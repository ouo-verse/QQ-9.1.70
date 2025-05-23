package com.tencent.luggage.wxa.ai;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class j extends ContentObserver {

    /* renamed from: b, reason: collision with root package name */
    public static final a f121506b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final AudioManager f121507a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Context context, Handler handler) {
        super(handler);
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.f121507a = (AudioManager) systemService;
    }

    @Override // android.database.ContentObserver
    public boolean deliverSelfNotifications() {
        return false;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z16) {
        w.d("SettingsContentObserver", "Volume now " + SystemMethodProxy.getStreamVolume(this.f121507a, 3));
    }
}
