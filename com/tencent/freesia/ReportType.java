package com.tencent.freesia;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class ReportType {
    private static final /* synthetic */ ReportType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final ReportType CHECK_RESOURCE_FAILED;
    public static final ReportType CONFIG_USED_COUNT;
    public static final ReportType DEFAULT;
    public static final ReportType DOWNLOAD_RESOURCE_FAILED;
    public static final ReportType OP_RESOURCE_IO_FAILED;
    public static final ReportType PARSE_FAILED;
    public static final ReportType UNZIP_RESOURCE_FAILED;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10358);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ReportType reportType = new ReportType("DEFAULT", 0);
        DEFAULT = reportType;
        ReportType reportType2 = new ReportType("PARSE_FAILED", 1);
        PARSE_FAILED = reportType2;
        ReportType reportType3 = new ReportType("DOWNLOAD_RESOURCE_FAILED", 2);
        DOWNLOAD_RESOURCE_FAILED = reportType3;
        ReportType reportType4 = new ReportType("UNZIP_RESOURCE_FAILED", 3);
        UNZIP_RESOURCE_FAILED = reportType4;
        ReportType reportType5 = new ReportType("CHECK_RESOURCE_FAILED", 4);
        CHECK_RESOURCE_FAILED = reportType5;
        ReportType reportType6 = new ReportType("OP_RESOURCE_IO_FAILED", 5);
        OP_RESOURCE_IO_FAILED = reportType6;
        ReportType reportType7 = new ReportType("CONFIG_USED_COUNT", 6);
        CONFIG_USED_COUNT = reportType7;
        $VALUES = new ReportType[]{reportType, reportType2, reportType3, reportType4, reportType5, reportType6, reportType7};
    }

    ReportType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static ReportType valueOf(String str) {
        return (ReportType) Enum.valueOf(ReportType.class, str);
    }

    public static ReportType[] values() {
        return (ReportType[]) $VALUES.clone();
    }
}
