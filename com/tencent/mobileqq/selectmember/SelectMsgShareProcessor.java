package com.tencent.mobileqq.selectmember;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

/* loaded from: classes18.dex */
public class SelectMsgShareProcessor extends BaseConfigParser<a> {
    static IPatchRedirector $redirector_;

    /* loaded from: classes18.dex */
    public static class a implements IConfigData {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public int f285785d;

        /* renamed from: e, reason: collision with root package name */
        public int f285786e;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f285785d = 5;
                this.f285786e = 100;
            }
        }

        public static a a(String str) {
            a aVar = new a();
            try {
                StringBuilder sb5 = new StringBuilder();
                QLog.d("SelectMsgShareProcessor", 1, "content=", str);
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("maxSelectTime")) {
                    aVar.f285785d = jSONObject.optInt("maxSelectTime", aVar.f285785d);
                }
                if (jSONObject.has("maxSelectNumber")) {
                    aVar.f285786e = jSONObject.optInt("maxSelectNumber", aVar.f285786e);
                }
                sb5.append("config: ");
                sb5.append(str);
                sb5.append(",");
                QLog.d("SelectMsgShareProcessor", 1, "parse, content:" + ((Object) sb5));
                return aVar;
            } catch (Exception e16) {
                QLog.e("SelectMsgShareProcessor", 1, "JSONException", e16);
                return new a();
            }
        }

        @NonNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "SelectMsgShareBean{mDaysUpperLimit=" + this.f285785d + ", mMsgNumUpperLimit=" + this.f285786e + '}';
        }
    }

    public SelectMsgShareProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a defaultConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new a();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            return;
        }
        super.doOnConfigUpdate(aVar);
        if (QLog.isColorLevel()) {
            QLog.d("SelectMsgShareProcessor", 2, "onUpdate " + aVar.toString());
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public a parse(@NonNull byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bArr);
        }
        String str = new String(bArr, StandardCharsets.UTF_8);
        QLog.d("SelectMsgShareProcessor", 1, "onParsed confFiles.length=", Integer.valueOf(str.length()), " config: ", str);
        if (!TextUtils.isEmpty(str)) {
            return a.a(str);
        }
        return new a();
    }
}
