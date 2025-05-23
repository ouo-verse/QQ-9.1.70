package com.tencent.mobileqq.onlinestatus.utils;

import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qqlive.tvkplayer.tools.config.ITVKConfigRequester;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/utils/ab;", "", "", ITVKConfigRequester.ConfigRequestListener.EXTRA_KEY_EXP_NAME, "Lcom/tencent/mobileqq/utils/abtest/ExpEntityInfo;", "b", "", "c", "", "a", "<init>", "()V", "qqonlinestatus-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class ab {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ab f256333a = new ab();

    ab() {
    }

    public final void a(@NotNull String expName) {
        Intrinsics.checkNotNullParameter(expName, "expName");
        b(expName).reportExpExposure();
    }

    @NotNull
    public final ExpEntityInfo b(@NotNull String expName) {
        Intrinsics.checkNotNullParameter(expName, "expName");
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(expName);
        Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance().getExpEntity(expName)");
        return expEntity;
    }

    public final boolean c(@NotNull String expName) {
        Intrinsics.checkNotNullParameter(expName, "expName");
        return b(expName).isExperiment();
    }
}
