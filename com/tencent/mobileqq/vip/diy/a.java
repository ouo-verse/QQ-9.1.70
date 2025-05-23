package com.tencent.mobileqq.vip.diy;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import e15.f;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a extends f {
    static IPatchRedirector $redirector_;
    private HashMap<String, f> C;

    public a(String str, View view, HashMap<String, f> hashMap) {
        super(str, view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, view, hashMap);
        } else {
            this.C = hashMap;
        }
    }

    @Override // e15.f
    protected ViewGroup.LayoutParams k(ViewGroup.LayoutParams layoutParams, JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ViewGroup.LayoutParams) iPatchRedirector.redirect((short) 4, (Object) this, (Object) layoutParams, (Object) jSONObject);
        }
        float j3 = UIUtils.j(this.f395367e.getContext());
        layoutParams.width = Math.max((int) ((j3 * 108.0f) / 360.0f), UIUtils.b(this.f395367e.getContext(), 108.0f));
        layoutParams.height = Math.max((int) ((j3 * 126.0f) / 360.0f), UIUtils.b(this.f395367e.getContext(), 126.0f));
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e15.f
    public void q(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
        } else if ("border".equals(str)) {
            this.C.get(str);
        } else {
            super.q(str, str2);
        }
    }
}
