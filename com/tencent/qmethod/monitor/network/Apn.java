package com.tencent.qmethod.monitor.network;

import com.tencent.mobileqq.auto.engine.loader.ASPluginBean;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qmethod/monitor/network/Apn;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "TYPE_INIT", "TYPE_UNKNOWN", ASPluginBean.TYPE_NET, "TYPE_WAP", "TYPE_WIFI", "T_APN_CMWAP", "T_APN_3GWAP", "T_APN_UNIWAP", "T_APN_CTWAP", "T_APN_CTNET", "T_APN_UNINET", "T_APN_3GNET", "T_APN_CMNET", "T_APN_CTLTE", "T_APN_WONET", "T_APN_CMLTE", "T_APN_CM3G", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public enum Apn {
    TYPE_INIT(-1),
    TYPE_UNKNOWN(0),
    TYPE_NET(1),
    TYPE_WAP(2),
    TYPE_WIFI(4),
    T_APN_CMWAP(8),
    T_APN_3GWAP(16),
    T_APN_UNIWAP(32),
    T_APN_CTWAP(64),
    T_APN_CTNET(128),
    T_APN_UNINET(256),
    T_APN_3GNET(512),
    T_APN_CMNET(1024),
    T_APN_CTLTE(2048),
    T_APN_WONET(4096),
    T_APN_CMLTE(8192),
    T_APN_CM3G(16384);

    private final int value;

    Apn(int i3) {
        this.value = i3;
    }

    public final int getValue() {
        return this.value;
    }
}
