package com.tencent.mobileqq.guild.feed.jsbridge.methods.detail;

import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.vivo.push.PushClientConstants;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000f2\u00020\u0001:\u0002\u0010\u0011B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ&\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\b\u001a\u00020\u0002H\u0014R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/jsbridge/methods/detail/GetVideoPlayParamMethod;", "Lcom/tencent/mobileqq/guild/feed/jsbridge/methods/detail/c;", "", "url", PushClientConstants.TAG_PKG_NAME, "method", "", "o", "k", "Leipc/EIPCResultCallback;", tl.h.F, "Leipc/EIPCResultCallback;", "ipcCallback", "<init>", "()V", "i", "a", "InvokeResult", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GetVideoPlayParamMethod extends c {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final EIPCResultCallback ipcCallback = new EIPCResultCallback() { // from class: com.tencent.mobileqq.guild.feed.jsbridge.methods.detail.k
        @Override // eipc.EIPCResultCallback
        public final void onCallback(EIPCResult eIPCResult) {
            GetVideoPlayParamMethod.q(GetVideoPlayParamMethod.this, eIPCResult);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    @Keep
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/jsbridge/methods/detail/GetVideoPlayParamMethod$InvokeResult;", "", "", "toJson", "", InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, "I", "getCurrentTime", "()I", "setCurrentTime", "(I)V", "", "muteStatus", "Ljava/lang/Boolean;", "getMuteStatus", "()Ljava/lang/Boolean;", "setMuteStatus", "(Ljava/lang/Boolean;)V", "autoPlay", "getAutoPlay", "setAutoPlay", "<init>", "()V", "Companion", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class InvokeResult {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @SerializedName("autoPlay")
        @Nullable
        private Boolean autoPlay;

        @SerializedName(InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME)
        private int currentTime;

        @SerializedName("muteStatus")
        @Nullable
        private Boolean muteStatus;

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/jsbridge/methods/detail/GetVideoPlayParamMethod$InvokeResult$a;", "", "", InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, "", "muteStatus", "autoPlay", "Lcom/tencent/mobileqq/guild/feed/jsbridge/methods/detail/GetVideoPlayParamMethod$InvokeResult;", "a", "(ILjava/lang/Boolean;Ljava/lang/Boolean;)Lcom/tencent/mobileqq/guild/feed/jsbridge/methods/detail/GetVideoPlayParamMethod$InvokeResult;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.feed.jsbridge.methods.detail.GetVideoPlayParamMethod$InvokeResult$a, reason: from kotlin metadata */
        /* loaded from: classes13.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final InvokeResult a(int currentTime, @Nullable Boolean muteStatus, @Nullable Boolean autoPlay) {
                InvokeResult invokeResult = new InvokeResult();
                invokeResult.setCurrentTime(currentTime);
                invokeResult.setMuteStatus(muteStatus);
                invokeResult.setAutoPlay(autoPlay);
                return invokeResult;
            }

            Companion() {
            }
        }

        public InvokeResult() {
            Boolean bool = Boolean.FALSE;
            this.muteStatus = bool;
            this.autoPlay = bool;
        }

        @Nullable
        public final Boolean getAutoPlay() {
            return this.autoPlay;
        }

        public final int getCurrentTime() {
            return this.currentTime;
        }

        @Nullable
        public final Boolean getMuteStatus() {
            return this.muteStatus;
        }

        public final void setAutoPlay(@Nullable Boolean bool) {
            this.autoPlay = bool;
        }

        public final void setCurrentTime(int i3) {
            this.currentTime = i3;
        }

        public final void setMuteStatus(@Nullable Boolean bool) {
            this.muteStatus = bool;
        }

        @NotNull
        public final String toJson() {
            String json = new Gson().toJson(this);
            Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(this)");
            return json;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(GetVideoPlayParamMethod this$0, EIPCResult eIPCResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!eIPCResult.isSuccess()) {
            this$0.i(new InvokeResult().toJson());
            Logger.f235387a.d().i("GetVideoPlayParamMethod", 1, "auto top IPC\u9519\u8bef result=" + eIPCResult.code);
            return;
        }
        this$0.i(InvokeResult.INSTANCE.a(eIPCResult.data.getInt(InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME), Boolean.valueOf(eIPCResult.data.getBoolean("muteStatus")), Boolean.valueOf(eIPCResult.data.getBoolean("autoPlay"))).toJson());
        Logger.f235387a.d().i("GetVideoPlayParamMethod", 1, "GetVideoPlayParam code=" + eIPCResult.data.getInt(InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME) + " muteStatus=" + eIPCResult.data.getBoolean("muteStatus") + ", autoPlay=" + eIPCResult.data.getBoolean("autoPlay"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    @NotNull
    public String k() {
        return "getVideoPlayParam";
    }

    @Override // ok1.a
    protected boolean o(@Nullable String url, @Nullable String pkgName, @Nullable String method) {
        Logger.f235387a.d().i("GetVideoPlayParamMethod", 1, "GetVideoPlayParam invoke videoId=" + g("videoId"));
        com.tencent.mobileqq.guild.util.y.b(com.tencent.mobileqq.guild.ipc.methods.n.class, this.ipcCallback, g("videoId"));
        return true;
    }
}
