package com.tencent.mobileqq.qqlive.sail.ui.more.bottom;

import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import uq4.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/more/bottom/a;", "", "", "Luq4/e;", "b", "()[Luq4/e;", "a", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f272911a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52615);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f272911a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final e[] a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (e[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        e eVar = new e();
        eVar.f439836a = "20002";
        eVar.f439838c = "";
        eVar.f439837b = "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/qqlive/8975/icon_interact_qqlive_make_up_mode.png";
        eVar.f439843h = false;
        e eVar2 = new e();
        eVar2.f439836a = "20003";
        eVar2.f439838c = "";
        eVar2.f439837b = "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/qqlive/8975/icon_interact_qqlive_share.png";
        eVar2.f439843h = true;
        e eVar3 = new e();
        eVar3.f439836a = "20004";
        eVar3.f439838c = "";
        eVar3.f439837b = "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/qqlive/8975/icon_interact_qqlive_more.png";
        eVar3.f439843h = true;
        return new e[]{eVar, eVar2, eVar3};
    }

    @NotNull
    public final e[] b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (e[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        e eVar = new e();
        eVar.f439836a = HippyQQConstants.HIPPY_CHANNEL;
        eVar.f439838c = "";
        eVar.f439837b = "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/qqlive/8975/icon_interact_qqlive_more.png";
        eVar.f439843h = true;
        e eVar2 = new e();
        eVar2.f439836a = "10005";
        eVar2.f439838c = "";
        eVar2.f439837b = "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/qqlive/8975/icon_interact_qqlive_gift.png";
        eVar2.f439843h = false;
        return new e[]{eVar, eVar2};
    }
}
