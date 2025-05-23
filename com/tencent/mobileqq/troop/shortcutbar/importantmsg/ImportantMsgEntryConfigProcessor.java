package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.l;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import javax.annotation.Nullable;

/* loaded from: classes19.dex */
public class ImportantMsgEntryConfigProcessor extends l<c> {
    static IPatchRedirector $redirector_;

    public ImportantMsgEntryConfigProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public c migrateOldOrDefaultContent(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (c) iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
        QLog.d("ImportantMsgEntryConfigProcessor", 2, "migrateOldOrDefaultContent, type: " + i3);
        return new c();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c onParsed(ai[] aiVarArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (c) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aiVarArr);
        }
        if (aiVarArr != null && aiVarArr.length > 0) {
            return c.a(aiVarArr);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) cVar);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<c> clazz() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return c.class;
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
        return true;
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
            return;
        }
        QLog.d("ImportantMsgEntryConfigProcessor", 1, "onReqFailed, failCode = " + i3);
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 658;
    }
}
