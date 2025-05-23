package com.tencent.mobileqq.teamwork.api.impl;

import android.app.Activity;
import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.teamwork.api.IGroupTeamWorkAdapterCreator;

/* compiled from: P */
/* loaded from: classes18.dex */
public class GroupTeamWorkAdapterCreatorImpl implements IGroupTeamWorkAdapterCreator {
    @Override // com.tencent.mobileqq.teamwork.api.IGroupTeamWorkAdapterCreator
    public com.tencent.mobileqq.teamwork.g getGroupTeamWorkAdapter(AppInterface appInterface, Activity activity, com.tencent.mobileqq.teamwork.m mVar, Handler handler) {
        return new com.tencent.mobileqq.teamworkforgroup.e(appInterface, activity, mVar, handler);
    }
}
