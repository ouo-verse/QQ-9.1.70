package com.tencent.mobileqq.guild.webview.methods;

import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.vivo.push.PushClientConstants;
import eipc.EIPCResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0002\u000b\fB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0014\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/webview/methods/CheckGuildTabOpenMethod;", "Lcom/tencent/mobileqq/guild/webview/methods/a;", "", "url", PushClientConstants.TAG_PKG_NAME, "method", "", "k", "<init>", "()V", tl.h.F, "a", "InvokeResult", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class CheckGuildTabOpenMethod extends a {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Keep
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0083\b\u0018\u0000 \u001f2\u00020\u0001:\u0001 B'\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0004H\u00c6\u0003J)\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\n\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\f\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\r\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0011\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b\u001c\u0010\u0015\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/webview/methods/CheckGuildTabOpenMethod$InvokeResult;", "", "", "toJson", "", "component1", "component2", "component3", "result", "message", WidgetCacheConstellationData.INTERVAL, "copy", "toString", "hashCode", "other", "", "equals", "I", "getResult", "()I", "setResult", "(I)V", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getInterval", "setInterval", "<init>", "(ILjava/lang/String;I)V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final /* data */ class InvokeResult {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @SerializedName(WidgetCacheConstellationData.INTERVAL)
        private int interval;

        @SerializedName("msg")
        @Nullable
        private String message;

        @SerializedName("result")
        private int result;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/webview/methods/CheckGuildTabOpenMethod$InvokeResult$a;", "", "Landroid/os/Bundle;", "bundle", "Lcom/tencent/mobileqq/guild/webview/methods/CheckGuildTabOpenMethod$InvokeResult;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.webview.methods.CheckGuildTabOpenMethod$InvokeResult$a, reason: from kotlin metadata */
        /* loaded from: classes14.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final InvokeResult a(@NotNull Bundle bundle) {
                Intrinsics.checkNotNullParameter(bundle, "bundle");
                if (!bundle.getBoolean("ret", false)) {
                    return new InvokeResult(-204, "Tab\u672a\u5f00\u542f, \u8bf7\u91cd\u8bd5", 1000);
                }
                return new InvokeResult(0, "Tab\u5df2\u5f00\u542f", 0, 4, null);
            }

            Companion() {
            }
        }

        public InvokeResult() {
            this(0, null, 0, 7, null);
        }

        public static /* synthetic */ InvokeResult copy$default(InvokeResult invokeResult, int i3, String str, int i16, int i17, Object obj) {
            if ((i17 & 1) != 0) {
                i3 = invokeResult.result;
            }
            if ((i17 & 2) != 0) {
                str = invokeResult.message;
            }
            if ((i17 & 4) != 0) {
                i16 = invokeResult.interval;
            }
            return invokeResult.copy(i3, str, i16);
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

        /* renamed from: component3, reason: from getter */
        public final int getInterval() {
            return this.interval;
        }

        @NotNull
        public final InvokeResult copy(int result, @Nullable String message, int interval) {
            return new InvokeResult(result, message, interval);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InvokeResult)) {
                return false;
            }
            InvokeResult invokeResult = (InvokeResult) other;
            if (this.result == invokeResult.result && Intrinsics.areEqual(this.message, invokeResult.message) && this.interval == invokeResult.interval) {
                return true;
            }
            return false;
        }

        public final int getInterval() {
            return this.interval;
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
            return ((i3 + hashCode) * 31) + this.interval;
        }

        public final void setInterval(int i3) {
            this.interval = i3;
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
            return "InvokeResult(result=" + this.result + ", message=" + this.message + ", interval=" + this.interval + ")";
        }

        public InvokeResult(int i3, @Nullable String str, int i16) {
            this.result = i3;
            this.message = str;
            this.interval = i16;
        }

        public /* synthetic */ InvokeResult(int i3, String str, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) != 0 ? null : str, (i17 & 4) != 0 ? Integer.MAX_VALUE : i16);
        }
    }

    @Override // com.tencent.mobileqq.guild.webview.methods.a
    protected boolean k(@NotNull String url, @NotNull String pkgName, @NotNull String method) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        Intrinsics.checkNotNullParameter(method, "method");
        EIPCResult g16 = com.tencent.mobileqq.guild.util.y.g(com.tencent.mobileqq.guild.ipc.methods.v.class, new Object[0]);
        InvokeResult.Companion companion = InvokeResult.INSTANCE;
        Bundle bundle = g16.data;
        Intrinsics.checkNotNullExpressionValue(bundle, "result.data");
        i(companion.a(bundle).toJson());
        return true;
    }
}
