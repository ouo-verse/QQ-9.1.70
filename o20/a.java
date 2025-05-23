package o20;

import com.tencent.biz.qqcircle.comment.at.bean.QFSCommentAtEntity;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private QFSCommentAtEntity f421781a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f421782b;

    public QFSCommentAtEntity a() {
        return this.f421781a;
    }

    public boolean b() {
        return this.f421782b;
    }

    public void c(QFSCommentAtEntity qFSCommentAtEntity) {
        this.f421781a = qFSCommentAtEntity;
    }

    public void d(boolean z16) {
        this.f421782b = z16;
    }

    public String toString() {
        return "QFSCommentAtBaseItemInfo{mAtEntity=" + this.f421781a + ", mSelected=" + this.f421782b + '}';
    }
}
