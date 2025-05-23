package com.tencent.mobileqq.filemanager.openbrowser;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c implements com.tencent.mobileqq.filebrowser.f {

    /* renamed from: a, reason: collision with root package name */
    private int f208991a = 0;

    /* renamed from: b, reason: collision with root package name */
    private String f208992b = null;

    /* renamed from: c, reason: collision with root package name */
    private int f208993c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f208994d = 0;

    /* renamed from: e, reason: collision with root package name */
    private String f208995e = "";

    @Override // com.tencent.mobileqq.filebrowser.f
    public int a() {
        return this.f208994d;
    }

    @Override // com.tencent.mobileqq.filebrowser.f
    public String b() {
        return this.f208995e;
    }

    @Override // com.tencent.mobileqq.filebrowser.f
    public String c() {
        return this.f208992b;
    }

    public c d(int i3) {
        this.f208991a = i3;
        return this;
    }

    public c e(int i3) {
        this.f208994d = i3;
        return this;
    }

    public c f(int i3) {
        this.f208993c = i3;
        return this;
    }

    public c g(String str) {
        this.f208995e = str;
        return this;
    }

    @Override // com.tencent.mobileqq.filebrowser.f
    public int getEntranceType() {
        return this.f208991a;
    }

    @Override // com.tencent.mobileqq.filebrowser.f
    public int getSource() {
        return this.f208993c;
    }

    public c h(String str) {
        this.f208992b = str;
        return this;
    }
}
