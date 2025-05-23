package com.tencent.mobileqq.nearbypro.api.impl;

import ab2.b;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.nearbypro.api.IMapNearbyDataService;
import com.tencent.mobileqq.nearbypro.api.map.SelfUserInfo;
import com.tencent.mobileqq.startup.step.InitSkin;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/api/impl/MapNearbyDataServiceImpl;", "Lcom/tencent/mobileqq/nearbypro/api/IMapNearbyDataService;", "Lmqq/app/AppRuntime;", "appRuntime", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/nearbypro/api/map/SelfUserInfo;", "getSelfUserInfo", "updateSelfUserInfo", "selfUserInfo", "Lcom/tencent/mobileqq/nearbypro/api/map/SelfUserInfo;", "<init>", "()V", "Companion", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class MapNearbyDataServiceImpl implements IMapNearbyDataService {

    @NotNull
    public static final String TAG = "NBP.MapNearbyDataServiceImpl";

    @NotNull
    private SelfUserInfo selfUserInfo;

    public MapNearbyDataServiceImpl() {
        SelfUserInfo a16 = b.f25770a.a();
        this.selfUserInfo = a16 == null ? new SelfUserInfo(0L, null, null, 0, null, null, null, null, null, null, null, null, null, InitSkin.DRAWABLE_COUNT, null) : a16;
    }

    @Override // com.tencent.mobileqq.nearbypro.api.IMapNearbyDataService
    @NotNull
    public SelfUserInfo getSelfUserInfo() {
        return this.selfUserInfo;
    }

    @Override // com.tencent.mobileqq.nearbypro.api.IMapNearbyDataService
    public void updateSelfUserInfo() {
        SelfUserInfo a16 = b.f25770a.a();
        if (a16 == null) {
            a16 = this.selfUserInfo;
        }
        this.selfUserInfo = a16;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@Nullable AppRuntime appRuntime) {
    }
}
