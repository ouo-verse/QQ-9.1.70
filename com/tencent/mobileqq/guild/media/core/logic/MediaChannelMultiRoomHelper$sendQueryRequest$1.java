package com.tencent.mobileqq.guild.media.core.logic;

import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserAVRspInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.fc;
import java.util.Iterator;
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
import wh2.er;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.media.core.logic.MediaChannelMultiRoomHelper$sendQueryRequest$1", f = "MediaChannelMultiRoomHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class MediaChannelMultiRoomHelper$sendQueryRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MediaChannelMultiRoomHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaChannelMultiRoomHelper$sendQueryRequest$1(MediaChannelMultiRoomHelper mediaChannelMultiRoomHelper, Continuation<? super MediaChannelMultiRoomHelper$sendQueryRequest$1> continuation) {
        super(2, continuation);
        this.this$0 = mediaChannelMultiRoomHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(MediaChannelMultiRoomHelper mediaChannelMultiRoomHelper, int i3, String str, IGProUserAVRspInfo iGProUserAVRspInfo) {
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str2 = "sendQueryRequest: result[" + i3 + "] errMsg[" + str + "]";
        if (str2 instanceof String) {
            bVar.a().add(str2);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("QGMC.MediaGroup.MediaChannelMultiRoomHelper", 1, (String) it.next(), null);
        }
        mediaChannelMultiRoomHelper.X0(iGProUserAVRspInfo, true);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MediaChannelMultiRoomHelper$sendQueryRequest$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        fc T0;
        uh2.b R0;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Logger.f235387a.d().d("QGMC.MediaGroup.MediaChannelMultiRoomHelper", 1, "[sendQueryRequest] ");
            T0 = this.this$0.T0();
            T0.b().e(12);
            T0.b().f(0);
            T0.b().d(0);
            R0 = this.this$0.R0();
            final MediaChannelMultiRoomHelper mediaChannelMultiRoomHelper = this.this$0;
            R0.queryAVState(T0, new er() { // from class: com.tencent.mobileqq.guild.media.core.logic.as
                @Override // wh2.er
                public final void a(int i3, String str, IGProUserAVRspInfo iGProUserAVRspInfo) {
                    MediaChannelMultiRoomHelper$sendQueryRequest$1.b(MediaChannelMultiRoomHelper.this, i3, str, iGProUserAVRspInfo);
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MediaChannelMultiRoomHelper$sendQueryRequest$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
