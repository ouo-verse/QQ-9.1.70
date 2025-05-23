package com.tencent.tmassistantsdk.internal.openSDK;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.assistant.sdk.remote.SDKConst;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.r;
import com.tencent.tmassistantsdk.ITMAssistantCallBackListener;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYBTaskInfo;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class TMAssistantBaseCallYYB {
    protected static final String TAG = "TMAssistantBaseCallYYB";
    protected String mClientKey;
    protected int sdkAPILevel = 1;
    protected Context mContext = null;
    public String hostPackageName = null;
    protected int hostVersionCode = 0;
    protected com.tencent.tmassistantsdk.a.a.b sdkChannel = new com.tencent.tmassistantsdk.a.a.b();
    protected ReferenceQueue<ITMAssistantCallBackListener> mListenerQueue = new ReferenceQueue<>();
    protected List<WeakReference<ITMAssistantCallBackListener>> mWeakListenerArrayList = new CopyOnWriteArrayList();

    public static int getQQDownloadApiLevel(Context context) {
        Bundle bundle;
        if (context == null) {
            r.a(TAG, "context is null,return 0");
            return 0;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(SDKConst.SELF_PACKAGENAME, 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return 0;
            }
            return bundle.getInt(SDKConst.SDK_APILEVEL);
        } catch (Exception unused) {
            r.b(TAG, "packagename not found\uff01");
            return 0;
        }
    }

    public static boolean isExistActoin(long j3) {
        ArrayList<com.tencent.tmassistantsdk.a.a.c> a16;
        if (j3 >= 0 && (a16 = new com.tencent.tmassistantsdk.a.a.b().a()) != null && a16.size() > 0) {
            Iterator<com.tencent.tmassistantsdk.a.a.c> it = a16.iterator();
            while (it.hasNext()) {
                com.tencent.tmassistantsdk.a.a.c next = it.next();
                if (next.f380542a == j3 && next.f380547f - next.f380546e <= MiniBoxNoticeInfo.MIN_5) {
                    return true;
                }
            }
        }
        return false;
    }

    public abstract long addDownloadTaskFromAppDetail(TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, boolean z16, boolean z17);

    public abstract long addDownloadTaskFromAuthorize(TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, String str);

    public abstract long addDownloadTaskFromTaskList(TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, boolean z16, boolean z17);

    public long addDownloadTaskFromTmast(Bundle bundle) {
        long j3;
        long j16;
        String string = bundle.getString("url");
        if (TextUtils.isEmpty(string)) {
            return -1L;
        }
        String formatEncryptUrl = formatEncryptUrl(string);
        long currentTimeMillis = System.currentTimeMillis();
        long j17 = MiniBoxNoticeInfo.MIN_5 + currentTimeMillis;
        long j18 = bundle.getLong("startTime");
        long j19 = bundle.getLong("endTime");
        if (j18 != 0 && j19 != 0) {
            j16 = j19;
            j3 = j18;
        } else {
            j3 = currentTimeMillis;
            j16 = j17;
        }
        return this.sdkChannel.a(this.hostPackageName, this.hostVersionCode, "", 0, formatEncryptUrl, j3, j16, 0, null);
    }

    public long addDownloadTaskFromWebview(Bundle bundle) {
        long j3;
        long j16;
        String string = bundle.getString("url");
        HashMap hashMap = new HashMap();
        hashMap.put("url", string);
        String formatIntentUriPath = formatIntentUriPath(5, hashMap);
        long currentTimeMillis = System.currentTimeMillis();
        long j17 = MiniBoxNoticeInfo.MIN_5 + currentTimeMillis;
        long j18 = bundle.getLong("startTime");
        long j19 = bundle.getLong("endTime");
        if (j18 != 0 && j19 != 0) {
            j3 = j18;
            j16 = j19;
        } else {
            j3 = currentTimeMillis;
            j16 = j17;
        }
        return this.sdkChannel.a(this.hostPackageName, this.hostVersionCode, "", 0, formatIntentUriPath, j3, j16, 0, null);
    }

    public long buildAddDBData(TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, boolean z16, boolean z17, String str, String str2, int i3, String str3) {
        Map<String, String> formatMapParams;
        if (TextUtils.isEmpty(str2)) {
            formatMapParams = formatMapParams(tMAssistantCallYYBParamStruct, z16, z17, str3);
        } else {
            formatMapParams = formatMapParams(tMAssistantCallYYBParamStruct, true, true, str3);
            formatMapParams.put("verifytype", str2);
        }
        String formatIntentUriPath = formatIntentUriPath(i3, formatMapParams);
        long currentTimeMillis = System.currentTimeMillis();
        return this.sdkChannel.a(this.hostPackageName, this.hostVersionCode, "", 0, formatIntentUriPath, currentTimeMillis, currentTimeMillis + MiniBoxNoticeInfo.MIN_5, 0, null);
    }

    public int checkQQDownloaderInstalled() {
        Context context = this.mContext;
        if (context != null) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return 1;
            }
            try {
                if (InstalledAppListMonitor.getPackageInfo(packageManager, SDKConst.SELF_PACKAGENAME, 0) != null) {
                    return this.sdkAPILevel > GlobalUtil.getInstance().getQQDownloaderAPILevel() ? 2 : 0;
                }
                return 1;
            } catch (PackageManager.NameNotFoundException unused) {
                r.b(TAG, "packagename not found\uff01");
                return 1;
            }
        }
        r.a(TAG, "mContext is null");
        throw new Exception("you must initial openSDK,by calling initQQDownloaderOpenSDK method!");
    }

    public abstract void destroyQQDownloaderOpenSDK();

    /* JADX INFO: Access modifiers changed from: protected */
    public String formatEncryptUrl(String str) {
        return "tmast://encrypt?encryptdata=" + URLEncoder.encode(b.a(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String formatIntentUriPath(int i3, Map<String, String> map) {
        return formatIntentUriPath(i3, map, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Map<String, String> formatMapParams(TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, boolean z16, boolean z17, String str) {
        String formatOplist = formatOplist(z16, z17);
        HashMap hashMap = new HashMap();
        hashMap.put("hostpname", this.hostPackageName);
        hashMap.put("hostversioncode", String.valueOf(this.hostVersionCode));
        hashMap.put("sngappid", tMAssistantCallYYBParamStruct.SNGAppId);
        hashMap.put("appid", tMAssistantCallYYBParamStruct.taskAppId);
        hashMap.put("apkid", tMAssistantCallYYBParamStruct.taskApkId);
        hashMap.put("pname", tMAssistantCallYYBParamStruct.taskPackageName);
        hashMap.put("via", tMAssistantCallYYBParamStruct.via);
        hashMap.put("uin", tMAssistantCallYYBParamStruct.uin);
        hashMap.put("uintype", tMAssistantCallYYBParamStruct.uinType);
        hashMap.put("versioncode", String.valueOf(tMAssistantCallYYBParamStruct.taskVersion));
        hashMap.put("oplist", formatOplist);
        hashMap.put("channelid", tMAssistantCallYYBParamStruct.channelId);
        hashMap.put("actionflag", tMAssistantCallYYBParamStruct.actionFlag);
        hashMap.put("traceid", str);
        hashMap.put("recommendId", tMAssistantCallYYBParamStruct.recommendId);
        JSONObject jSONObject = new JSONObject();
        for (String str2 : tMAssistantCallYYBParamStruct.timePointMap.keySet()) {
            try {
                jSONObject.put(str2, tMAssistantCallYYBParamStruct.timePointMap.get(str2));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        hashMap.put("timePoints", jSONObject.toString());
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String formatOplist(boolean z16, boolean z17) {
        if (z16 && z17) {
            return "1;2";
        }
        if (z17) {
            return "2";
        }
        if (z16) {
            return "1";
        }
        return "";
    }

    public abstract TMAssistantCallYYBTaskInfo getDownloadTaskState(TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct);

    public abstract void initTMAssistantCallYYBApi(Context context);

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStateChanged(TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, int i3, int i16, String str) {
        Iterator<WeakReference<ITMAssistantCallBackListener>> it = this.mWeakListenerArrayList.iterator();
        while (it.hasNext()) {
            ITMAssistantCallBackListener iTMAssistantCallBackListener = it.next().get();
            if (iTMAssistantCallBackListener != null) {
                iTMAssistantCallBackListener.onDownloadTaskStateChanged(tMAssistantCallYYBParamStruct, i3, i16, str);
            }
        }
    }

    public boolean registerListener(ITMAssistantCallBackListener iTMAssistantCallBackListener) {
        if (iTMAssistantCallBackListener == null) {
            r.a(TAG, "listener is null,return false");
            return false;
        }
        while (true) {
            Reference<? extends ITMAssistantCallBackListener> poll = this.mListenerQueue.poll();
            if (poll == null) {
                break;
            }
            this.mWeakListenerArrayList.remove(poll);
        }
        Iterator<WeakReference<ITMAssistantCallBackListener>> it = this.mWeakListenerArrayList.iterator();
        while (it.hasNext()) {
            if (it.next().get() == iTMAssistantCallBackListener) {
                return true;
            }
        }
        this.mWeakListenerArrayList.add(new WeakReference<>(iTMAssistantCallBackListener, this.mListenerQueue));
        return true;
    }

    public boolean removeDownloadTask(long j3) {
        if (j3 >= 0) {
            return this.sdkChannel.a(j3);
        }
        return false;
    }

    public void setQQGameClientKey(String str) {
        this.mClientKey = str;
    }

    public void startQQDownloader(Context context) {
        if (context != null) {
            Intent launchIntentForPackage = InstalledAppListMonitor.getLaunchIntentForPackage(context.getPackageManager(), SDKConst.SELF_PACKAGENAME);
            if (context instanceof Application) {
                launchIntentForPackage.addFlags(268435456);
            }
            context.startActivity(launchIntentForPackage);
        }
    }

    public abstract void startToAuthorized(Context context, TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, String str);

    public void startToDownloadTaskList(Context context) {
        if (context != null) {
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse("tmast://download?hostpname=" + this.hostPackageName + "&hostversion=" + this.hostVersionCode));
            if (context instanceof Application) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
            return;
        }
        r.a(TAG, "context is null,return 0");
        throw new Exception("you must input an application or activity context!");
    }

    public void startToDownloadTaskListWithParams(Context context, Bundle bundle) {
        if (context != null) {
            StringBuilder sb5 = new StringBuilder("tmast://download?hostpname=" + this.hostPackageName + "&hostversion=" + this.hostVersionCode);
            if (bundle != null) {
                for (String str : bundle.keySet()) {
                    sb5.append(ContainerUtils.FIELD_DELIMITER);
                    sb5.append(str);
                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb5.append(bundle.getString(str));
                }
            }
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(sb5.toString()));
            if (context instanceof Application) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
            return;
        }
        r.a(TAG, "context is null,return 0");
        throw new Exception("you must input an application or activity context!");
    }

    public abstract void startToWebView(Context context, String str);

    public boolean unregisterListener(ITMAssistantCallBackListener iTMAssistantCallBackListener) {
        if (iTMAssistantCallBackListener == null) {
            r.a(TAG, "listener is null,return false");
            return false;
        }
        Iterator<WeakReference<ITMAssistantCallBackListener>> it = this.mWeakListenerArrayList.iterator();
        while (it.hasNext()) {
            if (it.next().get() == iTMAssistantCallBackListener) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String formatIntentUriPath(int i3, Map<String, String> map, boolean z16) {
        String str = "tpmast://" + (i3 != 1 ? i3 != 4 ? i3 != 5 ? i3 != 6 ? "appdetails" : "downloadmanager" : "webview" : "updatedownload" : "download") + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
        String str2 = "";
        if (map != null && map.size() > 0) {
            int i16 = 0;
            String str3 = "";
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                    str3 = str3 + (i16 <= 0 ? "" : ContainerUtils.FIELD_DELIMITER) + key + ContainerUtils.KEY_VALUE_DELIMITER + URLEncoder.encode(value);
                }
                i16++;
            }
            str2 = str3;
        }
        String str4 = str + str2;
        return z16 ? formatEncryptUrl(str4) : str4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long buildAddDBData(byte[] bArr) {
        if (bArr == null) {
            return -1L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        return this.sdkChannel.a(null, 0, null, 0, null, currentTimeMillis, currentTimeMillis + MiniBoxNoticeInfo.MIN_5, 1, bArr);
    }

    public int checkQQDownloaderInstalled(int i3) {
        Context context = this.mContext;
        if (context != null) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return 1;
            }
            try {
                if (InstalledAppListMonitor.getPackageInfo(packageManager, SDKConst.SELF_PACKAGENAME, 0) == null) {
                    return 1;
                }
                return (this.sdkAPILevel <= GlobalUtil.getInstance().getQQDownloaderAPILevel() && i3 <= GlobalUtil.getInstance().getQQDownloaderVersionCode()) ? 0 : 2;
            } catch (PackageManager.NameNotFoundException e16) {
                e16.printStackTrace();
                return 1;
            }
        }
        r.a(TAG, "mContext is null");
        throw new Exception("you must initial openSDK,by calling initQQDownloaderOpenSDK method!");
    }
}
