package hd;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\f\u0010\rR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lhd/a;", "Lhd/b;", "Landroid/view/View$OnClickListener;", "e", "Landroid/view/View$OnClickListener;", "c", "()Landroid/view/View$OnClickListener;", "setOnClickListener", "(Landroid/view/View$OnClickListener;)V", "onClickListener", "", "name", "<init>", "(Ljava/lang/String;Landroid/view/View$OnClickListener;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends b {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View.OnClickListener onClickListener;

    public a() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: c, reason: from getter */
    public final View.OnClickListener getOnClickListener() {
        return this.onClickListener;
    }

    public /* synthetic */ a(String str, View.OnClickListener onClickListener, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? null : onClickListener);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String name, View.OnClickListener onClickListener) {
        super(name, "", 1);
        Intrinsics.checkNotNullParameter(name, "name");
        this.onClickListener = onClickListener;
    }
}
