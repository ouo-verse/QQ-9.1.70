package fc4;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0004H&J\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u0004H&J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H&\u00a8\u0006\u0010"}, d2 = {"Lfc4/e;", "Ljava/util/Observable;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Lfc4/e$a;", "d", "a", "holder", "position", "", "c", "b", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public abstract class e extends Observable {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\n"}, d2 = {"Lfc4/e$a;", "", "Landroid/view/View;", "a", "Landroid/view/View;", "()Landroid/view/View;", "itemView", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "<init>", "(Landroid/view/View;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final View itemView;

        public a(View item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.itemView = item;
        }

        /* renamed from: a, reason: from getter */
        public final View getItemView() {
            return this.itemView;
        }
    }

    public abstract int a();

    public abstract int b(int position);

    public abstract void c(a holder, int position);

    public abstract a d(ViewGroup parent, int viewType);
}
