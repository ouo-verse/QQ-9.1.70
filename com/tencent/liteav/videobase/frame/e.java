package com.tencent.liteav.videobase.frame;

import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.frame.a;
import com.tencent.liteav.videobase.utils.ConsumerChainTimestamp;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.utils.ProducerChainTimestamp;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class e extends com.tencent.liteav.videobase.frame.a<d> {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f119342a = new AtomicInteger();

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class a extends d {

        /* renamed from: a, reason: collision with root package name */
        int f119343a;

        /* renamed from: b, reason: collision with root package name */
        final int f119344b;

        /* renamed from: c, reason: collision with root package name */
        final int f119345c;

        /* renamed from: d, reason: collision with root package name */
        private FrameMetaData f119346d;

        /* renamed from: e, reason: collision with root package name */
        private ProducerChainTimestamp f119347e;

        /* renamed from: f, reason: collision with root package name */
        private ConsumerChainTimestamp f119348f;

        /* synthetic */ a(g gVar, int i3, int i16, byte b16) {
            this(gVar, i3, i16);
        }

        @Override // com.tencent.liteav.videobase.frame.d
        public final int a() {
            return this.f119343a;
        }

        @Override // com.tencent.liteav.videobase.frame.d
        public final int b() {
            return this.f119344b;
        }

        @Override // com.tencent.liteav.videobase.frame.d
        public final int c() {
            return this.f119345c;
        }

        @Override // com.tencent.liteav.videobase.frame.d
        public final FrameMetaData d() {
            return this.f119346d;
        }

        @Override // com.tencent.liteav.videobase.frame.d
        public final void e() {
            this.f119346d = null;
            this.f119347e = null;
            this.f119348f = null;
        }

        @Override // com.tencent.liteav.videobase.frame.i
        public final void release() {
            super.release();
        }

        a(g<d> gVar, int i3, int i16) {
            super(gVar);
            this.f119343a = -1;
            this.f119344b = i3;
            this.f119345c = i16;
        }

        @Override // com.tencent.liteav.videobase.frame.d
        public final PixelFrame a(Object obj) {
            b bVar = new b(this, obj, (byte) 0);
            bVar.retain();
            return bVar;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class b extends PixelFrame {

        /* renamed from: b, reason: collision with root package name */
        private static final g<b> f119349b = f.a();

        /* renamed from: a, reason: collision with root package name */
        private final d f119350a;

        /* synthetic */ b(d dVar, Object obj, byte b16) {
            this(dVar, obj);
        }

        @Override // com.tencent.liteav.videobase.frame.PixelFrame
        public final void setTextureId(int i3) {
            throw new UnsupportedOperationException("Object is allocated by pool, can't change its Buffer");
        }

        b(d dVar, Object obj) {
            super(f119349b);
            dVar.retain();
            this.mWidth = dVar.b();
            this.mHeight = dVar.c();
            this.f119350a = dVar;
            this.mTextureId = dVar.a();
            this.mGLContext = obj;
            this.mPixelBufferType = GLConstants.a.TEXTURE_2D;
            this.mPixelFormatType = GLConstants.PixelFormatType.RGBA;
            this.mMetaData = dVar.d();
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static class c implements a.InterfaceC5951a {

        /* renamed from: a, reason: collision with root package name */
        final int f119351a;

        /* renamed from: b, reason: collision with root package name */
        final int f119352b;

        public c(int i3, int i16) {
            this.f119351a = i3;
            this.f119352b = i16;
        }

        public final boolean equals(Object obj) {
            if (obj.getClass() != c.class) {
                return false;
            }
            c cVar = (c) obj;
            if (this.f119351a != cVar.f119351a || this.f119352b != cVar.f119352b) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return (this.f119351a * 37213) + this.f119352b;
        }
    }

    @Override // com.tencent.liteav.videobase.frame.a
    protected final /* synthetic */ void a(d dVar) {
        a aVar = (a) dVar;
        OpenGlUtils.deleteTexture(aVar.f119343a);
        aVar.f119343a = -1;
        f119342a.getAndDecrement();
    }

    @Override // com.tencent.liteav.videobase.frame.a
    protected final /* synthetic */ a.InterfaceC5951a b(d dVar) {
        d dVar2 = dVar;
        return new c(dVar2.b(), dVar2.c());
    }

    @Override // com.tencent.liteav.videobase.frame.a
    public final void b() {
        super.b();
    }

    public final d a(int i3, int i16) {
        d dVar = (d) super.a(new c(i3, i16));
        dVar.e();
        return dVar;
    }

    @Override // com.tencent.liteav.videobase.frame.a
    public final void a() {
        super.a();
    }

    @Override // com.tencent.liteav.videobase.frame.a
    protected final /* synthetic */ d a(g<d> gVar, a.InterfaceC5951a interfaceC5951a) {
        c cVar = (c) interfaceC5951a;
        a aVar = new a(gVar, cVar.f119351a, cVar.f119352b, (byte) 0);
        aVar.f119343a = OpenGlUtils.createTexture(aVar.f119344b, aVar.f119345c, 6408, 6408);
        f119342a.incrementAndGet();
        return aVar;
    }
}
