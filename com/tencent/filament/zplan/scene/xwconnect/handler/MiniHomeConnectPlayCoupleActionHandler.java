package com.tencent.filament.zplan.scene.xwconnect.handler;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.filament.zplan.app.impl.FilamentNativeAppV2305;
import com.tencent.filament.zplan.scene.xwconnect.handler.MiniHomeConnectPlayCoupleActionHandler;
import com.tencent.filament.zplan.scene.xwconnect.handler.a;
import com.tencent.filament.zplanservice.channel.MessageChannel;
import com.tencent.filament.zplanservice.pbjava.CoupleActionChannel$PlayCoupleActionReq;
import com.tencent.filament.zplanservice.pbjava.CoupleActionChannel$PlayCoupleActionRsp;
import com.tencent.filament.zplanservice.pbjava.MessageChannelErrorCode$MessageResponse;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.mobileqq.pb.PBBytesField;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000)\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\b\u0018\u0000 \u00152\u00020\u0001:\u0003\u0016\u0010\u0005B\u0015\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectPlayCoupleActionHandler;", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/a;", "Lcom/tencent/filament/zplanservice/pbjava/CoupleActionChannel$PlayCoupleActionReq;", "req", "", "c", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "com/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectPlayCoupleActionHandler$action$1", "d", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectPlayCoupleActionHandler$action$1;", "action", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/filament/zplan/app/impl/FilamentNativeAppV2305;", "e", "Ljava/lang/ref/WeakReference;", "b", "()Ljava/lang/ref/WeakReference;", "nativeApp", "<init>", "(Ljava/lang/ref/WeakReference;)V", "f", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class MiniHomeConnectPlayCoupleActionHandler implements a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final MiniHomeConnectPlayCoupleActionHandler$action$1 action;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<FilamentNativeAppV2305> nativeApp;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectPlayCoupleActionHandler$b;", "Ltk0/b;", "Lcom/tencent/filament/zplanservice/pbjava/CoupleActionChannel$PlayCoupleActionReq;", "a", "Lcom/tencent/filament/zplanservice/pbjava/CoupleActionChannel$PlayCoupleActionReq;", "()Lcom/tencent/filament/zplanservice/pbjava/CoupleActionChannel$PlayCoupleActionReq;", "req", "<init>", "(Lcom/tencent/filament/zplanservice/pbjava/CoupleActionChannel$PlayCoupleActionReq;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static class b implements tk0.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final CoupleActionChannel$PlayCoupleActionReq req;

        public b(@NotNull CoupleActionChannel$PlayCoupleActionReq req) {
            Intrinsics.checkNotNullParameter(req, "req");
            this.req = req;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final CoupleActionChannel$PlayCoupleActionReq getReq() {
            return this.req;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectPlayCoupleActionHandler$c;", "Ltk0/b;", "Lcom/tencent/filament/zplanservice/pbjava/CoupleActionChannel$PlayCoupleActionRsp;", "a", "Lcom/tencent/filament/zplanservice/pbjava/CoupleActionChannel$PlayCoupleActionRsp;", "b", "()Lcom/tencent/filament/zplanservice/pbjava/CoupleActionChannel$PlayCoupleActionRsp;", "rsp", "", "I", "()I", "reqActionId", "<init>", "(Lcom/tencent/filament/zplanservice/pbjava/CoupleActionChannel$PlayCoupleActionRsp;I)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static class c implements tk0.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final CoupleActionChannel$PlayCoupleActionRsp rsp;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int reqActionId;

        public c(@NotNull CoupleActionChannel$PlayCoupleActionRsp rsp, int i3) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            this.rsp = rsp;
            this.reqActionId = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getReqActionId() {
            return this.reqActionId;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final CoupleActionChannel$PlayCoupleActionRsp getRsp() {
            return this.rsp;
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.tencent.filament.zplan.scene.xwconnect.handler.MiniHomeConnectPlayCoupleActionHandler$action$1] */
    public MiniHomeConnectPlayCoupleActionHandler(@NotNull WeakReference<FilamentNativeAppV2305> nativeApp) {
        Intrinsics.checkNotNullParameter(nativeApp, "nativeApp");
        this.nativeApp = nativeApp;
        this.action = new tk0.a() { // from class: com.tencent.filament.zplan.scene.xwconnect.handler.MiniHomeConnectPlayCoupleActionHandler$action$1
            @Override // tk0.a
            public void call(@NotNull tk0.b event) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (event instanceof MiniHomeConnectPlayCoupleActionHandler.b) {
                    MiniHomeConnectPlayCoupleActionHandler.this.c(((MiniHomeConnectPlayCoupleActionHandler.b) event).getReq());
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(final CoupleActionChannel$PlayCoupleActionReq req) {
        FLog.INSTANCE.i("ConnectHandler_MiniHomeConnectPlayCoupleActionHandler", "playAction, actionId: " + req.action_id.get());
        MessageChannel.INSTANCE.callN2C("coupleAction.Play", req.toByteArray(), new Function1<MessageChannelErrorCode$MessageResponse, Unit>() { // from class: com.tencent.filament.zplan.scene.xwconnect.handler.MiniHomeConnectPlayCoupleActionHandler$playAction$1
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
                FLog.INSTANCE.i("ConnectHandler_MiniHomeConnectPlayCoupleActionHandler", "postMessage event:playAction result: " + messageChannelErrorCode$MessageResponse);
                if (messageChannelErrorCode$MessageResponse == null || (pBBytesField = messageChannelErrorCode$MessageResponse.data) == null || (filamentNativeAppV2305 = MiniHomeConnectPlayCoupleActionHandler.this.b().get()) == null) {
                    return;
                }
                CoupleActionChannel$PlayCoupleActionRsp mergeFrom = new CoupleActionChannel$PlayCoupleActionRsp().mergeFrom(pBBytesField.get().toByteArray());
                Intrinsics.checkNotNullExpressionValue(mergeFrom, "PlayCoupleActionRsp().me\u2026data.get().toByteArray())");
                filamentNativeAppV2305.dispatchEvent(new MiniHomeConnectPlayCoupleActionHandler.c(mergeFrom, req.action_id.get()));
            }
        });
    }

    @NotNull
    public final WeakReference<FilamentNativeAppV2305> b() {
        return this.nativeApp;
    }

    @Override // com.tencent.filament.zplan.scene.xwconnect.handler.a
    public void onCreate() {
        a.C1118a.a(this);
        FilamentNativeAppV2305 filamentNativeAppV2305 = this.nativeApp.get();
        if (filamentNativeAppV2305 != null) {
            filamentNativeAppV2305.register(tk0.c.f436439a.a(Reflection.getOrCreateKotlinClass(b.class)), this.action);
        }
    }

    @Override // com.tencent.filament.zplan.scene.xwconnect.handler.a
    public void onDestroy() {
        a.C1118a.b(this);
        FilamentNativeAppV2305 filamentNativeAppV2305 = this.nativeApp.get();
        if (filamentNativeAppV2305 != null) {
            filamentNativeAppV2305.unregister(tk0.c.f436439a.a(Reflection.getOrCreateKotlinClass(b.class)), this.action);
        }
    }
}
