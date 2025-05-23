package com.tencent.mobileqq.comment.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.config.l;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class DanmuConfProcessor extends l<a> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static boolean f201764a;

    public DanmuConfProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean a() {
        a aVar = (a) am.s().x(PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT);
        if (aVar != null && !TextUtils.isEmpty(aVar.f201765a)) {
            f201764a = "1".equals(aVar.f201765a);
        }
        return f201764a;
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a migrateOldOrDefaultContent(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (a) iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
        return new a();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a onParsed(ai[] aiVarArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (a) iPatchRedirector.redirect((short) 5, (Object) this, (Object) aiVarArr);
        }
        if (aiVarArr != null && aiVarArr.length > 0) {
            a e16 = e(aiVarArr[0].f202268b);
            if (QLog.isColorLevel()) {
                QLog.d("DanmuConfProcessor", 2, "onParsed " + aiVarArr[0].f202268b);
            }
            return e16;
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
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onUpdate(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
            return;
        }
        if (aVar != null && !TextUtils.isEmpty(aVar.f201765a)) {
            f201764a = "1".equals(aVar.f201765a);
            if (QLog.isColorLevel()) {
                QLog.e("DanmuConfProcessor", 2, "onUpdate, isDanmuEnable:" + f201764a);
            }
        }
    }

    public a e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        try {
            String optString = new JSONObject(str).optString("IsDanmuEnable");
            if (QLog.isColorLevel()) {
                QLog.e("DanmuConfProcessor", 2, "parse conf, IsDanmuEnable:" + optString);
            }
            return new a(optString.trim());
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
        return PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT;
    }

    /* loaded from: classes5.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f201765a;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.f201765a = "";
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.f201765a = str;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
        }
    }
}
