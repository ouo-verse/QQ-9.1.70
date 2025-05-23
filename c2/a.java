package c2;

import android.app.Activity;
import android.content.Intent;
import com.hihonor.cloudservice.support.account.request.SignInOptions;
import com.hihonor.cloudservice.support.account.result.SignInAccountInfo;
import com.hihonor.cloudservice.tasks.f;
import f2.b;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class a {
    public static f2.a a(Activity activity, SignInOptions signInOptions) {
        h45.a.a(activity, "Null activity is not permitted.");
        return new b(activity, signInOptions);
    }

    public static f<SignInAccountInfo> b(int i3, Intent intent) {
        return d2.a.a(i3, intent);
    }

    public static f<SignInAccountInfo> c(Intent intent) {
        return b(-2, intent);
    }
}
