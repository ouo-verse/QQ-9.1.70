package com.tencent.mobileqq.zootopia.video;

import com.tencent.mobileqq.qqvideoedit.api.IQQVideoEditApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.ipc.ak;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ8\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0005H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/video/ZootopiaVideoCutApiImpl;", "Lcom/tencent/mobileqq/zootopia/ipc/ak;", "", "videoPath", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "extraInfo", "", "jumpToVideoCutPage", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaVideoCutApiImpl implements ak {
    @Override // com.tencent.mobileqq.zootopia.ipc.ak
    public void jumpToVideoCutPage(String videoPath, HashMap<String, String> extraInfo) {
        Intrinsics.checkNotNullParameter(videoPath, "videoPath");
        ((IQQVideoEditApi) QRoute.api(IQQVideoEditApi.class)).jumpToZootopiaVideoEditPage(videoPath, extraInfo);
    }
}
