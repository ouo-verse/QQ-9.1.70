package com.tencent.qqnt.chathistory.inject;

import com.tencent.mobileqq.activity.history.compat.ChatHistoryTroopFileAdaptNTFragment;
import com.tencent.mobileqq.activity.history.compat.ChatHistoryTroopMemberFragmentV1;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qqnt.chathistory.bridge.IHistoryBridgeInterface;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes23.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/History/Inject_Chat_History_API.yml", version = 1)
    public static HashMap<String, Class<IHistoryBridgeInterface>> f353321a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52099);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HashMap<String, Class<IHistoryBridgeInterface>> hashMap = new HashMap<>();
        f353321a = hashMap;
        hashMap.put("HostService", com.tencent.mobileqq.activity.history.compat.a.class);
        f353321a.put("groupFile", ChatHistoryTroopFileAdaptNTFragment.class);
        f353321a.put("groupMember", ChatHistoryTroopMemberFragmentV1.class);
        a();
    }

    @QAutoInitMethod
    static void a() {
    }
}
