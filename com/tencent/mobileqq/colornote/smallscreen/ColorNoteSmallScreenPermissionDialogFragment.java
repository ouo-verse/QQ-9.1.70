package com.tencent.mobileqq.colornote.smallscreen;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

/* loaded from: classes5.dex */
public class ColorNoteSmallScreenPermissionDialogFragment extends QPublicBaseFragment {
    public static boolean C = false;

    /* loaded from: classes5.dex */
    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            com.tencent.mobileqq.colornote.smallscreen.b.f(BaseApplication.getContext());
            if (ColorNoteSmallScreenPermissionDialogFragment.this.getQBaseActivity() != null) {
                ColorNoteSmallScreenPermissionDialogFragment.this.getQBaseActivity().finish();
                ColorNoteSmallScreenPermissionDialogFragment.this.getQBaseActivity().overridePendingTransition(0, 0);
            }
            ReportController.o(null, "dc00898", "", "", "0X800AB3C", "0X800AB3C", 0, 0, "", "", "", "");
        }
    }

    /* loaded from: classes5.dex */
    class b implements DialogInterface.OnCancelListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (ColorNoteSmallScreenPermissionDialogFragment.this.getQBaseActivity() != null) {
                ColorNoteSmallScreenPermissionDialogFragment.this.getQBaseActivity().finish();
                ColorNoteSmallScreenPermissionDialogFragment.this.getQBaseActivity().overridePendingTransition(0, 0);
            }
            ReportController.o(null, "dc00898", "", "", "0X800AB3B", "0X800AB3B", 0, 0, "", "", "", "");
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        activity.overridePendingTransition(0, 0);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i3;
        int i16;
        int i17;
        if (QLog.isColorLevel()) {
            QLog.i("ColorNoteSmallScreenPermissionDialogFragment", 2, "showPermissionDialog in");
        }
        Intent intent = getQBaseActivity().getIntent();
        if (intent != null) {
            i3 = intent.getIntExtra("key_permission_from", 1);
        } else {
            i3 = 1;
        }
        if (i3 == 2) {
            i16 = R.string.zmf;
        } else {
            if (i3 == 3) {
                com.tencent.mobileqq.colornote.e.g(getQBaseActivity().getAppRuntime(), true);
            }
            i16 = R.string.f170756vz1;
        }
        QQCustomDialog positiveButton = DialogUtil.createCustomDialog(getQBaseActivity(), 230).setMessage(i16).setPositiveButton(R.string.f170757vz2, new a());
        positiveButton.setTitle(R.string.f170758vz3);
        positiveButton.setCancelable(true);
        positiveButton.setOnCancelListener(new b());
        positiveButton.setCanceledOnTouchOutside(false);
        positiveButton.show();
        C = true;
        if (i3 == 2) {
            i17 = 1;
        } else {
            i17 = 2;
        }
        ReportController.o(null, "dc00898", "", "", "0X800AB3A", "0X800AB3A", i17, 0, "", "", "", "");
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        C = false;
    }
}
