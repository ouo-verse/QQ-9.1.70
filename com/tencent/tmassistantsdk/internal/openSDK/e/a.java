package com.tencent.tmassistantsdk.internal.openSDK.e;

import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistant.common.ProtocolPackage;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCCmd;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCHead;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCRequest;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCResponse;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCSDKDownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    protected static int f380585a;

    public static int a(JceStruct jceStruct) {
        if (jceStruct == null) {
            return -1;
        }
        return IPCCmd.convert(jceStruct.getClass().getSimpleName().substring(0, r2.length() - 7)).value();
    }

    public static byte[] b(JceStruct jceStruct) {
        return ProtocolPackage.jceStructToUTF8Byte(jceStruct);
    }

    public static IPCRequest a(JceStruct jceStruct, String str) {
        if (jceStruct == null) {
            return null;
        }
        IPCRequest iPCRequest = new IPCRequest();
        IPCHead iPCHead = new IPCHead();
        int i3 = f380585a;
        f380585a = i3 + 1;
        iPCHead.requestId = i3;
        iPCHead.cmdId = a(jceStruct);
        iPCHead.hostPackageName = GlobalUtil.getAppPackageName(GlobalUtil.getInstance().getContext());
        iPCHead.hostVersionCode = String.valueOf(GlobalUtil.getAppVersionCode(GlobalUtil.getInstance().getContext()));
        iPCHead.traceId = str;
        iPCHead.sdkIpcJceVersion = 1;
        iPCRequest.head = iPCHead;
        iPCRequest.body = b(jceStruct);
        return iPCRequest;
    }

    public static byte[] a(IPCRequest iPCRequest) {
        if (iPCRequest == null) {
            return null;
        }
        iPCRequest.body = ProtocolPackage.encrypt(iPCRequest.body, ProtocolPackage.CRYPT_KEY.getBytes());
        return b(iPCRequest);
    }

    public static IPCResponse a(byte[] bArr) {
        if (bArr != null && bArr.length >= 4) {
            IPCResponse iPCResponse = new IPCResponse();
            try {
                JceInputStream jceInputStream = new JceInputStream(bArr);
                jceInputStream.setServerEncoding("utf-8");
                iPCResponse.readFrom(jceInputStream);
                if (!TextUtils.isEmpty(iPCResponse.head.hostPackageName)) {
                    iPCResponse.body = ProtocolPackage.decrypt(iPCResponse.body, ProtocolPackage.CRYPT_KEY.getBytes());
                }
                return iPCResponse;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return null;
    }

    public static JceStruct a(IPCResponse iPCResponse) {
        try {
            JceStruct a16 = a(IPCCmd.convert(iPCResponse.head.cmdId).toString());
            if (a16 != null) {
                byte[] bArr = iPCResponse.body;
                if (bArr.length > 0) {
                    try {
                        JceInputStream jceInputStream = new JceInputStream(bArr);
                        jceInputStream.setServerEncoding("utf-8");
                        a16.readFrom(jceInputStream);
                        return a16;
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private static JceStruct a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (JceStruct) Class.forName((a.class.getPackage().getName() + ".jce." + str) + "Response").newInstance();
        } catch (ClassNotFoundException e16) {
            e16.printStackTrace();
            return null;
        } catch (IllegalAccessException e17) {
            e17.printStackTrace();
            return null;
        } catch (InstantiationException e18) {
            e18.printStackTrace();
            return null;
        }
    }

    public static List<IPCSDKDownloadInfo> a(List<TMAssistantDownloadTaskInfo> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<TMAssistantDownloadTaskInfo> it = list.iterator();
        while (it.hasNext()) {
            IPCSDKDownloadInfo a16 = a(it.next());
            if (a16 != null) {
                arrayList.add(a16);
            }
        }
        return arrayList;
    }

    public static IPCSDKDownloadInfo a(TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo) {
        if (tMAssistantDownloadTaskInfo == null) {
            return null;
        }
        IPCSDKDownloadInfo iPCSDKDownloadInfo = new IPCSDKDownloadInfo();
        iPCSDKDownloadInfo.appId = tMAssistantDownloadTaskInfo.mAppId + "";
        iPCSDKDownloadInfo.appIconUrl = tMAssistantDownloadTaskInfo.mIconUrl + "";
        iPCSDKDownloadInfo.appName = tMAssistantDownloadTaskInfo.mAppName + "";
        iPCSDKDownloadInfo.downloadFinishTime = tMAssistantDownloadTaskInfo.mEndTime;
        iPCSDKDownloadInfo.packageName = tMAssistantDownloadTaskInfo.mTaskPackageName + "";
        iPCSDKDownloadInfo.via = tMAssistantDownloadTaskInfo.mVia + "";
        iPCSDKDownloadInfo.versionCode = tMAssistantDownloadTaskInfo.mTaskVersionCode;
        iPCSDKDownloadInfo.appState = tMAssistantDownloadTaskInfo.mState;
        iPCSDKDownloadInfo.receivedLen = tMAssistantDownloadTaskInfo.mReceiveDataLen;
        iPCSDKDownloadInfo.totalLen = tMAssistantDownloadTaskInfo.mTotalDataLen;
        iPCSDKDownloadInfo.url = tMAssistantDownloadTaskInfo.mUrl + "";
        return iPCSDKDownloadInfo;
    }
}
