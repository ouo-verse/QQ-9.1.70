package com.tencent.xweb.xwalk.plugin;

import com.tencent.luggage.wxa.ar.j0;
import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.ar.y;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes27.dex */
public class XWalkFullScreenVideoPlugin extends XWalkPlugin {
    public static final String FULLSCREEN_VIDEO_JS_FILENAME = "xweb_fullscreen_video.js";

    @Override // com.tencent.xweb.xwalk.plugin.XWalkPlugin
    public void checkFiles() {
        x0.d(getPluginName(), "checkFiles, skip");
    }

    @Override // com.tencent.xweb.xwalk.plugin.XWalkPlugin
    public String getDownloadFullPath(int i3, boolean z16) {
        String versionDir = getVersionDir(i3);
        if (versionDir != null && !versionDir.isEmpty()) {
            if (!z16) {
                return versionDir + File.separator + FULLSCREEN_VIDEO_JS_FILENAME;
            }
            return versionDir + File.separator + "patch";
        }
        return "";
    }

    @Override // com.tencent.xweb.xwalk.plugin.XWalkPlugin
    public List<String> getKeyFilesPath(int i3) {
        String versionDir = getVersionDir(i3);
        if (versionDir != null && !versionDir.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(versionDir + File.separator + FULLSCREEN_VIDEO_JS_FILENAME);
            return arrayList;
        }
        return null;
    }

    @Override // com.tencent.xweb.xwalk.plugin.XWalkPlugin
    public String getPluginName() {
        return XWalkPluginManager.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO;
    }

    @Override // com.tencent.xweb.xwalk.plugin.XWalkPlugin
    public boolean isDownloadImmediately() {
        return true;
    }

    @Override // com.tencent.xweb.xwalk.plugin.XWalkPlugin
    public boolean isIgnoreForbidDownloadCode() {
        return true;
    }

    @Override // com.tencent.xweb.xwalk.plugin.XWalkPlugin
    public int performInstall(j0 j0Var) {
        x0.d(getPluginName(), "performInstall version " + j0Var.f121684l);
        if (y.a(j0Var.f121697y, j0Var.f121676d)) {
            setAvailableVersion(j0Var.f121684l, true);
            x0.d(getPluginName(), "performInstall " + getAvailableVersion() + " success");
            return 0;
        }
        x0.c(getPluginName(), "performInstall failed, md5 not match");
        File file = new File(j0Var.f121697y);
        if (file.exists()) {
            file.delete();
        }
        n0.b(getPluginName(), false);
        return -2;
    }
}
