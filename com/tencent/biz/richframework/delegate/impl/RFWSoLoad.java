package com.tencent.biz.richframework.delegate.impl;

import android.util.ArrayMap;
import com.tencent.biz.richframework.delegate.ISoLoadDelegate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWSoLoad {
    public static final int LOAD_STATUS_LOADING = 1;
    public static final int LOAD_STATUS_LOAD_DONE = 2;
    public static final int LOAD_STATUS_UN_INIT = 0;
    private static final String TAG = "RFWSoLoad";
    private static volatile ISoLoadDelegate sISoLoadDelegate;
    private static final Map<String, Set<ISoLoadDelegate.OnLoadListener>> sSoLoadListenerMap = new ArrayMap();
    private static final ConcurrentHashMap<String, Integer> sSoLoadState = new ConcurrentHashMap<>();

    private static void addListener(String str, ISoLoadDelegate.OnLoadListener onLoadListener) {
        if (onLoadListener == null) {
            return;
        }
        Map<String, Set<ISoLoadDelegate.OnLoadListener>> map = sSoLoadListenerMap;
        Set<ISoLoadDelegate.OnLoadListener> set = map.get(str);
        if (set == null) {
            set = new HashSet<>();
            map.put(str, set);
        }
        set.add(onLoadListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void dispatchLoadState(String str, boolean z16) {
        synchronized (RFWSoLoad.class) {
            int i3 = 0;
            RFWLog.d(TAG, RFWLog.USR, "load so:", str, ",result:", Boolean.valueOf(z16));
            if (z16) {
                i3 = 2;
            }
            sSoLoadState.put(str, Integer.valueOf(i3));
            Set<ISoLoadDelegate.OnLoadListener> set = sSoLoadListenerMap.get(str);
            if (set != null) {
                Iterator<ISoLoadDelegate.OnLoadListener> it = set.iterator();
                while (it.hasNext()) {
                    it.next().onLoadResult(z16);
                }
            }
            sSoLoadListenerMap.remove(str);
        }
    }

    private static ISoLoadDelegate getSoLoadDelegate() {
        if (sISoLoadDelegate == null) {
            synchronized (RFWSoLoad.class) {
                if (sISoLoadDelegate == null) {
                    sISoLoadDelegate = (ISoLoadDelegate) RFWDelegate.getDelegate(ISoLoadDelegate.class);
                }
            }
        }
        return sISoLoadDelegate;
    }

    private static boolean isSoLoading(String str) {
        Integer num = sSoLoadState.get(str);
        if (num != null && num.intValue() == 1) {
            return true;
        }
        return false;
    }

    private static boolean isSoReady(String str) {
        Integer num = sSoLoadState.get(str);
        if (num != null && num.intValue() == 2) {
            return true;
        }
        return false;
    }

    public static void load(String str, ISoLoadDelegate.OnLoadListener onLoadListener) {
        load(str, false, onLoadListener);
    }

    public static synchronized void load(final String str, boolean z16, ISoLoadDelegate.OnLoadListener onLoadListener) {
        synchronized (RFWSoLoad.class) {
            if (isSoReady(str)) {
                if (onLoadListener != null) {
                    onLoadListener.onLoadResult(true);
                }
                return;
            }
            addListener(str, onLoadListener);
            if (isSoLoading(str)) {
                RFWLog.d(TAG, RFWLog.USR, "load return, because isLoading, so:", str);
                return;
            }
            sSoLoadState.put(str, 1);
            try {
            } catch (Throwable th5) {
                RFWLog.fatal(TAG, RFWLog.USR, th5);
                dispatchLoadState(str, false);
            }
            if (z16) {
                System.loadLibrary(str);
                dispatchLoadState(str, true);
                return;
            }
            ISoLoadDelegate soLoadDelegate = getSoLoadDelegate();
            if (soLoadDelegate == null) {
                RFWLog.fatal(TAG, RFWLog.USR, new RuntimeException("load fail, getSoLoadDelegate = null, check you has register the delegate"));
                dispatchLoadState(str, false);
            } else {
                soLoadDelegate.load(str, new ISoLoadDelegate.OnLoadListener() { // from class: com.tencent.biz.richframework.delegate.impl.RFWSoLoad.1
                    @Override // com.tencent.biz.richframework.delegate.ISoLoadDelegate.OnLoadListener
                    public void onLoadResult(boolean z17) {
                        RFWSoLoad.dispatchLoadState(str, z17);
                    }
                });
            }
        }
    }
}
