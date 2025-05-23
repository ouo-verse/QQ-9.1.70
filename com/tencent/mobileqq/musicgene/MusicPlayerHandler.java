package com.tencent.mobileqq.musicgene;

import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.qqmusic.MusicSongInfoMatch$CMsgRequest;
import tencent.im.oidb.qqmusic.MusicSongInfoMatch$CMsgResponse;
import tencent.im.oidb.qqmusic.MusicSongInfoMatch$ParamPair;

/* loaded from: classes15.dex */
public class MusicPlayerHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    public MusicPlayerHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        }
    }

    private long D2() {
        String str = AppSetting.f99551k;
        if (!TextUtils.isEmpty(str)) {
            try {
                return Long.parseLong(str.replace(".", ""));
            } catch (NumberFormatException unused) {
            }
        }
        return 0L;
    }

    private void E2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        try {
            if (fromServiceMsg.getResultCode() == 1000) {
                byte[] wupBuffer = fromServiceMsg.getWupBuffer();
                MusicSongInfoMatch$CMsgResponse musicSongInfoMatch$CMsgResponse = new MusicSongInfoMatch$CMsgResponse();
                musicSongInfoMatch$CMsgResponse.mergeFrom(wupBuffer);
                String str = new String(musicSongInfoMatch$CMsgResponse.data.get().toByteArray());
                int i3 = musicSongInfoMatch$CMsgResponse.reqtype.get();
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            notifyUI(83, true, str);
                        }
                    } else {
                        notifyUI(82, true, str);
                    }
                } else {
                    notifyUI(81, true, str);
                }
            } else {
                notifyUI(81, false, null);
            }
        } catch (Exception unused) {
        }
    }

    public void F2(String str, long j3, long j16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16));
            return;
        }
        QLog.d("MusicPlayerHandler", 4, "requestLikeSong ", String.valueOf(str), " ", String.valueOf(j3), " ", String.valueOf(j16), " ", String.valueOf(z16));
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(j3), "MusicSongInfoMatchSvc.songquery");
        MusicSongInfoMatch$CMsgRequest musicSongInfoMatch$CMsgRequest = new MusicSongInfoMatch$CMsgRequest();
        MusicSongInfoMatch$ParamPair musicSongInfoMatch$ParamPair = new MusicSongInfoMatch$ParamPair();
        musicSongInfoMatch$ParamPair.key.set(ByteStringMicro.copyFromUtf8("songid"));
        musicSongInfoMatch$ParamPair.value.set(ByteStringMicro.copyFromUtf8(String.valueOf(j16)));
        MusicSongInfoMatch$ParamPair musicSongInfoMatch$ParamPair2 = new MusicSongInfoMatch$ParamPair();
        musicSongInfoMatch$ParamPair2.key.set(ByteStringMicro.copyFromUtf8("OpenUDID"));
        musicSongInfoMatch$ParamPair2.value.set(ByteStringMicro.copyFromUtf8(String.valueOf(str)));
        musicSongInfoMatch$CMsgRequest.urlparams.add(musicSongInfoMatch$ParamPair);
        musicSongInfoMatch$CMsgRequest.urlparams.add(musicSongInfoMatch$ParamPair2);
        if (z16) {
            musicSongInfoMatch$CMsgRequest.reqtype.set(2);
        } else {
            musicSongInfoMatch$CMsgRequest.reqtype.set(3);
        }
        musicSongInfoMatch$CMsgRequest.uin.set(j3);
        musicSongInfoMatch$CMsgRequest.f436021ct.set(1008L);
        musicSongInfoMatch$CMsgRequest.f436022cv.set(D2());
        toServiceMsg.putWupBuffer(musicSongInfoMatch$CMsgRequest.toByteArray());
        sendPbReq(toServiceMsg);
    }

    public void G2(long j3, String str, String str2, String str3, String str4, String str5, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Long.valueOf(j3), str, str2, str3, str4, str5, Integer.valueOf(i3));
            return;
        }
        QLog.d("MusicPlayerHandler", 4, "requestMatchSongInfo ", String.valueOf(str), " ", String.valueOf(str2), " ", String.valueOf(str3), " ", String.valueOf(str4), " ", String.valueOf(str5), " ", String.valueOf(i3));
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(j3), "MusicSongInfoMatchSvc.songquery");
        MusicSongInfoMatch$CMsgRequest musicSongInfoMatch$CMsgRequest = new MusicSongInfoMatch$CMsgRequest();
        if (!TextUtils.isEmpty(str)) {
            MusicSongInfoMatch$ParamPair musicSongInfoMatch$ParamPair = new MusicSongInfoMatch$ParamPair();
            musicSongInfoMatch$ParamPair.key.set(ByteStringMicro.copyFromUtf8("songname"));
            musicSongInfoMatch$ParamPair.value.set(ByteStringMicro.copyFromUtf8(str));
            musicSongInfoMatch$CMsgRequest.urlparams.add(musicSongInfoMatch$ParamPair);
        }
        if (!TextUtils.isEmpty(str2)) {
            MusicSongInfoMatch$ParamPair musicSongInfoMatch$ParamPair2 = new MusicSongInfoMatch$ParamPair();
            musicSongInfoMatch$ParamPair2.key.set(ByteStringMicro.copyFromUtf8("singername"));
            musicSongInfoMatch$ParamPair2.value.set(ByteStringMicro.copyFromUtf8(str2));
            musicSongInfoMatch$CMsgRequest.urlparams.add(musicSongInfoMatch$ParamPair2);
        }
        if (!TextUtils.isEmpty(str3)) {
            MusicSongInfoMatch$ParamPair musicSongInfoMatch$ParamPair3 = new MusicSongInfoMatch$ParamPair();
            musicSongInfoMatch$ParamPair3.key.set(ByteStringMicro.copyFromUtf8("albumname"));
            musicSongInfoMatch$ParamPair3.value.set(ByteStringMicro.copyFromUtf8(str3));
            musicSongInfoMatch$CMsgRequest.urlparams.add(musicSongInfoMatch$ParamPair3);
        }
        if (!TextUtils.isEmpty(str4)) {
            MusicSongInfoMatch$ParamPair musicSongInfoMatch$ParamPair4 = new MusicSongInfoMatch$ParamPair();
            musicSongInfoMatch$ParamPair4.key.set(ByteStringMicro.copyFromUtf8("songid"));
            musicSongInfoMatch$ParamPair4.value.set(ByteStringMicro.copyFromUtf8(str4));
            musicSongInfoMatch$CMsgRequest.urlparams.add(musicSongInfoMatch$ParamPair4);
        }
        if (!TextUtils.isEmpty(str5)) {
            MusicSongInfoMatch$ParamPair musicSongInfoMatch$ParamPair5 = new MusicSongInfoMatch$ParamPair();
            musicSongInfoMatch$ParamPair5.key.set(ByteStringMicro.copyFromUtf8("summary"));
            musicSongInfoMatch$ParamPair5.value.set(ByteStringMicro.copyFromUtf8(str5));
            musicSongInfoMatch$CMsgRequest.urlparams.add(musicSongInfoMatch$ParamPair5);
        }
        if (i3 > 0) {
            String valueOf = String.valueOf(i3 / 1000);
            MusicSongInfoMatch$ParamPair musicSongInfoMatch$ParamPair6 = new MusicSongInfoMatch$ParamPair();
            musicSongInfoMatch$ParamPair6.key.set(ByteStringMicro.copyFromUtf8("duration"));
            musicSongInfoMatch$ParamPair6.value.set(ByteStringMicro.copyFromUtf8(valueOf));
            musicSongInfoMatch$CMsgRequest.urlparams.add(musicSongInfoMatch$ParamPair6);
        }
        musicSongInfoMatch$CMsgRequest.reqtype.set(1);
        musicSongInfoMatch$CMsgRequest.uin.set(j3);
        musicSongInfoMatch$CMsgRequest.f436021ct.set(1008L);
        musicSongInfoMatch$CMsgRequest.f436022cv.set(D2());
        toServiceMsg.putWupBuffer(musicSongInfoMatch$CMsgRequest.toByteArray());
        sendPbReq(toServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return MusicPlayerActivity.f.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
        } else if ("MusicSongInfoMatchSvc.songquery".equals(fromServiceMsg.getServiceCmd())) {
            E2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
