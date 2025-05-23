package com.tencent.mobileqq.stt.shard;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.stt.shard.b;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x3d.SttResultPush$MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x3d.SttResultPush$TransPttResp;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private b.a f290743b;

    public c(a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f290743b = null;
        }
    }

    public int c(SttResultPush$MsgBody sttResultPush$MsgBody) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) sttResultPush$MsgBody)).intValue();
        }
        if (sttResultPush$MsgBody == null) {
            return 4001;
        }
        SttResultPush$TransPttResp sttResultPush$TransPttResp = sttResultPush$MsgBody.msg_ptt_resp;
        if (!sttResultPush$TransPttResp.has()) {
            this.f290738a.f(4, 2007);
            return 4001;
        }
        Long valueOf = Long.valueOf(sttResultPush$TransPttResp.uint64_sessionid.get());
        int i3 = sttResultPush$TransPttResp.uint32_pos.get();
        int i16 = sttResultPush$TransPttResp.uint32_len.get();
        int i17 = sttResultPush$TransPttResp.uint32_total_len.get();
        int i18 = 1 << sttResultPush$TransPttResp.uint32_seq.get();
        int i19 = sttResultPush$TransPttResp.uint32_error_code.get();
        if (QLog.isColorLevel()) {
            QLog.d("Q.stt_IntactSttRcv", 2, "onSttResultPush with: " + i19 + ", " + valueOf + ", " + i3 + ", " + i16 + ", " + i17);
        }
        if (i19 == 0 && i3 + i16 <= i17) {
            b.a a16 = a(this.f290743b, i3, i16, i17, i18, sttResultPush$TransPttResp.bytes_text.get().toByteArray());
            this.f290743b = a16;
            boolean z16 = a16.f290742d;
            if (z16) {
                str = new String(a16.f290741c.array());
                this.f290743b = null;
            } else {
                str = "";
            }
            this.f290738a.e(false);
            this.f290738a.h(str, z16);
            if (QLog.isColorLevel()) {
                QLog.d("Q.stt_IntactSttRcv", 2, "doReceivePushData stt pushPacket.isEnd = " + z16 + "  | session = " + valueOf);
            }
            return 0;
        }
        if (this.f290743b != null) {
            this.f290743b = null;
        }
        QLog.i("Q.stt_IntactSttRcv", 1, "onSttResultPush with: " + i19 + ", " + valueOf + ", " + i3 + ", " + i16 + ", " + i17);
        this.f290738a.f(4, 2008);
        return 4002;
    }
}
