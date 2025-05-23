package com.tencent.mobileqq.zplan.aigc.view.viewHolder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zplan.aigc.data.Imagery;
import com.tencent.mobileqq.zplan.aigc.view.CircleView;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 62\u00020\u0001:\u00017B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b4\u00105J}\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2K\u0010\u0010\u001aG\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\f\u0012\b\b\n\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\f\u0012\b\b\n\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\f\u0012\b\b\n\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u000f0\u000bH\u0007R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010#\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\"R\u001b\u0010(\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010\u001c\u001a\u0004\b&\u0010'R\u001b\u0010+\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010\u001c\u001a\u0004\b*\u0010\u001eR\u001b\u00100\u001a\u00020,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010\u001c\u001a\u0004\b.\u0010/R\u0016\u00103\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010)\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/view/viewHolder/SuitImageryHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lzd3/a;", "dtReporter", "Lcom/tencent/mobileqq/zplan/aigc/data/i;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "itemId", "position", "", "name", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "Landroid/widget/ImageView;", "imageView", "", "onItemClick", DomainData.DOMAIN_NAME, "Landroid/content/Context;", "E", "Landroid/content/Context;", "context", "Landroid/view/View;", UserInfo.SEX_FEMALE, "Landroid/view/View;", "v", "Landroid/widget/TextView;", "G", "Lkotlin/Lazy;", ReportConstant.COSTREPORT_PREFIX, "()Landroid/widget/TextView;", "tvSpell", "H", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroid/widget/ImageView;", "cover", "Landroid/widget/LinearLayout;", "I", "getContainer", "()Landroid/widget/LinearLayout;", ParseCommon.CONTAINER, "J", "r", "tvColor", "Lcom/tencent/mobileqq/zplan/aigc/view/CircleView;", "K", "p", "()Lcom/tencent/mobileqq/zplan/aigc/view/CircleView;", "colorShow", "", "L", "lastClickTime", "<init>", "(Landroid/content/Context;Landroid/view/View;)V", "M", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SuitImageryHolder extends RecyclerView.ViewHolder {
    private static final String N = "SuitImageryHolder";

    /* renamed from: E, reason: from kotlin metadata */
    private final Context context;

    /* renamed from: F, reason: from kotlin metadata */
    private final View v;

    /* renamed from: G, reason: from kotlin metadata */
    private final Lazy tvSpell;

    /* renamed from: H, reason: from kotlin metadata */
    private final Lazy cover;

    /* renamed from: I, reason: from kotlin metadata */
    private final Lazy container;

    /* renamed from: J, reason: from kotlin metadata */
    private final Lazy tvColor;

    /* renamed from: K, reason: from kotlin metadata */
    private final Lazy colorShow;

    /* renamed from: L, reason: from kotlin metadata */
    private long lastClickTime;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuitImageryHolder(Context context, View v3) {
        super(v3);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(v3, "v");
        this.context = context;
        this.v = v3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.zplan.aigc.view.viewHolder.SuitImageryHolder$tvSpell$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                View view;
                view = SuitImageryHolder.this.v;
                return (TextView) view.findViewById(R.id.qtm);
            }
        });
        this.tvSpell = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.zplan.aigc.view.viewHolder.SuitImageryHolder$cover$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                View view;
                view = SuitImageryHolder.this.v;
                return (ImageView) view.findViewById(R.id.q18);
            }
        });
        this.cover = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.zplan.aigc.view.viewHolder.SuitImageryHolder$container$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                View view;
                view = SuitImageryHolder.this.v;
                return (LinearLayout) view.findViewById(R.id.q1h);
            }
        });
        this.container = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.zplan.aigc.view.viewHolder.SuitImageryHolder$tvColor$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                View view;
                view = SuitImageryHolder.this.v;
                return (TextView) view.findViewById(R.id.qta);
            }
        });
        this.tvColor = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<CircleView>() { // from class: com.tencent.mobileqq.zplan.aigc.view.viewHolder.SuitImageryHolder$colorShow$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CircleView invoke() {
                View view;
                view = SuitImageryHolder.this.v;
                return (CircleView) view.findViewById(R.id.pl8);
            }
        });
        this.colorShow = lazy5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(SuitImageryHolder this$0, Imagery item, Function3 onItemClick, int i3, Map doneReportParams, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(onItemClick, "$onItemClick");
        Intrinsics.checkNotNullParameter(doneReportParams, "$doneReportParams");
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this$0.lastClickTime > 500) {
            this$0.lastClickTime = currentTimeMillis;
            onItemClick.invoke(item, this$0.q(), Integer.valueOf(i3));
            VideoReport.reportEvent("dt_clck", this$0.v, doneReportParams);
        }
    }

    private final CircleView p() {
        Object value = this.colorShow.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-colorShow>(...)");
        return (CircleView) value;
    }

    private final ImageView q() {
        Object value = this.cover.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-cover>(...)");
        return (ImageView) value;
    }

    private final TextView r() {
        Object value = this.tvColor.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-tvColor>(...)");
        return (TextView) value;
    }

    private final TextView s() {
        Object value = this.tvSpell.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-tvSpell>(...)");
        return (TextView) value;
    }

    public final void n(zd3.a dtReporter, final Imagery item, int itemId, final int position, String name, final Function3<? super Imagery, ? super ImageView, ? super Integer, Unit> onItemClick) {
        Intrinsics.checkNotNullParameter(dtReporter, "dtReporter");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("zplan_click_keywords_text", name);
        linkedHashMap.put("dt_pgid", "pg_zplan_create_new");
        String valueOf = String.valueOf(item.getBackgroundUrl());
        zd3.a.y(dtReporter, this.v, "em_zplan_keywords", linkedHashMap, null, 8, null);
        s().setText(name);
        r().setVisibility(8);
        p().setVisibility(8);
        this.v.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aigc.view.viewHolder.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuitImageryHolder.o(SuitImageryHolder.this, item, onItemClick, position, linkedHashMap, view);
            }
        });
        try {
            Result.Companion companion = Result.INSTANCE;
            q().setScaleType(ImageView.ScaleType.CENTER_CROP);
            ImageView q16 = q();
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = this.context.getDrawable(R.drawable.idr);
            obtain.mFailedDrawable = this.context.getDrawable(R.drawable.idr);
            obtain.mGifRoundCorner = 2.0f;
            Unit unit = Unit.INSTANCE;
            q16.setImageDrawable(URLDrawable.getDrawable(valueOf, obtain));
            Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
    }
}
