package com.tencent.luggage.wxa.l1;

import com.tencent.luggage.wxa.ei.s;
import com.tencent.luggage.wxa.l1.d;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.k0;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c implements d.InterfaceC6416d {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.xd.d f132919a;

    /* renamed from: b, reason: collision with root package name */
    public final s f132920b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f132921c;

    /* renamed from: d, reason: collision with root package name */
    public int f132922d = Integer.MIN_VALUE;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends k0 {
        private static final int CTRL_INDEX = 637;
        public static final String NAME = "onCameraFrame";

        public a() {
        }
    }

    public c(com.tencent.luggage.wxa.xd.d dVar) {
        this.f132919a = dVar;
        this.f132920b = (s) dVar.getJsRuntime().a(s.class);
    }

    public int a(d dVar, int i3, int i16) {
        if (dVar == null) {
            w.f("MicroMsg.FrameDataCallbackHelper", "listenFrameChange recordView null");
            return -1;
        }
        if (this.f132920b == null) {
            return -2;
        }
        int i17 = this.f132922d;
        if (i17 != Integer.MIN_VALUE) {
            w.d("MicroMsg.FrameDataCallbackHelper", "listenFrameChange destroy last one bufferId:%d", Integer.valueOf(i17));
            this.f132920b.e(this.f132922d);
        }
        int b16 = this.f132920b.b(i3 * i16 * 4);
        this.f132922d = b16;
        w.d("MicroMsg.FrameDataCallbackHelper", "listenFrameChange bufferId:%d height:%d width:%d", Integer.valueOf(b16), Integer.valueOf(i16), Integer.valueOf(i3));
        this.f132921c = true;
        dVar.a(this.f132920b.g(this.f132922d), this);
        return this.f132922d;
    }

    public void b(d dVar) {
        w.d("MicroMsg.FrameDataCallbackHelper", "onUIResume mNeedCallback:%b", Boolean.valueOf(this.f132921c));
        if (!this.f132921c) {
            return;
        }
        if (dVar == null) {
            w.f("MicroMsg.FrameDataCallbackHelper", "onUIResume recordView null");
            return;
        }
        int i3 = this.f132922d;
        if (i3 == Integer.MIN_VALUE) {
            w.f("MicroMsg.FrameDataCallbackHelper", "onUIResume invalid mCurrentSharedBufferId");
            return;
        }
        s sVar = this.f132920b;
        if (sVar == null) {
            w.f("MicroMsg.FrameDataCallbackHelper", "onUIResume mSharedBufferAddon null");
        } else {
            dVar.a(sVar.g(i3), this);
        }
    }

    public void c(d dVar) {
        this.f132921c = false;
        if (dVar != null) {
            dVar.a((ByteBuffer) null, (d.InterfaceC6416d) null);
        }
        int i3 = this.f132922d;
        if (i3 != Integer.MIN_VALUE) {
            this.f132920b.e(i3);
            this.f132922d = Integer.MIN_VALUE;
        }
    }

    public void a(d dVar) {
        w.d("MicroMsg.FrameDataCallbackHelper", "onUIPause mNeedCallback:%b", Boolean.valueOf(this.f132921c));
        if (dVar == null) {
            w.f("MicroMsg.FrameDataCallbackHelper", "onUIPause recordView null");
        } else {
            dVar.a((ByteBuffer) null, (d.InterfaceC6416d) null);
        }
    }

    @Override // com.tencent.luggage.wxa.l1.d.InterfaceC6416d
    public void a() {
        if (!this.f132921c) {
            w.d("MicroMsg.FrameDataCallbackHelper", "onDateUpdate not need callback");
        } else {
            this.f132919a.a(new a());
        }
    }
}
