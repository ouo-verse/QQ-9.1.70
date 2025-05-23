package com.tencent.luggage.wxa.l4;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.d0;
import com.tencent.mm.ui.BaseActivity;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c implements d0 {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a extends BaseActivity {
    }

    @Override // com.tencent.luggage.wxa.xd.d0
    public void a(Context context, String str, String str2, d0.a aVar) {
        w.a("Luggage.FullSdkExternalToolsHelper", "open webview activity url: %s", str);
        Intent intent = new Intent(context, (Class<?>) a.class);
        intent.putExtra("_url_", str);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        com.tencent.luggage.wxa.fa.b.a(context, intent);
        context.startActivity(intent);
    }
}
