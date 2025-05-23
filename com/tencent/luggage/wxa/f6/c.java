package com.tencent.luggage.wxa.f6;

import android.content.Intent;
import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c extends com.tencent.luggage.wxa.ga.a {
    public abstract void a(Intent intent);

    @Override // com.tencent.luggage.wxa.ga.a, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // com.tencent.luggage.wxa.ga.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
            return;
        }
        overridePendingTransition(0, 0);
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        a(intent);
        finish();
    }

    @Override // com.tencent.luggage.wxa.ga.a, android.app.Activity
    public void onDestroy() {
        super.overridePendingTransition(0, 0);
        super.onDestroy();
    }

    @Override // com.tencent.luggage.wxa.ga.a, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            a(intent);
        }
        finish();
    }

    @Override // com.tencent.luggage.wxa.ga.a, android.app.Activity
    public void onPause() {
        overridePendingTransition(0, 0);
        super.onPause();
    }

    @Override // com.tencent.luggage.wxa.ga.a, android.app.Activity
    public void onResume() {
        super.onResume();
        finish();
    }
}
