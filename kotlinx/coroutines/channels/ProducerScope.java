package kotlinx.coroutines.channels;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003R\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "E", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/channels/SendChannel;", WadlProxyConsts.CHANNEL, "getChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
@ExperimentalCoroutinesApi
/* loaded from: classes28.dex */
public interface ProducerScope<E> extends CoroutineScope, SendChannel<E> {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static final class DefaultImpls {
        @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
        public static <E> boolean offer(@NotNull ProducerScope<? super E> producerScope, E e16) {
            return SendChannel.DefaultImpls.offer(producerScope, e16);
        }
    }

    @NotNull
    SendChannel<E> getChannel();
}
