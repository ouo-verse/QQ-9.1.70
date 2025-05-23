package com.tencent.bugly.common.network;

import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/bugly/common/network/NetworkState;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", HippyTextInputController.COMMAND_getValue, "()Ljava/lang/String;", "NETWORK_NONE", "NETWORK_WIFI", "NETWORK_2G", "NETWORK_3G", "NETWORK_4G", "NETWORK_MOBILE", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public enum NetworkState {
    NETWORK_NONE("NONE"),
    NETWORK_WIFI(Global.TRACKING_WIFI),
    NETWORK_2G("2G"),
    NETWORK_3G("3G"),
    NETWORK_4G("4G"),
    NETWORK_MOBILE("MOBILE");


    @NotNull
    private final String value;

    NetworkState(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
