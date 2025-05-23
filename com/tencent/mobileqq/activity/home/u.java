package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.activity.framebusiness.ContactsInjectImpl;
import com.tencent.mobileqq.activity.framebusiness.GuildInjectImpl;
import com.tencent.mobileqq.activity.framebusiness.LebaInjectImpl;
import com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl;
import com.tencent.mobileqq.activity.framebusiness.StateMachineInjectImpl;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.FrameControllerInjectImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes10.dex */
public class u {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @ConfigInject(configPath = "Foundation/QQActivity/src/main/resources/Inject_FrameFragmentTabConfig.yml", version = 2)
    public static ArrayList<Class<? extends x>> f183141a;

    /* renamed from: b, reason: collision with root package name */
    @ConfigInject(configPath = "Foundation/QQActivity/src/main/resources/Inject_FrameFragmentTabConfig.yml", version = 1)
    public static ArrayList<Class<? extends w>> f183142b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35343);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList<Class<? extends x>> arrayList = new ArrayList<>();
        f183141a = arrayList;
        arrayList.add(FrameControllerInjectImpl.class);
        ArrayList<Class<? extends w>> arrayList2 = new ArrayList<>();
        f183142b = arrayList2;
        arrayList2.add(ContactsInjectImpl.class);
        f183142b.add(com.tencent.mobileqq.activity.framebusiness.b.class);
        f183142b.add(LebaInjectImpl.class);
        f183142b.add(QCircleInjectImpl.class);
        f183142b.add(com.tencent.mobileqq.activity.framebusiness.aa.class);
        f183142b.add(StateMachineInjectImpl.class);
        f183142b.add(GuildInjectImpl.class);
        f183142b.add(com.tencent.mobileqq.activity.framebusiness.g.class);
        f183142b.add(com.tencent.mobileqq.activity.framebusiness.o.class);
    }
}
