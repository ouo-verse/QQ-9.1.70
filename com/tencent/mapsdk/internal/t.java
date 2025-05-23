package com.tencent.mapsdk.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.map.tools.Callback;
import com.tencent.mapsdk.internal.u;
import com.tencent.tencentmap.mapsdk.maps.BaseMapView;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final Context f150419a;

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.t$1, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass1 implements Callback<Void> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f150420a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TencentMapOptions f150421b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Callback f150422c;

        public AnonymousClass1(ViewGroup viewGroup, TencentMapOptions tencentMapOptions, Callback callback) {
            this.f150420a = viewGroup;
            this.f150421b = tencentMapOptions;
            this.f150422c = callback;
        }

        private void a() {
            BaseMapView.MapViewProxy a16 = t.this.a(u.a().f151145b, this.f150420a, this.f150421b);
            Callback callback = this.f150422c;
            if (callback != null) {
                callback.callback(a16);
            }
        }

        @Override // com.tencent.map.tools.Callback
        public final /* synthetic */ void callback(Void r46) {
            BaseMapView.MapViewProxy a16 = t.this.a(u.a().f151145b, this.f150420a, this.f150421b);
            Callback callback = this.f150422c;
            if (callback != null) {
                callback.callback(a16);
            }
        }
    }

    public t(Context context) {
        this.f150419a = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final BaseMapView.MapViewProxy a(s sVar, ViewGroup viewGroup, TencentMapOptions tencentMapOptions) {
        return sVar.createDelegate(this.f150419a, tencentMapOptions, viewGroup);
    }

    public final BaseMapView.MapViewProxy a(ViewGroup viewGroup, @NonNull TencentMapOptions tencentMapOptions) {
        u.a().a(this.f150419a, a(tencentMapOptions));
        return a(u.a().f151145b, viewGroup, tencentMapOptions);
    }

    private void a(ViewGroup viewGroup, @NonNull TencentMapOptions tencentMapOptions, Callback<BaseMapView.MapViewProxy> callback) {
        new BaseThread(new u.AnonymousClass4(this.f150419a, a(tencentMapOptions), new Handler(Looper.getMainLooper()), new AnonymousClass1(viewGroup, tencentMapOptions, callback)), "tms-plugin").start();
    }

    public final String a(TencentMapOptions tencentMapOptions) {
        String mapKey = tencentMapOptions.getMapKey();
        if (hs.a(mapKey)) {
            mapKey = ht.a(this.f150419a, "TencentMapSDK");
        }
        String customUserId = tencentMapOptions.getCustomUserId();
        if (TextUtils.isEmpty(customUserId)) {
            customUserId = "undefined";
        }
        return mapKey + "," + customUserId;
    }
}
