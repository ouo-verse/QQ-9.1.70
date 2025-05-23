package cv1;

import com.tencent.mobileqq.text.QQText;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private String f391886a;

    /* renamed from: b, reason: collision with root package name */
    private CharSequence f391887b;

    /* renamed from: c, reason: collision with root package name */
    private QQText f391888c;

    /* renamed from: d, reason: collision with root package name */
    private int f391889d = 1;

    /* renamed from: e, reason: collision with root package name */
    private int f391890e = 11;

    /* renamed from: f, reason: collision with root package name */
    private long f391891f = -1;

    /* renamed from: g, reason: collision with root package name */
    private long f391892g = -1;

    /* renamed from: h, reason: collision with root package name */
    private String f391893h = "";

    public CharSequence a() {
        return this.f391887b;
    }

    public long b() {
        return this.f391891f;
    }

    public QQText c() {
        return this.f391888c;
    }

    public void d(CharSequence charSequence) {
        this.f391887b = charSequence;
    }

    public void e(long j3) {
        this.f391891f = j3;
    }

    public void f(long j3) {
        this.f391892g = j3;
    }

    public void g(int i3) {
        this.f391890e = i3;
    }

    public void h(QQText qQText) {
        this.f391888c = qQText;
    }

    public String toString() {
        return "UIData{, mTitleName=" + this.f391886a + ", qqText=" + ((Object) this.f391888c) + ", mContentText=" + ((Object) this.f391887b) + ", mFrom=" + this.f391889d + '}';
    }
}
