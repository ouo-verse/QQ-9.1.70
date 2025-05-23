package com.tencent.turingfd.sdk.xq;

import com.tencent.ams.dynamicwidget.http.Method;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class CanisMinor {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final int f382624a;

    /* renamed from: b, reason: collision with root package name */
    public final Cdo[] f382625b;

    /* renamed from: c, reason: collision with root package name */
    public final String f382626c;

    /* compiled from: P */
    /* renamed from: com.tencent.turingfd.sdk.xq.CanisMinor$do, reason: invalid class name */
    /* loaded from: classes27.dex */
    public static class Cdo {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final boolean f382627a;

        /* renamed from: b, reason: collision with root package name */
        public final String f382628b;

        /* renamed from: c, reason: collision with root package name */
        public final String f382629c;

        /* renamed from: d, reason: collision with root package name */
        public final String f382630d;

        /* renamed from: e, reason: collision with root package name */
        public final String f382631e;

        /* renamed from: f, reason: collision with root package name */
        public final String f382632f;

        /* renamed from: g, reason: collision with root package name */
        public final String[] f382633g;

        /* renamed from: h, reason: collision with root package name */
        public final boolean f382634h;

        /* renamed from: i, reason: collision with root package name */
        public final boolean f382635i;

        public Cdo(boolean z16, String str, String str2, String str3, String str4, String str5, String[] strArr, boolean z17, boolean z18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), str, str2, str3, str4, str5, strArr, Boolean.valueOf(z17), Boolean.valueOf(z18));
                return;
            }
            this.f382627a = z16;
            this.f382628b = str;
            this.f382629c = str2;
            this.f382630d = str3;
            this.f382631e = str4;
            this.f382632f = str5;
            this.f382633g = strArr;
            this.f382634h = z17;
            this.f382635i = z18;
        }
    }

    public CanisMinor(int i3, Cdo[] cdoArr, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), cdoArr, str);
            return;
        }
        this.f382624a = i3;
        this.f382625b = cdoArr;
        this.f382626c = str;
    }

    public static Cdo a(JSONObject jSONObject) throws JSONException {
        String str;
        String str2;
        String str3;
        boolean z16;
        HashSet hashSet;
        String string = jSONObject.getString("method");
        if (Method.POST.equals(string)) {
            str = jSONObject.getString("body");
            str2 = jSONObject.getString("content_type");
        } else {
            str = null;
            str2 = null;
        }
        if ("trans".equals(string)) {
            str3 = null;
            z16 = false;
        } else {
            str3 = jSONObject.getString("url");
            z16 = jSONObject.getBoolean(WinkDaTongReportConstant.ElementParamValue.XSJ_OPERATION_TYPE_CONTINUE);
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("ex_keywords");
            hashSet = new HashSet();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                try {
                    hashSet.add(jSONArray.getString(i3));
                } catch (JSONException unused) {
                }
            }
        } catch (JSONException unused2) {
            hashSet = null;
        }
        return new Cdo(z16, string, str3, str, str2, jSONObject.getString("action_session"), Creturn.a(hashSet) ? null : (String[]) hashSet.toArray(new String[0]), jSONObject.optInt("net_used", 0) == 0, !jSONObject.optBoolean("disable_follow_redirects", false));
    }

    public static CanisMinor a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            String str = new String(bArr, "utf-8");
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str);
            int i3 = jSONObject.getInt("ret");
            String string = jSONObject.getString(SessionDbHelper.SESSION_ID);
            JSONArray jSONArray = jSONObject.getJSONArray("actions");
            for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                arrayList.add(a(jSONArray.getJSONObject(i16)));
            }
            return new CanisMinor(i3, (Cdo[]) arrayList.toArray(new Cdo[0]), string);
        } catch (UnsupportedEncodingException | JSONException unused) {
            return null;
        }
    }
}
