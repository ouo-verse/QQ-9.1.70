package o9;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\b\b\u0016\u0018\u0000 \u00192\u00020\u0001:\u0001\u0003B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0010R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\"\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\b\u0010\u0005\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0017\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u000e\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lo9/b;", "", "", "a", "I", "()I", "action", "", "b", "Z", "isSuccess", "()Z", "setSuccess", "(Z)V", "c", "d", "(I)V", "commentNum", "", "Ljava/lang/String;", "getCommentContent", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "commentContent", "<init>", "e", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int action;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int commentNum;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isSuccess = true;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String commentContent = "";

    public b(int i3) {
        this.action = i3;
    }

    /* renamed from: a, reason: from getter */
    public final int getAction() {
        return this.action;
    }

    /* renamed from: b, reason: from getter */
    public final int getCommentNum() {
        return this.commentNum;
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.commentContent = str;
    }

    public final void d(int i3) {
        this.commentNum = i3;
    }
}
