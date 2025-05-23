package com.tencent.mobileqq.ad.cardad.views;

import android.content.Context;
import android.os.Handler;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.ad.tangram.AdError;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.gdtad.views.video.GdtVideoView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ad.cardad.data.aa;
import com.tencent.mobileqq.ad.cardad.data.ab;
import com.tencent.mobileqq.ad.cardad.data.ac;
import com.tencent.mobileqq.ad.cardad.views.CardAdView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
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
@Metadata(d1 = {"\u0000\u0081\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001c\b\u0016\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001oB!\u0012\u0006\u0010h\u001a\u00020g\u0012\u0006\u0010j\u001a\u00020i\u0012\b\u0010l\u001a\u0004\u0018\u00010k\u00a2\u0006\u0004\bm\u0010nJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\t\u001a\u00020\u0005H\u0014J\b\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u000bH\u0016J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\u0005H\u0016J\b\u0010!\u001a\u00020\u0005H\u0016J\b\u0010\"\u001a\u00020\u0005H\u0016J\b\u0010#\u001a\u00020\u0005H\u0016J\b\u0010$\u001a\u00020\u0005H\u0016J\b\u0010%\u001a\u00020\u0005H\u0016J\b\u0010&\u001a\u00020\u0005H\u0016J\b\u0010'\u001a\u00020\u0005H\u0016J\b\u0010(\u001a\u00020\u0005H\u0016J\b\u0010)\u001a\u00020\u0005H\u0016J\b\u0010*\u001a\u00020\u0005H\u0016J\b\u0010,\u001a\u00020+H\u0016R$\u00104\u001a\u0004\u0018\u00010-8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u0010<\u001a\u0004\u0018\u0001058\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010C\u001a\u00020\u000b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010G\u001a\u00020\u000b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010>\u001a\u0004\bE\u0010@\"\u0004\bF\u0010BR\"\u0010K\u001a\u00020\u000b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010>\u001a\u0004\bI\u0010@\"\u0004\bJ\u0010BR\u0016\u0010M\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010>R\u0016\u0010O\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010>R\"\u0010U\u001a\u00020+8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u0018\u0010X\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010Z\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010YR$\u0010b\u001a\u0004\u0018\u00010[8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0014\u0010f\u001a\u00020c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bd\u0010e\u00a8\u0006p"}, d2 = {"Lcom/tencent/mobileqq/ad/cardad/views/CardAdVideoView;", "Lcom/tencent/mobileqq/ad/cardad/views/CardAdView;", "Lcom/tencent/gdtad/views/video/GdtVideoView$GdtVideoListener;", "Lcom/tencent/gdtad/views/video/GdtVideoData;", "I0", "", "J0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Y", BdhLogUtil.LogTag.Tag_Req, "", "isEnableVideoPlay", "setEnableVideoPlay", "enable", "setPlayIconAlwaysVisible", "isVoiceOn", "setIsVoiceOn", "", "position", "setVideoStartPosition", "Lcom/tencent/mobileqq/ad/cardad/data/ab;", "callback", "setVideoProgressCallback", "Lcom/tencent/mobileqq/ad/cardad/data/ac;", "setVoiceOnChangeCallback", "r0", "isNeedReport", "t0", "Lcom/tencent/ad/tangram/AdError;", "adError", "onError", "onCompletion", "onVideoPrepared", "onFirstTimeLoopEnd", "onCurrentLoopStart", "onFirstFrameRendered", "w0", "C0", "f0", "e0", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "K0", "", "M", "Lcom/tencent/gdtad/views/video/GdtVideoView;", "k0", "Lcom/tencent/gdtad/views/video/GdtVideoView;", "E0", "()Lcom/tencent/gdtad/views/video/GdtVideoView;", "setMGdtVideoView", "(Lcom/tencent/gdtad/views/video/GdtVideoView;)V", "mGdtVideoView", "Landroid/widget/ProgressBar;", "l0", "Landroid/widget/ProgressBar;", "G0", "()Landroid/widget/ProgressBar;", "setMProgressBar", "(Landroid/widget/ProgressBar;)V", "mProgressBar", "m0", "Z", "getMPlayIconAlwaysVisible", "()Z", "setMPlayIconAlwaysVisible", "(Z)V", "mPlayIconAlwaysVisible", "n0", "getMIsEnablePlay", "setMIsEnablePlay", "mIsEnablePlay", "o0", "F0", "setMIsVoiceOn", "mIsVoiceOn", "p0", "mHasVideoPrepared", "q0", "mStartVideoAfterPrepare", "J", "getMVideoStartPosMs", "()J", "setMVideoStartPosMs", "(J)V", "mVideoStartPosMs", "s0", "Lcom/tencent/mobileqq/ad/cardad/data/ab;", "mVideoProgressCallback", "Lcom/tencent/mobileqq/ad/cardad/data/ac;", "mVoiceOnChangeCallback", "Landroid/os/Handler;", "u0", "Landroid/os/Handler;", "H0", "()Landroid/os/Handler;", "setMProgressHandler", "(Landroid/os/Handler;)V", "mProgressHandler", "com/tencent/mobileqq/ad/cardad/views/CardAdVideoView$mVideoProgressUpdateRunnable$1", "v0", "Lcom/tencent/mobileqq/ad/cardad/views/CardAdVideoView$mVideoProgressUpdateRunnable$1;", "mVideoProgressUpdateRunnable", "Landroid/content/Context;", "context", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "Lcom/tencent/mobileqq/ad/cardad/data/aa;", "reportCallback", "<init>", "(Landroid/content/Context;Lcom/tencent/gdtad/aditem/GdtAd;Lcom/tencent/mobileqq/ad/cardad/data/aa;)V", "a", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public class CardAdVideoView extends CardAdView implements GdtVideoView.GdtVideoListener {
    static IPatchRedirector $redirector_;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GdtVideoView mGdtVideoView;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ProgressBar mProgressBar;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private boolean mPlayIconAlwaysVisible;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private boolean mIsEnablePlay;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private boolean mIsVoiceOn;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private boolean mHasVideoPrepared;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    private boolean mStartVideoAfterPrepare;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    private long mVideoStartPosMs;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ab mVideoProgressCallback;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ac mVoiceOnChangeCallback;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Handler mProgressHandler;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CardAdVideoView$mVideoProgressUpdateRunnable$1 mVideoProgressUpdateRunnable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/ad/cardad/views/CardAdVideoView$a;", "", "", "PROGRESS_UPDATE_FREQ_MS", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.ad.cardad.views.CardAdVideoView$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28624);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 40)) {
            redirector.redirect((short) 40);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r8v2, types: [com.tencent.mobileqq.ad.cardad.views.CardAdVideoView$mVideoProgressUpdateRunnable$1] */
    public CardAdVideoView(@NotNull Context context, @NotNull GdtAd gdtAd, @Nullable aa aaVar) {
        super(context, gdtAd, aaVar);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, gdtAd, aaVar);
            return;
        }
        this.mIsEnablePlay = true;
        this.mProgressHandler = ThreadManagerV2.getUIHandlerV2();
        this.mVideoProgressUpdateRunnable = new Runnable() { // from class: com.tencent.mobileqq.ad.cardad.views.CardAdVideoView$mVideoProgressUpdateRunnable$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CardAdVideoView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                GdtVideoView E0 = CardAdVideoView.this.E0();
                int i3 = 0;
                if (E0 != null && !E0.isPlaying()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    Handler H0 = CardAdVideoView.this.H0();
                    if (H0 != null) {
                        H0.removeCallbacks(this);
                        return;
                    }
                    return;
                }
                ProgressBar G0 = CardAdVideoView.this.G0();
                if (G0 != null) {
                    GdtVideoView E02 = CardAdVideoView.this.E0();
                    if (E02 != null) {
                        i3 = (int) E02.getCurrentPositionMs();
                    }
                    G0.setProgress(i3);
                }
                Handler H02 = CardAdVideoView.this.H0();
                if (H02 != null) {
                    H02.postDelayed(this, 1000L);
                }
            }
        };
    }

    private final GdtVideoData I0() {
        GdtVideoData gdtVideoData = new GdtVideoData();
        gdtVideoData.setUrl(L());
        gdtVideoData.setStartPositionMillis(this.mVideoStartPosMs);
        gdtVideoData.setLoop(true);
        gdtVideoData.setVolumOpen(this.mIsVoiceOn);
        gdtVideoData.setAd(D());
        gdtVideoData.setVideoDefaultBackgroundColor(0);
        gdtVideoData.setCoverUrl(E());
        return gdtVideoData;
    }

    private final void J0() {
        QLog.d(q(), 1, "updateVideoView");
        GdtVideoView gdtVideoView = new GdtVideoView(C(), I0());
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
            return;
        }
        super.C0();
        GdtVideoView gdtVideoView = this.mGdtVideoView;
        if (gdtVideoView != null) {
            gdtVideoView.updateFinishType(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final GdtVideoView E0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (GdtVideoView) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mGdtVideoView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean F0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.mIsVoiceOn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final ProgressBar G0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ProgressBar) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mProgressBar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final Handler H0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Handler) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.mProgressHandler;
    }

    public void K0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this);
            return;
        }
        GdtVideoView gdtVideoView = this.mGdtVideoView;
        if (gdtVideoView != null) {
            gdtVideoView.updateVoiceOn(this.mIsVoiceOn);
        }
        ac acVar = this.mVoiceOnChangeCallback;
        if (acVar != null) {
            acVar.a(this.mIsVoiceOn);
        }
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    public long M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Long) iPatchRedirector.redirect((short) 39, (Object) this)).longValue();
        }
        GdtVideoView gdtVideoView = this.mGdtVideoView;
        if (gdtVideoView != null) {
            return gdtVideoView.getCurrentPositionMs();
        }
        return 0L;
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    public void R() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        super.R();
        this.mIsVoiceOn = !this.mIsVoiceOn;
        ImageView A = A();
        if (A != null) {
            if (this.mIsVoiceOn) {
                str = "\u9759\u97f3";
            } else {
                str = "\u53d6\u6d88\u9759\u97f3";
            }
            A.setContentDescription(str);
        }
        K0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    public void Y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        super.Y();
        ProgressBar progressBar = (ProgressBar) J().findViewById(R.id.tn9);
        this.mProgressBar = progressBar;
        p0(progressBar, true);
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    public void e0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this);
        } else {
            super.e0();
            CardAdView.u0(this, false, 1, null);
        }
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    public void f0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this);
            return;
        }
        super.f0();
        w0();
        x0();
    }

    @Override // com.tencent.gdtad.views.video.GdtVideoView.GdtVideoListener
    public void onCompletion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
        }
    }

    @Override // com.tencent.gdtad.views.video.GdtVideoView.GdtVideoListener
    public void onCurrentLoopStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        aa H = H();
        if (H != null) {
            H.d(D());
        }
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this);
            return;
        }
        super.onDestroy();
        GdtVideoView gdtVideoView = this.mGdtVideoView;
        if (gdtVideoView != null) {
            gdtVideoView.destroy();
        }
        Handler handler = this.mProgressHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mVideoProgressUpdateRunnable);
        }
        this.mGdtVideoView = null;
    }

    @Override // com.tencent.gdtad.views.video.GdtVideoView.GdtVideoListener
    public void onError(@NotNull AdError adError) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) adError);
        } else {
            Intrinsics.checkNotNullParameter(adError, "adError");
            QLog.e(q(), 1, "startVideo onError");
        }
    }

    @Override // com.tencent.gdtad.views.video.GdtVideoView.GdtVideoListener
    public void onFirstFrameRendered() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
        } else {
            p0(v(), false);
        }
    }

    @Override // com.tencent.gdtad.views.video.GdtVideoView.GdtVideoListener
    public void onFirstTimeLoopEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
        }
    }

    @Override // com.tencent.gdtad.views.video.GdtVideoView.GdtVideoListener
    public void onVideoPrepared() {
        ProgressBar progressBar;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        this.mHasVideoPrepared = true;
        GdtVideoView gdtVideoView = this.mGdtVideoView;
        if (gdtVideoView != null && (progressBar = this.mProgressBar) != null) {
            if (gdtVideoView != null) {
                i3 = (int) gdtVideoView.getVideoDurationMs();
            } else {
                i3 = 0;
            }
            progressBar.setMax(i3);
        }
        if (this.mStartVideoAfterPrepare) {
            w0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    @NotNull
    public String q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return "CardAdVideoView";
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    public void r0() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        if (!this.mIsEnablePlay) {
            return;
        }
        super.r0();
        if (this.mGdtVideoView == null) {
            J0();
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
            return;
        }
        K0();
        GdtVideoView gdtVideoView2 = this.mGdtVideoView;
        if (gdtVideoView2 != null) {
            gdtVideoView2.play(false);
        }
        Handler handler = this.mProgressHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mVideoProgressUpdateRunnable);
        }
        if (this.mProgressBar != null) {
            Handler handler2 = this.mProgressHandler;
            if (handler2 != null) {
                handler2.post(this.mVideoProgressUpdateRunnable);
            }
            QLog.d(q(), 1, "startVideo post runnable");
        }
        if (this.mPlayIconAlwaysVisible) {
            p0(G(), true);
        } else {
            p0(G(), false);
        }
        CardAdView.c K = K();
        if (K != null) {
            K.a(M());
        }
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    public void setEnableVideoPlay(boolean isEnableVideoPlay) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, isEnableVideoPlay);
        } else {
            this.mIsEnablePlay = isEnableVideoPlay;
        }
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    public void setIsVoiceOn(boolean isVoiceOn) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, isVoiceOn);
        } else {
            this.mIsVoiceOn = isVoiceOn;
        }
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    public void setPlayIconAlwaysVisible(boolean enable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, enable);
        } else {
            this.mPlayIconAlwaysVisible = enable;
        }
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    public void setVideoProgressCallback(@NotNull ab callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.mVideoProgressCallback = callback;
        }
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    public void setVideoStartPosition(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, position);
        } else {
            this.mVideoStartPosMs = position;
        }
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    public void setVoiceOnChangeCallback(@NotNull ac callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.mVoiceOnChangeCallback = callback;
        }
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    public void t0(boolean isNeedReport) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, isNeedReport);
            return;
        }
        super.t0(isNeedReport);
        GdtVideoView gdtVideoView = this.mGdtVideoView;
        if (gdtVideoView == null) {
            return;
        }
        if (gdtVideoView != null) {
            j3 = gdtVideoView.getCurrentPositionMs();
        } else {
            j3 = 0;
        }
        this.mVideoStartPosMs = j3;
        ab abVar = this.mVideoProgressCallback;
        if (abVar != null) {
            abVar.a(j3);
        }
        GdtVideoView gdtVideoView2 = this.mGdtVideoView;
        if (gdtVideoView2 != null) {
            gdtVideoView2.stop(false, isNeedReport);
        }
        p0(G(), true);
        p0(v(), true);
        CardAdView.c K = K();
        if (K != null) {
            K.onVideoStop();
        }
        GdtVideoView gdtVideoView3 = this.mGdtVideoView;
        if (gdtVideoView3 != null) {
            gdtVideoView3.onDestroy();
        }
        this.mGdtVideoView = null;
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    public void w0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
        } else if (com.tencent.mobileqq.ad.cardad.utils.d.d(com.tencent.mobileqq.ad.cardad.utils.d.f186735a, I(), false, 2, null) < 0.5d) {
            QLog.d(q(), 1, "tryToAutoStartVideo return: invisible");
        } else {
            QLog.d(q(), 1, "tryToAutoStartVideo");
            r0();
        }
    }
}
