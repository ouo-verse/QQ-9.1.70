package com.tencent.mobileqq.activity.contacts.mayknow;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.l;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class ReportExposeConfigProcessor extends l<ContactReportUtils.a> {
    static IPatchRedirector $redirector_;

    public ReportExposeConfigProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ContactReportUtils.a migrateOldOrDefaultContent(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ContactReportUtils.a) iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
        if (QLog.isColorLevel()) {
            QLog.d("ReportExposeConfigProcessor", 2, "migrateOldOrDefaultContent");
        }
        return new ContactReportUtils.a();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ContactReportUtils.a onParsed(ai[] aiVarArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ContactReportUtils.a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aiVarArr);
        }
        if (QLog.isColorLevel()) {
            QLog.d("ReportExposeConfigProcessor", 2, "onParsed :" + aiVarArr);
            if (aiVarArr != null) {
                for (ai aiVar : aiVarArr) {
                    if (aiVar != null) {
                        QLog.d("ReportExposeConfigProcessor", 2, "onParsed item: " + aiVar.f202268b);
                    }
                }
            }
        }
        if (aiVarArr != null && aiVarArr.length > 0) {
            for (ai aiVar2 : aiVarArr) {
                if (aiVar2 != null && !TextUtils.isEmpty(aiVar2.f202268b)) {
                    try {
                        ContactReportUtils.a aVar = new ContactReportUtils.a();
                        JSONObject jSONObject = new JSONObject(aiVar2.f202268b);
                        if (jSONObject.has("enable")) {
                            aVar.f181626a = jSONObject.getBoolean("enable");
                        }
                        if (jSONObject.has(WidgetCacheConstellationData.INTERVAL)) {
                            aVar.f181627b = jSONObject.getLong(WidgetCacheConstellationData.INTERVAL);
                        }
                        return aVar;
                    } catch (Throwable th5) {
                        QLog.e("ReportExposeConfigProcessor", 1, th5, new Object[0]);
                    }
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(ContactReportUtils.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ReportExposeConfigProcessor", 2, "onUpdate");
        }
        if (aVar != null) {
            ContactReportUtils.k(aVar);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<ContactReportUtils.a> clazz() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return ContactReportUtils.a.class;
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
        if (QLog.isColorLevel()) {
            QLog.d("ReportExposeConfigProcessor", 2, "migrateOldVersion");
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else if (QLog.isColorLevel()) {
            QLog.d("ReportExposeConfigProcessor", 2, "onReqFailed, code = " + i3);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 438;
    }
}
