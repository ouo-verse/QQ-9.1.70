package com.tencent.mobileqq.matchfriend.reborn.api.impl;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import ca2.ChatsListInteractiveEntryModel;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi;
import com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerDataApi;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.QQStrangerLiteActionModel;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.QQStrangerLiteActionPushEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.QQStrangerLiteEntryPart;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.e;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.q;
import com.tencent.mobileqq.matchfriend.reborn.couple.QQCoupleManager;
import com.tencent.mobileqq.matchfriend.reborn.couple.api.IQQStrangerInteractiveMarkService;
import com.tencent.mobileqq.matchfriend.reborn.couple.b;
import com.tencent.mobileqq.matchfriend.reborn.couple.model.NearbyProInteractiveMarkModel;
import com.tencent.mobileqq.matchfriend.reborn.couple.model.QQStrangerInteractiveMarkModel;
import com.tencent.mobileqq.matchfriend.reborn.utils.QQStrangerGrayTipHelper;
import com.tencent.mobileqq.matchfriend.reborn.utils.c;
import com.tencent.mobileqq.matchfriend.reborn.utils.d;
import com.tencent.mobileqq.message.newmsg.a;
import com.tencent.mobileqq.nearbypro.api.INearbyProChatApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.interactivemsg.interactive_msg_service.InteractiveMsgServicePB$MsgMetaInfo;
import com.tencent.trpcprotocol.kuolie.interactivemsg.system_msg_content.SystemMsgContentPB$InteractivemsgSystemmsgContent;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$MiniInfo;
import com.tencent.trpcprotocol.qqstranger.common.common_system_msg.CommonSystemMsgPB$InteractiveMarkerMsg;
import com.tencent.trpcprotocol.qqstranger.common.common_system_msg.CommonSystemMsgPB$InterativeNoticeMsg;
import com.tencent.trpcprotocol.qqstranger.common.common_system_msg.CommonSystemMsgPB$SystemMsgContent;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import msf.msgcomm.nt_msg_common$Msg;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\tH\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\tH\u0002J\u0018\u0010\u000f\u001a\n \u000e*\u0004\u0018\u00010\u000b0\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J \u0010\u0014\u001a\u00020\u00042\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012H\u0016J \u0010\u0015\u001a\u00020\u00042\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012H\u0016J \u0010\u0016\u001a\u00020\u00042\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012H\u0016J \u0010\u0017\u001a\u00020\u00042\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016R\u0014\u0010\u001b\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/api/impl/QQStrangerDataApiImpl;", "Lcom/tencent/mobileqq/matchfriend/reborn/api/IQQStrangerDataApi;", "Lcom/tencent/trpcprotocol/qqstranger/common/common_system_msg/CommonSystemMsgPB$InteractiveMarkerMsg;", "msg", "", "handleInteractiveMarkPush", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l;", "model", "showSystemNotification", "Lcom/tencent/trpcprotocol/qqstranger/common/common_system_msg/CommonSystemMsgPB$InterativeNoticeMsg;", "handleNBPFeedInteractive", "", "makeInteractiveText", ReportConstant.COSTREPORT_PREFIX, "kotlin.jvm.PlatformType", "encode", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "buff", "handleNT0x166MsgPush", "handleNT0x167MsgPush", "handleNTOx16eMsgPush", "handleNT0x16fMsgPush", "updateLiteActionLatestUnread", "", "hasSaveMiniUserInfo", "FORWARD_TO_LITEACTION_MSG", "Ljava/lang/String;", "<init>", "()V", "Companion", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerDataApiImpl implements IQQStrangerDataApi {
    private static int notifyId = NotificationUtil.Constants.NOTIFY_ID_QQSTRANGER_LITE_ACTION_PUSH;
    private static int notifyIdNbp = NotificationUtil.Constants.NOTIFY_ID_NBP_PRO_LITE_ACTION_PUSH;
    private static final String tag = "QQStrangerDataApiImpl";
    private final String FORWARD_TO_LITEACTION_MSG = "is_check_needed=" + encode("false");

    private final String encode(String s16) {
        try {
            return URLEncoder.encode(s16, StandardCharsets.UTF_8.name());
        } catch (Exception unused) {
            return s16;
        }
    }

    private final void handleInteractiveMarkPush(CommonSystemMsgPB$InteractiveMarkerMsg msg2) {
        IQQStrangerInteractiveMarkService iQQStrangerInteractiveMarkService;
        QQStrangerInteractiveMarkModel qQStrangerInteractiveMarkModel;
        QQCoupleManager qQCoupleManager;
        c cVar = c.f245468a;
        int a16 = cVar.a(msg2.appid.get());
        if (a16 == 0) {
            QLog.e(tag, 1, "[handleInteractiveMarkPush] invalid chat type:" + a16);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (iQQStrangerInteractiveMarkService = (IQQStrangerInteractiveMarkService) peekAppRuntime.getRuntimeService(IQQStrangerInteractiveMarkService.class, "all")) == null) {
            return;
        }
        if (a16 == 119) {
            qQStrangerInteractiveMarkModel = new NearbyProInteractiveMarkModel();
        } else {
            qQStrangerInteractiveMarkModel = new QQStrangerInteractiveMarkModel();
        }
        qQStrangerInteractiveMarkModel.bizId = cVar.c(a16);
        qQStrangerInteractiveMarkModel.coupleId = String.valueOf(msg2.peer_tinyid.get());
        qQStrangerInteractiveMarkModel.subtype = String.valueOf(msg2.marker_id.get());
        qQStrangerInteractiveMarkModel.count = msg2.count.get();
        qQStrangerInteractiveMarkModel.level = msg2.level.get();
        QLog.i(tag, 1, "[handleInteractiveMarkPush]upsertInteractiveMark model=" + qQStrangerInteractiveMarkModel);
        if (qQStrangerInteractiveMarkModel instanceof NearbyProInteractiveMarkModel) {
            b<? extends QQStrangerInteractiveMarkModel> coupleMgr = iQQStrangerInteractiveMarkService.getCoupleMgr(a16);
            qQCoupleManager = coupleMgr instanceof QQCoupleManager ? (QQCoupleManager) coupleMgr : null;
            if (qQCoupleManager != null) {
                qQCoupleManager.A(qQStrangerInteractiveMarkModel);
                return;
            }
            return;
        }
        b<? extends QQStrangerInteractiveMarkModel> coupleMgr2 = iQQStrangerInteractiveMarkService.getCoupleMgr(a16);
        qQCoupleManager = coupleMgr2 instanceof QQCoupleManager ? (QQCoupleManager) coupleMgr2 : null;
        if (qQCoupleManager != null) {
            qQCoupleManager.A(qQStrangerInteractiveMarkModel);
        }
    }

    private final void handleNBPFeedInteractive(CommonSystemMsgPB$InterativeNoticeMsg msg2) {
        if (GuardManager.sInstance.isApplicationForeground()) {
            if (QLog.isColorLevel()) {
                QLog.d(tag, 2, "NBPFeedInteractive App in the foreground.");
                return;
            }
            return;
        }
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            if (QLog.isColorLevel()) {
                QLog.d(tag, 2, "NBPFeedInteractive In adolescent mode.");
                return;
            }
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        Manager manager = peekAppRuntime.getManager(QQManagerFactory.NEW_MSG_NOTIFICATION_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.message.newmsg.NewMsgNotificationManager");
        if (!((a) manager).g()) {
            if (QLog.isColorLevel()) {
                QLog.d(tag, 2, "NBPFeedInteractive Close notification switch.");
                return;
            }
            return;
        }
        Intent data = new Intent(BaseApplication.context, (Class<?>) JumpActivity.class).setData(Uri.parse("mqqapi://kuikly/open?target=52&channel=2&version=1&src_type=app&page_name=nearbypro_main&key_scheme=" + URLEncoder.encode("mqqapi://kuikly/open?target=52&channel=2&version=1&src_type=app&source=1&page_name=nearbypro_interactive_page", "UTF-8") + "&key_from=21"));
        Intrinsics.checkNotNullExpressionValue(data, "Intent(BaseApplication.c\u2026i.parse(scheme)\n        )");
        PendingIntent activity = PendingIntent.getActivity(BaseApplication.context, 0, data, 167772160);
        String makeInteractiveText = makeInteractiveText(msg2);
        if (makeInteractiveText == null || makeInteractiveText.length() == 0) {
            QLog.d(tag, 2, "NBPFeedInteractive textStr.isNullOrEmpty");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(tag, 2, "NBPFeedInteractive Show system notification: " + makeInteractiveText + ".");
        }
        Notification build = new NotificationCompat.Builder(BaseApplication.context, QQNotificationManager.CHANNEL_ID_OTHER).setSmallIcon(R.drawable.b8g).setTicker(HardCodeUtil.qqStr(R.string.x1x)).setContentTitle(HardCodeUtil.qqStr(R.string.x1y)).setContentText(makeInteractiveText).setWhen(System.currentTimeMillis()).setPriority(1).setContentIntent(activity).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder(\n            Bas\u2026ent)\n            .build()");
        QQNotificationManager.getInstance().notify(tag, notifyIdNbp, build);
    }

    private final String makeInteractiveText(CommonSystemMsgPB$InterativeNoticeMsg msg2) {
        String str;
        switch (msg2.scene_id.get()) {
            case 6:
                return msg2.user_info.nick.get() + " \u8d5e\u4e86\u4f60\u7684\u52a8\u6001";
            case 7:
                return msg2.user_info.nick.get() + " \u8bc4\u8bba\u4e86\u4f60\u7684\u52a8\u6001";
            case 8:
                if (((INearbyProChatApi) QRoute.api(INearbyProChatApi.class)).checkTidIsSelf(msg2.target_user_info.tid.get())) {
                    str = "\u4f60";
                } else {
                    str = msg2.target_user_info.nick.get();
                }
                return msg2.user_info.nick.get() + " \u56de\u590d\u4e86" + str + "\u7684\u8bc4\u8bba";
            case 9:
                return "\u4f60\u6536\u5230\u4e00\u6761\u6765\u81ea\u9644\u8fd1\u7684\u8f7b\u4e92\u52a8\u6d88\u606f";
            case 10:
                return msg2.user_info.nick.get() + "\u5f00\u59cb\u5173\u6ce8\u4f60\u4e86";
            default:
                return null;
        }
    }

    private final void showSystemNotification(QQStrangerLiteActionModel model) {
        String str;
        String str2;
        if (GuardManager.sInstance.isApplicationForeground()) {
            if (QLog.isColorLevel()) {
                QLog.d(tag, 2, "App in the foreground.");
                return;
            }
            return;
        }
        if (((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).isNeedForbidNotification()) {
            if (QLog.isColorLevel()) {
                QLog.d(tag, 2, "QQStranger do not push.");
                return;
            }
            return;
        }
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            if (QLog.isColorLevel()) {
                QLog.d(tag, 2, "In adolescent mode.");
                return;
            }
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        Manager manager = peekAppRuntime.getManager(QQManagerFactory.NEW_MSG_NOTIFICATION_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.message.newmsg.NewMsgNotificationManager");
        if (!((a) manager).g()) {
            if (QLog.isColorLevel()) {
                QLog.d(tag, 2, "Close notification switch.");
                return;
            }
            return;
        }
        Intent data = new Intent(BaseApplication.context, (Class<?>) JumpActivity.class).setData(Uri.parse("mqqapi://stranger/jump_liteactionlist_page?" + this.FORWARD_TO_LITEACTION_MSG));
        Intrinsics.checkNotNullExpressionValue(data, "Intent(BaseApplication.c\u2026LITEACTION_MSG)\n        )");
        PendingIntent activity = PendingIntent.getActivity(BaseApplication.context, 0, data, 167772160);
        int sceneId = model.getSceneId();
        if (sceneId == 6) {
            str = model.getNick() + " \u8d5e\u4e86\u4f60\u7684\u52a8\u6001";
        } else if (sceneId == 7) {
            str = model.getNick() + " \u8bc4\u8bba\u4e86\u4f60\u7684\u52a8\u6001";
        } else if (sceneId != 8) {
            if (model.getCanChat()) {
                str = model.getNick() + " \u56de\u5e94\u4e86\u4f60\u7684\u540c\u9891\u4e92\u52a8";
            } else {
                if (model.getEmojiId() > 0) {
                    str2 = QQSysFaceUtil.getFaceDescription(QQSysFaceUtil.convertToLocal(model.getEmojiId()));
                } else {
                    str2 = "\u8868\u60c5";
                }
                str = model.getNick() + " \u7ed9\u4f60\u53d1\u9001\u4e86\u4e00\u4e2a" + str2;
            }
        } else {
            str = model.getNick() + " \u56de\u590d\u4e86\u4f60\u7684\u8bc4\u8bba";
        }
        if (QLog.isColorLevel()) {
            QLog.d(tag, 2, "Show system notification: " + str + ".");
        }
        Notification build = new NotificationCompat.Builder(BaseApplication.context, QQNotificationManager.CHANNEL_ID_OTHER).setSmallIcon(R.drawable.b8g).setTicker(HardCodeUtil.qqStr(R.string.x2k)).setContentTitle(HardCodeUtil.qqStr(R.string.x2l)).setContentText(str).setWhen(System.currentTimeMillis()).setPriority(1).setContentIntent(activity).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder(\n            Bas\u2026ent)\n            .build()");
        QQNotificationManager.getInstance().notify(tag, notifyId, build);
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerDataApi
    public void handleNT0x166MsgPush(ArrayList<Byte> buff) {
        byte[] byteArray;
        String str = tag;
        Intrinsics.checkNotNullParameter(buff, "buff");
        try {
            nt_msg_common$Msg nt_msg_common_msg = new nt_msg_common$Msg();
            byteArray = CollectionsKt___CollectionsKt.toByteArray(buff);
            nt_msg_common_msg.mergeFrom(byteArray);
            byte[] byteArray2 = nt_msg_common_msg.body.msg_content.get().toByteArray();
            SystemMsgContentPB$InteractivemsgSystemmsgContent systemMsgContentPB$InteractivemsgSystemmsgContent = new SystemMsgContentPB$InteractivemsgSystemmsgContent();
            systemMsgContentPB$InteractivemsgSystemmsgContent.mergeFrom(byteArray2);
            int i3 = systemMsgContentPB$InteractivemsgSystemmsgContent.msg_unread_cnt.get();
            q.f244623a.g(i3);
            QLog.i(tag, 1, "handleNT0x166MsgPush,unread=" + i3);
            InteractiveMsgServicePB$MsgMetaInfo interactiveMsgServicePB$MsgMetaInfo = systemMsgContentPB$InteractivemsgSystemmsgContent.cur_msg_info;
            if (interactiveMsgServicePB$MsgMetaInfo != null) {
                String str2 = interactiveMsgServicePB$MsgMetaInfo.msg_id.get();
                boolean z16 = interactiveMsgServicePB$MsgMetaInfo.is_read.get();
                String str3 = interactiveMsgServicePB$MsgMetaInfo.peer_mini_profile.open_id.get();
                long j3 = interactiveMsgServicePB$MsgMetaInfo.peer_mini_profile.tiny_id.get();
                String str4 = interactiveMsgServicePB$MsgMetaInfo.peer_mini_profile.avatar.get();
                String str5 = interactiveMsgServicePB$MsgMetaInfo.peer_mini_profile.nick.get();
                String str6 = interactiveMsgServicePB$MsgMetaInfo.summary.get();
                String a16 = e.INSTANCE.a(interactiveMsgServicePB$MsgMetaInfo.msg_time.get());
                int i16 = interactiveMsgServicePB$MsgMetaInfo.inter_emoj_id.get();
                long j16 = interactiveMsgServicePB$MsgMetaInfo.feed_meta.feed_id.get();
                String str7 = interactiveMsgServicePB$MsgMetaInfo.msg_info.feed_id.get();
                Intrinsics.checkNotNullExpressionValue(str7, "it.msg_info.feed_id.get()");
                int i17 = interactiveMsgServicePB$MsgMetaInfo.msg_info.feed_source.get();
                String str8 = interactiveMsgServicePB$MsgMetaInfo.msg_info.content.get();
                Intrinsics.checkNotNullExpressionValue(str8, "it.msg_info.content.get()");
                String str9 = interactiveMsgServicePB$MsgMetaInfo.msg_info.pic.get();
                Intrinsics.checkNotNullExpressionValue(str9, "it.msg_info.pic.get()");
                String str10 = interactiveMsgServicePB$MsgMetaInfo.msg_info.comment_content.get();
                try {
                    Intrinsics.checkNotNullExpressionValue(str10, "it.msg_info.comment_content.get()");
                    String str11 = interactiveMsgServicePB$MsgMetaInfo.msg_info.comment_id.get();
                    Intrinsics.checkNotNullExpressionValue(str11, "it.msg_info.comment_id.get()");
                    String str12 = interactiveMsgServicePB$MsgMetaInfo.msg_info.feed_owner_uid.get();
                    Intrinsics.checkNotNullExpressionValue(str12, "it.msg_info.feed_owner_uid.get()");
                    String str13 = interactiveMsgServicePB$MsgMetaInfo.msg_info.reply_id.get();
                    Intrinsics.checkNotNullExpressionValue(str13, "it.msg_info.reply_id.get()");
                    QQStrangerLiteActionModel.MsgInfo msgInfo = new QQStrangerLiteActionModel.MsgInfo(str7, i17, str8, str9, str10, str11, str12, str13, interactiveMsgServicePB$MsgMetaInfo.msg_info.is_feed_delete.get() == 1);
                    String str14 = interactiveMsgServicePB$MsgMetaInfo.quick_reply.content.get();
                    Intrinsics.checkNotNullExpressionValue(str14, "it.quick_reply.content.get()");
                    QQStrangerLiteActionModel.InteractiveOption interactiveOption = new QQStrangerLiteActionModel.InteractiveOption(false, str14, interactiveMsgServicePB$MsgMetaInfo.quick_reply.interactive_id.get(), 1, null);
                    int i18 = interactiveMsgServicePB$MsgMetaInfo.scene_id.get();
                    boolean z17 = interactiveMsgServicePB$MsgMetaInfo.flag_msg_status.get() == 2;
                    boolean z18 = interactiveMsgServicePB$MsgMetaInfo.is_comment_delete.get() == 1;
                    Intrinsics.checkNotNullExpressionValue(str2, "get()");
                    Intrinsics.checkNotNullExpressionValue(str3, "get()");
                    Intrinsics.checkNotNullExpressionValue(str4, "get()");
                    Intrinsics.checkNotNullExpressionValue(str5, "get()");
                    Intrinsics.checkNotNullExpressionValue(str6, "get()");
                    QQStrangerLiteActionModel qQStrangerLiteActionModel = new QQStrangerLiteActionModel(str2, z16, str3, j3, str4, str5, str6, a16, i16, j16, i18, msgInfo, z17, z18, interactiveOption);
                    QQStrangerLiteEntryPart.INSTANCE.a(qQStrangerLiteActionModel);
                    SimpleEventBus.getInstance().dispatchEvent(new QQStrangerLiteActionPushEvent(qQStrangerLiteActionModel));
                    if (QLog.isColorLevel()) {
                        String str15 = "The push data: " + qQStrangerLiteActionModel + ".";
                        str = tag;
                        QLog.d(str, 2, str15);
                    }
                } catch (Exception e16) {
                    e = e16;
                    str = tag;
                    QLog.e(str, 1, e, new Object[0]);
                }
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerDataApi
    public void handleNT0x167MsgPush(ArrayList<Byte> buff) {
        Intrinsics.checkNotNullParameter(buff, "buff");
        QQStrangerGrayTipHelper.f(buff);
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerDataApi
    public void handleNT0x16fMsgPush(ArrayList<Byte> buff) {
        Intrinsics.checkNotNullParameter(buff, "buff");
        QQStrangerGrayTipHelper.f245465a.g(buff);
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerDataApi
    public void handleNTOx16eMsgPush(ArrayList<Byte> buff) {
        byte[] byteArray;
        Intrinsics.checkNotNullParameter(buff, "buff");
        try {
            nt_msg_common$Msg nt_msg_common_msg = new nt_msg_common$Msg();
            byteArray = CollectionsKt___CollectionsKt.toByteArray(buff);
            nt_msg_common_msg.mergeFrom(byteArray);
            byte[] byteArray2 = nt_msg_common_msg.body.msg_content.get().toByteArray();
            CommonSystemMsgPB$SystemMsgContent commonSystemMsgPB$SystemMsgContent = new CommonSystemMsgPB$SystemMsgContent();
            commonSystemMsgPB$SystemMsgContent.mergeFrom(byteArray2);
            int i3 = commonSystemMsgPB$SystemMsgContent.msg_type.get();
            QLog.i(tag, 1, "handleNTOx16eMsgPush appId=" + commonSystemMsgPB$SystemMsgContent.appid.get() + ", msg_type=" + i3);
            if (i3 != 1) {
                if (i3 == 2 && commonSystemMsgPB$SystemMsgContent.appid.get() == 2) {
                    CommonSystemMsgPB$InterativeNoticeMsg msg2 = commonSystemMsgPB$SystemMsgContent.interactive_notice_msg.get();
                    if (msg2.scene_id.get() != 9) {
                        INearbyProChatApi iNearbyProChatApi = (INearbyProChatApi) QRoute.api(INearbyProChatApi.class);
                        ChatsListInteractiveEntryModel.Companion companion = ChatsListInteractiveEntryModel.INSTANCE;
                        Intrinsics.checkNotNullExpressionValue(msg2, "msg");
                        iNearbyProChatApi.handleInteractiveMsg(companion.b(makeInteractiveText(msg2), msg2.interact_timestamp.get()), msg2.unread_num.get());
                    }
                }
            } else {
                CommonSystemMsgPB$InteractiveMarkerMsg commonSystemMsgPB$InteractiveMarkerMsg = commonSystemMsgPB$SystemMsgContent.interactive_marker_msg.get();
                Intrinsics.checkNotNullExpressionValue(commonSystemMsgPB$InteractiveMarkerMsg, "msgContent.interactive_marker_msg.get()");
                handleInteractiveMarkPush(commonSystemMsgPB$InteractiveMarkerMsg);
            }
        } catch (Exception e16) {
            QLog.e(tag, 1, e16, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerDataApi
    public boolean hasSaveMiniUserInfo() {
        return ((userInfo$MiniInfo) d.f245469a.a("loginUserInfoKey")) != null;
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerDataApi
    public void updateLiteActionLatestUnread() {
        q.f244623a.b(new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.api.impl.QQStrangerDataApiImpl$updateLiteActionLatestUnread$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                QLog.i("QQStrangerDataApiImpl", 1, "updateLiteActionLatestUnread:" + i3);
            }
        });
    }
}
