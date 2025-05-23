package org.libpag;

import android.content.res.AssetManager;
import android.util.Xml;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: classes29.dex */
public class PAGFont {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f423717a = Pattern.compile("^[ \\n\\r\\t]+|[ \\n\\r\\t]+$");

    /* renamed from: b, reason: collision with root package name */
    private static boolean f423718b = false;
    public String fontFamily;
    public String fontStyle;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes29.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        String f423719a;

        /* renamed from: b, reason: collision with root package name */
        String f423720b;

        /* renamed from: c, reason: collision with root package name */
        int f423721c;

        /* renamed from: d, reason: collision with root package name */
        int f423722d;

        b() {
            this.f423719a = "";
            this.f423720b = "";
            this.f423721c = 0;
            this.f423722d = 400;
        }
    }

    static {
        org.extra.tools.a.b("pag");
    }

    public PAGFont() {
        this.fontFamily = "";
        this.fontStyle = "";
    }

    private static void RegisterFallbackFonts() {
        if (f423718b) {
            return;
        }
        f423718b = true;
        int i3 = 0;
        b[] bVarArr = new b[0];
        if (new File("/system/etc/fonts.xml").exists()) {
            try {
                bVarArr = b();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        } else {
            try {
                bVarArr = a();
            } catch (Exception e17) {
                e17.printStackTrace();
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        b a16 = a(bVarArr, LocaleUtils.L_SIMPLE_CHINESE);
        if (a16 != null) {
            a(a16, arrayList, arrayList2);
        }
        for (b bVar : bVarArr) {
            a(bVar, arrayList, arrayList2);
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
            SetFallbackFontPaths(strArr, iArr);
        }
    }

    public static native PAGFont RegisterFont(AssetManager assetManager, String str, int i3, String str2, String str3);

    public static PAGFont RegisterFont(String str) {
        return RegisterFont(str, 0);
    }

    public static native PAGFont RegisterFont(String str, int i3, String str2, String str3);

    private static native PAGFont RegisterFontBytes(byte[] bArr, int i3, int i16, String str, String str2);

    private static native void SetFallbackFontPaths(String[] strArr, int[] iArr);

    private static native void UnregisterFont(String str, String str2);

    public static void UnregisterFont(PAGFont pAGFont) {
        UnregisterFont(pAGFont.fontFamily, pAGFont.fontStyle);
    }

    private static b[] a(XmlPullParser xmlPullParser) {
        ArrayList arrayList = new ArrayList();
        xmlPullParser.require(2, null, "familyset");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals(IjkMediaPlayer.OnNativeInvokeListener.ARG_FAMILIY)) {
                    a(xmlPullParser, arrayList);
                } else {
                    d(xmlPullParser);
                }
            }
        }
        b[] bVarArr = new b[arrayList.size()];
        arrayList.toArray(bVarArr);
        return bVarArr;
    }

    private static b[] b() {
        b[] bVarArr = new b[0];
        try {
            FileInputStream fileInputStream = new FileInputStream("/system/etc/fonts.xml");
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(fileInputStream, null);
                newPullParser.nextTag();
                return a(newPullParser);
            } finally {
                fileInputStream.close();
            }
        } catch (IOException unused) {
            return bVarArr;
        }
    }

    private static b c(XmlPullParser xmlPullParser) {
        int parseInt;
        int parseInt2;
        b bVar = new b();
        String attributeValue = xmlPullParser.getAttributeValue(null, "index");
        if (attributeValue == null) {
            parseInt = 0;
        } else {
            parseInt = Integer.parseInt(attributeValue);
        }
        bVar.f423721c = parseInt;
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "weight");
        if (attributeValue2 == null) {
            parseInt2 = 400;
        } else {
            parseInt2 = Integer.parseInt(attributeValue2);
        }
        bVar.f423722d = parseInt2;
        StringBuilder sb5 = new StringBuilder();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 4) {
                sb5.append(xmlPullParser.getText());
            }
            if (xmlPullParser.getEventType() == 2) {
                d(xmlPullParser);
            }
        }
        bVar.f423720b = "/system/fonts/" + f423717a.matcher(sb5).replaceAll("");
        return bVar;
    }

    private static void d(XmlPullParser xmlPullParser) {
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

    public static PAGFont RegisterFont(AssetManager assetManager, String str) {
        return RegisterFont(assetManager, str, 0);
    }

    public static PAGFont RegisterFont(AssetManager assetManager, String str, int i3) {
        return RegisterFont(assetManager, str, i3, "", "");
    }

    public PAGFont(String str, String str2) {
        this.fontFamily = str;
        this.fontStyle = str2;
    }

    public static PAGFont RegisterFont(String str, int i3) {
        return RegisterFont(str, i3, "", "");
    }

    private static b[] b(XmlPullParser xmlPullParser) {
        ArrayList arrayList = new ArrayList();
        xmlPullParser.require(2, null, "familyset");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals(IjkMediaPlayer.OnNativeInvokeListener.ARG_FAMILIY)) {
                    while (xmlPullParser.next() != 3) {
                        if (xmlPullParser.getEventType() == 2) {
                            if (xmlPullParser.getName().equals("fileset")) {
                                b(xmlPullParser, arrayList);
                            } else {
                                d(xmlPullParser);
                            }
                        }
                    }
                } else {
                    d(xmlPullParser);
                }
            }
        }
        b[] bVarArr = new b[arrayList.size()];
        arrayList.toArray(bVarArr);
        return bVarArr;
    }

    private static void a(XmlPullParser xmlPullParser, ArrayList arrayList) {
        b bVar = null;
        xmlPullParser.getAttributeValue(null, "name");
        String attributeValue = xmlPullParser.getAttributeValue(null, "lang");
        ArrayList arrayList2 = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList2.add(c(xmlPullParser));
                } else {
                    d(xmlPullParser);
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
            b bVar2 = (b) it.next();
            if (bVar2.f423722d == 400) {
                bVar = bVar2;
                break;
            }
        }
        if (bVar == null) {
            bVar = (b) arrayList2.get(0);
        }
        if (bVar.f423720b.isEmpty()) {
            return;
        }
        if (attributeValue == null) {
            attributeValue = "";
        }
        bVar.f423719a = attributeValue;
        arrayList.add(bVar);
    }

    private static void b(XmlPullParser xmlPullParser, ArrayList arrayList) {
        b bVar;
        ArrayList arrayList2 = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("file")) {
                    arrayList2.add(c(xmlPullParser));
                } else {
                    d(xmlPullParser);
                }
            }
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        Iterator it = arrayList2.iterator();
        while (true) {
            if (!it.hasNext()) {
                bVar = null;
                break;
            } else {
                bVar = (b) it.next();
                if (bVar.f423722d == 400) {
                    break;
                }
            }
        }
        if (bVar == null) {
            bVar = (b) arrayList2.get(0);
        }
        if (bVar.f423720b.isEmpty()) {
            return;
        }
        arrayList.add(bVar);
    }

    private static b[] a() {
        b[] bVarArr = new b[0];
        try {
            FileInputStream fileInputStream = new FileInputStream("/system/etc/fallback_fonts.xml");
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(fileInputStream, null);
                newPullParser.nextTag();
                return b(newPullParser);
            } finally {
                fileInputStream.close();
            }
        } catch (IOException unused) {
            return bVarArr;
        }
    }

    private static b a(b[] bVarArr, String str) {
        String lowerCase = str.toLowerCase();
        for (b bVar : bVarArr) {
            if (bVar.f423719a.toLowerCase().equals(lowerCase)) {
                return bVar;
            }
        }
        return null;
    }

    private static void a(b bVar, ArrayList arrayList, ArrayList arrayList2) {
        if (!arrayList.contains(bVar.f423720b) && new File(bVar.f423720b).exists()) {
            arrayList.add(bVar.f423720b);
            arrayList2.add(Integer.valueOf(bVar.f423721c));
        }
    }
}
