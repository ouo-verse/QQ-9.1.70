package com.tencent.mobileqq.qqshop.report.gdt;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ecshop.temp.api.IEcshopOtherApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010\f\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqshop/report/gdt/b;", "", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "", AdMetricTag.Report.TYPE, "", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", QQPermissionConstants.Permission.AUIDO_GROUP, "g", "e", "d", "c", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f274718a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40699);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f274718a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b(GdtAd gdtAd, int reportType) {
        qq_ad_get.QQAdGetRsp.AdInfo adInfo = gdtAd.info;
        if (adInfo != null) {
            ((IEcshopOtherApi) QRoute.api(IEcshopOtherApi.class)).gdtC2SReport(adInfo, reportType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(MsgRecord record) {
        Intrinsics.checkNotNullParameter(record, "$record");
        com.tencent.mobileqq.qqshop.report.dev.b.f274713a.f(record);
    }

    public final void c(@NotNull MsgRecord record, @NotNull GdtAd gdtAd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) record, (Object) gdtAd);
            return;
        }
        Intrinsics.checkNotNullParameter(record, "record");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        b(gdtAd, 1);
        com.tencent.mobileqq.qqshop.report.dev.b.f274713a.c(record);
    }

    public final void d(@Nullable MsgRecord record, @NotNull GdtAd gdtAd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) record, (Object) gdtAd);
            return;
        }
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).doCgiReport(gdtAd.getUrlForImpression());
        b(gdtAd, 0);
        if (record != null) {
            com.tencent.mobileqq.qqshop.report.dev.b.f274713a.d(record);
        }
    }

    public final void e(@NotNull final MsgRecord record) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) record);
        } else {
            Intrinsics.checkNotNullParameter(record, "record");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqshop.report.gdt.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.f(MsgRecord.this);
                }
            }, 128, null, true);
        }
    }

    public final void g(@NotNull MsgRecord record) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) record);
        } else {
            Intrinsics.checkNotNullParameter(record, "record");
            com.tencent.mobileqq.qqshop.report.dev.b.f274713a.g(record);
        }
    }
}
