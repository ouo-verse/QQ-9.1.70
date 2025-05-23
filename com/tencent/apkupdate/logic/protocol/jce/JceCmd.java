package com.tencent.apkupdate.logic.protocol.jce;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class JceCmd implements Serializable {
    public static final /* synthetic */ boolean $assertionsDisabled;
    static IPatchRedirector $redirector_ = null;
    public static final JceCmd Empty;
    public static final JceCmd GetAppUpdate;
    public static final JceCmd GetSettings;
    public static final JceCmd ReportApkFileInfo;
    public static final JceCmd ReportLog;
    public static final int _Empty = 0;
    public static final int _GetAppUpdate = 3;
    public static final int _GetSettings = 2;
    public static final int _ReportApkFileInfo = 4;
    public static final int _ReportLog = 1;
    private static JceCmd[] __values;
    private String __T;
    private int __value;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7837);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        $assertionsDisabled = true;
        __values = new JceCmd[5];
        Empty = new JceCmd(0, 0, "Empty");
        ReportLog = new JceCmd(1, 1, "ReportLog");
        GetSettings = new JceCmd(2, 2, "GetSettings");
        GetAppUpdate = new JceCmd(3, 3, "GetAppUpdate");
        ReportApkFileInfo = new JceCmd(4, 4, "ReportApkFileInfo");
    }

    JceCmd(int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
            return;
        }
        new String();
        this.__T = str;
        this.__value = i16;
        __values[i3] = this;
    }

    public static JceCmd convert(String str) {
        int i3 = 0;
        while (true) {
            JceCmd[] jceCmdArr = __values;
            if (i3 < jceCmdArr.length) {
                if (jceCmdArr[i3].toString().equals(str)) {
                    return __values[i3];
                }
                i3++;
            } else {
                if ($assertionsDisabled) {
                    return null;
                }
                throw new AssertionError();
            }
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.__T;
    }

    public int value() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.__value;
    }
}
