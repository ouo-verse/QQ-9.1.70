package com.tencent.superplayer.utils;

import android.app.ActivityManager;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.tvkplayer.api.TVKSDKMgr;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.thumbplayer.core.datatransport.api.TPDataTransportMgr;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes26.dex */
public class CommonUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final String f373986a = "CommonUtil";

    /* renamed from: b, reason: collision with root package name */
    private static AtomicInteger f373987b = new AtomicInteger(1000);

    public static String a(SuperPlayerVideoInfo superPlayerVideoInfo) {
        if (!TextUtils.isEmpty(superPlayerVideoInfo.getFileId())) {
            return superPlayerVideoInfo.getFileId();
        }
        if (!TextUtils.isEmpty(superPlayerVideoInfo.getVid()) && superPlayerVideoInfo.getTVideoNetInfo() != null && superPlayerVideoInfo.getTVideoNetInfo().getCurrentDefinition() != null) {
            return superPlayerVideoInfo.getVid() + superPlayerVideoInfo.getTVideoNetInfo().getCurrentDefinition().getDefn();
        }
        if (!TextUtils.isEmpty(superPlayerVideoInfo.getPlayUrl())) {
            return b(superPlayerVideoInfo.getPlayUrl());
        }
        return null;
    }

    public static String b(String str) {
        NoSuchAlgorithmException e16;
        String str2;
        if (str == null || "".equals(str)) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(str.getBytes());
            str2 = new BigInteger(1, messageDigest.digest()).toString(16);
            while (str2.length() < 32) {
                try {
                    str2 = "0" + str2;
                } catch (NoSuchAlgorithmException e17) {
                    e16 = e17;
                    LogUtil.e(f373986a, "calculateMD5ForInput error", e16);
                    return str2;
                }
            }
            return str2.toUpperCase();
        } catch (NoSuchAlgorithmException e18) {
            e16 = e18;
            str2 = null;
        }
    }

    public static String c(Set<String> set) {
        if (set == null) {
            return null;
        }
        HashSet hashSet = new HashSet(set);
        if (hashSet.size() == 0) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            sb5.append((String) it.next());
            sb5.append(",");
        }
        return sb5.toString().substring(0, r2.length() - 1);
    }

    public static ArrayList<Map<String, String>> d(SuperPlayerVideoInfo superPlayerVideoInfo, Map<String, String> map) {
        int i3;
        int i16;
        if (superPlayerVideoInfo.getPlayUrls() == null) {
            return null;
        }
        ArrayList<Map<String, String>> arrayList = new ArrayList<>();
        if (superPlayerVideoInfo.getCookie() != null) {
            i3 = superPlayerVideoInfo.getCookie().size();
        } else {
            i3 = 0;
        }
        if (superPlayerVideoInfo.getUrlHostList() != null) {
            i16 = superPlayerVideoInfo.getUrlHostList().size();
        } else {
            i16 = 0;
        }
        for (int i17 = 0; i17 < superPlayerVideoInfo.getPlayUrls().length; i17++) {
            HashMap hashMap = new HashMap();
            if (map != null) {
                hashMap.putAll(map);
            }
            if (i17 < i3) {
                hashMap.put("Cookie", superPlayerVideoInfo.getCookie().get(i17));
            }
            if (i17 < i16) {
                hashMap.put("Host", superPlayerVideoInfo.getUrlHostList().get(i17));
            }
            arrayList.add(hashMap);
        }
        return arrayList;
    }

    public static Map<String, String> e(SuperPlayerVideoInfo superPlayerVideoInfo) {
        HashMap hashMap = new HashMap();
        if (superPlayerVideoInfo.getUrlHostList() != null && superPlayerVideoInfo.getUrlHostList().size() > 0) {
            hashMap.put("Host", superPlayerVideoInfo.getUrlHostList().get(0));
        }
        if (superPlayerVideoInfo.getCookie() != null && superPlayerVideoInfo.getCookie().size() > 0) {
            hashMap.put("Cookie", superPlayerVideoInfo.getCookie().get(0));
        }
        return hashMap;
    }

    public static String f() {
        return String.valueOf(f373987b.getAndAdd(1));
    }

    public static String g() {
        if (SuperPlayerSDKMgr.getContext() == null) {
            return "unknown";
        }
        int myPid = Process.myPid();
        String str = "";
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : SystemMethodProxy.getRunningAppProcesses((ActivityManager) SuperPlayerSDKMgr.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) {
            if (runningAppProcessInfo.pid == myPid) {
                str = runningAppProcessInfo.processName;
            }
        }
        return str;
    }

    public static String h(int i3) {
        return SuperPlayerSDKMgr.getDataCacheFolder() + File.separator + i3;
    }

    public static int i(int i3) {
        if (SuperPlayerSDKMgr.getPlatform() <= 0) {
            return 0;
        }
        String valueOf = String.valueOf(SuperPlayerSDKMgr.getPlatform());
        if (i3 >= 0) {
            valueOf = valueOf + String.valueOf(i3);
        }
        return Integer.valueOf(valueOf).intValue();
    }

    public static boolean j(int i3) {
        if (TextUtils.isEmpty(SuperPlayerSDKMgr.getDataCacheFolder())) {
            return false;
        }
        String h16 = h(i3);
        try {
            File file = new File(h16);
            if (!file.exists()) {
                file.mkdirs();
                LogUtil.d(f373986a, "\u4e1a\u52a1\u7f13\u5b58\u76ee\u5f55\u521b\u5efa\u6210\u529f\uff0cpath = " + h16);
            } else {
                LogUtil.d(f373986a, "\u4e1a\u52a1\u7f13\u5b58\u76ee\u5f55\u5df2\u5b58\u5728\uff0cpath = " + h16);
            }
            o(SuperPlayerSDKMgr.getDataCacheFolder());
            if (!TPDataTransportMgr.isNativeInit()) {
                ThreadUtil.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.superplayer.utils.CommonUtil.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TPDataTransportMgr.init(SuperPlayerSDKMgr.getContext());
                        LogUtil.d(CommonUtil.f373986a, "TPDataTransportMgr not init try init again");
                    }
                });
            }
            TPDataTransportMgr.registerBizId(i3, h16);
            return true;
        } catch (Exception e16) {
            LogUtil.d(f373986a, "\u4e1a\u52a1\u7f13\u5b58\u76ee\u5f55\u521b\u5efa\u5931\u8d25\uff0cpath = " + h16 + ", error = " + e16.getMessage());
            return false;
        }
    }

    public static boolean k(SuperPlayerVideoInfo superPlayerVideoInfo, SuperPlayerOption superPlayerOption) {
        Boolean bool;
        if (superPlayerOption != null && (bool = superPlayerOption.enableDownloadProxy) != null) {
            return bool.booleanValue();
        }
        if ((superPlayerVideoInfo.getVideoSource() == 2 && superPlayerVideoInfo.getFormat() == 201) || superPlayerVideoInfo.getFormat() == 103 || superPlayerVideoInfo.getFormat() == 202 || superPlayerVideoInfo.getFormat() == 204) {
            return false;
        }
        return true;
    }

    public static boolean l(int i3) {
        if (i3 != 401 && i3 != 402 && i3 != 403 && i3 != 201 && i3 != 202 && i3 != 203) {
            return false;
        }
        return true;
    }

    public static boolean m() {
        try {
            return SuperPlayerSDKMgr.getContext().getPackageName().equals(g());
        } catch (Throwable th5) {
            LogUtil.e(f373986a, "isMainProcess happen error.", th5);
            return false;
        }
    }

    public static boolean n() {
        try {
            int i3 = TVKSDKMgr.ERROR_OTHERS;
            LogUtil.d(f373986a, "isPackageTVKPlayer = true");
            return true;
        } catch (Exception e16) {
            LogUtil.d(f373986a, "isPackageTVKPlayer = false, e = " + e16.getMessage());
            return false;
        }
    }

    private static void o(String str) {
        File file = new File(str, ".nomedia");
        if (!file.exists()) {
            try {
                boolean createNewFile = file.createNewFile();
                LogUtil.d(f373986a, ".nomedia file create result:" + createNewFile);
                return;
            } catch (IOException unused) {
                LogUtil.w(f373986a, ".nomedia file create failed.");
                return;
            }
        }
        LogUtil.d(f373986a, ".nomedia file exists");
    }

    public static int p(String str, int i3) {
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return i3;
        }
    }

    public static void q(SuperPlayerVideoInfo superPlayerVideoInfo, int i3, HashMap<String, String> hashMap) {
        hashMap.put("task_file_type", String.valueOf(i3));
        hashMap.put("dl_param_save_path", superPlayerVideoInfo.getLocalSavePath());
        hashMap.put("dl_param_file_duration", String.valueOf(superPlayerVideoInfo.getVideoDurationMs()));
        hashMap.put("dl_param_play_keyid", superPlayerVideoInfo.getFileId());
    }
}
