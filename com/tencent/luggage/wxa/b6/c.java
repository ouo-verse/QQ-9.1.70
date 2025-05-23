package com.tencent.luggage.wxa.b6;

import android.content.Context;
import android.content.ContextWrapper;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.xweb.XWebEnvironmentConfig;
import com.tencent.xweb.XWebSdk;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f121884a = false;

    /* renamed from: b, reason: collision with root package name */
    public static String f121885b = "XWebEnvironmentInitHelper";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends ContextWrapper {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f121886a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, Context context2) {
            super(context);
            this.f121886a = context2;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Context getApplicationContext() {
            Context applicationContext = super.getApplicationContext();
            if (applicationContext == null) {
                return this.f121886a;
            }
            return applicationContext;
        }
    }

    public static void a() {
        if (f121884a) {
            return;
        }
        Context c16 = z.c();
        w.d(f121885b, "initXWebEnvironment, context:%s", c16);
        XWebSdk.initXWebEnvironment(new a(c16, c16), new XWebEnvironmentConfig.XWebEnvironmentConfigBuilder().setLogInterface(b.f121879a).setReporterInterface(b.f121880b).setSharedPreferenceProvider(b.f121881c).setWebViewExtensionListener(b.f121882d).createXWebEnvironmentConfig());
        f121884a = true;
    }
}
