package com.tencent.biz.qqcircle.wink;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.immersive.events.QFSFeedPositionChangeEvent;
import com.tencent.biz.qqcircle.publish.plusentry.composer.bubble.PlusEntryBubbleComposer;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkpublish.api.IReportApi;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QFSTianShuConstant;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StMaterialDataNew;
import feedcloud.FeedCloudMeta$StSingleMaterial;
import feedcloud.FeedCloudMeta$StTagInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bG\u0010HJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J&\u0010\f\u001a\u00020\b2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J&\u0010\u000f\u001a\u00020\b2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0002J,\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\b\b\u0002\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u0004H\u0002J\u000e\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0010J\u0010\u0010\u001f\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dJ\u000e\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u0004J\u001c\u0010\"\u001a\u00020\b2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\nJ\u000e\u0010#\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u001c\u0010$\u001a\u00020\b2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\nJ\u000e\u0010%\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010&\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010'\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rJ\u0016\u0010(\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010J\u0016\u0010)\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010J\u0006\u0010*\u001a\u00020\bJ\u0006\u0010+\u001a\u00020\bJ\u0016\u0010,\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004J\u0016\u0010-\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004J\u0016\u0010.\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004J\u0016\u00102\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u00042\u0006\u00101\u001a\u000200J\u001e\u00106\u001a\u00020\b2\u0006\u00103\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u0004R$\u0010;\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b*\u00108\u001a\u0004\b9\u0010:R$\u0010@\u001a\u00020<2\u0006\u00107\u001a\u00020<8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b+\u0010=\u001a\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010AR\u0016\u0010D\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010CR\u0011\u0010F\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\bE\u0010:\u00a8\u0006I"}, d2 = {"Lcom/tencent/biz/qqcircle/wink/e;", "", "Lfeedcloud/FeedCloudMeta$StFeed;", "stFeed", "", "u", "Lcom/tencent/biz/qqcircle/wink/b;", "dtButtonInfo", "", "i", "", "params", DomainData.DOMAIN_NAME, "Lcom/tencent/biz/qqcircle/wink/a;", "dtBubbleInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "pageId", IProfileCardConst.KEY_FROM_TYPE, "Lcooperation/qqcircle/report/QCircleLpReportDc05504$DataBuilder;", "v", "actionType", "subActionType", "materialType", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "Lcooperation/qqcircle/report/QCircleLpReportDc05507$DataBuilder;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "uiType", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/biz/qqcircle/immersive/events/QFSFeedPositionChangeEvent;", "event", HippyTKDListViewAdapter.X, "pgId", "y", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "o", "l", "k", "j", tl.h.F, "g", "b", "c", "f", "e", "a", "musicId", "", "isExpose", "d", "actionId", "adId", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "B", "<set-?>", "Ljava/lang/String;", "t", "()Ljava/lang/String;", "mCustomPgId", "Lcom/tencent/mobileqq/winkpublish/api/IReportApi$a;", "Lcom/tencent/mobileqq/winkpublish/api/IReportApi$a;", ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/mobileqq/winkpublish/api/IReportApi$a;", "mCurrentFeedInfo", "Lcom/tencent/biz/qqcircle/wink/b;", "mCurrentDTButtonInfo", "I", "mCurrentUIType", "w", "reportBtnPosition", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f93946a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String mCustomPgId = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static IReportApi.ReportFeedInfo mCurrentFeedInfo = new IReportApi.ReportFeedInfo(0, null, null, null, null, null, 63, null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static DTButtonInfo mCurrentDTButtonInfo = new DTButtonInfo(null, null, 3, null);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static int mCurrentUIType = -1;

    e() {
    }

    private final void i(DTButtonInfo dtButtonInfo) {
        mCurrentDTButtonInfo = dtButtonInfo;
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        n(params, dtButtonInfo);
        VideoReport.reportEvent("ev_xsj_abnormal_imp", params);
    }

    private final void m(Map<String, Object> params, DTBubbleInfo dtBubbleInfo) {
        p(params);
        params.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_NEW_FEATURE_BUBBLE);
        params.put("xsj_publish_location", w());
        params.put("xsj_guide_text", dtBubbleInfo.getGuideText());
        params.put("xsj_tianshu_task_id", dtBubbleInfo.getTianShuId());
        params.put("xsj_operation_activity_id", dtBubbleInfo.getOperationActivityId());
        params.put("xsj_resource_type", 2);
        o(params);
    }

    private final void n(Map<String, Object> params, DTButtonInfo dtButtonInfo) {
        p(params);
        params.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_EDIT_BUTTON);
        params.put("xsj_publish_location", w());
        params.put("xsj_operation_activity_id", dtButtonInfo.getOperationActivityId());
        PlusEntryBubbleComposer.Companion companion = PlusEntryBubbleComposer.INSTANCE;
        if (TextUtils.isEmpty(companion.a())) {
            params.put("xsj_tianshu_task_id", dtButtonInfo.getTianShuId());
        } else {
            params.put("xsj_tianshu_task_id", companion.a());
        }
        o(params);
    }

    private final QCircleLpReportDc05507.DataBuilder q(int actionType, int subActionType, String materialType, String materialId) {
        boolean z16;
        boolean z17;
        String materialInfos = mCurrentFeedInfo.getMaterialInfos();
        if (materialType.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (materialId.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.mo162put(materialId);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(materialType, jSONArray);
                    String jSONObject2 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
                    materialInfos = jSONObject2;
                } catch (Exception e16) {
                    QLog.e("QFS[WinkDcReporter]", 1, e16, new Object[0]);
                }
            }
        }
        QCircleLpReportDc05507.DataBuilder ext5 = new QCircleLpReportDc05507.DataBuilder().setActionType(actionType).setSubActionType(subActionType).setFeedId(mCurrentFeedInfo.getFeedId()).setAuthorUin(mCurrentFeedInfo.getFeedAuthorUin()).setPosition(mCurrentFeedInfo.getFeedIndex()).setSealTransfer(mCurrentFeedInfo.getSealTransfer()).setActTime(System.currentTimeMillis()).setExt5(materialInfos);
        Intrinsics.checkNotNullExpressionValue(ext5, "DataBuilder()\n          \u2026           .setExt5(ext5)");
        return ext5;
    }

    static /* synthetic */ QCircleLpReportDc05507.DataBuilder r(e eVar, int i3, int i16, String str, String str2, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            str = "";
        }
        if ((i17 & 8) != 0) {
            str2 = "";
        }
        return eVar.q(i3, i16, str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00cf A[LOOP:2: B:25:0x00c9->B:27:0x00cf, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String u(FeedCloudMeta$StFeed stFeed) {
        List<FeedCloudMeta$StMaterialDataNew> filterNotNull;
        Iterator<FeedCloudMeta$StSingleMaterial> it;
        List filterNotNull2;
        List take;
        JSONObject jSONObject = new JSONObject();
        String str = stFeed.musicInfo.MID.get();
        if (str != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.mo162put(str);
            jSONObject.put("music", jSONArray);
        }
        List<FeedCloudMeta$StTagInfo> list = stFeed.tagInfos.get();
        if (list != null) {
            JSONArray jSONArray2 = new JSONArray();
            filterNotNull2 = CollectionsKt___CollectionsKt.filterNotNull(list);
            take = CollectionsKt___CollectionsKt.take(filterNotNull2, 10);
            Iterator it5 = take.iterator();
            while (it5.hasNext()) {
                jSONArray2.mo162put(((FeedCloudMeta$StTagInfo) it5.next()).tagName.get());
            }
            jSONObject.put("topic", jSONArray2);
        }
        List<FeedCloudMeta$StMaterialDataNew> list2 = stFeed.video.materialList.get();
        Intrinsics.checkNotNullExpressionValue(list2, "stFeed.video.materialList.get()");
        filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(list2);
        for (FeedCloudMeta$StMaterialDataNew feedCloudMeta$StMaterialDataNew : filterNotNull) {
            String str2 = feedCloudMeta$StMaterialDataNew.materialType.get();
            if (str2 != null) {
                int hashCode = str2.hashCode();
                if (hashCode != -1321546630) {
                    if (hashCode != -445885909) {
                        if (hashCode == 2044886559 && str2.equals("libTemplate")) {
                            JSONArray jSONArray3 = new JSONArray();
                            it = feedCloudMeta$StMaterialDataNew.materialList.get().iterator();
                            while (it.hasNext()) {
                                jSONArray3.mo162put(it.next().materialId.get());
                            }
                            jSONObject.put(str2, jSONArray3);
                        }
                    } else if (str2.equals("meterial")) {
                        JSONArray jSONArray32 = new JSONArray();
                        it = feedCloudMeta$StMaterialDataNew.materialList.get().iterator();
                        while (it.hasNext()) {
                        }
                        jSONObject.put(str2, jSONArray32);
                    }
                } else if (str2.equals("template")) {
                    JSONArray jSONArray322 = new JSONArray();
                    it = feedCloudMeta$StMaterialDataNew.materialList.get().iterator();
                    while (it.hasNext()) {
                    }
                    jSONObject.put(str2, jSONArray322);
                }
            }
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
        if (QLog.isColorLevel()) {
            QLog.i("QFS[WinkDcReporter]", 2, "genMaterialInfos: " + jSONObject2);
        }
        return jSONObject2;
    }

    private final QCircleLpReportDc05504.DataBuilder v(int pageId, int fromType) {
        QCircleLpReportDc05504.DataBuilder pageId2 = new QCircleLpReportDc05504.DataBuilder().setToUin(HostDataTransUtils.getAccount()).setActionType(14).setThrActionType(0).setExt1(String.valueOf(fromType)).setExt3(String.valueOf(System.currentTimeMillis())).setExt6("0").setPageId(pageId);
        Intrinsics.checkNotNullExpressionValue(pageId2, "DataBuilder()\n          \u2026       .setPageId(pageId)");
        return pageId2;
    }

    public final void A(int uiType) {
        QLog.d("QFS[WinkDcReporter]", 1, "setUIType, uiType: " + uiType);
        mCurrentUIType = uiType;
    }

    public final void B(int actionId, @NotNull String adId, @NotNull String traceInfo) {
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(traceInfo, "traceInfo");
        TianShuReportData tianShuReportData = new TianShuReportData();
        tianShuReportData.mActionId = actionId;
        tianShuReportData.mItemId = adId;
        tianShuReportData.mTriggerInfo = traceInfo;
        tianShuReportData.mTraceId = String.valueOf(QCirclePluginUtil.getCurrentAccountLongUin());
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mAppId = QFSTianShuConstant.QCIRCLE_APP_ID;
        tianShuReportData.mPageId = QFSTianShuConstant.QCIRCLE_APP_ID;
        tianShuReportData.mOperTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        tianShuReportData.mActionValue = 1;
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(tianShuReportData);
    }

    public final void a(@NotNull String materialType, @NotNull String materialId) {
        Intrinsics.checkNotNullParameter(materialType, "materialType");
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        QCircleLpReportDc05507.report(q(1012, 2, materialType, materialId));
    }

    public final void b() {
        QCircleLpReportDc05507.report(r(this, 1000, 2, null, null, 12, null));
    }

    public final void c() {
        QCircleLpReportDc05507.report(r(this, 1000, 1, null, null, 12, null));
    }

    public final void d(@NotNull String musicId, boolean isExpose) {
        int i3;
        Intrinsics.checkNotNullParameter(musicId, "musicId");
        if (isExpose) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        QCircleLpReportDc05507.report(q(1013, i3, "music", musicId));
    }

    public final void e(@NotNull String materialType, @NotNull String materialId) {
        Intrinsics.checkNotNullParameter(materialType, "materialType");
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        QCircleLpReportDc05507.report(q(1011, 2, materialType, materialId));
    }

    public final void f(@NotNull String materialType, @NotNull String materialId) {
        Intrinsics.checkNotNullParameter(materialType, "materialType");
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        QCircleLpReportDc05507.report(q(1011, 1, materialType, materialId));
    }

    public final void g(int pageId, int fromType) {
        QCircleLpReportDc05504.report(v(pageId, fromType).setSubActionType(2));
    }

    public final void h(int pageId, int fromType) {
        QCircleLpReportDc05504.report(v(pageId, fromType).setSubActionType(1));
    }

    public final void j(@NotNull DTBubbleInfo dtBubbleInfo) {
        Intrinsics.checkNotNullParameter(dtBubbleInfo, "dtBubbleInfo");
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        m(params, dtBubbleInfo);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", params);
    }

    public final void k(@NotNull DTBubbleInfo dtBubbleInfo) {
        Intrinsics.checkNotNullParameter(dtBubbleInfo, "dtBubbleInfo");
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        m(params, dtBubbleInfo);
        VideoReport.reportEvent("ev_xsj_abnormal_imp", params);
    }

    public final void l(@NotNull DTButtonInfo dtButtonInfo) {
        Intrinsics.checkNotNullParameter(dtButtonInfo, "dtButtonInfo");
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        n(params, dtButtonInfo);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", params);
    }

    public final void o(@NotNull Map<String, Object> params) {
        Intrinsics.checkNotNullParameter(params, "params");
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(mCurrentFeedInfo.getFeedIndex()));
        params.put("xsj_feed_id", mCurrentFeedInfo.getFeedId());
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, mCurrentFeedInfo.getFeedAuthorUin());
    }

    public final void p(@NotNull Map<String, Object> params) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (TextUtils.isEmpty(mCustomPgId)) {
            String str = (String) WinkDatongCurrentParams.params.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID);
            if (!TextUtils.isEmpty(str)) {
                params.put("xsj_custom_pgid", str);
                return;
            }
            return;
        }
        params.put("xsj_custom_pgid", mCustomPgId);
    }

    @NotNull
    public final IReportApi.ReportFeedInfo s() {
        return mCurrentFeedInfo;
    }

    @NotNull
    public final String t() {
        return mCustomPgId;
    }

    @NotNull
    public final String w() {
        int i3 = mCurrentUIType;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return "none";
                }
                return QCircleDaTongConstant.ElementParamValue.QQ_MAIN_TAB;
            }
            return "middle";
        }
        return "upright";
    }

    public final void x(@Nullable QFSFeedPositionChangeEvent event) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        String str;
        e30.b feedData;
        if (event != null && (feedData = event.getFeedData()) != null) {
            feedCloudMeta$StFeed = feedData.g();
        } else {
            feedCloudMeta$StFeed = null;
        }
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        FeedCloudMeta$StFeed stFeed = event.getFeedData().g();
        int tabType = event.getTabType();
        if (tabType != 1) {
            str = "pg_xsj_explore_page";
            if (tabType != 6 && tabType == 9) {
                str = "pg_xsj_friendtab_explore_page";
            }
        } else {
            str = QCircleDaTongConstant.PageId.PG_XSJ_FOLLOWING_PAGE;
        }
        int position = event.getPosition();
        String str2 = stFeed.f398449id.get();
        Intrinsics.checkNotNullExpressionValue(str2, "stFeed.id.get()");
        String str3 = stFeed.poster.f398463id.get();
        Intrinsics.checkNotNullExpressionValue(str3, "stFeed.poster.id.get()");
        String str4 = stFeed.recomInfo.recomTrace.get();
        Intrinsics.checkNotNullExpressionValue(str4, "stFeed.recomInfo.recomTrace.get()");
        Intrinsics.checkNotNullExpressionValue(stFeed, "stFeed");
        mCurrentFeedInfo = new IReportApi.ReportFeedInfo(position, str2, str3, str4, u(stFeed), str);
        ((IReportApi) QRoute.api(IReportApi.class)).setDc5507ReportInfo(mCurrentFeedInfo);
    }

    public final void y(@NotNull String pgId) {
        Intrinsics.checkNotNullParameter(pgId, "pgId");
        QLog.d("QFS[WinkDcReporter]", 1, "onPgIdChanged, pgId: " + pgId);
        mCustomPgId = pgId;
        z(mCurrentDTButtonInfo);
    }

    public final void z(@NotNull DTButtonInfo dtButtonInfo) {
        Intrinsics.checkNotNullParameter(dtButtonInfo, "dtButtonInfo");
        i(dtButtonInfo);
        c();
    }
}
