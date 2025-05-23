package com.tencent.mapsdk.internal;

import com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.datamodels.FromToLatLng;
import com.tencent.map.sdk.utilities.visualization.od.ArcLineOverlayProvider;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.mapsdk.internal.ej;
import com.tencent.mapsdk.internal.en;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class sc implements se {
    @Override // com.tencent.mapsdk.internal.se
    public final en a(en enVar, String str) {
        return enVar;
    }

    @Override // com.tencent.mapsdk.internal.se
    public final en a(byte[] bArr) {
        return (en) JsonUtils.parseToModel(new String(bArr), ej.class, new Object[0]);
    }

    @Override // com.tencent.mapsdk.internal.se
    public final BaseOverlayProvider a(en enVar) {
        if (!(enVar instanceof ej) || !enVar.c()) {
            return null;
        }
        ej ejVar = (ej) enVar;
        ArcLineOverlayProvider arcLineOverlayProvider = new ArcLineOverlayProvider();
        if (ejVar.f148179a.f148210c.f148212b != null) {
            ArrayList arrayList = new ArrayList();
            for (en.a.C7029a.AbstractC7030a abstractC7030a : ejVar.f148179a.f148210c.f148212b) {
                if (abstractC7030a instanceof en.a.C7029a.b) {
                    en.a.C7029a.b bVar = (en.a.C7029a.b) abstractC7030a;
                    arrayList.add(new FromToLatLng(bVar.f148215c.get(0), bVar.f148215c.get(1)));
                }
            }
            arcLineOverlayProvider.data(arrayList);
        }
        en.c.e eVar = ejVar.f148179a.f148180a.f148181a.f148189a.f148196a.f148192c;
        if (eVar != null) {
            int size = eVar.f148242b.size();
            int[] iArr = new int[size];
            for (int i3 = 0; i3 < size; i3++) {
                iArr[i3] = ejVar.f148179a.f148180a.f148181a.f148189a.f148196a.f148192c.f148242b.get(i3).intValue();
            }
            arcLineOverlayProvider.gradient(iArr);
        }
        arcLineOverlayProvider.width(ejVar.f148179a.f148180a.f148181a.f148189a.f148196a.f148190a);
        arcLineOverlayProvider.radian((float) (ejVar.f148179a.f148180a.f148181a.f148189a.f148196a.f148191b * 90.0d));
        ej.a.C7023a.C7024a c7024a = ejVar.f148179a.f148180a.f148182b;
        arcLineOverlayProvider.zoomRange(c7024a.f148236k, c7024a.f148235j);
        arcLineOverlayProvider.zIndex(ejVar.f148179a.f148180a.f148182b.f148232g);
        arcLineOverlayProvider.displayLevel(ejVar.f148179a.f148180a.f148182b.f148231f);
        arcLineOverlayProvider.enable3D(ejVar.f148179a.f148180a.f148182b.f148183a);
        arcLineOverlayProvider.opacity((float) ejVar.f148179a.f148180a.f148182b.f148234i);
        arcLineOverlayProvider.visibility(!ejVar.f148179a.f148180a.f148182b.f148233h);
        ej.a.C7023a.C7024a c7024a2 = ejVar.f148179a.f148180a.f148182b;
        if (c7024a2.f148184b) {
            arcLineOverlayProvider.setAnimateDuration((int) (c7024a2.f148185c.f148188c * 1000.0d));
            arcLineOverlayProvider.setHighlightDuration((int) (ejVar.f148179a.f148180a.f148182b.f148185c.f148186a * 1000.0d));
            arcLineOverlayProvider.animateColor(ejVar.f148179a.f148180a.f148182b.f148185c.f148187b);
        } else {
            arcLineOverlayProvider.setAnimateDuration(0);
        }
        return arcLineOverlayProvider;
    }
}
