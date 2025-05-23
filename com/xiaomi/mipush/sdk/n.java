package com.xiaomi.mipush.sdk;

import com.xiaomi.push.service.module.PushChannelRegion;

/* compiled from: P */
/* loaded from: classes28.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private PushChannelRegion f388074a = PushChannelRegion.China;

    /* renamed from: b, reason: collision with root package name */
    private boolean f388075b = false;

    /* renamed from: c, reason: collision with root package name */
    private boolean f388076c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f388077d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f388078e = false;

    public boolean a() {
        return this.f388077d;
    }

    public boolean b() {
        return this.f388076c;
    }

    public boolean c() {
        return this.f388078e;
    }

    public boolean d() {
        return this.f388075b;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("PushConfiguration{");
        stringBuffer.append("Region:");
        PushChannelRegion pushChannelRegion = this.f388074a;
        if (pushChannelRegion == null) {
            stringBuffer.append("null");
        } else {
            stringBuffer.append(pushChannelRegion.name());
        }
        stringBuffer.append(",mOpenHmsPush:" + this.f388075b);
        stringBuffer.append(",mOpenFCMPush:" + this.f388076c);
        stringBuffer.append(",mOpenCOSPush:" + this.f388077d);
        stringBuffer.append(",mOpenFTOSPush:" + this.f388078e);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
