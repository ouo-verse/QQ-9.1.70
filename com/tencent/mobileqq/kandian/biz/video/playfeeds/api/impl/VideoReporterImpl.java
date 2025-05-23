package com.tencent.mobileqq.kandian.biz.video.playfeeds.api.impl;

import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoReporter;
import com.tenpay.realname.RealNameSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\u001a\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J6\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010 \u001a\u00020\u001a2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J4\u0010#\u001a\u00020\u001a2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010$\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010&\u001a\u00020'H\u0016J<\u0010(\u001a\u0004\u0018\u00010\u00042\b\u0010)\u001a\u0004\u0018\u00010\u00042\b\u0010*\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010+\u001a\u0004\u0018\u00010\u00042\b\u0010,\u001a\u0004\u0018\u00010\nH\u0016J\u0014\u0010(\u001a\u0004\u0018\u00010\u00042\b\u0010,\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/impl/VideoReporterImpl;", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoReporter;", "()V", "addJump2ChannelAndVieoSessionID2R5", "", "jump2ChannelValue", "", "videoSessionId", "r5JsonStr", "addKanDianTagForWeishiReport", "Lorg/json/JSONObject;", "r5", "companyId", "getKandianModel4Report", "getReportVideoType", IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, RealNameSource.EXTRA_KEY_SOURCE_NAME, "getUinMemberNum", "app", "Lcom/tencent/common/app/AppInterface;", "uin", "uinType", "getVideoSessionId", "key", "", "reportClickEvent", "", "cmd", "videoAioUinType", "videoBizSource", "vid", "r4", "reportVideoStructMsgRecv", "mr", "Lcom/tencent/mobileqq/data/MessageRecord;", "reportVideoStructMsgSendSuc", QQBrowserActivity.KEY_MSG_TYPE, "peerUin", "uniseq", "", "videoReportBaseR5", "md5", IPublicAccountBrowser.KEY_PUB_UIN, "aid", "extR5", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class VideoReporterImpl implements IVideoReporter {
    @Override // com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoReporter
    public String addJump2ChannelAndVieoSessionID2R5(int jump2ChannelValue, String videoSessionId, String r5JsonStr) {
        return null;
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoReporter
    public JSONObject addKanDianTagForWeishiReport(JSONObject r56, int companyId) {
        return null;
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoReporter
    public int getKandianModel4Report() {
        return 0;
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoReporter
    public int getReportVideoType(int busiType, String sourceName) {
        return 0;
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoReporter
    public int getUinMemberNum(AppInterface app, String uin, int uinType) {
        return 0;
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoReporter
    public String getVideoSessionId(Object key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return null;
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoReporter
    public String videoReportBaseR5(String md5, String puin, String vid, String aid, JSONObject extR5) {
        return null;
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoReporter
    public String videoReportBaseR5(JSONObject extR5) {
        return null;
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoReporter
    public void reportVideoStructMsgRecv(MessageRecord mr5) {
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoReporter
    public void reportClickEvent(String cmd, int videoAioUinType, int videoBizSource, String vid, String r46) {
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoReporter
    public void reportVideoStructMsgSendSuc(AppInterface app, int msgType, String peerUin, int uinType, long uniseq) {
    }
}
