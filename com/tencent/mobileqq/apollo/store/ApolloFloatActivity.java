package com.tencent.mobileqq.apollo.store;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ApolloFloatActivity extends AbsBaseWebViewActivity {
    private static final String TAG = "ApolloFloatActivity";
    TextView rightView;

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        super.doOnBackPressed();
        overridePendingTransition(0, 0);
    }

    @Override // com.tencent.biz.webviewbase.AbsBaseWebViewActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        super.doOnCreate(bundle);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        new RelativeLayout.LayoutParams(-1, -1);
        Resources resources = super.getResources();
        if (SystemBarActivityModule.getSystemBarComp(this) != null) {
            int color = resources.getColor(R.color.ajr);
            SystemBarActivityModule.getSystemBarComp(this).setStatusColor(color);
            SystemBarActivityModule.getSystemBarComp(this).setStatusBarColor(color);
        }
        super.setContentView(relativeLayout);
        if (((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
            return false;
        }
        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).doBindService(relativeLayout.getContext().getApplicationContext());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        return false;
    }

    @Override // com.tencent.biz.webviewbase.AbsBaseWebViewActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.rightView) {
            super.onBackEvent();
            finish();
        }
    }
}
