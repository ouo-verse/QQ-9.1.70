package com.tencent.mobileqq.guild.feed.jsbridge.methods.detail;

import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.guild.util.Logger;
import com.vivo.push.PushClientConstants;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000f2\u00020\u0001:\u0002\u0010\u0011B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ&\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\b\u001a\u00020\u0002H\u0014R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/jsbridge/methods/detail/AutoTopGuildMethod;", "Lcom/tencent/mobileqq/guild/feed/jsbridge/methods/detail/c;", "", "url", PushClientConstants.TAG_PKG_NAME, "method", "", "o", "k", "Leipc/EIPCResultCallback;", tl.h.F, "Leipc/EIPCResultCallback;", "ipcCallback", "<init>", "()V", "i", "a", "InvokeResult", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class AutoTopGuildMethod extends c {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final EIPCResultCallback ipcCallback = new EIPCResultCallback() { // from class: com.tencent.mobileqq.guild.feed.jsbridge.methods.detail.a
        @Override // eipc.EIPCResultCallback
        public final void onCallback(EIPCResult eIPCResult) {
            AutoTopGuildMethod.q(AutoTopGuildMethod.this, eIPCResult);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Keep
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/jsbridge/methods/detail/AutoTopGuildMethod$InvokeResult;", "", "", "toJson", "", "code", "I", "getCode", "()I", "setCode", "(I)V", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "<init>", "()V", "Companion", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class InvokeResult {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @SerializedName("result")
        private int code;

        @SerializedName("msg")
        @Nullable
        private String message;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/jsbridge/methods/detail/AutoTopGuildMethod$InvokeResult$a;", "", "", "code", "", "message", "Lcom/tencent/mobileqq/guild/feed/jsbridge/methods/detail/AutoTopGuildMethod$InvokeResult;", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.feed.jsbridge.methods.detail.AutoTopGuildMethod$InvokeResult$a, reason: from kotlin metadata */
        /* loaded from: classes13.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final InvokeResult a(int code, @Nullable String message) {
                InvokeResult invokeResult = new InvokeResult();
                invokeResult.setCode(code);
                invokeResult.setMessage(message);
                return invokeResult;
            }

            Companion() {
            }
        }

        public final int getCode() {
            return this.code;
        }

        @Nullable
        public final String getMessage() {
            return this.message;
        }

        public final void setCode(int i3) {
            this.code = i3;
        }

        public final void setMessage(@Nullable String str) {
            this.message = str;
        }

        @NotNull
        public final String toJson() {
            String json = new Gson().toJson(this);
            Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(this)");
            return json;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(AutoTopGuildMethod this$0, EIPCResult eIPCResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!eIPCResult.isSuccess()) {
            this$0.i(InvokeResult.INSTANCE.a(-201, "IPC\u9519\u8bef: " + eIPCResult.code).toJson());
            Logger.f235387a.d().i("AutoTopGuildMethod", 1, "auto top IPC\u9519\u8bef result=" + eIPCResult.code);
            return;
        }
        this$0.i(InvokeResult.INSTANCE.a(eIPCResult.data.getInt("errCode"), eIPCResult.data.getString("errMsg")).toJson());
        Logger.f235387a.d().i("AutoTopGuildMethod", 1, "auto top code=" + eIPCResult.data.getInt("errCode") + " msg=" + eIPCResult.data.getString("errMsg"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    @NotNull
    public String k() {
        return "autoTopGuild";
    }

    @Override // ok1.a
    protected boolean o(@Nullable String url, @Nullable String pkgName, @Nullable String method) {
        Logger.f235387a.d().i("AutoTopGuildMethod", 1, "AutoTopGuildMethod invoke guildId=" + g("guildId") + " source=" + g("source"));
        com.tencent.mobileqq.guild.util.y.b(com.tencent.mobileqq.guild.ipc.methods.i.class, this.ipcCallback, g("guildId"), g("source"));
        return true;
    }
}
