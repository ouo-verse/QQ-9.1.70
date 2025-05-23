package com.tencent.mobileqq.app.automator.step;

import QC.Hamlet;
import QC.HamletCheck;
import QC.UniBusinessCheckItem;
import QC.UniBusinessItem;
import QC.UniLoginCheckRsp;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.VasMMKV;
import com.tencent.mobileqq.vas.VipMMKV;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.mobileqq.vas.troopkeyword.TroopKeywordManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ChatBackgroundAuth {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private static class a implements BusinessObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<AppRuntime> f195325d;

        public a(AppRuntime appRuntime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
            } else {
                this.f195325d = new WeakReference<>(appRuntime);
            }
        }

        private int a(int i3) {
            if (i3 == 3) {
                return 1;
            }
            if (i3 == 2) {
                return 0;
            }
            return -1;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
                return;
            }
            AppRuntime appRuntime = this.f195325d.get();
            if (appRuntime == null) {
                return;
            }
            VasMMKV.getCommon(appRuntime.getCurrentUin()).encodeLong("lastChabgAuthTime", System.currentTimeMillis());
            if (obj instanceof UniLoginCheckRsp) {
                UniLoginCheckRsp uniLoginCheckRsp = (UniLoginCheckRsp) obj;
                TroopKeywordManager.e(appRuntime).l(uniLoginCheckRsp.stKeyWord);
                if (uniLoginCheckRsp.ret == 0) {
                    ChatBackgroundManager chatBackgroundManager = (ChatBackgroundManager) appRuntime.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER);
                    VasLogReporter.getChatBackground().reportLow("bg and effect id clear");
                    chatBackgroundManager.c();
                    chatBackgroundManager.b();
                    Iterator<HamletCheck> it = uniLoginCheckRsp.stHamletList.iterator();
                    while (it.hasNext()) {
                        HamletCheck next = it.next();
                        ArrayList<UniBusinessCheckItem> arrayList = next.itemlist;
                        if (arrayList != null && arrayList.size() > 0) {
                            Iterator<UniBusinessCheckItem> it5 = next.itemlist.iterator();
                            int i16 = -1;
                            int i17 = -1;
                            while (it5.hasNext()) {
                                UniBusinessCheckItem next2 = it5.next();
                                int i18 = next2.appid;
                                if (i18 == 8) {
                                    i16 = next2.itemid;
                                } else if (i18 == 35) {
                                    i17 = next2.itemid;
                                }
                            }
                            if (i16 >= 0) {
                                String valueOf = String.valueOf(next.uid);
                                if (appRuntime.getAccount().equals(valueOf) && next.locationtype == 1) {
                                    valueOf = null;
                                }
                                String str = valueOf;
                                VasLogReporter.getChatBackground().reportLow("auth : uid = " + str + " locationtype=" + next.locationtype + " bgId=" + i16 + " effectId=" + i17);
                                if (!ThemeBackground.DIY_UPLOAD_BG_ID.equals(String.valueOf(i16)) || i17 > 0) {
                                    chatBackgroundManager.y(i16, i17, str, "chatbgAuth", a(next.locationtype));
                                }
                            }
                        }
                    }
                    return;
                }
                VasLogReporter.getChatBackground().reportLow("onResponse: ret:" + uniLoginCheckRsp.ret + " errmsg:" + uniLoginCheckRsp.errmsg);
            }
        }
    }

    public ChatBackgroundAuth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void c(AppRuntime appRuntime, FriendsManager friendsManager, HashMap<String, Integer> hashMap, ArrayList<Hamlet> arrayList, int i3) {
        String str;
        int i16;
        for (String str2 : hashMap.keySet()) {
            Integer num = hashMap.get(str2);
            if (num != null) {
                UniBusinessItem uniBusinessItem = new UniBusinessItem(i3, num.intValue(), "");
                if (str2.contains("_")) {
                    String[] split = str2.split("_");
                    str = split[0];
                    int parseInt = Integer.parseInt(split[1]);
                    if (parseInt > -1) {
                        i16 = f(parseInt);
                    } else if (friendsManager.c0(str)) {
                        i16 = 2;
                    } else {
                        i16 = 3;
                    }
                } else {
                    if ("null".equals(str2)) {
                        str = appRuntime.getCurrentUin();
                    } else {
                        str = null;
                    }
                    i16 = 1;
                }
                QLog.d("ChatBackgroundAuth", 1, "friendUin:" + str + " serverUinType:" + i16 + " appId:" + i3 + " id:" + num);
                Hamlet d16 = d(arrayList, str, i16);
                if (d16 == null) {
                    Hamlet hamlet = new Hamlet(Long.parseLong(str), i16, new ArrayList());
                    arrayList.add(hamlet);
                    d16 = hamlet;
                }
                d16.itemlist.add(uniBusinessItem);
            }
        }
    }

    private Hamlet d(ArrayList<Hamlet> arrayList, String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<Hamlet> it = arrayList.iterator();
        while (it.hasNext()) {
            Hamlet next = it.next();
            if (next.uid == Long.parseLong(str) && i3 == next.locationtype) {
                return next;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<Hamlet> e(AppRuntime appRuntime, HashMap<String, Integer> hashMap, HashMap<String, Integer> hashMap2, FriendsManager friendsManager, int i3, int i16) {
        ArrayList<Hamlet> arrayList = new ArrayList<>();
        c(appRuntime, friendsManager, hashMap, arrayList, i3);
        c(appRuntime, friendsManager, hashMap2, arrayList, i16);
        return arrayList;
    }

    private int f(int i3) {
        if (i3 == 1) {
            return 3;
        }
        if (i3 != 0) {
            return 1;
        }
        return 2;
    }

    private boolean g(AppRuntime appRuntime) {
        boolean z16;
        if (Math.abs(System.currentTimeMillis() - VipMMKV.getCommon(appRuntime.getCurrentAccountUin()).decodeLong("lastChabgAuthTime", 0L)) > 86400000) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            VipMMKV.getCommon(appRuntime.getCurrentAccountUin()).encodeLong("lastChabgAuthTime", System.currentTimeMillis());
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        String currentAccountUin = peekAppRuntime.getCurrentAccountUin();
        VipMMKV.getCommon(currentAccountUin).encodeLong("lastChabgAuthTime", 0L);
        QLog.d("ChatBackgroundAuth", 2, "resetNeedAuth\uff01" + currentAccountUin);
        try {
            ThemeUtil.getUinThemePreferences(peekAppRuntime).edit().putLong("authTime", 0L).commit();
            QLog.d("ChatBackgroundAuth", 1, "resetNeedAuth\uff01 default theme auth");
        } catch (Exception e16) {
            QLog.d("ChatBackgroundAuth", 1, "resetNeedAuth error", e16);
        }
    }

    public void h(Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bool);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        if ((bool.booleanValue() || g(peekAppRuntime)) && (peekAppRuntime instanceof QQAppInterface)) {
            ThreadManagerV2.excute(new Runnable(peekAppRuntime) { // from class: com.tencent.mobileqq.app.automator.step.ChatBackgroundAuth.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ AppRuntime f195324d;

                {
                    this.f195324d = peekAppRuntime;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatBackgroundAuth.this, (Object) peekAppRuntime);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    AppInterface appInterface = (AppInterface) this.f195324d;
                    QLog.d("ChatBackgroundAuth", 2, "request start auth");
                    ChatBackgroundManager chatBackgroundManager = (ChatBackgroundManager) appInterface.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER);
                    HashMap<String, Integer> g16 = chatBackgroundManager.g();
                    VasLogReporter.getChatBackground().reportLow("auth : ids = " + g16.toString());
                    HashMap<String, Integer> f16 = chatBackgroundManager.f();
                    VasLogReporter.getChatBackground().reportLow("auth : effect ids = " + f16.toString());
                    ((ISVIPHandler) appInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).gxhLoginCheck(ChatBackgroundAuth.this.e(appInterface, g16, f16, (FriendsManager) appInterface.getManager(QQManagerFactory.FRIENDS_MANAGER), 8, 35), new a(appInterface), true);
                }
            }, 128, null, false);
        }
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.app.automator.step.a
                @Override // java.lang.Runnable
                public final void run() {
                    ChatBackgroundAuth.this.j();
                }
            }, 16, null, false);
        }
    }
}
