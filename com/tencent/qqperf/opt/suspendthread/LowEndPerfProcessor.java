package com.tencent.qqperf.opt.suspendthread;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.config.l;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.qphone.base.util.QLog;
import vy3.a;
import vy3.b;

/* loaded from: classes25.dex */
public class LowEndPerfProcessor extends l<b> {
    public static b a() {
        b bVar = (b) am.s().x(PlayerResources.ViewId.OPEN_FREE_TRAFFIC_CONTAINER);
        if (bVar == null) {
            return new b();
        }
        return bVar;
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b migrateOldOrDefaultContent(int i3) {
        return new b();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b onParsed(ai[] aiVarArr) {
        ai aiVar;
        if (aiVarArr != null && aiVarArr.length > 0 && (aiVar = aiVarArr[0]) != null) {
            b b16 = b.b(aiVar.f202268b);
            if (QLog.isColorLevel()) {
                QLog.d("Perf", 2, "onParsed " + aiVarArr[0].f202268b);
            }
            return b16;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Perf", 2, "onParsed is null");
            return null;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<b> clazz() {
        return b.class;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onUpdate(b bVar) {
        if (bVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d("Perf", 2, "onUpdate but newConf==null");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Perf", 2, "onUpdate " + bVar.toString());
        }
        SharedPreferences.Editor edit = a.a().edit();
        edit.putBoolean("disablepreloadproc_new", bVar.f443751a);
        edit.putBoolean("disablegettrooplist_new", bVar.f443753c);
        edit.putBoolean("disablepredownload_new", bVar.f443752b);
        edit.putBoolean("enableautoperf_new", bVar.f443754d);
        edit.putString("userratio_new", bVar.f443755e);
        edit.putString("extralsteps_new", bVar.f443756f);
        edit.putString("predownloadwhitelist_new", bVar.f443757g);
        edit.putBoolean("enable_thread_suspend", bVar.f443759i);
        edit.putBoolean("fake_enable_thread_suspend", bVar.f443760j);
        edit.putBoolean("suspendWhiteListOnly", bVar.f443761k);
        edit.commit();
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isAccountRelated() {
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedCompressed() {
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedStoreLargeFile() {
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    public int migrateOldVersion() {
        if (QLog.isColorLevel()) {
            QLog.d("Perf", 2, "migrateOldVersion");
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("Perf", 2, "onReqFailed ", Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return PlayerResources.ViewId.OPEN_FREE_TRAFFIC_CONTAINER;
    }
}
