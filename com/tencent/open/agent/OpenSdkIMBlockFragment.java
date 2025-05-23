package com.tencent.open.agent;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OpenSdkIMBlockFragment extends QPublicBaseFragment {
    private boolean C;
    private String D;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements View.OnClickListener {

        /* compiled from: P */
        /* renamed from: com.tencent.open.agent.OpenSdkIMBlockFragment$a$a, reason: collision with other inner class name */
        /* loaded from: classes22.dex */
        class DialogInterfaceOnClickListenerC9262a implements DialogInterface.OnClickListener {
            DialogInterfaceOnClickListenerC9262a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                QLog.d("IMBlockOpenSDKFragment", 1, "-->onClick--");
            }
        }

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(OpenSdkIMBlockFragment.this.getQBaseActivity(), 230);
            createCustomDialog.setTitle(R.string.f199594pu);
            createCustomDialog.setMessage(R.string.f199574ps);
            createCustomDialog.setPositiveButton(R.string.f199584pt, new DialogInterfaceOnClickListenerC9262a());
            createCustomDialog.show();
            com.tencent.open.agent.util.d.s(OpenSdkIMBlockFragment.this.D, "0X800B65A");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            com.tencent.open.agent.util.d.s(OpenSdkIMBlockFragment.this.D, "0X800B65B");
            OpenSdkIMBlockFragment.this.sh();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private String getCurrentUin() {
        Intent intent;
        String stringExtra;
        if (getQBaseActivity() == null || (intent = getQBaseActivity().getIntent()) == null || (stringExtra = intent.getStringExtra("uin")) == null) {
            return "";
        }
        return stringExtra;
    }

    private void rh(View view) {
        int i3 = view.getResources().getDisplayMetrics().heightPixels;
        float f16 = (view.getResources().getDisplayMetrics().density * 194.5f) + 0.5f;
        float f17 = i3 - f16;
        QLog.d("IMBlockOpenSDKFragment", 1, "screenHeight=", Integer.valueOf(i3), ", viewPX=", Float.valueOf(f16), ", space=", Float.valueOf(f17));
        View findViewById = view.findViewById(R.id.f163884b6);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = (int) (0.26082367f * f17);
        findViewById.setLayoutParams(layoutParams);
        View findViewById2 = view.findViewById(R.id.zyv);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById2.getLayoutParams();
        layoutParams2.topMargin = (int) (f17 * 0.2914467f);
        findViewById2.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sh() {
        up3.b.f(this.D);
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity == null) {
            QLog.d("IMBlockOpenSDKFragment", 1, "-->exitImBlock--getActivity() == null");
            return;
        }
        if (qBaseActivity.getIntent() != null && !qBaseActivity.getIntent().getBooleanExtra("is_from_login", false)) {
            Intent intent = new Intent();
            intent.putExtra("logout_intent", true);
            intent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
            RouteUtils.startActivity(qBaseActivity, intent, RouterConstants.UI_ROUTER_LOGIN);
        }
        qBaseActivity.finish();
    }

    public static void th(Activity activity, String str, boolean z16) {
        QLog.d("IMBlockOpenSDKFragment", 1, "-->startFragment--uin=", com.tencent.open.agent.util.g.C(str), ", isFromLogin=", Boolean.valueOf(z16));
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (activity == null) {
            QLog.d("IMBlockOpenSDKFragment", 1, "-->startFragment fail null == currentActivity--");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("uin", str);
        intent.putExtra("is_from_login", z16);
        QPublicFragmentActivity.b.e(activity, intent, QPublicFragmentActivity.class, OpenSdkIMBlockFragment.class, 0);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        QLog.d("IMBlockOpenSDKFragment", 1, "onBackEvent");
        sh();
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        QLog.d("IMBlockOpenSDKFragment", 1, "-->onCreateView--");
        this.D = getCurrentUin();
        View inflate = layoutInflater.inflate(R.layout.ftp, viewGroup, false);
        inflate.findViewById(R.id.xcp).setOnClickListener(new a());
        ((TextView) inflate.findViewById(R.id.zr8)).setText(this.D);
        rh(inflate);
        inflate.findViewById(R.id.zyv).setOnClickListener(new b());
        com.tencent.open.agent.util.d.s(this.D, "0X800B659");
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QLog.d("IMBlockOpenSDKFragment", 1, "-->onDestroy--");
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        QLog.d("IMBlockOpenSDKFragment", 1, "-->onResume--mUpdatedStatusBar=", Boolean.valueOf(this.C));
        super.onResume();
        if (!this.C) {
            com.tencent.open.agent.util.g.Y(getQBaseActivity());
            this.C = true;
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        QLog.d("IMBlockOpenSDKFragment", 1, "-->onStart");
        super.onStart();
    }
}
