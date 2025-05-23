package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c45.i;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RoleCardKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporterKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.FeedPublishTechReporter;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt__StringsKt;
import n25.k;
import n35.w;
import s25.f;

/* loaded from: classes31.dex */
public final class NBPPublishService {
    public static final NBPPublishService INSTANCE = new NBPPublishService();

    public final void publish(final NBPPublishConfig nBPPublishConfig, final Function3<? super Boolean, ? super f, ? super String, Unit> function3) {
        KLog.INSTANCE.i("NBPPublishService", "[publish]: " + nBPPublishConfig);
        final FeedPublishTechReporter feedPublishTechReporter = new FeedPublishTechReporter(APICallTechReporterKt.NBPCurrentTime());
        String str = nBPPublishConfig.photoPath;
        boolean z16 = false;
        if (str != null) {
            if (str.length() > 0) {
                z16 = true;
            }
        }
        if (z16) {
            feedPublishTechReporter.uploadStartTime = APICallTechReporterKt.NBPCurrentTime();
            QQNearbyModule.Companion.getInstance().uploadImage(nBPPublishConfig.photoPath, new Function1<byte[], Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPPublishService$publish$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                /* JADX WARN: Code restructure failed: missing block: B:20:0x007a, code lost:
                
                    if (r5 == null) goto L22;
                 */
                @Override // kotlin.jvm.functions.Function1
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Unit invoke(byte[] bArr) {
                    String str2;
                    CharSequence trim;
                    byte[] bArr2 = bArr;
                    FeedPublishTechReporter feedPublishTechReporter2 = FeedPublishTechReporter.this;
                    feedPublishTechReporter2.getClass();
                    feedPublishTechReporter2.uploadTimeUsage = Integer.valueOf((int) (APICallTechReporterKt.NBPCurrentTime() - feedPublishTechReporter2.uploadStartTime));
                    if (bArr2 == null) {
                        KLog.INSTANCE.e("NBPPublishService", "upload photo failed, photoUploadResult is null");
                        Function3<Boolean, f, String, Unit> function32 = function3;
                        if (function32 != null) {
                            function32.invoke(Boolean.FALSE, null, "\u56fe\u7247\u4e0a\u4f20\u5931\u8d25");
                        }
                        FeedPublishTechReporter.this.reportResult$enumunboxing$(4, null);
                    } else {
                        w wVar = (w) i.b(new w(null, null, 3, null), bArr2);
                        NBPPublishConfig nBPPublishConfig2 = nBPPublishConfig;
                        FeedPublishTechReporter feedPublishTechReporter3 = FeedPublishTechReporter.this;
                        Function3<Boolean, f, String, Unit> function33 = function3;
                        feedPublishTechReporter3.getClass();
                        feedPublishTechReporter3.submitStartTime = APICallTechReporterKt.NBPCurrentTime();
                        NBPPublishRepository nBPPublishRepository = NBPPublishRepository.INSTANCE;
                        NBPPublishStatusData nBPPublishStatusData = nBPPublishConfig2.status;
                        int i3 = nBPPublishStatusData != null ? nBPPublishStatusData.statusId : 0;
                        int i16 = nBPPublishStatusData != null ? nBPPublishStatusData.richStatusId : 0;
                        int i17 = nBPPublishStatusData != null ? nBPPublishStatusData.motionId : 0;
                        String str3 = nBPPublishConfig2.textContent;
                        if (str3 != null) {
                            trim = StringsKt__StringsKt.trim((CharSequence) str3);
                            str2 = trim.toString();
                        }
                        str2 = "";
                        nBPPublishRepository.requestPublishFeed(i3, i16, i17, str2, nBPPublishConfig2.poiInfo, wVar != null ? CollectionsKt__CollectionsJVMKt.listOf(wVar) : CollectionsKt__CollectionsKt.emptyList(), nBPPublishConfig2.topics, nBPPublishConfig2.themes, nBPPublishConfig2.feedType, new NBPPublishService$sendPublishRequest$1(feedPublishTechReporter3, nBPPublishConfig2, function33), new NBPPublishService$sendPublishRequest$2(function33, nBPPublishConfig2, feedPublishTechReporter3));
                    }
                    return Unit.INSTANCE;
                }
            });
        } else {
            sendPublishRequest(nBPPublishConfig, feedPublishTechReporter, function3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void access$customDtReportPublish(int i3, String str, NBPPublishConfig nBPPublishConfig) {
        String joinToString$default;
        int i16;
        String str2;
        int i17;
        String joinToString$default2;
        int i18;
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(nBPPublishConfig.themes, ";", null, null, 0, null, null, 62, null);
        e m3 = RoleCardKt$$ExternalSyntheticOutline0.m("nearby_publish_result", i3);
        String str3 = nBPPublishConfig.photoPath;
        int i19 = 1;
        if (str3 != null) {
            if ((str3.length() > 0) == true) {
                i16 = 1;
                m3.t("nearby_publish_have_pic", i16);
                str2 = nBPPublishConfig.textContent;
                if (str2 != null) {
                    if ((str2.length() > 0) == true) {
                        i17 = 1;
                        m3.t("nearby_publish_have_word", i17);
                        NBPPublishStatusData nBPPublishStatusData = nBPPublishConfig.status;
                        m3.t("nearby_action_id", nBPPublishStatusData != null ? nBPPublishStatusData.richStatusId : 0);
                        NBPPublishStatusData nBPPublishStatusData2 = nBPPublishConfig.status;
                        m3.t("nearby_status_id", nBPPublishStatusData2 != null ? nBPPublishStatusData2.statusId : 0);
                        joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(nBPPublishConfig.topics, ";", null, null, 0, null, null, 62, null);
                        m3.v("nearby_topic_id", joinToString$default2);
                        m3.v("nearby_map_id", joinToString$default);
                        m3.v("nearby_feed_id", str);
                        m3.t("nearby_publish_type", nBPPublishConfig.isAISelectTheme ? 1 : 0);
                        i18 = nBPPublishConfig.feedType;
                        if (i18 != 2 && i18 != 3) {
                            i19 = 0;
                        }
                        m3.t("nearby_is_tag_card", i19);
                        m3.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("ev_nearby_publish", m3);
                    }
                }
                i17 = 0;
                m3.t("nearby_publish_have_word", i17);
                NBPPublishStatusData nBPPublishStatusData3 = nBPPublishConfig.status;
                m3.t("nearby_action_id", nBPPublishStatusData3 != null ? nBPPublishStatusData3.richStatusId : 0);
                NBPPublishStatusData nBPPublishStatusData22 = nBPPublishConfig.status;
                m3.t("nearby_status_id", nBPPublishStatusData22 != null ? nBPPublishStatusData22.statusId : 0);
                joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(nBPPublishConfig.topics, ";", null, null, 0, null, null, 62, null);
                m3.v("nearby_topic_id", joinToString$default2);
                m3.v("nearby_map_id", joinToString$default);
                m3.v("nearby_feed_id", str);
                m3.t("nearby_publish_type", nBPPublishConfig.isAISelectTheme ? 1 : 0);
                i18 = nBPPublishConfig.feedType;
                if (i18 != 2) {
                    i19 = 0;
                }
                m3.t("nearby_is_tag_card", i19);
                m3.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("ev_nearby_publish", m3);
            }
        }
        i16 = 0;
        m3.t("nearby_publish_have_pic", i16);
        str2 = nBPPublishConfig.textContent;
        if (str2 != null) {
        }
        i17 = 0;
        m3.t("nearby_publish_have_word", i17);
        NBPPublishStatusData nBPPublishStatusData32 = nBPPublishConfig.status;
        m3.t("nearby_action_id", nBPPublishStatusData32 != null ? nBPPublishStatusData32.richStatusId : 0);
        NBPPublishStatusData nBPPublishStatusData222 = nBPPublishConfig.status;
        m3.t("nearby_status_id", nBPPublishStatusData222 != null ? nBPPublishStatusData222.statusId : 0);
        joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(nBPPublishConfig.topics, ";", null, null, 0, null, null, 62, null);
        m3.v("nearby_topic_id", joinToString$default2);
        m3.v("nearby_map_id", joinToString$default);
        m3.v("nearby_feed_id", str);
        m3.t("nearby_publish_type", nBPPublishConfig.isAISelectTheme ? 1 : 0);
        i18 = nBPPublishConfig.feedType;
        if (i18 != 2) {
        }
        m3.t("nearby_is_tag_card", i19);
        m3.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("ev_nearby_publish", m3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0030, code lost:
    
        if (r3 == null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void sendPublishRequest(NBPPublishConfig nBPPublishConfig, FeedPublishTechReporter feedPublishTechReporter, Function3 function3) {
        String str;
        List<w> emptyList;
        CharSequence trim;
        feedPublishTechReporter.submitStartTime = APICallTechReporterKt.NBPCurrentTime();
        NBPPublishRepository nBPPublishRepository = NBPPublishRepository.INSTANCE;
        NBPPublishStatusData nBPPublishStatusData = nBPPublishConfig.status;
        int i3 = nBPPublishStatusData != null ? nBPPublishStatusData.statusId : 0;
        int i16 = nBPPublishStatusData != null ? nBPPublishStatusData.richStatusId : 0;
        int i17 = nBPPublishStatusData != null ? nBPPublishStatusData.motionId : 0;
        String str2 = nBPPublishConfig.textContent;
        if (str2 != null) {
            trim = StringsKt__StringsKt.trim((CharSequence) str2);
            str = trim.toString();
        }
        str = "";
        k kVar = nBPPublishConfig.poiInfo;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        nBPPublishRepository.requestPublishFeed(i3, i16, i17, str, kVar, emptyList, nBPPublishConfig.topics, nBPPublishConfig.themes, nBPPublishConfig.feedType, new NBPPublishService$sendPublishRequest$1(feedPublishTechReporter, nBPPublishConfig, function3), new NBPPublishService$sendPublishRequest$2(function3, nBPPublishConfig, feedPublishTechReporter));
    }
}
