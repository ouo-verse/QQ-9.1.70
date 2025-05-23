package com.tencent.mobileqq.troop.file.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.dpc.DeviceProfileManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import java.util.List;

/* compiled from: P */
/* loaded from: classes35.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    QQAppInterface f295525a;

    /* renamed from: b, reason: collision with root package name */
    String f295526b;

    /* renamed from: c, reason: collision with root package name */
    Context f295527c;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a implements com.tencent.qqnt.troopmemberlist.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SharedPreferences f295528a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f295529b;

        a(SharedPreferences sharedPreferences, String str) {
            this.f295528a = sharedPreferences;
            this.f295529b = str;
        }

        @Override // com.tencent.qqnt.troopmemberlist.f
        public void a(boolean z16, List<? extends TroopMemberInfo> list) {
            QLog.e("RefreshMemberList", 4, "onUpdateTroopGetMemberList - success");
            this.f295528a.edit().putLong("key_last_update_time" + this.f295529b, System.currentTimeMillis()).commit();
        }
    }

    public r(QQAppInterface qQAppInterface, Context context, String str) {
        this.f295525a = qQAppInterface;
        this.f295527c = context;
        this.f295526b = str;
    }

    private String a(String str) {
        TroopInfo k3;
        TroopManager troopManager = (TroopManager) this.f295525a.getManager(QQManagerFactory.TROOP_MANAGER);
        if (troopManager == null || (k3 = troopManager.k(str)) == null) {
            return null;
        }
        return k3.troopcode;
    }

    public void b(boolean z16, LifecycleOwner lifecycleOwner) {
        QLog.e("RefreshMemberList", 4, "Prepare refreshMemberListFromServer");
        if (TextUtils.isEmpty(this.f295526b)) {
            return;
        }
        String a16 = a(this.f295526b);
        if (TextUtils.isEmpty(a16)) {
            return;
        }
        SharedPreferences sharedPreferences = this.f295527c.getSharedPreferences(DeviceProfileManager.KEY_LAST_UPDATE_TIME, 4);
        long j3 = sharedPreferences.getLong("key_last_update_time" + a16, 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (!z16 && j3 != 0 && (j3 <= 0 || currentTimeMillis - j3 <= MiniBoxNoticeInfo.MIN_5)) {
            QLog.e("RefreshMemberList", 4, "< 5min, Will not refresh.");
            return;
        }
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberList(this.f295526b, lifecycleOwner, true, "TroopMemberListRefresh", new a(sharedPreferences, a16));
        if (j3 == 0) {
            QLog.e("RefreshMemberList", 4, "Not refresh now, will refresh.");
        } else {
            QLog.e("RefreshMemberList", 4, "> 5min, will refresh.");
        }
    }
}
