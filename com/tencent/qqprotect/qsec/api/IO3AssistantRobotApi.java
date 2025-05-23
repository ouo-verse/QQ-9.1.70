package com.tencent.qqprotect.qsec.api;

import android.content.Context;
import com.tencent.kuikly.core.render.android.b;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001:\u0001 J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&J+\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J2\u0010\u0019\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00142\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\u0016H&J9\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001cH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006!"}, d2 = {"Lcom/tencent/qqprotect/qsec/api/IO3AssistantRobotApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "Lcom/tencent/qqprotect/qsec/api/a;", "userAccountInfo", "Lcom/tencent/qqprotect/qsec/api/IO3AssistantRobotApi$a;", "openCallback", "", "openO3AssistantRobotChatFrame", "Lcom/tencent/kuikly/core/render/android/b;", "renderExport", "registerExternalModule", "", "conversationId", "smsCode", "Lcom/tencent/qqprotect/accountassistant/chat/data/basic/a;", "Lcom/tencent/qqprotect/accountassistant/chat/data/faceverify/a;", "getFaceVerifyUserData", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "isResend", "Lkotlin/Function2;", "", "callback", "sendSmsCode", "faceVerityRetCode", "token", "", "smsToken", "accountAssistantCheckFace", "(Ljava/lang/String;ILjava/lang/String;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "qqprotect-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IO3AssistantRobotApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqprotect/qsec/api/IO3AssistantRobotApi$a;", "", "", "onSuccess", "", "errorCode", "", "errorMsg", "onFailed", "qqprotect-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public interface a {
        void onFailed(int errorCode, @NotNull String errorMsg);

        void onSuccess();
    }

    @Nullable
    Object accountAssistantCheckFace(@NotNull String str, int i3, @NotNull String str2, @NotNull byte[] bArr, @NotNull Continuation<? super com.tencent.qqprotect.accountassistant.chat.data.basic.a<String>> continuation);

    @Nullable
    Object getFaceVerifyUserData(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super com.tencent.qqprotect.accountassistant.chat.data.basic.a<com.tencent.qqprotect.accountassistant.chat.data.faceverify.a>> continuation);

    void openO3AssistantRobotChatFrame(@NotNull Context context, @NotNull com.tencent.qqprotect.qsec.api.a userAccountInfo, @NotNull a openCallback);

    void registerExternalModule(@NotNull b renderExport);

    void sendSmsCode(@NotNull String conversationId, boolean isResend, @NotNull Function2<? super Integer, ? super String, Unit> callback);
}
