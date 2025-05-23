package com.tencent.gdtad.basics.motivevideo.hippy;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment;
import mqq.util.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtBaseDialogFragment extends ReportAndroidXDialogFragment {
    a C;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class a extends AndroidViewModel {

        /* renamed from: i, reason: collision with root package name */
        private final MutableLiveData<Boolean> f108951i;

        public a(@NonNull Application application) {
            super(application);
            this.f108951i = new MutableLiveData<>();
        }

        public MutableLiveData<Boolean> L1() {
            return this.f108951i;
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    private static class b implements Observer<Boolean> {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<FragmentActivity> f108952d;

        /* renamed from: e, reason: collision with root package name */
        private final WeakReference<GdtBaseDialogFragment> f108953e;

        /* renamed from: f, reason: collision with root package name */
        private final String f108954f;

        public b(WeakReference<FragmentActivity> weakReference, WeakReference<GdtBaseDialogFragment> weakReference2, String str) {
            this.f108952d = weakReference;
            this.f108953e = weakReference2;
            this.f108954f = str;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            FragmentActivity fragmentActivity;
            WeakReference<FragmentActivity> weakReference = this.f108952d;
            GdtBaseDialogFragment gdtBaseDialogFragment = null;
            if (weakReference != null) {
                fragmentActivity = weakReference.get();
            } else {
                fragmentActivity = null;
            }
            WeakReference<GdtBaseDialogFragment> weakReference2 = this.f108953e;
            if (weakReference2 != null) {
                gdtBaseDialogFragment = weakReference2.get();
            }
            if (bool != null && fragmentActivity != null && gdtBaseDialogFragment != null) {
                QLog.i(this.f108954f, 1, "[GdtBaseDialogObserver][onChanged] isShow:" + bool);
                try {
                    if (bool.booleanValue()) {
                        gdtBaseDialogFragment.show(fragmentActivity.getSupportFragmentManager(), this.f108954f);
                    } else {
                        gdtBaseDialogFragment.C.L1().removeObservers(gdtBaseDialogFragment);
                        gdtBaseDialogFragment.dismiss();
                    }
                    return;
                } catch (Throwable th5) {
                    QLog.e(this.f108954f, 1, "[GdtBaseDialogObserver][onChanged]", th5);
                    return;
                }
            }
            QLog.e(this.f108954f, 1, "[GdtBaseDialogObserver][onChanged] error, not valid");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ph() {
        a aVar = this.C;
        if (aVar == null) {
            QLog.e(getTag(), 1, "[dismissSafely] error, mBaseDialogViewModel is null");
            return;
        }
        try {
            aVar.L1().postValue(Boolean.FALSE);
        } catch (Throwable th5) {
            QLog.e(getTag(), 1, "[dismissSafely]", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qh(FragmentActivity fragmentActivity, String str) {
        try {
            if (this.C == null) {
                this.C = (a) new ViewModelProvider(fragmentActivity).get(a.class);
            }
            this.C.L1().setValue(null);
            this.C.L1().removeObservers(fragmentActivity);
            this.C.L1().observe(fragmentActivity, new b(new WeakReference(fragmentActivity), new WeakReference(this), str));
            this.C.L1().postValue(Boolean.TRUE);
        } catch (Throwable th5) {
            QLog.e(getTag(), 1, "[showSafely]", th5);
        }
    }
}
