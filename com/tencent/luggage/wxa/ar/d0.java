package com.tencent.luggage.wxa.ar;

import com.tencent.rdelivery.reshub.FileSuffix;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d0 {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.Closeable, java.io.BufferedReader] */
    public static ArrayList a(int i3) {
        Throwable th5;
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        ?? r36;
        int i16;
        try {
            fileInputStream = new FileInputStream(new File(u0.l(i3)));
        } catch (Throwable th6) {
            th5 = th6;
            fileInputStream = null;
            inputStreamReader = null;
        }
        try {
            inputStreamReader = new InputStreamReader(fileInputStream);
            try {
                r36 = new BufferedReader(inputStreamReader);
            } catch (Throwable th7) {
                th5 = th7;
                r36 = 0;
            }
            try {
                ArrayList arrayList = new ArrayList();
                while (true) {
                    String readLine = r36.readLine();
                    if (readLine == null) {
                        return arrayList;
                    }
                    if (!readLine.isEmpty()) {
                        if (readLine.startsWith("ADD:")) {
                            readLine = readLine.substring(4);
                            i16 = 1;
                        } else if (readLine.startsWith("MOD:")) {
                            readLine = readLine.substring(4);
                            i16 = 2;
                        } else if (readLine.startsWith("DEL:")) {
                            readLine = readLine.substring(4);
                            i16 = 3;
                        } else {
                            i16 = 0;
                        }
                        for (String str : readLine.split(",")) {
                            if (str != null && !str.isEmpty()) {
                                c0 c0Var = new c0();
                                c0Var.f121626e = str;
                                c0Var.f121622a = i16;
                                if (i16 == 2) {
                                    c0Var.f121623b = c0Var.f121626e + FileSuffix.PATCH_FILE;
                                }
                                if (i16 == 2 && c0Var.f121626e.equals("base.apk")) {
                                    c0Var.f121625d = 1;
                                } else {
                                    c0Var.f121625d = 2;
                                }
                                x0.b("PatchFileConfigParser", "getPatchFileConfigList config:" + c0Var);
                                arrayList.add(c0Var);
                            }
                        }
                    }
                }
            } catch (Throwable th8) {
                th5 = th8;
                try {
                    x0.a("PatchFileConfigParser", "getPatchFileConfigList error", th5);
                    return null;
                } finally {
                    w.a(fileInputStream);
                    w.a(inputStreamReader);
                    w.a((Closeable) r36);
                }
            }
        } catch (Throwable th9) {
            th5 = th9;
            inputStreamReader = null;
            r36 = inputStreamReader;
            x0.a("PatchFileConfigParser", "getPatchFileConfigList error", th5);
            return null;
        }
    }

    public static ArrayList b(int i3) {
        Throwable th5;
        FileInputStream fileInputStream;
        int i16;
        try {
            fileInputStream = new FileInputStream(new File(u0.n(i3)));
        } catch (Throwable th6) {
            th5 = th6;
            fileInputStream = null;
        }
        try {
            Element documentElement = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(fileInputStream).getDocumentElement();
            if (documentElement == null) {
                x0.a("PatchFileConfigParser", "parse xml failed, patch.xml is corrupted");
                return null;
            }
            NodeList elementsByTagName = documentElement.getElementsByTagName("file");
            if (elementsByTagName == null || elementsByTagName.getLength() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i17 = 0; i17 < elementsByTagName.getLength(); i17++) {
                c0 c0Var = new c0();
                Element element = (Element) elementsByTagName.item(i17);
                if (element.getAttribute("algorithm").equals("bsdiff")) {
                    c0Var.f121627f = 1;
                } else if (element.getAttribute("algorithm").equals("hdiff")) {
                    c0Var.f121627f = 2;
                }
                if (element.getAttribute("type").equals("add")) {
                    i16 = 1;
                } else if (element.getAttribute("type").equals("mod")) {
                    i16 = 2;
                } else if (element.getAttribute("type").equals("del")) {
                    i16 = 3;
                } else {
                    i16 = 0;
                }
                c0Var.f121622a = i16;
                c0Var.f121626e = element.getAttribute("originalFileName");
                if (i16 == 2) {
                    c0Var.f121623b = c0Var.f121626e + FileSuffix.PATCH_FILE;
                }
                if (i16 == 2 && c0Var.f121626e.equals("base.apk")) {
                    c0Var.f121625d = 1;
                } else {
                    c0Var.f121625d = 2;
                }
                x0.b("PatchFileConfigParser", "getPatchXmlConfigList config:" + c0Var);
                arrayList.add(c0Var);
            }
            return arrayList;
        } catch (Throwable th7) {
            th5 = th7;
            try {
                x0.a("PatchFileConfigParser", "getPatchXmlConfigList error", th5);
                return null;
            } finally {
                w.a(fileInputStream);
            }
        }
    }

    public static ArrayList a(int i3, int i16) {
        if (i16 == 1) {
            return a(i3);
        }
        if (i16 == 2) {
            return b(i3);
        }
        x0.c("PatchFileConfigParser", "getPatchList, error, unknown patchType");
        return null;
    }
}
