package ge;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonComment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b%\u0010&R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001e\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010$\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010 \u001a\u0004\b\u0003\u0010!\"\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lge/b;", "", "", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "i", "(Ljava/lang/String;)V", "lLoc", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "b", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "g", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;)V", "commentComment", "", "c", "I", "()I", tl.h.F, "(I)V", "commentNum", "", "Z", "e", "()Z", "setPrivate", "(Z)V", "isPrivate", "", "J", "()J", "f", "(J)V", "batchId", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String lLoc = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private CommonComment commentComment;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int commentNum;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isPrivate;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long batchId;

    /* renamed from: a, reason: from getter */
    public final long getBatchId() {
        return this.batchId;
    }

    /* renamed from: b, reason: from getter */
    public final CommonComment getCommentComment() {
        return this.commentComment;
    }

    /* renamed from: c, reason: from getter */
    public final int getCommentNum() {
        return this.commentNum;
    }

    /* renamed from: d, reason: from getter */
    public final String getLLoc() {
        return this.lLoc;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsPrivate() {
        return this.isPrivate;
    }

    public final void f(long j3) {
        this.batchId = j3;
    }

    public final void g(CommonComment commonComment) {
        this.commentComment = commonComment;
    }

    public final void h(int i3) {
        this.commentNum = i3;
    }

    public final void i(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lLoc = str;
    }
}
