package com.tencent.ilinkservice;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class IlinkServiceLogImpl {
    private IlinkServiceLogCallback m_callback_ = null;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class SingletonLoader {
        private static IlinkServiceLogImpl singletonStatic = new IlinkServiceLogImpl();

        SingletonLoader() {
        }
    }

    public static IlinkServiceLogImpl getInstance() {
        return SingletonLoader.singletonStatic;
    }

    public void d(String str, String str2, Object... objArr) {
        IlinkServiceLogCallback ilinkServiceLogCallback = this.m_callback_;
        if (ilinkServiceLogCallback == null) {
            return;
        }
        ilinkServiceLogCallback.d(str, str2, objArr);
    }

    public void e(String str, String str2, Object... objArr) {
        IlinkServiceLogCallback ilinkServiceLogCallback = this.m_callback_;
        if (ilinkServiceLogCallback == null) {
            return;
        }
        ilinkServiceLogCallback.e(str, str2, objArr);
    }

    public void i(String str, String str2, Object... objArr) {
        IlinkServiceLogCallback ilinkServiceLogCallback = this.m_callback_;
        if (ilinkServiceLogCallback == null) {
            return;
        }
        ilinkServiceLogCallback.i(str, str2, objArr);
    }

    public void setCallback(IlinkServiceLogCallback ilinkServiceLogCallback) {
        this.m_callback_ = ilinkServiceLogCallback;
    }

    public void v(String str, String str2, Object... objArr) {
        IlinkServiceLogCallback ilinkServiceLogCallback = this.m_callback_;
        if (ilinkServiceLogCallback == null) {
            return;
        }
        ilinkServiceLogCallback.v(str, str2, objArr);
    }

    public void w(String str, String str2, Object... objArr) {
        IlinkServiceLogCallback ilinkServiceLogCallback = this.m_callback_;
        if (ilinkServiceLogCallback == null) {
            return;
        }
        ilinkServiceLogCallback.w(str, str2, objArr);
    }
}
