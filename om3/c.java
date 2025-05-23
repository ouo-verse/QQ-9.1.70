package om3;

import hn3.LinkScreenAnchorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import om3.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002\u00a8\u0006\u0013"}, d2 = {"Lom3/c;", "", "Lom3/d;", "state", "", "d", "", "pkType", "b", "c", "Lhn3/a;", "linkScreenAnchorInfo", "Le55/a;", "a", "oldState", "nextState", "e", "<init>", "()V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f423174a = new c();

    c() {
    }

    @NotNull
    public final e55.a a(@NotNull LinkScreenAnchorInfo linkScreenAnchorInfo) {
        Intrinsics.checkNotNullParameter(linkScreenAnchorInfo, "linkScreenAnchorInfo");
        e55.a aVar = new e55.a();
        e55.c cVar = new e55.c();
        aVar.f395729a = cVar;
        cVar.f395738d = linkScreenAnchorInfo.getAvatar();
        aVar.f395729a.f395737c = linkScreenAnchorInfo.getNick();
        aVar.f395729a.f395736b = linkScreenAnchorInfo.getRoomId();
        return aVar;
    }

    public final boolean b(int pkType) {
        if (pkType != 2 && pkType != 3) {
            return false;
        }
        return true;
    }

    public final boolean c(int pkType) {
        if (pkType == 1 || pkType == 2) {
            return true;
        }
        return false;
    }

    public final boolean d(@NotNull d state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof d.InLinkScreen) {
            d.InLinkScreen inLinkScreen = (d.InLinkScreen) state;
            if (inLinkScreen.getPkType() == 1 || inLinkScreen.getPkType() == 2) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final boolean e(@NotNull d oldState, @NotNull d nextState) {
        Intrinsics.checkNotNullParameter(oldState, "oldState");
        Intrinsics.checkNotNullParameter(nextState, "nextState");
        if (!oldState.getClass().getSimpleName().equals(nextState.getClass().getSimpleName())) {
            return true;
        }
        if ((oldState instanceof d.InLinkScreen) && (nextState instanceof d.InLinkScreen)) {
            d.InLinkScreen inLinkScreen = (d.InLinkScreen) oldState;
            d.InLinkScreen inLinkScreen2 = (d.InLinkScreen) nextState;
            if (inLinkScreen.getIsInPK() != inLinkScreen2.getIsInPK() || inLinkScreen.getPkType() != inLinkScreen2.getPkType()) {
                return true;
            }
            return false;
        }
        return false;
    }
}
