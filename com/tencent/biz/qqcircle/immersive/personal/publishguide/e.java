package com.tencent.biz.qqcircle.immersive.personal.publishguide;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.widgets.QCircleRoundImageView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010&\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b'\u0010(J*\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0015\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0017\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u001a\u0010\u001d\u001a\u00020\u00188\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010 \u001a\u00020\u00188\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u001cR\u001c\u0010\"\u001a\n \u0012*\u0004\u0018\u00010\u00180\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u001aR\u0016\u0010%\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006)"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/e;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "view", "", "elementId", "Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/a;", "bannerInfo", "", "onlyClick", "", ReportConstant.COSTREPORT_PREFIX, "o", "Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/f;", "E", "Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/f;", "listener", "Lcom/tencent/biz/qqcircle/widgets/QCircleRoundImageView;", "kotlin.jvm.PlatformType", UserInfo.SEX_FEMALE, "Lcom/tencent/biz/qqcircle/widgets/QCircleRoundImageView;", "ivIcon", "G", "ivIconHot", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "tvTitle", "I", "getTvSubtitle", "tvSubtitle", "J", "tvAction", "K", "Landroid/view/View;", "closeBtn", "itemView", "<init>", "(Landroid/view/View;Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/f;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public class e extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final f listener;

    /* renamed from: F, reason: from kotlin metadata */
    private final QCircleRoundImageView ivIcon;

    /* renamed from: G, reason: from kotlin metadata */
    private final QCircleRoundImageView ivIconHot;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final TextView tvTitle;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final TextView tvSubtitle;

    /* renamed from: J, reason: from kotlin metadata */
    private final TextView tvAction;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private final View closeBtn;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull View itemView, @NotNull f listener) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        QCircleRoundImageView qCircleRoundImageView = (QCircleRoundImageView) itemView.findViewById(R.id.dvu);
        this.ivIcon = qCircleRoundImageView;
        QCircleRoundImageView qCircleRoundImageView2 = (QCircleRoundImageView) itemView.findViewById(R.id.y4s);
        this.ivIconHot = qCircleRoundImageView2;
        View findViewById = itemView.findViewById(R.id.kbs);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.tv_title)");
        this.tvTitle = (TextView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.f167057me2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.tv_subtitle)");
        this.tvSubtitle = (TextView) findViewById2;
        this.tvAction = (TextView) itemView.findViewById(R.id.k56);
        this.closeBtn = itemView.findViewById(R.id.dum);
        qCircleRoundImageView.setRoundRect(e83.a.b(4));
        qCircleRoundImageView2.setRoundRect(e83.a.b(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(e this$0, BannerInfo bannerInfo, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bannerInfo, "$bannerInfo");
        this$0.listener.a(bannerInfo);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(e this$0, BannerInfo bannerInfo, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bannerInfo, "$bannerInfo");
        this$0.listener.a(bannerInfo);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(e this$0, BannerInfo bannerInfo, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bannerInfo, "$bannerInfo");
        this$0.listener.b(bannerInfo);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void s(View view, String elementId, BannerInfo bannerInfo, boolean onlyClick) {
        ExposurePolicy exposurePolicy;
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, elementId);
        VideoReport.setElementReuseIdentifier(view, bannerInfo.getId());
        if (onlyClick) {
            exposurePolicy = ExposurePolicy.REPORT_NONE;
        } else {
            exposurePolicy = ExposurePolicy.REPORT_FIRST;
        }
        VideoReport.setElementExposePolicy(view, exposurePolicy);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementParams(view, bannerInfo.c());
    }

    public void o(@NotNull final BannerInfo bannerInfo) {
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        QCircleFeedPicLoader g16 = QCircleFeedPicLoader.g();
        Option obtain = Option.obtain();
        obtain.setTargetView(this.ivIcon);
        obtain.setUrl(bannerInfo.getBackgroundImg());
        obtain.setNeedShowLoadingDrawable(false);
        g16.loadImage(obtain);
        if (!TextUtils.isEmpty(bannerInfo.getHotIcon())) {
            QCircleFeedPicLoader g17 = QCircleFeedPicLoader.g();
            Option obtain2 = Option.obtain();
            obtain2.setTargetView(this.ivIconHot);
            obtain2.setUrl(bannerInfo.getHotIcon());
            obtain2.setNeedShowLoadingDrawable(false);
            this.ivIconHot.setVisibility(0);
            g17.loadImage(obtain2);
        }
        this.tvTitle.setText(bannerInfo.getTitle());
        this.tvSubtitle.setText(bannerInfo.getDesc());
        this.tvAction.setText(bannerInfo.getButtonText());
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.personal.publishguide.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.p(e.this, bannerInfo, view);
            }
        });
        this.tvAction.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.personal.publishguide.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.q(e.this, bannerInfo, view);
            }
        });
        View view = this.closeBtn;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.personal.publishguide.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    e.r(e.this, bannerInfo, view2);
                }
            });
        }
        s(this.itemView, QCircleDaTongConstant.ElementId.EM_XSJ_MATERIAL_BANNER, bannerInfo, false);
        s(this.tvAction, QCircleDaTongConstant.ElementId.EM_XSJ_MATERIAL_BANNER_BUTTON, bannerInfo, true);
        s(this.closeBtn, QCircleDaTongConstant.ElementId.EM_XSJ_BANNER_CLOSE_BUTTON, bannerInfo, true);
    }
}
