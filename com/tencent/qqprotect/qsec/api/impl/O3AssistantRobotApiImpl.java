package com.tencent.qqprotect.qsec.api.impl;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.accountassistant.chat.service.b;
import com.tencent.qqprotect.qsec.api.IO3AssistantRobotApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\b\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J+\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J2\u0010\u0019\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00142\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\u0016H\u0016J9\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001cH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006$"}, d2 = {"Lcom/tencent/qqprotect/qsec/api/impl/O3AssistantRobotApiImpl;", "Lcom/tencent/qqprotect/qsec/api/IO3AssistantRobotApi;", "Landroid/content/Context;", "context", "Lcom/tencent/qqprotect/qsec/api/a;", "userAccountInfo", "Lcom/tencent/qqprotect/qsec/api/IO3AssistantRobotApi$a;", "openCallback", "", "openO3AssistantRobotChatFrame", "Lcom/tencent/kuikly/core/render/android/b;", "renderExport", "registerExternalModule", "", "conversationId", "smsCode", "Lcom/tencent/qqprotect/accountassistant/chat/data/basic/a;", "Lcom/tencent/qqprotect/accountassistant/chat/data/faceverify/a;", "getFaceVerifyUserData", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "isResend", "Lkotlin/Function2;", "", "callback", "sendSmsCode", "faceVerityRetCode", "token", "", "smsToken", "accountAssistantCheckFace", "(Ljava/lang/String;ILjava/lang/String;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "Companion", "a", "qqprotect-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class O3AssistantRobotApiImpl implements IO3AssistantRobotApi {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    private static final a Companion;

    @Deprecated
    @NotNull
    private static final String TAG = "O3AssistantRobotApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqprotect/qsec/api/impl/O3AssistantRobotApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqprotect-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17701);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            Companion = new a(null);
        }
    }

    public O3AssistantRobotApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqprotect.qsec.api.IO3AssistantRobotApi
    @Nullable
    public Object accountAssistantCheckFace(@NotNull String str, int i3, @NotNull String str2, @NotNull byte[] bArr, @NotNull Continuation<? super com.tencent.qqprotect.accountassistant.chat.data.basic.a<String>> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), str2, bArr, continuation);
        }
        return b.f363485a.c(str, i3, str2, bArr, continuation);
    }

    @Override // com.tencent.qqprotect.qsec.api.IO3AssistantRobotApi
    @Nullable
    public Object getFaceVerifyUserData(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super com.tencent.qqprotect.accountassistant.chat.data.basic.a<com.tencent.qqprotect.accountassistant.chat.data.faceverify.a>> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, this, str, str2, continuation);
        }
        return b.f363485a.g(str, str2, continuation);
    }

    @Override // com.tencent.qqprotect.qsec.api.IO3AssistantRobotApi
    public void openO3AssistantRobotChatFrame(@NotNull Context context, @NotNull com.tencent.qqprotect.qsec.api.a userAccountInfo, @NotNull IO3AssistantRobotApi.a openCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, userAccountInfo, openCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(userAccountInfo, "userAccountInfo");
        Intrinsics.checkNotNullParameter(openCallback, "openCallback");
        QLog.i(TAG, 1, "openO3AssistantRobotChatFrame, userInfo: " + userAccountInfo);
        com.tencent.qqprotect.qsec.utils.a.f363534a.c(context, userAccountInfo, openCallback);
    }

    @Override // com.tencent.qqprotect.qsec.api.IO3AssistantRobotApi
    public void registerExternalModule(@NotNull com.tencent.kuikly.core.render.android.b renderExport) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) renderExport);
        } else {
            Intrinsics.checkNotNullParameter(renderExport, "renderExport");
            renderExport.a("QQKuiklyFindPwdRobotModule", O3AssistantRobotApiImpl$registerExternalModule$1.INSTANCE);
        }
    }

    @Override // com.tencent.qqprotect.qsec.api.IO3AssistantRobotApi
    public void sendSmsCode(@NotNull String conversationId, boolean isResend, @NotNull Function2<? super Integer, ? super String, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, conversationId, Boolean.valueOf(isResend), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        b.f363485a.h(conversationId, isResend, callback);
    }
}
