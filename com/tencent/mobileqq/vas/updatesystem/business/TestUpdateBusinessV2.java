package com.tencent.mobileqq.vas.updatesystem.business;

import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.vas.update.business.BaseUpdateBusiness;
import com.tencent.vas.update.entity.BusinessItemInfo;
import java.io.File;

/* compiled from: P */
/* loaded from: classes20.dex */
public class TestUpdateBusinessV2 extends BaseUpdateBusiness {
    public static final long BID = 1000000;
    private static final String RING_DIR = "test_dir";
    private static final String SCID_RING = "test";

    private String getSavePath(String str) {
        BaseApplication context = BaseApplication.getContext();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(context.getFilesDir());
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append(RING_DIR);
        sb5.append(str2);
        sb5.append(str);
        sb5.append(".zip");
        return sb5.toString();
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public long getBid() {
        return 1000000L;
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public BusinessItemInfo getBusinessItemInfo(long j3, String str) {
        BusinessItemInfo businessItemInfo = new BusinessItemInfo();
        businessItemInfo.mSaveInDir = false;
        businessItemInfo.mSavePath = getSavePath("test");
        return businessItemInfo;
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public String getFrom() {
        return "TestUpdateBusinessV2";
    }

    public void startDownload() {
        startDownload("test");
    }
}
