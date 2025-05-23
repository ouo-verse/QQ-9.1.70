package com.tencent.mobileqq.comment.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.config.l;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class ImmersiveConfProcessor extends l<a> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static boolean f201766a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f201767b;

    public ImmersiveConfProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean a() {
        a aVar = (a) am.s().x(579);
        if (aVar != null && !TextUtils.isEmpty(aVar.f201768a)) {
            f201766a = "1".equals(aVar.f201768a);
        }
        return f201766a;
    }

    public static boolean b() {
        a aVar = (a) am.s().x(579);
        if (aVar != null && !TextUtils.isEmpty(aVar.f201769b)) {
            f201767b = "1".equals(aVar.f201769b);
        }
        return f201767b;
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a migrateOldOrDefaultContent(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (a) iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
        return new a();
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<a> clazz() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Class) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return a.class;
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public a onParsed(ai[] aiVarArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (a) iPatchRedirector.redirect((short) 5, (Object) this, (Object) aiVarArr);
        }
        if (aiVarArr != null && aiVarArr.length > 0) {
            a f16 = f(aiVarArr[0].f202268b);
            if (QLog.isColorLevel()) {
                QLog.d("ImmersiveConfProcessor", 2, "onParsed " + aiVarArr[0].f202268b);
            }
            return f16;
        }
        return new a();
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onUpdate(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
            return;
        }
        if (aVar != null) {
            if (TextUtils.isEmpty(aVar.f201768a)) {
                f201766a = "1".equals(aVar.f201768a);
            }
            if (TextUtils.isEmpty(aVar.f201769b)) {
                f201767b = "1".equals(aVar.f201769b);
            }
        }
    }

    public a f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("IsImageImmersiveEnable");
            String optString2 = jSONObject.optString("IsVideoImmersiveEnable");
            if (QLog.isColorLevel()) {
                QLog.e("ImmersiveConfProcessor", 2, "ImmersiveConfBean, isImgEnable:" + optString + ", isVdoEnable:" + optString2);
            }
            return new a(optString.trim(), optString2.trim());
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedCompressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedStoreLargeFile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    public int migrateOldVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 579;
    }

    /* loaded from: classes5.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f201768a;

        /* renamed from: b, reason: collision with root package name */
        public String f201769b;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f201768a = "";
                this.f201769b = "";
            }
        }

        public a(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            } else {
                this.f201768a = str;
                this.f201769b = str2;
            }
        }
    }
}
