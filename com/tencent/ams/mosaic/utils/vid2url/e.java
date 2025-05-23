package com.tencent.ams.mosaic.utils.vid2url;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.publish.business.model.UploadVideoObject;
import com.tencent.ads.data.AdParam;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.mobileqq.activity.photo.MediaDBValues;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final int f71608a;

    /* renamed from: b, reason: collision with root package name */
    private String f71609b;

    /* renamed from: c, reason: collision with root package name */
    private String f71610c;

    /* renamed from: d, reason: collision with root package name */
    private String f71611d;

    /* renamed from: e, reason: collision with root package name */
    private List<String> f71612e;

    /* renamed from: f, reason: collision with root package name */
    private String f71613f;

    /* renamed from: g, reason: collision with root package name */
    private Document f71614g;

    /* renamed from: h, reason: collision with root package name */
    private final ArrayList<a> f71615h;

    /* renamed from: i, reason: collision with root package name */
    private int f71616i;

    /* renamed from: j, reason: collision with root package name */
    private String f71617j;

    /* renamed from: k, reason: collision with root package name */
    private String f71618k;

    /* renamed from: l, reason: collision with root package name */
    private String f71619l;

    public e(String str, List<String> list, int i3, String str2, String str3, String str4, String str5, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, list, Integer.valueOf(i3), str2, str3, str4, str5, Boolean.valueOf(z16));
            return;
        }
        this.f71608a = 1;
        this.f71615h = new ArrayList<>(4);
        this.f71611d = str;
        this.f71612e = list;
        this.f71616i = i3;
        this.f71617j = TextUtils.isEmpty(str2) ? "shd" : str2;
        this.f71613f = TextUtils.isEmpty(str3) ? "20303" : str3;
        this.f71609b = TextUtils.isEmpty(str4) ? "https://vv6.video.qq.com/getvmind?otype=xml" : str4;
        this.f71610c = TextUtils.isEmpty(str5) ? "https://vv6.video.qq.com/diffvmind" : str5;
        g(z16);
    }

    private String a(String str, String str2, String str3) {
        if (str != null) {
            if (!str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                str = str + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
            }
            return str + ContainerUtils.FIELD_DELIMITER + str2 + ContainerUtils.KEY_VALUE_DELIMITER + str3;
        }
        return str;
    }

    private JSONArray b() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.f71612e;
        if (list != null) {
            for (String str : list) {
                if (TextUtils.isEmpty(str)) {
                    jSONArray.mo162put("");
                } else {
                    jSONArray.mo162put(str);
                }
            }
        }
        return jSONArray;
    }

    private String c(String str) {
        if (str.equals("sd")) {
            return "100";
        }
        if (str.equals("hd") || !str.equals("shd")) {
            return "200";
        }
        return IndividuationPlugin.Business_Pendant;
    }

    private JSONArray d(String str) {
        String[] split;
        if (!TextUtils.isEmpty(str) && (split = str.split("\\|")) != null) {
            JSONArray jSONArray = new JSONArray();
            for (String str2 : split) {
                if (!TextUtils.isEmpty(str2)) {
                    jSONArray.mo162put(str2);
                }
            }
            return jSONArray;
        }
        return null;
    }

    private String f(String str) {
        if (MosaicUtils.v(str)) {
            try {
                if (Integer.parseInt(str) == 1) {
                    return UploadVideoObject.VODEO_FORMAT_H265;
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    private void g(boolean z16) {
        if (z16) {
            j();
        } else {
            k();
        }
    }

    private void h(String str) {
        JSONObject optJSONObject;
        Iterator keys;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("code", -1) == 0 && (optJSONObject = jSONObject.optJSONObject("vid_map")) != null && (keys = optJSONObject.keys()) != null) {
                    while (keys.hasNext()) {
                        i(optJSONObject, (String) keys.next());
                    }
                }
            } catch (Exception e16) {
                com.tencent.ams.mosaic.utils.f.b("AdCoreVidInfo", Log.getStackTraceString(e16));
            }
        }
    }

    private void i(JSONObject jSONObject, String str) {
        JSONObject optJSONObject;
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            Object opt = jSONObject.opt(str);
            if (opt instanceof JSONObject) {
                JSONObject jSONObject2 = (JSONObject) opt;
                if (jSONObject2.optInt("code", -1) != 0) {
                    return;
                }
                String optString = jSONObject2.optString("md5");
                String optString2 = jSONObject2.optString("hevc");
                int optInt = jSONObject2.optInt(MediaDBValues.FILESIZE);
                JSONArray optJSONArray = jSONObject2.optJSONArray("url_info");
                if (optJSONArray != null && optJSONArray.length() > 0 && (optJSONObject = optJSONArray.optJSONObject(0)) != null) {
                    String optString3 = optJSONObject.optString("url");
                    if (!TextUtils.isEmpty(optString3)) {
                        a aVar = new a(str, optString, optString3);
                        aVar.f71578d = optInt;
                        aVar.f71581g = f(optString2);
                        if (aVar.f71578d > 0 && c.f(optString3)) {
                            this.f71615h.add(aVar);
                        }
                    }
                }
            }
        }
    }

    private void j() {
        int i3;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray d16 = d(this.f71611d);
            if (d16 != null && d16.length() != 0) {
                jSONObject.put(AdParam.VIDS, d16);
                jSONObject.put("sdtfrom_list", b());
                jSONObject.put("platform", this.f71613f);
                jSONObject.put("defn", this.f71617j);
                jSONObject.put(AdParam.DTYPE, 1);
                jSONObject.put("appaid", "1");
                jSONObject.put("flowid", MosaicUtils.r());
                jSONObject.put("sdtfrom", "v5266");
                int i16 = this.f71616i;
                if (i16 >= 0) {
                    jSONObject.put("hevclv", i16);
                }
                if (c.e()) {
                    i3 = 6000;
                } else {
                    i3 = 2000;
                }
                h(c.c(this.f71610c, jSONObject.toString(), i3, i3, 3));
            }
        } catch (Exception e16) {
            com.tencent.ams.mosaic.utils.f.b("AdCoreVidInfo", Log.getStackTraceString(e16));
        }
    }

    private void k() {
        Document m3 = m(this.f71611d);
        this.f71614g = m3;
        if (m3 != null) {
            l(m3);
        } else {
            com.tencent.ams.mosaic.utils.f.a("AdCoreVidInfo", "VidInfo doc is null");
        }
    }

    private void l(Document document) {
        String e16;
        Iterator<Node> it = f.c(document, "/root/fl/fi[*]").iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Node next = it.next();
            if ("1".equals(f.e(next, "fi/sl"))) {
                this.f71618k = f.e(next, "fi/br");
                this.f71619l = f.e(next, "fi/id");
                break;
            }
        }
        Iterator<Node> it5 = f.c(document, "/root/vl/vi[*]").iterator();
        while (it5.hasNext()) {
            Node next2 = it5.next();
            String e17 = f.e(next2, "vi/vid");
            String e18 = f.e(next2, "vi/cl/ci/cs");
            String e19 = f.e(next2, "vi/cl/ci/cmd5");
            String e26 = f.e(next2, "vi/hevc");
            if (e18 == null && e19 == null) {
                e18 = f.e(next2, "vi/fs");
                e19 = f.e(next2, "vi/fmd5");
            }
            if (MosaicUtils.v(e18) && !TextUtils.isEmpty(e19) && !TextUtils.isEmpty(e17)) {
                ArrayList<Node> d16 = f.d(next2, "vi/ul/ui[*]");
                if (!MosaicUtils.t(d16) && (e16 = f.e(d16.get(0), "ui/url")) != null) {
                    String a16 = a(e16, "sdtfrom", "");
                    a aVar = new a(e17, e19, a16);
                    aVar.f71578d = Integer.parseInt(e18);
                    aVar.f71581g = f(e26);
                    if (aVar.f71578d > 0 && c.f(a16)) {
                        this.f71615h.add(aVar);
                    }
                }
            }
        }
    }

    private Document m(String str) {
        String join;
        HashMap hashMap = new HashMap();
        hashMap.put(AdParam.VIDS, str);
        List<String> list = this.f71612e;
        if (list == null) {
            join = "";
        } else {
            join = TextUtils.join("|", list);
        }
        hashMap.put("sdtfrom_list", join);
        hashMap.put(AdParam.OTYPE, "xml");
        hashMap.put(AdParam.APPVER, "1.0");
        hashMap.put(AdParam.ENCRYPTVER, "1.0");
        hashMap.put("platform", this.f71613f);
        hashMap.put("sdtfrom", "v5266");
        hashMap.put("defn", this.f71617j);
        hashMap.put("speed", c(this.f71617j));
        hashMap.put(AdParam.DTYPE, String.valueOf(1));
        hashMap.put("device", String.valueOf(d.f()));
        hashMap.put("clip", "1");
        int i3 = this.f71616i;
        if (i3 >= 0) {
            hashMap.put("hevclv", String.valueOf(i3));
        }
        hashMap.put("appaid", "1");
        b bVar = new b(this.f71609b);
        bVar.i(" qqlive/tad1.0 ");
        bVar.h(hashMap);
        Object d16 = c.d(bVar);
        if (d16 instanceof Document) {
            return (Document) d16;
        }
        return null;
    }

    public ArrayList<a> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f71615h;
    }
}
