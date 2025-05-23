package com.tencent.mobileqq.emosm.api;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import jb1.a;
import mqq.app.api.IRuntimeService;
import tencent.im.cs.faceroam_sso.faceroam_sso$EmojiItem;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes6.dex */
public interface IFavroamingDBManagerService<T extends CustomEmotionBase> extends IRuntimeService {
    void addFavRoamingUpdateListener(a aVar);

    EmoticonInfo convertEmotionDataToInfo(CustomEmotionData customEmotionData, BaseQQAppInterface baseQQAppInterface);

    void delOverflow(List<CustomEmotionData> list);

    void deleteCustomEmotion(CustomEmotionData customEmotionData);

    void deleteCustomEmotionList(List<CustomEmotionData> list);

    void deleteDB(List<String> list);

    List<CustomEmotionData> findMagicEmosById(String str);

    String getCustomEmoticonPath(CustomEmotionData customEmotionData);

    List<String> getCustomEmoticonResIdsByType(String str);

    CustomEmotionData getCustomEmotionDataBYResId(List<CustomEmotionData> list, String str);

    List<CustomEmotionData> getEmoticonDataList();

    List<CustomEmotionData> getEmoticonDataListFromDB();

    List<T> getEmoticonDatasByType(String str);

    CustomEmotionData getEmotionDataByUrl(String str);

    List<String> getLocalFavDataNotInServer(List<String> list, List<faceroam_sso$EmojiItem> list2);

    void insertCustomEmotion(CustomEmotionData customEmotionData);

    void notifyFavRoamingUpdate();

    void removeFavRoamingUpdateListener(a aVar);

    List<EmoticonInfo> syncGetCustomEmotionInfoShowedInAIOPanel();

    List<EmoticonInfo> syncGetCustomEmotionInfoShowedInPanel();

    List<EmoticonInfo> syncGetCustomEmotionInfoShowedInPreview();

    void trimCache();

    void updateCache(CustomEmotionData customEmotionData, int i3);

    void updateCustomEmotion(CustomEmotionData customEmotionData);

    void updateCustomEmotionDataListInDB(List<CustomEmotionData> list, int i3);

    boolean updateDeletedEmoticon(CustomEmotionData customEmotionData, int i3);

    List<CustomEmotionData> updateFavEmotionsInLocalEx(List<String> list, List<faceroam_sso$EmojiItem> list2);

    CustomEmotionData updateUpload(String str);
}
