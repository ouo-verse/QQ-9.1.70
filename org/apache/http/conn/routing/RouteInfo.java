package org.apache.http.conn.routing;

import java.net.InetAddress;
import org.apache.http.HttpHost;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public interface RouteInfo {

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum LayerType {
        LAYERED,
        PLAIN
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum TunnelType {
        PLAIN,
        TUNNELLED
    }

    int getHopCount();

    HttpHost getHopTarget(int i3);

    LayerType getLayerType();

    InetAddress getLocalAddress();

    HttpHost getProxyHost();

    HttpHost getTargetHost();

    TunnelType getTunnelType();

    boolean isLayered();

    boolean isSecure();

    boolean isTunnelled();
}
