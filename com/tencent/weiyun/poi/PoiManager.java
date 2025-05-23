package com.tencent.weiyun.poi;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.weiyun.WeiyunLiteGlobal;
import com.tencent.weiyun.callback.FetchPOICallback;
import com.tencent.weiyun.data.PoiItem;
import com.tencent.weiyun.utils.Singleton;
import com.tencent.weiyun.utils.WyLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes27.dex */
public final class PoiManager implements Handler.Callback {
    static IPatchRedirector $redirector_ = null;
    private static final int MSG_FETCH = 2;
    private static final int MSG_INIT = 1;
    private static final int NETWORK_REQ_LIMIT = 50;
    private static final String TAG = "PoiManager";
    private static Singleton<PoiManager, Void> sInstance;
    private final Comparator<PoiItem> mComparator;
    private final Handler mHandler;
    private final HashSet<String> mPoiKeys;

    /* loaded from: classes27.dex */
    public interface IFetchPoiListener {
        void onError(int i3, String str, boolean z16);

        void onSuccess(List<PoiItem> list, boolean z16);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11318);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            sInstance = new Singleton<PoiManager, Void>() { // from class: com.tencent.weiyun.poi.PoiManager.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.tencent.weiyun.utils.Singleton
                public PoiManager create(Void r46) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new PoiManager(null) : (PoiManager) iPatchRedirector.redirect((short) 2, (Object) this, (Object) r46);
                }
            };
        }
    }

    /* synthetic */ PoiManager(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this, (Object) anonymousClass1);
    }

    public static PoiManager getInstance() {
        return sInstance.get(null);
    }

    private void performFetchPoi(List<PoiItem> list, IFetchPoiListener iFetchPoiListener) {
        List<PoiItem> queryPoi;
        if (list != null && !list.isEmpty()) {
            Iterator<PoiItem> it = list.iterator();
            while (it.hasNext()) {
                PoiItem next = it.next();
                if (next == null || (next.longitude == 0.0d && next.latitude == 0.0d)) {
                    it.remove();
                }
            }
            if (list.isEmpty()) {
                if (iFetchPoiListener != null) {
                    iFetchPoiListener.onSuccess(new ArrayList(0), true);
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList(list);
            Collections.sort(arrayList, this.mComparator);
            if (iFetchPoiListener != null && (queryPoi = PoiHelper.queryPoi(arrayList)) != null && !queryPoi.isEmpty()) {
                iFetchPoiListener.onSuccess(queryPoi, arrayList.isEmpty());
            }
            boolean isEmpty = arrayList.isEmpty();
            while (!isEmpty) {
                int i3 = 50;
                if (arrayList.size() < 50) {
                    i3 = arrayList.size();
                }
                PoiItem[] poiItemArr = new PoiItem[i3];
                Iterator it5 = arrayList.iterator();
                for (int i16 = 0; i16 < i3 && it5.hasNext(); i16++) {
                    poiItemArr[i16] = (PoiItem) it5.next();
                    it5.remove();
                }
                boolean isEmpty2 = arrayList.isEmpty();
                WeiyunLiteGlobal.getInstance().getCommandManager().fetchPOI(Arrays.asList(poiItemArr), new FetchPOICallback(poiItemArr, iFetchPoiListener, isEmpty2) { // from class: com.tencent.weiyun.poi.PoiManager.3
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ IFetchPoiListener val$listener;
                    final /* synthetic */ boolean val$reqCompleted;
                    final /* synthetic */ PoiItem[] val$singleReq;

                    {
                        this.val$singleReq = poiItemArr;
                        this.val$listener = iFetchPoiListener;
                        this.val$reqCompleted = isEmpty2;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, PoiManager.this, poiItemArr, iFetchPoiListener, Boolean.valueOf(isEmpty2));
                        }
                    }

                    @Override // com.tencent.weiyun.callback.FetchPOICallback
                    public void onError(int i17, String str) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                            iPatchRedirector.redirect((short) 3, (Object) this, i17, (Object) str);
                            return;
                        }
                        IFetchPoiListener iFetchPoiListener2 = this.val$listener;
                        if (iFetchPoiListener2 != null) {
                            iFetchPoiListener2.onError(i17, str, this.val$reqCompleted);
                        }
                    }

                    @Override // com.tencent.weiyun.callback.FetchPOICallback
                    public void onSuccess(List<PoiItem> list2) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list2);
                            return;
                        }
                        int i17 = 0;
                        if (list2 == null) {
                            list2 = new ArrayList<>(0);
                        }
                        if (!list2.isEmpty()) {
                            int length = this.val$singleReq.length;
                            Iterator<PoiItem> it6 = list2.iterator();
                            while (it6.hasNext()) {
                                PoiItem next2 = it6.next();
                                if (i17 < length) {
                                    int i18 = i17 + 1;
                                    PoiItem poiItem = this.val$singleReq[i17];
                                    next2.longitude = poiItem.longitude;
                                    next2.latitude = poiItem.latitude;
                                    i17 = i18;
                                } else {
                                    it6.remove();
                                    WyLog.w(PoiManager.TAG, "fetchPOI: server respond error.");
                                }
                            }
                        }
                        ArrayList arrayList2 = new ArrayList(list2);
                        IFetchPoiListener iFetchPoiListener2 = this.val$listener;
                        if (iFetchPoiListener2 != null) {
                            iFetchPoiListener2.onSuccess(list2, this.val$reqCompleted);
                        }
                        Collections.sort(arrayList2, PoiManager.this.mComparator);
                        PoiHelper.insertPoi(arrayList2);
                    }
                });
                isEmpty = isEmpty2;
            }
        }
    }

    public void cancelAll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.mHandler.removeMessages(2);
        }
    }

    public void fetchPoi(List<PoiItem> list, IFetchPoiListener iFetchPoiListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) list, (Object) iFetchPoiListener);
        } else if (list != null && !list.isEmpty()) {
            Message.obtain(this.mHandler, 2, new Object[]{list, iFetchPoiListener}).sendToTarget();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 == 1) {
            HashSet<String> queryPoiKeys = PoiHelper.queryPoiKeys();
            synchronized (this.mPoiKeys) {
                this.mPoiKeys.addAll(queryPoiKeys);
            }
        } else if (i3 == 2) {
            Object obj = message.obj;
            performFetchPoi((List) ((Object[]) obj)[0], (IFetchPoiListener) ((Object[]) obj)[1]);
        }
        return true;
    }

    public boolean hasCache(double d16, double d17) {
        boolean contains;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, Double.valueOf(d16), Double.valueOf(d17))).booleanValue();
        }
        if (d16 == 0.0d && d17 == 0.0d) {
            return false;
        }
        String generateKey = PoiHelper.generateKey(d16, d17);
        synchronized (this.mPoiKeys) {
            contains = this.mPoiKeys.contains(generateKey);
        }
        return contains;
    }

    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            Message.obtain(this.mHandler, 1).sendToTarget();
        }
    }

    PoiManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("poi-fetcher");
        baseHandlerThread.start();
        this.mHandler = new Handler(baseHandlerThread.getLooper(), this);
        this.mPoiKeys = new HashSet<>();
        this.mComparator = new Comparator<PoiItem>() { // from class: com.tencent.weiyun.poi.PoiManager.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PoiManager.this);
                }
            }

            @Override // java.util.Comparator
            public int compare(PoiItem poiItem, PoiItem poiItem2) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) poiItem, (Object) poiItem2)).intValue();
                }
                double d16 = poiItem.longitude;
                double d17 = poiItem2.longitude;
                if (d16 < d17) {
                    return -1;
                }
                if (d16 > d17) {
                    return 1;
                }
                double d18 = poiItem.latitude;
                double d19 = poiItem2.latitude;
                if (d18 < d19) {
                    return -1;
                }
                return d18 > d19 ? 1 : 0;
            }
        };
    }
}
