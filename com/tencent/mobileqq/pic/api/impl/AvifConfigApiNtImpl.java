package com.tencent.mobileqq.pic.api.impl;

import com.google.gson.Gson;
import com.tencent.mobileqq.pic.api.IAvifConfigApi;
import com.tencent.mobileqq.pic.api.NativeAvifConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/pic/api/impl/AvifConfigApiNtImpl;", "Lcom/tencent/mobileqq/pic/api/IAvifConfigApi;", "()V", "defaultHeightForNt", "", "defaultWidthForNt", "getAvifConfigForNative", "", "pic_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class AvifConfigApiNtImpl implements IAvifConfigApi {
    static IPatchRedirector $redirector_;
    private final long defaultHeightForNt;
    private final long defaultWidthForNt;

    public AvifConfigApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.defaultWidthForNt = 2500L;
            this.defaultHeightForNt = 2500L;
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IAvifConfigApi
    @NotNull
    public String getAvifConfigForNative() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        String json = new Gson().toJson(new NativeAvifConfig(false, this.defaultWidthForNt, this.defaultHeightForNt));
        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(NativeAvif\u2026rNt, defaultHeightForNt))");
        return json;
    }
}
