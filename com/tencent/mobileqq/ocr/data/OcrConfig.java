package com.tencent.mobileqq.ocr.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Xml;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gdtad.basics.motivevideo.report.GdtADFlyingStreamingReportHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.msf.core.net.utils.MsfCmdConfig;
import com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplatePreloadHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.xweb.FileReaderHelper;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: P */
/* loaded from: classes16.dex */
public class OcrConfig implements Parcelable, Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final String CHINESE = "zh";
    public static final Parcelable.Creator<OcrConfig> CREATOR;
    public static final String DEFAULT_SUPPORT_LANGUAGE = "en/ja/ko/fr/es/it/de/tr/ru/pt/vi/id/ms/th";
    public static final String ENGLISH = "en";
    public static final String TAG = "OcrConfig";

    /* renamed from: d, reason: collision with root package name */
    private static final HashMap<String, String> f254720d;
    public int aioOcrOpen;
    public String aioText;
    public int chatFileOcrOpen;
    public long endTime;
    public String iconMd5;
    public String iconPressMD5;
    public String iconPressUrl;
    public String iconText;
    public String iconUrl;
    public int questionResultOpen;
    public int questionScanOpen;
    public int qzoneOcrOpen;
    public int scanOcrOpen;
    public long startTime;
    public String tips;
    public HashMap<String, String> translateLanguageNames;
    public HashMap<String, List<String>> translateSupportLanguages;
    public int version;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements Parcelable.Creator<OcrConfig> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public OcrConfig createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (OcrConfig) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new OcrConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public OcrConfig[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (OcrConfig[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new OcrConfig[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32241);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        CREATOR = new a();
        HashMap<String, String> hashMap = new HashMap<>();
        f254720d = hashMap;
        hashMap.put(CHINESE, HardCodeUtil.qqStr(R.string.oug));
        hashMap.put("en", HardCodeUtil.qqStr(R.string.ous));
        hashMap.put("af", HardCodeUtil.qqStr(R.string.ovk));
        hashMap.put("ar", HardCodeUtil.qqStr(R.string.f172258ow0));
        hashMap.put("eu", HardCodeUtil.qqStr(R.string.f172255ov2));
        hashMap.put("be", HardCodeUtil.qqStr(R.string.ovf));
        hashMap.put("hr", HardCodeUtil.qqStr(R.string.ouq));
        hashMap.put("da", HardCodeUtil.qqStr(R.string.ovy));
        hashMap.put("nl", HardCodeUtil.qqStr(R.string.oux));
        hashMap.put("fo", HardCodeUtil.qqStr(R.string.oum));
        hashMap.put("fi", HardCodeUtil.qqStr(R.string.f172254ov1));
        hashMap.put("fr", HardCodeUtil.qqStr(R.string.ov6));
        hashMap.put("gd", HardCodeUtil.qqStr(R.string.ovd));
        hashMap.put("de", HardCodeUtil.qqStr(R.string.out));
        hashMap.put("he", HardCodeUtil.qqStr(R.string.ovn));
        hashMap.put("hu", HardCodeUtil.qqStr(R.string.ovs));
        hashMap.put("id", HardCodeUtil.qqStr(R.string.ovb));
        hashMap.put("it", HardCodeUtil.qqStr(R.string.f172253ov0));
        hashMap.put("kr", HardCodeUtil.qqStr(R.string.ovq));
        hashMap.put(LocaleUtils.L_KOREAN, HardCodeUtil.qqStr(R.string.ov_));
        hashMap.put("lv", HardCodeUtil.qqStr(R.string.f172260ow2));
        hashMap.put("mk", HardCodeUtil.qqStr(R.string.ove));
        hashMap.put("mt", HardCodeUtil.qqStr(R.string.f172257ov4));
        hashMap.put("no", HardCodeUtil.qqStr(R.string.ovr));
        hashMap.put("pt", HardCodeUtil.qqStr(R.string.ovo));
        hashMap.put(MsfCmdConfig.CMD_DELETE_FILE, HardCodeUtil.qqStr(R.string.ovm));
        hashMap.put("ro", HardCodeUtil.qqStr(R.string.ov7));
        hashMap.put("sr", HardCodeUtil.qqStr(R.string.f172259ow1));
        hashMap.put("sk", HardCodeUtil.qqStr(R.string.ovi));
        hashMap.put("sb", HardCodeUtil.qqStr(R.string.ov5));
        hashMap.put("es", HardCodeUtil.qqStr(R.string.ova));
        hashMap.put("sx", HardCodeUtil.qqStr(R.string.ovj));
        hashMap.put(GdtADFlyingStreamingReportHelper.PARAM_KEY_SV, HardCodeUtil.qqStr(R.string.ovg));
        hashMap.put("ts", HardCodeUtil.qqStr(R.string.ouu));
        hashMap.put(ReportConstant.COSTREPORT_TRANS, HardCodeUtil.qqStr(R.string.ouk));
        hashMap.put("ur", HardCodeUtil.qqStr(R.string.ouf));
        hashMap.put("vi", HardCodeUtil.qqStr(R.string.ovu));
        hashMap.put(WidgetCacheLunarData.JI, HardCodeUtil.qqStr(R.string.ouo));
        hashMap.put("sq", HardCodeUtil.qqStr(R.string.f172256ov3));
        hashMap.put(VasProfileTemplatePreloadHelper.BACKGROUND, HardCodeUtil.qqStr(R.string.ov8));
        hashMap.put("ca", HardCodeUtil.qqStr(R.string.oun));
        hashMap.put("cs", HardCodeUtil.qqStr(R.string.ovv));
        hashMap.put(FileReaderHelper.ET_EXT, HardCodeUtil.qqStr(R.string.ovw));
        hashMap.put("fa", HardCodeUtil.qqStr(R.string.oup));
        hashMap.put("ga", HardCodeUtil.qqStr(R.string.ovp));
        hashMap.put("el", HardCodeUtil.qqStr(R.string.oul));
        hashMap.put("hi", HardCodeUtil.qqStr(R.string.ouz));
        hashMap.put("is", HardCodeUtil.qqStr(R.string.ouj));
        hashMap.put("jp", HardCodeUtil.qqStr(R.string.ovx));
        hashMap.put(LocaleUtils.L_JAPANESE, HardCodeUtil.qqStr(R.string.ovz));
        hashMap.put("lt", HardCodeUtil.qqStr(R.string.ovl));
        hashMap.put("ms", HardCodeUtil.qqStr(R.string.ouy));
        hashMap.put("pl", HardCodeUtil.qqStr(R.string.ovc));
        hashMap.put("ru", HardCodeUtil.qqStr(R.string.ovh));
        hashMap.put("sz", HardCodeUtil.qqStr(R.string.ovt));
        hashMap.put("sl", HardCodeUtil.qqStr(R.string.ov9));
        hashMap.put("th", HardCodeUtil.qqStr(R.string.oue));
        hashMap.put("tn", HardCodeUtil.qqStr(R.string.ouh));
        hashMap.put("uk", HardCodeUtil.qqStr(R.string.our));
        hashMap.put("ve", HardCodeUtil.qqStr(R.string.f172261ow3));
        hashMap.put("xh", HardCodeUtil.qqStr(R.string.ouw));
        hashMap.put("zu", HardCodeUtil.qqStr(R.string.ouv));
        hashMap.put("jap", HardCodeUtil.qqStr(R.string.ovx));
        hashMap.put("unk", HardCodeUtil.qqStr(R.string.oui));
    }

    public OcrConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.version = 0;
        this.scanOcrOpen = 0;
        this.aioOcrOpen = 0;
        this.chatFileOcrOpen = 0;
        this.qzoneOcrOpen = 0;
        this.questionScanOpen = 0;
        this.questionResultOpen = 0;
    }

    public static void deleteLocalConfig(String str) {
        File fileStreamPath = MobileQQ.sMobileQQ.getFileStreamPath("ocr_config_" + str);
        if (fileStreamPath.exists()) {
            fileStreamPath.delete();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "deleteLocalConfig path:" + fileStreamPath.getAbsolutePath());
        }
    }

    public static String getDefaultLanguageName(String str) {
        if (TextUtils.isEmpty(str)) {
            return HardCodeUtil.qqStr(R.string.oui);
        }
        String str2 = f254720d.get(str);
        if (TextUtils.isEmpty(str2)) {
            str2 = HardCodeUtil.qqStr(R.string.oui);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("getDefaultLanguageName, code:%s, name:%s", str, str2));
        }
        return str2;
    }

    public static List<String> getDefaultSupportLanguages(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (str.equalsIgnoreCase(CHINESE)) {
            String[] split = DEFAULT_SUPPORT_LANGUAGE.split("/");
            if (split.length > 0) {
                Collections.addAll(arrayList, split);
            }
        } else {
            arrayList.add(CHINESE);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getDefaultSupportLanguages, list = " + arrayList);
        }
        return arrayList;
    }

    public static OcrConfig parse(String str) {
        String str2;
        String str3;
        int i3;
        int i16;
        String[] split;
        String str4 = "QuestionCfg";
        String str5 = "QzoneCfg";
        int i17 = 2;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "OcrConfig.parse, xmlContent:" + str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        XmlPullParser newPullParser = Xml.newPullParser();
        OcrConfig ocrConfig = new OcrConfig();
        try {
            newPullParser.setInput(new ByteArrayInputStream(str.getBytes()), "UTF-8");
            int eventType = newPullParser.getEventType();
            while (true) {
                int i18 = 1;
                if (eventType == 1) {
                    break;
                }
                if (eventType == i17) {
                    String name = newPullParser.getName();
                    int i19 = 3;
                    if (name.equalsIgnoreCase("ScanCfg")) {
                        for (int next = newPullParser.next(); next != 1; next = newPullParser.next()) {
                            if (next == i17) {
                                String name2 = newPullParser.getName();
                                if (name2.equalsIgnoreCase("ScanOcrOpen")) {
                                    ocrConfig.scanOcrOpen = Integer.parseInt(newPullParser.nextText());
                                } else if (name2.equalsIgnoreCase("ScanIconImg")) {
                                    ocrConfig.iconUrl = newPullParser.nextText();
                                } else if (name2.equalsIgnoreCase("ScanIconMd5")) {
                                    ocrConfig.iconMd5 = newPullParser.nextText();
                                } else if (name2.equalsIgnoreCase("ScanIconPressed")) {
                                    ocrConfig.iconPressUrl = newPullParser.nextText();
                                } else if (name2.equalsIgnoreCase("ScanIconPressedMd5")) {
                                    ocrConfig.iconPressMD5 = newPullParser.nextText();
                                } else if (name2.equalsIgnoreCase("ScanIconText")) {
                                    ocrConfig.iconText = newPullParser.nextText();
                                } else if (name2.equalsIgnoreCase("Scan_Line1")) {
                                    ocrConfig.tips = newPullParser.nextText();
                                }
                            } else if (next == 3 && newPullParser.getName().equalsIgnoreCase("ScanCfg")) {
                                break;
                            }
                        }
                    } else if (name.equalsIgnoreCase("AioCfg")) {
                        for (int next2 = newPullParser.next(); next2 != 1; next2 = newPullParser.next()) {
                            if (next2 == i17) {
                                String name3 = newPullParser.getName();
                                if (name3.equalsIgnoreCase("AioOcrOpen")) {
                                    ocrConfig.aioOcrOpen = Integer.parseInt(newPullParser.nextText());
                                } else if (name3.equalsIgnoreCase("AioText")) {
                                    ocrConfig.aioText = newPullParser.nextText();
                                }
                            } else if (next2 == 3 && newPullParser.getName().equalsIgnoreCase("AioCfg")) {
                                break;
                            }
                        }
                    } else if (name.equalsIgnoreCase("ChatFileCfg")) {
                        for (int next3 = newPullParser.next(); next3 != 1; next3 = newPullParser.next()) {
                            if (next3 == i17) {
                                if (newPullParser.getName().equalsIgnoreCase("ChatFileOcrOpen")) {
                                    ocrConfig.chatFileOcrOpen = Integer.parseInt(newPullParser.nextText());
                                }
                            } else if (next3 == 3 && newPullParser.getName().equalsIgnoreCase("ChatFileCfg")) {
                                break;
                            }
                        }
                    } else if (name.equalsIgnoreCase(str5)) {
                        for (int next4 = newPullParser.next(); next4 != 1; next4 = newPullParser.next()) {
                            if (next4 == i17) {
                                if (newPullParser.getName().equalsIgnoreCase("QzoneOcrOpen")) {
                                    ocrConfig.qzoneOcrOpen = Integer.parseInt(newPullParser.nextText());
                                }
                            } else if (next4 == 3 && newPullParser.getName().equalsIgnoreCase(str5)) {
                                break;
                            }
                        }
                    } else if (name.equalsIgnoreCase(str4)) {
                        for (int next5 = newPullParser.next(); next5 != 1; next5 = newPullParser.next()) {
                            if (next5 == i17) {
                                String name4 = newPullParser.getName();
                                if (name4.equalsIgnoreCase("ScanEnter")) {
                                    ocrConfig.questionScanOpen = Integer.parseInt(newPullParser.nextText());
                                } else if (name4.equalsIgnoreCase("ResultPageEnter")) {
                                    ocrConfig.questionResultOpen = Integer.parseInt(newPullParser.nextText());
                                }
                            } else if (next5 == 3 && newPullParser.getName().equalsIgnoreCase(str4)) {
                                break;
                            }
                        }
                    } else if (name.equalsIgnoreCase(CanvasView.ACTION_TRANSLATE)) {
                        int next6 = newPullParser.next();
                        while (next6 != i18) {
                            if (next6 == i17) {
                                String name5 = newPullParser.getName();
                                if (name5.equalsIgnoreCase("languages")) {
                                    while (next6 != i18) {
                                        if (next6 == i17) {
                                            if (newPullParser.getName().equalsIgnoreCase(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME)) {
                                                String str6 = null;
                                                String str7 = null;
                                                while (true) {
                                                    if (next6 == i18) {
                                                        break;
                                                    }
                                                    if (next6 == i17) {
                                                        String name6 = newPullParser.getName();
                                                        if (name6.equalsIgnoreCase("src")) {
                                                            str6 = newPullParser.nextText();
                                                        } else if (name6.equalsIgnoreCase("dst")) {
                                                            str7 = newPullParser.nextText();
                                                        }
                                                    } else if (next6 == 3 && newPullParser.getName().equalsIgnoreCase(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME)) {
                                                        if (!TextUtils.isEmpty(str6) && !TextUtils.isEmpty(str7)) {
                                                            if (ocrConfig.translateSupportLanguages == null) {
                                                                ocrConfig.translateSupportLanguages = new HashMap<>();
                                                            }
                                                            String[] split2 = str7.split("/");
                                                            if (split2 != null && split2.length > 0) {
                                                                ArrayList arrayList = new ArrayList();
                                                                int length = split2.length;
                                                                str2 = str4;
                                                                int i26 = 0;
                                                                while (i26 < length) {
                                                                    arrayList.add(split2[i26]);
                                                                    i26++;
                                                                    str5 = str5;
                                                                }
                                                                str3 = str5;
                                                                ocrConfig.translateSupportLanguages.put(str6, arrayList);
                                                            }
                                                        }
                                                    }
                                                    String str8 = str4;
                                                    str7 = str7;
                                                    str5 = str5;
                                                    i17 = 2;
                                                    i18 = 1;
                                                    next6 = newPullParser.next();
                                                    str4 = str8;
                                                }
                                            }
                                            str2 = str4;
                                            str3 = str5;
                                        } else {
                                            str2 = str4;
                                            str3 = str5;
                                            if (next6 == 3 && newPullParser.getName().equalsIgnoreCase("languages")) {
                                                i3 = 3;
                                                i16 = 1;
                                                break;
                                            }
                                        }
                                        next6 = newPullParser.next();
                                        str4 = str2;
                                        str5 = str3;
                                        i17 = 2;
                                        i18 = 1;
                                    }
                                    str2 = str4;
                                    str3 = str5;
                                    i16 = i18;
                                } else {
                                    str2 = str4;
                                    str3 = str5;
                                    if (name5.equalsIgnoreCase("name")) {
                                        int next7 = newPullParser.next();
                                        int i27 = 1;
                                        while (true) {
                                            if (next7 != i27) {
                                                if (next7 == 2) {
                                                    if (newPullParser.getName().equalsIgnoreCase(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME)) {
                                                        String nextText = newPullParser.nextText();
                                                        if (!TextUtils.isEmpty(nextText) && (split = nextText.split("-")) != null && split.length == 2) {
                                                            if (ocrConfig.translateLanguageNames == null) {
                                                                ocrConfig.translateLanguageNames = new HashMap<>();
                                                            }
                                                            String str9 = split[0];
                                                            i16 = 1;
                                                            String str10 = split[1];
                                                            if (!TextUtils.isEmpty(str9) && !TextUtils.isEmpty(str10)) {
                                                                ocrConfig.translateLanguageNames.put(str9, str10);
                                                            }
                                                        }
                                                    }
                                                    i16 = 1;
                                                } else {
                                                    i16 = 1;
                                                    if (next7 == 3 && newPullParser.getName().equalsIgnoreCase("name")) {
                                                        break;
                                                    }
                                                }
                                                next7 = newPullParser.next();
                                                i27 = i16;
                                            } else {
                                                i16 = i27;
                                                break;
                                            }
                                        }
                                    } else {
                                        i16 = 1;
                                    }
                                }
                                i3 = 3;
                            } else {
                                str2 = str4;
                                str3 = str5;
                                i3 = i19;
                                i16 = i18;
                                if (next6 == i3 && newPullParser.getName().equalsIgnoreCase(CanvasView.ACTION_TRANSLATE)) {
                                    break;
                                }
                            }
                            next6 = newPullParser.next();
                            i19 = i3;
                            i18 = i16;
                            str4 = str2;
                            str5 = str3;
                            i17 = 2;
                        }
                    }
                }
                str2 = str4;
                str3 = str5;
                eventType = newPullParser.next();
                str4 = str2;
                str5 = str3;
                i17 = 2;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "parse:" + ocrConfig);
            }
            return ocrConfig;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "parse exception:" + e16.toString());
                return null;
            }
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static OcrConfig readFromFile(String str) {
        ?? r46;
        ObjectInputStream objectInputStream;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "start loadFromLocal");
        }
        FileInputStream fileInputStream = null;
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "loadFromLocal uin is null");
            }
            return null;
        }
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("ocr_config_");
        sb5.append(str);
        File fileStreamPath = mobileQQ.getFileStreamPath(sb5.toString());
        ?? exists = fileStreamPath.exists();
        try {
            if (exists == 0) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "loadFromLocal file is not exist");
                }
                return null;
            }
            try {
                exists = new FileInputStream(fileStreamPath);
                try {
                    objectInputStream = new ObjectInputStream(new BufferedInputStream(exists));
                } catch (Exception e16) {
                    e = e16;
                    objectInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    sb5 = null;
                    fileInputStream = exists;
                    r46 = sb5;
                    if (fileInputStream != null) {
                    }
                    if (r46 != 0) {
                    }
                    throw th;
                }
            } catch (Exception e17) {
                e = e17;
                exists = 0;
                objectInputStream = null;
            } catch (Throwable th6) {
                th = th6;
                r46 = 0;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e18) {
                        if (QLog.isColorLevel()) {
                            e18.printStackTrace();
                        }
                    }
                }
                if (r46 != 0) {
                    try {
                        r46.close();
                    } catch (IOException e19) {
                        if (QLog.isColorLevel()) {
                            e19.printStackTrace();
                        }
                    }
                }
                throw th;
            }
            try {
                OcrConfig ocrConfig = (OcrConfig) objectInputStream.readObject();
                try {
                    exists.close();
                } catch (IOException e26) {
                    if (QLog.isColorLevel()) {
                        e26.printStackTrace();
                    }
                }
                try {
                    objectInputStream.close();
                } catch (IOException e27) {
                    if (QLog.isColorLevel()) {
                        e27.printStackTrace();
                    }
                }
                return ocrConfig;
            } catch (Exception e28) {
                e = e28;
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "loadFromLocal exception:" + e.toString());
                }
                if (exists != 0) {
                    try {
                        exists.close();
                    } catch (IOException e29) {
                        if (QLog.isColorLevel()) {
                            e29.printStackTrace();
                        }
                    }
                }
                if (objectInputStream == null) {
                    return null;
                }
                try {
                    objectInputStream.close();
                    return null;
                } catch (IOException e36) {
                    if (!QLog.isColorLevel()) {
                        return null;
                    }
                    e36.printStackTrace();
                    return null;
                }
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 0;
    }

    public String getTranslateLanguageName(String str) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        HashMap<String, String> hashMap = this.translateLanguageNames;
        if (hashMap != null) {
            str2 = hashMap.get(str);
        } else {
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = getDefaultLanguageName(str);
        } else {
            QLog.d(TAG, 1, "translateLanguageNames == null");
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("getTranslateLanguageName, code:%s, name:%s", str, str2));
        }
        return str2;
    }

    public List<String> getTranslateSupportLanguages(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        List<String> list = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap<String, List<String>> hashMap = this.translateSupportLanguages;
        if (hashMap != null) {
            list = hashMap.get(str);
        } else {
            QLog.d(TAG, 1, "translateSupportLanguages == null");
        }
        if (list == null || list.size() == 0) {
            list = getDefaultSupportLanguages(str);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getTranslateSupportLanguages, list = " + list);
        }
        return list;
    }

    public boolean isEntryOpen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this)).booleanValue();
        }
        if (this.scanOcrOpen == 1) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:132:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0194 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.io.OutputStream, java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void saveToFile(String str) {
        ObjectOutputStream objectOutputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "saveToFile uin is empty");
                return;
            }
            return;
        }
        File fileStreamPath = MobileQQ.sMobileQQ.getFileStreamPath("ocr_config_" + str);
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        ?? sb5 = new StringBuilder();
        sb5.append("ocr_config_");
        sb5.append(str);
        sb5.append(".tmp");
        File fileStreamPath2 = mobileQQ.getFileStreamPath(sb5.toString());
        ?? r46 = "ocr_config_";
        if (QLog.isColorLevel()) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("saveToFile path:");
            String absolutePath = fileStreamPath.getAbsolutePath();
            sb6.append(absolutePath);
            QLog.d(TAG, 2, sb6.toString());
            r46 = absolutePath;
        }
        if (fileStreamPath2.exists()) {
            fileStreamPath2.delete();
        }
        FileOutputStream fileOutputStream = null;
        r3 = null;
        r3 = null;
        ObjectOutputStream objectOutputStream2 = null;
        fileOutputStream = null;
        try {
            try {
                fileStreamPath2.createNewFile();
                r46 = new FileOutputStream(fileStreamPath2);
                try {
                    sb5 = new BufferedOutputStream(r46);
                    try {
                        objectOutputStream = new ObjectOutputStream(sb5);
                        try {
                            objectOutputStream.writeObject(this);
                            objectOutputStream.flush();
                            if (fileStreamPath.exists()) {
                                fileStreamPath.delete();
                            }
                            fileStreamPath2.renameTo(fileStreamPath);
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "save successful");
                            }
                            try {
                                r46.close();
                            } catch (IOException e16) {
                                if (QLog.isColorLevel()) {
                                    e16.printStackTrace();
                                }
                            }
                            try {
                                sb5.close();
                            } catch (IOException e17) {
                                e17.printStackTrace();
                            }
                            try {
                                objectOutputStream.close();
                            } catch (IOException e18) {
                                e = e18;
                                if (!QLog.isColorLevel()) {
                                    return;
                                }
                                e.printStackTrace();
                            }
                        } catch (IOException e19) {
                            e = e19;
                            objectOutputStream2 = objectOutputStream;
                            e.printStackTrace();
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "saveToFile Exception:" + e.toString());
                            }
                            if (r46 != 0) {
                                try {
                                    r46.close();
                                } catch (IOException e26) {
                                    if (QLog.isColorLevel()) {
                                        e26.printStackTrace();
                                    }
                                }
                            }
                            if (sb5 != 0) {
                                try {
                                    sb5.close();
                                } catch (IOException e27) {
                                    e27.printStackTrace();
                                }
                            }
                            if (objectOutputStream2 != null) {
                                try {
                                    objectOutputStream2.close();
                                } catch (IOException e28) {
                                    e = e28;
                                    if (!QLog.isColorLevel()) {
                                        return;
                                    }
                                    e.printStackTrace();
                                }
                            }
                        } catch (OutOfMemoryError e29) {
                            e = e29;
                            fileOutputStream = r46;
                            sb5 = sb5;
                            try {
                                QLog.d(TAG, 2, "saveToFile " + e.getMessage());
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e36) {
                                        if (QLog.isColorLevel()) {
                                            e36.printStackTrace();
                                        }
                                    }
                                }
                                if (sb5 != 0) {
                                    try {
                                        sb5.close();
                                    } catch (IOException e37) {
                                        e37.printStackTrace();
                                    }
                                }
                                if (objectOutputStream != null) {
                                    try {
                                        objectOutputStream.close();
                                    } catch (IOException e38) {
                                        e = e38;
                                        if (!QLog.isColorLevel()) {
                                            return;
                                        }
                                        e.printStackTrace();
                                    }
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e39) {
                                        if (QLog.isColorLevel()) {
                                            e39.printStackTrace();
                                        }
                                    }
                                }
                                if (sb5 != 0) {
                                    try {
                                        sb5.close();
                                    } catch (IOException e46) {
                                        e46.printStackTrace();
                                    }
                                }
                                if (objectOutputStream != null) {
                                    try {
                                        objectOutputStream.close();
                                        throw th;
                                    } catch (IOException e47) {
                                        if (QLog.isColorLevel()) {
                                            e47.printStackTrace();
                                            throw th;
                                        }
                                        throw th;
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            fileOutputStream = r46;
                            if (fileOutputStream != null) {
                            }
                            if (sb5 != 0) {
                            }
                            if (objectOutputStream != null) {
                            }
                        }
                    } catch (IOException e48) {
                        e = e48;
                    } catch (OutOfMemoryError e49) {
                        e = e49;
                        objectOutputStream = null;
                    }
                } catch (IOException e56) {
                    e = e56;
                    sb5 = 0;
                } catch (OutOfMemoryError e57) {
                    e = e57;
                    sb5 = 0;
                    objectOutputStream = null;
                } catch (Throwable th7) {
                    th = th7;
                    sb5 = 0;
                    objectOutputStream = null;
                }
            } catch (IOException e58) {
                e = e58;
                r46 = 0;
                sb5 = 0;
            } catch (OutOfMemoryError e59) {
                e = e59;
                sb5 = 0;
                objectOutputStream = null;
            } catch (Throwable th8) {
                th = th8;
                sb5 = 0;
                objectOutputStream = null;
                if (fileOutputStream != null) {
                }
                if (sb5 != 0) {
                }
                if (objectOutputStream != null) {
                }
            }
        } catch (Throwable th9) {
            th = th9;
            objectOutputStream = null;
        }
    }

    public String toString() {
        int size;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder("OcrConfig{");
        sb5.append("version:");
        sb5.append(this.version);
        sb5.append(",scanOcrOpen,:");
        sb5.append(this.scanOcrOpen);
        sb5.append(",iconUrl:");
        sb5.append(this.iconUrl);
        sb5.append(",iconMd5:");
        sb5.append(this.iconMd5);
        sb5.append(",iconPressUrl:");
        sb5.append(this.iconPressUrl);
        sb5.append(",iconPressMD5:");
        sb5.append(this.iconPressMD5);
        sb5.append(",iconText:");
        sb5.append(this.iconText);
        sb5.append(",tips:");
        sb5.append(this.tips);
        sb5.append(",aioOcrOpen,:");
        sb5.append(this.aioOcrOpen);
        sb5.append(",aioText:");
        sb5.append(this.aioText);
        sb5.append(",chatFileOcrOpen:");
        sb5.append(this.chatFileOcrOpen);
        sb5.append(",qzoneOcrOpen:");
        sb5.append(this.qzoneOcrOpen);
        sb5.append(",questionScanOpen:");
        sb5.append(this.questionScanOpen);
        sb5.append(",questionResultOpen:");
        sb5.append(this.questionResultOpen);
        sb5.append(",translateLanguageNames:");
        HashMap<String, String> hashMap = this.translateLanguageNames;
        int i3 = 0;
        if (hashMap == null) {
            size = 0;
        } else {
            size = hashMap.size();
        }
        sb5.append(size);
        sb5.append(",translateSupportLanguages:");
        HashMap<String, List<String>> hashMap2 = this.translateSupportLanguages;
        if (hashMap2 != null) {
            i3 = hashMap2.size();
        }
        sb5.append(i3);
        return sb5.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeInt(this.version);
        parcel.writeInt(this.scanOcrOpen);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.iconMd5);
        parcel.writeString(this.iconPressUrl);
        parcel.writeString(this.iconPressMD5);
        parcel.writeString(this.iconText);
        parcel.writeString(this.tips);
        parcel.writeInt(this.aioOcrOpen);
        parcel.writeString(this.aioText);
        parcel.writeInt(this.qzoneOcrOpen);
        parcel.writeInt(this.questionScanOpen);
        parcel.writeInt(this.questionResultOpen);
        parcel.writeInt(this.chatFileOcrOpen);
    }

    public OcrConfig(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
            return;
        }
        this.version = 0;
        this.scanOcrOpen = 0;
        this.aioOcrOpen = 0;
        this.chatFileOcrOpen = 0;
        this.qzoneOcrOpen = 0;
        this.questionScanOpen = 0;
        this.questionResultOpen = 0;
        this.version = parcel.readInt();
        this.scanOcrOpen = parcel.readInt();
        this.iconUrl = parcel.readString();
        this.iconMd5 = parcel.readString();
        this.iconPressUrl = parcel.readString();
        this.iconPressMD5 = parcel.readString();
        this.iconText = parcel.readString();
        this.tips = parcel.readString();
        this.aioOcrOpen = parcel.readInt();
        this.aioText = parcel.readString();
        this.qzoneOcrOpen = parcel.readInt();
        this.questionScanOpen = parcel.readInt();
        this.questionResultOpen = parcel.readInt();
        this.chatFileOcrOpen = parcel.readInt();
    }
}
