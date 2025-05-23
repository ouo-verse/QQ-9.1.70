package jp0;

import fp0.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qo0.e;
import ro0.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2 = {"Ljp0/a;", "Lro0/c;", "", "isHalfDisplay", "", "visualShowHeight", "windowViewPortHeight", "d", "Lfp0/b;", "g", "Lfp0/b;", "style", "Lqo0/e;", "configuration", "<init>", "(Lqo0/e;Lfp0/b;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a extends c {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b style;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull e configuration, @NotNull b style) {
        super(configuration);
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(style, "style");
        this.style = style;
    }

    @Override // ro0.c
    public int d(boolean isHalfDisplay, int visualShowHeight, int windowViewPortHeight) {
        return this.style.getDimen().getFullStatusTopPadding();
    }
}
