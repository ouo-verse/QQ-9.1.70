package bz;

import android.view.ViewGroup;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u000b"}, d2 = {"Lbz/j;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "type", "Lcom/tencent/widget/pull2refresh/BaseViewHolder;", "Lyy/c;", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f29427a = new j();

    j() {
    }

    public final BaseViewHolder<yy.c> a(ViewGroup parent, int type) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (type == -2) {
            return new m(parent);
        }
        if (type == -1) {
            return new n(parent);
        }
        if (type == 0) {
            return new g(parent);
        }
        if (type == 1) {
            return new k(parent);
        }
        if (type == 3) {
            return new h(parent);
        }
        if (type != 4) {
            return new i(parent);
        }
        return new h(parent);
    }
}
