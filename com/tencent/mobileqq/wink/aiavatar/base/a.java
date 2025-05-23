package com.tencent.mobileqq.wink.aiavatar.base;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.aiavatar.detailpage.WinkAIAvatarMaterialDetailViewModel;
import com.tencent.mobileqq.wink.aiavatar.mainpage.WinkAIAvatarStyleViewModel;
import com.tencent.mobileqq.wink.aiavatar.resultpage.WinkAIAvatarResultViewModel;
import com.tencent.mobileqq.wink.aiavatar.view.WinkAIAvatarGenerateBtn;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0013\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b>\u0010?J \u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J \u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\nJ \u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\fJ*\u0010\u0013\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000fJ\u001e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fJ\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0004J\"\u0010\u0019\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000fJ\u0016\u0010\u001a\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\u0018\u0010\u001c\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\u0018\u0010\u001d\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ)\u0010\"\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010!\u001a\u0004\u0018\u00010 \u00a2\u0006\u0004\b\"\u0010#J)\u0010$\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010!\u001a\u0004\u0018\u00010 \u00a2\u0006\u0004\b$\u0010#J\u0010\u0010&\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010'\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010*\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010(J\u0018\u0010,\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010+\u001a\u0004\u0018\u00010\u001eJ*\u0010/\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010.\u001a\u00020-J\u001e\u00100\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020-J\u0016\u00101\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\u0016\u00102\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\u0018\u00103\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\u0018\u00104\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\u001e\u00107\u001a\u00020\b2\u0006\u00105\u001a\u00020-2\u0006\u00106\u001a\u00020-2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0010\u00108\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004J\u0010\u00109\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004J\u0010\u0010:\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004J\u0010\u0010;\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004J\u0010\u0010<\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004J\u0010\u0010=\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/base/a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/View;", "contentView", "Lcom/tencent/mobileqq/wink/aiavatar/resultpage/WinkAIAvatarResultViewModel;", "viewModel", "", "c", "Lcom/tencent/mobileqq/wink/aiavatar/mainpage/WinkAIAvatarStyleViewModel;", "b", "Lcom/tencent/mobileqq/wink/aiavatar/detailpage/WinkAIAvatarMaterialDetailViewModel;", "a", DTConstants.TAG.ELEMENT, "", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "contentTag", "reuseIdentifier", "l", "k", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "t", ReportConstant.COSTREPORT_PREFIX, "e", "d", "shareBtn", BdhLogUtil.LogTag.Tag_Conn, "B", "Lcom/tencent/mobileqq/wink/aiavatar/view/WinkAIAvatarGenerateBtn;", "setBtn", "", "isSyncQZone", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lcom/tencent/mobileqq/wink/aiavatar/view/WinkAIAvatarGenerateBtn;Ljava/lang/String;Ljava/lang/Boolean;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "makeSameBtn", "p", "o", "Landroid/widget/TextView;", "view", "y", "generateBtn", "j", "", IProfileCardConst.KEY_FROM_TYPE, UserInfo.SEX_FEMALE, "E", "i", h.F, "v", "u", "sharePage", "shareContent", "D", "g", "f", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, HippyTKDListViewAdapter.X, "w", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f317690a = new a();

    a() {
    }

    public final void A(@Nullable WinkAIAvatarGenerateBtn setBtn, @NotNull String materialId, @Nullable Boolean isSyncQZone) {
        String str;
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        if (setBtn != null) {
            str = setBtn.b();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str, "\u8bbe\u7f6e\u5934\u50cf\u5e76\u4fdd\u5b58")) {
            VideoReport.setElementExposePolicy(setBtn, ExposurePolicy.REPORT_NONE);
            Map<String, Object> params = WinkDTParamBuilder.buildMainAppElementParams();
            Intrinsics.checkNotNullExpressionValue(params, "params");
            params.put("material_id", materialId);
            params.put("zplan_is_sync_qzone", Integer.valueOf(Intrinsics.areEqual(isSyncQZone, Boolean.TRUE) ? 1 : 0));
            com.tencent.mobileqq.wink.report.e.v(com.tencent.mobileqq.wink.report.e.f326265a, "imp", setBtn, WinkDaTongReportConstant.ElementId.EM_BAS_SET_AS_AVATAR, params, null, 16, null);
        }
    }

    public final void B(@Nullable View shareBtn, @NotNull String materialId) {
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        if (shareBtn != null) {
            Map<String, Object> params = WinkDTParamBuilder.buildMainAppElementParams();
            Intrinsics.checkNotNullExpressionValue(params, "params");
            params.put("material_id", materialId);
            com.tencent.mobileqq.wink.report.e.t(com.tencent.mobileqq.wink.report.e.f326265a, shareBtn, WinkDaTongReportConstant.ElementId.EM_BAS_SHARE, params, null, 8, null);
        }
    }

    public final void C(@Nullable View shareBtn, @NotNull String materialId) {
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        if (shareBtn != null) {
            VideoReport.setElementExposePolicy(shareBtn, ExposurePolicy.REPORT_NONE);
            Map<String, Object> params = WinkDTParamBuilder.buildMainAppElementParams();
            Intrinsics.checkNotNullExpressionValue(params, "params");
            params.put("material_id", materialId);
            com.tencent.mobileqq.wink.report.e.v(com.tencent.mobileqq.wink.report.e.f326265a, "imp", shareBtn, WinkDaTongReportConstant.ElementId.EM_BAS_SHARE, params, null, 16, null);
        }
    }

    public final void D(int sharePage, int shareContent, @NotNull String materialId) {
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        Map<String, Object> params = WinkDTParamBuilder.buildMainAppElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("material_id", materialId);
        params.put(WinkDaTongReportConstant.ElementParamKey.SHARE_PAGE, Integer.valueOf(sharePage));
        params.put(WinkDaTongReportConstant.ElementParamKey.SHARE_CONTENT, Integer.valueOf(shareContent));
        params.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        com.tencent.mobileqq.wink.report.e.v(com.tencent.mobileqq.wink.report.e.f326265a, WinkDaTongReportConstant.EventId.EV_BAS_AI_AVATAR_SHARE_SUCCESS, null, null, null, params, 14, null);
    }

    public final void E(@NotNull View element, @NotNull String materialId, int fromType) {
        String str;
        Intrinsics.checkNotNullParameter(element, "element");
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        if (fromType == 1) {
            str = WinkDaTongReportConstant.ElementId.EM_BAS_CONTENT_RECOMMENDATION;
        } else {
            str = WinkDaTongReportConstant.ElementId.EM_BAS_OTHER_STYLE_RECOMMEND;
        }
        Map<String, Object> params = WinkDTParamBuilder.buildMainAppElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("recommended_material_id", materialId);
        com.tencent.mobileqq.wink.report.e.t(com.tencent.mobileqq.wink.report.e.f326265a, element, str, params, null, 8, null);
    }

    public final void F(@NotNull View element, @NotNull String materialId, @Nullable String reuseIdentifier, int fromType) {
        String str;
        Intrinsics.checkNotNullParameter(element, "element");
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        if (fromType == 1) {
            str = WinkDaTongReportConstant.ElementId.EM_BAS_CONTENT_RECOMMENDATION;
        } else {
            str = WinkDaTongReportConstant.ElementId.EM_BAS_OTHER_STYLE_RECOMMEND;
        }
        Map<String, ?> params = WinkDTParamBuilder.buildMainAppElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("recommended_material_id", materialId);
        com.tencent.mobileqq.wink.report.e eVar = com.tencent.mobileqq.wink.report.e.f326265a;
        eVar.e(element, str, params, reuseIdentifier);
        eVar.y();
    }

    public final void a(@Nullable Activity activity, @NotNull View contentView, @NotNull WinkAIAvatarMaterialDetailViewModel viewModel) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        if (activity == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        VideoReport.addToDetectionWhitelist(activity);
        VideoReport.setPageId(contentView, WinkDaTongReportConstant.PageId.PG_BAS_AI_STYLE_DETAIL);
        hashMap.put("come_from", viewModel.getComeFrom());
        String str = viewModel.getOriginStyleMaterial().f30533id;
        Intrinsics.checkNotNullExpressionValue(str, "viewModel.getOriginMaterial().id");
        hashMap.put("material_id", str);
        VideoReport.setPageParams(contentView, new WinkDTParamBuilder().buildReportPageParamsForQQMain(hashMap));
    }

    public final void b(@Nullable Activity activity, @NotNull View contentView, @NotNull WinkAIAvatarStyleViewModel viewModel) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        if (activity == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        VideoReport.addToDetectionWhitelist(activity);
        VideoReport.setPageId(contentView, WinkDaTongReportConstant.PageId.PG_BAS_AI_AVATAR_MAIN);
        hashMap.put("come_from", viewModel.getComeFrom());
        VideoReport.setPageParams(contentView, new WinkDTParamBuilder().buildReportPageParamsForQQMain(hashMap));
    }

    public final void c(@Nullable Activity activity, @NotNull View contentView, @NotNull WinkAIAvatarResultViewModel viewModel) {
        String str;
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        if (activity == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        VideoReport.addToDetectionWhitelist(activity);
        if (viewModel.getIsSchemeJump()) {
            VideoReport.setPageId(contentView, WinkDaTongReportConstant.PageId.PG_BAS_AI_EMOJI_SHARING_RESULTS);
            if (viewModel.getIsCoupleAvatar()) {
                str = "1";
            } else {
                str = "0";
            }
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.IS_COUPLE_AVATAR, str);
            hashMap.put("material_id", viewModel.x2());
        } else {
            VideoReport.setPageId(contentView, WinkDaTongReportConstant.PageId.PG_BAS_AI_AVATAR_EDITING);
        }
        VideoReport.setPageParams(contentView, new WinkDTParamBuilder().buildReportPageParamsForQQMain(hashMap));
    }

    public final void d(@NotNull View element, @NotNull String materialId) {
        Intrinsics.checkNotNullParameter(element, "element");
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        Map<String, ?> params = WinkDTParamBuilder.buildMainAppElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("material_id", materialId);
        com.tencent.mobileqq.wink.report.e.f326265a.s(element, WinkDaTongReportConstant.ElementId.EM_BAS_AI_AVATAR_RECOMMENDATION, params, materialId);
    }

    public final void e(@NotNull View element, @NotNull String materialId, @Nullable String reuseIdentifier) {
        Intrinsics.checkNotNullParameter(element, "element");
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        Map<String, ?> params = WinkDTParamBuilder.buildMainAppElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("material_id", materialId);
        com.tencent.mobileqq.wink.report.e eVar = com.tencent.mobileqq.wink.report.e.f326265a;
        eVar.e(element, WinkDaTongReportConstant.ElementId.EM_BAS_AI_AVATAR_RECOMMENDATION, params, reuseIdentifier);
        eVar.y();
    }

    public final void f(@Nullable View element) {
        if (element != null) {
            com.tencent.mobileqq.wink.report.e.t(com.tencent.mobileqq.wink.report.e.f326265a, element, WinkDaTongReportConstant.ElementId.EM_BAS_UPLOAD_BUTTON, WinkDTParamBuilder.buildMainAppElementParams(), null, 8, null);
        }
    }

    public final void g(@Nullable View element) {
        if (element != null) {
            com.tencent.mobileqq.wink.report.e.f(com.tencent.mobileqq.wink.report.e.f326265a, element, WinkDaTongReportConstant.ElementId.EM_BAS_UPLOAD_BUTTON, WinkDTParamBuilder.buildMainAppElementParams(), null, 8, null);
        }
    }

    public final void h(@NotNull View element, @NotNull String materialId) {
        Intrinsics.checkNotNullParameter(element, "element");
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        Map<String, Object> params = WinkDTParamBuilder.buildMainAppElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("material_id", materialId);
        com.tencent.mobileqq.wink.report.e.t(com.tencent.mobileqq.wink.report.e.f326265a, element, WinkDaTongReportConstant.ElementId.EM_BAS_DOWNLOAD, params, null, 8, null);
    }

    public final void i(@NotNull View element, @NotNull String materialId) {
        Intrinsics.checkNotNullParameter(element, "element");
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        VideoReport.setElementExposePolicy(element, ExposurePolicy.REPORT_NONE);
        Map<String, Object> params = WinkDTParamBuilder.buildMainAppElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("material_id", materialId);
        com.tencent.mobileqq.wink.report.e.v(com.tencent.mobileqq.wink.report.e.f326265a, "imp", element, WinkDaTongReportConstant.ElementId.EM_BAS_DOWNLOAD, params, null, 16, null);
    }

    public final void j(@NotNull String materialId, @Nullable WinkAIAvatarGenerateBtn generateBtn) {
        String str;
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        if (generateBtn != null) {
            str = generateBtn.b();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str, "\u5f00\u59cb\u751f\u6210")) {
            Map<String, Object> params = WinkDTParamBuilder.buildMainAppElementParams();
            Intrinsics.checkNotNullExpressionValue(params, "params");
            params.put("material_id", materialId);
            com.tencent.mobileqq.wink.report.e.t(com.tencent.mobileqq.wink.report.e.f326265a, generateBtn, WinkDaTongReportConstant.ElementId.EM_BAS_REGENERATE, params, null, 8, null);
        }
    }

    public final void k(@NotNull View element, @NotNull String materialId, @NotNull String contentTag) {
        Intrinsics.checkNotNullParameter(element, "element");
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        Intrinsics.checkNotNullParameter(contentTag, "contentTag");
        Map<String, ?> params = WinkDTParamBuilder.buildMainAppElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("material_id", materialId);
        params.put(WinkDaTongReportConstant.ElementParamKey.CONTENT_TAG, contentTag);
        com.tencent.mobileqq.wink.report.e.f326265a.s(element, WinkDaTongReportConstant.ElementId.EM_BAS_PLAY_CARD, params, materialId);
    }

    public final void l(@NotNull View element, @NotNull String materialId, @NotNull String contentTag, @Nullable String reuseIdentifier) {
        Intrinsics.checkNotNullParameter(element, "element");
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        Intrinsics.checkNotNullParameter(contentTag, "contentTag");
        Map<String, ?> params = WinkDTParamBuilder.buildMainAppElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("material_id", materialId);
        params.put(WinkDaTongReportConstant.ElementParamKey.CONTENT_TAG, contentTag);
        com.tencent.mobileqq.wink.report.e eVar = com.tencent.mobileqq.wink.report.e.f326265a;
        eVar.e(element, WinkDaTongReportConstant.ElementId.EM_BAS_PLAY_CARD, params, reuseIdentifier);
        eVar.y();
    }

    public final void m(@NotNull View element) {
        Intrinsics.checkNotNullParameter(element, "element");
        com.tencent.mobileqq.wink.report.e.t(com.tencent.mobileqq.wink.report.e.f326265a, element, WinkDaTongReportConstant.ElementId.EM_BAS_SHARE, WinkDTParamBuilder.buildMainAppElementParams(), null, 8, null);
    }

    public final void n(@NotNull View element) {
        Intrinsics.checkNotNullParameter(element, "element");
        com.tencent.mobileqq.wink.report.e.f(com.tencent.mobileqq.wink.report.e.f326265a, element, WinkDaTongReportConstant.ElementId.EM_BAS_SHARE, WinkDTParamBuilder.buildMainAppElementParams(), null, 8, null);
    }

    public final void o(@Nullable WinkAIAvatarGenerateBtn makeSameBtn) {
        String str;
        if (makeSameBtn != null) {
            str = makeSameBtn.b();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str, "\u505a\u540c\u6b3e")) {
            com.tencent.mobileqq.wink.report.e.t(com.tencent.mobileqq.wink.report.e.f326265a, makeSameBtn, WinkDaTongReportConstant.ElementId.EM_BAS_MAKE_SAME_KIND, null, null, 12, null);
        }
    }

    public final void p(@Nullable WinkAIAvatarGenerateBtn makeSameBtn) {
        String str;
        if (makeSameBtn != null) {
            str = makeSameBtn.b();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str, "\u505a\u540c\u6b3e")) {
            VideoReport.setElementExposePolicy(makeSameBtn, ExposurePolicy.REPORT_NONE);
            com.tencent.mobileqq.wink.report.e.v(com.tencent.mobileqq.wink.report.e.f326265a, "imp", makeSameBtn, WinkDaTongReportConstant.ElementId.EM_BAS_MAKE_SAME_KIND, null, null, 24, null);
        }
    }

    public final void q(@Nullable View element) {
        if (element != null) {
            com.tencent.mobileqq.wink.report.e.t(com.tencent.mobileqq.wink.report.e.f326265a, element, WinkDaTongReportConstant.ElementId.EM_BAS_MORE, WinkDTParamBuilder.buildMainAppElementParams(), null, 8, null);
        }
    }

    public final void r(@Nullable View element) {
        if (element != null) {
            VideoReport.setElementExposePolicy(element, ExposurePolicy.REPORT_NONE);
            com.tencent.mobileqq.wink.report.e.v(com.tencent.mobileqq.wink.report.e.f326265a, "imp", element, WinkDaTongReportConstant.ElementId.EM_BAS_MORE, WinkDTParamBuilder.buildMainAppElementParams(), null, 16, null);
        }
    }

    public final void s(@NotNull View element) {
        Intrinsics.checkNotNullParameter(element, "element");
        com.tencent.mobileqq.wink.report.e.t(com.tencent.mobileqq.wink.report.e.f326265a, element, WinkDaTongReportConstant.ElementId.EM_BAS_ORIGINAL_DRAWING, WinkDTParamBuilder.buildMainAppElementParams(), null, 8, null);
    }

    public final void t(@NotNull View element) {
        Intrinsics.checkNotNullParameter(element, "element");
        com.tencent.mobileqq.wink.report.e.f(com.tencent.mobileqq.wink.report.e.f326265a, element, WinkDaTongReportConstant.ElementId.EM_BAS_ORIGINAL_DRAWING, WinkDTParamBuilder.buildMainAppElementParams(), null, 8, null);
    }

    public final void u(@Nullable View element, @NotNull String materialId) {
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        if (element != null) {
            Map<String, Object> params = WinkDTParamBuilder.buildMainAppElementParams();
            Intrinsics.checkNotNullExpressionValue(params, "params");
            params.put("material_id", materialId);
            com.tencent.mobileqq.wink.report.e.t(com.tencent.mobileqq.wink.report.e.f326265a, element, WinkDaTongReportConstant.ElementId.EM_BAS_ANEW_GENERATE, params, null, 8, null);
        }
    }

    public final void v(@Nullable View element, @NotNull String materialId) {
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        if (element != null) {
            VideoReport.setElementExposePolicy(element, ExposurePolicy.REPORT_NONE);
            Map<String, Object> params = WinkDTParamBuilder.buildMainAppElementParams();
            Intrinsics.checkNotNullExpressionValue(params, "params");
            params.put("material_id", materialId);
            com.tencent.mobileqq.wink.report.e.v(com.tencent.mobileqq.wink.report.e.f326265a, "imp", element, WinkDaTongReportConstant.ElementId.EM_BAS_ANEW_GENERATE, params, null, 16, null);
        }
    }

    public final void w(@Nullable View element) {
        if (element != null) {
            com.tencent.mobileqq.wink.report.e.t(com.tencent.mobileqq.wink.report.e.f326265a, element, WinkDaTongReportConstant.ElementId.EM_BAS_REPLACE_PHOTO, WinkDTParamBuilder.buildMainAppElementParams(), null, 8, null);
        }
    }

    public final void x(@Nullable View element) {
        if (element != null) {
            VideoReport.setElementExposePolicy(element, ExposurePolicy.REPORT_NONE);
            com.tencent.mobileqq.wink.report.e.v(com.tencent.mobileqq.wink.report.e.f326265a, "imp", element, WinkDaTongReportConstant.ElementId.EM_BAS_REPLACE_PHOTO, WinkDTParamBuilder.buildMainAppElementParams(), null, 16, null);
        }
    }

    public final void y(@Nullable TextView view) {
        if (view != null && Intrinsics.areEqual(view.getText(), "\u505a\u540c\u6b3e")) {
            com.tencent.mobileqq.wink.report.e.t(com.tencent.mobileqq.wink.report.e.f326265a, view, WinkDaTongReportConstant.ElementId.EM_BAS_MAKE_SAME_KIND, null, null, 12, null);
        }
    }

    public final void z(@Nullable WinkAIAvatarGenerateBtn setBtn, @NotNull String materialId, @Nullable Boolean isSyncQZone) {
        String str;
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        if (setBtn != null) {
            str = setBtn.b();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str, "\u8bbe\u7f6e\u5934\u50cf\u5e76\u4fdd\u5b58")) {
            Map<String, Object> params = WinkDTParamBuilder.buildMainAppElementParams();
            Intrinsics.checkNotNullExpressionValue(params, "params");
            params.put("material_id", materialId);
            params.put("zplan_is_sync_qzone", Integer.valueOf(Intrinsics.areEqual(isSyncQZone, Boolean.TRUE) ? 1 : 0));
            com.tencent.mobileqq.wink.report.e.t(com.tencent.mobileqq.wink.report.e.f326265a, setBtn, WinkDaTongReportConstant.ElementId.EM_BAS_SET_AS_AVATAR, params, null, 8, null);
        }
    }
}
