package com.tencent.mobileqq.groupvideo.bridgeengine;

import androidx.annotation.Keep;

/* compiled from: P */
@Keep
/* loaded from: classes12.dex */
public interface ITroopManageService {
    void asyncCreateAndManageTroopList(ITroopManageCallback iTroopManageCallback) throws NoSuchMethodException;

    void loadTroopAvatar(String str, ITroopManageCallback iTroopManageCallback) throws NoSuchMethodException;
}
