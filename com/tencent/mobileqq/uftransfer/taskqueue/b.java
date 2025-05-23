package com.tencent.mobileqq.uftransfer.taskqueue;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.depend.c;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b extends Observable {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static b f305703b;

    /* renamed from: a, reason: collision with root package name */
    private Set<String> f305704a;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static abstract class a implements Observer {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        protected abstract void a(String str, int i3);

        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) observable, obj);
            } else {
                Object[] objArr = (Object[]) obj;
                a((String) objArr[0], ((Integer) objArr[1]).intValue());
            }
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f305704a = new HashSet();
        }
    }

    public static b c() {
        if (f305703b == null) {
            f305703b = new b();
        }
        return f305703b;
    }

    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.f305704a.add(str);
            c.c("[UFTTransfer] UFTUploadTaskQueueHelper", 1, "addUploadingFilePath:" + str + " Size:" + this.f305704a.size());
        }
    }

    public boolean b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str)).booleanValue();
        }
        return this.f305704a.contains(str);
    }

    public void d(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, i3);
            return;
        }
        if (this.f305704a.remove(str)) {
            c.c("[UFTTransfer] UFTUploadTaskQueueHelper", 1, "remUploadingFilePath:" + str + " Size:" + this.f305704a.size() + " queueId:" + i3);
            setChanged();
            notifyObservers(new Object[]{str, Integer.valueOf(i3)});
        }
    }
}
