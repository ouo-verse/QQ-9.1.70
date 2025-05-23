package com.tencent.mobileqq.wink.api.impl;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.wink.api.IDateTransFrom;
import com.tencent.mobileqq.wink.api.IWinkShareAPI;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.aielimination.y;
import com.tencent.mobileqq.wink.share.WinkShareUtils;
import com.tencent.mobileqq.wink.share.p;
import com.tencent.mobileqq.wink.share.s;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002J(\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J*\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J \u0010\u001d\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/wink/api/impl/WinkShareAPIImpl;", "Lcom/tencent/mobileqq/wink/api/IWinkShareAPI;", "Landroid/app/Dialog;", "view", "", "", "", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, "", "customReportSharePanel", "Lcom/tencent/mobileqq/wink/api/IDateTransFrom;", WadlProxyConsts.KEY_MATERIAL, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "scene", "Landroid/view/View;", "clickView", "showMaterialSharePanel", "", "type", "", "uin", "mateData", "Li83/g;", "listener", "requestArk", "previewPic", "Lcom/tencent/mobileqq/wink/api/c;", "data", "showAIEliminationSharePanel", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkShareAPIImpl implements IWinkShareAPI {
    private final void customReportSharePanel(Dialog view, Map<String, ? extends Object> pageParams) {
        String str;
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_QZ_MORE_OPERATION_PANEL);
        Map<String, Object> map = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_QZ_MORE_OPERATION_PANEL);
        map.put("eid", WinkDaTongReportConstant.ElementId.EM_QZ_MORE_OPERATION_PANEL);
        Object obj = pageParams.get("qq_pgid");
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = null;
        }
        VideoReport.setPageId(view, str);
        VideoReport.setPageParams(view, new WinkDTParamBuilder().buildPageParams(pageParams, WinkContext.INSTANCE.d().getDtParams().c()));
        VideoReport.reportEvent("dt_imp", view, map);
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkShareAPI
    public void requestArk(int type, long uin, @NotNull String mateData, @Nullable i83.g listener) {
        Intrinsics.checkNotNullParameter(mateData, "mateData");
        WinkShareUtils.INSTANCE.i(type, uin, mateData, listener);
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkShareAPI
    public void showAIEliminationSharePanel(@NotNull Activity activity, @NotNull String previewPic, @NotNull com.tencent.mobileqq.wink.api.c data) {
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(previewPic, "previewPic");
        Intrinsics.checkNotNullParameter(data, "data");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(ShareActionSheetBuilder.ActionSheetItem.build(2), ShareActionSheetBuilder.ActionSheetItem.build(3));
        if (WXShareHelper.b0().f0()) {
            arrayListOf.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
        }
        if (WXShareHelper.b0().g0()) {
            arrayListOf.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
        }
        if (!data.b()) {
            arrayListOf.add(ShareActionSheetBuilder.ActionSheetItem.build(203));
        }
        ShareActionSheet b16 = new s.a().c(arrayListOf, !data.b() ? CollectionsKt__CollectionsKt.arrayListOf(ShareActionSheetBuilder.ActionSheetItem.build(39)) : CollectionsKt__CollectionsKt.arrayListOf(ShareActionSheetBuilder.ActionSheetItem.build(1))).j(false).h(8, 0, 0).e(new y(activity, previewPic, data)).g(previewPic).b(activity);
        b16.show();
        ActionSheet actionSheet = b16.getActionSheet();
        Intrinsics.checkNotNullExpressionValue(actionSheet, "sharePanel.actionSheet");
        customReportSharePanel(actionSheet, data.e());
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkShareAPI
    public void showMaterialSharePanel(@NotNull IDateTransFrom material, @NotNull Activity activity, @NotNull String scene, @NotNull View clickView) {
        Intrinsics.checkNotNullParameter(material, "material");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(clickView, "clickView");
        new s.a().c(s.a.INSTANCE.a(), null).h(0, 0, 8).e(new p(material, activity, scene, clickView)).a(activity).show();
    }
}
