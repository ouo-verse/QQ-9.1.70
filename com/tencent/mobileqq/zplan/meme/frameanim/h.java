package com.tencent.mobileqq.zplan.meme.frameanim;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/frameanim/h;", "", "a", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/frameanim/h$a;", "", "Lcom/tencent/mobileqq/zplan/meme/frameanim/StrategyId;", "a", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.meme.frameanim.h$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final StrategyId a() {
            String zPlanQZoneAvatarPlayStrategy = ((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).getZPlanQZoneAvatarPlayStrategy();
            if (Intrinsics.areEqual(zPlanQZoneAvatarPlayStrategy, "ZPlanQZoneAvatarPlayStrategy")) {
                return StrategyId.ZPLAN_QZONE_AVATAR_PLAY_STRATEGY;
            }
            if (Intrinsics.areEqual(zPlanQZoneAvatarPlayStrategy, "QZoneExtStrategy")) {
                return StrategyId.QZONE_EXT_STATUS;
            }
            return StrategyId.QZONE_EXT_STATUS;
        }

        Companion() {
        }
    }
}
