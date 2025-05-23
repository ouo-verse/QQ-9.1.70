package kotlinx.coroutines;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B2\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012!\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004\u00a2\u0006\u0002\u0010\nJ\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00c6\u0003J$\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004H\u00c6\u0003J:\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012#\b\u0002\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R+\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/CompletedWithCancellation;", "", "result", "onCancellation", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final /* data */ class CompletedWithCancellation {

    @JvmField
    @NotNull
    public final Function1<Throwable, Unit> onCancellation;

    @JvmField
    @Nullable
    public final Object result;

    /* JADX WARN: Multi-variable type inference failed */
    public CompletedWithCancellation(@Nullable Object obj, @NotNull Function1<? super Throwable, Unit> function1) {
        this.result = obj;
        this.onCancellation = function1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CompletedWithCancellation copy$default(CompletedWithCancellation completedWithCancellation, Object obj, Function1 function1, int i3, Object obj2) {
        if ((i3 & 1) != 0) {
            obj = completedWithCancellation.result;
        }
        if ((i3 & 2) != 0) {
            function1 = completedWithCancellation.onCancellation;
        }
        return completedWithCancellation.copy(obj, function1);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Object getResult() {
        return this.result;
    }

    @NotNull
    public final Function1<Throwable, Unit> component2() {
        return this.onCancellation;
    }

    @NotNull
    public final CompletedWithCancellation copy(@Nullable Object result, @NotNull Function1<? super Throwable, Unit> onCancellation) {
        return new CompletedWithCancellation(result, onCancellation);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CompletedWithCancellation)) {
            return false;
        }
        CompletedWithCancellation completedWithCancellation = (CompletedWithCancellation) other;
        if (Intrinsics.areEqual(this.result, completedWithCancellation.result) && Intrinsics.areEqual(this.onCancellation, completedWithCancellation.onCancellation)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        Object obj = this.result;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        return (hashCode * 31) + this.onCancellation.hashCode();
    }

    @NotNull
    public String toString() {
        return "CompletedWithCancellation(result=" + this.result + ", onCancellation=" + this.onCancellation + ')';
    }
}
