package com.tencent.mobileqq.qwallet.hb.aio.passwd;

import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.HashMap;
import java.util.HashSet;
import mqq.app.api.IRuntimeService;

@Service(process = {"all"})
/* loaded from: classes16.dex */
public interface IPasswdRedBagService extends IRuntimeService {
    public static final int FLAG_NORMAL = 0;
    public static final String TAG = "PasswdRedBagSgervice";
    public static final int TYPE_C2C = 3;
    public static final int TYPE_DISCUSS = 2;
    public static final int TYPE_GROUP = 1;
    public static final int TYPE_NONE = 0;

    void loadConfigs();

    void loadRedBagInfoToCache(boolean z16);

    void saveDisGroupInfos(HashMap<String, String> hashMap);

    void saveGroupInfos(HashMap<String, String> hashMap);

    void updatePasswdConfig(HashSet<String> hashSet);
}
