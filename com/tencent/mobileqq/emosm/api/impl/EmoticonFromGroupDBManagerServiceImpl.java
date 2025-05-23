package com.tencent.mobileqq.emosm.api.impl;

import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.mobileqq.emosm.api.IEmoticonFromGroupDBManagerService;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes6.dex */
public class EmoticonFromGroupDBManagerServiceImpl implements IEmoticonFromGroupDBManagerService<EmoticonFromGroupEntity> {
    public static final String TAG = "EmoticonFromGroup_DBManager";
    protected volatile int mCountOfSpare = 0;

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonFromGroupDBManagerService
    public void decreaseCountOfSpare() {
        this.mCountOfSpare--;
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonFromGroupDBManagerService
    public int getCountOfSpare() {
        return this.mCountOfSpare;
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonFromGroupDBManagerService
    public void setCountOfSpare(int i3) {
        this.mCountOfSpare = i3;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
    }
}
