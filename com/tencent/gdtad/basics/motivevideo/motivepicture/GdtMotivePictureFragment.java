package com.tencent.gdtad.basics.motivevideo.motivepicture;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.basics.motivevideo.n;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.io.Serializable;
import mqq.util.WeakReference;

/* loaded from: classes6.dex */
public final class GdtMotivePictureFragment extends QPublicBaseFragment {
    private GdtMvPictureViewController C;
    private GdtMotiveVideoModel D;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a implements n {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<GdtMotivePictureFragment> f109039a;

        public a(WeakReference<GdtMotivePictureFragment> weakReference) {
            this.f109039a = weakReference;
        }

        @Override // com.tencent.gdtad.basics.motivevideo.n
        public void finish() {
            GdtLog.i("GdtMotivePictureFragment", "[finish]");
            Activity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }

        @Override // com.tencent.gdtad.basics.motivevideo.n
        public Activity getActivity() {
            GdtMotivePictureFragment gdtMotivePictureFragment;
            WeakReference<GdtMotivePictureFragment> weakReference = this.f109039a;
            if (weakReference != null) {
                gdtMotivePictureFragment = weakReference.get();
            } else {
                gdtMotivePictureFragment = null;
            }
            if (gdtMotivePictureFragment == null) {
                return null;
            }
            return gdtMotivePictureFragment.getQBaseActivity();
        }

        @Override // com.tencent.gdtad.basics.motivevideo.n
        public void setResult(int i3, Intent intent) {
            GdtMotivePictureFragment gdtMotivePictureFragment;
            boolean z16;
            WeakReference<GdtMotivePictureFragment> weakReference = this.f109039a;
            ResultReceiver resultReceiver = null;
            if (weakReference != null) {
                gdtMotivePictureFragment = weakReference.get();
            } else {
                gdtMotivePictureFragment = null;
            }
            if (gdtMotivePictureFragment != null && gdtMotivePictureFragment.getArguments() != null) {
                resultReceiver = (ResultReceiver) gdtMotivePictureFragment.getArguments().getParcelable("result_receiver");
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[setResult] resultReceiver != null? :");
            if (resultReceiver != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            GdtLog.i("GdtMotivePictureFragment", sb5.toString());
            if (resultReceiver != null) {
                resultReceiver.send(i3, intent.getExtras());
            }
        }
    }

    private static GdtMotiveVideoPageData ph(Serializable serializable) {
        if (!(serializable instanceof GdtMotiveVideoPageData)) {
            return null;
        }
        return (GdtMotiveVideoPageData) serializable;
    }

    private void qh(Activity activity) {
        if (activity == null) {
            GdtLog.e("GdtMotivePictureFragment", "[initData] activity is null");
            return;
        }
        Bundle arguments = getArguments();
        if (arguments == null) {
            GdtLog.e("GdtMotivePictureFragment", "[initData] arguments is null");
            activity.finish();
            return;
        }
        GdtMotiveVideoPageData ph5 = ph(arguments.getSerializable("data"));
        if (ph5 == null) {
            GdtLog.e("GdtMotivePictureFragment", "[initData] data is null");
            activity.finish();
        } else {
            this.D = new GdtMotiveVideoModel(ph5);
        }
    }

    private void rh() {
        if (this.D == null) {
            GdtLog.e("GdtMotivePictureFragment", "[initViewController] mModel is null");
            return;
        }
        GdtMvPictureViewController gdtMvPictureViewController = new GdtMvPictureViewController(new a(new WeakReference(this)), this.D, false);
        this.C = gdtMvPictureViewController;
        gdtMvPictureViewController.P();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void beforeFinish() {
        if (this.C != null) {
            Bundle arguments = getArguments();
            String str = "";
            if (arguments != null) {
                str = arguments.getString("arg_callback", "");
            }
            this.C.v(str);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        Window window;
        super.initWindowStyleAndAnimation(activity);
        GdtMotiveVideoPageData gdtMotiveVideoPageData = null;
        if (activity != null) {
            window = activity.getWindow();
        } else {
            window = null;
        }
        if (window != null && window.getDecorView() != null) {
            qh(activity);
            GdtMotiveVideoModel gdtMotiveVideoModel = this.D;
            if (gdtMotiveVideoModel != null) {
                gdtMotiveVideoPageData = gdtMotiveVideoModel.getGdtMotiveVideoPageData();
            }
            if (gdtMotiveVideoPageData == null) {
                GdtLog.e("GdtMotivePictureFragment", "[initWindowStyleAndAnimation] pageData is null");
                return;
            }
            window.setFlags(1024, 1024);
            window.getDecorView().setSystemUiVisibility(7942);
            activity.setRequestedOrientation(gdtMotiveVideoPageData.screenOrientation);
            return;
        }
        GdtLog.e("GdtMotivePictureFragment", "[initWindowStyleAndAnimation] activity or window is null");
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        GdtLog.i("GdtMotivePictureFragment", "[onBackEvent]");
        GdtMvPictureViewController gdtMvPictureViewController = this.C;
        if (gdtMvPictureViewController != null) {
            return gdtMvPictureViewController.O();
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        GdtLog.i("GdtMotivePictureFragment", "[onCreate]");
        rh();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentActivity activity = getActivity();
        View view = null;
        if (activity == null) {
            GdtLog.e("GdtMotivePictureFragment", "[onCreateView] activity is null");
        } else {
            GdtMvPictureViewController gdtMvPictureViewController = this.C;
            if (gdtMvPictureViewController == null) {
                GdtLog.e("GdtMotivePictureFragment", "[onCreateView] mViewController is null");
            } else {
                view = gdtMvPictureViewController.C(LayoutInflater.from(activity), viewGroup);
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        GdtLog.i("GdtMotivePictureFragment", "[onDestroy]");
        GdtMvPictureViewController gdtMvPictureViewController = this.C;
        if (gdtMvPictureViewController != null) {
            gdtMvPictureViewController.Q();
        }
        this.C = null;
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        GdtLog.i("GdtMotivePictureFragment", "[onPause]");
        GdtMvPictureViewController gdtMvPictureViewController = this.C;
        if (gdtMvPictureViewController != null) {
            gdtMvPictureViewController.R();
        }
        super.onPause();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        GdtLog.i("GdtMotivePictureFragment", "[onResume]");
        GdtMvPictureViewController gdtMvPictureViewController = this.C;
        if (gdtMvPictureViewController != null) {
            gdtMvPictureViewController.U();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        GdtLog.i("GdtMotivePictureFragment", "[onStart]");
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        GdtLog.i("GdtMotivePictureFragment", "[onStop]");
        GdtMvPictureViewController gdtMvPictureViewController = this.C;
        if (gdtMvPictureViewController != null) {
            gdtMvPictureViewController.V();
        }
        super.onStop();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onWindowFocusChanged(boolean z16) {
        Window window;
        super.onWindowFocusChanged(z16);
        GdtLog.i("GdtMotivePictureFragment", "[onWindowFocusChanged] called with: hasFocus = [" + z16 + "]");
        if (getQBaseActivity() != null) {
            window = getQBaseActivity().getWindow();
        } else {
            window = null;
        }
        if (z16 && window != null && window.getDecorView() != null) {
            window.getDecorView().setSystemUiVisibility(7942);
        }
    }
}
