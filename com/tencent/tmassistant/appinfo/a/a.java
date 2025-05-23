package com.tencent.tmassistant.appinfo.a;

import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistant.appinfo.aidl.IGetAppInfoCallback;
import com.tencent.tmassistant.appinfo.data.AppDetail;
import com.tencent.tmassistant.appinfo.data.AppDetailReqParam;
import com.tencent.tmassistant.appinfo.data.AppParam;
import com.tencent.tmassistant.common.jce.AppDetailSdkInfo;
import com.tencent.tmassistant.common.jce.AppDetailSdkReqInfo;
import com.tencent.tmassistant.common.jce.GetAppDetailForSdkRequest;
import com.tencent.tmassistant.common.jce.GetAppDetailForSdkResponse;
import com.tencent.tmassistantbase.util.r;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a extends com.tencent.tmassistantbase.network.a {

    /* renamed from: d, reason: collision with root package name */
    private Map<Integer, IGetAppInfoCallback> f380366d;

    public a() {
        super(GetAppDetailForSdkRequest.class, GetAppDetailForSdkResponse.class);
        this.f380366d = new ConcurrentHashMap();
    }

    private static ArrayList<AppDetailSdkReqInfo> b(List<AppParam> list) {
        ArrayList<AppDetailSdkReqInfo> arrayList = new ArrayList<>();
        for (AppParam appParam : list) {
            if (appParam != null && !TextUtils.isEmpty(appParam.packageName)) {
                AppDetailSdkReqInfo appDetailSdkReqInfo = new AppDetailSdkReqInfo();
                appDetailSdkReqInfo.packageName = appParam.packageName;
                String str = appParam.channelId;
                if (str == null) {
                    str = "";
                }
                appDetailSdkReqInfo.channelId = str;
                arrayList.add(appDetailSdkReqInfo);
            } else {
                r.a("GetAppInfoEngine_", "transFrom packageName is empty");
            }
        }
        return arrayList;
    }

    public int a(AppDetailReqParam appDetailReqParam, IGetAppInfoCallback iGetAppInfoCallback) {
        List<AppParam> list;
        if (appDetailReqParam != null && (list = appDetailReqParam.apps) != null && list.size() != 0) {
            GetAppDetailForSdkRequest getAppDetailForSdkRequest = new GetAppDetailForSdkRequest();
            String str = appDetailReqParam.biz;
            if (str == null) {
                str = "";
            }
            getAppDetailForSdkRequest.biz = str;
            getAppDetailForSdkRequest.reqList = b(appDetailReqParam.apps);
            int a16 = a(getAppDetailForSdkRequest);
            if (a16 >= 0 && iGetAppInfoCallback != null) {
                this.f380366d.put(Integer.valueOf(a16), iGetAppInfoCallback);
            }
            return a16;
        }
        r.a("GetAppInfoEngine_", "bad req params");
        return -1;
    }

    @Override // com.tencent.tmassistantbase.network.a
    public void a(int i3, int i16, JceStruct jceStruct, JceStruct jceStruct2) {
        GetAppDetailForSdkResponse getAppDetailForSdkResponse;
        IGetAppInfoCallback remove = this.f380366d.remove(Integer.valueOf(i3));
        if (remove == null) {
            r.a("GetAppInfoEngine_", "cb is null, need't call back anymore.");
            return;
        }
        if (i16 == 0 && (jceStruct2 instanceof GetAppDetailForSdkResponse)) {
            getAppDetailForSdkResponse = (GetAppDetailForSdkResponse) jceStruct2;
        } else {
            getAppDetailForSdkResponse = new GetAppDetailForSdkResponse();
            getAppDetailForSdkResponse.ret = -1;
            getAppDetailForSdkResponse.detailList = new ArrayList<>();
        }
        a(i3, getAppDetailForSdkResponse, remove);
    }

    private void a(int i3, GetAppDetailForSdkResponse getAppDetailForSdkResponse, IGetAppInfoCallback iGetAppInfoCallback) {
        try {
            iGetAppInfoCallback.onGetAppInfoResponse(i3, getAppDetailForSdkResponse.ret, a(getAppDetailForSdkResponse.detailList));
        } catch (Throwable th5) {
            r.a("GetAppInfoEngine_", "doNotify failed, reqId=" + i3 + ", ret=" + getAppDetailForSdkResponse.ret, th5);
        }
    }

    private static ArrayList<AppDetail> a(List<AppDetailSdkInfo> list) {
        ArrayList<AppDetail> arrayList = new ArrayList<>();
        for (AppDetailSdkInfo appDetailSdkInfo : list) {
            AppDetail appDetail = new AppDetail();
            appDetail.appId = appDetailSdkInfo.appId;
            appDetail.apkId = appDetailSdkInfo.apkId;
            appDetail.appName = appDetailSdkInfo.appName;
            appDetail.iconUrl = appDetailSdkInfo.iconUrl;
            appDetail.packageName = appDetailSdkInfo.packageName;
            appDetail.versionCode = appDetailSdkInfo.versionCode;
            appDetail.signatureMd5 = appDetailSdkInfo.signatureMd5;
            appDetail.apkMd5 = appDetailSdkInfo.apkMd5;
            appDetail.fileSize = appDetailSdkInfo.fileSize;
            appDetail.apkDownUrl = appDetailSdkInfo.apkDownUrl;
            appDetail.channelId = appDetailSdkInfo.channelId;
            arrayList.add(appDetail);
        }
        return arrayList;
    }
}
