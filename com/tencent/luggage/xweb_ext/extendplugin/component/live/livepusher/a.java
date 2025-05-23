package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.rtmp.TXLivePusher;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface a extends TXLivePusher.VideoCustomProcessListener {

    /* renamed from: a, reason: collision with root package name */
    public static final a f146954a = new C7003a();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C7003a implements a {
        public int a(int i3, int i16, int i17) {
            return 0;
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a
        public boolean isEnabled() {
            return false;
        }

        public void a() {
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a
        public void a(b bVar, float f16) {
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a
        public void a(d dVar, String str) {
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a
        public void a(e eVar, String str) {
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a
        public void a(String str, float f16) {
        }

        public void a(float[] fArr) {
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a
        public void c() {
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a
        public void d() {
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a
        public void e() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public enum b {
        SKIN_BRIGHT,
        SKIN_SMOOTH,
        FACE_THIN,
        EYE_BIGGER
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface c {

        /* renamed from: a, reason: collision with root package name */
        public static final c f146960a = new C7004a();

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a$c$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C7004a implements c {
            @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.c
            public a create() {
                return a.f146954a;
            }
        }

        a create();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public enum d {
        MAKEUP_LIP_STICK,
        MAKEUP_EYE_SHADOW,
        MAKEUP_BLUSHER_STICK,
        MAKEUP_FACE_CONTOUR,
        MAKEUP_EYE_BROW
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public enum e {
        STICKER_BACK,
        STICKER_FRONT,
        STICKER_2D
    }

    void a(b bVar, float f16);

    void a(d dVar, String str);

    void a(e eVar, String str);

    void a(String str, float f16);

    void c();

    void d();

    void e();

    boolean isEnabled();
}
