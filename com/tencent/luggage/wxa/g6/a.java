package com.tencent.luggage.wxa.g6;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface a {

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.g6.a$-CC, reason: invalid class name */
    /* loaded from: classes8.dex */
    public final /* synthetic */ class CC {
        public static a a(Context context) {
            a b16 = b(context);
            if (b16 != null) {
                return b16;
            }
            throw new IllegalArgumentException("context is not ActivityLike " + context);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static a b(Context context) {
            if (context instanceof a) {
                return (a) context;
            }
            if (context instanceof Activity) {
                return new C6231a(context, (Activity) context);
            }
            return null;
        }

        public static boolean c(Context context) {
            if (!(context instanceof a) && !(context instanceof Activity)) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.g6.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6231a implements a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f126460a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f126461b;

        public C6231a(Context context, Activity activity) {
            this.f126460a = context;
            this.f126461b = activity;
        }

        @Override // com.tencent.luggage.wxa.g6.a
        public Context getContext() {
            return this.f126460a;
        }

        @Override // com.tencent.luggage.wxa.g6.a
        public Intent getIntent() {
            return this.f126461b.getIntent();
        }

        @Override // com.tencent.luggage.wxa.g6.a
        public void overridePendingTransition(int i3, int i16) {
            this.f126461b.overridePendingTransition(i3, i16);
        }

        @Override // com.tencent.luggage.wxa.g6.a
        public void runOnUiThread(Runnable runnable) {
            this.f126461b.runOnUiThread(runnable);
        }

        @Override // com.tencent.luggage.wxa.g6.a
        public void setResult(int i3, Intent intent) {
            this.f126461b.setResult(i3, intent);
        }
    }

    Context getContext();

    Intent getIntent();

    void overridePendingTransition(int i3, int i16);

    void runOnUiThread(Runnable runnable);

    void setResult(int i3, Intent intent);
}
