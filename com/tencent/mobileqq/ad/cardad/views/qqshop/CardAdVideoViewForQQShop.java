package com.tencent.mobileqq.ad.cardad.views.qqshop;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.ad.tangram.AdError;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.gdtad.views.video.GdtVideoView;
import com.tencent.mobileqq.ad.cardad.data.aa;
import com.tencent.mobileqq.ad.cardad.utils.d;
import com.tencent.mobileqq.ad.cardad.views.CardAdView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00014B!\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u0010.\u001a\u00020-\u0012\b\u00100\u001a\u0004\u0018\u00010/\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u0005H\u0004J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016R\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\"\u0010'\u001a\u00020\n8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\"R\u0016\u0010*\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010\"\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/ad/cardad/views/qqshop/CardAdVideoViewForQQShop;", "Lcom/tencent/mobileqq/ad/cardad/views/qqshop/CardAdViewForQQShop;", "Lcom/tencent/gdtad/views/video/GdtVideoView$GdtVideoListener;", "Lcom/tencent/gdtad/views/video/GdtVideoData;", "R0", "", "T0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r0", "", "isNeedReport", "t0", "S0", "Lcom/tencent/ad/tangram/AdError;", "adError", "onError", "onCompletion", "onVideoPrepared", "onFirstTimeLoopEnd", "onCurrentLoopStart", "onFirstFrameRendered", "w0", "C0", "f0", "e0", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "M", "Lcom/tencent/gdtad/views/video/GdtVideoView;", "u0", "Lcom/tencent/gdtad/views/video/GdtVideoView;", "mGdtVideoView", "v0", "Z", "getMIsEnablePlay", "()Z", "setMIsEnablePlay", "(Z)V", "mIsEnablePlay", "mHasVideoPrepared", "x0", "mStartVideoAfterPrepare", "Landroid/content/Context;", "context", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "Lcom/tencent/mobileqq/ad/cardad/data/aa;", "reportCallback", "<init>", "(Landroid/content/Context;Lcom/tencent/gdtad/aditem/GdtAd;Lcom/tencent/mobileqq/ad/cardad/data/aa;)V", "y0", "a", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public class CardAdVideoViewForQQShop extends CardAdViewForQQShop implements GdtVideoView.GdtVideoListener {
    static IPatchRedirector $redirector_;

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GdtVideoView mGdtVideoView;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    private boolean mIsEnablePlay;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    private boolean mHasVideoPrepared;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    private boolean mStartVideoAfterPrepare;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/ad/cardad/views/qqshop/CardAdVideoViewForQQShop$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.ad.cardad.views.qqshop.CardAdVideoViewForQQShop$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34709);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardAdVideoViewForQQShop(@NotNull Context context, @NotNull GdtAd gdtAd, @Nullable aa aaVar) {
        super(context, gdtAd, aaVar);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, gdtAd, aaVar);
        } else {
            this.mIsEnablePlay = true;
        }
    }

    private final GdtVideoData R0() {
        GdtVideoData gdtVideoData = new GdtVideoData();
        gdtVideoData.setUrl(L());
        gdtVideoData.setStartPositionMillis(0L);
        gdtVideoData.setLoop(true);
        gdtVideoData.setVolumOpen(false);
        gdtVideoData.setAd(D());
        gdtVideoData.setVideoDefaultBackgroundColor(0);
        gdtVideoData.setCoverUrl(E());
        return gdtVideoData;
    }

    private final void T0() {
        QLog.d(q(), 1, "updateVideoView");
        GdtVideoView gdtVideoView = new GdtVideoView(C(), R0());
        this.mGdtVideoView = gdtVideoView;
        gdtVideoView.addVideoListener(new WeakReference<>(this));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        p0(z(), true);
        if (z().getChildCount() > 0) {
            z().removeAllViews();
        }
        z().addView(this.mGdtVideoView, layoutParams);
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    public void C0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        super.C0();
        GdtVideoView gdtVideoView = this.mGdtVideoView;
        if (gdtVideoView != null) {
            gdtVideoView.updateFinishType(2);
        }
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    public long M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Long) iPatchRedirector.redirect((short) 19, (Object) this)).longValue();
        }
        GdtVideoView gdtVideoView = this.mGdtVideoView;
        if (gdtVideoView != null) {
            return gdtVideoView.getCurrentPositionMs();
        }
        return 0L;
    }

    protected final void S0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            t0(false);
            z().setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.qqshop.CardAdViewForQQShop, com.tencent.mobileqq.ad.cardad.views.CardAdView
    public void e0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            super.e0();
            CardAdView.u0(this, false, 1, null);
        }
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    public void f0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        super.f0();
        w0();
        x0();
    }

    @Override // com.tencent.gdtad.views.video.GdtVideoView.GdtVideoListener
    public void onCompletion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    @Override // com.tencent.gdtad.views.video.GdtVideoView.GdtVideoListener
    public void onCurrentLoopStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.qqshop.CardAdViewForQQShop, com.tencent.mobileqq.ad.cardad.views.CardAdView
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        super.onDestroy();
        GdtVideoView gdtVideoView = this.mGdtVideoView;
        if (gdtVideoView != null) {
            gdtVideoView.destroy();
        }
        this.mGdtVideoView = null;
    }

    @Override // com.tencent.gdtad.views.video.GdtVideoView.GdtVideoListener
    public void onError(@Nullable AdError adError) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) adError);
        } else {
            QLog.e(q(), 1, "startVideo onError");
        }
    }

    @Override // com.tencent.gdtad.views.video.GdtVideoView.GdtVideoListener
    public void onFirstFrameRendered() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        }
    }

    @Override // com.tencent.gdtad.views.video.GdtVideoView.GdtVideoListener
    public void onFirstTimeLoopEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        QLog.d(q(), 1, "onFirstTimeLoopEnd");
        this.mIsEnablePlay = false;
        S0();
    }

    @Override // com.tencent.gdtad.views.video.GdtVideoView.GdtVideoListener
    public void onVideoPrepared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        this.mHasVideoPrepared = true;
        if (this.mStartVideoAfterPrepare) {
            w0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    @NotNull
    public String q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "CardAdVideoViewForQQShop";
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    public void r0() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (!this.mIsEnablePlay) {
            return;
        }
        super.r0();
        if (this.mGdtVideoView == null) {
            T0();
        }
        GdtVideoView gdtVideoView = this.mGdtVideoView;
        if (gdtVideoView != null && gdtVideoView.isPlaying()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        if (!this.mHasVideoPrepared) {
            this.mStartVideoAfterPrepare = true;
            QLog.d(q(), 1, "startVideo return: not prepare");
        } else {
            GdtVideoView gdtVideoView2 = this.mGdtVideoView;
            if (gdtVideoView2 != null) {
                gdtVideoView2.play(false);
            }
            p0(G(), false);
        }
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    public void t0(boolean isNeedReport) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, isNeedReport);
            return;
        }
        super.t0(isNeedReport);
        GdtVideoView gdtVideoView = this.mGdtVideoView;
        if (gdtVideoView == null) {
            return;
        }
        if (gdtVideoView != null) {
            gdtVideoView.stop(false, isNeedReport);
        }
        p0(G(), true);
        GdtVideoView gdtVideoView2 = this.mGdtVideoView;
        if (gdtVideoView2 != null) {
            gdtVideoView2.onDestroy();
        }
        this.mGdtVideoView = null;
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    public void w0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else if (d.d(d.f186735a, I(), false, 2, null) < 0.5d) {
            QLog.d(q(), 1, "tryToAutoStartVideo return: invisible");
        } else {
            QLog.d(q(), 1, "tryToAutoStartVideo");
            r0();
        }
    }
}
