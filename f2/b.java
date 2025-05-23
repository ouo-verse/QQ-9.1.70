package f2;

import android.app.Activity;
import android.content.Intent;
import com.hihonor.cloudservice.support.account.request.SignInOptions;
import q.q.q.w.q.c;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b extends com.hihonor.cloudservice.common.a<SignInOptions> implements a {

    /* renamed from: d, reason: collision with root package name */
    public static final c<SignInOptions> f397705d = new c<>("SignInAccountInfo.API");

    public b(Activity activity, SignInOptions signInOptions) {
        super(activity, f397705d, signInOptions);
    }

    @Override // h2.a
    public Intent getSignInIntent() {
        return d2.a.b(d(), a());
    }
}
