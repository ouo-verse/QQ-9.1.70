package com.qzone.reborn.publicaccount;

import android.text.TextUtils;
import android.util.Log;
import com.qzone.reborn.base.QZoneBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzone.pb.QZoneOfficialAccount$GetMessageListReq;
import com.tencent.qzone.pb.QZoneOfficialAccount$GetMessageListRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0011\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u001d\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/qzone/reborn/publicaccount/QZonePublicAccountMsgListRequest;", "Lcom/qzone/reborn/base/QZoneBaseRequest;", "", "getRequestByteData", "", "getCmdName", "getRequestByteKey", "T", WebViewPlugin.KEY_RESPONSE, "decode", "([B)Ljava/lang/Object;", "Lcom/tencent/qzone/pb/QZoneOfficialAccount$GetMessageListReq;", "mRequest", "Lcom/tencent/qzone/pb/QZoneOfficialAccount$GetMessageListReq;", "attachInfo", "<init>", "(Ljava/lang/String;)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZonePublicAccountMsgListRequest extends QZoneBaseRequest {
    private final QZoneOfficialAccount$GetMessageListReq mRequest;

    public QZonePublicAccountMsgListRequest(String str) {
        QZoneOfficialAccount$GetMessageListReq qZoneOfficialAccount$GetMessageListReq = new QZoneOfficialAccount$GetMessageListReq();
        this.mRequest = qZoneOfficialAccount$GetMessageListReq;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        qZoneOfficialAccount$GetMessageListReq.attach_info.set(str);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, com.tencent.mobileqq.pb.MessageMicro, com.tencent.qzone.pb.QZoneOfficialAccount$GetMessageListRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] responseData) {
        Intrinsics.checkNotNullParameter(responseData, "responseData");
        ?? r06 = (T) new QZoneOfficialAccount$GetMessageListRsp();
        try {
            r06.mergeFrom(responseData);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QZonePublicAccountMsgListRequest", 1, "decode error: ", Log.getStackTraceString(e16));
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "QzoneV3Service.trpc.qzone.official_account.QzoneOfficialAccountService.GetMessageList";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.mRequest.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "mRequest.toByteArray()");
        return byteArray;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public byte[] getRequestByteKey() {
        return getRequestByteData();
    }
}
