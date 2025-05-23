package com.tencent.mobileqq.ark.api.scheme;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ark.ark;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.ark.module.h;
import com.tencent.mobileqq.ark.util.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class TelSchemeHandler implements h {
    @Override // com.tencent.mobileqq.ark.module.h
    public boolean a(final String str, final String str2, JSONObject jSONObject, final long j3, final String str3, final String str4) {
        ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).sendToAppThread(str3, new Runnable() { // from class: com.tencent.mobileqq.ark.api.scheme.TelSchemeHandler.2
            @Override // java.lang.Runnable
            public void run() {
                ark.Application Create = ark.Application.Create(str3, str4, str);
                if (Create == null) {
                    QLog.i("ArkApp", 1, "ArkAppSchemeCenter.navigate create application error");
                    return;
                }
                if (!com.tencent.mobileqq.ark.module.a.a(str3, j3, Create, "permission.TELEPHONE")) {
                    Create.Release();
                    QLog.i("ArkApp", 1, "ArkAppSchemeCenter.navigate check Permission fail");
                    return;
                }
                Create.Release();
                String str5 = str;
                if (TextUtils.isEmpty(str5)) {
                    try {
                        Object obj = i.b(new JSONObject(str2)).get("number");
                        if (obj != null) {
                            str5 = obj.toString();
                        }
                    } catch (JSONException e16) {
                        QLog.i("ArkApp", 1, "ArkAppSchemeCenter.navigate parameter error: " + e16.getMessage());
                    }
                }
                TelSchemeHandler.this.b(str5);
            }
        });
        return true;
    }

    protected void b(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToMainThread(new Runnable() { // from class: com.tencent.mobileqq.ark.api.scheme.TelSchemeHandler.1

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.ark.api.scheme.TelSchemeHandler$1$a */
            /* loaded from: classes11.dex */
            class a implements DialogInterface.OnClickListener {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ QQCustomDialog f199132d;

                a(QQCustomDialog qQCustomDialog) {
                    this.f199132d = qQCustomDialog;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL + str));
                    com.tencent.mobileqq.ark.d.a(intent);
                    BaseActivity.sTopActivity.startActivity(intent);
                    QQCustomDialog qQCustomDialog = this.f199132d;
                    if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
                        try {
                            this.f199132d.dismiss();
                        } catch (Exception unused) {
                        }
                    }
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.ark.api.scheme.TelSchemeHandler$1$b */
            /* loaded from: classes11.dex */
            class b implements DialogInterface.OnClickListener {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ QQCustomDialog f199134d;

                b(QQCustomDialog qQCustomDialog) {
                    this.f199134d = qQCustomDialog;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    QQCustomDialog qQCustomDialog = this.f199134d;
                    if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
                        try {
                            this.f199134d.dismiss();
                        } catch (Exception unused) {
                        }
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                QQCustomDialog createNoTitleDialog = DialogUtil.createNoTitleDialog(BaseActivity.sTopActivity, str);
                TextView textView = (TextView) createNoTitleDialog.findViewById(R.id.dialogText);
                textView.setGravity(17);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                textView.setLayoutParams(layoutParams);
                createNoTitleDialog.setPositiveButton(R.string.ano, new a(createNoTitleDialog));
                createNoTitleDialog.setNegativeButton(R.string.cancel, new b(createNoTitleDialog));
                try {
                    createNoTitleDialog.show();
                } catch (Exception unused) {
                }
            }
        });
    }
}
