package com.tencent.mobileqq.qwallet.config.impl;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Config;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.config.impl.QWalletConfigServiceImpl;
import com.tencent.mobileqq.qwallet.hb.IHbThemeConfigApi;
import com.tencent.mobileqq.qwallet.hb.panel.RedPacketManager;
import com.tencent.mobileqq.qwallet.hb.skin.HbSkinRepository;
import com.tencent.qphone.base.util.QLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QWalletConfigServiceImpl implements IQWalletConfigService {
    private static final String TAG = "QWalletConfigServiceImpl";
    private static final Object TRY_REQUEST_LOCK = new Object();
    private static final long TRY_REQUEST_REFRESH_TIME = 86400000;
    private volatile long mLastTryRequestTime = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit lambda$tryRequestAllConfig$0(Boolean bool) {
        QLog.d(TAG, 1, "tryRequestAllConfig: isSuccess" + bool);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$tryRequestAllConfig$1(long j3) {
        synchronized (TRY_REQUEST_LOCK) {
            this.mLastTryRequestTime = j3;
            if (RedPacketManager.f277534a.e() == null) {
                RedPacketManager.n(new Function1() { // from class: rk2.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit lambda$tryRequestAllConfig$0;
                        lambda$tryRequestAllConfig$0 = QWalletConfigServiceImpl.lambda$tryRequestAllConfig$0((Boolean) obj);
                        return lambda$tryRequestAllConfig$0;
                    }
                });
            }
            HbSkinRepository.f277840a.k(false);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.config.IQWalletConfigService
    public void handleQWalletSettingCofig(ConfigurationService$Config configurationService$Config) {
        ((IHbThemeConfigApi) QRoute.api(IHbThemeConfigApi.class)).handleQWalletSettingConfig(configurationService$Config);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "QWalletConfigServiceImpl init");
        }
        if (RedPacketManager.f277534a.e() == null) {
            QLog.i(TAG, 1, "onCreate: hbPanelConfig is null");
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        this.mLastTryRequestTime = -1L;
    }

    @Override // com.tencent.mobileqq.qwallet.config.IQWalletConfigService
    public void tryRequestAllConfig() {
        final long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        if (Math.abs(serverTimeMillis - this.mLastTryRequestTime) < 86400000) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: rk2.b
            @Override // java.lang.Runnable
            public final void run() {
                QWalletConfigServiceImpl.this.lambda$tryRequestAllConfig$1(serverTimeMillis);
            }
        }, 128, null, true);
    }

    @Override // com.tencent.mobileqq.qwallet.config.IQWalletConfigService
    public void tryGetConfig(int i3) {
    }
}
