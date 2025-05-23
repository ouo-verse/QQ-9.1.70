package com.tencent.mobileqq.Doraemon.impl.commonModule;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import com.tencent.widget.ActionSheet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class f extends com.tencent.mobileqq.Doraemon.e {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private QQCustomDialog f154194b;

    /* renamed from: c, reason: collision with root package name */
    private ActionSheet f154195c;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private static class a implements ActionSheet.OnButtonClickListener, DialogInterface.OnCancelListener, ActionSheet.OnDismissListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        ActionSheet f154196d;

        /* renamed from: e, reason: collision with root package name */
        com.tencent.mobileqq.Doraemon.a f154197e;

        public a(ActionSheet actionSheet, com.tencent.mobileqq.Doraemon.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) actionSheet, (Object) aVar);
            } else {
                this.f154196d = actionSheet;
                this.f154197e = aVar;
            }
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cancel", true);
                jSONObject.put("tapIndex", -1);
                DoraemonUtil.e(this.f154197e, jSONObject);
            } catch (JSONException e16) {
                String message = e16.getMessage();
                if (QLog.isColorLevel()) {
                    QLog.w("DoraemonOpenAPI.widget", 2, message, e16);
                }
                com.tencent.mobileqq.Doraemon.a aVar = this.f154197e;
                if (message == null) {
                    message = "";
                }
                DoraemonUtil.c(aVar, -2, message);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, i3);
                return;
            }
            this.f154196d.dismiss();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cancel", false);
                jSONObject.put("tapIndex", i3);
                DoraemonUtil.e(this.f154197e, jSONObject);
            } catch (JSONException e16) {
                String message = e16.getMessage();
                if (QLog.isColorLevel()) {
                    QLog.w("DoraemonOpenAPI.widget", 2, message, e16);
                }
                com.tencent.mobileqq.Doraemon.a aVar = this.f154197e;
                if (message == null) {
                    message = "";
                }
                DoraemonUtil.c(aVar, -2, message);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnDismissListener
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cancel", true);
                jSONObject.put("tapIndex", -1);
                DoraemonUtil.e(this.f154197e, jSONObject);
            } catch (JSONException e16) {
                String message = e16.getMessage();
                if (QLog.isColorLevel()) {
                    QLog.w("DoraemonOpenAPI.widget", 2, message, e16);
                }
                com.tencent.mobileqq.Doraemon.a aVar = this.f154197e;
                if (message == null) {
                    message = "";
                }
                DoraemonUtil.c(aVar, -2, message);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private static class b implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        com.tencent.mobileqq.Doraemon.a f154198d;

        public b(com.tencent.mobileqq.Doraemon.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            } else {
                this.f154198d = aVar;
            }
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM, false);
                jSONObject.put("cancel", true);
                DoraemonUtil.e(this.f154198d, jSONObject);
            } catch (JSONException e16) {
                String message = e16.getMessage();
                if (QLog.isColorLevel()) {
                    QLog.w("DoraemonOpenAPI.widget", 2, message, e16);
                }
                com.tencent.mobileqq.Doraemon.a aVar = this.f154198d;
                if (message == null) {
                    message = "";
                }
                DoraemonUtil.c(aVar, -1, message);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            boolean z17 = false;
            if (i3 == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            try {
                jSONObject.put(MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM, z16);
                if (i3 != 1) {
                    z17 = true;
                }
                jSONObject.put("cancel", z17);
                DoraemonUtil.e(this.f154198d, jSONObject);
            } catch (JSONException e16) {
                String message = e16.getMessage();
                if (QLog.isColorLevel()) {
                    QLog.w("DoraemonOpenAPI.widget", 2, message, e16);
                }
                com.tencent.mobileqq.Doraemon.a aVar = this.f154198d;
                if (message == null) {
                    message = "";
                }
                DoraemonUtil.c(aVar, -1, message);
            }
        }
    }

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.Doraemon.e
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QQCustomDialog qQCustomDialog = this.f154194b;
        if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
            this.f154194b.dismiss();
        }
        ActionSheet actionSheet = this.f154195c;
        if (actionSheet != null && actionSheet.isShowing()) {
            this.f154195c.dismiss();
        }
    }

    @Override // com.tencent.mobileqq.Doraemon.e
    public boolean c(int i3, String str, JSONObject jSONObject, @NonNull com.tencent.mobileqq.Doraemon.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, jSONObject, aVar)).booleanValue();
        }
        if (i3 != 28) {
            if (i3 != 29) {
                return false;
            }
            QQCustomDialog qQCustomDialog = this.f154194b;
            if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
                this.f154194b.dismiss();
            }
            Activity j3 = this.f154095a.j();
            if (j3 != null && !j3.isFinishing()) {
                this.f154194b = DialogUtil.createCustomDialog(j3, 230);
                String optString = jSONObject.optString("title");
                if (!TextUtils.isEmpty(optString)) {
                    this.f154194b.setTitle(optString);
                }
                String optString2 = jSONObject.optString("content");
                if (!TextUtils.isEmpty(optString2)) {
                    this.f154194b.setMessage(optString2);
                }
                b bVar = new b(aVar);
                String optString3 = jSONObject.optString("confirmText");
                if (!TextUtils.isEmpty(optString3)) {
                    this.f154194b.setPositiveButton(optString3, bVar);
                }
                String optString4 = jSONObject.optString("cancelText");
                if (!TextUtils.isEmpty(optString4)) {
                    this.f154194b.setNegativeButton(optString4, bVar);
                }
                this.f154194b.setOnCancelListener(bVar);
                this.f154194b.show();
            } else {
                QLog.e("DoraemonOpenAPI.widget", 1, "execute show dialog activity is null or finish");
                return false;
            }
        } else {
            ActionSheet actionSheet = this.f154195c;
            if (actionSheet != null && actionSheet.isShowing()) {
                this.f154195c.dismiss();
            }
            Activity j16 = this.f154095a.j();
            if (j16 != null && !j16.isFinishing()) {
                this.f154195c = ActionSheet.create(j16);
                JSONArray optJSONArray = jSONObject.optJSONArray(VideoTemplateParser.ITEM_LIST);
                if (optJSONArray == null) {
                    DoraemonUtil.c(aVar, -1, "param error");
                } else {
                    int length = optJSONArray.length();
                    boolean z16 = false;
                    while (i16 < length) {
                        this.f154195c.addButton(optJSONArray.optString(i16, ""));
                        i16++;
                        z16 = true;
                    }
                    a aVar2 = new a(this.f154195c, aVar);
                    String optString5 = jSONObject.optString("cancelText");
                    if (!TextUtils.isEmpty(optString5)) {
                        this.f154195c.addCancelButton(optString5);
                        z16 = true;
                    }
                    if (z16) {
                        this.f154195c.setOnButtonClickListener(aVar2);
                        this.f154195c.setOnCancelListener(aVar2);
                        this.f154195c.setOnDismissListener(aVar2);
                        this.f154195c.show();
                    } else {
                        DoraemonUtil.c(aVar, -1, "param error");
                    }
                }
            } else {
                QLog.e("DoraemonOpenAPI.widget", 1, "execute show action sheet activity is null or finish");
                return false;
            }
        }
        return true;
    }
}
