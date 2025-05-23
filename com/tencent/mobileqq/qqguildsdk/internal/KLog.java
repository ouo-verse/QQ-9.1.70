package com.tencent.mobileqq.qqguildsdk.internal;

import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J;\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0006\"\u00020\u0001H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ9\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0006\"\u00020\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u000b\u0010\fJ9\u0010\r\u001a\u00020\n2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0006\"\u00020\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\r\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/internal/KLog;", "", "", "subTag", "", "seq", "", "msg", "e", "(Ljava/lang/String;Ljava/lang/Integer;[Ljava/lang/Object;)Ljava/lang/String;", "", "d", "(Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Integer;)V", "b", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "getCurSeq", "()Ljava/util/concurrent/atomic/AtomicInteger;", "curSeq", "<init>", "()V", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class KLog {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final KLog f268416a = new KLog();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final AtomicInteger curSeq = new AtomicInteger(0);

    KLog() {
    }

    public static /* synthetic */ void c(KLog kLog, String str, Object[] objArr, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        if ((i3 & 4) != 0) {
            num = null;
        }
        kLog.b(str, objArr, num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String e(String subTag, Integer seq, Object... msg2) {
        int incrementAndGet;
        String joinToString$default;
        if (seq != null) {
            incrementAndGet = seq.intValue();
        } else {
            incrementAndGet = curSeq.incrementAndGet();
        }
        joinToString$default = ArraysKt___ArraysKt.joinToString$default(msg2, (CharSequence) null, "[" + subTag + "]seq(" + incrementAndGet + ")---- ", (CharSequence) null, 0, (CharSequence) null, new Function1<Object, CharSequence>() { // from class: com.tencent.mobileqq.qqguildsdk.internal.KLog$joinLogString$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.toString();
            }
        }, 29, (Object) null);
        return joinToString$default;
    }

    public final void b(@Nullable String subTag, @NotNull Object[] msg2, @Nullable Integer seq) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (QLog.isColorLevel()) {
            QLog.d("NTKernel", 2, f268416a.e(subTag, seq, Arrays.copyOf(msg2, msg2.length)));
        }
    }

    public final void d(@Nullable String subTag, @NotNull Object[] msg2, @Nullable Integer seq) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (QLog.isDevelopLevel()) {
            QLog.d("NTKernel", 4, f268416a.e(subTag, seq, Arrays.copyOf(msg2, msg2.length)));
        }
    }
}
