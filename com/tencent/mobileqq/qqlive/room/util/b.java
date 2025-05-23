package com.tencent.mobileqq.qqlive.room.util;

import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qqlive/context/QQLiveContext;", "qqLiveContext", "", "a", "timi-game-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b {
    @NotNull
    public static final String a(@Nullable QQLiveContext qQLiveContext) {
        HashMap<String, String> l3;
        String str;
        String str2 = "";
        if (qQLiveContext != null && (l3 = qQLiveContext.l()) != null) {
            if (!Intrinsics.areEqual(qQLiveContext.j(), "12") && !Intrinsics.areEqual(qQLiveContext.j(), "14")) {
                if (l3.containsKey("activity_id") && (str = l3.get("activity_id")) != null) {
                    str2 = str;
                }
                Intrinsics.checkNotNullExpressionValue(str2, "{\n            // \u5176\u4ed6\u5165\u53e3\u4eceac\u2026\"\n            }\n        }");
            } else if (l3.containsKey("trace_info")) {
                try {
                    str2 = new JSONObject(l3.get("trace_info")).optString("ad_id", "");
                } catch (Exception e16) {
                    AegisLogger.INSTANCE.e("Audience|SchemaAttributeKit", "getActivityId error", String.valueOf(e16));
                }
                Intrinsics.checkNotNullExpressionValue(str2, "{\n            // \u62bd\u5c49\u7ea2\u70b9\u4e0e\u52a8\u6001\u2026\"\n            }\n        }");
            }
        }
        return str2;
    }
}
