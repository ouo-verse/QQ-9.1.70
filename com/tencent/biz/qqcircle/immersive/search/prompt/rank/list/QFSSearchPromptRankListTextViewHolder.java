package com.tencent.biz.qqcircle.immersive.search.prompt.rank.list;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import circlesearch.CircleSearchExhibition$JumpInfo;
import circlesearch.CircleSearchExhibition$TextIconStyleData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.immersive.bean.QFSSearchInfo;
import com.tencent.biz.qqcircle.immersive.views.search.util.ad;
import com.tencent.biz.qqcircle.immersive.views.search.util.p;
import com.tencent.biz.qqcircle.utils.cf;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleReportBean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0019\u0012\u0006\u0010\u0019\u001a\u00020\u0013\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0011\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/search/prompt/rank/list/QFSSearchPromptRankListTextViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcirclesearch/CircleSearchExhibition$TextIconStyleData;", "data", "", "p", DomainData.DOMAIN_NAME, "Lcooperation/qqcircle/report/QCircleReportBean;", "E", "Lcooperation/qqcircle/report/QCircleReportBean;", "reportBean", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "indexView", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "titleView", "Landroid/view/View;", "H", "Landroid/view/View;", "labelLayout", "I", "labelTextView", "itemView", "<init>", "(Landroid/view/View;Lcooperation/qqcircle/report/QCircleReportBean;)V", "J", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSSearchPromptRankListTextViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private final QCircleReportBean reportBean;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private final ImageView indexView;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private final TextView titleView;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private final View labelLayout;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private final TextView labelTextView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSSearchPromptRankListTextViewHolder(@NotNull View itemView, @Nullable QCircleReportBean qCircleReportBean) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.reportBean = qCircleReportBean;
        this.indexView = (ImageView) itemView.findViewById(R.id.f43831nj);
        this.titleView = (TextView) itemView.findViewById(R.id.f53482cm);
        this.labelLayout = itemView.findViewById(R.id.f43851nl);
        this.labelTextView = (TextView) itemView.findViewById(R.id.f43881no);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(CircleSearchExhibition$TextIconStyleData data, final QFSSearchPromptRankListTextViewHolder this$0, final View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b bVar = b.f89965a;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        CircleSearchExhibition$JumpInfo circleSearchExhibition$JumpInfo = data.jumpInfo;
        Intrinsics.checkNotNullExpressionValue(circleSearchExhibition$JumpInfo, "data.jumpInfo");
        bVar.b(context, circleSearchExhibition$JumpInfo, new Function1<QFSSearchInfo, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.search.prompt.rank.list.QFSSearchPromptRankListTextViewHolder$bindData$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QFSSearchInfo qFSSearchInfo) {
                invoke2(qFSSearchInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QFSSearchInfo searchInfo) {
                QCircleReportBean qCircleReportBean;
                QCircleReportBean qCircleReportBean2;
                Intrinsics.checkNotNullParameter(searchInfo, "searchInfo");
                Context context2 = view.getContext();
                qCircleReportBean = this$0.reportBean;
                qCircleReportBean2 = this$0.reportBean;
                cf.a(context2, 5108, qCircleReportBean, qCircleReportBean2 != null ? qCircleReportBean2.getPageId() : 0, searchInfo.f());
            }
        });
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void p(CircleSearchExhibition$TextIconStyleData data) {
        boolean z16;
        String text = data.icon.text.get();
        Integer F = p.F(data.icon.text_color.get());
        Integer F2 = p.F(data.icon.background_color.get());
        Intrinsics.checkNotNullExpressionValue(text, "text");
        if (text.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && F != null && F2 != null) {
            TextView textView = this.labelTextView;
            if (textView != null) {
                textView.setText(text);
            }
            TextView textView2 = this.labelTextView;
            if (textView2 != null) {
                textView2.setTextColor(F.intValue());
            }
            View view = this.labelLayout;
            if (view != null) {
                view.setBackground(ad.f(F2.intValue(), 3, 16, 16));
            }
            View view2 = this.labelLayout;
            if (view2 != null) {
                view2.setVisibility(0);
                return;
            }
            return;
        }
        View view3 = this.labelLayout;
        if (view3 != null) {
            view3.setVisibility(8);
        }
    }

    public final void n(@NotNull final CircleSearchExhibition$TextIconStyleData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        ImageView imageView = this.indexView;
        if (imageView != null) {
            ca0.a.c(imageView, data.rankImg.get());
        }
        TextView textView = this.titleView;
        if (textView != null) {
            textView.setText(data.text.get());
        }
        p(data);
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.search.prompt.rank.list.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSSearchPromptRankListTextViewHolder.o(CircleSearchExhibition$TextIconStyleData.this, this, view);
            }
        });
    }
}
