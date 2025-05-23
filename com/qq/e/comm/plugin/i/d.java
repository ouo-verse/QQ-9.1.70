package com.qq.e.comm.plugin.i;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d extends Exception implements com.tencent.ams.fusion.service.resdownload.b {

    /* renamed from: a, reason: collision with root package name */
    private String f39516a;

    /* renamed from: b, reason: collision with root package name */
    private int f39517b;

    /* renamed from: c, reason: collision with root package name */
    private int f39518c;

    public d() {
    }

    @Override // com.tencent.ams.fusion.service.resdownload.b
    public int a() {
        return this.f39517b;
    }

    @Override // com.tencent.ams.fusion.service.resdownload.b
    public String b() {
        return this.f39516a;
    }

    @Override // com.tencent.ams.fusion.service.resdownload.b
    public int c() {
        return this.f39518c;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "DownloadException{errorMsg='" + this.f39516a + "', errorCode=" + this.f39517b + ", internalErrorCode=" + this.f39518c + '}';
    }

    public d(String str) {
        super(str);
        this.f39516a = str;
    }

    public void a(String str) {
        this.f39516a = str;
    }

    public d(int i3, String str) {
        this(str);
        this.f39517b = i3;
    }

    public d(String str, Throwable th5) {
        super(str, th5);
        this.f39516a = str;
    }

    public d(int i3, int i16) {
        this("net work response error");
        this.f39517b = i3;
        this.f39518c = i16;
    }

    public d(int i3, int i16, Throwable th5) {
        this(th5.getMessage(), th5);
        this.f39517b = i3;
        this.f39518c = i16;
    }
}
