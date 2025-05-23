package com.tencent.mobileqq.vas.kuikly.moduleimpl;

import android.text.TextUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.f;
import com.tencent.mobileqq.vas.manager.api.IGXHManager;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import eipc.EIPCCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ;\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tJ;\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/f;", "", "", "jsonString", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "c", "b", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class f {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Function1 function1, String str) {
        if (function1 != null) {
            function1.invoke(str);
        }
    }

    public final void b(@NotNull String jsonString, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        QLog.i("GXH", 1, "openPanel " + jsonString);
        JSONObject jSONObject = new JSONObject(jsonString);
        String optString = jSONObject.optString("uin");
        boolean optBoolean = jSONObject.optBoolean("isGroup");
        boolean optBoolean2 = jSONObject.optBoolean("needRemark");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("name", optString);
        String str = null;
        if (!optBoolean) {
            String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(optString);
            if (optBoolean2) {
                IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
                Intrinsics.checkNotNullExpressionValue(uid, "uid");
                str = iFriendsInfoService.getRemarkWithUid(uid, "VasKuiklyModule");
            }
            if (TextUtils.isEmpty(str)) {
                IFriendsInfoService iFriendsInfoService2 = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
                Intrinsics.checkNotNullExpressionValue(uid, "uid");
                str = iFriendsInfoService2.getNickWithUid(uid, "VasKuiklyModule");
            }
            if (!TextUtils.isEmpty(str)) {
                jSONObject2.put("name", str);
            }
        } else {
            TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(optString);
            if (troopInfoFromCache != null) {
                str = troopInfoFromCache.getTroopDisplayName();
            }
            if (!TextUtils.isEmpty(str)) {
                jSONObject2.put("name", str);
            }
        }
        if (callback != null) {
            callback.invoke(jSONObject2);
        }
    }

    public final void c(@NotNull String jsonString, @Nullable final Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        QLog.i("GXH", 1, "openPanel " + jsonString);
        JSONObject jSONObject = new JSONObject(jsonString);
        IGXHManager gxh = VasUtil.getService().getGxh();
        IGXHManager.FriendSelectParams a16 = IGXHManager.FriendSelectParams.INSTANCE.a(jSONObject);
        EIPCCallback a17 = com.tencent.mobileqq.vas.api.f.a(new f.b() { // from class: com.tencent.mobileqq.vas.kuikly.moduleimpl.e
            @Override // com.tencent.mobileqq.vas.api.f.b
            public final void onCallback(String str) {
                f.d(Function1.this, str);
            }
        });
        Intrinsics.checkNotNullExpressionValue(a17, "buildCallback {\n        \u2026.invoke(it)\n            }");
        gxh.openSelectFriendsPanel(a16, a17);
    }
}
