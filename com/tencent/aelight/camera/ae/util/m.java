package com.tencent.aelight.camera.ae.util;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u001a\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u001c\u0010\u000b\u001a\u00020\u00042\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tR$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\f\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0016\u001a\u00020\u00068\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u000eR\u0014\u0010\u0018\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\fR\u0016\u0010\u001a\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\fR\u0016\u0010\u001c\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\fR\u0016\u0010\u001e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\fR\u0016\u0010 \u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\f\u00a8\u0006#"}, d2 = {"Lcom/tencent/aelight/camera/ae/util/m;", "", "Landroid/content/Intent;", "intent", "", "b", "", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "c", "", "reportMap", "a", "Ljava/lang/String;", "getMaterialId", "()Ljava/lang/String;", "setMaterialId", "(Ljava/lang/String;)V", "getActivityId", "setActivityId", "activityId", "d", "getReportKeyAppKey", "reportKeyAppKey", "e", com.heytap.mcssdk.a.a.f36102l, "f", "materialType", "g", "xsjQzoneMode", tl.h.F, "fromLibQzone", "i", "qzoneLibtemplateMaterialType", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class m {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static String materialId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static String activityId;

    /* renamed from: a, reason: collision with root package name */
    public static final m f65786a = new m();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final String reportKeyAppKey = DTParamKey.REPORT_KEY_APPKEY;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final String appKey = "00000QG6YX3X0LZH";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static String materialType = "none";

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static String xsjQzoneMode = "normal";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static String fromLibQzone = "";

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static String qzoneLibtemplateMaterialType = "none";

    m() {
    }

    public final void a(Map<String, Object> reportMap) {
        Intrinsics.checkNotNullParameter(reportMap, "reportMap");
        reportMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_WHICH_ENTRANCE, fromLibQzone);
        reportMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_LIBTEMPLATE_MATERIAL_TYPE, qzoneLibtemplateMaterialType);
    }

    public final void b(Intent intent) {
        String str;
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(AECameraConstants.VIDEO_STORY_ACTIVITY_ID);
        HashMap hashMap = (HashMap) intent.getSerializableExtra("key_attrs");
        if (hashMap != null && hashMap.containsKey("xsj_operation_activity_id")) {
            stringExtra = String.valueOf(hashMap.get("xsj_operation_activity_id"));
        }
        if (hashMap != null) {
            if (!hashMap.isEmpty()) {
                if (hashMap.containsKey("meterial") && hashMap.get("meterial") != null) {
                    if (String.valueOf(hashMap.get("meterial")).length() > 0) {
                        materialType = "meterial";
                    }
                }
                if (hashMap.containsKey(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_MODE) && hashMap.get(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_MODE) != null) {
                    if (String.valueOf(hashMap.get(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_MODE)).length() > 0) {
                        xsjQzoneMode = String.valueOf(hashMap.get(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_MODE));
                    }
                }
            }
        }
        if (WinkContext.INSTANCE.d().u("QZONE")) {
            str = QQWinkConstants.QZONE_LIBTEMPLATE;
        } else {
            str = "";
        }
        fromLibQzone = str;
        com.tencent.mobileqq.wink.utils.m mVar = com.tencent.mobileqq.wink.utils.m.f326717a;
        Bundle extras = intent.getExtras();
        Object obj = extras != null ? extras.get(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_LIBTEMPLATE_MATERIAL_TYPE) : null;
        if (!(obj instanceof String)) {
            obj = null;
        }
        String str2 = (String) obj;
        if (str2 == null) {
            Serializable serializableExtra = intent.getSerializableExtra(WinkDTParamBuilder.KEY_ATTRS);
            HashMap hashMap2 = serializableExtra instanceof HashMap ? (HashMap) serializableExtra : null;
            Object obj2 = hashMap2 != null ? hashMap2.get(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_LIBTEMPLATE_MATERIAL_TYPE) : null;
            str2 = (String) (obj2 instanceof String ? obj2 : null);
        }
        if (str2 == null) {
            str2 = "none";
        }
        qzoneLibtemplateMaterialType = str2;
        activityId = stringExtra;
    }

    public final void c(String materialId2) {
        String valueOf;
        if (materialId2 == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PROPS_NAME, materialId2);
        String str = activityId;
        if (str == null) {
            valueOf = "none";
        } else {
            valueOf = String.valueOf(str);
        }
        linkedHashMap.put("xsj_operation_activity_id", valueOf);
        linkedHashMap.put("xsj_eid", "em_xsj_material_load_end");
        linkedHashMap.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_CAMERA_PAGE);
        linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_MODE, xsjQzoneMode);
        linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_TYPE, materialType);
        linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_WHICH_ENTRANCE, fromLibQzone);
        linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_LIBTEMPLATE_MATERIAL_TYPE, qzoneLibtemplateMaterialType);
        String str2 = reportKeyAppKey;
        String APP_KEY = WinkDTParamBuilder.APP_KEY;
        Intrinsics.checkNotNullExpressionValue(APP_KEY, "APP_KEY");
        linkedHashMap.put(str2, APP_KEY);
        VideoReport.reportEvent("ev_xsj_camera_action", linkedHashMap);
        materialId = materialId2;
    }
}
