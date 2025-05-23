package com.tencent.mobileqq.graytip;

import com.tencent.mobileqq.graytip.UniteEntity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    @ConfigInject(configPath = "Foundation/imcore-api/src/main/resources/Inject_tips_processor_config.yml", version = 1)
    private static ArrayList<Class<? extends b>> f213670b;

    /* renamed from: a, reason: collision with root package name */
    private final List<b> f213671a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39710);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        ArrayList<Class<? extends b>> arrayList = new ArrayList<>();
        f213670b = arrayList;
        arrayList.add(com.tencent.mobileqq.selectmember.a.class);
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f213671a = new ArrayList();
        Iterator<Class<? extends b>> it = f213670b.iterator();
        while (it.hasNext()) {
            try {
                this.f213671a.add(it.next().newInstance());
            } catch (Exception e16) {
                QLog.e("TipsProcessorProxy", 1, "ILoginAction newInstance", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.graytip.b
    public boolean a(AppRuntime appRuntime, MessageForUniteGrayTip messageForUniteGrayTip) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) appRuntime, (Object) messageForUniteGrayTip)).booleanValue();
        }
        for (b bVar : this.f213671a) {
            if (bVar.a(appRuntime, messageForUniteGrayTip)) {
                QLog.d("TipsProcessorProxy", 1, "processor : ", bVar, " interruptAddTipsToDB");
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.graytip.b
    public void b(MessageForUniteGrayTip messageForUniteGrayTip) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) messageForUniteGrayTip);
            return;
        }
        Iterator<b> it = this.f213671a.iterator();
        while (it.hasNext()) {
            it.next().b(messageForUniteGrayTip);
        }
    }

    @Override // com.tencent.mobileqq.graytip.b
    public void c(g gVar, UniteEntity.Note note, int i3, String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, gVar, note, Integer.valueOf(i3), str, Long.valueOf(j3));
            return;
        }
        Iterator<b> it = this.f213671a.iterator();
        while (it.hasNext()) {
            it.next().c(gVar, note, i3, str, j3);
        }
    }
}
