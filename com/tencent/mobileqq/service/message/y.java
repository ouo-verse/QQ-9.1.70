package com.tencent.mobileqq.service.message;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$Text;

/* compiled from: P */
/* loaded from: classes18.dex */
public class y {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected StringBuilder f286352a;

    /* renamed from: b, reason: collision with root package name */
    protected long f286353b;

    /* renamed from: c, reason: collision with root package name */
    protected long f286354c;

    /* renamed from: d, reason: collision with root package name */
    protected com.tencent.mobileqq.troop.data.c f286355d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<AtTroopMemberInfo> f286356e;

    /* renamed from: f, reason: collision with root package name */
    private AtTroopMemberInfo f286357f;

    /* renamed from: g, reason: collision with root package name */
    private AtTroopMemberInfo f286358g;

    /* renamed from: h, reason: collision with root package name */
    protected byte[] f286359h;

    /* renamed from: i, reason: collision with root package name */
    protected StringBuilder f286360i;

    /* renamed from: j, reason: collision with root package name */
    protected boolean f286361j;

    /* renamed from: k, reason: collision with root package name */
    protected im_msg_body$Elem f286362k;

    /* renamed from: l, reason: collision with root package name */
    protected AppRuntime f286363l;

    public y(AppRuntime appRuntime, StringBuilder sb5, long j3, com.tencent.mobileqq.troop.data.c cVar, ArrayList<AtTroopMemberInfo> arrayList, AtTroopMemberInfo atTroopMemberInfo, AtTroopMemberInfo atTroopMemberInfo2, byte[] bArr, StringBuilder sb6, boolean z16, im_msg_body$Elem im_msg_body_elem, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, sb5, Long.valueOf(j3), cVar, arrayList, atTroopMemberInfo, atTroopMemberInfo2, bArr, sb6, Boolean.valueOf(z16), im_msg_body_elem, Long.valueOf(j16));
            return;
        }
        this.f286352a = sb5;
        this.f286353b = j3;
        this.f286355d = cVar;
        this.f286356e = arrayList;
        this.f286357f = atTroopMemberInfo;
        this.f286358g = atTroopMemberInfo2;
        this.f286359h = bArr;
        this.f286360i = sb6;
        this.f286361j = z16;
        this.f286362k = im_msg_body_elem;
        this.f286363l = appRuntime;
        this.f286354c = j16;
    }

    private void a(int i3, byte[] bArr) {
        short s16 = 0;
        short shortData = PkgTools.getShortData(bArr, 0);
        int i16 = 2;
        while (s16 < shortData && i16 < 2048) {
            AtTroopMemberInfo atTroopMemberInfo = new AtTroopMemberInfo();
            if (atTroopMemberInfo.readFrom(bArr, i16)) {
                i16 += atTroopMemberInfo.length();
                atTroopMemberInfo.startPos = (short) (atTroopMemberInfo.startPos + i3);
                s16 = (short) (s16 + 1);
                this.f286356e.add(atTroopMemberInfo);
            } else {
                return;
            }
        }
    }

    private void b(int i3, byte[] bArr) {
        short s16 = 0;
        short shortData = PkgTools.getShortData(bArr, 0);
        int i16 = 2;
        while (s16 < shortData && i16 < 2048) {
            AtTroopMemberInfo atTroopMemberInfo = new AtTroopMemberInfo();
            if (s16 == 0 && this.f286357f == null) {
                this.f286357f = atTroopMemberInfo;
            }
            if (atTroopMemberInfo.readFrom(bArr, i16)) {
                i16 += atTroopMemberInfo.length();
                atTroopMemberInfo.startPos = (short) (atTroopMemberInfo.startPos + i3);
                s16 = (short) (s16 + 1);
                if (atTroopMemberInfo.isIncludingAll()) {
                    this.f286355d.f294893c.k(14, this.f286353b, this.f286354c);
                }
                if (atTroopMemberInfo.isIncludingMe(this.f286363l.getLongAccountUin())) {
                    this.f286355d.f294893c.k(25, this.f286353b, this.f286354c);
                    AtTroopMemberInfo atTroopMemberInfo2 = this.f286357f;
                    if (atTroopMemberInfo != atTroopMemberInfo2 && this.f286358g == null && atTroopMemberInfo2 != null && atTroopMemberInfo2.isIncludingMe(this.f286363l.getLongAccountUin())) {
                        this.f286358g = atTroopMemberInfo;
                    }
                }
            } else {
                return;
            }
        }
    }

    private void c(ByteStringMicro byteStringMicro, int i3) {
        byte[] bArr;
        int i16;
        if (byteStringMicro != null) {
            bArr = byteStringMicro.toByteArray();
        } else {
            bArr = null;
        }
        com.tencent.mobileqq.troop.data.c cVar = this.f286355d;
        if (cVar != null && (((i16 = cVar.f294892b) == 3000 || i16 == 1) && this.f286356e != null && bArr != null && bArr.length != 0)) {
            a(i3, bArr);
        }
        com.tencent.mobileqq.troop.data.c cVar2 = this.f286355d;
        if (cVar2 != null) {
            if ((cVar2.f294893c.e(25, this.f286353b) || this.f286355d.f294893c.e(14, this.f286353b) || this.f286358g == null) && bArr != null && bArr.length != 0) {
                b(i3, bArr);
            }
        }
    }

    @Nullable
    private y f() {
        if (QLog.isColorLevel()) {
            this.f286352a.append("elemType:Text;\n");
        }
        if (this.f286361j) {
            this.f286361j = false;
            return this;
        }
        im_msg_body$Text im_msg_body_text = this.f286362k.text.get();
        int length = this.f286360i.length();
        if (im_msg_body_text.str.has()) {
            this.f286360i.append(x.a(im_msg_body_text.str.get().toStringUtf8(), false));
        }
        if (im_msg_body_text.attr_6_buf.has()) {
            c(im_msg_body_text.attr_6_buf.get(), length);
            return null;
        }
        return null;
    }

    protected void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    public byte[] e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (byte[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f286359h;
    }

    public AtTroopMemberInfo g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AtTroopMemberInfo) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f286357f;
    }

    public AtTroopMemberInfo h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AtTroopMemberInfo) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f286358g;
    }

    public y i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (y) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (this.f286362k.text.has()) {
            y f16 = f();
            if (f16 != null) {
                return f16;
            }
        } else {
            d();
        }
        return this;
    }

    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.f286361j;
    }
}
