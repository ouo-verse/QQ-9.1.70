package com.tencent.mobileqq.activity.aio.stickerrecommended;

import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes10.dex */
public interface IStickerRecManager extends IRuntimeService {

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface ImgUpdateListener {
        void onImgUpdated(List<IStickerRecEmoticon> list, String str, String str2, int i3, String str3);
    }

    boolean analyzeFromQCircle(String str, int i3, String str2);

    boolean analyzeFromQzone(String str, int i3, String str2);

    void clearOverdueStickerCache();

    void deletePicCache();

    String getCurrentText();

    boolean hasInit();

    void init();

    boolean isEmotionRecSettingOpen();

    boolean isForceUpdateCache();

    void pullWords();

    void reportEvent(List<r> list, boolean z16, int i3, String str);

    void setCurrentText(String str);

    void setForceUpdateCache(boolean z16);

    void setImgUpdateListener(ImgUpdateListener imgUpdateListener);

    void updateEmotionRecSetting(boolean z16);
}
