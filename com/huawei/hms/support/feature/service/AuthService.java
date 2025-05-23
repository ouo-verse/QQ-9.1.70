package com.huawei.hms.support.feature.service;

import android.content.Intent;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.HuaweiApiInterface;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface AuthService extends HuaweiApiInterface {
    Task<Void> cancelAuthorization();

    Intent getSignInIntent();

    Task<Void> signOut();
}
