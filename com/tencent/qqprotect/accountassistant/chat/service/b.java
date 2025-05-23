package com.tencent.qqprotect.accountassistant.chat.service;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.dt.api.IQSecChannel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import yy3.c;
import yy3.d;
import yy3.e;
import yy3.f;
import yy3.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J+\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ9\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J0\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00160\u0015R0\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR6\u0010&\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006)"}, d2 = {"Lcom/tencent/qqprotect/accountassistant/chat/service/b;", "", "Lyy3/d;", "rsp", "Lcom/tencent/qqprotect/accountassistant/chat/data/faceverify/a;", "f", "", "conversationID", "smsCode", "Lcom/tencent/qqprotect/accountassistant/chat/data/basic/a;", "g", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "faceVerityRetCode", "faceToken", "", "smsToken", "c", "(Ljava/lang/String;ILjava/lang/String;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "isResend", "Lkotlin/Function2;", "", "callback", h.F, "Lkotlin/Function1;", "b", "Lkotlin/jvm/functions/Function1;", "d", "()Lkotlin/jvm/functions/Function1;", "j", "(Lkotlin/jvm/functions/Function1;)V", "checkFaceCallback", "Lkotlin/jvm/functions/Function2;", "e", "()Lkotlin/jvm/functions/Function2;", "k", "(Lkotlin/jvm/functions/Function2;)V", "findPwdSuccessCallback", "<init>", "()V", "qqprotect-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f363485a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Function1<? super Boolean, Unit> checkFaceCallback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Function2<? super String, ? super String, Unit> findPwdSuccessCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "ret", "", "response", "", "kotlin.jvm.PlatformType", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    static final class a implements com.tencent.mobileqq.dt.api.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f363488a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f363489b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Continuation<com.tencent.qqprotect.accountassistant.chat.data.basic.a<String>> f363490c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f363491d;

        a(String str, String str2, Continuation<? super com.tencent.qqprotect.accountassistant.chat.data.basic.a<String>> continuation, int i3) {
            this.f363488a = str;
            this.f363489b = str2;
            this.f363490c = continuation;
            this.f363491d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, continuation, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.mobileqq.dt.api.a
        public final void onResult(int i3, byte[] bArr) {
            Integer num;
            int i16;
            String str;
            Function1<Boolean, Unit> d16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) bArr);
                return;
            }
            boolean z16 = true;
            QLog.i("AssistantRobotFaceVerifyService", 1, "checkFace, onResult: " + i3 + " faceToken\uff1a " + this.f363488a + " conversationID: " + this.f363489b);
            if (i3 != 0) {
                Continuation<com.tencent.qqprotect.accountassistant.chat.data.basic.a<String>> continuation = this.f363490c;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(new com.tencent.qqprotect.accountassistant.chat.data.basic.a(false, i3, "", "", false, 16, null)));
                return;
            }
            try {
                yy3.b c16 = yy3.b.c(bArr);
                e eVar = c16.f451557a;
                String str2 = null;
                if (eVar != null) {
                    num = Integer.valueOf(eVar.f451569a);
                } else {
                    num = null;
                }
                QLog.i("AssistantRobotFaceVerifyService", 1, "checkFace, rsp code: " + num);
                e eVar2 = c16.f451557a;
                int i17 = -1;
                if (eVar2 != null) {
                    i16 = eVar2.f451569a;
                } else {
                    i16 = -1;
                }
                if (i16 != 0) {
                    z16 = false;
                }
                boolean z17 = z16;
                if (z17) {
                    if (this.f363491d == 0 && (d16 = b.f363485a.d()) != null) {
                        d16.invoke(Boolean.TRUE);
                    }
                    Function2<String, String, Unit> e16 = b.f363485a.e();
                    if (e16 != null) {
                        String str3 = c16.f451558b;
                        Intrinsics.checkNotNullExpressionValue(str3, "rsp.userAccount");
                        String str4 = c16.f451559c;
                        Intrinsics.checkNotNullExpressionValue(str4, "rsp.userPwd");
                        e16.invoke(str3, str4);
                    }
                }
                Continuation<com.tencent.qqprotect.accountassistant.chat.data.basic.a<String>> continuation2 = this.f363490c;
                e eVar3 = c16.f451557a;
                if (eVar3 != null) {
                    i17 = eVar3.f451569a;
                }
                int i18 = i17;
                if (eVar3 != null) {
                    str2 = eVar3.f451570b;
                }
                if (str2 == null) {
                    str = "";
                } else {
                    str = str2;
                }
                continuation2.resumeWith(Result.m476constructorimpl(new com.tencent.qqprotect.accountassistant.chat.data.basic.a(z17, i18, str, this.f363489b, false, 16, null)));
            } catch (InvalidProtocolBufferNanoException e17) {
                QLog.e("AssistantRobotFaceVerifyService", 1, "checkFace, InvalidProtocolBufferNanoException: " + e17.getMessage());
                Continuation<com.tencent.qqprotect.accountassistant.chat.data.basic.a<String>> continuation3 = this.f363490c;
                Result.Companion companion2 = Result.INSTANCE;
                continuation3.resumeWith(Result.m476constructorimpl(new com.tencent.qqprotect.accountassistant.chat.data.basic.a(false, -1, "", "", false, 16, null)));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "ret", "", "response", "", "kotlin.jvm.PlatformType", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.qqprotect.accountassistant.chat.service.b$b, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    static final class C9713b implements com.tencent.mobileqq.dt.api.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<com.tencent.qqprotect.accountassistant.chat.data.basic.a<com.tencent.qqprotect.accountassistant.chat.data.faceverify.a>> f363492a;

        /* JADX WARN: Multi-variable type inference failed */
        C9713b(Continuation<? super com.tencent.qqprotect.accountassistant.chat.data.basic.a<com.tencent.qqprotect.accountassistant.chat.data.faceverify.a>> continuation) {
            this.f363492a = continuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) continuation);
            }
        }

        @Override // com.tencent.mobileqq.dt.api.a
        public final void onResult(int i3, byte[] bArr) {
            Integer num;
            int i16;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) bArr);
                return;
            }
            QLog.i("AssistantRobotFaceVerifyService", 1, "queryUserData, onResult: " + i3);
            if (i3 != 0) {
                Continuation<com.tencent.qqprotect.accountassistant.chat.data.basic.a<com.tencent.qqprotect.accountassistant.chat.data.faceverify.a>> continuation = this.f363492a;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(new com.tencent.qqprotect.accountassistant.chat.data.basic.a(false, i3, "", null, false, 16, null)));
                return;
            }
            try {
                d rsp = d.c(bArr);
                e eVar = rsp.f451562a;
                String str2 = null;
                if (eVar != null) {
                    num = Integer.valueOf(eVar.f451569a);
                } else {
                    num = null;
                }
                QLog.i("AssistantRobotFaceVerifyService", 1, "queryUserData, rsp code: " + num);
                e eVar2 = rsp.f451562a;
                int i17 = -1;
                if (eVar2 != null) {
                    i16 = eVar2.f451569a;
                } else {
                    i16 = -1;
                }
                if (i16 != 0) {
                    Continuation<com.tencent.qqprotect.accountassistant.chat.data.basic.a<com.tencent.qqprotect.accountassistant.chat.data.faceverify.a>> continuation2 = this.f363492a;
                    if (eVar2 != null) {
                        i17 = eVar2.f451569a;
                    }
                    int i18 = i17;
                    if (eVar2 != null) {
                        str2 = eVar2.f451570b;
                    }
                    if (str2 == null) {
                        str = "";
                    } else {
                        str = str2;
                    }
                    continuation2.resumeWith(Result.m476constructorimpl(new com.tencent.qqprotect.accountassistant.chat.data.basic.a(false, i18, str, null, false, 16, null)));
                    return;
                }
                b bVar = b.f363485a;
                Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                com.tencent.qqprotect.accountassistant.chat.data.faceverify.a f16 = bVar.f(rsp);
                Continuation<com.tencent.qqprotect.accountassistant.chat.data.basic.a<com.tencent.qqprotect.accountassistant.chat.data.faceverify.a>> continuation3 = this.f363492a;
                Result.Companion companion2 = Result.INSTANCE;
                continuation3.resumeWith(Result.m476constructorimpl(new com.tencent.qqprotect.accountassistant.chat.data.basic.a(true, i3, "", f16, false, 16, null)));
            } catch (InvalidProtocolBufferNanoException e16) {
                QLog.e("AssistantRobotFaceVerifyService", 1, "queryUserData, InvalidProtocolBufferNanoException: " + e16.getMessage());
                Continuation<com.tencent.qqprotect.accountassistant.chat.data.basic.a<com.tencent.qqprotect.accountassistant.chat.data.faceverify.a>> continuation4 = this.f363492a;
                Result.Companion companion3 = Result.INSTANCE;
                continuation4.resumeWith(Result.m476constructorimpl(new com.tencent.qqprotect.accountassistant.chat.data.basic.a(false, -1, "", null, false, 16, null)));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17667);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f363485a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.qqprotect.accountassistant.chat.data.faceverify.a f(d rsp) {
        String str = rsp.f451563b;
        Intrinsics.checkNotNullExpressionValue(str, "rsp.idName");
        String str2 = rsp.f451564c;
        Intrinsics.checkNotNullExpressionValue(str2, "rsp.idNo");
        String str3 = rsp.f451566e;
        Intrinsics.checkNotNullExpressionValue(str3, "rsp.faceTemkey");
        long j3 = rsp.f451567f;
        byte[] bArr = rsp.f451568g;
        Intrinsics.checkNotNullExpressionValue(bArr, "rsp.smsToken");
        return new com.tencent.qqprotect.accountassistant.chat.data.faceverify.a(str, str2, str3, j3, bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function2 callback, int i3, byte[] bArr) {
        Integer num;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        QLog.i("AssistantRobotFaceVerifyService", 1, "sendSms ret is " + i3);
        String str = "";
        if (i3 != 0) {
            callback.invoke(Integer.valueOf(i3), "");
            return;
        }
        int i16 = -1;
        try {
            g c16 = g.c(bArr);
            e eVar = c16.f451573a;
            String str2 = null;
            if (eVar != null) {
                num = Integer.valueOf(eVar.f451569a);
            } else {
                num = null;
            }
            QLog.i("AssistantRobotFaceVerifyService", 1, "sendSms, rsp code: " + num);
            e eVar2 = c16.f451573a;
            if (eVar2 != null) {
                i16 = eVar2.f451569a;
            }
            Integer valueOf = Integer.valueOf(i16);
            e eVar3 = c16.f451573a;
            if (eVar3 != null) {
                str2 = eVar3.f451570b;
            }
            if (str2 != null) {
                str = str2;
            }
            callback.invoke(valueOf, str);
        } catch (InvalidProtocolBufferNanoException e16) {
            QLog.e("AssistantRobotFaceVerifyService", 1, "sendSms, InvalidProtocolBufferNanoException: " + e16.getMessage());
            callback.invoke(-1, "");
        }
    }

    @Nullable
    public final Object c(@NotNull String str, int i3, @NotNull String str2, @NotNull byte[] bArr, @NotNull Continuation<? super com.tencent.qqprotect.accountassistant.chat.data.basic.a<String>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        Function1<? super Boolean, Unit> function1;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            SafeContinuation safeContinuation = new SafeContinuation(intercepted);
            QLog.i("AssistantRobotFaceVerifyService", 1, "checkFace, conversationID: " + str + " faceVerityRetCode\uff1a " + i3);
            if (i3 != 0 && (function1 = checkFaceCallback) != null) {
                function1.invoke(Boxing.boxBoolean(false));
            }
            yy3.a aVar = new yy3.a();
            aVar.f451553a = str;
            aVar.f451554b = str2;
            aVar.f451555c = bArr;
            aVar.f451556d = i3;
            IQSecChannel iQSecChannel = (IQSecChannel) QRoute.api(IQSecChannel.class);
            AppRuntime a16 = zy3.a.a();
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
            iQSecChannel.sendRequest((AppInterface) a16, "checkFace", MessageNano.toByteArray(aVar), new a(str2, str, safeContinuation, i3));
            Object orThrow = safeContinuation.getOrThrow();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (orThrow == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return orThrow;
        }
        return iPatchRedirector.redirect((short) 7, this, str, Integer.valueOf(i3), str2, bArr, continuation);
    }

    @Nullable
    public final Function1<Boolean, Unit> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Function1) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return checkFaceCallback;
    }

    @Nullable
    public final Function2<String, String, Unit> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Function2) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return findPwdSuccessCallback;
    }

    @Nullable
    public final Object g(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super com.tencent.qqprotect.accountassistant.chat.data.basic.a<com.tencent.qqprotect.accountassistant.chat.data.faceverify.a>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            SafeContinuation safeContinuation = new SafeContinuation(intercepted);
            c cVar = new c();
            cVar.f451560a = str;
            cVar.f451561b = str2;
            IQSecChannel iQSecChannel = (IQSecChannel) QRoute.api(IQSecChannel.class);
            AppRuntime a16 = zy3.a.a();
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
            iQSecChannel.sendRequest((AppInterface) a16, "queryUserData", MessageNano.toByteArray(cVar), new C9713b(safeContinuation));
            Object orThrow = safeContinuation.getOrThrow();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (orThrow == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return orThrow;
        }
        return iPatchRedirector.redirect((short) 6, this, str, str2, continuation);
    }

    public final void h(@NotNull String conversationID, boolean isResend, @NotNull final Function2<? super Integer, ? super String, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, conversationID, Boolean.valueOf(isResend), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(conversationID, "conversationID");
        Intrinsics.checkNotNullParameter(callback, "callback");
        f fVar = new f();
        fVar.f451571a = conversationID;
        fVar.f451572b = isResend;
        IQSecChannel iQSecChannel = (IQSecChannel) QRoute.api(IQSecChannel.class);
        AppRuntime a16 = zy3.a.a();
        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        iQSecChannel.sendRequest((AppInterface) a16, "sendSMSCode", MessageNano.toByteArray(fVar), new com.tencent.mobileqq.dt.api.a() { // from class: com.tencent.qqprotect.accountassistant.chat.service.a
            @Override // com.tencent.mobileqq.dt.api.a
            public final void onResult(int i3, byte[] bArr) {
                b.i(Function2.this, i3, bArr);
            }
        });
    }

    public final void j(@Nullable Function1<? super Boolean, Unit> function1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) function1);
        } else {
            checkFaceCallback = function1;
        }
    }

    public final void k(@Nullable Function2<? super String, ? super String, Unit> function2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) function2);
        } else {
            findPwdSuccessCallback = function2;
        }
    }
}
