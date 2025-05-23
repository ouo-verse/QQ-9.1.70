package com.tencent.mobileqq.vas.updatesystem.business;

import androidx.annotation.Keep;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes20.dex */
public class TroopNickNameBusiness extends QQVasUpdateBusiness {
    public static final String SCID_CONFIG = "newgroupnick.android.";

    /* compiled from: P */
    @Keep
    /* loaded from: classes20.dex */
    public static class Config {
        public int fontId;
        public int fontType;
        public int delay = 50;
        public int repeatCount = 1;
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public long getBid() {
        return 50L;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    protected String getBusinessDir() {
        return "troopnick";
    }

    public Config getConfig(int i3) {
        File file = new File(getSavePath(i3), "config.json");
        if (file.exists()) {
            try {
                return (Config) com.tencent.mobileqq.jsonconverter.a.e(FileUtils.readFileToString(file), Config.class);
            } catch (IOException e16) {
                e16.printStackTrace();
                return null;
            }
        }
        startDownload(getScid(i3));
        return null;
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public String getFrom() {
        return "newgroupnick";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    protected String getScidPrefix() {
        return SCID_CONFIG;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isEnableCheckFile() {
        return true;
    }
}
