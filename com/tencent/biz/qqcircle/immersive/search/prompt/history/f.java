package com.tencent.biz.qqcircle.immersive.search.prompt.history;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QFSSearchHistoryItemInfo;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.bean.QFSSearchInfo;
import com.tencent.biz.qqcircle.utils.cf;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J(\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/search/prompt/history/f;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/biz/qqcircle/beans/QFSSearchHistoryItemInfo;", "info", "", "position", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "showDelete", "Lcooperation/qqcircle/report/QCircleReportBean;", "reportBean", DomainData.DOMAIN_NAME, "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "tvText", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "ivDelete", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class f extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private final TextView tvText;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private final ImageView ivDelete;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.tvText = (TextView) itemView.findViewById(R.id.f53942dv);
        this.ivDelete = (ImageView) itemView.findViewById(R.id.f53922dt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(QFSSearchHistoryItemInfo info, QCircleReportBean qCircleReportBean, View view) {
        PartManager partManager;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(info, "$info");
        QFSSearchInfo qFSSearchInfo = new QFSSearchInfo();
        qFSSearchInfo.k(info.searchHistoryWord);
        qFSSearchInfo.j(2);
        QCircleBaseFragment qCircleBaseFragment = QCirclePluginUtil.getQCircleBaseFragment(view.getContext());
        if (qCircleBaseFragment != null && (partManager = qCircleBaseFragment.getPartManager()) != null) {
            partManager.broadcastMessage("qfs_search_words_auto_complete", qFSSearchInfo);
        }
        cf.a(view.getContext(), 5106, qCircleReportBean, QCircleReportBean.getPageId("", qCircleReportBean), info.searchHistoryWord);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(QFSSearchHistoryItemInfo info, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(info, "$info");
        com.tencent.biz.qqcircle.manager.k.d().c(info.searchHistoryWord);
        VideoReport.setElementId(view, "em_xsj_delete_button");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_clck", view, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void q(QFSSearchHistoryItemInfo info, int position) {
        HashMap hashMap = new HashMap();
        hashMap.put("xsj_item_index", Integer.valueOf(position));
        String str = info.searchHistoryWord;
        Intrinsics.checkNotNullExpressionValue(str, "info.searchHistoryWord");
        hashMap.put("xsj_query_text", str);
        TextView textView = this.tvText;
        if (textView != null) {
            ua0.i.k(textView, QCircleDaTongConstant.ElementId.EM_XSJ_SEARCH_HISTORY_WORD, hashMap, info.hashCode());
        }
        ImageView imageView = this.ivDelete;
        if (imageView != null) {
            ua0.i.k(imageView, "em_xsj_delete_button", hashMap, info.hashCode());
        }
    }

    public final void n(@NotNull final QFSSearchHistoryItemInfo info, boolean showDelete, int position, @Nullable final QCircleReportBean reportBean) {
        Intrinsics.checkNotNullParameter(info, "info");
        TextView textView = this.tvText;
        if (textView != null) {
            textView.setText(info.showText);
        }
        TextView textView2 = this.tvText;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.search.prompt.history.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    f.o(QFSSearchHistoryItemInfo.this, reportBean, view);
                }
            });
        }
        ImageView imageView = this.ivDelete;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.search.prompt.history.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    f.p(QFSSearchHistoryItemInfo.this, view);
                }
            });
        }
        if (showDelete) {
            ImageView imageView2 = this.ivDelete;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
        } else {
            ImageView imageView3 = this.ivDelete;
            if (imageView3 != null) {
                imageView3.setVisibility(8);
            }
        }
        q(info, position);
    }
}
