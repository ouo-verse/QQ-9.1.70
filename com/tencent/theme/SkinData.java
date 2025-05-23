package com.tencent.theme;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public class SkinData {
    static IPatchRedirector $redirector_;
    public String mFileName;
    public String mFilePath;
    int mInDensity;
    public String mOriginalFileName;
    public int mOriginalResourcesId;
    public int mResourcesID;
    public int mTintColorResId;

    public SkinData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String toString() {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("mResourcesID:");
        sb5.append(this.mResourcesID);
        sb5.append(",mInDensity:");
        sb5.append(this.mInDensity);
        sb5.append(",mTintColorResId:");
        sb5.append(this.mTintColorResId);
        sb5.append(",mOriginalResourcesId:");
        sb5.append(this.mOriginalResourcesId);
        sb5.append(",mFilePath:");
        String str3 = "null";
        if (TextUtils.isEmpty(this.mFilePath)) {
            str = "null";
        } else {
            str = this.mFilePath;
        }
        sb5.append(str);
        sb5.append(",mFileName:");
        if (TextUtils.isEmpty(this.mFileName)) {
            str2 = "null";
        } else {
            str2 = this.mFileName;
        }
        sb5.append(str2);
        sb5.append(",mOriginalFileName:");
        if (!TextUtils.isEmpty(this.mOriginalFileName)) {
            str3 = this.mOriginalFileName;
        }
        sb5.append(str3);
        return sb5.toString();
    }
}
