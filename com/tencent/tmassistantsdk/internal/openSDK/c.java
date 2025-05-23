package com.tencent.tmassistantsdk.internal.openSDK;

import android.content.Context;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistant.TMAssistantDownloadSDKManager;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.OuterCallLog;
import com.tencent.tmassistantbase.util.r;
import com.tencent.tmassistantsdk.ITMAssistantCallBackListener;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYBTaskInfo;
import com.tencent.tmassistantsdk.internal.logreport.OuterCallReportModel;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.BatchDownloadActionRequest;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.BatchDownloadActionResponse;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.GetDownloadProgressResponse;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.GetDownloadStateResponse;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCBaseParam;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCDownloadParam;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCQueryDownloadInfo;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCRequest;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCResponse;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.OperateDownloadTaskRequest;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.QueryDownloadTaskRequest;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.QueryDownloadTaskResponse;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.URIActionRequest;
import java.util.ArrayList;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c implements com.tencent.tmassistantsdk.a.b.a {

    /* renamed from: e, reason: collision with root package name */
    protected static c f380575e;

    /* renamed from: a, reason: collision with root package name */
    protected com.tencent.tmassistantsdk.a.b.b f380576a = null;

    /* renamed from: b, reason: collision with root package name */
    protected ITMAssistantCallBackListener f380577b = null;

    /* renamed from: c, reason: collision with root package name */
    String f380578c = UUID.randomUUID().toString();

    /* renamed from: d, reason: collision with root package name */
    private Context f380579d;

    c(Context context) {
        this.f380579d = null;
        if (context != null) {
            b(context);
        }
        this.f380579d = context;
    }

    public static synchronized c a(Context context) {
        c cVar;
        synchronized (c.class) {
            if (f380575e == null) {
                f380575e = new c(context);
            }
            cVar = f380575e;
        }
        return cVar;
    }

    public boolean b(int i3, ArrayList<TMAssistantCallYYBParamStruct> arrayList, String str, String str2, String str3) {
        BatchDownloadActionRequest a16 = a(i3, arrayList, str, str2, str3);
        String uuid = UUID.randomUUID().toString();
        byte[] a17 = a(a16, uuid);
        if (a17 != null && a17.length > 0) {
            try {
                b(GlobalUtil.getInstance().getContext());
                com.tencent.tmassistantsdk.a.b.b bVar = this.f380576a;
                if (bVar == null) {
                    return false;
                }
                bVar.a(a17);
                com.tencent.tmassistantsdk.internal.logreport.b.g().a(com.tencent.tmassistantsdk.internal.logreport.b.g().a(str, uuid, "V2_handleBatchRequestAction_" + i3));
                return true;
            } catch (Throwable th5) {
                th5.printStackTrace();
                r.b("TMQQDownloaderDataProcessor", "result is false");
            }
        }
        return false;
    }

    public void c() {
        if (this.f380576a != null) {
            Context context = GlobalUtil.getInstance().getContext();
            if (context != null) {
                TMAssistantDownloadSDKManager.a(context).b(this.f380578c);
            }
            this.f380576a = null;
        }
    }

    public void d() {
        this.f380577b = null;
        Context context = GlobalUtil.getInstance().getContext();
        if (context != null) {
            TMAssistantDownloadSDKManager.a(context).b(this.f380578c);
        }
        this.f380576a = null;
    }

    @Override // com.tencent.tmassistantsdk.a.b.a
    public void onActionResult(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            IPCResponse a16 = com.tencent.tmassistantsdk.internal.openSDK.e.a.a(bArr);
            JceStruct a17 = com.tencent.tmassistantsdk.internal.openSDK.e.a.a(a16);
            int i3 = a16.head.cmdId;
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 8) {
                        b();
                        return;
                    }
                    return;
                } else {
                    if (a17 != null) {
                        a((GetDownloadProgressResponse) a17);
                        return;
                    }
                    return;
                }
            }
            if (a17 != null) {
                a((GetDownloadStateResponse) a17);
            }
        }
    }

    public void a(ITMAssistantCallBackListener iTMAssistantCallBackListener) {
        this.f380577b = iTMAssistantCallBackListener;
    }

    public boolean a(TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, int i3, String str, String str2, String str3, OuterCallReportModel outerCallReportModel) {
        if (TMAssistantBaseCallYYB.getQQDownloadApiLevel(this.f380579d) >= 6 && i3 == 1) {
            tMAssistantCallYYBParamStruct.timePointMap.put(OuterCallLog.OuterCall_TMQQDownloaderDataProcessor_HandleDownloadTask_Start, Long.valueOf(System.currentTimeMillis()));
        }
        OperateDownloadTaskRequest operateDownloadTaskRequest = new OperateDownloadTaskRequest();
        IPCBaseParam a16 = a(tMAssistantCallYYBParamStruct, outerCallReportModel);
        if (TMAssistantBaseCallYYB.getQQDownloadApiLevel(this.f380579d) >= 6 && i3 == 1) {
            tMAssistantCallYYBParamStruct.timePointMap.put(OuterCallLog.OuterCall_TMQQDownloaderDataProcessor_HandleDownloadTask_End, Long.valueOf(System.currentTimeMillis()));
        }
        operateDownloadTaskRequest.requestType = i3;
        operateDownloadTaskRequest.baseParam = a16;
        operateDownloadTaskRequest.actionFlag = str2;
        operateDownloadTaskRequest.verifyType = str3;
        operateDownloadTaskRequest.opList = str;
        operateDownloadTaskRequest.timePoint = tMAssistantCallYYBParamStruct.timePointMap;
        String uuid = UUID.randomUUID().toString();
        byte[] a17 = a(operateDownloadTaskRequest, uuid);
        if (a17 != null && a17.length > 0) {
            try {
                b(GlobalUtil.getInstance().getContext());
                com.tencent.tmassistantsdk.a.b.b bVar = this.f380576a;
                if (bVar == null) {
                    return false;
                }
                bVar.a(a17);
                com.tencent.tmassistantsdk.internal.logreport.b.g().a(com.tencent.tmassistantsdk.internal.logreport.b.g().a(com.tencent.tmassistantsdk.internal.logreport.b.a(tMAssistantCallYYBParamStruct), uuid, "V2_handleDownloadTask_" + i3));
                return true;
            } catch (Throwable th5) {
                r.b("TMQQDownloaderDataProcessor", "handleDownloadTask Exception,return false", th5);
                th5.printStackTrace();
            }
        }
        return false;
    }

    private static String b(TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, OuterCallReportModel outerCallReportModel) {
        if (outerCallReportModel == null) {
            return "";
        }
        GlobalUtil.getAppPackageName(GlobalUtil.getInstance().getContext());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("beaconId", outerCallReportModel.mHostPname + "|" + tMAssistantCallYYBParamStruct.via + "|" + outerCallReportModel.mOuterCallTime);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject.toString();
    }

    void b() {
        ITMAssistantCallBackListener iTMAssistantCallBackListener = this.f380577b;
        if (iTMAssistantCallBackListener != null) {
            iTMAssistantCallBackListener.onServiceFree();
        }
    }

    public synchronized com.tencent.tmassistantsdk.a.b.b b(Context context) {
        if (this.f380576a == null && context != null) {
            com.tencent.tmassistantsdk.a.b.b a16 = TMAssistantDownloadSDKManager.a(context).a(this.f380578c);
            this.f380576a = a16;
            if (a16 != null) {
                a16.a(this);
            }
        }
        return this.f380576a;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        URIActionRequest uRIActionRequest = new URIActionRequest(str);
        String uuid = UUID.randomUUID().toString();
        byte[] a16 = a(uRIActionRequest, uuid);
        if (a16 != null && a16.length > 0) {
            try {
                b(GlobalUtil.getInstance().getContext());
                com.tencent.tmassistantsdk.a.b.b bVar = this.f380576a;
                if (bVar != null) {
                    bVar.a(a16);
                }
                com.tencent.tmassistantsdk.internal.logreport.b.g().a(com.tencent.tmassistantsdk.internal.logreport.b.g().a(str, uuid, "V2_handleUriAction"));
                return false;
            } catch (Throwable th5) {
                th5.printStackTrace();
                r.b("TMQQDownloaderDataProcessor", "handleUriAction Exception,return false", th5);
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<TMAssistantCallYYBTaskInfo> a(ArrayList<TMAssistantCallYYBParamStruct> arrayList, String str, String str2, String str3) {
        byte[] bArr;
        IPCResponse a16;
        BatchDownloadActionResponse batchDownloadActionResponse;
        ArrayList<TMAssistantCallYYBTaskInfo> arrayList2 = null;
        if (arrayList == null) {
            return null;
        }
        byte[] a17 = a(a(3, arrayList, str, str2, str3), "");
        if (a17 != null && a17.length > 0) {
            try {
                b(GlobalUtil.getInstance().getContext());
                com.tencent.tmassistantsdk.a.b.b bVar = this.f380576a;
                if (bVar != null) {
                    bArr = bVar.b(a17);
                    a16 = com.tencent.tmassistantsdk.internal.openSDK.e.a.a(bArr);
                    if (a16 != null && (batchDownloadActionResponse = (BatchDownloadActionResponse) com.tencent.tmassistantsdk.internal.openSDK.e.a.a(a16)) != null) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("getBatchTaskInfos BatchDownloadActionResponse batchRequestType:");
                        sb5.append(batchDownloadActionResponse.batchRequestType);
                        if (batchDownloadActionResponse.batchData != null) {
                            batchDownloadActionResponse.batchData.size();
                            arrayList2 = new ArrayList<>();
                            for (int i3 = 0; i3 < batchDownloadActionResponse.batchData.size(); i3++) {
                                IPCQueryDownloadInfo iPCQueryDownloadInfo = batchDownloadActionResponse.batchData.get(i3);
                                arrayList2.add(new TMAssistantCallYYBTaskInfo(iPCQueryDownloadInfo.url, iPCQueryDownloadInfo.savePath, GlobalUtil.assistantState2SDKState(iPCQueryDownloadInfo.state), iPCQueryDownloadInfo.receivedLen, iPCQueryDownloadInfo.totalLen, "application/vnd.android.package-archive"));
                            }
                        }
                    }
                    return arrayList2;
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
                return null;
            }
        }
        bArr = null;
        a16 = com.tencent.tmassistantsdk.internal.openSDK.e.a.a(bArr);
        if (a16 != null) {
            StringBuilder sb52 = new StringBuilder();
            sb52.append("getBatchTaskInfos BatchDownloadActionResponse batchRequestType:");
            sb52.append(batchDownloadActionResponse.batchRequestType);
            if (batchDownloadActionResponse.batchData != null) {
            }
        }
        return arrayList2;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TMAssistantCallYYBTaskInfo a(TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct) {
        byte[] bArr;
        IPCResponse a16;
        IPCBaseParam a17 = a(tMAssistantCallYYBParamStruct, (OuterCallReportModel) null);
        QueryDownloadTaskRequest queryDownloadTaskRequest = new QueryDownloadTaskRequest();
        queryDownloadTaskRequest.baseParam = a17;
        byte[] a18 = a(queryDownloadTaskRequest, "");
        if (a18 != null && a18.length > 0) {
            try {
                b(GlobalUtil.getInstance().getContext());
                com.tencent.tmassistantsdk.a.b.b bVar = this.f380576a;
                if (bVar != null) {
                    bArr = bVar.b(a18);
                    a16 = com.tencent.tmassistantsdk.internal.openSDK.e.a.a(bArr);
                    if (a16 != null) {
                        return null;
                    }
                    QueryDownloadTaskResponse queryDownloadTaskResponse = (QueryDownloadTaskResponse) com.tencent.tmassistantsdk.internal.openSDK.e.a.a(a16);
                    return new TMAssistantCallYYBTaskInfo(queryDownloadTaskResponse.url, queryDownloadTaskResponse.savePath, GlobalUtil.assistantState2SDKState(queryDownloadTaskResponse.state), queryDownloadTaskResponse.receivedLen, queryDownloadTaskResponse.totalLen, "application/vnd.android.package-archive");
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
                r.a("TMQQDownloaderDataProcessor", "getDownloadTask Exception,return null", th5);
                return null;
            }
        }
        bArr = null;
        a16 = com.tencent.tmassistantsdk.internal.openSDK.e.a.a(bArr);
        if (a16 != null) {
        }
    }

    public static BatchDownloadActionRequest a(int i3, ArrayList<TMAssistantCallYYBParamStruct> arrayList, String str, String str2, String str3) {
        BatchDownloadActionRequest batchDownloadActionRequest = new BatchDownloadActionRequest();
        batchDownloadActionRequest.batchRequestType = i3;
        if (str != null) {
            batchDownloadActionRequest.via = str;
        }
        if (str2 != null) {
            batchDownloadActionRequest.uin = str2;
        }
        if (str3 != null) {
            batchDownloadActionRequest.uinType = str3;
        }
        batchDownloadActionRequest.batchData = new ArrayList<>();
        if (arrayList != null) {
            for (int i16 = 0; i16 < arrayList.size(); i16++) {
                IPCBaseParam a16 = a(arrayList.get(i16), (OuterCallReportModel) null);
                IPCDownloadParam iPCDownloadParam = new IPCDownloadParam();
                iPCDownloadParam.baseParam = a16;
                batchDownloadActionRequest.batchData.add(iPCDownloadParam);
            }
        }
        return batchDownloadActionRequest;
    }

    public static byte[] a(JceStruct jceStruct, String str) {
        byte[] a16;
        IPCRequest a17 = com.tencent.tmassistantsdk.internal.openSDK.e.a.a(jceStruct, str);
        if (a17 == null || (a16 = com.tencent.tmassistantsdk.internal.openSDK.e.a.a(a17)) == null || a16.length <= 0) {
            return null;
        }
        return a16;
    }

    private static IPCBaseParam a(TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, OuterCallReportModel outerCallReportModel) {
        if (tMAssistantCallYYBParamStruct == null) {
            return null;
        }
        IPCBaseParam iPCBaseParam = new IPCBaseParam();
        iPCBaseParam.hostAppId = tMAssistantCallYYBParamStruct.SNGAppId;
        iPCBaseParam.taskAppId = tMAssistantCallYYBParamStruct.taskAppId;
        iPCBaseParam.taskPackageName = tMAssistantCallYYBParamStruct.taskPackageName;
        iPCBaseParam.taskVersion = String.valueOf(tMAssistantCallYYBParamStruct.taskVersion);
        iPCBaseParam.uin = tMAssistantCallYYBParamStruct.uin;
        iPCBaseParam.uinType = tMAssistantCallYYBParamStruct.uinType;
        iPCBaseParam.via = tMAssistantCallYYBParamStruct.via;
        iPCBaseParam.channelId = tMAssistantCallYYBParamStruct.channelId;
        iPCBaseParam.extra = b(tMAssistantCallYYBParamStruct, outerCallReportModel);
        return iPCBaseParam;
    }

    private TMAssistantCallYYBParamStruct a(IPCBaseParam iPCBaseParam) {
        if (iPCBaseParam == null) {
            return null;
        }
        TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct = new TMAssistantCallYYBParamStruct();
        tMAssistantCallYYBParamStruct.SNGAppId = iPCBaseParam.hostAppId;
        tMAssistantCallYYBParamStruct.taskAppId = iPCBaseParam.taskAppId;
        tMAssistantCallYYBParamStruct.taskPackageName = iPCBaseParam.taskPackageName;
        try {
            tMAssistantCallYYBParamStruct.taskVersion = Integer.valueOf(iPCBaseParam.taskVersion).intValue();
        } catch (Exception unused) {
            r.b("TMQQDownloaderDataProcessor", "baseParam2QQParam Integer.valueOf(baseParam.taskVersion) NumberFormatException occur");
        }
        tMAssistantCallYYBParamStruct.uin = iPCBaseParam.uin;
        tMAssistantCallYYBParamStruct.uinType = iPCBaseParam.uinType;
        tMAssistantCallYYBParamStruct.via = iPCBaseParam.via;
        tMAssistantCallYYBParamStruct.channelId = iPCBaseParam.channelId;
        return tMAssistantCallYYBParamStruct;
    }

    @Override // com.tencent.tmassistantsdk.a.b.a
    public void a() {
        ITMAssistantCallBackListener iTMAssistantCallBackListener = this.f380577b;
        if (iTMAssistantCallBackListener != null) {
            iTMAssistantCallBackListener.onQQDownloaderInvalid();
        }
        Context context = GlobalUtil.getInstance().getContext();
        if (context != null) {
            TMAssistantDownloadSDKManager.a(context).b(this.f380578c);
        }
        this.f380576a = null;
    }

    void a(GetDownloadStateResponse getDownloadStateResponse) {
        ITMAssistantCallBackListener iTMAssistantCallBackListener;
        TMAssistantCallYYBParamStruct a16 = a(getDownloadStateResponse.requestParam);
        if (a16 == null || (iTMAssistantCallBackListener = this.f380577b) == null) {
            return;
        }
        iTMAssistantCallBackListener.onDownloadTaskStateChanged(a16, GlobalUtil.assistantState2SDKState(getDownloadStateResponse.state), GlobalUtil.assistantErrorCode2SDKErrorCode(getDownloadStateResponse.errorCode), getDownloadStateResponse.errorMsg);
    }

    void a(GetDownloadProgressResponse getDownloadProgressResponse) {
        ITMAssistantCallBackListener iTMAssistantCallBackListener;
        TMAssistantCallYYBParamStruct a16 = a(getDownloadProgressResponse.requestParam);
        if (a16 == null || (iTMAssistantCallBackListener = this.f380577b) == null) {
            return;
        }
        iTMAssistantCallBackListener.onDownloadTaskProgressChanged(a16, getDownloadProgressResponse.receivedLen, getDownloadProgressResponse.totalLen);
    }
}
