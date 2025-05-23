package com.tencent.mobileqq.teamwork;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.style.LinkSpan;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class n extends QQText {

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a extends LinkSpan {
        public a(String str) {
            super(str);
        }

        @Override // com.tencent.mobileqq.text.style.LinkSpan
        protected void g(View view, String str) {
            Uri parse = Uri.parse(str);
            Context context = view.getContext();
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, parse);
            intent.putExtra("com.android.browser.application_id", context.getPackageName());
            try {
                context.startActivity(intent);
            } catch (ActivityNotFoundException unused) {
                QLog.w("OpenDefaultBrowserQQText", 1, "Activity was not found for intent, " + intent.toString());
            }
        }
    }

    public n(CharSequence charSequence, int i3) {
        super(charSequence, i3);
    }

    @Override // com.tencent.mobileqq.text.QQText, com.tencent.mobileqq.text.processor.ISpanCallback
    public void addSpan(Object obj, int i3, int i16, int i17) {
        if (obj instanceof LinkSpan) {
            obj = new a(((LinkSpan) obj).f292710d);
        }
        super.addSpan(obj, i3, i16, i17);
    }
}
