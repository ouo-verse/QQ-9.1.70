package com.tencent.mobileqq.webview.config;

import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/webview/config/HardSandBoxConfigParser;", "Lcom/tencent/mobileqq/webview/config/BaseUnitedConfig;", "Lcom/tencent/mobileqq/webview/config/b;", "", "content", "c", "b", "", "getGroup", "<init>", "()V", "e", "a", "webview_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class HardSandBoxConfigParser extends BaseUnitedConfig<b> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b defaultConfig() {
        return new b();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b parse(byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        try {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            JSONObject jSONObject = new JSONObject(new String(content, UTF_8));
            b bVar = new b();
            bVar.a(jSONObject);
            QLog.d("HardSandBoxConfigParser_SandBoxControl", 1, "parse result:" + bVar);
            return bVar;
        } catch (Exception e16) {
            QLog.d("HardSandBoxConfigParser_SandBoxControl", 1, "parse exception. ", e16);
            return defaultConfig();
        }
    }

    @Override // com.tencent.mobileqq.webview.config.BaseUnitedConfig
    public String getGroup() {
        return "webview_hard_sandbox_switch";
    }
}
