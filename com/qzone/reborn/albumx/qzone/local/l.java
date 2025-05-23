package com.qzone.reborn.albumx.qzone.local;

import NS_UNDEAL_COUNT.count_info;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0016\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005J\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004J\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004J\u001c\u0010\u0011\u001a\u00020\u00072\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0004\u00a8\u0006\u0014"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/local/l;", "", "", "type", "", "", "ext", "", "g", "key", "value", tl.h.F, "d", "c", "b", "LNS_UNDEAL_COUNT/count_info;", "stMapCountInfo", "e", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final l f52668a = new l();

    l() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            if ((entry != null ? (count_info) entry.getValue() : null) != null) {
                l lVar = f52668a;
                int intValue = ((Number) entry.getKey()).intValue();
                Object value = entry.getValue();
                Intrinsics.checkNotNull(value);
                Map<String, String> map2 = ((count_info) value).ext;
                Intrinsics.checkNotNullExpressionValue(map2, "entry.value!!.ext");
                lVar.g(intValue, map2);
            }
        }
    }

    public final Map<String, String> b() {
        HashMap<String, String> b16 = com.qzone.reborn.util.g.b(com.qzone.reborn.configx.g.f53821a.b().q1());
        return b16 == null ? new HashMap() : b16;
    }

    public final Map<String, String> c() {
        String C0 = com.qzone.reborn.configx.g.f53821a.b().C0();
        if (TextUtils.isEmpty(C0)) {
            C0 = "{\n    \"1_1\": {\n        \"name\": \"\u5e38\u89c4\u5730\u70b9\",\n        \"titles\": [\n            \"%s\u4e4b\u884c\",\n            \"%s\u4e4b\u65c5\",\n            \"\u5927\u7231%s\"\n        ]\n    },\n    \"1_2\": {\n        \"name\": \"\u5bb6\u4e61\",\n        \"titles\": [\n            \"\u5bb6\u4e61\u8bb0\u5fc6\"\n        ]\n    },\n    \"1_3\": {\n        \"name\": \"\u5730\u70b9+\u5e74\u4efd\",\n        \"titles\": [\n            \"\u884c\u8005%s\",\n            \"%s\u5728\u8def\u4e0a\"\n        ]\n    },\n    \"2_1\": {\n        \"name\": \"\u8282\u65e5\",\n        \"titles\": [\n            \"%s\"\n        ]\n    },\n    \"2_2\": {\n        \"name\": \"\u5468\u672b\",\n        \"titles\": [\n            \"\u5468\u672b\u65f6\u5149\"\n        ]\n    },\n    \"2_3\": {\n        \"name\": \"\u6625\",\n        \"titles\": [\n            \"\u6625\u65e5\u8e0f\u9752\"\n        ]\n    },\n    \"2_4\": {\n        \"name\": \"\u590f\",\n        \"titles\": [\n            \"\u76db\u590f\u65f6\u8282\"\n        ]\n    },\n    \"2_5\": {\n        \"name\": \"\u79cb\",\n        \"titles\": [\n            \"\u79cb\u65e5\u70c2\u6f2b\"\n        ]\n    },\n    \"2_6\": {\n        \"name\": \"\u51ac\",\n        \"titles\": [\n            \"\u51ac\u5b63\u65f6\u5149\"\n        ]\n    },\n    \"3_1\": {\n        \"name\": \"\u805a\u4f1a\",\n        \"titles\": [\n            \"\u6b22\u805a\u65f6\u523b\",\n            \"\u7f8e\u597d\u65f6\u5149\",\n            \"%s\u5c0f\u805a\"\n        ]\n    },\n    \"3_2\": {\n        \"name\": \"\u751f\u65e5\",\n        \"titles\": [\n            \"Happy Birthday\"\n        ]\n    },\n    \"3_3\": {\n        \"name\": \"\u7ed3\u5a5a\",\n        \"titles\": [\n            \"\u611f\u52a8\u77ac\u95f4\"\n        ]\n    },\n    \"3_4\": {\n        \"name\": \"\u4eb2\u5b50\u751f\u65e5\",\n        \"titles\": [\n            \"%s\u5b9d\u8d1d\u751f\u65e5\"\n        ]\n    },\n    \"3_5\": {\n        \"name\": \"\u4eb2\u5b50\u65e5\u5e38\",\n        \"titles\": [\n            \"\u6709\u4f60\u771f\u597d\"\n        ]\n    },\n    \"3_6\": {\n        \"name\": \"\u4eb2\u5b50\u65e5\u5e38\",\n        \"titles\": [\n            \"%s\u6210\u957f\u65e5\u8bb0\"\n        ]\n    },\n    \"3_7\": {\n        \"name\": \"\u5ba0\u7269\",\n        \"titles\": [\n            \"\u6211\u7684\u5ba0\u7269\u65e5\u8bb0\"\n        ]\n    },\n    \"3_8\": {\n        \"name\": \"\u60c5\u4fa3\u7a7a\u95f4\",\n        \"titles\": [\n            \"%s\u7eaa\u5ff5\u65e5\"\n        ]\n    },\n    \"4_1\": {\n        \"name\": \"\u7f8e\u98df\",\n        \"titles\": [\n            \"\u552f\u6709\u7f8e\u98df\u4e0d\u53ef\u8f9c\u8d1f\"\n        ]\n    },\n    \"5_1\": {\n        \"name\": \"\u65c5\u884c\",\n        \"titles\": [\n            \"\u6211\u7684\u8db3\u8ff9\"\n        ]\n    },\n    \"5_2\": {\n        \"name\": \"\u65c5\u884c\",\n        \"titles\": [\n            \"\u65c5\u884c\u65f6\u523b\"\n        ]\n    },\n    \"5_3\": {\n        \"name\": \"\u90a3\u5e74\u4eca\u65e5\",\n        \"titles\": [\n            \"\u90a3\u5e74\u4eca\u65e5\"\n        ]\n    },\n    \"5_4\": {\n        \"name\": \"\u5a5a\u793c\",\n        \"titles\": [\n            \"\u5e78\u798f\u65f6\u523b\"\n        ]\n    },\n    \"5_5\": {\n        \"name\": \"\u5ba0\u7269\",\n        \"titles\": [\n            \"\u840c\u5ba0\u5b9d\u8d1d\"\n        ]\n    },\n    \"5_6\": {\n        \"name\": \"\u4eb2\u5b50\",\n        \"titles\": [\n            \"\u5b9d\u8d1d\u65e5\u8bb0\"\n        ]\n    },\n    \"5_7\": {\n        \"name\": \"\u60c5\u4fa3\",\n        \"titles\": [\n            \"\u96be\u5fd8\u4e00\u523b\"\n        ]\n    }\n}";
        }
        Map<String, Object> a16 = com.qzone.reborn.util.g.a(C0);
        HashMap hashMap = new HashMap();
        if (a16 != null && !a16.isEmpty()) {
            for (Map.Entry<String, Object> entry : a16.entrySet()) {
                String key = entry.getKey();
                Intrinsics.checkNotNullExpressionValue(key, "entry.key");
                hashMap.put(key, entry.getValue().toString());
            }
            return hashMap;
        }
        QZLog.e("QZoneUploadRecommendConfig", 1, "[covertJsonMapData] configMap isEmpty");
        return hashMap;
    }

    public final String d(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        String j3 = com.qzone.reborn.util.i.b().j("qz_local_recommend_config_" + key, "");
        Intrinsics.checkNotNullExpressionValue(j3, "g().getString(QZoneMMKVK\u2026COMMEND_CONFIG + key, \"\")");
        return j3;
    }

    public final void h(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        com.qzone.reborn.util.i.b().r("qz_local_recommend_config_" + key, value);
    }

    public final void e(final Map<Integer, count_info> stMapCountInfo) {
        if (stMapCountInfo != null && !stMapCountInfo.isEmpty()) {
            RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.qzone.reborn.albumx.qzone.local.k
                @Override // java.lang.Runnable
                public final void run() {
                    l.f(stMapCountInfo);
                }
            });
        } else {
            QLog.e("QZoneUploadRecommendConfig", 1, "stMapCountInfo is null, return");
        }
    }

    private final void g(int type, Map<String, String> ext) {
        if (type == 1021) {
            h("recommend_parenting_album_birthday", ext.toString());
        } else if (type == 1023) {
            h("resident_login_city", ext.toString());
        } else {
            if (type != 1024) {
                return;
            }
            h("recommend_hometown", ext.toString());
        }
    }
}
