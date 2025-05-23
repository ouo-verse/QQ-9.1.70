package cy4;

import com.tencent.zplan.resource.data.ZPlanUEResInfo;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0001\tBY\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013\u0012\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0013\u0012\u0014\b\u0002\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001d0\u001c\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b%\u0010&J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\t\u0010\u0017R\u001f\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001a\u0010\u0017R#\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001d0\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\u0015\u0010\u001fR\u0019\u0010$\u001a\u0004\u0018\u00010\u00018\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u000e\u0010#\u00a8\u0006("}, d2 = {"Lcy4/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getBusinessScene", "()I", "businessScene", "b", "Z", "e", "()Z", "isZPlanUser", "", "Lcy4/a;", "c", "Ljava/util/List;", "()Ljava/util/List;", "avatarCharacterList", "Ljx4/b;", "d", "stickerConfList", "", "Lcom/tencent/zplan/resource/data/ZPlanUEResInfo;", "Ljava/util/Map;", "()Ljava/util/Map;", "originalResInfoMap", "f", "Ljava/lang/Object;", "()Ljava/lang/Object;", "originalExtInfoBytes", "<init>", "(IZLjava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/lang/Object;)V", "g", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* renamed from: cy4.b, reason: from toString */
/* loaded from: classes27.dex */
public final /* data */ class ZPlanResourceBusinessData {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int businessScene;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isZPlanUser;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final List<UserAvatarCharacter> avatarCharacterList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final List<jx4.b> stickerConfList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Map<String, ZPlanUEResInfo> originalResInfoMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Object originalExtInfoBytes;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"Lcy4/b$a;", "", "Lcy4/b;", "a", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: cy4.b$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final ZPlanResourceBusinessData a() {
            return new ZPlanResourceBusinessData(0, true, null, null, null, null, 48, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ZPlanResourceBusinessData(int i3, boolean z16, @Nullable List<UserAvatarCharacter> list, @Nullable List<jx4.b> list2, @NotNull Map<String, ZPlanUEResInfo> originalResInfoMap, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(originalResInfoMap, "originalResInfoMap");
        this.businessScene = i3;
        this.isZPlanUser = z16;
        this.avatarCharacterList = list;
        this.stickerConfList = list2;
        this.originalResInfoMap = originalResInfoMap;
        this.originalExtInfoBytes = obj;
    }

    @Nullable
    public final List<UserAvatarCharacter> a() {
        return this.avatarCharacterList;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final Object getOriginalExtInfoBytes() {
        return this.originalExtInfoBytes;
    }

    @NotNull
    public final Map<String, ZPlanUEResInfo> c() {
        return this.originalResInfoMap;
    }

    @Nullable
    public final List<jx4.b> d() {
        return this.stickerConfList;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsZPlanUser() {
        return this.isZPlanUser;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ZPlanResourceBusinessData) {
                ZPlanResourceBusinessData zPlanResourceBusinessData = (ZPlanResourceBusinessData) other;
                if (this.businessScene != zPlanResourceBusinessData.businessScene || this.isZPlanUser != zPlanResourceBusinessData.isZPlanUser || !Intrinsics.areEqual(this.avatarCharacterList, zPlanResourceBusinessData.avatarCharacterList) || !Intrinsics.areEqual(this.stickerConfList, zPlanResourceBusinessData.stickerConfList) || !Intrinsics.areEqual(this.originalResInfoMap, zPlanResourceBusinessData.originalResInfoMap) || !Intrinsics.areEqual(this.originalExtInfoBytes, zPlanResourceBusinessData.originalExtInfoBytes)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18 = this.businessScene * 31;
        boolean z16 = this.isZPlanUser;
        int i19 = z16;
        if (z16 != 0) {
            i19 = 1;
        }
        int i26 = (i18 + i19) * 31;
        List<UserAvatarCharacter> list = this.avatarCharacterList;
        int i27 = 0;
        if (list != null) {
            i3 = list.hashCode();
        } else {
            i3 = 0;
        }
        int i28 = (i26 + i3) * 31;
        List<jx4.b> list2 = this.stickerConfList;
        if (list2 != null) {
            i16 = list2.hashCode();
        } else {
            i16 = 0;
        }
        int i29 = (i28 + i16) * 31;
        Map<String, ZPlanUEResInfo> map = this.originalResInfoMap;
        if (map != null) {
            i17 = map.hashCode();
        } else {
            i17 = 0;
        }
        int i36 = (i29 + i17) * 31;
        Object obj = this.originalExtInfoBytes;
        if (obj != null) {
            i27 = obj.hashCode();
        }
        return i36 + i27;
    }

    @NotNull
    public String toString() {
        return "ZPlanResourceBusinessData(businessScene=" + this.businessScene + ", isZPlanUser=" + this.isZPlanUser + ", avatarCharacterList=" + this.avatarCharacterList + ", stickerConfList=" + this.stickerConfList + ", originalResInfoMap=" + this.originalResInfoMap + ", originalExtInfoBytes=" + this.originalExtInfoBytes + ")";
    }

    public /* synthetic */ ZPlanResourceBusinessData(int i3, boolean z16, List list, List list2, Map map, Object obj, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, z16, list, list2, (i16 & 16) != 0 ? new LinkedHashMap() : map, (i16 & 32) != 0 ? null : obj);
    }
}
