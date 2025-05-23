package com.tencent.luggage.wxa.ar;

import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class r {
    public static k a(String str) {
        if (str == null) {
            x0.a("ConfigParser", "parse config failed, path is empty");
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            x0.a("ConfigParser", "parse config failed, file not exist");
            return null;
        }
        return a(file, a(file, (int) file.length(), "<Versions>"));
    }

    public static n b(String str) {
        if (str == null) {
            x0.a("ConfigParser", "parse plugin config failed, path is empty");
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            x0.a("ConfigParser", "parse plugin config failed, file not exist");
            return null;
        }
        return b(file, a(file, (int) file.length(), "<Plugins>"));
    }

    public static int c(Element element, String str) {
        String attribute;
        if (element != null && (attribute = element.getAttribute(str)) != null && !attribute.isEmpty()) {
            if (attribute.contains(RelationNTPushServiceImpl.PRE_HEX_STRING)) {
                attribute = attribute.trim().substring(2);
            }
            try {
                return Integer.parseInt(attribute, 16);
            } catch (Throwable th5) {
                x0.a("ConfigParser", "safeGetIntFromHex error", th5);
            }
        }
        return 0;
    }

    public static k a(File file, String str) {
        SAXException e16;
        k kVar;
        ParserConfigurationException e17;
        IOException e18;
        FileInputStream fileInputStream;
        Element documentElement;
        x0.d("ConfigParser", "parse base config, file:" + file.getAbsolutePath());
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (IOException e19) {
                e18 = e19;
                kVar = null;
            } catch (ParserConfigurationException e26) {
                e17 = e26;
                kVar = null;
            } catch (SAXException e27) {
                e16 = e27;
                kVar = null;
            }
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
        }
        try {
            try {
                kVar = new k();
            } catch (IOException e28) {
                e18 = e28;
                kVar = null;
            } catch (ParserConfigurationException e29) {
                e17 = e29;
                kVar = null;
            } catch (SAXException e36) {
                e16 = e36;
                kVar = null;
            }
            try {
                documentElement = newInstance.newDocumentBuilder().parse(fileInputStream).getDocumentElement();
            } catch (IOException e37) {
                e18 = e37;
                fileInputStream2 = fileInputStream;
                x0.a("ConfigParser", "parse config failed, IOException:" + e18);
                e18.printStackTrace();
                fileInputStream = fileInputStream2;
                w.a(fileInputStream);
                return kVar;
            } catch (ParserConfigurationException e38) {
                e17 = e38;
                fileInputStream2 = fileInputStream;
                x0.a("ConfigParser", "parse config failed, ParserConfigurationException:" + e17);
                e17.printStackTrace();
                fileInputStream = fileInputStream2;
                w.a(fileInputStream);
                return kVar;
            } catch (SAXException e39) {
                e16 = e39;
                fileInputStream2 = fileInputStream;
                x0.a("ConfigParser", "parse config failed, SAXException:" + e16);
                e16.printStackTrace();
                fileInputStream = fileInputStream2;
                w.a(fileInputStream);
                return kVar;
            }
            if (documentElement == null) {
                x0.a("ConfigParser", "parse config failed, xml is corrupted");
                w.a(fileInputStream);
                return null;
            }
            kVar.f121699a = documentElement.getAttribute("checkvalue");
            kVar.f121700b = documentElement.getAttribute("signature");
            String str2 = kVar.f121699a;
            if (str2 != null && str2.equalsIgnoreCase(str)) {
                if (!u.a(kVar.f121699a, kVar.f121700b, "MHYwEAYHKoZIzj0CAQYFK4EEACIDYgAElTrKAIIFSlvo+nwaPfs/mOUwWxBMLvtZ\nLJzLBPmZsBp5JhCEf91FTaJTAnxQN77mxuzil4rN7YLV5S2h3nNOlKKfEnf4lpc4\nzsCGoyHQX0gGYYTAHPmL+qUv6MO4YMAn")) {
                    n0.a(95L, 1);
                    x0.a("ConfigParser", "parse config failed, signature not match");
                    w.a(fileInputStream);
                    return null;
                }
                kVar.f121701c = documentElement.getAttribute("configVer");
                kVar.f121703e = b(documentElement);
                a(kVar, documentElement);
                w.a(fileInputStream);
                return kVar;
            }
            n0.a(34L, 1);
            x0.a("ConfigParser", "parse config failed, checkValue not match");
            w.a(fileInputStream);
            return null;
        } catch (Throwable th6) {
            th = th6;
            w.a(fileInputStream);
            throw th;
        }
    }

    public static n b(File file, String str) {
        SAXException e16;
        n nVar;
        ParserConfigurationException e17;
        IOException e18;
        FileInputStream fileInputStream;
        Element documentElement;
        x0.d("ConfigParser", "parse plugin config, file:" + file.getAbsolutePath());
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (IOException e19) {
                e18 = e19;
                nVar = null;
            } catch (ParserConfigurationException e26) {
                e17 = e26;
                nVar = null;
            } catch (SAXException e27) {
                e16 = e27;
                nVar = null;
            }
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
        }
        try {
            try {
                nVar = new n();
                try {
                    documentElement = newInstance.newDocumentBuilder().parse(fileInputStream).getDocumentElement();
                } catch (IOException e28) {
                    e18 = e28;
                    fileInputStream2 = fileInputStream;
                    x0.a("ConfigParser", "parse plugin config failed, IOException:" + e18);
                    e18.printStackTrace();
                    fileInputStream = fileInputStream2;
                    w.a(fileInputStream);
                    return nVar;
                } catch (ParserConfigurationException e29) {
                    e17 = e29;
                    fileInputStream2 = fileInputStream;
                    x0.a("ConfigParser", "parse plugin config failed, ParserConfigurationException:" + e17);
                    e17.printStackTrace();
                    fileInputStream = fileInputStream2;
                    w.a(fileInputStream);
                    return nVar;
                } catch (SAXException e36) {
                    e16 = e36;
                    fileInputStream2 = fileInputStream;
                    x0.a("ConfigParser", "parse plugin config failed, SAXException:" + e16);
                    e16.printStackTrace();
                    fileInputStream = fileInputStream2;
                    w.a(fileInputStream);
                    return nVar;
                }
            } catch (IOException e37) {
                e18 = e37;
                nVar = null;
            } catch (ParserConfigurationException e38) {
                e17 = e38;
                nVar = null;
            } catch (SAXException e39) {
                e16 = e39;
                nVar = null;
            }
            if (documentElement == null) {
                x0.a("ConfigParser", "parse plugin config failed, xml is corrupted");
                w.a(fileInputStream);
                return null;
            }
            nVar.f121743a = documentElement.getAttribute("checkvalue");
            nVar.f121744b = documentElement.getAttribute("signature");
            String str2 = nVar.f121743a;
            if (str2 != null && str2.equalsIgnoreCase(str)) {
                if (!u.a(nVar.f121743a, nVar.f121744b, "MHYwEAYHKoZIzj0CAQYFK4EEACIDYgAElTrKAIIFSlvo+nwaPfs/mOUwWxBMLvtZ\nLJzLBPmZsBp5JhCEf91FTaJTAnxQN77mxuzil4rN7YLV5S2h3nNOlKKfEnf4lpc4\nzsCGoyHQX0gGYYTAHPmL+qUv6MO4YMAn")) {
                    n0.a(95L, 1);
                    x0.a("ConfigParser", "parse plugin config failed, signature not match");
                    w.a(fileInputStream);
                    return null;
                }
                nVar.f121745c = documentElement.getAttribute("configVer");
                nVar.f121747e = b(documentElement);
                a(nVar, documentElement);
                w.a(fileInputStream);
                return nVar;
            }
            x0.a("ConfigParser", "parse plugin config failed, checkValue not match");
            w.a(fileInputStream);
            return null;
        } catch (Throwable th6) {
            th = th6;
            w.a(fileInputStream);
            throw th;
        }
    }

    public static j[] b(Element element) {
        if (element == null) {
            return null;
        }
        try {
            NodeList elementsByTagName = element.getElementsByTagName("command");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("parseCommandList, size:");
            sb5.append(elementsByTagName != null ? elementsByTagName.getLength() : 0);
            x0.b("ConfigParser", sb5.toString());
            if (elementsByTagName != null && elementsByTagName.getLength() != 0) {
                j[] jVarArr = new j[elementsByTagName.getLength()];
                for (int i3 = 0; i3 < elementsByTagName.getLength(); i3++) {
                    j jVar = new j();
                    a(jVar, (Element) elementsByTagName.item(i3));
                    jVarArr[i3] = jVar;
                }
                return jVarArr;
            }
        } catch (Throwable th5) {
            x0.a("ConfigParser", "parseCommandList error", th5);
        }
        return null;
    }

    public static void a(k kVar, Element element) {
        NodeList elementsByTagName = element.getElementsByTagName("VersionInfo");
        if (elementsByTagName == null || elementsByTagName.getLength() == 0) {
            return;
        }
        kVar.f121702d = new p[elementsByTagName.getLength()];
        for (int i3 = 0; i3 < elementsByTagName.getLength(); i3++) {
            p pVar = new p();
            Element element2 = (Element) elementsByTagName.item(i3);
            pVar.f121648d = element2.getAttribute("fullurl");
            pVar.f121655k = element2.getAttribute("md5");
            a(pVar.f121647c, element2);
            pVar.f121654j = b(element2, "period");
            pVar.f121645a = b(element2, "version");
            pVar.f121656l = a(element2, "useCellular");
            pVar.f121658n = a(element2, "lowPriority");
            pVar.f121657m = a(element2, "useCdn");
            pVar.f121646b = b(element2, "versionId");
            pVar.f121651g = element2.getAttribute("updateSchedule");
            pVar.f121652h = element2.getAttribute("releaseDate");
            pVar.f121764v = element2.getAttribute("updateHourSpeed");
            pVar.f121659o = element2.getAttribute("UPDATE_SPEED_CONFIG");
            pVar.f121660p = element2.getAttribute("UPDATE_FORWARD_SPEED_CONFIG");
            pVar.f121661q = element2.getAttribute("UPDATE_SCHEDULE_TIME_RANGE_BIND");
            pVar.f121649e = a(element2, "updateStartTime", -1.0f);
            pVar.f121650f = a(element2, "updateEndTime", -1.0f);
            pVar.f121662r = a(element2, "forbidDownloadWhenNoUin");
            String attribute = element2.getAttribute("tryUseSharedCore");
            if (attribute != null && !attribute.isEmpty()) {
                pVar.f121762t = Boolean.parseBoolean(attribute);
            }
            pVar.f121763u = a(element2, "supportPredown");
            a(element2, pVar.f121761s);
            pVar.f121653i = a(element2);
            kVar.f121702d[i3] = pVar;
        }
    }

    public static int b(Element element, String str) {
        String attribute;
        if (element != null && (attribute = element.getAttribute(str)) != null && !attribute.isEmpty()) {
            try {
                return Integer.parseInt(attribute);
            } catch (Throwable th5) {
                x0.a("ConfigParser", "safeGetInt error", th5);
            }
        }
        return 0;
    }

    public static void a(n nVar, Element element) {
        NodeList elementsByTagName = element.getElementsByTagName("PluginInfo");
        if (elementsByTagName == null || elementsByTagName.getLength() == 0) {
            return;
        }
        nVar.f121746d = new o[elementsByTagName.getLength()];
        for (int i3 = 0; i3 < elementsByTagName.getLength(); i3++) {
            Element element2 = (Element) elementsByTagName.item(i3);
            o oVar = new o();
            oVar.f121755s = element2.getAttribute("name");
            oVar.f121645a = b(element2, "version");
            oVar.f121648d = element2.getAttribute("fullurl");
            oVar.f121655k = element2.getAttribute("md5");
            oVar.f121656l = a(element2, "useCellular");
            oVar.f121658n = a(element2, "lowPriority");
            oVar.f121657m = a(element2, "useCdn");
            oVar.f121654j = b(element2, "period");
            oVar.f121646b = b(element2, "versionId");
            oVar.f121651g = element2.getAttribute("updateSchedule");
            oVar.f121652h = element2.getAttribute("releaseDate");
            oVar.f121659o = element2.getAttribute("UPDATE_SPEED_CONFIG");
            oVar.f121660p = element2.getAttribute("UPDATE_FORWARD_SPEED_CONFIG");
            oVar.f121661q = element2.getAttribute("UPDATE_SCHEDULE_TIME_RANGE_BIND");
            oVar.f121649e = a(element2, "updateStartTime", -1.0f);
            oVar.f121650f = a(element2, "updateEndTime", -1.0f);
            a(oVar.f121647c, element2);
            oVar.f121653i = a(element2);
            nVar.f121746d[i3] = oVar;
        }
    }

    public static String a(File file, int i3, String str) {
        FileInputStream fileInputStream;
        byte[] bArr;
        try {
            bArr = new byte[i3];
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
        }
        try {
            int read = fileInputStream.read(bArr, 0, i3);
            if (read != i3) {
                return null;
            }
            String str2 = new String(bArr, 0, read);
            int indexOf = str2.indexOf(str);
            if (indexOf < 0) {
                return null;
            }
            byte[] digest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest(str2.substring(indexOf).getBytes());
            if (digest != null && digest.length != 0) {
                StringBuilder sb5 = new StringBuilder(digest.length);
                for (byte b16 : digest) {
                    String hexString = Integer.toHexString(b16 & 255);
                    if (hexString.length() == 1) {
                        sb5.append(0);
                    }
                    sb5.append(hexString);
                }
                return sb5.toString().toUpperCase();
            }
            return null;
        } catch (Throwable th6) {
            th = th6;
            try {
                x0.c("ConfigParser", "getConfigCheckValue error:" + th);
                return null;
            } finally {
                w.a(fileInputStream);
            }
        }
    }

    public static void a(Element element, q qVar) {
        NodeList elementsByTagName;
        if (qVar == null || (elementsByTagName = element.getElementsByTagName("Description")) == null || elementsByTagName.getLength() == 0) {
            return;
        }
        qVar.f121766a = ((Element) elementsByTagName.item(0)).getAttribute("versionStr");
    }

    public static m[] a(Element element) {
        NodeList elementsByTagName = element.getElementsByTagName("Patch");
        if (elementsByTagName == null || elementsByTagName.getLength() == 0) {
            return null;
        }
        m[] mVarArr = new m[elementsByTagName.getLength()];
        for (int i3 = 0; i3 < elementsByTagName.getLength(); i3++) {
            m mVar = new m();
            Element element2 = (Element) elementsByTagName.item(i3);
            mVar.f121737b = element2.getAttribute("url");
            mVar.f121736a = b(element2, "targetVersion");
            mVar.f121738c = element2.getAttribute("md5");
            mVar.f121739d = a(element2, "useCellular");
            mVar.f121740e = a(element2, "useCdn");
            if (element2.hasAttribute("patchType")) {
                if (element2.getAttribute("patchType").equals("1")) {
                    mVar.f121741f = 1;
                } else if (element2.getAttribute("patchType").equals("2")) {
                    mVar.f121741f = 2;
                } else {
                    x0.c("ConfigParser", "getPatches, error, unknown patchType");
                    return null;
                }
            } else {
                mVar.f121741f = 1;
            }
            mVarArr[i3] = mVar;
        }
        return mVarArr;
    }

    public static void a(j jVar, Element element) {
        jVar.f121670b = element.getAttribute("optype");
        jVar.f121671c = element.getAttribute("opvalue");
        jVar.f121672d = element.getAttribute("module");
        a(jVar.f121669a, element);
    }

    public static void a(l lVar, Element element) {
        lVar.f121710c = b(element, "apkMin");
        lVar.f121711d = b(element, "apkMax");
        lVar.f121712e = b(element, "preDownApkMin");
        lVar.f121713f = b(element, "preDownApkMax");
        lVar.f121708a = b(element, "sdkMin");
        lVar.f121709b = b(element, "sdkMax");
        lVar.f121714g = b(element, "apiMin");
        lVar.f121715h = b(element, "apiMax");
        lVar.f121716i = b(element, "targetApiMin");
        lVar.f121717j = b(element, "targetApiMax");
        lVar.f121718k = element.getAttribute("forbidDeviceRegex");
        lVar.f121719l = element.getAttribute("whiteDeviceRegex");
        lVar.f121729v = element.getAttribute("forbidAppRegex");
        lVar.f121730w = element.getAttribute("whiteAppRegex");
        lVar.f121720m = b(element, "grayMin");
        lVar.f121721n = b(element, "grayMax");
        lVar.f121722o = b(element, "dayGrayMin");
        lVar.f121723p = b(element, "dayGrayMax");
        lVar.f121724q = b(element, "chromeMin");
        lVar.f121725r = b(element, "chromeMax");
        lVar.f121726s = b(element, "usertype");
        lVar.f121731x = b(element, "x5sdkmin");
        lVar.f121732y = b(element, "x5sdkmax");
        lVar.f121733z = b(element, "x5coremin");
        lVar.A = b(element, "x5coremax");
        lVar.f121727t = a(element, "hoursStart", -1.0d);
        lVar.f121728u = a(element, "hoursEnd", -1.0d);
        lVar.C = element.getAttribute("runtimeAbis");
        lVar.E = element.getAttribute("blackRuntimeAbis");
        lVar.B = element.getAttribute("deviceAbis");
        lVar.D = element.getAttribute("blackDeviceAbis");
        lVar.F = c(element, "appClientVerMin");
        lVar.G = c(element, "appClientVerMax");
        lVar.H = element.getAttribute("appInfoWhiteList");
        lVar.I = element.getAttribute("appInfoBlackList");
    }

    public static double a(Element element, String str, double d16) {
        String attribute;
        if (element != null && (attribute = element.getAttribute(str)) != null && !attribute.isEmpty()) {
            try {
                return Double.parseDouble(attribute);
            } catch (Throwable th5) {
                x0.a("ConfigParser", "safeGetDouble error", th5);
            }
        }
        return d16;
    }

    public static float a(Element element, String str, float f16) {
        String attribute;
        if (element != null && (attribute = element.getAttribute(str)) != null && !attribute.isEmpty()) {
            try {
                return Float.parseFloat(attribute);
            } catch (Throwable th5) {
                x0.a("ConfigParser", "safeGetFloat error", th5);
            }
        }
        return f16;
    }

    public static boolean a(Element element, String str) {
        String attribute;
        if (element != null && (attribute = element.getAttribute(str)) != null && !attribute.isEmpty()) {
            try {
                return Boolean.parseBoolean(attribute);
            } catch (Throwable th5) {
                x0.a("ConfigParser", "safeGetBoolean error", th5);
            }
        }
        return false;
    }
}
