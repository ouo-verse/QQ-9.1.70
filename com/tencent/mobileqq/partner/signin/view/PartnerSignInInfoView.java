package com.tencent.mobileqq.partner.signin.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.ColorUtils;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.components.PartnerButton;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.partner.signin.PartnerSignInHandler;
import com.tencent.mobileqq.partner.signin.k;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.util.m;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import tl.h;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 J2\u00020\u0001:\u0001KB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010E\u0012\b\b\u0002\u0010G\u001a\u00020\r\u00a2\u0006\u0004\bH\u0010IJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0003J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J2\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00040\u00162\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00000\u0014H\u0002J\u001c\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\f\u001a\u00020\rH\u0002J \u0010 \u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0007R\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010*\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00100\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u0014\u00102\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010-R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u00109\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010;\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b:\u00108R\u0014\u0010=\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b<\u00108R\u0014\u0010@\u001a\u00020>8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b?\u0010<R\u0014\u0010B\u001a\u00020>8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bA\u0010<R\u0014\u0010D\u001a\u00020>8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bC\u0010<\u00a8\u0006L"}, d2 = {"Lcom/tencent/mobileqq/partner/signin/view/PartnerSignInInfoView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "", "H0", "", "selfUin", "partnerUin", "Lcom/tencent/mobileqq/partner/signin/b;", "signInData", "K0", "themeColor", "", "F0", "", "B0", "", "markId", "I0", "Lmqq/util/WeakReference;", "infoViewRef", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/partner/signin/k;", "E0", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/components/PartnerButton$a;", "D0", "Landroid/content/res/Resources;", "it", "G0", "C0", "J0", "Landroid/view/View;", "d", "Landroid/view/View;", "togetherLayout", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "e", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "partnerAvatarView", "f", "selfAvatarView", "Landroid/widget/TextView;", h.F, "Landroid/widget/TextView;", "togetherTv", "i", "partnerDaysTv", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "selfDaysTv", "Lcom/tencent/mobileqq/components/PartnerButton;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/components/PartnerButton;", "signInButton", "D", "Ljava/lang/String;", "BUTTON_TYPE_UNCHECKIN", "E", "BUTTON_TYPE_CHECKIN", UserInfo.SEX_FEMALE, "PLACE_HOLDER", "", "G", "BUTTON_ICON_SIZE", "H", "BUTTON_TEXT_SIZE", "I", "TOGETHER_TEXT_SIZE", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "J", "a", "mutualmark_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class PartnerSignInInfoView extends ConstraintLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private final PartnerButton signInButton;

    /* renamed from: D, reason: from kotlin metadata */
    private final String BUTTON_TYPE_UNCHECKIN;

    /* renamed from: E, reason: from kotlin metadata */
    private final String BUTTON_TYPE_CHECKIN;

    /* renamed from: F, reason: from kotlin metadata */
    private final String PLACE_HOLDER;

    /* renamed from: G, reason: from kotlin metadata */
    private final float BUTTON_ICON_SIZE;

    /* renamed from: H, reason: from kotlin metadata */
    private final float BUTTON_TEXT_SIZE;

    /* renamed from: I, reason: from kotlin metadata */
    private final float TOGETHER_TEXT_SIZE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final View togetherLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final QQProAvatarView partnerAvatarView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final QQProAvatarView selfAvatarView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final TextView togetherTv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final TextView partnerDaysTv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final TextView selfDaysTv;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PartnerSignInInfoView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final CharSequence B0(com.tencent.mobileqq.partner.signin.b signInData) {
        int indexOf$default;
        String replace$default;
        int k3 = signInData.k();
        String e16 = signInData.e();
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) e16, this.PLACE_HOLDER, 0, false, 6, (Object) null);
        if (indexOf$default < 0 || indexOf$default >= e16.length()) {
            return e16;
        }
        replace$default = StringsKt__StringsJVMKt.replace$default(e16, this.PLACE_HOLDER, String.valueOf(k3), false, 4, (Object) null);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(replace$default);
        try {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(F0(signInData.j())), indexOf$default, String.valueOf(k3).length() + indexOf$default, 17);
        } catch (IllegalArgumentException unused) {
            QLog.i("PartnerSignInInfoView", 1, "PartnerSignInData themeColor error " + signInData.j());
        }
        return spannableStringBuilder;
    }

    private final ConcurrentHashMap<String, PartnerButton.PartnerButtonParam> D0(int themeColor) {
        ConcurrentHashMap<String, PartnerButton.PartnerButtonParam> concurrentHashMap = new ConcurrentHashMap<>();
        Resources resources = getResources();
        if (resources != null) {
            concurrentHashMap.put(this.BUTTON_TYPE_UNCHECKIN, G0(resources, themeColor));
            concurrentHashMap.put(this.BUTTON_TYPE_CHECKIN, C0(resources, themeColor));
        }
        return concurrentHashMap;
    }

    private final Function1<k, Unit> E0(String partnerUin, long markId, WeakReference<PartnerSignInInfoView> infoViewRef) {
        return new PartnerSignInInfoView$getSignInCallback$1(markId, infoViewRef, partnerUin);
    }

    private final int F0(String themeColor) {
        try {
            if (themeColor.length() == 0) {
                themeColor = "#";
            }
            return Color.parseColor(themeColor);
        } catch (IllegalArgumentException unused) {
            Resources resources = getResources();
            if (resources != null) {
                return resources.getColor(R.color.qui_common_brand_standard, null);
            }
            return -16777216;
        }
    }

    private final void H0(Context context) {
        if (FontSettingManager.getFontLevel() <= 17.0f) {
            return;
        }
        float f16 = FontSettingManager.systemMetrics.density / context.getResources().getDisplayMetrics().density;
        this.partnerAvatarView.setScaleX(f16);
        this.partnerAvatarView.setScaleY(f16);
        this.selfAvatarView.setScaleX(f16);
        this.selfAvatarView.setScaleY(f16);
        this.togetherTv.setTextSize(2, this.TOGETHER_TEXT_SIZE * f16);
        this.signInButton.setScaleX(f16);
        this.signInButton.setScaleY(f16);
    }

    private final void I0(String partnerUin, long markId) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        BusinessHandler businessHandler = appInterface.getBusinessHandler(PartnerSignInHandler.class.getName());
        PartnerSignInHandler partnerSignInHandler = businessHandler instanceof PartnerSignInHandler ? (PartnerSignInHandler) businessHandler : null;
        if (partnerSignInHandler != null) {
            partnerSignInHandler.I2(partnerUin, markId, "sidebar", E0(partnerUin, markId, new WeakReference<>(this)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K0(String selfUin, final String partnerUin, final com.tencent.mobileqq.partner.signin.b signInData) {
        String replace$default;
        String replace$default2;
        this.togetherTv.setText(B0(signInData));
        int i3 = 0;
        int i16 = 0;
        boolean z16 = false;
        for (com.tencent.mobileqq.partner.signin.a aVar : signInData.g()) {
            if (Intrinsics.areEqual(aVar.a(), selfUin)) {
                i3 = aVar.b();
                z16 = aVar.c();
            }
            if (Intrinsics.areEqual(aVar.a(), partnerUin)) {
                i16 = aVar.b();
            }
        }
        TextView textView = this.selfDaysTv;
        String qqStr = HardCodeUtil.qqStr(R.string.wyg);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.partner_checkin_days)");
        replace$default = StringsKt__StringsJVMKt.replace$default(qqStr, this.PLACE_HOLDER, String.valueOf(i3), false, 4, (Object) null);
        textView.setText(replace$default);
        TextView textView2 = this.partnerDaysTv;
        String qqStr2 = HardCodeUtil.qqStr(R.string.wyg);
        Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.partner_checkin_days)");
        replace$default2 = StringsKt__StringsJVMKt.replace$default(qqStr2, this.PLACE_HOLDER, String.valueOf(i16), false, 4, (Object) null);
        textView2.setText(replace$default2);
        this.signInButton.setButtonParams(D0(F0(signInData.j())));
        this.signInButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.partner.signin.view.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PartnerSignInInfoView.L0(PartnerSignInInfoView.this, partnerUin, signInData, view);
            }
        });
        if (z16) {
            this.signInButton.a(this.BUTTON_TYPE_CHECKIN);
            this.signInButton.setClickable(false);
        } else {
            this.signInButton.a(this.BUTTON_TYPE_UNCHECKIN);
            this.signInButton.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(PartnerSignInInfoView this$0, String partnerUin, com.tencent.mobileqq.partner.signin.b signInData, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(partnerUin, "$partnerUin");
        Intrinsics.checkNotNullParameter(signInData, "$signInData");
        this$0.I0(partnerUin, signInData.f());
        m.f306784a.b(new m.PartnerReportData("pg_aio_swipleft", "em_bas_punch_button", "dt_clck", signInData, partnerUin, "2"));
    }

    public final void J0(String selfUin, String partnerUin, com.tencent.mobileqq.partner.signin.b signInData) {
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        Intrinsics.checkNotNullParameter(partnerUin, "partnerUin");
        Intrinsics.checkNotNullParameter(signInData, "signInData");
        this.selfAvatarView.w(1, selfUin);
        this.partnerAvatarView.w(1, partnerUin);
        K0(selfUin, partnerUin, signInData);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PartnerSignInInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PartnerSignInInfoView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PartnerSignInInfoView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.BUTTON_TYPE_UNCHECKIN = "button_type_uncheckin";
        this.BUTTON_TYPE_CHECKIN = "button_type_checkin";
        this.PLACE_HOLDER = "{day}";
        this.BUTTON_ICON_SIZE = 16.0f;
        this.BUTTON_TEXT_SIZE = 14.0f;
        this.TOGETHER_TEXT_SIZE = 16.0f;
        LayoutInflater.from(context).inflate(R.layout.cvz, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.ohb);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.layout\u2026cumulative_days_together)");
        this.togetherLayout = findViewById;
        View findViewById2 = findViewById(R.id.f163131oh0);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.avatar_partner)");
        QQProAvatarView qQProAvatarView = (QQProAvatarView) findViewById2;
        this.partnerAvatarView = qQProAvatarView;
        View findViewById3 = findViewById(R.id.f163132oh1);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.avatar_self)");
        QQProAvatarView qQProAvatarView2 = (QQProAvatarView) findViewById3;
        this.selfAvatarView = qQProAvatarView2;
        View findViewById4 = findViewById(R.id.ohp);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.tv_accumulative_days)");
        this.togetherTv = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.ohu);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.tv_sign_in_days_partner)");
        this.partnerDaysTv = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.ohv);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.tv_sign_in_days_self)");
        this.selfDaysTv = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.f163134oh3);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.btn_sign_in)");
        this.signInButton = (PartnerButton) findViewById7;
        qQProAvatarView.setEnableFrame(true);
        qQProAvatarView2.setEnableFrame(true);
        H0(context);
    }

    private final PartnerButton.PartnerButtonParam C0(Resources it, int themeColor) {
        Drawable mutate = it.getDrawable(R.drawable.eym, null).mutate();
        Intrinsics.checkNotNullExpressionValue(mutate, "it.getDrawable(R.drawabl\u2026port_fill, null).mutate()");
        mutate.setTint(themeColor);
        String qqStr = HardCodeUtil.qqStr(R.string.wyj);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(qqStr);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(themeColor), 0, qqStr.length(), 17);
        Drawable mutate2 = it.getDrawable(R.drawable.eyb, null).mutate();
        Intrinsics.checkNotNullExpressionValue(mutate2, "it.getDrawable(R.drawabl\u2026d_default, null).mutate()");
        mutate2.setTint(ColorUtils.setAlphaComponent(themeColor, 26));
        return new PartnerButton.PartnerButtonParam(mutate, this.BUTTON_ICON_SIZE, spannableStringBuilder, this.BUTTON_TEXT_SIZE, mutate2);
    }

    private final PartnerButton.PartnerButtonParam G0(Resources it, int themeColor) {
        Drawable unCheckinIcon = it.getDrawable(R.drawable.eyf, null);
        String qqStr = HardCodeUtil.qqStr(R.string.wyi);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(qqStr);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(-1), 0, qqStr.length(), 17);
        ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed}, new int[]{-16842919}}, new int[]{ColorUtils.setAlphaComponent(themeColor, 128), themeColor});
        Drawable mutate = it.getDrawable(R.drawable.eyb, null).mutate();
        Intrinsics.checkNotNullExpressionValue(mutate, "it.getDrawable(R.drawabl\u2026d_default, null).mutate()");
        mutate.setTintList(colorStateList);
        Intrinsics.checkNotNullExpressionValue(unCheckinIcon, "unCheckinIcon");
        return new PartnerButton.PartnerButtonParam(unCheckinIcon, this.BUTTON_ICON_SIZE, spannableStringBuilder, this.BUTTON_TEXT_SIZE, mutate);
    }
}
