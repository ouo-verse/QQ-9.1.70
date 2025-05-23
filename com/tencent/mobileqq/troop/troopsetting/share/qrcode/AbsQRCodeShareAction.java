package com.tencent.mobileqq.troop.troopsetting.share.qrcode;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001b\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0084@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/share/qrcode/AbsQRCodeShareAction;", "Lcom/tencent/mobileqq/troop/troopsetting/share/a;", "", "uin", "g", "Lcom/tencent/mobileqq/troop/troopsetting/share/b;", "shareContext", h.F, "(Lcom/tencent/mobileqq/troop/troopsetting/share/b;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public abstract class AbsQRCodeShareAction extends com.tencent.mobileqq.troop.troopsetting.share.a {
    static IPatchRedirector $redirector_;

    public AbsQRCodeShareAction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String g(String uin) {
        return "temp_qrcode_share_" + uin + ".png";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0046  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h(@NotNull com.tencent.mobileqq.troop.troopsetting.share.b bVar, @NotNull Continuation<? super String> continuation) {
        AbsQRCodeShareAction$saveQRCodeFile$1 absQRCodeShareAction$saveQRCodeFile$1;
        Object coroutine_suspended;
        int i3;
        Ref.ObjectRef objectRef;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar, (Object) continuation);
        }
        if (continuation instanceof AbsQRCodeShareAction$saveQRCodeFile$1) {
            absQRCodeShareAction$saveQRCodeFile$1 = (AbsQRCodeShareAction$saveQRCodeFile$1) continuation;
            int i16 = absQRCodeShareAction$saveQRCodeFile$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                absQRCodeShareAction$saveQRCodeFile$1.label = i16 - Integer.MIN_VALUE;
                Object obj = absQRCodeShareAction$saveQRCodeFile$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = absQRCodeShareAction$saveQRCodeFile$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        objectRef = (Ref.ObjectRef) absQRCodeShareAction$saveQRCodeFile$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    objectRef2.element = "";
                    CoroutineDispatcher io5 = Dispatchers.getIO();
                    AbsQRCodeShareAction$saveQRCodeFile$2 absQRCodeShareAction$saveQRCodeFile$2 = new AbsQRCodeShareAction$saveQRCodeFile$2(bVar, this, objectRef2, null);
                    absQRCodeShareAction$saveQRCodeFile$1.L$0 = objectRef2;
                    absQRCodeShareAction$saveQRCodeFile$1.label = 1;
                    if (BuildersKt.withContext(io5, absQRCodeShareAction$saveQRCodeFile$2, absQRCodeShareAction$saveQRCodeFile$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef = objectRef2;
                }
                return objectRef.element;
            }
        }
        absQRCodeShareAction$saveQRCodeFile$1 = new AbsQRCodeShareAction$saveQRCodeFile$1(this, continuation);
        Object obj2 = absQRCodeShareAction$saveQRCodeFile$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = absQRCodeShareAction$saveQRCodeFile$1.label;
        if (i3 == 0) {
        }
        return objectRef.element;
    }
}
