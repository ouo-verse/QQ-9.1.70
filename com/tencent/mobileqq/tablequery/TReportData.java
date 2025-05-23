package com.tencent.mobileqq.tablequery;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TReportData implements Serializable {
    static IPatchRedirector $redirector_;
    public String actionName;
    public String mainAction;
    public int opType;

    /* renamed from: r2, reason: collision with root package name */
    public String f291343r2;

    /* renamed from: r3, reason: collision with root package name */
    public String f291344r3;

    /* renamed from: r4, reason: collision with root package name */
    public String f291345r4;

    /* renamed from: r5, reason: collision with root package name */
    public String f291346r5;
    public int result;
    public String subAction;
    public String table;

    public TReportData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public TReportData(String str, String str2, String str3, String str4, int i3, int i16, String str5, String str6, String str7, String str8) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, str3, str4, Integer.valueOf(i3), Integer.valueOf(i16), str5, str6, str7, str8);
            return;
        }
        this.table = str;
        this.mainAction = str2;
        this.subAction = str3;
        this.actionName = str4;
        this.opType = i3;
        this.result = i16;
        this.f291343r2 = str5;
        this.f291344r3 = str6;
        this.f291345r4 = str7;
        this.f291346r5 = str8;
    }
}
