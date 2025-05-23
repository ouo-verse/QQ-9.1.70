package com.tencent.karaoke.recordsdk.media;

import com.tencent.karaoke.audiobasesdk.NoteItem;
import com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult;
import com.tencent.karaoke.audiobasesdk.scorer.MultiScoreStcInfo;
import com.tencent.karaoke.recordsdk.media.audio.AbstractKaraRecorder;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes7.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    private volatile NoteItem[] f117036b;

    /* renamed from: e, reason: collision with root package name */
    private volatile int[] f117039e;

    /* renamed from: f, reason: collision with root package name */
    private volatile byte[] f117040f;

    /* renamed from: g, reason: collision with root package name */
    private volatile int[] f117041g;

    /* renamed from: h, reason: collision with root package name */
    private volatile int[] f117042h;

    /* renamed from: j, reason: collision with root package name */
    private volatile boolean f117044j;

    /* renamed from: n, reason: collision with root package name */
    private volatile AbstractKaraRecorder.b f117048n;

    /* renamed from: o, reason: collision with root package name */
    private volatile String f117049o;

    /* renamed from: p, reason: collision with root package name */
    private volatile ArrayList<MultiScoreStcInfo> f117050p;

    /* renamed from: q, reason: collision with root package name */
    private volatile MultiScoreResult f117051q;

    /* renamed from: r, reason: collision with root package name */
    private volatile MultiScoreResult f117052r;

    /* renamed from: a, reason: collision with root package name */
    protected byte f117035a = 0;

    /* renamed from: c, reason: collision with root package name */
    private volatile int f117037c = -1;

    /* renamed from: d, reason: collision with root package name */
    private volatile int f117038d = -1;

    /* renamed from: i, reason: collision with root package name */
    private volatile int f117043i = -1;

    /* renamed from: k, reason: collision with root package name */
    private volatile int f117045k = -1;

    /* renamed from: l, reason: collision with root package name */
    private volatile int f117046l = -1;

    /* renamed from: m, reason: collision with root package name */
    protected volatile int f117047m = 0;

    /* renamed from: s, reason: collision with root package name */
    private int f117053s = -1;

    /* renamed from: t, reason: collision with root package name */
    private int f117054t = -1;

    /* renamed from: u, reason: collision with root package name */
    private boolean f117055u = false;

    /* renamed from: v, reason: collision with root package name */
    private RecordServiceFromType f117056v = RecordServiceFromType.NormalRecord;

    public int a() {
        return this.f117045k;
    }

    public boolean b() {
        return this.f117055u;
    }

    public void c(int[] iArr) {
        this.f117041g = iArr;
    }

    public void d(String str) {
        this.f117049o = str;
    }

    public void e(AbstractKaraRecorder.b bVar) {
        this.f117048n = bVar;
    }

    public void f(int[] iArr) {
        this.f117039e = iArr;
    }

    public void g(MultiScoreResult multiScoreResult, MultiScoreResult multiScoreResult2) {
        this.f117051q = multiScoreResult;
        this.f117052r = multiScoreResult2;
    }

    public void h(ArrayList<MultiScoreStcInfo> arrayList) {
        this.f117050p = arrayList;
    }

    public void i(byte[] bArr) {
        this.f117040f = bArr;
    }

    public void j(NoteItem[] noteItemArr) {
        this.f117036b = noteItemArr;
    }

    public void k(int i3) {
        this.f117047m = i3;
    }

    public void l(int i3) {
        this.f117038d = i3;
    }

    public void m(int i3) {
        this.f117037c = i3;
    }

    public void n(int[] iArr) {
        this.f117042h = iArr;
    }

    public void o(boolean z16) {
        this.f117044j = z16;
    }
}
