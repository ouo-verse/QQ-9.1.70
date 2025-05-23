package com.tencent.mobileqq.guild.nt.misc.api.impl;

import android.app.Activity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.guild.nt.misc.api.IActivityClassesApi;

/* compiled from: P */
/* loaded from: classes14.dex */
public class ActivityClassesApiImpl implements IActivityClassesApi {
    @Override // com.tencent.mobileqq.guild.nt.misc.api.IActivityClassesApi
    public Class<? extends Activity> getJumpActivityClass() {
        return JumpActivity.class;
    }
}
