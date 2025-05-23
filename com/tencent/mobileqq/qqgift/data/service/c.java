package com.tencent.mobileqq.qqgift.data.service;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public long f264860a;

    /* renamed from: b, reason: collision with root package name */
    public long f264861b;

    /* renamed from: c, reason: collision with root package name */
    public int f264862c;

    /* renamed from: d, reason: collision with root package name */
    public int f264863d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f264864e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f264865f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f264866g;

    /* renamed from: h, reason: collision with root package name */
    public List<String> f264867h;

    /* renamed from: i, reason: collision with root package name */
    public int f264868i;

    /* renamed from: j, reason: collision with root package name */
    public ConcurrentHashMap<String, String> f264869j;

    /* renamed from: k, reason: collision with root package name */
    public ConcurrentHashMap<String, String> f264870k;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f264860a = 0L;
        this.f264861b = 0L;
        this.f264862c = 0;
        this.f264863d = 0;
        this.f264864e = false;
        this.f264865f = false;
        this.f264866g = false;
        this.f264867h = new ArrayList();
        this.f264869j = new ConcurrentHashMap<>();
        this.f264870k = new ConcurrentHashMap<>();
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ConcurrentHashMap<String, String> concurrentHashMap = this.f264869j;
        if (concurrentHashMap != null && concurrentHashMap.size() != 0) {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : this.f264869j.entrySet()) {
                try {
                    jSONObject.put(entry.getKey(), entry.getValue());
                } catch (JSONException unused) {
                    if (QLog.isColorLevel()) {
                        QLog.e("GiftSendReqData", 4, "toExtJsonData error");
                    }
                }
            }
            return jSONObject.toString();
        }
        return "";
    }
}
