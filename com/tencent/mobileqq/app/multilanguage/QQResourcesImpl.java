package com.tencent.mobileqq.app.multilanguage;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QQResourcesImpl {
    static IPatchRedirector $redirector_;
    private Resources mDefaultResource;
    private String mLangPackageName;
    private Resources mMultiLangResource;

    public QQResourcesImpl(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.mDefaultResource = context.getResources();
        }
    }

    public Resources getDefaultResource() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Resources) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mDefaultResource;
    }

    public int getMultiLangResid(int i3) {
        String resourceEntryName;
        int identifier;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, i3)).intValue();
        }
        Resources resources = this.mDefaultResource;
        if (resources == null || this.mMultiLangResource == null || (identifier = this.mMultiLangResource.getIdentifier((resourceEntryName = resources.getResourceEntryName(i3)), this.mDefaultResource.getResourceTypeName(i3), this.mLangPackageName)) <= 0) {
            return 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d(MultiLanguageEngine.TAG, 2, "resourceName:", resourceEntryName, " ,lanResID:", Integer.valueOf(identifier), " ,oldId:", Integer.valueOf(i3));
        }
        return identifier;
    }

    public Resources getMultiLangResource() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Resources) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Resources resources = this.mMultiLangResource;
        if (resources == null) {
            return this.mDefaultResource;
        }
        return resources;
    }

    public int mapMultiLangResid(int i3) {
        String resourceEntryName;
        int identifier;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, i3)).intValue();
        }
        Resources resources = this.mDefaultResource;
        if (resources != null && this.mMultiLangResource != null && (identifier = this.mMultiLangResource.getIdentifier((resourceEntryName = resources.getResourceEntryName(i3)), this.mDefaultResource.getResourceTypeName(i3), this.mLangPackageName)) > 0) {
            if (QLog.isColorLevel()) {
                QLog.d(MultiLanguageEngine.TAG, 2, "resourceName:", resourceEntryName, " ,lanResID:", Integer.valueOf(identifier), " ,oldId:", Integer.valueOf(i3));
            }
            return identifier;
        }
        return i3;
    }

    public void setMultiLangResource(Resources resources, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) resources, (Object) str);
        } else {
            this.mMultiLangResource = resources;
            this.mLangPackageName = str;
        }
    }
}
