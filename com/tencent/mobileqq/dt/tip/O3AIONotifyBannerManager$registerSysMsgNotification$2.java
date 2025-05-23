package com.tencent.mobileqq.dt.tip;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.msg.data.h;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.msg.nt_im_msg_body$MsgBody;
import tencent.im.msg.nt_sys_msg_common$Msg;
import tencent.im.msg.nt_sys_msg_common$RoutingHead;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/qqnt/msg/data/h;", "data", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.dt.tip.O3AIONotifyBannerManager$registerSysMsgNotification$2", f = "O3AIONotifyBannerManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class O3AIONotifyBannerManager$registerSysMsgNotification$2 extends SuspendLambda implements Function2<h, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public O3AIONotifyBannerManager$registerSysMsgNotification$2(Continuation<? super O3AIONotifyBannerManager$registerSysMsgNotification$2> continuation) {
        super(2, continuation);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        O3AIONotifyBannerManager$registerSysMsgNotification$2 o3AIONotifyBannerManager$registerSysMsgNotification$2 = new O3AIONotifyBannerManager$registerSysMsgNotification$2(continuation);
        o3AIONotifyBannerManager$registerSysMsgNotification$2.L$0 = obj;
        return o3AIONotifyBannerManager$registerSysMsgNotification$2;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull h hVar, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((O3AIONotifyBannerManager$registerSysMsgNotification$2) create(hVar, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) hVar, (Object) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        boolean z16;
        nt_im_msg_body$MsgBody nt_im_msg_body_msgbody;
        PBBytesField pBBytesField;
        ByteStringMicro byteStringMicro;
        nt_sys_msg_common$RoutingHead nt_sys_msg_common_routinghead;
        PBBytesField pBBytesField2;
        ByteStringMicro byteStringMicro2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                h hVar = (h) this.L$0;
                if (hVar.c() != 377) {
                    return Unit.INSTANCE;
                }
                nt_sys_msg_common$Msg a16 = hVar.a();
                byte[] bArr = null;
                if (a16 != null && (nt_sys_msg_common_routinghead = a16.routing_head) != null && (pBBytesField2 = nt_sys_msg_common_routinghead.from_uid) != null && (byteStringMicro2 = pBBytesField2.get()) != null) {
                    str = byteStringMicro2.toStringUtf8();
                } else {
                    str = null;
                }
                if (str == null) {
                    str = "";
                }
                boolean z17 = false;
                if (str.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    QLog.e("O3AIONotifyBannerManager", 1, "uid empty");
                    return Unit.INSTANCE;
                }
                nt_sys_msg_common$Msg a17 = hVar.a();
                if (a17 != null && (nt_im_msg_body_msgbody = a17.body) != null && (pBBytesField = nt_im_msg_body_msgbody.msg_content) != null && (byteStringMicro = pBBytesField.get()) != null) {
                    bArr = byteStringMicro.toByteArray();
                }
                try {
                    b bVar = a.c(bArr).f203884b;
                    if (bVar == null) {
                        QLog.e("O3AIONotifyBannerManager", 1, "notifyBanner is null");
                        return Unit.INSTANCE;
                    }
                    String str2 = bVar.f203885a;
                    if (str2 == null || str2.length() == 0) {
                        z17 = true;
                    }
                    if (!z17) {
                        O3AIONotifyBannerManager.f203873a.f(str, bVar);
                        return Unit.INSTANCE;
                    }
                    QLog.e("O3AIONotifyBannerManager", 1, "notifyBanner text is empty");
                    return Unit.INSTANCE;
                } catch (Throwable unused) {
                    QLog.e("O3AIONotifyBannerManager", 1, "parse error");
                    return Unit.INSTANCE;
                }
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }
}
