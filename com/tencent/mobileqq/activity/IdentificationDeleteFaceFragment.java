package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.Arrays;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes9.dex */
public class IdentificationDeleteFaceFragment extends QPublicBaseFragment implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private static final List<Integer> D;
    private QBaseActivity C;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f176248d;

        a(QBaseActivity qBaseActivity) {
            this.f176248d = qBaseActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) IdentificationDeleteFaceFragment.this, (Object) qBaseActivity);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            ReportController.o(null, "dc00898", "", "", "0X800A320", "0X800A320", 0, 0, "", "", "", "");
            Intent intent = new Intent();
            intent.putExtra("url", "https://accounts.qq.com/face/delete");
            RouteUtils.startActivityForResult(this.f176248d, intent, RouterConstants.UI_ROUTE_BROWSER, 1001);
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) IdentificationDeleteFaceFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("IdentificationDeleteFaceFragment", 2, "user cancel delete");
            }
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19283);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            D = Arrays.asList(206, 205, 203);
        }
    }

    public IdentificationDeleteFaceFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void qh(View view) {
        QUISecNavBar qUISecNavBar = (QUISecNavBar) view.findViewById(R.id.f98255ml);
        qUISecNavBar.S(this);
        qUISecNavBar.setOnBaseTitleBarClickListener(new Function2() { // from class: com.tencent.mobileqq.activity.de
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit sh5;
                sh5 = IdentificationDeleteFaceFragment.this.sh((View) obj, (BaseAction) obj2);
                return sh5;
            }
        });
    }

    private boolean rh() {
        QBaseActivity qBaseActivity = this.C;
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit sh(View view, BaseAction baseAction) {
        if (baseAction == BaseAction.ACTION_LEFT_BUTTON) {
            onBackEvent();
            QBaseActivity qBaseActivity = this.C;
            if (qBaseActivity != null) {
                qBaseActivity.finish();
                return null;
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        if (rh()) {
            QLog.e("IdentificationDeleteFaceFragment", 1, "onActivityResult activity is null");
            return;
        }
        if (i3 == 1001) {
            if (i16 == -1) {
                if (intent == null) {
                    intent = new Intent();
                }
                intent.putExtra("key_face_scan_result", true);
                this.C.setResult(i16, intent);
                this.C.finish();
                return;
            }
            return;
        }
        if (i16 == -1 && intent != null) {
            if (intent.getBooleanExtra("key_face_scan_result", false)) {
                this.C.setResult(i16, intent);
                this.C.finish();
            } else if (intent.getBundleExtra("data") != null) {
                Bundle bundleExtra = intent.getBundleExtra("data");
                if (D.contains(Integer.valueOf(bundleExtra.getInt("ret", -1)))) {
                    QQToast.makeText(this.C, bundleExtra.getString("errMsg"), 0).show();
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            QBaseActivity qBaseActivity = getQBaseActivity();
            if (id5 == R.id.ivTitleBtnLeft) {
                qBaseActivity.finish();
            } else if (id5 == R.id.f167041k72) {
                ReportController.o(null, "dc00898", "", "", "0X800A855", "0X800A855", 0, 0, "", "", "", "");
                DialogUtil.createCustomDialog(getActivity(), 0, getString(R.string.f159411s9), getString(R.string.f159401s8), getString(R.string.f159391s7), getString(R.string.b0a), new a(qBaseActivity), new b()).show();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            inflate = (View) iPatchRedirector.redirect((short) 2, this, layoutInflater, viewGroup, bundle);
        } else {
            this.C = getQBaseActivity();
            inflate = layoutInflater.inflate(R.layout.fcf, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.f167041k72)).setOnClickListener(this);
            qh(inflate);
            ReportController.o(null, "dc00898", "", "", "0X800A86F", "0X800A86F", 0, 0, "", "", "", "");
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }
}
