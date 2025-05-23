package com.tencent.mobileqq.profile.like;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f260233a;

    /* renamed from: b, reason: collision with root package name */
    public String f260234b;

    /* renamed from: c, reason: collision with root package name */
    public String f260235c;

    /* renamed from: d, reason: collision with root package name */
    public int f260236d;

    /* renamed from: e, reason: collision with root package name */
    public String f260237e;

    /* renamed from: f, reason: collision with root package name */
    public Bitmap f260238f;

    /* renamed from: g, reason: collision with root package name */
    public String f260239g;

    /* renamed from: h, reason: collision with root package name */
    public Bitmap f260240h;

    /* renamed from: i, reason: collision with root package name */
    public String f260241i;

    /* renamed from: j, reason: collision with root package name */
    public Bitmap f260242j;

    /* renamed from: k, reason: collision with root package name */
    public String f260243k;

    /* renamed from: l, reason: collision with root package name */
    public String f260244l;

    public d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.f260233a = i3;
        }
    }

    private static String a(String str) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            QLog.e("PraiseInfo", 1, str + " not exist!");
            return null;
        }
        try {
            return FileUtils.readFileToString(file);
        } catch (OutOfMemoryError e16) {
            if (QLog.isColorLevel()) {
                QLog.e("PraiseInfo", 2, e16.getMessage());
            }
            return null;
        }
    }

    public static d b(int i3, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String a16 = a(str);
            if (TextUtils.isEmpty(a16)) {
                return null;
            }
            if (QLog.isColorLevel()) {
                QLog.d("PraiseInfo", 2, "content:" + a16);
            }
            JSONObject jSONObject = new JSONObject(a16);
            d dVar = new d(i3);
            dVar.f260234b = jSONObject.optString("name");
            dVar.f260235c = jSONObject.optString("text");
            if (jSONObject.has("color")) {
                String trim = jSONObject.optString("color").trim();
                if (trim.startsWith(RelationNTPushServiceImpl.PRE_HEX_STRING)) {
                    trim = trim.substring(2);
                }
                try {
                    dVar.f260236d = Color.parseColor("#" + trim);
                } catch (Exception unused) {
                    if (QLog.isColorLevel()) {
                        QLog.d("PraiseInfo", 2, "color invalid");
                    }
                }
            }
            return dVar;
        } catch (IOException e16) {
            QLog.e("PraiseInfo", 1, "parsePraiseInfo failed with IOException.", e16);
            return null;
        } catch (JSONException e17) {
            QLog.e("PraiseInfo", 1, "parsePraiseInfo failed with JsonException.", e17);
            return null;
        }
    }
}
