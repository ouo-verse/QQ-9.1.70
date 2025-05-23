package com.tencent.mobileqq.mini.config.united;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000e\u000fB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0014J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/mini/config/united/MiniConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/mini/config/united/MiniConfigParser$Config;", "()V", "defaultConfig", "doOnConfigUpdate", "", DownloadInfo.spKey_Config, "onSend", "version", "", "parse", "content", "", "Companion", "Config", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniConfigParser extends BaseConfigParser<Config> {
    public static final String TAG = "MiniConfigParser";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.freesia.BaseConfigParser
    public void doOnConfigUpdate(Config config) {
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onSend(String version) {
        Intrinsics.checkNotNullParameter(version, "version");
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/mini/config/united/MiniConfigParser$Config;", "Lcom/tencent/freesia/IConfigData;", "()V", DownloadInfo.spKey_Config, "Lorg/json/JSONObject;", "getConfig", "()Lorg/json/JSONObject;", "setConfig", "(Lorg/json/JSONObject;)V", "parse", "", "content", "", "toSafeJson", "jsonString", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class Config implements IConfigData {
        public static final String TAG = "ECUnitedConfigParser.Config";
        private JSONObject config = new JSONObject();

        public final JSONObject getConfig() {
            return this.config;
        }

        public final void parse(String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            QLog.d(TAG, 1, "parse config: " + content);
            JSONObject safeJson = toSafeJson(content);
            this.config = safeJson;
            QLog.d(TAG, 1, "parse config json: " + safeJson);
        }

        public final void setConfig(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "<set-?>");
            this.config = jSONObject;
        }

        private final JSONObject toSafeJson(String jsonString) {
            if (jsonString == null || jsonString.length() == 0) {
                return new JSONObject();
            }
            try {
                return new JSONObject(jsonString);
            } catch (JSONException unused) {
                return new JSONObject();
            }
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public Config defaultConfig() {
        return new Config();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    public Config parse(byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        QLog.d(TAG, 1, "parse config");
        Config config = new Config();
        if (!(content.length == 0)) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            config.parse(new String(content, UTF_8));
            QLog.d(TAG, 1, "config: " + config.getConfig());
        } else {
            QLog.d(TAG, 1, "parse empty content");
        }
        return config;
    }
}
