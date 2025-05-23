package com.tencent.mobileqq.emoticon;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;

/* compiled from: P */
/* loaded from: classes12.dex */
public interface IEmojiListenerManager {
    void addEmoticonPackageDownloadListener(EmoticonPackageDownloadListener emoticonPackageDownloadListener);

    void addEmotionJsonDownloadListener(EmotionJsonDownloadListener emotionJsonDownloadListener);

    void notifyEmoticonCoverListener(EmoticonPackage emoticonPackage, int i3, int i16, int i17);

    void notifyPackageFail(EmoticonPackage emoticonPackage, int i3, int i16, AppInterface appInterface);

    void notifyPackageProgress(EmoticonPackage emoticonPackage, int i3, int i16);

    void notifyPackageStart(EmoticonPackage emoticonPackage);

    void removeEmoticonPackageDownloadListener(EmoticonPackageDownloadListener emoticonPackageDownloadListener);

    void removeEmotionJsonDownloadListener(EmotionJsonDownloadListener emotionJsonDownloadListener);
}
