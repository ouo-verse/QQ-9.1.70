package cooperation.plugin.patch;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.api.ITroopBeaconReporter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.raft.codegenmeta.utils.RLog;
import cooperation.plugin.PluginInfo;
import cooperation.plugin.patch.PatchDownloadManager;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J2\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0007J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0002\u00a8\u0006\u0016"}, d2 = {"Lcooperation/plugin/patch/PatchReporter;", "", "", "errorCode", "Lcooperation/plugin/patch/PatchDownloadManager$PatchInfo;", "patchInfo", "downloadDuration", "patchDuration", "", "curVersion", "", "b", "", "patchStatus", "Lcooperation/plugin/PluginInfo;", "pluginInfo", "a", "installDuration", "c", "<init>", "()V", RLog.ERROR, "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes28.dex */
public final class PatchReporter {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final PatchReporter f390339a = new PatchReporter();

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcooperation/plugin/patch/PatchReporter$ERROR;", "", "(Ljava/lang/String;I)V", "PATCH_SUCCEED", "PATCH_FAILED", "PATCH_FILE_VERIFY_FAILED", "PATCH_MD5_MISMATCH", "PATCH_DOWNLOAD_FAILED", "PATCH_MISMATCH", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public enum ERROR {
        PATCH_SUCCEED,
        PATCH_FAILED,
        PATCH_FILE_VERIFY_FAILED,
        PATCH_MD5_MISMATCH,
        PATCH_DOWNLOAD_FAILED,
        PATCH_MISMATCH
    }

    PatchReporter() {
    }

    @JvmStatic
    public static final void b(long errorCode, @Nullable PatchDownloadManager.PatchInfo patchInfo, long downloadDuration, long patchDuration, @NotNull String curVersion) {
        String str;
        Intrinsics.checkNotNullParameter(curVersion, "curVersion");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("patch_error_code", Long.valueOf(errorCode));
        if (patchInfo != null) {
            String str2 = patchInfo.length;
            Intrinsics.checkNotNullExpressionValue(str2, "patchInfo.length");
            linkedHashMap.put("patch_length", str2);
            String str3 = patchInfo.url;
            Intrinsics.checkNotNullExpressionValue(str3, "patchInfo.url");
            linkedHashMap.put("patch_url", str3);
        }
        linkedHashMap.put("patch_download_duration", Long.valueOf(downloadDuration));
        linkedHashMap.put("patch_duration", Long.valueOf(patchDuration));
        linkedHashMap.put("installed_plugin_version", curVersion);
        ((ITroopBeaconReporter) QRoute.api(ITroopBeaconReporter.class)).report("group_video_patch", linkedHashMap);
        if (patchInfo != null) {
            str = patchInfo.toString();
        } else {
            str = null;
        }
        QLog.i("plugin_tag", 1, "patch report: [errorCode]=" + errorCode + ", [downloadDuration]=" + downloadDuration + ", [patchDuration]=" + patchDuration + ", [installedVersion]=" + curVersion + ", [patchInfo]=" + str);
    }

    public final void a(int patchStatus, @Nullable PluginInfo pluginInfo) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("patch_check_status", Integer.valueOf(patchStatus));
        if (pluginInfo != null) {
            String str = pluginInfo.mVersion;
            Intrinsics.checkNotNullExpressionValue(str, "pluginInfo.mVersion");
            linkedHashMap.put("installed_plugin_version", str);
        }
        ((ITroopBeaconReporter) QRoute.api(ITroopBeaconReporter.class)).report("group_video_patch", linkedHashMap);
    }

    public final void c(long installDuration) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("patch_check_status", 5);
        linkedHashMap.put("pre_install_cost", Long.valueOf(installDuration));
        ((ITroopBeaconReporter) QRoute.api(ITroopBeaconReporter.class)).report("group_video_patch", linkedHashMap);
    }
}
