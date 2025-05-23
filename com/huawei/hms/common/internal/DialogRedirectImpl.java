package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Intent;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DialogRedirectImpl extends DialogRedirect {

    /* renamed from: a, reason: collision with root package name */
    private final Activity f36865a;

    /* renamed from: b, reason: collision with root package name */
    private final int f36866b;

    /* renamed from: c, reason: collision with root package name */
    private final Intent f36867c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogRedirectImpl(Intent intent, Activity activity, int i3) {
        this.f36867c = intent;
        this.f36865a = activity;
        this.f36866b = i3;
    }

    @Override // com.huawei.hms.common.internal.DialogRedirect
    public final void redirect() {
        Intent intent = this.f36867c;
        if (intent != null) {
            this.f36865a.startActivityForResult(intent, this.f36866b);
        }
    }
}
