package com.tencent.hydevteam.pluginframework.pluginmanager;

import com.tencent.hydevteam.common.annotation.API;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;

/* compiled from: P */
@API
/* loaded from: classes7.dex */
public interface VersionChecker {

    @API
    public static final String SOURCE_BACKUP_LATEST = "SOURCE_BACKUP_LATEST";

    @API
    public static final String SOURCE_BACKUP_STABLE = "SOURCE_BACKUP_STABLE";

    @API
    public static final String SOURCE_CGI = "SOURCE_CGI";

    @API
    TargetDownloadInfo check(String str, String str2, String str3, boolean z16) throws VersionCheckException;

    @API
    TargetDownloadInfo checkForceUpdate(String str, String str2, String str3, boolean z16, InstalledPlugin installedPlugin) throws VersionCheckException;
}
