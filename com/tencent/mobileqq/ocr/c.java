package com.tencent.mobileqq.ocr;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c implements BusinessObserver {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void a(boolean z16, String str, List<OCRTextSearchInfo.SougouSearchInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, list);
        }
    }

    public void b(int i3, String str, OCRTextSearchInfo.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, cVar);
        }
    }

    public void c(boolean z16, int i3, TranslateResult translateResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3), translateResult);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    Object[] objArr = (Object[]) obj;
                    if (objArr != null && objArr.length == 3) {
                        b(((Integer) objArr[0]).intValue(), (String) objArr[1], (OCRTextSearchInfo.c) objArr[2]);
                        return;
                    } else {
                        b(-1, "", null);
                        return;
                    }
                }
                return;
            }
            Object[] objArr2 = (Object[]) obj;
            if (obj != null && objArr2.length == 2) {
                Integer num = (Integer) objArr2[0];
                TranslateResult translateResult = (TranslateResult) objArr2[1];
                if (translateResult != null) {
                    c(z16, num.intValue(), translateResult);
                    return;
                } else {
                    c(false, num.intValue(), null);
                    return;
                }
            }
            c(false, -1, null);
            return;
        }
        Object[] objArr3 = (Object[]) obj;
        if (objArr3 != null && objArr3.length == 2) {
            a(z16, (String) objArr3[0], (List) objArr3[1]);
        } else {
            a(false, "", null);
        }
    }
}
