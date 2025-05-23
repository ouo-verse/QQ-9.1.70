package com.gcore.gcloud;

import android.app.Application;
import android.content.Context;
import com.gcore.abase.hotfix.GCloudFix;

/* compiled from: P */
/* loaded from: classes2.dex */
public class GCloudApplication extends Application {
    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        GCloudFix.init(context);
    }
}
