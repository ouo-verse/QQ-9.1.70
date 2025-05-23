package com.tencent.mobileqq.msf.core.push;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.msf.sdk.CommandCallbackerInfo;
import com.tencent.mobileqq.msf.sdk.NotifyRegisterInfo;
import com.tencent.mobileqq.msf.sdk.PushRegisterInfo;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class a extends JceStruct {

    /* renamed from: o, reason: collision with root package name */
    static PushRegisterInfo f249584o;

    /* renamed from: p, reason: collision with root package name */
    static NotifyRegisterInfo f249585p;

    /* renamed from: q, reason: collision with root package name */
    static CommandCallbackerInfo f249586q;

    /* renamed from: a, reason: collision with root package name */
    public int f249587a;

    /* renamed from: b, reason: collision with root package name */
    public String f249588b;

    /* renamed from: c, reason: collision with root package name */
    public long f249589c;

    /* renamed from: d, reason: collision with root package name */
    public long f249590d;

    /* renamed from: e, reason: collision with root package name */
    public long f249591e;

    /* renamed from: f, reason: collision with root package name */
    public long f249592f;

    /* renamed from: g, reason: collision with root package name */
    public long f249593g;

    /* renamed from: h, reason: collision with root package name */
    public long f249594h;

    /* renamed from: i, reason: collision with root package name */
    public String f249595i;

    /* renamed from: j, reason: collision with root package name */
    public String f249596j;

    /* renamed from: k, reason: collision with root package name */
    public PushRegisterInfo f249597k;

    /* renamed from: l, reason: collision with root package name */
    public NotifyRegisterInfo f249598l;

    /* renamed from: m, reason: collision with root package name */
    public CommandCallbackerInfo f249599m;

    /* renamed from: n, reason: collision with root package name */
    public String f249600n;

    public a() {
        this.f249587a = 0;
        this.f249588b = "";
        this.f249589c = 0L;
        this.f249590d = 0L;
        this.f249591e = 0L;
        this.f249592f = 0L;
        this.f249593g = 0L;
        this.f249594h = 0L;
        this.f249595i = "";
        this.f249596j = "";
        this.f249597k = null;
        this.f249598l = null;
        this.f249599m = null;
        this.f249600n = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f249587a = jceInputStream.read(this.f249587a, 1, true);
        this.f249588b = jceInputStream.readString(2, true);
        this.f249589c = jceInputStream.read(this.f249589c, 3, true);
        this.f249590d = jceInputStream.read(this.f249590d, 4, true);
        this.f249591e = jceInputStream.read(this.f249591e, 5, false);
        this.f249592f = jceInputStream.read(this.f249592f, 6, false);
        this.f249593g = jceInputStream.read(this.f249593g, 7, false);
        this.f249594h = jceInputStream.read(this.f249594h, 8, false);
        this.f249595i = jceInputStream.readString(9, false);
        this.f249596j = jceInputStream.readString(10, false);
        if (f249584o == null) {
            f249584o = new PushRegisterInfo();
        }
        this.f249597k = (PushRegisterInfo) jceInputStream.read((JceStruct) f249584o, 11, false);
        if (f249585p == null) {
            f249585p = new NotifyRegisterInfo();
        }
        this.f249598l = (NotifyRegisterInfo) jceInputStream.read((JceStruct) f249585p, 12, false);
        if (f249586q == null) {
            f249586q = new CommandCallbackerInfo();
        }
        this.f249599m = (CommandCallbackerInfo) jceInputStream.read((JceStruct) f249586q, 13, false);
        this.f249600n = jceInputStream.readString(14, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f249587a, 1);
        jceOutputStream.write(this.f249588b, 2);
        jceOutputStream.write(this.f249589c, 3);
        jceOutputStream.write(this.f249590d, 4);
        jceOutputStream.write(this.f249591e, 5);
        jceOutputStream.write(this.f249592f, 6);
        jceOutputStream.write(this.f249593g, 7);
        jceOutputStream.write(this.f249594h, 8);
        String str = this.f249595i;
        if (str != null) {
            jceOutputStream.write(str, 9);
        }
        String str2 = this.f249596j;
        if (str2 != null) {
            jceOutputStream.write(str2, 10);
        }
        PushRegisterInfo pushRegisterInfo = this.f249597k;
        if (pushRegisterInfo != null) {
            jceOutputStream.write((JceStruct) pushRegisterInfo, 11);
        }
        NotifyRegisterInfo notifyRegisterInfo = this.f249598l;
        if (notifyRegisterInfo != null) {
            jceOutputStream.write((JceStruct) notifyRegisterInfo, 12);
        }
        CommandCallbackerInfo commandCallbackerInfo = this.f249599m;
        if (commandCallbackerInfo != null) {
            jceOutputStream.write((JceStruct) commandCallbackerInfo, 13);
        }
        String str3 = this.f249600n;
        if (str3 != null) {
            jceOutputStream.write(str3, 14);
        }
    }

    public a(int i3, String str, long j3, long j16, long j17, long j18, long j19, long j26, String str2, String str3, PushRegisterInfo pushRegisterInfo, NotifyRegisterInfo notifyRegisterInfo, CommandCallbackerInfo commandCallbackerInfo, String str4) {
        this.f249587a = i3;
        this.f249588b = str;
        this.f249589c = j3;
        this.f249590d = j16;
        this.f249591e = j17;
        this.f249592f = j18;
        this.f249593g = j19;
        this.f249594h = j26;
        this.f249595i = str2;
        this.f249596j = str3;
        this.f249597k = pushRegisterInfo;
        this.f249598l = notifyRegisterInfo;
        this.f249599m = commandCallbackerInfo;
        this.f249600n = str4;
    }

    public a(String str) {
        this.f249587a = 0;
        this.f249589c = 0L;
        this.f249590d = 0L;
        this.f249591e = 0L;
        this.f249592f = 0L;
        this.f249593g = 0L;
        this.f249594h = 0L;
        this.f249595i = "";
        this.f249596j = "";
        this.f249597k = null;
        this.f249598l = null;
        this.f249599m = null;
        this.f249600n = "";
        this.f249588b = str;
        this.f249600n = "" + com.tencent.mobileqq.msf.core.c.c(BaseApplication.getContext());
    }
}
