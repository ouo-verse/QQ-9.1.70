package com.tencent.tdf.utils;

import android.util.Xml;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tdf.TDFJNI;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: P */
/* loaded from: classes26.dex */
public class FontUtils {
    static IPatchRedirector $redirector_ = null;
    private static final String DefaultLanguage = "zh-Hans";
    private static final Pattern FILENAME_WHITESPACE_PATTERN;
    private static final String[] FallbackFontFileNames;
    private static final String SystemFontConfigPath_JellyBean = "/system/etc/fallback_fonts.xml";
    private static final String SystemFontConfigPath_Lollipop = "/system/etc/fonts.xml";
    private static final String SystemFontPath = "/system/fonts/";
    private static boolean systemFontLoaded;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15537);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        FallbackFontFileNames = new String[]{"/system/fonts/NotoSansCJK-Regular.ttc", "/system/fonts/NotoSansSC-Regular.otf", "/system/fonts/DroidSansFallback.ttf"};
        systemFontLoaded = false;
        FILENAME_WHITESPACE_PATTERN = Pattern.compile("^[ \\n\\r\\t]+|[ \\n\\r\\t]+$");
    }

    public FontUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void addFont(FontConfig fontConfig, ArrayList<String> arrayList, ArrayList<Integer> arrayList2) {
        if (arrayList.contains(fontConfig.fileName) || !new File(fontConfig.fileName).exists()) {
            return;
        }
        arrayList.add(fontConfig.fileName);
        arrayList2.add(Integer.valueOf(fontConfig.ttcIndex));
    }

    private static FontConfig getFontByLanguage(FontConfig[] fontConfigArr, String str) {
        String lowerCase = str.toLowerCase();
        for (FontConfig fontConfig : fontConfigArr) {
            if (fontConfig.language.toLowerCase().equals(lowerCase)) {
                return fontConfig;
            }
        }
        return null;
    }

    private static FontConfig[] parseJellyBean() throws XmlPullParserException, IOException {
        FontConfig[] fontConfigArr = new FontConfig[0];
        try {
            FileInputStream fileInputStream = new FileInputStream(SystemFontConfigPath_JellyBean);
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(fileInputStream, null);
                newPullParser.nextTag();
                return readFamiliesJellyBean(newPullParser);
            } finally {
                fileInputStream.close();
            }
        } catch (IOException unused) {
            return fontConfigArr;
        }
    }

    private static FontConfig[] parseLollipop() throws XmlPullParserException, IOException {
        FontConfig[] fontConfigArr = new FontConfig[0];
        try {
            FileInputStream fileInputStream = new FileInputStream(SystemFontConfigPath_Lollipop);
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(fileInputStream, null);
                newPullParser.nextTag();
                return readFamilies(newPullParser);
            } finally {
                fileInputStream.close();
            }
        } catch (IOException unused) {
            return fontConfigArr;
        }
    }

    private static FontConfig[] readFamilies(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        xmlPullParser.require(2, null, "familyset");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals(IjkMediaPlayer.OnNativeInvokeListener.ARG_FAMILIY)) {
                    readFamily(xmlPullParser, arrayList);
                } else {
                    skip(xmlPullParser);
                }
            }
        }
        FontConfig[] fontConfigArr = new FontConfig[arrayList.size()];
        arrayList.toArray(fontConfigArr);
        return fontConfigArr;
    }

    private static FontConfig[] readFamiliesJellyBean(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        xmlPullParser.require(2, null, "familyset");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals(IjkMediaPlayer.OnNativeInvokeListener.ARG_FAMILIY)) {
                    while (xmlPullParser.next() != 3) {
                        if (xmlPullParser.getEventType() == 2) {
                            if (xmlPullParser.getName().equals("fileset")) {
                                readFileset(xmlPullParser, arrayList);
                            } else {
                                skip(xmlPullParser);
                            }
                        }
                    }
                } else {
                    skip(xmlPullParser);
                }
            }
        }
        FontConfig[] fontConfigArr = new FontConfig[arrayList.size()];
        arrayList.toArray(fontConfigArr);
        return fontConfigArr;
    }

    private static void readFamily(XmlPullParser xmlPullParser, ArrayList<FontConfig> arrayList) throws XmlPullParserException, IOException {
        FontConfig fontConfig = null;
        xmlPullParser.getAttributeValue(null, "name");
        String attributeValue = xmlPullParser.getAttributeValue(null, "lang");
        ArrayList arrayList2 = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList2.add(readFont(xmlPullParser));
                } else {
                    skip(xmlPullParser);
                }
            }
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        Iterator it = arrayList2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            FontConfig fontConfig2 = (FontConfig) it.next();
            if (fontConfig2.weight == 400) {
                fontConfig = fontConfig2;
                break;
            }
        }
        if (fontConfig == null) {
            fontConfig = (FontConfig) arrayList2.get(0);
        }
        if (!fontConfig.fileName.isEmpty()) {
            if (attributeValue == null) {
                attributeValue = "";
            }
            fontConfig.language = attributeValue;
            arrayList.add(fontConfig);
        }
    }

    private static void readFileset(XmlPullParser xmlPullParser, ArrayList<FontConfig> arrayList) throws XmlPullParserException, IOException {
        FontConfig fontConfig;
        ArrayList arrayList2 = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("file")) {
                    arrayList2.add(readFont(xmlPullParser));
                } else {
                    skip(xmlPullParser);
                }
            }
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        Iterator it = arrayList2.iterator();
        while (true) {
            if (it.hasNext()) {
                fontConfig = (FontConfig) it.next();
                if (fontConfig.weight == 400) {
                    break;
                }
            } else {
                fontConfig = null;
                break;
            }
        }
        if (fontConfig == null) {
            fontConfig = (FontConfig) arrayList2.get(0);
        }
        if (!fontConfig.fileName.isEmpty()) {
            arrayList.add(fontConfig);
        }
    }

    private static FontConfig readFont(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int parseInt;
        int parseInt2;
        FontConfig fontConfig = new FontConfig(null);
        String attributeValue = xmlPullParser.getAttributeValue(null, "index");
        if (attributeValue == null) {
            parseInt = 0;
        } else {
            parseInt = Integer.parseInt(attributeValue);
        }
        fontConfig.ttcIndex = parseInt;
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "weight");
        if (attributeValue2 == null) {
            parseInt2 = 400;
        } else {
            parseInt2 = Integer.parseInt(attributeValue2);
        }
        fontConfig.weight = parseInt2;
        StringBuilder sb5 = new StringBuilder();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 4) {
                sb5.append(xmlPullParser.getText());
            }
            if (xmlPullParser.getEventType() == 2) {
                skip(xmlPullParser);
            }
        }
        fontConfig.fileName = SystemFontPath + FILENAME_WHITESPACE_PATTERN.matcher(sb5).replaceAll("");
        return fontConfig;
    }

    public static void setSystemDefaultFontPaths(long j3) {
        if (systemFontLoaded) {
            return;
        }
        systemFontLoaded = true;
        int i3 = 0;
        FontConfig[] fontConfigArr = new FontConfig[0];
        if (new File(SystemFontConfigPath_Lollipop).exists()) {
            try {
                fontConfigArr = parseLollipop();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        } else {
            try {
                fontConfigArr = parseJellyBean();
            } catch (Exception e17) {
                e17.printStackTrace();
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        FontConfig fontByLanguage = getFontByLanguage(fontConfigArr, "zh-Hans");
        if (fontByLanguage != null) {
            addFont(fontByLanguage, arrayList, arrayList2);
        }
        for (String str : FallbackFontFileNames) {
            FontConfig fontConfig = new FontConfig(null);
            fontConfig.fileName = str;
            addFont(fontConfig, arrayList, arrayList2);
        }
        for (FontConfig fontConfig2 : fontConfigArr) {
            addFont(fontConfig2, arrayList, arrayList2);
        }
        if (!arrayList.isEmpty()) {
            String[] strArr = new String[arrayList.size()];
            arrayList.toArray(strArr);
            int[] iArr = new int[arrayList2.size()];
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                iArr[i3] = ((Integer) it.next()).intValue();
                i3++;
            }
            TDFJNI.setSystemDefaultFontPaths(j3, strArr, iArr);
        }
    }

    private static void skip(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i3 = 1;
        while (i3 > 0) {
            int next = xmlPullParser.next();
            if (next != 2) {
                if (next == 3) {
                    i3--;
                }
            } else {
                i3++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class FontConfig {
        static IPatchRedirector $redirector_;
        String fileName;
        String language;
        int ttcIndex;
        int weight;

        FontConfig() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.language = "";
            this.fileName = "";
            this.ttcIndex = 0;
            this.weight = 400;
        }

        /* synthetic */ FontConfig(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) anonymousClass1);
        }
    }
}
