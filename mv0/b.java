package mv0;

import com.tencent.icgame.game.utils.g;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.supervision.IQQLiveModuleKickOut;
import fu0.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lmv0/b;", "", "Lki2/b;", "listener", "", "a", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f417658a = new b();

    b() {
    }

    public final void a(@NotNull ki2.b listener) {
        IQQLiveModuleKickOut iQQLiveModuleKickOut;
        Intrinsics.checkNotNullParameter(listener, "listener");
        IQQLiveSDK f16 = ((c) qx0.a.b(c.class)).f();
        if (f16 != null) {
            iQQLiveModuleKickOut = f16.getKickOutModule();
        } else {
            iQQLiveModuleKickOut = null;
        }
        if (iQQLiveModuleKickOut != null) {
            iQQLiveModuleKickOut.removeKickedOutOfRoomListener(listener);
        }
        g.h("TimiAudienceKickOutHelper ", "removeKickedOutOfRoomListener " + iQQLiveModuleKickOut + " " + listener);
    }
}
