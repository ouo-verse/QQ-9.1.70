package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProNavigationItemExt;

/* loaded from: classes17.dex */
public class GGProNavigationItemExt implements IGProNavigationItemExt {
    public final GProNavigationItemExt mInfo;

    public GGProNavigationItemExt(GProNavigationItemExt gProNavigationItemExt) {
        this.mInfo = gProNavigationItemExt;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationItemExt
    public String getGameOnlineCnt() {
        return this.mInfo.getGameOnlineCnt();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationItemExt
    public String toString() {
        return this.mInfo.toString();
    }
}
