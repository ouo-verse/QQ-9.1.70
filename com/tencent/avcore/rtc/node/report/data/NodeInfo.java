package com.tencent.avcore.rtc.node.report.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class NodeInfo {
    static IPatchRedirector $redirector_;
    public boolean cleanFileCache;
    public boolean needFileCache;
    public int nodeId;
    public String nodeName;
    public int nodeType;
    public int parentNodeId;
    public int preDependNodeId;
    public int timeoutIntervalMs;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private int f77521a;

        /* renamed from: b, reason: collision with root package name */
        private int f77522b;

        /* renamed from: c, reason: collision with root package name */
        private String f77523c;

        /* renamed from: d, reason: collision with root package name */
        private int f77524d;

        /* renamed from: e, reason: collision with root package name */
        private int f77525e;

        /* renamed from: f, reason: collision with root package name */
        private int f77526f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f77527g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f77528h;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f77523c = "";
            }
        }

        public NodeInfo i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (NodeInfo) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return new NodeInfo(this);
        }

        public a j(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (a) iPatchRedirector.redirect((short) 9, (Object) this, z16);
            }
            this.f77528h = z16;
            return this;
        }

        public a k(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (a) iPatchRedirector.redirect((short) 8, (Object) this, z16);
            }
            this.f77527g = z16;
            return this;
        }

        public a l(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
            this.f77521a = i3;
            return this;
        }

        public a m(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            }
            this.f77523c = str;
            return this;
        }

        public a n(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (a) iPatchRedirector.redirect((short) 6, (Object) this, i3);
            }
            this.f77525e = i3;
            return this;
        }
    }

    NodeInfo(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            return;
        }
        this.nodeId = 0;
        this.nodeType = 0;
        this.nodeName = "";
        this.timeoutIntervalMs = 0;
        this.preDependNodeId = 0;
        this.needFileCache = false;
        this.cleanFileCache = false;
        this.nodeId = aVar.f77521a;
        this.nodeType = aVar.f77522b;
        this.nodeName = aVar.f77523c;
        this.parentNodeId = aVar.f77524d;
        this.timeoutIntervalMs = aVar.f77525e;
        this.preDependNodeId = aVar.f77526f;
        this.needFileCache = aVar.f77527g;
        this.cleanFileCache = aVar.f77528h;
    }
}
