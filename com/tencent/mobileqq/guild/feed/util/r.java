package com.tencent.mobileqq.guild.feed.util;

import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/r;", "", "", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final r f223924a = new r();

    r() {
    }

    public final boolean a() {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity("exp_sgrp_channel_home_time_feed_tab");
        Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance().getExpEnti\u2026ANNEL_HOME_TIME_FEED_TAB)");
        expEntity.reportExpExposure();
        if (expEntity.isExperiment("exp_sgrp_channel_home_time_feed_tab_A")) {
            return false;
        }
        if (!expEntity.isExperiment("exp_sgrp_channel_home_time_feed_tab_B")) {
            expEntity.isExperiment("exp_sgrp_channel_home_time_feed_tab_C");
        }
        return true;
    }
}
