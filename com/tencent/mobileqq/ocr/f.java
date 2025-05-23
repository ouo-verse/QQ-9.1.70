package com.tencent.mobileqq.ocr;

import com.tencent.mobileqq.ocr.OCRTextSearchInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f254759a;

    /* renamed from: b, reason: collision with root package name */
    public String f254760b;

    /* renamed from: c, reason: collision with root package name */
    public List<OCRTextSearchInfo.a> f254761c;

    /* renamed from: d, reason: collision with root package name */
    public int f254762d;

    /* renamed from: e, reason: collision with root package name */
    public String f254763e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f254764f;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
