package nn3;

import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R4\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\tj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lnn3/a;", "", "", "roomId", "Lnn3/a$a;", "gameData", "", "a", "b", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "cache", "<init>", "()V", "qq-live-od-logic-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f420534a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Long, GameData> cache = new HashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lnn3/a$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "[B", "getGameDetail", "()[B", "gameDetail", "Lnn3/c;", "b", "Lnn3/c;", "getGameExtraInfo", "()Lnn3/c;", "gameExtraInfo", "<init>", "([BLnn3/c;)V", "qq-live-od-logic-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: nn3.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes22.dex */
    public static final /* data */ class GameData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final byte[] gameDetail;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final GameExtraInfo gameExtraInfo;

        public GameData(@Nullable byte[] bArr, @NotNull GameExtraInfo gameExtraInfo) {
            Intrinsics.checkNotNullParameter(gameExtraInfo, "gameExtraInfo");
            this.gameDetail = bArr;
            this.gameExtraInfo = gameExtraInfo;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GameData)) {
                return false;
            }
            GameData gameData = (GameData) other;
            if (Intrinsics.areEqual(this.gameDetail, gameData.gameDetail) && Intrinsics.areEqual(this.gameExtraInfo, gameData.gameExtraInfo)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            byte[] bArr = this.gameDetail;
            if (bArr == null) {
                hashCode = 0;
            } else {
                hashCode = Arrays.hashCode(bArr);
            }
            return (hashCode * 31) + this.gameExtraInfo.hashCode();
        }

        @NotNull
        public String toString() {
            return "GameData(gameDetail=" + Arrays.toString(this.gameDetail) + ", gameExtraInfo=" + this.gameExtraInfo + ')';
        }
    }

    a() {
    }

    public final void a(long roomId, @Nullable GameData gameData) {
        cache.put(Long.valueOf(roomId), gameData);
    }

    public final void b(long roomId) {
        cache.remove(Long.valueOf(roomId));
    }
}
