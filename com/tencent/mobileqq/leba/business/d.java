package com.tencent.mobileqq.leba.business;

import android.content.Context;
import com.tencent.mobileqq.leba.l;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import java.util.Map;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public abstract class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected Map<Long, com.tencent.mobileqq.leba.entity.g> f240102a;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    protected int a(RedTouch redTouch) {
        BusinessInfoCheckUpdate.RedTypeInfo redType;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) redTouch)).intValue();
        }
        if (redTouch == null || !redTouch.hasLebaRedTouch() || (redType = redTouch.getRedType()) == null) {
            return 0;
        }
        if (redType.red_type.get() == 0) {
            return 1;
        }
        if (redType.red_type.get() == 5) {
            return 2;
        }
        redType.red_type.get();
        return 3;
    }

    public abstract boolean b(AppRuntime appRuntime, Context context, long j3, RedTouch redTouch, String str, Map<Long, com.tencent.mobileqq.leba.entity.g> map, int i3, boolean z16);

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(long j3, RedTouch redTouch) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), redTouch);
            return;
        }
        if (this.f240102a == null) {
            return;
        }
        int b16 = l.b(redTouch);
        if (b16 == 0) {
            b16 = a(redTouch);
        }
        if (b16 != 0) {
            this.f240102a.put(Long.valueOf(j3), new com.tencent.mobileqq.leba.entity.g(b16, l.a(redTouch)));
        }
    }
}
