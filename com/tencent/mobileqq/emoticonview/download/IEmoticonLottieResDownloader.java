package com.tencent.mobileqq.emoticonview.download;

import com.tencent.mobileqq.emoticonview.anisticker.AniStickerHelper;

/* compiled from: P */
/* loaded from: classes12.dex */
public interface IEmoticonLottieResDownloader {
    boolean checkFileExists();

    void loadLottieRes(AniStickerHelper.Builder builder, LoadListener loadListener);
}
