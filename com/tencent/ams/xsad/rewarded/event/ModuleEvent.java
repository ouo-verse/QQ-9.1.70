package com.tencent.ams.xsad.rewarded.event;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ModuleEvent {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @Event
    public int f71810a;

    /* renamed from: b, reason: collision with root package name */
    public Map<String, String> f71811b;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface Event {
        public static final int CLICK = 1;
        public static final int ENTER_VIP_CLICK = 5;
        public static final int NONE = 0;
        public static final int ORIGIN_EXPOSURE = 2;
        public static final int VALID_EXPOSURE = 3;
        public static final int VALID_INTERACTIVE = 4;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private int f71812a;

        /* renamed from: b, reason: collision with root package name */
        private Map<String, String> f71813b;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public ModuleEvent c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (ModuleEvent) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return new ModuleEvent(this, null);
        }

        public b d(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (b) iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
            this.f71812a = i3;
            return this;
        }

        public b e(Map<String, String> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) map);
            }
            this.f71813b = map;
            return this;
        }
    }

    /* synthetic */ ModuleEvent(b bVar, a aVar) {
        this(bVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar, (Object) aVar);
    }

    public ModuleEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    ModuleEvent(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
        } else {
            this.f71810a = bVar.f71812a;
            this.f71811b = bVar.f71813b;
        }
    }
}
