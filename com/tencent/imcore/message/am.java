package com.tencent.imcore.message;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
class am {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private List<MessageRecord> f116563a;

    /* renamed from: b, reason: collision with root package name */
    private long f116564b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f116565c;

    public am(List<MessageRecord> list, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, list, Long.valueOf(j3));
        } else {
            this.f116563a = list;
            this.f116564b = j3;
        }
    }

    public am a() {
        int size;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (am) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        int i3 = 0;
        this.f116565c = false;
        List<MessageRecord> list = this.f116563a;
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        while (true) {
            if (i3 >= size) {
                break;
            }
            if (this.f116563a.get(i3).uniseq == this.f116564b) {
                while (true) {
                    if (i3 >= this.f116563a.size()) {
                        break;
                    }
                    if (ao.C(this.f116563a.get(i3).msgtype)) {
                        this.f116564b = this.f116563a.get(i3).uniseq;
                        this.f116565c = true;
                        break;
                    }
                    i3++;
                }
            } else {
                i3++;
            }
        }
        return this;
    }

    public long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return this.f116564b;
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.f116565c;
    }
}
