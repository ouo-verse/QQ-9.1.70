package com.tencent.mobileqq.troop.aivoicechat.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\bg\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J`\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000526\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000bH&\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/troop/aivoicechat/api/ITroopAIVoiceChatApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Ljava/lang/Class;", "", "getJumpParser", "", "groupUin", "", "aiVoiceType", "timbreId", "text", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "result", "errMsg", "", "callback", "sendAiPttMsg", "Companion", "a", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopAIVoiceChatApi extends QRouteApi {
    public static final IPatchRedirector $redirector_ = null;

    @NotNull
    public static final String AI_CHAT_TYPE = "voice_type";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String GUIDE_BUBBLE_SHOWN_CACHE_KEY = "guide_bubble_shown_cache_key_";

    @NotNull
    public static final String PARAMS_KEY_IS_AI_VOICE_CHAT_ACTIVE = "key_is_troop_ai_voice_chat_active";

    @NotNull
    public static final String PARAMS_KEY_SHOW_AI_VOICE_GUIDE_BUBBLE = "need_show_ai_voice_chat_guide_bubble";

    @NotNull
    public static final String PARAM_KEY_OPEN_AI_CHAT_TYPE = "key_open_ai_chat_type";

    @NotNull
    public static final String TROOP_UIN = "troop_uin";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/troop/aivoicechat/api/ITroopAIVoiceChatApi$a;", "", "<init>", "()V", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.aivoicechat.api.ITroopAIVoiceChatApi$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f293893a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22075);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f293893a = new Companion();
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(22078), (Class<?>) ITroopAIVoiceChatApi.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.f293893a;
        }
    }

    @NotNull
    Class<Object> getJumpParser();

    void sendAiPttMsg(@NotNull String groupUin, int aiVoiceType, @NotNull String timbreId, @NotNull String text, @NotNull Function2<? super Integer, ? super String, Unit> callback);
}
