package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusDataManager;
import com.tencent.mobileqq.onlinestatus.utils.NewStatusCache;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes10.dex */
public class OnlineStatusConfProcessor extends BaseConfigParser<ai> {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(IConfigData iConfigData) {
        if (!(iConfigData instanceof ai)) {
            QLog.d("OnlineStatusConfProcessor", 1, "[onCdnDownload] loadLargeConfigAsync not instanceof");
            return;
        }
        QLog.d("OnlineStatusConfProcessor", 1, "[onCdnDownload] loadLargeConfigAsync");
        ai aiVar = (ai) iConfigData;
        ak.f202506a.d(aiVar);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IOnlineStatusService iOnlineStatusService = (IOnlineStatusService) peekAppRuntime.getRuntimeService(IOnlineStatusService.class, "");
        IOnlineStatusManagerService iOnlineStatusManagerService = (IOnlineStatusManagerService) peekAppRuntime.getRuntimeService(IOnlineStatusManagerService.class, "");
        OnlineStatusDataManager onlineStatusDataManager = (OnlineStatusDataManager) iOnlineStatusManagerService.getManager(com.tencent.mobileqq.onlinestatus.manager.f.class);
        if (onlineStatusDataManager != null) {
            onlineStatusDataManager.N(iOnlineStatusService.getExtOnlineStatus());
        }
        com.tencent.mobileqq.onlinestatus.manager.d dVar = (com.tencent.mobileqq.onlinestatus.manager.d) iOnlineStatusManagerService.getManager(com.tencent.mobileqq.onlinestatus.manager.d.class);
        if (dVar != null) {
            dVar.c(aiVar.h());
        }
        if (com.tencent.mobileqq.util.af.i()) {
            com.tencent.mobileqq.onlinestatus.manager.t.f255980a.i("from_conf_update");
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ai defaultConfig() {
        return new ai();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(@Nullable ai aiVar) {
        super.doOnConfigUpdate(aiVar);
        if (aiVar == null) {
            return;
        }
        QLog.d("OnlineStatusConfProcessor", 1, "doOnConfigUpdate " + aiVar);
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ai parse(@NonNull byte[] bArr) {
        String str;
        NewStatusCache.f256304a.m();
        try {
            str = new String(bArr, StandardCharsets.UTF_8);
        } catch (Exception e16) {
            QLog.e("OnlineStatusConfProcessor", 1, "OnlineStatusBean parse: " + e16);
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.w("OnlineStatusConfProcessor", 1, "[onParsed] item is null");
            return new ai();
        }
        ai p16 = ai.p(str);
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusConfProcessor", 2, "[onParsed] content=" + str);
        }
        return p16;
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onCdnDownload(boolean z16) {
        QLog.d("OnlineStatusConfProcessor", 1, "[onCdnDownload] " + z16);
        ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadLargeConfigAsync("100952", new py2.a() { // from class: com.tencent.mobileqq.config.business.aj
            @Override // py2.a
            public final void a(Object obj) {
                OnlineStatusConfProcessor.e((IConfigData) obj);
            }
        });
    }
}
