package i4;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.qzone.adapter.feedcomponent.s;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes38.dex */
public abstract class a {

    /* renamed from: d, reason: collision with root package name */
    private final String f407173d = "AlbumBaseViewController";

    /* renamed from: e, reason: collision with root package name */
    protected final FragmentActivity f407174e;

    public a(FragmentActivity fragmentActivity) {
        this.f407174e = fragmentActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View F(int i3) {
        return this.f407174e.findViewById(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Intent G() {
        return this.f407174e.getIntent();
    }

    public Activity H() {
        return this.f407174e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String I(int i3) {
        return this.f407174e.getString(i3);
    }

    public boolean M(Activity activity) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U(Runnable runnable) {
        this.f407174e.runOnUiThread(runnable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V(Intent intent) {
        try {
            this.f407174e.startActivity(intent);
        } catch (Exception e16) {
            QZLog.w(e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void W(Intent intent, int i3) {
        try {
            this.f407174e.startActivityForResult(intent, i3);
        } catch (Exception e16) {
            QZLog.w(e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Resources getResources() {
        return this.f407174e.getResources();
    }

    public void J(s8.b bVar) {
    }

    public void L(boolean z16) {
    }

    public void N(Activity activity) {
    }

    public void O(Activity activity) {
    }

    public void P(Activity activity) {
    }

    public void S(Activity activity) {
    }

    public void K(s sVar, int i3) {
    }

    public void Q(Activity activity, Bundle bundle) {
    }

    public void T(Activity activity, Bundle bundle) {
    }

    public void R(Activity activity, int i3, int i16, Intent intent) {
    }
}
