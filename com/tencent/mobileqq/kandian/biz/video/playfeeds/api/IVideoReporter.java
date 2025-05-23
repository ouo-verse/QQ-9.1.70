package com.tencent.mobileqq.kandian.biz.video.playfeeds.api;

import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tenpay.realname.RealNameSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H&J\u001c\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u0005H&J\b\u0010\f\u001a\u00020\u0005H&J\u001a\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H&J$\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001a\u00020\u0005H&J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0016\u001a\u00020\u0017H&J6\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010\u001f\u001a\u00020\u00192\b\u0010 \u001a\u0004\u0018\u00010!H&J4\u0010\"\u001a\u00020\u00192\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010#\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&H&J<\u0010'\u001a\u0004\u0018\u00010\u00032\b\u0010(\u001a\u0004\u0018\u00010\u00032\b\u0010)\u001a\u0004\u0018\u00010\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u00032\b\u0010*\u001a\u0004\u0018\u00010\u00032\b\u0010+\u001a\u0004\u0018\u00010\tH&J\u0014\u0010'\u001a\u0004\u0018\u00010\u00032\b\u0010+\u001a\u0004\u0018\u00010\tH&\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoReporter;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "addJump2ChannelAndVieoSessionID2R5", "", "jump2ChannelValue", "", "videoSessionId", "r5JsonStr", "addKanDianTagForWeishiReport", "Lorg/json/JSONObject;", "r5", "companyId", "getKandianModel4Report", "getReportVideoType", IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, RealNameSource.EXTRA_KEY_SOURCE_NAME, "getUinMemberNum", "app", "Lcom/tencent/common/app/AppInterface;", "uin", "uinType", "getVideoSessionId", "key", "", "reportClickEvent", "", "cmd", "videoAioUinType", "videoBizSource", "vid", "r4", "reportVideoStructMsgRecv", "mr", "Lcom/tencent/mobileqq/data/MessageRecord;", "reportVideoStructMsgSendSuc", QQBrowserActivity.KEY_MSG_TYPE, "peerUin", "uniseq", "", "videoReportBaseR5", "md5", IPublicAccountBrowser.KEY_PUB_UIN, "aid", "extR5", "kandian-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IVideoReporter extends QRouteApi {
    @Nullable
    String addJump2ChannelAndVieoSessionID2R5(int jump2ChannelValue, @Nullable String videoSessionId, @Nullable String r5JsonStr);

    @Nullable
    JSONObject addKanDianTagForWeishiReport(@Nullable JSONObject r56, int companyId);

    int getKandianModel4Report();

    int getReportVideoType(int busiType, @Nullable String sourceName);

    int getUinMemberNum(@Nullable AppInterface app, @Nullable String uin, int uinType);

    @Nullable
    String getVideoSessionId(@NotNull Object key);

    void reportClickEvent(@Nullable String cmd, int videoAioUinType, int videoBizSource, @Nullable String vid, @Nullable String r46);

    void reportVideoStructMsgRecv(@Nullable MessageRecord mr5);

    void reportVideoStructMsgSendSuc(@Nullable AppInterface app, int msgType, @Nullable String peerUin, int uinType, long uniseq);

    @Nullable
    String videoReportBaseR5(@Nullable String md5, @Nullable String puin, @Nullable String vid, @Nullable String aid, @Nullable JSONObject extR5);

    @Nullable
    String videoReportBaseR5(@Nullable JSONObject extR5);
}
