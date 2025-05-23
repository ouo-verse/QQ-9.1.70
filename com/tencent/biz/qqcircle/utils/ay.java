package com.tencent.biz.qqcircle.utils;

import com.tencent.biz.qqcircle.requests.QFSGetRightInfoRequest;
import com.tencent.biz.qqcircle.utils.ay;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import feedcloud.GetRightInfoRsp;
import feedcloud.RightInfo;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ay {

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void a(RightInfo rightInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(a aVar, String str, BaseRequest baseRequest, boolean z16, long j3, String str2, Object obj) {
        String traceId;
        String str3 = "";
        if (baseRequest == null) {
            traceId = "";
        } else {
            traceId = baseRequest.getTraceId();
        }
        if (baseRequest != null) {
            str3 = baseRequest.getCmdName();
        }
        if (z16 && j3 == 0 && obj != null) {
            if (aVar == null) {
                RFWLog.d("QOK-QFSCommentPermissionUtils", RFWLog.USR, "[loadCommentPermission] callback should not be null.");
                return;
            }
            if (obj instanceof GetRightInfoRsp) {
                aVar.a(((GetRightInfoRsp) obj).right_info);
                RFWLog.d("QOK-QFSCommentPermissionUtils", RFWLog.USR, "[loadCommentPermission] feedId: " + str + " | traceId: " + traceId + " | cmdName: " + str3);
                return;
            }
            RFWLog.d("QOK-QFSCommentPermissionUtils", RFWLog.USR, "[loadCommentPermission] callback should not be null.");
            return;
        }
        RFWLog.w("QOK-QFSCommentPermissionUtils", RFWLog.USR, "[loadCommentPermission] error: retCode=" + j3 + "errMsg=" + str2 + "traceId:" + traceId);
    }

    public static void c(final String str, final a aVar) {
        VSNetworkHelper.getInstance().sendRequest(new QFSGetRightInfoRequest(str), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.utils.ax
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str2, Object obj) {
                ay.b(ay.a.this, str, baseRequest, z16, j3, str2, obj);
            }
        });
    }
}
