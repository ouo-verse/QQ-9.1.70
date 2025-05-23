package com.tencent.hippykotlin.demo.pages.nearby.base;

import com.tencent.hippykotlin.demo.pages.base.BasePager;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUITokenThemeMode;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.module.NearbyProfileBridgeModule;
import com.tencent.kuikly.core.module.Module;
import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public abstract class NearbyBasePager extends BasePager {
    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public Map<String, Module> createExternalModules() {
        Map<String, Module> mutableMap;
        Map<String, Module> createExternalModules = super.createExternalModules();
        Intrinsics.checkNotNull(createExternalModules);
        mutableMap = MapsKt__MapsKt.toMutableMap(createExternalModules);
        mutableMap.put("NearbyProfileKuiklyModule", new NearbyProfileBridgeModule());
        mutableMap.put("QQNearbyModule", new QQNearbyModule());
        return mutableMap;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager
    public final QUITokenThemeMode quiTokenThemeMode() {
        return QUITokenThemeMode.ONLY_DAY_AND_NIGHT;
    }
}
