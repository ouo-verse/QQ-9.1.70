package com.tencent.mobileqq.minigame.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.gamecenter.api.IYunGameChannelApi;
import com.tencent.mobileqq.minigame.api.IMiniGameVALoginApi;
import com.tencent.mobileqq.minigame.config.MiniGameVAInterceptConfig;
import com.tencent.mobileqq.minigame.va.GameLoginInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClientConstants;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0002J.\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0014\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\n0\u000eH\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/minigame/api/impl/MiniGameVALoginApiImpl;", "Lcom/tencent/mobileqq/minigame/api/IMiniGameVALoginApi;", "()V", "gameLoginInfoCacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mobileqq/minigame/va/GameLoginInfo;", "findGameAppId", PushClientConstants.TAG_PKG_NAME, "getLoginInfo", "", "forceUpdate", "", "callback", "Lkotlin/Function1;", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameVALoginApiImpl implements IMiniGameVALoginApi {
    private static final String TAG = "MiniGameVALoginApiImpl";
    private final ConcurrentHashMap<String, GameLoginInfo> gameLoginInfoCacheMap = new ConcurrentHashMap<>();

    private final String findGameAppId(String pkgName) {
        Map<String, MiniGameVAInterceptConfig.VAInterceptConfig> interceptConfigMap;
        MiniGameVAInterceptConfig miniGameVAInterceptConfig = (MiniGameVAInterceptConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniGameVAInterceptConfig.CONFIG_ID);
        String str = "";
        if (miniGameVAInterceptConfig != null && (interceptConfigMap = miniGameVAInterceptConfig.getInterceptConfigMap()) != null) {
            for (Map.Entry<String, MiniGameVAInterceptConfig.VAInterceptConfig> entry : interceptConfigMap.entrySet()) {
                if (TextUtils.equals(pkgName, entry.getValue().getGameAppPkgName())) {
                    str = entry.getValue().getGameAppId();
                }
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getLoginInfo$lambda$0(String str, Function1 callback, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        QLog.d(TAG, 2, "getLoginInfo accessToken:" + str2 + " payToken:" + str3 + " openId:" + str4 + " appId:" + str5);
        GameLoginInfo gameLoginInfo = new GameLoginInfo();
        if (str2 == null) {
            str2 = "";
        }
        gameLoginInfo.accessToken = str2;
        if (str3 == null) {
            str3 = "";
        }
        gameLoginInfo.payToken = str3;
        if (str4 == null) {
            str4 = "";
        }
        gameLoginInfo.openId = str4;
        gameLoginInfo.appId = str;
        callback.invoke(gameLoginInfo);
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVALoginApi
    public void getLoginInfo(String pkgName, boolean forceUpdate, final Function1<? super GameLoginInfo, Unit> callback) {
        GameLoginInfo remove;
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (TextUtils.isEmpty(pkgName)) {
            callback.invoke(null);
            return;
        }
        if (!forceUpdate && (remove = this.gameLoginInfoCacheMap.remove(pkgName)) != null && !TextUtils.isEmpty(remove.accessToken) && !TextUtils.isEmpty(remove.openId)) {
            callback.invoke(remove);
            QLog.d(TAG, 1, "getLoginInfo from cache pkgName:" + pkgName + " gameLoginInfo:" + remove);
            return;
        }
        final String findGameAppId = findGameAppId(pkgName);
        if (TextUtils.isEmpty(findGameAppId)) {
            callback.invoke(null);
        } else {
            ((IYunGameChannelApi) QRoute.api(IYunGameChannelApi.class)).startGetLaunchKeys(findGameAppId, new IYunGameChannelApi.OnGetLaunchKeyListener() { // from class: com.tencent.mobileqq.minigame.api.impl.g
                @Override // com.tencent.mobileqq.gamecenter.api.IYunGameChannelApi.OnGetLaunchKeyListener
                public final void onResult(String str, String str2, String str3, String str4) {
                    MiniGameVALoginApiImpl.getLoginInfo$lambda$0(findGameAppId, callback, str, str2, str3, str4);
                }
            });
        }
    }
}
