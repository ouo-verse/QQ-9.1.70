package com.tenpay.sdk.hbdetail;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import ccom.tencent.mobileqq.pb.qwallet.HbExpandReportPB$ReportReq;
import ccom.tencent.mobileqq.pb.qwallet.HbExpandReportPB$ReportRsp;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.nearbypro.profile.avatar.MyNearbyProBizScene;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qwallet.utils.g;
import com.tencent.mobileqq.qwallet.utils.k;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tenpay.sdk.hbdetail.HbDetailRsp;
import com.tenpay.sdk.net.gateway.QWalletGatewayServlet;
import cooperation.qwallet.plugin.QWalletPicHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 !2\u00020\u0001:\u0002!\"B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u001c\u0010\u001d\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0018\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u0011\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006#"}, d2 = {"Lcom/tenpay/sdk/hbdetail/HbDetailPopContainer;", "", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "closeButton", "Landroid/widget/ImageView;", "getCloseButton", "()Landroid/widget/ImageView;", "popButton", "Landroid/widget/Button;", "getPopButton", "()Landroid/widget/Button;", "popDesc", "Landroid/widget/TextView;", "getPopDesc", "()Landroid/widget/TextView;", "popIcon", "getPopIcon", "popView", "Landroid/view/ViewGroup;", "getPopView", "()Landroid/view/ViewGroup;", "bindBubbleData", "", "listId", "", "bubbleData", "Lcom/tenpay/sdk/hbdetail/HbDetailRsp$HbOperationBubble;", "getHbBubbleId", "report", AdMetricTag.Report.TYPE, "Lcom/tenpay/sdk/hbdetail/HbDetailPopContainer$ReportType;", "Companion", "ReportType", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class HbDetailPopContainer {

    @NotNull
    private static final String KEY_LAST_HB_DETAiL_POP_CLOSE = "qwallet_last_hb_detail_pop_close_";

    @NotNull
    private static final String KEY_LAST_HB_DETAiL_POP_EXPOSE = "qwallet_last_hb_detail_pop_expose_";

    @NotNull
    private static final String TAG = "HbDetailPopContainer";

    @NotNull
    private final ImageView closeButton;

    @NotNull
    private final Button popButton;

    @NotNull
    private final TextView popDesc;

    @NotNull
    private final ImageView popIcon;

    @NotNull
    private final ViewGroup popView;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tenpay/sdk/hbdetail/HbDetailPopContainer$ReportType;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "UNKNOWN_REPORTTYPE", "EXPOSE", MyNearbyProBizScene.CLICK, "NEGATIVE_FEEDBACK", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public enum ReportType {
        UNKNOWN_REPORTTYPE(0),
        EXPOSE(1),
        CLICK(2),
        NEGATIVE_FEEDBACK(3);

        private final int value;

        ReportType(int i3) {
            this.value = i3;
        }

        public final int getValue() {
            return this.value;
        }
    }

    public HbDetailPopContainer(@NotNull View itemView) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View findViewById = itemView.findViewById(R.id.x66);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.hb_detail_header_pop)");
        this.popView = (ViewGroup) findViewById;
        View findViewById2 = itemView.findViewById(R.id.x6e);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.hb_detail_pop_icon)");
        this.popIcon = (ImageView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.x6d);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.hb_detail_pop_desc)");
        this.popDesc = (TextView) findViewById3;
        View findViewById4 = itemView.findViewById(R.id.x6b);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.hb_detail_pop_button)");
        this.popButton = (Button) findViewById4;
        View findViewById5 = itemView.findViewById(R.id.x6c);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.hb_detail_pop_close)");
        this.closeButton = (ImageView) findViewById5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindBubbleData$lambda$0(HbDetailPopContainer this$0, HbDetailRsp.HbOperationBubble hbOperationBubble, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        k.h(this$0.popView.getContext(), hbOperationBubble.getUrl());
        this$0.report(ReportType.CLICK, hbOperationBubble);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindBubbleData$lambda$1(HbDetailPopContainer this$0, HbDetailRsp.HbOperationBubble hbOperationBubble, String currentBubbleId, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(currentBubbleId, "$currentBubbleId");
        this$0.report(ReportType.NEGATIVE_FEEDBACK, hbOperationBubble);
        this$0.popView.setVisibility(8);
        g.q(KEY_LAST_HB_DETAiL_POP_CLOSE + com.tencent.mobileqq.base.a.c(), currentBubbleId);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final String getHbBubbleId(String listId, HbDetailRsp.HbOperationBubble bubbleData) {
        String str;
        if (bubbleData != null) {
            str = bubbleData.getReportInfo();
        } else {
            str = null;
        }
        return listId + "-" + str;
    }

    private final void report(ReportType reportType, HbDetailRsp.HbOperationBubble bubbleData) {
        QLog.w(TAG, 1, "hbDetailBubble report: type=" + reportType + " reportInfo=" + bubbleData.getReportInfo() + " token=" + bubbleData.getToken());
        HbExpandReportPB$ReportReq hbExpandReportPB$ReportReq = new HbExpandReportPB$ReportReq();
        hbExpandReportPB$ReportReq.report_type.set(reportType.getValue());
        PBStringField pBStringField = hbExpandReportPB$ReportReq.report_info;
        String reportInfo = bubbleData.getReportInfo();
        String str = "";
        if (reportInfo == null) {
            reportInfo = "";
        }
        pBStringField.set(reportInfo);
        PBStringField pBStringField2 = hbExpandReportPB$ReportReq.token;
        String token = bubbleData.getToken();
        if (token != null) {
            str = token;
        }
        pBStringField2.set(str);
        QWalletGatewayServlet qWalletGatewayServlet = QWalletGatewayServlet.INSTANCE;
        pl2.c cVar = new pl2.c();
        Object newInstance = HbExpandReportPB$ReportRsp.class.newInstance();
        Intrinsics.checkNotNullExpressionValue(newInstance, "Rsp::class.java.newInstance()");
        qWalletGatewayServlet.sendRequest("trpc.qqhb.misc.HbExpandReport", "Report", hbExpandReportPB$ReportReq, (MessageMicro) newInstance, false, true, false, null, cVar);
    }

    public final void bindBubbleData(@Nullable String listId, @Nullable final HbDetailRsp.HbOperationBubble bubbleData) {
        if (bubbleData == null) {
            this.popView.setVisibility(8);
            return;
        }
        final String hbBubbleId = getHbBubbleId(listId, bubbleData);
        if (Intrinsics.areEqual(hbBubbleId, g.i(KEY_LAST_HB_DETAiL_POP_CLOSE + com.tencent.mobileqq.base.a.c()))) {
            this.popView.setVisibility(8);
            return;
        }
        this.popView.setVisibility(0);
        this.popIcon.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(bubbleData.getIcon()));
        this.popDesc.setText(bubbleData.getContent());
        try {
            this.popDesc.setTextColor(Color.parseColor(bubbleData.getContentColor()));
        } catch (Exception unused) {
            QLog.w(TAG, 1, "bubble contentColor is illegal: " + bubbleData.getContentColor());
        }
        this.popButton.setText(bubbleData.getButtonTxt());
        this.popButton.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.hbdetail.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HbDetailPopContainer.bindBubbleData$lambda$0(HbDetailPopContainer.this, bubbleData, view);
            }
        });
        if (!Intrinsics.areEqual(g.i(KEY_LAST_HB_DETAiL_POP_EXPOSE + com.tencent.mobileqq.base.a.c()), hbBubbleId)) {
            report(ReportType.EXPOSE, bubbleData);
            g.q(KEY_LAST_HB_DETAiL_POP_EXPOSE + com.tencent.mobileqq.base.a.c(), hbBubbleId);
        }
        BaseAIOUtils.g(this.closeButton, ViewUtils.dpToPx(25.0f));
        this.closeButton.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.hbdetail.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HbDetailPopContainer.bindBubbleData$lambda$1(HbDetailPopContainer.this, bubbleData, hbBubbleId, view);
            }
        });
    }

    @NotNull
    public final ImageView getCloseButton() {
        return this.closeButton;
    }

    @NotNull
    public final Button getPopButton() {
        return this.popButton;
    }

    @NotNull
    public final TextView getPopDesc() {
        return this.popDesc;
    }

    @NotNull
    public final ImageView getPopIcon() {
        return this.popIcon;
    }

    @NotNull
    public final ViewGroup getPopView() {
        return this.popView;
    }
}
