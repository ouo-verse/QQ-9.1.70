package com.tencent.mobileqq.emosm.api;

import androidx.annotation.NonNull;
import com.tencent.cache.api.collection.a;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonKeywords;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.data.EmotionKeyword;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.PromotionEmoticonPkg;
import com.tencent.mobileqq.data.RecentEmotion;
import com.tencent.mobileqq.data.VipIPSiteInfo;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.QueryCallback;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.pb.emosm.EmosmPb$SubCmd0x5RspBQRecommend;
import com.tencent.pb.emosm.EmosmPb$SupportSize;
import com.tencent.qqnt.kernel.nativeinterface.CommonTabEmojiInfo;
import java.util.List;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes6.dex */
public interface IEmoticonManagerService extends IRuntimeService {
    void addEmotionKeywordExpose(EmotionKeyword emotionKeyword, boolean z16);

    void addEmotionKeywordToCache(EmotionKeyword emotionKeyword);

    void addExtensionSizeByScreenSizeFromKeyword(String str, Emoticon emoticon, List<EmosmPb$SupportSize> list);

    void addRecentEmotionExposeNum(EmotionKeyword emotionKeyword, boolean z16);

    void addRecentEmotionToCache(RecentEmotion recentEmotion);

    void addTabEmoticonPackage(EmoticonPackage emoticonPackage, int i3);

    void asyncFindEmoticon(String str, String str2, QueryCallback<Emoticon> queryCallback);

    void asyncFindEmoticonPackage(String str, int i3, QueryCallback<EmoticonPackage> queryCallback);

    void asyncFindEmoticonPackage(String str, QueryCallback<EmoticonPackage> queryCallback);

    void asyncFindTabEmoticonPackageById(String str, int i3, QueryCallback<EmoticonPackage> queryCallback);

    void asyncFindTabEmoticonPackageById(String str, QueryCallback<EmoticonPackage> queryCallback);

    void asyncGetCommonTabEmojiInfoList(int i3, QueryCallback<List<CommonTabEmojiInfo>> queryCallback);

    <T> void asyncGetEmoticonInfo(MarkFaceMessage markFaceMessage, QueryCallback<T> queryCallback);

    void asyncGetTabEmoticonPackages(int i3, QueryCallback<List<EmoticonPackage>> queryCallback);

    void asyncIncreaseEmotionClickNum(Emoticon emoticon);

    void clearAllRecommendExposeNum();

    void clearCache();

    void clearEmotionKeyword(String str);

    EmoticonTab findEmoticonTabById(String str);

    List<Emoticon> findKeywordEmotion(String str);

    int getExtensionSizeByScreenSize(String str);

    VipIPSiteInfo getIPSiteInfoFromBytes(byte[] bArr);

    long getKeywordLastReqTime(String str);

    int getKeywordTotalCount(String str);

    List<String> getKeywordsByEmoticon(Emoticon emoticon);

    List<String> getLocalExposeNumFullKeyword(String str);

    List<EmoticonInfo> getMagicEmoticonInfoList(int i3);

    @NonNull
    List<CommonTabEmojiInfo> getNtCommonTabEmojiInfoList();

    CommonTabEmojiInfo getNtOfficialCommonTabEmojiInfo(int i3);

    a<String, EmoticonPackage> getPkgCache();

    List<PromotionEmoticonPkg> getProEmoticonPkgs(boolean z16, int i3, boolean z17);

    Emoticon getRecentEmotionByKeyword(String str);

    String getSmallEmoticonDescription(String str, String str2);

    List<String> getTabCache();

    boolean handleFetchEmoticonPackagesResp(boolean z16, int i3, EmoticonResp emoticonResp, int i16);

    boolean isEpidInTabcache(String str);

    boolean isKeywordsInHotWordList(String str);

    boolean isShowFavTabRedPoint(int i3);

    boolean isShowRecommendTabRedPoint(int i3);

    boolean isWifiOrG3OrG4();

    void parseCloudKeywordsJson();

    byte[] parseIPSiteInfoToBytes(VipIPSiteInfo vipIPSiteInfo);

    void pushRecommendExposeInfoToSP();

    List<Emoticon> queryBigEmoticonsFromDB();

    void reconstructAllTabEmoticonPackage(List<String> list, int i3);

    void reconstructEmoticonPackage(String str, List<Emoticon> list);

    void recordRecommendEpExpose(PromotionEmoticonPkg promotionEmoticonPkg);

    boolean removeEmoticonPackage(EmoticonPackage emoticonPackage);

    void removeTabEmoticonPackage(String str, int i3);

    void reportSwitchSpeakerPhoneClick(ChatMessage chatMessage, p pVar, boolean z16);

    void saveAndUpdateRecommendEmosInfo(EmosmPb$SubCmd0x5RspBQRecommend emosmPb$SubCmd0x5RspBQRecommend, int i3);

    void saveEmoticon(Emoticon emoticon);

    void saveEmoticonPackage(EmoticonPackage emoticonPackage);

    void saveEmoticonPackageKeywordJson(String str, int i3, String str2, int i16, int i17);

    void saveEmoticonPackages(List<EmoticonPackage> list);

    void saveEmoticonPkgUpdateStatus(String str, int i3, String str2, int i16, int i17);

    void saveEmoticons(List<Emoticon> list);

    void saveEmotionKeywordToDB();

    void saveRecentEmotionToDB();

    void setRecommendEpRedFlag(String str, int i3);

    void syncEmoticonPackageById(String str);

    Emoticon syncFindEmoticonById(String str, String str2);

    EmoticonPackage syncFindEmoticonPackageById(String str);

    EmoticonPackage syncFindEmoticonPackageById(String str, int i3);

    EmoticonPackage syncFindEmoticonPackageInCache(String str, int i3);

    EmoticonPackage syncFindTabEmoticonPackageById(String str);

    EmoticonPackage syncFindTabEmoticonPackageById(String str, int i3);

    <T extends EmoticonInfo> T syncGetEmoticonInfo(MarkFaceMessage markFaceMessage);

    List<Emoticon> syncGetEmoticonsByKeyword(String str, boolean z16);

    List<Emoticon> syncGetSubEmoticonsByPackageId(String str);

    List<Emoticon> syncGetSubEmoticonsByPackageId(String str, boolean z16);

    List<EmoticonPackage> syncGetTabEmoticonPackages();

    List<EmoticonPackage> syncGetTabEmoticonPackages(int i3);

    void syncIncreaseEmoticonExposeNum(IStickerRecEmoticon iStickerRecEmoticon);

    void syncPcTabEmoticonPackage(String str, int i3);

    void updateKeywordReqTime(EmoticonKeywords emoticonKeywords);

    void updateNtCommonTabEmojiInfoList(List<CommonTabEmojiInfo> list);
}
