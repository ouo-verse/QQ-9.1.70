package com.tencent.mobileqq.zplan.card.impl.view.stagger.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.zplan.card.impl.view.stagger.view.StaggerLabelItemView;
import com.tencent.sqshow.zootopia.card.report.a;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pu4.g;
import pv4.s;
import tl.h;
import zf3.StaggerLabelItemData;
import zf3.b;
import zf3.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001/B\u000f\u0012\u0006\u0010+\u001a\u00020*\u00a2\u0006\u0004\b,\u0010-J0\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u001c\u0010%\u001a\n \"*\u0004\u0018\u00010!0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/stagger/view/StaggerLabelItemView;", "Landroid/widget/FrameLayout;", "", "", c.G, "", "selected", "Lzf3/f;", "data", "Lzf3/b;", "listener", "Lyf3/a;", IndividuationUrlHelper.UrlId.CARD_HOME, "", "b", "Landroid/widget/LinearLayout;", "d", "Landroid/widget/LinearLayout;", "mContentArea", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "e", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "mIcon", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "mTxt", "Landroid/graphics/drawable/GradientDrawable;", h.F, "Landroid/graphics/drawable/GradientDrawable;", "mSelectedBg", "i", "mNormalBg", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "kotlin.jvm.PlatformType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "mDrawableOpt", "Lcom/tencent/sqshow/zootopia/card/report/a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/sqshow/zootopia/card/report/a;", "reportHelper", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "D", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class StaggerLabelItemView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private final a reportHelper;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final LinearLayout mContentArea;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ZPlanMediaView mIcon;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final TextView mTxt;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final GradientDrawable mSelectedBg;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final GradientDrawable mNormalBg;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final URLDrawable.URLDrawableOptions mDrawableOpt;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaggerLabelItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        this.mContentArea = linearLayout;
        ZPlanMediaView zPlanMediaView = new ZPlanMediaView(context);
        this.mIcon = zPlanMediaView;
        TextView textView = new TextView(context);
        this.mTxt = textView;
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.mSelectedBg = gradientDrawable;
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        this.mNormalBg = gradientDrawable2;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = new ColorDrawable(0);
        this.mDrawableOpt = obtain;
        this.reportHelper = new a();
        textView.setTextSize(1, 12.0f);
        textView.setTextColor(-1);
        gradientDrawable.setColors(new int[]{Color.parseColor("#7644d7"), Color.parseColor("#584fd9")});
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TL_BR);
        d dVar = d.f452428a;
        gradientDrawable.setCornerRadius(dVar.s() / 2);
        gradientDrawable2.setStroke(i.a(0.5f), Color.parseColor("#D6DAED"));
        gradientDrawable2.setColor(-1);
        gradientDrawable2.setCornerRadius(dVar.s() / 2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.leftMargin = dVar.r();
        layoutParams.rightMargin = dVar.r();
        addView(linearLayout, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i.a(14.5f), i.a(14.5f));
        layoutParams2.gravity = 16;
        linearLayout.addView(zPlanMediaView, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 16;
        layoutParams3.leftMargin = i.b(5);
        textView.setPadding(0, 0, 0, i.b(1));
        linearLayout.addView(textView, layoutParams3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(StaggerLabelItemData data, StaggerLabelItemView this$0, yf3.a card, int i3, b listener, View view) {
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(card, "$card");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        HashMap<String, Object> hashMap = new HashMap<>();
        String str = data.getLabelBtnInfo().f427648f;
        Intrinsics.checkNotNullExpressionValue(str, "data.labelBtnInfo.id");
        hashMap.put("zplan_tab_id", str);
        String str2 = data.getLabelBtnInfo().f427643a;
        Intrinsics.checkNotNullExpressionValue(str2, "data.labelBtnInfo.name");
        hashMap.put("zplan_tab_name", str2);
        this$0.reportHelper.a(this$0, card.b(), i3, "2", card.a(), new s(), hashMap, "em_zplan_tab_btn");
        listener.a(card, i3, data);
    }

    public void b(final int pos, boolean selected, final StaggerLabelItemData data, final b listener, final yf3.a card) {
        GradientDrawable gradientDrawable;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(card, "card");
        if (selected) {
            this.mTxt.setTextColor(-1);
            gradientDrawable = this.mSelectedBg;
        } else {
            this.mTxt.setTextColor(Color.parseColor("#868686"));
            gradientDrawable = this.mNormalBg;
        }
        setBackground(gradientDrawable);
        this.mTxt.setText(data.getLabelBtnInfo().f427643a);
        if (data.getLabelBtnInfo().f427647e == null) {
            this.mIcon.setVisibility(8);
        } else {
            this.mIcon.setVisibility(0);
            ZPlanMediaView zPlanMediaView = this.mIcon;
            g gVar = data.getLabelBtnInfo().f427647e;
            Intrinsics.checkNotNullExpressionValue(gVar, "data.labelBtnInfo.material");
            zPlanMediaView.e(gVar);
        }
        aa.d(this, new View.OnClickListener() { // from class: bg3.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StaggerLabelItemView.c(StaggerLabelItemData.this, this, card, pos, listener, view);
            }
        });
        HashMap hashMap = new HashMap();
        String str = data.getLabelBtnInfo().f427648f;
        Intrinsics.checkNotNullExpressionValue(str, "data.labelBtnInfo.id");
        hashMap.put("zplan_tab_id", str);
        String str2 = data.getLabelBtnInfo().f427643a;
        Intrinsics.checkNotNullExpressionValue(str2, "data.labelBtnInfo.name");
        hashMap.put("zplan_tab_name", str2);
        this.reportHelper.c(this, card.b(), pos, "2", card.a(), new s(), (r24 & 64) != 0 ? new HashMap() : hashMap, (r24 & 128) != 0 ? "em_zplan_element" : "em_zplan_tab_btn", (r24 & 256) != 0 ? null : null, (r24 & 512) != 0);
    }
}
