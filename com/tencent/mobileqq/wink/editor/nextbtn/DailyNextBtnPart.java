package com.tencent.mobileqq.wink.editor.nextbtn;

import android.app.Activity;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheWeatherData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.cu;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import uq3.k;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 -2\u00020\u0001:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000eH\u0014J\u0012\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016R$\u0010\u001b\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR*\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010%R\u0014\u0010*\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010%\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/nextbtn/DailyNextBtnPart;", "Lcom/tencent/mobileqq/wink/editor/nextbtn/NextBtnPart;", "", "", "getReportParams", "", "initViewModel", "xa", "Aa", "Landroid/text/SpannableStringBuilder;", "ta", "", "B9", "getLogTag", "Landroid/view/View;", "X9", "view", "da", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "T", "Landroid/view/View;", "ua", "()Landroid/view/View;", "setDailySendBtn", "(Landroid/view/View;)V", "dailySendBtn", "Lkotlin/Function0;", "U", "Lkotlin/jvm/functions/Function0;", "getDailySendListener", "()Lkotlin/jvm/functions/Function0;", "za", "(Lkotlin/jvm/functions/Function0;)V", "dailySendListener", "V", "I", "BUBBLE_WIDTH", "W", "BUBBLE_HEIGHT", "X", "BUBBLE_BG_HEIGHT", "<init>", "()V", "Y", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class DailyNextBtnPart extends NextBtnPart {

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private View dailySendBtn;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private Function0<Unit> dailySendListener;

    /* renamed from: V, reason: from kotlin metadata */
    private final int BUBBLE_WIDTH = ViewExKt.d(219);

    /* renamed from: W, reason: from kotlin metadata */
    private final int BUBBLE_HEIGHT = ViewExKt.d(63);

    /* renamed from: X, reason: from kotlin metadata */
    private final int BUBBLE_BG_HEIGHT = ViewExKt.d(55);

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0006\u0010\t\u001a\u00020\u0007J\u000e\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\n0\nJ\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u0007R\u0014\u0010\u0010\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0011\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/nextbtn/DailyNextBtnPart$a;", "", "", "b", WidgetCacheWeatherData.HOUR, "", "d", "", "f", "e", "Luq3/k;", "kotlin.jvm.PlatformType", h.F, "a", "c", "g", "DAY_3_STRING", "Ljava/lang/String;", "EXP_PARAMS_KEY", "HOUR_24", "I", "HOUR_24_STRING", "HOUR_72", "MMKV_IS_FIRST_TIME_SHOW_DAILY_BUBBLE", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.nextbtn.DailyNextBtnPart$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:0x001e, code lost:
        
            r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r0);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final int b() {
            int i3;
            Integer intOrNull;
            Map<String, String> params = ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).getParams("exp_xsj_publish_story_new_one");
            if (params == null) {
                return 24;
            }
            String str = params.get("valid_time");
            if (str != null && intOrNull != null) {
                i3 = intOrNull.intValue();
            } else {
                if (!DailyNextBtnPart.INSTANCE.f()) {
                    return 24;
                }
                i3 = 72;
            }
            return i3;
        }

        private final String d(int hour) {
            if (hour <= 0) {
                if (!f()) {
                    return "24\u5c0f\u65f6";
                }
                return "3\u5929";
            }
            boolean z16 = false;
            if (1 <= hour && hour < 25) {
                z16 = true;
            }
            if (z16) {
                return "24\u5c0f\u65f6";
            }
            return (hour / 24) + "\u5929";
        }

        private final boolean f() {
            if (!((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExpHit("exp_xsj_publish_story_new_one", "exp_xsj_publish_story_new_one_C") && !((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExpHit("exp_xsj_publish_story_new_one", "exp_xsj_publish_story_new_one_E")) {
                return false;
            }
            return true;
        }

        @NotNull
        public final String a() {
            return d(b());
        }

        public final int c() {
            return b() * 60 * 60;
        }

        public final boolean e() {
            if (g() && k.a().c("mmkv_is_first_time_show_daily_bubble", true)) {
                return true;
            }
            return false;
        }

        public final boolean g() {
            if (WinkContext.INSTANCE.d().u("QCIRCLE") && (((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExpHit("exp_xsj_publish_story_new_one", "exp_xsj_publish_story_new_one_B") || ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExpHit("exp_xsj_publish_story_new_one", "exp_xsj_publish_story_new_one_C") || ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExpHit("exp_xsj_publish_story_new_one", "exp_xsj_publish_story_new_one_D") || ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExpHit("exp_xsj_publish_story_new_one", "exp_xsj_publish_story_new_one_E"))) {
                return true;
            }
            return false;
        }

        public final k h() {
            return k.a().j("mmkv_is_first_time_show_daily_bubble", false);
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JR\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/wink/editor/nextbtn/DailyNextBtnPart$b", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "v", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "", "onLayoutChange", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements View.OnLayoutChangeListener {
        b() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(@Nullable View v3, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            w53.b.a(DailyNextBtnPart.this.TAG, "onLayoutChange...");
            View ua5 = DailyNextBtnPart.this.ua();
            if (ua5 != null) {
                ua5.removeOnLayoutChangeListener(this);
            }
            DailyNextBtnPart.this.Aa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Aa() {
        Companion companion = INSTANCE;
        if (companion.e()) {
            w53.b.a(this.TAG, "showFirstDailyBubble...");
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.hcv, (ViewGroup) null, false);
            inflate.setLayoutParams(new ViewGroup.LayoutParams(this.BUBBLE_WIDTH, this.BUBBLE_HEIGHT));
            ((ImageView) inflate.findViewById(R.id.f164690ti1)).setLayoutParams(new ViewGroup.LayoutParams(this.BUBBLE_WIDTH, this.BUBBLE_BG_HEIGHT));
            ((TextView) inflate.findViewById(R.id.f164692ti3)).setText(ta());
            com.tencent.mobileqq.widget.tip.a b06 = com.tencent.mobileqq.widget.tip.a.r(getContext()).a0(inflate).Z(1, 0).S(this.dailySendBtn).i0(16.0f, -20.0f).b0(5000L);
            if (!getActivity().isFinishing() && !getActivity().isDestroyed()) {
                b06.s0();
                companion.h();
                w53.b.a(this.TAG, "showFirstDailyBubble... show...");
            }
        }
    }

    private final Map<String, String> getReportParams() {
        Map<String, String> r16 = cu.r(H9());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        boolean z16 = false;
        if (r16 != null && (!r16.isEmpty())) {
            z16 = true;
        }
        String str = "";
        if (z16) {
            String str2 = r16.get(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_UNDERLAY_STYLE);
            if (str2 == null) {
                str2 = "";
            }
            linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_UNDERLAY_STYLE, str2);
            String str3 = r16.get(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_COLOR_STYLE);
            if (str3 == null) {
                str3 = "";
            }
            linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_COLOR_STYLE, str3);
            String str4 = r16.get("xsj_text_content");
            if (str4 == null) {
                str4 = "";
            }
            linkedHashMap.put("xsj_text_content", str4);
            String str5 = r16.get(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_ALIGNMEN_STYLE);
            if (str5 == null) {
                str5 = "";
            }
            linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_ALIGNMEN_STYLE, str5);
            String str6 = r16.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CHAR_FORM_NAME);
            if (str6 == null) {
                str6 = "";
            }
            linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CHAR_FORM_NAME, str6);
            String str7 = r16.get(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_PARAGRAPH);
            if (str7 == null) {
                str7 = "";
            }
            linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_PARAGRAPH, str7);
        }
        linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_DAILY_TYPE, "1");
        WinkContext.Companion companion = WinkContext.INSTANCE;
        if (!TextUtils.isEmpty(companion.d().p(QCircleScheme.AttrQQPublish.ARK_SHARE_TYPE))) {
            QLog.d(this.TAG, 2, "getReportParams ARK_SHARE_TYPE: " + companion.d().p(QCircleScheme.AttrQQPublish.ARK_SHARE_TYPE));
            String p16 = companion.d().p(QCircleScheme.AttrQQPublish.ARK_SHARE_TYPE);
            if (p16 != null) {
                str = p16;
            }
            linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MATERIAL_SHARE_TYPE, str);
        }
        return linkedHashMap;
    }

    private final void initViewModel() {
        LiveData<MenuType> e36 = G9().e3();
        Fragment hostFragment = getHostFragment();
        final Function1<MenuType, Unit> function1 = new Function1<MenuType, Unit>() { // from class: com.tencent.mobileqq.wink.editor.nextbtn.DailyNextBtnPart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MenuType menuType) {
                invoke2(menuType);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable MenuType menuType) {
                if (menuType != null) {
                    DailyNextBtnPart dailyNextBtnPart = DailyNextBtnPart.this;
                    if (menuType == MenuType.TO_IMAGE || menuType == MenuType.TO_VIDEO) {
                        dailyNextBtnPart.xa();
                    }
                }
            }
        };
        e36.observe(hostFragment, new Observer() { // from class: com.tencent.mobileqq.wink.editor.nextbtn.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DailyNextBtnPart.wa(Function1.this, obj);
            }
        });
    }

    private final SpannableStringBuilder ta() {
        String str = "\u70b9\u51fb\u8f7b\u677e\u53d1\u65e5\u5e38\uff0c\u4ec5" + INSTANCE.a() + "\u53ef\u89c1";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) str);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(14, true), 0, str.length(), 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFFFF")), 0, str.length(), 33);
        spannableStringBuilder.append((CharSequence) ("\n\u5230\u671f\u540e\u81ea\u52a8\u8bbe\u4e3a\u79c1\u5bc6\u4f5c\u54c1"));
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(12, true), str.length() + 1, str.length() + 1 + 11, 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#CCFFFFFF")), str.length() + 1, str.length() + 1 + 11, 33);
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void va(DailyNextBtnPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.G9().V4(true);
        Function0<Unit> function0 = this$0.dailySendListener;
        if (function0 != null) {
            function0.invoke();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void xa() {
        com.tencent.mobileqq.wink.report.a.f326259a.a("em_xsj_publish_button", "ev_xsj_abnormal_imp", cu.k(G9().getEditMode()), getReportParams());
    }

    @Override // com.tencent.mobileqq.wink.editor.nextbtn.NextBtnPart, com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return R.id.zql;
    }

    @Override // com.tencent.mobileqq.wink.editor.nextbtn.NextBtnPart
    @Nullable
    /* renamed from: X9, reason: from getter */
    public View getDailySendBtn() {
        return this.dailySendBtn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.nextbtn.NextBtnPart
    public void da(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.da(view);
        View findViewById = view.findViewById(R.id.ud7);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.nextbtn.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DailyNextBtnPart.va(DailyNextBtnPart.this, view2);
                }
            });
            findViewById.addOnLayoutChangeListener(new b());
            xa();
        } else {
            findViewById = null;
        }
        this.dailySendBtn = findViewById;
        ((TextView) view.findViewById(R.id.ud8)).setText(INSTANCE.a() + "\u53ef\u89c1");
        initViewModel();
    }

    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "DailyNextBtnPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        w53.b.a(this.TAG, "onPartResume...");
    }

    @Nullable
    public final View ua() {
        return this.dailySendBtn;
    }

    public final void za(@Nullable Function0<Unit> function0) {
        this.dailySendListener = function0;
    }
}
