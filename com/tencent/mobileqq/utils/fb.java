package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.vas.ReportInfo;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class fb {
    private static List<String> a(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            String c16 = com.tencent.msdk.dns.c.h().c(str);
            if (!TextUtils.isEmpty(c16)) {
                for (String str2 : c16.split(";")) {
                    if (!"0".equals(str2) && !TextUtils.isEmpty(str2)) {
                        arrayList.add(str2);
                    }
                }
            }
        } catch (Exception e16) {
            QLog.e("VasIpUtils", 1, "getIpList exception:" + e16.getMessage());
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x017d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(String str) {
        Throwable th5;
        boolean z16;
        ReportInfo value1;
        ReportInfo num1;
        long j3;
        ReportInfo num12;
        long j16;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z17 = false;
        long j17 = 2;
        try {
            try {
                InetAddress.getAllByName(str);
                VasCommonReporter.getDownLoader().setValue1("put_ip_to_cache").setNum1(0L).report();
            } catch (Exception unused) {
                List<String> a16 = a(str);
                if (a16.size() == 0) {
                    try {
                        try {
                            if (InetAddress.getAllByName(str).length > 0) {
                                z17 = true;
                            }
                            ReportInfo value12 = VasCommonReporter.getDownLoader().setValue1("put_ip_to_cache");
                            if (z17) {
                                j3 = 1;
                            } else {
                                j3 = 2;
                            }
                            num1 = value12.setNum1(j3);
                        } catch (Exception e16) {
                            QLog.e("VasIpUtils", 1, "putIpToAddress exception3:" + e16.getMessage());
                            num1 = VasCommonReporter.getDownLoader().setValue1("put_ip_to_cache").setNum1(2L);
                            num1.report();
                            return;
                        }
                        num1.report();
                        return;
                    } finally {
                    }
                }
                try {
                    Class<?> cls = Class.forName("java.net.Inet6AddressImpl");
                    Field declaredField = cls.getDeclaredField("addressCache");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(cls);
                    InetAddress[] inetAddressArr = new InetAddress[a16.size()];
                    for (int i3 = 0; i3 < a16.size(); i3++) {
                        try {
                            inetAddressArr[i3] = InetAddress.getByName(a16.get(i3));
                        } catch (UnknownHostException e17) {
                            QLog.e("VasIpUtils", 1, "putIpToAddress exception1:" + e17.getMessage());
                        }
                    }
                    Method declaredMethod = obj.getClass().getDeclaredMethod("put", String.class, Integer.TYPE, InetAddress[].class);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(obj, str, 0, inetAddressArr);
                } catch (Exception e18) {
                    QLog.e("VasIpUtils", 1, "putIpToAddress exception2:" + e18.getMessage());
                    try {
                        if (InetAddress.getAllByName(str).length > 0) {
                            z17 = true;
                        }
                        ReportInfo value13 = VasCommonReporter.getDownLoader().setValue1("put_ip_to_cache");
                        if (!z17) {
                            j16 = 1;
                        } else {
                            j16 = 2;
                        }
                        num12 = value13.setNum1(j16);
                    } catch (Exception e19) {
                        QLog.e("VasIpUtils", 1, "putIpToAddress exception3:" + e19.getMessage());
                        num12 = VasCommonReporter.getDownLoader().setValue1("put_ip_to_cache").setNum1(2L);
                        num12.report();
                    }
                    num12.report();
                }
                try {
                    if (InetAddress.getAllByName(str).length > 0) {
                    }
                    ReportInfo value132 = VasCommonReporter.getDownLoader().setValue1("put_ip_to_cache");
                    if (!z17) {
                    }
                    num12 = value132.setNum1(j16);
                    num12.report();
                } finally {
                }
            } catch (Throwable th6) {
                th5 = th6;
                z16 = false;
                if (!z16) {
                }
            }
        } catch (Throwable th7) {
            th5 = th7;
            z16 = true;
            if (!z16) {
                try {
                    try {
                        if (InetAddress.getAllByName(str).length > 0) {
                            z17 = true;
                        }
                        value1 = VasCommonReporter.getDownLoader().setValue1("put_ip_to_cache");
                        if (z17) {
                            j17 = 1;
                        }
                    } finally {
                    }
                } catch (Exception e26) {
                    QLog.e("VasIpUtils", 1, "putIpToAddress exception3:" + e26.getMessage());
                    value1 = VasCommonReporter.getDownLoader().setValue1("put_ip_to_cache");
                    value1.setNum1(j17).report();
                    throw th5;
                }
                value1.setNum1(j17).report();
                throw th5;
            }
            VasCommonReporter.getDownLoader().setValue1("put_ip_to_cache").setNum1(0L).report();
            throw th5;
        }
    }
}
