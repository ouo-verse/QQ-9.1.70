package com.tencent.mobileqq.minigame.config;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0014\u0010\u0005\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0002\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/minigame/config/MiniGamePallasConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/minigame/config/MiniGamePallasConfig;", "()V", "defaultConfig", "parse", "content", "", "", DownloadInfo.spKey_Config, "", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGamePallasConfigParser extends BaseConfigParser<MiniGamePallasConfig> {
    private static final String TAG = "MiniGamePallasConfigParser";

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public MiniGamePallasConfig defaultConfig() {
        return new MiniGamePallasConfig();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    public MiniGamePallasConfig parse(byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        MiniGamePallasConfig miniGamePallasConfig = new MiniGamePallasConfig();
        if (!(content.length == 0)) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            parse(miniGamePallasConfig, new String(content, UTF_8));
        } else {
            QLog.i(TAG, 1, "parse empty content");
        }
        return miniGamePallasConfig;
    }

    private final void parse(MiniGamePallasConfig miniGamePallasConfig, String str) {
        try {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "parse config:" + str);
            }
            JSONObject jSONObject = new JSONObject(str);
            miniGamePallasConfig.setFileDownloadType(jSONObject.optInt(WnsConfig.SECONDARY_KEY_MINI_GAME_SDK_ENABLE_DOWNLOADER, 1));
            miniGamePallasConfig.setEnableRecordScreen(jSONObject.optBoolean("enableRecordScreen", false));
        } catch (Exception e16) {
            QLog.e(TAG, 1, "parse error: " + e16.getMessage());
        }
    }
}
