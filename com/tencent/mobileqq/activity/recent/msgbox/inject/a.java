package com.tencent.mobileqq.activity.recent.msgbox.inject;

import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.mobileqq.activity.recent.msgbox.businesshandler.b;
import com.tencent.mobileqq.activity.recent.msgbox.c;
import com.tencent.mobileqq.activity.recent.msgbox.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @ConfigInject(configPath = "Business/qqtempmsgbox-impl/src/main/resources/Inject_TempMsgBoxBusinessHandlerConfig.yml", version = 1)
    public static HashMap<String, Class<? extends b>> f185702a;

    /* renamed from: b, reason: collision with root package name */
    @ConfigInject(configPath = "Business/qqtempmsgbox-impl/src/main/resources/Inject_TempMsgBoxBusinessHandlerConfig.yml", version = 1)
    public static ArrayList<Class<? extends c>> f185703b;

    /* renamed from: c, reason: collision with root package name */
    @ConfigInject(configPath = "Business/qqtempmsgbox-impl/src/main/resources/Inject_TempMsgBoxBusinessHandlerConfig.yml", version = 1)
    public static HashMap<String, Class<? extends com.tencent.mobileqq.activity.recent.msgbox.tempchat.a>> f185704c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25644);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HashMap<String, Class<? extends b>> hashMap = new HashMap<>();
        f185702a = hashMap;
        hashMap.put(IPublicAccountJavascriptInterface.NAME_SPACE, com.tencent.mobileqq.activity.recent.msgbox.businesshandler.c.class);
        f185702a.put("tempGameMsg", com.tencent.mobileqq.activity.recent.msgbox.businesshandler.a.class);
        ArrayList<Class<? extends c>> arrayList = new ArrayList<>();
        f185703b = arrayList;
        arrayList.add(f.class);
        f185704c = new HashMap<>();
    }
}
