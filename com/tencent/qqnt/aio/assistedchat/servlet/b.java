package com.tencent.qqnt.aio.assistedchat.servlet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.aio.assistedchat.protocolbuffer.AssistedChatPB$AssistedSwitchRsp;
import com.tencent.qqnt.aio.assistedchat.protocolbuffer.AssistedChatPB$GetPromptListRsp;
import com.tencent.qqnt.aio.assistedchat.protocolbuffer.AssistedChatPB$GradeRsp;
import com.tencent.qqnt.aio.assistedchat.protocolbuffer.AssistedChatPB$RecommendRsp;
import com.tencent.qqnt.aio.assistedchat.protocolbuffer.AssistedChatPB$ReportRsp;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR/\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00050\u00040\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/servlet/b;", "", "", "", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/pb/MessageMicro;", "b", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "CMD_RSP_MAP", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f349435a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, Class<? extends MessageMicro<?>>> CMD_RSP_MAP;

    static {
        Map<String, Class<? extends MessageMicro<?>>> mapOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60087);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f349435a = new b();
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("trpc.kuolie.assisted_chat.AssistedChatService.SsoRecommend", AssistedChatPB$RecommendRsp.class), TuplesKt.to("trpc.kuolie.assisted_chat.AssistedChatService.SsoGrade", AssistedChatPB$GradeRsp.class), TuplesKt.to("trpc.kuolie.assisted_chat.AssistedChatService.SsoAssistedSwitch", AssistedChatPB$AssistedSwitchRsp.class), TuplesKt.to("trpc.kuolie.assisted_chat.AssistedChatService.SsoReport", AssistedChatPB$ReportRsp.class), TuplesKt.to("trpc.kuolie.assisted_chat.AssistedChatService.SsoGetPromptList", AssistedChatPB$GetPromptListRsp.class));
        CMD_RSP_MAP = mapOf;
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final Map<String, Class<? extends MessageMicro<?>>> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Map) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return CMD_RSP_MAP;
    }
}
