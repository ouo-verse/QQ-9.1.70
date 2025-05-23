package com.tencent.mobileqq.qqlive.api.impl.room.common;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.av.LiveMediaConfig;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import lt3.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pt3.c;
import pt3.h;
import pt3.i;

/* loaded from: classes17.dex */
public class AVChatStreamPublisher extends AudioStreamPublisher {
    static IPatchRedirector $redirector_ = null;
    private static final int AV_TYPE_VIDEO = 0;
    private static final int CONTENT_TYPE_AV_CHAT = 10002;
    private static final int ENABLE_LINK_MIC = 1;
    private static final int LIVE_TYPE_LINK_MIC = 6;
    private static final int ROOM_GAME_TYPE = 0;
    private LiveMediaConfig mediaConfig;

    public AVChatStreamPublisher(LiveMediaConfig liveMediaConfig, IQQLiveSDK iQQLiveSDK, BaseRoomInfo baseRoomInfo, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, liveMediaConfig, iQQLiveSDK, baseRoomInfo, str);
            return;
        }
        this.mediaConfig = liveMediaConfig;
        setLiveSdk(iQQLiveSDK);
        setRoomInfo(baseRoomInfo);
        setUserSig(str);
    }

    private h getResolution(LiveMediaConfig liveMediaConfig) {
        h hVar = new h();
        int resolution = liveMediaConfig.getResolution();
        if (resolution != 0) {
            if (resolution != 1) {
                if (resolution != 2) {
                    if (resolution != 3) {
                        if (resolution != 4) {
                            hVar.f427147b = 270;
                            hVar.f427146a = 480;
                        } else {
                            hVar.f427147b = 1920;
                            hVar.f427146a = 1080;
                        }
                    } else {
                        hVar.f427147b = 1280;
                        hVar.f427146a = 720;
                    }
                } else {
                    hVar.f427147b = 960;
                    hVar.f427146a = 540;
                }
            } else {
                hVar.f427147b = 640;
                hVar.f427146a = 360;
            }
        } else {
            hVar.f427147b = 480;
            hVar.f427146a = 270;
        }
        return hVar;
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.common.AudioStreamPublisher
    @NotNull
    public pt3.a covertToEndNewReq(@NotNull BaseRoomInfo baseRoomInfo, @Nullable String str, @Nullable String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (pt3.a) iPatchRedirector.redirect((short) 4, this, baseRoomInfo, str, str2, Integer.valueOf(i3));
        }
        pt3.a aVar = new pt3.a();
        aVar.f427106a = baseRoomInfo.getRoomId();
        aVar.f427107b = i3;
        aVar.f427108c = 6;
        aVar.f427109d = com.tencent.mobileqq.qqlive.anchor.util.a.J(str);
        aVar.f427110e = 3;
        c cVar = new c();
        cVar.f427121b = DeviceInfoMonitor.getModel();
        cVar.f427122c = AppSetting.f99551k;
        cVar.f427123d = getResolution(this.mediaConfig);
        aVar.f427111f = cVar;
        aVar.f427113h = 1;
        aVar.f427114i = 0;
        aVar.f427115j = 0;
        aVar.f427116k = "";
        return aVar;
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.common.AudioStreamPublisher
    @NotNull
    public i covertToStartNewReq(long j3, @NotNull BaseRoomInfo baseRoomInfo, @Nullable String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (i) iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), baseRoomInfo, str, Integer.valueOf(i3));
        }
        i iVar = new i();
        iVar.f427148a = baseRoomInfo.getRoomId();
        iVar.f427149b = i3;
        iVar.f427150c = 6;
        iVar.f427151d = com.tencent.mobileqq.qqlive.anchor.util.a.J(str);
        iVar.f427152e = 3;
        c cVar = new c();
        cVar.f427121b = DeviceInfoMonitor.getModel();
        cVar.f427122c = AppSetting.f99551k;
        cVar.f427123d = getResolution(this.mediaConfig);
        cVar.f427124e = 10002;
        iVar.f427153f = cVar;
        iVar.f427155h = 1;
        iVar.f427156i = 0;
        iVar.f427157j = 0;
        iVar.f427158k = "";
        iVar.f427154g = j3;
        return iVar;
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.common.AudioStreamPublisher
    @NotNull
    public b createHeartbeatReq(@NotNull BaseRoomInfo baseRoomInfo, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (b) iPatchRedirector.redirect((short) 5, (Object) this, (Object) baseRoomInfo, i3);
        }
        b bVar = new b();
        bVar.f415540a = i3;
        bVar.f415543d = (int) baseRoomInfo.getRoomId();
        bVar.f415544e = 3;
        bVar.f415541b = 6;
        return bVar;
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.common.AudioStreamPublisher
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            super.destroy();
            this.mediaConfig = null;
        }
    }
}
