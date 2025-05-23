package com.tencent.mobileqq.ad.cardad.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.shake.GdtShakeSensor;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 P2\u00020\u00012\u00020\u0002:\u0002QRB\u0017\u0012\u0006\u0010K\u001a\u00020\u001b\u0012\u0006\u0010M\u001a\u00020L\u00a2\u0006\u0004\bN\u0010OJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J \u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u000e\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0006J\u0006\u0010\u0017\u001a\u00020\u0003J\u0006\u0010\u0018\u001a\u00020\u0003J\u0006\u0010\u0019\u001a\u00020\u0003J\b\u0010\u001a\u001a\u00020\u0003H\u0016R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010 R\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010 R\u0016\u0010#\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010 R\u0016\u0010$\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0004\u0010 R\u0016\u0010'\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010&R\u0016\u0010)\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010+\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010&R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u00109\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00106R\u0016\u0010<\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010B\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010;R\u0016\u0010F\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010;R\u0016\u0010H\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010;R\u0016\u0010J\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010:\u00a8\u0006S"}, d2 = {"Lcom/tencent/mobileqq/ad/cardad/views/CardAdShakeView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/gdtad/views/shake/GdtShakeSensor$OnShakeListener;", "", "i", "g", "", "position", "l", "k", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, DomainData.DOMAIN_NAME, "", "f", "canShake", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "Lcom/tencent/mobileqq/ad/cardad/views/CardAdShakeView$b;", "shakeListener", "e", "orientation", tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "t", "j", "onShakeComplete", "Landroid/content/Context;", "d", "Landroid/content/Context;", "mContext", "Landroid/view/View;", "Landroid/view/View;", "mRootView", "mMaskView", "mTopMaskView", "mBottomMaskView", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "mTopShakeContainer", BdhLogUtil.LogTag.Tag_Conn, "mMiddleShakeContainer", "D", "mBottomShakeContainer", "Lcom/tencent/gdtad/views/shake/GdtShakeSensor;", "E", "Lcom/tencent/gdtad/views/shake/GdtShakeSensor;", "mShakeSensor", "Lcom/tencent/gdtad/views/shake/GdtShakeSensor$Params;", UserInfo.SEX_FEMALE, "Lcom/tencent/gdtad/views/shake/GdtShakeSensor$Params;", "mShakeParams", "Landroid/animation/ValueAnimator;", "G", "Landroid/animation/ValueAnimator;", "mShakeFirstTimeAnimator", "H", "mShakeRegisterAnimator", "I", "Z", "mCanShake", "J", "Lcom/tencent/gdtad/aditem/GdtAd;", "mGdtAd", "K", "Lcom/tencent/mobileqq/ad/cardad/views/CardAdShakeView$b;", "mShakeListener", "L", "mIsRegistered", "M", "mIsFirstTimeShow", "N", "mHasInitView", "P", "mShakePosition", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "b", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class CardAdShakeView extends FrameLayout implements GdtShakeSensor.OnShakeListener {
    static IPatchRedirector $redirector_;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private LinearLayout mMiddleShakeContainer;

    /* renamed from: D, reason: from kotlin metadata */
    private LinearLayout mBottomShakeContainer;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private GdtShakeSensor mShakeSensor;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private GdtShakeSensor.Params mShakeParams;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private ValueAnimator mShakeFirstTimeAnimator;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private ValueAnimator mShakeRegisterAnimator;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean mCanShake;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private GdtAd mGdtAd;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private b mShakeListener;

    /* renamed from: L, reason: from kotlin metadata */
    private volatile boolean mIsRegistered;

    /* renamed from: M, reason: from kotlin metadata */
    private volatile boolean mIsFirstTimeShow;

    /* renamed from: N, reason: from kotlin metadata */
    private volatile boolean mHasInitView;

    /* renamed from: P, reason: from kotlin metadata */
    private int mShakePosition;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context mContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View mRootView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View mMaskView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View mTopMaskView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View mBottomMaskView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mTopShakeContainer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/ad/cardad/views/CardAdShakeView$a;", "", "", "CARD_AD_SHAKE_DURATION_AGAIN", "J", "CARD_AD_SHAKE_DURATION_FIRST_TIME", "", "CARD_AD_SHAKE_LANDSCAPE", "I", "CARD_AD_SHAKE_PORTRAIT", "CARD_AD_SHAKE_POS_BOTTOM", "CARD_AD_SHAKE_POS_MIDDLE", "CARD_AD_SHAKE_POS_TOP", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.ad.cardad.views.CardAdShakeView$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/ad/cardad/views/CardAdShakeView$b;", "", "", "onShakeComplete", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public interface b {
        void onShakeComplete();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26547);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardAdShakeView(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attrs);
            return;
        }
        this.mContext = context;
        this.mIsFirstTimeShow = true;
        this.mShakePosition = 1;
        i();
    }

    private final boolean f() {
        com.tencent.mobileqq.ad.cardad.utils.d dVar = com.tencent.mobileqq.ad.cardad.utils.d.f186735a;
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        Object parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        if (com.tencent.mobileqq.ad.cardad.utils.d.d(dVar, (View) parent, false, 2, null) < 0.5d || !GuardManager.sInstance.isApplicationForeground()) {
            return false;
        }
        return true;
    }

    private final void g() {
        GdtAd gdtAd;
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        if (this.mCanShake && (gdtAd = this.mGdtAd) != null) {
            if (gdtAd != null) {
                adInfo = gdtAd.info;
            } else {
                adInfo = null;
            }
            this.mShakeParams = new GdtShakeSensor.Params(adInfo);
        }
    }

    private final void i() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.f167689e15, (ViewGroup) this, true);
        if (inflate == null) {
            return;
        }
        this.mRootView = inflate;
        View findViewById = inflate.findViewById(R.id.tmu);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.card_ad_shake_mask)");
        this.mMaskView = findViewById;
        View view = this.mRootView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        View findViewById2 = view.findViewById(R.id.f164733tn3);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R\u2026d.card_ad_shake_top_mask)");
        this.mTopMaskView = findViewById2;
        View view3 = this.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view3 = null;
        }
        View findViewById3 = view3.findViewById(R.id.tms);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R\u2026ard_ad_shake_bottom_mask)");
        this.mBottomMaskView = findViewById3;
        View view4 = this.mRootView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view4 = null;
        }
        View findViewById4 = view4.findViewById(R.id.f164730tn0);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R\u2026d_ad_shake_top_container)");
        this.mTopShakeContainer = (LinearLayout) findViewById4;
        View view5 = this.mRootView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view5 = null;
        }
        View findViewById5 = view5.findViewById(R.id.tmv);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mRootView.findViewById(R\u2026d_shake_middle_container)");
        this.mMiddleShakeContainer = (LinearLayout) findViewById5;
        View view6 = this.mRootView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            view2 = view6;
        }
        View findViewById6 = view2.findViewById(R.id.tmp);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "mRootView.findViewById(R\u2026d_shake_bottom_container)");
        this.mBottomShakeContainer = (LinearLayout) findViewById6;
    }

    private final void k() {
        if (this.mIsRegistered) {
            return;
        }
        QLog.d("CardAdShakeView", 2, "register");
        GdtShakeSensor gdtShakeSensor = new GdtShakeSensor();
        gdtShakeSensor.setShakeFactor(this.mShakeParams);
        gdtShakeSensor.setShakeListener(new WeakReference<>(this));
        gdtShakeSensor.register(this.mContext);
        this.mShakeSensor = gdtShakeSensor;
        this.mIsRegistered = true;
    }

    private final void l(int position) {
        if (!this.mCanShake) {
            return;
        }
        LinearLayout linearLayout = null;
        if (position != 1) {
            if (position != 2) {
                if (position == 3) {
                    View view = this.mTopMaskView;
                    if (view == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTopMaskView");
                        view = null;
                    }
                    view.setVisibility(8);
                    View view2 = this.mMaskView;
                    if (view2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mMaskView");
                        view2 = null;
                    }
                    view2.setVisibility(8);
                    View view3 = this.mBottomMaskView;
                    if (view3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBottomMaskView");
                        view3 = null;
                    }
                    view3.setVisibility(0);
                    LinearLayout linearLayout2 = this.mTopShakeContainer;
                    if (linearLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTopShakeContainer");
                        linearLayout2 = null;
                    }
                    linearLayout2.setVisibility(8);
                    LinearLayout linearLayout3 = this.mMiddleShakeContainer;
                    if (linearLayout3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mMiddleShakeContainer");
                        linearLayout3 = null;
                    }
                    linearLayout3.setVisibility(8);
                    LinearLayout linearLayout4 = this.mBottomShakeContainer;
                    if (linearLayout4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBottomShakeContainer");
                    } else {
                        linearLayout = linearLayout4;
                    }
                    linearLayout.setVisibility(0);
                    return;
                }
                return;
            }
            View view4 = this.mTopMaskView;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopMaskView");
                view4 = null;
            }
            view4.setVisibility(8);
            View view5 = this.mMaskView;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMaskView");
                view5 = null;
            }
            view5.setVisibility(0);
            View view6 = this.mBottomMaskView;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBottomMaskView");
                view6 = null;
            }
            view6.setVisibility(8);
            View view7 = this.mBottomMaskView;
            if (view7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBottomMaskView");
                view7 = null;
            }
            view7.setVisibility(8);
            LinearLayout linearLayout5 = this.mTopShakeContainer;
            if (linearLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopShakeContainer");
                linearLayout5 = null;
            }
            linearLayout5.setVisibility(8);
            LinearLayout linearLayout6 = this.mMiddleShakeContainer;
            if (linearLayout6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMiddleShakeContainer");
                linearLayout6 = null;
            }
            linearLayout6.setVisibility(0);
            LinearLayout linearLayout7 = this.mBottomShakeContainer;
            if (linearLayout7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBottomShakeContainer");
            } else {
                linearLayout = linearLayout7;
            }
            linearLayout.setVisibility(8);
            return;
        }
        View view8 = this.mTopMaskView;
        if (view8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopMaskView");
            view8 = null;
        }
        view8.setVisibility(0);
        View view9 = this.mMaskView;
        if (view9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMaskView");
            view9 = null;
        }
        view9.setVisibility(8);
        View view10 = this.mBottomMaskView;
        if (view10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomMaskView");
            view10 = null;
        }
        view10.setVisibility(8);
        LinearLayout linearLayout8 = this.mTopShakeContainer;
        if (linearLayout8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopShakeContainer");
            linearLayout8 = null;
        }
        linearLayout8.setVisibility(0);
        LinearLayout linearLayout9 = this.mMiddleShakeContainer;
        if (linearLayout9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMiddleShakeContainer");
            linearLayout9 = null;
        }
        linearLayout9.setVisibility(8);
        LinearLayout linearLayout10 = this.mBottomShakeContainer;
        if (linearLayout10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomShakeContainer");
        } else {
            linearLayout = linearLayout10;
        }
        linearLayout.setVisibility(8);
    }

    private final void n() {
        l(this.mShakePosition);
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 1, 2);
        this.mShakeRegisterAnimator = ofInt;
        if (ofInt != null) {
            ofInt.setDuration(2000L);
        }
        ValueAnimator valueAnimator = this.mShakeRegisterAnimator;
        if (valueAnimator != null) {
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.ad.cardad.views.a
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    CardAdShakeView.o(CardAdShakeView.this, valueAnimator2);
                }
            });
        }
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.ad.cardad.views.b
            @Override // java.lang.Runnable
            public final void run() {
                CardAdShakeView.p(CardAdShakeView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(CardAdShakeView this$0, ValueAnimator valueAnimator) {
        Object obj;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (valueAnimator != null) {
            obj = valueAnimator.getAnimatedValue();
        } else {
            obj = null;
        }
        if (Intrinsics.areEqual(obj, (Object) 2) && this$0.f()) {
            this$0.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(CardAdShakeView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ValueAnimator valueAnimator = this$0.mShakeRegisterAnimator;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    private final void q() {
        if (!this.mHasInitView) {
            l(this.mShakePosition);
            this.mHasInitView = true;
        }
        this.mIsFirstTimeShow = false;
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 1, 2, 3, 4, 5);
        this.mShakeFirstTimeAnimator = ofInt;
        if (ofInt != null) {
            ofInt.setDuration(5000L);
        }
        ValueAnimator valueAnimator = this.mShakeFirstTimeAnimator;
        if (valueAnimator != null) {
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.ad.cardad.views.c
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    CardAdShakeView.r(CardAdShakeView.this, valueAnimator2);
                }
            });
        }
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.ad.cardad.views.d
            @Override // java.lang.Runnable
            public final void run() {
                CardAdShakeView.s(CardAdShakeView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(CardAdShakeView this$0, ValueAnimator valueAnimator) {
        Object obj;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (valueAnimator != null) {
            obj = valueAnimator.getAnimatedValue();
        } else {
            obj = null;
        }
        if (Intrinsics.areEqual(obj, (Object) 2)) {
            if (this$0.f()) {
                this$0.k();
            }
        } else if (Intrinsics.areEqual(obj, (Object) 3)) {
            this$0.l(2);
        } else if (Intrinsics.areEqual(obj, (Object) 5)) {
            this$0.l(this$0.mShakePosition);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(CardAdShakeView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ValueAnimator valueAnimator = this$0.mShakeFirstTimeAnimator;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    private final void u() {
        if (!this.mIsRegistered) {
            return;
        }
        QLog.d("CardAdShakeView", 2, "unregister");
        GdtShakeSensor gdtShakeSensor = this.mShakeSensor;
        if (gdtShakeSensor != null) {
            gdtShakeSensor.unregister(this.mContext);
        }
        this.mShakeSensor = null;
        this.mIsRegistered = false;
    }

    public final void e(boolean canShake, @NotNull GdtAd gdtAd, @Nullable b shakeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(canShake), gdtAd, shakeListener);
            return;
        }
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        this.mCanShake = canShake;
        this.mGdtAd = gdtAd;
        this.mShakeListener = shakeListener;
        g();
    }

    public final void h(int orientation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 3;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, orientation);
            return;
        }
        if (orientation == 1) {
            i3 = 1;
        }
        this.mShakePosition = i3;
    }

    public final void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        t();
        View view = this.mMaskView;
        LinearLayout linearLayout = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMaskView");
            view = null;
        }
        view.setVisibility(8);
        LinearLayout linearLayout2 = this.mTopShakeContainer;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopShakeContainer");
            linearLayout2 = null;
        }
        linearLayout2.setVisibility(8);
        LinearLayout linearLayout3 = this.mMiddleShakeContainer;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMiddleShakeContainer");
            linearLayout3 = null;
        }
        linearLayout3.setVisibility(8);
        LinearLayout linearLayout4 = this.mBottomShakeContainer;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomShakeContainer");
        } else {
            linearLayout = linearLayout4;
        }
        linearLayout.setVisibility(8);
        GdtShakeSensor gdtShakeSensor = this.mShakeSensor;
        if (gdtShakeSensor != null) {
            gdtShakeSensor.reset();
        }
    }

    public final void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        QLog.d("CardAdShakeView", 1, "startShake isFirstTimeShow:", Boolean.valueOf(this.mIsFirstTimeShow));
        if (this.mIsFirstTimeShow) {
            q();
        } else {
            n();
        }
    }

    @Override // com.tencent.gdtad.views.shake.GdtShakeSensor.OnShakeListener
    public void onShakeComplete() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        QLog.d("CardAdShakeView", 1, "onShakeComplete");
        b bVar = this.mShakeListener;
        if (bVar != null) {
            bVar.onShakeComplete();
        }
        GdtShakeSensor gdtShakeSensor = this.mShakeSensor;
        if (gdtShakeSensor != null) {
            gdtShakeSensor.reset();
        }
        u();
    }

    public final void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        ValueAnimator valueAnimator = this.mShakeFirstTimeAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.mShakeFirstTimeAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        this.mShakeFirstTimeAnimator = null;
        ValueAnimator valueAnimator3 = this.mShakeRegisterAnimator;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
        }
        ValueAnimator valueAnimator4 = this.mShakeRegisterAnimator;
        if (valueAnimator4 != null) {
            valueAnimator4.removeAllListeners();
        }
        this.mShakeRegisterAnimator = null;
        u();
    }
}
