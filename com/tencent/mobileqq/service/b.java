package com.tencent.mobileqq.service;

import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.NearFieldDiscussHandler;
import com.tencent.mobileqq.graycheck.business.GrayCheckHandler;
import com.tencent.mobileqq.guild.message.api.impl.onlinepush.GuildMessagePushHandler;
import com.tencent.mobileqq.mini.push.MiniAppPushHandler;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.service.message.r;
import com.tencent.mobileqq.subaccount.api.impl.SubAccountBindHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b extends MobileQQServiceBase {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Foundation/mqq/Inject_MobileQQServiceConfig.yml", version = 1)
    public static ArrayList<Class<? extends BaseProtocolCoder>> f286081c;

    /* renamed from: d, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Foundation/mqq/Inject_MobileQQServiceConfig.yml", version = 1)
    public static ArrayList<Class<? extends BusinessHandler>> f286082d;

    /* renamed from: e, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Foundation/mqq/Inject_MobileQQServiceConfig.yml", version = 1)
    public static ArrayList<Class<? extends BusinessHandler>> f286083e;

    /* renamed from: a, reason: collision with root package name */
    private BaseQQAppInterface f286084a;

    /* renamed from: b, reason: collision with root package name */
    private List<String> f286085b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42291);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        ArrayList<Class<? extends BaseProtocolCoder>> arrayList = new ArrayList<>();
        f286081c = arrayList;
        arrayList.add(com.tencent.aelight.camera.ae.config.a.class);
        f286081c.add(com.tencent.mobileqq.service.profile.b.class);
        f286081c.add(com.tencent.mobileqq.service.friendlist.a.class);
        f286081c.add(r.class);
        f286081c.add(com.tencent.mobileqq.service.lbs.a.class);
        f286081c.add(com.tencent.mobileqq.service.qzone.d.class);
        f286081c.add(com.tencent.mobileqq.service.push.a.class);
        f286081c.add(com.tencent.mobileqq.service.config.a.class);
        f286081c.add(com.tencent.mobileqq.service.report.c.class);
        f286081c.add(com.tencent.mobileqq.service.discussion.c.class);
        f286081c.add(com.tencent.mobileqq.service.RegisterProxySvcPack.a.class);
        f286081c.add(h.class);
        f286081c.add(j.class);
        f286081c.add(com.tencent.biz.bmqq.protocol.a.class);
        f286081c.add(fq2.b.class);
        f286081c.add(fq2.c.class);
        f286081c.add(g.class);
        f286081c.add(fq2.a.class);
        f286081c.add(com.tencent.mobileqq.service.graycheck.a.class);
        ArrayList<Class<? extends BusinessHandler>> arrayList2 = new ArrayList<>();
        f286082d = arrayList2;
        arrayList2.add(MessageHandler.class);
        f286082d.add(SubAccountBindHandler.class);
        f286082d.add(GuildMessagePushHandler.class);
        f286082d.add(GrayCheckHandler.class);
        f286082d.add(MiniAppPushHandler.class);
        ArrayList<Class<? extends BusinessHandler>> arrayList3 = new ArrayList<>();
        f286083e = arrayList3;
        arrayList3.add(MessageHandler.class);
        f286083e.add(NearFieldDiscussHandler.class);
        f286083e.add(OnlineStatusHandler.class);
    }

    public b(BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface);
            return;
        }
        this.f286085b = new ArrayList();
        this.f286084a = baseQQAppInterface;
        c();
        d();
    }

    private void b() {
        Iterator<Class<? extends BaseProtocolCoder>> it = f286081c.iterator();
        while (it.hasNext()) {
            try {
                addCoder(it.next().newInstance());
            } catch (Exception e16) {
                QLog.e("MobileQQService", 1, "translate inject coder error", e16);
            }
        }
    }

    private void c() {
        Iterator<Class<? extends BusinessHandler>> it = f286082d.iterator();
        while (it.hasNext()) {
            Class<? extends BusinessHandler> next = it.next();
            try {
                Set<String> pushCommandList = this.f286084a.getBusinessHandler(next.getName()).getPushCommandList();
                if (pushCommandList != null && !pushCommandList.isEmpty()) {
                    Iterator<String> it5 = pushCommandList.iterator();
                    while (it5.hasNext()) {
                        a.a(it5.next(), next.getName());
                    }
                }
            } catch (Exception e16) {
                QLog.e("MobileQQService", 1, "translate inject pushCmd handler error", e16);
            }
        }
    }

    private void d() {
        Iterator<Class<? extends BusinessHandler>> it = f286083e.iterator();
        while (it.hasNext()) {
            try {
                Set<String> pushPBCommandList = this.f286084a.getBusinessHandler(it.next().getName()).getPushPBCommandList();
                if (pushPBCommandList != null) {
                    this.f286085b.addAll(pushPBCommandList);
                }
            } catch (Exception e16) {
                QLog.e("MobileQQService", 1, "translate inject pushPBCmd handler error", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.service.MobileQQServiceBase
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.destroy();
        if (QLog.isColorLevel()) {
            QLog.i("MobileQQService", 2, "MobileQQService has destroyed.");
        }
    }

    @Override // com.tencent.mobileqq.service.MobileQQServiceBase
    protected synchronized void initCoders() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            b();
            super.setCodersInit();
        }
    }

    @Override // com.tencent.mobileqq.service.MobileQQServiceBase
    public boolean isPBPushCmd(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str)).booleanValue();
        }
        return this.f286085b.contains(str);
    }
}
