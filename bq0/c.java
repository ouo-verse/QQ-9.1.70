package bq0;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lbq0/c;", "Lat/b;", "", "d", "I", "b", "()I", "position", "Landroid/view/View;", "e", "Landroid/view/View;", "a", "()Landroid/view/View;", "itemView", "<init>", "(ILandroid/view/View;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c implements at.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int position;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final View itemView;

    public c(int i3, @Nullable View view) {
        this.position = i3;
        this.itemView = view;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final View getItemView() {
        return this.itemView;
    }

    /* renamed from: b, reason: from getter */
    public final int getPosition() {
        return this.position;
    }

    public /* synthetic */ c(int i3, View view, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? null : view);
    }
}
