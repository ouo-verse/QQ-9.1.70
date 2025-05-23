package com.tencent.gdtad.adapter;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.dialog.AdProgressDialog;
import com.tencent.ad.tangram.dialog.AdProgressDialogAdapter;
import com.tencent.mobileqq.widget.QQProgressDialog;

/* compiled from: P */
/* loaded from: classes6.dex */
public class n implements AdProgressDialogAdapter {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private QQProgressDialog f108479a;

    @Override // com.tencent.ad.tangram.dialog.AdProgressDialogAdapter
    public void dismiss() {
        QQProgressDialog qQProgressDialog = this.f108479a;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.f108479a.dismiss();
            this.f108479a = null;
        }
    }

    @Override // com.tencent.ad.tangram.dialog.AdProgressDialogAdapter
    public boolean isShowing(Context context) {
        QQProgressDialog qQProgressDialog = this.f108479a;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ad.tangram.dialog.AdProgressDialogAdapter
    public void show(@Nullable Context context, @Nullable AdProgressDialog.Params params) {
        if (context != null) {
            if (this.f108479a == null) {
                this.f108479a = new QQProgressDialog(context);
            }
            if (params != null) {
                this.f108479a.setOffsetY(params.yOffset);
                this.f108479a.setCancelable(params.cancelable);
                if (!TextUtils.isEmpty(params.message)) {
                    this.f108479a.setMessage(params.message);
                }
            }
        }
        QQProgressDialog qQProgressDialog = this.f108479a;
        if (qQProgressDialog != null) {
            qQProgressDialog.show();
        }
    }
}
