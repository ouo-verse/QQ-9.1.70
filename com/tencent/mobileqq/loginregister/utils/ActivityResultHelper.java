package com.tencent.mobileqq.loginregister.utils;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ActivityResultHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final ForResultFragment f243036a;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class ForResultFragment extends QBaseFragment {
        static IPatchRedirector $redirector_;
        private static final Map<Integer, b> F;
        private static final AtomicInteger G;
        private final HashMap<Integer, Integer> C;
        private final List<a> D;
        private final List<c> E;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32462);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 7)) {
                redirector.redirect((short) 7);
            } else {
                F = new HashMap();
                G = new AtomicInteger(0);
            }
        }

        public ForResultFragment() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.C = new HashMap<>();
            this.D = new LinkedList();
            this.E = new LinkedList();
        }

        @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
        public void onActivityResult(int i3, int i16, @Nullable Intent intent) {
            b remove;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
                return;
            }
            super.onActivityResult(i3, i16, intent);
            if (QLog.isColorLevel()) {
                QLog.d("ActivityResultHelper", 2, "onActivityResult requestCode=" + i3 + " resultCode=" + i16);
            }
            Integer remove2 = this.C.remove(Integer.valueOf(i3));
            if (remove2 != null && (remove = F.remove(remove2)) != null) {
                remove.onActivityResult(i3, i16, intent);
            }
        }

        @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
        public void onCreate(@Nullable Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
                return;
            }
            super.onCreate(bundle);
            Iterator<c> it = this.E.iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
            this.E.clear();
            for (a aVar : this.D) {
                startActivityForResult(aVar.f243037a, aVar.f243038b);
            }
            this.D.clear();
            if (bundle != null) {
                Serializable serializable = bundle.getSerializable("ForResultFragment_requestCodeCallbackKey");
                this.C.clear();
                if (serializable != null) {
                    this.C.putAll((Map) serializable);
                }
            }
        }

        @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
        public void onSaveInstanceState(@NonNull Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
            } else {
                super.onSaveInstanceState(bundle);
                bundle.putSerializable("ForResultFragment_requestCodeCallbackKey", this.C);
            }
        }

        void ph(c cVar) {
            if (getHost() == null) {
                this.E.add(cVar);
            } else {
                cVar.a(this);
            }
        }

        @MainThread
        public void qh(int i3, b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) bVar);
                return;
            }
            int incrementAndGet = G.incrementAndGet();
            F.put(Integer.valueOf(incrementAndGet), bVar);
            this.C.put(Integer.valueOf(i3), Integer.valueOf(incrementAndGet));
        }

        @Override // androidx.fragment.app.Fragment
        public void startActivityForResult(Intent intent, int i3, @Nullable Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, intent, Integer.valueOf(i3), bundle);
                return;
            }
            if (getHost() == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("ActivityResultHelper", 2, "startActivityForResult pending, requestCode=" + i3);
                }
                this.D.add(new a(intent, i3));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ActivityResultHelper", 2, "startActivityForResult requestCode=" + i3);
            }
            super.startActivityForResult(intent, i3, bundle);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        Intent f243037a;

        /* renamed from: b, reason: collision with root package name */
        int f243038b;

        a(Intent intent, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent, i3);
            } else {
                this.f243037a = intent;
                this.f243038b = i3;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface b {
        void onActivityResult(int i3, int i16, Intent intent);
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface c {
        void a(ForResultFragment forResultFragment);
    }

    public ActivityResultHelper(FragmentActivity fragmentActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fragmentActivity);
        } else {
            this.f243036a = a(fragmentActivity);
        }
    }

    private ForResultFragment a(FragmentActivity fragmentActivity) {
        Fragment findFragmentByTag = fragmentActivity.getSupportFragmentManager().findFragmentByTag("fragment_tag_start_activity_for_result");
        if (findFragmentByTag instanceof ForResultFragment) {
            return (ForResultFragment) findFragmentByTag;
        }
        FragmentTransaction beginTransaction = fragmentActivity.getSupportFragmentManager().beginTransaction();
        if (findFragmentByTag != null) {
            beginTransaction.remove(findFragmentByTag);
        }
        ForResultFragment forResultFragment = new ForResultFragment();
        beginTransaction.add(forResultFragment, "fragment_tag_start_activity_for_result");
        beginTransaction.commitAllowingStateLoss();
        return forResultFragment;
    }

    @MainThread
    public void b(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
        } else {
            this.f243036a.ph(cVar);
        }
    }
}
