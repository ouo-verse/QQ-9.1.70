package com.tencent.mobileqq.minigame.publicaccount.config;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0014\u0010\u0005\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0002\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/minigame/publicaccount/config/MiniGameConfigProcessor;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/minigame/publicaccount/config/MiniGameConfBean;", "()V", "defaultConfig", "parse", "content", "", "", DownloadInfo.spKey_Config, "", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameConfigProcessor extends BaseConfigParser<MiniGameConfBean> {
    private static final String CONFIG_ID = "100853";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "MiniGamePASubscribeProcessor";

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/minigame/publicaccount/config/MiniGameConfigProcessor$Companion;", "", "()V", "CONFIG_ID", "", "TAG", "loadConfig", "Lcom/tencent/mobileqq/minigame/publicaccount/config/MiniGameConfBean;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final MiniGameConfBean loadConfig() {
            MiniGameConfBean miniGameConfBean = (MiniGameConfBean) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniGameConfigProcessor.CONFIG_ID);
            return miniGameConfBean == null ? new MiniGameConfBean(false, false, 3, null) : miniGameConfBean;
        }

        Companion() {
        }
    }

    @JvmStatic
    public static final MiniGameConfBean loadConfig() {
        return INSTANCE.loadConfig();
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public MiniGameConfBean defaultConfig() {
        return new MiniGameConfBean(false, false, 2, null);
    }

    @Override // com.tencent.freesia.BaseConfigParser
    public MiniGameConfBean parse(byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        MiniGameConfBean miniGameConfBean = new MiniGameConfBean(false, false, 3, null);
        if (!(content.length == 0)) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            String str = new String(content, UTF_8);
            QLog.i(TAG, 1, "parse: config=" + str);
            parse(miniGameConfBean, str);
        } else {
            QLog.i(TAG, 1, "parse empty content");
        }
        return miniGameConfBean;
    }

    private final void parse(MiniGameConfBean miniGameConfBean, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            miniGameConfBean.setShowSubscribe(jSONObject.optInt("minigame_pa_subscribe", 0) == 1);
            miniGameConfBean.setScreenRecordEnabled(jSONObject.optInt("screenRecordEnabled", 0) == 1);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "parse error: " + e16.getMessage());
        }
    }
}
