package com.tencent.mobileqq.sharehelper;

import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class f implements b {
    static IPatchRedirector $redirector_;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.sharehelper.b
    public void a(Context context, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) dVar);
            return;
        }
        QZoneShareData qZoneShareData = new QZoneShareData();
        qZoneShareData.mSummary = dVar.f();
        qZoneShareData.mDefaultForwardReason = dVar.b();
        qZoneShareData.mTitle = dVar.h();
        qZoneShareData.mImageUrls = dVar.d();
        qZoneShareData.targetUrl = dVar.g();
        qZoneShareData.from = dVar.c();
        QZoneShareManager.shareToQzone(context, dVar.a(), qZoneShareData, null, dVar.e());
    }

    @Override // com.tencent.mobileqq.sharehelper.b
    public void b(Context context, ArrayList<String> arrayList, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, arrayList, Integer.valueOf(i3));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("images", arrayList);
        QZoneShareManager.publishToQzone((AppInterface) BaseApplicationImpl.getApplication().getRuntime(), context, bundle, null, i3);
    }
}
