package com.tencent.upload.network.route;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.network.route.IUploadRouteStrategy;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class UploadRoute implements Serializable {
    static IPatchRedirector $redirector_ = null;
    private static final long serialVersionUID = 100;
    private String mIp;
    private int mPort;
    private IUploadRouteStrategy.RouteCategoryType mRouteCategory;
    private int newStrategy;

    public UploadRoute(String str, int i3, IUploadRouteStrategy.RouteCategoryType routeCategoryType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), routeCategoryType);
            return;
        }
        this.newStrategy = 0;
        this.mIp = str;
        this.mPort = i3;
        this.mRouteCategory = routeCategoryType;
    }

    public String getIp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mIp;
    }

    public int getNewStrategy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.newStrategy;
    }

    public int getPort() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.mPort;
    }

    public IUploadRouteStrategy.RouteCategoryType getRouteCategory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (IUploadRouteStrategy.RouteCategoryType) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mRouteCategory;
    }

    public boolean isDuplicate(UploadRoute uploadRoute) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) uploadRoute)).booleanValue();
        }
        if (uploadRoute == null || !this.mIp.equals(uploadRoute.getIp()) || this.mPort != uploadRoute.getPort()) {
            return false;
        }
        return true;
    }

    public void setIp(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            this.mIp = str;
        }
    }

    public UploadRoute setNewStrategy(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (UploadRoute) iPatchRedirector.redirect((short) 10, (Object) this, i3);
        }
        this.newStrategy = i3;
        return this;
    }

    public void setPort(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.mPort = i3;
        }
    }

    public void setRouteCategory(IUploadRouteStrategy.RouteCategoryType routeCategoryType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) routeCategoryType);
        } else {
            this.mRouteCategory = routeCategoryType;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("(ip:");
        String str = this.mIp;
        String str2 = "null";
        if (str == null) {
            str = "null";
        }
        sb5.append(str);
        sb5.append(", port:");
        sb5.append(this.mPort);
        sb5.append(", ");
        IUploadRouteStrategy.RouteCategoryType routeCategoryType = this.mRouteCategory;
        if (routeCategoryType != null) {
            str2 = routeCategoryType.getDesc();
        }
        sb5.append(str2);
        sb5.append(", newStrategy:");
        sb5.append(this.newStrategy);
        sb5.append(")");
        return sb5.toString();
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public UploadRoute m286clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) ? new UploadRoute(this.mIp, this.mPort, this.mRouteCategory).setNewStrategy(this.newStrategy) : (UploadRoute) iPatchRedirector.redirect((short) 12, (Object) this);
    }
}
