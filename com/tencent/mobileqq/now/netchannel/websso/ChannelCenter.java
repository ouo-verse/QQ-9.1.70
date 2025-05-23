package com.tencent.mobileqq.now.netchannel.websso;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.mobileqq.now.wnsilivehead.WnsHeadProto$ForwardReq;
import com.tencent.mobileqq.now.wnsilivehead.WnsHeadProto$ForwardRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ChannelCenter {

    /* renamed from: d, reason: collision with root package name */
    private static ChannelCenter f254348d;

    /* renamed from: a, reason: collision with root package name */
    private WebServiceSSO f254349a;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f254350b = false;

    /* renamed from: c, reason: collision with root package name */
    private Handler f254351c = new Handler(Looper.getMainLooper());

    ChannelCenter() {
    }

    private WnsHeadProto$ForwardReq c(byte[] bArr) {
        WnsHeadProto$ForwardReq wnsHeadProto$ForwardReq = new WnsHeadProto$ForwardReq();
        wnsHeadProto$ForwardReq.platform.set(16130);
        wnsHeadProto$ForwardReq.busi_buf.set(ByteStringMicro.copyFrom(bArr));
        wnsHeadProto$ForwardReq.version.set(a.b());
        wnsHeadProto$ForwardReq.version_code.set(a.a());
        wnsHeadProto$ForwardReq.f254410a2.set(e.c().a());
        wnsHeadProto$ForwardReq.uid.set(e.c().e());
        wnsHeadProto$ForwardReq.tinyid.set(e.c().d());
        wnsHeadProto$ForwardReq.stream_type.set(1);
        wnsHeadProto$ForwardReq.original_id.set(String.valueOf(e.f()));
        wnsHeadProto$ForwardReq.original_id_type.set(1);
        if (this.f254349a.f()) {
            wnsHeadProto$ForwardReq.target_env.set(1);
        }
        return wnsHeadProto$ForwardReq;
    }

    public static ChannelCenter e() {
        if (f254348d == null) {
            ChannelCenter channelCenter = new ChannelCenter();
            f254348d = channelCenter;
            channelCenter.f(false);
        }
        return f254348d;
    }

    public static void g() {
        ChannelCenter channelCenter = f254348d;
        if (channelCenter != null) {
            channelCenter.j();
            f254348d = null;
        }
    }

    public void d() {
        this.f254349a.i();
    }

    protected void f(boolean z16) {
        int i3;
        int i16;
        if (z16) {
            i3 = 1400015341;
        } else {
            i3 = 1400005918;
        }
        int i17 = i3;
        if (z16) {
            i16 = 7747;
        } else {
            i16 = 3256;
        }
        String valueOf = String.valueOf(i17);
        e.c();
        this.f254349a = new WebServiceSSO(i17, i16, valueOf, e.f(), "", 0);
        i(z16);
    }

    public void h(final int i3, int i16, byte[] bArr, final b bVar) {
        String format = String.format("0x%x_0x%x", Integer.valueOf(i3), Integer.valueOf(i16));
        WnsHeadProto$ForwardReq c16 = c(bArr);
        Log.i("ChannelCenter", "WebServiceSSO--start send cmd=" + i3);
        try {
            this.f254349a.g(format, c16.toByteArray(), new d() { // from class: com.tencent.mobileqq.now.netchannel.websso.ChannelCenter.1
                @Override // com.tencent.mobileqq.now.netchannel.websso.d
                public void a(byte[] bArr2) {
                    Log.i("ChannelCenter", "WebServiceSSO--onSuccess cmd=" + i3);
                    if (ChannelCenter.this.f254350b) {
                        Log.d("ChannelCenter", "now live quit.");
                        return;
                    }
                    WnsHeadProto$ForwardRsp wnsHeadProto$ForwardRsp = new WnsHeadProto$ForwardRsp();
                    try {
                        wnsHeadProto$ForwardRsp.mergeFrom(bArr2);
                        final byte[] byteArray = wnsHeadProto$ForwardRsp.busi_buf.get().toByteArray();
                        if (wnsHeadProto$ForwardRsp.stream_type.has() && wnsHeadProto$ForwardRsp.stream_type.get() == 1) {
                            try {
                                byteArray = zb2.a.d(byteArray);
                            } catch (Exception e16) {
                                e16.printStackTrace();
                                byteArray = null;
                            }
                        }
                        if (byteArray != null) {
                            ChannelCenter.this.f254351c.post(new Runnable() { // from class: com.tencent.mobileqq.now.netchannel.websso.ChannelCenter.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    Log.i("ChannelCenter", "WebServiceSSO--onSuccess final cmd=" + i3);
                                    bVar.onRecv(byteArray);
                                }
                            });
                        }
                    } catch (InvalidProtocolBufferMicroException unused) {
                        bVar.onError(1000001, "\u89e3\u6790\u51fa\u9519");
                    }
                }

                @Override // com.tencent.mobileqq.now.netchannel.websso.d
                public void onFail(int i17, String str) {
                    Log.d("ChannelCenter", "WebServiceSSO--onFail errCode=" + i3 + ", errMsg=" + str);
                    if (ChannelCenter.this.f254350b) {
                        Log.d("ChannelCenter", "now live quit.");
                    } else {
                        bVar.onError(i17, str);
                    }
                }
            });
        } catch (Exception e16) {
            final String message = e16.getMessage();
            Log.i("ChannelCenter", message);
            this.f254351c.post(new Runnable() { // from class: com.tencent.mobileqq.now.netchannel.websso.ChannelCenter.2
                @Override // java.lang.Runnable
                public void run() {
                    Log.d("ChannelCenter", "WebServiceSSO--onException final cmd=" + i3);
                    if (ChannelCenter.this.f254350b) {
                        Log.d("ChannelCenter", "now live quit.");
                    } else {
                        bVar.onError(1000002, message);
                    }
                }
            });
        }
    }

    public void i(boolean z16) {
        this.f254349a.h(z16);
    }

    protected void j() {
        d();
        this.f254350b = true;
    }
}
