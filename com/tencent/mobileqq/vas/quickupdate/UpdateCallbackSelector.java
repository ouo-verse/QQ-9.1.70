package com.tencent.mobileqq.vas.quickupdate;

import android.content.Context;
import androidx.annotation.Keep;
import com.tencent.comic.quickupdate.QQComicUpdateBusiness;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.JarReflectUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
@Keep
/* loaded from: classes20.dex */
public class UpdateCallbackSelector {
    private static final String TAG = "UpdateCallbackSelector";
    private static BaseUpdateCallback defaultCallback;

    @ConfigInject(configPath = "Business/vas-temp-api/src/main/resources/Inject_VasQuickUpdateBusiness.yml", version = 4)
    public static ArrayList<Class<? extends BaseUpdateCallback>> mInjectBusinessCallback;
    private static HashMap<Long, BaseUpdateCallback> sBusinessRegister;

    static {
        ArrayList<Class<? extends BaseUpdateCallback>> arrayList = new ArrayList<>();
        mInjectBusinessCallback = arrayList;
        arrayList.add(ThemeUpdateCallback.class);
        mInjectBusinessCallback.add(QQComicUpdateBusiness.class);
        sBusinessRegister = new HashMap<>();
        initBaseUpdateCallback();
        defaultCallback = new EmptyCallback();
    }

    public static void cleanCache(Context context) {
        Iterator<BaseUpdateCallback> it = sBusinessRegister.values().iterator();
        while (it.hasNext()) {
            it.next().cleanCache(context);
        }
    }

    public static void clearCallback() {
        sBusinessRegister.clear();
    }

    public static BaseUpdateCallback getCallback(long j3) {
        BaseUpdateCallback baseUpdateCallback = sBusinessRegister.get(Long.valueOf(j3));
        if (baseUpdateCallback == null) {
            return defaultCallback;
        }
        return baseUpdateCallback;
    }

    private static BaseUpdateCallback[] getInjectArray() {
        QLog.i(TAG, 1, "getInjectArray size = " + mInjectBusinessCallback.size());
        if (mInjectBusinessCallback.isEmpty()) {
            return new BaseUpdateCallback[]{ThemeUpdateCallback.sInstance};
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Class<? extends BaseUpdateCallback>> it = mInjectBusinessCallback.iterator();
        while (it.hasNext()) {
            Class<? extends BaseUpdateCallback> next = it.next();
            if (next != null) {
                Object staticField = JarReflectUtil.getStaticField(next.getName(), "sInstance");
                if (staticField != null) {
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "inject class name = " + next.getName());
                    }
                    arrayList.add((BaseUpdateCallback) staticField);
                } else {
                    QLog.e(TAG, 1, "current inject clsss get static field fail \uff0c object = null");
                }
            }
        }
        return (BaseUpdateCallback[]) arrayList.toArray(new BaseUpdateCallback[arrayList.size()]);
    }

    private static void initBaseUpdateCallback() {
        BaseUpdateCallback[] injectArray = getInjectArray();
        QLog.i(TAG, 1, "getInjectArray size = " + injectArray.length);
        for (BaseUpdateCallback baseUpdateCallback : injectArray) {
            if (baseUpdateCallback != null) {
                if (sBusinessRegister.containsKey(Long.valueOf(baseUpdateCallback.getBID()))) {
                    sBusinessRegister.get(Long.valueOf(baseUpdateCallback.getBID()));
                }
                sBusinessRegister.put(Long.valueOf(baseUpdateCallback.getBID()), baseUpdateCallback);
            }
        }
    }

    public static synchronized void setDefaultCallback(BaseUpdateCallback baseUpdateCallback) {
        synchronized (UpdateCallbackSelector.class) {
            defaultCallback = baseUpdateCallback;
        }
    }

    public static synchronized void unsetDefaultCallback(BaseUpdateCallback baseUpdateCallback) {
        synchronized (UpdateCallbackSelector.class) {
            if (defaultCallback == baseUpdateCallback) {
                defaultCallback = new EmptyCallback();
            }
        }
    }
}
