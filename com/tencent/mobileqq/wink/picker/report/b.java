package com.tencent.mobileqq.wink.picker.report;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import r93.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J8\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022&\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bH\u0002J0\u0010\u000b\u001a\u00020\u00042&\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bH\u0002JL\u0010\u0011\u001a\u00020\u00042\n\u0010\u000e\u001a\u00060\fj\u0002`\r2\n\u0010\u000f\u001a\u00060\fj\u0002`\r2\u0006\u0010\u0010\u001a\u00020\u00072\"\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\bH\u0002J,\u0010\u0012\u001a\u00020\u00042\"\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\bH\u0002J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/report/b;", "", "Landroid/content/Intent;", "intent", "", "b", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "schemaData", "c", "a", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "paiTongKuanType", "paiTongKuanId", "schemeType", "f", "d", "e", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f325261a = new b();

    b() {
    }

    private final void a(HashMap<String, String> schemaData) {
        String str;
        if (h.f430993a.g()) {
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.QZONE_PUBLISH_ID, ((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).getPublishId());
            boolean z16 = false;
            if (schemaData != null && schemaData.containsKey("adId")) {
                z16 = true;
            }
            if (z16) {
                str = schemaData.get("adId");
            } else {
                str = "";
            }
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.ADID, str);
        }
    }

    private final void b(Intent intent) {
        String stringExtra = intent.getStringExtra("xsj_ref_pgid");
        if (stringExtra != null) {
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID, stringExtra);
        }
    }

    private final void c(Intent intent, HashMap<String, String> schemaData) {
        if (schemaData != null && schemaData.containsKey("tagid")) {
            WinkDatongCurrentParams.put("xsj_topic_id", schemaData.get("tagid"));
        } else {
            Bundle extras = intent.getExtras();
            Intrinsics.checkNotNull(extras);
            if (extras.containsKey("QQWinkDataKeys-tag_id")) {
                WinkDatongCurrentParams.put("xsj_topic_id", intent.getStringExtra("QQWinkDataKeys-tag_id"));
            }
        }
        if (schemaData != null && schemaData.containsKey("tag")) {
            WinkDatongCurrentParams.put("xsj_topic_name", schemaData.get("tag"));
        } else {
            Bundle extras2 = intent.getExtras();
            Intrinsics.checkNotNull(extras2);
            if (extras2.containsKey("QQWinkDataKeys-tag_name")) {
                WinkDatongCurrentParams.put("xsj_topic_name", intent.getStringExtra("QQWinkDataKeys-tag_name"));
            }
        }
        if (schemaData != null && schemaData.containsKey("feedtagpagefromtype")) {
            WinkDatongCurrentParams.put("xsj_topic_page_source", schemaData.get("feedtagpagefromtype"));
            return;
        }
        Bundle extras3 = intent.getExtras();
        Intrinsics.checkNotNull(extras3);
        if (extras3.containsKey("QQWinkDataKeys-tag_from")) {
            WinkDatongCurrentParams.put("xsj_topic_page_source", intent.getStringExtra("QQWinkDataKeys-tag_from"));
        }
    }

    private final void d(HashMap<String, String> schemaData) {
        String str;
        String str2 = "";
        if (!schemaData.containsKey("xsj_operation_activity_id") ? !(!schemaData.containsKey("taskid") || (str = schemaData.get("taskid")) == null) : (str = schemaData.get("xsj_operation_activity_id")) != null) {
            str2 = str;
        }
        WinkDatongCurrentParams.put("xsj_operation_activity_id", str2);
    }

    private final void f(StringBuilder paiTongKuanType, StringBuilder paiTongKuanId, String schemeType, HashMap<String, String> schemaData) {
        if (schemaData.containsKey(schemeType)) {
            paiTongKuanType.append(schemeType);
            paiTongKuanType.append(",");
            paiTongKuanId.append(schemaData.get(schemeType));
            paiTongKuanId.append(",");
        }
    }

    public final void e(@NotNull Intent intent) {
        HashMap<String, String> hashMap;
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(intent, "intent");
        Serializable serializableExtra = intent.getSerializableExtra("key_attrs");
        if (serializableExtra instanceof HashMap) {
            hashMap = (HashMap) serializableExtra;
        } else {
            hashMap = null;
        }
        c(intent, hashMap);
        b(intent);
        a(hashMap);
        if (hashMap == null) {
            QLog.e("WinkReportInitializer", 1, "[initDatongParams] schemaData is null.");
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        StringBuilder sb6 = new StringBuilder();
        f(sb5, sb6, "filter", hashMap);
        f(sb5, sb6, "template", hashMap);
        f(sb5, sb6, "sticker", hashMap);
        f(sb5, sb6, "music", hashMap);
        f(sb5, sb6, "meterial", hashMap);
        f(sb5, sb6, "libtemplate", hashMap);
        if (sb5.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (sb6.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                sb5.deleteCharAt(sb5.length() - 1);
                sb6.deleteCharAt(sb6.length() - 1);
                WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_TYPE, sb5.toString());
                WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_ID, sb6.toString());
            }
        }
        d(hashMap);
        WinkDatongCurrentParams.put("xsj_url", intent.getStringExtra("key_scheme"));
        if (Intrinsics.areEqual(hashMap.get("up_source"), "24")) {
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_ATLAS_EXPLORE_PAGE, 1);
        } else {
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_ATLAS_EXPLORE_PAGE, 0);
        }
        if (hashMap.containsKey(QCircleScheme.AttrQQPublish.DATONG_REPORT_ELEMENT_PARAMS)) {
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TRANSF_PARAMS, hashMap.get(QCircleScheme.AttrQQPublish.DATONG_REPORT_ELEMENT_PARAMS));
        }
    }
}
