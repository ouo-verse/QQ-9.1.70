package com.tencent.mobileqq.msf.core.net.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.net.patch.PatchChecker;
import com.tencent.mobileqq.msf.core.net.patch.PatchCommonUtil;
import com.tencent.mobileqq.msf.core.net.patch.RFixExtraConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes15.dex */
public class MsfHandlePatchUtils {
    static IPatchRedirector $redirector_ = null;
    private static final String FILE_COMMON = "common_mmkv_configurations";
    public static final String KEY_PATCH_CONFIG = "key_msf_config_rfix_patch_content";
    private static final String KEY_PATCH_VERSION = "key_msf_config_rfix_version_patch";
    private static final String TAG = "MsfHandlePatchUtils";

    public MsfHandlePatchUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void downloadAndVerifyPatch(RFixExtraConfig rFixExtraConfig) {
        QLog.d(TAG, 1, "downloadAndVerifyPatch is invoke");
        if (rFixExtraConfig.isEnable() && rFixExtraConfig.matchSystemVersion()) {
            String patchName = rFixExtraConfig.getPatchName();
            if (TextUtils.isEmpty(patchName)) {
                b.a(1, 2, false);
                return;
            }
            String patchPath = PatchCommonUtil.getPatchPath(patchName);
            String patchUrl = rFixExtraConfig.getPatchUrl();
            if (!TextUtils.isEmpty(patchPath) && !TextUtils.isEmpty(patchUrl)) {
                String patchPath2 = PatchCommonUtil.getPatchPath(patchUrl.substring(patchUrl.lastIndexOf(File.separator) + 1));
                if (!TextUtils.isEmpty(patchPath2)) {
                    boolean a16 = c.a(patchUrl, patchPath2);
                    QLog.d(TAG, 1, "download patch result=" + a16);
                    if (a16) {
                        b.a(1, 2, true);
                        boolean checkPatchValid = PatchChecker.checkPatchValid("dex", patchName);
                        QLog.d(TAG, 1, "verify patch result=" + checkPatchValid);
                        if (checkPatchValid) {
                            MsfPullConfigUtil.showToastForSafeModeTest("\u8865\u4e01\u4e0b\u8f7d\u5e76\u6821\u9a8c\u6210\u529f\uff0c\u4e0b\u6b21\u542f\u52a8\u4fee\u590d\u95ea\u9000");
                            new DexClassLoader(patchPath, BaseApplication.getContext().getDir("dex", 0).getAbsolutePath(), patchPath, BaseApplication.getContext().getClassLoader());
                            b.a(1, 1000, true);
                            return;
                        } else {
                            File file = new File(patchPath);
                            if (file.exists()) {
                                file.delete();
                            }
                            b.a(1, 3, false);
                            return;
                        }
                    }
                    b.a(1, 2, false);
                    return;
                }
                b.a(1, 2, false);
                return;
            }
            b.a(1, 2, false);
            return;
        }
        b.a(1, 2, false);
    }

    private static RFixExtraConfig getLatestPatchConfig(List<String> list) {
        RFixExtraConfig rFixExtraConfig = null;
        if (list == null) {
            return null;
        }
        Iterator<String> it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            RFixExtraConfig rFixExtraConfig2 = new RFixExtraConfig(it.next());
            if (rFixExtraConfig2.getConfigId() > i3) {
                i3 = rFixExtraConfig2.getConfigId();
                rFixExtraConfig = rFixExtraConfig2;
            }
        }
        return rFixExtraConfig;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getPatchConfigVersion() {
        return QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations").decodeInt(KEY_PATCH_VERSION, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void handlePatchConfig(int i3, List<String> list) {
        b.a(1, 1, true);
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
        RFixExtraConfig rFixExtraConfig = new RFixExtraConfig(from.decodeString(KEY_PATCH_CONFIG, null));
        int decodeInt = from.decodeInt(KEY_PATCH_VERSION, 0);
        QLog.d(TAG, 1, "handlePatchConfig localVersion " + decodeInt + " | version is " + i3);
        if (i3 != decodeInt) {
            RFixExtraConfig latestPatchConfig = getLatestPatchConfig(list);
            if (latestPatchConfig != null && latestPatchConfig.getConfigId() > rFixExtraConfig.getConfigId()) {
                QLog.d(TAG, 1, "handlePatchConfig: " + latestPatchConfig.getContent());
                from.encodeString(KEY_PATCH_CONFIG, latestPatchConfig.getContent());
                rFixExtraConfig = latestPatchConfig;
            }
            from.encodeInt(KEY_PATCH_VERSION, i3);
            if (rFixExtraConfig.isEnable()) {
                downloadAndVerifyPatch(rFixExtraConfig);
            } else {
                b.a(1, 1, false);
            }
        } else if (rFixExtraConfig.isEnable()) {
            String patchName = rFixExtraConfig.getPatchName();
            if (!TextUtils.isEmpty(patchName)) {
                verify(rFixExtraConfig, patchName);
            } else {
                QLog.e(TAG, 1, "patchName is empty curPatchCfg is " + rFixExtraConfig);
                b.a(1, 2, false);
            }
        } else {
            QLog.e(TAG, 1, "curPatchCfg is null");
            b.a(1, 2, false);
        }
        if (from.decodeInt(KEY_PATCH_VERSION, 0) != i3) {
            from.encodeInt(KEY_PATCH_VERSION, 0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void verify(RFixExtraConfig rFixExtraConfig, String str) {
        boolean z16;
        File file = new File(PatchCommonUtil.getPatchPath(str));
        if (file.exists()) {
            if (!PatchChecker.checkPatchValid("dex", str)) {
                file.delete();
            } else {
                z16 = false;
                if (!z16) {
                    downloadAndVerifyPatch(rFixExtraConfig);
                    return;
                } else {
                    b.a(1, 1000, true);
                    return;
                }
            }
        }
        z16 = true;
        if (!z16) {
        }
    }
}
