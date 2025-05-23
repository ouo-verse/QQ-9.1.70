package com.tencent.mobileqq.troop.troopnotification.vm.processor;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopnotification.vm.processor.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0016\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0016\u0010\u000b\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/vm/processor/b;", "Lcom/tencent/mobileqq/troop/troopnotification/vm/processor/d;", "", "getTitle", "", "getCategory", "", "Lcom/tencent/qqnt/notification/f;", "notificationList", "", "b", "c", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b implements d {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.vm.processor.d
    @NotNull
    public List<com.tencent.qqnt.notification.f> a(@NotNull List<com.tencent.qqnt.notification.f> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this, (Object) list);
        }
        return d.a.a(this, list);
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.vm.processor.d
    public boolean b(@NotNull List<com.tencent.qqnt.notification.f> notificationList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) notificationList)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(notificationList, "notificationList");
        return false;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.vm.processor.d
    public boolean c(@NotNull List<com.tencent.qqnt.notification.f> notificationList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) notificationList)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(notificationList, "notificationList");
        return !notificationList.isEmpty();
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.vm.processor.d
    public int getCategory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return -1000;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.vm.processor.d
    @NotNull
    public String getTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        String qqStr = HardCodeUtil.qqStr(R.string.f235207b1);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(com.tencent.mobile\u2026_notification_suspicious)");
        return qqStr;
    }
}
