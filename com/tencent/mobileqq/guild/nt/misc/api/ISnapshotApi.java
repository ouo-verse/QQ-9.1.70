package com.tencent.mobileqq.guild.nt.misc.api;

import android.app.Activity;
import android.net.Uri;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface ISnapshotApi extends QRouteApi {
    Uri enterSnapshot(Activity activity, int i3);

    boolean isOnVideoCalling();
}
