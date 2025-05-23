package com.tencent.luggage.wxa.standalone_open_runtime.ui.patched;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.scanner.scanner.ui.BaseScanUI;
import com.tencent.luggage.wxa.q7.b;
import kotlin.Metadata;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/luggage/wxa/standalone_open_runtime/ui/patched/PatchedWxaScanCodeActivity;", "Lcom/tencent/luggage/scanner/scanner/ui/BaseScanUI;", "()V", "onCreate", "", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "luggage-standalone-open-runtime-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class PatchedWxaScanCodeActivity extends BaseScanUI {
    @Override // com.tencent.luggage.wxa.g6.s, com.tencent.mm.ui.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        Context applicationContext = getApplicationContext();
        if (applicationContext != null) {
            b.a(applicationContext);
        }
        super.onCreate(savedInstanceState);
    }
}
