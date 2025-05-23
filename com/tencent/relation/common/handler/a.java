package com.tencent.relation.common.handler;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$RspBody;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class a implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Map<Class<? extends c>, c> f364721a;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f364721a = new HashMap();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0081 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0082  */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private c a(Class<? extends c> cls) {
        c cVar;
        if (this.f364721a.containsKey(cls)) {
            cVar = this.f364721a.get(cls);
        } else {
            try {
                c newInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
                if (newInstance instanceof c) {
                    cVar = newInstance;
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("AbsBusinessManagerFor0x5eb", 1, "obj not instanceof I0x5ebHandlerProcessor");
                    }
                    return null;
                }
            } catch (IllegalAccessException e16) {
                QLog.d("AbsBusinessManagerFor0x5eb", 1, String.format("e:%s", e16.toString()));
                cVar = null;
                if (cVar == null) {
                }
            } catch (InstantiationException e17) {
                QLog.d("AbsBusinessManagerFor0x5eb", 1, String.format("e:%s", e17.toString()));
                cVar = null;
                if (cVar == null) {
                }
            } catch (NoSuchMethodException e18) {
                QLog.d("AbsBusinessManagerFor0x5eb", 1, String.format("e:%s", e18.toString()));
                cVar = null;
                if (cVar == null) {
                }
            } catch (InvocationTargetException e19) {
                QLog.d("AbsBusinessManagerFor0x5eb", 1, String.format("e:%s", e19.toString()));
                cVar = null;
                if (cVar == null) {
                }
            }
        }
        if (cVar == null) {
            return null;
        }
        int businessType = cVar.getBusinessType();
        boolean a16 = com.tencent.relation.common.config.toggle.b.a(businessType);
        if (QLog.isColorLevel()) {
            QLog.i("AbsBusinessManagerFor0x5eb", 1, String.format("enter get0x5ebHandlerProcessor clazz \uff1a%s, businessType: %s useMergeReq\uff1a%b", cVar.getClass().getName(), String.valueOf(businessType), Boolean.valueOf(a16)));
        }
        if (!a16) {
            return null;
        }
        this.f364721a.put(cls, cVar);
        return cVar;
    }

    public abstract List<Class<? extends c>> b();

    @Override // com.tencent.relation.common.handler.c
    public oidb_0x5eb$ReqBody get0x5ebReqBody(Bundle bundle, @NonNull oidb_0x5eb$ReqBody oidb_0x5eb_reqbody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (oidb_0x5eb$ReqBody) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle, (Object) oidb_0x5eb_reqbody);
        }
        if (oidb_0x5eb_reqbody == null) {
            new RuntimeException("mergeReqBody allow not null!!!!");
        }
        List<Class<? extends c>> b16 = b();
        if (b16 != null && b16.size() != 0) {
            for (Class<? extends c> cls : b16) {
                c a16 = a(cls);
                if (a16 == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AbsBusinessManagerFor0x5eb", 1, String.format("get0x5ebReqBody null == handlerProcessor ,  clazz name is :%s", cls.getClass().getName()));
                    }
                } else {
                    oidb_0x5eb_reqbody = a16.get0x5ebReqBody(bundle, oidb_0x5eb_reqbody);
                    if (oidb_0x5eb_reqbody == null) {
                        new RuntimeException("mergeReqBody allow not null!!!!");
                    }
                }
            }
            return oidb_0x5eb_reqbody;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AbsBusinessManagerFor0x5eb", 1, "null == handlerProcessors || handlerProcessors.size() == 0");
            return null;
        }
        return null;
    }

    @Override // com.tencent.relation.common.handler.c
    public int getBusinessType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.relation.common.handler.c
    public Bundle getRequestExtraData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bundle) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Bundle bundle = new Bundle();
        for (Class<? extends c> cls : b()) {
            c a16 = a(cls);
            if (a16 == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("AbsBusinessManagerFor0x5eb", 1, String.format("onReceive null == handlerProcessor ,  clazz name is :%s", cls.getClass().getName()));
                }
            } else {
                Bundle requestExtraData = a16.getRequestExtraData();
                if (requestExtraData != null) {
                    bundle.putAll(requestExtraData);
                }
            }
        }
        return bundle;
    }

    @Override // com.tencent.relation.common.handler.c
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj, oidb_0x5eb$RspBody oidb_0x5eb_rspbody, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, obj, oidb_0x5eb_rspbody, Boolean.valueOf(z16));
            return;
        }
        for (Class<? extends c> cls : b()) {
            c a16 = a(cls);
            if (a16 == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("AbsBusinessManagerFor0x5eb", 1, String.format("onReceive null == handlerProcessor ,  clazz name is :%s", cls.getClass().getName()));
                }
            } else {
                a16.onReceive(toServiceMsg, fromServiceMsg, obj, oidb_0x5eb_rspbody, z16);
            }
        }
    }
}
