package com.tencent.mobileqq.minigame.config;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0014\u0010\t\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/minigame/config/MiniGameSDKConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/minigame/config/MiniGameSDKConfig;", "()V", "defaultConfig", "onSend", "", "version", "", "parse", "content", "", DownloadInfo.spKey_Config, "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameSDKConfigParser extends BaseConfigParser<MiniGameSDKConfig> {
    private static final String TAG = "MiniGameUnitedConfigParser";

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onSend(String version) {
        Intrinsics.checkNotNullParameter(version, "version");
        QLog.i(TAG, 1, "onSend: version=" + version);
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public MiniGameSDKConfig defaultConfig() {
        return new MiniGameSDKConfig();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    public MiniGameSDKConfig parse(byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        MiniGameSDKConfig miniGameSDKConfig = new MiniGameSDKConfig();
        if (!(content.length == 0)) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            String str = new String(content, UTF_8);
            QLog.i(TAG, 1, "parse: config=" + str);
            parse(miniGameSDKConfig, str);
        } else {
            QLog.i(TAG, 1, "parse empty content");
        }
        return miniGameSDKConfig;
    }

    private final void parse(MiniGameSDKConfig miniGameSDKConfig, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            miniGameSDKConfig.setFirstGameFixDuration(jSONObject.optInt("firstGameFixDuration", 60));
            miniGameSDKConfig.setSecondGameFixDuration(jSONObject.optInt("secondGameFixDuration", 30));
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "parse error: " + e16.getMessage());
        }
    }
}
