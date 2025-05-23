package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* loaded from: classes23.dex */
public class TXLivePushListenerReflect {
    private static final String TAG = "TXLivePushListenerRefle";

    /* loaded from: classes23.dex */
    public interface ITXLivePushListener {
        void onNetStatus(Bundle bundle);

        void onPushEvent(int i3, Bundle bundle);
    }

    /* loaded from: classes23.dex */
    public interface ITXSnapshotListener {
        void onSnapshot(Bitmap bitmap);
    }

    /* loaded from: classes23.dex */
    public static class ITXSnapshotListenerInvocationHandler implements InvocationHandler {
        private ITXSnapshotListener listener;

        public ITXSnapshotListenerInvocationHandler(ITXSnapshotListener iTXSnapshotListener) {
            this.listener = iTXSnapshotListener;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            ITXSnapshotListener iTXSnapshotListener;
            QMLog.e(TXLivePushListenerReflect.TAG, "ITXSnapshotListenerInvocationHandler invoke:" + method.getName());
            if (Object.class.equals(method.getDeclaringClass())) {
                try {
                    return method.invoke(this, objArr);
                } catch (Throwable th5) {
                    QMLog.e(TXLivePushListenerReflect.TAG, "invoke", th5);
                }
            }
            if ("onSnapshot".equals(method.getName()) && objArr != null && objArr.length == 1) {
                Object obj2 = objArr[0];
                if ((obj2 instanceof Bitmap) && (iTXSnapshotListener = this.listener) != null) {
                    iTXSnapshotListener.onSnapshot((Bitmap) obj2);
                    return null;
                }
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes23.dex */
    public interface OnBGMNotify {
        void onBGMComplete(int i3);

        void onBGMProgress(long j3, long j16);

        void onBGMStart();
    }

    /* loaded from: classes23.dex */
    public static class OnBGMNotifyInvocationHandler implements InvocationHandler {
        private OnBGMNotify listener;

        public OnBGMNotifyInvocationHandler(OnBGMNotify onBGMNotify) {
            this.listener = onBGMNotify;
        }

        private void onBGMComplete(Object[] objArr) {
            OnBGMNotify onBGMNotify;
            if (objArr != null && objArr.length == 1) {
                Object obj = objArr[0];
                if ((obj instanceof Integer) && (onBGMNotify = this.listener) != null) {
                    onBGMNotify.onBGMComplete(((Integer) obj).intValue());
                }
            }
        }

        private void onBGMProgress(Object[] objArr) {
            OnBGMNotify onBGMNotify;
            if (objArr != null && objArr.length == 2) {
                Object obj = objArr[0];
                if ((obj instanceof Long) && (objArr[1] instanceof Long) && (onBGMNotify = this.listener) != null) {
                    onBGMNotify.onBGMProgress(((Long) obj).longValue(), ((Long) objArr[1]).longValue());
                }
            }
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            QMLog.e(TXLivePushListenerReflect.TAG, "OnBGMNotifyInvocationHandler invoke:" + method.getName());
            if (Object.class.equals(method.getDeclaringClass())) {
                try {
                    return method.invoke(this, objArr);
                } catch (Throwable th5) {
                    QMLog.e(TXLivePushListenerReflect.TAG, "invoke", th5);
                }
            }
            if ("onBGMStart".equals(method.getName())) {
                OnBGMNotify onBGMNotify = this.listener;
                if (onBGMNotify != null) {
                    onBGMNotify.onBGMStart();
                }
            } else if ("onBGMProgress".equals(method.getName())) {
                onBGMProgress(objArr);
            }
            if ("onBGMComplete".equals(method.getName())) {
                onBGMComplete(objArr);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes23.dex */
    public static class TXLivePushListenerInvocationHandler implements InvocationHandler {
        private ITXLivePushListener listener;

        public TXLivePushListenerInvocationHandler(ITXLivePushListener iTXLivePushListener) {
            this.listener = iTXLivePushListener;
        }

        private void livePushOnPushEvent(Object[] objArr) {
            if (objArr != null && objArr.length == 2) {
                if ((objArr[0] instanceof Integer) && (objArr[1] instanceof Bundle)) {
                    if (QMLog.isColorLevel()) {
                        QMLog.e(TXLivePushListenerReflect.TAG, "onPushEvent code:" + objArr[0]);
                    }
                    ITXLivePushListener iTXLivePushListener = this.listener;
                    if (iTXLivePushListener != null) {
                        iTXLivePushListener.onPushEvent(((Integer) objArr[0]).intValue(), (Bundle) objArr[1]);
                    }
                }
                Object obj = objArr[1];
                if (obj instanceof Bundle) {
                    Bundle bundle = (Bundle) obj;
                    if (QMLog.isColorLevel()) {
                        QMLog.e(TXLivePushListenerReflect.TAG, "onPushEvent params:" + bundle.toString());
                    }
                }
            }
        }

        private void liverPushOnNetStatus(Object[] objArr) {
            if (objArr != null && objArr.length == 1) {
                Object obj = objArr[0];
                if (obj instanceof Bundle) {
                    Bundle bundle = (Bundle) obj;
                    if (QMLog.isColorLevel()) {
                        QMLog.e(TXLivePushListenerReflect.TAG, "onNetStatus params:" + bundle.toString());
                    }
                    ITXLivePushListener iTXLivePushListener = this.listener;
                    if (iTXLivePushListener != null) {
                        iTXLivePushListener.onNetStatus(bundle);
                    }
                }
            }
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            QMLog.e(TXLivePushListenerReflect.TAG, "TXLivePushListenerInvocationHandler invoke:" + method.getName());
            if (Object.class.equals(method.getDeclaringClass())) {
                try {
                    return method.invoke(this, objArr);
                } catch (Throwable th5) {
                    QMLog.e(TXLivePushListenerReflect.TAG, "invoke", th5);
                }
            }
            if ("onNetStatus".equals(method.getName())) {
                liverPushOnNetStatus(objArr);
                return null;
            }
            if ("onPushEvent".equals(method.getName())) {
                livePushOnPushEvent(objArr);
                return null;
            }
            return null;
        }
    }
}
