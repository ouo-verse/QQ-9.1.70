package com.tencent.ams.dynamic;

import com.tencent.ams.dsdk.data.TemplateInfo;
import com.tencent.ams.dsdk.fodder.TemplateManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import pm0.c;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class b implements TemplateManager.UpdateTemplateListenerV2 {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<TemplateManager.UpdateTemplateListenerV2> f70122a;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        ArrayList<TemplateManager.UpdateTemplateListenerV2> arrayList = new ArrayList<>();
        this.f70122a = arrayList;
        arrayList.add(new c());
    }

    @Override // com.tencent.ams.dsdk.fodder.TemplateManager.UpdateTemplateListener
    public void onFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        Iterator<TemplateManager.UpdateTemplateListenerV2> it = this.f70122a.iterator();
        while (it.hasNext()) {
            TemplateManager.UpdateTemplateListenerV2 next = it.next();
            if (next == null) {
                QLog.e("DynamicTemplateUpdateListener", 1, "[onFinish] error, listener is null");
            } else {
                next.onFinish();
            }
        }
    }

    @Override // com.tencent.ams.dsdk.fodder.TemplateManager.UpdateTemplateListener
    public void onItemCancelled(TemplateInfo templateInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) templateInfo);
            return;
        }
        Iterator<TemplateManager.UpdateTemplateListenerV2> it = this.f70122a.iterator();
        while (it.hasNext()) {
            TemplateManager.UpdateTemplateListenerV2 next = it.next();
            if (next == null) {
                QLog.e("DynamicTemplateUpdateListener", 1, "[onItemCancelled] error, listener is null");
            } else {
                next.onItemCancelled(templateInfo);
            }
        }
    }

    @Override // com.tencent.ams.dsdk.fodder.TemplateManager.UpdateTemplateListenerV2
    public void onItemExisted(TemplateInfo templateInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) templateInfo);
            return;
        }
        Iterator<TemplateManager.UpdateTemplateListenerV2> it = this.f70122a.iterator();
        while (it.hasNext()) {
            TemplateManager.UpdateTemplateListenerV2 next = it.next();
            if (next == null) {
                QLog.e("DynamicTemplateUpdateListener", 1, "[onItemExisted] error, listener is null");
            } else {
                next.onItemExisted(templateInfo);
            }
        }
    }

    @Override // com.tencent.ams.dsdk.fodder.TemplateManager.UpdateTemplateListener
    public void onItemFailed(TemplateInfo templateInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) templateInfo);
            return;
        }
        Iterator<TemplateManager.UpdateTemplateListenerV2> it = this.f70122a.iterator();
        while (it.hasNext()) {
            TemplateManager.UpdateTemplateListenerV2 next = it.next();
            if (next == null) {
                QLog.e("DynamicTemplateUpdateListener", 1, "[onItemFailed] error, listener is null");
            } else {
                next.onItemFailed(templateInfo);
            }
        }
    }

    @Override // com.tencent.ams.dsdk.fodder.TemplateManager.UpdateTemplateListener
    public void onItemStart(TemplateInfo templateInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) templateInfo);
            return;
        }
        Iterator<TemplateManager.UpdateTemplateListenerV2> it = this.f70122a.iterator();
        while (it.hasNext()) {
            TemplateManager.UpdateTemplateListenerV2 next = it.next();
            if (next == null) {
                QLog.e("DynamicTemplateUpdateListener", 1, "[onItemStart] error, listener is null");
            } else {
                next.onItemStart(templateInfo);
            }
        }
    }

    @Override // com.tencent.ams.dsdk.fodder.TemplateManager.UpdateTemplateListener
    public void onItemSuccess(TemplateInfo templateInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) templateInfo);
            return;
        }
        Iterator<TemplateManager.UpdateTemplateListenerV2> it = this.f70122a.iterator();
        while (it.hasNext()) {
            TemplateManager.UpdateTemplateListenerV2 next = it.next();
            if (next == null) {
                QLog.e("DynamicTemplateUpdateListener", 1, "[onItemSuccess] error, listener is null");
            } else {
                next.onItemSuccess(templateInfo);
            }
        }
    }

    @Override // com.tencent.ams.dsdk.fodder.TemplateManager.UpdateTemplateListener
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        Iterator<TemplateManager.UpdateTemplateListenerV2> it = this.f70122a.iterator();
        while (it.hasNext()) {
            TemplateManager.UpdateTemplateListenerV2 next = it.next();
            if (next == null) {
                QLog.e("DynamicTemplateUpdateListener", 1, "[onStart] error, listener is null");
            } else {
                next.onStart();
            }
        }
    }
}
