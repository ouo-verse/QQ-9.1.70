package com.tencent.mobileqq.troop.homework.clockin.time.part;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/time/part/j;", "Lcom/tencent/mobileqq/troop/homework/clockin/time/part/BaseClockInTimeSettingPart;", "", "B9", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class j extends BaseClockInTimeSettingPart {
    static IPatchRedirector $redirector_;

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.clockin.time.part.BaseClockInTimeSettingPart
    public void B9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        L9(new com.tencent.mobileqq.troop.homework.clockin.time.repo.b());
        View findViewById = getPartRootView().findViewById(R.id.f164817tz0);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026in_time_limit_view_group)");
        M9((ViewGroup) findViewById);
        View findViewById2 = getPartRootView().findViewById(R.id.tyz);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.clock_in_time_limit)");
        K9((TextView) findViewById2);
    }
}
