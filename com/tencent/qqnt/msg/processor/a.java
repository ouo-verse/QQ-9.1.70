package com.tencent.qqnt.msg.processor;

import com.tencent.mobileqq.guild.message.notify.GuildFeedsHomeSubChannelMsgRecvCB;
import com.tencent.mobileqq.guild.message.notify.GuildNotifyMsgRecvCB;
import com.tencent.mobileqq.guild.message.notify.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqshop.message.e;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.msg.api.b;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import sr0.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0007RF\u0010\r\u001a&\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u00050\u0004j\u0012\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u0005`\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/msg/processor/a;", "", "", "b", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/qqnt/msg/api/b;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "a", "()Ljava/util/ArrayList;", "setMsgStaticCallbackList", "(Ljava/util/ArrayList;)V", "msgStaticCallbackList", "<init>", "()V", "msg_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f359709a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Guild/Inject_AIOGuildConfig.yml", version = 1)
    @NotNull
    private static ArrayList<Class<? extends b>> msgStaticCallbackList;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40322);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f359709a = new a();
        ArrayList<Class<? extends b>> arrayList = new ArrayList<>();
        msgStaticCallbackList = arrayList;
        arrayList.add(c.class);
        msgStaticCallbackList.add(GuildNotifyMsgRecvCB.class);
        msgStaticCallbackList.add(d.class);
        msgStaticCallbackList.add(GuildFeedsHomeSubChannelMsgRecvCB.class);
        msgStaticCallbackList.add(com.tencent.mobileqq.troop.nt.b.class);
        msgStaticCallbackList.add(com.tencent.mobileqq.vas.troop.impl.c.class);
        msgStaticCallbackList.add(e.class);
        msgStaticCallbackList.add(com.tencent.troopguild.a.class);
        msgStaticCallbackList.add(com.tencent.mobileqq.guild.guildtab.a.class);
        msgStaticCallbackList.add(l43.c.class);
        msgStaticCallbackList.add(com.tencent.mobileqq.weather.chat.d.class);
        msgStaticCallbackList.add(com.tencent.mobileqq.qqshop.api.b.class);
        b();
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    @QAutoInitMethod
    public static final void b() {
        QLog.i("MsgStaticCallbackRegister", 1, "inject");
    }

    @NotNull
    public final ArrayList<Class<? extends b>> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return msgStaticCallbackList;
    }
}
