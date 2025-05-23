package pu;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f427246a = new byte[512];

    /* renamed from: b, reason: collision with root package name */
    private int f427247b;

    /* renamed from: c, reason: collision with root package name */
    private int f427248c;

    public a() {
        this.f427247b = 0;
        this.f427248c = 0;
        for (int i3 = 0; i3 < 512; i3++) {
            this.f427246a[i3] = 0;
        }
        this.f427247b = 0;
        this.f427248c = 0;
    }

    public byte[] a() {
        int i3 = this.f427248c;
        byte[] bArr = new byte[i3];
        System.arraycopy(this.f427246a, 0, bArr, 0, i3);
        return bArr;
    }

    public void b(int i3) {
        System.arraycopy(new byte[]{(byte) ((i3 >> 24) & 255), (byte) ((i3 >> 16) & 255), (byte) ((i3 >> 8) & 255), (byte) (i3 & 255)}, 0, this.f427246a, this.f427247b, 4);
        this.f427247b += 4;
        this.f427248c += 4;
    }

    public void c(byte b16) {
        byte[] bArr = this.f427246a;
        int i3 = this.f427247b;
        bArr[i3] = b16;
        this.f427247b = i3 + 1;
        this.f427248c++;
    }
}
