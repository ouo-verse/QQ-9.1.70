package com.tencent.paysdk.jsbridge;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a implements mq3.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, ArrayList<b>> f342027a;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f342027a = new HashMap<>();
        }
    }

    private void d() {
        if (this.f342027a.size() > 0) {
            Iterator<Map.Entry<String, ArrayList<b>>> it = this.f342027a.entrySet().iterator();
            while (it.hasNext()) {
                ArrayList<b> value = it.next().getValue();
                if (value != null) {
                    Iterator<b> it5 = value.iterator();
                    while (it5.hasNext()) {
                        b next = it5.next();
                        if (next != null) {
                            next.onJsDestroy();
                        }
                    }
                }
            }
        }
    }

    private ArrayList<b> e(String str) {
        return this.f342027a.get(str);
    }

    @Override // mq3.b
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            d();
            this.f342027a.clear();
        }
    }

    @Override // mq3.b
    public void b(String str, String str2, Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, str2, map);
            return;
        }
        ArrayList<b> e16 = e(str);
        if (e16 != null && !e16.isEmpty()) {
            Iterator<b> it = e16.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && !TextUtils.isEmpty(str2)) {
                    try {
                        Method method = next.getClass().getMethod(str2, Map.class);
                        if (method != null && method.isAnnotationPresent(JavascriptInterface.class)) {
                            method.invoke(next, map);
                        }
                    } catch (Exception e17) {
                        Log.e("DefaultJsModuleProvider", "callFunction exception: moduleName is " + str + ", methodName is " + str2 + ", jsModule is " + next + ", e is " + e17.getMessage());
                        return;
                    }
                }
            }
            return;
        }
        Log.e("DefaultJsModuleProvider", "callFunction: jsModuleList is null or empty, moduleName is " + str + ", methodName is " + str2);
    }

    @Override // mq3.b
    public void c(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
            return;
        }
        if (bVar == null) {
            Log.e("DefaultJsModuleProvider", "registerJsModule: module is null");
            return;
        }
        ArrayList<b> arrayList = this.f342027a.get(bVar.getName());
        boolean z16 = false;
        if (arrayList != null) {
            Iterator<b> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b next = it.next();
                if (next == bVar) {
                    Log.i("DefaultJsModuleProvider", "registerJsModule: module is exist in list");
                    z16 = true;
                    break;
                } else if (bVar.getClass().getSuperclass().getSimpleName().equals(next.getClass().getSimpleName())) {
                    Log.i("DefaultJsModuleProvider", "registerJsModule: remove module, because module is base class, jsModule is " + next);
                    next.onJsDestroy();
                    it.remove();
                }
            }
        } else {
            arrayList = new ArrayList<>();
            this.f342027a.put(bVar.getName(), arrayList);
        }
        if (!z16) {
            arrayList.add(bVar);
        }
    }
}
