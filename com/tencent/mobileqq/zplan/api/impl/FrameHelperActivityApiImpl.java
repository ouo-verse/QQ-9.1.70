package com.tencent.mobileqq.zplan.api.impl;

import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.zplan.api.IFrameHelperActivityApi;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/impl/FrameHelperActivityApiImpl;", "Lcom/tencent/mobileqq/zplan/api/IFrameHelperActivityApi;", "()V", "isDrawerEnabled", "", "setDrawerFrameEnable", "", "enable", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class FrameHelperActivityApiImpl implements IFrameHelperActivityApi {
    @Override // com.tencent.mobileqq.zplan.api.IFrameHelperActivityApi
    public boolean isDrawerEnabled() {
        return FrameHelperActivity.Fi();
    }

    @Override // com.tencent.mobileqq.zplan.api.IFrameHelperActivityApi
    public void setDrawerFrameEnable(boolean enable) {
        FrameHelperActivity.gj(enable, "FrameHelperActivityApiImpl");
    }
}
