package com.tencent.robot.timbre.setting;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public /* synthetic */ class RobotTimbreSettingFragment$createTimbreSettingConfigs$1$1$1 extends FunctionReferenceImpl implements Function2<k, Boolean, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public RobotTimbreSettingFragment$createTimbreSettingConfigs$1$1$1(Object obj) {
        super(2, obj, RobotTimbreSettingFragment.class, "onPlayAndSelected", "onPlayAndSelected(Lcom/tencent/robot/timbre/setting/RobotTimbreSettingItemConfig;Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(k kVar, Boolean bool) {
        invoke(kVar, bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull k p06, boolean z16) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((RobotTimbreSettingFragment) this.receiver).Oh(p06, z16);
    }
}
