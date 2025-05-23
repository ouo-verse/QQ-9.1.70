package com.tencent.qqnt.aio.api.impl;

import com.tencent.mobileqq.aio.animation.AIOAnimationMsgProcessorFactory;
import com.tencent.mobileqq.aio.gamemsg.GameMsgProcessorFactory;
import com.tencent.mobileqq.aio.msglist.holder.component.facebubble.AIOFaceBubbleMsgProcessorFactory;
import com.tencent.mobileqq.aio.msglist.holder.component.poke.AIOPokeMsgProcessorFactory;
import com.tencent.mobileqq.aio.msglist.holder.component.zplan.AIOZPlanMsgProcessorFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.qqnt.aio.data.AIOMsgProcessorFactory;
import com.tencent.qqnt.aio.matchfriend.MatchFriendArkMsgProcessorFactory;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes23.dex */
public class r {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @QAutoInject(configPath = "AutoInjectYml/Business/AIO/msg/aio_msg_processor_factory.yml", version = 1)
    static ArrayList<AIOMsgProcessorFactory> f348970a;

    /* renamed from: b, reason: collision with root package name */
    private static ArrayList f348971b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65971);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f348971b = arrayList;
        arrayList.add(AIOAnimationMsgProcessorFactory.class);
        f348971b.add(AIOPokeMsgProcessorFactory.class);
        f348971b.add(AIOZPlanMsgProcessorFactory.class);
        f348971b.add(AIOFaceBubbleMsgProcessorFactory.class);
        f348971b.add(MatchFriendArkMsgProcessorFactory.class);
        f348971b.add(GameMsgProcessorFactory.class);
        f348970a = new ArrayList<>();
        a();
    }

    @QAutoInitMethod
    private static void a() {
        com.tencent.mobileqq.qroute.utils.b.c(f348971b, f348970a);
    }
}
