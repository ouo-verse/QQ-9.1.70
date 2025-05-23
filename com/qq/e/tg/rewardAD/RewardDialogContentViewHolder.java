package com.qq.e.tg.rewardAD;

import android.view.View;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class RewardDialogContentViewHolder {

    /* renamed from: a, reason: collision with root package name */
    private ContentViewUpdateListener f40607a;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class ActionType {
        public static final int EXIT = 1;
        public static final int ONE_MORE = 3;
        public static final int RESUME = 2;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class AdType {
        public static final int BROWSER = 2;
        public static final int VIDEO = 1;
        public static final int VIDEO_CEILING = 3;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface ContentViewUpdateListener {
        View update(Map map);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface Key {
        public static final String HAD_REWARDED = "hadRewarded";
        public static final String REWARD_AD_PLAYED_TIME = "rewardAdPlayedTime";
        public static final String REWARD_AD_TYPE = "rewardAdType";
        public static final String REWARD_TIME = "rewardTime";
        public static final String REWARD_VIDEO_DURATION = "rewardVideoDuration";
        public static final String SCREEN_ORIENTATION = "screenOrientation";
    }

    public RewardDialogContentViewHolder(ContentViewUpdateListener contentViewUpdateListener) {
        this.f40607a = contentViewUpdateListener;
    }

    public ContentViewUpdateListener getContentViewUpdateListener() {
        return this.f40607a;
    }
}
