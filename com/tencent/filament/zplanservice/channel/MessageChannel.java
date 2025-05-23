package com.tencent.filament.zplanservice.channel;

import androidx.annotation.Keep;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.filament.zplanservice.channel.handler.annotation.EventName;
import com.tencent.filament.zplanservice.pbjava.MessageChannelErrorCode$MessageChannelError;
import com.tencent.filament.zplanservice.pbjava.MessageChannelErrorCode$MessageResponse;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBUInt64Field;
import io.github.landerlyoung.jenny.NativeMethodProxy;
import io.github.landerlyoung.jenny.NativeProxy;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@NativeProxy(allFields = false, allMethods = false)
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J2\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0018\u0010\u0015\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\n0\bj\u0002`\u000bJC\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0017\u001a\u00020\u00072\u001e\u0010\u0018\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\u0019j\u0002`\u001aH\u0082 J\u001b\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0082 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R,\u0010\u0005\u001a \u0012\u0004\u0012\u00020\u0007\u0012\u0016\u0012\u0014\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\n0\bj\u0002`\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/filament/zplanservice/channel/MessageChannel;", "", "()V", "TAG", "", "messageN2CCallbackMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlin/Function1;", "Lcom/tencent/filament/zplanservice/pbjava/MessageChannelErrorCode$MessageResponse;", "", "Lcom/tencent/filament/zplanservice/channel/CallbackC2N;", "messageN2CIndex", "Ljava/util/concurrent/atomic/AtomicLong;", "callC2N", AdMetricTag.EVENT_NAME, "data", "", "callbackN2CId", "", "callN2C", "callbackC2N", "nCallN2C", "index", "callback", "Lkotlin/Function2;", "Lcom/tencent/filament/zplanservice/channel/JniCallbackC2N;", "nCallbackN2C", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class MessageChannel {
    private static final String TAG = "MessageChannel";

    @NotNull
    public static final MessageChannel INSTANCE = new MessageChannel();
    private static final AtomicLong messageN2CIndex = new AtomicLong(0);
    private static final ConcurrentHashMap<Long, Function1<MessageChannelErrorCode$MessageResponse, Unit>> messageN2CCallbackMap = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002\u00a8\u0006\u0006"}, d2 = {"com/tencent/filament/zplanservice/channel/MessageChannel$a", "Lcom/tencent/filament/zplanservice/channel/a;", "Lcom/tencent/filament/zplanservice/pbjava/MessageChannelErrorCode$MessageResponse;", "data", "", "a", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class a implements com.tencent.filament.zplanservice.channel.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f106350a;

        a(int i3) {
            this.f106350a = i3;
        }

        @Override // com.tencent.filament.zplanservice.channel.a
        public void a(@Nullable MessageChannelErrorCode$MessageResponse data) {
            byte[] bArr;
            MessageChannel messageChannel = MessageChannel.INSTANCE;
            int i3 = this.f106350a;
            if (data != null) {
                bArr = data.toByteArray();
            } else {
                bArr = null;
            }
            messageChannel.nCallbackN2C(i3, bArr);
        }
    }

    MessageChannel() {
    }

    @JvmStatic
    @Keep
    @NativeMethodProxy
    public static final void callC2N(@NotNull String eventName, @Nullable byte[] data, int callbackN2CId) {
        Function3<String, MessageMicro<?>, com.tencent.filament.zplanservice.channel.a, Unit> function3;
        String str;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        try {
            a aVar = new a(callbackN2CId);
            d dVar = d.f106356d;
            Object obj = dVar.b().get(eventName);
            Object obj2 = null;
            if (obj != null) {
                ConcurrentHashMap<String, Method> a16 = dVar.a();
                Method method = a16.get(eventName);
                if (method == null) {
                    Method[] declaredMethods = obj.getClass().getDeclaredMethods();
                    Intrinsics.checkNotNullExpressionValue(declaredMethods, "handler.javaClass.declaredMethods");
                    for (Method method2 : declaredMethods) {
                        EventName eventName2 = (EventName) method2.getAnnotation(EventName.class);
                        if (eventName2 != null) {
                            str = eventName2.name();
                        } else {
                            str = null;
                        }
                        if (Intrinsics.areEqual(str, eventName)) {
                            Method putIfAbsent = a16.putIfAbsent(eventName, method2);
                            if (putIfAbsent != null) {
                                method = putIfAbsent;
                            } else {
                                method = method2;
                            }
                        }
                    }
                    throw new NoSuchElementException("Array contains no element matching the predicate.");
                }
                method.invoke(obj, eventName, data, aVar);
                return;
            }
            f fVar = f.f106360b;
            DispatchConfig dispatchConfig = fVar.b().get(eventName);
            if (dispatchConfig != null) {
                Object a17 = fVar.a(data, dispatchConfig.b());
                Object obj3 = a17.getClass().getDeclaredField("scene_address").get(a17);
                if (obj3 instanceof PBUInt64Field) {
                    obj2 = obj3;
                }
                PBUInt64Field pBUInt64Field = (PBUInt64Field) obj2;
                if (pBUInt64Field != null && (function3 = dispatchConfig.a().get(Long.valueOf(pBUInt64Field.get()))) != null) {
                    function3.invoke(eventName, (MessageMicro) a17, aVar);
                    return;
                }
            }
            FLog.INSTANCE.e(TAG, "native can not handle " + eventName);
            MessageChannel messageChannel = INSTANCE;
            MessageChannelErrorCode$MessageResponse messageChannelErrorCode$MessageResponse = new MessageChannelErrorCode$MessageResponse();
            MessageChannelErrorCode$MessageChannelError messageChannelErrorCode$MessageChannelError = messageChannelErrorCode$MessageResponse.error;
            MessageChannelErrorCode$MessageChannelError messageChannelErrorCode$MessageChannelError2 = new MessageChannelErrorCode$MessageChannelError();
            messageChannelErrorCode$MessageChannelError2.code.set(1);
            Unit unit = Unit.INSTANCE;
            messageChannelErrorCode$MessageChannelError.set(messageChannelErrorCode$MessageChannelError2);
            messageChannel.nCallbackN2C(callbackN2CId, messageChannelErrorCode$MessageResponse.toByteArray());
        } catch (Throwable th5) {
            FLog.INSTANCE.e(TAG, "callC2N " + eventName + " \u5f02\u5e38 ", th5);
            MessageChannel messageChannel2 = INSTANCE;
            MessageChannelErrorCode$MessageResponse messageChannelErrorCode$MessageResponse2 = new MessageChannelErrorCode$MessageResponse();
            MessageChannelErrorCode$MessageChannelError messageChannelErrorCode$MessageChannelError3 = messageChannelErrorCode$MessageResponse2.error;
            MessageChannelErrorCode$MessageChannelError messageChannelErrorCode$MessageChannelError4 = new MessageChannelErrorCode$MessageChannelError();
            messageChannelErrorCode$MessageChannelError4.code.set(3);
            messageChannelErrorCode$MessageChannelError4.message.set(th5.getMessage());
            Unit unit2 = Unit.INSTANCE;
            messageChannelErrorCode$MessageChannelError3.set(messageChannelErrorCode$MessageChannelError4);
            messageChannel2.nCallbackN2C(callbackN2CId, messageChannelErrorCode$MessageResponse2.toByteArray());
        }
    }

    private final native void nCallN2C(String eventName, byte[] data, long index, Function2<? super byte[], ? super Long, Unit> callback);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nCallbackN2C(int callbackN2CId, byte[] data);

    public final void callN2C(@NotNull String eventName, @Nullable byte[] data, @NotNull Function1<? super MessageChannelErrorCode$MessageResponse, Unit> callbackC2N) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(callbackC2N, "callbackC2N");
        long andIncrement = messageN2CIndex.getAndIncrement();
        messageN2CCallbackMap.put(Long.valueOf(andIncrement), callbackC2N);
        nCallN2C(eventName, data, andIncrement, new Function2<byte[], Long, Unit>() { // from class: com.tencent.filament.zplanservice.channel.MessageChannel$callN2C$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(byte[] bArr, Long l3) {
                invoke(bArr, l3.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable byte[] bArr, long j3) {
                ConcurrentHashMap concurrentHashMap;
                MessageChannel messageChannel = MessageChannel.INSTANCE;
                concurrentHashMap = MessageChannel.messageN2CCallbackMap;
                Function1 function1 = (Function1) concurrentHashMap.remove(Long.valueOf(j3));
                if (function1 != null) {
                    function1.invoke(bArr != null ? (MessageChannelErrorCode$MessageResponse) com.tencent.filament.zplanservice.util.d.a(bArr, new MessageChannelErrorCode$MessageResponse()) : null);
                }
            }
        });
    }
}
