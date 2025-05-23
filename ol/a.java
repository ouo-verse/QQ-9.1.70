package ol;

import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\"\u0010\u0007\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\u00062\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\n"}, d2 = {"Lol/a;", "", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "comment", "Ljava/util/ArrayList;", "Lcom/qzone/proxy/feedcomponent/model/PictureItem;", "Lkotlin/collections/ArrayList;", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f423082a = new a();

    a() {
    }

    public final ArrayList<PictureItem> a(Comment comment) {
        Intrinsics.checkNotNullParameter(comment, "comment");
        ArrayList<PictureItem> arrayList = comment.commentPictureItems;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList<PictureItem> arrayList2 = comment.commentPictureItems;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "{\n                commen\u2026s //\u8bc4\u8bba\u63d2\u56fe\u7684\u56fe\u7247\n            }");
            return arrayList2;
        }
        ArrayList<PictureItem> arrayList3 = comment.pictureItems;
        if (arrayList3 != null) {
            Intrinsics.checkNotNullExpressionValue(arrayList3, "{\n                commen\u2026ms //\u8bc4\u8bba\u56de\u6e90\u56fe\u7247\n            }");
            return arrayList3;
        }
        return new ArrayList<>();
    }
}
