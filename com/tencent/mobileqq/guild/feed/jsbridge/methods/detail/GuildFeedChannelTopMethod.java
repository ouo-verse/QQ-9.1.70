package com.tencent.mobileqq.guild.feed.jsbridge.methods.detail;

import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.guild.ipc.methods.GuildFeedChannelTopIPCMethod;
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
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u000b2\u00020\u0001:\u0002\f\rB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ&\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\b\u001a\u00020\u0002H\u0014\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/jsbridge/methods/detail/GuildFeedChannelTopMethod;", "Lcom/tencent/mobileqq/guild/feed/jsbridge/methods/detail/c;", "", "url", PushClientConstants.TAG_PKG_NAME, "method", "", "o", "k", "<init>", "()V", tl.h.F, "a", "InvokeResult", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedChannelTopMethod extends c {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Keep
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/jsbridge/methods/detail/GuildFeedChannelTopMethod$InvokeResult;", "", "", "toJson", "", "isSuccess", "Z", "()Z", "setSuccess", "(Z)V", "<init>", "()V", "Companion", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class InvokeResult {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @SerializedName("success")
        private boolean isSuccess;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/jsbridge/methods/detail/GuildFeedChannelTopMethod$InvokeResult$a;", "", "", "isSuccess", "Lcom/tencent/mobileqq/guild/feed/jsbridge/methods/detail/GuildFeedChannelTopMethod$InvokeResult;", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.feed.jsbridge.methods.detail.GuildFeedChannelTopMethod$InvokeResult$a, reason: from kotlin metadata */
        /* loaded from: classes13.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final InvokeResult a(boolean isSuccess) {
                InvokeResult invokeResult = new InvokeResult();
                invokeResult.setSuccess(isSuccess);
                return invokeResult;
            }

            Companion() {
            }
        }

        /* renamed from: isSuccess, reason: from getter */
        public final boolean getIsSuccess() {
            return this.isSuccess;
        }

        public final void setSuccess(boolean z16) {
            this.isSuccess = z16;
        }

        @NotNull
        public final String toJson() {
            String json = new Gson().toJson(this);
            Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(this)");
            return json;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(GuildFeedChannelTopMethod this$0, EIPCResult eIPCResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.f235387a.d().i("GuildFeedChannelTopMethod", 1, "asyncInvoke, callback, result=" + eIPCResult);
        if (eIPCResult != null) {
            Object obj = eIPCResult.data.get("isSuccess");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            this$0.i(InvokeResult.INSTANCE.a(((Boolean) obj).booleanValue()).toJson());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    @NotNull
    public String k() {
        return "feedListTop";
    }

    @Override // ok1.a
    protected boolean o(@Nullable String url, @Nullable String pkgName, @Nullable String method) {
        String g16 = g("guildId");
        String str = "";
        if (g16 == null) {
            g16 = "";
        }
        String g17 = g("channelId");
        if (g17 == null) {
            g17 = "";
        }
        String g18 = g("feedId");
        if (g18 == null) {
            g18 = "";
        }
        String g19 = g("channelName");
        if (g19 != null) {
            str = g19;
        }
        boolean b16 = b("isSetTop");
        Logger.f235387a.d().i("GuildFeedChannelTopMethod", 1, "GuildFeedChannelTopMethod invoke, guildId=" + g16 + ", channelId=" + g17 + ", feedId=" + g18 + ", channelName=" + str + ", isSetTop=" + b16);
        com.tencent.mobileqq.guild.util.y.b(GuildFeedChannelTopIPCMethod.class, new EIPCResultCallback() { // from class: com.tencent.mobileqq.guild.feed.jsbridge.methods.detail.l
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                GuildFeedChannelTopMethod.q(GuildFeedChannelTopMethod.this, eIPCResult);
            }
        }, g16, g17, g18, str, Boolean.valueOf(b16));
        return true;
    }
}
