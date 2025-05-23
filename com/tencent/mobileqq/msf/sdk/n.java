package com.tencent.mobileqq.msf.sdk;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class n extends JceStruct {

    /* renamed from: f, reason: collision with root package name */
    static NotifyRegisterInfo f250618f;

    /* renamed from: g, reason: collision with root package name */
    static CommandCallbackerInfo f250619g;

    /* renamed from: a, reason: collision with root package name */
    public int f250620a;

    /* renamed from: b, reason: collision with root package name */
    public String f250621b;

    /* renamed from: c, reason: collision with root package name */
    public String f250622c;

    /* renamed from: d, reason: collision with root package name */
    public NotifyRegisterInfo f250623d;

    /* renamed from: e, reason: collision with root package name */
    public CommandCallbackerInfo f250624e;

    public n() {
        this.f250620a = 0;
        this.f250621b = "";
        this.f250622c = "";
        this.f250623d = null;
        this.f250624e = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f250620a = jceInputStream.read(this.f250620a, 1, true);
        this.f250621b = jceInputStream.readString(2, true);
        this.f250622c = jceInputStream.readString(3, true);
        if (f250618f == null) {
            f250618f = new NotifyRegisterInfo();
        }
        this.f250623d = (NotifyRegisterInfo) jceInputStream.read((JceStruct) f250618f, 4, true);
        if (f250619g == null) {
            f250619g = new CommandCallbackerInfo();
        }
        this.f250624e = (CommandCallbackerInfo) jceInputStream.read((JceStruct) f250619g, 5, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f250620a, 1);
        jceOutputStream.write(this.f250621b, 2);
        jceOutputStream.write(this.f250622c, 3);
        jceOutputStream.write((JceStruct) this.f250623d, 4);
        jceOutputStream.write((JceStruct) this.f250624e, 5);
    }

    public n(int i3, String str, String str2, NotifyRegisterInfo notifyRegisterInfo, CommandCallbackerInfo commandCallbackerInfo) {
        this.f250620a = i3;
        this.f250621b = str;
        this.f250622c = str2;
        this.f250623d = notifyRegisterInfo;
        this.f250624e = commandCallbackerInfo;
    }
}
