package com.tencent.mobileqq.guild.webview.methods;

import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.guild.ipc.methods.aw;
import com.vivo.push.PushClientConstants;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0014\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/webview/methods/RefreshGuildListMethod;", "Lcom/tencent/mobileqq/guild/webview/methods/a;", "Leipc/EIPCResultCallback;", "l", "", "url", PushClientConstants.TAG_PKG_NAME, "method", "", "k", "<init>", "()V", "InvokeResult", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class RefreshGuildListMethod extends com.tencent.mobileqq.guild.webview.methods.a {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Keep
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0083\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u001d\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u001f\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002H\u00c6\u0001J\t\u0010\n\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/webview/methods/RefreshGuildListMethod$InvokeResult;", "", "", "toJson", "", "component1", "component2", "result", "message", "copy", "toString", "hashCode", "other", "", "equals", "I", "getResult", "()I", "setResult", "(I)V", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "<init>", "(ILjava/lang/String;)V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final /* data */ class InvokeResult {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @SerializedName("msg")
        @Nullable
        private String message;

        @SerializedName("result")
        private int result;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/webview/methods/RefreshGuildListMethod$InvokeResult$a;", "", "Landroid/os/Bundle;", "bundle", "Lcom/tencent/mobileqq/guild/webview/methods/RefreshGuildListMethod$InvokeResult;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.webview.methods.RefreshGuildListMethod$InvokeResult$a, reason: from kotlin metadata */
        /* loaded from: classes14.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final InvokeResult a(@NotNull Bundle bundle) {
                Intrinsics.checkNotNullParameter(bundle, "bundle");
                return new InvokeResult(bundle.getInt("result"), bundle.getString("msg", ""));
            }

            Companion() {
            }
        }

        public InvokeResult() {
            this(0, null, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ InvokeResult copy$default(InvokeResult invokeResult, int i3, String str, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                i3 = invokeResult.result;
            }
            if ((i16 & 2) != 0) {
                str = invokeResult.message;
            }
            return invokeResult.copy(i3, str);
        }

        /* renamed from: component1, reason: from getter */
        public final int getResult() {
            return this.result;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        @NotNull
        public final InvokeResult copy(int result, @Nullable String message) {
            return new InvokeResult(result, message);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InvokeResult)) {
                return false;
            }
            InvokeResult invokeResult = (InvokeResult) other;
            if (this.result == invokeResult.result && Intrinsics.areEqual(this.message, invokeResult.message)) {
                return true;
            }
            return false;
        }

        @Nullable
        public final String getMessage() {
            return this.message;
        }

        public final int getResult() {
            return this.result;
        }

        public int hashCode() {
            int hashCode;
            int i3 = this.result * 31;
            String str = this.message;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            return i3 + hashCode;
        }

        public final void setMessage(@Nullable String str) {
            this.message = str;
        }

        public final void setResult(int i3) {
            this.result = i3;
        }

        @NotNull
        public final String toJson() {
            String json = new Gson().toJson(this);
            Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(this)");
            return json;
        }

        @NotNull
        public String toString() {
            return "InvokeResult(result=" + this.result + ", message=" + this.message + ")";
        }

        public InvokeResult(int i3, @Nullable String str) {
            this.result = i3;
            this.message = str;
        }

        public /* synthetic */ InvokeResult(int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? null : str);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/webview/methods/RefreshGuildListMethod$a", "Leipc/EIPCResultCallback;", "Leipc/EIPCResult;", "ipcResult", "", "onCallback", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements EIPCResultCallback {
        a() {
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(@NotNull EIPCResult ipcResult) {
            Intrinsics.checkNotNullParameter(ipcResult, "ipcResult");
            if (ipcResult.isSuccess()) {
                InvokeResult.Companion companion = InvokeResult.INSTANCE;
                Bundle bundle = ipcResult.data;
                Intrinsics.checkNotNullExpressionValue(bundle, "ipcResult.data");
                RefreshGuildListMethod.this.i(companion.a(bundle).toJson());
                return;
            }
            RefreshGuildListMethod.this.i(new InvokeResult(-201, "\u9519\u8bef\u7801=" + ipcResult.code).toJson());
        }
    }

    private final EIPCResultCallback l() {
        return new a();
    }

    @Override // com.tencent.mobileqq.guild.webview.methods.a
    protected boolean k(@NotNull String url, @NotNull String pkgName, @NotNull String method) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        Intrinsics.checkNotNullParameter(method, "method");
        com.tencent.mobileqq.guild.util.y.b(aw.class, l(), new Object[0]);
        return true;
    }
}
