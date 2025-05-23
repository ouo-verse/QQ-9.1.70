package com.tencent.sqshow.zootopia.avatar.filament;

import com.tencent.filament.zplan.avatar.Directional;
import com.tencent.filament.zplan.avatar.IndirectLight;
import com.tencent.filament.zplan.avatar.LightsParams;
import com.tencent.filament.zplan.avatar.SpotLight;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/filament/k;", "", "", "isNight", "Lcom/tencent/filament/zplan/avatar/LightsParams;", "a", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f370019a = new k();

    k() {
    }

    public final LightsParams a(boolean isNight) {
        List mutableListOf;
        List mutableListOf2;
        if (isNight) {
            SpotLight spotLight = new SpotLight(null, null, null, null, 0.0f, 0.0d, 0, 0, false, 511, null);
            spotLight.setKey("spotLight1");
            spotLight.setPosition(new float[]{1.017f, 1.017f, 0.905f});
            spotLight.setDirection(new float[]{-0.61f, 0.281f, -0.741f});
            spotLight.setColor(new float[]{0.8f, 0.8f, 1.0f});
            spotLight.setIntensity(3380.0f);
            spotLight.setFalloff(5.0d);
            spotLight.setInnerCone(30);
            spotLight.setOuterCone(50);
            spotLight.setCastShadows(false);
            SpotLight spotLight2 = new SpotLight(null, null, null, null, 0.0f, 0.0d, 0, 0, false, 511, null);
            spotLight2.setKey("spotLight2");
            spotLight2.setPosition(new float[]{0.152f, 0.273f, -1.897f});
            spotLight2.setDirection(new float[]{-0.307f, -0.237f, 0.922f});
            spotLight2.setColor(new float[]{0.5f, 0.5f, 1.0f});
            spotLight2.setIntensity(4833.0f);
            spotLight2.setFalloff(30.0d);
            spotLight2.setInnerCone(10);
            spotLight2.setOuterCone(40);
            spotLight2.setCastShadows(false);
            Directional directional = new Directional(null, 0, 0.0f, null, false, 31, null);
            directional.setColor(new float[]{0.95f, 0.94f, 0.85f});
            directional.setIntensity(35000.0f);
            directional.setDirection(new float[]{-0.45f, -0.31f, -0.86f});
            directional.setCastShadows(true);
            IndirectLight indirectLight = new IndirectLight(null, 0.0f, 3, null);
            indirectLight.setIntensity(2000.0f);
            mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf(spotLight, spotLight2);
            return new LightsParams(directional, indirectLight, mutableListOf2);
        }
        SpotLight spotLight3 = new SpotLight(null, null, null, null, 0.0f, 0.0d, 0, 0, false, 511, null);
        spotLight3.setKey("spotLight1");
        spotLight3.setPosition(new float[]{1.017f, 1.017f, 0.905f});
        spotLight3.setDirection(new float[]{-0.61f, 0.281f, -0.741f});
        spotLight3.setColor(new float[]{0.8f, 0.8f, 1.0f});
        spotLight3.setIntensity(123380.0f);
        spotLight3.setFalloff(10.0d);
        spotLight3.setInnerCone(10);
        spotLight3.setOuterCone(50);
        spotLight3.setCastShadows(false);
        SpotLight spotLight4 = new SpotLight(null, null, null, null, 0.0f, 0.0d, 0, 0, false, 511, null);
        spotLight4.setKey("spotLight2");
        spotLight4.setPosition(new float[]{0.152f, 0.273f, -1.897f});
        spotLight4.setDirection(new float[]{-0.307f, -0.237f, 0.922f});
        spotLight4.setColor(new float[]{0.5f, 0.5f, 1.0f});
        spotLight4.setIntensity(48330.0f);
        spotLight4.setFalloff(30.0d);
        spotLight4.setInnerCone(10);
        spotLight4.setOuterCone(40);
        spotLight4.setCastShadows(false);
        Directional directional2 = new Directional(new float[]{1.0f, 0.94f, 0.99f}, 0, 67000.0f, new float[]{0.5f, -0.246f, -0.856f}, true, 2, null);
        IndirectLight indirectLight2 = new IndirectLight(null, 5000.0f, 1, null);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(spotLight3, spotLight4);
        return new LightsParams(directional2, indirectLight2, mutableListOf);
    }
}
