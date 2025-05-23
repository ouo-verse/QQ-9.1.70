package com.tencent.av.opengl.effects;

import android.graphics.PointF;
import com.tencent.ttpic.openapi.PTFaceAttr;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class p {

    /* renamed from: g, reason: collision with root package name */
    public short f74010g;

    /* renamed from: h, reason: collision with root package name */
    public short f74011h;

    /* renamed from: i, reason: collision with root package name */
    public int f74012i;

    /* renamed from: j, reason: collision with root package name */
    public int f74013j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f74014k = false;

    /* renamed from: a, reason: collision with root package name */
    public List<PointF> f74004a = null;

    /* renamed from: b, reason: collision with root package name */
    public float[] f74005b = null;

    /* renamed from: c, reason: collision with root package name */
    public int f74006c = 0;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f74007d = null;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f74008e = null;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f74009f = null;

    private byte[] b(int i3, int i16) {
        List<PointF> list = this.f74004a;
        if (list != null && list.size() > 0 && i3 != 0 && i16 != 0) {
            float f16 = 240.0f / i3;
            float f17 = 320.0f / i16;
            ByteBuffer allocate = ByteBuffer.allocate(this.f74004a.size() * 4);
            for (int i17 = 0; i17 < this.f74004a.size(); i17++) {
                PointF pointF = this.f74004a.get(i17);
                short s16 = (short) (pointF.x * f16);
                allocate.putShort(s16);
                allocate.putShort((short) (pointF.y * f17));
            }
            return allocate.array();
        }
        return null;
    }

    private byte[] c(int i3, int i16) {
        List<PointF> list = this.f74004a;
        if (list != null && list.size() > 0 && i3 != 0 && i16 != 0) {
            float f16 = 2.4E8f / i3;
            float f17 = 3.2E8f / i16;
            ByteBuffer allocate = ByteBuffer.allocate(this.f74004a.size() * 8);
            for (int i17 = 0; i17 < this.f74004a.size(); i17++) {
                PointF pointF = this.f74004a.get(i17);
                int i18 = (int) (pointF.x * f16);
                int i19 = (int) (pointF.y * f17);
                allocate.putInt(i18);
                allocate.putInt(i19);
            }
            return allocate.array();
        }
        return null;
    }

    public void a(int i3, int i16) {
        this.f74012i = i3;
        this.f74013j = i16;
        this.f74004a = null;
        this.f74005b = null;
        this.f74006c = 0;
        this.f74007d = null;
        this.f74008e = null;
        this.f74009f = null;
        this.f74014k = false;
    }

    public void d(PTFaceAttr pTFaceAttr, boolean z16) {
        if (pTFaceAttr != null) {
            this.f74006c = pTFaceAttr.getFaceCount();
        } else {
            this.f74006c = 0;
        }
        if (this.f74006c > 0 && pTFaceAttr != null) {
            if (!z16) {
                this.f74004a = pTFaceAttr.getAllFacePoints().get(0);
                this.f74005b = pTFaceAttr.getAllFaceAngles().get(0);
                this.f74007d = b(this.f74013j, this.f74012i);
                this.f74008e = c(this.f74013j, this.f74012i);
                return;
            }
            ByteBuffer allocate = ByteBuffer.allocate("".getBytes().length + 4);
            short s16 = (short) this.f74013j;
            this.f74010g = s16;
            short s17 = (short) this.f74012i;
            this.f74011h = s17;
            allocate.put(new byte[]{(byte) (s17 >> 8), (byte) s17, (byte) (s16 >> 8), (byte) s16});
            allocate.put("".getBytes());
            this.f74009f = allocate.array();
        }
    }
}
