package com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfloatingwindow.impl.QQFloatingWindowImpl;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, com.tencent.mobileqq.qqfloatingwindow.a> f264385a;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f264385a = new HashMap();
        }
    }

    public ArrayList<com.tencent.mobileqq.qqfloatingwindow.a> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        ArrayList<com.tencent.mobileqq.qqfloatingwindow.a> arrayList = new ArrayList<>();
        Iterator<Map.Entry<String, com.tencent.mobileqq.qqfloatingwindow.a>> it = this.f264385a.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        return arrayList;
    }

    public com.tencent.mobileqq.qqfloatingwindow.a b(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.qqfloatingwindow.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) str);
        }
        com.tencent.mobileqq.qqfloatingwindow.a aVar = this.f264385a.get(str);
        if (aVar == null && context != null) {
            try {
                Constructor<?> declaredConstructor = Class.forName(str).getDeclaredConstructor(Context.class);
                declaredConstructor.setAccessible(true);
                com.tencent.mobileqq.qqfloatingwindow.a aVar2 = (com.tencent.mobileqq.qqfloatingwindow.a) declaredConstructor.newInstance(context);
                try {
                    this.f264385a.put(str, aVar2);
                    return aVar2;
                } catch (Exception e16) {
                    e = e16;
                    aVar = aVar2;
                    QLog.e(QQFloatingWindowImpl.TAG, 1, e, new Object[0]);
                    return aVar;
                }
            } catch (Exception e17) {
                e = e17;
            }
        } else {
            return aVar;
        }
    }
}
