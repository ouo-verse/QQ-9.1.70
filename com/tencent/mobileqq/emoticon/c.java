package com.tencent.mobileqq.emoticon;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static c f204730b;

    /* renamed from: a, reason: collision with root package name */
    ArrayList<WeakReference<EmotionPanelPayBackListener>> f204731a;

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f204731a = new ArrayList<>();
        }
    }

    public static c c() {
        if (f204730b == null) {
            synchronized (c.class) {
                if (f204730b == null) {
                    f204730b = new c();
                }
            }
        }
        return f204730b;
    }

    public void a(EmotionPanelPayBackListener emotionPanelPayBackListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) emotionPanelPayBackListener);
            return;
        }
        if (emotionPanelPayBackListener == null) {
            return;
        }
        synchronized (this.f204731a) {
            Iterator<WeakReference<EmotionPanelPayBackListener>> it = this.f204731a.iterator();
            while (it.hasNext()) {
                if (it.next().get() == emotionPanelPayBackListener) {
                    return;
                }
            }
            this.f204731a.add(new WeakReference<>(emotionPanelPayBackListener));
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        synchronized (this.f204731a) {
            this.f204731a.clear();
        }
    }

    public void d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        ArrayList<WeakReference<EmotionPanelPayBackListener>> arrayList = this.f204731a;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<WeakReference<EmotionPanelPayBackListener>> it = this.f204731a.iterator();
            while (it.hasNext()) {
                EmotionPanelPayBackListener emotionPanelPayBackListener = it.next().get();
                if (emotionPanelPayBackListener != null) {
                    emotionPanelPayBackListener.onPayBack(i3);
                }
            }
        }
    }

    public void e(EmotionPanelPayBackListener emotionPanelPayBackListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) emotionPanelPayBackListener);
            return;
        }
        if (emotionPanelPayBackListener == null) {
            return;
        }
        synchronized (this.f204731a) {
            Iterator<WeakReference<EmotionPanelPayBackListener>> it = this.f204731a.iterator();
            while (it.hasNext()) {
                if (it.next().get() == emotionPanelPayBackListener) {
                    it.remove();
                }
            }
        }
    }
}
