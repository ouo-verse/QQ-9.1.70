package i45;

import android.content.Context;
import android.text.TextUtils;
import android.util.Xml;
import com.hihonor.honorid.core.data.HonorAccount;
import com.hihonor.honorid.core.data.UserInfo;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.vas.ipc.VasLiveIPCModule;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import q.q.q.e.w.e;

/* compiled from: P */
/* loaded from: classes29.dex */
public class d implements a {
    private static ArrayList<HonorAccount> b(String str, Context context, boolean z16) {
        FileInputStream fileInputStream = null;
        try {
            try {
                File file = new File(context.getFilesDir().getCanonicalPath() + "/" + str);
                if (!file.exists()) {
                    e.c("XmlFileGrade", "xmlfilegradle sdk filepath not exist", true);
                    return new ArrayList<>();
                }
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    XmlPullParser newPullParser = Xml.newPullParser();
                    newPullParser.setInput(fileInputStream2, null);
                    ArrayList<HonorAccount> c16 = c(newPullParser, context, z16);
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused) {
                        e.b("XmlFileGrade", "IOException", true);
                    }
                    return c16;
                } catch (FileNotFoundException unused2) {
                    fileInputStream = fileInputStream2;
                    e.b("XmlFileGrade", "readAccountsFromXml FileNotFoundException", true);
                    ArrayList<HonorAccount> arrayList = new ArrayList<>();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused3) {
                            e.b("XmlFileGrade", "IOException", true);
                        }
                    }
                    return arrayList;
                } catch (IOException unused4) {
                    fileInputStream = fileInputStream2;
                    e.b("XmlFileGrade", "readAccountsFromXml IOException", true);
                    ArrayList<HonorAccount> arrayList2 = new ArrayList<>();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused5) {
                            e.b("XmlFileGrade", "IOException", true);
                        }
                    }
                    return arrayList2;
                } catch (RuntimeException unused6) {
                    fileInputStream = fileInputStream2;
                    e.b("XmlFileGrade", "readAccountsFromXml RuntimeException", true);
                    ArrayList<HonorAccount> arrayList3 = new ArrayList<>();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused7) {
                            e.b("XmlFileGrade", "IOException", true);
                        }
                    }
                    return arrayList3;
                } catch (XmlPullParserException unused8) {
                    fileInputStream = fileInputStream2;
                    e.b("XmlFileGrade", "XmlPullParserException readAccountsFromXmlfailed!", true);
                    ArrayList<HonorAccount> arrayList4 = new ArrayList<>();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused9) {
                            e.b("XmlFileGrade", "IOException", true);
                        }
                    }
                    return arrayList4;
                } catch (Exception unused10) {
                    fileInputStream = fileInputStream2;
                    e.b("XmlFileGrade", "readAccountsFromXml Exception", true);
                    ArrayList<HonorAccount> arrayList5 = new ArrayList<>();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused11) {
                            e.b("XmlFileGrade", "IOException", true);
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
                            e.b("XmlFileGrade", "IOException", true);
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

    private static ArrayList<HonorAccount> c(XmlPullParser xmlPullParser, Context context, boolean z16) {
        e.d("XmlFileGrade", "parseAccountsFromXml Start", true);
        int eventType = xmlPullParser.getEventType();
        ArrayList<HonorAccount> arrayList = new ArrayList<>();
        HonorAccount honorAccount = new HonorAccount();
        while (1 != eventType) {
            String name = xmlPullParser.getName();
            if (eventType != 0) {
                if (eventType != 2) {
                    if (eventType != 3) {
                        e.d("XmlFileGrade", "default", true);
                    } else if ("account".equals(name)) {
                        e.d("XmlFileGrade", "parseAccountsFromXml account add ", true);
                        if (!TextUtils.isEmpty(honorAccount.p())) {
                            arrayList.add(honorAccount);
                        } else {
                            e.c("XmlFileGrade", "Invalid account , not need add.", true);
                        }
                        honorAccount = new HonorAccount();
                    }
                } else if ("account".equals(name)) {
                    String attributeValue = xmlPullParser.getAttributeValue("", "appId");
                    if (TextUtils.isEmpty(attributeValue)) {
                        e.d("XmlFileGrade", "authTokenType is null", true);
                        attributeValue = j2.a.h(context);
                    }
                    honorAccount.I0(attributeValue);
                } else if (VasLiveIPCModule.KEY_GET_ACCOUNT_NICK_NAME.equals(name)) {
                    String nextText = xmlPullParser.nextText();
                    if (z16) {
                        nextText = i2.b.c(context, nextText);
                    }
                    honorAccount.r(nextText);
                } else {
                    e(xmlPullParser, context, z16, honorAccount, name);
                }
            }
            eventType = xmlPullParser.next();
        }
        return arrayList;
    }

    private void d(Context context) {
        if (j2.a.i(context)) {
            return;
        }
        ArrayList<HonorAccount> b16 = b("accounts.xml", context, true);
        h45.c.d(context, "accounts.xml");
        l2.b.e(context, "accounts.xml", b16, true);
    }

    private static void e(XmlPullParser xmlPullParser, Context context, boolean z16, HonorAccount honorAccount, String str) {
        if ("userId".equals(str)) {
            String nextText = xmlPullParser.nextText();
            if (z16) {
                nextText = i2.b.c(context, nextText);
            }
            honorAccount.P0(nextText);
            return;
        }
        if (Constants.SP_DEVICE_ID.equals(str)) {
            String nextText2 = xmlPullParser.nextText();
            if (z16) {
                nextText2 = i2.b.c(context, nextText2);
            }
            honorAccount.D(nextText2);
            return;
        }
        if ("subDeviceId".equals(str)) {
            String nextText3 = xmlPullParser.nextText();
            if (z16) {
                nextText3 = i2.b.c(context, nextText3);
            }
            honorAccount.C0(nextText3);
            return;
        }
        if ("deviceType".equals(str)) {
            honorAccount.G(xmlPullParser.nextText());
            return;
        }
        if ("serviceToken".equals(str)) {
            honorAccount.F0(i2.b.c(context, xmlPullParser.nextText()));
            return;
        }
        if ("siteId".equals(str)) {
            try {
                honorAccount.n(Integer.parseInt(xmlPullParser.nextText()));
                return;
            } catch (NumberFormatException unused) {
                e.e("XmlFileGrade", "NumberFormatException: read accounts.xml parseInt error", true);
                return;
            } catch (Exception unused2) {
                e.e("XmlFileGrade", "read accounts.xml parseInt error", true);
                return;
            }
        }
        if ("accountType".equals(str)) {
            honorAccount.u(xmlPullParser.nextText());
        } else {
            g(xmlPullParser, context, z16, honorAccount, str);
        }
    }

    private void f(Context context) {
        e.c("XmlFileGrade", "update HnAccounts.xml when version update", true);
        k45.a b16 = k45.a.b(context);
        b16.c("last_head_picture_url");
        e.c("XmlFileGrade", "delete last_head_picture_url in HonorAccount.xml", true);
        b16.c("DEVID_1");
        e.c("XmlFileGrade", "delete DEVID in HonorAccount.xml", true);
        b16.c("SUBDEVID");
        e.c("XmlFileGrade", "delete SUBDEVID in HonorAccount.xml", true);
        b16.c("hasEncryptHeadPictureUrl");
        e.c("XmlFileGrade", "delete hasEncryptHeadPictureUrl in HonorAccount.xml", true);
        String a16 = b16.a(CommonConstant.KEY_ACCESS_TOKEN, "");
        if (!TextUtils.isEmpty(a16)) {
            String c16 = i2.b.c(context, a16);
            if (!TextUtils.isEmpty(c16)) {
                e.c("XmlFileGrade", "update accessToken in HonorAccount.xml", true);
                b16.d(CommonConstant.KEY_ACCESS_TOKEN, c16);
            } else {
                b16.c(CommonConstant.KEY_ACCESS_TOKEN);
                e.c("XmlFileGrade", "accessToken ecb decrypt error", true);
            }
        }
        String a17 = b16.a("UUID", "");
        if (!TextUtils.isEmpty(a17)) {
            e.c("XmlFileGrade", "update uuid in HonorAccount.xml", true);
            b16.d("UUID", a17);
        } else {
            b16.c("UUID");
            e.c("XmlFileGrade", "uuid ecb decrypt error", true);
        }
    }

    private static void g(XmlPullParser xmlPullParser, Context context, boolean z16, HonorAccount honorAccount, String str) {
        if (UserInfo.LOGIN_USER_NAME.equals(str)) {
            honorAccount.h0(i2.b.c(context, xmlPullParser.nextText()));
        } else if ("countryIsoCode".equals(str)) {
            honorAccount.b0(i2.b.c(context, xmlPullParser.nextText()));
        }
    }

    @Override // i45.a
    public void a(Context context, int i3, int i16) {
        if (i3 >= i16) {
            e.b("XmlFileGrade", "newVersion is less then oldVersion, onUpgrade error", true);
        } else {
            f(context);
            d(context);
        }
    }
}
