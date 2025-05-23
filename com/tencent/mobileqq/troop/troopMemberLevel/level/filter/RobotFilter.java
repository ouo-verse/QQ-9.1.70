package com.tencent.mobileqq.troop.troopmemberlevel.level.filter;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/troopmemberlevel/level/filter/RobotFilter;", "Lcom/tencent/mobileqq/troop/troopmemberlevel/level/filter/a;", "Lcom/tencent/mobileqq/troop/troopmemberlevel/level/filter/b;", "filterArgs", "", "a", "", "b", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class RobotFilter implements a {
    static IPatchRedirector $redirector_;

    public RobotFilter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopmemberlevel.level.filter.a
    public boolean a(@NotNull b filterArgs) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) filterArgs)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(filterArgs, "filterArgs");
        return !((ITroopRobotService) filterArgs.a().getRuntimeService(ITroopRobotService.class, "")).isRobotUin(filterArgs.b().getMsgRecord().senderUin);
    }

    @Override // com.tencent.mobileqq.troop.troopmemberlevel.level.filter.a
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return 3;
        }
        return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
    }
}
