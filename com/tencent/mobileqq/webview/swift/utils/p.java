package com.tencent.mobileqq.webview.swift.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.webview.SandBoxControl;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.smtt.sdk.QbSdk;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0017\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/webview/swift/utils/p;", "", "Lkotlin/Function0;", "", "realInitBlock", "a", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class p {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final p f314786a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46149);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f314786a = new p();
        }
    }

    p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static void a(@NotNull Function0<Unit> realInitBlock) {
        Intrinsics.checkNotNullParameter(realInitBlock, "realInitBlock");
        QbSdk.setTbsInstallerCallback((QbSdk.TbsInstallerCallBack) aa.k(QbSdk.TbsInstallerCallBack.class));
        SandBoxControl.a();
        realInitBlock.invoke();
        ((com.tencent.mobileqq.webview.swift.injector.w) aa.k(com.tencent.mobileqq.webview.swift.injector.w.class)).onInitFinish();
    }
}
