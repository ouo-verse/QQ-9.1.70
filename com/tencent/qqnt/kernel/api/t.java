package com.tencent.qqnt.kernel.api;

import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqnt.kernel.nativeinterface.IGetGuildBinaryDataCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGuildGroupBubbleCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGuestGetMsgAbstractsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGuestMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGuildMatchedOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgListener;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MatchKey;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.SceneInfoParam;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\u001c\u0010\u000b\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH&J,\u0010\u0016\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&J<\u0010\u001a\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u001e\u0010\u0019\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0017j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u0001`\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH&JB\u0010#\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u0017j\b\u0012\u0004\u0012\u00020\u001e`\u00182\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\"H&J\u001c\u0010%\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010$H&J\u001a\u0010&\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\"H&J\"\u0010)\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010(H&J\"\u0010+\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\"H&J\u0010\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u001bH&J\u0010\u0010.\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u001bH&J\u0010\u0010/\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u001bH&J\u0010\u00100\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u001bH&J,\u00105\u001a\u00020\u00042\"\u00104\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020201j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u000202`3H&J$\u00108\u001a\u00020\u00042\b\u00106\u001a\u0004\u0018\u0001022\u0010\u00107\u001a\f\u0012\u0006\u0012\u0004\u0018\u000102\u0018\u00010\u0017H&J\u0012\u00109\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&J\u001c\u0010<\u001a\u00020\u00042\b\u0010;\u001a\u0004\u0018\u00010:2\b\u0010\u0015\u001a\u0004\u0018\u00010\"H&J0\u0010?\u001a\u00020\u00042\u0006\u00106\u001a\u0002022\f\u00107\u001a\b\u0012\u0004\u0012\u0002020\u00172\u0006\u0010=\u001a\u00020\u001b2\b\u0010\n\u001a\u0004\u0018\u00010>H&J<\u0010D\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010@\u001a\u00020\u00112\u0006\u0010A\u001a\u00020\u001b2\u0006\u0010B\u001a\u00020\f2\u0006\u0010=\u001a\u00020\u001b2\b\u0010\n\u001a\u0004\u0018\u00010CH&J2\u0010G\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0016\u0010F\u001a\u0012\u0012\u0004\u0012\u00020E0\u0017j\b\u0012\u0004\u0012\u00020E`\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\"H&\u00a8\u0006H"}, d2 = {"Lcom/tencent/qqnt/kernel/api/t;", "Lcom/tencent/qqnt/kernel/api/j;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGuildMsgListener;", "listener", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "startGuildMsgSync", "Lcom/tencent/qqnt/kernel/nativeinterface/MatchKey;", "matchKey", "Lcom/tencent/qqnt/kernel/nativeinterface/IGuildMatchedOperateCallback;", "result", "isGuildChannelSync", "", WSPublicAccReport.SOP_NAME_FOCUS, "setFocusOnGuild", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "", "beginSeq", "endSeq", "Lcom/tencent/qqnt/kernel/nativeinterface/IMsgOperateCallback;", "cb", "getMsgsBySeqRange", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "seqList", "getMsgsBySeqList", "", "scenes", "onScenesChangeForSilenceMode", "Lcom/tencent/qqnt/kernel/nativeinterface/SceneInfoParam;", "sceneInfo", "isLocal", "isDelete", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "setGroupGuildMsgRead", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGuildBinaryDataCallback;", "getGuildGroupTransData", "setGroupGuildBubbleRead", "needFetch", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGuildGroupBubbleCallback;", "getGuildGroupBubble", "needSummary", "fetchGroupGuildUnread", "flag", "setGroupGuildFlag", "setGuildUDCFlag", "setGuildTabUserFlag", "setBuildMode", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "map", "setConfigurationServiceData", "guildId", "channelIds", "refreshMsgAbstracts", "getChannelFreqLimitInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msg", "insertGameResultAsMsgToDb", QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, "Lcom/tencent/qqnt/kernel/nativeinterface/IGuestGetMsgAbstractsCallback;", "getGuestMsgAbstracts", "startSeq", "cnt", "queryOrder", "Lcom/tencent/qqnt/kernel/nativeinterface/IGuestMsgOperateCallback;", "getGuestMsgByRange", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElements", "sendSummonMsg", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface t extends j {
    void fetchGroupGuildUnread(@NotNull Contact peer, boolean needSummary, @Nullable IOperateCallback cb5);

    void getChannelFreqLimitInfo(@Nullable Contact peer);

    void getGuestMsgAbstracts(@NotNull String guildId, @NotNull ArrayList<String> channelIds, int random, @Nullable IGuestGetMsgAbstractsCallback result);

    void getGuestMsgByRange(@Nullable Contact peer, long startSeq, int cnt, boolean queryOrder, int random, @Nullable IGuestMsgOperateCallback result);

    void getGuildGroupBubble(@NotNull Contact peer, boolean needFetch, @Nullable IGetGuildGroupBubbleCallback cb5);

    void getGuildGroupTransData(@Nullable Contact peer, @Nullable IGetGuildBinaryDataCallback cb5);

    void getMsgsBySeqList(@Nullable Contact peer, @Nullable ArrayList<Long> seqList, @Nullable IMsgOperateCallback cb5);

    void getMsgsBySeqRange(@Nullable Contact peer, long beginSeq, long endSeq, @Nullable IMsgOperateCallback cb5);

    void insertGameResultAsMsgToDb(@Nullable MsgRecord msg2, @Nullable IOperateCallback cb5);

    void isGuildChannelSync(@Nullable MatchKey matchKey, @Nullable IGuildMatchedOperateCallback result);

    void onScenesChangeForSilenceMode(int scenes);

    void q(@NotNull IKernelGuildMsgListener listener);

    void refreshMsgAbstracts(@Nullable String guildId, @Nullable ArrayList<String> channelIds);

    void sendSummonMsg(@NotNull Contact peer, @NotNull ArrayList<MsgElement> msgElements, @Nullable IOperateCallback cb5);

    void setBuildMode(int flag);

    void setConfigurationServiceData(@NotNull HashMap<Long, String> map);

    void setFocusOnGuild(boolean focus);

    void setGroupGuildBubbleRead(@NotNull Contact peer, @Nullable IOperateCallback cb5);

    void setGroupGuildFlag(int flag);

    void setGroupGuildMsgRead(@NotNull Contact peer, @NotNull ArrayList<SceneInfoParam> sceneInfo, boolean isLocal, boolean isDelete, @Nullable IOperateCallback cb5);

    void setGuildTabUserFlag(int flag);

    void setGuildUDCFlag(int flag);

    void startGuildMsgSync();
}
