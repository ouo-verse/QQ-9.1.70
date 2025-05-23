package com.tencent.robot.profile.utils;

import androidx.core.util.Consumer;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "nickInfo", "Lcom/tencent/mobileqq/data/troop/TroopMemberNickInfo;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class RobotProfileUtils$getMemberNickByUin$1 extends Lambda implements Function1<TroopMemberNickInfo, Unit> {
    final /* synthetic */ Consumer<String> $consumer;
    final /* synthetic */ String $peerUin;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotProfileUtils$getMemberNickByUin$1(Consumer<String> consumer, String str) {
        super(1);
        this.$consumer = consumer;
        this.$peerUin = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TroopMemberNickInfo troopMemberNickInfo, Consumer consumer, String peerUin) {
        Intrinsics.checkNotNullParameter(consumer, "$consumer");
        Intrinsics.checkNotNullParameter(peerUin, "$peerUin");
        if (troopMemberNickInfo == null) {
            RobotProfileUtils.f368193a.F(peerUin, consumer);
        } else {
            consumer.accept(troopMemberNickInfo.getShowName(false, false));
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TroopMemberNickInfo troopMemberNickInfo) {
        invoke2(troopMemberNickInfo);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable final TroopMemberNickInfo troopMemberNickInfo) {
        final Consumer<String> consumer = this.$consumer;
        final String str = this.$peerUin;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.profile.utils.f
            @Override // java.lang.Runnable
            public final void run() {
                RobotProfileUtils$getMemberNickByUin$1.b(TroopMemberNickInfo.this, consumer, str);
            }
        }, 160, null, false);
    }
}
