package com.tencent.mobileqq.listentogether;

import android.text.TextUtils;
import com.tencent.mobileqq.dpc.DPCObserver;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class c {

    /* renamed from: e, reason: collision with root package name */
    public static final String f240895e = DPCNames.ltcfg.name();

    /* renamed from: a, reason: collision with root package name */
    public int f240896a = 50;

    /* renamed from: b, reason: collision with root package name */
    public int f240897b = 0;

    /* renamed from: c, reason: collision with root package name */
    public long f240898c = 3000;

    /* renamed from: d, reason: collision with root package name */
    public DPCObserver f240899d = new a();

    /* compiled from: P */
    /* loaded from: classes33.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final c f240901a = new c();
    }

    c() {
        c();
        ((IDPCApi) QRoute.api(IDPCApi.class)).addObserver(this.f240899d);
    }

    public static c b() {
        return b.f240901a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        String featureValueWithoutAccountManager = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(f240895e);
        try {
            if (!TextUtils.isEmpty(featureValueWithoutAccountManager)) {
                String[] split = featureValueWithoutAccountManager.split("\\|");
                if (split.length >= 4) {
                    this.f240896a = Integer.valueOf(split[0]).intValue();
                    this.f240897b = Integer.valueOf(split[1]).intValue();
                    this.f240898c = Long.valueOf(split[2]).longValue();
                }
            }
        } catch (Exception e16) {
            QLog.d("ListenTogether.dpc", 1, "loadDpc", e16);
            this.f240896a = 50;
            this.f240897b = 0;
            this.f240898c = 3000L;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ListenTogether.dpc", 2, String.format("loadDpc, dpcValue: %s, [%s]", featureValueWithoutAccountManager, this));
        }
    }

    public String toString() {
        return "ListenTogetherDPC{maxCacheCount=" + this.f240896a + ", preDownloadNetType=" + this.f240897b + ", playingAdjustInterval=" + this.f240898c + '}';
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements DPCObserver {
        a() {
        }

        @Override // com.tencent.mobileqq.dpc.DPCObserver
        public void onDpcPullFinished(boolean z16) {
            if (z16) {
                c.this.c();
            }
            if (QLog.isColorLevel()) {
                QLog.d("ListenTogether.dpc", 2, "onDpcPullFinished, hasChanged = " + z16);
            }
        }
    }
}
