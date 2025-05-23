package com.tencent.biz.qqcircle.entrance;

import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.proxy.QCircleInvokeModule;
import cooperation.qqcircle.proxy.QCircleInvokeParam;
import cooperation.qqcircle.proxy.QCircleInvokeStub;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b implements QCircleInvokeStub {

    /* renamed from: a, reason: collision with root package name */
    private static SparseArray<QCircleInvokeModule> f84409a;

    static {
        SparseArray<QCircleInvokeModule> sparseArray = new SparseArray<>();
        f84409a = sparseArray;
        sparseArray.append(1, new QCircleInvokeInitImpl());
        f84409a.append(2, new a());
    }

    private void a(int i3, int i16, Object[] objArr) {
        SparseArray<QCircleInvokeModule> sparseArray = f84409a;
        if (sparseArray != null) {
            QCircleInvokeModule qCircleInvokeModule = sparseArray.get(i3);
            if (qCircleInvokeModule != null) {
                QLog.d("QCircleInvokeStubImpl", 1, "handleInvoke action:" + i3 + " method:" + i16);
                qCircleInvokeModule.invoke(i3, i16, objArr);
                return;
            }
            return;
        }
        QLog.d("QCircleInvokeStubImpl", 1, "handleInvoke error, sInvokeModuleImpl is null");
    }

    private Object c(int i3, int i16, Object[] objArr) {
        return null;
    }

    @Override // cooperation.qqcircle.proxy.QCircleInvokeStub
    public void invoke(int i3, Object... objArr) {
        a(QCircleInvokeParam.getAction(i3), QCircleInvokeParam.getMethod(i3), objArr);
    }

    @Override // cooperation.qqcircle.proxy.QCircleInvokeStub
    public void invokeWithCallBack(int i3, Object obj, Object... objArr) {
        b(QCircleInvokeParam.getAction(i3), QCircleInvokeParam.getMethod(i3), obj, objArr);
    }

    @Override // cooperation.qqcircle.proxy.QCircleInvokeStub
    public Object invokeWithReturnValue(int i3, Object... objArr) {
        return c(QCircleInvokeParam.getAction(i3), QCircleInvokeParam.getMethod(i3), objArr);
    }

    private void b(int i3, int i16, Object obj, Object[] objArr) {
    }
}
