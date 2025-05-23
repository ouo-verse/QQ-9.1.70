package com.tencent.luggage.wxa.ri;

import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.tn.w;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g extends f {

    /* renamed from: j, reason: collision with root package name */
    public int f139770j;

    /* renamed from: k, reason: collision with root package name */
    public int f139771k;

    @Override // com.tencent.luggage.wxa.ri.f, com.tencent.luggage.wxa.ri.d
    public boolean a(String str, int i3, int i16, int i17) {
        this.f139770j = i3;
        this.f139771k = i16;
        return super.a(str, i3, i16, i17);
    }

    public final void b() {
        RandomAccessFile c16 = x.c(this.f139769i.g(), true);
        c16.seek(0L);
        c16.write(a(this.f139770j, this.f139771k, this.f139769i.s()));
        c16.close();
    }

    @Override // com.tencent.luggage.wxa.ri.f, com.tencent.luggage.wxa.ri.d
    public void close() {
        super.close();
        try {
            b();
        } catch (IOException e16) {
            w.f("Luggage.PCMAudioEncoder", "", e16);
        }
    }

    public byte[] a(int i3, int i16, long j3) {
        return a(j3, j3 + 36, i3, i16, ((i3 * 16) * i16) / 8, RegisterType.UNINIT_REF);
    }

    public final byte[] a(long j3, long j16, long j17, int i3, long j18, byte b16) {
        return new byte[]{82, 73, 70, 70, (byte) (j16 & 255), (byte) ((j16 >> 8) & 255), (byte) ((j16 >> 16) & 255), (byte) ((j16 >> 24) & 255), 87, 65, 86, 69, 102, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, 32, RegisterType.UNINIT_REF, 0, 0, 0, 1, 0, (byte) i3, 0, (byte) (j17 & 255), (byte) ((j17 >> 8) & 255), (byte) ((j17 >> 16) & 255), (byte) ((j17 >> 24) & 255), (byte) (j18 & 255), (byte) ((j18 >> 8) & 255), (byte) ((j18 >> 16) & 255), (byte) ((j18 >> 24) & 255), (byte) (i3 * (b16 / 8)), 0, b16, 0, 100, 97, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, 97, (byte) (j3 & 255), (byte) ((j3 >> 8) & 255), (byte) ((j3 >> 16) & 255), (byte) ((j3 >> 24) & 255)};
    }
}
