package com.tencent.mobileqq.activity.recent.gamemsgbox.data;

import com.tencent.mobileqq.gamecenter.msginfo.GameSwitchConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import cooperation.qzone.QZoneShareManager;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b implements Comparable<b> {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static final HashMap<String, Integer> f185506f;

    /* renamed from: d, reason: collision with root package name */
    public gd1.a f185507d;

    /* renamed from: e, reason: collision with root package name */
    public GameSwitchConfig f185508e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21514);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        HashMap<String, Integer> hashMap = new HashMap<>();
        f185506f = hashMap;
        hashMap.put(QZoneShareManager.GLORY_OF_KINGS, 1);
        hashMap.put("1106467070", 2);
        hashMap.put("1106838536", 3);
        hashMap.put("1105371489", 4);
        hashMap.put("1109807272", 5);
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar)).intValue();
        }
        HashMap<String, Integer> hashMap = f185506f;
        if (!hashMap.containsKey(this.f185507d.f401939c)) {
            return 1;
        }
        if (!hashMap.containsKey(bVar.f185507d.f401939c)) {
            return -1;
        }
        return hashMap.get(this.f185507d.f401939c).intValue() - hashMap.get(bVar.f185507d.f401939c).intValue();
    }
}
