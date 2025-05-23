package j22;

import androidx.fragment.app.Fragment;
import g32.h;
import i22.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\bR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lj22/a;", "", "Lj22/b;", "Landroidx/fragment/app/Fragment;", "fragment", "", "a", "Lg32/h;", "Lg32/h;", "trigger", "b", "Landroidx/fragment/app/Fragment;", "parentFragment", "<init>", "(Lg32/h;)V", "ic-game-room-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final h trigger;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Fragment parentFragment;

    public a(@NotNull h trigger) {
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        this.trigger = trigger;
    }

    public void a(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.parentFragment = fragment;
        this.trigger.w0(new i(fragment));
    }
}
