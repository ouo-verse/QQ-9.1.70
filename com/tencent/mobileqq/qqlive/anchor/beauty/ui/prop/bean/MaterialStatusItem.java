package com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes17.dex */
public class MaterialStatusItem {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f270488a;

    /* renamed from: b, reason: collision with root package name */
    public String f270489b;

    /* renamed from: c, reason: collision with root package name */
    boolean f270490c;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes17.dex */
    @interface ResDownloadStatus {
    }

    public MaterialStatusItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f270488a = 0;
            this.f270490c = false;
        }
    }

    @NonNull
    public Object clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this);
        }
        MaterialStatusItem materialStatusItem = new MaterialStatusItem();
        materialStatusItem.f270488a = this.f270488a;
        materialStatusItem.f270490c = this.f270490c;
        return materialStatusItem;
    }

    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        StringBuffer stringBuffer = new StringBuffer("MaterialStatusItem = [");
        stringBuffer.append("downloadStatus = ");
        stringBuffer.append(this.f270488a);
        stringBuffer.append(",");
        stringBuffer.append("isSelected = ");
        stringBuffer.append(this.f270490c);
        stringBuffer.append(",");
        stringBuffer.append("resLocalPath = ");
        stringBuffer.append(this.f270489b);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
