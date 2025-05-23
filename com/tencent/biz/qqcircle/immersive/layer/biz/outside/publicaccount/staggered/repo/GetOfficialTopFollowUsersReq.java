package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudOfficialaccount$OfficialTopFollowUsersReq;
import feedcloud.FeedCloudOfficialaccount$OfficialTopFollowUsersRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001f\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/GetOfficialTopFollowUsersReq;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest;", "", "getRequestByteData", "", "getCmdName", "T", "rspData", "decode", "([B)Ljava/lang/Object;", "Lfeedcloud/FeedCloudOfficialaccount$OfficialTopFollowUsersReq;", Const.BUNDLE_KEY_REQUEST, "Lfeedcloud/FeedCloudOfficialaccount$OfficialTopFollowUsersReq;", "<init>", "()V", "Companion", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
final class GetOfficialTopFollowUsersReq extends QCircleBaseRequest {

    @NotNull
    private final FeedCloudOfficialaccount$OfficialTopFollowUsersReq request = new MessageMicro<FeedCloudOfficialaccount$OfficialTopFollowUsersReq>() { // from class: feedcloud.FeedCloudOfficialaccount$OfficialTopFollowUsersReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], FeedCloudOfficialaccount$OfficialTopFollowUsersReq.class);
    };

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, feedcloud.FeedCloudOfficialaccount$OfficialTopFollowUsersRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] rspData) {
        ?? r06 = (T) new FeedCloudOfficialaccount$OfficialTopFollowUsersRsp();
        try {
            r06.mergeFrom(rspData);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("GetOfficialTopFollowUsersReq", 1, "decode error, e=" + e16.getMessage(), e16);
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.officialaccount.OfficialAccount.OfficialTopFollowUsers";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        byte[] byteArray = toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "request.toByteArray()");
        return byteArray;
    }
}
