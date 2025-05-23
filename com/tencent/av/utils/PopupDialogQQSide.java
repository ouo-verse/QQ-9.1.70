package com.tencent.av.utils;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

/* loaded from: classes3.dex */
public class PopupDialogQQSide extends QPublicBaseFragment {
    QQCustomDialog C = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ResultReceiver f76729d;

        a(ResultReceiver resultReceiver) {
            this.f76729d = resultReceiver;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ResultReceiver resultReceiver = this.f76729d;
            if (resultReceiver != null) {
                resultReceiver.send(0, PopupDialogQQSide.this.getArguments());
            }
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ResultReceiver f76731d;

        b(ResultReceiver resultReceiver) {
            this.f76731d = resultReceiver;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ResultReceiver resultReceiver = this.f76731d;
            if (resultReceiver != null) {
                resultReceiver.send(1, PopupDialogQQSide.this.getArguments());
            }
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements DialogInterface.OnDismissListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            PopupDialogQQSide popupDialogQQSide = PopupDialogQQSide.this;
            if (dialogInterface == popupDialogQQSide.C) {
                popupDialogQQSide.C = null;
            }
            if (popupDialogQQSide.getQBaseActivity() != null) {
                PopupDialogQQSide.this.getQBaseActivity().doOnBackPressed();
                PopupDialogQQSide.this.getQBaseActivity().overridePendingTransition(0, 0);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        ph();
        super.onDestroyView();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        qh();
    }

    void ph() {
        QQCustomDialog qQCustomDialog = this.C;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
            this.C = null;
        }
    }

    void qh() {
        Bundle bundle = (Bundle) getArguments().getParcelable(Const.BUNDLE_KEY_REQUEST);
        int i3 = bundle.getInt("type", 230);
        String string = bundle.getString("titleText");
        String string2 = bundle.getString("contentText");
        int i16 = bundle.getInt("leftBtnText", 0);
        int i17 = bundle.getInt("rightBtnText", 0);
        ResultReceiver resultReceiver = (ResultReceiver) bundle.getParcelable("resultReceiver");
        boolean z16 = bundle.getBoolean("leftBtnVisiable", true);
        boolean z17 = bundle.getBoolean("rightBtnVisiable", true);
        ph();
        a aVar = new a(resultReceiver);
        b bVar = new b(resultReceiver);
        if (i16 == 0) {
            i16 = R.string.idk;
        }
        if (i17 == 0) {
            i17 = R.string.idk;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getQBaseActivity(), i3);
        createCustomDialog.setMessage(string2);
        createCustomDialog.setTitle(string);
        if (z16) {
            createCustomDialog.setNegativeButton(i16, aVar);
        }
        if (z17) {
            createCustomDialog.setPositiveButton(i17, bVar);
        }
        createCustomDialog.setOnDismissListener(new c());
        createCustomDialog.setCancelable(true);
        createCustomDialog.show();
        this.C = createCustomDialog;
    }
}
