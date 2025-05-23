package com.tencent.mobileqq.newfriend.msg;

import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d extends i {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public MayKnowRecommend f254031d;

    @Override // com.tencent.mobileqq.newfriend.msg.i
    public String a(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) appRuntime);
        }
        if (TextUtils.isEmpty(this.f254035a)) {
            this.f254035a = String.format(MobileQQ.sMobileQQ.getApplicationContext().getString(R.string.f170115gt), this.f254031d.getDisplayName());
        }
        return this.f254035a;
    }

    @Override // com.tencent.mobileqq.newfriend.msg.i
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return true;
    }
}
