package kotlinx.coroutines.selects;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J6\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u001c\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0006\u0012\u0004\u0018\u00010\u00020\bH'\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ3\u0010\u000b\u001a\u00020\u0004*\u00020\f2\u001c\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0006\u0012\u0004\u0018\u00010\u00020\bH\u00a6\u0002\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJE\u0010\u000b\u001a\u00020\u0004\"\u0004\b\u0001\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u000f2\"\u0010\u0007\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0010H\u00a6\u0002\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011JY\u0010\u000b\u001a\u00020\u0004\"\u0004\b\u0001\u0010\u0012\"\u0004\b\u0002\u0010\u000e*\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u000e0\u00132\u0006\u0010\u0014\u001a\u0002H\u00122\"\u0010\u0007\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0010H\u00a6\u0002\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015JS\u0010\u000b\u001a\u00020\u0004\"\u0004\b\u0001\u0010\u0012\"\u0004\b\u0002\u0010\u000e*\u0010\u0012\u0006\u0012\u0004\u0018\u0001H\u0012\u0012\u0004\u0012\u0002H\u000e0\u00132\"\u0010\u0007\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0010H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilder;", BdhLogUtil.LogTag.Tag_Req, "", "onTimeout", "", "timeMillis", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(JLkotlin/jvm/functions/Function1;)V", "invoke", "Lkotlinx/coroutines/selects/SelectClause0;", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "P", "Lkotlinx/coroutines/selects/SelectClause2;", "param", "(Lkotlinx/coroutines/selects/SelectClause2;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "(Lkotlinx/coroutines/selects/SelectClause2;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public interface SelectBuilder<R> {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static <R, P, Q> void invoke(@NotNull SelectBuilder<? super R> selectBuilder, @NotNull SelectClause2<? super P, ? extends Q> selectClause2, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
            selectBuilder.invoke(selectClause2, null, function2);
        }
    }

    void invoke(@NotNull SelectClause0 selectClause0, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1);

    <Q> void invoke(@NotNull SelectClause1<? extends Q> selectClause1, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2);

    <P, Q> void invoke(@NotNull SelectClause2<? super P, ? extends Q> selectClause2, P p16, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2);

    <P, Q> void invoke(@NotNull SelectClause2<? super P, ? extends Q> selectClause2, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2);

    @ExperimentalCoroutinesApi
    void onTimeout(long timeMillis, @NotNull Function1<? super Continuation<? super R>, ? extends Object> block);
}
