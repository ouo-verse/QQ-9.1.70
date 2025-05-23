package com.tencent.mobileqq.ar.ARPromotion;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c {

    /* renamed from: f, reason: collision with root package name */
    public String f196872f;

    /* renamed from: g, reason: collision with root package name */
    public long f196873g;

    /* renamed from: h, reason: collision with root package name */
    public String f196874h;

    /* renamed from: i, reason: collision with root package name */
    public String f196875i;

    /* renamed from: a, reason: collision with root package name */
    public boolean f196867a = false;

    /* renamed from: b, reason: collision with root package name */
    public int f196868b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f196869c = 1;

    /* renamed from: d, reason: collision with root package name */
    public int f196870d = 1;

    /* renamed from: e, reason: collision with root package name */
    public int f196871e = 0;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList<a> f196876j = new ArrayList<>();

    /* renamed from: k, reason: collision with root package name */
    public String f196877k = "https://www.qq.com";

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f196878a;

        /* renamed from: b, reason: collision with root package name */
        public String f196879b;

        /* renamed from: c, reason: collision with root package name */
        public String f196880c;

        /* renamed from: d, reason: collision with root package name */
        public int f196881d = 2;

        /* renamed from: e, reason: collision with root package name */
        public int f196882e;

        /* renamed from: f, reason: collision with root package name */
        public int f196883f;

        /* renamed from: g, reason: collision with root package name */
        public int f196884g;
    }

    public static c a(JSONObject jSONObject) {
        String str;
        String[] split;
        String str2 = "ARTransferDoorConfigInfo";
        String str3 = "trigger";
        c cVar = new c();
        String str4 = "triggerType";
        try {
            if (jSONObject.has("preDownload")) {
                cVar.f196868b = jSONObject.optInt("preDownload");
            }
            if (jSONObject.has("Video360Restart")) {
                cVar.f196869c = jSONObject.optInt("Video360Restart");
            }
            if (jSONObject.has("Video360Repeat")) {
                int optInt = jSONObject.optInt("Video360Repeat");
                cVar.f196870d = optInt;
                if (optInt <= 0) {
                    optInt = Integer.MAX_VALUE;
                }
                cVar.f196870d = optInt;
            }
            if (jSONObject.has("Video360ConnectType")) {
                cVar.f196871e = jSONObject.optInt("Video360ConnectType");
            }
            if (jSONObject.has("TraversingResource")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("TraversingResource");
                if (optJSONObject.has("TraversingResourceSize")) {
                    cVar.f196873g = optJSONObject.optLong("TraversingResourceSize");
                }
                if (optJSONObject.has("TraversingResourceUrl")) {
                    cVar.f196872f = optJSONObject.optString("TraversingResourceUrl");
                }
                if (optJSONObject.has("TraversingResourceMD5")) {
                    cVar.f196874h = optJSONObject.optString("TraversingResourceMD5");
                }
            }
            if (jSONObject.has("FragmentInfos")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("FragmentInfos");
                int length = optJSONArray.length();
                int i3 = 0;
                while (i3 < length) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                    a aVar = new a();
                    if (jSONObject2.has("name")) {
                        aVar.f196878a = jSONObject2.getString("name");
                    }
                    if (jSONObject2.has("md5")) {
                        aVar.f196879b = jSONObject2.getString("md5");
                    }
                    if (jSONObject2.has("url")) {
                        aVar.f196880c = jSONObject2.getString("url");
                    }
                    if (jSONObject2.has("repeat")) {
                        int optInt2 = jSONObject2.optInt("repeat");
                        aVar.f196881d = optInt2;
                        if (optInt2 <= 0) {
                            optInt2 = Integer.MAX_VALUE;
                        }
                        aVar.f196881d = optInt2;
                    }
                    String str5 = str4;
                    if (jSONObject2.has(str5)) {
                        aVar.f196882e = jSONObject2.optInt(str5);
                    }
                    String str6 = str3;
                    if (jSONObject2.has(str6) && (split = jSONObject2.getString(str6).split("\\|")) != null && split.length == 2) {
                        int i16 = 0;
                        try {
                        } catch (NumberFormatException e16) {
                            e = e16;
                        }
                        try {
                            aVar.f196883f = Integer.parseInt(split[0]);
                            aVar.f196884g = Integer.parseInt(split[1]);
                        } catch (NumberFormatException e17) {
                            e = e17;
                            i16 = 0;
                            aVar.f196883f = i16;
                            aVar.f196884g = i16;
                            Object[] objArr = new Object[1];
                            objArr[i16] = e;
                            str = str2;
                            try {
                                QLog.d(str, 1, String.format("ARTransferDoorConfigInfo parseJson, numberException\n%s", objArr));
                                cVar.f196876j.add(aVar);
                                i3++;
                                str4 = str5;
                                str3 = str6;
                                str2 = str;
                            } catch (Exception e18) {
                                e = e18;
                                QLog.d(str, 1, String.format("ARTransferDoorConfigInfo parseJson, Exception\n%s", e));
                                return cVar;
                            }
                        }
                    }
                    str = str2;
                    cVar.f196876j.add(aVar);
                    i3++;
                    str4 = str5;
                    str3 = str6;
                    str2 = str;
                }
            }
        } catch (Exception e19) {
            e = e19;
            str = str2;
        }
        return cVar;
    }
}
