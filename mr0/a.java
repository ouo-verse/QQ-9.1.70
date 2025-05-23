package mr0;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B-\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0010\u00a2\u0006\u0004\b\u0017\u0010\u0018R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR.\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lmr0/a;", "", "Landroid/graphics/drawable/Drawable;", "a", "Landroid/graphics/drawable/Drawable;", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "drawable", "", "b", "I", "()I", "setJobType", "(I)V", "jobType", "Lkotlin/Pair;", "c", "Lkotlin/Pair;", "()Lkotlin/Pair;", "setSize", "(Lkotlin/Pair;)V", "size", "<init>", "(Landroid/graphics/drawable/Drawable;ILkotlin/Pair;)V", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable drawable;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int jobType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Pair<Integer, Integer> size;

    public a(@Nullable Drawable drawable, int i3, @NotNull Pair<Integer, Integer> size) {
        Intrinsics.checkNotNullParameter(size, "size");
        this.drawable = drawable;
        this.jobType = i3;
        this.size = size;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Drawable getDrawable() {
        return this.drawable;
    }

    /* renamed from: b, reason: from getter */
    public final int getJobType() {
        return this.jobType;
    }

    @NotNull
    public final Pair<Integer, Integer> c() {
        return this.size;
    }
}
