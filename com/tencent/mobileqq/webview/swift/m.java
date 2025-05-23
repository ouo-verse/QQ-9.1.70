package com.tencent.mobileqq.webview.swift;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class m extends w {
    static IPatchRedirector $redirector_;

    public m(@NonNull QQBrowserActivity qQBrowserActivity) {
        super(qQBrowserActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQBrowserActivity);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.w, com.tencent.mobileqq.colornote.f
    public ColorNote getColorNote() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ColorNote) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ColorNote colorNote = super.getColorNote();
        if (((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).isKandianUrl(this.f314832h.getIntent().getStringExtra("url"))) {
            try {
                JSONObject jSONObject = new JSONObject(new String(colorNote.getReserve()));
                jSONObject.put(IPublicAccountBrowser.H5_TYPE_READ_IN_JOY, true);
                colorNote.mReserve = jSONObject.toString().getBytes();
            } catch (JSONException e16) {
                QLog.e("WebColorNoteController", 1, e16, new Object[0]);
            }
        }
        return colorNote;
    }

    @Override // com.tencent.mobileqq.webview.swift.w
    public void i(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            return;
        }
        super.b();
        super.i(bundle);
        if (this.f314832h.getIntent().getBooleanExtra(IPublicAccountBrowser.KEY_SLIDE_RIGHT_BACK_ENABLE, true)) {
            super.c();
            e();
            IColorNoteController d16 = super.d();
            if (d16 != null) {
                d16.disablePostTable();
            }
        }
    }
}
