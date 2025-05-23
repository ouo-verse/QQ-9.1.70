package com.tencent.mobileqq.wink.picker.qzone;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.mobileqq.wink.picker.qzone.n;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qzone.QZoneHelper;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 92\u00020\u0001:\u0001:B\u000f\u0012\u0006\u00106\u001a\u00020\u000e\u00a2\u0006\u0004\b7\u00108J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J,\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000bj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\f2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002JV\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00040\u00142!\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00040\u0014H\u0016R\u001c\u0010\u001f\u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001c\u0010!\u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u001c\u0010%\u001a\n \u001c*\u0004\u0018\u00010\"0\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u001c\u0010)\u001a\n \u001c*\u0004\u0018\u00010&0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010+\u001a\n \u001c*\u0004\u0018\u00010\"0\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010$R\u001c\u0010-\u001a\n \u001c*\u0004\u0018\u00010&0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010(R\u001c\u0010/\u001a\n \u001c*\u0004\u0018\u00010&0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010(R\u001c\u00101\u001a\n \u001c*\u0004\u0018\u00010&0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010(R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qzone/p;", "Lcom/tencent/mobileqq/wink/picker/core/b;", "Lcom/tencent/mobileqq/wink/picker/qzone/n$a;", DownloadInfo.spKey_Config, "", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, DomainData.DOMAIN_NAME, "", "schemaStr", "r", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", ReportConstant.COSTREPORT_PREFIX, "Landroid/view/View;", "view", "u", "t", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "localMedia", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "v", "onItemClick", "onItemSelect", "l", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "E", "Landroid/widget/ImageView;", "bgIv", UserInfo.SEX_FEMALE, "maskIv", "Landroid/view/ViewGroup;", "G", "Landroid/view/ViewGroup;", "memoryAlbumContainer", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "memoryAlbumTv", "I", "tianShuContainer", "J", "tianShuBtnTv", "K", "tianShuTitleTv", "L", "tianShuDescTv", "", "M", "Z", "isExposed", "itemView", "<init>", "(Landroid/view/View;)V", "N", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class p extends com.tencent.mobileqq.wink.picker.core.b {

    /* renamed from: E, reason: from kotlin metadata */
    private final ImageView bgIv;

    /* renamed from: F, reason: from kotlin metadata */
    private final ImageView maskIv;

    /* renamed from: G, reason: from kotlin metadata */
    private final ViewGroup memoryAlbumContainer;

    /* renamed from: H, reason: from kotlin metadata */
    private final TextView memoryAlbumTv;

    /* renamed from: I, reason: from kotlin metadata */
    private final ViewGroup tianShuContainer;

    /* renamed from: J, reason: from kotlin metadata */
    private final TextView tianShuBtnTv;

    /* renamed from: K, reason: from kotlin metadata */
    private final TextView tianShuTitleTv;

    /* renamed from: L, reason: from kotlin metadata */
    private final TextView tianShuDescTv;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean isExposed;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.bgIv = (ImageView) itemView.findViewById(R.id.t6a);
        this.maskIv = (ImageView) itemView.findViewById(R.id.yxx);
        this.memoryAlbumContainer = (ViewGroup) itemView.findViewById(R.id.f166232z33);
        this.memoryAlbumTv = (TextView) itemView.findViewById(R.id.z39);
        this.tianShuContainer = (ViewGroup) itemView.findViewById(R.id.f97155jm);
        this.tianShuBtnTv = (TextView) itemView.findViewById(R.id.f97135jk);
        this.tianShuTitleTv = (TextView) itemView.findViewById(R.id.f97165jn);
        this.tianShuDescTv = (TextView) itemView.findViewById(R.id.f97145jl);
    }

    private final void n(n.RecommendItemConfig config) {
        Object bgUrl = config.getBgUrl();
        if (bgUrl instanceof Integer) {
            this.bgIv.setImageResource(((Number) bgUrl).intValue());
            if (Intrinsics.areEqual(bgUrl, Integer.valueOf(R.drawable.ntf))) {
                this.maskIv.setVisibility(8);
                return;
            } else {
                this.maskIv.setVisibility(0);
                return;
            }
        }
        if (bgUrl instanceof String) {
            Option option = Option.obtain();
            option.setTargetView(this.bgIv);
            option.setUrl((String) bgUrl);
            option.setLoadingDrawable(new ColorDrawable(0));
            option.setFailedDrawable(new ColorDrawable(0));
            QQPicLoader qQPicLoader = QQPicLoader.f201806a;
            Intrinsics.checkNotNullExpressionValue(option, "option");
            qQPicLoader.e(option, null);
            this.maskIv.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(n.RecommendItemConfig config, p this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(config, "$config");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w53.b.f("QZoneRecommendFirstItemViewHolder", "click QZoneRecommendFirstItemViewHolder: " + config.getSchema());
        if (!FastClickUtils.isFastDoubleClick("QZoneRecommendFirstItemViewHolder")) {
            this$0.r(config.getSchema());
            View itemView = this$0.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            this$0.t(itemView, config);
            n.f325197a.n(config, 102);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void p(n.RecommendItemConfig config) {
        this.memoryAlbumContainer.setVisibility(0);
        this.tianShuContainer.setVisibility(8);
        this.memoryAlbumTv.setText(config.getDesc());
        n(config);
    }

    private final void q(n.RecommendItemConfig config) {
        this.memoryAlbumContainer.setVisibility(8);
        this.tianShuContainer.setVisibility(0);
        this.tianShuBtnTv.setText(config.getBtnText());
        this.tianShuTitleTv.setText(config.getTitle());
        this.tianShuDescTv.setText(config.getDesc());
        n(config);
    }

    private final void r(String schemaStr) {
        boolean startsWith$default;
        Context context = this.itemView.getContext();
        QRouteApi api = QRoute.api(IQQWinkLauncher.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQQWinkLauncher::class.java)");
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Bundle fillInnerJumpBundle$default = IQQWinkLauncher.DefaultImpls.fillInnerJumpBundle$default((IQQWinkLauncher) api, context, null, 2, null);
        fillInnerJumpBundle$default.putInt(QZoneHelper.Constants.KEY_PUBLISH_COME_FROM, 3);
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(schemaStr, QCircleScheme.AttrQQPublish.PUBLISH_SCHEMA_PREFIX, false, 2, null);
        if (startsWith$default) {
            ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).jumpToQQWinkBySchema(context, QCircleScheme.Q_CIRCLE_ACTION_OPEN_QQPUBLISH, s(schemaStr), fillInnerJumpBundle$default);
            return;
        }
        Intent intent = new Intent(context, (Class<?>) JumpActivity.class);
        intent.setData(Uri.parse(schemaStr));
        intent.putExtras(fillInnerJumpBundle$default);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    private final HashMap<String, String> s(String schemaStr) {
        boolean z16;
        Uri parse = Uri.parse(schemaStr);
        Set<String> queryParameterNames = parse.getQueryParameterNames();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("key_scheme", schemaStr);
        for (String name : queryParameterNames) {
            boolean z17 = false;
            if (name != null && name.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                String queryParameter = parse.getQueryParameter(name);
                if (queryParameter == null || queryParameter.length() == 0) {
                    z17 = true;
                }
                if (!z17) {
                    Intrinsics.checkNotNullExpressionValue(name, "name");
                    hashMap.put(name, queryParameter);
                }
            }
        }
        return hashMap;
    }

    private final void t(View view, n.RecommendItemConfig config) {
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_QZ_OPEN_RECOMMEND);
        Map<String, Object> reportMap = WinkDTParamBuilder.buildElementParams();
        if (config.i()) {
            Intrinsics.checkNotNullExpressionValue(reportMap, "reportMap");
            reportMap.put(WinkDaTongReportConstant.ElementParamKey.RECOMMEND_TYPE, 1);
        } else {
            Intrinsics.checkNotNullExpressionValue(reportMap, "reportMap");
            reportMap.put(WinkDaTongReportConstant.ElementParamKey.RECOMMEND_TYPE, 2);
            reportMap.put("adID", config.getIADId());
        }
        VideoReport.reportEvent("dt_clck", view, reportMap);
    }

    private final void u(View view, n.RecommendItemConfig config) {
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_QZ_OPEN_RECOMMEND);
        Map<String, Object> reportMap = WinkDTParamBuilder.buildElementParams();
        if (config.i()) {
            Intrinsics.checkNotNullExpressionValue(reportMap, "reportMap");
            reportMap.put(WinkDaTongReportConstant.ElementParamKey.RECOMMEND_TYPE, 1);
        } else {
            Intrinsics.checkNotNullExpressionValue(reportMap, "reportMap");
            reportMap.put(WinkDaTongReportConstant.ElementParamKey.RECOMMEND_TYPE, 2);
            reportMap.put("adID", config.getIADId());
        }
        VideoReport.setElementParams(view, reportMap);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_FIRST);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.b
    public void l(@NotNull LocalMediaInfo localMedia, @NotNull Function1<? super View, Unit> onItemClick, @NotNull Function1<? super View, Unit> onItemSelect) {
        Intrinsics.checkNotNullParameter(localMedia, "localMedia");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        Intrinsics.checkNotNullParameter(onItemSelect, "onItemSelect");
        n nVar = n.f325197a;
        final n.RecommendItemConfig e16 = nVar.e(this.itemView.getContext());
        if (e16.i()) {
            p(e16);
        } else {
            q(e16);
        }
        if (!this.isExposed) {
            this.isExposed = true;
            nVar.n(e16, 101);
        }
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.qzone.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.o(n.RecommendItemConfig.this, this, view);
            }
        });
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        u(itemView, e16);
    }
}
