package com.tencent.mobileqq.springhb.preload;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f289507a;

    /* renamed from: b, reason: collision with root package name */
    public JSONArray f289508b;

    /* renamed from: c, reason: collision with root package name */
    public List<SpringHbZipMappingBean> f289509c;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends TypeToken<List<SpringHbZipMappingBean>> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this);
            }
        }
    }

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f289508b = new JSONArray();
            this.f289509c = new ArrayList();
        }
    }

    public static h a(int i3, String str) throws Exception {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        h hVar = new h();
        JSONObject jSONObject = new JSONObject(str);
        hVar.f289507a = i3;
        hVar.f289508b = b(jSONObject);
        hVar.f289509c = c(jSONObject);
        return hVar;
    }

    private static JSONArray b(JSONObject jSONObject) {
        JSONArray jSONArray = new JSONArray();
        JSONArray optJSONArray = jSONObject.optJSONArray("module_config");
        if (optJSONArray != null) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                jSONArray.mo162put(optJSONArray.optJSONObject(i3));
            }
        }
        return jSONArray;
    }

    private static List<SpringHbZipMappingBean> c(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("module_config");
        if (optJSONArray != null) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONArray optJSONArray2 = optJSONArray.optJSONObject(i3).optJSONArray("zip_resources");
                if (optJSONArray2 != null) {
                    for (int i16 = 0; i16 < optJSONArray2.length(); i16++) {
                        JSONObject optJSONObject = optJSONArray2.optJSONObject(i16);
                        SpringHbZipMappingBean springHbZipMappingBean = new SpringHbZipMappingBean();
                        String optString = optJSONObject.optString("zip_res_id");
                        String str = "";
                        if (TextUtils.isEmpty(optString)) {
                            optString = "";
                        }
                        springHbZipMappingBean.zipResId = optString;
                        String optString2 = optJSONObject.optString("res_name");
                        if (TextUtils.isEmpty(optString2)) {
                            optString2 = "";
                        }
                        springHbZipMappingBean.resName = optString2;
                        String optString3 = optJSONObject.optString("url");
                        if (!TextUtils.isEmpty(optString3)) {
                            str = optString3;
                        }
                        springHbZipMappingBean.url = str;
                        arrayList.add(springHbZipMappingBean);
                    }
                }
            }
        }
        return arrayList;
    }

    public void d(ObjectInputStream objectInputStream) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) objectInputStream);
            return;
        }
        try {
            this.f289507a = objectInputStream.readInt();
            this.f289508b = new JSONArray(objectInputStream.readUTF());
            this.f289509c = (List) new Gson().fromJson(objectInputStream.readUTF(), new a().getType());
        } catch (JSONException unused) {
            this.f289507a = 0;
            this.f289508b = new JSONArray();
            this.f289509c = new ArrayList();
        }
    }

    public void e(ObjectOutputStream objectOutputStream) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) objectOutputStream);
            return;
        }
        objectOutputStream.writeInt(this.f289507a);
        objectOutputStream.writeUTF(this.f289508b.toString());
        objectOutputStream.writeUTF(new Gson().toJson(this.f289509c));
    }
}
