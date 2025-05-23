package com.tencent.mobileqq.profile.like;

import SummaryCard.TPraiseInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static AtomicBoolean f260222a;

    /* renamed from: b, reason: collision with root package name */
    public static Vector<String> f260223b;

    /* renamed from: c, reason: collision with root package name */
    public static Vector<a> f260224c;

    /* renamed from: d, reason: collision with root package name */
    public static int f260225d;

    /* renamed from: e, reason: collision with root package name */
    public static int f260226e;

    /* renamed from: f, reason: collision with root package name */
    public static int f260227f;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f260228a;

        /* renamed from: b, reason: collision with root package name */
        public String f260229b;

        /* renamed from: c, reason: collision with root package name */
        public Vector<String> f260230c;

        /* renamed from: d, reason: collision with root package name */
        public String f260231d;

        /* renamed from: e, reason: collision with root package name */
        public String f260232e;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73832);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f260222a = new AtomicBoolean(false);
        f260225d = 10;
        f260226e = 2000;
        f260227f = 0;
    }

    public static synchronized void a(AppRuntime appRuntime) {
        synchronized (c.class) {
            if (appRuntime == null) {
                QLog.e("PraiseConfigHelper", 1, "parseJson, app null");
                return;
            }
            if (!f260222a.compareAndSet(false, true)) {
                return;
            }
            JSONObject jSONFromLocal = VasUpdateUtil.getJSONFromLocal(appRuntime, VasUpdateConstants.SCID_PRAISE_CONFIG, true, null);
            if (jSONFromLocal != null) {
                JSONArray optJSONArray = jSONFromLocal.optJSONArray("colorEntries");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    Vector<String> vector = f260223b;
                    if (vector == null) {
                        f260223b = new Vector<>();
                    } else {
                        vector.clear();
                    }
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        String optString = optJSONArray.optString(i3);
                        if (!TextUtils.isEmpty(optString)) {
                            if (!optString.startsWith("http:")) {
                                optString = "http:" + optString;
                            }
                            f260223b.add(optString);
                        }
                    }
                }
                JSONArray optJSONArray2 = jSONFromLocal.optJSONArray("newEntries");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    Vector<a> vector2 = f260224c;
                    if (vector2 == null) {
                        f260224c = new Vector<>();
                    } else {
                        vector2.clear();
                    }
                    for (int i16 = 0; i16 < optJSONArray2.length(); i16++) {
                        JSONObject optJSONObject = optJSONArray2.optJSONObject(i16);
                        if (optJSONObject != null) {
                            a aVar = new a();
                            aVar.f260228a = optJSONObject.optString("title");
                            aVar.f260229b = optJSONObject.optString("subtitle");
                            aVar.f260231d = optJSONObject.optString("bannerLink");
                            aVar.f260232e = optJSONObject.optString("reportName");
                            aVar.f260230c = new Vector<>();
                            JSONArray optJSONArray3 = optJSONObject.optJSONArray("entrys");
                            if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                                for (int i17 = 0; i17 < optJSONArray3.length(); i17++) {
                                    String optString2 = optJSONArray3.optJSONObject(i17).optString("icon");
                                    if (!TextUtils.isEmpty(optString2)) {
                                        aVar.f260230c.add(optString2);
                                    }
                                }
                            }
                            f260224c.add(aVar);
                        }
                    }
                }
                f260225d = jSONFromLocal.optInt("playNum", 10);
                f260226e = (int) (jSONFromLocal.optDouble("downloadTimeLimit", 2.0d) * 1000.0d);
                f260227f = jSONFromLocal.optInt("praiseFlyOrder", 0);
            }
            f260222a.set(false);
        }
    }

    public static List<TPraiseInfo> b(List<TPraiseInfo> list) {
        if (f260227f == 0 && list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (TPraiseInfo tPraiseInfo : list) {
                if (tPraiseInfo.uCustomId > 0) {
                    arrayList.add(tPraiseInfo);
                } else {
                    arrayList2.add(tPraiseInfo);
                }
            }
            arrayList.addAll(arrayList2);
            return arrayList;
        }
        return list;
    }
}
