package com.tencent.mobileqq.qqexpand.fragment;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ExpandOfflineFragment extends QPublicBaseFragment {
    private View C;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            QBaseActivity qBaseActivity = ExpandOfflineFragment.this.getQBaseActivity();
            if (qBaseActivity == null || qBaseActivity.isFinishing()) {
                return;
            }
            qBaseActivity.finish();
        }
    }

    private void ph() {
        this.C.findViewById(R.id.f163222oz1).setOnClickListener(new a());
    }

    private void qh() {
        ImageView imageView = (ImageView) this.C.findViewById(R.id.f163223oz2);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = new ColorDrawable(0);
        imageView.setImageDrawable(URLDrawable.getDrawable("https://downv6.qq.com/extendfriend/match_not_available.png", obtain));
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        cc2.b.d(getActivity(), true);
        qh();
        ph();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.czz, viewGroup, false);
        this.C = inflate;
        return inflate;
    }
}
