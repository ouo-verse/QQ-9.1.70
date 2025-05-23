package com.tencent.qqnt.biz.lightbusiness.lightinteraction.scheme.impl;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.scheme.ILIASchemeJumpApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/scheme/impl/LIASchemeJumpApiNtImpl;", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/scheme/ILIASchemeJumpApi;", "()V", "jump", "", "appInterface", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "context", "Landroid/content/Context;", "schemeUrl", "", "light_business_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class LIASchemeJumpApiNtImpl implements ILIASchemeJumpApi {
    static IPatchRedirector $redirector_;

    public LIASchemeJumpApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.biz.lightbusiness.lightinteraction.scheme.ILIASchemeJumpApi
    public boolean jump(@Nullable BaseQQAppInterface appInterface, @NotNull Context context, @NotNull String schemeUrl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, appInterface, context, schemeUrl)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(schemeUrl, "schemeUrl");
        return false;
    }
}
