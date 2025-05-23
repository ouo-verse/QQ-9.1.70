package nd2;

import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDynamicInfoEntity;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.mobileqq.Doraemon.monitor.APIQuotaEntity;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.activity.TroopNotificationCache;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecommendEntity;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecommendSortEntity;
import com.tencent.mobileqq.activity.bless.BlessPtvModule;
import com.tencent.mobileqq.activity.bless.BlessTask;
import com.tencent.mobileqq.activity.bless.BlessWording;
import com.tencent.mobileqq.app.qqdaily.FrontBackData;
import com.tencent.mobileqq.bubble.BubbleDiyEntity;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.config.operation.QQOperationTaskRecord;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.config.operation.QQOperationVoipTipsTaskExcuteRecord;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.EmoticonKeywords;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.PYMKBizEntryInfo;
import com.tencent.mobileqq.data.entitymanager.Interceptor;
import com.tencent.mobileqq.data.qzone.FeedInfo;
import com.tencent.mobileqq.data.troop.TroopExtDBInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfoExt;
import com.tencent.mobileqq.doutu.DoutuData;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.fts.data.troop.FTSNewTroopSync;
import com.tencent.mobileqq.fts.data.troop.FTSTroopSync;
import com.tencent.mobileqq.fts.data.troop.FTSTroopTime;
import com.tencent.mobileqq.gamecenter.data.PadFaceAd;
import com.tencent.mobileqq.gamecenter.msginfo.GameUserInfo;
import com.tencent.mobileqq.guild.data.ChannelMsgEvent;
import com.tencent.mobileqq.guild.message.GuildMsgSeqTimeItem;
import com.tencent.mobileqq.guild.message.lastmsg.GuildLastMsgItem;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.HotPicSendData;
import com.tencent.mobileqq.hotpic.HotPicTagInfo;
import com.tencent.mobileqq.leba.entity.LebaPluginConfig;
import com.tencent.mobileqq.matchfriend.bean.QQStrangerUserInfo;
import com.tencent.mobileqq.microapp.apkg.AppInfo;
import com.tencent.mobileqq.mini.api.QQMiniManager;
import com.tencent.mobileqq.multimsg.MultiMsgNick;
import com.tencent.mobileqq.profile.ProfileShoppingPhotoInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.searchlocal.model.SearchHistory;
import com.tencent.mobileqq.statistics.Reporting;
import com.tencent.mobileqq.tofumsg.TofuItem;
import com.tencent.mobileqq.tofumsg.TofuLimitMsg;
import com.tencent.mobileqq.troop.data.GroupSystemMsgOldData;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.data.TroopAIONotifyItem;
import com.tencent.mobileqq.troop.data.TroopAioKeyBlackRule;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo;
import com.tencent.mobileqq.troop.data.TroopAioTopADInfo;
import com.tencent.mobileqq.troop.data.TroopGiftBagInfo;
import com.tencent.mobileqq.troop.data.TroopTipsEntity;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem;
import com.tencent.mobileqq.troop.onlinemember.data.TroopAllOnlineData;
import com.tencent.mobileqq.troop.recommend.data.RecentRecommendTroopItem;
import com.tencent.mobileqq.troop.troopapps.data.FullListGroupAppEntity;
import com.tencent.mobileqq.troop.troopapps.data.GrayGroupAppEntity;
import com.tencent.mobileqq.troop.troopapps.data.TroopAppInfo;
import com.tencent.mobileqq.troop.troopgame.MemberGradeLevelInfo;
import com.tencent.mobileqq.vas.pendant.drawable.bean.DiyPendantEntity;
import com.tencent.mobileqq.vashealth.api.IQQHealthApi;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.intimateinfo.bean.NTIntimateBaseEntity;
import com.tencent.qqnt.ntrelation.intimateinfo.bean.NTMutualMarkEntity;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c extends j {

    /* renamed from: a, reason: collision with root package name */
    private final Class[] f419965a = {MultiMsgNick.class, FTSTroopSync.class, Reporting.class, BusinessCard.class, FTSTroopTime.class, DoutuData.class, QQOperationViopTipTask.class, HotPicTagInfo.class, BmqqAccountType.class, QQOperationTaskRecord.class, QQOperationVoipTipsTaskExcuteRecord.class, TroopNotificationCache.class, TroopAIOAppInfo.class, HotPicData.class, ProfileShoppingPhotoInfo.class, DrawerPushItem.class, TroopAioKeyBlackRule.class, TroopAioKeywordTipInfo.class, TroopAllOnlineData.class, ((IPublicAccountProxy) QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountDynamicInfoEntity.class), DiyPendantEntity.class, BlessPtvModule.class, BlessWording.class, ((IQQHealthApi) QRoute.api(IQQHealthApi.class)).getTracePathDataClass(), ((IQQHealthApi) QRoute.api(IQQHealthApi.class)).getTracePointDataClass(), HotPicSendData.class, TroopTipsEntity.class, BubbleDiyEntity.class, TroopGiftBagInfo.class, HotChatInfo.class, EmoticonKeywords.class, BlessTask.class, TroopAioTopADInfo.class, FTSNewTroopSync.class, FeedInfo.class, BeancurdMsg.class, APIQuotaEntity.class, AppInfo.class, PadFaceAd.class, ExtensionInfo.class, ColorNote.class, FrontBackData.class, StickerRecommendEntity.class, StickerRecommendSortEntity.class, TofuItem.class, TroopEssenceMsgItem.class, MemberGradeLevelInfo.class, TroopMemberCardInfo.class, QQMiniManager.getMiniAppEntityClass(), QQMiniManager.getDeskTopAppEntityClass(), QQMiniManager.getDesktopAppEntityV3Class(), FullListGroupAppEntity.class, GrayGroupAppEntity.class, TroopAppInfo.class, TroopAIONotifyItem.class, RecentRecommendTroopItem.class, GroupSystemMsgOldData.class, DiscussionMemberInfo.class, DiscussionInfo.class, GuildMsgSeqTimeItem.class, TofuLimitMsg.class, GameUserInfo.class, ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).getGuildMessageNavigateInfoClass(), ChannelMsgEvent.class, FileManagerEntity.class, GuildLastMsgItem.class, TroopMemberInfoExt.class, TroopExtDBInfo.class, SearchHistory.class, QQStrangerUserInfo.class, PYMKBizEntryInfo.class, NTMutualMarkEntity.class, NTIntimateBaseEntity.class, LebaPluginConfig.class};

    private Class b(String str) {
        for (Class cls : this.f419965a) {
            if (cls.getSimpleName().equals(str)) {
                return cls;
            }
        }
        return d(str);
    }

    @Override // com.tencent.mobileqq.data.entitymanager.Interceptor
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Class intercept(Interceptor.Chain chain) {
        String a16 = a(chain);
        Class b16 = b(a16);
        if (b16 != null && QLog.isDevelopLevel()) {
            QLog.d("CommonInterceptor", 1, "check table: " + a16 + " / " + b16.getName());
        }
        return b16;
    }

    Class d(String str) {
        try {
            return Class.forName("com.tencent.mobileqq.data." + str);
        } catch (ClassNotFoundException unused) {
            QLog.d("CommonInterceptor", 1, "find unknown table: " + str);
            return null;
        }
    }
}
