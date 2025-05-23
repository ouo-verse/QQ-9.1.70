package com.tencent.mobileqq.minigame.metafarm.data;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tJ\u0014\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/minigame/metafarm/data/MetaFarmStatusManager;", "", "()V", "TAG", "", "statusList", "", "Lcom/tencent/mobileqq/minigame/metafarm/data/MetaFarmStatus;", "getStatusList", "", "saveStatusList", "", "list", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MetaFarmStatusManager {
    public static final String TAG = "MetaFarmStatusManager";
    public static final MetaFarmStatusManager INSTANCE = new MetaFarmStatusManager();
    private static List<MetaFarmStatus> statusList = new ArrayList();

    MetaFarmStatusManager() {
    }

    public final List<MetaFarmStatus> getStatusList() {
        return statusList;
    }

    public final void saveStatusList(List<MetaFarmStatus> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        statusList.clear();
        statusList.addAll(list);
    }
}
