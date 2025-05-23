package com.tencent.mobileqq.troop.utils;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.heytap.databaseengine.apiv3.data.Element;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class i implements Manager {
    static IPatchRedirector $redirector_;
    String C;
    String D;
    boolean E;
    public String F;
    public String G;
    String H;
    b I;
    a J;
    String K;
    String L;
    int M;
    int N;

    /* renamed from: d, reason: collision with root package name */
    public String f302162d;

    /* renamed from: e, reason: collision with root package name */
    public String f302163e;

    /* renamed from: f, reason: collision with root package name */
    public String f302164f;

    /* renamed from: h, reason: collision with root package name */
    public String f302165h;

    /* renamed from: i, reason: collision with root package name */
    AppInterface f302166i;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    List<String> f302167m;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f302168a;

        /* renamed from: b, reason: collision with root package name */
        public int f302169b;

        /* renamed from: c, reason: collision with root package name */
        public long f302170c;

        /* renamed from: d, reason: collision with root package name */
        public long f302171d;

        /* renamed from: e, reason: collision with root package name */
        public int f302172e;

        /* renamed from: f, reason: collision with root package name */
        public String f302173f;

        /* renamed from: g, reason: collision with root package name */
        public String f302174g;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f302175a;

        /* renamed from: b, reason: collision with root package name */
        public int f302176b;

        /* renamed from: c, reason: collision with root package name */
        public long f302177c;

        /* renamed from: d, reason: collision with root package name */
        public long f302178d;

        /* renamed from: e, reason: collision with root package name */
        public int f302179e;

        /* renamed from: f, reason: collision with root package name */
        public String f302180f;

        /* renamed from: g, reason: collision with root package name */
        public String f302181g;

        /* renamed from: h, reason: collision with root package name */
        public String f302182h;

        /* renamed from: i, reason: collision with root package name */
        public String f302183i;

        /* renamed from: j, reason: collision with root package name */
        public String f302184j;

        /* renamed from: k, reason: collision with root package name */
        public String f302185k;

        /* renamed from: l, reason: collision with root package name */
        public String f302186l;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public i(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
            return;
        }
        this.f302162d = "banner_config";
        this.f302163e = "dialog_config";
        this.f302164f = "banner_show_num";
        this.f302165h = "dialog_show_num";
        this.f302167m = new ArrayList(5);
        this.E = false;
        this.F = HardCodeUtil.qqStr(R.string.omd);
        this.G = HardCodeUtil.qqStr(R.string.om8);
        this.H = "";
        this.f302166i = appInterface;
        String currentAccountUin = appInterface.getCurrentAccountUin();
        this.f302162d += currentAccountUin;
        this.f302164f += currentAccountUin;
        this.f302163e += currentAccountUin;
        this.f302165h += currentAccountUin;
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("nearby_videochat", 0);
        String string = sharedPreferences.getString(DownloadInfo.spKey_Config, "");
        this.H = string;
        if (!TextUtils.isEmpty(string)) {
            h(this.H);
        }
        this.E = sharedPreferences.getBoolean("enter_guide", true);
        String string2 = sharedPreferences.getString(this.f302162d, "");
        if (!TextUtils.isEmpty(string2)) {
            e(string2, true);
            a aVar = this.J;
            if (aVar != null && !TextUtils.isEmpty(aVar.f302168a)) {
                this.N = b(sharedPreferences.getString(this.f302164f, ""), this.J.f302168a);
                this.L = this.J.f302168a;
            }
        }
        String string3 = sharedPreferences.getString(this.f302163e, "");
        if (!TextUtils.isEmpty(string3)) {
            g(string3, true);
            b bVar = this.I;
            if (bVar != null && !TextUtils.isEmpty(bVar.f302175a)) {
                this.M = b(sharedPreferences.getString(this.f302165h, ""), this.I.f302175a);
                this.K = this.I.f302175a;
            }
        }
    }

    private void e(String str, boolean z16) {
        try {
            if (TextUtils.isEmpty(str)) {
                QLog.e(LogTag.NEARBY_VIDEO_CHAT, 2, "parseBannerJson json is null");
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            a aVar = new a();
            this.J = aVar;
            aVar.f302168a = jSONObject.optString("unique_key");
            this.J.f302169b = jSONObject.optInt("display_times");
            this.J.f302170c = jSONObject.optLong(Element.ELEMENT_NAME_START_TIMESTAMP, 0L);
            this.J.f302171d = jSONObject.optLong(Element.ELEMENT_NAME_END_TIMESTAMP, 0L);
            this.J.f302172e = jSONObject.optInt("target_group");
            JSONObject optJSONObject = jSONObject.optJSONObject("content");
            if (optJSONObject != null) {
                this.J.f302173f = optJSONObject.optString("image_url");
                this.J.f302174g = optJSONObject.optString("jump_url");
            }
            if (!z16) {
                SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("nearby_videochat", 0);
                sharedPreferences.edit().putString(this.f302162d, jSONObject.toString()).commit();
                String str2 = this.J.f302168a;
                if (str2 != null && !str2.equals(this.L)) {
                    this.L = this.J.f302168a;
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(this.L, 0);
                    sharedPreferences.edit().putString(this.f302164f, jSONObject2.toString()).commit();
                }
            }
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.e(LogTag.NEARBY_VIDEO_CHAT, 2, "parseBannerJson JSONException", e16);
            }
        }
    }

    private void g(String str, boolean z16) {
        try {
            if (TextUtils.isEmpty(str)) {
                QLog.e(LogTag.NEARBY_VIDEO_CHAT, 2, "parseDialogJson json is null");
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            b bVar = new b();
            this.I = bVar;
            bVar.f302175a = jSONObject.optString("unique_key");
            this.I.f302176b = jSONObject.optInt("display_times");
            this.I.f302177c = jSONObject.optLong(Element.ELEMENT_NAME_START_TIMESTAMP, 0L);
            this.I.f302178d = jSONObject.optLong(Element.ELEMENT_NAME_END_TIMESTAMP, 0L);
            this.I.f302179e = jSONObject.optInt("target_group");
            JSONObject optJSONObject = jSONObject.optJSONObject("content");
            if (optJSONObject != null) {
                this.I.f302180f = optJSONObject.optString("header_url");
                this.I.f302181g = optJSONObject.optString("title");
                this.I.f302182h = optJSONObject.optString("content");
                this.I.f302183i = optJSONObject.optString(QZoneAdTianshuFeedData.KEY_BUTTON_TEXT);
                this.I.f302184j = optJSONObject.optString("jump_url");
                this.I.f302185k = optJSONObject.optString("button_text_color");
                this.I.f302186l = optJSONObject.optString("button_background_color");
            }
            if (!z16) {
                SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("nearby_videochat", 0);
                sharedPreferences.edit().putString(this.f302163e, jSONObject.toString()).commit();
                String str2 = this.I.f302175a;
                if (str2 != null && !str2.equals(this.K)) {
                    this.K = this.I.f302175a;
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(this.K, 0);
                    sharedPreferences.edit().putString(this.f302165h, jSONObject2.toString()).commit();
                }
            }
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.e(LogTag.NEARBY_VIDEO_CHAT, 2, "parseDialogJson JSONException", e16);
            }
        }
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.H;
    }

    public int b(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2)).intValue();
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            return new JSONObject(str).optInt(str2);
        } catch (JSONException unused) {
            QLog.e(LogTag.NEARBY_VIDEO_CHAT, 2, "getNumFromJson json:" + str);
            return 0;
        }
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.D;
    }

    public void d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            e(str, false);
        }
    }

    public void f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            g(str, false);
        }
    }

    public void h(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        try {
            this.f302167m.clear();
            if (TextUtils.isEmpty(str)) {
                this.C = null;
                this.D = null;
            } else {
                this.H = str;
                JSONObject jSONObject = new JSONObject(str);
                this.F = jSONObject.optString("detail_default");
                this.G = jSONObject.optString("detail_num");
                this.C = jSONObject.optString("guide");
                this.D = jSONObject.optString("title");
                SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("nearby_videochat", 4);
                sharedPreferences.edit().putString("detail_default", this.F).commit();
                sharedPreferences.edit().putString("detail_num", this.G).commit();
                if (TextUtils.isEmpty(this.D)) {
                    sharedPreferences.edit().putString("title", HardCodeUtil.qqStr(R.string.omc)).commit();
                } else {
                    sharedPreferences.edit().putString("title", this.D).commit();
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("tips");
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    this.f302167m.add(optJSONArray.optString(i3));
                }
            }
            BaseApplication.getContext().getSharedPreferences("nearby_videochat", 4).edit().putString(DownloadInfo.spKey_Config, str).commit();
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.e(LogTag.NEARBY_VIDEO_CHAT, 2, "parseJson JSONException", e16);
            }
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        }
    }
}
