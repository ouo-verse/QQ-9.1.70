package com.tencent.biz.qcircleshadow.libmanager;

import android.util.SparseArray;
import com.tencent.aelight.camera.api.IAEEditorGenerateResultListener;
import com.tencent.aelight.camera.api.IAEEditorManagerForQzone;
import com.tencent.aelight.camera.api.IAEEditorUICallbackListener;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleAEEditorGenerateResultListener;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleAEEditorUICallbackListener;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleWXShareListener;
import com.tencent.mobileqq.qcircle.api.IQQFrontBackListener;
import com.tencent.mobileqq.qcircle.api.a;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wxapi.api.IWXShareHelper;
import com.tencent.mobileqq.wxapi.listener.IWXShareHelperListener;
import f20.b;
import f20.c;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes4.dex */
public class QCircleListenerProxyManager {
    private static final String TAG = "QCircleListenerProxyManager";
    private static volatile QCircleListenerProxyManager sInstance;
    private SparseArray<IAEEditorGenerateResultListener> mMapAEEditorResultListener = new SparseArray<>();
    private SparseArray<IAEEditorUICallbackListener> mMapAEEditorUICallbackListener = new SparseArray<>();
    private SparseArray<IWXShareHelperListener> mMapWXShareListener = new SparseArray<>();
    private ConcurrentLinkedQueue<IQQFrontBackListener> mQQFrontBackListener = new ConcurrentLinkedQueue<>();
    private a mSceneChangeCallback;

    public static QCircleListenerProxyManager getInstance() {
        if (sInstance == null) {
            synchronized (QCircleListenerProxyManager.class) {
                if (sInstance == null) {
                    sInstance = new QCircleListenerProxyManager();
                }
            }
        }
        return sInstance;
    }

    public void addQCircleAEEditorGenerateResultListener(QCircleAEEditorGenerateResultListener qCircleAEEditorGenerateResultListener) {
        if (qCircleAEEditorGenerateResultListener == null) {
            return;
        }
        f20.a aVar = new f20.a(qCircleAEEditorGenerateResultListener);
        this.mMapAEEditorResultListener.append(qCircleAEEditorGenerateResultListener.hashCode(), aVar);
        ((IAEEditorManagerForQzone) QRoute.api(IAEEditorManagerForQzone.class)).addListener(aVar);
    }

    public void addQCircleAEEditorUICallbackListener(QCircleAEEditorUICallbackListener qCircleAEEditorUICallbackListener) {
        if (qCircleAEEditorUICallbackListener == null) {
            return;
        }
        b bVar = new b(qCircleAEEditorUICallbackListener);
        this.mMapAEEditorUICallbackListener.append(qCircleAEEditorUICallbackListener.hashCode(), bVar);
        ((IAEEditorManagerForQzone) QRoute.api(IAEEditorManagerForQzone.class)).addUICallbackListener(bVar);
    }

    public void addQCircleWXShareListener(QCircleWXShareListener qCircleWXShareListener) {
        if (qCircleWXShareListener == null) {
            return;
        }
        c cVar = new c(qCircleWXShareListener);
        this.mMapWXShareListener.append(qCircleWXShareListener.hashCode(), cVar);
        ((IWXShareHelper) QRoute.api(IWXShareHelper.class)).addObserver(cVar);
    }

    public void addQQFrontBackListener(IQQFrontBackListener iQQFrontBackListener) {
        if (iQQFrontBackListener == null) {
            return;
        }
        this.mQQFrontBackListener.add(iQQFrontBackListener);
    }

    public a getSceneChangeCallback() {
        return this.mSceneChangeCallback;
    }

    public void onQQEnterBackground() {
        Iterator<IQQFrontBackListener> it = this.mQQFrontBackListener.iterator();
        while (it.hasNext()) {
            it.next().onQQEnterBackground();
        }
    }

    public void onQQEnterForeground() {
        Iterator<IQQFrontBackListener> it = this.mQQFrontBackListener.iterator();
        while (it.hasNext()) {
            it.next().onQQEnterForeground();
        }
    }

    public void removeQCircleAEEditorGenerateResultListener(QCircleAEEditorGenerateResultListener qCircleAEEditorGenerateResultListener) {
        IAEEditorGenerateResultListener iAEEditorGenerateResultListener;
        if (qCircleAEEditorGenerateResultListener != null && (iAEEditorGenerateResultListener = this.mMapAEEditorResultListener.get(qCircleAEEditorGenerateResultListener.hashCode())) != null) {
            ((IAEEditorManagerForQzone) QRoute.api(IAEEditorManagerForQzone.class)).removeListener(iAEEditorGenerateResultListener);
        }
    }

    public void removeQCircleAEEditorUICallbackListener(QCircleAEEditorUICallbackListener qCircleAEEditorUICallbackListener) {
        IAEEditorUICallbackListener iAEEditorUICallbackListener;
        if (qCircleAEEditorUICallbackListener != null && (iAEEditorUICallbackListener = this.mMapAEEditorUICallbackListener.get(qCircleAEEditorUICallbackListener.hashCode())) != null) {
            ((IAEEditorManagerForQzone) QRoute.api(IAEEditorManagerForQzone.class)).removeUICallbackListener(iAEEditorUICallbackListener);
        }
    }

    public void removeQCircleWXShareListener(QCircleWXShareListener qCircleWXShareListener) {
        IWXShareHelperListener iWXShareHelperListener;
        if (qCircleWXShareListener != null && (iWXShareHelperListener = this.mMapWXShareListener.get(qCircleWXShareListener.hashCode())) != null) {
            ((IWXShareHelper) QRoute.api(IWXShareHelper.class)).removeObserver(iWXShareHelperListener);
        }
    }

    public void removeQQFrontBackListener(IQQFrontBackListener iQQFrontBackListener) {
        if (iQQFrontBackListener == null) {
            return;
        }
        this.mQQFrontBackListener.remove(iQQFrontBackListener);
    }

    public void setSceneChangeCallback(a aVar) {
        this.mSceneChangeCallback = aVar;
    }
}
