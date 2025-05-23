package com.tencent.open.agent.strategy;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.open.agent.util.t;

/* compiled from: P */
/* loaded from: classes22.dex */
abstract class c implements g {

    /* renamed from: a, reason: collision with root package name */
    protected String f340578a;

    public c(String str) {
        this.f340578a = str;
    }

    @Override // com.tencent.open.agent.strategy.g
    public void a(Activity activity) {
        Bundle d16 = com.tencent.open.agent.util.c.d(activity.getIntent(), "key_params");
        if (b(activity, d16)) {
            d(activity, d16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b(Activity activity, Bundle bundle) {
        if (bundle == null) {
            e(activity, -5);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(Intent intent, Activity activity, Bundle bundle) {
        intent.putExtra("key_action", this.f340578a);
        intent.putExtra("key_params", bundle);
        try {
            activity.startActivityForResult(intent, 0);
        } catch (ActivityNotFoundException e16) {
            t.d("BaseAction", "ActivityNotFoundException", e16);
            e(activity, -6);
        }
    }

    protected abstract void d(Activity activity, Bundle bundle);

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(Activity activity, int i3) {
        t.e("BaseAction", "setResult action=", this.f340578a, ", error=", Integer.valueOf(i3));
        Intent intent = new Intent();
        intent.putExtra("key_error_code", i3);
        intent.putExtra("key_error_msg", com.tencent.open.business.base.b.f341055c);
        intent.putExtra("key_error_detail", "");
        intent.putExtra("key_response", "");
        activity.setResult(-1, intent);
        activity.finish();
    }
}
