package com.qzone.reborn.intimate.request;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oj.a;
import qzone.QZIntimateProfileReader$ClientCreateISpacesReq;
import qzone.QZIntimateProfileReader$ClientCreateISpacesRsp;
import qzone.QZoneBaseMeta$StUser;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u001d\u0010\f\u001a\u0002H\r\"\u0004\b\u0000\u0010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016\u00a2\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/qzone/reborn/intimate/request/QZoneIntimateActivateSpaceRequest;", "Lcom/qzone/reborn/intimate/request/QZoneIntimateBaseRequest;", "users", "", "Lqzone/QZoneBaseMeta$StUser;", "spaceType", "", "anniversary", "", "(Ljava/util/List;IJ)V", "activateSpaceRequest", "Lqzone/QZIntimateProfileReader$ClientCreateISpacesReq;", "decode", "T", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getCmdName", "", "getRequestByteData", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneIntimateActivateSpaceRequest extends QZoneIntimateBaseRequest {
    private QZIntimateProfileReader$ClientCreateISpacesReq activateSpaceRequest;

    public QZoneIntimateActivateSpaceRequest(List<QZoneBaseMeta$StUser> users, int i3, long j3) {
        Intrinsics.checkNotNullParameter(users, "users");
        QZIntimateProfileReader$ClientCreateISpacesReq qZIntimateProfileReader$ClientCreateISpacesReq = new QZIntimateProfileReader$ClientCreateISpacesReq();
        this.activateSpaceRequest = qZIntimateProfileReader$ClientCreateISpacesReq;
        qZIntimateProfileReader$ClientCreateISpacesReq.users.set(a.f423008a.q(users));
        this.activateSpaceRequest.type.set(i3);
        if (j3 > 0) {
            this.activateSpaceRequest.anniversary.set(j3);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [qzone.QZIntimateProfileReader$ClientCreateISpacesRsp, T, com.tencent.mobileqq.pb.MessageMicro] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new QZIntimateProfileReader$ClientCreateISpacesRsp();
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "IntimateSpace.trpc.qzone.intimate_space_profileaccess.SpaceprofileAccess.ClientCreateISpaces";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        byte[] byteArray = this.activateSpaceRequest.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "activateSpaceRequest.toByteArray()");
        return byteArray;
    }
}
