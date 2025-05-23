package com.tencent.mobileqq.vas.message;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.state.square.api.MessageRecordType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vas/message/c;", "", "", "uin", "", "a", "troopUin", "b", "", "uinType", "Lcom/tencent/state/square/api/MessageRecordType;", "c", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f310029a = new c();

    c() {
    }

    public final boolean a(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if ((runtime instanceof QQAppInterface ? (QQAppInterface) runtime : null) == null) {
            return true;
        }
        return !FriendsStatusUtil.k(uin, r0);
    }

    public final boolean b(String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        return appInterface != null && ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getTroopMask(appInterface, troopUin) == GroupMsgMask.NOTIFY;
    }

    public final MessageRecordType c(int uinType) {
        if (uinType == 0) {
            return MessageRecordType.RECORD_TYPE_FRIEND;
        }
        if (uinType == 1) {
            return MessageRecordType.RECORD_TYPE_TROOP;
        }
        if (uinType != 10019) {
            return MessageRecordType.RECORD_TYPE_NONE;
        }
        return MessageRecordType.RECORD_TYPE_SQUARE_TEMP;
    }
}
