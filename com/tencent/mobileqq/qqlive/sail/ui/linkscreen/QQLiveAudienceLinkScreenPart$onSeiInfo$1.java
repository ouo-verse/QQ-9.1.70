package com.tencent.mobileqq.qqlive.sail.ui.linkscreen;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.callback.room.VideoSeiInfo;
import com.tencent.mobileqq.qqlive.sail.model.AudienceRoomInfo;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqlive.sail.ui.linkscreen.QQLiveAudienceLinkScreenPart$onSeiInfo$1", f = "QQLiveAudienceLinkScreenPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes17.dex */
final class QQLiveAudienceLinkScreenPart$onSeiInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ VideoSeiInfo $seiInfo;
    int label;
    final /* synthetic */ QQLiveAudienceLinkScreenPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLiveAudienceLinkScreenPart$onSeiInfo$1(QQLiveAudienceLinkScreenPart qQLiveAudienceLinkScreenPart, VideoSeiInfo videoSeiInfo, Continuation<? super QQLiveAudienceLinkScreenPart$onSeiInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = qQLiveAudienceLinkScreenPart;
        this.$seiInfo = videoSeiInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, qQLiveAudienceLinkScreenPart, videoSeiInfo, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new QQLiveAudienceLinkScreenPart$onSeiInfo$1(this.this$0, this.$seiInfo, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean oa5;
        e ma5;
        e ma6;
        e ma7;
        com.tencent.mobileqq.qqlive.sail.room.e na5;
        AudienceRoomInfo audienceRoomInfo;
        FrameLayout frameLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                oa5 = this.this$0.oa(this.$seiInfo);
                if (oa5) {
                    ma5 = this.this$0.ma();
                    if (!ma5.N1() && this.this$0.R9()) {
                        AegisLogger.INSTANCE.i("Audience|QQLiveAudienceLinkScreenPart", "onSeiInfo", "roomId=" + this.this$0.H9() + ", pkViewModel enter room");
                        ma7 = this.this$0.ma();
                        Context context = this.this$0.getContext();
                        na5 = this.this$0.na();
                        if (na5 != null) {
                            audienceRoomInfo = na5.b();
                        } else {
                            audienceRoomInfo = null;
                        }
                        frameLayout = this.this$0.pkGameContainer;
                        ma7.Q1(context, audienceRoomInfo, frameLayout);
                    }
                    ma6 = this.this$0.ma();
                    ma6.T1(this.$seiInfo);
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((QQLiveAudienceLinkScreenPart$onSeiInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
