package com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\tJ1\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004\"\u0004\u0018\u00010\u0001H&\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/IQAdRewardMgrListener;", "", "", "adPlayStatus", "", "params", "", "a", "(I[Ljava/lang/Object;)V", "AdPlayStatus", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes19.dex */
public interface IQAdRewardMgrListener {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/IQAdRewardMgrListener$AdPlayStatus;", "", "Companion", "a", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes19.dex */
    public @interface AdPlayStatus {
        public static final int CLOSE_REWARD_AD_PAGE = 8;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.f304186a;
        public static final int DOWNLOAD_PROGRESS_CHANGE = 13;
        public static final int DOWNLOAD_UI_STATE_CHANGE = 14;
        public static final int ENTER_VIP_CLICK = 15;
        public static final int MULTI_AD_UNLOCK_FAIL = 12;
        public static final int MULTI_AD_UNLOCK_SUCCESS = 11;
        public static final int OPEN_REWARD_AD_PAGE = 4;
        public static final int REQUEST_ERROR = 3;
        public static final int REQUEST_PREPARED = 2;
        public static final int REQUEST_PREPARING = 1;
        public static final int REWARD_DIALOG_CLOSE_CLICK = 16;
        public static final int REWARD_NEED_LOGIN = 9;
        public static final int TRY_UNLOCK = 10;
        public static final int UNKNOWN = 0;
        public static final int UNLOCK_ERROR = 7;
        public static final int UNLOCK_PREPARING = 5;
        public static final int UNLOCK_SUCCESS = 6;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/IQAdRewardMgrListener$AdPlayStatus$a;", "", "<init>", "()V", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.IQAdRewardMgrListener$AdPlayStatus$a, reason: from kotlin metadata */
        /* loaded from: classes19.dex */
        public static final class Companion {

            /* renamed from: a, reason: collision with root package name */
            static final /* synthetic */ Companion f304186a = new Companion();

            Companion() {
            }
        }
    }

    void a(@AdPlayStatus int adPlayStatus, @NotNull Object... params);
}
