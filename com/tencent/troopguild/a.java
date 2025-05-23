package com.tencent.troopguild;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FirstViewGroupGuildInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupGuildNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.GuildMsgAbFlag;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.api.b;
import com.tencent.qqnt.msg.data.h;
import com.tencent.troopguild.api.ITroopGuildInfoService;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/troopguild/a;", "Lcom/tencent/qqnt/msg/api/b;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/FirstViewGroupGuildInfo;", "firstViewGroupGuildInfos", "", "onFirstViewGroupGuildMapping", "<init>", "()V", "troop-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class a implements com.tencent.qqnt.msg.api.b {
    @Override // com.tencent.qqnt.msg.api.b
    public void a(@NotNull h hVar) {
        b.a.h(this, hVar);
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void b(@NotNull byte[] bArr) {
        b.a.g(this, bArr);
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onFirstViewGroupGuildMapping(@NotNull ArrayList<FirstViewGroupGuildInfo> firstViewGroupGuildInfos) {
        Intrinsics.checkNotNullParameter(firstViewGroupGuildInfos, "firstViewGroupGuildInfos");
        HashMap<String, Pair<Long, Integer>> hashMap = new HashMap<>();
        for (FirstViewGroupGuildInfo firstViewGroupGuildInfo : firstViewGroupGuildInfos) {
            try {
                String str = firstViewGroupGuildInfo.groupId;
                Intrinsics.checkNotNullExpressionValue(str, "it.groupId");
                String str2 = firstViewGroupGuildInfo.guildId;
                Intrinsics.checkNotNullExpressionValue(str2, "it.guildId");
                hashMap.put(str, new Pair<>(Long.valueOf(Long.parseLong(str2)), Integer.valueOf(firstViewGroupGuildInfo.groupGuildSwitch)));
            } catch (Exception e16) {
                QLog.e("TroopGuildFirstViewMappingCB", 1, "[onFirstViewGroupGuildMapping]. exception: " + e16.getMessage() + ", " + firstViewGroupGuildInfo);
            }
        }
        QLog.i("TroopGuildFirstViewMappingCB", 1, "[onFirstViewGroupGuildMapping]. troopGuildIds size: " + hashMap.size());
        ((ITroopGuildInfoService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ITroopGuildInfoService.class, "")).handleRegisterProxyGuildId(hashMap);
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onGroupGuildUpdate(@NotNull GroupGuildNotifyInfo groupGuildNotifyInfo) {
        b.a.b(this, groupGuildNotifyInfo);
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onGuildMsgAbFlagChanged(@NotNull GuildMsgAbFlag guildMsgAbFlag) {
        b.a.c(this, guildMsgAbFlag);
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onRecvGroupGuildFlag(int i3) {
        b.a.d(this, i3);
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onRecvMsg(@NotNull ArrayList<MsgRecord> arrayList) {
        b.a.e(this, arrayList);
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onRecvUDCFlag(int i3) {
        b.a.f(this, i3);
    }
}
