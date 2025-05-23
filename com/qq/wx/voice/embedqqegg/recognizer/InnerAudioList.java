package com.qq.wx.voice.embedqqegg.recognizer;

/* compiled from: P */
/* loaded from: classes3.dex */
public class InnerAudioList {

    /* renamed from: a, reason: collision with root package name */
    private b[] f40927a = new b[4096];

    /* renamed from: b, reason: collision with root package name */
    private volatile int f40928b = 0;

    /* renamed from: c, reason: collision with root package name */
    private volatile int f40929c = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    public InnerAudioList() {
        for (int i3 = 0; i3 < 4096; i3++) {
            this.f40927a[i3] = new b(null, InnerAudioState.stop);
        }
    }

    private static int a(int i3) {
        int i16 = i3 + 1;
        if (i16 == 4096) {
            return 0;
        }
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final b b() {
        if (this.f40928b == this.f40929c) {
            return null;
        }
        b bVar = this.f40927a[this.f40928b];
        this.f40928b = a(this.f40928b);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() {
        this.f40928b = 0;
        this.f40929c = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a(b bVar) {
        if (a(this.f40929c) == this.f40928b) {
            return false;
        }
        this.f40927a[this.f40929c] = bVar;
        this.f40929c = a(this.f40929c);
        return true;
    }
}
