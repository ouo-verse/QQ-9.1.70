package com.tencent.mobileqq.studymode;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.eldermode.ElderModeManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.theme.SkinnableView;
import com.tencent.util.LoadingUtil;
import cooperation.qzone.remote.ServiceConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0002EFB\u0011\b\u0016\u0012\u0006\u0010<\u001a\u00020;\u00a2\u0006\u0004\b=\u0010>B\u001b\b\u0016\u0012\u0006\u0010<\u001a\u00020;\u0012\b\u0010@\u001a\u0004\u0018\u00010?\u00a2\u0006\u0004\b=\u0010AB#\b\u0016\u0012\u0006\u0010<\u001a\u00020;\u0012\b\u0010@\u001a\u0004\u0018\u00010?\u0012\u0006\u0010B\u001a\u00020\u0003\u00a2\u0006\u0004\b=\u0010CJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011J\"\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u0011J\u0006\u0010\u0017\u001a\u00020\u000bJ\u000e\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0003J\u0012\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0014J\u000e\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0011J\u000e\u0010 \u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u0003J\u000e\u0010\"\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u0011J\b\u0010#\u001a\u00020\u000bH\u0016R$\u0010*\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010+R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00101\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010/R\u0018\u00102\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010/R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010+R\u0016\u0010:\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010+\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/studymode/ModeRadioGroup;", "Landroid/widget/LinearLayout;", "Lcom/tencent/theme/SkinnableView;", "", "type", "Landroid/widget/RelativeLayout;", "f", "Landroid/graphics/drawable/Drawable;", "e", "Landroid/view/View;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "o", "c", "", "k", "j", "", "enableCheck", "i", ServiceConst.EXTRA_NEEDCALLBACK, UIJsPlugin.EVENT_SHOW_LOADING, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "p", "d", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "isArrowUp", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "_index", "r", NodeProps.VISIBLE, "setCurrentColorTextVisible", "onThemeChanged", "Lcom/tencent/mobileqq/studymode/ModeRadioGroup$b;", "Lcom/tencent/mobileqq/studymode/ModeRadioGroup$b;", "getOnCheckChangeListener", "()Lcom/tencent/mobileqq/studymode/ModeRadioGroup$b;", "setOnCheckChangeListener", "(Lcom/tencent/mobileqq/studymode/ModeRadioGroup$b;)V", "onCheckChangeListener", "I", "oldType", "Z", tl.h.F, "Landroid/widget/RelativeLayout;", "defaultItem", "simpleItem", "studyItem", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "currentColorText", "D", "currentColorIndex", "E", "from", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attr", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", UserInfo.SEX_FEMALE, "a", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ModeRadioGroup extends LinearLayout implements SkinnableView {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TextView currentColorText;

    /* renamed from: D, reason: from kotlin metadata */
    private int currentColorIndex;

    /* renamed from: E, reason: from kotlin metadata */
    private int from;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b onCheckChangeListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int oldType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean enableCheck;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RelativeLayout defaultItem;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RelativeLayout simpleItem;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RelativeLayout studyItem;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/studymode/ModeRadioGroup$a;", "", "", "SIMPLE_MODE_COLORFUL_DIALOG_EXPOSURE", "Ljava/lang/String;", "SIMPLE_MODE_COLORFUL_ENTRANCE_CLICK", "SIMPLE_MODE_COLORFUL_ENTRANCE_EXPOSURE", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.studymode.ModeRadioGroup$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/studymode/ModeRadioGroup$b;", "", "", "curType", "oldType", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public interface b {
        void a(int curType, int oldType);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61827);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ModeRadioGroup(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
    }

    private final void c(View item) {
        int i3;
        if (QLog.isColorLevel()) {
            QLog.d("GeneralModeRadioGroup", 2, "cancelLoading");
        }
        View findViewById = item.findViewById(R.id.vna);
        boolean z16 = findViewById instanceof ImageView;
        if (z16) {
            Object drawable = ((ImageView) findViewById).getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).stop();
            }
        }
        if (z16) {
            i3 = 4;
        } else {
            i3 = 8;
        }
        findViewById.setVisibility(i3);
    }

    private final Drawable e() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(BaseAIOUtils.f(6.0f, getResources()));
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        gradientDrawable.setColor(com.tencent.mobileqq.mvvm.f.a(resources, R.color.qui_common_fill_light_secondary));
        int f16 = BaseAIOUtils.f(1.5f, getResources());
        Resources resources2 = getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "resources");
        gradientDrawable.setStroke(f16, com.tencent.mobileqq.mvvm.f.a(resources2, R.color.qui_common_brand_standard));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(BaseAIOUtils.f(6.0f, getResources()));
        Resources resources3 = getResources();
        Intrinsics.checkNotNullExpressionValue(resources3, "resources");
        gradientDrawable2.setColor(com.tencent.mobileqq.mvvm.f.a(resources3, R.color.qui_common_fill_light_secondary));
        int f17 = BaseAIOUtils.f(1.5f, getResources());
        Resources resources4 = getResources();
        Intrinsics.checkNotNullExpressionValue(resources4, "resources");
        gradientDrawable2.setStroke(f17, com.tencent.mobileqq.mvvm.f.a(resources4, R.color.qui_common_border_standard));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_selected}, gradientDrawable);
        stateListDrawable.addState(new int[0], gradientDrawable2);
        return stateListDrawable;
    }

    private final RelativeLayout f(final int type) {
        View imageView;
        int i3;
        int f16 = BaseAIOUtils.f(8.0f, getContext().getResources());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, BaseAIOUtils.f(120.0f, getContext().getResources()));
        layoutParams.leftMargin = f16;
        layoutParams.rightMargin = f16;
        layoutParams.weight = 1.0f;
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setTag(Integer.valueOf(type));
        relativeLayout.setLayoutParams(layoutParams);
        int f17 = BaseAIOUtils.f(8.0f, getContext().getResources());
        relativeLayout.setPadding(f17, BaseAIOUtils.f(12.0f, getContext().getResources()), f17, f17);
        com.tencent.mobileqq.mvvm.g.a(relativeLayout, e());
        addView(relativeLayout);
        TextView textView = new TextView(getContext());
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        textView.setTextColor(com.tencent.mobileqq.mvvm.f.b(resources, R.color.qui_common_text_primary));
        textView.setTextSize(1, 16.0f);
        textView.setText(k(type));
        textView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        textView.setId(R.id.vne);
        textView.setCompoundDrawablePadding(BaseAIOUtils.f(5.0f, getContext().getResources()));
        textView.setMaxLines(1);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        relativeLayout.addView(textView);
        int f18 = BaseAIOUtils.f(16.0f, getContext().getResources());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(f18, f18);
        layoutParams2.addRule(12);
        layoutParams2.addRule(11);
        View imageView2 = new ImageView(getContext());
        imageView2.setLayoutParams(layoutParams2);
        imageView2.setId(R.id.vnd);
        relativeLayout.addView(imageView2);
        int f19 = BaseAIOUtils.f(20.0f, getContext().getResources());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(f19, f19);
        layoutParams3.addRule(12);
        layoutParams3.addRule(9);
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("mode_switch_loading_8988_116301189", true)) {
            imageView = LoadingUtil.getLoadingView(getContext(), ViewUtils.dip2px(20.0f), ViewUtils.dip2px(20.0f), 2);
        } else {
            imageView = new ImageView(getContext());
        }
        imageView.setLayoutParams(layoutParams3);
        imageView.setId(R.id.vna);
        if (imageView instanceof ImageView) {
            i3 = 4;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        relativeLayout.addView(imageView);
        TextView textView2 = new TextView(getContext());
        Resources resources2 = getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "resources");
        textView2.setTextColor(com.tencent.mobileqq.mvvm.f.b(resources2, R.color.qui_common_text_secondary));
        textView2.setTextSize(1, 12.0f);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setMaxLines(3);
        textView2.setText(j(type));
        textView2.setLineSpacing(0.0f, 1.3f);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(3, R.id.vne);
        layoutParams4.addRule(2, R.id.vnd);
        layoutParams4.topMargin = BaseAIOUtils.f(4.0f, getContext().getResources());
        layoutParams4.bottomMargin = BaseAIOUtils.f(4.0f, getContext().getResources());
        textView2.setLayoutParams(layoutParams4);
        textView2.setId(R.id.vnb);
        relativeLayout.addView(textView2);
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.studymode.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ModeRadioGroup.g(ModeRadioGroup.this, type, view);
            }
        });
        if (type == 1) {
            TextView textView3 = new TextView(getContext());
            this.currentColorText = textView3;
            Resources resources3 = getResources();
            Intrinsics.checkNotNullExpressionValue(resources3, "resources");
            textView3.setTextColor(com.tencent.mobileqq.mvvm.f.b(resources3, R.color.qui_common_text_secondary));
            TextView textView4 = this.currentColorText;
            if (textView4 != null) {
                textView4.setTextSize(1, 12.0f);
            }
            TextView textView5 = this.currentColorText;
            if (textView5 != null) {
                textView5.setEllipsize(TextUtils.TruncateAt.END);
            }
            TextView textView6 = this.currentColorText;
            if (textView6 != null) {
                textView6.setLineSpacing(0.0f, 1.3f);
            }
            TextView textView7 = this.currentColorText;
            if (textView7 != null) {
                textView7.setVisibility(8);
            }
            q(false);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams5.addRule(9);
            layoutParams5.addRule(12);
            TextView textView8 = this.currentColorText;
            if (textView8 != null) {
                textView8.setLayoutParams(layoutParams5);
            }
            TextView textView9 = this.currentColorText;
            if (textView9 != null) {
                textView9.setId(R.id.vnc);
            }
            relativeLayout.addView(this.currentColorText);
            TextView textView10 = this.currentColorText;
            if (textView10 != null) {
                textView10.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.studymode.i
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ModeRadioGroup.h(ModeRadioGroup.this, view);
                    }
                });
            }
            if (FontSettingManager.getFontLevel() >= 18.0f) {
                layoutParams3.removeRule(9);
                layoutParams3.removeRule(12);
                layoutParams3.addRule(2, R.id.vnd);
                layoutParams3.addRule(9);
                layoutParams3.addRule(11);
            } else {
                layoutParams3.removeRule(9);
                layoutParams3.addRule(1, R.id.vnc);
            }
        }
        return relativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(ModeRadioGroup this$0, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!NetworkUtil.isNetSupport(this$0.getContext())) {
            if (this$0.oldType != i3) {
                QQToast.makeText(this$0.getContext(), 1, R.string.cjm, 1).show();
            }
        } else if (i3 == 2 && this$0.oldType != 2) {
            if (this$0.enableCheck) {
                n(this$0, i3, true, false, 4, null);
            }
        } else {
            QLog.d("GeneralModeRadioGroup", 1, "click item, type= " + i3 + ", old type= " + this$0.oldType + ", enableCheck = " + this$0.enableCheck);
            if (this$0.enableCheck && i3 != this$0.oldType) {
                n(this$0, i3, true, false, 4, null);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(final ModeRadioGroup this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.enableCheck && !hf0.a.a("ModeRadioGroup")) {
            ReportController.o(null, "dc00898", "", "", "0X800BF84", "0X800BF84", this$0.from, 0, "", "", "", "");
            this$0.q(true);
            if (this$0.getContext() != null && (this$0.getContext() instanceof FragmentActivity)) {
                Object systemService = this$0.getContext().getSystemService("vibrator");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
                ((Vibrator) systemService).vibrate(20L);
                ColorListDialogFragment colorListDialogFragment = new ColorListDialogFragment(this$0.currentColorIndex);
                colorListDialogFragment.wh(new Function0<Unit>() { // from class: com.tencent.mobileqq.studymode.ModeRadioGroup$createItemView$2$1
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) ModeRadioGroup.this);
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
                        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                            ModeRadioGroup.this.q(false);
                        } else {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        }
                    }
                });
                Context context = this$0.getContext();
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                colorListDialogFragment.show(((FragmentActivity) context).getSupportFragmentManager(), "ColorListDialogFragment");
                if (this$0.getContext() instanceof BaseActivity) {
                    Context context2 = this$0.getContext();
                    Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type com.tencent.mobileqq.app.BaseActivity");
                    Manager manager = ((BaseActivity) context2).getAppInterface().getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER);
                    Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.studymode.ModeSwitchManager");
                    ((l) manager).w(this$0.currentColorIndex);
                    QLog.i("ModeRadioGroup", 1, "update modeSwitchManager.bPref: " + this$0.currentColorIndex + " when init ColorListDialogFragment");
                }
                ReportController.o(null, "dc00898", "", "", "0X800BF85", "0X800BF85", this$0.from, 0, "", "", "", "");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final String j(int type) {
        String string;
        if (type != 1) {
            if (type != 2) {
                string = getContext().getResources().getString(R.string.wju);
            } else {
                string = getContext().getResources().getString(R.string.wjz);
            }
        } else {
            string = getContext().getResources().getString(R.string.wjx);
        }
        Intrinsics.checkNotNullExpressionValue(string, "when (type) {\n        MO\u2026fault_mode_content)\n    }");
        return string;
    }

    private final String k(int type) {
        String string;
        if (type != 1) {
            if (type != 2) {
                string = getContext().getResources().getString(r.b());
            } else {
                string = getContext().getResources().getString(R.string.f170988wk0);
            }
        } else {
            string = getContext().getResources().getString(r.d());
        }
        Intrinsics.checkNotNullExpressionValue(string, "when (type) {\n        MO\u2026tDefaultModeName())\n    }");
        return string;
    }

    public static /* synthetic */ void n(ModeRadioGroup modeRadioGroup, int i3, boolean z16, boolean z17, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            z16 = false;
        }
        if ((i16 & 4) != 0) {
            z17 = false;
        }
        modeRadioGroup.m(i3, z16, z17);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void o(View item) {
        if (QLog.isColorLevel()) {
            QLog.d("GeneralModeRadioGroup", 2, UIJsPlugin.EVENT_SHOW_LOADING);
        }
        Resources resources = getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        Drawable c16 = com.tencent.mobileqq.mvvm.f.c(resources, R.drawable.jig);
        int f16 = BaseAIOUtils.f(20.0f, getContext().getResources());
        View findViewById = item.findViewById(R.id.vna);
        if (findViewById instanceof ImageView) {
            c16.setBounds(0, 0, f16, f16);
            ((ImageView) findViewById).setImageDrawable(c16);
            if (c16 instanceof Animatable) {
                ((Animatable) c16).start();
            }
        }
        findViewById.setVisibility(0);
    }

    public final void d(int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, type);
            return;
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View child = getChildAt(i3);
            Object tag = child.getTag();
            if ((tag instanceof Integer) && Intrinsics.areEqual(tag, Integer.valueOf(type))) {
                Intrinsics.checkNotNullExpressionValue(child, "child");
                c(child);
            }
        }
    }

    public final void i(boolean enableCheck) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, enableCheck);
        } else {
            this.enableCheck = enableCheck;
        }
    }

    public final void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        RelativeLayout relativeLayout = this.defaultItem;
        if (relativeLayout != null) {
            com.tencent.mobileqq.mvvm.g.a(relativeLayout, e());
        }
        RelativeLayout relativeLayout2 = this.simpleItem;
        if (relativeLayout2 != null) {
            com.tencent.mobileqq.mvvm.g.a(relativeLayout2, e());
        }
        RelativeLayout relativeLayout3 = this.defaultItem;
        if (relativeLayout3 != null) {
            com.tencent.mobileqq.mvvm.g.a(relativeLayout3, e());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m(int type, boolean needCallback, boolean showLoading) {
        boolean z16;
        int childCount;
        int i3;
        b bVar;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(type), Boolean.valueOf(needCallback), Boolean.valueOf(showLoading));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GeneralModeRadioGroup", 2, "selectByType type : " + type + ", old type : " + this.oldType + ", needCallback : " + needCallback + ", showLoading : " + showLoading);
            QLog.d("GeneralModeRadioGroup", 2, "stack: ", new Throwable("selectByType"));
        }
        if (needCallback && ElderModeManager.j() && type != 3) {
            if (ElderModeManager.d() == 18.0f) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                z16 = true;
                childCount = getChildCount();
                for (i3 = 0; i3 < childCount; i3++) {
                    View child = getChildAt(i3);
                    ImageView imageView = (ImageView) child.findViewById(R.id.vnd);
                    Object tag = child.getTag();
                    if ((tag instanceof Integer) && Intrinsics.areEqual(tag, Integer.valueOf(type)) && !z16) {
                        if (showLoading) {
                            Intrinsics.checkNotNullExpressionValue(child, "child");
                            o(child);
                        }
                        imageView.setImageResource(R.drawable.qui_common_check_box_checked);
                        child.setSelected(true);
                    } else {
                        imageView.setImageResource(R.drawable.qui_common_check_box_unchecked);
                        child.setSelected(false);
                        Intrinsics.checkNotNullExpressionValue(child, "child");
                        c(child);
                    }
                }
                if (needCallback && (bVar = this.onCheckChangeListener) != null) {
                    bVar.a(type, this.oldType);
                }
                this.oldType = type;
            }
        }
        z16 = false;
        childCount = getChildCount();
        while (i3 < childCount) {
        }
        if (needCallback) {
            bVar.a(type, this.oldType);
        }
        this.oldType = type;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(@Nullable Configuration newConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) newConfig);
        } else {
            super.onConfigurationChanged(newConfig);
            requestLayout();
        }
    }

    @Override // com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(index)");
            com.tencent.mobileqq.mvvm.g.a(childAt, null);
            View childAt2 = getChildAt(i3);
            Intrinsics.checkNotNullExpressionValue(childAt2, "getChildAt(index)");
            com.tencent.mobileqq.mvvm.g.a(childAt2, e());
        }
    }

    public final void p(int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, type);
            return;
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View child = getChildAt(i3);
            Object tag = child.getTag();
            if ((tag instanceof Integer) && Intrinsics.areEqual(tag, Integer.valueOf(type))) {
                Intrinsics.checkNotNullExpressionValue(child, "child");
                o(child);
            }
        }
    }

    public final void q(boolean isArrowUp) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, isArrowUp);
            return;
        }
        int f16 = BaseAIOUtils.f(16.0f, getContext().getResources());
        Resources resources = getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        if (isArrowUp) {
            i3 = R.drawable.qui_chevron_up;
        } else {
            i3 = R.drawable.qui_chevron_down;
        }
        Drawable c16 = com.tencent.mobileqq.mvvm.f.c(resources, i3);
        c16.setBounds(0, 0, f16, f16);
        TextView textView = this.currentColorText;
        if (textView != null) {
            textView.setCompoundDrawables(null, null, c16, null);
        }
    }

    public final void r(int _index) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, _index);
            return;
        }
        if (_index < 0 || _index >= ThemeConstants.THEME_ID_IMAGE_LIST_MAME.length) {
            _index = 0;
        }
        this.currentColorIndex = _index;
        String text = ThemeConstants.THEME_ID_IMAGE_LIST_MAME[_index];
        if (FontSettingManager.isFontSizeLarge()) {
            Intrinsics.checkNotNullExpressionValue(text, "text");
            text = text.substring(0, text.length() - 1);
            Intrinsics.checkNotNullExpressionValue(text, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        }
        TextView textView = this.currentColorText;
        if (textView != null) {
            textView.setText(text);
        }
    }

    public final void setCurrentColorTextVisible(boolean visible) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, visible);
            return;
        }
        TextView textView = this.currentColorText;
        int i3 = 0;
        if (textView != null && textView.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && visible) {
            ReportController.o(null, "dc00898", "", "", "0X800BF83", "0X800BF83", this.from, 0, "", "", "", "");
        }
        TextView textView2 = this.currentColorText;
        if (textView2 != null) {
            if (!visible) {
                i3 = 8;
            }
            textView2.setVisibility(i3);
        }
    }

    public final void setOnCheckChangeListener(@Nullable b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
        } else {
            this.onCheckChangeListener = bVar;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ModeRadioGroup(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModeRadioGroup(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.oldType = -1;
        this.enableCheck = true;
        setOrientation(0);
        setPadding(BaseAIOUtils.f(8.0f, context.getResources()), 0, BaseAIOUtils.f(8.0f, context.getResources()), BaseAIOUtils.f(18.0f, context.getResources()));
        this.defaultItem = f(0);
        this.simpleItem = f(1);
        this.studyItem = f(2);
        if (context instanceof BaseActivity) {
            this.from = ModeChoiceViewContainer.I(((BaseActivity) context).getAppInterface()) ? 1 : 2;
        }
    }
}
