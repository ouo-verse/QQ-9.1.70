package com.tencent.mobileqq.activity.recent.gamemsgbox;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes10.dex */
public class al {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static ar f185475a;

    /* renamed from: b, reason: collision with root package name */
    @ConfigInject(configPath = "Business/qqgamemsgbox-impl/src/main/resources/Inject_GameMsgBoxConfig.yml", version = 1)
    public static ArrayList<Class<? extends ar>> f185476b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20587);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList<Class<? extends ar>> arrayList = new ArrayList<>();
        f185476b = arrayList;
        arrayList.add(t.class);
        try {
            f185475a = f185476b.get(0).newInstance();
        } catch (Exception e16) {
            QLog.e("MsgBoxUtil", 1, "registerCallback error: ", e16);
        }
    }
}
