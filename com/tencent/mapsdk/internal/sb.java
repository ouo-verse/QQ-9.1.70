package com.tencent.mapsdk.internal;

import com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.aggregation.AggregationOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.aggregation.HoneyCombVectorOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.aggregation.SquareVectorOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.datamodels.WeightedLatLng;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.mapsdk.internal.ei;
import com.tencent.mapsdk.internal.en;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class sb implements se {
    private static ei b(byte[] bArr) {
        return (ei) JsonUtils.parseToModel(new String(bArr), ei.class, new Object[0]);
    }

    @Override // com.tencent.mapsdk.internal.se
    public final en a(en enVar, String str) {
        return enVar;
    }

    @Override // com.tencent.mapsdk.internal.se
    public final BaseOverlayProvider a(en enVar) {
        AggregationOverlayProvider squareVectorOverlayProvider;
        en.c.d dVar;
        if (!(enVar instanceof ei) || !enVar.c()) {
            return null;
        }
        ei eiVar = (ei) enVar;
        if (eiVar.f148163a.f148164a.f148165a.f148172a.f148178a.f148175c.equals("hexagon")) {
            squareVectorOverlayProvider = new HoneyCombVectorOverlayProvider();
        } else {
            squareVectorOverlayProvider = eiVar.f148163a.f148164a.f148165a.f148172a.f148178a.f148175c.equals("grid") ? new SquareVectorOverlayProvider() : null;
        }
        if (squareVectorOverlayProvider == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (en.a.C7029a.AbstractC7030a abstractC7030a : eiVar.f148163a.f148210c.f148212b) {
            if (abstractC7030a instanceof en.a.C7029a.e) {
                arrayList.addAll(((en.a.C7029a.e) abstractC7030a).f148226c);
            }
        }
        AggregationOverlayProvider nodes = squareVectorOverlayProvider.nodes((WeightedLatLng[]) arrayList.toArray(new WeightedLatLng[0]));
        int size = eiVar.f148163a.f148164a.f148165a.f148172a.f148178a.f148176d.f148242b.size();
        int[] iArr = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr[i3] = eiVar.f148163a.f148164a.f148165a.f148172a.f148178a.f148176d.f148242b.get(i3).intValue();
        }
        double[] dArr = new double[eiVar.f148163a.f148164a.f148165a.f148172a.f148178a.f148176d.f148241a.size()];
        for (int i16 = 0; i16 < size; i16++) {
            dArr[i16] = eiVar.f148163a.f148164a.f148165a.f148172a.f148178a.f148176d.f148241a.get(i16).doubleValue();
        }
        nodes.colors(iArr, dArr);
        nodes.size(eiVar.f148163a.f148164a.f148165a.f148172a.f148178a.f148174b);
        nodes.gap(eiVar.f148163a.f148164a.f148165a.f148172a.f148178a.f148173a);
        nodes.setHeightRange(eiVar.f148163a.f148164a.f148166b.f148170d.get(0).doubleValue(), eiVar.f148163a.f148164a.f148166b.f148170d.get(1).doubleValue());
        ei.a.C7019a.C7020a c7020a = eiVar.f148163a.f148164a.f148166b;
        nodes.setIntensityRange(c7020a.f148168b, c7020a.f148167a);
        ei.a.C7019a.C7020a c7020a2 = eiVar.f148163a.f148164a.f148166b;
        nodes.zoomRange(c7020a2.f148236k, c7020a2.f148235j);
        nodes.zIndex(eiVar.f148163a.f148164a.f148166b.f148232g);
        nodes.displayLevel(eiVar.f148163a.f148164a.f148166b.f148231f);
        nodes.enable3D(eiVar.f148163a.f148164a.f148166b.f148169c);
        nodes.opacity((float) eiVar.f148163a.f148164a.f148166b.f148234i);
        nodes.visibility(!eiVar.f148163a.f148164a.f148166b.f148233h);
        ei.a.C7019a c7019a = eiVar.f148163a.f148164a;
        if (c7019a.f148166b.f148171e && (dVar = c7019a.f148165a.f148172a.f148178a.f148177e) != null) {
            nodes.setAnimateDuration((int) (dVar.f148240c * 1000.0d));
        } else {
            nodes.setAnimateDuration(0);
        }
        return nodes;
    }

    @Override // com.tencent.mapsdk.internal.se
    public final /* synthetic */ en a(byte[] bArr) {
        return (ei) JsonUtils.parseToModel(new String(bArr), ei.class, new Object[0]);
    }
}
