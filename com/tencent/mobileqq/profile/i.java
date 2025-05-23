package com.tencent.mobileqq.profile;

import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f260182a;

    /* renamed from: b, reason: collision with root package name */
    public int f260183b;

    /* renamed from: c, reason: collision with root package name */
    public String f260184c;

    /* renamed from: d, reason: collision with root package name */
    public String f260185d;

    /* renamed from: e, reason: collision with root package name */
    public String f260186e;

    /* renamed from: f, reason: collision with root package name */
    public String f260187f;

    /* renamed from: g, reason: collision with root package name */
    public int f260188g;

    /* renamed from: h, reason: collision with root package name */
    public int f260189h;

    /* renamed from: i, reason: collision with root package name */
    public int f260190i;

    /* renamed from: j, reason: collision with root package name */
    public int f260191j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f260192k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f260193l;

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f260192k = false;
            this.f260193l = false;
        }
    }

    private String a() {
        switch (this.f260188g) {
            case 4:
                return HardCodeUtil.qqStr(R.string.t4z);
            case 5:
                return HardCodeUtil.qqStr(R.string.t4x);
            case 6:
                return HardCodeUtil.qqStr(R.string.t4v);
            case 7:
                return HardCodeUtil.qqStr(R.string.t4w);
            case 8:
                return HardCodeUtil.qqStr(R.string.f172657t50);
            case 9:
                return HardCodeUtil.qqStr(R.string.t4y);
            default:
                return "";
        }
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        if (this.f260183b == 3) {
            if (this.f260189h > 0) {
                sb5.append(this.f260189h + "\u7ea7");
            }
            if (!TextUtils.isEmpty(this.f260187f)) {
                if (sb5.length() > 0) {
                    sb5.append("   ");
                }
                sb5.append(this.f260187f);
            }
            if (this.f260188g > 0) {
                String a16 = a();
                if (!TextUtils.isEmpty(a16)) {
                    if (sb5.length() > 0) {
                        sb5.append("   ");
                    }
                    sb5.append(a16);
                }
            }
        } else if (this.f260189h > 0) {
            sb5.append(this.f260189h + "\u7ea7");
        }
        return sb5.toString();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "uint32_idx:" + this.f260182a + " uint32_category:" + this.f260183b + " str_school_id:" + this.f260184c + " str_school_name:" + this.f260185d + " str_department_id:" + this.f260186e + " str_department_name:" + this.f260187f + " uint32_degree:" + this.f260188g + " uint32_enrollment_year:" + this.f260189h + " uint32_graduation_year:" + this.f260190i + " uint32_allow_recommend:" + this.f260191j;
    }
}
