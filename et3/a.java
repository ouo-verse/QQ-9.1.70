package et3;

import com.tencent.widget.ProcessUtil;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f397103a;

    /* renamed from: b, reason: collision with root package name */
    public String f397104b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f397105c;

    public a(String str, String str2, boolean z16) {
        this.f397103a = str;
        this.f397104b = str2;
        this.f397105c = z16;
    }

    public static a a() {
        return new a(null, ProcessUtil.getCurrentProcessNameByApplication(), false);
    }
}
