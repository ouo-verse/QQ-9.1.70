package com.tencent.mapsdk.internal;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.map.tools.net.NetMethod;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetRequest;
import com.tencent.mapsdk.internal.cp;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface di extends cp.a {
    @NetRequest(constQuery = "styleid=0", method = NetMethod.URL, path = "satellite", queryKeys = {QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, HippyTKDListViewAdapter.X, "y", "version"}, useExtraQuery = false)
    String satelliteUrl(String str, String str2, String str3, String str4);

    @NetRequest(constQuery = "styleid=0", method = NetMethod.URL, path = "satellite", queryKeys = {QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, HippyTKDListViewAdapter.X, "y", "version"})
    String satelliteUrl2(String str, String str2, String str3, String str4);
}
