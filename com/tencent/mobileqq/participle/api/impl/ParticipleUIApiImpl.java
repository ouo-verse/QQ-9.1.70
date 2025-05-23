package com.tencent.mobileqq.participle.api.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.participle.ParticipleFragment;
import com.tencent.mobileqq.participle.api.IParticipleUIApi;

/* loaded from: classes33.dex */
public class ParticipleUIApiImpl implements IParticipleUIApi {
    @Override // com.tencent.mobileqq.participle.api.IParticipleUIApi
    public void startFragmentForResult(Activity activity, int i3, Intent intent) {
        ParticipleFragment.yh(activity, i3, intent);
    }
}
