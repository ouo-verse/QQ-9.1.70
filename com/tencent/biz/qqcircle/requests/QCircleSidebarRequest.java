package com.tencent.biz.qqcircle.requests;

import java.io.IOException;
import java.util.HashMap;
import okio.ByteString;
import trpcprotocol.feedcloud.sidebar.GetSidebarReq;
import trpcprotocol.feedcloud.sidebar.GetSidebarRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleSidebarRequest extends QCircleBaseRequest {
    public static final String KEY_EXT_MESSAGE_INSERT_LIVE = "message_insert_live";
    byte[] mLiveMessageCommonExt;
    byte[] mPrivateMessageAttachInfo;

    public QCircleSidebarRequest(byte[] bArr, byte[] bArr2) {
        this.mPrivateMessageAttachInfo = bArr;
        this.mLiveMessageCommonExt = bArr2;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.sidebar.Sidebar.GetSidebar";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        GetSidebarReq.a aVar = new GetSidebarReq.a();
        HashMap hashMap = new HashMap();
        byte[] bArr = this.mPrivateMessageAttachInfo;
        if (bArr != null && bArr.length > 0) {
            hashMap.put("private_msg", ByteString.of(bArr));
        }
        byte[] bArr2 = this.mLiveMessageCommonExt;
        if (bArr2 != null && bArr2.length > 0) {
            hashMap.put(KEY_EXT_MESSAGE_INSERT_LIVE, ByteString.of(bArr2));
        }
        if (hashMap.size() > 0) {
            aVar.b(hashMap);
        }
        return aVar.build().encode();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public GetSidebarRsp decode(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return GetSidebarRsp.ADAPTER.decode(bArr);
        } catch (IOException e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
