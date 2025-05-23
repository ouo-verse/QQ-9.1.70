package com.tencent.mobileqq.avatar.dynamicavatar;

import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f200050a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f200051b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f200052c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f200053d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f200054e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f200055f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f200056g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f200057h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f200058i;

    /* renamed from: j, reason: collision with root package name */
    public int f200059j;

    /* renamed from: k, reason: collision with root package name */
    public int f200060k;

    /* renamed from: l, reason: collision with root package name */
    public int f200061l;

    /* renamed from: m, reason: collision with root package name */
    public int f200062m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f200063n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f200064o;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            a();
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.dynamic_avatar.name());
        this.f200050a = featureValue;
        this.f200051b = true;
        try {
            String[] split = featureValue.split("\\|");
            if (split.length >= 11) {
                this.f200051b = false;
                if (Integer.valueOf(split[0]).intValue() == 1) {
                    this.f200052c = true;
                } else {
                    this.f200052c = false;
                }
                if (this.f200052c) {
                    if (Integer.valueOf(split[1]).intValue() == 1) {
                        this.f200053d = true;
                    } else {
                        this.f200053d = false;
                    }
                    if (Integer.valueOf(split[2]).intValue() == 1) {
                        this.f200054e = true;
                    } else {
                        this.f200054e = false;
                    }
                    if (Integer.valueOf(split[3]).intValue() == 1) {
                        this.f200055f = true;
                    } else {
                        this.f200055f = false;
                    }
                    if (Integer.valueOf(split[4]).intValue() == 1) {
                        this.f200056g = true;
                    } else {
                        this.f200056g = false;
                    }
                    if (Integer.valueOf(split[5]).intValue() == 1) {
                        this.f200057h = true;
                    } else {
                        this.f200057h = false;
                    }
                    if (Integer.valueOf(split[6]).intValue() == 1) {
                        this.f200058i = true;
                    } else {
                        this.f200058i = false;
                    }
                    if (Integer.valueOf(split[11]).intValue() == 1) {
                        this.f200063n = true;
                    } else {
                        this.f200063n = false;
                    }
                    if (Integer.valueOf(split[12]).intValue() == 1) {
                        this.f200064o = true;
                    } else {
                        this.f200064o = false;
                    }
                } else {
                    this.f200053d = false;
                    this.f200054e = false;
                    this.f200055f = false;
                    this.f200056g = false;
                    this.f200057h = false;
                    this.f200058i = false;
                    this.f200063n = false;
                    this.f200064o = false;
                }
                this.f200059j = Integer.valueOf(split[7]).intValue();
                this.f200060k = Integer.valueOf(split[8]).intValue();
                this.f200061l = Integer.valueOf(split[9]).intValue();
                this.f200062m = Integer.valueOf(split[10]).intValue();
            }
        } catch (Exception e16) {
            this.f200051b = true;
            if (QLog.isColorLevel()) {
                QLog.d("DynamicAvatarConfig", 2, "parse config exception:" + e16.getMessage());
            }
        }
        if (this.f200051b) {
            this.f200052c = true;
            this.f200053d = true;
            this.f200054e = true;
            this.f200055f = true;
            this.f200056g = true;
            this.f200057h = true;
            this.f200058i = true;
            this.f200059j = 8;
            this.f200060k = 200;
            this.f200061l = 18;
            this.f200062m = 18;
            this.f200063n = true;
            this.f200064o = true;
            return;
        }
        if (this.f200059j <= 0 || this.f200060k <= 0) {
            this.f200052c = false;
            this.f200053d = false;
            this.f200054e = false;
            this.f200055f = false;
            this.f200056g = false;
            this.f200057h = false;
            this.f200058i = false;
            this.f200063n = false;
            this.f200064o = false;
            if (QLog.isColorLevel()) {
                QLog.d("DynamicAvatarConfig", 2, "maxPlayingCount or maxPlayCountOneDay <= 0");
            }
        }
        if (this.f200061l <= 0) {
            if (QLog.isColorLevel()) {
                QLog.d("DynamicAvatarConfig", 2, "adjust samllSizeFPS:" + this.f200061l);
            }
            this.f200061l = 18;
        }
        if (this.f200062m <= 0) {
            if (QLog.isColorLevel()) {
                QLog.d("DynamicAvatarConfig", 2, "adjust bigSizeFPS:" + this.f200062m);
            }
            this.f200062m = 18;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "dpcString:" + this.f200050a + ",isPlayInAll:" + this.f200052c + ",isPlayInMsgTab:" + this.f200053d + ",isPlayInContacts:" + this.f200054e + ",isPlayInNearList:" + this.f200055f + ",isPlayInFriendProfile:" + this.f200056g + ",isPlayInNearProfile:" + this.f200057h + ",isPlayInTroopProfile:" + this.f200058i + ",maxPlayingCount:" + this.f200059j + ",maxPlayCountOneDay:" + this.f200060k + ",bigSizeFPS:" + this.f200062m + ",smallSizeFPS:" + this.f200061l + ",isConvsPlayAfterKill:" + this.f200063n + ",isContactPlayAfterKill:" + this.f200064o + ",isUseDefault:" + this.f200051b;
    }
}
