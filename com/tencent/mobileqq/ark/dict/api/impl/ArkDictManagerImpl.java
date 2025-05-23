package com.tencent.mobileqq.ark.dict.api.impl;

import com.tencent.mobileqq.app.bc;
import com.tencent.mobileqq.ark.dict.ArkAiDictMgr;
import com.tencent.mobileqq.ark.dict.ArkAiDictUpdateMgr;
import com.tencent.mobileqq.ark.dict.ArkRecommendLogic;
import com.tencent.mobileqq.ark.dict.api.IArkDictManager;
import com.tencent.mobileqq.ark.dict.f;
import com.tencent.mobileqq.ark.dict.g;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArkDictManagerImpl implements IArkDictManager {
    private AppRuntime appRuntime;
    private ArkAiDictMgr mDictMgr;
    private ArkAiDictUpdateMgr mDictUpdateMgr;

    @Override // com.tencent.mobileqq.ark.dict.api.IArkDictManager
    public void clearDict() {
        this.mDictMgr.e();
    }

    @Override // com.tencent.mobileqq.ark.dict.api.IArkDictManager
    public bc getAnalysisThread() {
        return ArkRecommendLogic.a();
    }

    @Override // com.tencent.mobileqq.ark.dict.api.IArkDictManager
    public void initWordData() {
        ArkAiDictMgr.j(this.appRuntime);
    }

    @Override // com.tencent.mobileqq.ark.dict.api.IArkDictManager
    public boolean isUseTestDict() {
        return f.a();
    }

    @Override // com.tencent.mobileqq.ark.dict.api.IArkDictManager
    public void loadTestDict() {
        this.mDictMgr.l();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.appRuntime = appRuntime;
        this.mDictMgr = new ArkAiDictMgr();
        this.mDictUpdateMgr = new ArkAiDictUpdateMgr(appRuntime);
    }

    @Override // com.tencent.mobileqq.ark.dict.api.IArkDictManager
    public void reloadWordData() {
        ArkAiDictMgr.n(this.appRuntime);
    }

    @Override // com.tencent.mobileqq.ark.dict.api.IArkDictManager
    public void setUseTestDict(boolean z16) {
        f.b(z16);
    }

    @Override // com.tencent.mobileqq.ark.dict.api.IArkDictManager
    public void updateLocalDict() {
        this.mDictUpdateMgr.P();
    }

    @Override // com.tencent.mobileqq.ark.dict.api.IArkDictManager
    public g wordSegment(String str) {
        return ArkAiDictMgr.o(this.appRuntime, str);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }
}
