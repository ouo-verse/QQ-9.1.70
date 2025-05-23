package com.tencent.mobileqq.zootopia.ipc;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.luabridge.ZPlanLuaBridge;
import com.tencent.zplan.luabridge.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u000f2\u00020\u00012\u00020\u0002:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ipc/ZootopiaFriendInviteIPCImpl;", "Lcom/tencent/mobileqq/zootopia/ipc/u;", "Lcom/tencent/mobileqq/zootopia/ipc/v;", "Lcom/tencent/mobileqq/zootopia/ipc/aj;", "callback", "", "showNewFriendDialog", "Lcom/tencent/mobileqq/zootopia/ipc/w;", "getNewFriendInvitation", "Lorg/json/JSONObject;", "value", "onNewFriendDialogClose", "onNewFriendInvitation", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaFriendInviteIPCImpl implements u, v {
    public static final String TAG = "ZootopiaFriendInviteIPCImpl";

    @Override // com.tencent.mobileqq.zootopia.ipc.v
    public void getNewFriendInvitation(w callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i(TAG, 1, "getNewFriendInvitation");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if ((peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null) != null) {
            int zPlanUnreadNum = ((INewFriendApi) QRoute.api(INewFriendApi.class)).getZPlanUnreadNum();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("newInvitationCount", zPlanUnreadNum);
            QLog.i(TAG, 1, "getNewFriendInvitation value:" + jSONObject);
            callback.a(jSONObject);
        }
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.u
    public void onNewFriendDialogClose(JSONObject value) {
        Intrinsics.checkNotNullParameter(value, "value");
        QLog.i(TAG, 1, "onNewFriendDialogClose value\uff1a" + value);
        ZPlanLuaBridge zPlanLuaBridge = ZPlanLuaBridge.INSTANCE;
        String jSONObject = value.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "value.toString()");
        a.C10063a.b(zPlanLuaBridge, "N2L_OnNewFriendDialogClose", jSONObject, null, 4, null);
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.u
    public void onNewFriendInvitation(JSONObject value) {
        Intrinsics.checkNotNullParameter(value, "value");
        QLog.i(TAG, 1, "onNewFriendInvitation value\uff1a" + value);
        ZPlanLuaBridge zPlanLuaBridge = ZPlanLuaBridge.INSTANCE;
        String jSONObject = value.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "value.toString()");
        a.C10063a.b(zPlanLuaBridge, "N2L_OnNewFriendInvitation", jSONObject, null, 4, null);
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.v
    public void showNewFriendDialog(aj callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i(TAG, 1, "showNewFriendDialog");
        ((INewFriendApi) QRoute.api(INewFriendApi.class)).startZPlanNewFriendFragment(BaseApplication.getContext(), null);
        callback.onResult(true);
    }
}
