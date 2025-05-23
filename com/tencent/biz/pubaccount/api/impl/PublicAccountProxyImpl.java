package com.tencent.biz.pubaccount.api.impl;

import android.app.Activity;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;

/* loaded from: classes32.dex */
public class PublicAccountProxyImpl implements IPublicAccountProxy {
    @Override // com.tencent.biz.pubaccount.api.IPublicAccountProxy
    public Class getImplClass(Class cls) {
        try {
            return Class.forName(getImplName(cls));
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountProxy
    public String getImplName(Class cls) {
        try {
            return cls.getPackage().getName() + ".impl." + cls.getSimpleName().substring(1) + "Impl";
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountProxy
    public boolean isPublicAccountBrowser(Activity activity) {
        return activity instanceof PublicAccountBrowserImpl;
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountProxy
    public void setDataManagerAfterMsgSync() {
        PublicAccountDataManagerImpl.setAfterMsgSync();
    }
}
