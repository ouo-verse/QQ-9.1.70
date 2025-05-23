package com.huawei.hms.hihealth.options;

import android.os.Parcelable;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.health.aabq;
import com.huawei.hms.health.aabv;
import com.huawei.hms.health.aabw;
import com.huawei.hms.health.aaby;
import com.huawei.hms.health.aacc;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ActivityBeginOptions extends aabq {
    public static final Parcelable.Creator<ActivityBeginOptions> CREATOR = new aabq.aab(ActivityBeginOptions.class);

    @aaby(id = 1)
    private final String mActivityType;

    @aaby(id = 2)
    private final String mAppType;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Builder {
        private String mActivityType;
        private String mAppType;

        public Builder(String str) {
            boolean z16;
            if (aacc.aab(str) != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            Preconditions.checkArgument(z16, "The activityType is not supported!");
            this.mActivityType = str;
        }

        public ActivityBeginOptions build() {
            Preconditions.checkNotNull(this.mActivityType, "activity name should not be null");
            return new ActivityBeginOptions(this);
        }

        public Builder setAppType(String str) {
            this.mAppType = str;
            return this;
        }
    }

    ActivityBeginOptions(Builder builder) {
        this(builder.mActivityType, builder.mAppType);
    }

    public String getActivityType() {
        return this.mActivityType;
    }

    public String getAppType() {
        return this.mAppType;
    }

    @aabw
    ActivityBeginOptions(@aabv(id = 1) String str, @aabv(id = 2) String str2) {
        Preconditions.checkNotNull(str, "activity name should not be null");
        this.mActivityType = str;
        this.mAppType = str2;
    }
}
