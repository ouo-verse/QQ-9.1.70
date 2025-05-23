package com.tencent.mobileqq.troop.flame.surprise;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.flame.api.ITroopFlameApi;
import com.tencent.mobileqq.troop.flame.api.impl.TroopFlameApiImpl;
import com.tencent.mobileqq.troop.flame.widget.TroopLottieAnimationView;
import com.tencent.mobileqq.troop.widget.pag.TroopPagView;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mvi.base.route.j;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.reserve2.animation.BusiAnimationEvent;
import com.tencent.qqnt.kernel.nativeinterface.GroupExtFlameData;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGView;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0018B\u001f\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\u0006\u0010\"\u001a\u00020\u001d\u0012\u0006\u0010(\u001a\u00020#\u00a2\u0006\u0004\b<\u0010=J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\r\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J\u0016\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011J\u0010\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\"\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010(\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010-\u001a\n **\u0004\u0018\u00010)0)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00103\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u00102R\u0018\u0010\f\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u00105R\u0018\u00108\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u00107R\u0018\u0010;\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010:\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/troop/flame/surprise/TroopFlameSurpriseEggManager;", "", "", "o", "", "levelHasShow", "curLevel", "Landroid/view/View;", h.F, "", "l", "k", "pagView", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "targetLocation", "", "targetSize", DomainData.DOMAIN_NAME, "Lcom/tencent/qqnt/kernel/nativeinterface/GroupExtFlameData;", "troopFlameData", "g", "Lcom/tencent/aio/api/runtime/a;", "a", "Lcom/tencent/aio/api/runtime/a;", "i", "()Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Landroid/content/Context;", "b", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "", "c", "Ljava/lang/String;", "j", "()Ljava/lang/String;", "troopUin", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "d", "Landroid/view/LayoutInflater;", "inflater", "e", "[I", "f", "[F", "Z", "isUseLottie", "Lcom/tencent/mobileqq/troop/widget/pag/TroopPagView;", "Lcom/tencent/mobileqq/troop/widget/pag/TroopPagView;", "Lcom/tencent/mobileqq/troop/flame/widget/TroopLottieAnimationView;", "Lcom/tencent/mobileqq/troop/flame/widget/TroopLottieAnimationView;", "lottieAnimationView", "Landroid/animation/AnimatorSet;", "Landroid/animation/AnimatorSet;", "animatorSet", "<init>", "(Lcom/tencent/aio/api/runtime/a;Landroid/content/Context;Ljava/lang/String;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"InflateParams"})
/* loaded from: classes19.dex */
public final class TroopFlameSurpriseEggManager {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final LayoutInflater inflater;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private int[] targetLocation;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private float[] targetSize;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean isUseLottie;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TroopPagView pagView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TroopLottieAnimationView lottieAnimationView;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AnimatorSet animatorSet;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/flame/surprise/TroopFlameSurpriseEggManager$a;", "", "", "ANIM_DURATION_TIME", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.flame.surprise.TroopFlameSurpriseEggManager$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/troop/flame/surprise/TroopFlameSurpriseEggManager$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "onAnimationCancel", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopFlameSurpriseEggManager.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                TroopFlameSurpriseEggManager.this.m();
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            } else {
                TroopFlameSurpriseEggManager troopFlameSurpriseEggManager = TroopFlameSurpriseEggManager.this;
                troopFlameSurpriseEggManager.p(troopFlameSurpriseEggManager.lottieAnimationView);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/flame/surprise/TroopFlameSurpriseEggManager$c", "Lorg/libpag/PAGView$PAGViewListener;", "Lorg/libpag/PAGView;", "p0", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "onAnimationUpdate", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c implements PAGView.PAGViewListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopFlameSurpriseEggManager.this);
            }
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationCancel(@Nullable PAGView p06) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                TroopFlameSurpriseEggManager.this.m();
            } else {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) p06);
            }
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationEnd(@Nullable PAGView p06) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) p06);
            } else {
                TroopFlameSurpriseEggManager troopFlameSurpriseEggManager = TroopFlameSurpriseEggManager.this;
                troopFlameSurpriseEggManager.p(troopFlameSurpriseEggManager.pagView);
            }
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationRepeat(@Nullable PAGView p06) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) p06);
            }
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationStart(@Nullable PAGView p06) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) p06);
            }
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationUpdate(@Nullable PAGView p06) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) p06);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/troop/flame/surprise/TroopFlameSurpriseEggManager$d", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class d implements Animator.AnimatorListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopFlameSurpriseEggManager.this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                TroopFlameSurpriseEggManager.this.m();
            } else {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                TroopFlameSurpriseEggManager.this.m();
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animation);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36599);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopFlameSurpriseEggManager(@NotNull com.tencent.aio.api.runtime.a mAIOContext, @NotNull Context context, @NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(mAIOContext, "mAIOContext");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, mAIOContext, context, troopUin);
            return;
        }
        this.mAIOContext = mAIOContext;
        this.context = context;
        this.troopUin = troopUin;
        this.inflater = LayoutInflater.from(context);
        this.targetLocation = new int[2];
        this.targetSize = new float[2];
        this.isUseLottie = com.tencent.mobileqq.troop.flame.widget.a.f296153a.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View h(int levelHasShow, int curLevel) {
        View fullScreenRootView = this.inflater.inflate(R.layout.fzp, (ViewGroup) null);
        if (this.isUseLottie) {
            TroopLottieAnimationView troopLottieAnimationView = (TroopLottieAnimationView) fullScreenRootView.findViewById(R.id.f909153r);
            this.lottieAnimationView = troopLottieAnimationView;
            if (troopLottieAnimationView != null) {
                troopLottieAnimationView.setVisibility(0);
            }
            TroopLottieAnimationView troopLottieAnimationView2 = this.lottieAnimationView;
            if (troopLottieAnimationView2 != null) {
                troopLottieAnimationView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            k(levelHasShow, curLevel);
        } else {
            TroopPagView troopPagView = (TroopPagView) fullScreenRootView.findViewById(R.id.f909253s);
            this.pagView = troopPagView;
            if (troopPagView != null) {
                troopPagView.setVisibility(0);
            }
            l(levelHasShow, curLevel);
        }
        Intrinsics.checkNotNullExpressionValue(fullScreenRootView, "fullScreenRootView");
        return fullScreenRootView;
    }

    private final void k(int levelHasShow, int curLevel) {
        TroopLottieAnimationView troopLottieAnimationView = this.lottieAnimationView;
        if (troopLottieAnimationView != null) {
            troopLottieAnimationView.addAnimatorListener(new b());
        }
        TroopLottieAnimationView troopLottieAnimationView2 = this.lottieAnimationView;
        if (troopLottieAnimationView2 != null) {
            troopLottieAnimationView2.setAnimationFromUrl(TroopFlameSurprisePag.INSTANCE.a(true, levelHasShow, curLevel));
        }
        TroopLottieAnimationView troopLottieAnimationView3 = this.lottieAnimationView;
        if (troopLottieAnimationView3 != null) {
            troopLottieAnimationView3.playAnimation();
        }
    }

    private final void l(int levelHasShow, int curLevel) {
        TroopPagView troopPagView = this.pagView;
        if (troopPagView != null) {
            troopPagView.play(TroopFlameSurprisePag.INSTANCE.a(false, levelHasShow, curLevel), 1, null, null, new c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        TroopPagView troopPagView = this.pagView;
        if (troopPagView != null) {
            troopPagView.setPagListener(null);
        }
        TroopLottieAnimationView troopLottieAnimationView = this.lottieAnimationView;
        if (troopLottieAnimationView != null) {
            troopLottieAnimationView.removeAllAnimatorListeners();
        }
        try {
            TroopPagView troopPagView2 = this.pagView;
            if (troopPagView2 != null) {
                troopPagView2.stop();
            }
            TroopLottieAnimationView troopLottieAnimationView2 = this.lottieAnimationView;
            if (troopLottieAnimationView2 != null) {
                troopLottieAnimationView2.cancelAnimation();
            }
        } catch (Throwable th5) {
            QLog.e("TroopFlameSurpriseEggManager", 1, "[removeFullScreenPagView] throwable = " + th5);
        }
        this.pagView = null;
        this.lottieAnimationView = null;
        AnimatorSet animatorSet = this.animatorSet;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
        }
        this.animatorSet = null;
        j e16 = this.mAIOContext.e();
        if (e16 != null) {
            e16.h(new BusiAnimationEvent.RemoveFullScreenView(7));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean o() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106056", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(View pagView) {
        float height;
        if (pagView == null) {
            m();
            return;
        }
        pagView.setPivotX(0.0f);
        pagView.setPivotY(0.0f);
        int[] iArr = new int[2];
        pagView.getLocationOnScreen(iArr);
        int[] iArr2 = this.targetLocation;
        int i3 = iArr2[0] - iArr[0];
        int i16 = iArr2[1] - iArr[1];
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(pagView, "translationX", i3);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(pagView, "translationY", i16);
        if (pagView.getHeight() == 0) {
            height = 0.0f;
        } else {
            height = this.targetSize[1] / pagView.getHeight();
        }
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(pagView, BasicAnimation.KeyPath.SCALE_X, height);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(pagView, BasicAnimation.KeyPath.SCALE_Y, height);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(pagView, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.animatorSet = animatorSet;
        animatorSet.playTogether(ofFloat3, ofFloat4, ofFloat, ofFloat2, ofFloat5);
        AnimatorSet animatorSet2 = this.animatorSet;
        if (animatorSet2 != null) {
            animatorSet2.setDuration(700L);
        }
        AnimatorSet animatorSet3 = this.animatorSet;
        if (animatorSet3 != null) {
            animatorSet3.addListener(new d());
        }
        AnimatorSet animatorSet4 = this.animatorSet;
        if (animatorSet4 != null) {
            animatorSet4.start();
        }
    }

    public final boolean g(@Nullable final GroupExtFlameData troopFlameData) {
        Integer num;
        int coerceAtLeast;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) troopFlameData)).booleanValue();
        }
        String str = this.troopUin;
        if (troopFlameData != null) {
            num = Integer.valueOf(troopFlameData.state);
        } else {
            num = null;
        }
        QLog.i("TroopFlameSurpriseEggManager", 1, "[checkAndAddSurpriseEgg] troopUin = " + str + " state = " + num + " resumed = " + this.mAIOContext.c().isResumed());
        if (troopFlameData != null) {
            final Ref.IntRef intRef = new Ref.IntRef();
            com.tencent.mobileqq.troop.config.a aVar = com.tencent.mobileqq.troop.config.a.f294689a;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(TroopFlameApiImpl.FLAME_SURPRISE_SHOWN_CACHE_KEY, Arrays.copyOf(new Object[]{this.troopUin}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            int j3 = com.tencent.mobileqq.troop.config.a.j(aVar, format, 0, false, 4, null);
            intRef.element = j3;
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(j3, 0);
            intRef.element = coerceAtLeast;
            QLog.i("TroopFlameSurpriseEggManager", 1, "[checkAndAddSurpriseEgg] levelHasShow = " + coerceAtLeast);
            int i3 = troopFlameData.state;
            int i16 = intRef.element;
            if (i3 != i16 && i3 != 999) {
                if (i3 >= i16 && i3 != 0) {
                    a aVar2 = a.f296149a;
                    if (!aVar2.b()) {
                        String format2 = String.format(TroopFlameApiImpl.FLAME_SURPRISE_SHOWN_CACHE_KEY, Arrays.copyOf(new Object[]{this.troopUin}, 1));
                        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
                        com.tencent.mobileqq.troop.config.a.v(aVar, format2, troopFlameData.state, false, 4, null);
                        ((ITroopFlameApi) QRoute.api(ITroopFlameApi.class)).addLocalTroopFlameGrayTip(this.troopUin, intRef.element, troopFlameData.state);
                        return false;
                    }
                    if (!this.mAIOContext.c().isResumed()) {
                        return false;
                    }
                    com.tencent.mobileqq.ad.cardad.utils.d.f186735a.h(new Function0<Unit>(intRef, troopFlameData) { // from class: com.tencent.mobileqq.troop.flame.surprise.TroopFlameSurpriseEggManager$checkAndAddSurpriseEgg$1$1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ GroupExtFlameData $flameData;
                        final /* synthetic */ Ref.IntRef $levelHasShow;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$levelHasShow = intRef;
                            this.$flameData = troopFlameData;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, TroopFlameSurpriseEggManager.this, intRef, troopFlameData);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            boolean o16;
                            j e16;
                            View h16;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            QLog.i("TroopFlameSurpriseEggManager", 1, "[checkAndAddSurpriseEgg] troopUin = " + TroopFlameSurpriseEggManager.this.j() + " levelHasShow = " + this.$levelHasShow.element + " state = " + this.$flameData.state);
                            TroopFlameSurpriseEggManager.this.m();
                            ((ITroopFlameApi) QRoute.api(ITroopFlameApi.class)).addLocalTroopFlameGrayTip(TroopFlameSurpriseEggManager.this.j(), this.$levelHasShow.element, this.$flameData.state);
                            o16 = TroopFlameSurpriseEggManager.this.o();
                            if (o16 || (e16 = TroopFlameSurpriseEggManager.this.i().e()) == null) {
                                return;
                            }
                            h16 = TroopFlameSurpriseEggManager.this.h(this.$levelHasShow.element, this.$flameData.state);
                            e16.h(new BusiAnimationEvent.AddFullScreenView(7, h16));
                        }
                    });
                    String format3 = String.format(TroopFlameApiImpl.FLAME_SURPRISE_SHOWN_CACHE_KEY, Arrays.copyOf(new Object[]{this.troopUin}, 1));
                    Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
                    com.tencent.mobileqq.troop.config.a.v(aVar, format3, troopFlameData.state, false, 4, null);
                    aVar2.a();
                    return true;
                }
                String format4 = String.format(TroopFlameApiImpl.FLAME_SURPRISE_SHOWN_CACHE_KEY, Arrays.copyOf(new Object[]{this.troopUin}, 1));
                Intrinsics.checkNotNullExpressionValue(format4, "format(format, *args)");
                com.tencent.mobileqq.troop.config.a.v(aVar, format4, troopFlameData.state, false, 4, null);
            }
        }
        return false;
    }

    @NotNull
    public final com.tencent.aio.api.runtime.a i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.aio.api.runtime.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mAIOContext;
    }

    @NotNull
    public final String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.troopUin;
    }

    public final void n(@NotNull int[] targetLocation, @NotNull float[] targetSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) targetLocation, (Object) targetSize);
            return;
        }
        Intrinsics.checkNotNullParameter(targetLocation, "targetLocation");
        Intrinsics.checkNotNullParameter(targetSize, "targetSize");
        this.targetLocation = targetLocation;
        this.targetSize = targetSize;
    }
}
