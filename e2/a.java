package e2;

import com.hihonor.cloudservice.support.account.request.SignInOptions;
import com.hihonor.cloudservice.support.api.entity.auth.Scope;
import com.hihonor.cloudservice.support.feature.request.AbstractSignInOptions;
import h45.b;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a extends g2.a {
    public a() {
    }

    public SignInOptions a() {
        return new SignInOptions(this.f401099a, this.f401100b, this.f401101c, this.f401102d, this.f401103e, this.f401104f, this.f401105g, this.f401106h, this.f401107i, this.f401108j, this.f401109k, this.f401110l);
    }

    public a b(String str) {
        this.f401101c = str;
        return this;
    }

    public a c() {
        return e(AbstractSignInOptions.L);
    }

    public a d() {
        return e(AbstractSignInOptions.J);
    }

    public a e(Scope scope) {
        this.f401099a.add(scope);
        return this;
    }

    public a f(List<Scope> list) {
        if (b.b(list)) {
            for (Scope scope : list) {
                if (scope != null && scope.a() != null) {
                    this.f401099a.add(scope);
                }
            }
        }
        return this;
    }

    public a(SignInOptions signInOptions) {
        this.f401099a.addAll(signInOptions.f());
        this.f401100b.addAll(signInOptions.c());
    }
}
