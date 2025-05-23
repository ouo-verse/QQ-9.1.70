package c.t.m.g;

import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;

/* compiled from: P */
/* loaded from: classes.dex */
public class s {

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f29972d = {31, 113, 239, 397, com.tencent.luggage.wxa.yd.a.CTRL_INDEX, PlayerResources.ViewId.PLAYER_DURATION, 619, 773, 853, 977};

    /* renamed from: a, reason: collision with root package name */
    public byte[] f29973a = new byte[0];

    /* renamed from: b, reason: collision with root package name */
    public a[] f29974b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f29975c;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f29976a;

        /* renamed from: b, reason: collision with root package name */
        public int f29977b;

        public a(int i3, int i16) {
            this.f29976a = i3;
            this.f29977b = i16;
        }

        public int a(String str) {
            int length = str.length();
            int i3 = 0;
            for (int i16 = 0; i16 < length; i16++) {
                i3 = str.charAt(i16) + (this.f29977b * i3);
            }
            return (this.f29976a - 1) & i3;
        }
    }

    public s(int i3, int i16) {
        int i17 = 0;
        this.f29974b = new a[Math.min(Math.max(1, i16), f29972d.length)];
        while (true) {
            a[] aVarArr = this.f29974b;
            if (i17 < aVarArr.length) {
                aVarArr[i17] = new a(i3 * 8, f29972d[i17]);
                i17++;
            } else {
                this.f29975c = new byte[i3];
                return;
            }
        }
    }

    public void a(byte[] bArr) {
        synchronized (this.f29973a) {
            if (bArr != null) {
                System.arraycopy(bArr, 0, this.f29975c, 0, Math.min(bArr.length, this.f29975c.length));
            }
        }
    }

    public boolean b(String str) {
        synchronized (this.f29973a) {
            if (str == null) {
                return false;
            }
            for (a aVar : this.f29974b) {
                if (!m0.a(this.f29975c, aVar.a(str))) {
                    return false;
                }
            }
            return true;
        }
    }

    public byte[] a() {
        byte[] bArr;
        synchronized (this.f29973a) {
            bArr = this.f29975c;
        }
        return bArr;
    }

    public void a(String str) {
        synchronized (this.f29973a) {
            for (a aVar : this.f29974b) {
                m0.a(this.f29975c, aVar.a(str), true);
            }
        }
    }
}
