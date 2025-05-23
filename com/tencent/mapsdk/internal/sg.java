package com.tencent.mapsdk.internal;

import com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.heatmap.GradientVectorOverlayProvider;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.mapsdk.internal.en;
import com.tencent.mapsdk.internal.ep;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class sg implements se {
    @Override // com.tencent.mapsdk.internal.se
    public final en a(en enVar, String str) {
        return enVar;
    }

    @Override // com.tencent.mapsdk.internal.se
    public final en a(byte[] bArr) {
        return (en) JsonUtils.parseToModel(new String(bArr), ep.class, new Object[0]);
    }

    @Override // com.tencent.mapsdk.internal.se
    public final BaseOverlayProvider a(en enVar) {
        en.c.d dVar;
        if (!(enVar instanceof ep) || !enVar.c()) {
            return null;
        }
        ep epVar = (ep) enVar;
        GradientVectorOverlayProvider gradientVectorOverlayProvider = new GradientVectorOverlayProvider();
        ArrayList arrayList = new ArrayList();
        for (en.a.C7029a.AbstractC7030a abstractC7030a : epVar.f148258a.f148210c.f148212b) {
            if (abstractC7030a instanceof en.a.C7029a.e) {
                arrayList.addAll(((en.a.C7029a.e) abstractC7030a).f148226c);
            }
        }
        gradientVectorOverlayProvider.weightedData(arrayList);
        int size = epVar.f148258a.f148259a.f148260a.f148267a.f148271a.f148269b.f148242b.size();
        int[] iArr = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr[i3] = epVar.f148258a.f148259a.f148260a.f148267a.f148271a.f148269b.f148242b.get(i3).intValue();
        }
        float[] fArr = new float[epVar.f148258a.f148259a.f148260a.f148267a.f148271a.f148269b.f148241a.size()];
        for (int i16 = 0; i16 < size; i16++) {
            fArr[i16] = epVar.f148258a.f148259a.f148260a.f148267a.f148271a.f148269b.f148241a.get(i16).floatValue();
        }
        gradientVectorOverlayProvider.gradient(iArr, fArr);
        gradientVectorOverlayProvider.radius(epVar.f148258a.f148259a.f148260a.f148267a.f148271a.f148268a);
        gradientVectorOverlayProvider.setMaxHeight(epVar.f148258a.f148259a.f148261b.f148265d.get(1).floatValue());
        ep.a.C7036a.C7037a c7037a = epVar.f148258a.f148259a.f148261b;
        gradientVectorOverlayProvider.setIntensityRange((float) c7037a.f148263b, (float) c7037a.f148262a);
        ep.a.C7036a.C7037a c7037a2 = epVar.f148258a.f148259a.f148261b;
        gradientVectorOverlayProvider.zoomRange(c7037a2.f148236k, c7037a2.f148235j);
        gradientVectorOverlayProvider.zIndex(epVar.f148258a.f148259a.f148261b.f148232g);
        gradientVectorOverlayProvider.displayLevel(epVar.f148258a.f148259a.f148261b.f148231f);
        gradientVectorOverlayProvider.enable3D(epVar.f148258a.f148259a.f148261b.f148264c);
        gradientVectorOverlayProvider.opacity((float) epVar.f148258a.f148259a.f148261b.f148234i);
        gradientVectorOverlayProvider.visibility(!epVar.f148258a.f148259a.f148261b.f148233h);
        ep.a.C7036a c7036a = epVar.f148258a.f148259a;
        if (c7036a.f148261b.f148266e && (dVar = c7036a.f148260a.f148267a.f148271a.f148270c) != null) {
            gradientVectorOverlayProvider.setAnimateDuration((int) (dVar.f148240c * 1000.0d));
        } else {
            gradientVectorOverlayProvider.setAnimateDuration(0);
        }
        return gradientVectorOverlayProvider;
    }
}
