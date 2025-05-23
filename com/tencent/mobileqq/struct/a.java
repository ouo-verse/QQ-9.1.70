package com.tencent.mobileqq.struct;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @unique
    public String f290269a;

    /* renamed from: b, reason: collision with root package name */
    public String f290270b;

    /* renamed from: c, reason: collision with root package name */
    public String f290271c;

    /* renamed from: d, reason: collision with root package name */
    public short f290272d;

    /* renamed from: e, reason: collision with root package name */
    public String f290273e;

    /* renamed from: f, reason: collision with root package name */
    public String f290274f;

    /* renamed from: g, reason: collision with root package name */
    public String f290275g;

    /* renamed from: h, reason: collision with root package name */
    public String f290276h;

    /* renamed from: i, reason: collision with root package name */
    public String f290277i;

    /* renamed from: j, reason: collision with root package name */
    public String f290278j;

    /* renamed from: k, reason: collision with root package name */
    public String f290279k;

    /* renamed from: l, reason: collision with root package name */
    public String f290280l;

    /* renamed from: m, reason: collision with root package name */
    public ax f290281m;

    /* renamed from: n, reason: collision with root package name */
    public String f290282n;

    /* renamed from: o, reason: collision with root package name */
    public String f290283o;

    /* renamed from: p, reason: collision with root package name */
    public String f290284p;

    public a(long j3, String str, short s16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), str, Short.valueOf(s16));
            return;
        }
        this.f290270b = "";
        this.f290273e = "";
        this.f290274f = "";
        this.f290275g = "";
        this.f290276h = "";
        this.f290277i = "";
        this.f290278j = "";
        this.f290279k = "";
        this.f290280l = "";
        this.f290269a = String.valueOf(j3);
        this.f290271c = str;
        if (s16 == 0) {
            this.f290272d = (short) 10;
        } else {
            this.f290272d = s16;
        }
    }

    public boolean a(String str) {
        String[] split;
        int lastIndexOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        try {
            split = str.split(ContainerUtils.FIELD_DELIMITER);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("PushBanner", 2, "loadParams Exception:", e16);
            }
        }
        if (split.length == 7) {
            this.f290274f = split[0].substring(14);
            this.f290275g = split[1].substring(8);
            this.f290276h = split[2].substring(5);
            this.f290277i = split[3].substring(9);
            this.f290278j = split[4].substring(17);
            String decodeCgi = PkgTools.decodeCgi(split[5].substring(9));
            this.f290279k = decodeCgi;
            if (decodeCgi != null && decodeCgi.length() > 0 && (lastIndexOf = this.f290279k.lastIndexOf("channel_id")) != -1) {
                String substring = this.f290279k.substring(lastIndexOf);
                char charAt = substring.charAt(10);
                if (charAt == '%') {
                    String substring2 = substring.substring(substring.indexOf(37) + 3);
                    if (substring2.indexOf(37) > 0) {
                        substring2 = substring2.substring(0, substring2.indexOf(37));
                    }
                    this.f290270b = substring2;
                } else if (charAt == '=') {
                    String substring3 = substring.substring(substring.indexOf(61) + 1);
                    if (substring3.indexOf(38) > 0) {
                        substring3 = substring3.substring(0, substring3.indexOf(38));
                    }
                    this.f290270b = substring3;
                }
            }
            this.f290280l = split[6].substring(13);
            if (!"PLUGIN".equalsIgnoreCase(this.f290278j)) {
                return false;
            }
            return true;
        }
        throw new IllegalArgumentException("PushBanner Params Count must be:7");
    }
}
