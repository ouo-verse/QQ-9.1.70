package bu2;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\b\u000eB!\b\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\u0082\u0001\u0003\u000f\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"Lbu2/c;", "", "", "a", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "errorCode", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "errorMsg", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "c", "Lbu2/c$a;", "Lbu2/c$b;", "Lbu2/c$c;", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Integer errorCode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String errorMsg;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lbu2/c$a;", "Lbu2/c;", "", "errorCode", "", "errorMsg", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a extends c {
        public a() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public /* synthetic */ a(Integer num, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : str);
        }

        public a(@Nullable Integer num, @Nullable String str) {
            super(num, str, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lbu2/c$b;", "Lbu2/c;", "", "errorCode", "", "errorMsg", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends c {
        public b(@Nullable Integer num, @Nullable String str) {
            super(num, str, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lbu2/c$c;", "Lbu2/c;", "", "errorCode", "", "errorMsg", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: bu2.c$c, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static final class C0152c extends c {
        public C0152c() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public /* synthetic */ C0152c(Integer num, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : str);
        }

        public C0152c(@Nullable Integer num, @Nullable String str) {
            super(num, str, null);
        }
    }

    public /* synthetic */ c(Integer num, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, str);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Integer getErrorCode() {
        return this.errorCode;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    c(Integer num, String str) {
        this.errorCode = num;
        this.errorMsg = str;
    }
}
