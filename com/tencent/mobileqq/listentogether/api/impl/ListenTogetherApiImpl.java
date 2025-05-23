package com.tencent.mobileqq.listentogether.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.listentogether.ListenTogetherHandler;
import com.tencent.mobileqq.listentogether.api.IListenTogetherApi;
import com.tencent.mobileqq.listentogether.f;
import com.tencent.mobileqq.listentogether.ipc.ListenTogetherIPCModuleMainServer;
import com.tencent.mobileqq.listentogether.lyrics.ProfileMusicBoxController;
import com.tencent.mobileqq.listentogether.nt.ListenTogetherHelper;
import com.tencent.mobileqq.listentogether.nt.a;
import com.tencent.mobileqq.listentogether.predownload.ListenTogetherResDownloader;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import d72.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x857.TroopTips0x857$MediaChangePushInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004H\u0016J\u001c\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J,\u0010\u0015\u001a\u00020\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J>\u0010\u001a\u001a\u00020\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u001b\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\u001d\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001e\u001a\u00020\u000fH\u0016J\b\u0010 \u001a\u00020\u0011H\u0016J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020!H\u0016J\"\u0010'\u001a\u00020\u00142\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J*\u0010+\u001a\u00020\u00142\b\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020!2\u0006\u0010*\u001a\u00020\u000bH\u0016J\b\u0010-\u001a\u00020,H\u0016J\u0012\u0010/\u001a\u00020\u000b2\b\u0010.\u001a\u0004\u0018\u00010(H\u0016J\b\u00100\u001a\u00020\u0014H\u0016\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/listentogether/api/impl/ListenTogetherApiImpl;", "Lcom/tencent/mobileqq/listentogether/api/IListenTogetherApi;", "Lcom/tencent/aio/main/businesshelper/h;", "getListenTogetherHelper", "Ljava/lang/Class;", "Lcom/tencent/qqnt/graytips/handler/b;", "getListenTogetherActionHandler", "", "message", "Landroid/content/Intent;", "intent", "", "handleListenTogetherIntentFromArkMsg", "Landroid/content/Context;", "context", "", "type", "", "uin", "from", "", "gotoListenTogetherSettingPage", ShortVideoConstants.PARAM_KEY_SESSION_TYPE, "joinFrom", "reopenIfNeed", IOnlineStatusService.SONG_ID, "onJoinClick", "checkIsTogetherOpenArkMsg", "msgRecord", "handleIntentFromNTArkMsg", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PLAY_STATE, "getPlayStateStr", "getListenTogetherHandlerName", "", "isPlaying", "msgSeq", "msgTime", "Ltencent/im/oidb/cmd0x857/TroopTips0x857$MediaChangePushInfo;", "pushInfo", "decodeGroupPush", "", BaseConstants.ATTRIBUTE_KEY_PB_DATA, "isOffline", "decodePush0x210_0x11f", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "getListenTogetherIPCModuleMainServerIns", "bytesMusicSwitch", "isC2CListenTogetherOpening", "removeAllCacheFiles", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ListenTogetherApiImpl implements IListenTogetherApi {
    @Override // com.tencent.mobileqq.listentogether.api.IListenTogetherApi
    public boolean checkIsTogetherOpenArkMsg(Object message) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        return b.e(peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null, message instanceof Message ? (Message) message : null);
    }

    @Override // com.tencent.mobileqq.listentogether.api.IListenTogetherApi
    public void decodeGroupPush(long msgSeq, long msgTime, TroopTips0x857$MediaChangePushInfo pushInfo) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface == null) {
            return;
        }
        f.c(qQAppInterface, msgSeq, msgTime, pushInfo);
    }

    @Override // com.tencent.mobileqq.listentogether.api.IListenTogetherApi
    public void decodePush0x210_0x11f(byte[] pbData, long msgSeq, long msgTime, boolean isOffline) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        f.d(peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null, pbData, msgSeq, msgTime, isOffline);
    }

    @Override // com.tencent.mobileqq.listentogether.api.IListenTogetherApi
    public Class<? extends com.tencent.qqnt.graytips.handler.b> getListenTogetherActionHandler() {
        return a.class;
    }

    @Override // com.tencent.mobileqq.listentogether.api.IListenTogetherApi
    public String getListenTogetherHandlerName() {
        String name = ListenTogetherHandler.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "ListenTogetherHandler::class.java.name");
        return name;
    }

    @Override // com.tencent.mobileqq.listentogether.api.IListenTogetherApi
    public h getListenTogetherHelper() {
        return new ListenTogetherHelper();
    }

    @Override // com.tencent.mobileqq.listentogether.api.IListenTogetherApi
    public QIPCModule getListenTogetherIPCModuleMainServerIns() {
        ListenTogetherIPCModuleMainServer c16 = ListenTogetherIPCModuleMainServer.c();
        Intrinsics.checkNotNullExpressionValue(c16, "getInstance()");
        return c16;
    }

    @Override // com.tencent.mobileqq.listentogether.api.IListenTogetherApi
    public String getPlayStateStr(int playState) {
        return com.tencent.mobileqq.listentogether.player.a.a(playState);
    }

    @Override // com.tencent.mobileqq.listentogether.api.IListenTogetherApi
    public void gotoListenTogetherSettingPage(Context context, int type, String uin, int from) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        b.o(peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null, context, type, uin, from);
    }

    @Override // com.tencent.mobileqq.listentogether.api.IListenTogetherApi
    public void handleIntentFromNTArkMsg(Object msgRecord, Intent intent) {
        b.p(msgRecord instanceof RecentContactInfo ? (RecentContactInfo) msgRecord : null, intent);
    }

    @Override // com.tencent.mobileqq.listentogether.api.IListenTogetherApi
    public boolean handleListenTogetherIntentFromArkMsg(Object message, Intent intent) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        return b.q(peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null, message instanceof Message ? (Message) message : null, intent);
    }

    @Override // com.tencent.mobileqq.listentogether.api.IListenTogetherApi
    public boolean isC2CListenTogetherOpening(byte[] bytesMusicSwitch) {
        return com.tencent.mobileqq.listentogether.a.a(bytesMusicSwitch);
    }

    @Override // com.tencent.mobileqq.listentogether.api.IListenTogetherApi
    public boolean isPlaying(long uin) {
        return ProfileMusicBoxController.j0(uin);
    }

    @Override // com.tencent.mobileqq.listentogether.api.IListenTogetherApi
    public void onJoinClick(Context context, int sessionType, String uin, int joinFrom, boolean reopenIfNeed, String songId) {
        b.s(context, sessionType, uin, joinFrom, reopenIfNeed, songId);
    }

    @Override // com.tencent.mobileqq.listentogether.api.IListenTogetherApi
    public void removeAllCacheFiles() {
        ListenTogetherResDownloader.k();
    }
}
