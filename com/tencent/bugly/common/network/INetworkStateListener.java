package com.tencent.bugly.common.network;

import com.tencent.ams.adcore.mma.api.Global;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/bugly/common/network/INetworkStateListener;", "", "onNetworkStateChanged", "", "state", "", "Companion", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public interface INetworkStateListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int DISCONNECTED = 3;
    public static final int MOBILE = 2;
    public static final int WIFI = 1;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/bugly/common/network/INetworkStateListener$Companion;", "", "()V", "DISCONNECTED", "", "MOBILE", Global.TRACKING_WIFI, "bugly-common_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int DISCONNECTED = 3;
        public static final int MOBILE = 2;
        public static final int WIFI = 1;

        Companion() {
        }
    }

    void onNetworkStateChanged(int state);
}
