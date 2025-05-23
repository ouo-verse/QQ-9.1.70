package com.tencent.ams.adcore.mma.util;

import android.util.Xml;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.ams.adcore.mma.bean.Argument;
import com.tencent.ams.adcore.mma.bean.Company;
import com.tencent.ams.adcore.mma.bean.Config;
import com.tencent.ams.adcore.mma.bean.Domain;
import com.tencent.ams.adcore.mma.bean.Event;
import com.tencent.ams.adcore.mma.bean.OfflineCache;
import com.tencent.ams.adcore.mma.bean.SDK;
import com.tencent.ams.adcore.mma.bean.Signature;
import com.tencent.ams.adcore.mma.bean.Switch;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: P */
/* loaded from: classes3.dex */
public class XmlUtil {
    static IPatchRedirector $redirector_;

    public XmlUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void closeSafe(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    private static void dealArgumentInfo(Argument argument, String str, XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        if (argument != null) {
            if ("key".equals(str)) {
                argument.key = xmlPullParser.nextText();
            }
            if ("value".equals(str)) {
                argument.value = xmlPullParser.nextText();
            }
            if ("urlEncode".equals(str)) {
                argument.urlEncode = Boolean.parseBoolean(xmlPullParser.nextText());
            }
            if ("isRequired".equals(str)) {
                argument.isRequired = Boolean.parseBoolean(xmlPullParser.nextText());
            }
        }
    }

    private static void dealEventInfo(Event event, String str, XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        if (event != null) {
            if ("key".equals(str)) {
                event.key = xmlPullParser.nextText();
            }
            if ("value".equals(str)) {
                event.value = xmlPullParser.nextText();
            }
            if ("urlEncode".equals(str)) {
                event.urlEncode = Boolean.parseBoolean(xmlPullParser.nextText());
            }
        }
    }

    private static void dealOfflineCacheInfo(SDK sdk, String str, XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        if (sdk.offlineCache != null) {
            if ("length".equals(str)) {
                sdk.offlineCache.length = xmlPullParser.nextText();
            }
            if ("queueExpirationSecs".equals(str)) {
                sdk.offlineCache.queueExpirationSecs = xmlPullParser.nextText();
            }
            if ("timeout".equals(str)) {
                sdk.offlineCache.timeout = xmlPullParser.nextText();
            }
        }
    }

    public static SDK doParser(InputStream inputStream) {
        SDK sdk;
        Throwable th5;
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(inputStream, "UTF-8");
            sdk = null;
            Company company = null;
            Argument argument = null;
            Event event = null;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType != 0) {
                    if (eventType != 2) {
                        if (eventType != 3) {
                            continue;
                        } else {
                            try {
                                String name = newPullParser.getName();
                                if (IProfileProtocolConst.KEY_COMPANY.equals(name)) {
                                    sdk.companies.add(company);
                                    company = null;
                                } else if ("argument".equals(name)) {
                                    company.config.arguments.add(argument);
                                    argument = null;
                                } else if ("event".equals(name)) {
                                    company.config.events.add(event);
                                    event = null;
                                }
                            } catch (Throwable th6) {
                                th5 = th6;
                                try {
                                    th5.printStackTrace();
                                    return sdk;
                                } finally {
                                    closeSafe(inputStream);
                                }
                            }
                        }
                    } else if (sdk != null) {
                        String name2 = newPullParser.getName();
                        if ("offlineCache".equals(name2)) {
                            sdk.offlineCache = new OfflineCache();
                        }
                        dealOfflineCacheInfo(sdk, name2, newPullParser);
                        if ("companies".equals(name2)) {
                            sdk.companies = new ArrayList();
                        }
                        if (sdk.companies != null && IProfileProtocolConst.KEY_COMPANY.equals(name2)) {
                            company = new Company();
                        }
                        if (company != null) {
                            if ("name".equals(name2) && company.name == null) {
                                company.name = newPullParser.nextText();
                            }
                            if (TagName.ENCRYPT_TYPE.equals(name2)) {
                                String nextText = newPullParser.nextText();
                                if (isNumeric(nextText)) {
                                    company.encryptType = Integer.parseInt(nextText);
                                }
                            }
                            if ("domain".equals(name2)) {
                                company.domain = new Domain();
                            }
                            if (company.domain != null && "url".equals(name2)) {
                                company.domain.url = newPullParser.nextText();
                            }
                            if ("signature".equals(name2)) {
                                company.signature = new Signature();
                            }
                            if (company.signature != null) {
                                if ("publicKey".equals(name2)) {
                                    company.signature.publicKey = newPullParser.nextText();
                                }
                                if ("paramKey".equals(name2)) {
                                    company.signature.paramKey = newPullParser.nextText();
                                }
                            }
                            if (TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH.equals(name2)) {
                                company.sswitch = new Switch();
                            }
                            if (company.sswitch != null) {
                                if ("isTrackLocation".equals(name2)) {
                                    company.sswitch.isTrackLocation = Boolean.parseBoolean(newPullParser.nextText());
                                }
                                if ("offlineCacheExpiration".equals(name2)) {
                                    company.sswitch.offlineCacheExpiration = newPullParser.nextText();
                                }
                                if ("encrypt".equals(name2)) {
                                    company.sswitch.encrypt = new HashMap();
                                }
                                if (company.sswitch.encrypt != null && (Global.TRACKING_MAC.equals(name2) || "IDA".equals(name2) || Global.TRACKING_IMEI.equals(name2) || "ANDROID".equals(name2))) {
                                    company.sswitch.encrypt.put(name2, newPullParser.nextText());
                                }
                            }
                            if (DownloadInfo.spKey_Config.equals(name2)) {
                                company.config = new Config();
                            }
                            if (company.config != null) {
                                if ("arguments".equals(name2)) {
                                    company.config.arguments = new ArrayList();
                                }
                                if (company.config.arguments != null && "argument".equals(name2)) {
                                    argument = new Argument();
                                }
                                dealArgumentInfo(argument, name2, newPullParser);
                                if (LinkReportConstant$GlobalKey.EVENTS.equals(name2)) {
                                    company.config.events = new ArrayList();
                                }
                                if (company.config.events != null && "event".equals(name2)) {
                                    event = new Event();
                                }
                                dealEventInfo(event, name2, newPullParser);
                            }
                            if ("separator".equals(name2)) {
                                company.separator = newPullParser.nextText();
                            }
                            if ("equalizer".equals(name2)) {
                                company.equalizer = newPullParser.nextText();
                            }
                            if ("timeStampUseSecond".equals(name2)) {
                                company.timeStampUseSecond = Boolean.parseBoolean(newPullParser.nextText());
                            }
                        }
                    }
                } else {
                    sdk = new SDK();
                }
            }
        } catch (Throwable th7) {
            sdk = null;
            th5 = th7;
        }
        return sdk;
    }

    public static boolean isNumeric(String str) {
        if (str != null && !"".equals(str)) {
            return Pattern.compile("[0-9]*").matcher(str).matches();
        }
        return false;
    }
}
