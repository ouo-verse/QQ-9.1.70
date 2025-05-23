package com.tencent.mobileqq.ocr.data;

import android.text.TextUtils;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.ar.arcloud.pb.YoutuOcr$OcrItem;
import com.tencent.mobileqq.ar.arcloud.pb.YoutuOcr$YoutuOcrDetail;
import com.tencent.mobileqq.ar.arcloud.pb.YoutuOcr$YoutuOcrRsp;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public C8173a f254733a;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ocr.data.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static class C8173a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f254734a;

        /* renamed from: b, reason: collision with root package name */
        public String f254735b;

        /* renamed from: c, reason: collision with root package name */
        public int f254736c;

        /* renamed from: d, reason: collision with root package name */
        public String f254737d;

        /* renamed from: e, reason: collision with root package name */
        public String f254738e;

        /* renamed from: f, reason: collision with root package name */
        public String f254739f;

        /* renamed from: g, reason: collision with root package name */
        public String f254740g;

        /* renamed from: h, reason: collision with root package name */
        public ArrayList<String> f254741h;

        public C8173a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "ssoErrCode:" + this.f254734a + ",ssoErrMsg:" + this.f254735b + ",errCode:" + this.f254736c + ",errMsg:" + this.f254737d + ",session_id:" + this.f254738e + ",content:" + this.f254739f + ",language" + this.f254740g + ",ocr_language_list" + this.f254741h;
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static C8173a b(YoutuOcr$YoutuOcrRsp youtuOcr$YoutuOcrRsp) {
        int i3;
        String str;
        int i16;
        List<YoutuOcr$OcrItem> list;
        C8173a c8173a = new C8173a();
        if (youtuOcr$YoutuOcrRsp.youtu_ocr_errorcode.has()) {
            i3 = youtuOcr$YoutuOcrRsp.youtu_ocr_errorcode.get();
        } else {
            i3 = 0;
        }
        c8173a.f254734a = i3;
        String str2 = "";
        if (!youtuOcr$YoutuOcrRsp.youtu_ocr_errormsg.has()) {
            str = "";
        } else {
            str = youtuOcr$YoutuOcrRsp.youtu_ocr_errormsg.get();
        }
        c8173a.f254735b = str;
        if (youtuOcr$YoutuOcrRsp.youtu_orc_detail.has()) {
            YoutuOcr$YoutuOcrDetail youtuOcr$YoutuOcrDetail = youtuOcr$YoutuOcrRsp.youtu_orc_detail.get();
            if (youtuOcr$YoutuOcrDetail.errorcode.has()) {
                i16 = youtuOcr$YoutuOcrDetail.errorcode.get();
            } else {
                i16 = -1;
            }
            c8173a.f254736c = i16;
            if (youtuOcr$YoutuOcrDetail.errormsg.has()) {
                str2 = youtuOcr$YoutuOcrDetail.errormsg.get();
            }
            c8173a.f254737d = str2;
            if (youtuOcr$YoutuOcrDetail.language.has()) {
                c8173a.f254740g = youtuOcr$YoutuOcrDetail.language.get();
            }
            if (youtuOcr$YoutuOcrDetail.ocr_language_list.has()) {
                ArrayList<String> arrayList = new ArrayList<>();
                c8173a.f254741h = arrayList;
                arrayList.addAll(youtuOcr$YoutuOcrDetail.ocr_language_list.get());
            }
            if (youtuOcr$YoutuOcrDetail.ocr_item.has()) {
                list = youtuOcr$YoutuOcrDetail.ocr_item.get();
            } else {
                list = null;
            }
            if (list != null) {
                c8173a.f254739f = c(list);
            }
        }
        return c8173a;
    }

    private static String c(List<YoutuOcr$OcrItem> list) {
        if (list != null && list.size() != 0) {
            StringBuilder sb5 = new StringBuilder();
            Iterator<YoutuOcr$OcrItem> it = list.iterator();
            while (it.hasNext()) {
                String str = it.next().itemstring.get();
                if (!TextUtils.isEmpty(str)) {
                    sb5.append(str);
                    sb5.append("\n");
                }
            }
            return sb5.toString();
        }
        QLog.d(LogTag.TAG_OCR, 1, "typeSetting regoc items is null");
        return null;
    }

    public OcrRecogResult a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (OcrRecogResult) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        C8173a c8173a = this.f254733a;
        if (c8173a != null && !TextUtils.isEmpty(c8173a.f254739f)) {
            OcrRecogResult ocrRecogResult = new OcrRecogResult();
            C8173a c8173a2 = this.f254733a;
            if (c8173a2 != null) {
                ocrRecogResult.language = c8173a2.f254740g;
                ocrRecogResult.ocrContent = c8173a2.f254739f;
                ocrRecogResult.ocr_languages = c8173a2.f254741h;
            }
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_OCR, 2, "getUIData " + ocrRecogResult);
            }
            return ocrRecogResult;
        }
        return null;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "mOcrResult:" + this.f254733a;
    }
}
