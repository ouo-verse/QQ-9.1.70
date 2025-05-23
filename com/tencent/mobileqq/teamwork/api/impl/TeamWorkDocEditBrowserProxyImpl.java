package com.tencent.mobileqq.teamwork.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocEditBrowserProxy;

/* loaded from: classes18.dex */
public class TeamWorkDocEditBrowserProxyImpl implements ITeamWorkDocEditBrowserProxy {
    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkDocEditBrowserProxy
    public Intent getClassIntent(Context context) {
        return new Intent(context, (Class<?>) TeamWorkDocEditBrowserActivity.class);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkDocEditBrowserProxy
    public Intent getOpenTeamWorkIntent(Intent intent, String str, Context context) {
        return TeamWorkDocEditBrowserActivity.getOpenTeamWorkIntent(intent, str, context);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkDocEditBrowserProxy
    public boolean isInstanceClass(Activity activity) {
        return activity instanceof TeamWorkDocEditBrowserActivity;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkDocEditBrowserProxy
    public boolean openDocsMiniApp(Context context, String str, String str2) {
        return TeamWorkDocEditBrowserActivity.openDocsMiniApp(context, str, str2);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkDocEditBrowserProxy
    public void openTeamWorkDocEditBrowserActivity(Context context, Bundle bundle, boolean z16) {
        TeamWorkDocEditBrowserActivity.openTeamWorkDocEditBrowserActivity(context, bundle, z16);
    }
}
