package com.tencent.mobileqq.emosm.api;

import android.content.Context;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.VipComicFavorEmoStructMsgInfo;
import com.tencent.mobileqq.emosm.favroaming.IPicDownloadListener;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import java.util.Map;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes6.dex */
public interface IVipComicMqqManagerService extends IRuntimeService {
    void delComicEmoticonList(List<String> list);

    VipComicFavorEmoStructMsgInfo getComicStructInfo(String str);

    Map<String, VipComicFavorEmoStructMsgInfo> getComicStructInfoMap();

    List<CustomEmotionData> getEmoticonList(List<CustomEmotionData> list);

    String getFilePath(String str);

    void handleComicEmoticon(Context context, List<CustomEmotionData> list, Map<String, VipComicFavorEmoStructMsgInfo> map, IPicDownloadListener iPicDownloadListener);

    boolean isComicEmoticon(CustomEmotionData customEmotionData);

    void saveComicStructInfo(VipComicFavorEmoStructMsgInfo vipComicFavorEmoStructMsgInfo);

    void setMyComicEmoticon(List<VipComicFavorEmoStructMsgInfo> list, boolean z16);

    void updateComicStructInfo(List<String> list);

    void uploadInitComicEmoStructMsgInfo();
}
