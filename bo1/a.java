package bo1;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003:\u0005\u0006\u0007\b\t\nB\t\b\u0004\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0001\u0005\u000b\f\r\u000e\u000f\u00a8\u0006\u0010"}, d2 = {"Lbo1/a;", "T", "Args", "", "<init>", "()V", "a", "b", "c", "d", "e", "Lbo1/a$a;", "Lbo1/a$b;", "Lbo1/a$c;", "Lbo1/a$d;", "Lbo1/a$e;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class a<T, Args> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u0000*\u0004\b\u0004\u0010\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00040\u0002B)\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\b\u0010\u0015\u001a\u0004\u0018\u00018\u0004\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0015\u001a\u0004\u0018\u00018\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001d\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u000f\u00a8\u0006 "}, d2 = {"Lbo1/a$a;", "Args", "Lbo1/a;", "", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "getKeyword", "()Ljava/lang/String;", "keyword", "b", "Ljava/lang/Object;", "getExtraArgs", "()Ljava/lang/Object;", "extraArgs", "c", "I", "getErrorType", "()I", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "d", "getErrorMsg", "errorMsg", "<init>", "(Ljava/lang/String;Ljava/lang/Object;ILjava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: bo1.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class ErrorState<Args> extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String keyword;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Args extraArgs;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int errorType;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String errorMsg;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ErrorState(@NotNull String keyword, @Nullable Args args, int i3, @NotNull String errorMsg) {
            super(null);
            Intrinsics.checkNotNullParameter(keyword, "keyword");
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            this.keyword = keyword;
            this.extraArgs = args;
            this.errorType = i3;
            this.errorMsg = errorMsg;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ErrorState)) {
                return false;
            }
            ErrorState errorState = (ErrorState) other;
            if (Intrinsics.areEqual(this.keyword, errorState.keyword) && Intrinsics.areEqual(this.extraArgs, errorState.extraArgs) && this.errorType == errorState.errorType && Intrinsics.areEqual(this.errorMsg, errorState.errorMsg)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = this.keyword.hashCode() * 31;
            Args args = this.extraArgs;
            if (args == null) {
                hashCode = 0;
            } else {
                hashCode = args.hashCode();
            }
            return ((((hashCode2 + hashCode) * 31) + this.errorType) * 31) + this.errorMsg.hashCode();
        }

        @NotNull
        public String toString() {
            return "ErrorState(keyword=" + this.keyword + ", extraArgs=" + this.extraArgs + ", errorType=" + this.errorType + ", errorMsg=" + this.errorMsg + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lbo1/a$b;", "Lbo1/a;", "", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f28717a = new b();

        b() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lbo1/a$c;", "Lbo1/a;", "", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c extends a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final c f28718a = new c();

        c() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lbo1/a$d;", "Lbo1/a;", "", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d extends a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final d f28719a = new d();

        d() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u0000*\u0004\b\u0004\u0010\u0001*\u0004\b\u0005\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0003B!\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00018\u0005\u0012\u0006\u0010\u0007\u001a\u00028\u0004\u00a2\u0006\u0004\b\u0019\u0010\u001aJ<\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u00052\b\b\u0002\u0010\u0007\u001a\u00028\u0004H\u00c6\u0001\u00a2\u0006\u0004\b\b\u0010\tJ\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u00d6\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0006\u001a\u0004\u0018\u00018\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0007\u001a\u00028\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lbo1/a$e;", "T", "Args", "Lbo1/a;", "", "keyword", "extraArgs", "value", "a", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)Lbo1/a$e;", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "b", "Ljava/lang/Object;", "getExtraArgs", "()Ljava/lang/Object;", "d", "<init>", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: bo1.a$e, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class SuccessState<T, Args> extends a<T, Args> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String keyword;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Args extraArgs;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final T value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SuccessState(@NotNull String keyword, @Nullable Args args, T t16) {
            super(null);
            Intrinsics.checkNotNullParameter(keyword, "keyword");
            this.keyword = keyword;
            this.extraArgs = args;
            this.value = t16;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SuccessState b(SuccessState successState, String str, Object obj, Object obj2, int i3, Object obj3) {
            if ((i3 & 1) != 0) {
                str = successState.keyword;
            }
            if ((i3 & 2) != 0) {
                obj = successState.extraArgs;
            }
            if ((i3 & 4) != 0) {
                obj2 = successState.value;
            }
            return successState.a(str, obj, obj2);
        }

        @NotNull
        public final SuccessState<T, Args> a(@NotNull String keyword, @Nullable Args extraArgs, T value) {
            Intrinsics.checkNotNullParameter(keyword, "keyword");
            return new SuccessState<>(keyword, extraArgs, value);
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getKeyword() {
            return this.keyword;
        }

        public final T d() {
            return this.value;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SuccessState)) {
                return false;
            }
            SuccessState successState = (SuccessState) other;
            if (Intrinsics.areEqual(this.keyword, successState.keyword) && Intrinsics.areEqual(this.extraArgs, successState.extraArgs) && Intrinsics.areEqual(this.value, successState.value)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = this.keyword.hashCode() * 31;
            Args args = this.extraArgs;
            int i3 = 0;
            if (args == null) {
                hashCode = 0;
            } else {
                hashCode = args.hashCode();
            }
            int i16 = (hashCode2 + hashCode) * 31;
            T t16 = this.value;
            if (t16 != null) {
                i3 = t16.hashCode();
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "SuccessState(keyword=" + this.keyword + ", extraArgs=" + this.extraArgs + ", value=" + this.value + ")";
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    a() {
    }
}
