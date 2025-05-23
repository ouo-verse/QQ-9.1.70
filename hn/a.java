package hn;

import com.qzone.reborn.qzmoment.comment.QZMCommentBusinessViewModel;
import com.qzone.reborn.qzmoment.comment.QZMFeedCommentInfo;
import gn.b;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a implements b {

    /* renamed from: a, reason: collision with root package name */
    private QZMCommentBusinessViewModel f405335a;

    /* renamed from: b, reason: collision with root package name */
    private QZMFeedCommentInfo f405336b;

    @Override // gn.b
    public QZMFeedCommentInfo a() {
        return this.f405336b;
    }

    @Override // gn.b
    public void b(QZMFeedCommentInfo qZMFeedCommentInfo) {
        this.f405336b = qZMFeedCommentInfo;
    }

    @Override // gn.b
    public void c(QZMCommentBusinessViewModel qZMCommentBusinessViewModel) {
        this.f405335a = qZMCommentBusinessViewModel;
    }

    @Override // gn.b
    public QZMCommentBusinessViewModel d() {
        return this.f405335a;
    }
}
