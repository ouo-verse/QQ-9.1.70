package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pymk.api.IPYMKSwitchAGuideApi;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.DarkModeManager;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import com.tencent.theme.SkinnableActivityProcesser;
import com.tencent.util.TokenResUtils;
import com.tencent.widget.SwipRightMenuBuilder;
import com.tencent.widget.SwipTextViewMenuBuilder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SimpleModeHelper {

    /* renamed from: a, reason: collision with root package name */
    private static Boolean f307327a;

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f307328b = {R.drawable.skin_drawable_ff5967, R.drawable.cj9, R.drawable.f160580ms0, R.drawable.f160580ms0, R.drawable.skin_drawable_ff8d40, R.drawable.skin_drawable_ff8d40, R.drawable.cj9, R.drawable.f160580ms0, R.drawable.f160580ms0, R.drawable.cjb, R.drawable.mry, R.drawable.f160582ms2, R.drawable.skin_drawable_ff5967, R.drawable.f160582ms2};

    /* renamed from: c, reason: collision with root package name */
    static boolean f307329c = false;

    /* renamed from: d, reason: collision with root package name */
    static boolean f307330d = false;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f307331e = false;

    /* renamed from: f, reason: collision with root package name */
    public static String f307332f = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EditText f307337d;

        a(EditText editText) {
            this.f307337d = editText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            this.f307337d.setCursorVisible(true);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public static boolean A() {
        return QQTheme.isNowThemeIsNight();
    }

    public static boolean B() {
        return QQTheme.isNowSimpleUI();
    }

    public static boolean C() {
        if (f307327a == null) {
            f307327a = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("tab_host_divider_switch_9.0_887617015", true));
        }
        QLog.i("SimpleModeHelper", 1, "needShowTabHostDivider, sDividerSwitch:" + f307327a);
        if (f307327a.booleanValue()) {
            if ((QQTheme.isNowSimpleUI() && !QQTheme.isNowThemeIsNight()) || QQTheme.isDefaultTheme() || QQTheme.isNowThemeDefaultNight()) {
                return true;
            }
            return false;
        }
        if (QQTheme.isNowSimpleUI() && !QQTheme.isNowThemeIsNight()) {
            return true;
        }
        return false;
    }

    public static void D(View view) {
        if (view == null || view.getContext() == null) {
            return;
        }
        view.setBackgroundColor(view.getResources().getColor(R.color.skin_color_ffe6e6e6));
    }

    private static void E(final ViewGroup viewGroup, final SkinnableActivityProcesser skinnableActivityProcesser, final Conversation conversation) {
        QLog.d("SimpleModeHelper", 1, "start check ui");
        if (viewGroup != null && skinnableActivityProcesser != null && conversation != null) {
            if (!z()) {
                QLog.d("SimpleModeHelper", 1, "checkInitUI switch off");
            } else {
                if (!w(viewGroup)) {
                    QLog.d("SimpleModeHelper", 1, "ui state is right");
                    return;
                }
                QLog.d("SimpleModeHelper", 1, "checkInitUI has system bitmap drawable");
                final AtomicInteger atomicInteger = new AtomicInteger();
                ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.utils.SimpleModeHelper.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (atomicInteger.getAndIncrement() > 2) {
                            QLog.d("SimpleModeHelper", 1, "retry three times");
                            return;
                        }
                        try {
                            skinnableActivityProcesser.update(new Intent());
                            conversation.refreshRecentList(0L);
                        } catch (Exception e16) {
                            QLog.d("SimpleModeHelper", 1, "fix error background error : ", e16);
                        }
                        if (!SimpleModeHelper.w(viewGroup)) {
                            return;
                        }
                        QLog.d("SimpleModeHelper", 1, "retry update");
                        ThreadManager.getUIHandler().postDelayed(this, 1000L);
                    }
                }, 1000L);
            }
        }
    }

    public static void F() {
        int i3;
        int i16;
        String str;
        int i17 = 1;
        if (!f307331e) {
            QLog.i("SimpleModeHelper", 1, "reportNightMode return 0");
            return;
        }
        f307331e = false;
        f307332f = "";
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date());
        if (!QQTheme.isDefaultTheme() && !QQTheme.isNowThemeDefaultNight()) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        if (QQTheme.isNowThemeIsNight()) {
            i16 = i3;
            i17 = 2;
        } else {
            if (QQTheme.isCustomTheme(f307332f)) {
                i3 = 3;
            }
            i16 = i3;
        }
        if (DarkModeManager.f()) {
            str = "1";
        } else {
            str = "0";
        }
        String str2 = str;
        ReportController.o(null, "dc00898", "", "", "0X800C0D2", "0X800C0D2", i16, 0, str2, "", format, "");
        ReportController.o(null, "dc00898", "", "", "0X800C0D7", "0X800C0D7", i17, 0, str2, "", format, "");
    }

    public static View b(ViewGroup viewGroup, View view) {
        ViewGroup viewGroup2;
        if (viewGroup == null) {
            return view;
        }
        if (C()) {
            if (view == null) {
                Context context = viewGroup.getContext();
                if (context == null || viewGroup.findViewById(com.tencent.mobileqq.util.af.f()) == null || (viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.b9o)) == null) {
                    return null;
                }
                View view2 = new View(context);
                view2.setBackgroundColor(context.getResources().getColor(R.color.qui_common_border_light));
                view2.setId(R.id.f916655s);
                viewGroup.removeView(view2);
                viewGroup2.addView(view2);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, 1);
                layoutParams.gravity = 80;
                layoutParams.bottomMargin = com.tencent.mobileqq.util.x.c(context, 54.0f);
                view2.setLayoutParams(layoutParams);
                com.tencent.mobileqq.qui.b.f276860a.a(view2, RFWNavigationBarImmersiveHelper.ImmersiveType.ABOVE);
                view = view2;
            }
            view.setVisibility(0);
        } else if (view != null) {
            view.setVisibility(8);
        }
        return view;
    }

    public static void c(ViewGroup viewGroup, SkinnableActivityProcesser skinnableActivityProcesser, Conversation conversation) {
        E(viewGroup, skinnableActivityProcesser, conversation);
    }

    private static boolean d(com.tencent.mobileqq.widget.l lVar) {
        Drawable.ConstantState constantState = lVar.getConstantState();
        if (!(constantState instanceof DrawableContainer.DrawableContainerState)) {
            return false;
        }
        DrawableContainer.DrawableContainerState drawableContainerState = (DrawableContainer.DrawableContainerState) constantState;
        int childCount = drawableContainerState.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            Drawable child = drawableContainerState.getChild(i3);
            if ((child instanceof BitmapDrawable) || (child instanceof NinePatchDrawable)) {
                return true;
            }
            if ((child instanceof com.tencent.mobileqq.widget.l) && d((com.tencent.mobileqq.widget.l) child)) {
                return true;
            }
        }
        return false;
    }

    public static int e(boolean z16, boolean z17) {
        if (z17) {
            if (z16) {
                if (TokenResUtils.useSimpleBubble()) {
                    return R.drawable.skin_aio_user_bubble_pressed_simple;
                }
                return R.drawable.skin_aio_user_bubble_pressed;
            }
            if (TokenResUtils.useSimpleBubble()) {
                return R.drawable.skin_aio_friend_bubble_pressed_simple;
            }
            return R.drawable.skin_aio_friend_bubble_pressed;
        }
        if (z16) {
            if (TokenResUtils.useSimpleBubble()) {
                return R.drawable.skin_aio_user_bubble_nor_simple;
            }
            return R.drawable.skin_aio_user_bubble_nor;
        }
        if (TokenResUtils.useSimpleBubble()) {
            return R.drawable.skin_aio_friend_bubble_nor_simple;
        }
        return R.drawable.skin_aio_friend_bubble_nor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static com.tencent.mobileqq.widget.q f(CommonRefreshLayout commonRefreshLayout) {
        com.tencent.mobileqq.widget.q qVar = (com.tencent.mobileqq.widget.q) View.inflate(commonRefreshLayout.getContext(), R.layout.e4h, null);
        qVar.setHeaderBgDrawable(null);
        qVar.j(19, new Object());
        commonRefreshLayout.x((ViewGroup) qVar);
        return qVar;
    }

    public static int g() {
        if (!QQTheme.isNowSimpleUI()) {
            return SimpleUIUtil.getSimpleUIPref();
        }
        String currentThemeId = QQTheme.getCurrentThemeId();
        try {
            int parseInt = Integer.parseInt(currentThemeId);
            int i3 = 0;
            while (true) {
                int[] iArr = ThemeConstants.THEME_IDS;
                if (i3 >= iArr.length) {
                    break;
                }
                if (parseInt == iArr[i3]) {
                    return i3;
                }
                i3++;
            }
        } catch (NumberFormatException e16) {
            QLog.d("SimpleModeHelper", 1, "parse theme id to int error, theme id ", currentThemeId, " error : ", e16);
        }
        return 0;
    }

    public static void h(View view) {
        if (view != null && view.getContext() != null && !B()) {
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            int dpToPx = ViewUtils.dpToPx(4.0f);
            view.setPadding(Math.max(0, paddingLeft - dpToPx), view.getPaddingTop(), Math.max(0, paddingRight - dpToPx), view.getPaddingBottom());
            view.invalidate();
        }
    }

    public static void i(Button button) {
        Resources resources;
        if (!B() || button == null || (resources = button.getResources()) == null) {
            return;
        }
        button.setBackground(resources.getDrawable(R.drawable.common_btn_blue));
    }

    public static void j(boolean z16, View view, int i3) {
        int i16;
        View findViewById = view.findViewById(R.id.ujq);
        if (z16) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        findViewById.setVisibility(i16);
    }

    public static void k(boolean z16, View view) {
        int i3;
        View findViewById = view.findViewById(R.id.uji);
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        findViewById.setVisibility(i3);
        if (QQTheme.isNowThemeIsNight()) {
            view.findViewById(R.id.ujj).setBackgroundColor(-16777216);
            view.findViewById(R.id.ujq).setBackgroundColor(Color.parseColor("#333333"));
        } else {
            view.findViewById(R.id.ujj).setBackgroundColor(-1);
            view.findViewById(R.id.ujq).setBackgroundColor(Color.parseColor("#E6E6E6"));
        }
    }

    public static void l(LinearLayout linearLayout, boolean z16, int i3) {
        u(z16, i3, linearLayout.findViewById(R.id.ixi));
        View findViewById = linearLayout.findViewById(R.id.f7j);
        View findViewById2 = linearLayout.findViewById(R.id.f103145zt);
        if (findViewById2 != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) findViewById2.getLayoutParams();
            if (z16) {
                i3 = 0;
            }
            marginLayoutParams.bottomMargin = i3;
            marginLayoutParams.topMargin = 0;
            return;
        }
        if (findViewById != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) findViewById.getLayoutParams();
            if (z16) {
                i3 = 0;
            }
            marginLayoutParams2.bottomMargin = i3;
            marginLayoutParams2.topMargin = 0;
        }
    }

    public static void m(SwipRightMenuBuilder swipRightMenuBuilder) {
        if (swipRightMenuBuilder instanceof SwipTextViewMenuBuilder) {
            if (B()) {
                ((SwipTextViewMenuBuilder) swipRightMenuBuilder).setMENU_BG_IDS(f307328b);
            } else {
                ((SwipTextViewMenuBuilder) swipRightMenuBuilder).setMENU_BG_IDS(com.tencent.mobileqq.activity.recent.j.f185634d);
            }
        }
    }

    public static void n(TextView textView) {
        if (!B() || textView == null || textView.getResources() == null) {
            return;
        }
        textView.setTextSize(2, 16.0f);
    }

    public static void o(TextView textView, TextView textView2, ImageView imageView, ViewGroup.LayoutParams layoutParams) {
        if (imageView == null || !B()) {
            return;
        }
        Context context = imageView.getContext();
        imageView.setImageResource(R.drawable.forward_dialog_file_arrow_normal);
        int c16 = com.tencent.mobileqq.util.x.c(context, 16.0f);
        int c17 = com.tencent.mobileqq.util.x.c(context, 16.0f);
        layoutParams.width = c16;
        layoutParams.height = c17;
        ColorStateList colorStateList = context.getResources().getColorStateList(R.color.skin_color_ff999999);
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
        if (textView2 != null) {
            textView2.setTextColor(colorStateList);
        }
    }

    public static void p(View view) {
        if (!A() || view == null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.idy);
        TextView textView = (TextView) view.findViewById(R.id.kfu);
        View findViewById = view.findViewById(R.id.biw);
        ImageView imageView = (ImageView) view.findViewById(R.id.did);
        Context context = view.getContext();
        if (context == null || relativeLayout == null || textView == null || findViewById == null) {
            return;
        }
        float dip2px = ViewUtils.dip2px(8.0f);
        findViewById.setBackgroundColor(MiniChatConstants.COLOR_SELECTED_NIGHT);
        textView.setTextColor(-1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(MiniChatConstants.COLOR_SELECTED_NIGHT);
        gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dip2px, dip2px, dip2px, dip2px});
        view.setBackgroundDrawable(gradientDrawable);
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.leftMargin = 0;
            layoutParams2.rightMargin = 0;
        }
        int dip2px2 = ViewUtils.dip2px(16.0f);
        relativeLayout.setPadding(dip2px2, 0, dip2px2, 0);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(MiniChatConstants.COLOR_NIGHT);
        gradientDrawable2.setCornerRadii(new float[]{dip2px, dip2px, dip2px, dip2px, 0.0f, 0.0f, 0.0f, 0.0f});
        relativeLayout.setBackgroundDrawable(gradientDrawable2);
        ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
        layoutParams3.height = ViewUtils.dip2px(23.0f);
        layoutParams3.width = ViewUtils.dip2px(11.0f);
        imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.jnq));
    }

    public static void q(View view) {
        if (view == null) {
            return;
        }
        if (A()) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, new ColorDrawable(MiniChatConstants.COLOR_NIGHT));
            stateListDrawable.addState(new int[0], new ColorDrawable(0));
            view.setBackgroundDrawable(stateListDrawable);
            return;
        }
        com.tencent.mobileqq.util.dd.a(view, R.drawable.f160746ms);
    }

    private static void r(ImageView imageView) {
        if (imageView == null) {
            return;
        }
        if (!B() && !TokenResUtils.useTokenRes2()) {
            return;
        }
        Context context = imageView.getContext();
        imageView.setImageResource(TokenResUtils.getTokenRes2(R.drawable.forward_dialog_file_arrow_normal, R.drawable.jae));
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int c16 = com.tencent.mobileqq.util.x.c(context, 16.0f);
        int c17 = com.tencent.mobileqq.util.x.c(context, 16.0f);
        layoutParams.width = c16;
        layoutParams.height = c17;
    }

    public static void s(TextView textView, ImageView imageView, ViewGroup.LayoutParams layoutParams) {
        if (imageView == null) {
            return;
        }
        if (!B() && !TokenResUtils.useTokenRes2()) {
            return;
        }
        Context context = imageView.getContext();
        imageView.setImageResource(TokenResUtils.getTokenRes2(R.drawable.forward_dialog_file_arrow_normal, R.drawable.jae));
        int c16 = com.tencent.mobileqq.util.x.c(context, 16.0f);
        int c17 = com.tencent.mobileqq.util.x.c(context, 16.0f);
        layoutParams.width = c16;
        layoutParams.height = c17;
        if (textView != null) {
            textView.setTextColor(context.getResources().getColorStateList(R.color.skin_color_ff999999));
        }
    }

    public static void t(View view, View view2) {
        Context context;
        if (view == null || view2 == null || (context = view.getContext()) == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
        if (B()) {
            layoutParams.leftMargin = com.tencent.mobileqq.util.x.c(context, 8.0f);
            layoutParams.bottomMargin = com.tencent.mobileqq.util.x.c(context, 2.0f);
            layoutParams2.height = (int) context.getResources().getDimension(R.dimen.d6b);
        } else {
            layoutParams.leftMargin = com.tencent.mobileqq.util.x.c(context, 0.0f);
            layoutParams.bottomMargin = com.tencent.mobileqq.util.x.c(context, 1.0f);
            layoutParams2.height = (int) context.getResources().getDimension(R.dimen.ad9);
            h(view2);
        }
    }

    public static void u(boolean z16, int i3, View view) {
        if (view != null) {
            boolean isAbleToShowPYMKGuide = ((IPYMKSwitchAGuideApi) QRoute.api(IPYMKSwitchAGuideApi.class)).isAbleToShowPYMKGuide();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (isAbleToShowPYMKGuide || z16) {
                i3 = 0;
            }
            marginLayoutParams.bottomMargin = i3;
        }
    }

    public static void v(boolean z16, View view) {
        if (view == null) {
            return;
        }
        if (z16) {
            view.setVisibility(8);
        } else if (C()) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean w(View view) {
        Drawable background = view.getBackground();
        if ((background instanceof BitmapDrawable) || (background instanceof NinePatchDrawable)) {
            return true;
        }
        if ((background instanceof com.tencent.mobileqq.widget.l) && d((com.tencent.mobileqq.widget.l) background)) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                if (w(viewGroup.getChildAt(i3))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static View x(View view) {
        BaseApplication context;
        if (view == null || (context = BaseApplication.getContext()) == null) {
            return null;
        }
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup)) {
            return null;
        }
        View view2 = new View(context);
        view2.setBackgroundColor(context.getResources().getColor(R.color.skin_color_ffe6e6e6));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, 1);
        layoutParams.addRule(3, view.getId());
        ((ViewGroup) parent).addView(view2, layoutParams);
        view2.setVisibility(8);
        return view2;
    }

    public static void y(QQCustomDialog qQCustomDialog) {
        Context context;
        Resources resources;
        View findViewById;
        if (qQCustomDialog == null || (resources = (context = qQCustomDialog.getContext()).getResources()) == null) {
            return;
        }
        View findViewById2 = qQCustomDialog.findViewById(R.id.vdy);
        if (findViewById2 == null) {
            findViewById = qQCustomDialog.findViewById(R.id.bja);
        } else {
            findViewById = findViewById2.findViewById(R.id.bja);
        }
        if (findViewById == null) {
            return;
        }
        r((ImageView) findViewById.findViewById(R.id.dia));
        if (!QQTheme.isNowSimpleUI() && !QQTheme.isNowThemeIsNight()) {
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(resources.getColor(R.color.skin_color_white));
        gradientDrawable.setCornerRadius(com.tencent.mobileqq.util.x.c(context, 4.0f));
        findViewById.setBackgroundDrawable(gradientDrawable);
        LinearLayout linearLayout = (LinearLayout) findViewById.findViewById(R.id.dmo);
        if (linearLayout != null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(resources.getColor(R.color.skin_color_forward_dialog_new_version_editbox_bg));
            gradientDrawable2.setCornerRadius(com.tencent.mobileqq.util.x.c(context, 4.0f));
            linearLayout.setBackgroundDrawable(gradientDrawable2);
        }
        View findViewById3 = findViewById.findViewById(R.id.mah);
        if (findViewById3 != null) {
            findViewById3.setBackgroundColor(resources.getColor(R.color.skin_color_forward_dialog_divider));
        }
        View findViewById4 = findViewById.findViewById(R.id.biw);
        if (findViewById4 != null) {
            findViewById4.setBackgroundColor(resources.getColor(R.color.skin_color_forward_dialog_divider));
        }
        EditText editText = (EditText) findViewById.findViewById(R.id.input);
        if (editText != null) {
            editText.setHintTextColor(resources.getColor(R.color.skin_color_ffcccccc));
            editText.setTextColor(resources.getColor(R.color.skin_input_theme_version2));
            editText.setPadding(com.tencent.mobileqq.util.x.c(context, 11.0f), editText.getPaddingTop(), editText.getPaddingRight(), editText.getPaddingBottom());
            editText.setTextSize(2, 13.0f);
            editText.setCursorVisible(false);
            editText.setOnClickListener(new a(editText));
        }
        TextView textView = (TextView) findViewById.findViewById(R.id.kfu);
        if (textView != null) {
            textView.setTextColor(resources.getColor(R.color.skin_color_ff000000));
        }
        TextView textView2 = (TextView) findViewById.findViewById(R.id.kfr);
        if (textView2 != null) {
            textView2.setTextColor(resources.getColor(R.color.skin_color_ff000000));
        }
        TextView textView3 = (TextView) findViewById.findViewById(R.id.dialogLeftBtn);
        if (textView3 != null) {
            textView3.setTextColor(resources.getColor(R.color.skin_color_ff000000));
            if (QQTheme.isNowThemeIsNight()) {
                com.tencent.mobileqq.util.dd.a(textView3, R.drawable.forward_dialog_new_btn_simple_night_bg);
            } else {
                com.tencent.mobileqq.util.dd.a(textView3, R.drawable.jnn);
            }
        }
        TextView textView4 = (TextView) findViewById.findViewById(R.id.dialogRightBtn);
        if (textView4 != null) {
            textView4.setTextColor(resources.getColor(R.color.skin_color_ff000000));
            if (QQTheme.isNowThemeIsNight()) {
                com.tencent.mobileqq.util.dd.a(textView4, R.drawable.forward_dialog_new_btn_simple_night_bg);
            } else {
                com.tencent.mobileqq.util.dd.a(textView4, R.drawable.jnn);
            }
        }
    }

    private static boolean z() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        return ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("fix_theme_error_switch_2");
    }
}
