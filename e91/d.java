package e91;

import com.tencent.util.QQCustomArkDialogUtil;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private String f395959a;

    /* renamed from: b, reason: collision with root package name */
    private String f395960b;

    /* renamed from: c, reason: collision with root package name */
    private String f395961c;

    /* renamed from: d, reason: collision with root package name */
    private int f395962d;

    /* renamed from: e, reason: collision with root package name */
    private int f395963e;

    public String a() {
        return this.f395959a;
    }

    public String b() {
        return this.f395961c;
    }

    public void c(String str) {
        this.f395959a = str;
    }

    public void d(String str) {
        this.f395961c = str;
    }

    public void e(int i3) {
        this.f395963e = i3;
    }

    public void f(String str) {
        this.f395960b = str;
    }

    public void g(int i3) {
        this.f395962d = i3;
    }

    public HashMap<String, String> h() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("app", this.f395959a);
        hashMap.put("view", this.f395960b);
        hashMap.put(QQCustomArkDialogUtil.BIZ_SRC, this.f395961c);
        hashMap.put("width", this.f395962d + "");
        hashMap.put("height", this.f395963e + "");
        return hashMap;
    }
}
