package com.tencent.mobileqq.microapp.apkg;

import android.text.TextUtils;
import com.tencent.mobileqq.microapp.sdk.LaunchParam;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes15.dex */
public class AppInfo extends Entity implements Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final int TYPE_APP = 2;
    public static final int TYPE_GAME = 1;
    public static final int TYPE_QZONE_GAME = 3;
    public String iconUrl;

    /* renamed from: id, reason: collision with root package name */
    @unique
    public String f245836id;
    public String launchUrl;
    public String name;
    public long timestamp;
    public int type;

    public AppInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public boolean isCollectionPage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (this.type == 2 && LaunchParam.isCollectionPage(this.f245836id)) {
            return true;
        }
        return false;
    }

    public boolean isValid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        int i3 = this.type;
        if (i3 == 1) {
            if (!TextUtils.isEmpty(this.f245836id)) {
                return true;
            }
            return false;
        }
        if (i3 == 2) {
            if (!TextUtils.isEmpty(this.f245836id) && !TextUtils.isEmpty(this.name) && isValidUrl(this.iconUrl)) {
                return true;
            }
            return false;
        }
        if (i3 == 3 && !TextUtils.isEmpty(this.f245836id)) {
            return true;
        }
        return false;
    }

    public boolean isValidUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str)).booleanValue();
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                new URL(str);
                return true;
            } catch (MalformedURLException unused) {
                return false;
            }
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "{id:" + this.f245836id + ",name:" + this.name + "}";
    }

    public void updateTimeStamp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.timestamp = NetConnInfoCenter.getServerTimeMillis();
        }
    }

    public AppInfo(int i3, String str, String str2, String str3) {
        this(i3, str, str2, str3, 0L);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, str2, str3);
    }

    public AppInfo(int i3, String str, String str2, String str3, long j3) {
        this(i3, str, str2, str3, j3, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, str2, str3, Long.valueOf(j3));
    }

    public AppInfo(int i3, String str, String str2, String str3, long j3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), str, str2, str3, Long.valueOf(j3), str4);
            return;
        }
        this.type = i3;
        this.f245836id = str;
        this.iconUrl = str2;
        this.name = str3;
        this.timestamp = j3;
        this.launchUrl = str4;
    }
}
