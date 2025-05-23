package com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils;

import com.tencent.tmdownloader.a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/utils/QAdRewardDefine$QAdPlayerViewStatus", "", "Companion", "a", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes19.dex */
public @interface QAdRewardDefine$QAdPlayerViewStatus {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f304322d;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\r\u0010\b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/utils/QAdRewardDefine$QAdPlayerViewStatus$a;", "", "", "a", "I", "c", "()I", "setINIT", "(I)V", a.CONNTECTSTATE_INIT, "b", "setFIRST_CREATE", "FIRST_CREATE", "setDESTORY", "DESTORY", "<init>", "()V", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$QAdPlayerViewStatus$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private static int INIT;

        /* renamed from: d, reason: collision with root package name */
        static final /* synthetic */ Companion f304322d = new Companion();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private static int FIRST_CREATE = 2;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private static int DESTORY = 3;

        Companion() {
        }

        public final int a() {
            return DESTORY;
        }

        public final int b() {
            return FIRST_CREATE;
        }

        public final int c() {
            return INIT;
        }
    }
}
