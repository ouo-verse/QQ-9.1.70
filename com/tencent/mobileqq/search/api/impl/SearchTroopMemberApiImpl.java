package com.tencent.mobileqq.search.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.search.api.ISearchTroopMemberApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/search/api/impl/SearchTroopMemberApiImpl;", "Lcom/tencent/mobileqq/search/api/ISearchTroopMemberApi;", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "member", "", "canSelectToRemove", "<init>", "()V", "Companion", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchTroopMemberApiImpl implements ISearchTroopMemberApi {

    @NotNull
    public static final String TAG = "SearchTroopMemberApiImpl";

    @Override // com.tencent.mobileqq.search.api.ISearchTroopMemberApi
    public boolean canSelectToRemove(@Nullable TroopMemberInfo member) {
        boolean z16;
        if (member == null || TextUtils.isEmpty(member.troopuin) || member.role == MemberRole.OWNER) {
            return false;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.w(TAG, 1, "[canSelectToRemove] app runtime is null");
            return false;
        }
        if (TextUtils.equals(peekAppRuntime.getCurrentAccountUin(), member.memberuin)) {
            return false;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(ITroopInfoService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026va, ProcessConstant.MAIN)");
        TroopInfo findTroopInfo = ((ITroopInfoService) runtimeService).findTroopInfo(member.troopuin);
        if (findTroopInfo == null) {
            QLog.w(TAG, 1, "[canSelectToRemove] troopInfo is null");
            return false;
        }
        boolean isTroopOwner = findTroopInfo.isTroopOwner(peekAppRuntime.getCurrentAccountUin());
        if (member.role == MemberRole.ADMIN) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!isTroopOwner && z16) {
            return false;
        }
        return true;
    }
}
