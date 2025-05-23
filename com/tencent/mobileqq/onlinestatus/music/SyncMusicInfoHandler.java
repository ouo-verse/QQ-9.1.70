package com.tencent.mobileqq.onlinestatus.music;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.onlinestatus.an;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.model.CustomShareInfo;
import com.tencent.mobileqq.onlinestatus.networkhandler.CustomHandler;
import com.tencent.mobileqq.onlinestatus.view.SyncStatusExtInfoPopWindow;
import com.tencent.mobileqq.onlinestatus.y;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.onlinestatus.GetSongInfo$ReqBody;
import tencent.im.onlinestatus.GetSongInfo$RspBody;
import tencent.im.onlinestatus.SyncSingSong$ReqBody;
import tencent.im.onlinestatus.SyncSingSong$RspBody;

/* compiled from: P */
/* loaded from: classes16.dex */
public class SyncMusicInfoHandler extends BusinessHandler {

    /* renamed from: d, reason: collision with root package name */
    private AppInterface f256056d;

    /* renamed from: e, reason: collision with root package name */
    private y.e f256057e;

    /* renamed from: f, reason: collision with root package name */
    private SyncStatusExtInfoPopWindow.e f256058f;

    protected SyncMusicInfoHandler(AppInterface appInterface) {
        super(appInterface);
        this.f256056d = appInterface;
    }

    private void D2(FromServiceMsg fromServiceMsg, Object obj) {
        if (this.f256057e == null) {
            QLog.e("SyncMusicInfoHandler", 1, "handleGetSongInfo mOpenSyncSingSongPopWindowListener == null");
            return;
        }
        if (fromServiceMsg != null && obj != null) {
            try {
                GetSongInfo$RspBody getSongInfo$RspBody = new GetSongInfo$RspBody();
                getSongInfo$RspBody.mergeFrom((byte[]) obj);
                int i3 = getSongInfo$RspBody.err_code.get();
                String stringUtf8 = getSongInfo$RspBody.err_msg.get().toStringUtf8();
                if (i3 != 0) {
                    QLog.e("SyncMusicInfoHandler", 1, "handleGetSongInfo: errCode: " + i3 + " errMsg: " + stringUtf8);
                    this.f256057e.a(null, null);
                    return;
                }
                String stringUtf82 = getSongInfo$RspBody.song_name.get().toStringUtf8();
                String stringUtf83 = getSongInfo$RspBody.singer_name.get().toStringUtf8();
                this.f256057e.a(stringUtf82, stringUtf83);
                if (QLog.isColorLevel()) {
                    QLog.d("SyncMusicInfoHandler", 2, "errCode: " + i3 + " errMsg: " + stringUtf8 + " songName: " + stringUtf82 + " singerName: " + stringUtf83);
                    return;
                }
                return;
            } catch (Exception e16) {
                QLog.e("SyncMusicInfoHandler", 1, "receive: " + e16);
                this.f256057e.a(null, null);
                return;
            }
        }
        QLog.d("SyncMusicInfoHandler", 1, "handleGetSongInfo res: " + fromServiceMsg + " data: " + obj);
        this.f256057e.a(null, null);
    }

