package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.util.SparseArray;
import com.heytap.databaseengine.type.DataTableNameType;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.flashtransfer.api.IFlashTransferHelperApi;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.api.IBaseProClassObjectFactoryApi;
import com.tencent.mobileqq.zplan.utils.api.IZPlanClassObjectFactory;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static SparseArray<Class<? extends ForwardBaseOption>> f211028a;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72112);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        SparseArray<Class<? extends ForwardBaseOption>> sparseArray = new SparseArray<>(30);
        f211028a = sparseArray;
        sparseArray.put(0, ForwardFileOption.class);
        f211028a.put(1, ForwardPhotoOption.class);
        f211028a.put(-1, ForwardTextOption.class);
        f211028a.put(-2, ForwardMapOption.class);
        f211028a.put(-3, ForwardStructingMsgOption.class);
        f211028a.put(17, ForwardSendHongBaoOption.class);
        f211028a.put(18, ForwardH5HongBaoOption.class);
        f211028a.put(20, ForwardRecommendFriendOption.class);
        f211028a.put(53, ForwardRecommendFriendArkOption.class);
        f211028a.put(24, ForwardRecommendFriendOption.class);
        f211028a.put(42, ForwardRobotCardOption.class);
        f211028a.put(11, ForwardSdkShareOption.class);
        f211028a.put(15, ForwardChooseFriendOption.class);
        f211028a.put(2, ForwardQZoneRichImageOption.class);
        f211028a.put(12, ForwardAioAlbumOption.class);
        f211028a.put(1001, ForwardPluginShareStructMsgOption.class);
        f211028a.put(-4, ForwardHyperTextOption.class);
        f211028a.put(13, ForwardVoiceCallOption.class);
        f211028a.put(14, ForwardEmojiPacketSendOption.class);
        f211028a.put(9, ForwardMarketFaceOption.class);
        f211028a.put(16, ForwardSelectContactOption.class);
        f211028a.put(21, ForwardShortVideoOption.class);
        f211028a.put(22, ForwardQFavBatchOption.class);
        f211028a.put(10, ForwardCompositeOption.class);
        f211028a.put(23, ForwardShareCardOption.class);
        f211028a.put(25, ForwardH5PTVOption.class);
        f211028a.put(27, ForwardArkMsgOption.class);
        f211028a.put(38, ForwardArkH5StructOption.class);
        f211028a.put(35, ForwardArkBabyqReplyMsgOption.class);
        f211028a.put(33, ForwardArkFlashChatMsgOption.class);
        f211028a.put(26, ForwardApolloActionSendOption.class);
        f211028a.put(-5, ForwardMixedMsgOption.class);
        f211028a.put(36, ForwardTribeShortVideoMsgOption.class);
        f211028a.put(39, ForwardQzoneArkMsgOption.class);
        f211028a.put(41, ForwardGameMsgOption.class);
        f211028a.put(-6, ForwardReplyMsgOption.class);
        f211028a.put(44, ForwardMiniAppUpdatableMsgOption.class);
        f211028a.put(45, ForwardReadInJoyOption.class);
        f211028a.put(46, ForwardAskAnonymouslyMsgOption.class);
        f211028a.put(47, EmotionBatchForwardOption.class);
        f211028a.put(48, ForwardAniStickerOption.class);
        f211028a.put(49, ForwardZPlanShareOption.class);
        f211028a.put(54, ForwardZPlanModShareOption.class);
        f211028a.put(56, ForwardWeishiShareOption.class);
        f211028a.put(50, ForwardFriendPermissionOption.class);
        f211028a.put(51, ForwardAddFriendPermissionOption.class);
        f211028a.put(52, ForwardArkPartyRoomMsgOption.class);
        f211028a.put(1055, ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).getChooseGuildOptionClass());
        f211028a.put(1051, ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).getGuildCommentArkMsgOptionClass());
        f211028a.put(1003, ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).getForwardServerArkOptionClass());
        f211028a.put(1050, ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).getForwardSendGuildScheduleClass());
        f211028a.put(1052, ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).getForwardGuildRobotClass());
        f211028a.put(1054, ForwardVideoEmoticonOption.class);
        f211028a.put(1056, ForwardRedPackArkMsgOption.class);
        f211028a.put(1057, ((IMiniAppService) QRoute.api(IMiniAppService.class)).getMiniChooseFriendForwardClass());
        f211028a.put(55, ForwardMapDetailArkOptions.class);
        f211028a.put(1058, ForwardGCChooseFriendOption.class);
        f211028a.put(1059, ForwardWalletPetArkMsgOption.class);
        f211028a.put(1060, ForwardAECameraArkOption.class);
        f211028a.put(1062, ForwardH5RabbitSpringEmoteOption.class);
        f211028a.put(1063, ForwardWalletUnderAgeReadNameOption.class);
        f211028a.put(57, ForwardICGameShareOption.class);
        f211028a.put(DataTableNameType.TABLE_WRIST_TEMPERATURE_STAT, ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).getForwardTroopRobotClass());
        f211028a.put(DataTableNameType.TABLE_SPORT_METADATA, ForwardRobotListOption.class);
        f211028a.put(DataTableNameType.TABLE_SNORE_OSA_MODEL, ForwardQCircleArkOption.class);
        f211028a.put(1067, ((IZPlanClassObjectFactory) QRoute.api(IZPlanClassObjectFactory.class)).getForwardMiniHomeConnectOptionClass());
        f211028a.put(58, ((IFlashTransferHelperApi) QRoute.api(IFlashTransferHelperApi.class)).getForwardOptionClass());
        f211028a.put(DataTableNameType.TABLE_DATA_COLLECTION, ((IBaseProClassObjectFactoryApi) QRoute.api(IBaseProClassObjectFactoryApi.class)).getForwardAIAvatarArkOptionClass());
    }

    public static void a(ForwardBaseOption forwardBaseOption) {
        if (forwardBaseOption.isFromJumpActivity()) {
            forwardBaseOption.addEventListener(new com.tencent.mobileqq.sharehelper.systemshare.a());
        }
    }

    public static ForwardBaseOption b(Intent intent, QQAppInterface qQAppInterface) {
        intent.putExtra("emoInputType", 2);
        ForwardBaseOption c16 = c(intent);
        if (c16 != null) {
            c16.initApp(qQAppInterface);
            c16.preloadData();
            a(c16);
        }
        return c16;
    }

    public static ForwardBaseOption c(Intent intent) {
        int intExtra = intent.getIntExtra("forward_type", -1);
        if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardOptionBuilder", 2, "ForwardOptionBuilder forwardType=" + intExtra);
        }
        Class<? extends ForwardBaseOption> cls = f211028a.get(intExtra);
        if (cls != null) {
            try {
                return cls.getDeclaredConstructor(Intent.class).newInstance(intent);
            } catch (Exception e16) {
                QLog.e("ForwardOption.ForwardOptionBuilder", 1, e16, new Object[0]);
            }
        } else {
            QLog.e("ForwardOption.ForwardOptionBuilder", 1, "clazz should not be null!!");
        }
        return null;
    }

    public static ForwardBaseOption d(Intent intent, QQAppInterface qQAppInterface, Activity activity) {
        intent.putExtra("emoInputType", 2);
        ForwardBaseOption c16 = c(intent);
        if (c16 != null) {
            c16.initContext(qQAppInterface, activity);
            c16.preloadData();
            a(c16);
        }
        return c16;
    }
}
