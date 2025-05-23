package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;

/* loaded from: classes10.dex */
public class OnlineAutoStatusConfProcessor extends BaseConfigParser<af> {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(IConfigData iConfigData) {
        if (!(iConfigData instanceof af)) {
            QLog.d("OnlineAutoStatusConfProcessor", 1, "[onCdnDownload] loadLargeConfigAsync not instanceof");
        } else {
            QLog.d("OnlineAutoStatusConfProcessor", 1, "[onCdnDownload] loadLargeConfigAsync");
            ah.f202497a.c((af) iConfigData);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public af defaultConfig() {
        return new af();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(@Nullable af afVar) {
        super.doOnConfigUpdate(afVar);
        if (afVar == null) {
            return;
        }
        QLog.d("OnlineAutoStatusConfProcessor", 1, "doOnConfigUpdate " + afVar);
        ah.f202497a.c(afVar);
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public af parse(@NonNull byte[] bArr) {
        String str = new String(bArr, StandardCharsets.UTF_8);
        if (!TextUtils.isEmpty(str)) {
            af c16 = af.c(str);
            QLog.d("OnlineAutoStatusConfProcessor", 1, "onParsed " + str);
            return c16;
        }
        QLog.d("OnlineAutoStatusConfProcessor", 1, "onParsed is null");
        return new af();
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onCdnDownload(boolean z16) {
        QLog.d("OnlineAutoStatusConfProcessor", 1, "[onCdnDownload] " + z16);
        super.onCdnDownload(z16);
        ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadLargeConfigAsync("101325", new py2.a() { // from class: com.tencent.mobileqq.config.business.ag
            @Override // py2.a
            public final void a(Object obj) {
                OnlineAutoStatusConfProcessor.e((IConfigData) obj);
            }
        });
    }
}
