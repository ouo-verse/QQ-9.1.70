package com.tencent.mobileqq.dextransform;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Iterator;
import org.jf.dexlib2.iface.reference.FieldReference;
import org.jf.dexlib2.immutable.ImmutableMethodParameter;
import org.jf.dexlib2.immutable.util.ParamUtil;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d extends com.tencent.mobileqq.dextransform.a {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    public String f203542h;

    /* renamed from: i, reason: collision with root package name */
    public String f203543i;

    /* renamed from: j, reason: collision with root package name */
    public String f203544j;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    static /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f203545a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11837);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[InjectAction.values().length];
            f203545a = iArr;
            try {
                iArr[InjectAction.GET_FIELD_REPLACE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f203545a[InjectAction.GET_STATIC_FIELD_REPLACE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f203545a[InjectAction.PUT_FIELD_REPLACE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f203545a[InjectAction.PUT_STATIC_FIELD_REPLACE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public d(InjectAction injectAction, String str, String str2, String str3, String str4, String str5, String str6) {
        super(injectAction, str4, str5, str6);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, injectAction, str, str2, str3, str4, str5, str6);
            return;
        }
        this.f203542h = str;
        this.f203543i = str2;
        this.f203544j = str3;
    }

    private boolean j(Iterator<ImmutableMethodParameter> it) {
        if (it.hasNext() && this.f203542h.equals(it.next().getType())) {
            return !it.hasNext();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.dextransform.a
    protected boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (!g() && !h()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.dextransform.a
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (!super.e()) {
            return false;
        }
        a();
        Iterator<ImmutableMethodParameter> it = ParamUtil.parseParamString(this.f203536e).iterator();
        int i3 = a.f203545a[this.f203532a.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return false;
                    }
                } else if (!j(it)) {
                    return false;
                }
                return "V".equals(this.f203537f);
            }
        } else if (!j(it)) {
            return false;
        }
        return this.f203544j.equals(this.f203537f);
    }

    @Override // com.tencent.mobileqq.dextransform.a
    protected boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (this.f203542h != null && this.f203543i != null && this.f203544j != null) {
            return true;
        }
        return false;
    }

    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        InjectAction injectAction = this.f203532a;
        if (injectAction != InjectAction.GET_FIELD_REPLACE && injectAction != InjectAction.GET_STATIC_FIELD_REPLACE) {
            return false;
        }
        return true;
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        InjectAction injectAction = this.f203532a;
        if (injectAction != InjectAction.PUT_FIELD_REPLACE && injectAction != InjectAction.PUT_STATIC_FIELD_REPLACE) {
            return false;
        }
        return true;
    }

    public boolean i(@NonNull FieldReference fieldReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) fieldReference)).booleanValue();
        }
        if (fieldReference.getDefiningClass().equals(this.f203542h) && fieldReference.getName().equals(this.f203543i) && fieldReference.getType().equals(this.f203544j)) {
            return true;
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "FieldInjectConfig{action=" + this.f203532a + ", destClass='" + this.f203533b + "', destMethod='" + this.f203534c + "', destMethodDesc='" + this.f203535d + "', destParams='" + this.f203536e + "', destReturnType='" + this.f203537f + "', srcClass='" + this.f203542h + "', srcField='" + this.f203543i + "', srcType='" + this.f203544j + "'}";
    }
}
