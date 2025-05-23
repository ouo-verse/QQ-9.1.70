package com.tencent.mm.plugin.appbrand.ipc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.os.ResultReceiver;
import android.support.v4.os.ResultReceiverCompat;
import androidx.core.app.ComponentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.luggage.wxa.zp.h;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class ResultReceiverFixLeak {

    /* compiled from: P */
    @SuppressLint({"RestrictedApi"})
    /* loaded from: classes9.dex */
    public static final class ResultReceiverLifecycleWrapper extends ResultReceiver implements LifecycleObserver {

        /* renamed from: a, reason: collision with root package name */
        public ResultReceiver f151978a;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ LifecycleOwner f151979a;

            public a(LifecycleOwner lifecycleOwner) {
                this.f151979a = lifecycleOwner;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f151979a.getLifecycle().addObserver(ResultReceiverLifecycleWrapper.this);
            }
        }

        public ResultReceiverLifecycleWrapper(ResultReceiver resultReceiver, LifecycleOwner lifecycleOwner) {
            super(ResultReceiverCompat.getHandler(resultReceiver));
            this.f151978a = resultReceiver;
            if (Looper.getMainLooper() == Looper.myLooper()) {
                lifecycleOwner.getLifecycle().addObserver(this);
            } else {
                h.f146825d.a(new a(lifecycleOwner));
            }
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void onDestroy() {
            this.f151978a = null;
        }

        @Override // android.support.v4.os.ResultReceiver
        public void onReceiveResult(int i3, Bundle bundle) {
            super.onReceiveResult(i3, bundle);
            ResultReceiver resultReceiver = this.f151978a;
            if (resultReceiver != null) {
                ResultReceiverCompat.callOnResultReceive(resultReceiver, i3, bundle);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ResultReceiver a(ResultReceiver resultReceiver, Context context) {
        if (resultReceiver != null && (context instanceof ComponentActivity)) {
            return new ResultReceiverLifecycleWrapper(resultReceiver, (LifecycleOwner) context);
        }
        return resultReceiver;
    }
}
