package com.qzone.reborn.message.repo;

import NS_MOBILE_FEEDS.mobile_feeds_req;
import com.qzone.common.requestengine.request.WnsRequest;
import com.tencent.common.config.AppSetting;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB!\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/message/repo/QZonePassiveMessageListRequest;", "Lcom/qzone/common/requestengine/request/WnsRequest;", "", "needClientRetry", "", "requestType", "fromNotify", "", "attachInfo", "<init>", "(IZLjava/lang/String;)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZonePassiveMessageListRequest extends WnsRequest {
    private static final String CMD_STRING_GTE_PASSIVE_FEEDS = "getPassiveFeeds";

    public QZonePassiveMessageListRequest(int i3, boolean z16, String str) {
        super("getPassiveFeeds");
        mobile_feeds_req mobile_feeds_reqVar = new mobile_feeds_req();
        mobile_feeds_reqVar.refresh_type = i3;
        mobile_feeds_reqVar.relation_type = 3;
        mobile_feeds_reqVar.count = 10;
        mobile_feeds_reqVar.attach_info = str == null ? "" : str;
        HashMap hashMap = new HashMap();
        hashMap.put(29, "1");
        int f16 = AppSetting.f();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(f16);
        hashMap.put(182, sb5.toString());
        hashMap.put(41, "source=1&from_notify=" + (z16 ? "1" : "0"));
        mobile_feeds_reqVar.busi_param = hashMap;
        this.req = mobile_feeds_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    protected boolean needClientRetry() {
        return true;
    }
}
