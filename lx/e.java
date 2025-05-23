package lx;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.j;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.markdown.api.impl.MarkdownConfigApiImpl;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import cooperation.qzone.util.QZoneImageUtils;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class e extends b {

    /* renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, Set<String>> f415714c;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f415715d;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                e.this.f415714c.clear();
                Object obj = message.obj;
                if (obj instanceof ConcurrentHashMap) {
                    e.this.f415714c.putAll((ConcurrentHashMap) obj);
                }
                QLog.d("AuthorizeConfig", 1, "update mJsApiWhiteList. after size: ", Integer.valueOf(e.this.f415714c.size()));
            }
        }
    }

    public e(j jVar, b bVar) {
        super(jVar, bVar);
        this.f415714c = new ConcurrentHashMap<>(50);
        this.f415715d = new a(Looper.getMainLooper());
    }

    private ConcurrentHashMap<String, Set<String>> l() {
        JSONObject jSONObject;
        try {
            if (QLog.isColorLevel()) {
                QLog.e("AuthorizeConfig", 2, "now read cmdConfig {\"*.qq.com\":[\"*\"],\"*.tencent.com\":[\"*\"],\"*.soso.com\":[\"*\"],\"*.paipai.com\":[\"*\"],\"*.tenpay.com\":[\"*\"],\"*.yixun.com\":[\"*\"],\"*.myapp.com\":[\"*\"],\"pub.idqqimg.com\":[\"*\"],\"*.qzone.com\":[\"*\"],\"*.weishi.com\":[\"*\"],\"*.weiyun.com\":[\"*\"],\"*\":[\"InputClickEvent.onClickInputCtrl\",\"UrlSaveVerifyV2.validCheck\",\"HtmlViewer.showHTML\",\"Troop.addGroupApp\",\"deviceapp.*\"]}");
            }
            jSONObject = new JSONObject("{\"*.qq.com\":[\"*\"],\"*.tencent.com\":[\"*\"],\"*.soso.com\":[\"*\"],\"*.paipai.com\":[\"*\"],\"*.tenpay.com\":[\"*\"],\"*.yixun.com\":[\"*\"],\"*.myapp.com\":[\"*\"],\"pub.idqqimg.com\":[\"*\"],\"*.qzone.com\":[\"*\"],\"*.weishi.com\":[\"*\"],\"*.weiyun.com\":[\"*\"],\"*\":[\"InputClickEvent.onClickInputCtrl\",\"UrlSaveVerifyV2.validCheck\",\"HtmlViewer.showHTML\",\"Troop.addGroupApp\",\"deviceapp.*\"]}");
        } catch (JSONException unused) {
            if (QLog.isColorLevel()) {
                QLog.d("AuthorizeConfig", 2, "Decode mCmdConfig error");
            }
            jSONObject = null;
        }
        if (jSONObject == null) {
            QLog.e("AuthorizeConfig", 1, "cmdJsonObject is null!");
            return null;
        }
        JSONArray names = jSONObject.names();
        if (names != null && names.length() != 0) {
            ConcurrentHashMap<String, Set<String>> concurrentHashMap = new ConcurrentHashMap<>(50);
            for (int i3 = 0; i3 < names.length(); i3++) {
                Set<String> synchronizedSet = Collections.synchronizedSet(new HashSet(20));
                String optString = names.optString(i3);
                JSONArray optJSONArray = jSONObject.optJSONArray(optString);
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                        synchronizedSet.add(optJSONArray.optString(i16));
                    }
                    concurrentHashMap.put(optString, synchronizedSet);
                }
            }
            return concurrentHashMap;
        }
        QLog.e("AuthorizeConfig", 1, "domain Name are all empty!");
        return null;
    }

    private ConcurrentHashMap<String, Set<String>> m() {
        JSONArray jSONArray;
        String c16 = this.f415710a.c("cmd_config_new", "");
        if (!TextUtils.isEmpty(c16)) {
            try {
                jSONArray = new JSONArray(c16);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("AuthorizeConfig", 2, "Js Api Config JSONArray error!", e16);
                }
                jSONArray = null;
            }
            if (jSONArray != null && jSONArray.length() != 0) {
                ConcurrentHashMap<String, Set<String>> concurrentHashMap = new ConcurrentHashMap<>(50);
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                    JSONArray optJSONArray = optJSONObject.optJSONArray(DTConstants.TAG.API);
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray(QZoneImageUtils.KEY_MATCH);
                    int length2 = optJSONArray2.length();
                    for (int i16 = 0; i16 < length2; i16++) {
                        String optString = optJSONArray2.optString(i16);
                        Set<String> set = concurrentHashMap.get(optString);
                        if (set == null) {
                            set = Collections.synchronizedSet(new HashSet(20));
                        }
                        int length3 = optJSONArray.length();
                        for (int i17 = 0; i17 < length3; i17++) {
                            set.add(optJSONArray.optString(i17));
                        }
                        concurrentHashMap.put(optString, set);
                    }
                }
                return concurrentHashMap;
            }
            QLog.e("AuthorizeConfig", 1, "Js Api Config JSONArray From Pref is empty");
            return null;
        }
        QLog.e("AuthorizeConfig", 1, "get Js Api Config From Pref is empty!");
        return null;
    }

    @Override // lx.b
    public JSONArray a(String str) {
        JSONArray jSONArray;
        if (!n()) {
            return this.f415711b.a(str);
        }
        JSONArray jSONArray2 = null;
        String c16 = this.f415710a.c(str, null);
        if (c16 == null) {
            return null;
        }
        try {
            jSONArray = new JSONArray(c16);
        } catch (JSONException unused) {
        }
        try {
            if (QLog.isColorLevel()) {
                QLog.e("AuthorizeConfig", 2, "Load server config for " + str);
            }
            return jSONArray;
        } catch (JSONException unused2) {
            jSONArray2 = jSONArray;
            if (QLog.isColorLevel()) {
                QLog.w("AuthorizeConfig", 2, "Decode " + str + " Config error");
                return jSONArray2;
            }
            return jSONArray2;
        }
    }

    @Override // lx.b
    public String b() {
        if (!n()) {
            return this.f415711b.b();
        }
        return this.f415710a.c("extra", null);
    }

    @Override // lx.b
    public String c() {
        if (!n()) {
            return this.f415711b.c();
        }
        return this.f415710a.c("jump", null);
    }

    @Override // lx.b
    public String d() {
        if (!n()) {
            return this.f415711b.d();
        }
        return this.f415710a.c("offlineHtml", null);
    }

    @Override // lx.b
    public JSONObject e() throws JSONException {
        if (!n()) {
            return this.f415711b.e();
        }
        String c16 = this.f415710a.c(MarkdownConfigApiImpl.KEY_SCHEME_WHITE_LIST, null);
        if (c16 == null) {
            return null;
        }
        return new JSONObject(c16);
    }

    @Override // lx.b
    @UiThread
    public int f(String str, String str2) {
        if (!n()) {
            int f16 = this.f415711b.f(str, str2);
            if (b.h(f16) || !b.g(f16)) {
                return f16;
            }
        }
        ConcurrentHashMap<String, Set<String>> concurrentHashMap = this.f415714c;
        if (concurrentHashMap.size() == 0) {
            concurrentHashMap = o();
        }
        if (concurrentHashMap.size() == 0) {
            QLog.e("AuthorizeConfig", 1, "can not find any JS API, so return!");
            return i(false, true);
        }
        Set<String> keySet = concurrentHashMap.keySet();
        if (keySet.size() == 0) {
            QLog.e("AuthorizeConfig", 1, "JS API keySet empty, so return!");
            return i(false, true);
        }
        if (!TextUtils.isEmpty(str)) {
            str = str.toLowerCase();
        }
        for (String str3 : keySet) {
            if (AuthorizeConfig.P(str3, str)) {
                Set<String> set = concurrentHashMap.get(str3);
                if (set != null && set.size() != 0) {
                    HashSet hashSet = new HashSet(set.size());
                    hashSet.addAll(set);
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        if (AuthorizeConfig.P((String) it.next(), str2)) {
                            return i(true, false);
                        }
                    }
                } else {
                    QLog.e("AuthorizeConfig", 1, "JS API list empty, pattern: ", str3, ", domain: ", str);
                }
            }
        }
        QLog.e("AuthorizeConfig", 1, "hasCommandRight white size " + concurrentHashMap.size());
        return i(false, false);
    }

    public void j() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f415714c.clear();
            QLog.d("AuthorizeConfig", 1, "clearJsApiList");
        } else if (this.f415714c.size() > 0) {
            this.f415715d.sendEmptyMessage(1);
            QLog.d("AuthorizeConfig", 1, "post clearJsApiList");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x01ad A[Catch: Exception -> 0x01e0, TryCatch #9 {Exception -> 0x01e0, blocks: (B:40:0x019d, B:42:0x01ad, B:44:0x01c5, B:46:0x01d1, B:48:0x01d8), top: B:39:0x019d }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0226  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String k(j jVar, String str) throws Exception {
        String str2;
        String str3;
        int length;
        int i3;
        JSONArray jSONArray;
        ConcurrentHashMap concurrentHashMap;
        JSONArray jSONArray2;
        String str4 = QZoneImageUtils.KEY_MATCH;
        String str5 = "publishSeq";
        JSONObject jSONObject = new JSONObject(str);
        String str6 = "";
        try {
            jSONArray = jSONObject.getJSONArray("allow");
            concurrentHashMap = new ConcurrentHashMap(50);
            try {
            } catch (Exception e16) {
                e = e16;
            } catch (OutOfMemoryError e17) {
                e = e17;
            }
        } catch (Exception e18) {
            e = e18;
            str2 = str4;
            str3 = str5;
        } catch (OutOfMemoryError e19) {
            e = e19;
            str2 = str4;
            str3 = str5;
        }
        if (jSONArray != null && jSONArray.length() > 0) {
            jVar.e("cmd_config_new", jSONArray.toString());
            int length2 = jSONArray.length();
            int i16 = 0;
            while (i16 < length2) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i16);
                JSONArray optJSONArray = optJSONObject.optJSONArray(DTConstants.TAG.API);
                JSONArray optJSONArray2 = optJSONObject.optJSONArray(str4);
                JSONArray jSONArray3 = jSONArray;
                int length3 = optJSONArray2.length();
                int i17 = length2;
                int i18 = 0;
                while (i18 < length3) {
                    int i19 = length3;
                    String string = optJSONArray2.getString(i18);
                    Set set = (Set) concurrentHashMap.get(string);
                    if (set == null) {
                        jSONArray2 = optJSONArray2;
                        try {
                            str3 = str5;
                        } catch (Exception e26) {
                            e = e26;
                            str3 = str5;
                            str2 = str4;
                            str6 = "" + e.getMessage();
                            jVar.e("offlineHtml", jSONObject.getJSONObject("offline").toString());
                            jVar.e("extra", jSONObject.getJSONObject("ext").toString());
                            jVar.e("jump", jSONObject.getJSONObject("jump").toString());
                            JSONObject jSONObject2 = new JSONObject();
                            JSONArray jSONArray4 = jSONObject.getJSONArray(MarkdownConfigApiImpl.KEY_SCHEME_WHITE_LIST);
                            length = jSONArray4.length();
                            i3 = 0;
                            while (i3 < length) {
                            }
                            jVar.e(MarkdownConfigApiImpl.KEY_SCHEME_WHITE_LIST, jSONObject2.toString());
                            String str7 = str3;
                            jVar.d(str7, Long.valueOf(jSONObject.getLong(str7)));
                            while (r11 < r3) {
                            }
                            return str6;
                        } catch (OutOfMemoryError e27) {
                            e = e27;
                            str3 = str5;
                            str2 = str4;
                            str6 = "" + e.getMessage();
                            jVar.e("offlineHtml", jSONObject.getJSONObject("offline").toString());
                            jVar.e("extra", jSONObject.getJSONObject("ext").toString());
                            jVar.e("jump", jSONObject.getJSONObject("jump").toString());
                            JSONObject jSONObject22 = new JSONObject();
                            JSONArray jSONArray42 = jSONObject.getJSONArray(MarkdownConfigApiImpl.KEY_SCHEME_WHITE_LIST);
                            length = jSONArray42.length();
                            i3 = 0;
                            while (i3 < length) {
                            }
                            jVar.e(MarkdownConfigApiImpl.KEY_SCHEME_WHITE_LIST, jSONObject22.toString());
                            String str72 = str3;
                            jVar.d(str72, Long.valueOf(jSONObject.getLong(str72)));
                            while (r11 < r3) {
                            }
                            return str6;
                        }
                        try {
                            set = Collections.synchronizedSet(new HashSet(20));
                        } catch (Exception e28) {
                            e = e28;
                            str2 = str4;
                            str6 = "" + e.getMessage();
                            jVar.e("offlineHtml", jSONObject.getJSONObject("offline").toString());
                            jVar.e("extra", jSONObject.getJSONObject("ext").toString());
                            jVar.e("jump", jSONObject.getJSONObject("jump").toString());
                            JSONObject jSONObject222 = new JSONObject();
                            JSONArray jSONArray422 = jSONObject.getJSONArray(MarkdownConfigApiImpl.KEY_SCHEME_WHITE_LIST);
                            length = jSONArray422.length();
                            i3 = 0;
                            while (i3 < length) {
                            }
                            jVar.e(MarkdownConfigApiImpl.KEY_SCHEME_WHITE_LIST, jSONObject222.toString());
                            String str722 = str3;
                            jVar.d(str722, Long.valueOf(jSONObject.getLong(str722)));
                            while (r11 < r3) {
                            }
                            return str6;
                        } catch (OutOfMemoryError e29) {
                            e = e29;
                            str2 = str4;
                            str6 = "" + e.getMessage();
                            jVar.e("offlineHtml", jSONObject.getJSONObject("offline").toString());
                            jVar.e("extra", jSONObject.getJSONObject("ext").toString());
                            jVar.e("jump", jSONObject.getJSONObject("jump").toString());
                            JSONObject jSONObject2222 = new JSONObject();
                            JSONArray jSONArray4222 = jSONObject.getJSONArray(MarkdownConfigApiImpl.KEY_SCHEME_WHITE_LIST);
                            length = jSONArray4222.length();
                            i3 = 0;
                            while (i3 < length) {
                            }
                            jVar.e(MarkdownConfigApiImpl.KEY_SCHEME_WHITE_LIST, jSONObject2222.toString());
                            String str7222 = str3;
                            jVar.d(str7222, Long.valueOf(jSONObject.getLong(str7222)));
                            while (r11 < r3) {
                            }
                            return str6;
                        }
                    } else {
                        str3 = str5;
                        jSONArray2 = optJSONArray2;
                    }
                    Set set2 = set;
                    int length4 = optJSONArray.length();
                    String str8 = str4;
                    int i26 = 0;
                    while (i26 < length4) {
                        int i27 = length4;
                        set2.add(optJSONArray.getString(i26));
                        i26++;
                        length4 = i27;
                    }
                    concurrentHashMap.put(string, set2);
                    i18++;
                    length3 = i19;
                    str4 = str8;
                    optJSONArray2 = jSONArray2;
                    str5 = str3;
                }
                i16++;
                jSONArray = jSONArray3;
                length2 = i17;
            }
            str2 = str4;
            str3 = str5;
            if (this.f415715d.hasMessages(1)) {
                this.f415715d.removeMessages(1);
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = concurrentHashMap;
            this.f415715d.sendMessage(obtain);
            try {
                jVar.e("offlineHtml", jSONObject.getJSONObject("offline").toString());
            } catch (JSONException e36) {
                str6 = str6 + "|" + e36.getMessage();
            }
            try {
                jVar.e("extra", jSONObject.getJSONObject("ext").toString());
            } catch (JSONException e37) {
                str6 = str6 + "|" + e37.getMessage();
            }
            try {
                jVar.e("jump", jSONObject.getJSONObject("jump").toString());
            } catch (JSONException e38) {
                str6 = str6 + "|" + e38.getMessage();
            }
            try {
                JSONObject jSONObject22222 = new JSONObject();
                JSONArray jSONArray42222 = jSONObject.getJSONArray(MarkdownConfigApiImpl.KEY_SCHEME_WHITE_LIST);
                length = jSONArray42222.length();
                i3 = 0;
                while (i3 < length) {
                    JSONObject jSONObject3 = jSONArray42222.getJSONObject(i3);
                    JSONArray jSONArray5 = jSONObject3.getJSONArray(ZPlanPublishSource.FROM_SCHEME);
                    String str9 = str2;
                    JSONArray jSONArray6 = jSONObject3.getJSONArray(str9);
                    int length5 = jSONArray6.length();
                    for (int i28 = 0; i28 < length5; i28++) {
                        jSONObject22222.put(jSONArray6.getString(i28), jSONArray5);
                    }
                    i3++;
                    str2 = str9;
                }
                jVar.e(MarkdownConfigApiImpl.KEY_SCHEME_WHITE_LIST, jSONObject22222.toString());
            } catch (Exception e39) {
                str6 = str6 + "|" + e39.getMessage();
            }
            String str72222 = str3;
            try {
                jVar.d(str72222, Long.valueOf(jSONObject.getLong(str72222)));
            } catch (Exception e46) {
                QLog.e("AuthorizeConfig", 1, "parse publishSeq error:" + e46.getMessage());
            }
            for (String str10 : AuthorizeConfig.f78108z) {
                try {
                    JSONArray jSONArray7 = jSONObject.getJSONArray(str10);
                    jVar.e(str10, jSONArray7.toString());
                    if (QLog.isColorLevel()) {
                        QLog.d("AuthorizeConfig", 2, "Server " + str10 + " config= " + jSONArray7);
                    }
                } catch (JSONException e47) {
                    str6 = str6 + "|" + e47.getMessage();
                }
            }
            return str6;
        }
        QLog.e("AuthorizeConfig", 1, "update allow JSAPI are all empty!");
        return null;
    }

    public boolean n() {
        return true;
    }

    @NonNull
    public ConcurrentHashMap<String, Set<String>> o() {
        int size;
        int i3;
        boolean z16;
        ConcurrentHashMap<String, Set<String>> m3 = m();
        if (m3 == null) {
            size = 0;
        } else {
            size = m3.size();
        }
        if (size == 0 && (m3 = l()) != null) {
            i3 = m3.size();
        } else {
            i3 = 0;
        }
        if (m3 == null) {
            m3 = new ConcurrentHashMap<>();
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("AuthorizeConfig", 1, "loadFromCache countCache=", Integer.valueOf(size), ", countDefault=", Integer.valueOf(i3), ", isMain=", Boolean.valueOf(z16));
        if (z16) {
            this.f415714c.clear();
            this.f415714c.putAll(m3);
        } else if (!this.f415715d.hasMessages(1)) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = m3;
            this.f415715d.sendMessage(obtain);
        }
        return m3;
    }
}
