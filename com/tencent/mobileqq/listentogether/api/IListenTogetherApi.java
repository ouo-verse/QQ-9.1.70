package com.tencent.mobileqq.listentogether.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qqnt.graytips.handler.b;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x857.TroopTips0x857$MediaChangePushInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004H&J\u001c\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH&J,\u0010\u0015\u001a\u00020\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u000fH&J>\u0010\u001a\u001a\u00020\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0011H&J\u0012\u0010\u001b\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\u001d\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001e\u001a\u00020\u000fH&J\b\u0010 \u001a\u00020\u0011H&J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020!H&J\"\u0010'\u001a\u00020\u00142\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010%H&J*\u0010+\u001a\u00020\u00142\b\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020!2\u0006\u0010*\u001a\u00020\u000bH&J\b\u0010-\u001a\u00020,H&J\u0012\u0010/\u001a\u00020\u000b2\b\u0010.\u001a\u0004\u0018\u00010(H&J\b\u00100\u001a\u00020\u0014H&\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/listentogether/api/IListenTogetherApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/aio/main/businesshelper/h;", "getListenTogetherHelper", "Ljava/lang/Class;", "Lcom/tencent/qqnt/graytips/handler/b;", "getListenTogetherActionHandler", "", "message", "Landroid/content/Intent;", "intent", "", "handleListenTogetherIntentFromArkMsg", "Landroid/content/Context;", "context", "", "type", "", "uin", "from", "", "gotoListenTogetherSettingPage", ShortVideoConstants.PARAM_KEY_SESSION_TYPE, "joinFrom", "reopenIfNeed", IOnlineStatusService.SONG_ID, "onJoinClick", "checkIsTogetherOpenArkMsg", "msgRecord", "handleIntentFromNTArkMsg", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PLAY_STATE, "getPlayStateStr", "getListenTogetherHandlerName", "", "isPlaying", "msgSeq", "msgTime", "Ltencent/im/oidb/cmd0x857/TroopTips0x857$MediaChangePushInfo;", "pushInfo", "decodeGroupPush", "", BaseConstants.ATTRIBUTE_KEY_PB_DATA, "isOffline", "decodePush0x210_0x11f", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "getListenTogetherIPCModuleMainServerIns", "bytesMusicSwitch", "isC2CListenTogetherOpening", "removeAllCacheFiles", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IListenTogetherApi extends QRouteApi {
    boolean checkIsTogetherOpenArkMsg(@Nullable Object message);

    void decodeGroupPush(long msgSeq, long msgTime, @Nullable TroopTips0x857$MediaChangePushInfo pushInfo);

    void decodePush0x210_0x11f(@Nullable byte[] pbData, long msgSeq, long msgTime, boolean isOffline);

    @NotNull
    Class<? extends b> getListenTogetherActionHandler();

    @NotNull
    String getListenTogetherHandlerName();

    @NotNull
    h getListenTogetherHelper();

    @NotNull
    QIPCModule getListenTogetherIPCModuleMainServerIns();

    @Nullable
    String getPlayStateStr(int playState);

    void gotoListenTogetherSettingPage(@Nullable Context context, int type, @Nullable String uin, int from);

    void handleIntentFromNTArkMsg(@Nullable Object msgRecord, @Nullable Intent intent);

    boolean handleListenTogetherIntentFromArkMsg(@Nullable Object message, @Nullable Intent intent);

    boolean isC2CListenTogetherOpening(@Nullable byte[] bytesMusicSwitch);

    boolean isPlaying(long uin);

    void onJoinClick(@Nullable Context context, int sessionType, @Nullable String uin, int joinFrom, boolean reopenIfNeed, @Nullable String songId);

    void removeAllCacheFiles();
}
