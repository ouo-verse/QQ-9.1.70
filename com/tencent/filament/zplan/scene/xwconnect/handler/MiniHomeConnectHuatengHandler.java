package com.tencent.filament.zplan.scene.xwconnect.handler;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.filament.zplan.app.impl.FilamentNativeAppV2305;
import com.tencent.filament.zplan.scene.xwconnect.handler.MiniHomeConnectHuatengHandler;
import com.tencent.filament.zplan.scene.xwconnect.handler.a;
import com.tencent.filament.zplanservice.channel.MessageChannel;
import com.tencent.filament.zplanservice.pbjava.MessageChannelErrorCode$MessageResponse;
import com.tencent.filament.zplanservice.pbjava.sceneevent.NativeDoFlowerOp$NativeDoFlowerOpReq;
import com.tencent.filament.zplanservice.pbjava.sceneevent.NativeDoFlowerOp$NativeDoFlowerOpRsp;
import com.tencent.filament.zplanservice.pbjava.sceneevent.NativeDoFlowerOp$NativeFlowerStartPreview;
import com.tencent.filament.zplanservice.pbjava.sceneevent.NativeDoFlowerOp$NativeFlowerStopPreview;
import com.tencent.filament.zplanservice.pbjava.sceneevent.NativeDoFlowerOp$NotifyFlowerUi;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.BaseConstants;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n*\u0001\u000f\u0018\u0000 \u000e2\u00020\u0001:\u0006\u001f !\u0005\u0007\tB\u001d\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0010\u001c\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001c\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\""}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectHuatengHandler;", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/a;", "Lcom/tencent/filament/zplanservice/pbjava/sceneevent/NativeDoFlowerOp$NativeDoFlowerOpReq;", "req", "", "d", "Lcom/tencent/filament/zplanservice/pbjava/sceneevent/NativeDoFlowerOp$NativeFlowerStartPreview;", "e", "Lcom/tencent/filament/zplanservice/pbjava/sceneevent/NativeDoFlowerOp$NativeFlowerStopPreview;", "f", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/filament/zplanservice/pbjava/sceneevent/NativeDoFlowerOp$NotifyFlowerUi;", BaseConstants.ATTRIBUTE_KEY_PB_DATA, h.F, "com/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectHuatengHandler$action$1", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectHuatengHandler$action$1;", "action", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/filament/zplan/app/impl/FilamentNativeAppV2305;", "Ljava/lang/ref/WeakReference;", "g", "()Ljava/lang/ref/WeakReference;", "nativeApp", "", "J", "getSceneId", "()J", WadlProxyConsts.SCENE_ID, "<init>", "(Ljava/lang/ref/WeakReference;J)V", "a", "b", "c", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class MiniHomeConnectHuatengHandler implements a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final MiniHomeConnectHuatengHandler$action$1 action;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<FilamentNativeAppV2305> nativeApp;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final long sceneId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectHuatengHandler$b;", "Ltk0/b;", "Lcom/tencent/filament/zplanservice/pbjava/sceneevent/NativeDoFlowerOp$NativeDoFlowerOpReq;", "a", "Lcom/tencent/filament/zplanservice/pbjava/sceneevent/NativeDoFlowerOp$NativeDoFlowerOpReq;", "()Lcom/tencent/filament/zplanservice/pbjava/sceneevent/NativeDoFlowerOp$NativeDoFlowerOpReq;", "req", "<init>", "(Lcom/tencent/filament/zplanservice/pbjava/sceneevent/NativeDoFlowerOp$NativeDoFlowerOpReq;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static class b implements tk0.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final NativeDoFlowerOp$NativeDoFlowerOpReq req;

        public b(@NotNull NativeDoFlowerOp$NativeDoFlowerOpReq req) {
            Intrinsics.checkNotNullParameter(req, "req");
            this.req = req;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final NativeDoFlowerOp$NativeDoFlowerOpReq getReq() {
            return this.req;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectHuatengHandler$c;", "Ltk0/b;", "", "a", "I", "()I", "reqOp", "Lcom/tencent/filament/zplanservice/pbjava/sceneevent/NativeDoFlowerOp$NativeDoFlowerOpRsp;", "b", "Lcom/tencent/filament/zplanservice/pbjava/sceneevent/NativeDoFlowerOp$NativeDoFlowerOpRsp;", "()Lcom/tencent/filament/zplanservice/pbjava/sceneevent/NativeDoFlowerOp$NativeDoFlowerOpRsp;", "rsp", "<init>", "(ILcom/tencent/filament/zplanservice/pbjava/sceneevent/NativeDoFlowerOp$NativeDoFlowerOpRsp;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static class c implements tk0.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int reqOp;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final NativeDoFlowerOp$NativeDoFlowerOpRsp rsp;

        public c(int i3, @NotNull NativeDoFlowerOp$NativeDoFlowerOpRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            this.reqOp = i3;
            this.rsp = rsp;
        }

        /* renamed from: a, reason: from getter */
        public final int getReqOp() {
            return this.reqOp;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final NativeDoFlowerOp$NativeDoFlowerOpRsp getRsp() {
            return this.rsp;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectHuatengHandler$d;", "Ltk0/b;", "Lcom/tencent/filament/zplanservice/pbjava/sceneevent/NativeDoFlowerOp$NotifyFlowerUi;", "a", "Lcom/tencent/filament/zplanservice/pbjava/sceneevent/NativeDoFlowerOp$NotifyFlowerUi;", "()Lcom/tencent/filament/zplanservice/pbjava/sceneevent/NativeDoFlowerOp$NotifyFlowerUi;", "req", "<init>", "(Lcom/tencent/filament/zplanservice/pbjava/sceneevent/NativeDoFlowerOp$NotifyFlowerUi;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static class d implements tk0.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final NativeDoFlowerOp$NotifyFlowerUi req;

        public d(@NotNull NativeDoFlowerOp$NotifyFlowerUi req) {
            Intrinsics.checkNotNullParameter(req, "req");
            this.req = req;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final NativeDoFlowerOp$NotifyFlowerUi getReq() {
            return this.req;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectHuatengHandler$e;", "Ltk0/b;", "Lcom/tencent/filament/zplanservice/pbjava/sceneevent/NativeDoFlowerOp$NativeFlowerStartPreview;", "a", "Lcom/tencent/filament/zplanservice/pbjava/sceneevent/NativeDoFlowerOp$NativeFlowerStartPreview;", "()Lcom/tencent/filament/zplanservice/pbjava/sceneevent/NativeDoFlowerOp$NativeFlowerStartPreview;", "req", "<init>", "(Lcom/tencent/filament/zplanservice/pbjava/sceneevent/NativeDoFlowerOp$NativeFlowerStartPreview;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static class e implements tk0.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final NativeDoFlowerOp$NativeFlowerStartPreview req;

        public e(@NotNull NativeDoFlowerOp$NativeFlowerStartPreview req) {
            Intrinsics.checkNotNullParameter(req, "req");
            this.req = req;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final NativeDoFlowerOp$NativeFlowerStartPreview getReq() {
            return this.req;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectHuatengHandler$f;", "Ltk0/b;", "Lcom/tencent/filament/zplanservice/pbjava/sceneevent/NativeDoFlowerOp$NativeFlowerStopPreview;", "a", "Lcom/tencent/filament/zplanservice/pbjava/sceneevent/NativeDoFlowerOp$NativeFlowerStopPreview;", "()Lcom/tencent/filament/zplanservice/pbjava/sceneevent/NativeDoFlowerOp$NativeFlowerStopPreview;", "req", "<init>", "(Lcom/tencent/filament/zplanservice/pbjava/sceneevent/NativeDoFlowerOp$NativeFlowerStopPreview;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static class f implements tk0.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final NativeDoFlowerOp$NativeFlowerStopPreview req;

        public f(@NotNull NativeDoFlowerOp$NativeFlowerStopPreview req) {
            Intrinsics.checkNotNullParameter(req, "req");
            this.req = req;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final NativeDoFlowerOp$NativeFlowerStopPreview getReq() {
            return this.req;
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.tencent.filament.zplan.scene.xwconnect.handler.MiniHomeConnectHuatengHandler$action$1] */
    public MiniHomeConnectHuatengHandler(@NotNull WeakReference<FilamentNativeAppV2305> nativeApp, long j3) {
        Intrinsics.checkNotNullParameter(nativeApp, "nativeApp");
        this.nativeApp = nativeApp;
        this.sceneId = j3;
        this.action = new tk0.a() { // from class: com.tencent.filament.zplan.scene.xwconnect.handler.MiniHomeConnectHuatengHandler$action$1
            @Override // tk0.a
            public void call(@NotNull tk0.b event) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (event instanceof MiniHomeConnectHuatengHandler.b) {
                    MiniHomeConnectHuatengHandler.this.d(((MiniHomeConnectHuatengHandler.b) event).getReq());
                } else if (event instanceof MiniHomeConnectHuatengHandler.e) {
                    MiniHomeConnectHuatengHandler.this.e(((MiniHomeConnectHuatengHandler.e) event).getReq());
                } else if (event instanceof MiniHomeConnectHuatengHandler.f) {
                    MiniHomeConnectHuatengHandler.this.f(((MiniHomeConnectHuatengHandler.f) event).getReq());
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(final NativeDoFlowerOp$NativeDoFlowerOpReq req) {
        FLog.INSTANCE.i("ConnectHandler_MiniHomeConnectHuatengHandler", "doFlowerOp, uin: " + req.uin.get() + ", op: " + req.f106426op.get());
        req.scene_address.set(this.sceneId);
        MessageChannel.INSTANCE.callN2C("flower.NativeDoFlowerOpReq", req.toByteArray(), new Function1<MessageChannelErrorCode$MessageResponse, Unit>() { // from class: com.tencent.filament.zplan.scene.xwconnect.handler.MiniHomeConnectHuatengHandler$doFlowerOp$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MessageChannelErrorCode$MessageResponse messageChannelErrorCode$MessageResponse) {
                invoke2(messageChannelErrorCode$MessageResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable MessageChannelErrorCode$MessageResponse messageChannelErrorCode$MessageResponse) {
                PBBytesField pBBytesField;
                FilamentNativeAppV2305 filamentNativeAppV2305;
                FLog.INSTANCE.i("ConnectHandler_MiniHomeConnectHuatengHandler", "postMessage event:doFlowerOp " + req.f106426op.get() + ", result: " + messageChannelErrorCode$MessageResponse);
                if (messageChannelErrorCode$MessageResponse == null || (pBBytesField = messageChannelErrorCode$MessageResponse.data) == null || (filamentNativeAppV2305 = MiniHomeConnectHuatengHandler.this.g().get()) == null) {
                    return;
                }
                int i3 = req.f106426op.get();
                NativeDoFlowerOp$NativeDoFlowerOpRsp mergeFrom = new NativeDoFlowerOp$NativeDoFlowerOpRsp().mergeFrom(pBBytesField.get().toByteArray());
                Intrinsics.checkNotNullExpressionValue(mergeFrom, "NativeDoFlowerOp.NativeD\u2026data.get().toByteArray())");
                filamentNativeAppV2305.dispatchEvent(new MiniHomeConnectHuatengHandler.c(i3, mergeFrom));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(NativeDoFlowerOp$NativeFlowerStartPreview req) {
        FLog.INSTANCE.i("ConnectHandler_MiniHomeConnectHuatengHandler", "doStartFlowerPreview");
        req.scene_address.set(this.sceneId);
        MessageChannel.INSTANCE.callN2C("flower.NativeFlowerStartPreview", req.toByteArray(), new Function1<MessageChannelErrorCode$MessageResponse, Unit>() { // from class: com.tencent.filament.zplan.scene.xwconnect.handler.MiniHomeConnectHuatengHandler$doStartFlowerPreview$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MessageChannelErrorCode$MessageResponse messageChannelErrorCode$MessageResponse) {
                invoke2(messageChannelErrorCode$MessageResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable MessageChannelErrorCode$MessageResponse messageChannelErrorCode$MessageResponse) {
                FLog.INSTANCE.i("ConnectHandler_MiniHomeConnectHuatengHandler", "postMessage event:doStartFlowerPreview result: " + messageChannelErrorCode$MessageResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(NativeDoFlowerOp$NativeFlowerStopPreview req) {
        FLog.INSTANCE.i("ConnectHandler_MiniHomeConnectHuatengHandler", "doStopFlowerPreview");
        req.scene_address.set(this.sceneId);
        MessageChannel.INSTANCE.callN2C("flower.NativeFlowerStopPreview", req.toByteArray(), new Function1<MessageChannelErrorCode$MessageResponse, Unit>() { // from class: com.tencent.filament.zplan.scene.xwconnect.handler.MiniHomeConnectHuatengHandler$doStopFlowerPreview$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MessageChannelErrorCode$MessageResponse messageChannelErrorCode$MessageResponse) {
                invoke2(messageChannelErrorCode$MessageResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable MessageChannelErrorCode$MessageResponse messageChannelErrorCode$MessageResponse) {
                FLog.INSTANCE.i("ConnectHandler_MiniHomeConnectHuatengHandler", "postMessage event:doStopFlowerPreview result: " + messageChannelErrorCode$MessageResponse);
            }
        });
    }

    @NotNull
    public final WeakReference<FilamentNativeAppV2305> g() {
        return this.nativeApp;
    }

    public final void h(@NotNull NativeDoFlowerOp$NotifyFlowerUi pbData) {
        Intrinsics.checkNotNullParameter(pbData, "pbData");
        FilamentNativeAppV2305 filamentNativeAppV2305 = this.nativeApp.get();
        if (filamentNativeAppV2305 != null) {
            filamentNativeAppV2305.dispatchEvent(new d(pbData));
        }
    }

    @Override // com.tencent.filament.zplan.scene.xwconnect.handler.a
    public void onCreate() {
        a.C1118a.a(this);
        FilamentNativeAppV2305 filamentNativeAppV2305 = this.nativeApp.get();
        if (filamentNativeAppV2305 != null) {
            filamentNativeAppV2305.register(tk0.c.f436439a.a(Reflection.getOrCreateKotlinClass(b.class)), this.action);
        }
        FilamentNativeAppV2305 filamentNativeAppV23052 = this.nativeApp.get();
        if (filamentNativeAppV23052 != null) {
            filamentNativeAppV23052.register(tk0.c.f436439a.a(Reflection.getOrCreateKotlinClass(e.class)), this.action);
        }
        FilamentNativeAppV2305 filamentNativeAppV23053 = this.nativeApp.get();
        if (filamentNativeAppV23053 != null) {
            filamentNativeAppV23053.register(tk0.c.f436439a.a(Reflection.getOrCreateKotlinClass(f.class)), this.action);
        }
    }

    @Override // com.tencent.filament.zplan.scene.xwconnect.handler.a
    public void onDestroy() {
        a.C1118a.b(this);
        FilamentNativeAppV2305 filamentNativeAppV2305 = this.nativeApp.get();
        if (filamentNativeAppV2305 != null) {
            filamentNativeAppV2305.unregister(tk0.c.f436439a.a(Reflection.getOrCreateKotlinClass(b.class)), this.action);
        }
        FilamentNativeAppV2305 filamentNativeAppV23052 = this.nativeApp.get();
        if (filamentNativeAppV23052 != null) {
            filamentNativeAppV23052.unregister(tk0.c.f436439a.a(Reflection.getOrCreateKotlinClass(e.class)), this.action);
        }
        FilamentNativeAppV2305 filamentNativeAppV23053 = this.nativeApp.get();
        if (filamentNativeAppV23053 != null) {
            filamentNativeAppV23053.unregister(tk0.c.f436439a.a(Reflection.getOrCreateKotlinClass(f.class)), this.action);
        }
    }
}
