package com.huawei.hms.health;

import com.huawei.hmf.tasks.OnSuccessListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class aabd implements OnSuccessListener<String> {
    final /* synthetic */ aaba aab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aabd(aaba aabaVar) {
        this.aab = aabaVar;
    }

    @Override // com.huawei.hmf.tasks.OnSuccessListener
    public void onSuccess(String str) {
        aabz.aabb("HealthKitAuthHubFragment", "get auth url success");
        this.aab.aaba(str);
    }
}
