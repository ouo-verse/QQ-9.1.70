package com.tencent.mobileqq.nearbypro.api;

import com.tencent.mobileqq.nearbypro.api.map.SelfUserInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Service(process = {""})
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/api/IMapNearbyDataService;", "Lmqq/app/api/IRuntimeService;", "getSelfUserInfo", "Lcom/tencent/mobileqq/nearbypro/api/map/SelfUserInfo;", "updateSelfUserInfo", "", "qq_nearby_pro_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public interface IMapNearbyDataService extends IRuntimeService {
    @NotNull
    SelfUserInfo getSelfUserInfo();

    void updateSelfUserInfo();
}
