package com.tencent.mobileqq.guild.feed.jsbridge.methods.detail;

import androidx.annotation.Keep;
import com.epicgames.ue4.GameActivity;
import com.tencent.mobileqq.guild.feed.api.impl.GuildFeedMiscApiImpl;
import com.tencent.mobileqq.guild.ipc.methods.GuildGetEnablePicShareIpcMethod;
import com.tencent.mobileqq.guild.util.Logger;
import com.vivo.push.PushClientConstants;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000f2\u00020\u0001:\u0002\u0010\u0011B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ&\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\b\u001a\u00020\u0002H\u0014R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/jsbridge/methods/detail/OnGetEnablePicShareMethod;", "Lcom/tencent/mobileqq/guild/feed/jsbridge/methods/detail/c;", "", "url", PushClientConstants.TAG_PKG_NAME, "method", "", "o", "k", "Leipc/EIPCResultCallback;", tl.h.F, "Leipc/EIPCResultCallback;", "ipcCallback", "<init>", "()V", "i", "a", GameActivity.DOWNLOAD_RETURN_NAME, "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class OnGetEnablePicShareMethod extends c {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final EIPCResultCallback ipcCallback = new EIPCResultCallback() { // from class: com.tencent.mobileqq.guild.feed.jsbridge.methods.detail.t
        @Override // eipc.EIPCResultCallback
        public final void onCallback(EIPCResult eIPCResult) {
            OnGetEnablePicShareMethod.q(OnGetEnablePicShareMethod.this, eIPCResult);
        }
    };

    @Keep
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/jsbridge/methods/detail/OnGetEnablePicShareMethod$Result;", "", "ret", "", "(I)V", "getRet", "()I", "setRet", "toJson", "", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class Result {
        private int ret;

        public Result(int i3) {
            this.ret = i3;
        }

        public final int getRet() {
            return this.ret;
        }

        public final void setRet(int i3) {
            this.ret = i3;
        }

        @NotNull
        public final String toJson() {
            return "{\"ret\":" + this.ret + "}";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(OnGetEnablePicShareMethod this$0, EIPCResult eIPCResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!eIPCResult.isSuccess()) {
            this$0.i(new Result(0).toJson());
            Logger.f235387a.d().i("OnGetEnablePicShare", 1, "auto top IPC\u9519\u8bef result=" + eIPCResult.code);
            return;
        }
        this$0.i(new Result(eIPCResult.data.getInt(GuildFeedMiscApiImpl.EXTRA_KEY_ENTRY_CONFIG)).toJson());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    @NotNull
    public String k() {
        return "canShareFeedImage";
    }

    @Override // ok1.a
    protected boolean o(@Nullable String url, @Nullable String pkgName, @Nullable String method) {
        Logger.f235387a.d().i("OnGetEnablePicShare", 1, "OnGetEnablePicShare invoke");
        com.tencent.mobileqq.guild.util.y.b(GuildGetEnablePicShareIpcMethod.class, this.ipcCallback, g("guildId"), g("feedId"), g("posterTinyId"), g("feedSourceType"));
        return true;
    }
}
