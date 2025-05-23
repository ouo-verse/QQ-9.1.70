package com.tencent.qne;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qne.delegate.b;
import com.tencent.qne.delegate.c;
import com.tencent.qne.delegate.d;
import com.tencent.qne.model.DependencyLibrary;
import com.tencent.qne.util.Logger;
import com.tencent.qne.util.Reporter;
import com.tencent.qne.util.SoLoader;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J7\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fR$\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\r\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qne/QneSDK;", "", "Landroid/content/Context;", "context", "Lcom/tencent/qne/delegate/d;", "shiplyDelegate", "Lcom/tencent/qne/delegate/b;", "loggerDelegate", "Lcom/tencent/qne/delegate/c;", "reporterDelegate", "Lcom/tencent/qne/util/d;", "c", "(Landroid/content/Context;Lcom/tencent/qne/delegate/d;Lcom/tencent/qne/delegate/b;Lcom/tencent/qne/delegate/c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "b", "Lcom/tencent/qne/delegate/d;", "a", "()Lcom/tencent/qne/delegate/d;", "(Lcom/tencent/qne/delegate/d;)V", "shiply", "<init>", "()V", "qne_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes22.dex */
public final class QneSDK {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QneSDK f344322a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static d shiply;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14494);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f344322a = new QneSDK();
        }
    }

    QneSDK() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final d a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (d) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return shiply;
    }

    public final void b(@Nullable d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) dVar);
        } else {
            shiply = dVar;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0059  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object c(@NotNull Context context, @NotNull d dVar, @NotNull b bVar, @Nullable c cVar, @NotNull Continuation<? super com.tencent.qne.util.d> continuation) {
        QneSDK$setup$1 qneSDK$setup$1;
        Object coroutine_suspended;
        int i3;
        String str;
        List listOf;
        com.tencent.qne.util.d dVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, this, context, dVar, bVar, cVar, continuation);
        }
        if (continuation instanceof QneSDK$setup$1) {
            qneSDK$setup$1 = (QneSDK$setup$1) continuation;
            int i16 = qneSDK$setup$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                qneSDK$setup$1.label = i16 - Integer.MIN_VALUE;
                Object obj = qneSDK$setup$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = qneSDK$setup$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        str = (String) qneSDK$setup$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    QneFoundationHelper.INSTANCE.init(context);
                    Logger.INSTANCE.init(bVar);
                    Reporter.INSTANCE.init(cVar);
                    b(dVar);
                    str = context.getFilesDir() + "/QNE/so";
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(DependencyLibrary.QNE_CORE);
                    SoLoader soLoader = new SoLoader(dVar, str, listOf);
                    qneSDK$setup$1.L$0 = str;
                    qneSDK$setup$1.label = 1;
                    obj = soLoader.e(qneSDK$setup$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                dVar2 = (com.tencent.qne.util.d) obj;
                if (dVar2.b()) {
                    QneFoundationHelper.INSTANCE.appendDspLibraryPath(str);
                }
                return dVar2;
            }
        }
        qneSDK$setup$1 = new QneSDK$setup$1(this, continuation);
        Object obj2 = qneSDK$setup$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = qneSDK$setup$1.label;
        if (i3 == 0) {
        }
        dVar2 = (com.tencent.qne.util.d) obj2;
        if (dVar2.b()) {
        }
        return dVar2;
    }
}
