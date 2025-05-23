package com.tencent.biz.pubaccount.weishi.request;

import UserGrowth.stGetPersonalFeedListReq;
import UserGrowth.stGetPersonalFeedListRsp;
import com.tencent.biz.pubaccount.weishi.net.common.g;
import com.tencent.biz.pubaccount.weishi.util.x;
import java.util.ArrayList;

/* loaded from: classes32.dex */
public class ProfileFeedListRequest extends g<stGetPersonalFeedListRsp> {
    private static final String CMD_STRING = "GetPersonalFeedList";
    private static final String TAG = "PersonalFeedListRequest";

    public ProfileFeedListRequest(String str, String str2, boolean z16, ArrayList<String> arrayList, int i3, int i16) {
        super(CMD_STRING, i3);
        stGetPersonalFeedListReq stgetpersonalfeedlistreq = new stGetPersonalFeedListReq();
        stgetpersonalfeedlistreq.personId = str;
        stgetpersonalfeedlistreq.attach_info = str2;
        stgetpersonalfeedlistreq.isFirst = z16;
        stgetpersonalfeedlistreq.context_feedids = arrayList;
        stgetpersonalfeedlistreq.scene = i3;
        stgetpersonalfeedlistreq.reqType = i16;
        this.req = stgetpersonalfeedlistreq;
        x.f(TAG, "stSimpleGetFeedListReq  = " + stgetpersonalfeedlistreq.toString());
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public Class<stGetPersonalFeedListRsp> getRspClass() {
        return stGetPersonalFeedListRsp.class;
    }
}
