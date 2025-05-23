package com.huawei.hms.health;

import com.huawei.hmf.tasks.OnFailureListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class aabc implements OnFailureListener {
    final /* synthetic */ aaba aab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aabc(aaba aabaVar) {
        this.aab = aabaVar;
    }

    @Override // com.huawei.hmf.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        aabz.aabc("HealthKitAuthHubFragment", "can not get auth url");
        this.aab.aaba("");
    }
}
