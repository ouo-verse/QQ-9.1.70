package com.tencent.mobileqq.zplan.friend.api.impl;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.friend.api.IZPlanChangeFriendApi;
import com.tencent.mobileqq.zplan.friend.api.impl.ZPlanChangeFriendApiImpl;
import com.tencent.mobileqq.zplan.friend.o;
import com.tencent.mobileqq.zplan.friend.q;
import com.tencent.mobileqq.zplan.ipc.business.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.activity.ZplanHostActivity;
import com.tencent.zplan.engine.ZPlanIPCHelper;
import com.tencent.zplan.luabridge.a;
import java.util.ArrayList;
import java.util.List;
import k74.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014JF\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\u001c\u0010\u0011\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zplan/friend/api/impl/ZPlanChangeFriendApiImpl;", "Lcom/tencent/mobileqq/zplan/friend/api/IZPlanChangeFriendApi;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "maxSelectNum", "", "templateID", "", "preselection", "preselectionSex", "requestCode", "", "showChangeRoleFragment", "uin", "Lcom/tencent/mobileqq/zplan/friend/o;", "callback", "getUserAvatar", "requestPlayerSuits", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanChangeFriendApiImpl implements IZPlanChangeFriendApi {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void getUserAvatar$lambda$2(o oVar, boolean z16, String path) {
        QLog.i("ZPlanSameStyle", 1, "getUserAvatar result = " + z16 + ", path = " + path);
        if (oVar != null) {
            Intrinsics.checkNotNullExpressionValue(path, "path");
            oVar.a(z16, path);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showChangeRoleFragment$lambda$1(Activity activity, int i3, int i16, List preselection, List preselectionSex, String str) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(preselection, "$preselection");
        Intrinsics.checkNotNullParameter(preselectionSex, "$preselectionSex");
        ZplanHostActivity.Companion companion = ZplanHostActivity.INSTANCE;
        Bundle bundle = new Bundle();
        bundle.putInt("max_select_num", i16);
        bundle.putStringArrayList("pre_selection", new ArrayList<>(preselection));
        bundle.putIntegerArrayList("pre_selection_sex", new ArrayList<>(preselectionSex));
        bundle.putString("template_id", str);
        bundle.putBoolean("in_little_world_scene", true);
        Unit unit = Unit.INSTANCE;
        ZplanHostActivity.Companion.e(companion, activity, q.class, bundle, i3, 0, 16, null);
    }

    @Override // com.tencent.mobileqq.zplan.friend.api.IZPlanChangeFriendApi
    public void getUserAvatar(String uin, final o callback) {
        ((a) i.INSTANCE.a(a.class)).getUserAvatar(uin, new a.b() { // from class: vh3.a
            @Override // com.tencent.mobileqq.zplan.ipc.business.a.b
            public final void onResult(boolean z16, String str) {
                ZPlanChangeFriendApiImpl.getUserAvatar$lambda$2(o.this, z16, str);
            }
        });
    }

    @Override // com.tencent.mobileqq.zplan.friend.api.IZPlanChangeFriendApi
    public void requestPlayerSuits(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        com.tencent.zplan.luabridge.a k3 = ZPlanIPCHelper.f385519j.k();
        if (k3 != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Uin", uin);
            Unit unit = Unit.INSTANCE;
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026uin)\n        }.toString()");
            a.C10063a.b(k3, "N2L_RequestPlayerSuits", jSONObject2, null, 4, null);
        }
    }

    @Override // com.tencent.mobileqq.zplan.friend.api.IZPlanChangeFriendApi
    public void showChangeRoleFragment(final Activity activity, final int maxSelectNum, final String templateID, final List<String> preselection, final List<Integer> preselectionSex, final int requestCode) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(preselection, "preselection");
        Intrinsics.checkNotNullParameter(preselectionSex, "preselectionSex");
        ThreadManager.getUIHandler().post(new Runnable() { // from class: vh3.b
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanChangeFriendApiImpl.showChangeRoleFragment$lambda$1(activity, requestCode, maxSelectNum, preselection, preselectionSex, templateID);
            }
        });
    }
}
