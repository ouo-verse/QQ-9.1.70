package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProUserGuideBubble;

/* loaded from: classes17.dex */
public class GGProUserGuideBubble implements IGProUserGuideBubble {
    public final GProUserGuideBubble mInfo;

    public GGProUserGuideBubble(GProUserGuideBubble gProUserGuideBubble) {
        this.mInfo = gProUserGuideBubble;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserGuideBubble
    public String getIconUrl() {
        return this.mInfo.getIconUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserGuideBubble
    public String getTitle() {
        return this.mInfo.getTitle();
    }
}