    private void E2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        if (this.f256058f == null) {
            QLog.e("SyncMusicInfoHandler", 1, "handleSetSingSong mMusicInfoCallback == null");
            return;
        }
        if (fromServiceMsg != null && obj != null && toServiceMsg != null) {
            try {
                SyncSingSong$RspBody syncSingSong$RspBody = new SyncSingSong$RspBody();
                syncSingSong$RspBody.mergeFrom((byte[]) obj);
                int i3 = syncSingSong$RspBody.err_code.get();
                QLog.d("SyncMusicInfoHandler", 1, "handleGetSongInfo: errCode: " + i3 + " errMsg: " + syncSingSong$RspBody.err_msg.get().toStringUtf8());
                SyncStatusExtInfoPopWindow.e eVar = this.f256058f;
                if (i3 == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                eVar.a(z16);
                Object attribute = toServiceMsg.getAttribute(IOnlineStatusService.KEY_CUSTOM_SHARE_INFO);
                if (attribute instanceof CustomShareInfo) {
                    ((CustomHandler) this.f256056d.getBusinessHandler(CustomHandler.class.getName())).L2((CustomShareInfo) attribute);
                    return;
                }
                return;
            } catch (Exception e16) {
                QLog.e("SyncMusicInfoHandler", 1, "receive: " + e16);
                this.f256058f.a(false);
                return;
            }
        }
        QLog.d("SyncMusicInfoHandler", 1, "handleSetSingSong res: " + fromServiceMsg + " data: " + obj);
        this.f256058f.a(false);
    }

    public void F2(an anVar, CustomShareInfo customShareInfo) {
        if (anVar == null) {
            QLog.e("SyncMusicInfoHandler", 1, "status: null");
            return;
        }
        SyncSingSong$ReqBody syncSingSong$ReqBody = new SyncSingSong$ReqBody();
        syncSingSong$ReqBody.bytes_song_id.set(ByteStringMicro.copyFromUtf8(anVar.f255411b));
        syncSingSong$ReqBody.uint32_song_type.set(anVar.f255413d);
        syncSingSong$ReqBody.bool_pause_flag.set(anVar.f255417h);
        syncSingSong$ReqBody.uint32_remaining_time.set(anVar.f255415f);
        syncSingSong$ReqBody.uint32_song_play_time.set(anVar.f255418i);
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f256056d.getCurrentAccountUin(), "trpc.QQService.CommonLogic.StatusService.SsoSyncSongInfo");
        toServiceMsg.putWupBuffer(syncSingSong$ReqBody.toByteArray());
        toServiceMsg.addAttribute(IOnlineStatusService.KEY_CUSTOM_SHARE_INFO, customShareInfo);
        sendPbReq(toServiceMsg);
    }

    public void G2(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("SyncMusicInfoHandler", 1, "songId: null");
            return;
        }
        GetSongInfo$ReqBody getSongInfo$ReqBody = new GetSongInfo$ReqBody();
        getSongInfo$ReqBody.bytes_song_id.set(ByteStringMicro.copyFromUtf8(str));
        getSongInfo$ReqBody.uint32_song_type.set(i3);
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f256056d.getCurrentAccountUin(), "trpc.QQService.CommonLogic.StatusService.SsoGetSongInfo");
        toServiceMsg.putWupBuffer(getSongInfo$ReqBody.toByteArray());
        sendPbReq(toServiceMsg);
    }

    public void H2(y.e eVar) {
        this.f256057e = eVar;
    }

    public void I2(SyncStatusExtInfoPopWindow.e eVar) {
        this.f256058f = eVar;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("trpc.QQService.CommonLogic.StatusService.SsoGetSongInfo");
            this.allowCmdSet.add("trpc.QQService.CommonLogic.StatusService.SsoSyncSongInfo");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (toServiceMsg != null && fromServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (msgCmdFilter(serviceCmd) && QLog.isColorLevel()) {
                QLog.d("SyncMusicInfoHandler", 2, "onReceive, msgCmdFilter is true,cmd  = " + serviceCmd);
            }
            if ("trpc.QQService.CommonLogic.StatusService.SsoGetSongInfo".equals(serviceCmd)) {
                D2(fromServiceMsg, obj);
                return;
            } else {
                if ("trpc.QQService.CommonLogic.StatusService.SsoSyncSongInfo".equals(serviceCmd)) {
                    E2(toServiceMsg, fromServiceMsg, obj);
                    return;
                }
                return;
            }
        }
        QLog.e("SyncMusicInfoHandler", 1, "req: " + toServiceMsg + " res: " + fromServiceMsg);
    }
}
