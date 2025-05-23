package com.tencent.qqnt.aio.interceptor;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import com.tencent.qqnt.kernel.nativeinterface.TempChatPrepareInfo;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J=\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rJ2\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u001b\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/aio/interceptor/BaseTempAIOStartInterceptor;", "Lcom/tencent/qqnt/aio/interceptor/g;", "Landroid/content/Context;", "context", "", "chatType", "", "uid", "nick", "Landroid/os/Bundle;", "extra", "", "b", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernel/nativeinterface/TempChatPrepareInfo;", "c", "info", "e", "(Lcom/tencent/qqnt/kernel/nativeinterface/TempChatPrepareInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "a", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public abstract class BaseTempAIOStartInterceptor implements g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/interceptor/BaseTempAIOStartInterceptor$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.interceptor.BaseTempAIOStartInterceptor$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "result", "", "errMsg", "", "kotlin.jvm.PlatformType", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class b implements IOperateCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Boolean> f351157a;

        /* JADX WARN: Multi-variable type inference failed */
        b(CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.f351157a = cancellableContinuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cancellableContinuation);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
        public final void onResult(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
                return;
            }
            boolean z16 = true;
            QLog.d("BaseTempAIOStartInterceptor", 1, "prepareTempChat result=" + i3 + " err=" + str);
            if (this.f351157a.isActive()) {
                CancellableContinuation<Boolean> cancellableContinuation = this.f351157a;
                Result.Companion companion = Result.INSTANCE;
                if (i3 != 0) {
                    z16 = false;
                }
                cancellableContinuation.resumeWith(Result.m476constructorimpl(Boolean.valueOf(z16)));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51110);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public BaseTempAIOStartInterceptor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ Object d(BaseTempAIOStartInterceptor baseTempAIOStartInterceptor, Context context, int i3, String str, String str2, Bundle bundle, Continuation<? super Boolean> continuation) {
        BaseTempAIOStartInterceptor$interceptStartAIO$1 baseTempAIOStartInterceptor$interceptStartAIO$1;
        Object coroutine_suspended;
        int i16;
        if (continuation instanceof BaseTempAIOStartInterceptor$interceptStartAIO$1) {
            baseTempAIOStartInterceptor$interceptStartAIO$1 = (BaseTempAIOStartInterceptor$interceptStartAIO$1) continuation;
            int i17 = baseTempAIOStartInterceptor$interceptStartAIO$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                baseTempAIOStartInterceptor$interceptStartAIO$1.label = i17 - Integer.MIN_VALUE;
                Object obj = baseTempAIOStartInterceptor$interceptStartAIO$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = baseTempAIOStartInterceptor$interceptStartAIO$1.label;
                if (i16 == 0) {
                    if (i16 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    TempChatPrepareInfo c16 = baseTempAIOStartInterceptor.c(context, i3, str, str2, bundle);
                    baseTempAIOStartInterceptor$interceptStartAIO$1.label = 1;
                    if (baseTempAIOStartInterceptor.e(c16, baseTempAIOStartInterceptor$interceptStartAIO$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Boxing.boxBoolean(false);
            }
        }
        baseTempAIOStartInterceptor$interceptStartAIO$1 = new BaseTempAIOStartInterceptor$interceptStartAIO$1(baseTempAIOStartInterceptor, continuation);
        Object obj2 = baseTempAIOStartInterceptor$interceptStartAIO$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = baseTempAIOStartInterceptor$interceptStartAIO$1.label;
        if (i16 == 0) {
        }
        return Boxing.boxBoolean(false);
    }

    @Override // com.tencent.qqnt.aio.interceptor.g
    @Nullable
    public Object b(@NotNull Context context, int i3, @NotNull String str, @NotNull String str2, @Nullable Bundle bundle, @NotNull Continuation<? super Boolean> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, this, context, Integer.valueOf(i3), str, str2, bundle, continuation);
        }
        return d(this, context, i3, str, str2, bundle, continuation);
    }

    @NotNull
    public TempChatPrepareInfo c(@NotNull Context context, int chatType, @NotNull String uid, @NotNull String nick, @Nullable Bundle extra) {
        int checkRadix;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TempChatPrepareInfo) iPatchRedirector.redirect((short) 3, this, context, Integer.valueOf(chatType), uid, nick, extra);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(nick, "nick");
        byte[] bArr = new byte[0];
        String currentUid = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUid();
        long j3 = 0;
        if (extra != null) {
            extra.getLong("key_peerUin", 0L);
        }
        if (extra != null) {
            j3 = extra.getLong("key_groupUin", 0L);
        }
        if (QLog.isColorLevel()) {
            QLog.d("BaseTempAIOStartInterceptor", 2, "makeTempChatPrepareInfo chatType: " + chatType + ", uid:" + uid + " nick: " + nick + ", groupUin: " + j3);
        }
        checkRadix = CharsKt__CharJVMKt.checkRadix(10);
        String l3 = Long.toString(j3, checkRadix);
        Intrinsics.checkNotNullExpressionValue(l3, "toString(this, checkRadix(radix))");
        return new TempChatPrepareInfo(chatType, uid, nick, l3, bArr, currentUid, "", new TempChatGameSession());
    }

    @Nullable
    public final Object e(@NotNull TempChatPrepareInfo tempChatPrepareInfo, @NotNull Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            w msgService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "")).getMsgService();
            if (msgService != null) {
                msgService.prepareTempChat(tempChatPrepareInfo, new b(cancellableContinuationImpl));
            } else {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(Boxing.boxBoolean(false)));
            }
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        return iPatchRedirector.redirect((short) 4, (Object) this, (Object) tempChatPrepareInfo, (Object) continuation);
    }
}
