package com.sina.weibo.sdk.share;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class f {

    /* renamed from: g, reason: collision with root package name */
    public WeakReference<Activity> f61282g;

    public f(Activity activity) {
        this.f61282g = new WeakReference<>(activity);
    }

    public final void b(WeiboMultiMessage weiboMultiMessage) {
        Activity activity = this.f61282g.get();
        if (activity == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("_weibo_command_type", 1);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(System.currentTimeMillis());
        bundle.putString("_weibo_transaction", sb5.toString());
        bundle.putAll(weiboMultiMessage.writeToBundle(bundle));
        Intent intent = new Intent(activity, (Class<?>) ShareTransActivity.class);
        intent.putExtra("start_flag", 0);
        intent.putExtras(bundle);
        activity.startActivityForResult(intent, 10001);
    }
}
