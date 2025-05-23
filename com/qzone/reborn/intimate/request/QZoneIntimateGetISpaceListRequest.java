package com.qzone.reborn.intimate.request;

import com.qzone.reborn.intimate.bean.init.QZoneIntimateManageInitBean;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateProfileReader$GetISpaceListReq;
import qzone.QZIntimateProfileReader$GetISpaceListRsp;
import qzone.QZoneBaseMeta$StUser;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u001d\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/qzone/reborn/intimate/request/QZoneIntimateGetISpaceListRequest;", "Lcom/qzone/reborn/intimate/request/QZoneIntimateBaseRequest;", "initBean", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateManageInitBean;", "(Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateManageInitBean;)V", Const.BUNDLE_KEY_REQUEST, "Lqzone/QZIntimateProfileReader$GetISpaceListReq;", "decode", "T", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getCmdName", "", "getRequestByteData", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneIntimateGetISpaceListRequest extends QZoneIntimateBaseRequest {
    private final QZIntimateProfileReader$GetISpaceListReq request;

    public QZoneIntimateGetISpaceListRequest(QZoneIntimateManageInitBean qZoneIntimateManageInitBean) {
        QZIntimateProfileReader$GetISpaceListReq qZIntimateProfileReader$GetISpaceListReq = new QZIntimateProfileReader$GetISpaceListReq();
        this.request = qZIntimateProfileReader$GetISpaceListReq;
        if (qZoneIntimateManageInitBean != null) {
            QZoneBaseMeta$StUser qZoneBaseMeta$StUser = new QZoneBaseMeta$StUser();
            qZoneBaseMeta$StUser.uid.set(qZoneIntimateManageInitBean.getUid());
            qZIntimateProfileReader$GetISpaceListReq.user.set(qZoneBaseMeta$StUser);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, qzone.QZIntimateProfileReader$GetISpaceListRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new QZIntimateProfileReader$GetISpaceListRsp();
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "IntimateSpace.trpc.qzone.intimate_space_profileaccess.SpaceprofileAccess.GetISpaceManegePage";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.request.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "request.toByteArray()");
        return byteArray;
    }
}
