package com.tencent.mobileqq.qqlive.sail.room;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.sail.model.AnchorRoomInfo;
import com.tencent.mobileqq.qqlive.sail.model.anchor.AvConfig;
import com.tencent.mobileqq.qqlive.sail.model.anchor.SettingInfo;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqlive.sail.room.LiveAnchorRoom$updateRoomInfo$1", f = "LiveAnchorRoom.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes17.dex */
final class LiveAnchorRoom$updateRoomInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ AvConfig $config;
    final /* synthetic */ SettingInfo $info;
    int label;
    final /* synthetic */ LiveAnchorRoom this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveAnchorRoom$updateRoomInfo$1(LiveAnchorRoom liveAnchorRoom, AvConfig avConfig, SettingInfo settingInfo, Continuation<? super LiveAnchorRoom$updateRoomInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = liveAnchorRoom;
        this.$config = avConfig;
        this.$info = settingInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, liveAnchorRoom, avConfig, settingInfo, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new LiveAnchorRoom$updateRoomInfo$1(this.this$0, this.$config, this.$info, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        SettingInfo a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AegisLogger.INSTANCE.i(this.this$0.N(), "updateRoomInfo", String.valueOf(this.this$0.M()));
                AvConfig avConfig = this.$config;
                if (avConfig != null) {
                    this.this$0.L().y(AvConfig.b(avConfig, false, false, false, 0, false, 0, 63, null));
                }
                SettingInfo settingInfo = this.$info;
                if (settingInfo != null) {
                    AnchorRoomInfo L = this.this$0.L();
                    a16 = settingInfo.a((r24 & 1) != 0 ? settingInfo.roomType : 0, (r24 & 2) != 0 ? settingInfo.roomName : null, (r24 & 4) != 0 ? settingInfo.locationInfo : null, (r24 & 8) != 0 ? settingInfo.coverInfo : null, (r24 & 16) != 0 ? settingInfo.enableGif : false, (r24 & 32) != 0 ? settingInfo.streamRecordType : 0, (r24 & 64) != 0 ? settingInfo.styleInfo : null, (r24 & 128) != 0 ? settingInfo.isPrivateLive : false, (r24 & 256) != 0 ? settingInfo.source : null, (r24 & 512) != 0 ? settingInfo.isECGoodsLive : false, (r24 & 1024) != 0 ? settingInfo.openTabLevel : 0);
                    L.B(a16);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((LiveAnchorRoom$updateRoomInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
