package com.tencent.mobileqq.guild.webview.methods;

import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.guild.ipc.methods.at;
import com.vivo.push.PushClientConstants;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0014\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/webview/methods/OpenGuildBindGroupPageMethod;", "Lcom/tencent/mobileqq/guild/webview/methods/a;", "", "url", PushClientConstants.TAG_PKG_NAME, "method", "", "k", "<init>", "()V", "OpenGuildBindingGroupPageResult", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class OpenGuildBindGroupPageMethod extends a {

    @Keep
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0016\n\u0002\b\u000b\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/webview/methods/OpenGuildBindGroupPageMethod$OpenGuildBindingGroupPageResult;", "", "", "toJson", "", "result", "I", "getResult", "()I", "setResult", "(I)V", "", "groupCodeList", "[J", "getGroupCodeList", "()[J", "setGroupCodeList", "([J)V", "<init>", "()V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class OpenGuildBindingGroupPageResult {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @SerializedName("groupCodeList")
        @Nullable
        private long[] groupCodeList;

        @SerializedName("result")
        private int result;

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/webview/methods/OpenGuildBindGroupPageMethod$OpenGuildBindingGroupPageResult$a;", "", "", "code", "Landroid/os/Bundle;", "bundle", "Lcom/tencent/mobileqq/guild/webview/methods/OpenGuildBindGroupPageMethod$OpenGuildBindingGroupPageResult;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.webview.methods.OpenGuildBindGroupPageMethod$OpenGuildBindingGroupPageResult$a, reason: from kotlin metadata */
        /* loaded from: classes14.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final OpenGuildBindingGroupPageResult a(int code, @NotNull Bundle bundle) {
                Intrinsics.checkNotNullParameter(bundle, "bundle");
                OpenGuildBindingGroupPageResult openGuildBindingGroupPageResult = new OpenGuildBindingGroupPageResult();
                openGuildBindingGroupPageResult.setResult(code);
                openGuildBindingGroupPageResult.setGroupCodeList(bundle.getLongArray("data"));
                return openGuildBindingGroupPageResult;
            }

            Companion() {
            }
        }

        @Nullable
        public final long[] getGroupCodeList() {
            return this.groupCodeList;
        }

        public final int getResult() {
            return this.result;
        }

        public final void setGroupCodeList(@Nullable long[] jArr) {
            this.groupCodeList = jArr;
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(OpenGuildBindGroupPageMethod this$0, EIPCResult eIPCResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (eIPCResult != null) {
            try {
                OpenGuildBindingGroupPageResult.Companion companion = OpenGuildBindingGroupPageResult.INSTANCE;
                int i3 = eIPCResult.code;
                Bundle bundle = eIPCResult.data;
                Intrinsics.checkNotNullExpressionValue(bundle, "it.data");
                this$0.i(companion.a(i3, bundle).toJson());
            } catch (Exception e16) {
                this$0.h(e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.webview.methods.a
    protected boolean k(@NotNull String url, @NotNull String pkgName, @NotNull String method) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        Intrinsics.checkNotNullParameter(method, "method");
        com.tencent.mobileqq.guild.util.y.b(at.class, new EIPCResultCallback() { // from class: com.tencent.mobileqq.guild.webview.methods.t
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                OpenGuildBindGroupPageMethod.m(OpenGuildBindGroupPageMethod.this, eIPCResult);
            }
        }, f("groupCodeList"));
        return true;
    }
}
