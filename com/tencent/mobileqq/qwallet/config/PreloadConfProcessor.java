package com.tencent.mobileqq.qwallet.config;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tencent.common.app.AppInterface;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.base.a;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.qwallet.utils.g;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import kl2.PreloadConfBean;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class PreloadConfProcessor extends BaseConfigParser<PreloadConfBean> {

    /* renamed from: d, reason: collision with root package name */
    private static Gson f277120d = new GsonBuilder().create();

    public static String d() {
        return "preload_conf_version_" + a.c();
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public PreloadConfBean defaultConfig() {
        return new PreloadConfBean(new ArrayList());
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(@Nullable PreloadConfBean preloadConfBean) {
        if (QLog.isColorLevel()) {
            QLog.d("PreloadConfProcessor", 2, "[onUpdate]");
        }
        IPreloadService iPreloadService = (IPreloadService) ((AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null)).getRuntimeService(IPreloadService.class, "");
        iPreloadService.replaceConfig(preloadConfBean);
        iPreloadService.savePreloadConfig();
        iPreloadService.startCheckConfig(true);
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public PreloadConfBean parse(@NonNull byte[] bArr) {
        try {
            return (PreloadConfBean) f277120d.fromJson(new String(bArr, StandardCharsets.UTF_8), PreloadConfBean.class);
        } catch (Exception e16) {
            QLog.e("PreloadConfProcessor", 1, "parse: ", e16);
            return defaultConfig();
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onRemoved() {
        QLog.d("PreloadConfProcessor", 2, "onRemoved: ");
        g.s(d());
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onSend(@NonNull String str) {
        QLog.d("PreloadConfProcessor", 2, "onSend: version " + str);
        g.q(d(), str);
    }
}
