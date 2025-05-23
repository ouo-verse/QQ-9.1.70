package com.tencent.mobileqq.zplan.setting;

import android.content.Context;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes34.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public int f335440a = -1;

    /* renamed from: b, reason: collision with root package name */
    public boolean f335441b = false;

    /* renamed from: c, reason: collision with root package name */
    public C9199a f335442c = new C9199a(null);

    /* renamed from: d, reason: collision with root package name */
    public boolean f335443d = false;

    public static int a(int i3) {
        if (i3 != -1) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                return 0;
                            }
                            return R.string.xu6;
                        }
                        return R.string.xu_;
                    }
                    return R.string.xua;
                }
            } else {
                return R.string.xu8;
            }
        }
        return R.string.xu9;
    }

    public String toString() {
        return "QualityItem{type=" + this.f335440a + ", isClicked=" + this.f335441b + ", qualityFeature=" + this.f335442c.toString() + ", isRecommended=" + this.f335443d + '}';
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.zplan.setting.a$a, reason: collision with other inner class name */
    /* loaded from: classes34.dex */
    public static class C9199a {

        /* renamed from: a, reason: collision with root package name */
        public int f335444a = 2;

        /* renamed from: b, reason: collision with root package name */
        public int f335445b = 2;

        /* renamed from: c, reason: collision with root package name */
        public int f335446c = 2;

        /* renamed from: d, reason: collision with root package name */
        public int f335447d = 2;

        public C9199a(C9199a c9199a) {
            a(c9199a);
        }

        public String toString() {
            return "QualityFeature{antiAlias=" + this.f335444a + ", texture=" + this.f335445b + ", shadow=" + this.f335446c + ", effects=" + this.f335447d + '}';
        }

        public void a(C9199a c9199a) {
            if (c9199a == null) {
                return;
            }
            this.f335444a = c9199a.f335444a;
            this.f335445b = c9199a.f335445b;
            this.f335446c = c9199a.f335446c;
            this.f335447d = c9199a.f335447d;
        }
    }

    public String b(Context context) {
        if (context == null) {
            return "";
        }
        return context.getString(a(this.f335440a));
    }
}
