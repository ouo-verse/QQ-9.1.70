package ar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.aelight.camera.aeeditor.arch.AEEditorBaseFragment;
import com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImageEditFragment;
import com.tencent.aelight.camera.aeeditor.module.edit.AEEditorVideoEditFragment;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.BaseConstants;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    private static final String f26761c = "b";

    /* renamed from: a, reason: collision with root package name */
    private FragmentManager f26762a;

    /* renamed from: b, reason: collision with root package name */
    private HashMap<Class<? extends AEEditorBaseFragment>, AEEditorBaseFragment> f26763b = new HashMap<>();

    public b(FragmentManager fragmentManager) {
        this.f26762a = fragmentManager;
    }

    private void j(AEEditorBaseFragment aEEditorBaseFragment, Class<? extends AEEditorBaseFragment> cls, String str, Bundle bundle, boolean z16, boolean z17) {
        AEEditorBaseFragment aEEditorBaseFragment2;
        if (this.f26763b.containsKey(cls) && this.f26763b.get(cls) != null) {
            aEEditorBaseFragment2 = this.f26763b.get(cls);
            aEEditorBaseFragment2.rh(this);
        } else {
            try {
                AEEditorBaseFragment newInstance = cls.newInstance();
                newInstance.rh(this);
                aEEditorBaseFragment2 = newInstance;
            } catch (IllegalAccessException e16) {
                ms.a.c(f26761c, "replaceFragment: " + Log.getStackTraceString(e16));
                return;
            } catch (InstantiationException e17) {
                ms.a.c(f26761c, "replaceFragment: " + Log.getStackTraceString(e17));
                return;
            }
        }
        if (aEEditorBaseFragment2.getArguments() == null) {
            aEEditorBaseFragment2.setArguments(bundle);
        } else {
            aEEditorBaseFragment2.getArguments().putAll(bundle);
        }
        aEEditorBaseFragment2.D = str;
        FragmentTransaction beginTransaction = this.f26762a.beginTransaction();
        Class<? extends AEEditorBaseFragment> cls2 = null;
        for (Map.Entry<Class<? extends AEEditorBaseFragment>, AEEditorBaseFragment> entry : this.f26763b.entrySet()) {
            if (z16 && aEEditorBaseFragment != null && entry.getValue().equals(aEEditorBaseFragment)) {
                cls2 = entry.getKey();
            } else {
                beginTransaction.hide(entry.getValue());
            }
        }
        if (z16 && aEEditorBaseFragment != null) {
            if (cls2 != null) {
                this.f26763b.remove(cls2);
            }
            beginTransaction.remove(aEEditorBaseFragment);
        }
        if (this.f26762a.findFragmentByTag(cls.getName()) == null) {
            beginTransaction.add(R.id.rnx, aEEditorBaseFragment2, cls.getName()).commit();
        } else {
            beginTransaction.show(aEEditorBaseFragment2).commit();
        }
        this.f26763b.put(cls, aEEditorBaseFragment2);
    }

    public void b(int i3, int i16, Intent intent) {
        AEEditorBaseFragment e16 = e();
        if (e16 != null) {
            e16.doOnActivityResult(i3, i16, intent);
        }
    }

    public void c(boolean z16) {
        AEEditorBaseFragment e16 = e();
        if (e16 != null) {
            e16.onWindowFocusChanged(z16);
        }
    }

    public void d(Bundle bundle) {
        ms.a.f(f26761c, BaseConstants.BROADCAST_USERSYNC_ENTER);
        if (a.a(bundle)) {
            h(null, bundle);
        } else if (a.d(bundle)) {
            i(null, bundle);
        } else {
            if (a.b(bundle)) {
                i(null, bundle);
                return;
            }
            throw new RuntimeException("invalid editor type");
        }
    }

    public AEEditorBaseFragment e() {
        for (Map.Entry<Class<? extends AEEditorBaseFragment>, AEEditorBaseFragment> entry : this.f26763b.entrySet()) {
            if (entry.getValue().isVisible()) {
                return entry.getValue();
            }
        }
        return null;
    }

    public void h(String str, Bundle bundle) {
        ms.a.f(f26761c, "gotoImageEditModule from " + str);
        k(AEEditorImageEditFragment.class, str, bundle);
    }

    public void i(String str, Bundle bundle) {
        ms.a.f(f26761c, "gotoVideoEditModule from " + str);
        k(AEEditorVideoEditFragment.class, str, bundle);
    }

    public void g(Activity activity) {
        f(activity, false);
    }

    public void a(Activity activity) {
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    public void f(Activity activity, boolean z16) {
        AEEditorBaseFragment e16;
        if (activity == null || (e16 = e()) == null) {
            return;
        }
        boolean z17 = false;
        if (e16.isVisible() && z16) {
            z17 = false | e16.qh();
        }
        if (z17) {
            return;
        }
        try {
            e16.doOnBackPressed();
            String str = e16.D;
            if (str == null) {
                ms.a.f(f26761c, "goBack finish activity");
                a(activity);
                activity.finish();
            } else if (str.equals("AEEditorImageEdit") && e16.getModuleId().equals("AEEditorVideoEdit")) {
                h(null, new Bundle(e16.getArguments()));
            }
        } catch (Throwable th5) {
            ms.a.c(f26761c, Log.getStackTraceString(th5));
        }
    }

    private void k(Class<? extends AEEditorBaseFragment> cls, String str, Bundle bundle) {
        j(null, cls, str, bundle, false, false);
    }
}
