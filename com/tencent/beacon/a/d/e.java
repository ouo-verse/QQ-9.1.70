package com.tencent.beacon.a.d;

import com.tencent.beacon.a.b.i;
import java.nio.MappedByteBuffer;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f77687a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(g gVar) {
        this.f77687a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        JSONObject jSONObject;
        long j3;
        MappedByteBuffer mappedByteBuffer;
        MappedByteBuffer mappedByteBuffer2;
        MappedByteBuffer mappedByteBuffer3;
        MappedByteBuffer mappedByteBuffer4;
        long j16;
        try {
            obj = this.f77687a.f77690a;
            synchronized (obj) {
                jSONObject = this.f77687a.f77692c;
                byte[] a16 = g.a(jSONObject.toString().getBytes("ISO8859-1"));
                if (a16 == null) {
                    return;
                }
                long length = a16.length + 10;
                j3 = this.f77687a.f77694e;
                if (length > j3) {
                    this.f77687a.f77694e = a16.length + 10;
                    g gVar = this.f77687a;
                    j16 = gVar.f77694e;
                    gVar.a(j16);
                }
                mappedByteBuffer = this.f77687a.f77693d;
                mappedByteBuffer.putInt(0, a16.length);
                mappedByteBuffer2 = this.f77687a.f77693d;
                mappedByteBuffer2.position(10);
                mappedByteBuffer3 = this.f77687a.f77693d;
                mappedByteBuffer3.put(a16);
                mappedByteBuffer4 = this.f77687a.f77693d;
                mappedByteBuffer4.force();
            }
        } catch (Exception e16) {
            i.e().a("504", "[properties] write to file error!", e16);
        }
    }
}
