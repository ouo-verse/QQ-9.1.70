package com.tencent.mobileqq.vas.updatesystem.business;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.vas.VasNtToggle;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.util.AbiUtil;
import com.tencent.vas.update.entity.BusinessItemInfo;
import java.io.File;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ZipDownloadBusiness extends QQVasUpdateBusiness {
    public static final String BUSINESS_DIR = "zip_download";
    public static final int ID_DRESS_SHOW_PAG_FILE = 12;
    public static final int ID_FZ_FONT_SO;
    public static final int ID_GLDRAWABLE = 15;
    public static final int ID_HY_FONT_SO;
    public static final int ID_KINGCARD = 16;
    public static final boolean IS_CPU_64_BIT;
    public static final boolean IsUseNewFZSo;
    public static final boolean USE_ASYNC_FZ_SO;
    private static final String V2_LIB_NAME;

    static {
        int i3;
        int i16;
        boolean isEnable = VasNtToggle.VAS_FONT_SO_NEW_SWITCH.isEnable(false);
        IsUseNewFZSo = isEnable;
        boolean isEnable2 = ar.b("anzaihuang", "2024-03-24", "vas_font_engine_so_switch_config").isEnable(false);
        USE_ASYNC_FZ_SO = isEnable2;
        boolean isArm64Runtime = AbiUtil.isArm64Runtime(MobileQQ.sMobileQQ);
        IS_CPU_64_BIT = isArm64Runtime;
        if (isArm64Runtime) {
            i3 = 4;
        } else {
            i3 = 5;
        }
        ID_HY_FONT_SO = i3;
        if (isEnable2) {
            if (isArm64Runtime) {
                i16 = 14;
            } else {
                i16 = 13;
            }
        } else if (isEnable) {
            if (isArm64Runtime) {
                i16 = 11;
            } else {
                i16 = 10;
            }
        } else if (isArm64Runtime) {
            i16 = 6;
        } else {
            i16 = 7;
        }
        ID_FZ_FONT_SO = i16;
        V2_LIB_NAME = VasNtToggle.INSTANCE.getKING_CARD_JAR_NAME().getStringData("kcsdk_6.8.2.jar");
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public long getBid() {
        return 319L;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    protected String getBusinessDir() {
        return BUSINESS_DIR;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness, com.tencent.vas.update.callback.listener.IBusinessCallback
    public BusinessItemInfo getBusinessItemInfo(long j3, String str) {
        BusinessItemInfo businessItemInfo = super.getBusinessItemInfo(j3, str);
        if (getScid(15).equals(str)) {
            businessItemInfo.mSaveInDir = false;
        }
        return businessItemInfo;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public QQVasUpdateBusiness.CustomBusinessItemInfo getCustomItemInfo(long j3, String str) {
        QQVasUpdateBusiness.CustomBusinessItemInfo customBusinessItemInfo = new QQVasUpdateBusiness.CustomBusinessItemInfo();
        if (getScid(15).equals(str)) {
            customBusinessItemInfo.mSaveInDir = false;
        }
        return customBusinessItemInfo;
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public String getFrom() {
        return "ZipDownloadBusiness";
    }

    @NonNull
    public File getGLDrawablePath() {
        return new File(getSavePath(15));
    }

    @NonNull
    public File getKingCardJarPath() {
        return new File(getSavePath(16), V2_LIB_NAME);
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public String getScid(int i3) {
        return "additionalpatch." + i3 + ".android.zip";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isEnableCheckFile() {
        return true;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isEnableFileClean() {
        return true;
    }
}
