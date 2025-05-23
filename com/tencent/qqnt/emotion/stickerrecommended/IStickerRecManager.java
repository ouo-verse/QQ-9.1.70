package com.tencent.qqnt.emotion.stickerrecommended;

import android.content.Intent;
import com.tencent.aio.data.AIOContact;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecCacheEntity;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Config;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp.StickerRecKeywordFrom;
import java.util.Collection;
import java.util.List;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes24.dex */
public interface IStickerRecManager extends IRuntimeService {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public interface a {
        void a(List<g> list, String str, String str2, int i3, String str3, StickerRecKeywordFrom stickerRecKeywordFrom);
    }

    boolean analyze(String str, int i3, String str2, StickerRecKeywordFrom stickerRecKeywordFrom);

    boolean analyzeForScenesMode(com.tencent.qqnt.emotion.stickerrecommended.scenesrecommend.c cVar, int i3, String str);

    boolean analyzeFromQzone(String str, int i3, String str2);

    void clearOverdueStickerCache();

    void collectReportData(List<g> list, String str, String str2, int i3);

    void deletePicCache();

    String getCurrentText();

    int getUserConfigVersion(AppInterface appInterface);

    void handleRecommendedStickerConfig(AppInterface appInterface, ConfigurationService$Config configurationService$Config, int i3);

    void handleResponse(Intent intent, FromServiceMsg fromServiceMsg);

    boolean hasInit();

    void init();

    boolean isEmotionRecSettingOpen();

    boolean isForbidInsertOtherEmotion();

    boolean isForceUpdateCache();

    boolean isHandleKeyword(String str);

    Collection<String> loadKeywordForCameraEmotion();

    Collection<String> loadKeywordForFavEmotion();

    String preProcessUsrText(String str);

    String preProcessUsrTextUseLocalSearch(String str);

    void pullWords();

    void reportEvent(List<z> list, boolean z16, int i3, String str);

    void setCurrentText(String str);

    void setForbidInsertOtherEmotion(boolean z16);

    void setForceUpdateCache(boolean z16);

    void setImgUpdateListener(a aVar);

    void syncAddLocalEmoticonKeywords(Collection<String> collection);

    void updateEmotionRecSetting(boolean z16);

    void updateKeywordForFavEmotion();

    void updateSort(AIOContact aIOContact);

    void updateStickerLastTime(List<StickerRecCacheEntity> list);
}
