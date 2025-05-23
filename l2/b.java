package l2;

import android.content.Context;
import android.text.TextUtils;
import android.util.Xml;
import com.hihonor.honorid.core.data.HonorAccount;
import com.hihonor.honorid.core.data.UserInfo;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.vas.ipc.VasLiveIPCModule;
import h45.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;
import q.q.q.e.w.e;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b {
    public static ArrayList<HonorAccount> a(String str, Context context, boolean z16) {
        FileInputStream fileInputStream = null;
        try {
            try {
                File file = new File(context.getFilesDir().getCanonicalPath() + "/" + str);
                if (!file.exists()) {
                    e.c("SDKAccountXmlImpl", " sdk filepath not exist", true);
                    return new ArrayList<>();
                }
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    XmlPullParser newPullParser = Xml.newPullParser();
                    newPullParser.setInput(fileInputStream2, null);
                    ArrayList<HonorAccount> b16 = b(newPullParser, context, z16);
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused) {
                        e.b("SDKAccountXmlImpl", "IOException  ", true);
                    }
                    return b16;
                } catch (FileNotFoundException unused2) {
                    fileInputStream = fileInputStream2;
                    e.b("SDKAccountXmlImpl", "FileNotFoundException read xml failed!", true);
                    ArrayList<HonorAccount> arrayList = new ArrayList<>();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused3) {
                            e.b("SDKAccountXmlImpl", "IOException  ", true);
                        }
                    }
                    return arrayList;
                } catch (IOException unused4) {
                    fileInputStream = fileInputStream2;
                    e.b("SDKAccountXmlImpl", "IOException read xml failed!", true);
                    ArrayList<HonorAccount> arrayList2 = new ArrayList<>();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused5) {
                            e.b("SDKAccountXmlImpl", "IOException  ", true);
                        }
                    }
                    return arrayList2;
                } catch (RuntimeException unused6) {
                    fileInputStream = fileInputStream2;
                    e.b("SDKAccountXmlImpl", "RuntimeException read xml failed!", true);
                    ArrayList<HonorAccount> arrayList3 = new ArrayList<>();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused7) {
                            e.b("SDKAccountXmlImpl", "IOException  ", true);
                        }
                    }
                    return arrayList3;
                } catch (XmlPullParserException unused8) {
                    fileInputStream = fileInputStream2;
                    e.b("SDKAccountXmlImpl", "XmlPullParserException read xml failed!", true);
                    ArrayList<HonorAccount> arrayList4 = new ArrayList<>();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused9) {
                            e.b("SDKAccountXmlImpl", "IOException  ", true);
                        }
                    }
                    return arrayList4;
                } catch (Exception unused10) {
                    fileInputStream = fileInputStream2;
                    e.b("SDKAccountXmlImpl", "Exception read xml failed!", true);
                    ArrayList<HonorAccount> arrayList5 = new ArrayList<>();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused11) {
                            e.b("SDKAccountXmlImpl", "IOException  ", true);
                        }
                    }
                    return arrayList5;
                } catch (Throwable th5) {
                    fileInputStream = fileInputStream2;
                    th = th5;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused12) {
                            e.b("SDKAccountXmlImpl", "IOException  ", true);
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused13) {
            } catch (IOException unused14) {
            } catch (RuntimeException unused15) {
            } catch (XmlPullParserException unused16) {
            } catch (Exception unused17) {
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private static ArrayList<HonorAccount> b(XmlPullParser xmlPullParser, Context context, boolean z16) {
        e.c("SDKAccountXmlImpl", "sdkaccount xml parseAccountsFromXml Start", true);
        int eventType = xmlPullParser.getEventType();
        ArrayList<HonorAccount> arrayList = new ArrayList<>();
        HonorAccount honorAccount = new HonorAccount();
        while (1 != eventType) {
            String name = xmlPullParser.getName();
            if (eventType != 2) {
                if (eventType == 3 && "account".equals(name)) {
                    e.c("SDKAccountXmlImpl", "parseAccountsFromXml add account:", true);
                    arrayList.add(honorAccount);
                    honorAccount = new HonorAccount();
                }
            } else if ("account".equals(name)) {
                String attributeValue = xmlPullParser.getAttributeValue("", "appId");
                if (TextUtils.isEmpty(attributeValue)) {
                    e.d("SDKAccountXmlImpl", "sdk authTokenType is null", true);
                    attributeValue = j2.a.h(context);
                }
                honorAccount.I0(attributeValue);
            } else if (VasLiveIPCModule.KEY_GET_ACCOUNT_NICK_NAME.equals(name)) {
                String nextText = xmlPullParser.nextText();
                if (z16) {
                    nextText = i2.b.a(context, nextText);
                }
                honorAccount.r(nextText);
            } else if ("userId".equals(name)) {
                String nextText2 = xmlPullParser.nextText();
                if (z16) {
                    nextText2 = i2.b.a(context, nextText2);
                }
                honorAccount.P0(nextText2);
            } else {
                f(xmlPullParser, context, z16, honorAccount, name);
            }
            eventType = xmlPullParser.next();
        }
        return arrayList;
    }

    private static List<HonorAccount> c(List<HonorAccount> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (HonorAccount honorAccount : list) {
                if (!j2.a.d(honorAccount)) {
                    arrayList.add(honorAccount);
                }
            }
            try {
                if (!arrayList.isEmpty() && list.containsAll(arrayList)) {
                    list.removeAll(arrayList);
                }
            } catch (Exception unused) {
                e.b("SDKAccountXmlImpl", "Exception", true);
            }
            return list;
        }
        return null;
    }

    private static void d(Context context, HonorAccount honorAccount, boolean z16, XmlSerializer xmlSerializer) {
        int u06 = honorAccount.u0();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(u06);
        String str = "";
        sb5.append("");
        c.c(xmlSerializer, "siteId", sb5.toString());
        String s16 = honorAccount.s();
        if (s16 == null) {
            s16 = "";
        }
        c.c(xmlSerializer, "accountType", s16);
        String o06 = honorAccount.o0();
        if (z16) {
            o06 = i2.b.b(context, o06);
        }
        if (o06 == null) {
            o06 = "";
        }
        c.c(xmlSerializer, CommonConstant.KEY_SERVICE_COUNTRY_CODE, o06);
        String G0 = honorAccount.G0();
        if (z16) {
            G0 = i2.b.b(context, G0);
        }
        if (G0 == null) {
            G0 = "";
        }
        c.c(xmlSerializer, "uuid", G0);
        String c16 = honorAccount.c();
        if (!TextUtils.isEmpty(c16)) {
            c16 = i2.b.b(context, c16);
        }
        if (TextUtils.isEmpty(c16)) {
            c16 = "";
        }
        c.c(xmlSerializer, "as_server_domain", c16);
        String v3 = honorAccount.v();
        if (!TextUtils.isEmpty(v3)) {
            v3 = i2.b.b(context, v3);
        }
        if (TextUtils.isEmpty(v3)) {
            v3 = "";
        }
        c.c(xmlSerializer, "cas_server_domain", v3);
        String r06 = honorAccount.r0();
        if (!TextUtils.isEmpty(r06)) {
            r06 = i2.b.b(context, r06);
        }
        if (TextUtils.isEmpty(r06)) {
            r06 = "";
        }
        c.c(xmlSerializer, "siteDomain", r06);
        c.c(xmlSerializer, CommonConstant.KEY_HOME_ZONE, i2.b.b(context, honorAccount.E() + "") + "");
        String c06 = honorAccount.c0();
        if (!TextUtils.isEmpty(c06)) {
            str = c06;
        }
        c.c(xmlSerializer, WadlProxyConsts.LAST_UPDATE_TIME, str);
    }

    public static void e(Context context, String str, List<HonorAccount> list, boolean z16) {
        List<HonorAccount> c16 = c(list);
        if (c16 != null && !c16.isEmpty() && list != null && !list.isEmpty()) {
            XmlSerializer newSerializer = Xml.newSerializer();
            StringWriter stringWriter = new StringWriter();
            try {
                try {
                    try {
                        try {
                            try {
                                newSerializer.setOutput(stringWriter);
                                newSerializer.startDocument("UTF-8", Boolean.TRUE);
                                newSerializer.startTag("", "accounts");
                                newSerializer.attribute("", "size", list.size() + "");
                                Iterator<HonorAccount> it = list.iterator();
                                while (it.hasNext()) {
                                    g(context, it.next(), z16, newSerializer);
                                }
                                newSerializer.endTag("", "accounts");
                                newSerializer.endDocument();
                                boolean f16 = c.f(context.getFilesDir().getCanonicalPath() + "/", str, j2.a.e(stringWriter.toString()));
                                e.c("SDKAccountXmlImpl", "write accounts into file :" + f16, true);
                                if (z16 && f16) {
                                    c.i(context, String.valueOf(3));
                                }
                                stringWriter.close();
                            } catch (IllegalStateException unused) {
                                e.b("SDKAccountXmlImpl", "IllegalStateException write accounts failed!", true);
                                stringWriter.close();
                            } catch (Exception unused2) {
                                e.b("SDKAccountXmlImpl", "Exception write accounts failed!", true);
                                stringWriter.close();
                            }
                        } catch (IllegalArgumentException unused3) {
                            e.b("SDKAccountXmlImpl", "IllegalArgumentException write accounts failed!", true);
                            stringWriter.close();
                        } catch (RuntimeException unused4) {
                            e.b("SDKAccountXmlImpl", "RuntimeException write accounts failed!", true);
                            stringWriter.close();
                        }
                    } catch (IOException unused5) {
                        e.b("SDKAccountXmlImpl", "IOException write accounts failed!", true);
                        stringWriter.close();
                    }
                    return;
                } catch (Throwable th5) {
                    try {
                        stringWriter.close();
                    } catch (IOException unused6) {
                        e.b("SDKAccountXmlImpl", "IOException ", true);
                    }
                    throw th5;
                }
            } catch (IOException unused7) {
                e.b("SDKAccountXmlImpl", "IOException ", true);
                return;
            }
        }
        e.c("SDKAccountXmlImpl", "write accounts into file error", true);
    }

    private static void f(XmlPullParser xmlPullParser, Context context, boolean z16, HonorAccount honorAccount, String str) {
        if (Constants.SP_DEVICE_ID.equals(str)) {
            String nextText = xmlPullParser.nextText();
            if (z16) {
                nextText = i2.b.a(context, nextText);
            }
            honorAccount.D(nextText);
            return;
        }
        if ("subDeviceId".equals(str)) {
            String nextText2 = xmlPullParser.nextText();
            if (z16) {
                nextText2 = i2.b.a(context, nextText2);
            }
            honorAccount.C0(nextText2);
            return;
        }
        if ("deviceType".equals(str)) {
            honorAccount.G(xmlPullParser.nextText());
            return;
        }
        if ("serviceToken".equals(str)) {
            honorAccount.F0(i2.b.a(context, xmlPullParser.nextText()));
            return;
        }
        if ("siteId".equals(str)) {
            try {
                honorAccount.n(Integer.parseInt(xmlPullParser.nextText()));
                return;
            } catch (NumberFormatException unused) {
                e.e("SDKAccountXmlImpl", "NumberFormatException: read accounts.xml parseInt error", true);
                return;
            } catch (Exception unused2) {
                e.e("SDKAccountXmlImpl", "sdk read accounts.xml parseInt error", true);
                return;
            }
        }
        if ("accountType".equals(str)) {
            honorAccount.u(xmlPullParser.nextText());
        } else {
            h(xmlPullParser, context, z16, honorAccount, str);
        }
    }

    private static void g(Context context, HonorAccount honorAccount, boolean z16, XmlSerializer xmlSerializer) {
        e.c("SDKAccountXmlImpl", "SDKAccountXmlImpl start.", true);
        if (honorAccount == null) {
            e.b("SDKAccountXmlImpl", "account is null.", true);
            return;
        }
        xmlSerializer.startTag("", "account");
        xmlSerializer.attribute("", "appId", honorAccount.D0());
        String p16 = honorAccount.p();
        if (z16) {
            p16 = i2.b.b(context, p16);
        }
        c.c(xmlSerializer, VasLiveIPCModule.KEY_GET_ACCOUNT_NICK_NAME, p16);
        String M0 = honorAccount.M0();
        if (z16) {
            M0 = i2.b.b(context, M0);
        }
        c.c(xmlSerializer, "userId", M0);
        String y16 = honorAccount.y();
        if (z16) {
            y16 = i2.b.b(context, y16);
        }
        if (y16 == null) {
            y16 = "";
        }
        c.c(xmlSerializer, Constants.SP_DEVICE_ID, y16);
        String x06 = honorAccount.x0();
        if (z16) {
            x06 = i2.b.b(context, x06);
        }
        if (x06 == null) {
            x06 = "";
        }
        c.c(xmlSerializer, "subDeviceId", x06);
        String B = honorAccount.B();
        if (B == null) {
            B = "";
        }
        c.c(xmlSerializer, "deviceType", B);
        c.c(xmlSerializer, "serviceToken", i2.b.b(context, honorAccount.A0()));
        c.c(xmlSerializer, UserInfo.LOGIN_USER_NAME, i2.b.b(context, honorAccount.f0()));
        c.c(xmlSerializer, "countryIsoCode", i2.b.b(context, honorAccount.Z()));
        d(context, honorAccount, z16, xmlSerializer);
        xmlSerializer.endTag("", "account");
    }

    private static void h(XmlPullParser xmlPullParser, Context context, boolean z16, HonorAccount honorAccount, String str) {
        if (UserInfo.LOGIN_USER_NAME.equals(str)) {
            String nextText = xmlPullParser.nextText();
            if (z16) {
                nextText = i2.b.a(context, nextText);
            }
            honorAccount.h0(nextText);
            return;
        }
        if ("countryIsoCode".equals(str)) {
            String nextText2 = xmlPullParser.nextText();
            if (z16) {
                nextText2 = i2.b.a(context, nextText2);
            }
            honorAccount.b0(nextText2);
            return;
        }
        if (CommonConstant.KEY_SERVICE_COUNTRY_CODE.equals(str)) {
            String nextText3 = xmlPullParser.nextText();
            if (z16) {
                nextText3 = i2.b.a(context, nextText3);
            }
            honorAccount.w0(nextText3);
            return;
        }
        if ("uuid".equals(str)) {
            String nextText4 = xmlPullParser.nextText();
            if (z16) {
                nextText4 = i2.b.a(context, nextText4);
            }
            honorAccount.L0(nextText4);
            return;
        }
        String str2 = "";
        if ("as_server_domain".equals(str)) {
            String a16 = i2.b.a(context, xmlPullParser.nextText());
            if (j2.a.g(a16)) {
                str2 = a16;
            }
            honorAccount.g(str2);
            return;
        }
        if ("cas_server_domain".equals(str)) {
            String a17 = i2.b.a(context, xmlPullParser.nextText());
            if (j2.a.g(a17)) {
                str2 = a17;
            }
            honorAccount.x(str2);
            return;
        }
        i(xmlPullParser, context, z16, honorAccount, str);
    }

    private static void i(XmlPullParser xmlPullParser, Context context, boolean z16, HonorAccount honorAccount, String str) {
        if ("siteDomain".equals(str)) {
            String a16 = i2.b.a(context, xmlPullParser.nextText());
            if (!j2.a.g(a16)) {
                a16 = "";
            }
            honorAccount.z0(a16);
            return;
        }
        if (CommonConstant.KEY_HOME_ZONE.equals(str)) {
            try {
                honorAccount.f(Integer.parseInt(i2.b.a(context, xmlPullParser.nextText())));
            } catch (NumberFormatException unused) {
                e.e("SDKAccountXmlImpl", "NumberFormatException: read accounts.xml parseInt error", true);
            } catch (Exception unused2) {
                e.e("SDKAccountXmlImpl", "sdk read accounts.xml parseInt error", true);
            }
        }
    }
}
