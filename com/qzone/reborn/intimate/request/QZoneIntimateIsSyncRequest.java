package com.qzone.reborn.intimate.request;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.state.data.SquareJSConst;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceWriter$StIsQzoneSyncIntimateReq;
import qzone.QZIntimateSpaceWriter$StIsQzoneSyncIntimateRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u001d\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001f\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lcom/qzone/reborn/intimate/request/QZoneIntimateIsSyncRequest;", "Lcom/qzone/reborn/intimate/request/QZoneIntimateBaseRequest;", "", "getRequestByteData", "", "getCmdName", "T", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "Lqzone/QZIntimateSpaceWriter$StIsQzoneSyncIntimateReq;", "mSpaceReq", "Lqzone/QZIntimateSpaceWriter$StIsQzoneSyncIntimateReq;", "mContent", "", SquareJSConst.Params.PARAMS_UIN_LIST, "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneIntimateIsSyncRequest extends QZoneIntimateBaseRequest {
    public static final String TAG = "QZoneIntimateGetISpaceListRequest";
    private QZIntimateSpaceWriter$StIsQzoneSyncIntimateReq mSpaceReq;

    public QZoneIntimateIsSyncRequest(String mContent, List<String> uinList) {
        Intrinsics.checkNotNullParameter(mContent, "mContent");
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        QZIntimateSpaceWriter$StIsQzoneSyncIntimateReq qZIntimateSpaceWriter$StIsQzoneSyncIntimateReq = new QZIntimateSpaceWriter$StIsQzoneSyncIntimateReq();
        this.mSpaceReq = qZIntimateSpaceWriter$StIsQzoneSyncIntimateReq;
        qZIntimateSpaceWriter$StIsQzoneSyncIntimateReq.content.set(mContent);
        Iterator<T> it = uinList.iterator();
        while (it.hasNext()) {
            this.mSpaceReq.uin.add((String) it.next());
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, qzone.QZIntimateSpaceWriter$StIsQzoneSyncIntimateRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new QZIntimateSpaceWriter$StIsQzoneSyncIntimateRsp();
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "IntimateSpace.trpc.qzone.intimate_space_commwriter.ComWriter.IsQzoneSyncIntimate";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.mSpaceReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "mSpaceReq.toByteArray()");
        return byteArray;
    }
}
