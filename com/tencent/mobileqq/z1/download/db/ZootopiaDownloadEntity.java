package com.tencent.mobileqq.z1.download.db;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

/* compiled from: P */
/* loaded from: classes21.dex */
public class ZootopiaDownloadEntity extends Entity {
    public byte[] diffPatchInfoBytes;
    public byte[] loadingBackgroundMaterialBytes;

    @unique
    public String zootopiaId = "";
    public int type = 0;
    public String buttonText = "";
    public String typeIcon = "";
    public String typeName = "";
    public String title = "";
    public String cover = "";
    public String url = "";
    public String version = "";
    public String filePath = "";
    public int downloadStatus = 0;
    public long completeTime = 0;
    public long startTime = 0;
    public long size = 0;
    public String md5 = "";
    public float progress = 0.0f;
    public String projectName = "";
    public String icon = "";
    public int sceneType = 0;
    public String scriptType = "";
    public String runScript = "";
    public boolean showGameHealthyLoading = false;
    public boolean isAutoDownload = false;
    public boolean isUpdate = false;
    public boolean isSilentDownload = false;
    public boolean isPlayTogether = false;
    public boolean needNotification = false;
    public boolean isUseNewLoading = false;
    public String pakMd5 = "";
    public int packType = 0;
    public boolean isDiffUpdate = false;
}
