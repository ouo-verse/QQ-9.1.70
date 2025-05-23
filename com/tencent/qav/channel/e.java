package com.tencent.qav.channel;

import android.content.Context;
import android.os.Bundle;
import com.tencent.avcore.netchannel.AbstractNetChannel;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e extends AbstractNetChannel implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected Context f342364a;

    /* renamed from: b, reason: collision with root package name */
    protected d f342365b;

    public e(Context context, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) dVar);
            return;
        }
        this.f342364a = context;
        this.f342365b = dVar;
        dVar.a(this);
    }

    private byte[] b(Bundle bundle) {
        return bundle.getByteArray("buffer");
    }

    @Override // com.tencent.avcore.netchannel.IDavNetChannel
    public void SendSharpVideoMsgBySSOChannel(int i3, long j3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Long.valueOf(j3), bArr);
        }
    }

    @Override // com.tencent.avcore.netchannel.INetChannelCallback
    public void receiveDeviceMsg(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) bundle);
        }
    }

    @Override // com.tencent.avcore.netchannel.INetChannelCallback
    public void receiveMultiVideoAck(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) bundle);
        } else {
            receiveMultiVideoMsg(2, b(bundle), false);
        }
    }

    @Override // com.tencent.avcore.netchannel.INetChannelCallback
    public void receiveMultiVideoMsg(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) bundle);
        } else {
            receiveMultiVideoMsg(1, b(bundle), false);
        }
    }

    @Override // com.tencent.avcore.netchannel.INetChannelCallback
    public void receiveMultiVideoOfflineMsg(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) bundle);
        } else {
            receiveMultiVideoMsg(3, b(bundle), false);
        }
    }

    @Override // com.tencent.avcore.netchannel.INetChannelCallback
    public void receiveOpenImAck(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) bArr);
        } else {
            receiveMultiVideoMsg(103, bArr, false);
        }
    }

    @Override // com.tencent.avcore.netchannel.INetChannelCallback
    public void receiveSSOMultiVideoAck(int i3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3, (Object) bArr);
        } else {
            receiveMultiVideoMsg(i3, bArr, false);
        }
    }

    @Override // com.tencent.avcore.netchannel.INetChannelCallback
    public void receiveSSOMultiVideoMsg(int i3, byte[] bArr, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), bArr, Boolean.valueOf(z16));
        } else {
            receiveMultiVideoMsg(i3, bArr, z16);
        }
    }

    @Override // com.tencent.avcore.netchannel.INetChannelCallback
    public void receiveSharpVideoAck(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bundle);
        }
    }

    @Override // com.tencent.avcore.netchannel.INetChannelCallback
    public void receiveSharpVideoMsg(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) bundle);
        }
    }

    @Override // com.tencent.avcore.netchannel.INetChannelCallback
    public void receiveSharpVideoOfflineMsg(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bundle);
        }
    }

    @Override // com.tencent.avcore.netchannel.INetChannelCallback
    public void receiveVideoConfig(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) bundle);
        } else {
            pu.c.p(String.valueOf(AppSetting.f()), this.f342364a, b(bundle));
        }
    }

    @Override // com.tencent.avcore.netchannel.IDavNetChannel, com.tencent.avcore.netchannel.IMavNetChannel, com.tencent.avcore.netchannel.INetChannel
    public void sendGetGatewayMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        d dVar = this.f342365b;
        if (dVar != null) {
            dVar.sendGetGatewayMsg();
        }
    }

    @Override // com.tencent.avcore.netchannel.IDavNetChannel, com.tencent.avcore.netchannel.INetChannel
    public void sendGetVideoConfig(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr);
        }
    }

    @Override // com.tencent.avcore.netchannel.IMavNetChannel, com.tencent.avcore.netchannel.INetChannel
    public void sendMultiVideoMsg(long j3, long j16, byte[] bArr, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), Long.valueOf(j16), bArr, Boolean.valueOf(z16));
            return;
        }
        d dVar = this.f342365b;
        if (dVar != null) {
            dVar.sendMultiVideoMsg(j3, j16, bArr, z16);
        }
    }

    @Override // com.tencent.avcore.netchannel.IDavNetChannel, com.tencent.avcore.netchannel.INetChannel
    public void sendSharpVideoMsg(long j3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), bArr);
        }
    }

    @Override // com.tencent.avcore.netchannel.IDavNetChannel
    public void sendSharpVideoMsgByJCEChannel(long j3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), bArr);
        }
    }
}
