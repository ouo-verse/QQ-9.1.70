package com.tencent.mobileqq.config;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.config.g;
import com.tencent.mobileqq.config.struct.PicAndAdConf;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* compiled from: P */
/* loaded from: classes10.dex */
public class h {
    private static void a(PicAndAdConf picAndAdConf, byte[] bArr) {
        if (QLog.isColorLevel()) {
            QLog.d("ShanPing", 2, "config-huibao--decode---confighParse--buildItem_FlashLogo = ");
        }
        picAndAdConf.f202973f = PkgTools.getLongData(bArr, 0);
        picAndAdConf.f202974h = PkgTools.getLongData(bArr, 4) * 1000;
        picAndAdConf.f202975i = PkgTools.getLongData(bArr, 8) * 1000;
        byte b16 = bArr[12];
        int i3 = 13;
        int i16 = 0;
        while (i16 < b16) {
            long longData = PkgTools.getLongData(bArr, i3);
            int i17 = i3 + 4;
            byte b17 = bArr[i17];
            int i18 = i17 + 1 + 1;
            short shortData = PkgTools.getShortData(bArr, i18);
            int i19 = i18 + 2;
            String uTFString = PkgTools.getUTFString(bArr, i19, shortData);
            int i26 = i19 + shortData;
            short shortData2 = PkgTools.getShortData(bArr, i26);
            int i27 = i26 + 2;
            String uTFString2 = PkgTools.getUTFString(bArr, i27, shortData2);
            int i28 = i27 + shortData2;
            if (b17 == 1) {
                if (QLog.isColorLevel()) {
                    QLog.d("ShanPing", 2, "flashlogo desc= " + uTFString + " src addr = " + uTFString2);
                }
                String s16 = picAndAdConf.s(uTFString, (byte) 3);
                picAndAdConf.C(s16);
                picAndAdConf.a(picAndAdConf.x(longData, uTFString, s16, null, ""));
            }
            i16++;
            i3 = i28;
        }
    }

