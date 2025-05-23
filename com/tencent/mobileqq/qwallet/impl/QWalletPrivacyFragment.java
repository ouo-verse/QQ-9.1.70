package com.tencent.mobileqq.qwallet.impl;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import cooperation.qwallet.plugin.IQWalletHelper;
import x05.c;

/* loaded from: classes16.dex */
public class QWalletPrivacyFragment extends QPublicBaseFragment {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class a implements c.InterfaceC11524c {
        a() {
        }

        @Override // x05.c.InterfaceC11524c
        public void onClickUrl(String str) {
            Intent intent = new Intent(QWalletPrivacyFragment.this.getQBaseActivity(), (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", str);
            QWalletPrivacyFragment.this.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            com.tencent.mobileqq.qwallet.impl.b.b(QWalletPrivacyFragment.this.getQBaseActivity().getAppRuntime());
            QWalletPrivacyFragment.this.ph();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QWalletPrivacyFragment.this.getQBaseActivity().finish();
        }
    }

    private void qh(View view) {
        String string = getArguments().getString("title", "");
        String string2 = getArguments().getString("content", "");
        String string3 = getArguments().getString("background", "");
        if (QLog.isColorLevel()) {
            QLog.i("QWalletPrivacyFragment", 2, "onCreate:" + string + "|" + string2 + "|" + string3);
        }
        if (!TextUtils.isEmpty(string2)) {
            string2 = string2.replace(RedTouch.NEWLINE_CHAR, "\n");
        }
        CharSequence e16 = x05.c.e(string2, new a());
        if (!TextUtils.isEmpty(e16) && !TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
            QQCustomDialog createCustomDialogUrlWithoutAutoLink = DialogUtil.createCustomDialogUrlWithoutAutoLink(getQBaseActivity(), 230, R.layout.f168983bg2, string, e16, R.string.g9p, R.string.g9o, new b(), new c());
            createCustomDialogUrlWithoutAutoLink.setCancelable(false);
            createCustomDialogUrlWithoutAutoLink.setCanceledOnTouchOutside(false);
            createCustomDialogUrlWithoutAutoLink.show();
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.h8j);
            ColorDrawable colorDrawable = new ColorDrawable(-1);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mFailedDrawable = colorDrawable;
            obtain.mLoadingDrawable = colorDrawable;
            relativeLayout.setBackgroundDrawable(URLDrawable.getDrawable(string3, obtain));
            return;
        }
        ph();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.f168982bg1, viewGroup, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).preloadQWallet(getQBaseActivity().getAppRuntime(), 0, "qwallet_default");
        try {
            qh(view);
        } catch (Throwable th5) {
            QLog.e("QWalletPrivacyFragment", 1, "error msg in qqpay-impl module: ", th5);
            ph();
        }
    }

    public void ph() {
        ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).launchQWalletAct(getQBaseActivity(), getQBaseActivity().getAppRuntime(), false, getArguments().getInt(WadlProxyConsts.CHANNEL));
        getActivity().finish();
    }
}
