package com.tencent.mobileqq.troop.recommend;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.l;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import org.json.JSONObject;

/* loaded from: classes19.dex */
public class TDCRecomTroopConfigProcessor extends l<a> {
    static IPatchRedirector $redirector_;

    /* loaded from: classes19.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public boolean f298240a;

        /* renamed from: b, reason: collision with root package name */
        public String f298241b;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f298241b = "";
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static a a(String str) {
            a aVar;
            Exception e16;
            boolean z16;
            a aVar2 = null;
            if (str != null) {
                try {
                    aVar = new a();
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        if (jSONObject.optInt(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH) == 1) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        aVar.f298240a = z16;
                        aVar.f298241b = jSONObject.optString("tipText");
                    } catch (Exception e17) {
                        e16 = e17;
                        QLog.d("TDCRecomTroopConfigProcessor", 1, "convertFromJSONObject exception ", e16);
                        aVar2 = aVar;
                        if (QLog.isColorLevel()) {
                        }
                        return aVar2;
                    }
                } catch (Exception e18) {
                    aVar = null;
                    e16 = e18;
                }
                aVar2 = aVar;
            }
            if (QLog.isColorLevel()) {
                QLog.d("TDCRecomTroopConfigProcessor", 2, "convertFromJSONObject ,content = " + str + ",result = " + aVar2);
            }
            return aVar2;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "[displayOrNot:" + this.f298240a + ",title:" + this.f298241b + "]";
        }
    }

    public TDCRecomTroopConfigProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a migrateOldOrDefaultContent(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (a) iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
        return new a();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a onParsed(ai[] aiVarArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aiVarArr);
        }
        if (aiVarArr != null && aiVarArr.length != 0) {
            String str = aiVarArr[0].f202268b;
            if (QLog.isColorLevel()) {
                QLog.d("TDCRecomTroopConfigProcessor", 2, " onParsed,configID:547, content:" + str);
            }
            return a.a(str);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<a> clazz() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return a.class;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedCompressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedStoreLargeFile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    public int migrateOldVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 547;
    }
}
