package com.tencent.av.abtest.api.impl;

import com.tencent.av.abtest.api.IQavABTestApi;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QavABTestApiImpl implements IQavABTestApi {
    private ExpEntityInfo mCurrentExpInfo = null;

    @Override // com.tencent.av.abtest.api.IQavABTestApi
    public String getAssignment() {
        return this.mCurrentExpInfo.getAssignment();
    }

    @Override // com.tencent.av.abtest.api.IQavABTestApi
    public String getGrayId() {
        return this.mCurrentExpInfo.getGrayId();
    }

    @Override // com.tencent.av.abtest.api.IQavABTestApi
    public Map<String, String> getParams() {
        return this.mCurrentExpInfo.getTabParams();
    }

    @Override // com.tencent.av.abtest.api.IQavABTestApi
    public boolean isContrast() {
        ExpEntityInfo expEntityInfo = this.mCurrentExpInfo;
        if (expEntityInfo != null && expEntityInfo.isContrast()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.av.abtest.api.IQavABTestApi
    public boolean isExpHit(String str) {
        ExpEntityInfo expEntityInfo = this.mCurrentExpInfo;
        if (expEntityInfo != null && expEntityInfo.isExpHit(str)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.av.abtest.api.IQavABTestApi
    public boolean isExpOnline() {
        ExpEntityInfo expEntityInfo = this.mCurrentExpInfo;
        if (expEntityInfo != null && expEntityInfo.isExpOnline()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.av.abtest.api.IQavABTestApi
    public boolean isExperiment() {
        ExpEntityInfo expEntityInfo = this.mCurrentExpInfo;
        if (expEntityInfo != null && expEntityInfo.isExperiment()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.av.abtest.api.IQavABTestApi
    public IQavABTestApi loadExperiment(String str) {
        this.mCurrentExpInfo = ABTestController.getInstance().getExpEntity(str);
        return this;
    }

    @Override // com.tencent.av.abtest.api.IQavABTestApi
    public void reportEvent(int i3, String str) {
        ExpEntityInfo expEntityInfo = this.mCurrentExpInfo;
        if (expEntityInfo == null) {
            return;
        }
        expEntityInfo.reportEvent(i3, str);
    }

    @Override // com.tencent.av.abtest.api.IQavABTestApi
    public boolean reportExpExposure() {
        if (this.mCurrentExpInfo == null || !ABTestController.getInstance().isTabInited(ABTestController.APPID_1505)) {
            return false;
        }
        this.mCurrentExpInfo.reportExpExposure();
        return true;
    }

    @Override // com.tencent.av.abtest.api.IQavABTestApi
    public void reportExposure(String str) {
        ExpEntityInfo expEntityInfo = this.mCurrentExpInfo;
        if (expEntityInfo == null) {
            return;
        }
        expEntityInfo.reportExpExposure();
    }
}
