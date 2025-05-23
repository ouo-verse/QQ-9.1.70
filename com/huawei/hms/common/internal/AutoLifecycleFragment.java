package com.huawei.hms.common.internal;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.SparseArray;
import com.huawei.hms.api.HuaweiApiClient;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment;

/* compiled from: P */
/* loaded from: classes2.dex */
public class AutoLifecycleFragment extends ReportFragment {

    /* renamed from: a, reason: collision with root package name */
    private final SparseArray<a> f36828a = new SparseArray<>();

    /* renamed from: b, reason: collision with root package name */
    private boolean f36829b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final HuaweiApiClient f36830a;

        /* renamed from: b, reason: collision with root package name */
        protected final int f36831b;

        public a(int i3, HuaweiApiClient huaweiApiClient) {
            this.f36830a = huaweiApiClient;
            this.f36831b = i3;
        }

        public void a() {
            this.f36830a.disconnect();
        }
    }

    public static AutoLifecycleFragment getInstance(Activity activity) {
        Preconditions.checkMainThread("Must be called on the main thread");
        try {
            AutoLifecycleFragment autoLifecycleFragment = (AutoLifecycleFragment) activity.getFragmentManager().findFragmentByTag("HmsAutoLifecycleFrag");
            FragmentManager fragmentManager = activity.getFragmentManager();
            if (autoLifecycleFragment == null) {
                AutoLifecycleFragment autoLifecycleFragment2 = new AutoLifecycleFragment();
                fragmentManager.beginTransaction().add(autoLifecycleFragment2, "HmsAutoLifecycleFrag").commitAllowingStateLoss();
                fragmentManager.executePendingTransactions();
                return autoLifecycleFragment2;
            }
            return autoLifecycleFragment;
        } catch (ClassCastException e16) {
            throw new IllegalStateException("Fragment with tag HmsAutoLifecycleFrag is not a AutoLifecycleFragment", e16);
        }
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f36829b = true;
        for (int i3 = 0; i3 < this.f36828a.size(); i3++) {
            this.f36828a.valueAt(i3).f36830a.connect((Activity) null);
        }
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f36829b = false;
        for (int i3 = 0; i3 < this.f36828a.size(); i3++) {
            this.f36828a.valueAt(i3).f36830a.disconnect();
        }
    }

    public void startAutoMange(int i3, HuaweiApiClient huaweiApiClient) {
        boolean z16;
        Preconditions.checkNotNull(huaweiApiClient, "HuaweiApiClient instance cannot be null");
        if (this.f36828a.indexOfKey(i3) < 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Preconditions.checkState(z16, "Already managing a HuaweiApiClient with this clientId: " + i3);
        this.f36828a.put(i3, new a(i3, huaweiApiClient));
        if (this.f36829b) {
            huaweiApiClient.connect((Activity) null);
        }
    }

    public void stopAutoManage(int i3) {
        a aVar = this.f36828a.get(i3);
        this.f36828a.remove(i3);
        if (aVar != null) {
            aVar.a();
        }
    }
}
