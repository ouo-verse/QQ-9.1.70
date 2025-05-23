package com.tencent.mobileqq.pymk.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.pymk.api.IPYMKSwitchAGuideApi;
import com.tencent.mobileqq.pymk.f;
import com.tencent.mobileqq.pymk.i;
import com.tencent.mobileqq.pymk.k;
import com.tencent.mobileqq.pymk.request.PYMKHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/pymk/api/impl/PYMKSwitchAGuideApiImpl;", "Lcom/tencent/mobileqq/pymk/api/IPYMKSwitchAGuideApi;", "", "recordGuideClose", "", "isAbleToShowPYMKGuide", "Lcom/tencent/mobileqq/pymk/i;", "listener", "", "from", "addPYMKSwitchChangeListener", "removePYMKSwitchChangeListener", "removePYMKData", "reqOpenPYMKSetting", "reqGetPYMKSetting", "getPYMKSetting", "hasPYMKSwitchSaved", "getIsFirstTimeUpTo9025", "simplifyTop2", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class PYMKSwitchAGuideApiImpl implements IPYMKSwitchAGuideApi {
    @Override // com.tencent.mobileqq.pymk.api.IPYMKSwitchAGuideApi
    public void addPYMKSwitchChangeListener(i listener, String from) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(from, "from");
        k.f261468a.a(listener, from);
    }

    @Override // com.tencent.mobileqq.pymk.api.IPYMKSwitchAGuideApi
    public boolean getIsFirstTimeUpTo9025() {
        return f.f261465a.c();
    }

    @Override // com.tencent.mobileqq.pymk.api.IPYMKSwitchAGuideApi
    public boolean getPYMKSetting() {
        return k.f261468a.c();
    }

    @Override // com.tencent.mobileqq.pymk.api.IPYMKSwitchAGuideApi
    public boolean hasPYMKSwitchSaved() {
        return f.f261465a.i();
    }

    @Override // com.tencent.mobileqq.pymk.api.IPYMKSwitchAGuideApi
    public boolean isAbleToShowPYMKGuide() {
        return k.f261468a.e();
    }

    @Override // com.tencent.mobileqq.pymk.api.IPYMKSwitchAGuideApi
    public void recordGuideClose() {
        k.f261468a.g();
    }

    @Override // com.tencent.mobileqq.pymk.api.IPYMKSwitchAGuideApi
    public void removePYMKData() {
        f.f261465a.k(0);
    }

    @Override // com.tencent.mobileqq.pymk.api.IPYMKSwitchAGuideApi
    public void removePYMKSwitchChangeListener(i listener, String from) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(from, "from");
        k.f261468a.h(listener, from);
    }

    @Override // com.tencent.mobileqq.pymk.api.IPYMKSwitchAGuideApi
    public void reqGetPYMKSetting() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        BusinessHandler businessHandler = appInterface.getBusinessHandler(PYMKHandler.class.getName());
        PYMKHandler pYMKHandler = businessHandler instanceof PYMKHandler ? (PYMKHandler) businessHandler : null;
        if (pYMKHandler != null) {
            pYMKHandler.reqGetPYMKSetting();
        }
    }

    @Override // com.tencent.mobileqq.pymk.api.IPYMKSwitchAGuideApi
    public void reqOpenPYMKSetting() {
        k.f261468a.i();
    }

    @Override // com.tencent.mobileqq.pymk.api.IPYMKSwitchAGuideApi
    public boolean simplifyTop2() {
        return k.f261468a.m();
    }
}
