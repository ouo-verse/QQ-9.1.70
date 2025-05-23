package cooperation.qqcircle.proxy;

import com.tencent.qphone.base.util.QLog;

/* loaded from: classes28.dex */
public class QCircleInvokeProxy {
    public static final String TAG = "QCircleInvokeProxy";
    private boolean mHasStubBind = false;
    private QCircleInvokeStub mInvokeStub;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes28.dex */
    public static class QCircleProxyImpl {
        private static QCircleInvokeProxy INSTANCE = new QCircleInvokeProxy();

        QCircleProxyImpl() {
        }
    }

    QCircleInvokeProxy() {
    }

    public static void bindStub(QCircleInvokeStub qCircleInvokeStub) {
        QLog.d(TAG, 1, "invoke stub has bind!");
        getInstance().mInvokeStub = qCircleInvokeStub;
        getInstance().mHasStubBind = true;
    }

    public static boolean checkStubState(int i3, int i16) {
        boolean z16 = getInstance().mHasStubBind;
        if (!z16) {
            QLog.d(TAG, 1, "checkStubState fail,stub has not bind.action:" + i3 + ",method:" + i16);
            return getInstance().mHasStubBind;
        }
        return z16;
    }

    private static QCircleInvokeProxy getInstance() {
        return QCircleProxyImpl.INSTANCE;
    }

    public static void invoke(int i3, int i16, Object... objArr) {
        if (checkStubState(i3, i16)) {
            getInstance().mInvokeStub.invoke(QCircleInvokeParam.initInvokeKey(i3, i16), objArr);
        }
    }

    public static void invokeWithCallBack(int i3, int i16, Object obj, Object... objArr) {
        if (checkStubState(i3, i16)) {
            getInstance().mInvokeStub.invokeWithCallBack(QCircleInvokeParam.initInvokeKey(i3, i16), obj, objArr);
        }
    }

    public static Object invokeWithReturnValue(int i3, int i16, Object... objArr) {
        if (checkStubState(i3, i16)) {
            return getInstance().mInvokeStub.invokeWithReturnValue(QCircleInvokeParam.initInvokeKey(i3, i16), objArr);
        }
        return null;
    }
}
