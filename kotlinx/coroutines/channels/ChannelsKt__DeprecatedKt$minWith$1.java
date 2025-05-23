package kotlinx.coroutines.channels;

import com.heytap.databaseengine.apiv3.data.Element;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {369, 371}, m = "minWith", n = {"comparator", "iterator", "iterator", Element.ELEMENT_NAME_MIN}, s = {"L$0", "L$2", "L$2", "L$3"})
/* loaded from: classes28.dex */
public final class ChannelsKt__DeprecatedKt$minWith$1<E> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelsKt__DeprecatedKt$minWith$1(Continuation<? super ChannelsKt__DeprecatedKt$minWith$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object minWith;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        minWith = ChannelsKt__DeprecatedKt.minWith(null, null, this);
        return minWith;
    }
}