    private static void b(PicAndAdConf picAndAdConf, byte[] bArr, String str) {
        picAndAdConf.f202973f = PkgTools.getLongData(bArr, 0);
        picAndAdConf.f202974h = PkgTools.getLongData(bArr, 4) * 1000;
        picAndAdConf.f202975i = PkgTools.getLongData(bArr, 8) * 1000;
        byte b16 = bArr[12];
        if (b16 > 0) {
            picAndAdConf.k();
            BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit().putBoolean(AppConstants.Preferences.PUSH_BANNER_DISPLAY + str, true).commit();
        }
        int i3 = 13;
        int i16 = 0;
        while (i16 < b16) {
            long longData = PkgTools.getLongData(bArr, i3);
            int i17 = i3 + 4;
            byte b17 = bArr[i17];
            int i18 = i17 + 1 + 1;
            long longData2 = PkgTools.getLongData(bArr, i18);
            int i19 = i18 + 4;
            short shortData = PkgTools.getShortData(bArr, i19);
            int i26 = i19 + 2;
            short shortData2 = PkgTools.getShortData(bArr, i26);
            int i27 = i26 + 2;
            String uTFString = PkgTools.getUTFString(bArr, i27, shortData2);
            int i28 = i27 + shortData2;
            short shortData3 = PkgTools.getShortData(bArr, i28);
            int i29 = i28 + 2;
            String uTFString2 = PkgTools.getUTFString(bArr, i29, shortData3);
            int i36 = i29 + shortData3;
            short shortData4 = PkgTools.getShortData(bArr, i36);
            int i37 = i36 + 2;
            String uTFString3 = PkgTools.getUTFString(bArr, i37, shortData4);
            int i38 = i37 + shortData4;
            if (b17 == 1) {
                String s16 = picAndAdConf.s(uTFString2, (byte) 3);
                if (!e(String.valueOf(longData))) {
                    picAndAdConf.C(s16);
                }
                picAndAdConf.a(picAndAdConf.w(longData, uTFString, s16, uTFString3, BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/ADPic/" + longData, "" + longData2, shortData));
            }
            i16++;
            i3 = i38;
        }
    }

    private static void c(g.a aVar, byte[] bArr) {
        short shortData = PkgTools.getShortData(bArr, 0);
        aVar.f202878a = PkgTools.getUTFString(bArr, 2, shortData);
        int i3 = shortData + 2;
        aVar.f202879b = bArr[i3];
        int i16 = i3 + 1;
        aVar.f202880c = bArr[i16];
        int i17 = i16 + 1;
        aVar.f202881d = PkgTools.getUTFString(bArr, i17 + 2, PkgTools.getShortData(bArr, i17));
    }

    private static byte[] d() {
        String substring = MD5.toMD5(e.l() + AppSetting.i() + "E1D84CC825147ECD").substring(0, 16);
        try {
            return substring.getBytes("ISO8859_1");
        } catch (UnsupportedEncodingException unused) {
            return substring.getBytes();
        }
    }

    public static boolean e(String str) {
        return new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/ADPic/" + str).exists();
    }

    public static boolean f(byte[] bArr, i iVar, String str) {
        if (bArr != null && bArr.length != 0) {
            g(bArr, iVar);
            if (iVar.f202888f != 768) {
                return false;
            }
            if (iVar.f202884b != 0) {
                i(iVar);
                return false;
            }
            byte[] bArr2 = iVar.f202886d;
            if (bArr2 != null && bArr2.length != 0) {
                j(iVar, str);
                return true;
            }
        }
        return false;
    }

    private static void g(byte[] bArr, i iVar) {
        if (bArr == null || bArr.length <= 11 || bArr[0] != 2) {
            return;
        }
        iVar.f202888f = PkgTools.getShortData(bArr, 1);
        iVar.f202883a = PkgTools.getShortData(bArr, 3);
        iVar.f202885c = PkgTools.getLongData(bArr, 5) * 1000;
        byte b16 = bArr[9];
        iVar.f202884b = b16;
        int length = (bArr.length - 10) - 1;
        if (b16 == 0) {
            byte[] bArr2 = new byte[length];
            iVar.f202886d = bArr2;
            PkgTools.getBytesData(bArr, 10, bArr2, length);
            return;
        }
        iVar.f202887e = PkgTools.getUTFString(bArr, 10, length);
    }

    private static void h(int i3, byte[] bArr, String str) {
        byte[] decrypt = new Cryptor().decrypt(bArr, d());
        if (i3 != 4) {
            if (i3 != 12) {
                if (i3 == 24) {
                    e.f202867e.g();
                    e.f202867e.j(false);
                    b(e.f202867e, decrypt, str);
                    return;
                }
                return;
            }
            e.f202868f.g();
            e.f202868f.j(false);
            a(e.f202868f, decrypt);
            return;
        }
        g e16 = e.e();
        if (e16 != null) {
            c(e16.f202873e, decrypt);
        }
    }

    private static void j(i iVar, String str) {
        short shortData = PkgTools.getShortData(iVar.f202886d, 0);
        if (QLog.isColorLevel()) {
            QLog.d("ShanPing", 2, "config-huibao--decode---confighParse--itemNum = " + ((int) shortData));
        }
        int i3 = 2;
        for (int i16 = 0; i16 < shortData; i16++) {
            short shortData2 = PkgTools.getShortData(iVar.f202886d, i3);
            int i17 = i3 + 2;
            int shortData3 = PkgTools.getShortData(iVar.f202886d, i17);
            int i18 = i17 + 2;
            byte[] bArr = new byte[shortData3];
            PkgTools.getBytesData(iVar.f202886d, i18, bArr, shortData3);
            i3 = i18 + shortData3;
            h(shortData2, bArr, str);
        }
        g e16 = e.e();
        if (e16 != null) {
            e16.i();
        }
    }

    private static void k(HashMap<String, String> hashMap, NodeList nodeList) {
        if (nodeList != null && nodeList.getLength() != 0) {
            for (int i3 = 0; i3 < nodeList.getLength(); i3++) {
                Node item = nodeList.item(i3);
                if (item instanceof Element) {
                    if (item.hasChildNodes()) {
                        k(hashMap, item.getChildNodes());
                    }
                } else if (item.getParentNode() != null) {
                    hashMap.put(item.getParentNode().getNodeName(), item.getNodeValue());
                }
            }
        }
    }

    public static HashMap<String, String> l(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            k(hashMap, DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>" + str).getBytes())).getDocumentElement().getChildNodes());
            return hashMap;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private static void i(i iVar) {
    }
}
