package com.tencent.qqnt.aio.adapter.api;

import android.content.Context;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import common.config.service.QzoneConfig;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001:\u0002\u0012\u0013J<\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0007H&J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H&J\u0012\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IChatHistoryShortVideoApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "", WadlProxyConsts.KEY_JUMP_URL, QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "", "source", "", "seqList", "", "forwardToShortVideoLayer", "key", "obtainJumpUrlKeyVal", "Lcom/tencent/qqnt/aio/adapter/api/IChatHistoryShortVideoApi$a;", "listener", "setOnHistoryShortEventListener", "ChatHistoryShortVideoEvent", "a", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IChatHistoryShortVideoApi extends QRouteApi {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IChatHistoryShortVideoApi$ChatHistoryShortVideoEvent;", "", "(Ljava/lang/String;I)V", "SHORT_VIDEO_EVENT_POSITION_CHANGE", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class ChatHistoryShortVideoEvent {
        private static final /* synthetic */ ChatHistoryShortVideoEvent[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final ChatHistoryShortVideoEvent SHORT_VIDEO_EVENT_POSITION_CHANGE;

        private static final /* synthetic */ ChatHistoryShortVideoEvent[] $values() {
            return new ChatHistoryShortVideoEvent[]{SHORT_VIDEO_EVENT_POSITION_CHANGE};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30199);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                SHORT_VIDEO_EVENT_POSITION_CHANGE = new ChatHistoryShortVideoEvent("SHORT_VIDEO_EVENT_POSITION_CHANGE", 0);
                $VALUES = $values();
            }
        }

        ChatHistoryShortVideoEvent(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static ChatHistoryShortVideoEvent valueOf(String str) {
            return (ChatHistoryShortVideoEvent) Enum.valueOf(ChatHistoryShortVideoEvent.class, str);
        }

        public static ChatHistoryShortVideoEvent[] values() {
            return (ChatHistoryShortVideoEvent[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IChatHistoryShortVideoApi$a;", "", "Lcom/tencent/qqnt/aio/adapter/api/IChatHistoryShortVideoApi$ChatHistoryShortVideoEvent;", "type", "", "", "param", "", "a", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public interface a {
        void a(@NotNull ChatHistoryShortVideoEvent type, @NotNull Map<String, String> param);
    }

    void forwardToShortVideoLayer(@NotNull Context context, @NotNull String jumpUrl, @NotNull String entrance, @NotNull List<String> source, @NotNull List<Long> seqList);

    @NotNull
    String obtainJumpUrlKeyVal(@NotNull Context context, @NotNull String jumpUrl, @NotNull String key);

    void setOnHistoryShortEventListener(@Nullable a listener);
}
