package com.tencent.mobileqq.minigame.api.impl;

import android.os.Message;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.utils.MiniGameMMKVUtils;
import com.tencent.mobileqq.minigame.api.IMiniGameVABannerService;
import com.tencent.mobileqq.minigame.api.IMiniGameVAService;
import com.tencent.mobileqq.minigame.config.MiniGameVAInterceptConfig;
import com.tencent.mobileqq.minigame.va.MiniGameDownloadDataWrapper;
import com.tencent.mobileqq.minigame.va.StatusListener;
import com.tencent.mobileqq.minigame.va.banner.MiniGameVAResourceBannerInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\b\u0010\u0014\u001a\u00020\u000fH\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0016J\u0012\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u000fH\u0016J\u0012\u0010\u001a\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0016J \u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/minigame/api/impl/MiniGameVABannerServiceImpl;", "Lcom/tencent/mobileqq/minigame/api/IMiniGameVABannerService;", "()V", "currentBannerShowTs", "Lkotlin/Pair;", "", "", "downloadListenerMap", "", "Lcom/tencent/mobileqq/minigame/va/StatusListener;", "downloadingGameIds", "", "isBannerClosed", "", QCircleLpReportDc05507.KEY_CLEAR, "", "formatFileSize", "size", "getMiniGameAppId", VirtualAppProxy.KEY_GAME_ID, "hideBanner", "onBannerClose", "onCreate", "appRuntime", "Lmqq/app/AppRuntime;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onDownloadStart", "showBanner", "data", "Lcom/tencent/mobileqq/minigame/va/MiniGameDownloadDataWrapper;", "progress", "", "updateBanner", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameVABannerServiceImpl implements IMiniGameVABannerService {
    private static final String BANNER_STR_TEMPLATE = "\u6b63\u5728\u52a0\u8f7d%s\u9ad8\u6e05\u8d44\u6e90\u5305(%s/%s)";
    private static final long MAX_SHOW_DURATION = 3000;
    private static final String MMKV_KEY_BANNER_CLOSE = "mini_game_va_banner_close";
    private static final String TAG = "MiniGameVABannerServiceImpl";
    private Pair<String, Long> currentBannerShowTs;
    private boolean isBannerClosed;
    private final List<String> downloadingGameIds = new ArrayList();
    private final Map<String, StatusListener> downloadListenerMap = new LinkedHashMap();

    private final void clear() {
        hideBanner();
        this.downloadingGameIds.clear();
        this.currentBannerShowTs = null;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IMiniGameVAService iMiniGameVAService = peekAppRuntime != null ? (IMiniGameVAService) peekAppRuntime.getRuntimeService(IMiniGameVAService.class, "") : null;
        for (Map.Entry<String, StatusListener> entry : this.downloadListenerMap.entrySet()) {
            if (iMiniGameVAService != null) {
                iMiniGameVAService.unregisterStatusListener(entry.getKey(), entry.getValue());
            }
        }
        this.downloadListenerMap.clear();
    }

    private final String formatFileSize(long size) {
        String[] strArr = {"B", "K", "M", "G", "T"};
        double d16 = size;
        int i3 = 0;
        while (d16 > 1024.0d && i3 < 4) {
            d16 /= 1024;
            i3++;
        }
        String format = String.format("%.1f%s", Arrays.copyOf(new Object[]{Double.valueOf(d16), strArr[i3]}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        return format;
    }

    private final String getMiniGameAppId(String gameId) {
        MiniGameVAInterceptConfig miniGameVAInterceptConfig = (MiniGameVAInterceptConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniGameVAInterceptConfig.CONFIG_ID);
        if (miniGameVAInterceptConfig == null) {
            return "";
        }
        for (Map.Entry<String, MiniGameVAInterceptConfig.VAInterceptConfig> entry : miniGameVAInterceptConfig.getInterceptConfigMap().entrySet()) {
            if (Intrinsics.areEqual(entry.getValue().getGameAppId(), gameId)) {
                return entry.getKey();
            }
        }
        return "";
    }

    private final void showBanner(MiniGameDownloadDataWrapper data, int progress, String gameId) {
        int indexOf$default;
        String gameName = data.getData().getGameName();
        if (gameName.length() > 6) {
            gameName = gameName.subSequence(0, 6).toString();
        }
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) gameName, '-', 0, false, 6, (Object) null);
        if (indexOf$default != -1) {
            gameName = gameName.subSequence(0, indexOf$default).toString();
        }
        long size = data.getData().getSize();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(BANNER_STR_TEMPLATE, Arrays.copyOf(new Object[]{gameName, formatFileSize((progress * size) / 100), formatFileSize(size)}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        String miniGameAppId = getMiniGameAppId(gameId);
        MiniGameVAResourceBannerInfo miniGameVAResourceBannerInfo = new MiniGameVAResourceBannerInfo(gameId, miniGameAppId, format);
        QLog.d(TAG, 1, "showBanner miniGameAppId: " + miniGameAppId + ", str:" + format);
        Message message = new Message();
        message.what = 2;
        message.obj = miniGameVAResourceBannerInfo;
        BannerManager.l().O(com.tencent.mobileqq.banner.d.C, 2, message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0088 A[Catch: all -> 0x00ed, TryCatch #0 {, blocks: (B:3:0x0001, B:15:0x0029, B:17:0x002d, B:20:0x0088, B:21:0x0041, B:23:0x005f, B:25:0x006a, B:26:0x007d, B:28:0x0083, B:33:0x009f, B:35:0x00aa, B:37:0x00b2, B:39:0x00c1, B:41:0x00c4, B:43:0x00cd, B:44:0x00d5, B:46:0x00db, B:47:0x00e0, B:49:0x00e8), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void updateBanner(MiniGameDownloadDataWrapper data) {
        int downloadStatus = data.getDownloadStatus();
        String gameId = data.getData().getGameId();
        int progress = data.getProgress();
        if (progress != 100 && downloadStatus != 4 && downloadStatus != 10) {
            boolean z16 = false;
            if (1 <= progress && progress < 100) {
                Pair<String, Long> pair = this.currentBannerShowTs;
                if (pair == null) {
                    this.currentBannerShowTs = new Pair<>(gameId, Long.valueOf(System.currentTimeMillis()));
                    showBanner(data, progress, gameId);
                } else {
                    Intrinsics.checkNotNull(pair);
                    String first = pair.getFirst();
                    Pair<String, Long> pair2 = this.currentBannerShowTs;
                    Intrinsics.checkNotNull(pair2);
                    long longValue = pair2.getSecond().longValue();
                    if (!Intrinsics.areEqual(gameId, first) && System.currentTimeMillis() - longValue >= 3000) {
                        this.currentBannerShowTs = new Pair<>(gameId, Long.valueOf(System.currentTimeMillis()));
                        showBanner(data, progress, gameId);
                    } else {
                        if (Intrinsics.areEqual(gameId, first)) {
                            showBanner(data, progress, gameId);
                        }
                        if (z16) {
                            MiniAppUtils.reportMiniGameCenterDC00087("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9080", "908015", "929242", "8", gameId, null);
                        }
                    }
                }
                z16 = true;
                if (z16) {
                }
            }
        }
        StatusListener statusListener = this.downloadListenerMap.get(gameId);
        if (statusListener != null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            IMiniGameVAService iMiniGameVAService = peekAppRuntime != null ? (IMiniGameVAService) peekAppRuntime.getRuntimeService(IMiniGameVAService.class, "") : null;
            if (iMiniGameVAService != null) {
                iMiniGameVAService.unregisterStatusListener(gameId, statusListener);
            }
        }
        this.downloadingGameIds.remove(gameId);
        Pair<String, Long> pair3 = this.currentBannerShowTs;
        if (Intrinsics.areEqual(pair3 != null ? pair3.getFirst() : null, gameId)) {
            hideBanner();
            this.currentBannerShowTs = null;
        }
        if (this.downloadingGameIds.size() == 0) {
            clear();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        clear();
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVABannerService
    public void onDownloadStart(String gameId) {
        QLog.d(TAG, 1, "onDownloadStart gameId:" + gameId + ", isBannerClosed:" + this.isBannerClosed);
        if (this.isBannerClosed) {
            return;
        }
        if (gameId == null || gameId.length() == 0) {
            return;
        }
        if (this.downloadListenerMap.containsKey(gameId)) {
            QLog.d(TAG, 1, "onDownloadStart already record");
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IMiniGameVAService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        StatusListener statusListener = new StatusListener() { // from class: com.tencent.mobileqq.minigame.api.impl.MiniGameVABannerServiceImpl$onDownloadStart$downloadStatusListener$1
            @Override // com.tencent.mobileqq.minigame.va.StatusListener
            public void onStatusChanged(MiniGameDownloadDataWrapper data) {
                boolean z16;
                Intrinsics.checkNotNullParameter(data, "data");
                z16 = MiniGameVABannerServiceImpl.this.isBannerClosed;
                if (z16) {
                    MiniGameVABannerServiceImpl.this.hideBanner();
                } else {
                    MiniGameVABannerServiceImpl.this.updateBanner(data);
                }
            }
        };
        ((IMiniGameVAService) runtimeService).registerStatusListener(gameId, statusListener);
        this.downloadingGameIds.add(gameId);
        this.downloadListenerMap.put(gameId, statusListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideBanner() {
        QLog.d(TAG, 1, "hideBanner");
        BannerManager.l().O(com.tencent.mobileqq.banner.d.C, 0, null);
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVABannerService
    public void onBannerClose() {
        this.isBannerClosed = true;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String currentUin = peekAppRuntime != null ? peekAppRuntime.getCurrentUin() : null;
        if (currentUin != null) {
            MiniGameMMKVUtils.INSTANCE.saveBool(currentUin + "_mini_game_va_banner_close", true);
        }
        clear();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        String currentUin = appRuntime != null ? appRuntime.getCurrentUin() : null;
        if (currentUin != null) {
            this.isBannerClosed = MiniGameMMKVUtils.INSTANCE.getBool(currentUin + "_mini_game_va_banner_close");
        }
    }
}
