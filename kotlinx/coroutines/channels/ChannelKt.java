package kotlinx.coroutines.channels;

import com.tencent.mobileqq.qqguildsdk.data.genc.GGProSourceInfoBid;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.ChannelResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0007\u001a>\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u001aX\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\f2#\u0010\r\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u0002H\u000b0\bH\u0086\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013\u001a^\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u000b0\f\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\f2#\u0010\u0015\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\t0\bH\u0086\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\u00a2\u0006\u0004\b\u0016\u0010\u0013\u001a^\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\f\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\f2#\u0010\u0015\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\t0\bH\u0086\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\u00a2\u0006\u0004\b\u0017\u0010\u0013\u001a\\\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u000b0\f\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\f2!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u0011H\u000b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\t0\bH\u0086\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\u00a2\u0006\u0004\b\u001a\u0010\u0013\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u001b"}, d2 = {GGProSourceInfoBid.CHANNEL, "Lkotlinx/coroutines/channels/Channel;", "E", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "onUndeliveredElement", "Lkotlin/Function1;", "", "getOrElse", "T", "Lkotlinx/coroutines/channels/ChannelResult;", "onFailure", "", "Lkotlin/ParameterName;", "name", "exception", "getOrElse-WpGqRn0", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "onClosed", "action", "onClosed-WpGqRn0", "onFailure-WpGqRn0", "onSuccess", "value", "onSuccess-WpGqRn0", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class ChannelKt {
    @NotNull
    public static final <E> Channel<E> Channel(int i3, @NotNull BufferOverflow bufferOverflow, @Nullable Function1<? super E, Unit> function1) {
        if (i3 == -2) {
            return new ArrayChannel(bufferOverflow == BufferOverflow.SUSPEND ? Channel.INSTANCE.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core() : 1, bufferOverflow, function1);
        }
        if (i3 == -1) {
            if ((bufferOverflow != BufferOverflow.SUSPEND ? 0 : 1) != 0) {
                return new ConflatedChannel(function1);
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        }
        if (i3 == 0) {
            if (bufferOverflow == BufferOverflow.SUSPEND) {
                return new RendezvousChannel(function1);
            }
            return new ArrayChannel(1, bufferOverflow, function1);
        }
        if (i3 != Integer.MAX_VALUE) {
            if (i3 == 1 && bufferOverflow == BufferOverflow.DROP_OLDEST) {
                return new ConflatedChannel(function1);
            }
            return new ArrayChannel(i3, bufferOverflow, function1);
        }
        return new LinkedListChannel(function1);
    }

    public static /* synthetic */ Channel Channel$default(int i3, BufferOverflow bufferOverflow, Function1 function1, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 0;
        }
        if ((i16 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        if ((i16 & 4) != 0) {
            function1 = null;
        }
        return Channel(i3, bufferOverflow, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOrElse-WpGqRn0, reason: not valid java name */
    public static final <T> T m2004getOrElseWpGqRn0(@NotNull Object obj, @NotNull Function1<? super Throwable, ? extends T> function1) {
        if (obj instanceof ChannelResult.Failed) {
            return function1.invoke(ChannelResult.m2012exceptionOrNullimpl(obj));
        }
        return obj;
    }

    @NotNull
    /* renamed from: onClosed-WpGqRn0, reason: not valid java name */
    public static final <T> Object m2005onClosedWpGqRn0(@NotNull Object obj, @NotNull Function1<? super Throwable, Unit> function1) {
        if (obj instanceof ChannelResult.Closed) {
            function1.invoke(ChannelResult.m2012exceptionOrNullimpl(obj));
        }
        return obj;
    }

    @NotNull
    /* renamed from: onFailure-WpGqRn0, reason: not valid java name */
    public static final <T> Object m2006onFailureWpGqRn0(@NotNull Object obj, @NotNull Function1<? super Throwable, Unit> function1) {
        if (obj instanceof ChannelResult.Failed) {
            function1.invoke(ChannelResult.m2012exceptionOrNullimpl(obj));
        }
        return obj;
    }

    @NotNull
    /* renamed from: onSuccess-WpGqRn0, reason: not valid java name */
    public static final <T> Object m2007onSuccessWpGqRn0(@NotNull Object obj, @NotNull Function1<? super T, Unit> function1) {
        if (!(obj instanceof ChannelResult.Failed)) {
            function1.invoke(obj);
        }
        return obj;
    }

    public static /* synthetic */ Channel Channel$default(int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 0;
        }
        return Channel$default(i3, null, null, 6, null);
    }
}
