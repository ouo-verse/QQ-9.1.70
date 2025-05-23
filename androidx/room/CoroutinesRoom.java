package androidx.room;

import android.os.CancellationSignal;
import androidx.annotation.RestrictTo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Landroidx/room/CoroutinesRoom;", "", "()V", "Companion", "room-ktx_release"}, k = 1, mv = {1, 4, 2})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class CoroutinesRoom {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002JJ\u0010\u0003\u001a\r\u0012\t\u0012\u0007H\u0005\u00a2\u0006\u0002\b\u00060\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000fH\u0007\u00a2\u0006\u0002\u0010\u0010J=\u0010\u0011\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000fH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J5\u0010\u0011\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000fH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Landroidx/room/CoroutinesRoom$Companion;", "", "()V", "createFlow", "Lkotlinx/coroutines/flow/Flow;", BdhLogUtil.LogTag.Tag_Req, "Lkotlin/jvm/JvmSuppressWildcards;", TVKNetVideoInfo.AUDIO_TRACK_DOLBY, "Landroidx/room/RoomDatabase;", "inTransaction", "", "tableNames", "", "", "callable", "Ljava/util/concurrent/Callable;", "(Landroidx/room/RoomDatabase;Z[Ljava/lang/String;Ljava/util/concurrent/Callable;)Lkotlinx/coroutines/flow/Flow;", "execute", "cancellationSignal", "Landroid/os/CancellationSignal;", "(Landroidx/room/RoomDatabase;ZLandroid/os/CancellationSignal;Ljava/util/concurrent/Callable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroidx/room/RoomDatabase;ZLjava/util/concurrent/Callable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "room-ktx_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes.dex */
    public static final class Companion {
        Companion() {
        }

        @JvmStatic
        @NotNull
        public final <R> Flow<R> createFlow(@NotNull RoomDatabase db5, boolean inTransaction, @NotNull String[] tableNames, @NotNull Callable<R> callable) {
            Intrinsics.checkNotNullParameter(db5, "db");
            Intrinsics.checkNotNullParameter(tableNames, "tableNames");
            Intrinsics.checkNotNullParameter(callable, "callable");
            return FlowKt.flow(new CoroutinesRoom$Companion$createFlow$1(tableNames, inTransaction, db5, callable, null));
        }

        @JvmStatic
        @Nullable
        public final <R> Object execute(@NotNull RoomDatabase roomDatabase, boolean z16, @NotNull Callable<R> callable, @NotNull Continuation<? super R> continuation) {
            ContinuationInterceptor transactionDispatcher;
            if (roomDatabase.isOpen() && roomDatabase.inTransaction()) {
                return callable.call();
            }
            TransactionElement transactionElement = (TransactionElement) continuation.get$context().get(TransactionElement.INSTANCE);
            if (transactionElement == null || (transactionDispatcher = transactionElement.getTransactionDispatcher()) == null) {
                transactionDispatcher = z16 ? CoroutinesRoomKt.getTransactionDispatcher(roomDatabase) : CoroutinesRoomKt.getQueryDispatcher(roomDatabase);
            }
            return BuildersKt.withContext(transactionDispatcher, new CoroutinesRoom$Companion$execute$2(callable, null), continuation);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Nullable
        public final <R> Object execute(@NotNull RoomDatabase roomDatabase, boolean z16, @NotNull final CancellationSignal cancellationSignal, @NotNull final Callable<R> callable, @NotNull Continuation<? super R> continuation) {
            final ContinuationInterceptor transactionDispatcher;
            Continuation intercepted;
            final Job launch$default;
            Object coroutine_suspended;
            if (roomDatabase.isOpen() && roomDatabase.inTransaction()) {
                return callable.call();
            }
            TransactionElement transactionElement = (TransactionElement) continuation.get$context().get(TransactionElement.INSTANCE);
            if (transactionElement == null || (transactionDispatcher = transactionElement.getTransactionDispatcher()) == null) {
                transactionDispatcher = z16 ? CoroutinesRoomKt.getTransactionDispatcher(roomDatabase) : CoroutinesRoomKt.getQueryDispatcher(roomDatabase);
            }
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            launch$default = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, transactionDispatcher, null, new CoroutinesRoom$Companion$execute$$inlined$suspendCancellableCoroutine$lambda$1(cancellableContinuationImpl, null, transactionDispatcher, callable, cancellationSignal), 2, null);
            cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.room.CoroutinesRoom$Companion$execute$$inlined$suspendCancellableCoroutine$lambda$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                    invoke2(th5);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Throwable th5) {
                    cancellationSignal.cancel();
                    Job.DefaultImpls.cancel$default(Job.this, (CancellationException) null, 1, (Object) null);
                }
            });
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }
    }

    CoroutinesRoom() {
    }

    @JvmStatic
    @NotNull
    public static final <R> Flow<R> createFlow(@NotNull RoomDatabase roomDatabase, boolean z16, @NotNull String[] strArr, @NotNull Callable<R> callable) {
        return INSTANCE.createFlow(roomDatabase, z16, strArr, callable);
    }

    @JvmStatic
    @Nullable
    public static final <R> Object execute(@NotNull RoomDatabase roomDatabase, boolean z16, @NotNull CancellationSignal cancellationSignal, @NotNull Callable<R> callable, @NotNull Continuation<? super R> continuation) {
        return INSTANCE.execute(roomDatabase, z16, cancellationSignal, callable, continuation);
    }

    @JvmStatic
    @Nullable
    public static final <R> Object execute(@NotNull RoomDatabase roomDatabase, boolean z16, @NotNull Callable<R> callable, @NotNull Continuation<? super R> continuation) {
        return INSTANCE.execute(roomDatabase, z16, callable, continuation);
    }
}
