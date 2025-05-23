package com.tencent.ecommerce.base.device;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeServlet;
import com.tencent.smtt.sdk.WebView;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/base/device/b;", "", "Landroid/content/Context;", "context", "", MiniAppSendSmsCodeServlet.KEY_PHONE_NUMBER, "", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f100686a = new b();

    b() {
    }

    public final void a(Context context, String phoneNumber) {
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL + phoneNumber));
        intent.setFlags(268435456);
        context.startActivity(intent);
    }
}
