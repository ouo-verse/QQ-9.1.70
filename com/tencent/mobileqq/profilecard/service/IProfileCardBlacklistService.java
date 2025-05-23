package com.tencent.mobileqq.profilecard.service;

import com.tencent.mobileqq.profilecard.observer.ProfileCardBlacklistObserver;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.HashMap;
import mqq.app.api.IRuntimeService;

@Service(process = {"all"})
/* loaded from: classes16.dex */
public interface IProfileCardBlacklistService extends IRuntimeService {
    void deleteBlacklistUinMessage(String str);

    void refreshRecentList();

    void reportItemEvent(String str, String str2, String str3, HashMap<String, String> hashMap, HashMap<String, String> hashMap2);

    void reportPageEvent(String str, String str2, String str3, HashMap<String, String> hashMap, HashMap<String, String> hashMap2);

    void setProfileCardBlacklistObserver(ProfileCardBlacklistObserver profileCardBlacklistObserver);
}
