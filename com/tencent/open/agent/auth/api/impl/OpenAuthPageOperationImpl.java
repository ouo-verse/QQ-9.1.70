package com.tencent.open.agent.auth.api.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.open.agent.auth.api.IOpenAuthPageOperation;
import com.tencent.open.agent.report.OpenAuthTelemetryProxy;
import com.tencent.open.agent.util.t;

/* loaded from: classes22.dex */
public class OpenAuthPageOperationImpl implements IOpenAuthPageOperation {
    private static final String TAG = "OpenAuthPageOperationImpl";

    @Override // com.tencent.open.agent.auth.api.IOpenAuthPageOperation
    public void onClickAuthBtn(Activity activity) {
        if (activity == null) {
            t.e(TAG, "onClickAuthBtn activity is null");
        } else {
            new OpenAuthPageOperationHelper(activity).D();
            OpenAuthTelemetryProxy.d();
        }
    }

    @Override // com.tencent.open.agent.auth.api.IOpenAuthPageOperation
    public void onClickCancelBtn(Activity activity) {
        if (activity == null) {
            t.e(TAG, "onClickCancelBtn activity is null");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("key_cancel_auth", true);
        activity.setResult(103, intent);
        activity.finish();
        OpenAuthTelemetryProxy.c();
    }
}
