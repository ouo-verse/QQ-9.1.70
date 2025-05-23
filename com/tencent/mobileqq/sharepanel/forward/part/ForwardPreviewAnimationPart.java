package com.tencent.mobileqq.sharepanel.forward.part;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.sharepanel.forward.part.ForwardPreviewAnimationPart;
import com.tencent.mobileqq.sharepanel.fragment.DismissType;
import com.tencent.mobileqq.sharepanel.multiSelect.dialog.SelectedContactFragment;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00020\u0001:\u0001(B\u000f\u0012\u0006\u0010$\u001a\u00020#\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J,\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00072\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\fH\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001f\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/forward/part/ForwardPreviewAnimationPart;", "Lcom/tencent/mobileqq/sharepanel/forward/part/ForwardPreviewBasePart;", "", "Y9", "O9", "S9", "T9", "", "X9", "Lcom/tencent/mobileqq/sharepanel/fragment/DismissType;", "dismissType", "onlyAnimate", "Lkotlin/Function0;", "onEnd", "U9", "W9", "ba", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "D9", "f", "Landroid/view/View;", "panelContainer", tl.h.F, "maskView", "Landroid/view/animation/Animation;", "i", "Landroid/view/animation/Animation;", "showAnimation", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "dismissAnimation", "Lcom/tencent/mobileqq/sharepanel/forward/d;", "param", "<init>", "(Lcom/tencent/mobileqq/sharepanel/forward/d;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ForwardPreviewAnimationPart extends ForwardPreviewBasePart {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View panelContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View maskView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Animation showAnimation;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Animation dismissAnimation;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/forward/part/ForwardPreviewAnimationPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.sharepanel.forward.part.ForwardPreviewAnimationPart$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/sharepanel/forward/part/ForwardPreviewAnimationPart$b", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f287250e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f287251f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ DismissType f287252h;

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes18.dex */
        public /* synthetic */ class a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f287253a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33397);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 1)) {
                    redirector.redirect((short) 1);
                    return;
                }
                int[] iArr = new int[DismissType.values().length];
                try {
                    iArr[DismissType.CANCEL.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[DismissType.FORCE_CANCEL.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f287253a = iArr;
            }
        }

        b(Function0<Unit> function0, boolean z16, DismissType dismissType) {
            this.f287250e = function0;
            this.f287251f = z16;
            this.f287252h = dismissType;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ForwardPreviewAnimationPart.this, function0, Boolean.valueOf(z16), dismissType);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(DismissType dismissType, ForwardPreviewAnimationPart this$0) {
            Intrinsics.checkNotNullParameter(dismissType, "$dismissType");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            int i3 = a.f287253a[dismissType.ordinal()];
            if (i3 != 1 && i3 != 2) {
                this$0.A9();
            } else {
                this$0.z9();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                return;
            }
            QLog.d("ForwardPreviewAnimationPart", 1, "onDismissAnimationEnd");
            ForwardPreviewAnimationPart.this.dismissAnimation = null;
            Function0<Unit> function0 = this.f287250e;
            if (function0 != null) {
                function0.invoke();
            }
            if (this.f287251f) {
                return;
            }
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final DismissType dismissType = this.f287252h;
            final ForwardPreviewAnimationPart forwardPreviewAnimationPart = ForwardPreviewAnimationPart.this;
            uIHandlerV2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.sharepanel.forward.part.f
                @Override // java.lang.Runnable
                public final void run() {
                    ForwardPreviewAnimationPart.b.b(DismissType.this, forwardPreviewAnimationPart);
                }
            }, 30L);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/sharepanel/forward/part/ForwardPreviewAnimationPart$c", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f287254d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ForwardPreviewAnimationPart f287255e;

        c(View view, ForwardPreviewAnimationPart forwardPreviewAnimationPart) {
            this.f287254d = view;
            this.f287255e = forwardPreviewAnimationPart;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view, (Object) forwardPreviewAnimationPart);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                return;
            }
            QLog.d("ForwardPreviewAnimationPart", 1, "onShowAnimationEnd");
            this.f287255e.showAnimation = null;
            this.f287255e.ba();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            } else {
                this.f287254d.setVisibility(0);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33415);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForwardPreviewAnimationPart(@NotNull com.tencent.mobileqq.sharepanel.forward.d param) {
        super(param);
        Intrinsics.checkNotNullParameter(param, "param");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) param);
        }
    }

    private final void O9() {
        View view;
        final ImageView imageView;
        View partRootView = getPartRootView();
        if (partRootView != null) {
            partRootView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.sharepanel.forward.part.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ForwardPreviewAnimationPart.P9(ForwardPreviewAnimationPart.this, view2);
                }
            });
        }
        View partRootView2 = getPartRootView();
        View view2 = null;
        if (partRootView2 != null) {
            view = partRootView2.findViewById(R.id.yey);
        } else {
            view = null;
        }
        this.panelContainer = view;
        View partRootView3 = getPartRootView();
        if (partRootView3 != null) {
            view2 = partRootView3.findViewById(R.id.t6c);
        }
        this.maskView = view2;
        View partRootView4 = getPartRootView();
        if (partRootView4 != null && (imageView = (ImageView) partRootView4.findViewById(R.id.dum)) != null) {
            com.tencent.mobileqq.sharepanel.util.c cVar = com.tencent.mobileqq.sharepanel.util.c.f287601a;
            Context context = imageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "this.context");
            imageView.setImageDrawable(cVar.a(context));
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.sharepanel.forward.part.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    ForwardPreviewAnimationPart.Q9(ForwardPreviewAnimationPart.this, imageView, view3);
                }
            });
            com.tencent.mobileqq.sharepanel.ioc.f fVar = com.tencent.mobileqq.sharepanel.ioc.f.f287347a;
            com.tencent.mobileqq.sharepanel.ioc.f.k(fVar, imageView, "em_share_close", null, 4, null);
            com.tencent.mobileqq.sharepanel.ioc.f.h(fVar, imageView, "em_share_close", null, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(ForwardPreviewAnimationPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.x9(false);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(ForwardPreviewAnimationPart this$0, ImageView this_apply, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this$0.x9(true);
        com.tencent.mobileqq.sharepanel.ioc.f.e(com.tencent.mobileqq.sharepanel.ioc.f.f287347a, this_apply, "em_share_close", null, 4, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void S9() {
        View view = this.panelContainer;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = (int) (ViewUtils.getScreenHeight() * 0.15d);
            view.setLayoutParams(marginLayoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T9() {
        final Activity activity = getActivity();
        if (activity != null) {
            U9(DismissType.DISMISS, true, new Function0<Unit>(activity, this) { // from class: com.tencent.mobileqq.sharepanel.forward.part.ForwardPreviewAnimationPart$showSelectedContactListDialog$1$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Activity $it;
                final /* synthetic */ ForwardPreviewAnimationPart this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$it = activity;
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity, (Object) this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    SelectedContactFragment selectedContactFragment = new SelectedContactFragment();
                    Activity activity2 = this.$it;
                    final ForwardPreviewAnimationPart forwardPreviewAnimationPart = this.this$0;
                    Bundle bundle = new Bundle();
                    bundle.putInt("panel_height", DisplayUtil.getScreenHeight(activity2) / 2);
                    bundle.putParcelableArrayList("selected_contact_list", forwardPreviewAnimationPart.B9().c());
                    selectedContactFragment.setArguments(bundle);
                    selectedContactFragment.Kh(new Function0<Unit>() { // from class: com.tencent.mobileqq.sharepanel.forward.part.ForwardPreviewAnimationPart$showSelectedContactListDialog$1$1$fragment$1$2
                        static IPatchRedirector $redirector_;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ForwardPreviewAnimationPart.this);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                ForwardPreviewAnimationPart.this.X9();
                            } else {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                    try {
                        Activity activity3 = this.$it;
                        Intrinsics.checkNotNull(activity3, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                        ((FragmentActivity) activity3).getSupportFragmentManager().beginTransaction().add(selectedContactFragment, "ForwardPreviewAnimationPart").commitAllowingStateLoss();
                    } catch (Exception e16) {
                        QLog.e("ForwardPreviewAnimationPart", 1, "showInternal error: ", e16);
                    }
                }
            });
        }
    }

    private final boolean U9(DismissType dismissType, boolean onlyAnimate, Function0<Unit> onEnd) {
        View view = this.panelContainer;
        boolean z16 = false;
        if (view == null || view.getHeight() <= 0) {
            return false;
        }
        Animation animation = this.dismissAnimation;
        if (animation != null && animation.hasStarted()) {
            z16 = true;
        }
        if (z16) {
            return true;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, view.getHeight());
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.5f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setFillAfter(true);
        he0.b.l(animationSet, R.anim.f154974uh);
        animationSet.setAnimationListener(new b(onEnd, onlyAnimate, dismissType));
        view.startAnimation(animationSet);
        this.dismissAnimation = animationSet;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ boolean V9(ForwardPreviewAnimationPart forwardPreviewAnimationPart, DismissType dismissType, boolean z16, Function0 function0, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            function0 = null;
        }
        return forwardPreviewAnimationPart.U9(dismissType, z16, function0);
    }

    private final void W9() {
        View view = this.maskView;
        if (view != null) {
            view.setBackgroundResource(R.drawable.qui_common_overlay_dark_bg);
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setDuration(100L);
        View view2 = this.maskView;
        if (view2 != null) {
            view2.startAnimation(alphaAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean X9() {
        boolean z16;
        View view = this.panelContainer;
        if (view == null) {
            return false;
        }
        if (view.getHeight() <= 0) {
            view.setVisibility(0);
            return false;
        }
        Animation animation = this.showAnimation;
        if (animation != null && animation.hasStarted()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            view.setVisibility(0);
            return true;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, view.getHeight(), 0.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        he0.b.l(animationSet, R.anim.f154977uk);
        animationSet.setFillAfter(true);
        animationSet.setAnimationListener(new c(view, this));
        view.startAnimation(animationSet);
        this.showAnimation = animationSet;
        return true;
    }

    private final void Y9() {
        View view = this.panelContainer;
        if (view != null) {
            view.setVisibility(4);
            view.post(new Runnable() { // from class: com.tencent.mobileqq.sharepanel.forward.part.b
                @Override // java.lang.Runnable
                public final void run() {
                    ForwardPreviewAnimationPart.Z9(ForwardPreviewAnimationPart.this);
                }
            });
        }
        if (B9().d().c() && this.maskView != null) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.sharepanel.forward.part.c
                @Override // java.lang.Runnable
                public final void run() {
                    ForwardPreviewAnimationPart.aa(ForwardPreviewAnimationPart.this);
                }
            }, 30L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(ForwardPreviewAnimationPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.X9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(ForwardPreviewAnimationPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.W9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ba() {
        DialogFragment dialogFragment;
        Dialog dialog;
        Window window;
        Object partHost = getPartHost();
        if (partHost instanceof DialogFragment) {
            dialogFragment = (DialogFragment) partHost;
        } else {
            dialogFragment = null;
        }
        if (dialogFragment != null && (dialog = dialogFragment.getDialog()) != null && (window = dialog.getWindow()) != null) {
            QUIImmersiveHelper.u(window, true, true);
        }
    }

    @Override // com.tencent.mobileqq.sharepanel.forward.part.ForwardPreviewBasePart
    public boolean D9(@NotNull DismissType dismissType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) dismissType)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(dismissType, "dismissType");
        return V9(this, dismissType, false, null, 6, null);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) configuration);
        } else {
            super.onConfigurationChanged(configuration);
            S9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        O9();
        Y9();
        IPartHost partHost = getPartHost();
        if (partHost != null) {
            LiveData<Boolean> N1 = C9().N1();
            LifecycleOwner lifecycleOwner = partHost.getLifecycleOwner();
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.sharepanel.forward.part.ForwardPreviewAnimationPart$onInitView$1$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ForwardPreviewAnimationPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean it) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    if (it.booleanValue()) {
                        ForwardPreviewAnimationPart.this.T9();
                    }
                }
            };
            N1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.sharepanel.forward.part.a
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ForwardPreviewAnimationPart.R9(Function1.this, obj);
                }
            });
        }
        S9();
    }
}
