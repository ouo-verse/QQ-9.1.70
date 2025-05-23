package com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/utils/QAdRewardDefine$ErrorCode", "", "Companion", "a", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes19.dex */
public @interface QAdRewardDefine$ErrorCode {
    public static final int CODE_DNS_TIMEOUT = -829;
    public static final int CODE_HTTP_CONNECT_TIMEOUT = -822;
    public static final int CODE_HTTP_SOCKET_TIMEOUT = -823;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f304317a;
    public static final int LOAD_ERROR_FREQUENCY = 1005;
    public static final int LOAD_HAS_UNLOCK = 1002;
    public static final int LOAD_NETWORK_ERROR = 1000;
    public static final int LOAD_OUT_OF_TIME = 1003;
    public static final int LOAD_PARAMS_ERROR = 1001;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/utils/QAdRewardDefine$ErrorCode$a;", "", "<init>", "()V", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$ErrorCode$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f304317a = new Companion();

        Companion() {
        }
    }
}
