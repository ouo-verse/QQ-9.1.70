package com.tencent.avcore.rtc.node.report.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f77529a;

    /* renamed from: b, reason: collision with root package name */
    public int f77530b;

    /* renamed from: c, reason: collision with root package name */
    public String f77531c;

    /* renamed from: d, reason: collision with root package name */
    public int f77532d;

    /* renamed from: e, reason: collision with root package name */
    public CommonNodeData f77533e;

    /* renamed from: f, reason: collision with root package name */
    public StartState f77534f;

    /* renamed from: g, reason: collision with root package name */
    public EndState f77535g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList<NodeEvent> f77536h;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f77530b = NodeModel$NodeType.MASTER_NODE.ordinal();
        this.f77531c = "";
        this.f77533e = new CommonNodeData();
        this.f77534f = new StartState();
        this.f77535g = new EndState();
        this.f77536h = new ArrayList<>();
    }
}
