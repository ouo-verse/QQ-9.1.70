package com.tencent.biz.pubaccount.weishi.request.newreq;

import UserGrowth.stExposureFeedInfo;
import UserGrowth.stSimpleGetFeedListReq;
import UserGrowth.stSimpleGetFeedListRsp;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.config.experiment.e;
import com.tencent.biz.pubaccount.weishi.net.common.g;
import com.tencent.biz.pubaccount.weishi.util.WeishiLinkUtil;
import com.tencent.biz.pubaccount.weishi.util.bb;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSRecommendRequest extends g<stSimpleGetFeedListRsp> {
    private static final String CMD_STRING = "SimpleGetFeedList";
    private static final String TAG = "RecommendRequest";

    public WSRecommendRequest(String str, byte b16, byte b17, ArrayList<String> arrayList, int i3, String str2, String str3, String str4, String str5, String str6, ArrayList<stExposureFeedInfo> arrayList2, Map<String, Integer> map, byte[] bArr) {
        super(CMD_STRING, i3);
        stSimpleGetFeedListReq stsimplegetfeedlistreq = new stSimpleGetFeedListReq();
        stsimplegetfeedlistreq.attach_info = str;
        stsimplegetfeedlistreq.isrefresh = b16;
        stsimplegetfeedlistreq.isfirst = b17;
        stsimplegetfeedlistreq.channel_info = "from_android_qq";
        stsimplegetfeedlistreq.context_feedids = arrayList;
        stsimplegetfeedlistreq.scene = i3;
        stsimplegetfeedlistreq.gdt_args = str2;
        stsimplegetfeedlistreq.rowkey = str3;
        stsimplegetfeedlistreq.session = str4;
        stsimplegetfeedlistreq.push_info = str5;
        stsimplegetfeedlistreq.linkStragetyArgs = WeishiLinkUtil.i();
        stsimplegetfeedlistreq.qqNum = bb.y();
        stsimplegetfeedlistreq.subTabID = str6;
        stsimplegetfeedlistreq.exposureFeedList = arrayList2;
        stsimplegetfeedlistreq.feedsVideoType = map;
        stsimplegetfeedlistreq.waterAdReq = bArr;
        this.req = stsimplegetfeedlistreq;
        this.mIsFirst = b17 == 1;
        this.mIsRefresh = b16 == 1;
        this.mRequestSubId = str6;
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public boolean canRequestRetry() {
        return true;
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public String getExpABTestDataStr() {
        if (this.mReqScene == 8) {
            return e.c().b();
        }
        return super.getExpABTestDataStr();
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public Class<stSimpleGetFeedListRsp> getRspClass() {
        return stSimpleGetFeedListRsp.class;
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public boolean isNeedLaunchCalculator() {
        return this.mReqScene == 1 && isFirst() && (TextUtils.equals(this.mRequestSubId, "1000") || TextUtils.isEmpty(this.mRequestSubId));
    }
}
