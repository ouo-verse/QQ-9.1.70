package com.tencent.qqmini.minigame.helper;

import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.engine.IJsPluginEngine;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.plugins.engine.MiniGameJsPluginEngine;
import com.tencent.qqmini.sdk.widget.CapsuleButton;

/* compiled from: P */
/* loaded from: classes23.dex */
public class c implements com.tencent.qqmini.sdk.auth.a {

    /* renamed from: a, reason: collision with root package name */
    private boolean f346482a;

    /* renamed from: b, reason: collision with root package name */
    private RequestEvent f346483b;

    /* renamed from: c, reason: collision with root package name */
    private CapsuleButton.CapsuleBtnClickListener f346484c;

    /* renamed from: d, reason: collision with root package name */
    private IJsPluginEngine f346485d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f346486e = false;

    @Override // com.tencent.qqmini.sdk.auth.a
    public boolean a(CapsuleButton.CapsuleBtnClickListener capsuleBtnClickListener) {
        if (QMLog.isDebugEnabled()) {
            QMLog.i("RecentColorSignAuthCheckHelper", "[isNeedShowAuthDialog]");
        }
        this.f346484c = capsuleBtnClickListener;
        return this.f346482a;
    }

    @Override // com.tencent.qqmini.sdk.auth.a
    public boolean b(String str, RequestEvent requestEvent) {
        if (this.f346486e || !AuthorizeCenter.SCOPE_RECENT_COLORSIGN.equals(str)) {
            return true;
        }
        QMLog.i("RecentColorSignAuthCheckHelper", "[isAllowRequestAuth], color_sign is NOT allowed to be showed currently.");
        this.f346482a = true;
        this.f346483b = requestEvent;
        return false;
    }

    @Override // com.tencent.qqmini.sdk.auth.a
    public void c(IJsPluginEngine iJsPluginEngine) {
        this.f346485d = iJsPluginEngine;
    }

    @Override // com.tencent.qqmini.sdk.auth.a
    public void d() {
        if (QMLog.isDebugEnabled()) {
            QMLog.i("RecentColorSignAuthCheckHelper", "[onAuthDialogDismiss], mIsShowDialogLater:" + this.f346482a);
        }
        CapsuleButton.CapsuleBtnClickListener capsuleBtnClickListener = this.f346484c;
        if (capsuleBtnClickListener != null) {
            capsuleBtnClickListener.onCloseClick();
        }
    }

    @Override // com.tencent.qqmini.sdk.auth.a
    public boolean e() {
        RequestEvent requestEvent;
        IJsPluginEngine iJsPluginEngine = this.f346485d;
        if (!(iJsPluginEngine instanceof MiniGameJsPluginEngine) || (requestEvent = this.f346483b) == null) {
            return false;
        }
        this.f346486e = true;
        this.f346482a = false;
        ((MiniGameJsPluginEngine) iJsPluginEngine).checkAuthorization(requestEvent);
        return true;
    }
}
