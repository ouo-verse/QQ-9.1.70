package com.tencent.mobileqq.qqguildsdk.api.impl;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.impl.GProGuildMsgService;
import com.tencent.mobileqq.qqguildsdk.internal.KLog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.FirstViewDirectMsgNotifyInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAvChannelStateMsg;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBeaconEventModel;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBeaconStageModel;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCheckInNotifyInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProContact;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildFeedDraft;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildTopFeedMsg;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProManagerNotice;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProNewPostAndSystemPromptNotifyFeedEventData;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleNotifyInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUnreadCntInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GuildInteractiveNotificationItem;
import com.tencent.qqnt.kernelgpro.nativeinterface.IFetchNavigateInfoCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGuildDraftCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGuildGetMsgAbstractsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildFetchChannelLatestSeqCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildHelperNotifySwitchOperateCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildInteractiveNotificationCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener;
import com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService;
import com.tencent.qqnt.kernelgpro.nativeinterface.IUnreadCntCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstract;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u009d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0006\u0018\u0000 U2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001VB\u0019\u0012\b\u0010P\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010R\u001a\u00020Q\u00a2\u0006\u0004\bS\u0010TJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\tH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\r\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J \u0010\u0016\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u001c\u0010\u0019\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J.\u0010\u001d\u001a\u00020\t2\u001a\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u001c\u0010\u001e\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u001c\u0010\u001f\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u001c\u0010 \u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u001c\u0010\"\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010!H\u0016J\u001c\u0010$\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010#H\u0016J\u001c\u0010(\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010%2\b\u0010\u0018\u001a\u0004\u0018\u00010'H\u0016J\u001c\u0010)\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010'H\u0016J\u001c\u0010*\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010+\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010'H\u0016J<\u0010.\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010%2\u001e\u0010,\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010\u001aj\f\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u0001`\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010-H\u0016J$\u00101\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u00100\u001a\u00020/2\b\u0010\u0018\u001a\u0004\u0018\u00010'H\u0016J\u0012\u00102\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J$\u00103\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u00100\u001a\u00020/2\b\u0010\u0018\u001a\u0004\u0018\u00010'H\u0016J$\u00104\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u00100\u001a\u00020/2\b\u0010\u0018\u001a\u0004\u0018\u00010'H\u0016J6\u00107\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u00105\u001a\u00020\u00142\u001a\u00106\u001a\u0016\u0012\u0004\u0012\u00020/\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020/\u0018\u0001`\u001bH\u0016J \u0010:\u001a\u00020\t2\u0006\u00108\u001a\u00020\u00142\u0006\u00109\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020'H\u0016J\u0010\u0010<\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020;H\u0016J\b\u0010=\u001a\u00020\tH\u0016J$\u0010A\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010>\u001a\u00020\u00142\b\u0010@\u001a\u0004\u0018\u00010?H\u0016J \u0010C\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010B\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020'H\u0016J2\u0010I\u001a\u00020\t2\u0006\u0010D\u001a\u00020%2\u0006\u0010E\u001a\u00020\u00142\u0006\u0010F\u001a\u00020%2\u0006\u0010H\u001a\u00020G2\b\u0010\u0018\u001a\u0004\u0018\u00010'H\u0016J*\u0010K\u001a\u00020\t2\u0006\u0010D\u001a\u00020%2\u0006\u0010E\u001a\u00020\u00142\u0006\u0010F\u001a\u00020%2\b\u0010\u0018\u001a\u0004\u0018\u00010JH\u0016J*\u0010M\u001a\u00020\t2\u0006\u0010L\u001a\u00020%2\u0006\u0010E\u001a\u00020\u00142\u0006\u0010F\u001a\u00020%2\b\u0010\u0018\u001a\u0004\u0018\u00010'H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010O\u00a8\u0006W"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/api/impl/GProGuildMsgService;", "Lcom/tencent/mobileqq/qqguildsdk/api/impl/GProGuildMsgBaseService;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelGProGuildMsgListener;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelGProGuildMsgService;", "Luh2/c;", "listener", "com/tencent/mobileqq/qqguildsdk/api/impl/GProGuildMsgService$b", "P1", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelGProGuildMsgListener;)Lcom/tencent/mobileqq/qqguildsdk/api/impl/GProGuildMsgService$b;", "", "destroy", "r", "msgListener", "w0", "addKernelGProGuildMsgListener", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProContact;", "peer", "", "msgTabFocus", "", "activeStatus", "setFocusSession", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IUnreadCntCallback;", "cb", "G", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "peers", "getUnreadCntInfo", "p", HippyTKDListViewAdapter.X, "P", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGuildFetchChannelLatestSeqCallback;", "getFirstUnreadCommonMsg", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IFetchNavigateInfoCallback;", "getNavigateInfo", "", "guildId", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGuildOperateCallback;", "setGProGuildMsgRead", "setGProMsgRead", "setGProLocalMsgRead", "setGProAllDirectMsgRead", "channelIds", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGuildGetMsgAbstractsCallback;", "getMsgAbstracts", "", "msgId", "E", "getChannelEventFlow", "deleteRecallMsg", "deleteRecallMsgForLocal", "screenType", "msgSeqList", "setCurOnScreenMsg", "noticeType", "value", "setGuildHelperNotifySwitch", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGuildHelperNotifySwitchOperateCallback;", "getGuildHelperNotifySwitch", "forceShowGuildHelperNode", "type", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGuildInteractiveNotificationCallback;", "callback", "getGuildInteractiveNotification", "readScene", "clearGuildReadSceneV2", "guildID", "draftType", "draftKey", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGuildFeedDraft;", "draft", "setGuildFeedDraft", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGuildDraftCallback;", "getGuildFeedDraft", "draftId", "deleteGuildFeedDraft", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelGProGuildMsgListener;", "service", "Lcom/tencent/mobileqq/qqguildsdk/api/impl/ServiceContent;", "content", "<init>", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelGProGuildMsgService;Lcom/tencent/mobileqq/qqguildsdk/api/impl/ServiceContent;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class GProGuildMsgService extends GProGuildMsgBaseService<IKernelGProGuildMsgListener, IKernelGProGuildMsgService> implements uh2.c {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IKernelGProGuildMsgListener msgListener;

    @Metadata(d1 = {"\u0000w\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u0019\u001a\u00020\u00042\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0016J\u001c\u0010\u001e\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\"\u0010\u001f\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0016H\u0016J<\u0010%\u001a\u00020\u000422\u0010$\u001a.\u0012\u0004\u0012\u00020!\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u0016\u0018\u00010 j\u0016\u0012\u0004\u0012\u00020!\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u0016\u0018\u0001`#H\u0016J\u0012\u0010'\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010&H\u0016J\u001e\u0010)\u001a\u00020\u00042\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!\u0018\u00010 H\u0016\u00a8\u0006*"}, d2 = {"com/tencent/mobileqq/qqguildsdk/api/impl/GProGuildMsgService$b", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelGProGuildMsgListener;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/FirstViewDirectMsgNotifyInfo;", "notifyInfo", "", "onFeedEventUpdate", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GuildInteractiveNotificationItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "onGuildInteractiveUpdate", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGuildTopFeedMsg;", "topFeedMsg", "onGuildTopFeedUpdate", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProNewPostAndSystemPromptNotifyFeedEventData;", "data", "onGuildNewPostEvent", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProAvChannelStateMsg;", "onGuildAvChannelOpenUpdate", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProScheduleNotifyInfo;", "onGuildScheduleNotify", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProCheckInNotifyInfo;", "checkInNotifyInfo", "onGuildCheckInNotify", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/MsgAbstract;", "msgAbstractInfos", "onMsgAbstractUpdate", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProBeaconEventModel;", "eventModel", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProBeaconStageModel;", "stage", "onBeaconReportCount", "onBeaconReportStage", "Ljava/util/HashMap;", "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProUnreadCntInfo;", "Lkotlin/collections/HashMap;", "unreadCntInfos", "onUnreadCntUpdate", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProManagerNotice;", "onGuildManagerEventUpdate", "switchValue", "onGuildHelperNotifySwitchUpdate", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements IKernelGProGuildMsgListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IKernelGProGuildMsgListener f265089b;

        b(IKernelGProGuildMsgListener iKernelGProGuildMsgListener) {
            this.f265089b = iKernelGProGuildMsgListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(IKernelGProGuildMsgListener listener, GProBeaconEventModel gProBeaconEventModel, GProBeaconStageModel gProBeaconStageModel) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog.c(KLog.f268416a, "GProGuildMsgService", new Object[]{"onBeaconReportCount"}, null, 4, null);
            listener.onBeaconReportCount(gProBeaconEventModel, gProBeaconStageModel);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o(IKernelGProGuildMsgListener listener, GProBeaconEventModel gProBeaconEventModel, ArrayList arrayList) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog.c(KLog.f268416a, "GProGuildMsgService", new Object[]{"onBeaconReportStage"}, null, 4, null);
            listener.onBeaconReportStage(gProBeaconEventModel, arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void p(IKernelGProGuildMsgListener listener, FirstViewDirectMsgNotifyInfo firstViewDirectMsgNotifyInfo) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog.c(KLog.f268416a, "GProGuildMsgService", new Object[]{"onFeedEventUpdate"}, null, 4, null);
            listener.onFeedEventUpdate(firstViewDirectMsgNotifyInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void q(IKernelGProGuildMsgListener listener, GProAvChannelStateMsg gProAvChannelStateMsg) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog.c(KLog.f268416a, "GProGuildMsgService", new Object[]{"onGuildAvChannelOpenUpdate"}, null, 4, null);
            listener.onGuildAvChannelOpenUpdate(gProAvChannelStateMsg);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void r(IKernelGProGuildMsgListener listener, GProCheckInNotifyInfo gProCheckInNotifyInfo) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog.c(KLog.f268416a, "GProGuildMsgService", new Object[]{"onGuildCheckInNotify"}, null, 4, null);
            listener.onGuildCheckInNotify(gProCheckInNotifyInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void s(IKernelGProGuildMsgListener listener, HashMap hashMap) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog.c(KLog.f268416a, "GProGuildMsgService", new Object[]{"onGuildHelperNotifySwitchUpdate"}, null, 4, null);
            listener.onGuildHelperNotifySwitchUpdate(hashMap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void t(IKernelGProGuildMsgListener listener, GuildInteractiveNotificationItem guildInteractiveNotificationItem) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog.c(KLog.f268416a, "GProGuildMsgService", new Object[]{"onGuildInteractiveUpdate"}, null, 4, null);
            listener.onGuildInteractiveUpdate(guildInteractiveNotificationItem);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void u(IKernelGProGuildMsgListener listener, GProManagerNotice gProManagerNotice) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog.c(KLog.f268416a, "GProGuildMsgService", new Object[]{"onGuildManagerEventUpdate"}, null, 4, null);
            listener.onGuildManagerEventUpdate(gProManagerNotice);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void v(IKernelGProGuildMsgListener listener, GProNewPostAndSystemPromptNotifyFeedEventData data) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            Intrinsics.checkNotNullParameter(data, "$data");
            KLog.c(KLog.f268416a, "GProGuildMsgService", new Object[]{"onGuildNewPostEvent"}, null, 4, null);
            listener.onGuildNewPostEvent(data);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void w(IKernelGProGuildMsgListener listener, GProScheduleNotifyInfo gProScheduleNotifyInfo) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog.c(KLog.f268416a, "GProGuildMsgService", new Object[]{"onGuildScheduleNotify"}, null, 4, null);
            listener.onGuildScheduleNotify(gProScheduleNotifyInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void x(IKernelGProGuildMsgListener listener, GProGuildTopFeedMsg gProGuildTopFeedMsg) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog.c(KLog.f268416a, "GProGuildMsgService", new Object[]{"onGuildTopFeedUpdate"}, null, 4, null);
            listener.onGuildTopFeedUpdate(gProGuildTopFeedMsg);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void y(IKernelGProGuildMsgListener listener, ArrayList arrayList) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog.c(KLog.f268416a, "GProGuildMsgService", new Object[]{"onMsgAbstractUpdate"}, null, 4, null);
            listener.onMsgAbstractUpdate(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void z(IKernelGProGuildMsgListener listener, HashMap hashMap) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog.c(KLog.f268416a, "GProGuildMsgService", new Object[]{"onUnreadCntUpdate"}, null, 4, null);
            listener.onUnreadCntUpdate(hashMap);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public void onBeaconReportCount(@Nullable final GProBeaconEventModel eventModel, @Nullable final GProBeaconStageModel stage) {
            GProGuildMsgService gProGuildMsgService = GProGuildMsgService.this;
            final IKernelGProGuildMsgListener iKernelGProGuildMsgListener = this.f265089b;
            gProGuildMsgService.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.dh
                @Override // java.lang.Runnable
                public final void run() {
                    GProGuildMsgService.b.n(IKernelGProGuildMsgListener.this, eventModel, stage);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public void onBeaconReportStage(@Nullable final GProBeaconEventModel eventModel, @Nullable final ArrayList<GProBeaconStageModel> stage) {
            GProGuildMsgService gProGuildMsgService = GProGuildMsgService.this;
            final IKernelGProGuildMsgListener iKernelGProGuildMsgListener = this.f265089b;
            gProGuildMsgService.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.da
                @Override // java.lang.Runnable
                public final void run() {
                    GProGuildMsgService.b.o(IKernelGProGuildMsgListener.this, eventModel, stage);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public void onFeedEventUpdate(@Nullable final FirstViewDirectMsgNotifyInfo notifyInfo) {
            GProGuildMsgService gProGuildMsgService = GProGuildMsgService.this;
            final IKernelGProGuildMsgListener iKernelGProGuildMsgListener = this.f265089b;
            gProGuildMsgService.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.cx
                @Override // java.lang.Runnable
                public final void run() {
                    GProGuildMsgService.b.p(IKernelGProGuildMsgListener.this, notifyInfo);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public void onGuildAvChannelOpenUpdate(@Nullable final GProAvChannelStateMsg notifyInfo) {
            GProGuildMsgService gProGuildMsgService = GProGuildMsgService.this;
            final IKernelGProGuildMsgListener iKernelGProGuildMsgListener = this.f265089b;
            gProGuildMsgService.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.cy
                @Override // java.lang.Runnable
                public final void run() {
                    GProGuildMsgService.b.q(IKernelGProGuildMsgListener.this, notifyInfo);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public void onGuildCheckInNotify(@Nullable final GProCheckInNotifyInfo checkInNotifyInfo) {
            GProGuildMsgService gProGuildMsgService = GProGuildMsgService.this;
            final IKernelGProGuildMsgListener iKernelGProGuildMsgListener = this.f265089b;
            gProGuildMsgService.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.dc
                @Override // java.lang.Runnable
                public final void run() {
                    GProGuildMsgService.b.r(IKernelGProGuildMsgListener.this, checkInNotifyInfo);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public void onGuildHelperNotifySwitchUpdate(@Nullable final HashMap<Integer, Integer> switchValue) {
            GProGuildMsgService gProGuildMsgService = GProGuildMsgService.this;
            final IKernelGProGuildMsgListener iKernelGProGuildMsgListener = this.f265089b;
            gProGuildMsgService.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.cz
                @Override // java.lang.Runnable
                public final void run() {
                    GProGuildMsgService.b.s(IKernelGProGuildMsgListener.this, switchValue);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public void onGuildInteractiveUpdate(@Nullable final GuildInteractiveNotificationItem item) {
            GProGuildMsgService gProGuildMsgService = GProGuildMsgService.this;
            final IKernelGProGuildMsgListener iKernelGProGuildMsgListener = this.f265089b;
            gProGuildMsgService.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.dg
                @Override // java.lang.Runnable
                public final void run() {
                    GProGuildMsgService.b.t(IKernelGProGuildMsgListener.this, item);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public void onGuildManagerEventUpdate(@Nullable final GProManagerNotice notifyInfo) {
            GProGuildMsgService gProGuildMsgService = GProGuildMsgService.this;
            final IKernelGProGuildMsgListener iKernelGProGuildMsgListener = this.f265089b;
            gProGuildMsgService.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.cv
                @Override // java.lang.Runnable
                public final void run() {
                    GProGuildMsgService.b.u(IKernelGProGuildMsgListener.this, notifyInfo);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public void onGuildNewPostEvent(@NotNull final GProNewPostAndSystemPromptNotifyFeedEventData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            GProGuildMsgService gProGuildMsgService = GProGuildMsgService.this;
            final IKernelGProGuildMsgListener iKernelGProGuildMsgListener = this.f265089b;
            gProGuildMsgService.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.de
                @Override // java.lang.Runnable
                public final void run() {
                    GProGuildMsgService.b.v(IKernelGProGuildMsgListener.this, data);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public void onGuildScheduleNotify(@Nullable final GProScheduleNotifyInfo notifyInfo) {
            GProGuildMsgService gProGuildMsgService = GProGuildMsgService.this;
            final IKernelGProGuildMsgListener iKernelGProGuildMsgListener = this.f265089b;
            gProGuildMsgService.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.cw
                @Override // java.lang.Runnable
                public final void run() {
                    GProGuildMsgService.b.w(IKernelGProGuildMsgListener.this, notifyInfo);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public void onGuildTopFeedUpdate(@Nullable final GProGuildTopFeedMsg topFeedMsg) {
            GProGuildMsgService gProGuildMsgService = GProGuildMsgService.this;
            final IKernelGProGuildMsgListener iKernelGProGuildMsgListener = this.f265089b;
            gProGuildMsgService.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.db
                @Override // java.lang.Runnable
                public final void run() {
                    GProGuildMsgService.b.x(IKernelGProGuildMsgListener.this, topFeedMsg);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public void onMsgAbstractUpdate(@Nullable final ArrayList<MsgAbstract> msgAbstractInfos) {
            GProGuildMsgService gProGuildMsgService = GProGuildMsgService.this;
            final IKernelGProGuildMsgListener iKernelGProGuildMsgListener = this.f265089b;
            gProGuildMsgService.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.dd
                @Override // java.lang.Runnable
                public final void run() {
                    GProGuildMsgService.b.y(IKernelGProGuildMsgListener.this, msgAbstractInfos);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onUnreadCntAfterFirstView(HashMap hashMap) {
            com.tencent.qqnt.kernelgpro.nativeinterface.e.m(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public void onUnreadCntUpdate(@Nullable final HashMap<Integer, ArrayList<GProUnreadCntInfo>> unreadCntInfos) {
            GProGuildMsgService gProGuildMsgService = GProGuildMsgService.this;
            final IKernelGProGuildMsgListener iKernelGProGuildMsgListener = this.f265089b;
            gProGuildMsgService.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.df
                @Override // java.lang.Runnable
                public final void run() {
                    GProGuildMsgService.b.z(IKernelGProGuildMsgListener.this, unreadCntInfos);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GProGuildMsgService(@Nullable IKernelGProGuildMsgService iKernelGProGuildMsgService, @NotNull ServiceContent content) {
        super("GProGuildMsgService", content, iKernelGProGuildMsgService);
        Intrinsics.checkNotNullParameter(content, "content");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b P1(IKernelGProGuildMsgListener listener) {
        return new b(listener);
    }

    @Override // uh2.c
    public void E(@Nullable final GProContact peer, long msgId, @Nullable IGuildOperateCallback cb5) {
        final ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(msgId));
        u1("recallGProMsg", cb5, new Function1<IGuildOperateCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProGuildMsgService$recallGProMsg$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGuildOperateCallback iGuildOperateCallback) {
                IKernelGProGuildMsgService S0 = GProGuildMsgService.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.recallGProMsg(peer, arrayList, iGuildOperateCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // uh2.c
    public void G(@Nullable GProContact peer, @Nullable IUnreadCntCallback cb5) {
        final ArrayList arrayList = new ArrayList();
        if (peer != null) {
            arrayList.add(peer);
            v1("getUnreadCntInfo", cb5, new Function1<IUnreadCntCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProGuildMsgService$getUnreadCntInfo$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IUnreadCntCallback iUnreadCntCallback) {
                    IKernelGProGuildMsgService S0 = GProGuildMsgService.this.S0();
                    if (S0 == null) {
                        return null;
                    }
                    S0.getUnreadCntInfo(arrayList, iUnreadCntCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // uh2.c
    public void P(@Nullable GProContact peer, @Nullable IUnreadCntCallback cb5) {
        final ArrayList arrayList = new ArrayList();
        if (peer != null) {
            arrayList.add(peer);
            v1("getGuildFeedsUnreadCntInfo", cb5, new Function1<IUnreadCntCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProGuildMsgService$getGuildFeedsUnreadCntInfo$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IUnreadCntCallback iUnreadCntCallback) {
                    IKernelGProGuildMsgService S0 = GProGuildMsgService.this.S0();
                    if (S0 == null) {
                        return null;
                    }
                    S0.getGuildFeedsUnreadCntInfo(arrayList, iUnreadCntCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // uh2.c
    public void addKernelGProGuildMsgListener(@NotNull IKernelGProGuildMsgListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        L0(listener, new Function1<IKernelGProGuildMsgListener, Long>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProGuildMsgService$addKernelGProGuildMsgListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Long invoke(@NotNull IKernelGProGuildMsgListener it) {
                GProGuildMsgService.b P1;
                Intrinsics.checkNotNullParameter(it, "it");
                IKernelGProGuildMsgService S0 = GProGuildMsgService.this.S0();
                if (S0 == null) {
                    return null;
                }
                P1 = GProGuildMsgService.this.P1(it);
                return Long.valueOf(S0.addKernelGProGuildMsgListener(P1));
            }
        });
    }

    @Override // uh2.c
    public void clearGuildReadSceneV2(@NotNull final GProContact peer, final int readScene, @NotNull IGuildOperateCallback cb5) {
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        u1("clearGuildReadSceneV2", cb5, new Function1<IGuildOperateCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProGuildMsgService$clearGuildReadSceneV2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGuildOperateCallback iGuildOperateCallback) {
                IKernelGProGuildMsgService S0 = GProGuildMsgService.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.clearGuildReadSceneV2(peer, readScene, iGuildOperateCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // uh2.c
    public void deleteGuildFeedDraft(@NotNull String draftId, int draftType, @NotNull String draftKey, @Nullable final IGuildOperateCallback cb5) {
        Intrinsics.checkNotNullParameter(draftId, "draftId");
        Intrinsics.checkNotNullParameter(draftKey, "draftKey");
        P0("deleteGuildFeedDraft", new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProGuildMsgService$deleteGuildFeedDraft$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                invoke(num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String msg2) {
                Intrinsics.checkNotNullParameter(msg2, "msg");
                IGuildOperateCallback iGuildOperateCallback = IGuildOperateCallback.this;
                if (iGuildOperateCallback != null) {
                    iGuildOperateCallback.onResult(i3, msg2);
                }
            }
        }, new GProGuildMsgService$deleteGuildFeedDraft$2(draftId, draftType, draftKey, this, cb5));
    }

    @Override // uh2.c
    public void deleteRecallMsg(@Nullable final GProContact peer, final long msgId, @Nullable IGuildOperateCallback cb5) {
        u1("deleteRecallMsg", cb5, new Function1<IGuildOperateCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProGuildMsgService$deleteRecallMsg$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGuildOperateCallback iGuildOperateCallback) {
                IKernelGProGuildMsgService S0 = GProGuildMsgService.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.deleteRecallMsg(peer, msgId, iGuildOperateCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // uh2.c
    public void deleteRecallMsgForLocal(@Nullable final GProContact peer, final long msgId, @Nullable IGuildOperateCallback cb5) {
        u1("deleteRecallMsgForLocal", cb5, new Function1<IGuildOperateCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProGuildMsgService$deleteRecallMsgForLocal$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGuildOperateCallback iGuildOperateCallback) {
                IKernelGProGuildMsgService S0 = GProGuildMsgService.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.deleteRecallMsgForLocal(peer, msgId, iGuildOperateCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // uh2.c
    public void destroy() {
        QLog.i("GProGuildMsgService", 1, "destroy");
        IKernelGProGuildMsgListener iKernelGProGuildMsgListener = this.msgListener;
        if (iKernelGProGuildMsgListener != null) {
            BaseService.X0(this, iKernelGProGuildMsgListener, false, new Function1<Long, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProGuildMsgService$destroy$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                    invoke(l3.longValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(long j3) {
                    IKernelGProGuildMsgService S0 = GProGuildMsgService.this.S0();
                    if (S0 != null) {
                        S0.removeKernelGProGuildMsgListener(j3);
                    }
                }
            }, 2, null);
        }
    }

    @Override // uh2.c
    public void forceShowGuildHelperNode() {
        O0("forceShowGuildHelperNode", new Function0<Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProGuildMsgService$forceShowGuildHelperNode$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Unit invoke() {
                IKernelGProGuildMsgService S0 = GProGuildMsgService.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.forceShowGuildHelperNode();
                return Unit.INSTANCE;
            }
        });
    }

    @Override // uh2.c
    public void getChannelEventFlow(@Nullable final GProContact peer) {
        O0("getChannelEventFlow", new Function0<Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProGuildMsgService$getChannelEventFlow$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Unit invoke() {
                IKernelGProGuildMsgService S0 = GProGuildMsgService.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.getChannelEventFlow(peer);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // uh2.c
    public void getFirstUnreadCommonMsg(@Nullable final GProContact peer, @Nullable IGuildFetchChannelLatestSeqCallback cb5) {
        s1("getFirstUnreadCommonMsg", cb5, new Function1<IGuildFetchChannelLatestSeqCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProGuildMsgService$getFirstUnreadCommonMsg$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGuildFetchChannelLatestSeqCallback iGuildFetchChannelLatestSeqCallback) {
                IKernelGProGuildMsgService S0 = GProGuildMsgService.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.getFirstUnreadCommonMsg(peer, iGuildFetchChannelLatestSeqCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // uh2.c
    public void getGuildFeedDraft(@NotNull String guildID, int draftType, @NotNull String draftKey, @Nullable final IGProGuildDraftCallback cb5) {
        Intrinsics.checkNotNullParameter(guildID, "guildID");
        Intrinsics.checkNotNullParameter(draftKey, "draftKey");
        P0("getGuildFeedDraft", new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProGuildMsgService$getGuildFeedDraft$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                invoke(num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String msg2) {
                Intrinsics.checkNotNullParameter(msg2, "msg");
                IGProGuildDraftCallback iGProGuildDraftCallback = IGProGuildDraftCallback.this;
                if (iGProGuildDraftCallback != null) {
                    iGProGuildDraftCallback.onResult(i3, msg2, null);
                }
            }
        }, new GProGuildMsgService$getGuildFeedDraft$2(guildID, draftType, draftKey, this, cb5));
    }

    @Override // uh2.c
    public void getGuildHelperNotifySwitch(@NotNull final IGuildHelperNotifySwitchOperateCallback cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        O0("getGuildHelperNotifySwitch", new Function0<Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProGuildMsgService$getGuildHelperNotifySwitch$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Unit invoke() {
                IKernelGProGuildMsgService S0 = GProGuildMsgService.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.getGuildHelperNotifySwitch(cb5);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // uh2.c
    public void getGuildInteractiveNotification(@Nullable final String guildId, final int type, @Nullable IGuildInteractiveNotificationCallback callback) {
        t1("getGuildInteractiveNotification", callback, new Function1<IGuildInteractiveNotificationCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProGuildMsgService$getGuildInteractiveNotification$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGuildInteractiveNotificationCallback iGuildInteractiveNotificationCallback) {
                IKernelGProGuildMsgService S0 = GProGuildMsgService.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.getGuildInteractiveNotification(guildId, type, iGuildInteractiveNotificationCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // uh2.c
    public void getMsgAbstracts(@Nullable final String guildId, @Nullable final ArrayList<String> channelIds, @Nullable IGProGuildGetMsgAbstractsCallback cb5) {
        r1("getMsgAbstracts", cb5, new Function1<IGProGuildGetMsgAbstractsCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProGuildMsgService$getMsgAbstracts$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGProGuildGetMsgAbstractsCallback iGProGuildGetMsgAbstractsCallback) {
                IKernelGProGuildMsgService S0 = GProGuildMsgService.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.getMsgAbstracts(guildId, channelIds, iGProGuildGetMsgAbstractsCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // uh2.c
    public void getNavigateInfo(@Nullable final GProContact peer, @Nullable IFetchNavigateInfoCallback cb5) {
        q1("getNavigateInfo", cb5, new Function1<IFetchNavigateInfoCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProGuildMsgService$getNavigateInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IFetchNavigateInfoCallback iFetchNavigateInfoCallback) {
                IKernelGProGuildMsgService S0 = GProGuildMsgService.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.getNavigateInfo(peer, iFetchNavigateInfoCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // uh2.c
    public void getUnreadCntInfo(@Nullable final ArrayList<GProContact> peers, @Nullable IUnreadCntCallback cb5) {
        v1("getUnreadCntInfo", cb5, new Function1<IUnreadCntCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProGuildMsgService$getUnreadCntInfo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IUnreadCntCallback iUnreadCntCallback) {
                IKernelGProGuildMsgService S0 = GProGuildMsgService.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.getUnreadCntInfo(peers, iUnreadCntCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // uh2.c
    public void p(@Nullable GProContact peer, @Nullable IUnreadCntCallback cb5) {
        final ArrayList arrayList = new ArrayList();
        if (peer != null) {
            arrayList.add(peer);
            v1("getGuildUnreadCntInfo", cb5, new Function1<IUnreadCntCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProGuildMsgService$getGuildUnreadCntInfo$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IUnreadCntCallback iUnreadCntCallback) {
                    IKernelGProGuildMsgService S0 = GProGuildMsgService.this.S0();
                    if (S0 == null) {
                        return null;
                    }
                    S0.getGuildUnreadCntInfo(arrayList, iUnreadCntCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // uh2.c
    @Nullable
    /* renamed from: r, reason: from getter */
    public IKernelGProGuildMsgListener getMsgListener() {
        return this.msgListener;
    }

    @Override // uh2.c
    public void setCurOnScreenMsg(@Nullable final GProContact peer, final int screenType, @Nullable final ArrayList<Long> msgSeqList) {
        O0("setCurOnScreenMsg", new Function0<Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProGuildMsgService$setCurOnScreenMsg$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Unit invoke() {
                IKernelGProGuildMsgService S0 = GProGuildMsgService.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.setCurOnScreenMsg(peer, screenType, msgSeqList);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // uh2.c
    public void setFocusSession(@NotNull final GProContact peer, final boolean msgTabFocus, final int activeStatus) {
        Intrinsics.checkNotNullParameter(peer, "peer");
        O0("setFocusSession", new Function0<Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProGuildMsgService$setFocusSession$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Unit invoke() {
                IKernelGProGuildMsgService S0 = GProGuildMsgService.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.setFocusSession(peer, msgTabFocus, activeStatus);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // uh2.c
    public void setGProAllDirectMsgRead(@Nullable IGuildOperateCallback cb5) {
        u1("setGProAllDirectMsgRead", cb5, new Function1<IGuildOperateCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProGuildMsgService$setGProAllDirectMsgRead$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGuildOperateCallback iGuildOperateCallback) {
                IKernelGProGuildMsgService S0 = GProGuildMsgService.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.setGProAllDirectMsgRead(iGuildOperateCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // uh2.c
    public void setGProGuildMsgRead(@Nullable final String guildId, @Nullable IGuildOperateCallback cb5) {
        u1("setGProGuildMsgRead", cb5, new Function1<IGuildOperateCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProGuildMsgService$setGProGuildMsgRead$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGuildOperateCallback iGuildOperateCallback) {
                IKernelGProGuildMsgService S0 = GProGuildMsgService.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.setGProGuildMsgRead(guildId, iGuildOperateCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // uh2.c
    public void setGProLocalMsgRead(@Nullable final GProContact peer, @Nullable IGuildOperateCallback cb5) {
        u1("setGProLocalMsgRead", cb5, new Function1<IGuildOperateCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProGuildMsgService$setGProLocalMsgRead$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGuildOperateCallback iGuildOperateCallback) {
                IKernelGProGuildMsgService S0 = GProGuildMsgService.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.setGProLocalMsgRead(peer, iGuildOperateCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // uh2.c
    public void setGProMsgRead(@Nullable final GProContact peer, @Nullable IGuildOperateCallback cb5) {
        u1("setGProMsgRead", cb5, new Function1<IGuildOperateCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProGuildMsgService$setGProMsgRead$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGuildOperateCallback iGuildOperateCallback) {
                IKernelGProGuildMsgService S0 = GProGuildMsgService.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.setGProMsgRead(peer, iGuildOperateCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // uh2.c
    public void setGuildFeedDraft(@NotNull String guildID, int draftType, @NotNull String draftKey, @NotNull GProGuildFeedDraft draft, @Nullable final IGuildOperateCallback cb5) {
        Intrinsics.checkNotNullParameter(guildID, "guildID");
        Intrinsics.checkNotNullParameter(draftKey, "draftKey");
        Intrinsics.checkNotNullParameter(draft, "draft");
        P0("setGuildFeedDraft", new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProGuildMsgService$setGuildFeedDraft$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                invoke(num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String msg2) {
                Intrinsics.checkNotNullParameter(msg2, "msg");
                IGuildOperateCallback iGuildOperateCallback = IGuildOperateCallback.this;
                if (iGuildOperateCallback != null) {
                    iGuildOperateCallback.onResult(i3, msg2);
                }
            }
        }, new GProGuildMsgService$setGuildFeedDraft$2(guildID, draftType, draftKey, draft, this, cb5));
    }

    @Override // uh2.c
    public void setGuildHelperNotifySwitch(final int noticeType, final int value, @NotNull final IGuildOperateCallback cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        O0("setGuildHelperNotifySwitch", new Function0<Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProGuildMsgService$setGuildHelperNotifySwitch$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Unit invoke() {
                IKernelGProGuildMsgService S0 = GProGuildMsgService.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.setGuildHelperNotifySwitch(noticeType, value, cb5);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // uh2.c
    public void w0(@Nullable IKernelGProGuildMsgListener msgListener) {
        this.msgListener = msgListener;
    }

    @Override // uh2.c
    public void x(@Nullable GProContact peer, @Nullable IUnreadCntCallback cb5) {
        final ArrayList arrayList = new ArrayList();
        if (peer != null) {
            arrayList.add(peer);
            v1("getCategoryUnreadCntInfo", cb5, new Function1<IUnreadCntCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProGuildMsgService$getCategoryUnreadCntInfo$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IUnreadCntCallback iUnreadCntCallback) {
                    IKernelGProGuildMsgService S0 = GProGuildMsgService.this.S0();
                    if (S0 == null) {
                        return null;
                    }
                    S0.getCategoryUnreadCntInfo(arrayList, iUnreadCntCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // uh2.c
    public void z(@NotNull IKernelGProGuildMsgListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        BaseService.X0(this, listener, false, new Function1<Long, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProGuildMsgService$removeKernelGProGuildMsgListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                invoke(l3.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j3) {
                IKernelGProGuildMsgService S0 = GProGuildMsgService.this.S0();
                if (S0 != null) {
                    S0.removeKernelGProGuildMsgListener(j3);
                }
            }
        }, 2, null);
    }
}
