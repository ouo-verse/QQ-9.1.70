package com.tencent.mobileqq.zplan.authorize.impl.helper;

import com.tencent.mobileqq.zplan.ipc.annotation.ServletImpl;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/zplan/authorize/impl/helper/e;", "", "", "mapId", "", ZPlanPublishSource.FROM_SCHEME, "saveScheme", "", "clearScheme", "getScheme", "", "canAutoLaunch", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
@ServletImpl(impl = AutoLaunchIPCImpl.class)
/* loaded from: classes35.dex */
public interface e {
    boolean canAutoLaunch(String mapId);

    void clearScheme(int mapId);

    String getScheme(int mapId);

    int saveScheme(int mapId, String scheme);
}
