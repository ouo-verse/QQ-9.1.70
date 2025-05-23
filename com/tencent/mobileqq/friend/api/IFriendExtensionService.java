package com.tencent.mobileqq.friend.api;

import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {"all"})
/* loaded from: classes12.dex */
public interface IFriendExtensionService extends IRuntimeService {
    ExtensionInfo deleteExtensionInfo(String str);

    List<ExtensionInfo> getAllExtensionInfo();

    ExtensionInfo getExtensionInfo(String str);

    ExtensionInfo getExtensionInfo(String str, boolean z16);

    List<ExtensionInfo> getFriendRingIdListFromDB();

    void initCache();

    boolean saveExtensionInfo(ExtensionInfo extensionInfo);

    boolean saveExtensionInfoList(List<ExtensionInfo> list);
}
