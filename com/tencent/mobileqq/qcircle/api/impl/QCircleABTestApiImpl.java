package com.tencent.mobileqq.qcircle.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import uq3.o;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleABTestApiImpl implements IQCircleABTestApi {
    private static final Set<String> REPORT_RECORD = Collections.synchronizedSet(new HashSet());
    private static final String TAG = "QCircleABTestApi";

    private boolean hasReport(String str) {
        if (!o.c2()) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        Set<String> set = REPORT_RECORD;
        if (set.contains(str)) {
            return true;
        }
        set.add(str);
        return false;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleABTestApi
    public String getAssignment(String str) {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(str);
        if (expEntity == null) {
            return null;
        }
        return expEntity.getAssignment();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleABTestApi
    public String getAssignmentByLayerCode(String str) {
        ExpEntityInfo expEntityByLayerCode = ABTestController.getInstance().getExpEntityByLayerCode(str);
        if (expEntityByLayerCode == null) {
            return null;
        }
        return expEntityByLayerCode.getAssignment();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleABTestApi
    public String getExpNameByLayerCode(String str) {
        ExpEntityInfo expEntityByLayerCode = ABTestController.getInstance().getExpEntityByLayerCode(str);
        if (expEntityByLayerCode == null) {
            return null;
        }
        return expEntityByLayerCode.getExpName();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleABTestApi
    public Map<String, String> getParams(String str) {
        String str2;
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(str);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[getParams] entityInfo: ");
            if (expEntity == null) {
                str2 = "null";
            } else {
                str2 = expEntity.toStr();
            }
            sb5.append(str2);
            QLog.d(TAG, 2, sb5.toString());
        }
        if (expEntity == null) {
            return null;
        }
        return expEntity.getTabParams();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleABTestApi
    public Map<String, String> getParamsByLayerCode(String str) {
        ExpEntityInfo expEntityByLayerCode = ABTestController.getInstance().getExpEntityByLayerCode(str);
        if (expEntityByLayerCode == null) {
            return null;
        }
        return expEntityByLayerCode.getTabParams();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleABTestApi
    public boolean isContrast(String str) {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(str);
        if (expEntity != null && expEntity.isContrast()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleABTestApi
    public boolean isExpHit(String str, String str2) {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(str);
        if (expEntity != null && expEntity.isExpHit(str2)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleABTestApi
    public boolean isExpOnline(String str) {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(str);
        if (expEntity == null) {
            return false;
        }
        return expEntity.isExpOnline();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleABTestApi
    public boolean isExperiment(String str) {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(str);
        if (expEntity != null && expEntity.isExperiment()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleABTestApi
    public boolean isTabSDKInited() {
        return ABTestController.getInstance().isTabSDKInited();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleABTestApi
    public void onAccountChange() {
        if (!o.c2()) {
            return;
        }
        REPORT_RECORD.clear();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleABTestApi
    public void reportEvent(String str, int i3, String str2) {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(str);
        if (expEntity == null) {
            return;
        }
        expEntity.reportEvent(i3, str2);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleABTestApi
    public void reportExpExposure(String str) {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(str);
        if (expEntity == null || hasReport(str) || TextUtils.isEmpty(expEntity.getAssignment())) {
            return;
        }
        expEntity.reportExpExposure();
        com.tencent.qcircle.cooperation.config.debug.e.a(new com.tencent.qcircle.cooperation.config.debug.e(System.currentTimeMillis(), str, 1505, expEntity.getAssignment()));
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleABTestApi
    public void reportExposure(String str, String str2) {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(str);
        if (expEntity == null) {
            return;
        }
        expEntity.reportExposure(str2);
    }
}
