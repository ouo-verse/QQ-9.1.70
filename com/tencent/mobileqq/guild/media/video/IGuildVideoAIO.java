package com.tencent.mobileqq.guild.media.video;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildVideoAIO extends QRouteApi {
    int[] getMixThumbSize(int i3, int i16, int i17);

    int[] getThumbSize(int i3, int i16);
}
