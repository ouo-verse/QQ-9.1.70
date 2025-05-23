package k84;

import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lk84/b;", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b/\u00100J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007J\u000e\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003R\u0014\u0010\u0007\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\bR\u0014\u0010\u000e\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\bR\u0014\u0010\u0010\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\bR\u0014\u0010\u0011\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\bR\u0014\u0010\u0012\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\bR\u0014\u0010\u0013\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\bR\u0014\u0010\u0014\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\bR\u0014\u0010\u0015\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\bR\u0014\u0010\u0016\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\bR\u0014\u0010\u0017\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\bR\u0014\u0010\u0018\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\bR\u0014\u0010\u0019\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\bR\u0014\u0010\u001a\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\bR\u0014\u0010\u001b\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\bR\u0014\u0010\u001c\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\bR\u0014\u0010\u001d\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\bR\u0014\u0010\u001e\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\bR\u0014\u0010\u001f\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\bR\u0014\u0010 \u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b \u0010\bR\u0014\u0010!\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b!\u0010\bR\u0014\u0010\"\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\"\u0010\bR\u0014\u0010$\u001a\u00020#8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b&\u0010\bR\u0014\u0010'\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b'\u0010\bR\u0014\u0010(\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b(\u0010\bR\u0014\u0010)\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b)\u0010\bR\u0014\u0010*\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b*\u0010\bR\u0014\u0010+\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b+\u0010\bR\u0014\u0010,\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b,\u0010\bR\u0014\u0010-\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b-\u0010\bR\u0014\u0010.\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b.\u0010\b\u00a8\u00061"}, d2 = {"Lk84/b$a;", "", "msg", "", "b", "pbType", "a", "BRAND_STORE_ITEM", "I", "CLIENT_CARD_TYPE_END", "CLIENT_CARD_TYPE_START", "COMMON_CARD_TITLE", "COMMON_STATUS_LIST_EMPTY", "COMMON_STATUS_LIST_FAIL", "COMMON_STATUS_LOADING_SHIMMER", "DEFAULT", "DRESS_SQUARE_TREND", "GRID_WITH_BIG_ITEM", "HORIZONTAL_SCROLL", "HORIZONTAL_SCROLL_SMALL_ICONS", "HORIZONTAL_SCROLL_SMALL_IMG", "HORIZONTAL_SCROLL_SMALL_IMG_WITH_BUTTON", "HORIZONTAL_SCROLL_WITH_BUTTON", "LINKAGE_RECOMMEND_HORIZONAL", "NORMAL_BANNER", "NORMAL_BANNER_HALF", "NORMAL_BANNER_MIDDLE", "PARADISE_NEW_BANNER_19", "SMALLHOME_DATA_TOP_BANNER", "SMALLHOME_PARTY_GRID", "SMALL_ENTRY_ICONS", "SUB_TYPE_AVATAR_LIST_ITEM", "SUB_TYPE_RANK", "SUB_TYPE_UGC_LIST_DOWN", "SUB_TYPE_UGC_LIST_UP", "", "TAG", "Ljava/lang/String;", "TEXT_CARD", "UE4_AVATAR_CARD", "USER_CENTER_USER_INFO", "USER_CENTER_WORKS_EMPTY", "USER_CENTER_WORKS_ITEM", "USER_CENTER_WORKS_TITLE", "VERTICAL_GALLERY", "VIDEO_BIG", "WATER_FALL", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: k84.b$a, reason: from kotlin metadata */
    /* loaded from: classes38.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final int b(Object msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (msg2 instanceof ZootopiaCardData) {
                return ((ZootopiaCardData) msg2).getType();
            }
            return 0;
        }

        Companion() {
        }

        public final int a(int pbType) {
            return pbType;
        }
    }
}
