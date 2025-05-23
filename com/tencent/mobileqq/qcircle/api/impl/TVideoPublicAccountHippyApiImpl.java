package com.tencent.mobileqq.qcircle.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.qcircle.api.ITVideoPublicAccountHippyApi;
import com.tencent.mobileqq.tvideo.hippy.TVideoPublicAccountHippyProvider;
import com.tencent.mtt.hippy.HippyAPIProvider;

/* loaded from: classes16.dex */
public class TVideoPublicAccountHippyApiImpl implements ITVideoPublicAccountHippyApi {
    private static final String TVIDEO_PUBLIC_ACCOUNT_PREFIX = "TenVideoPublic";

    @Override // com.tencent.mobileqq.qcircle.api.ITVideoPublicAccountHippyApi
    public HippyAPIProvider createHippyProvider() {
        return new TVideoPublicAccountHippyProvider();
    }

    @Override // com.tencent.mobileqq.qcircle.api.ITVideoPublicAccountHippyApi
    public boolean isTVideoPublicAccountModule(String str) {
        if (!TextUtils.isEmpty(TVIDEO_PUBLIC_ACCOUNT_PREFIX) && str.startsWith(TVIDEO_PUBLIC_ACCOUNT_PREFIX)) {
            return true;
        }
        return false;
    }
}
