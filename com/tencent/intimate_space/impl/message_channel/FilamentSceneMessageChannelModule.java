package com.tencent.intimate_space.impl.message_channel;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.filament.zplanservice.channel.MessageChannel;
import com.tencent.filament.zplanservice.channel.SceneEventConfig;
import com.tencent.filament.zplanservice.channel.a;
import com.tencent.filament.zplanservice.channel.f;
import com.tencent.filament.zplanservice.pbjava.MessageChannelErrorCode$MessageResponse;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import i01.e;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0001\u001e\u0018\u0000 $2\u00020\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b\"\u0010#J5\u0010\n\u001a\u00020\u00072+\u0010\t\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\u0004\u0018\u0001`\bH\u0002J?\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032+\u0010\t\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\u0004\u0018\u0001`\bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0002JI\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032+\u0010\t\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\u0004\u0018\u0001`\bH\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016R;\u0010\u0015\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\u0004\u0018\u0001`\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0014R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R&\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/intimate_space/impl/message_channel/FilamentSceneMessageChannelModule;", "Li01/e;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "c", "params", "d", "", WadlProxyConsts.SCENE_ID, "g", "", "method", "call", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lkotlin/jvm/functions/Function1;", "messageHandler", "e", "J", "", "Ljava/lang/Class;", "Lcom/tencent/intimate_space/impl/message_channel/NTComposeMessageChannel$PostMessageToComposeReq;", "f", "Ljava/util/Map;", "handlerEventMap", "com/tencent/intimate_space/impl/message_channel/FilamentSceneMessageChannelModule$b", h.F, "Lcom/tencent/intimate_space/impl/message_channel/FilamentSceneMessageChannelModule$b;", "sceneHandler", "<init>", "()V", "i", "a", "intimate_space_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class FilamentSceneMessageChannelModule extends e {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> messageHandler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long sceneId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Class<NTComposeMessageChannel$PostMessageToComposeReq>> handlerEventMap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b sceneHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/intimate_space/impl/message_channel/FilamentSceneMessageChannelModule$a;", "", "", "METHOD_SET_ON_MESSAGE_HANDLER", "Ljava/lang/String;", "MODULE_NAME", "NT_COMPOSE_POST_MESSAGE_TO_COMPOSE", "NT_COMPOSE_POST_MESSAGE_TO_ENGINE", "POST_MESSAGE", "SCENE_ID", "SET_SCENE_ID", "TAG", "<init>", "()V", "intimate_space_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.intimate_space.impl.message_channel.FilamentSceneMessageChannelModule$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002O\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0001j\u0002`\u000bJ%\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00022\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\t\u001a\u00020\bH\u0096\u0002\u00a8\u0006\r"}, d2 = {"com/tencent/intimate_space/impl/message_channel/FilamentSceneMessageChannelModule$b", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", AdMetricTag.EVENT_NAME, "Lcom/tencent/mobileqq/pb/MessageMicro;", "pbField", "Lcom/tencent/filament/zplanservice/channel/a;", "callbackN2C", "", "Lcom/tencent/filament/zplanservice/channel/SceneHandler;", "a", "intimate_space_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class b implements Function3<String, MessageMicro<?>, a, Unit> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FilamentSceneMessageChannelModule.this);
            }
        }

        public void a(@NotNull String eventName, @NotNull MessageMicro<?> pbField, @NotNull a callbackN2C) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, eventName, pbField, callbackN2C);
                return;
            }
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            Intrinsics.checkNotNullParameter(pbField, "pbField");
            Intrinsics.checkNotNullParameter(callbackN2C, "callbackN2C");
            if (Intrinsics.areEqual(eventName, "NTCompose.PostMessageToCompose")) {
                NTComposeMessageChannel$PostMessageToComposeReq nTComposeMessageChannel$PostMessageToComposeReq = (NTComposeMessageChannel$PostMessageToComposeReq) pbField;
                Function1 function1 = FilamentSceneMessageChannelModule.this.messageHandler;
                if (function1 != null) {
                    function1.invoke(nTComposeMessageChannel$PostMessageToComposeReq.toByteArray());
                }
            }
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(String str, MessageMicro<?> messageMicro, a aVar) {
            a(str, messageMicro, aVar);
            return Unit.INSTANCE;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27875);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FilamentSceneMessageChannelModule() {
        Map<String, Class<NTComposeMessageChannel$PostMessageToComposeReq>> mutableMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("NTCompose.PostMessageToCompose", NTComposeMessageChannel$PostMessageToComposeReq.class));
            this.handlerEventMap = mutableMapOf;
            this.sceneHandler = new b();
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final void c(Function1<Object, Unit> callback) {
        FLog.INSTANCE.i("FilamentSceneMessageChannelModule", "onMessage");
        this.messageHandler = callback;
    }

    private final void d(Object params, final Function1<Object, Unit> callback) {
        Object[] objArr;
        Object orNull;
        String str;
        Object orNull2;
        FLog fLog = FLog.INSTANCE;
        fLog.i("FilamentSceneMessageChannelModule", "start postMessage");
        byte[] bArr = null;
        if (params instanceof Object[]) {
            objArr = (Object[]) params;
        } else {
            objArr = null;
        }
        if (objArr == null) {
            fLog.e("FilamentSceneMessageChannelModule", "param is not array");
            return;
        }
        if (objArr.length < 2) {
            fLog.e("FilamentSceneMessageChannelModule", "param count < 2");
            return;
        }
        boolean z16 = false;
        orNull = ArraysKt___ArraysKt.getOrNull(objArr, 0);
        if (orNull instanceof String) {
            str = (String) orNull;
        } else {
            str = null;
        }
        if (str == null || str.length() == 0) {
            z16 = true;
        }
        if (!z16) {
            orNull2 = ArraysKt___ArraysKt.getOrNull(objArr, 1);
            if (orNull2 instanceof byte[]) {
                bArr = (byte[]) orNull2;
            }
            NTComposeMessageChannel$PostMessageToEngineReq nTComposeMessageChannel$PostMessageToEngineReq = new NTComposeMessageChannel$PostMessageToEngineReq();
            nTComposeMessageChannel$PostMessageToEngineReq.scene_address.set(this.sceneId);
            nTComposeMessageChannel$PostMessageToEngineReq.event_name.set(str);
            nTComposeMessageChannel$PostMessageToEngineReq.data.set(ByteStringMicro.copyFrom(bArr));
            MessageChannel.INSTANCE.callN2C("NTCompose.PostMessageToEngine", nTComposeMessageChannel$PostMessageToEngineReq.toByteArray(), new Function1<MessageChannelErrorCode$MessageResponse, Unit>(callback) { // from class: com.tencent.intimate_space.impl.message_channel.FilamentSceneMessageChannelModule$postMessage$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ Function1<Object, Unit> $callback;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) FilamentSceneMessageChannelModule.this, (Object) callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(MessageChannelErrorCode$MessageResponse messageChannelErrorCode$MessageResponse) {
                    invoke2(messageChannelErrorCode$MessageResponse);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable MessageChannelErrorCode$MessageResponse messageChannelErrorCode$MessageResponse) {
                    PBBytesField pBBytesField;
                    ByteStringMicro byteStringMicro;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) messageChannelErrorCode$MessageResponse);
                        return;
                    }
                    byte[] byteArray = (messageChannelErrorCode$MessageResponse == null || (pBBytesField = messageChannelErrorCode$MessageResponse.data) == null || (byteStringMicro = pBBytesField.get()) == null) ? null : byteStringMicro.toByteArray();
                    if (byteArray == null) {
                        Function1<Object, Unit> function1 = this.$callback;
                        if (function1 != null) {
                            function1.invoke(null);
                            return;
                        }
                        return;
                    }
                    NTComposeMessageChannel$PostMessageToEngineRsp mergeFrom = new NTComposeMessageChannel$PostMessageToEngineRsp().mergeFrom(byteArray);
                    Function1<Object, Unit> function12 = this.$callback;
                    if (function12 != null) {
                        function12.invoke(mergeFrom.data.get().toByteArray());
                    }
                }
            });
            return;
        }
        fLog.e("FilamentSceneMessageChannelModule", "eventName is empty");
    }

    private final void g(long sceneId) {
        FLog.INSTANCE.i("FilamentSceneMessageChannelModule", "setSceneId: " + sceneId);
        this.sceneId = sceneId;
    }

    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable Object params, @Nullable Function1<Object, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, this, method, params, callback);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        int hashCode = method.hashCode();
        if (hashCode != -1896872364) {
            if (hashCode != -687616636) {
                if (hashCode == 593344517 && method.equals("setSceneId")) {
                    if (params != null) {
                        long optLong = new JSONObject((String) params).optLong(WadlProxyConsts.SCENE_ID);
                        g(optLong);
                        FLog.INSTANCE.i("FilamentSceneMessageChannelModule", "start registerSceneEventConfig: " + optLong);
                        f.f106360b.c(optLong, new SceneEventConfig(this.sceneHandler, this.handlerEventMap));
                        return Unit.INSTANCE;
                    }
                    return null;
                }
            } else if (method.equals("setOnMessageHandler")) {
                c(callback);
                return Unit.INSTANCE;
            }
        } else if (method.equals("postMessageToFilamentScene")) {
            d(params, callback);
            return Unit.INSTANCE;
        }
        return super.call(method, params, callback);
    }

    @Override // i01.e, i01.a
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onDestroy();
            f.f106360b.d(this.sceneId);
        }
    }
}
