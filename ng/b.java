package ng;

import com.qzone.util.ar;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f420119a;

    /* renamed from: b, reason: collision with root package name */
    public final int f420120b;

    /* renamed from: c, reason: collision with root package name */
    public final int f420121c;

    /* renamed from: d, reason: collision with root package name */
    public final int f420122d;

    /* renamed from: e, reason: collision with root package name */
    public final int f420123e;

    /* renamed from: f, reason: collision with root package name */
    public final int f420124f;

    b() {
        int l3 = pl.a.f426446a.l(BaseApplication.getContext());
        this.f420119a = l3;
        int d16 = ar.d(14.0f);
        this.f420121c = d16;
        this.f420122d = ar.d(10.0f);
        int i3 = l3 - (d16 * 2);
        this.f420123e = i3;
        int round = Math.round(i3 * 0.75f);
        this.f420124f = round;
        this.f420120b = round;
    }

    public static b a() {
        return new b();
    }
}
