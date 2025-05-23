package com.tencent.mobileqq.gamecenter.api.impl;

import android.net.Uri;
import com.tencent.mobileqq.gamecenter.api.IGameCenterVideoReportApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.video.interceptor.GameCenterPerfReportInterceptor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ0\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0018\u001a\u00020\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0019\u001a\u00020\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0016J&\u0010\u001c\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/api/impl/GameCenterVideoReportApiImpl;", "Lcom/tencent/mobileqq/gamecenter/api/IGameCenterVideoReportApi;", "Lcom/tencent/mobileqq/gamecenter/data/p;", "baseReportData", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getExtMap", "", "reportPlayStart", "", "module", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "reportPlayError", "reportVideoPrepared", "reportVideoBufferingStart", "reportVideoBufferingEnd", "reportVideoComplete", "reportVideoRelease", "url", "", "getHippyReportInterceptor", "", "checkIfReport", "checkIfDetectDropFrame", "operId", "extMap", "doReport", "<init>", "()V", "Companion", "a", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GameCenterVideoReportApiImpl implements IGameCenterVideoReportApi {

    @NotNull
    private static final String TAG = "GameCenterVideoReportApiImpl";

    private final HashMap<String, String> getExtMap(com.tencent.mobileqq.gamecenter.data.p baseReportData) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("ext25", baseReportData.url);
        hashMap.put("ext26", String.valueOf(baseReportData.source));
        return hashMap;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterVideoReportApi
    public boolean checkIfDetectDropFrame(@Nullable String url) {
        if (!checkIfReport(url) || ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).getConfigJsonObj(IGameCenterUnitedConfigApi.GAME_CENTER_VIDEO_REPORT_CONFIG).optInt("isDetectDropFrame", 1) != 1) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0048  */
    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterVideoReportApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean checkIfReport(@Nullable String url) {
        boolean z16;
        boolean z17;
        JSONArray optJSONArray;
        int length;
        int i3;
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        try {
            String host = Uri.parse(url).getHost();
            if (host != null) {
                if (host.length() != 0) {
                    z17 = false;
                    if (!z17 || (optJSONArray = ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).getConfigJsonObj(IGameCenterUnitedConfigApi.GAME_CENTER_VIDEO_REPORT_CONFIG).optJSONArray("reportDomains")) == null) {
                        return false;
                    }
                    length = optJSONArray.length();
                    for (i3 = 0; i3 < length; i3++) {
                        if (Intrinsics.areEqual(host, optJSONArray.optString(i3))) {
                            return true;
                        }
                    }
                    return false;
                }
            }
            z17 = true;
            if (!z17) {
                return false;
            }
            length = optJSONArray.length();
            while (i3 < length) {
            }
            return false;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
            return false;
        }
    }

    public final void doReport(@Nullable String operId, @NotNull HashMap<String, String> extMap) {
        Intrinsics.checkNotNullParameter(extMap, "extMap");
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("", "1", "160", "769", "76901", operId, "", extMap);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterVideoReportApi
    @NotNull
    public Object getHippyReportInterceptor(@Nullable String url) {
        return new GameCenterPerfReportInterceptor(com.tencent.mobileqq.gamecenter.data.p.INSTANCE.a(), url);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterVideoReportApi
    public void reportPlayError(@NotNull com.tencent.mobileqq.gamecenter.data.p baseReportData, int module, int errorType, int errorCode) {
        Intrinsics.checkNotNullParameter(baseReportData, "baseReportData");
        if (!checkIfReport(baseReportData.url)) {
            return;
        }
        HashMap<String, String> extMap = getExtMap(baseReportData);
        extMap.put("ext27", String.valueOf(module));
        extMap.put("ext28", String.valueOf(errorType));
        extMap.put("ext29", String.valueOf(errorCode));
        Unit unit = Unit.INSTANCE;
        doReport("929254", extMap);
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "[reportPlayError] url:" + baseReportData.url + ",module:" + module + ",errorType:" + errorType + ",errorCode:" + errorCode);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterVideoReportApi
    public void reportPlayStart(@NotNull com.tencent.mobileqq.gamecenter.data.p baseReportData) {
        Intrinsics.checkNotNullParameter(baseReportData, "baseReportData");
        if (!checkIfReport(baseReportData.url)) {
            return;
        }
        doReport("929253", getExtMap(baseReportData));
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterVideoReportApi
    public void reportVideoBufferingEnd(@NotNull com.tencent.mobileqq.gamecenter.data.p baseReportData) {
        Intrinsics.checkNotNullParameter(baseReportData, "baseReportData");
        if (!checkIfReport(baseReportData.url)) {
            return;
        }
        if (baseReportData.lastBufferingStartTime == 0) {
            QLog.e(TAG, 1, "[reportVideoBufferingEnd] lastBufferingStartTime is 0");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - baseReportData.lastBufferingStartTime;
        if (currentTimeMillis < 0) {
            QLog.e(TAG, 2, "[reportVideoBufferingEnd] cost is invalid");
            return;
        }
        HashMap<String, String> extMap = getExtMap(baseReportData);
        extMap.put("ext27", String.valueOf(currentTimeMillis));
        Unit unit = Unit.INSTANCE;
        doReport("929258", extMap);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterVideoReportApi
    public void reportVideoBufferingStart(@NotNull com.tencent.mobileqq.gamecenter.data.p baseReportData) {
        Intrinsics.checkNotNullParameter(baseReportData, "baseReportData");
        if (!checkIfReport(baseReportData.url)) {
            return;
        }
        doReport("929257", getExtMap(baseReportData));
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterVideoReportApi
    public void reportVideoComplete(@NotNull com.tencent.mobileqq.gamecenter.data.p baseReportData) {
        Intrinsics.checkNotNullParameter(baseReportData, "baseReportData");
        if (!checkIfReport(baseReportData.url)) {
            return;
        }
        doReport("929259", getExtMap(baseReportData));
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterVideoReportApi
    public void reportVideoPrepared(@NotNull com.tencent.mobileqq.gamecenter.data.p baseReportData) {
        Intrinsics.checkNotNullParameter(baseReportData, "baseReportData");
        if (!checkIfReport(baseReportData.url)) {
            return;
        }
        if (baseReportData.lastStartPrepareTime == 0) {
            QLog.e(TAG, 2, "[reportVideoPrepared] reportVideoPrepared is 0");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - baseReportData.lastStartPrepareTime;
        if (currentTimeMillis < 0) {
            QLog.e(TAG, 2, "[reportVideoPrepared] cost is invalid");
            return;
        }
        HashMap<String, String> extMap = getExtMap(baseReportData);
        extMap.put("ext27", String.valueOf(currentTimeMillis));
        Unit unit = Unit.INSTANCE;
        doReport("929256", extMap);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterVideoReportApi
    public void reportVideoRelease(@NotNull com.tencent.mobileqq.gamecenter.data.p baseReportData) {
        boolean z16;
        Intrinsics.checkNotNullParameter(baseReportData, "baseReportData");
        if (!checkIfReport(baseReportData.url)) {
            return;
        }
        HashMap<String, String> extMap = getExtMap(baseReportData);
        extMap.put("ext27", baseReportData.dropFrameRecordStr);
        extMap.put("ext28", String.valueOf(baseReportData.videoFps));
        float f16 = baseReportData.avgDropFrame;
        if (f16 == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            extMap.put("ext29", String.valueOf(f16));
        }
        Unit unit = Unit.INSTANCE;
        doReport("929279", extMap);
    }
}
