package com.tencent.mobileqq.resconfig;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quicommon.a;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\b\u0016\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001c\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J.\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u000eH\u0016J\u0006\u0010\u0014\u001a\u00020\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/resconfig/MainResourceConfig;", "", "Landroid/content/Context;", "context", "", "o", "Landroid/graphics/drawable/Drawable;", QCircleDaTongConstant.ElementParamValue.XSJ_SHARE_PANEL_STYLE_OLD, "p", "l", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, h.F, "k", "", "isTop", "", c.f123400v, "forceNoCorner", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "<init>", "()V", "a", "QQActivity_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public class MainResourceConfig {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    private static final int f281249b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Lazy<MainResourceConfig> f281250c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Lazy<MainResourceConfig> f281251d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Lazy<MainResourceConfig> f281252e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final Lazy<Boolean> f281253f;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b5\u0010\"J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0007J\b\u0010\b\u001a\u00020\u0006H\u0007J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007J:\u0010\u0013\u001a\u00020\u000b2\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0007J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014R\u001b\u0010\u001c\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR!\u0010#\u001a\u00020\u001d8FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0019\u0012\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R!\u0010'\u001a\u00020\u001d8FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b$\u0010\u0019\u0012\u0004\b&\u0010\"\u001a\u0004\b%\u0010 R!\u0010+\u001a\u00020\u001d8FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b(\u0010\u0019\u0012\u0004\b*\u0010\"\u001a\u0004\b)\u0010 R\u0014\u0010-\u001a\u00020,8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00100\u001a\u00020/8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00103\u001a\u0002028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/resconfig/MainResourceConfig$a;", "", "Landroid/view/View;", "view", "Landroid/animation/ObjectAnimator;", "b", "", h.F, "i", "Landroid/widget/TextView;", "title", "", "j", "", "bottomTabList", "leftArea", "rightArea", "Landroid/animation/Animator$AnimatorListener;", "animListener", "a", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", "c", "i9000UiSwitch$delegate", "Lkotlin/Lazy;", "f", "()Z", "i9000UiSwitch", "Lcom/tencent/mobileqq/resconfig/MainResourceConfig;", "conversationConfig$delegate", "e", "()Lcom/tencent/mobileqq/resconfig/MainResourceConfig;", "getConversationConfig$annotations", "()V", "conversationConfig", "lebaConfig$delegate", "g", "getLebaConfig$annotations", "lebaConfig", "contactConfig$delegate", "d", "getContactConfig$annotations", "contactConfig", "", "DURATION", "J", "", "TAG", "Ljava/lang/String;", "", "TRANSLATE_X", UserInfo.SEX_FEMALE, "<init>", "QQActivity_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.resconfig.MainResourceConfig$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
                return;
            }
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) defaultConstructorMarker);
        }

        private final ObjectAnimator b(View view) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(view, c.f123400v, 0.0f, 1.0f).setDuration(300L);
            Intrinsics.checkNotNullExpressionValue(duration, "ofFloat(view, \"alpha\", 0\u20261f).setDuration(DURATION)");
            return duration;
        }

        private final boolean f() {
            return ((Boolean) MainResourceConfig.f281253f.getValue()).booleanValue();
        }

        @JvmStatic
        public final void a(@Nullable List<? extends View> bottomTabList, @Nullable View leftArea, @Nullable View rightArea, @Nullable Animator.AnimatorListener animListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, this, bottomTabList, leftArea, rightArea, animListener);
                return;
            }
            if (bottomTabList != null && leftArea != null && rightArea != null) {
                AnimatorSet animatorSet = new AnimatorSet();
                ArrayList arrayList = new ArrayList();
                for (View view : bottomTabList) {
                    if (view != null) {
                        view.setVisibility(0);
                        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationY", view.getHeight(), 0.0f).setDuration(300L);
                        Intrinsics.checkNotNullExpressionValue(duration, "ofFloat(view, \"translati\u20260f).setDuration(DURATION)");
                        arrayList.add(duration);
                        arrayList.add(b(view));
                    }
                }
                float a16 = x.a(50.0f);
                leftArea.setVisibility(0);
                ObjectAnimator duration2 = ObjectAnimator.ofFloat(leftArea, "translationX", -a16, 0.0f).setDuration(300L);
                Intrinsics.checkNotNullExpressionValue(duration2, "ofFloat(leftArea, \"trans\u20260f).setDuration(DURATION)");
                arrayList.add(duration2);
                arrayList.add(b(leftArea));
                rightArea.setVisibility(0);
                ObjectAnimator duration3 = ObjectAnimator.ofFloat(rightArea, "translationX", a16, 0.0f).setDuration(300L);
                Intrinsics.checkNotNullExpressionValue(duration3, "ofFloat(rightArea, \"tran\u20260f).setDuration(DURATION)");
                arrayList.add(duration3);
                arrayList.add(b(rightArea));
                animatorSet.addListener(animListener);
                animatorSet.playTogether(arrayList);
                animatorSet.start();
                QLog.i("MainResourceConfig", 1, "start90UIAnimation");
            }
        }

        @Nullable
        public final Drawable c(@Nullable Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (Drawable) iPatchRedirector.redirect((short) 11, (Object) this, (Object) context);
            }
            if (context != null) {
                if (QQTheme.isVasTheme()) {
                    return context.getDrawable(R.drawable.bg_texture);
                }
                return new ColorDrawable(context.getColor(R.color.qui_common_bg_bottom_brand));
            }
            return null;
        }

        @NotNull
        public final MainResourceConfig d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (MainResourceConfig) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return (MainResourceConfig) MainResourceConfig.f281252e.getValue();
        }

        @NotNull
        public final MainResourceConfig e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (MainResourceConfig) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return (MainResourceConfig) MainResourceConfig.f281250c.getValue();
        }

        @NotNull
        public final MainResourceConfig g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (MainResourceConfig) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return (MainResourceConfig) MainResourceConfig.f281251d.getValue();
        }

        @JvmStatic
        public final boolean h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            return f();
        }

        @JvmStatic
        public final boolean i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
            }
            if (h() && (QQTheme.isDefaultTheme() || QQTheme.isNowThemeDefaultNight())) {
                return true;
            }
            return false;
        }

        @JvmStatic
        public final void j(@Nullable TextView title) {
            RelativeLayout.LayoutParams layoutParams;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) title);
                return;
            }
            if (title == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = title.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                layoutParams = (RelativeLayout.LayoutParams) layoutParams2;
            } else {
                layoutParams = null;
            }
            if (layoutParams != null) {
                boolean i3 = MainResourceConfig.INSTANCE.i();
                if (!QQTheme.isNowSimpleUI() && !i3) {
                    layoutParams.addRule(13);
                    layoutParams.leftMargin = 0;
                } else {
                    layoutParams.removeRule(13);
                    layoutParams.leftMargin = title.getResources().getDimensionPixelSize(R.dimen.f159595dg3);
                }
                title.setLayoutParams(layoutParams);
            }
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
        Lazy<MainResourceConfig> lazy;
        Lazy<MainResourceConfig> lazy2;
        Lazy<MainResourceConfig> lazy3;
        Lazy<Boolean> lazy4;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33233);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
            return;
        }
        INSTANCE = new Companion(null);
        f281249b = ViewUtils.dpToPx(16.0f);
        lazy = LazyKt__LazyJVMKt.lazy(MainResourceConfig$Companion$conversationConfig$2.INSTANCE);
        f281250c = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(MainResourceConfig$Companion$lebaConfig$2.INSTANCE);
        f281251d = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(MainResourceConfig$Companion$contactConfig$2.INSTANCE);
        f281252e = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(MainResourceConfig$Companion$i9000UiSwitch$2.INSTANCE);
        f281253f = lazy4;
    }

    public MainResourceConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void e(@Nullable List<? extends View> list, @Nullable View view, @Nullable View view2, @Nullable Animator.AnimatorListener animatorListener) {
        INSTANCE.a(list, view, view2, animatorListener);
    }

    @NotNull
    public static final MainResourceConfig f() {
        return INSTANCE.d();
    }

    @NotNull
    public static final MainResourceConfig g() {
        return INSTANCE.e();
    }

    @NotNull
    public static final MainResourceConfig i() {
        return INSTANCE.g();
    }

    @JvmStatic
    public static final boolean r() {
        return INSTANCE.i();
    }

    @JvmStatic
    public static final void s(@Nullable TextView textView) {
        INSTANCE.j(textView);
    }

    public int h(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) context)).intValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getResources().getDimensionPixelSize(R.dimen.title_bar_height);
    }

    public final boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("chats_login_barrier_9000_887617013", false);
    }

    @Nullable
    public Drawable k(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Drawable) iPatchRedirector.redirect((short) 8, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (QQTheme.isVasTheme()) {
            return context.getDrawable(R.drawable.bg_texture_theme_version2);
        }
        return new ColorDrawable(context.getColor(R.color.qui_common_bg_bottom_standard));
    }

    @Nullable
    public Drawable l(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Drawable) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (INSTANCE.i()) {
            return new ColorDrawable(o(context));
        }
        return ContextCompat.getDrawable(context, R.drawable.qui_common_fill_light_primary_bg);
    }

    @Nullable
    public Drawable m(@NotNull Context context, boolean isTop, float alpha, boolean forceNoCorner) {
        float f16;
        boolean z16;
        int o16;
        float f17;
        boolean z17;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Drawable) iPatchRedirector.redirect((short) 9, this, context, Boolean.valueOf(isTop), Float.valueOf(alpha), Boolean.valueOf(forceNoCorner));
        }
        Intrinsics.checkNotNullParameter(context, "context");
        int color = context.getColor(R.color.qui_common_fill_light_primary);
        if (isTop) {
            int o17 = o(context);
            int a16 = a.a(color, context.getColor(R.color.qui_common_overlay_light));
            if (INSTANCE.i()) {
                if (forceNoCorner) {
                    f17 = 0.0f;
                } else {
                    f17 = f281249b;
                }
                com.tencent.qqnt.util.c cVar = com.tencent.qqnt.util.c.f362979a;
                int[] iArr = {a16};
                if (alpha == 0.0f) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    i3 = 0;
                } else {
                    i3 = (((int) (alpha * 255.0f)) << 24) | o17;
                }
                return cVar.a(iArr, i3, new float[]{f17, f17, f17, f17, 0.0f, 0.0f, 0.0f, 0.0f});
            }
            return new ColorDrawable(a16);
        }
        if (INSTANCE.i()) {
            if (forceNoCorner) {
                f16 = 0.0f;
            } else {
                f16 = f281249b;
            }
            com.tencent.qqnt.util.c cVar2 = com.tencent.qqnt.util.c.f362979a;
            int[] iArr2 = {color};
            if (alpha == 0.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                o16 = 0;
            } else {
                o16 = o(context) | (((int) (alpha * 255.0f)) << 24);
            }
            return cVar2.a(iArr2, o16, new float[]{f16, f16, f16, f16, 0.0f, 0.0f, 0.0f, 0.0f});
        }
        return new ColorDrawable(color);
    }

    public int n(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context)).intValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return ImmersiveUtils.getStatusBarHeight(context);
    }

    public final int o(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context)).intValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getColor(R.color.qui_common_bg_nav_primary);
    }

    @Nullable
    public Drawable p(@NotNull Context context, @Nullable Drawable old) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Drawable) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) old);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return ContextCompat.getDrawable(context, R.drawable.qui_bg_nav_primary);
    }

    public int q(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context)).intValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return h(context) + n(context);
    }
}
