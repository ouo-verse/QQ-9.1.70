package com.tencent.mobileqq.ad.cardad.views.guild;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtImageData;
import com.tencent.gdtad.inject.GdtThirdProcessorProxy;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.gdtad.views.video.GdtVideoView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ad.cardad.data.aa;
import com.tencent.mobileqq.ad.cardad.views.CardAdVideoView;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplatePreloadHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001-\u0018\u0000 =2\u00020\u0001:\u0001>B!\u0012\u0006\u00106\u001a\u000205\u0012\u0006\u00108\u001a\u000207\u0012\b\u0010:\u001a\u0004\u0018\u000109\u00a2\u0006\u0004\b;\u0010<J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0014J\b\u0010\r\u001a\u00020\u0007H\u0014J\b\u0010\u000e\u001a\u00020\u0002H\u0014J\b\u0010\u000f\u001a\u00020\u0002H\u0014J\b\u0010\u0010\u001a\u00020\u0002H\u0014J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/ad/cardad/views/guild/CardAdVideoForGuildSquareFeed;", "Lcom/tencent/mobileqq/ad/cardad/views/CardAdVideoView;", "", "U0", "Q0", "", "milliseconds", "", "R0", "Lcom/tencent/gdtad/inject/GdtThirdProcessorProxy;", "S0", "", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Y", "f", "o0", "r0", "", "isNeedReport", "t0", "onFirstFrameRendered", "onCurrentLoopStart", "K0", "Landroidx/constraintlayout/widget/ConstraintLayout;", "x0", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mMediaContainerLayout", "Landroid/view/View;", "y0", "Landroid/view/View;", "mVideoBottomMask", "Landroid/widget/TextView;", "z0", "Landroid/widget/TextView;", "mProgressTime", "A0", "J", "mVideoDuration", "B0", "Z", "mIsPlaying", "C0", "Lcom/tencent/gdtad/inject/GdtThirdProcessorProxy;", "mThirdProcessorProxy", "com/tencent/mobileqq/ad/cardad/views/guild/CardAdVideoForGuildSquareFeed$mVideoProgressUpdateRunnable$1", "D0", "Lcom/tencent/mobileqq/ad/cardad/views/guild/CardAdVideoForGuildSquareFeed$mVideoProgressUpdateRunnable$1;", "mVideoProgressUpdateRunnable", "Ljava/lang/Runnable;", "E0", "Ljava/lang/Runnable;", "mTimeStatusRunnable", "Landroid/content/Context;", "context", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "Lcom/tencent/mobileqq/ad/cardad/data/aa;", "reportCallback", "<init>", "(Landroid/content/Context;Lcom/tencent/gdtad/aditem/GdtAd;Lcom/tencent/mobileqq/ad/cardad/data/aa;)V", "F0", "a", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class CardAdVideoForGuildSquareFeed extends CardAdVideoView {

    /* renamed from: A0, reason: from kotlin metadata */
    private long mVideoDuration;

    /* renamed from: B0, reason: from kotlin metadata */
    private boolean mIsPlaying;

    /* renamed from: C0, reason: from kotlin metadata */
    @Nullable
    private GdtThirdProcessorProxy mThirdProcessorProxy;

    /* renamed from: D0, reason: from kotlin metadata */
    @NotNull
    private final CardAdVideoForGuildSquareFeed$mVideoProgressUpdateRunnable$1 mVideoProgressUpdateRunnable;

    /* renamed from: E0, reason: from kotlin metadata */
    @NotNull
    private final Runnable mTimeStatusRunnable;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ConstraintLayout mMediaContainerLayout;

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mVideoBottomMask;

    /* renamed from: z0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mProgressTime;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.tencent.mobileqq.ad.cardad.views.guild.CardAdVideoForGuildSquareFeed$mVideoProgressUpdateRunnable$1] */
    public CardAdVideoForGuildSquareFeed(@NotNull Context context, @NotNull GdtAd gdtAd, @Nullable aa aaVar) {
        super(context, gdtAd, aaVar);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        this.mVideoProgressUpdateRunnable = new Runnable() { // from class: com.tencent.mobileqq.ad.cardad.views.guild.CardAdVideoForGuildSquareFeed$mVideoProgressUpdateRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                GdtVideoView E0;
                Handler H0;
                boolean z16;
                Handler H02;
                E0 = CardAdVideoForGuildSquareFeed.this.E0();
                boolean z17 = false;
                if (E0 != null && !E0.isPlaying()) {
                    z17 = true;
                }
                if (!z17) {
                    z16 = CardAdVideoForGuildSquareFeed.this.mIsPlaying;
                    if (z16) {
                        CardAdVideoForGuildSquareFeed.this.U0();
                        H02 = CardAdVideoForGuildSquareFeed.this.H0();
                        if (H02 != null) {
                            H02.postDelayed(this, 1000L);
                            return;
                        }
                        return;
                    }
                }
                H0 = CardAdVideoForGuildSquareFeed.this.H0();
                if (H0 != null) {
                    H0.removeCallbacks(this);
                }
            }
        };
        this.mTimeStatusRunnable = new Runnable() { // from class: com.tencent.mobileqq.ad.cardad.views.guild.a
            @Override // java.lang.Runnable
            public final void run() {
                CardAdVideoForGuildSquareFeed.T0(CardAdVideoForGuildSquareFeed.this);
            }
        };
    }

    private final void Q0() {
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.mTimeStatusRunnable, 4000L);
    }

    private final String R0(long milliseconds) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long minutes = timeUnit.toMinutes(milliseconds);
        long seconds = timeUnit.toSeconds(milliseconds) - TimeUnit.MINUTES.toSeconds(minutes);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(minutes), Long.valueOf(seconds)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    private final GdtThirdProcessorProxy S0() {
        if (this.mThirdProcessorProxy == null) {
            this.mThirdProcessorProxy = new GdtThirdProcessorProxy();
        }
        return this.mThirdProcessorProxy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T0(CardAdVideoForGuildSquareFeed this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.mProgressTime;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U0() {
        long j3;
        long j16 = this.mVideoDuration;
        GdtVideoView E0 = E0();
        if (E0 != null) {
            j3 = E0.getCurrentPositionMs();
        } else {
            j3 = 0;
        }
        String R0 = R0(j16 - j3);
        TextView textView = this.mProgressTime;
        if (textView != null) {
            textView.setText(R0);
        }
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdVideoView
    @SuppressLint({"UseCompatLoadingForDrawables"})
    public void K0() {
        int i3;
        super.K0();
        Context C = C();
        if (F0()) {
            i3 = R.drawable.jfl;
        } else {
            i3 = R.drawable.jfj;
        }
        Drawable drawable = C.getDrawable(i3);
        ImageView A = A();
        if (A != null) {
            A.setImageDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdVideoView, com.tencent.mobileqq.ad.cardad.views.CardAdView
    public void Y() {
        super.Y();
        this.mMediaContainerLayout = (ConstraintLayout) J().findViewById(R.id.tmg);
        this.mProgressTime = (TextView) J().findViewById(R.id.tml);
        this.mVideoBottomMask = J().findViewById(R.id.tn7);
        p0(this.mProgressTime, true);
        p0(this.mVideoBottomMask, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    public void f() {
        String str;
        Drawable drawable;
        super.f();
        if (D().getInnerShowType() == 4) {
            GdtImageData imageData = D().getImageData();
            ViewGroup.LayoutParams layoutParams = null;
            if (imageData != null) {
                str = imageData.url;
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                QLog.e("CardAdVideoForGuildSquareFeed", 1, "bindData image url is empty");
                return;
            }
            String uri = Uri.parse(str).buildUpon().appendQueryParameter(VasProfileTemplatePreloadHelper.BACKGROUND, "blur").build().toString();
            Intrinsics.checkNotNullExpressionValue(uri, "parse(adImageUrl).buildU\u2026blur\").build().toString()");
            ImageView w3 = w();
            if (w3 != null) {
                GdtThirdProcessorProxy S0 = S0();
                if (S0 != null) {
                    drawable = S0.getPreViewImage(getContext(), uri);
                } else {
                    drawable = null;
                }
                w3.setImageDrawable(drawable);
            }
            ConstraintLayout constraintLayout = this.mMediaContainerLayout;
            if (constraintLayout != null) {
                layoutParams = constraintLayout.getLayoutParams();
            }
            if (layoutParams != null) {
                layoutParams.width = ViewUtils.dpToPx(180.0f);
            }
            ViewGroup.LayoutParams layoutParams2 = F().getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ((ConstraintLayout.LayoutParams) layoutParams2).dimensionRatio = "5:7";
        }
        if (this.mVideoDuration == 0) {
            this.mVideoDuration = D().getVideoDuration();
        }
        U0();
        if (this.mIsPlaying) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.mTimeStatusRunnable);
        }
        FontSettingManager.resetViewSize2Normal(getContext(), this.mMediaContainerLayout);
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    protected int o() {
        return R.layout.e0w;
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    protected void o0() {
        GdtUIUtils.setViewRadius(u(), 15.0f);
        GdtUIUtils.setViewRadius(F(), 8.0f);
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdVideoView, com.tencent.gdtad.views.video.GdtVideoView.GdtVideoListener
    public void onCurrentLoopStart() {
        super.onCurrentLoopStart();
        p0(this.mProgressTime, true);
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.mTimeStatusRunnable);
        Q0();
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdVideoView, com.tencent.gdtad.views.video.GdtVideoView.GdtVideoListener
    public void onFirstFrameRendered() {
        super.onFirstFrameRendered();
        Q0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdVideoView, com.tencent.mobileqq.ad.cardad.views.CardAdView
    @NotNull
    public String q() {
        return "CardAdVideoForGuildSquareFeed";
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdVideoView, com.tencent.mobileqq.ad.cardad.views.CardAdView
    public void r0() {
        long j3;
        super.r0();
        GdtVideoView E0 = E0();
        if (E0 != null) {
            j3 = E0.getVideoDurationMs();
        } else {
            j3 = 0;
        }
        this.mVideoDuration = j3;
        this.mIsPlaying = true;
        if (this.mProgressTime != null) {
            Handler H0 = H0();
            if (H0 != null) {
                H0.post(this.mVideoProgressUpdateRunnable);
            }
            QLog.d(q(), 1, "startVideo mProgressTime post runnable");
        }
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdVideoView, com.tencent.mobileqq.ad.cardad.views.CardAdView
    public void t0(boolean isNeedReport) {
        super.t0(isNeedReport);
        p0(this.mProgressTime, true);
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.mTimeStatusRunnable);
        this.mIsPlaying = false;
    }
}
