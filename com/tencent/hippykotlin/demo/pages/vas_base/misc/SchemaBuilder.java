package com.tencent.hippykotlin.demo.pages.vas_base.misc;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.QUISkinImage$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.d;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class SchemaBuilder {
    public static final SchemaBuilder INSTANCE = new SchemaBuilder();

    public final String addTraceDetailByInfo(String str, Function0<TraceDetailInfo> function0) {
        return buildUrlWithParams(str, new Pair[]{TuplesKt.to("traceDetail", function0.invoke().toBase64String())});
    }

    public final String buildUrlWithParams(String str, Pair<String, ?>[] pairArr) {
        boolean contains$default;
        if (pairArr.length == 0) {
            return str;
        }
        String str2 = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, false, 2, (Object) null);
        if (contains$default) {
            str2 = ContainerUtils.FIELD_DELIMITER;
        }
        StringBuilder sb5 = new StringBuilder(str);
        boolean z16 = true;
        for (Pair<String, ?> pair : pairArr) {
            if (!(pair.getFirst().length() == 0)) {
                if (!(String.valueOf(pair.getSecond()).length() == 0)) {
                    sb5.append(z16 ? str2 : ContainerUtils.FIELD_DELIMITER);
                    sb5.append(pair.getFirst());
                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb5.append(String.valueOf(pair.getSecond()));
                    if (z16) {
                        z16 = false;
                    }
                }
            }
        }
        return sb5.toString();
    }

    public final String buildVasKuiklySchema(Pair[] pairArr) {
        return buildUrlWithParams(QUISkinImage$$ExternalSyntheticOutline0.m("mqqapi://kuikly/open?version=1&src_type=app&qqmc_config=vas_kuikly_config&page_name=", "UploadBackgroundPage", "&bundle_name=", "vas_qqvip_page"), pairArr);
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class TraceDetailInfo {
        public String appId = "";
        public String pageId = "";
        public String moduleId = "";
        public String subModuleId = "";
        public String itemId = "";
        public String itemType = "";

        public final String toBase64String() {
            Map mapOf;
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("appid", this.appId), TuplesKt.to("page_id", this.pageId), TuplesKt.to("module_id", this.moduleId), TuplesKt.to("sub_module_id", this.subModuleId), TuplesKt.to("item_id", this.itemId), TuplesKt.to("item_type", this.itemType), TuplesKt.to("rule_id", ""), TuplesKt.to("str_ruleid", ""));
            e eVar = new e();
            for (Map.Entry entry : mapOf.entrySet()) {
                if (((CharSequence) entry.getValue()).length() > 0) {
                    eVar.v((String) entry.getKey(), entry.getValue());
                }
            }
            String eVar2 = eVar.toString();
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("base64-");
            m3.append(((d) c.f117352a.g().acquireModule("KRCodecModule")).b(eVar2));
            return m3.toString();
        }
    }
}
