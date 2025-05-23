package ja3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.data.WinkAlbumItemType;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import ka3.c;
import ka3.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\f"}, d2 = {"Lja3/a;", "", "", "viewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lia3/b;", "clickListener", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f409682a = new a();

    a() {
    }

    @NotNull
    public final RecyclerView.ViewHolder a(int viewType, @NotNull ViewGroup parent, @Nullable ia3.b clickListener) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == WinkAlbumItemType.UI_TYPE_MEMORY_ALBUM_PREVIEW_ITEM.getViewType()) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.i6v, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026m_preview, parent, false)");
            return new na3.a(inflate, clickListener);
        }
        if (viewType == WinkAlbumItemType.UI_TYPE_NEW_ALBUM_PREVIEW_ITEM.getViewType()) {
            w83.b bVar = w83.b.f445025a;
            if (bVar.N()) {
                View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.i6x, parent, false);
                Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   \u2026view_new2, parent, false)");
                return new la3.b(inflate2, clickListener);
            }
            if (bVar.M()) {
                View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.i6w, parent, false);
                Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context)\n   \u2026eview_new, parent, false)");
                return new la3.a(inflate3, clickListener);
            }
            View inflate4 = LayoutInflater.from(parent.getContext()).inflate(R.layout.i6v, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate4, "from(parent.context)\n   \u2026m_preview, parent, false)");
            return new la3.a(inflate4, clickListener);
        }
        if (viewType == WinkAlbumItemType.UI_TYPE_PREVIEW_FOOTER_ITEM.getViewType()) {
            if (w83.b.f445025a.N()) {
                View inflate5 = LayoutInflater.from(parent.getContext()).inflate(R.layout.i6u, parent, false);
                Intrinsics.checkNotNullExpressionValue(inflate5, "from(parent.context)\n   \u2026ng_footer, parent, false)");
                return new c(inflate5);
            }
            View inflate6 = LayoutInflater.from(parent.getContext()).inflate(R.layout.i6s, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate6, "from(parent.context)\n   \u2026em_footer, parent, false)");
            return new c(inflate6);
        }
        if (viewType == WinkAlbumItemType.UI_TYPE_PREVIEW_FOOTER_ITEM_FINISH.getViewType()) {
            View inflate7 = LayoutInflater.from(parent.getContext()).inflate(R.layout.i6t, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate7, "from(parent.context)\n   \u2026m_footer2, parent, false)");
            return new c(inflate7);
        }
        boolean z16 = true;
        if (viewType != WinkAlbumItemType.UI_TYPE_TOPIC_EMPTY.getViewType() && viewType != WinkAlbumItemType.UI_TYPE_TOPIC_LOADING.getViewType()) {
            z16 = false;
        }
        if (z16) {
            View inflate8 = LayoutInflater.from(parent.getContext()).inflate(R.layout.i6r, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate8, "from(parent.context)\n   \u2026tem_empty, parent, false)");
            return new ka3.b(inflate8);
        }
        if (viewType == WinkAlbumItemType.UI_TYPE_TOPIC_UNAUTHORIZE.getViewType()) {
            View inflate9 = LayoutInflater.from(parent.getContext()).inflate(R.layout.i6r, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate9, "from(parent.context)\n   \u2026tem_empty, parent, false)");
            return new e(inflate9);
        }
        if (viewType == WinkAlbumItemType.UI_TYPE_MEMORY_ALBUM_TOPIC_SMALL.getViewType()) {
            View inflate10 = LayoutInflater.from(parent.getContext()).inflate(R.layout.i6y, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate10, "from(parent.context)\n   \u2026tem_topic, parent, false)");
            return new oa3.b(inflate10, clickListener);
        }
        if (viewType == WinkAlbumItemType.UI_TYPE_MEMORY_ALBUM_TOPIC_ONE_BIG.getViewType()) {
            View inflate11 = LayoutInflater.from(parent.getContext()).inflate(R.layout.i6y, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate11, "from(parent.context)\n   \u2026tem_topic, parent, false)");
            return new oa3.a(inflate11, clickListener);
        }
        if (viewType == WinkAlbumItemType.UI_TYPE_NEW_ALBUM_TOPIC_SMALL.getViewType()) {
            View inflate12 = LayoutInflater.from(parent.getContext()).inflate(R.layout.i6y, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate12, "from(parent.context)\n   \u2026tem_topic, parent, false)");
            return new ma3.b(inflate12, clickListener);
        }
        if (viewType == WinkAlbumItemType.UI_TYPE_NEW_ALBUM_TOPIC_ONE_BIG.getViewType()) {
            View inflate13 = LayoutInflater.from(parent.getContext()).inflate(R.layout.i6y, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate13, "from(parent.context)\n   \u2026tem_topic, parent, false)");
            return new ma3.a(inflate13, clickListener);
        }
        View inflate14 = LayoutInflater.from(parent.getContext()).inflate(R.layout.i6r, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate14, "from(parent.context)\n   \u2026tem_empty, parent, false)");
        return new ka3.b(inflate14);
    }
}
