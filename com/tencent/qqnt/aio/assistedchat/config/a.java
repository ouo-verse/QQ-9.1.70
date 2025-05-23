package com.tencent.qqnt.aio.assistedchat.config;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IAIOUniteConfigApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 <2\u00020\u0001:\u0002\u001f\u0014B\u0007\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016R\"\u0010\u0010\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001c\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\"\u0010#\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010*\u001a\u00020$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b\u0019\u0010'\"\u0004\b(\u0010)R\"\u00100\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b%\u0010/R\"\u00106\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b\u0012\u00103\"\u0004\b4\u00105R\"\u00109\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u00102\u001a\u0004\b\n\u00103\"\u0004\b8\u00105\u00a8\u0006="}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/config/a;", "Lcom/tencent/freesia/IConfigData;", "", "toString", "", "other", "", "equals", "", "hashCode", "d", "Z", "getTopicEnable", "()Z", "setTopicEnable", "(Z)V", "topicEnable", "Lcom/tencent/qqnt/aio/assistedchat/config/c;", "e", "Lcom/tencent/qqnt/aio/assistedchat/config/c;", "b", "()Lcom/tencent/qqnt/aio/assistedchat/config/c;", h.F, "(Lcom/tencent/qqnt/aio/assistedchat/config/c;)V", "bottomBarTopicConfig", "f", "getPolishEnable", "setPolishEnable", "polishEnable", "Lcom/tencent/qqnt/aio/assistedchat/config/b;", "Lcom/tencent/qqnt/aio/assistedchat/config/b;", "a", "()Lcom/tencent/qqnt/aio/assistedchat/config/b;", "g", "(Lcom/tencent/qqnt/aio/assistedchat/config/b;)V", "bottomBarPolishConfig", "Lcom/tencent/qqnt/aio/assistedchat/config/d;", "i", "Lcom/tencent/qqnt/aio/assistedchat/config/d;", "()Lcom/tencent/qqnt/aio/assistedchat/config/d;", "l", "(Lcom/tencent/qqnt/aio/assistedchat/config/d;)V", "replySuggestionConfig", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "c", "()I", "(I)V", "panelPolishMinWords", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "()Ljava/lang/String;", "k", "(Ljava/lang/String;)V", "panelTabTopicName", "D", "j", "panelTabPolishName", "<init>", "()V", "E", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a implements IConfigData {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String panelTabTopicName;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String panelTabPolishName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean topicEnable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private c bottomBarTopicConfig;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean polishEnable;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.qqnt.aio.assistedchat.config.b bottomBarPolishConfig;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private d replySuggestionConfig;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int panelPolishMinWords;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/config/a$a;", "", "Lcom/tencent/qqnt/aio/assistedchat/config/a;", "a", "", "CONFIG_NAME", "Ljava/lang/String;", "TAG", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.assistedchat.config.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            a aVar = (a) ((IAIOUniteConfigApi) QRoute.api(IAIOUniteConfigApi.class)).loadConfig("ai_assisted_chat_config");
            if (aVar == null) {
                return new a();
            }
            return aVar;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\f\u0010\u0006\u001a\u00020\u0005*\u00020\u0002H\u0002J\f\u0010\b\u001a\u00020\u0007*\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/config/a$b;", "", "Lorg/json/JSONObject;", "Lcom/tencent/qqnt/aio/assistedchat/config/c;", "c", "Lcom/tencent/qqnt/aio/assistedchat/config/b;", "b", "Lcom/tencent/qqnt/aio/assistedchat/config/d;", "d", "", "content", "Lcom/tencent/qqnt/aio/assistedchat/config/a;", "a", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f349065a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50948);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f349065a = new b();
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private final com.tencent.qqnt.aio.assistedchat.config.b b(JSONObject jSONObject) {
            com.tencent.qqnt.aio.assistedchat.config.b bVar = new com.tencent.qqnt.aio.assistedchat.config.b();
            JSONObject optJSONObject = jSONObject.optJSONObject("bottom_bar_write_while_polishing");
            if (optJSONObject != null) {
                bVar.l(optJSONObject.optInt("trigger_word_count"));
                bVar.g(optJSONObject.optInt("auto_trigger_times"));
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("open_switch_guide");
                if (optJSONObject2 != null) {
                    Intrinsics.checkNotNullExpressionValue(optJSONObject2, "optJSONObject(BOTTOM_BAR_POLISH_GUIDE)");
                    bVar.h(optJSONObject2.optInt("display_times_per_day"));
                    bVar.i(optJSONObject2.optInt("no_click_x_consecutive_days"));
                    bVar.j(optJSONObject2.optInt("not_appear_for_y_days"));
                    bVar.k(optJSONObject2.optInt("not_appear_for_z_days"));
                }
                if (QLog.isDevelopLevel()) {
                    QLog.i("AiAssistedChatConfigBean", 1, "[parseBottomBarPolish] json=" + optJSONObject);
                }
            }
            return bVar;
        }

        private final c c(JSONObject jSONObject) {
            c cVar = new c();
            JSONObject optJSONObject = jSONObject.optJSONObject("bottom_bar_topic");
            if (optJSONObject != null) {
                cVar.b(optJSONObject.optInt("trigger_after_no_operation_seconds"));
                if (QLog.isDevelopLevel()) {
                    QLog.i("AiAssistedChatConfigBean", 1, "[parseBottomBarTopic] json=" + optJSONObject);
                }
            }
            return cVar;
        }

        private final d d(JSONObject jSONObject) {
            d dVar = new d();
            JSONObject optJSONObject = jSONObject.optJSONObject("reply_suggestion");
            if (optJSONObject != null) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("tail_guide");
                if (optJSONObject2 != null) {
                    Intrinsics.checkNotNullExpressionValue(optJSONObject2, "optJSONObject(REPLY_SUGGESTION_TAIL_GUIDE)");
                    dVar.e(optJSONObject2.optInt("display_times_per_day"));
                    dVar.f(optJSONObject2.optInt("no_click_x_consecutive_days"));
                    dVar.g(optJSONObject2.optInt("not_appear_for_y_days"));
                    dVar.h(optJSONObject2.optInt("not_appear_for_z_days"));
                }
                if (QLog.isDevelopLevel()) {
                    QLog.i("AiAssistedChatConfigBean", 1, "[parseReplySuggestion] json=" + optJSONObject);
                }
            }
            return dVar;
        }

        @NotNull
        public final a a(@Nullable String content) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) content);
            }
            a aVar = new a();
            if (content != null && content.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return aVar;
            }
            try {
                JSONObject jSONObject = new JSONObject(content);
                aVar.h(c(jSONObject));
                aVar.g(b(jSONObject));
                aVar.l(d(jSONObject));
                JSONObject optJSONObject = jSONObject.optJSONObject(WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL);
                if (optJSONObject != null) {
                    aVar.i(optJSONObject.optInt("polishing_trigger_words_count", aVar.c()));
                    String optString = optJSONObject.optString("tab_name_topic", aVar.e());
                    Intrinsics.checkNotNullExpressionValue(optString, "it.optString(PANEL_TAB_N\u2026config.panelTabTopicName)");
                    aVar.k(optString);
                    String optString2 = optJSONObject.optString("tab_name_polish", aVar.d());
                    Intrinsics.checkNotNullExpressionValue(optString2, "it.optString(PANEL_TAB_N\u2026onfig.panelTabPolishName)");
                    aVar.j(optString2);
                }
            } catch (JSONException unused) {
                QLog.e("AiAssistedChatConfigBean", 1, "");
            }
            return aVar;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50950);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.bottomBarTopicConfig = new c();
        this.bottomBarPolishConfig = new com.tencent.qqnt.aio.assistedchat.config.b();
        this.replySuggestionConfig = new d();
        this.panelPolishMinWords = 2;
        this.panelTabTopicName = "\u629b\u8bdd\u9898";
        this.panelTabPolishName = "\u804a\u5929\u6da6\u8272";
    }

    @NotNull
    public final com.tencent.qqnt.aio.assistedchat.config.b a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.qqnt.aio.assistedchat.config.b) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.bottomBarPolishConfig;
    }

    @NotNull
    public final c b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (c) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.bottomBarTopicConfig;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.panelPolishMinWords;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.panelTabPolishName;
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.panelTabTopicName;
    }

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(a.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.qqnt.aio.assistedchat.config.AiAssistedChatConfigBean");
        a aVar = (a) other;
        if (this.topicEnable == aVar.topicEnable && Intrinsics.areEqual(this.bottomBarTopicConfig, aVar.bottomBarTopicConfig) && Intrinsics.areEqual(this.replySuggestionConfig, aVar.replySuggestionConfig) && this.polishEnable == aVar.polishEnable && Intrinsics.areEqual(this.bottomBarPolishConfig, aVar.bottomBarPolishConfig) && this.panelPolishMinWords == aVar.panelPolishMinWords && Intrinsics.areEqual(this.panelTabTopicName, aVar.panelTabTopicName) && Intrinsics.areEqual(this.panelTabPolishName, aVar.panelTabPolishName)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final d f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (d) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.replySuggestionConfig;
    }

    public final void g(@NotNull com.tencent.qqnt.aio.assistedchat.config.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) bVar);
        } else {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.bottomBarPolishConfig = bVar;
        }
    }

    public final void h(@NotNull c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) cVar);
        } else {
            Intrinsics.checkNotNullParameter(cVar, "<set-?>");
            this.bottomBarTopicConfig = cVar;
        }
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return (((((((((((((com.tencent.aio.widget.textView.param.a.a(this.topicEnable) * 31) + this.bottomBarTopicConfig.hashCode()) * 31) + this.replySuggestionConfig.hashCode()) * 31) + com.tencent.aio.widget.textView.param.a.a(this.polishEnable)) * 31) + this.bottomBarPolishConfig.hashCode()) * 31) + this.panelPolishMinWords) * 31) + this.panelTabTopicName.hashCode()) * 31) + this.panelTabPolishName.hashCode();
    }

    public final void i(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            this.panelPolishMinWords = i3;
        }
    }

    public final void j(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.panelTabPolishName = str;
        }
    }

    public final void k(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.panelTabTopicName = str;
        }
    }

    public final void l(@NotNull d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) dVar);
        } else {
            Intrinsics.checkNotNullParameter(dVar, "<set-?>");
            this.replySuggestionConfig = dVar;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return "topicEnable=" + this.topicEnable + ", bottomBarTopicConfig=" + this.bottomBarTopicConfig + ", polishEnable=" + this.polishEnable + ", bottomBarPolishConfig=" + this.bottomBarPolishConfig + ", replySuggestionConfig=" + this.replySuggestionConfig + ", panelPolishMinWords=" + this.panelPolishMinWords + ", panelTabTopicName=" + this.panelTabTopicName + ", panelTabPolishName=" + this.panelTabPolishName;
    }
}
