package com.tencent.mobileqq.service;

import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Long f286108a;

    /* renamed from: b, reason: collision with root package name */
    private int f286109b;

    /* renamed from: c, reason: collision with root package name */
    private int f286110c;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<String> f286111d;

    /* renamed from: e, reason: collision with root package name */
    private String f286112e;

    /* renamed from: f, reason: collision with root package name */
    private Long f286113f;

    /* renamed from: g, reason: collision with root package name */
    private ToServiceMsg f286114g;

    /* renamed from: h, reason: collision with root package name */
    private DataLineMsgRecord f286115h;

    /* renamed from: i, reason: collision with root package name */
    private int f286116i;

    public f(String str, Long l3, DataLineMsgRecord dataLineMsgRecord) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, l3, dataLineMsgRecord);
            return;
        }
        this.f286111d = new ArrayList<>();
        this.f286113f = l3;
        this.f286112e = str;
        this.f286108a = 0L;
        int i16 = 0;
        this.f286110c = 0;
        this.f286109b = ((this.f286112e.length() + 160) - 1) / 160;
        while (i16 < this.f286112e.length()) {
            int i17 = i16 + 160;
            if (i17 > this.f286112e.length()) {
                i3 = this.f286112e.length() - i16;
            } else {
                i3 = 160;
            }
            this.f286111d.add(this.f286112e.substring(i16, i3 + i16));
            i16 = i17;
        }
        this.f286115h = dataLineMsgRecord;
    }

    public Long a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Long) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f286113f;
    }

    public int b(StringBuffer stringBuffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) stringBuffer)).intValue();
        }
        if (this.f286111d.isEmpty()) {
            return -1;
        }
        stringBuffer.append(this.f286111d.remove(0));
        int i3 = this.f286110c;
        this.f286110c = i3 + 1;
        return i3;
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f286109b;
    }

    public void d(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) toServiceMsg);
        } else {
            this.f286114g = toServiceMsg;
        }
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.f286116i;
    }

    public void f(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.f286116i = i3;
        }
    }
}
