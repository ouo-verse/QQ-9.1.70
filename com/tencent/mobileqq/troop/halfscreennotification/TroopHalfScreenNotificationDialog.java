package com.tencent.mobileqq.troop.halfscreennotification;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qui.dialog.QUICompatDialog;
import com.tencent.mobileqq.troop.utils.ad;
import com.tencent.mobileqq.troop.utils.h;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.listitem.ab;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.util.AnimateUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 92\u00020\u0001:\u0001:B;\u0012\u0006\u00105\u001a\u000204\u0012\b\u00106\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0018\u0010&\u001a\u0014\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00020\"\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u001a\u0010\f\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u001a\u0010\u0012\u001a\u00020\u00022\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0010H\u0002J\u0016\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\u0012\u0010 \u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0014J\u0006\u0010!\u001a\u00020\u0002R&\u0010&\u001a\u0014\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0017\u00100\u001a\u00020+8\u0006\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0016\u00103\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/troop/halfscreennotification/TroopHalfScreenNotificationDialog;", "Lcom/tencent/mobileqq/qui/dialog/QUICompatDialog;", "", "E0", "Landroid/view/Window;", "window", "J0", "d0", "Landroid/view/View;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/mobileqq/troop/halfscreennotification/a;", "data", "m0", "s0", "Landroid/view/animation/AnimationSet;", "l0", "Lkotlin/Function0;", "callback", "f0", "k0", "y0", "I0", "w0", "", "singleButton", "x0", "C0", "F0", "show", "dismiss", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "B0", "Lkotlin/Function2;", "Lcom/tencent/mobileqq/troop/halfscreennotification/b;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function2;", "clickListener", "Lts2/e;", "D", "Lts2/e;", "vb", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "j0", "()Landroid/widget/ImageView;", "headerImageView", UserInfo.SEX_FEMALE, "Z", "dismissing", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "logicParent", "<init>", "(Landroid/app/Activity;Landroid/view/View;Lcom/tencent/mobileqq/troop/halfscreennotification/a;Lkotlin/jvm/functions/Function2;)V", "G", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopHalfScreenNotificationDialog extends QUICompatDialog {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Function2<com.tencent.mobileqq.troop.halfscreennotification.b, Boolean, Unit> clickListener;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final ts2.e vb;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final ImageView headerImageView;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean dismissing;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0014\u0010\u0010\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0014\u0010\u0011\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u0014\u0010\u0014\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000eR\u0014\u0010\u0015\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000eR\u0014\u0010\u0016\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0007R\u0014\u0010\u0017\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0007R\u0014\u0010\u0018\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0007R\u0014\u0010\u0019\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u000e\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/troop/halfscreennotification/TroopHalfScreenNotificationDialog$a;", "", "", "ANIMATION_DURATION", "J", "", "BOTTOM_PADDING_WHEN_NO_NAV_BAR", UserInfo.SEX_FEMALE, "", "BTN_POSITION_FIRST", "I", "BTN_POSITION_SECOND", "", "BTN_TYPE", "Ljava/lang/String;", "BTN_TYPE_DOUBLE", "BTN_TYPE_SINGLE", "BUTTON_POSITION", "EM_GROUP_HALF_CLOSE_BTN", "EM_GROUP_HALF_SCREEN_NOTE", "EM_GROUP_JUMP_BTN", "GROUP_NOTICE_ID", "MASK_TRANSPARENCY", "MOVE_LENGTH", "ROUND_RADIUS", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.halfscreennotification.TroopHalfScreenNotificationDialog$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/troop/halfscreennotification/TroopHalfScreenNotificationDialog$b", "Lcom/tencent/util/AnimateUtils$AnimationAdapter;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationEnd", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends AnimateUtils.AnimationAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f296189d;

        b(Function0<Unit> function0) {
            this.f296189d = function0;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function0);
            }
        }

        @Override // com.tencent.util.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            } else {
                this.f296189d.invoke();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38391);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopHalfScreenNotificationDialog(@NotNull Activity activity, @Nullable View view, @NotNull a data, @NotNull Function2<? super com.tencent.mobileqq.troop.halfscreennotification.b, ? super Boolean, Unit> clickListener) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, view, data, clickListener);
            return;
        }
        this.clickListener = clickListener;
        ts2.e g16 = ts2.e.g(LayoutInflater.from(activity));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(activity))");
        this.vb = g16;
        ImageView imageView = g16.f437377e;
        Intrinsics.checkNotNullExpressionValue(imageView, "vb.headerImage");
        this.headerImageView = imageView;
        y0();
        I0(data);
        w0(data);
        E0();
        m0(view, data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(TroopHalfScreenNotificationDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ad adVar = ad.f302002a;
        ImageFilterView imageFilterView = this$0.vb.f437375c;
        Intrinsics.checkNotNullExpressionValue(imageFilterView, "vb.closeIcon");
        h.a.f(adVar, imageFilterView, null, null, null, 14, null);
        g0(this$0, null, 1, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void C0(final a data) {
        QUIButton setMainButton$lambda$20 = this.vb.f437378f;
        setMainButton$lambda$20.setText(data.e().a());
        Intrinsics.checkNotNullExpressionValue(setMainButton$lambda$20, "setMainButton$lambda$20");
        ab.d(setMainButton$lambda$20, ViewUtils.dpToPx(22.5f));
        setMainButton$lambda$20.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.halfscreennotification.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopHalfScreenNotificationDialog.D0(TroopHalfScreenNotificationDialog.this, data, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(final TroopHalfScreenNotificationDialog this$0, final a data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        ad adVar = ad.f302002a;
        QUIButton qUIButton = this$0.vb.f437378f;
        Intrinsics.checkNotNullExpressionValue(qUIButton, "vb.mainButton");
        h.a.f(adVar, qUIButton, null, null, null, 14, null);
        this$0.f0(new Function0<Unit>(data) { // from class: com.tencent.mobileqq.troop.halfscreennotification.TroopHalfScreenNotificationDialog$setMainButton$1$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ a $data;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$data = data;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopHalfScreenNotificationDialog.this, (Object) data);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Function2 function2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    function2 = TroopHalfScreenNotificationDialog.this.clickListener;
                    function2.invoke(this.$data.e(), Boolean.TRUE);
                }
            }
        });
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void E0() {
        Window window;
        View decorView;
        WindowInsets rootWindowInsets;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Activity i3 = KRCSSViewExtensionKt.i(context);
        if (i3 != null && (window = i3.getWindow()) != null && (decorView = window.getDecorView()) != null && (rootWindowInsets = decorView.getRootWindowInsets()) != null && rootWindowInsets.getSystemWindowInsetBottom() == 0) {
            this.vb.f437376d.setPadding(0, 0, 0, ViewUtils.dpToPx(16.0f));
        }
    }

    private final void F0(final a data) {
        if (data.g() == null) {
            return;
        }
        this.vb.f437381i.setVisibility(0);
        QUIButton qUIButton = this.vb.f437380h;
        qUIButton.setVisibility(0);
        qUIButton.setText(data.g().a());
        qUIButton.setBackgroundResource(R.drawable.lw_);
        qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.halfscreennotification.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopHalfScreenNotificationDialog.H0(TroopHalfScreenNotificationDialog.this, data, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(final TroopHalfScreenNotificationDialog this$0, final a data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        ad adVar = ad.f302002a;
        QUIButton qUIButton = this$0.vb.f437380h;
        Intrinsics.checkNotNullExpressionValue(qUIButton, "vb.secondButton");
        h.a.f(adVar, qUIButton, null, null, null, 14, null);
        this$0.f0(new Function0<Unit>(data) { // from class: com.tencent.mobileqq.troop.halfscreennotification.TroopHalfScreenNotificationDialog$setSecondButton$1$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ a $data;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$data = data;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopHalfScreenNotificationDialog.this, (Object) data);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Function2 function2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    function2 = TroopHalfScreenNotificationDialog.this.clickListener;
                    function2.invoke(this.$data.g(), Boolean.FALSE);
                }
            }
        });
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void I0(a data) {
        this.vb.f437383k.setText(data.h());
        this.vb.f437382j.setText(data.a());
    }

    private final Window J0(Window window) {
        window.setBackgroundDrawableResource(17170445);
        window.addFlags(1073741824);
        window.setType(1000);
        window.setDimAmount(0.0f);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        attributes.gravity = 81;
        attributes.y = 0;
        attributes.x = 0;
        attributes.windowAnimations = 0;
        window.setAttributes(attributes);
        return window;
    }

    private final void d0() {
        final int measuredWidth = this.vb.f437377e.getMeasuredWidth() / 2;
        if (measuredWidth == this.vb.f437377e.getMeasuredHeight()) {
            return;
        }
        this.vb.f437377e.post(new Runnable() { // from class: com.tencent.mobileqq.troop.halfscreennotification.f
            @Override // java.lang.Runnable
            public final void run() {
                TroopHalfScreenNotificationDialog.e0(TroopHalfScreenNotificationDialog.this, measuredWidth);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(TroopHalfScreenNotificationDialog this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = this$0.vb.f437377e;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.height = i3;
        imageView.setLayoutParams(layoutParams);
    }

    private final void f0(final Function0<Unit> callback) {
        QLog.i("TroopHalfScreenNotificationDialog", 1, "dismissed");
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.35f, 0.0f);
        ofFloat.setDuration(200L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.troop.halfscreennotification.n
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                TroopHalfScreenNotificationDialog.i0(TroopHalfScreenNotificationDialog.this, valueAnimator);
            }
        });
        ofFloat.start();
        this.vb.f437379g.startAnimation(k0(new Function0<Unit>(callback) { // from class: com.tencent.mobileqq.troop.halfscreennotification.TroopHalfScreenNotificationDialog$dismissWithAnimation$3
            static IPatchRedirector $redirector_;
            final /* synthetic */ Function0<Unit> $callback;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$callback = callback;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopHalfScreenNotificationDialog.this, (Object) callback);
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
                super/*com.tencent.mobileqq.qui.dialog.QUICompatDialog*/.dismiss();
                Function0<Unit> function0 = this.$callback;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        }));
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void g0(TroopHalfScreenNotificationDialog troopHalfScreenNotificationDialog, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function0 = null;
        }
        troopHalfScreenNotificationDialog.f0(function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(TroopHalfScreenNotificationDialog this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Window window = this$0.getWindow();
        if (window != null) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            window.setDimAmount(((Float) animatedValue).floatValue());
        }
    }

    private final AnimationSet k0(Function0<Unit> callback) {
        AnimationSet animationSet = new AnimationSet(true);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, ViewUtils.dpToPx(112.0f));
        translateAnimation.setAnimationListener(new b(callback));
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(new AlphaAnimation(1.0f, 0.0f));
        animationSet.setDuration(200L);
        return animationSet;
    }

    private final AnimationSet l0() {
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(new TranslateAnimation(0.0f, 0.0f, ViewUtils.dpToPx(112.0f), 0.0f));
        animationSet.addAnimation(new AlphaAnimation(0.0f, 1.0f));
        animationSet.setDuration(200L);
        return animationSet;
    }

    private final void m0(View parent, final a data) {
        int i3;
        ad adVar = ad.f302002a;
        RadiusFrameLayout mainPanel = this.vb.f437379g;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        IDynamicParams iDynamicParams = new IDynamicParams() { // from class: com.tencent.mobileqq.troop.halfscreennotification.i
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map n06;
                n06 = TroopHalfScreenNotificationDialog.n0(a.this, str);
                return n06;
            }
        };
        Intrinsics.checkNotNullExpressionValue(mainPanel, "mainPanel");
        adVar.a(mainPanel, "em_group_half_screen_note", exposurePolicy, clickPolicy, iDynamicParams, parent);
        ImageFilterView closeIcon = this.vb.f437375c;
        IDynamicParams iDynamicParams2 = new IDynamicParams() { // from class: com.tencent.mobileqq.troop.halfscreennotification.j
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map o06;
                o06 = TroopHalfScreenNotificationDialog.o0(a.this, str);
                return o06;
            }
        };
        Intrinsics.checkNotNullExpressionValue(closeIcon, "closeIcon");
        adVar.a(closeIcon, "em_group_half_close_btn", exposurePolicy, clickPolicy, iDynamicParams2, parent);
        if (data.g() == null) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        final int i16 = i3;
        QUIButton mainButton = this.vb.f437378f;
        IDynamicParams iDynamicParams3 = new IDynamicParams() { // from class: com.tencent.mobileqq.troop.halfscreennotification.k
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map p06;
                p06 = TroopHalfScreenNotificationDialog.p0(a.this, i16, str);
                return p06;
            }
        };
        Intrinsics.checkNotNullExpressionValue(mainButton, "mainButton");
        adVar.a(mainButton, "em_group_jump_btn", exposurePolicy, clickPolicy, iDynamicParams3, parent);
        if (data.g() != null) {
            QUIButton secondButton = this.vb.f437380h;
            IDynamicParams iDynamicParams4 = new IDynamicParams() { // from class: com.tencent.mobileqq.troop.halfscreennotification.l
                @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
                public final Map getDynamicParams(String str) {
                    Map q06;
                    q06 = TroopHalfScreenNotificationDialog.q0(a.this, i16, str);
                    return q06;
                }
            };
            Intrinsics.checkNotNullExpressionValue(secondButton, "secondButton");
            adVar.a(secondButton, "em_group_jump_btn", exposurePolicy, clickPolicy, iDynamicParams4, parent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map n0(a data, String str) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(data, "$data");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("group_notice_id", data.f()));
        return mapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map o0(a data, String str) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(data, "$data");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("group_notice_id", data.f()));
        return mapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map p0(a data, int i3, String str) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(data, "$data");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("group_notice_id", data.f()), TuplesKt.to("button_position", 1), TuplesKt.to("btn_type", Integer.valueOf(i3)));
        return mapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map q0(a data, int i3, String str) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(data, "$data");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("group_notice_id", data.f()), TuplesKt.to("button_position", 2), TuplesKt.to("btn_type", Integer.valueOf(i3)));
        return mapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(TroopHalfScreenNotificationDialog this$0, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.d0();
    }

    private final void s0() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 0.35f);
        ofFloat.setDuration(200L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.troop.halfscreennotification.h
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                TroopHalfScreenNotificationDialog.u0(TroopHalfScreenNotificationDialog.this, valueAnimator);
            }
        });
        ofFloat.start();
        this.vb.f437379g.setAnimation(l0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(TroopHalfScreenNotificationDialog this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Window window = this$0.getWindow();
        if (window != null) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            window.setDimAmount(((Float) animatedValue).floatValue());
        }
    }

    private final void w0(a data) {
        boolean z16;
        if (data.g() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        x0(z16);
        C0(data);
        F0(data);
    }

    private final void x0(boolean singleButton) {
        float f16;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i3;
        int i16;
        int i17;
        if (singleButton) {
            f16 = 64.0f;
        } else {
            f16 = 32.0f;
        }
        LinearLayout setButtonContainer$lambda$18 = this.vb.f437374b;
        Intrinsics.checkNotNullExpressionValue(setButtonContainer$lambda$18, "setButtonContainer$lambda$18");
        int dpToPx = ViewUtils.dpToPx(f16);
        ViewGroup.LayoutParams layoutParams = setButtonContainer$lambda$18.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = null;
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        int i18 = -2;
        if (marginLayoutParams == null) {
            ViewGroup.LayoutParams layoutParams2 = setButtonContainer$lambda$18.getLayoutParams();
            if (layoutParams2 != null) {
                i16 = layoutParams2.width;
            } else {
                i16 = -2;
            }
            ViewGroup.LayoutParams layoutParams3 = setButtonContainer$lambda$18.getLayoutParams();
            if (layoutParams3 != null) {
                i17 = layoutParams3.height;
            } else {
                i17 = -2;
            }
            marginLayoutParams = new ViewGroup.MarginLayoutParams(i16, i17);
        }
        if (dpToPx != marginLayoutParams.leftMargin) {
            marginLayoutParams.leftMargin = dpToPx;
            setButtonContainer$lambda$18.setLayoutParams(marginLayoutParams);
        }
        int dpToPx2 = ViewUtils.dpToPx(f16);
        ViewGroup.LayoutParams layoutParams4 = setButtonContainer$lambda$18.getLayoutParams();
        if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams4;
        }
        if (marginLayoutParams2 == null) {
            ViewGroup.LayoutParams layoutParams5 = setButtonContainer$lambda$18.getLayoutParams();
            if (layoutParams5 != null) {
                i3 = layoutParams5.width;
            } else {
                i3 = -2;
            }
            ViewGroup.LayoutParams layoutParams6 = setButtonContainer$lambda$18.getLayoutParams();
            if (layoutParams6 != null) {
                i18 = layoutParams6.height;
            }
            marginLayoutParams2 = new ViewGroup.MarginLayoutParams(i3, i18);
        }
        if (dpToPx2 != marginLayoutParams2.rightMargin) {
            marginLayoutParams2.rightMargin = dpToPx2;
            setButtonContainer$lambda$18.setLayoutParams(marginLayoutParams2);
        }
    }

    private final void y0() {
        this.vb.f437376d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.halfscreennotification.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopHalfScreenNotificationDialog.z0(TroopHalfScreenNotificationDialog.this, view);
            }
        });
        this.vb.f437375c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.halfscreennotification.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopHalfScreenNotificationDialog.A0(TroopHalfScreenNotificationDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(TroopHalfScreenNotificationDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        g0(this$0, null, 1, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void B0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.headerImageView.setImageDrawable(getContext().getResources().getDrawable(R.drawable.qui_common_fill_standard_primary_bg, getContext().getTheme()));
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            if (this.dismissing) {
                return;
            }
            this.dismissing = true;
            g0(this, null, 1, null);
        }
    }

    @NotNull
    public final ImageView j0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ImageView) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.headerImageView;
    }

    @Override // android.app.Dialog
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        setContentView(this.vb.getRoot());
        this.vb.getRoot().addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.troop.halfscreennotification.m
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                TroopHalfScreenNotificationDialog.r0(TroopHalfScreenNotificationDialog.this, view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        });
        ad adVar = ad.f302002a;
        RadiusFrameLayout radiusFrameLayout = this.vb.f437379g;
        Intrinsics.checkNotNullExpressionValue(radiusFrameLayout, "vb.mainPanel");
        adVar.f(radiusFrameLayout);
        Window window = getWindow();
        if (window == null) {
            return;
        }
        J0(window);
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            s0();
            super.show();
        }
    }
}
