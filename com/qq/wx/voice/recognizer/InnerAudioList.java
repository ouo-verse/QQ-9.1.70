package com.qq.wx.voice.recognizer;

/* compiled from: P */
/* loaded from: classes3.dex */
public class InnerAudioList {

    /* renamed from: a, reason: collision with root package name */
    private a[] f40995a = new a[4096];

    /* renamed from: b, reason: collision with root package name */
    private volatile int f40996b = 0;

    /* renamed from: c, reason: collision with root package name */
    private volatile int f40997c = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    public InnerAudioList() {
        for (int i3 = 0; i3 < 4096; i3++) {
            this.f40995a[i3] = new a(null, InnerAudioState.stop);
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
    public final a b() {
        if (this.f40996b == this.f40997c) {
            return null;
        }
        a aVar = this.f40995a[this.f40996b];
        this.f40996b = a(this.f40996b);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() {
        this.f40996b = 0;
        this.f40997c = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a(a aVar) {
        if (a(this.f40997c) == this.f40996b) {
            return false;
        }
        this.f40995a[this.f40997c] = aVar;
        this.f40997c = a(this.f40997c);
        return true;
    }
}
