package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.impl.ScenesRecommendManagerImpl;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes10.dex */
public class ScenesEmotionConfigProcessor extends BaseConfigParser<a> {

    /* loaded from: classes10.dex */
    public static class a implements IConfigData {

        /* renamed from: d, reason: collision with root package name */
        public String f202477d = "";
    }

    private void e(String str) {
        try {
            QLog.d("ScencesEmotionConfigProcessor", 1, "saveConfig content = " + str);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof AppInterface) {
                AppInterface appInterface = (AppInterface) peekAppRuntime;
                com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.c.e(appInterface, str);
                ScenesRecommendManagerImpl.get(appInterface).loadConfigFromLocal();
            }
        } catch (Exception e16) {
            QLog.e("ScencesEmotionConfigProcessor", 1, "saveConfig has exception", e16);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a defaultConfig() {
        return new a();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(@Nullable a aVar) {
        super.doOnConfigUpdate(aVar);
        QLog.d("ScencesEmotionConfigProcessor", 1, "doOnConfigUpdate");
        if (aVar != null) {
            e(aVar.f202477d);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public a parse(@NonNull byte[] bArr) {
        a aVar = new a();
        String str = new String(bArr, StandardCharsets.UTF_8);
        aVar.f202477d = str;
        if (!TextUtils.isEmpty(str)) {
            e(str);
        } else {
            QLog.d("ScencesEmotionConfigProcessor", 1, "parse null");
        }
        return aVar;
    }
}
