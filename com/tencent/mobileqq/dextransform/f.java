package com.tencent.mobileqq.dextransform;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.dexasm.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import java.util.Set;
import javax.annotation.Nonnull;
import org.jf.dexlib2.HiddenApiRestriction;
import org.jf.dexlib2.Opcodes;
import org.jf.dexlib2.iface.MethodParameter;

/* compiled from: P */
/* loaded from: classes10.dex */
public class f extends com.tencent.mobileqq.dexasm.e {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private final b f203550c;

    /* renamed from: d, reason: collision with root package name */
    private final i f203551d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f203552e;

    /* renamed from: f, reason: collision with root package name */
    private String f203553f;

    public f(Opcodes opcodes, com.tencent.mobileqq.dexasm.e eVar, @NonNull b bVar, @NonNull i iVar) {
        super(opcodes, eVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, opcodes, eVar, bVar, iVar);
        } else {
            this.f203550c = bVar;
            this.f203551d = iVar;
        }
    }

    @Override // com.tencent.mobileqq.dexasm.e
    public void a(String str, int i3, @Nullable String str2, @NonNull List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), str2, list);
            return;
        }
        super.a(str, i3, str2, list);
        this.f203552e = this.f203550c.a(str);
        this.f203553f = str;
    }

    @Override // com.tencent.mobileqq.dexasm.e
    public k e(@NonNull String str, @NonNull List<? extends MethodParameter> list, @NonNull String str2, int i3, @Nonnull Set<HiddenApiRestriction> set) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (k) iPatchRedirector.redirect((short) 3, this, str, list, str2, Integer.valueOf(i3), set);
        }
        if (this.f203552e) {
            return super.e(str, list, str2, i3, set);
        }
        return new g(this.f203495a, super.e(str, list, str2, i3, set), str, this.f203550c, this.f203551d, this.f203553f);
    }
}
