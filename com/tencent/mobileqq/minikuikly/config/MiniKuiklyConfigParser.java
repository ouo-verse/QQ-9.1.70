package com.tencent.mobileqq.minikuikly.config;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import f92.a;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/minikuikly/config/MiniKuiklyConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lf92/a;", "", DownloadInfo.spKey_Config, "", "d", "b", "", "content", "c", "<init>", "()V", "a", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MiniKuiklyConfigParser extends BaseConfigParser<a> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a defaultConfig() {
        return new a();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a parse(byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        a aVar = new a();
        if (!(content.length == 0)) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            d(aVar, new String(content, UTF_8));
        } else {
            QLog.i("MiniKuiklyConfigParser", 1, "parse empty content");
        }
        return aVar;
    }

    private final void d(a aVar, String str) {
        JSONObject optJSONObject;
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "json.keys()");
            while (keys.hasNext()) {
                String key = (String) keys.next();
                Intrinsics.checkNotNullExpressionValue(key, "key");
                if ((key.length() > 0) && (optJSONObject = jSONObject.optJSONObject(key)) != null) {
                    Intrinsics.checkNotNullExpressionValue(optJSONObject, "optJSONObject(key)");
                    Map<String, a.KuiklyConfig> a16 = aVar.a();
                    String optString = optJSONObject.optString("openinfo");
                    Intrinsics.checkNotNullExpressionValue(optString, "configObject.optString(\"openinfo\")");
                    String optString2 = optJSONObject.optString("configID");
                    Intrinsics.checkNotNullExpressionValue(optString2, "configObject.optString(\"configID\")");
                    a16.put(key, new a.KuiklyConfig(optString, optString2));
                }
            }
        } catch (JSONException e16) {
            QLog.e("MiniKuiklyConfigParser", 1, "parse error: " + e16.getMessage());
        }
    }
}
