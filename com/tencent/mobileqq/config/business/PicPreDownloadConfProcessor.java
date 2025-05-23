package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Pattern;

/* loaded from: classes10.dex */
public class PicPreDownloadConfProcessor extends com.tencent.mobileqq.config.l<au> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public au migrateOldOrDefaultContent(int i3) {
        return new au();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public au onParsed(com.tencent.mobileqq.config.ai[] aiVarArr) {
        if (QLog.isColorLevel() && aiVarArr != null) {
            QLog.d("PicPreDownloadConfProcessor", 2, "onParsed " + aiVarArr.length);
        }
        if (aiVarArr != null && aiVarArr.length > 0) {
            return au.b(aiVarArr);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(au auVar) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d("PicPreDownloadConfProcessor", 2, "onUpdate " + auVar.toString());
        }
        if (Pattern.matches("(\\d+?\\|){7}\\d+", auVar.f202540g)) {
            com.tencent.mobileqq.pic.a.h("flowCombination", auVar.f202540g, true);
        }
        if (Pattern.matches("(\\d+?\\|){3}\\d+", auVar.f202541h)) {
            com.tencent.mobileqq.pic.a.h("troopCombination", auVar.f202541h, true);
        }
        long j3 = auVar.f202542i;
        if (j3 > 0) {
            com.tencent.mobileqq.pic.a.f("maxRequest", j3, true);
        }
        long j16 = auVar.f202534a;
        boolean z17 = false;
        if (j16 == 0 || j16 == 1) {
            if (j16 == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            com.tencent.mobileqq.pic.a.g("PicPreDownSwitchNew", z16, true);
        }
        long j17 = auVar.f202535b;
        if (j17 == 0 || j17 == 1 || j17 == 2 || j17 == 3) {
            com.tencent.mobileqq.pic.a.f("PicAuDownTimePoint", j17, true);
        }
        long j18 = auVar.f202536c;
        if (j18 > 0) {
            com.tencent.mobileqq.pic.a.f("MaxWifiFlow", j18, true);
        }
        long j19 = auVar.f202537d;
        if (j19 > 0) {
            com.tencent.mobileqq.pic.a.f("Max4GFlow", j19, true);
        }
        long j26 = auVar.f202538e;
        if (j26 > 0) {
            com.tencent.mobileqq.pic.a.f("Max3GFlow", j26, true);
        }
        long j27 = auVar.f202539f;
        if (j27 > 0) {
            com.tencent.mobileqq.pic.a.f("Max2GFlow", j27, true);
        }
        if (Pattern.matches("^[0-9A-Fa-f]+$", auVar.f202543j)) {
            com.tencent.mobileqq.pic.a.f("xGPreDownPolicy", Long.valueOf(auVar.f202543j, 16).longValue(), true);
        }
        long j28 = auVar.f202544k;
        if (j28 > 0) {
            com.tencent.mobileqq.pic.a.f("AFBFlowHitXG", j28, true);
        }
        long j29 = auVar.f202545l;
        if (j29 > 0) {
            com.tencent.mobileqq.pic.a.f("AFBFlowMissXG", j29, true);
        }
        long j36 = auVar.f202546m;
        if (j36 > 0) {
            com.tencent.mobileqq.pic.a.f("APicAvgSize", j36, true);
        }
        long j37 = auVar.f202547n;
        if (j37 > 0) {
            com.tencent.mobileqq.pic.a.f("APicMaxSize", j37, true);
        }
        long j38 = auVar.f202548o;
        if (j38 == 0 || j38 == 1) {
            if (j38 == 1) {
                z17 = true;
            }
            com.tencent.mobileqq.pic.a.g("enablePeakFlow", z17, true);
        }
        if (Pattern.matches("^((([01]?[0-9]|2[01234])-([01]?[0-9]|2[01234]);)*+([01]?[0-9]|2[01234])-([01]?[0-9]|2[01234]))$", auVar.f202549p)) {
            com.tencent.mobileqq.pic.a.h("PeakFlowTimePeriod", auVar.f202549p, true);
        }
        long j39 = auVar.f202550q;
        if (j39 > 0) {
            com.tencent.mobileqq.pic.a.f("PeakFlowMaxPicSize", j39, true);
        }
        int i3 = auVar.f202551r;
        if (i3 > 0 && auVar.f202552s > 0) {
            com.tencent.mobileqq.pic.a.f("gifWifiPreDownloadLimit", i3, true);
            com.tencent.mobileqq.pic.a.f("gifXgPreDownloadLimit", auVar.f202552s, true);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<au> clazz() {
        return au.class;
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
    public boolean isNeedUpgradeReset() {
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public int migrateOldVersion() {
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("PicPreDownloadConfProcessor", 2, "onReqFailed " + i3);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 616;
    }
}
