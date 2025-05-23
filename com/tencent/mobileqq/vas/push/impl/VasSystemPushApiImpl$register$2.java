package com.tencent.mobileqq.vas.push.impl;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.pb.scupdate.SCUpdatePB$Item;
import com.tencent.pb.scupdate.SCUpdatePB$PushMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.msg.data.h;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.msg.nt_im_msg_body$MsgBody;
import tencent.im.msg.nt_sys_msg_common$Msg;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/qqnt/msg/data/h;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.vas.push.impl.VasSystemPushApiImpl$register$2", f = "VasSystemPushApiImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes20.dex */
final class VasSystemPushApiImpl$register$2 extends SuspendLambda implements Function2<h, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ VasSystemPushApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasSystemPushApiImpl$register$2(VasSystemPushApiImpl vasSystemPushApiImpl, Continuation<? super VasSystemPushApiImpl$register$2> continuation) {
        super(2, continuation);
        this.this$0 = vasSystemPushApiImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        VasSystemPushApiImpl$register$2 vasSystemPushApiImpl$register$2 = new VasSystemPushApiImpl$register$2(this.this$0, continuation);
        vasSystemPushApiImpl$register$2.L$0 = obj;
        return vasSystemPushApiImpl$register$2;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull h hVar, @Nullable Continuation<? super Unit> continuation) {
        return ((VasSystemPushApiImpl$register$2) create(hVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean isEnable;
        nt_im_msg_body$MsgBody nt_im_msg_body_msgbody;
        PBBytesField pBBytesField;
        ByteStringMicro byteStringMicro;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            h hVar = (h) this.L$0;
            try {
                isEnable = this.this$0.isEnable();
            } catch (Error e16) {
                QLog.e("VasSystemPushApiImpl", 1, "receiveSysMsgNotificationFlow exception", e16);
            }
            if (!isEnable) {
                return Unit.INSTANCE;
            }
            if (hVar.d() == 528 && hVar.c() == 365) {
                QLog.i("VasSystemPushApiImpl", 1, "receiveSysMsgNotificationFlow data=" + hVar);
                nt_sys_msg_common$Msg a16 = hVar.a();
                if (a16 != null && (nt_im_msg_body_msgbody = a16.body) != null && (pBBytesField = nt_im_msg_body_msgbody.msg_content) != null && (byteStringMicro = pBBytesField.get()) != null) {
                    VasSystemPushApiImpl vasSystemPushApiImpl = this.this$0;
                    List<SCUpdatePB$Item> list = ((SCUpdatePB$PushMsg) MessageMicro.mergeFrom(new SCUpdatePB$PushMsg(), byteStringMicro.toByteArray())).update_items.get();
                    Intrinsics.checkNotNullExpressionValue(list, "pushMsg.update_items.get()");
                    for (SCUpdatePB$Item sCUpdatePB$Item : list) {
                        int i3 = sCUpdatePB$Item.bid.get();
                        String str = sCUpdatePB$Item.scid.get();
                        Intrinsics.checkNotNullExpressionValue(str, "item.scid.get()");
                        vasSystemPushApiImpl.handlePush0x16d(i3, str);
                    }
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
