package com.tencent.mobileqq.identification;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class AppConf implements Serializable {
    static IPatchRedirector $redirector_;
    public int[] actionReq;

    /* renamed from: al, reason: collision with root package name */
    public final List<AppWordings> f237888al;
    public final String appName;
    public String colorSequence;
    public String debug;
    public String errMsg;
    public String huiyanSdkToken;
    public final int mode;
    public int ret;
    public String selectData;
    public final List<ServiceProtocolSerializable> serviceProtocols;
    public String session;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class AppWordings implements Serializable {
        static IPatchRedirector $redirector_;
        public final int serviceType;
        public final String text;

        public AppWordings(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) str);
            } else {
                this.serviceType = i3;
                this.text = str;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class ServiceProtocolSerializable implements Serializable {
        static IPatchRedirector $redirector_;
        public final String name;
        public final String url;
        public final String wording;

        public ServiceProtocolSerializable(String str, String str2, String str3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, str3);
                return;
            }
            this.name = str;
            this.url = str2;
            this.wording = str3;
        }
    }

    public AppConf(String str, List<AppWordings> list, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, list, Integer.valueOf(i3));
            return;
        }
        this.appName = str;
        ArrayList arrayList = new ArrayList(3);
        this.f237888al = arrayList;
        arrayList.addAll(list);
        this.mode = i3;
        this.serviceProtocols = new ArrayList(3);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "appName=" + this.appName + " mode=" + this.mode + " colorSe=" + this.colorSequence + " session=" + this.session + " ret=" + this.ret + " errMsg=" + this.errMsg + " debug=" + this.debug + " selectData=" + this.selectData + " huiyanSdkToken=" + this.huiyanSdkToken;
    }
}
