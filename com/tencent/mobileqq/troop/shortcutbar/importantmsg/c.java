package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.raft.codegenmeta.utils.Constants;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private HashMap<Integer, a> f298726a;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        HashMap<Integer, a> hashMap = new HashMap<>();
        this.f298726a = hashMap;
        hashMap.put(1, new a("https://pub.idqqimg.com/pc/misc/files/20191009/8e2e317d4dfb00cbf7765c38a049d4c1k1j13h02.png", 1L, 0, ""));
        this.f298726a.put(2, new a("https://pub.idqqimg.com/pc/misc/files/20200324/5a1434be69aa5a61dca2e97db65cf50b.png", 1101236949L, 0, ""));
        this.f298726a.put(3, new a("https://pub.idqqimg.com/pc/misc/files/20191009/8e2e317d4dfb00cbf7765c38a049d4c1k1j17n0g.png", 101786420L, 0, ""));
        this.f298726a.put(4, new a("https://pub.idqqimg.com/pc/misc/files/20191009/8e2e317d4dfb00cbf7765c38a049d4c1k1j16hii.png", 1104445552L, 0, ""));
        this.f298726a.put(5, new a("https://pub.idqqimg.com/pc/misc/files/20180702/b836834dfbe493017b8767425c0d23e8jj3xilnn.png", ITeamWorkUtils.DOCS_APPID, 0, ""));
        this.f298726a.put(6, new a("https://pub.idqqimg.com/pc/misc/files/20190620/da7e017785e02546d81a93f6885b7c3fjx4cf6io.png", 1108961705L, 0, ""));
    }

    public static c a(ai[] aiVarArr) {
        int i3;
        c cVar = new c();
        for (ai aiVar : aiVarArr) {
            String str = aiVar.f202268b;
            if (!TextUtils.isEmpty(str)) {
                try {
                    HashMap<Integer, a> hashMap = new HashMap<>();
                    JSONArray optJSONArray = new JSONObject(str).optJSONArray(Constants.Configs.CONFIGS);
                    if (optJSONArray != null) {
                        for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                            a aVar = new a();
                            JSONObject jSONObject = optJSONArray.getJSONObject(i16);
                            if (jSONObject != null) {
                                i3 = jSONObject.optInt("t");
                                aVar.f298727a = jSONObject.optString("url");
                                aVar.f298728b = jSONObject.optLong("id");
                                aVar.f298729c = jSONObject.optInt("titletype");
                                aVar.f298730d = jSONObject.optString("deftitle");
                            } else {
                                i3 = -1;
                            }
                            hashMap.put(Integer.valueOf(i3), aVar);
                        }
                    }
                    cVar.c(hashMap);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("ImportantMsgEntryConfig", 2, cVar.toString());
        }
        return cVar;
    }

    public a b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        return this.f298726a.get(Integer.valueOf(i3));
    }

    protected void c(HashMap<Integer, a> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) hashMap);
        } else if (hashMap != null) {
            this.f298726a.clear();
            this.f298726a.putAll(hashMap);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f298726a.toString();
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f298727a;

        /* renamed from: b, reason: collision with root package name */
        public long f298728b;

        /* renamed from: c, reason: collision with root package name */
        public int f298729c;

        /* renamed from: d, reason: collision with root package name */
        public String f298730d;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f298727a = "";
            this.f298728b = -1L;
            this.f298729c = -1;
            this.f298730d = "";
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "iconUrl" + ContainerUtils.KEY_VALUE_DELIMITER + this.f298727a + ", appid" + ContainerUtils.KEY_VALUE_DELIMITER + this.f298728b + ", titleType" + ContainerUtils.KEY_VALUE_DELIMITER + this.f298729c + ", defTitle" + ContainerUtils.KEY_VALUE_DELIMITER + this.f298730d;
        }

        public a(String str, long j3, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Long.valueOf(j3), Integer.valueOf(i3), str2);
                return;
            }
            this.f298727a = str;
            this.f298728b = j3;
            this.f298729c = i3;
            this.f298730d = str2;
        }
    }
}
