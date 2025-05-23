package com.tencent.gdtad.adapter;

import com.tencent.ad.tangram.privacy.AdPrivacyPolicyManagerAdapter;
import com.tencent.mobileqq.app.privacy.PrivacyPolicyHelper;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class l implements AdPrivacyPolicyManagerAdapter {
    @Override // com.tencent.ad.tangram.privacy.AdPrivacyPolicyManagerAdapter
    public boolean isAllowed() {
        return PrivacyPolicyHelper.isUserAllow();
    }
}
