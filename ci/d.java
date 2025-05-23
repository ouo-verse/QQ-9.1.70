package ci;

import com.qzone.proxy.feedcomponent.model.Comment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012R*\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lci/d;", "", "", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "a", "Ljava/util/List;", "()Ljava/util/List;", "c", "(Ljava/util/List;)V", "comments", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "id", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private List<Comment> comments;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String id = "";

    public final List<Comment> a() {
        return this.comments;
    }

    /* renamed from: b, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final void c(List<Comment> list) {
        this.comments = list;
    }

    public final void d(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }
}
