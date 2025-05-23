package com.tencent.mobileqq.config.aio;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ma1.e;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\r\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/config/aio/ZhiTuConfParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lma1/e;", "", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "", "e", "b", "", "content", "d", "c", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class ZhiTuConfParser extends BaseConfigParser<e> {
    private final void e(String config, QQAppInterface app) {
        boolean z16;
        try {
            JSONObject jSONObject = new JSONObject(config);
            boolean z17 = false;
            if (jSONObject.has("kMarioConfigEnable")) {
                int i3 = jSONObject.getInt("kMarioConfigEnable");
                ZhituManager I = ZhituManager.I(app);
                if (i3 == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                I.N0(z16);
            }
            if (jSONObject.has("kMarioPageLen")) {
                ZhituManager.I(app).K0(jSONObject.getInt("kMarioPageLen"));
            }
            if (jSONObject.has("kMarioSaveAndShareEnable")) {
                int i16 = jSONObject.getInt("kMarioSaveAndShareEnable");
                ZhituManager I2 = ZhituManager.I(app);
                if (i16 == 1) {
                    z17 = true;
                }
                I2.S0(z17);
            }
            if (jSONObject.has("kMarioSafeGateRequestInterval")) {
                ZhituManager.I(app).O0(jSONObject.getInt("kMarioSafeGateRequestInterval"));
            }
        } catch (JSONException e16) {
            QLog.e("ZhiTuConfParser", 1, "saveConfig " + e16);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e defaultConfig() {
        return new e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(@Nullable e config) {
        super.doOnConfigUpdate(config);
        if (config != null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof QQAppInterface) {
                e(config.getConfigString(), (QQAppInterface) peekAppRuntime);
            }
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public e parse(@NotNull byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        String str = new String(content, UTF_8);
        e eVar = new e();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QLog.d("ZhiTuConfParser", 1, "conifg " + str);
        if (peekAppRuntime instanceof QQAppInterface) {
            eVar.b(str);
            e(str, (QQAppInterface) peekAppRuntime);
        }
        return eVar;
    }
}
