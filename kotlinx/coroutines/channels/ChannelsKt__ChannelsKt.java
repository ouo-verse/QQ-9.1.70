package kotlinx.coroutines.channels;

import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.channels.ChannelResult;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u0007\u00a2\u0006\u0002\u0010\u0005\u001a,\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\t"}, d2 = {"sendBlocking", "", "E", "Lkotlinx/coroutines/channels/SendChannel;", DTConstants.TAG.ELEMENT, "(Lkotlinx/coroutines/channels/SendChannel;Ljava/lang/Object;)V", "trySendBlocking", "Lkotlinx/coroutines/channels/ChannelResult;", "(Lkotlinx/coroutines/channels/SendChannel;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 5, 1}, xi = 48, xs = "kotlinx/coroutines/channels/ChannelsKt")
/* loaded from: classes28.dex */
public final /* synthetic */ class ChannelsKt__ChannelsKt {
    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in the favour of 'trySendBlocking'. Consider handling the result of 'trySendBlocking' explicitly and rethrow exception if necessary", replaceWith = @ReplaceWith(expression = "trySendBlocking(element)", imports = {}))
    public static final <E> void sendBlocking(@NotNull SendChannel<? super E> sendChannel, E e16) {
        if (!ChannelResult.m2018isSuccessimpl(sendChannel.mo2003trySendJP2dKIU(e16))) {
            BuildersKt__BuildersKt.runBlocking$default(null, new ChannelsKt__ChannelsKt$sendBlocking$1(sendChannel, e16, null), 1, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <E> Object trySendBlocking(@NotNull SendChannel<? super E> sendChannel, E e16) throws InterruptedException {
        Object runBlocking$default;
        Object mo2003trySendJP2dKIU = sendChannel.mo2003trySendJP2dKIU(e16);
        if (mo2003trySendJP2dKIU instanceof ChannelResult.Failed) {
            runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new ChannelsKt__ChannelsKt$trySendBlocking$2(sendChannel, e16, null), 1, null);
            return ((ChannelResult) runBlocking$default).getHolder();
        }
        return ChannelResult.INSTANCE.m2023successJP2dKIU(Unit.INSTANCE);
    }
}
