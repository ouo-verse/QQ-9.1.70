package com.tencent.mobileqq.guild.nt.misc.api.impl;

import android.app.Activity;
import android.net.Uri;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.guild.nt.misc.api.ISnapshotApi;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes33.dex */
public class SnapshotApiImpl implements ISnapshotApi {
    @Override // com.tencent.mobileqq.guild.nt.misc.api.ISnapshotApi
    public Uri enterSnapshot(Activity activity, int i3) {
        return ProfileCardUtils.enterSnapshot(activity, i3);
    }

    @Override // com.tencent.mobileqq.guild.nt.misc.api.ISnapshotApi
    public boolean isOnVideoCalling() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            return ((QQAppInterface) peekAppRuntime).isUsingCameraOnVideo();
        }
        return false;
    }
}
