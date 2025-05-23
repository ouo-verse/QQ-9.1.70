package com.tencent.mobileqq.mini.server.request;

import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.mini.server.BaseMiniAppSSORequest;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.trpcprotocol.minigame.sdk_qgroup_svr.sdk_qgroup_svr.JoinGroupReq;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/mini/server/request/JoinGroupByTagsRequest;", "Lcom/tencent/mobileqq/mini/server/BaseMiniAppSSORequest;", "appId", "", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "", "(Ljava/lang/String;[Ljava/lang/String;)V", "[Ljava/lang/String;", "getCmd", "getRequestData", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class JoinGroupByTagsRequest implements BaseMiniAppSSORequest {
    private final String appId;
    private final String[] tags;

    public JoinGroupByTagsRequest(String appId, String[] tags) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(tags, "tags");
        this.appId = appId;
        this.tags = tags;
    }

    @Override // com.tencent.mobileqq.mini.server.BaseMiniAppSSORequest
    public String getCmd() {
        return "miniapp.trpc.minigame.sdk_qgroup_svr.sdk_qgroup_svr.JoinGroup";
    }

    @Override // com.tencent.mobileqq.mini.server.BaseMiniAppSSORequest
    public byte[] getRequestData() {
        List<String> asList;
        JoinGroupReq joinGroupReq = new JoinGroupReq();
        joinGroupReq.appid.set(this.appId);
        PBRepeatField<String> pBRepeatField = joinGroupReq.tags;
        asList = ArraysKt___ArraysJvmKt.asList(this.tags);
        pBRepeatField.set(asList);
        byte[] byteArray = joinGroupReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        return byteArray;
    }
}
