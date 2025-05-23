package com.tencent.mobileqq.manager;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.identity.e;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.config.l;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import com.tencent.util.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes15.dex */
public class QSafeConfigProcessor extends l<c> {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/QQSafeBlockApi/Inject_SecurityBlockConfig.yml", version = 1)
    protected static ArrayList<Class<? extends e>> f243588b;

    /* renamed from: a, reason: collision with root package name */
    private List<e> f243589a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21879);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
            return;
        }
        ArrayList<Class<? extends e>> arrayList = new ArrayList<>();
        f243588b = arrayList;
        arrayList.add(o.class);
        f243588b.add(com.tencent.mobileqq.safe.a.class);
    }

    public QSafeConfigProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f243589a = new ArrayList();
        try {
            Iterator<Class<? extends e>> it = f243588b.iterator();
            while (it.hasNext()) {
                this.f243589a.add(it.next().newInstance());
            }
        } catch (Exception e16) {
            QLog.e("QSafeConfigProcessor", 1, "QSafeConfigProcessor new instance error : ", e16);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public c migrateOldOrDefaultContent(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (c) iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
        QLog.d("QSafeConfigProcessor", 1, "migrateOldOrDefaultContent");
        c cVar = new c();
        cVar.d(-1);
        Iterator<e> it = this.f243589a.iterator();
        while (it.hasNext()) {
            it.next().a(cVar);
        }
        return cVar;
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c onParsed(ai[] aiVarArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (c) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aiVarArr);
        }
        QLog.d("QSafeConfigProcessor", 1, "onParsed");
        if (aiVarArr != null && aiVarArr.length != 0) {
            ai aiVar = aiVarArr[0];
            String str = aiVar.f202268b;
            c cVar = new c();
            cVar.d(aiVar.f202267a);
            Iterator<e> it = this.f243589a.iterator();
            while (it.hasNext()) {
                it.next().b(cVar, str);
            }
            QLog.d("QSafeConfigProcessor", 1, "parsed bean : ", cVar);
            return cVar;
        }
        QLog.d("QSafeConfigProcessor", 1, "onParsed, but confFiles is empty");
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) cVar);
        } else {
            QLog.d("QSafeConfigProcessor", 1, "onUpdate");
            a.b().a(cVar);
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
        return -1;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        QLog.d("QSafeConfigProcessor", 1, "onReqFailed");
        a.b().a((c) am.s().x(TMAssistantDownloadErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION));
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqNoReceive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onReqNoReceive();
            QLog.d("QSafeConfigProcessor", 1, "onReqNoReceive");
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return TMAssistantDownloadErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION;
    }
}
