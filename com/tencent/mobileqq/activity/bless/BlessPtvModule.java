package com.tencent.mobileqq.activity.bless;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;

@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "id")
/* loaded from: classes10.dex */
public class BlessPtvModule extends Entity {
    static IPatchRedirector $redirector_ = null;
    public static final String DEFAULT_MODULE_ID = "0";
    public static final String DEFAULT_MODULE_TITLE;
    public static final String DEFAULT_VIP_LEVEL = "0";
    public static String path;
    public int audioLength;
    public boolean broken;
    public String data;
    private String defaultM4aPath;
    public boolean downloaded;

    /* renamed from: id, reason: collision with root package name */
    @unique
    public String f180535id;
    public String shareTitle;
    public String title;
    public String vipLevel;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67757);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            DEFAULT_MODULE_TITLE = HardCodeUtil.qqStr(R.string.k2i);
        }
    }

    public BlessPtvModule(String str, String str2, String str3, String str4, int i3, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3, str4, Integer.valueOf(i3), str5);
            return;
        }
        this.downloaded = false;
        this.broken = false;
        this.title = str;
        this.data = str2;
        this.f180535id = str3;
        this.vipLevel = str4;
        this.audioLength = i3;
        this.shareTitle = str5;
    }

    public String getLrcPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(path);
        String str = File.separator;
        sb5.append(str);
        sb5.append(this.f180535id);
        sb5.append(str);
        sb5.append(this.f180535id);
        sb5.append(".qrc");
        return sb5.toString();
    }

    public String getM4aPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if ("0".equals(this.f180535id)) {
            return this.defaultM4aPath;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(path);
        String str = File.separator;
        sb5.append(str);
        sb5.append(this.f180535id);
        sb5.append(str);
        sb5.append(this.f180535id);
        sb5.append(".m4a");
        return sb5.toString();
    }

    public String getPicPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(path);
        String str = File.separator;
        sb5.append(str);
        sb5.append(this.f180535id);
        sb5.append(str);
        sb5.append(this.f180535id);
        sb5.append(".png");
        return sb5.toString();
    }

    public Drawable getPngDrawable(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Drawable) iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
        }
        if ("0".equals(this.f180535id)) {
            return activity.getResources().getDrawable(R.drawable.f160364ca3);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(path);
        String str = File.separator;
        sb5.append(str);
        sb5.append(this.f180535id);
        sb5.append(str);
        sb5.append(this.f180535id);
        sb5.append(".png");
        String sb6 = sb5.toString();
        try {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            int f16 = BaseAIOUtils.f(56.0f, activity.getResources());
            obtain.mRequestHeight = f16;
            obtain.mRequestWidth = f16;
            return URLDrawable.getDrawable(new File(sb6), obtain);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    public String getZipPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(path);
        String str = File.separator;
        sb5.append(str);
        sb5.append(this.f180535id);
        sb5.append(str);
        sb5.append(this.f180535id);
        sb5.append(".zip");
        return sb5.toString();
    }

    public boolean isComplete() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (this.f180535id == "0") {
            String str = this.defaultM4aPath;
            if (str != null && q.p(str)) {
                return true;
            }
        } else if (q.p(getLrcPath()) && q.p(getM4aPath()) && q.p(getPicPath())) {
            return true;
        }
        return false;
    }

    public void setDefaultModule(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.defaultM4aPath = str;
        }
    }

    public BlessPtvModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.downloaded = false;
            this.broken = false;
        }
    }
}
