package com.tencent.mobileqq.ocr.api.impl;

import android.graphics.Point;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.gallery.picocr.b;
import com.tencent.mobileqq.gallery.picocr.c;
import com.tencent.mobileqq.ocr.api.IPicOcrService;
import com.tencent.mobileqq.ocr.req.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
import tencent.im.cs.cmd0xe07.cmd0xe07$Coordinate;
import tencent.im.cs.cmd0xe07.cmd0xe07$Language;
import tencent.im.cs.cmd0xe07.cmd0xe07$OCRReqBody;
import tencent.im.cs.cmd0xe07.cmd0xe07$OCRRspBody;
import tencent.im.cs.cmd0xe07.cmd0xe07$ReqBody;
import tencent.im.cs.cmd0xe07.cmd0xe07$RspBody;
import tencent.im.cs.cmd0xe07.cmd0xe07$TextDetection;

/* loaded from: classes16.dex */
public class PicOcrHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final String f254691d;

    /* renamed from: e, reason: collision with root package name */
    public static String f254692e;

    /* renamed from: f, reason: collision with root package name */
    private static Map f254693f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18946);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        f254691d = PicOcrHandler.class.getName();
        f254692e = "OidbSvc.0xe07_0";
        HashMap hashMap = new HashMap();
        f254693f = hashMap;
        hashMap.put(0, 0);
        f254693f.put(1, 1);
        f254693f.put(-1001, 0);
        f254693f.put(-1002, 1);
        f254693f.put(-1003, 2);
        f254693f.put(-1004, 3);
        f254693f.put(-1005, 4);
        f254693f.put(-1006, 5);
        f254693f.put(-1007, 6);
        f254693f.put(-1008, 7);
        f254693f.put(-1009, 10);
    }

    public PicOcrHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    private static int getEntranceType(int i3) {
        if (f254693f.containsKey(Integer.valueOf(i3))) {
            return ((Integer) f254693f.get(Integer.valueOf(i3))).intValue();
        }
        return 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0484  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x04d7  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x04db  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x04c7  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x047c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void D2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        ArrayList arrayList;
        c cVar;
        String str;
        String str2;
        int i3;
        int i16;
        int i17;
        Exception exc;
        String str3;
        String str4;
        String str5;
        int i18;
        int i19;
        String str6;
        int i26;
        String str7;
        String str8;
        boolean z17;
        boolean z18;
        String str9;
        int i27;
        int i28;
        int i29;
        int i36;
        int i37;
        int i38;
        BusinessHandler businessHandler;
        c cVar2;
        String str10;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg != null && fromServiceMsg.isSuccess()) {
            z16 = true;
        } else {
            z16 = false;
        }
        long longValue = ((Long) toServiceMsg.getAttribute("key_ocr_seq", 0L)).longValue();
        String str11 = (String) toServiceMsg.getAttribute("key_ocr_md5", "");
        String str12 = (String) toServiceMsg.getAttribute("key_ocr_url", "");
        int intValue = ((Integer) toServiceMsg.getAttribute("key_ocr_size", 0)).intValue();
        int intValue2 = ((Integer) toServiceMsg.getAttribute("key_ocr_width", 0)).intValue();
        int intValue3 = ((Integer) toServiceMsg.getAttribute("key_ocr_height", 0)).intValue();
        String str13 = (String) toServiceMsg.getAttribute("key_ocr_afmd5", "");
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        c cVar3 = new c();
        HashMap<String, String> hashMap = new HashMap<>();
        String str14 = null;
        int i39 = -1;
        if (z16) {
            try {
                cmd0xe07$RspBody cmd0xe07_rspbody = new cmd0xe07$RspBody();
                int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, cmd0xe07_rspbody);
                try {
                    str4 = cmd0xe07_rspbody.errMsg.get();
                    try {
                        str5 = cmd0xe07_rspbody.wording.get();
                        if (parseOIDBPkg == 0) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (z18) {
                            try {
                                if (cmd0xe07_rspbody.ocrRspBody.has()) {
                                    cmd0xe07$OCRRspBody cmd0xe07_ocrrspbody = cmd0xe07_rspbody.ocrRspBody.get();
                                    if (!cmd0xe07_ocrrspbody.requestId.has()) {
                                        str9 = "";
                                    } else {
                                        try {
                                            str9 = cmd0xe07_ocrrspbody.requestId.get();
                                        } catch (Exception e16) {
                                            arrayList = arrayList3;
                                            cVar = cVar3;
                                            str = str11;
                                            i18 = parseOIDBPkg;
                                            str2 = str12;
                                            i3 = intValue;
                                            i16 = intValue2;
                                            i17 = intValue3;
                                            i19 = -1;
                                            exc = e16;
                                            str3 = null;
                                            if (QLog.isColorLevel()) {
                                            }
                                            str6 = str14;
                                            i26 = i39;
                                            str7 = str4;
                                            str8 = str5;
                                            z17 = false;
                                            if (QLog.isColorLevel()) {
                                            }
                                            if (z17) {
                                            }
                                            businessHandler.notifyUI(100, z17, cVar2);
                                            HashMap<String, String> hashMap2 = new HashMap<>();
                                            if (z17) {
                                            }
                                            hashMap2.put("param_result", str10);
                                            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actPicOcrResult", true, 0L, 0L, hashMap2, "");
                                        }
                                    }
                                    try {
                                        if (!cmd0xe07_ocrrspbody.language.has()) {
                                            str14 = "";
                                        } else {
                                            try {
                                                str14 = cmd0xe07_ocrrspbody.language.get();
                                            } catch (Exception e17) {
                                                e = e17;
                                                arrayList = arrayList3;
                                                cVar = cVar3;
                                                str = str11;
                                                i18 = parseOIDBPkg;
                                                str2 = str12;
                                                i3 = intValue;
                                                i16 = intValue2;
                                                i17 = intValue3;
                                                i19 = -1;
                                                exc = e;
                                                str3 = str9;
                                                if (QLog.isColorLevel()) {
                                                }
                                                str6 = str14;
                                                i26 = i39;
                                                str7 = str4;
                                                str8 = str5;
                                                z17 = false;
                                                if (QLog.isColorLevel()) {
                                                }
                                                if (z17) {
                                                }
                                                businessHandler.notifyUI(100, z17, cVar2);
                                                HashMap<String, String> hashMap22 = new HashMap<>();
                                                if (z17) {
                                                }
                                                hashMap22.put("param_result", str10);
                                                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actPicOcrResult", true, 0L, 0L, hashMap22, "");
                                            }
                                        }
                                        if (cmd0xe07_ocrrspbody.ocrLanguageList.has()) {
                                            arrayList3.addAll(cmd0xe07_ocrrspbody.ocrLanguageList.get());
                                        }
                                        if (cmd0xe07_ocrrspbody.afterCompressWeight.has()) {
                                            i28 = cmd0xe07_ocrrspbody.afterCompressWeight.get();
                                            i27 = parseOIDBPkg;
                                        } else {
                                            i27 = parseOIDBPkg;
                                            i28 = -1;
                                        }
                                        try {
                                            if (cmd0xe07_ocrrspbody.afterCompressHeight.has()) {
                                                try {
                                                    i19 = cmd0xe07_ocrrspbody.afterCompressHeight.get();
                                                    str2 = str12;
                                                } catch (Exception e18) {
                                                    e = e18;
                                                    arrayList = arrayList3;
                                                    cVar = cVar3;
                                                    str = str11;
                                                    str2 = str12;
                                                    i3 = intValue;
                                                    i16 = intValue2;
                                                    i17 = intValue3;
                                                    i19 = -1;
                                                    i18 = i27;
                                                    exc = e;
                                                    i39 = i28;
                                                    str3 = str9;
                                                    if (QLog.isColorLevel()) {
                                                        QLog.e("PicOcrHandler", 2, "handleRequestPicOcrRsp seq:" + longValue + ", exp:", exc);
                                                    }
                                                    str6 = str14;
                                                    i26 = i39;
                                                    str7 = str4;
                                                    str8 = str5;
                                                    z17 = false;
                                                    if (QLog.isColorLevel()) {
                                                    }
                                                    if (z17) {
                                                    }
                                                    businessHandler.notifyUI(100, z17, cVar2);
                                                    HashMap<String, String> hashMap222 = new HashMap<>();
                                                    if (z17) {
                                                    }
                                                    hashMap222.put("param_result", str10);
                                                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actPicOcrResult", true, 0L, 0L, hashMap222, "");
                                                }
                                            } else {
                                                str2 = str12;
                                                i19 = -1;
                                            }
                                            try {
                                                if (cmd0xe07_ocrrspbody.languageList.has()) {
                                                    try {
                                                        List<cmd0xe07$Language> list = cmd0xe07_ocrrspbody.languageList.get();
                                                        if (list != null) {
                                                            Iterator<cmd0xe07$Language> it = list.iterator();
                                                            while (it.hasNext()) {
                                                                Iterator<cmd0xe07$Language> it5 = it;
                                                                cmd0xe07$Language next = it.next();
                                                                arrayList = arrayList3;
                                                                try {
                                                                    String str15 = next.language.get();
                                                                    String str16 = next.languageDesc.get();
                                                                    if (!TextUtils.isEmpty(str15)) {
                                                                        hashMap.put(str15, str16);
                                                                    }
                                                                    arrayList3 = arrayList;
                                                                    it = it5;
                                                                } catch (Exception e19) {
                                                                    e = e19;
                                                                    i18 = i27;
                                                                    cVar = cVar3;
                                                                    i39 = i28;
                                                                    str = str11;
                                                                    i3 = intValue;
                                                                    i16 = intValue2;
                                                                    i17 = intValue3;
                                                                    exc = e;
                                                                    str3 = str9;
                                                                    if (QLog.isColorLevel()) {
                                                                    }
                                                                    str6 = str14;
                                                                    i26 = i39;
                                                                    str7 = str4;
                                                                    str8 = str5;
                                                                    z17 = false;
                                                                    if (QLog.isColorLevel()) {
                                                                    }
                                                                    if (z17) {
                                                                    }
                                                                    businessHandler.notifyUI(100, z17, cVar2);
                                                                    HashMap<String, String> hashMap2222 = new HashMap<>();
                                                                    if (z17) {
                                                                    }
                                                                    hashMap2222.put("param_result", str10);
                                                                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actPicOcrResult", true, 0L, 0L, hashMap2222, "");
                                                                }
                                                            }
                                                        }
                                                    } catch (Exception e26) {
                                                        e = e26;
                                                        arrayList = arrayList3;
                                                    }
                                                }
                                                arrayList = arrayList3;
                                                try {
                                                    if (cmd0xe07_ocrrspbody.textDetections.has()) {
                                                        Iterator<cmd0xe07$TextDetection> it6 = cmd0xe07_ocrrspbody.textDetections.get().iterator();
                                                        while (it6.hasNext()) {
                                                            cmd0xe07$TextDetection next2 = it6.next();
                                                            b bVar = new b();
                                                            Iterator<cmd0xe07$TextDetection> it7 = it6;
                                                            String str17 = next2.detectedText.get();
                                                            cVar = cVar3;
                                                            try {
                                                                int i46 = next2.confidence.get();
                                                                str = str11;
                                                                try {
                                                                    ArrayList<Point> arrayList4 = new ArrayList<>();
                                                                    i17 = intValue3;
                                                                    try {
                                                                        Iterator<cmd0xe07$Coordinate> it8 = next2.polygon.get().coordinates.get().iterator();
                                                                        while (it8.hasNext()) {
                                                                            Iterator<cmd0xe07$Coordinate> it9 = it8;
                                                                            cmd0xe07$Coordinate next3 = it8.next();
                                                                            i16 = intValue2;
                                                                            try {
                                                                                i3 = intValue;
                                                                            } catch (Exception e27) {
                                                                                e = e27;
                                                                                i3 = intValue;
                                                                            }
                                                                            try {
                                                                                arrayList4.add(new Point(next3.X.get(), next3.Y.get()));
                                                                                intValue2 = i16;
                                                                                it8 = it9;
                                                                                intValue = i3;
                                                                            } catch (Exception e28) {
                                                                                e = e28;
                                                                                i18 = i27;
                                                                                exc = e;
                                                                                i39 = i28;
                                                                                str3 = str9;
                                                                                if (QLog.isColorLevel()) {
                                                                                }
                                                                                str6 = str14;
                                                                                i26 = i39;
                                                                                str7 = str4;
                                                                                str8 = str5;
                                                                                z17 = false;
                                                                                if (QLog.isColorLevel()) {
                                                                                }
                                                                                if (z17) {
                                                                                }
                                                                                businessHandler.notifyUI(100, z17, cVar2);
                                                                                HashMap<String, String> hashMap22222 = new HashMap<>();
                                                                                if (z17) {
                                                                                }
                                                                                hashMap22222.put("param_result", str10);
                                                                                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actPicOcrResult", true, 0L, 0L, hashMap22222, "");
                                                                            }
                                                                        }
                                                                        int i47 = intValue;
                                                                        int i48 = intValue2;
                                                                        if (next2.advancedInfo.has()) {
                                                                            String str18 = next2.advancedInfo.get();
                                                                            if (!TextUtils.isEmpty(str18)) {
                                                                                i29 = new JSONObject(new JSONObject(str18).optString("Parag")).optInt("ParagNo");
                                                                                bVar.f211807a = str17;
                                                                                bVar.f211808b = i46;
                                                                                bVar.f211809c = arrayList4;
                                                                                bVar.f211810d = i29;
                                                                                bVar.f211811e = i28;
                                                                                bVar.f211812f = i19;
                                                                                arrayList2.add(bVar);
                                                                                it6 = it7;
                                                                                cVar3 = cVar;
                                                                                str11 = str;
                                                                                intValue3 = i17;
                                                                                intValue2 = i48;
                                                                                intValue = i47;
                                                                            }
                                                                        }
                                                                        i29 = -1;
                                                                        bVar.f211807a = str17;
                                                                        bVar.f211808b = i46;
                                                                        bVar.f211809c = arrayList4;
                                                                        bVar.f211810d = i29;
                                                                        bVar.f211811e = i28;
                                                                        bVar.f211812f = i19;
                                                                        arrayList2.add(bVar);
                                                                        it6 = it7;
                                                                        cVar3 = cVar;
                                                                        str11 = str;
                                                                        intValue3 = i17;
                                                                        intValue2 = i48;
                                                                        intValue = i47;
                                                                    } catch (Exception e29) {
                                                                        e = e29;
                                                                        i3 = intValue;
                                                                        i16 = intValue2;
                                                                    }
                                                                } catch (Exception e36) {
                                                                    e = e36;
                                                                    i3 = intValue;
                                                                    i16 = intValue2;
                                                                    i17 = intValue3;
                                                                    i18 = i27;
                                                                    exc = e;
                                                                    i39 = i28;
                                                                    str3 = str9;
                                                                    if (QLog.isColorLevel()) {
                                                                    }
                                                                    str6 = str14;
                                                                    i26 = i39;
                                                                    str7 = str4;
                                                                    str8 = str5;
                                                                    z17 = false;
                                                                    if (QLog.isColorLevel()) {
                                                                    }
                                                                    if (z17) {
                                                                    }
                                                                    businessHandler.notifyUI(100, z17, cVar2);
                                                                    HashMap<String, String> hashMap222222 = new HashMap<>();
                                                                    if (z17) {
                                                                    }
                                                                    hashMap222222.put("param_result", str10);
                                                                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actPicOcrResult", true, 0L, 0L, hashMap222222, "");
                                                                }
                                                            } catch (Exception e37) {
                                                                e = e37;
                                                                str = str11;
                                                                i3 = intValue;
                                                                i16 = intValue2;
                                                                i17 = intValue3;
                                                                i18 = i27;
                                                                exc = e;
                                                                i39 = i28;
                                                                str3 = str9;
                                                                if (QLog.isColorLevel()) {
                                                                }
                                                                str6 = str14;
                                                                i26 = i39;
                                                                str7 = str4;
                                                                str8 = str5;
                                                                z17 = false;
                                                                if (QLog.isColorLevel()) {
                                                                }
                                                                if (z17) {
                                                                }
                                                                businessHandler.notifyUI(100, z17, cVar2);
                                                                HashMap<String, String> hashMap2222222 = new HashMap<>();
                                                                if (z17) {
                                                                }
                                                                hashMap2222222.put("param_result", str10);
                                                                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actPicOcrResult", true, 0L, 0L, hashMap2222222, "");
                                                            }
                                                        }
                                                    }
                                                    cVar = cVar3;
                                                    str = str11;
                                                    i3 = intValue;
                                                    i16 = intValue2;
                                                    i17 = intValue3;
                                                    str3 = str9;
                                                    i18 = i27;
                                                    i39 = i28;
                                                    z17 = z18;
                                                } catch (Exception e38) {
                                                    e = e38;
                                                    cVar = cVar3;
                                                    str = str11;
                                                    i3 = intValue;
                                                    i16 = intValue2;
                                                    i17 = intValue3;
                                                    i18 = i27;
                                                    exc = e;
                                                    i39 = i28;
                                                    str3 = str9;
                                                    if (QLog.isColorLevel()) {
                                                    }
                                                    str6 = str14;
                                                    i26 = i39;
                                                    str7 = str4;
                                                    str8 = str5;
                                                    z17 = false;
                                                    if (QLog.isColorLevel()) {
                                                    }
                                                    if (z17) {
                                                    }
                                                    businessHandler.notifyUI(100, z17, cVar2);
                                                    HashMap<String, String> hashMap22222222 = new HashMap<>();
                                                    if (z17) {
                                                    }
                                                    hashMap22222222.put("param_result", str10);
                                                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actPicOcrResult", true, 0L, 0L, hashMap22222222, "");
                                                }
                                            } catch (Exception e39) {
                                                e = e39;
                                                arrayList = arrayList3;
                                            }
                                        } catch (Exception e46) {
                                            arrayList = arrayList3;
                                            cVar = cVar3;
                                            str = str11;
                                            str2 = str12;
                                            i3 = intValue;
                                            i16 = intValue2;
                                            i17 = intValue3;
                                            i18 = i27;
                                            exc = e46;
                                            i19 = -1;
                                            str3 = str9;
                                            i39 = i28;
                                            if (QLog.isColorLevel()) {
                                            }
                                            str6 = str14;
                                            i26 = i39;
                                            str7 = str4;
                                            str8 = str5;
                                            z17 = false;
                                            if (QLog.isColorLevel()) {
                                            }
                                            if (z17) {
                                            }
                                            businessHandler.notifyUI(100, z17, cVar2);
                                            HashMap<String, String> hashMap222222222 = new HashMap<>();
                                            if (z17) {
                                            }
                                            hashMap222222222.put("param_result", str10);
                                            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actPicOcrResult", true, 0L, 0L, hashMap222222222, "");
                                        }
                                    } catch (Exception e47) {
                                        arrayList = arrayList3;
                                        cVar = cVar3;
                                        str = str11;
                                        str2 = str12;
                                        i3 = intValue;
                                        i16 = intValue2;
                                        i17 = intValue3;
                                        i18 = parseOIDBPkg;
                                        exc = e47;
                                        i19 = -1;
                                    }
                                }
                            } catch (Exception e48) {
                                arrayList = arrayList3;
                                cVar = cVar3;
                                str = str11;
                                str2 = str12;
                                i3 = intValue;
                                i16 = intValue2;
                                i17 = intValue3;
                                i18 = parseOIDBPkg;
                                exc = e48;
                                str3 = null;
                                i19 = -1;
                                if (QLog.isColorLevel()) {
                                }
                                str6 = str14;
                                i26 = i39;
                                str7 = str4;
                                str8 = str5;
                                z17 = false;
                                if (QLog.isColorLevel()) {
                                }
                                if (z17) {
                                }
                                businessHandler.notifyUI(100, z17, cVar2);
                                HashMap<String, String> hashMap2222222222 = new HashMap<>();
                                if (z17) {
                                }
                                hashMap2222222222.put("param_result", str10);
                                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actPicOcrResult", true, 0L, 0L, hashMap2222222222, "");
                            }
                        }
                        arrayList = arrayList3;
                        cVar = cVar3;
                        str = str11;
                        str2 = str12;
                        i3 = intValue;
                        i16 = intValue2;
                        i17 = intValue3;
                        i18 = parseOIDBPkg;
                        str3 = null;
                        i19 = -1;
                        z17 = z18;
                    } catch (Exception e49) {
                        arrayList = arrayList3;
                        cVar = cVar3;
                        str = str11;
                        str2 = str12;
                        i3 = intValue;
                        i16 = intValue2;
                        i17 = intValue3;
                        i18 = parseOIDBPkg;
                        exc = e49;
                        str3 = null;
                        str5 = null;
                    }
                } catch (Exception e56) {
                    arrayList = arrayList3;
                    cVar = cVar3;
                    str = str11;
                    str2 = str12;
                    i3 = intValue;
                    i16 = intValue2;
                    i17 = intValue3;
                    i18 = parseOIDBPkg;
                    exc = e56;
                    str3 = null;
                    str4 = null;
                    str5 = null;
                }
            } catch (Exception e57) {
                arrayList = arrayList3;
                cVar = cVar3;
                str = str11;
                str2 = str12;
                i3 = intValue;
                i16 = intValue2;
                i17 = intValue3;
                exc = e57;
                str3 = null;
                str4 = null;
                str5 = null;
                i18 = -1;
                i19 = -1;
            }
        } else {
            arrayList = arrayList3;
            cVar = cVar3;
            str = str11;
            str2 = str12;
            i3 = intValue;
            i16 = intValue2;
            i17 = intValue3;
            z17 = z16;
            str3 = null;
            str4 = null;
            str5 = null;
            i18 = -1;
            i19 = -1;
        }
        str6 = str14;
        i26 = i39;
        str7 = str4;
        str8 = str5;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("handleRequestPicOcrRsp seq:");
            sb5.append(longValue);
            sb5.append(", succ:");
            sb5.append(z17);
            sb5.append(",result:");
            sb5.append(i18);
            sb5.append(", requestId:");
            sb5.append(str3);
            sb5.append(", errMsg:");
            sb5.append(str7);
            sb5.append(", wording:");
            sb5.append(str8);
            sb5.append(", size:");
            sb5.append(arrayList2.size());
            sb5.append(", lag:");
            sb5.append(str6);
            sb5.append(", baseW:");
            sb5.append(i26);
            sb5.append(", baseH:");
            sb5.append(i19);
            sb5.append(", mapSize:");
            sb5.append(hashMap.size());
            sb5.append(", length:");
            i38 = i3;
            sb5.append(i38);
            sb5.append(", width:");
            i37 = i16;
            sb5.append(i37);
            sb5.append(", height");
            i36 = i17;
            sb5.append(i36);
            QLog.i("PicOcrHandler", 2, sb5.toString());
        } else {
            i36 = i17;
            i37 = i16;
            i38 = i3;
        }
        if (z17) {
            cVar2 = cVar;
            String str19 = str;
            cVar2.f211814a = str19;
            cVar2.f211817d = str6;
            cVar2.f211820g.addAll(arrayList);
            cVar2.f211815b = i26;
            cVar2.f211816c = i19;
            cVar2.f211819f.addAll(arrayList2);
            cVar2.f211818e = str2;
            cVar2.f211821h = hashMap;
            cVar2.f211822i = i38;
            cVar2.f211823j = i37;
            cVar2.f211824k = i36;
            cVar2.f211825l = str13;
            businessHandler = this;
            try {
                ((IPicOcrService) businessHandler.appRuntime.getRuntimeService(IPicOcrService.class, "")).putOcrResult(str19, cVar2);
            } catch (Exception e58) {
                QLog.e("PicOcrHandler", 2, "handleRequestPicOcrRsp Exception:", e58);
            }
        } else {
            businessHandler = this;
            cVar2 = cVar;
        }
        businessHandler.notifyUI(100, z17, cVar2);
        HashMap<String, String> hashMap22222222222 = new HashMap<>();
        if (z17) {
            str10 = "0";
        } else {
            str10 = "1";
        }
        hashMap22222222222.put("param_result", str10);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actPicOcrResult", true, 0L, 0L, hashMap22222222222, "");
    }

    public void E2(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
        } else {
            F2(aVar.f254776l, aVar.f254775k, aVar.f254770f, aVar.f254771g, aVar.f254766b, (int) aVar.f254769e, aVar.f254773i, aVar.f254774j, aVar.f254772h, aVar.f254765a);
        }
    }

    public void F2(String str, long j3, String str2, String str3, int i3, int i16, int i17, int i18, boolean z16, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Long.valueOf(j3), str2, str3, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z16), str4);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("PicOcrHandler", 2, "requestPicOcr seq:" + j3 + ", url:" + str + ", orimd5:" + str2 + ", afMd5:" + str3 + ", size:" + i16 + ", width:" + i17 + ", height:" + i18 + ", crop" + z16 + "\uff0c lang\uff1a" + str4);
        }
        cmd0xe07$OCRReqBody cmd0xe07_ocrreqbody = new cmd0xe07$OCRReqBody();
        cmd0xe07_ocrreqbody.imageUrl.set(str);
        if (!TextUtils.isEmpty(str4)) {
            cmd0xe07_ocrreqbody.languageType.set(str4);
        }
        if (!TextUtils.isEmpty(str2)) {
            cmd0xe07_ocrreqbody.originMd5.set(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            cmd0xe07_ocrreqbody.afterCompressMd5.set(str3);
        }
        cmd0xe07_ocrreqbody.afterCompressFileSize.set(i16);
        cmd0xe07_ocrreqbody.afterCompressWeight.set(i17);
        cmd0xe07_ocrreqbody.afterCompressHeight.set(i18);
        cmd0xe07_ocrreqbody.isCut.set(z16);
        cmd0xe07$ReqBody cmd0xe07_reqbody = new cmd0xe07$ReqBody();
        cmd0xe07_reqbody.version.set(1);
        cmd0xe07_reqbody.client.set(0);
        cmd0xe07_reqbody.entrance.set(getEntranceType(i3));
        cmd0xe07_reqbody.ocrReqBody.set(cmd0xe07_ocrreqbody);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg(f254692e, 3591, 0, cmd0xe07_reqbody.toByteArray());
        makeOIDBPkg.getAttributes().put("key_ocr_seq", Long.valueOf(j3));
        makeOIDBPkg.getAttributes().put("key_ocr_md5", str2);
        makeOIDBPkg.getAttributes().put("key_ocr_url", str);
        makeOIDBPkg.getAttributes().put("key_ocr_size", Integer.valueOf(i16));
        makeOIDBPkg.getAttributes().put("key_ocr_width", Integer.valueOf(i17));
        makeOIDBPkg.getAttributes().put("key_ocr_height", Integer.valueOf(i18));
        makeOIDBPkg.getAttributes().put("key_ocr_afmd5", str3);
        sendPbReq(makeOIDBPkg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Set) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add(f254692e);
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return com.tencent.mobileqq.gallery.picocr.a.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (toServiceMsg != null && fromServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (msgCmdFilter(serviceCmd)) {
                if (QLog.isColorLevel()) {
                    QLog.d("PicOcrHandler", 2, "onReceive, msgCmdFilter is true,cmd  = " + serviceCmd);
                    return;
                }
                return;
            }
            if (f254692e.equals(serviceCmd)) {
                D2(toServiceMsg, fromServiceMsg, obj);
            }
        }
    }
}
