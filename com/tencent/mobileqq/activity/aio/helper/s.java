package com.tencent.mobileqq.activity.aio.helper;

import android.text.TextUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IGuildTroopApi;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/helper/s;", "Lcom/tencent/qqnt/aio/frame/b;", "", "peerId", "", "peerUin", "", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class s implements com.tencent.qqnt.aio.frame.b {
    @Override // com.tencent.qqnt.aio.frame.b
    public boolean a(@Nullable String peerId, long peerUin) {
        boolean z16;
        boolean isGuildTroop;
        TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(peerId);
        if (troopInfoFromCache != null && troopInfoFromCache.hadJoinTroop()) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i("AIODelegate", 1, "[isValidTroop]: " + z16 + ", peerId: " + peerId);
        if (TextUtils.isEmpty(peerId)) {
            isGuildTroop = false;
        } else {
            IGuildTroopApi iGuildTroopApi = (IGuildTroopApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IGuildTroopApi.class);
            Intrinsics.checkNotNull(peerId);
            isGuildTroop = iGuildTroopApi.isGuildTroop(peerId);
        }
        QLog.i("AIODelegate", 1, "[isTroopGuild]: " + isGuildTroop + ", peerId: " + peerId);
        if (!z16 || isGuildTroop) {
            return false;
        }
        return true;
    }
}
