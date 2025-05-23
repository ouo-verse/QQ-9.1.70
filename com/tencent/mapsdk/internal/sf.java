package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.glmodel.GLModelOverlayProvider;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.en;
import com.tencent.mapsdk.internal.eo;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class sf implements se {
    @Override // com.tencent.mapsdk.internal.se
    public final en a(byte[] bArr) {
        return (en) JsonUtils.parseToModel(new String(bArr), eo.class, new Object[0]);
    }

    @Override // com.tencent.mapsdk.internal.se
    public final en a(en enVar, String str) {
        boolean z16 = enVar instanceof eo;
        en enVar2 = enVar;
        if (z16) {
            eo eoVar = (eo) enVar;
            en.a.C7029a.c cVar = (en.a.C7029a.c) eoVar.f148244a.f148210c.f148212b.get(0);
            String str2 = str + "/model/";
            LogUtil.b(ky.f149119y, "# 2\u6b21\u5904\u7406\u6570\u636e\u7f13\u5b58\u6839\u76ee\u5f55: [" + str2 + "]");
            String str3 = str2 + cVar.f148223i;
            File file = new File(str3, cVar.f148222h);
            LogUtil.b(ky.f149119y, "# 2\u6b21\u5904\u7406\u6570\u636e\u7f13\u5b58\u76ee\u6807\u6587\u4ef6: [" + file.getAbsolutePath() + "]");
            if (!file.exists()) {
                if (!TextUtils.isEmpty(cVar.f148218d) && !cVar.f148218d.equals("null")) {
                    cVar.f148217c = cVar.f148218d;
                }
                if (!TextUtils.isEmpty(cVar.f148219e) && !cVar.f148219e.equals("null")) {
                    cVar.f148217c = cVar.f148219e;
                }
                LogUtil.b(ky.f149119y, "2\u6b21\u5904\u7406\u6570\u636e\u8bf7\u6c42url: [" + cVar.f148217c + "]");
                NetResponse doGet = NetManager.getInstance().builder().url(cVar.f148217c).doGet();
                if (doGet.available()) {
                    kt.f(new File(str2));
                    byte[] bArr = doGet.data;
                    File file2 = new File(str2, cVar.f148221g + ".tmp");
                    kt.a(file2, bArr);
                    try {
                        kw.a(new FileInputStream(file2), new File(str3));
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                    kt.b(file2);
                    StringBuilder sb5 = new StringBuilder("# 2\u6b21\u4e0b\u8f7d\u5904\u7406\u6570\u636e\u5927\u5c0f: {");
                    sb5.append(cVar.f148221g);
                    sb5.append("} [");
                    byte[] bArr2 = doGet.data;
                    sb5.append(bArr2 != null ? bArr2.length : 0);
                    sb5.append("]");
                    LogUtil.b(ky.f149119y, sb5.toString());
                    ((en.a.C7029a.c) eoVar.f148244a.f148210c.f148212b.get(0)).f148214b = file.getAbsolutePath();
                    enVar2 = eoVar;
                } else {
                    LogUtil.b(ky.f149119y, "2\u6b21\u5904\u7406\u6570\u636e\u8bf7\u6c42\u5931\u8d25");
                    ((en.a.C7029a.c) eoVar.f148244a.f148210c.f148212b.get(0)).f148214b = "";
                    enVar2 = eoVar;
                }
            } else {
                LogUtil.b(ky.f149119y, "2\u6b21\u5904\u7406\u6570\u636e\u5df2\u5b58\u5728\u7f13\u5b58\u4e2d");
                ((en.a.C7029a.c) eoVar.f148244a.f148210c.f148212b.get(0)).f148214b = file.getAbsolutePath();
                enVar2 = eoVar;
            }
        }
        return enVar2;
    }

    @Override // com.tencent.mapsdk.internal.se
    public final BaseOverlayProvider a(en enVar) {
        if (!(enVar instanceof eo) || !enVar.c()) {
            return null;
        }
        eo eoVar = (eo) enVar;
        en.a.C7029a.c cVar = (en.a.C7029a.c) eoVar.f148244a.f148210c.f148212b.get(0);
        if (TextUtils.isEmpty(cVar.f148214b)) {
            return null;
        }
        LatLng latLng = eoVar.f148244a.f148245a.f148246a.f148248a.f148257a.f148249a;
        GLModelOverlayProvider gLModelOverlayProvider = new GLModelOverlayProvider(cVar.f148214b, new LatLng(latLng.latitude, latLng.longitude, latLng.altitude));
        List<Double> list = eoVar.f148244a.f148245a.f148246a.f148248a.f148257a.f148250b;
        if (list != null && list.size() == 3) {
            gLModelOverlayProvider.rotationX(list.get(0).floatValue() + 90.0f).rotationY(list.get(1).floatValue()).rotationZ(list.get(2).floatValue());
        }
        gLModelOverlayProvider.latLngBounds(eoVar.f148244a.f148245a.f148246a.f148248a.f148257a.f148254f);
        if (eoVar.f148244a.f148245a.f148246a.f148248a.f148257a.f148252d) {
            gLModelOverlayProvider.coordType(GLModelOverlayProvider.CoordType.GeoGraphicType);
            gLModelOverlayProvider.scale(eoVar.f148244a.f148245a.f148246a.f148248a.f148257a.f148251c);
        } else {
            gLModelOverlayProvider.coordType(GLModelOverlayProvider.CoordType.PixelType);
            List<Integer> list2 = eoVar.f148244a.f148245a.f148246a.f148248a.f148257a.f148253e;
            if (list2 != null && list2.size() == 2) {
                gLModelOverlayProvider.pixelBounds(list2.get(0).intValue(), list2.get(1).intValue());
            }
        }
        int i3 = eoVar.f148244a.f148245a.f148246a.f148248a.f148257a.f148255g.f148243a;
        if (i3 == 0) {
            gLModelOverlayProvider.animateType(GLModelOverlayProvider.AnimationType.None);
        } else if (i3 == 1) {
            gLModelOverlayProvider.animateType(GLModelOverlayProvider.AnimationType.FlattenRise);
        }
        gLModelOverlayProvider.setExposure((float) eoVar.f148244a.f148245a.f148246a.f148248a.f148257a.f148256h);
        eo.a.C7032a.C7033a c7033a = eoVar.f148244a.f148245a.f148247b;
        gLModelOverlayProvider.zoomRange(c7033a.f148236k, c7033a.f148235j);
        gLModelOverlayProvider.zIndex(eoVar.f148244a.f148245a.f148247b.f148232g);
        gLModelOverlayProvider.displayLevel(eoVar.f148244a.f148245a.f148247b.f148231f);
        gLModelOverlayProvider.opacity((float) eoVar.f148244a.f148245a.f148247b.f148234i);
        gLModelOverlayProvider.visibility(!eoVar.f148244a.f148245a.f148247b.f148233h);
        return gLModelOverlayProvider;
    }
}
