package com.tencent.mobileqq.phonecontact.data;

import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public LinkedHashMap<String, List<PhoneContact>> f258456a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f258457b;

    /* renamed from: c, reason: collision with root package name */
    public String[] f258458c;

    /* renamed from: d, reason: collision with root package name */
    public List<PhoneContact> f258459d;

    /* renamed from: e, reason: collision with root package name */
    public List<PhoneContact> f258460e;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f258456a = new LinkedHashMap<>();
        this.f258457b = new int[0];
        this.f258458c = new String[0];
        this.f258459d = new ArrayList();
        this.f258460e = new ArrayList();
    }
}
