package com.tencent.biz.pubaccount.weishi.request.newreq;

import UserGrowth.stSimpleGetFeedListReq;
import UserGrowth.stSimpleGetFeedListRsp;
import com.tencent.biz.pubaccount.weishi.net.common.g;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016J\u001c\u0010\t\u001a\u00020\b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u0016R\u0017\u0010\u000b\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/request/newreq/WSOneMoreFeedRequest;", "Lcom/tencent/biz/pubaccount/weishi/net/common/g;", "LUserGrowth/stSimpleGetFeedListRsp;", "Ljava/lang/Class;", "getRspClass", "", "", "mapExt", "", "onBuildHeaderMapExt", "", "scene", "I", "getScene", "()I", "feedId", "Ljava/lang/String;", "getFeedId", "()Ljava/lang/String;", "<init>", "(ILjava/lang/String;)V", "Companion", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSOneMoreFeedRequest extends g<stSimpleGetFeedListRsp> {
    private static final String CMD_STRING = "SimpleGetFeedList";
    private static final String KEY_TRIGGER_ONE_MORE_FEED_ID = "one_more_feedid";
    private final String feedId;
    private final int scene;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WSOneMoreFeedRequest(int i3, String feedId) {
        super(CMD_STRING, i3);
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        this.scene = i3;
        this.feedId = feedId;
        stSimpleGetFeedListReq stsimplegetfeedlistreq = new stSimpleGetFeedListReq();
        stsimplegetfeedlistreq.scene = i3;
        this.req = stsimplegetfeedlistreq;
    }

    public final String getFeedId() {
        return this.feedId;
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public Class<stSimpleGetFeedListRsp> getRspClass() {
        return stSimpleGetFeedListRsp.class;
    }

    public final int getScene() {
        return this.scene;
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public void onBuildHeaderMapExt(Map<String, String> mapExt) {
        Intrinsics.checkNotNullParameter(mapExt, "mapExt");
        super.onBuildHeaderMapExt(mapExt);
        mapExt.put(KEY_TRIGGER_ONE_MORE_FEED_ID, this.feedId);
    }
}
