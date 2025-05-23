package m94;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\tB\u0017\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lm94/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "g", "()I", "errorCode", "b", "Ljava/lang/String;", tl.h.F, "()Ljava/lang/String;", "errorMsg", "<init>", "(ILjava/lang/String;)V", "c", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: m94.e, reason: from toString */
/* loaded from: classes38.dex */
public final /* data */ class DressErrorMsg {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    private static final DressErrorMsg f416475d = new DressErrorMsg(-1000, "dress history is empty!");

    /* renamed from: e, reason: collision with root package name */
    private static final DressErrorMsg f416476e = new DressErrorMsg(-1001, "dress history bad targetIndex < 0");

    /* renamed from: f, reason: collision with root package name */
    private static final DressErrorMsg f416477f = new DressErrorMsg(-1002, "dress history bad targetIndex >= history size");

    /* renamed from: g, reason: collision with root package name */
    private static final DressErrorMsg f416478g = new DressErrorMsg(-2000, "occupancySlots is null");

    /* renamed from: h, reason: collision with root package name */
    private static final DressErrorMsg f416479h = new DressErrorMsg(-2001, "gender_not_match");

    /* renamed from: i, reason: collision with root package name */
    private static final DressErrorMsg f416480i = new DressErrorMsg(-3000, "waiting task over size!");

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int errorCode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String errorMsg;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0012\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0013R\u0014\u0010\u0019\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0013\u00a8\u0006\u001c"}, d2 = {"Lm94/e$a;", "", "Lm94/e;", "ERR_MSG_HISTORY_EMPTY", "Lm94/e;", "b", "()Lm94/e;", "ERR_MSG_HISTORY_INDEX_LESS_THAN_0", "c", "ERR_MSG_HISTORY_INDEX_MORE_THAN_MAX_SIZE", "d", "ERR_MSG_OCCUPANCY_SLOTS_EMPTY", "e", "ERR_MSG_GENDER_NOT_MATCH", "a", "ERR_MSG_TASK_OVER_SIZE", "f", "", "ERR_CODE_GENDER_NOT_MATCH", "I", "ERR_CODE_HISTORY_EMPTY", "ERR_CODE_HISTORY_INDEX_LESS_THAN_0", "ERR_CODE_HISTORY_INDEX_MORE_THAN_MAX_SIZE", "ERR_CODE_LUA", "ERR_CODE_OCCUPANCY_SLOTS_EMPTY", "ERR_CODE_TASK_OVER_SIZE", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: m94.e$a, reason: from kotlin metadata */
    /* loaded from: classes38.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DressErrorMsg a() {
            return DressErrorMsg.f416479h;
        }

        public final DressErrorMsg b() {
            return DressErrorMsg.f416475d;
        }

        public final DressErrorMsg c() {
            return DressErrorMsg.f416476e;
        }

        public final DressErrorMsg d() {
            return DressErrorMsg.f416477f;
        }

        public final DressErrorMsg e() {
            return DressErrorMsg.f416478g;
        }

        public final DressErrorMsg f() {
            return DressErrorMsg.f416480i;
        }

        Companion() {
        }
    }

    public DressErrorMsg(int i3, String errorMsg) {
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        this.errorCode = i3;
        this.errorMsg = errorMsg;
    }

    /* renamed from: g, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: h, reason: from getter */
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public int hashCode() {
        return (this.errorCode * 31) + this.errorMsg.hashCode();
    }

    public String toString() {
        return "DressErrorMsg(errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DressErrorMsg)) {
            return false;
        }
        DressErrorMsg dressErrorMsg = (DressErrorMsg) other;
        return this.errorCode == dressErrorMsg.errorCode && Intrinsics.areEqual(this.errorMsg, dressErrorMsg.errorMsg);
    }
}
