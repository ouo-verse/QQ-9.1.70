package com.tencent.mobileqq.dextransform;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Iterator;
import java.util.regex.Matcher;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.Instruction;
import org.jf.dexlib2.iface.reference.MethodReference;
import org.jf.dexlib2.immutable.ImmutableMethodParameter;
import org.jf.dexlib2.immutable.util.ParamUtil;

/* compiled from: P */
/* loaded from: classes10.dex */
public class e extends com.tencent.mobileqq.dextransform.a {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    public String f203546h;

    /* renamed from: i, reason: collision with root package name */
    public String f203547i;

    /* renamed from: j, reason: collision with root package name */
    public String f203548j;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    static /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f203549a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11852);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[Opcode.values().length];
            f203549a = iArr;
            try {
                iArr[Opcode.INVOKE_STATIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f203549a[Opcode.INVOKE_STATIC_RANGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f203549a[Opcode.INVOKE_VIRTUAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f203549a[Opcode.INVOKE_SUPER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f203549a[Opcode.INVOKE_DIRECT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f203549a[Opcode.INVOKE_INTERFACE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f203549a[Opcode.INVOKE_VIRTUAL_RANGE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f203549a[Opcode.INVOKE_SUPER_RANGE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f203549a[Opcode.INVOKE_DIRECT_RANGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f203549a[Opcode.INVOKE_INTERFACE_RANGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public e(@NonNull InjectAction injectAction, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull String str5, @NonNull String str6) {
        super(injectAction, str4, str5, str6);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, injectAction, str, str2, str3, str4, str5, str6);
            return;
        }
        this.f203546h = str;
        this.f203547i = str2;
        this.f203548j = str3;
    }

    private boolean h() {
        InjectAction injectAction = this.f203532a;
        if (injectAction != InjectAction.METHOD_REPLACE && injectAction != InjectAction.METHOD_ENTER && injectAction != InjectAction.METHOD_EXIT) {
            return false;
        }
        return true;
    }

    private boolean j() {
        InjectAction injectAction = this.f203532a;
        if (injectAction != InjectAction.STATIC_METHOD_REPLACE && injectAction != InjectAction.STATIC_METHOD_ENTER && injectAction != InjectAction.STATIC_METHOD_EXIT) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.dextransform.a
    protected boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (!j() && !h()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.dextransform.a
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (!super.e()) {
            return false;
        }
        if (j()) {
            return this.f203548j.equals(this.f203535d);
        }
        if (!h()) {
            return false;
        }
        Matcher matcher = com.tencent.mobileqq.dextransform.a.f203531g.matcher(this.f203548j);
        if (!matcher.matches()) {
            return false;
        }
        a();
        if (!matcher.group(2).equals(this.f203537f)) {
            return false;
        }
        String group = matcher.group(1);
        Iterator<ImmutableMethodParameter> it = ParamUtil.parseParamString(this.f203536e).iterator();
        if (!it.hasNext() || !it.next().getType().equals(this.f203546h)) {
            return false;
        }
        Iterator<ImmutableMethodParameter> it5 = ParamUtil.parseParamString(group).iterator();
        while (it.hasNext() && it5.hasNext()) {
            if (!it.next().getType().equals(it5.next().getType())) {
                return false;
            }
        }
        if (it.hasNext() || it5.hasNext()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.dextransform.a
    protected boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (this.f203546h != null && this.f203547i != null && this.f203548j != null) {
            return true;
        }
        return false;
    }

    public boolean g(@NonNull Instruction instruction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) instruction)).booleanValue();
        }
        switch (a.f203549a[instruction.getOpcode().ordinal()]) {
            case 1:
            case 2:
                return j();
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                return h();
            default:
                return false;
        }
    }

    public boolean i(@NonNull MethodReference methodReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) methodReference)).booleanValue();
        }
        if (methodReference.getDefiningClass().equals(this.f203546h) && methodReference.getName().equals(this.f203547i) && j.b(methodReference).equals(this.f203548j)) {
            return true;
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "MethodInjectConfig{action=" + this.f203532a + ", destClass='" + this.f203533b + "', destMethod='" + this.f203534c + "', destMethodDesc='" + this.f203535d + "', srcClass='" + this.f203546h + "', srcMethod='" + this.f203547i + "', srcMethodDesc='" + this.f203548j + "'}";
    }
}
