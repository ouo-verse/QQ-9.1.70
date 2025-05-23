package com.huawei.hms.push.task;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.PushNaming;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class IntentCallable implements Callable<Void> {

    /* renamed from: a, reason: collision with root package name */
    public Context f37477a;

    /* renamed from: b, reason: collision with root package name */
    public Intent f37478b;

    /* renamed from: c, reason: collision with root package name */
    public String f37479c;

    public IntentCallable(Context context, Intent intent, String str) {
        this.f37477a = context;
        this.f37478b = intent;
        this.f37479c = str;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        this.f37477a.sendBroadcast(this.f37478b);
        PushBiUtil.reportExit(this.f37477a, PushNaming.SET_NOTIFY_FLAG, this.f37479c, ErrorEnum.SUCCESS);
        return null;
    }
}
