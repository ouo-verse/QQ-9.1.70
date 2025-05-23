package com.tencent.guild.api.share;

import android.content.Intent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
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
@DebugMetadata(c = "com.tencent.guild.api.share.IGuildForwarder$sendMsg$1", f = "IGuildForwarder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class IGuildForwarder$sendMsg$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Contact $contact;
    final /* synthetic */ Intent $intent;
    final /* synthetic */ ArrayList<MsgElement> $msgElements;
    int label;
    final /* synthetic */ IGuildForwarder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IGuildForwarder$sendMsg$1(Contact contact, ArrayList<MsgElement> arrayList, IGuildForwarder iGuildForwarder, Intent intent, Continuation<? super IGuildForwarder$sendMsg$1> continuation) {
        super(2, continuation);
        this.$contact = contact;
        this.$msgElements = arrayList;
        this.this$0 = iGuildForwarder;
        this.$intent = intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(IGuildForwarder iGuildForwarder, Intent intent, int i3, String str) {
        QLog.i("IGuildForwarder", 1, "sendMsg. result: " + i3 + ", errMsg: " + str);
        if (i3 == 0) {
            iGuildForwarder.a(intent);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new IGuildForwarder$sendMsg$1(this.$contact, this.$msgElements, this.this$0, this.$intent, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            IMsgService iMsgService = (IMsgService) QRoute.api(IMsgService.class);
            Contact contact = this.$contact;
            ArrayList<MsgElement> arrayList = this.$msgElements;
            final IGuildForwarder iGuildForwarder = this.this$0;
            final Intent intent = this.$intent;
            iMsgService.sendMsg(contact, arrayList, new IOperateCallback() { // from class: com.tencent.guild.api.share.j
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    IGuildForwarder$sendMsg$1.b(IGuildForwarder.this, intent, i3, str);
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((IGuildForwarder$sendMsg$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
