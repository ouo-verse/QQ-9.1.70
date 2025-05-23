package i22;

import android.content.res.Configuration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Li22/c;", "Lg32/b;", "Landroid/content/res/Configuration;", "c", "Landroid/content/res/Configuration;", "getNewConfig", "()Landroid/content/res/Configuration;", "newConfig", "<init>", "(Landroid/content/res/Configuration;)V", "ic-game-room-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class c extends g32.b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Configuration newConfig;

    public c(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        this.newConfig = newConfig;
    }
}
