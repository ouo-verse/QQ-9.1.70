package kotlinx.coroutines.channels;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.selects.SelectClause1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u001a\u001a\u0010\u0002\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0001\u001aC\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u0002H\t0\n2\u001d\u0010\u000b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u0004\u0012\u0004\u0012\u0002H\b0\f\u00a2\u0006\u0002\b\rH\u0087\b\u00a2\u0006\u0002\u0010\u000e\u001aP\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u0002H\t0\u00042\u001d\u0010\u000b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u0004\u0012\u0004\u0012\u0002H\b0\f\u00a2\u0006\u0002\b\rH\u0086\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0002\u0010\u000f\u001a5\u0010\u0010\u001a\u00020\u0003\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\n2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00030\fH\u0087H\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012\u001a5\u0010\u0010\u001a\u00020\u0003\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00030\fH\u0086H\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013\u001a$\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\t0\u0015\"\b\b\u0000\u0010\t*\u00020\u0016*\b\u0012\u0004\u0012\u0002H\t0\u0004H\u0007\u001a'\u0010\u0017\u001a\u0004\u0018\u0001H\t\"\b\b\u0000\u0010\t*\u00020\u0016*\b\u0012\u0004\u0012\u0002H\t0\u0004H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018\u001a'\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\t0\u001a\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"DEFAULT_CLOSE_MESSAGE", "", "cancelConsumed", "", "Lkotlinx/coroutines/channels/ReceiveChannel;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "", "consume", BdhLogUtil.LogTag.Tag_Req, "E", "Lkotlinx/coroutines/channels/BroadcastChannel;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/channels/BroadcastChannel;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "consumeEach", "action", "(Lkotlinx/coroutines/channels/BroadcastChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onReceiveOrNull", "Lkotlinx/coroutines/selects/SelectClause1;", "", "receiveOrNull", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toList", "", "kotlinx-coroutines-core"}, k = 5, mv = {1, 5, 1}, xi = 48, xs = "kotlinx/coroutines/channels/ChannelsKt")
/* loaded from: classes28.dex */
public final /* synthetic */ class ChannelsKt__Channels_commonKt {
    @PublishedApi
    public static final void cancelConsumed(@NotNull ReceiveChannel<?> receiveChannel, @Nullable Throwable th5) {
        CancellationException cancellationException = null;
        if (th5 != null) {
            if (th5 instanceof CancellationException) {
                cancellationException = (CancellationException) th5;
            }
            if (cancellationException == null) {
                cancellationException = ExceptionsKt.CancellationException("Channel was consumed, consumer had failed", th5);
            }
        }
        receiveChannel.cancel(cancellationException);
    }

    @ObsoleteCoroutinesApi
    public static final <E, R> R consume(@NotNull BroadcastChannel<E> broadcastChannel, @NotNull Function1<? super ReceiveChannel<? extends E>, ? extends R> function1) {
        ReceiveChannel<E> openSubscription = broadcastChannel.openSubscription();
        try {
            return function1.invoke(openSubscription);
        } finally {
            InlineMarker.finallyStart(1);
            ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) openSubscription, (CancellationException) null, 1, (Object) null);
            InlineMarker.finallyEnd(1);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0065 A[Catch: all -> 0x0035, TryCatch #1 {all -> 0x0035, blocks: (B:11:0x0031, B:12:0x005d, B:14:0x0065, B:15:0x004b, B:20:0x006e), top: B:10:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0059 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006e A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #1 {all -> 0x0035, blocks: (B:11:0x0031, B:12:0x005d, B:14:0x0065, B:15:0x004b, B:20:0x006e), top: B:10:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005a -> B:12:0x005d). Please report as a decompilation issue!!! */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object consumeEach(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Function1<? super E, Unit> function1, @NotNull Continuation<? super Unit> continuation) {
        ChannelsKt__Channels_commonKt$consumeEach$1 channelsKt__Channels_commonKt$consumeEach$1;
        Object coroutine_suspended;
        int i3;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th5;
        ChannelIterator it;
        Function1<? super E, Unit> function12;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$consumeEach$1) {
            channelsKt__Channels_commonKt$consumeEach$1 = (ChannelsKt__Channels_commonKt$consumeEach$1) continuation;
            int i16 = channelsKt__Channels_commonKt$consumeEach$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$consumeEach$1.label = i16 - Integer.MIN_VALUE;
                Object obj = channelsKt__Channels_commonKt$consumeEach$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = channelsKt__Channels_commonKt$consumeEach$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        receiveChannel2 = receiveChannel;
                        it = receiveChannel.iterator();
                        function12 = function1;
                        channelsKt__Channels_commonKt$consumeEach$1.L$0 = function12;
                        channelsKt__Channels_commonKt$consumeEach$1.L$1 = receiveChannel2;
                        channelsKt__Channels_commonKt$consumeEach$1.L$2 = it;
                        channelsKt__Channels_commonKt$consumeEach$1.label = 1;
                        hasNext = it.hasNext(channelsKt__Channels_commonKt$consumeEach$1);
                        if (hasNext != coroutine_suspended) {
                        }
                    } catch (Throwable th6) {
                        receiveChannel2 = receiveChannel;
                        th5 = th6;
                        throw th5;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it = (ChannelIterator) channelsKt__Channels_commonKt$consumeEach$1.L$2;
                    receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEach$1.L$1;
                    Function1<? super E, Unit> function13 = (Function1) channelsKt__Channels_commonKt$consumeEach$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        if (!((Boolean) obj).booleanValue()) {
                            function13.invoke((Object) it.next());
                            function12 = function13;
                            channelsKt__Channels_commonKt$consumeEach$1.L$0 = function12;
                            channelsKt__Channels_commonKt$consumeEach$1.L$1 = receiveChannel2;
                            channelsKt__Channels_commonKt$consumeEach$1.L$2 = it;
                            channelsKt__Channels_commonKt$consumeEach$1.label = 1;
                            hasNext = it.hasNext(channelsKt__Channels_commonKt$consumeEach$1);
                            if (hasNext != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            function13 = function12;
                            obj = hasNext;
                            if (!((Boolean) obj).booleanValue()) {
                                Unit unit = Unit.INSTANCE;
                                InlineMarker.finallyStart(1);
                                ChannelsKt.cancelConsumed(receiveChannel2, null);
                                InlineMarker.finallyEnd(1);
                                return Unit.INSTANCE;
                            }
                        }
                    } catch (Throwable th7) {
                        th5 = th7;
                        try {
                            throw th5;
                        } catch (Throwable th8) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th5);
                            InlineMarker.finallyEnd(1);
                            throw th8;
                        }
                    }
                }
            }
        }
        channelsKt__Channels_commonKt$consumeEach$1 = new ChannelsKt__Channels_commonKt$consumeEach$1(continuation);
        Object obj2 = channelsKt__Channels_commonKt$consumeEach$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = channelsKt__Channels_commonKt$consumeEach$1.label;
        if (i3 != 0) {
        }
    }

    private static final <E> Object consumeEach$$forInline(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Unit> function1, Continuation<? super Unit> continuation) {
        try {
            ChannelIterator<? extends E> it = receiveChannel.iterator();
            while (true) {
                InlineMarker.mark(3);
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(null);
                InlineMarker.mark(1);
                if (!((Boolean) hasNext).booleanValue()) {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, null);
                    InlineMarker.finallyEnd(1);
                    return Unit.INSTANCE;
                }
                function1.invoke(it.next());
            }
        } finally {
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in the favour of 'onReceiveCatching'")
    @NotNull
    public static final <E> SelectClause1<E> onReceiveOrNull(@NotNull ReceiveChannel<? extends E> receiveChannel) {
        return receiveChannel.getOnReceiveOrNull();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in the favour of 'receiveCatching'", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    @Nullable
    public static final <E> Object receiveOrNull(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Continuation<? super E> continuation) {
        return receiveChannel.receiveOrNull(continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0070 A[Catch: all -> 0x0039, TryCatch #2 {all -> 0x0039, blocks: (B:11:0x0035, B:12:0x0068, B:14:0x0070, B:29:0x0079), top: B:10:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0064 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0079 A[Catch: all -> 0x0039, TRY_LEAVE, TryCatch #2 {all -> 0x0039, blocks: (B:11:0x0035, B:12:0x0068, B:14:0x0070, B:29:0x0079), top: B:10:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0065 -> B:12:0x0068). Please report as a decompilation issue!!! */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object toList(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Continuation<? super List<? extends E>> continuation) {
        ChannelsKt__Channels_commonKt$toList$1 channelsKt__Channels_commonKt$toList$1;
        Object coroutine_suspended;
        int i3;
        List createListBuilder;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th5;
        List list;
        ChannelIterator it;
        List list2;
        Object hasNext;
        List build;
        if (continuation instanceof ChannelsKt__Channels_commonKt$toList$1) {
            channelsKt__Channels_commonKt$toList$1 = (ChannelsKt__Channels_commonKt$toList$1) continuation;
            int i16 = channelsKt__Channels_commonKt$toList$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$toList$1.label = i16 - Integer.MIN_VALUE;
                Object obj = channelsKt__Channels_commonKt$toList$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = channelsKt__Channels_commonKt$toList$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        it = (ChannelIterator) channelsKt__Channels_commonKt$toList$1.L$3;
                        ReceiveChannel<? extends E> receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$toList$1.L$2;
                        List list3 = (List) channelsKt__Channels_commonKt$toList$1.L$1;
                        list = (List) channelsKt__Channels_commonKt$toList$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            List list4 = list3;
                            if (!((Boolean) obj).booleanValue()) {
                                list4.add(it.next());
                                receiveChannel2 = receiveChannel3;
                                list2 = list4;
                                try {
                                    channelsKt__Channels_commonKt$toList$1.L$0 = list;
                                    channelsKt__Channels_commonKt$toList$1.L$1 = list2;
                                    channelsKt__Channels_commonKt$toList$1.L$2 = receiveChannel2;
                                    channelsKt__Channels_commonKt$toList$1.L$3 = it;
                                    channelsKt__Channels_commonKt$toList$1.label = 1;
                                    hasNext = it.hasNext(channelsKt__Channels_commonKt$toList$1);
                                    if (hasNext != coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    receiveChannel3 = receiveChannel2;
                                    obj = hasNext;
                                    list4 = list2;
                                    if (!((Boolean) obj).booleanValue()) {
                                        Unit unit = Unit.INSTANCE;
                                        ChannelsKt.cancelConsumed(receiveChannel3, null);
                                        build = CollectionsKt__CollectionsJVMKt.build(list);
                                        return build;
                                    }
                                } catch (Throwable th6) {
                                    th5 = th6;
                                    try {
                                        throw th5;
                                    } catch (Throwable th7) {
                                        ChannelsKt.cancelConsumed(receiveChannel2, th5);
                                        throw th7;
                                    }
                                }
                            }
                        } catch (Throwable th8) {
                            th5 = th8;
                            receiveChannel2 = receiveChannel3;
                            throw th5;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    createListBuilder = CollectionsKt__CollectionsJVMKt.createListBuilder();
                    try {
                        List list5 = createListBuilder;
                        list = list5;
                        receiveChannel2 = receiveChannel;
                        it = receiveChannel.iterator();
                        list2 = list5;
                        channelsKt__Channels_commonKt$toList$1.L$0 = list;
                        channelsKt__Channels_commonKt$toList$1.L$1 = list2;
                        channelsKt__Channels_commonKt$toList$1.L$2 = receiveChannel2;
                        channelsKt__Channels_commonKt$toList$1.L$3 = it;
                        channelsKt__Channels_commonKt$toList$1.label = 1;
                        hasNext = it.hasNext(channelsKt__Channels_commonKt$toList$1);
                        if (hasNext != coroutine_suspended) {
                        }
                    } catch (Throwable th9) {
                        receiveChannel2 = receiveChannel;
                        th5 = th9;
                        throw th5;
                    }
                }
            }
        }
        channelsKt__Channels_commonKt$toList$1 = new ChannelsKt__Channels_commonKt$toList$1(continuation);
        Object obj2 = channelsKt__Channels_commonKt$toList$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = channelsKt__Channels_commonKt$toList$1.label;
        if (i3 == 0) {
        }
    }

    public static final <E, R> R consume(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Function1<? super ReceiveChannel<? extends E>, ? extends R> function1) {
        try {
            R invoke = function1.invoke(receiveChannel);
            InlineMarker.finallyStart(1);
            ChannelsKt.cancelConsumed(receiveChannel, null);
            InlineMarker.finallyEnd(1);
            return invoke;
        } finally {
        }
    }

    @ObsoleteCoroutinesApi
    private static final <E> Object consumeEach$$forInline(BroadcastChannel<E> broadcastChannel, Function1<? super E, Unit> function1, Continuation<? super Unit> continuation) {
        ReceiveChannel<E> openSubscription = broadcastChannel.openSubscription();
        try {
            ChannelIterator<E> it = openSubscription.iterator();
            while (true) {
                InlineMarker.mark(3);
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(null);
                InlineMarker.mark(1);
                if (!((Boolean) hasNext).booleanValue()) {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) openSubscription, (CancellationException) null, 1, (Object) null);
                    InlineMarker.finallyEnd(1);
                    return Unit.INSTANCE;
                }
                function1.invoke(it.next());
            }
        } catch (Throwable th5) {
            InlineMarker.finallyStart(1);
            ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) openSubscription, (CancellationException) null, 1, (Object) null);
            InlineMarker.finallyEnd(1);
            throw th5;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006f A[Catch: all -> 0x0088, TryCatch #0 {all -> 0x0088, blocks: (B:15:0x0067, B:17:0x006f, B:29:0x007a), top: B:14:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0062 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007a A[Catch: all -> 0x0088, TRY_LEAVE, TryCatch #0 {all -> 0x0088, blocks: (B:15:0x0067, B:17:0x006f, B:29:0x007a), top: B:14:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0063 -> B:13:0x0038). Please report as a decompilation issue!!! */
    @ObsoleteCoroutinesApi
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object consumeEach(@NotNull BroadcastChannel<E> broadcastChannel, @NotNull Function1<? super E, Unit> function1, @NotNull Continuation<? super Unit> continuation) {
        ChannelsKt__Channels_commonKt$consumeEach$3 channelsKt__Channels_commonKt$consumeEach$3;
        Object coroutine_suspended;
        int i3;
        ReceiveChannel<E> receiveChannel;
        Throwable th5;
        ReceiveChannel<E> receiveChannel2;
        ChannelIterator it;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$consumeEach$3) {
            channelsKt__Channels_commonKt$consumeEach$3 = (ChannelsKt__Channels_commonKt$consumeEach$3) continuation;
            int i16 = channelsKt__Channels_commonKt$consumeEach$3.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$consumeEach$3.label = i16 - Integer.MIN_VALUE;
                Object obj = channelsKt__Channels_commonKt$consumeEach$3.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = channelsKt__Channels_commonKt$consumeEach$3.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    ReceiveChannel<E> openSubscription = broadcastChannel.openSubscription();
                    try {
                        receiveChannel2 = openSubscription;
                        it = openSubscription.iterator();
                        channelsKt__Channels_commonKt$consumeEach$3.L$0 = function1;
                        channelsKt__Channels_commonKt$consumeEach$3.L$1 = receiveChannel2;
                        channelsKt__Channels_commonKt$consumeEach$3.L$2 = it;
                        channelsKt__Channels_commonKt$consumeEach$3.label = 1;
                        hasNext = it.hasNext(channelsKt__Channels_commonKt$consumeEach$3);
                        if (hasNext != coroutine_suspended) {
                        }
                    } catch (Throwable th6) {
                        receiveChannel = openSubscription;
                        th5 = th6;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it = (ChannelIterator) channelsKt__Channels_commonKt$consumeEach$3.L$2;
                    receiveChannel = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEach$3.L$1;
                    Function1<? super E, Unit> function12 = (Function1) channelsKt__Channels_commonKt$consumeEach$3.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        ChannelsKt__Channels_commonKt$consumeEach$3 channelsKt__Channels_commonKt$consumeEach$32 = channelsKt__Channels_commonKt$consumeEach$3;
                        ReceiveChannel<E> receiveChannel3 = receiveChannel;
                        function1 = function12;
                        Object obj2 = coroutine_suspended;
                        ChannelsKt__Channels_commonKt$consumeEach$3 channelsKt__Channels_commonKt$consumeEach$33 = channelsKt__Channels_commonKt$consumeEach$32;
                        try {
                            if (!((Boolean) obj).booleanValue()) {
                                function1.invoke((Object) it.next());
                                receiveChannel2 = receiveChannel3;
                                channelsKt__Channels_commonKt$consumeEach$3 = channelsKt__Channels_commonKt$consumeEach$33;
                                coroutine_suspended = obj2;
                                try {
                                    channelsKt__Channels_commonKt$consumeEach$3.L$0 = function1;
                                    channelsKt__Channels_commonKt$consumeEach$3.L$1 = receiveChannel2;
                                    channelsKt__Channels_commonKt$consumeEach$3.L$2 = it;
                                    channelsKt__Channels_commonKt$consumeEach$3.label = 1;
                                    hasNext = it.hasNext(channelsKt__Channels_commonKt$consumeEach$3);
                                    if (hasNext != coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    channelsKt__Channels_commonKt$consumeEach$32 = channelsKt__Channels_commonKt$consumeEach$3;
                                    receiveChannel3 = receiveChannel2;
                                    obj = hasNext;
                                    Object obj22 = coroutine_suspended;
                                    ChannelsKt__Channels_commonKt$consumeEach$3 channelsKt__Channels_commonKt$consumeEach$332 = channelsKt__Channels_commonKt$consumeEach$32;
                                    if (!((Boolean) obj).booleanValue()) {
                                        Unit unit = Unit.INSTANCE;
                                        InlineMarker.finallyStart(1);
                                        ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) receiveChannel3, (CancellationException) null, 1, (Object) null);
                                        InlineMarker.finallyEnd(1);
                                        return Unit.INSTANCE;
                                    }
                                } catch (Throwable th7) {
                                    th5 = th7;
                                    receiveChannel = receiveChannel2;
                                }
                            }
                        } catch (Throwable th8) {
                            th5 = th8;
                            receiveChannel = receiveChannel3;
                        }
                    } catch (Throwable th9) {
                        th5 = th9;
                    }
                }
                InlineMarker.finallyStart(1);
                ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) receiveChannel, (CancellationException) null, 1, (Object) null);
                InlineMarker.finallyEnd(1);
                throw th5;
            }
        }
        channelsKt__Channels_commonKt$consumeEach$3 = new ChannelsKt__Channels_commonKt$consumeEach$3(continuation);
        Object obj3 = channelsKt__Channels_commonKt$consumeEach$3.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = channelsKt__Channels_commonKt$consumeEach$3.label;
        if (i3 != 0) {
        }
        InlineMarker.finallyStart(1);
        ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) receiveChannel, (CancellationException) null, 1, (Object) null);
        InlineMarker.finallyEnd(1);
        throw th5;
    }
}
