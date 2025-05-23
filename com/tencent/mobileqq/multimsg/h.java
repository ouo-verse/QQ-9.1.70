package com.tencent.mobileqq.multimsg;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public SessionInfo f251617a;

    /* renamed from: b, reason: collision with root package name */
    public List<ChatMessage> f251618b;

    /* renamed from: c, reason: collision with root package name */
    public Map<String, String> f251619c;

    /* renamed from: d, reason: collision with root package name */
    public AbsStructMsg f251620d;

    /* renamed from: e, reason: collision with root package name */
    public MessageRecord f251621e;

    /* renamed from: f, reason: collision with root package name */
    public HashMap<String, ArrayList<MessageRecord>> f251622f;

    /* renamed from: g, reason: collision with root package name */
    public List<MessageRecord> f251623g;

    /* renamed from: h, reason: collision with root package name */
    public int f251624h;

    /* renamed from: i, reason: collision with root package name */
    public int f251625i;

    /* renamed from: j, reason: collision with root package name */
    private int f251626j;

    /* renamed from: k, reason: collision with root package name */
    private Object f251627k;

    /* renamed from: l, reason: collision with root package name */
    private int f251628l;

    /* renamed from: m, reason: collision with root package name */
    public int f251629m;

    /* renamed from: n, reason: collision with root package name */
    public int f251630n;

    /* renamed from: o, reason: collision with root package name */
    public int f251631o;

    /* renamed from: p, reason: collision with root package name */
    public int f251632p;

    /* renamed from: q, reason: collision with root package name */
    public int f251633q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f251634r;

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f251627k = new Object();
        }
    }

    public int a() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        synchronized (this.f251627k) {
            i3 = this.f251626j;
        }
        return i3;
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return String.valueOf(hashCode());
    }

    public int c() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        synchronized (this.f251627k) {
            i3 = this.f251628l;
        }
        return i3;
    }

    public void d(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        synchronized (this.f251627k) {
            int i17 = this.f251628l;
            if (i3 == 0) {
                i16 = 0;
            }
            this.f251628l = i17 + i16;
        }
    }

    public void e(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        synchronized (this.f251627k) {
            this.f251626j = i3 ^ this.f251626j;
        }
    }
}
