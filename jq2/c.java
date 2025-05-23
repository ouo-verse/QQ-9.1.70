package jq2;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000 \u00112\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H&J\u001c\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0000\u0018\u0001`\u0005H&J\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00000\u0004j\b\u0012\u0004\u0012\u00020\u0000`\u0005J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0000J$\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002H&J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002R$\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00000\u0004j\b\u0012\u0004\u0012\u00020\u0000`\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Ljq2/c;", "", "", "e", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "c", "d", "searchNode", "", "a", "title", "Landroid/content/Context;", "context", "id", "f", "url", "b", "Ljava/util/ArrayList;", "subNodes", "<init>", "()V", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<c> subNodes;

    public c() {
        ArrayList<c> arrayList = new ArrayList<>();
        this.subNodes = arrayList;
        ArrayList<c> c16 = c();
        if (c16 != null) {
            arrayList.addAll(c16);
        }
    }

    public final void a(c searchNode) {
        Intrinsics.checkNotNullParameter(searchNode, "searchNode");
        this.subNodes.add(searchNode);
    }

    public final String b(String url, String id5) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (TextUtils.isEmpty(id5)) {
            return url;
        }
        return url + "&search=" + id5;
    }

    public abstract ArrayList<c> c();

    public final ArrayList<c> d() {
        return this.subNodes;
    }

    public abstract String e();

    public abstract void f(String title, Context context, String id5);

    public static /* synthetic */ void g(c cVar, String str, Context context, String str2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                str2 = null;
            }
            cVar.f(str, context, str2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startRouteToPage");
    }
}
