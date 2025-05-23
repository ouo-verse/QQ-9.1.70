package o92;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xada.oidb_0xada$ReqBody;
import tencent.im.oidb.cmd0xada.oidb_0xada$RspBody;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public int f422249a;

    /* renamed from: b, reason: collision with root package name */
    public int f422250b;

    /* renamed from: d, reason: collision with root package name */
    public InterfaceC10894b f422252d;

    /* renamed from: e, reason: collision with root package name */
    public c f422253e;

    /* renamed from: g, reason: collision with root package name */
    public AppInterface f422255g;

    /* renamed from: c, reason: collision with root package name */
    public long f422251c = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f422254f = 0;

    /* compiled from: P */
    /* renamed from: o92.b$b, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public interface InterfaceC10894b {
        void a(int i3, byte[] bArr, Bundle bundle);
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public interface c {
        void a(int i3, byte[] bArr);
    }

    public b(AppInterface appInterface) {
        this.f422255g = appInterface;
    }

    public b b(int i3) {
        this.f422249a = i3;
        return this;
    }

    public b d(c cVar) {
        this.f422253e = cVar;
        return this;
    }

    public b e(InterfaceC10894b interfaceC10894b) {
        this.f422252d = interfaceC10894b;
        return this;
    }

    public b f(final byte[] bArr) {
        final oidb_0xada$ReqBody oidb_0xada_reqbody = new oidb_0xada$ReqBody();
        q92.b.b(this.f422255g, oidb_0xada_reqbody, new com.tencent.mobileqq.nearby.now.b() { // from class: o92.a
            @Override // com.tencent.mobileqq.nearby.now.b
            public final void onResult(boolean z16) {
                b.this.c(oidb_0xada_reqbody, bArr, z16);
            }
        });
        return this;
    }

    public b g(int i3) {
        this.f422250b = i3;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class a extends ProtoUtils.c {
        a() {
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            if (i3 == 0 && bArr != null) {
                oidb_0xada$RspBody oidb_0xada_rspbody = new oidb_0xada$RspBody();
                try {
                    oidb_0xada_rspbody.mergeFrom(bArr);
                    QLog.i("QQ_NOW_TASK", 2, "err_msg:   " + oidb_0xada_rspbody.err_msg.get());
                    if (oidb_0xada_rspbody.busi_buf.has()) {
                        InterfaceC10894b interfaceC10894b = b.this.f422252d;
                        if (interfaceC10894b != null && i3 == 0) {
                            interfaceC10894b.a(i3, oidb_0xada_rspbody.busi_buf.get().toByteArray(), bundle);
                        } else {
                            QLog.i("QQ_NOW_TASK", 1, "err_msg1:   " + oidb_0xada_rspbody.err_msg.get());
                            c cVar = b.this.f422253e;
                            if (cVar != null) {
                                cVar.a(i3, bArr);
                            }
                        }
                    } else {
                        QLog.i("QQ_NOW_TASK", 1, "err_msg2:   ");
                        c cVar2 = b.this.f422253e;
                        if (cVar2 != null) {
                            cVar2.a(i3, null);
                        }
                    }
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                    QLog.i("QQ_NOW_TASK", 1, "err_msg3:   ");
                    c cVar3 = b.this.f422253e;
                    if (cVar3 != null) {
                        cVar3.a(i3, null);
                        return;
                    }
                    return;
                }
            }
            QLog.i("QQ_NOW_TASK", 1, "err_msg4:   ");
            c cVar4 = b.this.f422253e;
            if (cVar4 != null) {
                cVar4.a(i3, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(oidb_0xada$ReqBody oidb_0xada_reqbody, byte[] bArr, boolean z16) {
        if (z16) {
            oidb_0xada_reqbody.cmd.set(this.f422249a);
            oidb_0xada_reqbody.subcmd.set(this.f422250b);
            oidb_0xada_reqbody.busi_buf.set(ByteStringMicro.copyFrom(bArr));
            ProtoUtils.i(this.f422255g, new a(), oidb_0xada_reqbody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, null, 0L);
        }
    }
}
