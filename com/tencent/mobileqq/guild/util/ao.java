package com.tencent.mobileqq.guild.util;

import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;

/* compiled from: P */
/* loaded from: classes14.dex */
public class ao {
    public static boolean a(IGProChannelInfo iGProChannelInfo) {
        if (iGProChannelInfo == null || iGProChannelInfo.getMyTalkPermissionType() != 2) {
            return false;
        }
        return true;
    }
}
