package com.tencent.luggage.wxa.h6;

import android.content.Context;
import com.tencent.luggage.ui.WxaSimpleWebViewActivity;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class p implements com.tencent.luggage.wxa.bi.b {
    @Override // com.tencent.luggage.wxa.bi.b
    public void a(String url, Context context) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(context, "context");
        WxaSimpleWebViewActivity.INSTANCE.a(context, url);
    }
}
