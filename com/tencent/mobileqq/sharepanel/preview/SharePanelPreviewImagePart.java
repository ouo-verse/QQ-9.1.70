package com.tencent.mobileqq.sharepanel.preview;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.sharepanel.fragment.DismissType;
import com.tencent.mobileqq.sharepanel.launcher.SharePanelParam;
import com.tencent.mobileqq.sharepanel.model.SharePanelContactItem;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 .2\u00020\u0001:\u0001/B\u000f\u0012\u0006\u0010+\u001a\u00020*\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0016\u0010\u0015\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR#\u0010$\u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R#\u0010)\u001a\n \u001f*\u0004\u0018\u00010%0%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b'\u0010(\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/preview/SharePanelPreviewImagePart;", "Lcom/tencent/mobileqq/sharepanel/part/i;", "", "W9", "da", "Z9", "ca", "Landroid/view/animation/AnimationSet;", "S9", "R9", "V9", "Q9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/sharepanel/fragment/DismissType;", "dismissType", "", "G9", "e", "Z", "isShowState", "Landroid/widget/RelativeLayout;", "f", "Landroid/widget/RelativeLayout;", "previewImageContainer", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCornerImageView;", tl.h.F, "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCornerImageView;", "mRoundCornerImageView", "Lcom/tencent/mobileqq/sharepanel/multiSelect/vm/a;", "kotlin.jvm.PlatformType", "i", "Lkotlin/Lazy;", "T9", "()Lcom/tencent/mobileqq/sharepanel/multiSelect/vm/a;", "multiSelectViewModel", "Lcom/tencent/mobileqq/sharepanel/preview/k;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "U9", "()Lcom/tencent/mobileqq/sharepanel/preview/k;", "singlePreviewVM", "Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;", "param", "<init>", "(Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SharePanelPreviewImagePart extends com.tencent.mobileqq.sharepanel.part.i {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isShowState;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RelativeLayout previewImageContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RoundCornerImageView mRoundCornerImageView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy multiSelectViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy singlePreviewVM;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/preview/SharePanelPreviewImagePart$a;", "", "", "CONTAINER_MARGIN_DP", UserInfo.SEX_FEMALE, "CORNER_DP", "MIN_HEIGHT_DP", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.sharepanel.preview.SharePanelPreviewImagePart$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/sharepanel/preview/SharePanelPreviewImagePart$b", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SharePanelPreviewImagePart.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@NotNull Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                return;
            }
            Intrinsics.checkNotNullParameter(animation, "animation");
            RoundCornerImageView roundCornerImageView = SharePanelPreviewImagePart.this.mRoundCornerImageView;
            if (roundCornerImageView != null) {
                roundCornerImageView.setVisibility(4);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@NotNull Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            } else {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@NotNull Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            } else {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/sharepanel/preview/SharePanelPreviewImagePart$c", "Landroid/view/View$AccessibilityDelegate;", "Landroid/view/View;", "host", "Landroid/view/accessibility/AccessibilityNodeInfo;", "info", "", "onInitializeAccessibilityNodeInfo", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c extends View.AccessibilityDelegate {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(@NotNull View host, @Nullable AccessibilityNodeInfo info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) host, (Object) info);
                return;
            }
            Intrinsics.checkNotNullParameter(host, "host");
            super.onInitializeAccessibilityNodeInfo(host, info);
            if (info != null) {
                info.setClassName("");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40915);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharePanelPreviewImagePart(@NotNull SharePanelParam param) {
        super(param);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(param, "param");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.sharepanel.multiSelect.vm.a>() { // from class: com.tencent.mobileqq.sharepanel.preview.SharePanelPreviewImagePart$multiSelectViewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SharePanelPreviewImagePart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final com.tencent.mobileqq.sharepanel.multiSelect.vm.a invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.sharepanel.multiSelect.vm.a) SharePanelPreviewImagePart.this.getViewModel(com.tencent.mobileqq.sharepanel.multiSelect.vm.a.class) : (com.tencent.mobileqq.sharepanel.multiSelect.vm.a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.multiSelectViewModel = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<k>() { // from class: com.tencent.mobileqq.sharepanel.preview.SharePanelPreviewImagePart$singlePreviewVM$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SharePanelPreviewImagePart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final k invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (k) SharePanelPreviewImagePart.this.getViewModel(k.class) : (k) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.singlePreviewVM = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) param);
    }

    private final void Q9() {
        RoundCornerImageView roundCornerImageView = this.mRoundCornerImageView;
        if (roundCornerImageView == null) {
            return;
        }
        roundCornerImageView.clearAnimation();
    }

    private final AnimationSet R9() {
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        he0.b.l(alphaAnimation, R.anim.f154975ui);
        animationSet.addAnimation(alphaAnimation);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.6f, 1.0f, 0.6f, 1, 0.5f, 1, 0.5f);
        he0.b.l(scaleAnimation, R.anim.f154975ui);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setAnimationListener(new b());
        return animationSet;
    }

    private final AnimationSet S9() {
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        he0.b.l(alphaAnimation, R.anim.f154978ul);
        animationSet.addAnimation(alphaAnimation);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.6f, 1.0f, 0.6f, 1.0f, 1, 0.5f, 1, 0.5f);
        he0.b.l(scaleAnimation, R.anim.f154978ul);
        animationSet.addAnimation(scaleAnimation);
        return animationSet;
    }

    private final com.tencent.mobileqq.sharepanel.multiSelect.vm.a T9() {
        return (com.tencent.mobileqq.sharepanel.multiSelect.vm.a) this.multiSelectViewModel.getValue();
    }

    private final k U9() {
        return (k) this.singlePreviewVM.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V9() {
        RoundCornerImageView roundCornerImageView = this.mRoundCornerImageView;
        if (roundCornerImageView == null || !this.isShowState) {
            return;
        }
        this.isShowState = false;
        Q9();
        if (roundCornerImageView.getVisibility() == 0) {
            roundCornerImageView.startAnimation(R9());
        }
    }

    private final void W9() {
        LifecycleOwner lifecycleOwner;
        IPartHost partHost = getPartHost();
        if (partHost != null) {
            lifecycleOwner = partHost.getLifecycleOwner();
        } else {
            lifecycleOwner = null;
        }
        if (lifecycleOwner == null) {
            return;
        }
        MutableLiveData<List<SharePanelContactItem>> M1 = T9().M1();
        final Function1<List<SharePanelContactItem>, Unit> function1 = new Function1<List<SharePanelContactItem>, Unit>() { // from class: com.tencent.mobileqq.sharepanel.preview.SharePanelPreviewImagePart$initObserver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SharePanelPreviewImagePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<SharePanelContactItem> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<SharePanelContactItem> list) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
                    return;
                }
                if (SharePanelPreviewImagePart.this.mRoundCornerImageView == null) {
                    return;
                }
                List<SharePanelContactItem> list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    SharePanelPreviewImagePart.this.da();
                } else {
                    SharePanelPreviewImagePart.this.V9();
                }
            }
        };
        M1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.sharepanel.preview.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SharePanelPreviewImagePart.X9(Function1.this, obj);
            }
        });
        MutableLiveData<Unit> L1 = U9().L1();
        final Function1<Unit, Unit> function12 = new Function1<Unit, Unit>() { // from class: com.tencent.mobileqq.sharepanel.preview.SharePanelPreviewImagePart$initObserver$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SharePanelPreviewImagePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Unit unit) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    SharePanelPreviewImagePart.this.V9();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) unit);
                }
            }
        };
        L1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.sharepanel.preview.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SharePanelPreviewImagePart.Y9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Z9() {
        final RelativeLayout relativeLayout = this.previewImageContainer;
        if (relativeLayout != null) {
            relativeLayout.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.sharepanel.preview.d
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                    SharePanelPreviewImagePart.aa(SharePanelPreviewImagePart.this, relativeLayout, view, i3, i16, i17, i18, i19, i26, i27, i28);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(final SharePanelPreviewImagePart this$0, RelativeLayout container, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(container, "$container");
        if (this$0.mRoundCornerImageView != null && this$0.isShowState) {
            if (i3 == i19 && i17 == i27 && i16 == i26 && i18 == i28) {
                return;
            }
            container.post(new Runnable() { // from class: com.tencent.mobileqq.sharepanel.preview.h
                @Override // java.lang.Runnable
                public final void run() {
                    SharePanelPreviewImagePart.ba(SharePanelPreviewImagePart.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(SharePanelPreviewImagePart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ca();
    }

    private final void ca() {
        RelativeLayout relativeLayout;
        RoundCornerImageView roundCornerImageView;
        Bitmap q16;
        float coerceAtMost;
        int roundToInt;
        int roundToInt2;
        if (!this.isShowState || (relativeLayout = this.previewImageContainer) == null || (roundCornerImageView = this.mRoundCornerImageView) == null || (q16 = F9().q()) == null || q16.isRecycled()) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = roundCornerImageView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        int width = relativeLayout.getWidth();
        int height = relativeLayout.getHeight();
        if (height < ViewUtils.dpToPx(290.0f)) {
            QLog.d("SharePanelPreviewImagePart", 2, "Height is less than the minimum threshold, set invisible.");
            roundCornerImageView.setVisibility(4);
            return;
        }
        float width2 = q16.getWidth();
        float height2 = q16.getHeight();
        coerceAtMost = RangesKt___RangesKt.coerceAtMost((width * 1.0f) / width2, (height * 1.0f) / height2);
        roundToInt = MathKt__MathJVMKt.roundToInt(width2 * coerceAtMost);
        layoutParams2.width = roundToInt;
        roundToInt2 = MathKt__MathJVMKt.roundToInt(height2 * coerceAtMost);
        layoutParams2.height = roundToInt2;
        roundCornerImageView.setLayoutParams(layoutParams2);
        roundCornerImageView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void da() {
        final Bitmap q16 = F9().q();
        if (q16 == null || this.isShowState) {
            return;
        }
        this.isShowState = true;
        Q9();
        final RelativeLayout relativeLayout = this.previewImageContainer;
        if (relativeLayout != null) {
            relativeLayout.post(new Runnable() { // from class: com.tencent.mobileqq.sharepanel.preview.c
                @Override // java.lang.Runnable
                public final void run() {
                    SharePanelPreviewImagePart.ea(SharePanelPreviewImagePart.this, relativeLayout, q16);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ea(SharePanelPreviewImagePart this$0, RelativeLayout container, Bitmap previewImage) {
        float coerceAtMost;
        int roundToInt;
        int roundToInt2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(container, "$container");
        Intrinsics.checkNotNullParameter(previewImage, "$previewImage");
        if (!this$0.isShowState) {
            return;
        }
        int width = container.getWidth();
        int height = container.getHeight();
        if (height < ViewUtils.dpToPx(290.0f)) {
            QLog.d("SharePanelPreviewImagePart", 2, "Height is less than the minimum threshold, do not init.");
            return;
        }
        RoundCornerImageView roundCornerImageView = new RoundCornerImageView(container.getContext());
        this$0.mRoundCornerImageView = roundCornerImageView;
        roundCornerImageView.f92071e = 1.0f;
        float width2 = previewImage.getWidth();
        float height2 = previewImage.getHeight();
        coerceAtMost = RangesKt___RangesKt.coerceAtMost((width * 1.0f) / width2, (height * 1.0f) / height2);
        roundToInt = MathKt__MathJVMKt.roundToInt(width2 * coerceAtMost);
        roundToInt2 = MathKt__MathJVMKt.roundToInt(height2 * coerceAtMost);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(roundToInt, roundToInt2);
        layoutParams.addRule(13);
        container.removeAllViews();
        container.addView(this$0.mRoundCornerImageView, layoutParams);
        roundCornerImageView.setCorner(ViewUtils.dpToPx(16.0f));
        roundCornerImageView.setAccessibilityDelegate(new c());
        roundCornerImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.sharepanel.preview.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SharePanelPreviewImagePart.ga(view);
            }
        });
        roundCornerImageView.setContentDescription("\u9884\u89c8\u56fe");
        roundCornerImageView.setImageBitmap(previewImage);
        roundCornerImageView.setVisibility(0);
        roundCornerImageView.startAnimation(this$0.S9());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ga(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.sharepanel.part.i
    public boolean G9(@NotNull DismissType dismissType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) dismissType)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(dismissType, "dismissType");
        V9();
        return super.G9(dismissType);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        if (F9().A() != null) {
            if (F9().q() != null) {
                QLog.d("SharePanelPreviewImagePart", 1, "topPreviewViewCreator is not null");
                return;
            }
            return;
        }
        if (rootView != null) {
            relativeLayout = (RelativeLayout) rootView.findViewById(R.id.f27260fr);
        } else {
            relativeLayout = null;
        }
        this.previewImageContainer = relativeLayout;
        if (F9().q() != null && (relativeLayout2 = this.previewImageContainer) != null) {
            ViewGroup.LayoutParams layoutParams = relativeLayout2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            int dpToPx = ViewUtils.dpToPx(32.0f);
            layoutParams2.setMargins(dpToPx, dpToPx, dpToPx, dpToPx);
            relativeLayout2.setLayoutParams(layoutParams2);
        }
        da();
        Z9();
        W9();
    }
}
