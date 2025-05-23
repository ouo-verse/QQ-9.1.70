package com.tencent.mobileqq.troop.redpoint;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f298268a;

    /* renamed from: b, reason: collision with root package name */
    public String f298269b;

    /* renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<Integer, RedPointItem> f298270c;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f298270c = new ConcurrentHashMap<>();
        }
    }

    public RedPointItem a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RedPointItem) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        ConcurrentHashMap<Integer, RedPointItem> concurrentHashMap = this.f298270c;
        if (concurrentHashMap != null) {
            return concurrentHashMap.get(Integer.valueOf(i3));
        }
        return null;
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        ConcurrentHashMap<Integer, RedPointItem> concurrentHashMap = this.f298270c;
        if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
            return true;
        }
        return false;
    }

    public boolean c(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("RedPointInfo", 2, "updateRedPointInfo : redId = " + i3 + ", uinReadNum = " + i16);
        }
        ConcurrentHashMap<Integer, RedPointItem> concurrentHashMap = this.f298270c;
        if (concurrentHashMap == null) {
            return false;
        }
        RedPointItem redPointItem = concurrentHashMap.get(Integer.valueOf(i3));
        if (redPointItem == null) {
            if (i16 != 0) {
                this.f298270c.put(Integer.valueOf(i3), new RedPointItem(i3, i16));
            }
            z16 = false;
        } else {
            if (redPointItem.unReadNum != i16) {
                if (i16 == 0) {
                    this.f298270c.remove(Integer.valueOf(i3));
                } else {
                    redPointItem.unReadNum = i16;
                    this.f298270c.put(Integer.valueOf(i3), redPointItem);
                }
            }
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("RedPointInfo", 2, "updateRedPointInfo isChanged = " + z16);
        }
        return z16;
    }

    public boolean d(HashMap<Integer, Integer> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) hashMap)).booleanValue();
        }
        boolean z16 = false;
        if (hashMap != null && !hashMap.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.d("RedPointInfo", 2, "updateRedPointInfo : redPointInfoMap " + hashMap.toString());
            }
            for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
                Integer key = entry.getKey();
                Integer value = entry.getValue();
                if (z16) {
                    c(key.intValue(), value.intValue());
                } else {
                    z16 = c(key.intValue(), value.intValue());
                }
            }
        }
        return z16;
    }
}
