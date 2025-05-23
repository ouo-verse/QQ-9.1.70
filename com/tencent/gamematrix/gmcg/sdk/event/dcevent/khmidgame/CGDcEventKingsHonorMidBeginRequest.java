package com.tencent.gamematrix.gmcg.sdk.event.dcevent.khmidgame;

import androidx.annotation.NonNull;
import com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest;
import com.tencent.gamematrix.gmcg.api.a;
import com.tencent.gamematrix.gmcg.api.constant.GmCgDcEventDefine;
import com.tencent.gamematrix.gmcg.base.helper.CGNestedJsonBuilder;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.utils.CGRandomUtil;
import com.tencent.gamematrix.gmcg.base.utils.CGSystemUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGDcEventKingsHonorMidBeginRequest implements GmCgDcEventRequest {
    private final CGKingsHonorMidGameConfig mCGKingsHonorMidGameConfig;
    public final long seq = System.currentTimeMillis();

    public CGDcEventKingsHonorMidBeginRequest(@NonNull CGKingsHonorMidGameConfig cGKingsHonorMidGameConfig) {
        this.mCGKingsHonorMidGameConfig = cGKingsHonorMidGameConfig;
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest
    public String generateDcEventDataToSend() {
        long random = CGRandomUtil.random(9);
        String encryptMd5 = CGSystemUtil.encryptMd5((random + this.mCGKingsHonorMidGameConfig.bizKey).getBytes());
        CGLog.e("encrypt biz key: " + encryptMd5);
        return new CGNestedJsonBuilder().put(QCircleScheme.AttrQQPublish.ADVERTISE_BIZ_ID, this.mCGKingsHonorMidGameConfig.bizId).put("sub_biz_id", this.mCGKingsHonorMidGameConfig.subBizId).put("biz_key", encryptMd5).put("nonce", Long.valueOf(random)).wrapUp("context", true).put("guid", this.mCGKingsHonorMidGameConfig.guid).put("entrance_id", this.mCGKingsHonorMidGameConfig.midGameId).put("login_platform", Integer.valueOf(this.mCGKingsHonorMidGameConfig.loginPlatform)).put("open_id", this.mCGKingsHonorMidGameConfig.openId).put("activity_id", this.mCGKingsHonorMidGameConfig.tag).put("midgame_id", this.mCGKingsHonorMidGameConfig.midGameId).put("tag", this.mCGKingsHonorMidGameConfig.tag).wrapUp("data", false).put("type", GmCgDcEventDefine.HK_EVENT_MIDGAME_BEGIN).put("seq", Long.valueOf(this.seq)).put("ack", (Integer) 0).put("retry_times", Integer.valueOf(this.mCGKingsHonorMidGameConfig.retryTimes)).wrapUp("event", true).wrapUp("data", false).put("cmd", GmCgDcEventDefine.HK_EVENT_CLIENT_NOTIFY).wrapUp("androidEvent", false).put("cmd", GmCgDcEventDefine.CMD_ANDROID_EVENT).build().toString();
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest
    public String provideDcEventCmd() {
        return GmCgDcEventDefine.CMD_ANDROID_EVENT;
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest
    public /* synthetic */ int provideDcEventSeq() {
        return a.a(this);
    }
}
