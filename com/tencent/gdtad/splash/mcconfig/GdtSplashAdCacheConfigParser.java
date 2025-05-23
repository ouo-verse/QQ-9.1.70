package com.tencent.gdtad.splash.mcconfig;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.freesia.NetworkResult;
import com.tencent.gdtad.splash.GdtSplashAdCacheTool;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;

/* loaded from: classes6.dex */
public class GdtSplashAdCacheConfigParser extends BaseConfigParser<a> {

    /* loaded from: classes6.dex */
    public static class a implements IConfigData {

        /* renamed from: d, reason: collision with root package name */
        boolean f109381d = false;
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a defaultConfig() {
        QLog.i("GdtSplashAdCacheConfigParser", 1, "defaultConfig");
        return new a();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(@Nullable a aVar) {
        super.doOnConfigUpdate(aVar);
        if (aVar != null) {
            if (aVar.f109381d) {
                GdtSplashAdCacheTool.f();
            }
            QLog.i("GdtSplashAdCacheConfigParser", 1, "doOnConfigUpdate, isDelCache=" + aVar.f109381d + ", cfg.hash=" + aVar.hashCode() + ", thread=" + Thread.currentThread());
            return;
        }
        QLog.e("GdtSplashAdCacheConfigParser", 1, "doOnConfigUpdate, cfg==null");
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public a parse(@NonNull byte[] bArr) {
        a aVar = new a();
        aVar.f109381d = com.tencent.gdtad.splash.mcconfig.a.c();
        String str = "";
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    str = new String(bArr, StandardCharsets.UTF_8);
                }
            } catch (Exception e16) {
                QLog.e("GdtSplashAdCacheConfigParser", 1, "parse, exp=" + e16.toString());
            }
        }
        QLog.i("GdtSplashAdCacheConfigParser", 1, "parse, isDelCache=" + aVar.f109381d + ", cfg.hash=" + aVar.hashCode() + ", cfgStr=" + str);
        return aVar;
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onReceiveNotUpdate(@NonNull NetworkResult networkResult) {
        super.onReceiveNotUpdate(networkResult);
        if (QLog.isColorLevel()) {
            QLog.i("GdtSplashAdCacheConfigParser", 2, "onReceiveNotUpdate");
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onRemoved() {
        super.onRemoved();
        QLog.i("GdtSplashAdCacheConfigParser", 1, "onRemoved, isDelCache=" + com.tencent.gdtad.splash.mcconfig.a.c());
    }
}
