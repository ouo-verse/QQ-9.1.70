package com.tencent.mobileqq.anim;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.anim.aio.AIOAnimationConfig;
import com.tencent.mobileqq.anim.aio.AIOTransitionAnimationSwitch;
import com.tencent.mobileqq.app.anim.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/anim/a;", "Lcom/tencent/mobileqq/app/anim/a;", "Lcom/tencent/mobileqq/app/anim/a$a;", "b", "a", "<init>", "()V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public class a implements com.tencent.mobileqq.app.anim.a {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.anim.a
    @NotNull
    public a.C7373a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a.C7373a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        AIOAnimationConfig aIOAnimationConfig = AIOAnimationConfig.f194304a;
        if (aIOAnimationConfig.d()) {
            if (aIOAnimationConfig.e()) {
                return new a.C7373a(R.anim.f154444la, R.anim.f154438l6);
            }
            return new a.C7373a(R.anim.l_, R.anim.f154437l5);
        }
        if (AIOTransitionAnimationSwitch.f194307a.a()) {
            return new a.C7373a(R.anim.l3, R.anim.f154439l7);
        }
        return new a.C7373a(R.anim.f154435l2, R.anim.f154436l4);
    }

    @Override // com.tencent.mobileqq.app.anim.a
    @NotNull
    public a.C7373a b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a.C7373a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        AIOAnimationConfig aIOAnimationConfig = AIOAnimationConfig.f194304a;
        if (aIOAnimationConfig.d()) {
            if (aIOAnimationConfig.e()) {
                return new a.C7373a(R.anim.f154447ld, R.anim.f154444la);
            }
            return new a.C7373a(R.anim.f154446lc, R.anim.l_);
        }
        if (AIOTransitionAnimationSwitch.f194307a.a()) {
            return new a.C7373a(R.anim.f154448le, R.anim.f154450lg);
        }
        return new a.C7373a(R.anim.f154445lb, R.anim.f154449lf);
    }
}
