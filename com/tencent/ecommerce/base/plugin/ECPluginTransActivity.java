package com.tencent.ecommerce.base.plugin;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import kotlin.Metadata;
import mqq.app.Constants;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/ecommerce/base/plugin/ECPluginTransActivity;", "Lcom/tencent/ecommerce/base/plugin/ECPluginActivity;", "()V", "onCreate", "", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class ECPluginTransActivity extends ECPluginActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ecommerce.base.plugin.ECPluginActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(Build.VERSION.SDK_INT == 26 ? -1 : 1);
        Window window = getWindow();
        if (window != null) {
            window.requestFeature(1);
        }
        super.onCreate(savedInstanceState);
    }
}
