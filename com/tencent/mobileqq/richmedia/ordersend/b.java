package com.tencent.mobileqq.richmedia.ordersend;

import com.tencent.mobileqq.app.bo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    int f281622a;

    /* renamed from: b, reason: collision with root package name */
    int f281623b;

    /* renamed from: c, reason: collision with root package name */
    int f281624c;

    /* renamed from: d, reason: collision with root package name */
    long f281625d;

    /* renamed from: e, reason: collision with root package name */
    String f281626e;

    /* renamed from: f, reason: collision with root package name */
    boolean f281627f;

    /* renamed from: g, reason: collision with root package name */
    boolean f281628g;

    /* renamed from: h, reason: collision with root package name */
    MessageRecord f281629h;

    /* renamed from: i, reason: collision with root package name */
    bo f281630i;

    /* renamed from: j, reason: collision with root package name */
    IOrderMediaMsgService.a f281631j;

    /* renamed from: k, reason: collision with root package name */
    Runnable f281632k;

    public boolean a() {
        if (this.f281629h != null && this.f281623b >= 2) {
            return true;
        }
        return false;
    }

    public boolean b() {
        if (this.f281629h != null && this.f281624c >= 4) {
            return true;
        }
        return false;
    }

    public boolean c() {
        if (this.f281629h != null && this.f281623b == 1) {
            return true;
        }
        return false;
    }

    public boolean d() {
        if (this.f281629h != null && this.f281624c == 3) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder(90);
        sb5.append(" MsgItem{index=");
        sb5.append(this.f281622a);
        sb5.append(", uniseq=");
        sb5.append(this.f281625d);
        sb5.append(", addStatus=");
        sb5.append(this.f281623b);
        sb5.append(", sendStatus=");
        sb5.append(this.f281624c);
        sb5.append(", isInvalid=");
        sb5.append(this.f281628g);
        sb5.append('}');
        return sb5.toString();
    }
}
