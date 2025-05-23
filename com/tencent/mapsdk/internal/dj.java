package com.tencent.mapsdk.internal;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.map.tools.net.NetMethod;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetRequest;
import com.tencent.mapsdk.internal.cp;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface dj extends cp.a {
    @NetRequest(constQuery = "styleid=7", method = NetMethod.URL, path = "scenic/", queryKeys = {HippyTKDListViewAdapter.X, "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "version"}, useExtraQuery = false)
    String sketchTileUrl(int i3, int i16, int i17, int i18);
}
