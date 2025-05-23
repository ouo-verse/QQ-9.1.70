package o20;

import com.tencent.biz.qqcircle.comment.at.bean.QFSCommentAtEntity;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c extends a {

    /* renamed from: f, reason: collision with root package name */
    private static int f421785f = 0;

    /* renamed from: g, reason: collision with root package name */
    public static final int f421786g = 100;

    /* renamed from: h, reason: collision with root package name */
    public static final int f421787h;

    /* renamed from: i, reason: collision with root package name */
    public static final int f421788i;

    /* renamed from: j, reason: collision with root package name */
    public static final int f421789j;

    /* renamed from: c, reason: collision with root package name */
    private final int f421790c;

    /* renamed from: d, reason: collision with root package name */
    private List<QFSCommentAtEntity> f421791d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f421792e;

    static {
        int i3 = 100 + 1;
        int i16 = i3 + 1;
        f421787h = i3;
        int i17 = i16 + 1;
        f421788i = i16;
        f421785f = i17 + 1;
        f421789j = i17;
    }

    public c(int i3) {
        this.f421790c = i3;
    }

    public List<QFSCommentAtEntity> e() {
        return this.f421791d;
    }

    public int f() {
        return this.f421790c;
    }

    public boolean g() {
        return this.f421792e;
    }

    public void h(boolean z16) {
        this.f421792e = z16;
    }

    public void i(List<QFSCommentAtEntity> list) {
        this.f421791d = list;
    }

    @Override // o20.a
    public String toString() {
        return "QFSCommentAtItemInfo{mType=" + this.f421790c + ", mRecentAtEntityList=" + this.f421791d + ", mFromSearch=" + this.f421792e + "} " + super.toString();
    }
}
