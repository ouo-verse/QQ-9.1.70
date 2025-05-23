package com.tencent.mobileqq.wink.publish;

import android.content.Intent;
import com.tencent.mobileqq.wink.tag.TagRetriever;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/b;", "", "Landroid/content/Intent;", "intent", "", "", "map", "", "a", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f325659a = new b();

    b() {
    }

    public final void a(@Nullable Intent intent, @NotNull Map<String, Object> map) {
        String str;
        Intrinsics.checkNotNullParameter(map, "map");
        Object obj = WinkDatongCurrentParams.get("xsj_topic_id");
        Intrinsics.checkNotNullExpressionValue(obj, "get(WinkDaTongReportCons\u2026entParamKey.XSJ_TOPIC_ID)");
        map.put("xsj_topic_id", obj);
        if (intent != null) {
            map.put("xsj_topic_name", TagRetriever.f326413a.j(intent));
        } else {
            Object obj2 = WinkDatongCurrentParams.get("xsj_topic_name");
            Intrinsics.checkNotNullExpressionValue(obj2, "get(WinkDaTongReportCons\u2026tParamKey.XSJ_TOPIC_NAME)");
            map.put("xsj_topic_name", obj2);
        }
        if (intent == null || (str = intent.getStringExtra("QQWinkDataKeys-tag_from")) == null) {
            str = "";
        }
        map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TOPIC_FROM, str);
        Object obj3 = WinkDatongCurrentParams.get("xsj_topic_page_source");
        Intrinsics.checkNotNullExpressionValue(obj3, "get(WinkDaTongReportCons\u2026ey.XSJ_TOPIC_PAGE_SOURCE)");
        map.put("xsj_topic_page_source", obj3);
    }
}
