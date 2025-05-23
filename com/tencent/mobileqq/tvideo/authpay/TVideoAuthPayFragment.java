package com.tencent.mobileqq.tvideo.authpay;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.tvideo.authpay.TVideoAuthPayWebView;
import com.tencent.paysdk.api.r;
import com.tencent.paysdk.util.f;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

/* loaded from: classes19.dex */
public class TVideoAuthPayFragment extends QPublicBaseFragment implements r {

    /* loaded from: classes19.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            TVideoAuthPayFragment.this.getActivity().finish();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes19.dex */
    class b implements TVideoAuthPayWebView.b {
        b() {
        }

        @Override // com.tencent.mobileqq.tvideo.authpay.TVideoAuthPayWebView.b
        public void clear() {
            TVideoAuthPayFragment.this.getActivity().finish();
        }
    }

    @Override // com.tencent.paysdk.api.r
    public void Jd(int i3, String str, String str2, String str3, String str4) {
        if (i3 == 0) {
            qx2.a.c().n(true);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.gg9, viewGroup, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        f.c(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.findViewById(R.id.sxo).setOnClickListener(new a());
        TVideoAuthPayWebView tVideoAuthPayWebView = (TVideoAuthPayWebView) view.findViewById(R.id.sxr);
        tVideoAuthPayWebView.setWebViewPartListener(new b());
        QLog.d(QPublicBaseFragment.TAG, 1, "loadUrl : " + qx2.a.c().f430271c);
        tVideoAuthPayWebView.loadUrl(qx2.a.c().f430271c);
        f.b(this);
    }
}
