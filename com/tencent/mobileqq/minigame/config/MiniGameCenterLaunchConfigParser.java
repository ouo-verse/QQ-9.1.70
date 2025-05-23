package com.tencent.mobileqq.minigame.config;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/minigame/config/MiniGameCenterLaunchConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/minigame/config/MiniGameCenterLaunchConfig;", "()V", "defaultConfig", "parse", "content", "", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameCenterLaunchConfigParser extends BaseConfigParser<MiniGameCenterLaunchConfig> {
    private static final String TAG = "MiniGameCenterLaunchConfigParser";

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public MiniGameCenterLaunchConfig defaultConfig() {
        return new MiniGameCenterLaunchConfig();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    public MiniGameCenterLaunchConfig parse(byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        MiniGameCenterLaunchConfig miniGameCenterLaunchConfig = new MiniGameCenterLaunchConfig();
        if (!(content.length == 0)) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            String str = new String(content, UTF_8);
            if (QLog.isDevelopLevel()) {
                QLog.i(TAG, 4, "parse: config=" + str);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                miniGameCenterLaunchConfig.setEnable(jSONObject.optBoolean("isEnable", false));
                String optString = jSONObject.optString(ZPlanPublishSource.FROM_SCHEME, "");
                Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"scheme\", \"\")");
                miniGameCenterLaunchConfig.setScheme(optString);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "parse fail, exception=", e16);
            }
        } else {
            QLog.w(TAG, 1, "parse empty content");
        }
        return miniGameCenterLaunchConfig;
    }
}
