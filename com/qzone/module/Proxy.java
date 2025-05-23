package com.qzone.module;

import android.text.TextUtils;
import cooperation.qzone.util.QZLog;

/* loaded from: classes39.dex */
public abstract class Proxy<T, C> implements IProxy<T, C> {
    private static final String TAG = "Proxy";
    private Module<T, C> proxy;

    public abstract String getModuleClassName();

    protected Module<T, C> getProxy() {
        if (this.proxy == null) {
            String moduleClassName = getModuleClassName();
            if (!TextUtils.isEmpty(moduleClassName)) {
                try {
                    this.proxy = (Module) LoadModule(moduleClassName);
                } catch (Throwable th5) {
                    QZLog.e(TAG, "module\u6a21\u5757\u52a0\u8f7d\u5931\u8d25", th5);
                }
            }
        }
        return this.proxy;
    }

    @Override // com.qzone.module.IProxy
    public C getServiceInterface() {
        return getProxy().getServiceInterface();
    }

    @Override // com.qzone.module.IProxy
    public T getUiInterface() {
        return getProxy().getUiInterface();
    }

    public Object LoadModule(String str) {
        try {
            Class<?> cls = Class.forName(str, false, getClass().getClassLoader());
            if (cls != null) {
                return cls.newInstance();
            }
            return null;
        } catch (Throwable th5) {
            QZLog.e(TAG, "load" + str + "failed,use default!,e:", th5);
            return null;
        }
    }
}
