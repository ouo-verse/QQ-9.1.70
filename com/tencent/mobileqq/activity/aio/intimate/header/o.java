package com.tencent.mobileqq.activity.aio.intimate.header;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.view.widget.ticker.TickerView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b5\u00106J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0017R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000bR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0016\u0010!\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001aR\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010\u001aR\u0016\u0010)\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010\u0016R\u0016\u0010+\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010\u001aR\u0016\u0010-\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010\u001aR\u0016\u0010/\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010\u000bR\u001e\u00104\u001a\n 1*\u0004\u0018\u000100008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/header/o;", "", "", "type", "", "a", "Lcom/tencent/mobileqq/activity/aio/intimate/header/g;", "model", "", "b", "Landroid/view/View;", "Landroid/view/View;", "getMRootView", "()Landroid/view/View;", "mRootView", "mCardRootBgView", "Landroid/widget/ImageView;", "c", "Landroid/widget/ImageView;", "mCardBgView", "Landroid/widget/LinearLayout;", "d", "Landroid/widget/LinearLayout;", "mTextArea", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "mFirstLineTextZeroDay", "f", "mSecondLineTextZeroDay", "g", "mFirstLineText", tl.h.F, "mFirstLineExtend", "Lcom/tencent/mobileqq/kandian/base/view/widget/ticker/TickerView;", "i", "Lcom/tencent/mobileqq/kandian/base/view/widget/ticker/TickerView;", "mSecondLineFirstText", "j", "mSecondLineSecondText", "k", "mFirstLabel", "l", "mFirstLabelFirstText", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mFirstLabelSecondText", DomainData.DOMAIN_NAME, "mFirstLabelBorder", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "o", "Landroid/content/res/Resources;", DKConfiguration.Directory.RESOURCES, "<init>", "(Landroid/view/View;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mRootView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View mCardRootBgView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageView mCardBgView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinearLayout mTextArea;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView mFirstLineTextZeroDay;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView mSecondLineTextZeroDay;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView mFirstLineText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView mFirstLineExtend;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TickerView mSecondLineFirstText;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView mSecondLineSecondText;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinearLayout mFirstLabel;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView mFirstLabelFirstText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView mFirstLabelSecondText;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View mFirstLabelBorder;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private Resources resources;

    public o(@NotNull View mRootView) {
        Intrinsics.checkNotNullParameter(mRootView, "mRootView");
        this.mRootView = mRootView;
        View findViewById = mRootView.findViewById(R.id.xpx);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R\u2026mate_header_card_root_bg)");
        this.mCardRootBgView = findViewById;
        View findViewById2 = mRootView.findViewById(R.id.xpw);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R\u2026.intimate_header_card_bg)");
        this.mCardBgView = (ImageView) findViewById2;
        View findViewById3 = mRootView.findViewById(R.id.xqe);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R\u2026ntimate_header_text_area)");
        this.mTextArea = (LinearLayout) findViewById3;
        View findViewById4 = mRootView.findViewById(R.id.f165833xq3);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R\u2026e_header_first_line_0day)");
        this.mFirstLineTextZeroDay = (TextView) findViewById4;
        View findViewById5 = mRootView.findViewById(R.id.xq8);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mRootView.findViewById(R\u2026_header_second_line_0day)");
        this.mSecondLineTextZeroDay = (TextView) findViewById5;
        View findViewById6 = mRootView.findViewById(R.id.xq5);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "mRootView.findViewById(R\u2026e_header_first_line_text)");
        this.mFirstLineText = (TextView) findViewById6;
        View findViewById7 = mRootView.findViewById(R.id.f165834xq4);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "mRootView.findViewById(R\u2026header_first_line_extend)");
        this.mFirstLineExtend = (TextView) findViewById7;
        View findViewById8 = mRootView.findViewById(R.id.xq9);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "mRootView.findViewById(R\u2026eader_second_line_bignum)");
        this.mSecondLineFirstText = (TickerView) findViewById8;
        View findViewById9 = mRootView.findViewById(R.id.xq_);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "mRootView.findViewById(R\u2026_header_second_line_text)");
        this.mSecondLineSecondText = (TextView) findViewById9;
        View findViewById10 = mRootView.findViewById(R.id.xpy);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "mRootView.findViewById(R\u2026imate_header_first_label)");
        this.mFirstLabel = (LinearLayout) findViewById10;
        View findViewById11 = mRootView.findViewById(R.id.f165830xq0);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "mRootView.findViewById(R\u2026r_first_label_first_text)");
        this.mFirstLabelFirstText = (TextView) findViewById11;
        View findViewById12 = mRootView.findViewById(R.id.f165831xq1);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "mRootView.findViewById(R\u2026_first_label_second_text)");
        this.mFirstLabelSecondText = (TextView) findViewById12;
        View findViewById13 = mRootView.findViewById(R.id.xpz);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "mRootView.findViewById(R\u2026eader_first_label_border)");
        this.mFirstLabelBorder = findViewById13;
        this.resources = mRootView.getResources();
    }

    public boolean a(int type) {
        return IntimateHeaderCardUtil.M(type);
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public void b(@NotNull g model) {
        RelativeLayout.LayoutParams layoutParams;
        boolean z16;
        Intrinsics.checkNotNullParameter(model, "model");
        if (QQTheme.isVasTheme()) {
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = this.mTextArea.getLayoutParams();
        if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.topMargin = 0;
            layoutParams.addRule(15);
        }
        this.mSecondLineTextZeroDay.setText(HardCodeUtil.qqStr(R.string.f161071wq) + IntimateHeaderCardUtil.p(model.getType(), model.getLevel()));
        this.mFirstLineText.setText(IntimateHeaderCardUtil.p(model.getType(), model.getLevel()));
        int color = this.resources.getColor(R.color.qui_common_text_allwhite_primary);
        String q16 = IntimateHeaderCardUtil.q(model.getType());
        if (q16 != null && q16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            try {
                color = Color.parseColor(q16);
            } catch (Exception e16) {
                QLog.e("WangZheCardAdapter", 1, "parseColor error:", e16);
            }
        }
        this.mFirstLineTextZeroDay.setTextColor(color);
        this.mSecondLineTextZeroDay.setTextColor(color);
        this.mFirstLineText.setTextColor(color);
        this.mFirstLineExtend.setTextColor(color);
        this.mSecondLineFirstText.setTextColor(color);
        this.mSecondLineSecondText.setTextColor(color);
        this.mFirstLabelFirstText.setTextColor(color);
        this.mFirstLabelSecondText.setTextColor(color);
        this.mFirstLineExtend.setBackgroundResource(R.drawable.f160884ju3);
        this.mFirstLabel.setBackgroundResource(R.drawable.f160884ju3);
        this.mFirstLabelBorder.setBackgroundResource(R.drawable.ju8);
        this.mCardBgView.setAlpha(1.0f);
        IntimateHeaderCardUtil.X(this.mCardBgView, IntimateHeaderCardUtil.b(model.getType()), new ColorDrawable(0));
        IntimateHeaderCardUtil.X(this.mCardRootBgView, IntimateHeaderCardUtil.e(model.getType(), model.getLevel()), this.resources.getDrawable(R.drawable.juf));
    }
}
