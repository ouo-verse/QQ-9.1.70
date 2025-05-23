package a11;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.tencent.libra.base.animation.decode.FrameSeqDecoder;
import com.tencent.libra.util.apng.decode.APNGParser;
import com.tencent.libra.util.apng.decode.e;
import com.tencent.libra.util.apng.decode.f;
import com.tencent.libra.util.apng.decode.g;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a extends FrameSeqDecoder<h11.a, b11.a> {
    private b A;

    /* renamed from: w, reason: collision with root package name */
    private b11.a f25331w;

    /* renamed from: x, reason: collision with root package name */
    private int f25332x;

    /* renamed from: y, reason: collision with root package name */
    private final Paint f25333y;

    /* renamed from: z, reason: collision with root package name */
    private int f25334z;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        byte f25335a;

        /* renamed from: b, reason: collision with root package name */
        Rect f25336b;

        /* renamed from: c, reason: collision with root package name */
        ByteBuffer f25337c;

        b() {
            this.f25336b = new Rect();
        }
    }

    public a(u01.c cVar, FrameSeqDecoder.a aVar) {
        super(cVar, aVar);
        Paint paint = new Paint();
        this.f25333y = paint;
        this.A = new b();
        paint.setAntiAlias(true);
    }

    private void S(com.tencent.libra.util.apng.decode.c cVar) {
        short s16 = cVar.f118827j;
        short s17 = cVar.f118828k;
        if (s17 == 0) {
            s17 = 100;
        }
        this.f25334z += Math.round((s16 * 1000.0f) / s17);
    }

    @Override // com.tencent.libra.base.animation.decode.FrameSeqDecoder
    protected void I() {
        this.A.f25337c = null;
        this.f25331w = null;
        this.f25334z = 0;
    }

    @Override // com.tencent.libra.base.animation.decode.FrameSeqDecoder
    protected void K(com.tencent.libra.base.animation.decode.a aVar) {
        if (aVar != null && this.f118608p != null) {
            try {
                Bitmap F = F(this.f118608p.width() / this.f118603k, this.f118608p.height() / this.f118603k);
                Canvas canvas = this.f118606n.get(F);
                if (canvas == null) {
                    canvas = new Canvas(F);
                    this.f118606n.put(F, canvas);
                }
                Canvas canvas2 = canvas;
                if (aVar instanceof a11.b) {
                    this.f118607o.rewind();
                    F.copyPixelsFromBuffer(this.f118607o);
                    if (this.f118597e == 0) {
                        canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                    } else {
                        canvas2.save();
                        canvas2.clipRect(this.A.f25336b);
                        b bVar = this.A;
                        byte b16 = bVar.f25335a;
                        if (b16 != 1) {
                            if (b16 == 2) {
                                bVar.f25337c.rewind();
                                F.copyPixelsFromBuffer(this.A.f25337c);
                            }
                        } else {
                            canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                        }
                        canvas2.restore();
                    }
                    if (((a11.b) aVar).f25343h == 2) {
                        b bVar2 = this.A;
                        if (bVar2.f25335a != 2) {
                            bVar2.f25337c.rewind();
                            F.copyPixelsToBuffer(this.A.f25337c);
                        }
                    }
                    this.A.f25335a = ((a11.b) aVar).f25343h;
                    canvas2.save();
                    if (((a11.b) aVar).f25342g == 0) {
                        int i3 = aVar.f118620d;
                        int i16 = this.f118603k;
                        int i17 = aVar.f118621e;
                        canvas2.clipRect(i3 / i16, i17 / i16, (i3 + aVar.f118618b) / i16, (i17 + aVar.f118619c) / i16);
                        canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                    }
                    Rect rect = this.A.f25336b;
                    int i18 = aVar.f118620d;
                    int i19 = this.f118603k;
                    int i26 = aVar.f118621e;
                    rect.set(i18 / i19, i26 / i19, (i18 + aVar.f118618b) / i19, (i26 + aVar.f118619c) / i19);
                    canvas2.restore();
                }
                Bitmap F2 = F(aVar.f118618b, aVar.f118619c);
                H(aVar.a(canvas2, this.f25333y, this.f118603k, F2, A()));
                H(F2);
                this.f118607o.rewind();
                F.copyPixelsToBuffer(this.f118607o);
                H(F);
            } catch (Error | Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.libra.base.animation.decode.FrameSeqDecoder
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public h11.a y(t01.d dVar) {
        return new h11.a(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.libra.base.animation.decode.FrameSeqDecoder
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public b11.a A() {
        if (this.f25331w == null) {
            this.f25331w = new b11.a();
        }
        return this.f25331w;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.libra.base.animation.decode.FrameSeqDecoder
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public Rect G(h11.a aVar) throws IOException {
        List<com.tencent.libra.util.apng.decode.b> c16 = APNGParser.c(aVar);
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[0];
        Iterator<com.tencent.libra.util.apng.decode.b> it = c16.iterator();
        a11.b bVar = null;
        boolean z16 = false;
        int i3 = 0;
        int i16 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.tencent.libra.util.apng.decode.b next = it.next();
            if (next instanceof com.tencent.libra.util.apng.decode.a) {
                this.f25332x = ((com.tencent.libra.util.apng.decode.a) next).f118816f;
                z16 = true;
            } else if (next instanceof com.tencent.libra.util.apng.decode.c) {
                com.tencent.libra.util.apng.decode.c cVar = (com.tencent.libra.util.apng.decode.c) next;
                bVar = new a11.b(aVar, cVar);
                bVar.f25346k = arrayList;
                bVar.f25344i = bArr;
                this.f118596d.add(bVar);
                S(cVar);
            } else if (next instanceof com.tencent.libra.util.apng.decode.d) {
                if (bVar != null) {
                    bVar.f25345j.add(next);
                }
            } else if (next instanceof e) {
                if (!z16) {
                    d dVar = new d(aVar);
                    dVar.f118618b = i3;
                    dVar.f118619c = i16;
                    this.f118596d.add(dVar);
                    this.f25332x = 1;
                    break;
                }
                if (bVar != null) {
                    bVar.f25345j.add(next);
                }
            } else if (next instanceof g) {
                g gVar = (g) next;
                i3 = gVar.f118836e;
                i16 = gVar.f118837f;
                bArr = gVar.f118838g;
            } else if (!(next instanceof f)) {
                arrayList.add(next);
            }
        }
        int i17 = i3 * i16;
        int i18 = this.f118603k;
        this.f118607o = ByteBuffer.allocate(((i17 / (i18 * i18)) + 1) * 4);
        b bVar2 = this.A;
        int i19 = this.f118603k;
        bVar2.f25337c = ByteBuffer.allocate(((i17 / (i19 * i19)) + 1) * 4);
        return new Rect(0, 0, i3, i16);
    }

    @Override // com.tencent.libra.base.animation.decode.FrameSeqDecoder
    public int t() {
        return this.f25334z;
    }

    @Override // com.tencent.libra.base.animation.decode.FrameSeqDecoder
    protected int w() {
        return this.f25332x;
    }
}
