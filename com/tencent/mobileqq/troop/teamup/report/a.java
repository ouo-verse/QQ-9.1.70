package com.tencent.mobileqq.troop.teamup.report;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.utils.h;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/report/a;", "Lcom/tencent/mobileqq/troop/utils/h;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a implements h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f299203a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56518);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f299203a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.h
    public void a(@NotNull View view, @NotNull String str, @NotNull ExposurePolicy exposurePolicy, @NotNull ClickPolicy clickPolicy, @Nullable IDynamicParams iDynamicParams, @Nullable View view2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, view, str, exposurePolicy, clickPolicy, iDynamicParams, view2);
        } else {
            h.a.l(this, view, str, exposurePolicy, clickPolicy, iDynamicParams, view2);
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.h
    public void b(@NotNull Activity activity, @NotNull String str, @NotNull HashMap<String, Object> hashMap, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, str, hashMap, Boolean.valueOf(z16));
        } else {
            h.a.c(this, activity, str, hashMap, z16);
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.h
    public void c(@NotNull View view, @Nullable String str, @Nullable HashMap<String, Object> hashMap, @Nullable View view2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, view, str, hashMap, view2);
        } else {
            h.a.i(this, view, str, hashMap, view2);
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.h
    public void d(@NotNull View view, @Nullable String str, @Nullable HashMap<String, Object> hashMap, @Nullable View view2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, view, str, hashMap, view2);
        } else {
            h.a.e(this, view, str, hashMap, view2);
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.h
    public void e(@NotNull View view, @NotNull String str, @Nullable HashMap<String, Object> hashMap, @NotNull ExposurePolicy exposurePolicy, @NotNull ClickPolicy clickPolicy, @Nullable View view2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, view, str, hashMap, exposurePolicy, clickPolicy, view2);
        } else {
            h.a.a(this, view, str, hashMap, exposurePolicy, clickPolicy, view2);
        }
    }
}
