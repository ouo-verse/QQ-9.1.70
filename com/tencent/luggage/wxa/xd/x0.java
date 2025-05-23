package com.tencent.luggage.wxa.xd;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.mini.out.nativePlugins.SmsPlugin;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeServlet;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class x0 extends com.tencent.luggage.wxa.xd.a {

    @Deprecated
    private static final int CTRL_INDEX = 1129;

    @Deprecated
    @NotNull
    private static final String NAME = "sendSms";

    /* renamed from: a, reason: collision with root package name */
    public static final a f144892a = new a(null);

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.ic.l lVar, JSONObject jSONObject, int i3) {
        if (lVar == null || jSONObject == null) {
            return;
        }
        String content = jSONObject.optString("content", "");
        int length = content.length();
        Regex regex = new Regex("[\\x00-\\x7f]+");
        Intrinsics.checkNotNullExpressionValue(content, "content");
        boolean matches = regex.matches(content);
        if ((matches && length > 160) || (!matches && length > 70)) {
            lVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.b.f121272x0));
            return;
        }
        String a16 = com.tencent.luggage.wxa.aa.m.a(jSONObject.optString(MiniAppSendSmsCodeServlet.KEY_PHONE_NUMBER, ""));
        Context context = lVar.getContext();
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse(SmsPlugin.KEY_SYSTEM_SMS_URI + a16));
        intent.putExtra(SmsPlugin.KEY_SYSTEM_SMS_CONTENT, content);
        com.tencent.luggage.wxa.fa.b.a(context, intent);
        context.startActivity(intent);
        lVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a));
    }
}
