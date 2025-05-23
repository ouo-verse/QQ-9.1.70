package com.tencent.input.base.panelcontainer.keyboard;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0002J\"\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/input/base/panelcontainer/keyboard/e;", "", "", "orientation", "", "c", "Lpz0/a;", "mmkvAdapter", "a", "height", "", "d", "<init>", "()V", "input-base_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f116886a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35350);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f116886a = new e();
        }
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ int b(e eVar, pz0.a aVar, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        return eVar.a(aVar, i3);
    }

    private final String c(int orientation) {
        if (orientation == 1) {
            return "sp_key_keyboard_height";
        }
        return "sp_key_keyboard_height_not_portrait";
    }

    public static /* synthetic */ void e(e eVar, pz0.a aVar, int i3, int i16, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            i16 = 1;
        }
        eVar.d(aVar, i3, i16);
    }

    public final int a(@Nullable pz0.a mmkvAdapter, int orientation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) mmkvAdapter, orientation)).intValue();
        }
        if (mmkvAdapter == null) {
            return 0;
        }
        return mmkvAdapter.decodeInt(c(orientation), 0);
    }

    public final void d(@Nullable pz0.a mmkvAdapter, int height, int orientation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, mmkvAdapter, Integer.valueOf(height), Integer.valueOf(orientation));
        } else if (mmkvAdapter != null) {
            mmkvAdapter.encodeInt(c(orientation), height);
        }
    }
}
