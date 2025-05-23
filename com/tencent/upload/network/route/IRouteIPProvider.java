package com.tencent.upload.network.route;

import com.tencent.upload.network.route.ServerRouteTable;

/* loaded from: classes27.dex */
public interface IRouteIPProvider {
    String getBakIps();

    String getHostUrl();

    String getOptIps();

    ServerRouteTable.PriorityPolicy getPriorityPolicy();

    String getV6HostUrl();

    String getV6OptIps();
}
