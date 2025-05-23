package ho2;

import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private int f405451a;

    /* renamed from: b, reason: collision with root package name */
    private String f405452b;

    /* renamed from: c, reason: collision with root package name */
    private int f405453c;

    /* renamed from: d, reason: collision with root package name */
    private int f405454d;

    public c() {
        this(0);
    }

    private boolean e(int i3) {
        if (i3 == 0 || i3 == 1 || i3 == 4 || i3 == 5 || i3 == 17 || i3 == 8 || i3 == 9 || i3 == 6) {
            return true;
        }
        return false;
    }

    private void f() {
        int i3 = this.f405451a;
        if (i3 != 1) {
            if (i3 != 17) {
                if (i3 != 4) {
                    if (i3 != 5) {
                        if (i3 != 6) {
                            if (i3 != 8) {
                                if (i3 != 9) {
                                    this.f405452b = "channel_logo";
                                    this.f405453c = R.drawable.n8e;
                                    this.f405454d = R.drawable.n8f;
                                    return;
                                }
                            } else {
                                this.f405452b = "world";
                                this.f405453c = R.drawable.n8q;
                                this.f405454d = R.drawable.n8q;
                                return;
                            }
                        } else {
                            this.f405452b = "share";
                            this.f405453c = R.drawable.n8o;
                            this.f405454d = R.drawable.n8p;
                            return;
                        }
                    }
                    this.f405452b = "play";
                    this.f405453c = R.drawable.n8h;
                    this.f405454d = R.drawable.n8i;
                    return;
                }
                this.f405452b = "voice";
                this.f405453c = R.drawable.n8c;
                this.f405454d = R.drawable.n8d;
                return;
            }
            this.f405452b = "music";
            this.f405453c = R.drawable.n8m;
            this.f405454d = R.drawable.n8n;
            return;
        }
        this.f405452b = "live";
        this.f405453c = R.drawable.n8k;
        this.f405454d = R.drawable.n8l;
    }

    public int a() {
        return this.f405454d;
    }

    public String b() {
        return this.f405452b;
    }

    public int c() {
        return this.f405453c;
    }

    public boolean d() {
        if (this.f405451a == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "GuildSearchChannelState{state=" + this.f405451a + ", reportTag='" + this.f405452b + "', resId=" + this.f405453c + ", newResId=" + this.f405454d + '}';
    }

    public c(int i3) {
        this.f405451a = 0;
        if (e(i3)) {
            this.f405451a = i3;
        }
        f();
    }
}
