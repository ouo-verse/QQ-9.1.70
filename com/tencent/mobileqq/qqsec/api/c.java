package com.tencent.mobileqq.qqsec.api;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface c {
    void a(Context context, boolean z16, boolean z17);

    void b(QBaseActivity qBaseActivity, boolean z16, String str);

    void c(Context context, String str);

    void d(Activity activity, String str);

    void e(BaseQQAppInterface baseQQAppInterface, ProgressDialog progressDialog);

    void f(QBaseActivity qBaseActivity);

    void g(Activity activity, JSONObject jSONObject);

    ArrayList<String> h(BaseQQAppInterface baseQQAppInterface);

    void i(BaseQQAppInterface baseQQAppInterface);
}
