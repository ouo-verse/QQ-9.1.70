package com.qq.e.tg.download.data;

import java.io.File;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface ITGDownloaderTaskInfo {
    String getAppName();

    String getAppTaskId();

    JSONObject getExtInfo();

    File getFilePath();

    String getIconsUrl();

    String getPkgName();

    String getTargetUrl();
}
