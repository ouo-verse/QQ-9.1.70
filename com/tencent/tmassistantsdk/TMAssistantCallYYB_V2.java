package com.tencent.tmassistantsdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IInterface;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.tmassistant.st.SDKReportManager2;
import com.tencent.tmassistantbase.network.NetworkMonitorReceiver;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.OuterCallLog;
import com.tencent.tmassistantbase.util.r;
import com.tencent.tmassistantsdk.internal.logreport.OuterCallReportModel;
import com.tencent.tmassistantsdk.internal.logreport.b;
import com.tencent.tmassistantsdk.internal.logreport.e;
import com.tencent.tmassistantsdk.internal.openSDK.QQDownloader.QQDownloaderInstalled;
import com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB;
import com.tencent.tmassistantsdk.internal.openSDK.c;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.BatchDownloadActionRequest;
import com.vivo.push.PushClientConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TMAssistantCallYYB_V2 extends TMAssistantBaseCallYYB implements ITMAssistantCallBackListener, QQDownloaderInstalled.b {
    protected static final String TAG = "TMAssistantCallYYB_V2";
    protected static TMAssistantCallYYB_V2 mInstance;
    protected CopyOnWriteArrayList<TMAssistantCallYYBParamStruct> mTaskList;

    protected TMAssistantCallYYB_V2() {
        this.mTaskList = null;
        this.mTaskList = new CopyOnWriteArrayList<>();
    }

    private synchronized void addToTaskList(TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct) {
        boolean z16;
        if (tMAssistantCallYYBParamStruct != null) {
            CopyOnWriteArrayList<TMAssistantCallYYBParamStruct> copyOnWriteArrayList = this.mTaskList;
            if (copyOnWriteArrayList != null) {
                Iterator<TMAssistantCallYYBParamStruct> it = copyOnWriteArrayList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        TMAssistantCallYYBParamStruct next = it.next();
                        String str = next.taskAppId;
                        z16 = true;
                        if (str != null) {
                            if (str.equals(tMAssistantCallYYBParamStruct.taskAppId)) {
                                String str2 = next.taskPackageName;
                                if (str2 == null || str2.equals(tMAssistantCallYYBParamStruct.taskPackageName)) {
                                    break;
                                }
                            }
                        } else {
                            String str3 = next.taskPackageName;
                            if (str3 != null && str3.equals(tMAssistantCallYYBParamStruct.taskPackageName)) {
                                break;
                            }
                        }
                    } else {
                        z16 = false;
                        break;
                    }
                }
                if (!z16) {
                    this.mTaskList.add(tMAssistantCallYYBParamStruct);
                }
            }
        }
    }

    private synchronized void addToTaskListHead(TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct) {
        boolean z16;
        if (tMAssistantCallYYBParamStruct != null) {
            CopyOnWriteArrayList<TMAssistantCallYYBParamStruct> copyOnWriteArrayList = this.mTaskList;
            if (copyOnWriteArrayList != null) {
                Iterator<TMAssistantCallYYBParamStruct> it = copyOnWriteArrayList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        TMAssistantCallYYBParamStruct next = it.next();
                        String str = next.taskAppId;
                        z16 = true;
                        if (str != null) {
                            if (str.equals(tMAssistantCallYYBParamStruct.taskAppId)) {
                                String str2 = next.taskPackageName;
                                if (str2 == null || str2.equals(tMAssistantCallYYBParamStruct.taskPackageName)) {
                                    break;
                                }
                            }
                        } else {
                            String str3 = next.taskPackageName;
                            if (str3 != null && str3.equals(tMAssistantCallYYBParamStruct.taskPackageName)) {
                                break;
                            }
                        }
                    } else {
                        z16 = false;
                        break;
                    }
                }
                if (!z16) {
                    this.mTaskList.add(0, tMAssistantCallYYBParamStruct);
                }
            }
        }
    }

    private Map<String, String> buildBatchDownloadParam(Context context, ArrayList<TMAssistantCallYYBParamStruct> arrayList) {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator<TMAssistantCallYYBParamStruct> it = arrayList.iterator();
        while (it.hasNext()) {
            TMAssistantCallYYBParamStruct next = it.next();
            if (next != null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(PushClientConstants.TAG_PKG_NAME, next.taskPackageName);
                    jSONObject2.put("versionCode", next.taskVersion);
                    jSONObject2.put("yybChannelId", next.channelId);
                    jSONObject2.put("recommendId", next.recommendId);
                    jSONObject2.put("via", next.via);
                    jSONArray.mo162put(jSONObject2);
                } catch (JSONException e16) {
                    r.a(TAG, "" + e16.getMessage() + "|" + e16.getCause());
                }
            }
        }
        try {
            jSONObject.put("appList", jSONArray);
            jSONObject.put("hostPackageName", GlobalUtil.getAppPackageName(context));
            jSONObject.put("hostVersionCode", GlobalUtil.getAppVersionCode(context));
        } catch (JSONException e17) {
            r.a(TAG, "" + e17.getMessage() + "|" + e17.getCause());
        }
        hashMap.put("out_batch_download", jSONObject.toString());
        return hashMap;
    }

    private int getBatchOperateType(int i3) {
        if (i3 != 2) {
            if (i3 != 3) {
                return 0;
            }
            return 7;
        }
        return 8;
    }

    private int getBatchRequestType(boolean z16, int i3) {
        if (z16) {
            if (i3 != 0) {
                if (i3 == 1) {
                    return 1;
                }
                if (i3 != 2) {
                    if (i3 == 3) {
                        return 5;
                    }
                } else {
                    return 6;
                }
            }
        } else if (i3 != 0 && i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    return 7;
                }
            } else {
                return 8;
            }
        } else {
            return 4;
        }
        return 2;
    }

    public static synchronized TMAssistantCallYYB_V2 getInstance() {
        TMAssistantCallYYB_V2 tMAssistantCallYYB_V2;
        synchronized (TMAssistantCallYYB_V2.class) {
            if (mInstance == null) {
                mInstance = new TMAssistantCallYYB_V2();
            }
            tMAssistantCallYYB_V2 = mInstance;
        }
        return tMAssistantCallYYB_V2;
    }

    private void onProgressChanged(TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, long j3, long j16) {
        Iterator<WeakReference<ITMAssistantCallBackListener>> it = this.mWeakListenerArrayList.iterator();
        while (it.hasNext()) {
            ITMAssistantCallBackListener iTMAssistantCallBackListener = it.next().get();
            if (iTMAssistantCallBackListener != null) {
                iTMAssistantCallBackListener.onDownloadTaskProgressChanged(tMAssistantCallYYBParamStruct, j3, j16);
            }
        }
    }

    private OuterCallReportModel setupOuterCallModel(TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct) {
        OuterCallReportModel defaultModel = OuterCallReportModel.getDefaultModel();
        defaultModel.mOuterCallTime = System.currentTimeMillis();
        defaultModel.mOuterCallMode = 1;
        defaultModel.mOuterCallType = 1;
        if (tMAssistantCallYYBParamStruct != null) {
            defaultModel.mVia = tMAssistantCallYYBParamStruct.via;
        }
        defaultModel.mComponentName = "SplashActivity";
        return defaultModel;
    }

    private Map<String, String> setupParamMap(TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, OuterCallReportModel outerCallReportModel, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
            if (outerCallReportModel != null) {
                hashMap.put("outerCallType", String.valueOf(outerCallReportModel.mOuterCallType));
                hashMap.put("outerCallTime", String.valueOf(outerCallReportModel.mOuterCallTime));
                hashMap.put("outerCallMode", String.valueOf(outerCallReportModel.mOuterCallMode));
                hashMap.put("outerCallComponent", outerCallReportModel.mComponentName);
                if (tMAssistantCallYYBParamStruct != null) {
                    hashMap.put("beaconId", outerCallReportModel.mHostPname + "|" + tMAssistantCallYYBParamStruct.via + "|" + outerCallReportModel.mOuterCallTime);
                }
            }
        }
        return hashMap;
    }

    private void startToAppDetailNewAPI(Context context, TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, OuterCallReportModel outerCallReportModel, Map<String, String> map) {
        String formatIntentUriPath = super.formatIntentUriPath(2, setupParamMap(tMAssistantCallYYBParamStruct, outerCallReportModel, map));
        Intent intent = new Intent();
        intent.setData(Uri.parse(formatIntentUriPath));
        intent.addFlags(268435456);
        intent.putExtra(TMAssistantCallYYBParamStruct.SOURCE_KEY, tMAssistantCallYYBParamStruct.source);
        intent.putExtra("packageName", tMAssistantCallYYBParamStruct.taskPackageName);
        context.startActivity(intent);
    }

    private void startToDownloadListNewAPI(Context context, Map<String, String> map) {
        String formatIntentUriPath = super.formatIntentUriPath(1, map);
        Intent intent = new Intent();
        intent.setData(Uri.parse(formatIntentUriPath));
        intent.addFlags(268435456);
        try {
            context.startActivity(intent);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void startToDownloadManager(Context context, ArrayList<TMAssistantCallYYBParamStruct> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            String formatIntentUriPath = super.formatIntentUriPath(6, buildBatchDownloadParam(context, arrayList));
            Intent intent = new Intent();
            intent.setData(Uri.parse(formatIntentUriPath));
            intent.putExtra(TMAssistantCallYYBParamStruct.SOURCE_KEY, arrayList.get(0).source);
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    private void startToWebViewNewAPI(Map<String, String> map, OuterCallReportModel outerCallReportModel) {
        String formatIntentUriPath = super.formatIntentUriPath(5, setupParamMap(null, outerCallReportModel, map));
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        intent.setData(Uri.parse(formatIntentUriPath));
        intent.addFlags(268435456);
        this.mContext.startActivity(intent);
    }

    public void addBatchOperationTmast(Context context, ArrayList<TMAssistantCallYYBParamStruct> arrayList) {
        String formatIntentUriPath = formatIntentUriPath(6, buildBatchDownloadParam(context, arrayList), false);
        Bundle bundle = new Bundle();
        bundle.putString("url", formatIntentUriPath);
        addDownloadTaskFromTmast(bundle);
    }

    public long addBatchUpdateOperationToDB(ArrayList<TMAssistantCallYYBParamStruct> arrayList, boolean z16, int i3, String str, String str2, String str3) {
        boolean z17;
        byte[] a16;
        if (arrayList != null && arrayList.size() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        int batchRequestType = getBatchRequestType(z17, i3);
        if (batchRequestType != 3 && !z17) {
            Iterator<TMAssistantCallYYBParamStruct> it = arrayList.iterator();
            while (it.hasNext()) {
                TMAssistantCallYYBParamStruct next = it.next();
                if (next != null) {
                    addToTaskList(next);
                }
            }
        }
        BatchDownloadActionRequest a17 = c.a(batchRequestType, arrayList, str, str2, str3);
        if (a17 != null && (a16 = c.a(a17, "")) != null) {
            return buildAddDBData(a16);
        }
        return -1L;
    }

    @Override // com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB
    public long addDownloadTaskFromAppDetail(TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, boolean z16, boolean z17) {
        addToTaskList(tMAssistantCallYYBParamStruct);
        String uuid = UUID.randomUUID().toString();
        long buildAddDBData = super.buildAddDBData(tMAssistantCallYYBParamStruct, z16, z17, tMAssistantCallYYBParamStruct.actionFlag, null, 2, uuid);
        b.g().a(b.g().a(b.a(tMAssistantCallYYBParamStruct), uuid, "V2_addDownloadTaskFromAppDetail"));
        return buildAddDBData;
    }

    @Override // com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB
    public long addDownloadTaskFromAuthorize(TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, String str) {
        String uuid = UUID.randomUUID().toString();
        addToTaskList(tMAssistantCallYYBParamStruct);
        long buildAddDBData = super.buildAddDBData(tMAssistantCallYYBParamStruct, true, true, tMAssistantCallYYBParamStruct.actionFlag, str, 3, uuid);
        b.g().a(b.g().a(b.a(tMAssistantCallYYBParamStruct), uuid, "V2_addDownloadTaskFromAuthorize"));
        return buildAddDBData;
    }

    @Override // com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB
    public long addDownloadTaskFromTaskList(TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, boolean z16, boolean z17) {
        addToTaskList(tMAssistantCallYYBParamStruct);
        String uuid = UUID.randomUUID().toString();
        long buildAddDBData = super.buildAddDBData(tMAssistantCallYYBParamStruct, z16, z17, tMAssistantCallYYBParamStruct.actionFlag, null, 1, uuid);
        b.g().a(b.g().a(b.a(tMAssistantCallYYBParamStruct), uuid, "V2_addDownloadTaskFromTaskList"));
        return buildAddDBData;
    }

    @Override // com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB
    public void destroyQQDownloaderOpenSDK() {
        e.c().b();
        Context context = this.mContext;
        if (context != null) {
            c.a(context).d();
            QQDownloaderInstalled.a().b();
            QQDownloaderInstalled.a().b(this.mContext);
        }
        GlobalUtil.getInstance().destroy();
        this.mContext = null;
    }

    public ArrayList<TMAssistantCallYYBTaskInfo> getBatchTaskState(ArrayList<TMAssistantCallYYBParamStruct> arrayList, String str, String str2, String str3) {
        if (this.mContext != null) {
            if (arrayList != null && arrayList.size() > 0) {
                int qQDownloadApiLevel = TMAssistantBaseCallYYB.getQQDownloadApiLevel(this.mContext);
                if (qQDownloadApiLevel <= 1) {
                    return null;
                }
                if (qQDownloadApiLevel < 4) {
                    TMAssistantCallYYBTaskInfo a16 = c.a(this.mContext).a(arrayList.get(0));
                    if (a16 == null) {
                        return null;
                    }
                    ArrayList<TMAssistantCallYYBTaskInfo> arrayList2 = new ArrayList<>();
                    arrayList2.add(a16);
                    return arrayList2;
                }
                return c.a(this.mContext).a(arrayList, str, str2, str3);
            }
            r.a(TAG, "appList is null");
            throw new Exception("ArrayList<TMQQDownloaderOpenSDKParam> appList cann't be null or empty!");
        }
        r.a(TAG, "context is null");
        throw new Exception("mContext shouldn't be null !");
    }

    @Override // com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB
    public TMAssistantCallYYBTaskInfo getDownloadTaskState(TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct) {
        Context context = this.mContext;
        if (context != null) {
            if (tMAssistantCallYYBParamStruct != null) {
                return c.a(context).a(tMAssistantCallYYBParamStruct);
            }
            r.a(TAG, "param is null");
            throw new Exception("TMQQDownloaderOpenSDKParam param cann't is null!");
        }
        r.a(TAG, "context is null");
        throw new Exception("Context shouldn't be null !");
    }

    public IInterface getIPCInterface() {
        if (getOpenSDKClient() != null) {
            try {
                return getOpenSDKClient().getServiceInterface();
            } catch (Exception e16) {
                e16.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public com.tencent.tmassistantsdk.a.b.b getOpenSDKClient() {
        Context context = GlobalUtil.getInstance().getContext();
        if (context != null) {
            return c.a(context).b(context);
        }
        return null;
    }

    @Override // com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB
    public void initTMAssistantCallYYBApi(Context context) {
        this.mContext = context;
        this.hostPackageName = context.getPackageName();
        this.hostVersionCode = GlobalUtil.getAppVersionCode(this.mContext);
        GlobalUtil.getInstance().setContext(this.mContext);
        this.sdkAPILevel = 2;
        Context context2 = this.mContext;
        if (context2 != null) {
            c.a(context2).a(this);
            QQDownloaderInstalled.a().a(this.mContext);
            QQDownloaderInstalled.a().a(this);
        }
        NetworkMonitorReceiver.getInstance().registerReceiver();
        e.c();
    }

    @Override // com.tencent.tmassistantsdk.ITMAssistantCallBackListener
    public void onDownloadTaskProgressChanged(TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, long j3, long j16) {
        if (tMAssistantCallYYBParamStruct != null) {
            onProgressChanged(tMAssistantCallYYBParamStruct, j3, j16);
        }
    }

    @Override // com.tencent.tmassistantsdk.ITMAssistantCallBackListener
    public void onDownloadTaskStateChanged(TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, int i3, int i16, String str) {
        if (tMAssistantCallYYBParamStruct != null) {
            onStateChanged(tMAssistantCallYYBParamStruct, i3, i16, str);
        }
    }

    @Override // com.tencent.tmassistantsdk.internal.openSDK.QQDownloader.QQDownloaderInstalled.b
    public synchronized void onQQDownloaderInstalled(Context context) {
        CopyOnWriteArrayList<TMAssistantCallYYBParamStruct> copyOnWriteArrayList = this.mTaskList;
        if (copyOnWriteArrayList != null) {
            Iterator<TMAssistantCallYYBParamStruct> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                TMAssistantCallYYBParamStruct next = it.next();
                if (next != null) {
                    try {
                        getDownloadTaskState(next);
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                    this.mTaskList.remove(next);
                }
            }
        }
    }

    @Override // com.tencent.tmassistantsdk.ITMAssistantCallBackListener
    public void onQQDownloaderInvalid() {
        Iterator<WeakReference<ITMAssistantCallBackListener>> it = this.mWeakListenerArrayList.iterator();
        while (it.hasNext()) {
            ITMAssistantCallBackListener iTMAssistantCallBackListener = it.next().get();
            if (iTMAssistantCallBackListener != null) {
                iTMAssistantCallBackListener.onQQDownloaderInvalid();
            }
        }
    }

    @Override // com.tencent.tmassistantsdk.ITMAssistantCallBackListener
    public void onServiceFree() {
        Iterator<WeakReference<ITMAssistantCallBackListener>> it = this.mWeakListenerArrayList.iterator();
        while (it.hasNext()) {
            ITMAssistantCallBackListener iTMAssistantCallBackListener = it.next().get();
            if (iTMAssistantCallBackListener != null) {
                iTMAssistantCallBackListener.onServiceFree();
            }
        }
    }

    public void releaseIPCConnected() {
        Context context = this.mContext;
        if (context != null) {
            c.a(context).c();
        }
    }

    public int startBatchOperation(Context context, ArrayList<TMAssistantCallYYBParamStruct> arrayList, int i3, String str) {
        if (context != null) {
            int qQDownloadApiLevel = TMAssistantBaseCallYYB.getQQDownloadApiLevel(context);
            if (qQDownloadApiLevel <= 0) {
                addBatchOperationTmast(context, arrayList);
                return 1;
            }
            if (qQDownloadApiLevel < 9) {
                return 2;
            }
            int batchOperateType = getBatchOperateType(i3);
            if (batchOperateType == 7) {
                startToDownloadManager(context, arrayList);
            }
            if (!c.a(this.mContext).b(batchOperateType, arrayList, str, "", "")) {
                r.c(TAG, "handleBatchRequestAction return false with batchRequestType=" + batchOperateType);
                return 0;
            }
            return 0;
        }
        r.a(TAG, "context is null");
        throw new Exception("you must input an application or activity context!");
    }

    public void startToAppDetail(Context context, TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, boolean z16, boolean z17, int i3) {
        int i16;
        if (TMAssistantBaseCallYYB.getQQDownloadApiLevel(context) >= 6) {
            tMAssistantCallYYBParamStruct.timePointMap.put(OuterCallLog.OuterCall_TMAssistantCallYYB_V2_StartToAppDetail, Long.valueOf(System.currentTimeMillis()));
        }
        if (context != null) {
            if (tMAssistantCallYYBParamStruct != null) {
                String formatOplist = super.formatOplist(z16, z17);
                if (1 == i3) {
                    i16 = 1;
                } else {
                    i16 = 4;
                }
                OuterCallReportModel outerCallReportModel = null;
                if (TMAssistantBaseCallYYB.getQQDownloadApiLevel(context) >= 6 && i16 == 1) {
                    Map<String, String> formatMapParams = super.formatMapParams(tMAssistantCallYYBParamStruct, z16, z17, "");
                    if (OuterCallReportModel.isYYBSupportOutcallReport()) {
                        outerCallReportModel = setupOuterCallModel(tMAssistantCallYYBParamStruct);
                        SDKReportManager2.getInstance().postReport(15, outerCallReportModel.toString());
                    }
                    startToAppDetailNewAPI(context, tMAssistantCallYYBParamStruct, outerCallReportModel, formatMapParams);
                    tMAssistantCallYYBParamStruct.outerCallReportData = outerCallReportModel.getJsonData();
                }
                addToTaskListHead(tMAssistantCallYYBParamStruct);
                c.a(this.mContext).a(tMAssistantCallYYBParamStruct, i16, formatOplist, tMAssistantCallYYBParamStruct.actionFlag, null, outerCallReportModel);
                return;
            }
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
            addToTaskList(tMAssistantCallYYBParamStruct);
            c.a(this.mContext).a(tMAssistantCallYYBParamStruct, 3, super.formatOplist(true, true), tMAssistantCallYYBParamStruct.actionFlag, str, null);
            return;
        }
        r.a(TAG, "param is null");
        throw new Exception("QQDownloaderParam param cann't be null!");
    }

    public int startToBatchUpdateOperation(Context context, ArrayList<TMAssistantCallYYBParamStruct> arrayList, boolean z16, int i3, String str, String str2, String str3) {
        if (context != null) {
            int qQDownloadApiLevel = TMAssistantBaseCallYYB.getQQDownloadApiLevel(context);
            boolean z17 = true;
            if (qQDownloadApiLevel <= 0) {
                return 1;
            }
            if (qQDownloadApiLevel < 4) {
                return 2;
            }
            if (arrayList != null && arrayList.size() != 0) {
                z17 = false;
            }
            int batchRequestType = getBatchRequestType(z17, i3);
            if (!c.a(this.mContext).b(batchRequestType, arrayList, str, str2, str3)) {
                r.c(TAG, "handleBatchRequestAction return false with batchRequestType=" + batchRequestType);
            }
            return 0;
        }
        r.a(TAG, "context is null");
        throw new Exception("you must input an application or activity context!");
    }

    public void startToDownloadTaskList(Context context, TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, boolean z16, boolean z17, int i3) {
        int i16;
        if (TMAssistantBaseCallYYB.getQQDownloadApiLevel(context) >= 6) {
            tMAssistantCallYYBParamStruct.timePointMap.put(OuterCallLog.OuterCall_TMAssistantCallYYB_V2_StartToDownloadList, Long.valueOf(System.currentTimeMillis()));
        }
        if (context != null) {
            if (tMAssistantCallYYBParamStruct == null) {
                r.a(TAG, "param is null");
                return;
            }
            String formatOplist = super.formatOplist(z16, z17);
            if (1 == i3) {
                i16 = 2;
            } else {
                i16 = 5;
            }
            OuterCallReportModel outerCallReportModel = null;
            if (TMAssistantBaseCallYYB.getQQDownloadApiLevel(context) >= 6 && i16 == 2) {
                Map<String, String> formatMapParams = super.formatMapParams(tMAssistantCallYYBParamStruct, z16, z17, "");
                if (OuterCallReportModel.isYYBSupportOutcallReport()) {
                    outerCallReportModel = setupOuterCallModel(tMAssistantCallYYBParamStruct);
                    SDKReportManager2.getInstance().postReport(15, outerCallReportModel.toString());
                }
                startToDownloadListNewAPI(context, setupParamMap(tMAssistantCallYYBParamStruct, outerCallReportModel, formatMapParams));
            }
            addToTaskListHead(tMAssistantCallYYBParamStruct);
            c.a(this.mContext).a(tMAssistantCallYYBParamStruct, i16, formatOplist, tMAssistantCallYYBParamStruct.actionFlag, null, outerCallReportModel);
            return;
        }
        r.a(TAG, "context is null");
        throw new Exception("you must input an application or activity context!");
    }

    @Override // com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB
    public void startToWebView(Context context, String str) {
        OuterCallReportModel outerCallReportModel;
        if (context != null) {
            if (!TextUtils.isEmpty(str)) {
                HashMap hashMap = new HashMap();
                hashMap.put("url", str);
                if (!TextUtils.isEmpty(str) && this.mContext != null) {
                    if (TMAssistantBaseCallYYB.getQQDownloadApiLevel(context) >= 6) {
                        if (OuterCallReportModel.isYYBSupportOutcallReport()) {
                            outerCallReportModel = setupOuterCallModel(str);
                            SDKReportManager2.getInstance().postReport(15, outerCallReportModel.toString());
                        } else {
                            outerCallReportModel = null;
                        }
                        startToWebViewNewAPI(hashMap, outerCallReportModel);
                        return;
                    }
                    c.a(this.mContext).a(super.formatIntentUriPath(5, hashMap));
                    return;
                }
                return;
            }
            r.a(TAG, "url is null");
            throw new Exception("param url shouldn't be null!");
        }
        r.a(TAG, "context is null");
        throw new Exception("you must input an application or activity context!");
    }

    private OuterCallReportModel setupOuterCallModel(String str) {
        OuterCallReportModel defaultModel = OuterCallReportModel.getDefaultModel();
        defaultModel.mComponentName = "SplashActivity";
        defaultModel.mVia = Uri.parse(str).getQueryParameter("via");
        defaultModel.mOuterCallType = 1;
        defaultModel.mOuterCallMode = 1;
        return defaultModel;
    }

    public void startToAuthorized(Context context, String str) {
        Context context2;
        String formatEncryptUrl = super.formatEncryptUrl(str);
        if (TextUtils.isEmpty(str) || (context2 = this.mContext) == null) {
            return;
        }
        c.a(context2).a(formatEncryptUrl);
    }
}
