package com.tencent.aelight.camera.struct.camera.material;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.aelight.camera.api.IAEMaterialManager;
import com.tencent.aelight.camera.api.IAEPath;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import common.config.service.QzoneConfig;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import ms.a;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AEMaterialMetaData implements Serializable {
    public static final int DISPLAY_TYPE_AR = 2;
    public static final int DISPLAY_TYPE_AUDIO = 1;
    public static final int DISPLAY_TYPE_CHANGE_VOICE = 4;
    public static final int DISPLAY_TYPE_DEFAULT = 0;
    public static final int DISPLAY_TYPE_WM = 3;
    public static final int FILTER = 0;
    public static final String MATERIAL_ID_NONE = "0";
    public static final AEMaterialMetaData MATERIAL_NONE = a();
    public static final int PLAY_SHOW_TYPE_FUNNY_FACE = 7;
    public static final int PLAY_SHOW_TYPE_FUNNY_PIC = 5;
    public static final int PLAY_SHOW_TYPE_FUNNY_PIC_TEXT = 4;
    public static final int PLAY_SHOW_TYPE_FUNNY_TEXT = 6;
    public static final int PLAY_SHOW_TYPE_MINI_APP = 3;
    public static final int PLAY_SHOW_TYPE_ORDINARY = 0;
    public static final int PLAY_SHOW_TYPE_WEB = 2;
    public static final int WS_FILTER = 12;
    public static final String ZPLAN_MATERIAL_RENDER_TYPE_FILAMENT = "1";
    public static final String ZPLAN_SUBFIX = "_zplan";
    public String activityHidden;
    public String activityUIStyleString;
    public String arkInfoJson;
    public String cakeId;
    public String cameraScheme;
    public String cameraTitle;
    public int categoryId;
    public String cosmeticName;
    public int cosmeticSlidingValue;
    public int downloadProgress;
    public boolean downloading;
    public boolean editablewatermark;
    public String firstcategoryname;
    public Integer frameIndex;
    public String iconurl;

    /* renamed from: id, reason: collision with root package name */
    public String f69050id;
    public ArrayList<String> mask;
    public String md5;
    public String miniAppId;
    public String minimumDeviceLevel;
    public String name;
    public String orderFemale;
    public String playShowCoverImg;
    public String playShowDisplayText;
    public int position;
    public String recommendReason;
    public boolean requireBS;
    public String resurl;
    public String shieldDevices;
    public int showCircleTakeSame;
    public String showEntry;
    public String showName;
    public boolean showStatus;
    public long startDownloadTime;
    public String sysRaceId;
    public String sysRaceLevel;
    public String tabId;
    public String takeSameName;
    public long totalLen;
    public boolean usable;
    public String webUrl;
    public boolean ischoose = false;
    public boolean isdoubleclick = false;
    public boolean isDowngrade = false;
    public int kind = 0;
    public int displayType = 0;
    public String topic = "";
    public String content = "";
    public String friendContent = "";
    public String score = null;
    public int playShowType = 0;
    public Integer activityType = null;
    public Integer yuhengRuleId = null;
    public Integer yuhengActivityId = null;
    public Integer yuhengTaskId = null;
    public Boolean aigcMaterial = Boolean.FALSE;
    public String isZplanMaterial = null;
    public String zplanRenderType = null;
    public boolean preDownload = false;
    public boolean isMounted = false;
    public String tagCN = "";
    public String tagEN = "";
    public Integer moodType = 0;
    public boolean isFromZPlan = false;
    public boolean isSupportChangeSuit = false;
    public boolean isFromRecoveryMaterial = false;
    public String challengeTopic = "";
    public float challengeRotation = 0.0f;
    public float challengeScale = 1.0f;
    public float challengePositionX = 0.1f;
    public float challengePositionY = 0.16f;
    public long challengeJoinsNums = 0;
    public String guidePic = "";

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface PlayShowType {
    }

    private static AEMaterialMetaData a() {
        AEMaterialMetaData aEMaterialMetaData = new AEMaterialMetaData();
        aEMaterialMetaData.f69050id = "0";
        aEMaterialMetaData.categoryId = 0;
        aEMaterialMetaData.name = "";
        aEMaterialMetaData.iconurl = "";
        return aEMaterialMetaData;
    }

    public static boolean isRealMaterial(@Nullable AEMaterialMetaData aEMaterialMetaData) {
        int i3;
        if (aEMaterialMetaData != null && ((i3 = aEMaterialMetaData.playShowType) == 0 || i3 == 4 || i3 == 5 || i3 == 6 || i3 == 7)) {
            return true;
        }
        return false;
    }

    public void deleteAllOldFile() {
        deleteOldZipFile();
        File file = new File(getIdCatFolder());
        if (file.exists()) {
            FileUtils.deleteDirectory(file.getPath());
        }
    }

    public void deleteOldZipFile() {
        File file = new File(getZipDownloadPath());
        if (file.exists()) {
            FileUtils.deleteDirectory(file.getPath());
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null || !(obj instanceof AEMaterialMetaData)) {
            return false;
        }
        String str = ((AEMaterialMetaData) obj).f69050id;
        if (str == null && this.f69050id == null) {
            return true;
        }
        if (str == null && this.f69050id != null) {
            return false;
        }
        if (str != null && this.f69050id == null) {
            return false;
        }
        return str.equals(this.f69050id);
    }

    public int getDisplayIconByType() {
        int i3 = this.displayType;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return -1;
                    }
                    return R.drawable.mjs;
                }
                return R.drawable.mjt;
            }
            return R.drawable.mjr;
        }
        return R.drawable.mjq;
    }

    public String getIdCatFolder() {
        File file = new File(((IAEPath) QRoute.api(IAEPath.class)).getCameraPathMaterialFinalUsable());
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file.getPath(), this.f69050id);
        if (!file2.exists()) {
            file2.mkdir();
        }
        return file2.getPath() + File.separator;
    }

    public String getLocalPath() {
        return getLocalPathWithoutSeparator() + File.separator;
    }

    public String getLocalPathWithoutSeparator() {
        File file = new File(((IAEPath) QRoute.api(IAEPath.class)).getCameraPathMaterialFinalUsable());
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = this.md5;
        if (TextUtils.isEmpty(str)) {
            str = this.name;
            a.f("AEMaterialMetaData", "getLocalZipPath  md5 is null md5 = name, name = " + this.name);
        }
        if (TextUtils.isEmpty(str)) {
            str = this.f69050id;
            a.f("AEMaterialMetaData", "getLocalZipPath  name is null md5 = id, id = " + this.f69050id);
        }
        StringBuilder sb5 = new StringBuilder(this.f69050id);
        if (this.isFromZPlan) {
            sb5.append(ZPLAN_SUBFIX);
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append(new File(file.getPath(), sb5.toString()).getPath());
        String str2 = File.separator;
        sb6.append(str2);
        sb6.append(str);
        sb6.append(str2);
        sb6.append(this.f69050id);
        return sb6.toString();
    }

    public String getLocalUnzipFolder() {
        File file = new File(((IAEPath) QRoute.api(IAEPath.class)).getCameraPathMaterialFinalUsable());
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuilder sb5 = new StringBuilder(this.f69050id);
        if (this.isFromZPlan) {
            sb5.append(ZPLAN_SUBFIX);
        }
        File file2 = new File(file.getPath(), sb5.toString());
        if (!file2.exists()) {
            file2.mkdir();
        }
        String str = this.md5;
        if (TextUtils.isEmpty(str)) {
            str = this.name;
            a.f("AEMaterialMetaData", "getLocalZipPath  md5 is null md5 = name, name = " + this.name);
        }
        if (TextUtils.isEmpty(str)) {
            a.f("AEMaterialMetaData", "getLocalZipPath  name is null md5 = id, id = " + this.f69050id);
            str = this.f69050id;
        }
        File file3 = new File(file2.getPath(), str);
        if (!file3.exists()) {
            file3.mkdir();
        }
        return file3.getPath() + File.separator;
    }

    public String getLocalZipPath() {
        String str = this.md5;
        if (TextUtils.isEmpty(str)) {
            str = this.name;
            a.f("AEMaterialMetaData", "getLocalZipPath  md5 is null md5 = name, name = " + this.name);
        }
        if (TextUtils.isEmpty(str)) {
            str = this.f69050id;
            a.f("AEMaterialMetaData", "getLocalZipPath  name is null md5 = id, id = " + this.f69050id);
        }
        return new File(((IAEMaterialManager) QRoute.api(IAEMaterialManager.class)).getMaterialZipFolderPath() + File.separator + this.f69050id, str).getPath();
    }

    public String getMoodLocalPath() {
        try {
            File file = new File(((IAEPath) QRoute.api(IAEPath.class)).getMoodPathFinalUsable());
            if (!file.exists()) {
                file.mkdirs();
            }
            return new File(file.getPath(), this.name).getPath() + File.separator;
        } catch (Exception e16) {
            a.c("AEMaterialMetaData", "getMoodLocalPath exception " + e16);
            return "";
        }
    }

    public String getMoodLocalUnzipFolder() {
        try {
            File file = new File(((IAEPath) QRoute.api(IAEPath.class)).getMoodPathFinalUsable());
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getPath() + File.separator;
        } catch (Exception e16) {
            a.c("AEMaterialMetaData", "getMoodLocalUnzipFolder exception " + e16);
            return "";
        }
    }

    public String getMoodPakPath() {
        try {
            File[] listFiles = new File(getMoodLocalPath()).listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (file.getPath().contains(".pak")) {
                        a.f("AEMaterialMetaData", "getMoodPakPath " + file.getPath());
                        return file.getPath();
                    }
                }
            }
            a.f("AEMaterialMetaData", "getMoodPakPath null ");
            return "";
        } catch (Exception e16) {
            a.c("AEMaterialMetaData", "getMoodPakPath exception " + e16);
            return "";
        }
    }

    public String getZipDownloadPath() {
        return ((IAEMaterialManager) QRoute.api(IAEMaterialManager.class)).getMaterialZipFolderPath() + File.separator + this.f69050id;
    }

    public int hashCode() {
        int hashCode;
        String str = this.f69050id;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return 31 + hashCode;
    }

    public boolean isNoneMaterial() {
        String str = this.f69050id;
        return str == null || str.equals("0");
    }

    public boolean isWsBanner() {
        if (this.kind == 12) {
            return true;
        }
        return false;
    }

    public boolean needDisplayType() {
        if (this.displayType != 0) {
            return true;
        }
        return false;
    }

    public void syncStateBy(AEMaterialMetaData aEMaterialMetaData) {
        if (!equals(MATERIAL_NONE)) {
            this.usable = aEMaterialMetaData.usable;
            this.downloading = aEMaterialMetaData.downloading;
            this.editablewatermark = aEMaterialMetaData.editablewatermark;
        }
    }

    public String toString() {
        return "AEMaterialMetaData{id='" + this.f69050id + "', name='" + this.name + "'}";
    }

    public boolean unZipFile() {
        String str = "AEMaterialMetaData getMaterialZipDeleteSwitch = ";
        File file = new File(getLocalZipPath());
        boolean z16 = false;
        try {
            if (!file.exists()) {
                a.c("AEMaterialMetaData", "AEMaterialMetaData getLocalZipPath = " + getLocalZipPath() + "zip\u4e0d\u5b58\u5728");
                return false;
            }
            try {
                ZipUtils.unZipFile(file, getLocalUnzipFolder());
                boolean materialZipDeleteSwitch = QzoneConfig.getMaterialZipDeleteSwitch();
                str = "AEMaterialMetaData getMaterialZipDeleteSwitch = " + materialZipDeleteSwitch;
                a.a("AEMaterialMetaData", str);
                if (materialZipDeleteSwitch) {
                    deleteOldZipFile();
                }
                z16 = true;
            } catch (IOException e16) {
                a.a("AEMaterialMetaData", "AEMaterialMetaData unZipFile exp = " + e16.getMessage());
                FileUtils.deleteDirectory(getLocalUnzipFolder());
                boolean materialZipDeleteSwitch2 = QzoneConfig.getMaterialZipDeleteSwitch();
                str = "AEMaterialMetaData getMaterialZipDeleteSwitch = " + materialZipDeleteSwitch2;
                a.a("AEMaterialMetaData", str);
                if (materialZipDeleteSwitch2) {
                    deleteOldZipFile();
                }
            }
            return z16;
        } catch (Throwable th5) {
            FileUtils.deleteDirectory(getLocalUnzipFolder());
            boolean materialZipDeleteSwitch3 = QzoneConfig.getMaterialZipDeleteSwitch();
            a.a("AEMaterialMetaData", str + materialZipDeleteSwitch3);
            if (materialZipDeleteSwitch3) {
                deleteOldZipFile();
            }
            throw th5;
        }
    }

    public static boolean isNoneMaterial(AEMaterialMetaData aEMaterialMetaData) {
        if (aEMaterialMetaData == null) {
            return false;
        }
        String str = aEMaterialMetaData.f69050id;
        return str == null || str.equals("0");
    }

    public static boolean isNoneMaterial(String str) {
        return str != null && str.equals("0");
    }
}
