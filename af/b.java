package af;

import com.qzone.proxy.feedcomponent.model.CellCommentInfo;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private String f25946a;

    /* renamed from: b, reason: collision with root package name */
    private CellCommentInfo f25947b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f25948c;

    public b(String str, CellCommentInfo cellCommentInfo) {
        this.f25946a = str;
        this.f25947b = cellCommentInfo;
    }

    public CellCommentInfo a() {
        return this.f25947b;
    }

    public String b() {
        return this.f25946a;
    }

    public boolean c() {
        return this.f25948c;
    }

    public void d(CellCommentInfo cellCommentInfo) {
        this.f25947b = cellCommentInfo;
    }

    public void e(boolean z16) {
        this.f25948c = z16;
    }
}
