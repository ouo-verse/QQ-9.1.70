package com.tencent.mobileqq.ad.debug;

import android.app.Activity;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import com.tencent.mobileqq.vas.adv.reward.api.IVasRewardAdApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uz2.VasRewardAdReportParams;
import uz2.VasRewardAdReqParams;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J(\u0010\f\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/ad/debug/w;", "", "", "e", "Landroid/widget/TextView;", "textView", "g", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "reqTV", "showTV", "reportTV", tl.h.F, "f", "", "b", "J", "mAdSequence", "", "c", "Z", "mIsFinished", "", "d", "I", "mElapsedTime", "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class w {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final w f186844a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long mAdSequence;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean mIsFinished;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int mElapsedTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/ad/debug/w$a", "Ltz2/b;", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "code", "", "retCode", "", "errMsg", "", "busiBuffer", "", "a", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class a implements tz2.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f186848a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f186849b;

        a(TextView textView, long j3) {
            this.f186848a = textView;
            this.f186849b = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, textView, Long.valueOf(j3));
            }
        }

        @Override // tz2.b
        public void a(@NotNull VasAdvServiceCode code, int retCode, @NotNull String errMsg, @Nullable byte[] busiBuffer) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, code, Integer.valueOf(retCode), errMsg, busiBuffer);
                return;
            }
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            if (code == VasAdvServiceCode.SUCCEED) {
                this.f186848a.setText("\u4e0a\u62a5\u6210\u529f:" + this.f186849b);
                return;
            }
            this.f186848a.setText("\u4e0a\u62a5\u5931\u8d25:" + code + "," + errMsg);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/ad/debug/w$b", "Ltz2/c;", "", "adSequence", "", "a", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "code", "", "errMsg", "b", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements tz2.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f186850a;

        b(TextView textView) {
            this.f186850a = textView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) textView);
            }
        }

        @Override // tz2.c
        public void a(long adSequence) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                w.mAdSequence = adSequence;
                this.f186850a.setText("\u8bf7\u6c42\u6210\u529f:" + w.mAdSequence);
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, adSequence);
        }

        @Override // tz2.c
        public void b(@NotNull VasAdvServiceCode code, @NotNull String errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) code, (Object) errMsg);
                return;
            }
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.f186850a.setText("\u8bf7\u6c42\u5931\u8d25:" + code + "," + errMsg);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/ad/debug/w$c", "Ltz2/d;", "", "code", "", "profitable", "elapsedTime", "totalTime", "", "a", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c implements tz2.d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f186851a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextView f186852b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ TextView f186853c;

        c(TextView textView, TextView textView2, TextView textView3) {
            this.f186851a = textView;
            this.f186852b = textView2;
            this.f186853c = textView3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, textView, textView2, textView3);
            }
        }

        @Override // tz2.d
        public void a(int code, boolean profitable, int elapsedTime, int totalTime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                w.mIsFinished = profitable;
                w.mElapsedTime = elapsedTime;
                if (profitable) {
                    this.f186851a.setText("\u83b7\u5f97\u5956\u52b1");
                    w.f186844a.f(this.f186852b);
                    return;
                } else {
                    this.f186851a.setText("\u672a\u83b7\u5f97\u5956\u52b1");
                    w.f186844a.g(this.f186853c);
                    return;
                }
            }
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(code), Boolean.valueOf(profitable), Integer.valueOf(elapsedTime), Integer.valueOf(totalTime));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27916);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f186844a = new w();
        }
    }

    w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            ((IVasRewardAdApi) QRoute.api(IVasRewardAdApi.class)).ensureDeviceInfoValid();
        }
    }

    public final void f(@NotNull TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) textView);
            return;
        }
        Intrinsics.checkNotNullParameter(textView, "textView");
        VasRewardAdReportParams.C11382a c11382a = new VasRewardAdReportParams.C11382a();
        c11382a.d(mAdSequence);
        c11382a.e(mIsFinished);
        c11382a.h(com.tencent.mobileqq.ad.debug.a.f186830a.l());
        c11382a.f("{\"reward_type\": 0}");
        c11382a.b(mElapsedTime);
        ((IVasRewardAdApi) QRoute.api(IVasRewardAdApi.class)).reportRewardAd(c11382a.a(), new a(textView, mAdSequence));
        mAdSequence = 0L;
    }

    public final void g(@NotNull TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) textView);
            return;
        }
        Intrinsics.checkNotNullParameter(textView, "textView");
        VasRewardAdReqParams.a aVar = new VasRewardAdReqParams.a();
        aVar.d(com.tencent.mobileqq.ad.debug.a.f186830a.l());
        aVar.c("{\"reward_type\": 0}");
        aVar.e(0);
        aVar.b("");
        ((IVasRewardAdApi) QRoute.api(IVasRewardAdApi.class)).requestAd(aVar.a(), new b(textView));
    }

    public final void h(@Nullable Activity activity, @NotNull TextView reqTV, @NotNull TextView showTV, @NotNull TextView reportTV) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, activity, reqTV, showTV, reportTV);
            return;
        }
        Intrinsics.checkNotNullParameter(reqTV, "reqTV");
        Intrinsics.checkNotNullParameter(showTV, "showTV");
        Intrinsics.checkNotNullParameter(reportTV, "reportTV");
        ((IVasRewardAdApi) QRoute.api(IVasRewardAdApi.class)).showRewardAd(activity, mAdSequence, "\u83b7\u5f97\u6709\u6548\u5956\u52b1", "biz_src_test", new c(showTV, reportTV, reqTV));
    }
}
