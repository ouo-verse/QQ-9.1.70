package com.tencent.mobileqq.selectfriend.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectfriend.api.ISelectNtSaveRecentUserApi;
import com.tencent.mobileqq.troop.blocktroop.k;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\"\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0002J \u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u001a\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/api/impl/SelectNtSaveRecentUserApiImpl;", "Lcom/tencent/mobileqq/selectfriend/api/ISelectNtSaveRecentUserApi;", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "appRuntime", "Lcom/tencent/mobileqq/data/RecentUser;", "recentUser", "", "forceUpdateParcelData", "hiddenChatOnSaveRecentUser", "troopOnSaveRecentUser", "needFilter", "hiddenChatShouldAddToList", "troopShouldAddToList", "onSaveRecentUser", "shouldAddToList", "<init>", "()V", "Companion", "a", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SelectNtSaveRecentUserApiImpl implements ISelectNtSaveRecentUserApi {
    private static final String TAG = "RelationNTSaveRecentUserApiImpl";

    private final RecentUser hiddenChatOnSaveRecentUser(BaseQQAppInterface appRuntime, RecentUser recentUser, boolean forceUpdateParcelData) {
        int i3 = recentUser.type;
        if ((i3 == 1 || i3 == 0) && (appRuntime instanceof QQAppInterface)) {
            String str = recentUser.uin;
            Intrinsics.checkNotNullExpressionValue(str, "recentUser.uin");
            recentUser.isHiddenChat = com.tencent.mobileqq.app.nthiddenchat.b.h(str, recentUser.getType(), (QQAppInterface) appRuntime) ? 1 : 0;
        }
        return recentUser;
    }

    private final boolean hiddenChatShouldAddToList(BaseQQAppInterface appRuntime, RecentUser recentUser, boolean needFilter) {
        int i3 = recentUser.type;
        if ((i3 == 1 || i3 == 0) && (appRuntime instanceof QQAppInterface)) {
            String str = recentUser.uin;
            Intrinsics.checkNotNullExpressionValue(str, "recentUser.uin");
            if (com.tencent.mobileqq.app.nthiddenchat.b.h(str, recentUser.type, (QQAppInterface) appRuntime)) {
                return false;
            }
        }
        return true;
    }

    private final RecentUser troopOnSaveRecentUser(BaseQQAppInterface appRuntime, RecentUser recentUser, boolean forceUpdateParcelData) {
        if (TextUtils.equals(recentUser.uin, AppConstants.TROOP_SUSPICIOUS_MSG_UIN)) {
            QLog.e(TAG, 1, "\u5df2\u8fc7\u6ee4\u7fa4\u901a\u77e5\u88ab\u8fc7\u6ee4 stack: " + QLog.getStackTraceString(new Throwable()));
            return null;
        }
        if (recentUser.type == 1 && (appRuntime instanceof QQAppInterface)) {
            GroupMsgMask troopMask = ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getTroopMask(appRuntime, recentUser.uin);
            if (troopMask == GroupMsgMask.ASSISTANT || troopMask == GroupMsgMask.SHIELD) {
                return null;
            }
            TroopInfo troopInfoFromCache = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getTroopInfoFromCache(recentUser.uin);
            if (troopInfoFromCache != null) {
                recentUser.showUpTime = troopInfoFromCache.setTopTime;
            }
        }
        return recentUser;
    }

    private final boolean troopShouldAddToList(BaseQQAppInterface appRuntime, RecentUser recentUser, boolean needFilter) {
        GroupMsgMask troopMask;
        if (TextUtils.equals(recentUser.uin, AppConstants.TROOP_SUSPICIOUS_MSG_UIN)) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, " Filtered troop notifications(uin is 9915) had be Add in recentCache,type:" + recentUser.type);
            }
            return false;
        }
        if (appRuntime instanceof QQAppInterface) {
            if (recentUser.type == 1) {
                if (k.s((QQAppInterface) appRuntime, recentUser.uin) || (troopMask = ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getTroopMask(appRuntime, recentUser.uin)) == GroupMsgMask.ASSISTANT || troopMask == GroupMsgMask.SHIELD) {
                    return false;
                }
            } else if (recentUser.getType() == 9000) {
                return false;
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.selectfriend.api.ISelectNtSaveRecentUserApi
    public RecentUser onSaveRecentUser(RecentUser recentUser, boolean forceUpdateParcelData) {
        Intrinsics.checkNotNullParameter(recentUser, "recentUser");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        BaseQQAppInterface baseQQAppInterface = peekAppRuntime instanceof BaseQQAppInterface ? (BaseQQAppInterface) peekAppRuntime : null;
        if (baseQQAppInterface == null || hiddenChatOnSaveRecentUser(baseQQAppInterface, recentUser, forceUpdateParcelData) == null || troopOnSaveRecentUser(baseQQAppInterface, recentUser, forceUpdateParcelData) == null) {
            return null;
        }
        return recentUser;
    }

    @Override // com.tencent.mobileqq.selectfriend.api.ISelectNtSaveRecentUserApi
    public boolean shouldAddToList(RecentUser recentUser, boolean needFilter) {
        Intrinsics.checkNotNullParameter(recentUser, "recentUser");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        BaseQQAppInterface baseQQAppInterface = peekAppRuntime instanceof BaseQQAppInterface ? (BaseQQAppInterface) peekAppRuntime : null;
        return baseQQAppInterface != null && hiddenChatShouldAddToList(baseQQAppInterface, recentUser, needFilter) && troopShouldAddToList(baseQQAppInterface, recentUser, needFilter);
    }
}
