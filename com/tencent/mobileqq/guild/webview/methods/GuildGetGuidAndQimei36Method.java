package com.tencent.mobileqq.guild.webview.methods;

import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vivo.push.PushClientConstants;
import eipc.EIPCResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0014\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/webview/methods/GuildGetGuidAndQimei36Method;", "Lcom/tencent/mobileqq/guild/webview/methods/a;", "", "url", PushClientConstants.TAG_PKG_NAME, "method", "", "k", "<init>", "()V", "GuidAndQimei36Result", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildGetGuidAndQimei36Method extends a {

    /* compiled from: P */
    @Keep
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/webview/methods/GuildGetGuidAndQimei36Method$GuidAndQimei36Result;", "", "", "toJson", "", "retCode", "I", "getRetCode", "()I", "setRetCode", "(I)V", "errorMsg", "Ljava/lang/String;", "getErrorMsg", "()Ljava/lang/String;", "setErrorMsg", "(Ljava/lang/String;)V", "guid", "getGuid", "setGuid", "qimei36", "getQimei36", "setQimei36", "<init>", "()V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class GuidAndQimei36Result {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @SerializedName("errorMsg")
        @Nullable
        private String errorMsg;

        @SerializedName("guid")
        @Nullable
        private String guid;

        @SerializedName("qimei36")
        @Nullable
        private String qimei36;

        @SerializedName("retCode")
        private int retCode;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/webview/methods/GuildGetGuidAndQimei36Method$GuidAndQimei36Result$a;", "", "", "code", "Landroid/os/Bundle;", "bundle", "Lcom/tencent/mobileqq/guild/webview/methods/GuildGetGuidAndQimei36Method$GuidAndQimei36Result;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.webview.methods.GuildGetGuidAndQimei36Method$GuidAndQimei36Result$a, reason: from kotlin metadata */
        /* loaded from: classes14.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final GuidAndQimei36Result a(int code, @Nullable Bundle bundle) {
                String str;
                String str2;
                GuidAndQimei36Result guidAndQimei36Result = new GuidAndQimei36Result();
                guidAndQimei36Result.setRetCode(code);
                String str3 = null;
                if (bundle != null) {
                    str = bundle.getString("ERROR_MSG");
                } else {
                    str = null;
                }
                guidAndQimei36Result.setErrorMsg(str);
                if (bundle != null) {
                    str2 = bundle.getString("KEY_GUID");
                } else {
                    str2 = null;
                }
                guidAndQimei36Result.setGuid(str2);
                if (bundle != null) {
                    str3 = bundle.getString("KEY_QIMEI36");
                }
                guidAndQimei36Result.setQimei36(str3);
                return guidAndQimei36Result;
            }

            Companion() {
            }
        }

        @Nullable
        public final String getErrorMsg() {
            return this.errorMsg;
        }

        @Nullable
        public final String getGuid() {
            return this.guid;
        }

        @Nullable
        public final String getQimei36() {
            return this.qimei36;
        }

        public final int getRetCode() {
            return this.retCode;
        }

        public final void setErrorMsg(@Nullable String str) {
            this.errorMsg = str;
        }

        public final void setGuid(@Nullable String str) {
            this.guid = str;
        }

        public final void setQimei36(@Nullable String str) {
            this.qimei36 = str;
        }

        public final void setRetCode(int i3) {
            this.retCode = i3;
        }

        @NotNull
        public final String toJson() {
            String json = new Gson().toJson(this);
            Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(this)");
            return json;
        }
    }

    @Override // com.tencent.mobileqq.guild.webview.methods.a
    protected boolean k(@NotNull String url, @NotNull String pkgName, @NotNull String method) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        Intrinsics.checkNotNullParameter(method, "method");
        EIPCResult g16 = com.tencent.mobileqq.guild.util.y.g(com.tencent.mobileqq.guild.ipc.methods.o.class, new Object[0]);
        i(GuidAndQimei36Result.INSTANCE.a(g16.code, g16.data).toJson());
        return true;
    }
}
