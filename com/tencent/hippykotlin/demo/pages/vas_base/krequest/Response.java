package com.tencent.hippykotlin.demo.pages.vas_base.krequest;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class Response {
    public final RequestConfig config;
    public final e data;
    public final Map<String, String> headers;
    public final int status;
    public final String statusText;

    public Response(e eVar, int i3, String str, Map<String, String> map, RequestConfig requestConfig) {
        this.data = eVar;
        this.status = i3;
        this.statusText = str;
        this.headers = map;
        this.config = requestConfig;
    }

    public final int hashCode() {
        return this.config.hashCode() + ((this.headers.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.statusText, QQAudioParams$$ExternalSyntheticOutline0.m(this.status, this.data.hashCode() * 31, 31), 31)) * 31);
    }

    public final String toString() {
        String trimIndent;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\n            status: ");
        m3.append(this.status);
        m3.append(",\n            statusText: ");
        m3.append(this.statusText);
        m3.append(",\n            data: ");
        m3.append(this.data);
        m3.append(",\n            headers: ");
        m3.append(this.headers);
        m3.append("\n        ");
        trimIndent = StringsKt__IndentKt.trimIndent(m3.toString());
        return trimIndent;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Response)) {
            return false;
        }
        Response response = (Response) obj;
        return Intrinsics.areEqual(this.data, response.data) && this.status == response.status && Intrinsics.areEqual(this.statusText, response.statusText) && Intrinsics.areEqual(this.headers, response.headers) && Intrinsics.areEqual(this.config, response.config);
    }

    public /* synthetic */ Response(e eVar, int i3, String str, RequestConfig requestConfig) {
        this(eVar, i3, str, new LinkedHashMap(), requestConfig);
    }
}
