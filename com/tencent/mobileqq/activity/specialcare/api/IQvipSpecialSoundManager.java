package com.tencent.mobileqq.activity.specialcare.api;

import com.tencent.mobileqq.activity.specialcare.c;
import com.tencent.mobileqq.vas.api.IVasManager;
import java.io.File;

/* compiled from: P */
/* loaded from: classes10.dex */
public interface IQvipSpecialSoundManager extends IVasManager {
    String getSoundName(int i3);

    boolean isCacheData();

    void loadSpecialSoundConfig(c cVar);

    void onSpecialSoundConfigDownloaded(int i3, File file, String str);

    void parseSpecialSoundConfigFile();

    void updateSpecialSoundConfig();
}
