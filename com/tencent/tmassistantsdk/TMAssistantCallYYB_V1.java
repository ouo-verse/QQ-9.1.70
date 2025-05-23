package com.tencent.tmassistantsdk;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.assistant.sdk.remote.SDKConst;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.tmassistantbase.network.NetworkMonitorReceiver;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.r;
import com.tencent.tmassistantsdk.internal.logreport.b;
import com.tencent.tmassistantsdk.internal.logreport.e;
import com.tencent.tmassistantsdk.internal.openSDK.DownloadStateChangedReceiver;
import com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB;
import com.tencent.tmassistantsdk.internal.openSDK.a;
import com.tencent.tmassistantsdk.internal.openSDK.d;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TMAssistantCallYYB_V1 extends TMAssistantBaseCallYYB implements a {
    public static final String AUTHORITY = "com.tencent.android.qqdownloader.provider";
    public static final Uri CONTENT_URI = com.tencent.tmassistantsdk.internal.openSDK.QQDownloader.a.f380574a;
    protected static final String TAG = "TMAssistantCallYYB_V1";
    protected static TMAssistantCallYYB_V1 mInstance;
    Map<String, TMAssistantCallYYBParamStruct> mDownloadParams;
    protected int sdkAPILevel = 1;

    TMAssistantCallYYB_V1() {
        this.mDownloadParams = null;
        this.mDownloadParams = new ConcurrentHashMap();
    }

    public static synchronized TMAssistantCallYYB_V1 getInstance() {
        TMAssistantCallYYB_V1 tMAssistantCallYYB_V1;
        synchronized (TMAssistantCallYYB_V1.class) {
            if (mInstance == null) {
                mInstance = new TMAssistantCallYYB_V1();
            }
            tMAssistantCallYYB_V1 = mInstance;
        }
        return tMAssistantCallYYB_V1;
    }

    private boolean isFileExist(String str) {
        if (new File(str).exists()) {
            return true;
        }
        return false;
    }

    private void relateToQQDownloader(Context context, TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, String str) {
        Map<String, String> formatMapParams = super.formatMapParams(tMAssistantCallYYBParamStruct, false, false, str);
        formatMapParams.put("taskid", str);
        String formatIntentUriPath = super.formatIntentUriPath(4, formatMapParams);
        Intent intent = new Intent(SDKConst.SDK_RELATED_ACTION);
        intent.setPackage(SDKConst.SELF_PACKAGENAME);
        intent.putExtra("command", SDKConst.COMMAND_REALTED_UPDATE_DOWNLOAD);
        intent.putExtra(SDKConst.KEY_REALTED_URL, formatIntentUriPath);
        context.sendBroadcast(intent);
    }

    @Override // com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB
    public long addDownloadTaskFromAppDetail(TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, boolean z16, boolean z17) {
        String uuid = UUID.randomUUID().toString();
        Map<String, TMAssistantCallYYBParamStruct> map = this.mDownloadParams;
        if (map != null && tMAssistantCallYYBParamStruct != null) {
            map.put(uuid, tMAssistantCallYYBParamStruct);
            b.g().a(b.g().a(b.a(tMAssistantCallYYBParamStruct), uuid, "V1_addDownloadTaskFromAppDetail"));
        }
        return super.buildAddDBData(tMAssistantCallYYBParamStruct, z16, z17, tMAssistantCallYYBParamStruct.actionFlag, null, 2, uuid);
    }

    @Override // com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB
    public long addDownloadTaskFromAuthorize(TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, String str) {
        String uuid = UUID.randomUUID().toString();
        Map<String, TMAssistantCallYYBParamStruct> map = this.mDownloadParams;
        if (map != null && tMAssistantCallYYBParamStruct != null) {
            map.put(uuid, tMAssistantCallYYBParamStruct);
            b.g().a(b.g().a(b.a(tMAssistantCallYYBParamStruct), uuid, "V1_addDownloadTaskFromAuthorize"));
        }
        return super.buildAddDBData(tMAssistantCallYYBParamStruct, true, true, tMAssistantCallYYBParamStruct.actionFlag, str, 3, uuid);
    }

    @Override // com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB
    public long addDownloadTaskFromTaskList(TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, boolean z16, boolean z17) {
        String uuid = UUID.randomUUID().toString();
        Map<String, TMAssistantCallYYBParamStruct> map = this.mDownloadParams;
        if (map != null && tMAssistantCallYYBParamStruct != null) {
            map.put(uuid, tMAssistantCallYYBParamStruct);
            b.g().a(b.g().a(b.a(tMAssistantCallYYBParamStruct), uuid, "V1_addDownloadTaskFromTaskList"));
        }
        return super.buildAddDBData(tMAssistantCallYYBParamStruct, z16, z17, tMAssistantCallYYBParamStruct.actionFlag, null, 1, uuid);
    }

    @Override // com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB
    public void destroyQQDownloaderOpenSDK() {
        NetworkMonitorReceiver.getInstance().unregisterReceiver();
        e.c().b();
        if (this.mContext != null) {
            DownloadStateChangedReceiver.a().b(this.mContext);
            DownloadStateChangedReceiver.a().b(this);
        }
        GlobalUtil.getInstance().destroy();
        this.mContext = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0110  */
    @Override // com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TMAssistantCallYYBTaskInfo getDownloadTaskState(TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct) {
        Cursor cursor;
        TMAssistantCallYYBTaskInfo tMAssistantCallYYBTaskInfo;
        Context context = this.mContext;
        if (context != null) {
            if (tMAssistantCallYYBParamStruct != null) {
                ContentResolver contentResolver = context.getContentResolver();
                Cursor cursor2 = null;
                r2 = null;
                TMAssistantCallYYBTaskInfo tMAssistantCallYYBTaskInfo2 = null;
                try {
                    try {
                        boolean z16 = false;
                        cursor = ContactsMonitor.query(contentResolver, CONTENT_URI, null, "packageName=? and versionCode=? and channelId=?", new String[]{tMAssistantCallYYBParamStruct.taskPackageName, String.valueOf(tMAssistantCallYYBParamStruct.taskVersion), tMAssistantCallYYBParamStruct.channelId}, null);
                        if (cursor != null) {
                            try {
                                try {
                                    if (cursor.moveToFirst()) {
                                        long j3 = cursor.getLong(cursor.getColumnIndex("apkId"));
                                        String str = GlobalUtil.String2List(cursor.getString(cursor.getColumnIndex("apkUrl"))).get(0);
                                        String string = cursor.getString(cursor.getColumnIndex("filePath"));
                                        long j16 = cursor.getLong(cursor.getColumnIndex("received_length"));
                                        long j17 = cursor.getLong(cursor.getColumnIndex("total_length"));
                                        int assistantState2SDKState = GlobalUtil.assistantState2SDKState(cursor.getInt(cursor.getColumnIndex("state")));
                                        if (4 == assistantState2SDKState && !isFileExist(string)) {
                                            cursor.close();
                                            return null;
                                        }
                                        tMAssistantCallYYBTaskInfo = new TMAssistantCallYYBTaskInfo(str, string, assistantState2SDKState, j16, j17, "application/vnd.android.package-archive");
                                        try {
                                            Map<String, TMAssistantCallYYBParamStruct> map = this.mDownloadParams;
                                            if (map != null) {
                                                Iterator<Map.Entry<String, TMAssistantCallYYBParamStruct>> it = map.entrySet().iterator();
                                                while (true) {
                                                    if (!it.hasNext()) {
                                                        break;
                                                    }
                                                    TMAssistantCallYYBParamStruct value = it.next().getValue();
                                                    if (value != null && value.taskPackageName.equals(tMAssistantCallYYBParamStruct.taskPackageName) && value.taskVersion == tMAssistantCallYYBParamStruct.taskVersion) {
                                                        z16 = true;
                                                        break;
                                                    }
                                                }
                                                if (!z16) {
                                                    String uuid = UUID.randomUUID().toString();
                                                    tMAssistantCallYYBParamStruct.taskApkId = String.valueOf(j3);
                                                    this.mDownloadParams.put(uuid, tMAssistantCallYYBParamStruct);
                                                    relateToQQDownloader(this.mContext, tMAssistantCallYYBParamStruct, uuid);
                                                }
                                            }
                                            tMAssistantCallYYBTaskInfo2 = tMAssistantCallYYBTaskInfo;
                                        } catch (Exception e16) {
                                            e = e16;
                                            cursor2 = cursor;
                                            e.printStackTrace();
                                            r.a(TAG, "getDownloadTaskState Exception", e);
                                            if (cursor2 == null) {
                                                cursor = cursor2;
                                                tMAssistantCallYYBTaskInfo2 = tMAssistantCallYYBTaskInfo;
                                                cursor.close();
                                                return tMAssistantCallYYBTaskInfo2;
                                            }
                                            return tMAssistantCallYYBTaskInfo;
                                        }
                                    }
                                } catch (Exception e17) {
                                    e = e17;
                                    tMAssistantCallYYBTaskInfo = null;
                                    cursor2 = cursor;
                                    e.printStackTrace();
                                    r.a(TAG, "getDownloadTaskState Exception", e);
                                    if (cursor2 == null) {
                                    }
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                cursor2 = cursor;
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                throw th;
                            }
                        }
                        if (cursor == null) {
                            return tMAssistantCallYYBTaskInfo2;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } catch (Exception e18) {
                    e = e18;
                    cursor = null;
                }
                cursor.close();
                return tMAssistantCallYYBTaskInfo2;
            }
            r.a(TAG, "param is null");
            throw new Exception("QQDownloaderParam param cann't is null!");
        }
        r.a(TAG, "context is null");
        throw new Exception("Context shouldn't be null !");
    }

    @Override // com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB
    public void initTMAssistantCallYYBApi(Context context) {
        this.mContext = context;
        this.hostPackageName = context.getPackageName();
        this.hostVersionCode = GlobalUtil.getAppVersionCode(this.mContext);
        GlobalUtil.getInstance().setContext(this.mContext);
        this.sdkAPILevel = 1;
        DownloadStateChangedReceiver.a().a(this.mContext);
        DownloadStateChangedReceiver.a().a(this);
        NetworkMonitorReceiver.getInstance().registerReceiver();
        e.c();
    }

    @Override // com.tencent.tmassistantsdk.internal.openSDK.a
    public void onDownloadStateChanged(d dVar) {
        TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct;
        TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct2 = dVar.f380580a;
        int assistantState2SDKState = GlobalUtil.assistantState2SDKState(dVar.f380582c);
        int assistantErrorCode2SDKErrorCode = GlobalUtil.assistantErrorCode2SDKErrorCode(dVar.f380583d);
        String str = dVar.f380584e;
        String str2 = dVar.f380581b;
        if (str2 != null && str2.trim().length() > 0) {
            tMAssistantCallYYBParamStruct = this.mDownloadParams.get(str2);
        } else {
            tMAssistantCallYYBParamStruct = null;
        }
        if (tMAssistantCallYYBParamStruct != null) {
            onStateChanged(tMAssistantCallYYBParamStruct, assistantState2SDKState, assistantErrorCode2SDKErrorCode, str);
        }
        if (6 == assistantState2SDKState) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, TMAssistantCallYYBParamStruct> entry : this.mDownloadParams.entrySet()) {
                TMAssistantCallYYBParamStruct value = entry.getValue();
                String key = entry.getKey();
                if (value != null && !TextUtils.isEmpty(tMAssistantCallYYBParamStruct2.taskPackageName) && value.taskPackageName.equals(tMAssistantCallYYBParamStruct2.taskPackageName) && value.taskVersion == tMAssistantCallYYBParamStruct2.taskVersion) {
                    arrayList.add(key);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.mDownloadParams.remove((String) it.next());
            }
        }
    }

    public void startToAppDetail(Context context, TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, boolean z16, boolean z17) {
        if (context != null) {
            String uuid = UUID.randomUUID().toString();
            Map<String, TMAssistantCallYYBParamStruct> map = this.mDownloadParams;
            if (map != null) {
                map.put(uuid, tMAssistantCallYYBParamStruct);
            }
            b.g().a(b.g().a(b.a(tMAssistantCallYYBParamStruct), uuid, "V1_startToAppDetail"));
            Map<String, String> formatMapParams = super.formatMapParams(tMAssistantCallYYBParamStruct, z16, z17, uuid);
            formatMapParams.put("taskid", uuid);
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(super.formatIntentUriPath(2, formatMapParams)));
            if (context instanceof Application) {
                intent.addFlags(268435456);
            }
            intent.putExtra(TMAssistantCallYYBParamStruct.SOURCE_KEY, tMAssistantCallYYBParamStruct.source);
            intent.putExtra("packageName", tMAssistantCallYYBParamStruct.taskPackageName);
            context.startActivity(intent);
            return;
        }
        r.a(TAG, "context is null");
        throw new Exception("you must input an application or activity context!");
    }

    @Override // com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB
    public void startToAuthorized(Context context, TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, String str) {
        if (context == null) {
            r.a(TAG, "context is null");
            throw new Exception("you must input an application or activity context!");
        }
        if (tMAssistantCallYYBParamStruct != null) {
            String uuid = UUID.randomUUID().toString();
            Map<String, TMAssistantCallYYBParamStruct> map = this.mDownloadParams;
            if (map != null) {
                map.put(uuid, tMAssistantCallYYBParamStruct);
            }
            b.g().a(b.g().a(b.a(tMAssistantCallYYBParamStruct), uuid, "V1_startToAuthorized"));
            Map<String, String> formatMapParams = super.formatMapParams(tMAssistantCallYYBParamStruct, true, true, uuid);
            formatMapParams.put("verifytype", str);
            formatMapParams.put("taskid", uuid);
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(super.formatIntentUriPath(3, formatMapParams)));
            if (context instanceof Application) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
            return;
        }
        r.a(TAG, "QQDownloaderParam param is null");
        throw new Exception("QQDownloaderParam param cann't be null!");
    }

    public void startToDownloadTaskList(Context context, TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, boolean z16, boolean z17) {
        if (context != null) {
            if (tMAssistantCallYYBParamStruct == null) {
                r.a(TAG, "param is null");
                return;
            }
            String uuid = UUID.randomUUID().toString();
            Map<String, TMAssistantCallYYBParamStruct> map = this.mDownloadParams;
            if (map != null) {
                map.put(uuid, tMAssistantCallYYBParamStruct);
            }
            b.g().a(b.g().a(b.a(tMAssistantCallYYBParamStruct), uuid, "V1_startToDownloadTaskList"));
            Map<String, String> formatMapParams = super.formatMapParams(tMAssistantCallYYBParamStruct, z16, z17, uuid);
            formatMapParams.put("taskid", uuid);
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(super.formatIntentUriPath(1, formatMapParams)));
            if (context instanceof Application) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
            return;
        }
        r.a(TAG, "context is null");
        throw new Exception("you must input an application or activity context!");
    }

    @Override // com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB
    public void startToWebView(Context context, String str) {
        if (context != null) {
            if (!TextUtils.isEmpty(str)) {
                HashMap hashMap = new HashMap();
                hashMap.put("url", str);
                Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(super.formatIntentUriPath(5, hashMap)));
                if (context instanceof Application) {
                    intent.addFlags(268435456);
                }
                context.startActivity(intent);
                return;
            }
            r.a(TAG, "url is null");
            throw new Exception("param url shouldn't be null!");
        }
        r.a(TAG, "context is null");
        throw new Exception("you must input an application or activity context!");
    }

    public long addDownloadTaskFromAuthorize(String str) {
        String formatEncryptUrl = super.formatEncryptUrl(str);
        long currentTimeMillis = System.currentTimeMillis();
        return this.sdkChannel.a(this.hostPackageName, this.hostVersionCode, "", 0, formatEncryptUrl, currentTimeMillis, currentTimeMillis + MiniBoxNoticeInfo.MIN_5, 0, null);
    }

    public void startToAuthorized(Context context, String str) {
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(formatEncryptUrl(str)));
        if (context instanceof Application) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }
}
