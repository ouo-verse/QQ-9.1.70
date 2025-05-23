package cooperation.plugin.patch;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoConfig;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;
import cooperation.plugin.patch.PatchDownloadManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.regex.PatternSyntaxException;

/* compiled from: P */
/* loaded from: classes28.dex */
public class g {
    public static boolean a(Context context, PluginInfo pluginInfo, boolean z16, Bundle bundle) {
        if (pluginInfo != null && context != null) {
            if (!Objects.equals(pluginInfo.mID, "GroupVideo.apk")) {
                QLog.i("plugin_tag", 1, "\u4e0d\u662f\u7fa4\u89c6\u9891\u63d2\u4ef6 \u4e0d\u5904\u7406patch");
                return false;
            }
            if (bundle != null && bundle.getBoolean("fullDownLoad")) {
                QLog.i("plugin_tag", 1, "\u8bf7\u6c42\u89e6\u53d1\u76f4\u63a5\u5168\u91cf\u4e0b\u8f7d");
                if (e(context, pluginInfo) == null) {
                    return false;
                }
                return true;
            }
            if (!z16) {
                QLog.i("plugin_tag", 1, "\u4e0d\u662f\u9884\u52a0\u8f7d\u89e6\u53d1 \u4e0d\u5904\u7406patch");
                return false;
            }
            if (!GroupVideoConfig.c().a()) {
                QLog.i("plugin_tag", 1, "canPrePatch false");
                return false;
            }
            if (e(context, pluginInfo) == null) {
                return false;
            }
            return true;
        }
        QLog.i("plugin_tag", 1, "canPatch false \u68c0\u67e5\u53c2\u6570");
        return false;
    }

    public static String b(Context context, String str) {
        return c(context) + File.separator + str;
    }

    public static String c(Context context) {
        return cooperation.plugin.d.i(context).getParent() + File.separator + "plugin_bak";
    }

    public static PluginInfo d(Context context, String str) {
        File[] c16;
        PluginInfo pluginInfo;
        if (context == null || TextUtils.isEmpty(str) || (c16 = cooperation.plugin.e.c(PluginUtils.getPluginInstallDir(context))) == null) {
            return null;
        }
        for (File file : c16) {
            if (file.isFile() && (pluginInfo = (PluginInfo) PluginBaseInfoHelper.createFromFile(file, PluginInfo.class)) != null && str.equals(pluginInfo.mID)) {
                return pluginInfo;
            }
        }
        return null;
    }

    public static PatchDownloadManager.PatchInfo e(Context context, PluginInfo pluginInfo) {
        String str;
        PatchDownloadManager.PatchInfo patchInfo = null;
        if (new File(b(context, pluginInfo.mID)).exists()) {
            PluginInfo d16 = d(context, pluginInfo.mID);
            List<PatchDownloadManager.PatchInfo> g16 = g(pluginInfo.mPatchDescription);
            if (!g16.isEmpty() && d16 != null && !TextUtils.isEmpty(d16.mVersion)) {
                Iterator<PatchDownloadManager.PatchInfo> it = g16.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PatchDownloadManager.PatchInfo next = it.next();
                    if (f(d16.mVersion, next.version)) {
                        patchInfo = next;
                        break;
                    }
                }
            }
            if (patchInfo == null) {
                Object[] objArr = new Object[3];
                objArr[0] = pluginInfo.mID;
                if (d16 != null) {
                    str = d16.mVersion;
                } else {
                    str = "not installed";
                }
                objArr[1] = str;
                objArr[2] = pluginInfo.mPatchDescription;
                QLog.i("plugin_tag", 1, String.format("plugin current version don't has matched patch file. [pluginId]=%s, [mVersion]=%s. [patchDescription]=%s", objArr));
            } else {
                QLog.i("plugin_tag", 1, String.format("plugin:%s get matched patch file. patchInfo=%s", pluginInfo.mID, patchInfo));
            }
        } else {
            QLog.i("plugin_tag", 1, String.format("plugin backup file not exist. bak file path should be %s", b(context, pluginInfo.mID)));
        }
        return patchInfo;
    }

    private static boolean f(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            QLog.i("plugin_tag", 1, String.format("isVersionMatched: [installedVersion]=%s, [patchVersion]=%s", str, str2));
            try {
                String[] split = str.split("-");
                String[] split2 = str2.split("-");
                return split[split.length - 1].equals(split2[split2.length - 1]);
            } catch (PatternSyntaxException unused) {
            }
        }
        return false;
    }

    private static List<PatchDownloadManager.PatchInfo> g(String str) {
        if (TextUtils.isEmpty(str)) {
            return new ArrayList();
        }
        return d.a(str, PatchDownloadManager.PatchInfo.class);
    }
}
