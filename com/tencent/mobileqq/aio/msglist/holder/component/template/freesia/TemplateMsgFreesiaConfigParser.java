package com.tencent.mobileqq.aio.msglist.holder.component.template.freesia;

import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.aio.adapter.a;
import com.tencent.qqnt.aio.api.IAIOUniteConfigApi;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Keep
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\b\u0007\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/freesia/TemplateMsgFreesiaConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/template/freesia/TemplateMsgRemoteSwitch;", "defaultConfig", "", "content", "parse", "<init>", "()V", "Companion", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class TemplateMsgFreesiaConfigParser extends BaseConfigParser<TemplateMsgRemoteSwitch> {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final String CONFIG_ID = "105818";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "TemMsg.config";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/freesia/TemplateMsgFreesiaConfigParser$a;", "", "Lcom/tencent/mobileqq/aio/msglist/holder/component/template/freesia/TemplateMsgRemoteSwitch;", "a", "", "CONFIG_ID", "Ljava/lang/String;", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.template.freesia.TemplateMsgFreesiaConfigParser$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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

        @JvmStatic
        @NotNull
        public final TemplateMsgRemoteSwitch a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TemplateMsgRemoteSwitch) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            TemplateMsgRemoteSwitch templateMsgRemoteSwitch = (TemplateMsgRemoteSwitch) ((IAIOUniteConfigApi) a.INSTANCE.a(IAIOUniteConfigApi.class)).loadConfig(TemplateMsgFreesiaConfigParser.CONFIG_ID);
            if (templateMsgRemoteSwitch == null) {
                TemplateMsgRemoteSwitch templateMsgRemoteSwitch2 = new TemplateMsgRemoteSwitch();
                com.tencent.mobileqq.aio.msglist.holder.component.template.a.b(com.tencent.mobileqq.aio.msglist.holder.component.template.a.f191886a, TemplateMsgFreesiaConfigParser.TAG, "got null config", null, 4, null);
                return templateMsgRemoteSwitch2;
            }
            return templateMsgRemoteSwitch;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63447);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TemplateMsgFreesiaConfigParser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    @NotNull
    public static final TemplateMsgRemoteSwitch getConfig() {
        return INSTANCE.a();
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    public TemplateMsgRemoteSwitch defaultConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new TemplateMsgRemoteSwitch() : (TemplateMsgRemoteSwitch) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    public TemplateMsgRemoteSwitch parse(@NotNull byte[] content) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TemplateMsgRemoteSwitch) iPatchRedirector.redirect((short) 3, (Object) this, (Object) content);
        }
        Intrinsics.checkNotNullParameter(content, "content");
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        String str = new String(content, UTF_8);
        com.tencent.mobileqq.aio.msglist.holder.component.template.a.b(com.tencent.mobileqq.aio.msglist.holder.component.template.a.f191886a, TAG, "parseing:" + str, null, 4, null);
        Object fromJson = new Gson().fromJson(str, (Class<Object>) TemplateMsgRemoteSwitch.class);
        Intrinsics.checkNotNullExpressionValue(fromJson, "Gson().fromJson(jsonStri\u2026RemoteSwitch::class.java)");
        return (TemplateMsgRemoteSwitch) fromJson;
    }
}
