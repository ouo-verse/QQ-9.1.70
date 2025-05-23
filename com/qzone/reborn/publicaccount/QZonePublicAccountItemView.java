package com.qzone.reborn.publicaccount;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.heytap.databaseengine.utils.DateUtil;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.qzone.util.ar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import cooperation.qzone.report.lp.LpReportInfo_dc02880;
import cooperation.qzone.report.lp.LpReportManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import om.a;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0017\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0003J\b\u0010\f\u001a\u00020\u0004H\u0016J\u001a\u0010\u000f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0004H\u0014R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R(\u0010!\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0016@RX\u0096\u000e\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R4\u0010(\u001a\n\u0018\u00010\"j\u0004\u0018\u0001`#2\u000e\u0010\u001c\u001a\n\u0018\u00010\"j\u0004\u0018\u0001`#8\u0016@RX\u0096\u000e\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0014\u0010*\u001a\u00020\u001b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010 \u00a8\u0006/"}, d2 = {"Lcom/qzone/reborn/publicaccount/QZonePublicAccountItemView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Lmm/a;", "Lom/a$b;", "", "viewType", "", "n0", "o0", "", "time", "p0", "getLayoutId", "data", com.tencent.luggage.wxa.c8.c.G, "setData", "itemData", "m0", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "mCalendarView", "", "Lom/a;", "f", "Ljava/util/List;", "mDecoratorList", "", "<set-?>", tl.h.F, "Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Ljava/lang/String;", "calendarTime", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "i", "Ljava/lang/StringBuilder;", "W", "()Ljava/lang/StringBuilder;", "itemTypeBuilder", "c0", "itemTypeList", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZonePublicAccountItemView extends QZoneBaseWidgetView<mm.a> implements a.b {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView mCalendarView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final List<om.a> mDecoratorList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String calendarTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private StringBuilder itemTypeBuilder;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZonePublicAccountItemView(Context context, int i3) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mDecoratorList = new ArrayList();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(ar.e(16.0f), ar.e(16.0f), ar.e(16.0f), ar.e(8.0f));
        setLayoutParams(layoutParams);
        n0(i3);
    }

    private final void o0() {
        LpReportInfo_dc02880 lpReportInfo_dc02880 = new LpReportInfo_dc02880(14, 1);
        lpReportInfo_dc02880.item_type = c0();
        lpReportInfo_dc02880.reserves2 = getCalendarTime();
        LpReportManager.getInstance().reportToDC02880(lpReportInfo_dc02880, false, false);
    }

    private final void p0(long time) {
        boolean startsWith$default;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM\u6708dd\u65e5");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(DateUtil.DATE_FORMAT_8);
        long j3 = time * 1000;
        String str = simpleDateFormat.format(new Date(j3));
        Intrinsics.checkNotNullExpressionValue(str, "str");
        TextView textView = null;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "0", false, 2, null);
        if (startsWith$default) {
            Intrinsics.checkNotNullExpressionValue(str, "str");
            str = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).substring(startIndex)");
        }
        this.calendarTime = simpleDateFormat2.format(new Date(j3));
        if (TextUtils.isEmpty(str)) {
            TextView textView2 = this.mCalendarView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCalendarView");
            } else {
                textView = textView2;
            }
            textView.setVisibility(8);
            return;
        }
        TextView textView3 = this.mCalendarView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCalendarView");
            textView3 = null;
        }
        textView3.setText(str);
        TextView textView4 = this.mCalendarView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCalendarView");
        } else {
            textView = textView4;
        }
        textView.setVisibility(0);
    }

    @Override // om.a.b
    /* renamed from: W, reason: from getter */
    public StringBuilder getItemTypeBuilder() {
        return this.itemTypeBuilder;
    }

    @Override // om.a.b
    public String c0() {
        if (getItemTypeBuilder() == null) {
            return "";
        }
        return String.valueOf(getItemTypeBuilder());
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.cnk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void bindData(mm.a itemData, int pos) {
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        p0(itemData.b());
        this.itemTypeBuilder = new StringBuilder();
        int size = itemData.c().size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mDecoratorList.get(i3).a(itemData.c().get(i3), pos);
        }
        o0();
    }

    @Override // om.a.b
    /* renamed from: q, reason: from getter */
    public String getCalendarTime() {
        return this.calendarTime;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void setData(mm.a data, int pos) {
        super.setData((QZonePublicAccountItemView) data, pos);
    }

    private final void n0(int viewType) {
        if (viewType == 1) {
            this.mDecoratorList.add(new om.d(this));
        } else if (viewType == 2 || viewType == 3 || viewType == 4) {
            this.mDecoratorList.add(new om.d(this));
            for (int i3 = 1; i3 < viewType; i3++) {
                if (i3 > 1) {
                    i.f58780a.a(this);
                }
                this.mDecoratorList.add(new om.f(this));
            }
        }
        View findViewById = findViewById(R.id.ni9);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tv_calender)");
        this.mCalendarView = (TextView) findViewById;
    }
}
