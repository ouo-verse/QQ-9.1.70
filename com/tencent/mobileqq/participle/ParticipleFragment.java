package com.tencent.mobileqq.participle;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.participle.api.IParticipleApi;
import com.tencent.mobileqq.participle.api.IParticipleUIApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.participle.ParticipleView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LoadingUtil;
import java.util.List;

/* loaded from: classes33.dex */
public class ParticipleFragment extends QPublicBaseFragment {
    public int C;
    private Dialog E;
    private ParticipleView F;
    public String D = "";
    private final d G = new b();

    /* loaded from: classes33.dex */
    class a implements ParticipleView.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f257193a;

        a(TextView textView) {
            this.f257193a = textView;
        }

        @Override // com.tencent.mobileqq.widget.participle.ParticipleView.d
        public void a() {
            String B = ParticipleFragment.this.F.B();
            if (TextUtils.isEmpty(B)) {
                this.f257193a.setClickable(false);
                this.f257193a.setTextColor(ParticipleFragment.this.getResources().getColor(R.color.qui_common_text_tertiary));
            } else {
                this.f257193a.setClickable(true);
                this.f257193a.setTextColor(ParticipleFragment.this.getResources().getColor(R.color.qui_common_text_primary));
            }
            int countByByte = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).countByByte(B);
            ParticipleFragment participleFragment = ParticipleFragment.this;
            if (countByByte > participleFragment.C) {
                QQToast.makeText(participleFragment.getActivity(), "\u5df2\u8fbe\u5230\u5907\u6ce8\u7684\u5b57\u6570\u4e0a\u9650", 1).show();
            }
        }
    }

    /* loaded from: classes33.dex */
    class b extends d {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.participle.d
        public void a(boolean z16, List<String> list) {
            ParticipleFragment.this.vh();
            ParticipleFragment.this.Ah(list);
        }
    }

    private void cancel() {
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity == null) {
            QLog.d("ParticipleFragment", 1, "cancel--getActivity() == null");
        } else {
            qBaseActivity.setResult(0);
            qBaseActivity.finish();
        }
    }

    private void complete() {
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity == null) {
            QLog.d("ParticipleFragment", 1, "-->exitImBlock--getActivity() == null");
            return;
        }
        String B = this.F.B();
        if (((IAddFriendApi) QRoute.api(IAddFriendApi.class)).countByByte(B) > this.C) {
            QQToast.makeText(getActivity(), "\u5df2\u8fbe\u5230\u5907\u6ce8\u7684\u5b57\u6570\u4e0a\u9650", 1).show();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(IParticipleUIApi.SELECTED_WORDS, B);
        qBaseActivity.setResult(-1, intent);
        qBaseActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        complete();
    }

    private void showProgressDialog() {
        Dialog dialog = this.E;
        if (dialog != null) {
            dialog.dismiss();
            this.E.show();
            return;
        }
        Dialog showLoadingDialog = LoadingUtil.showLoadingDialog(getActivity(), HardCodeUtil.qqStr(R.string.u3i), false);
        this.E = showLoadingDialog;
        if (showLoadingDialog == null) {
            return;
        }
        showLoadingDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.mobileqq.participle.c
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                ParticipleFragment.this.xh(dialogInterface);
            }
        });
        this.E.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vh() {
        Dialog dialog = this.E;
        if (dialog != null) {
            dialog.setOnCancelListener(null);
            this.E.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void wh(View view) {
        cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void xh(DialogInterface dialogInterface) {
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        dialogInterface.dismiss();
    }

    private void zh() {
        QPublicFragmentActivity qPublicFragmentActivity = (QPublicFragmentActivity) getActivity();
        if (qPublicFragmentActivity == null) {
            return;
        }
        if (!NetworkUtil.isNetSupport(qPublicFragmentActivity)) {
            QQToast.makeText(qPublicFragmentActivity, HardCodeUtil.qqStr(R.string.u38), 0).show(qPublicFragmentActivity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        } else {
            if (TextUtils.isEmpty(this.D)) {
                return;
            }
            ((IParticipleApi) QRoute.api(IParticipleApi.class)).participleTheContent((AppInterface) qPublicFragmentActivity.getAppRuntime(), this.D);
            showProgressDialog();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).addObserver(this.G);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.D = getActivity().getIntent().getStringExtra(IParticipleUIApi.ORIGIN_WORDS);
        this.C = getActivity().getIntent().getIntExtra("max_length", 32);
        QLog.d("ParticipleFragment", 1, "-->onCreateView--content=" + this.D + ", maxLength=" + this.C);
        View inflate = layoutInflater.inflate(R.layout.f1272203, viewGroup, false);
        this.F = (ParticipleView) inflate.findViewById(R.id.f17971q);
        TextView textView = (TextView) inflate.findViewById(R.id.f17460c);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.participle.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ParticipleFragment.this.lambda$onCreateView$0(view);
            }
        });
        textView.setClickable(false);
        ((TextView) inflate.findViewById(R.id.f173906)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.participle.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ParticipleFragment.this.wh(view);
            }
        });
        zh();
        this.F.setOnParticipleSelectChangeListener(new a(textView));
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        ((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.G);
        super.onDestroy();
    }

    public static void yh(Activity activity, int i3, Intent intent) {
        if (activity == null) {
            QLog.d("ParticipleFragment", 1, "startFragmentForResult fail null == activity");
            return;
        }
        QLog.d("ParticipleFragment", 1, "startFragmentForResult");
        if (intent == null) {
            intent = new Intent();
        }
        QPublicFragmentActivity.b.e(activity, intent, QPublicFragmentActivity.class, ParticipleFragment.class, i3);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        QLog.d("ParticipleFragment", 1, "onBackEvent");
        cancel();
        return super.onBackEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ah(List<String> list) {
        if (list != null && list.size() > 0) {
            this.F.k(false);
            this.F.setParticipleItems(list);
            this.F.R();
            return;
        }
        QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.qqStr(R.string.u3h), 0).show();
    }
}
