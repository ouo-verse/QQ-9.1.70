package com.tencent.av.ui.part.base;

import android.app.Activity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c extends nw.a implements mw.e {

    /* renamed from: e, reason: collision with root package name */
    private ImageView f76262e = null;

    @Override // mw.e
    public void g1() {
        if (this.f76262e != null) {
            if (QLog.isColorLevel()) {
                QLog.d(this.f421444d, 2, "setScreenDarken");
            }
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(500L);
            alphaAnimation.setFillAfter(true);
            this.f76262e.setVisibility(0);
            this.f76262e.startAnimation(alphaAnimation);
        }
    }

    @Override // nw.a, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f76262e = (ImageView) view.findViewById(R.id.g7q);
        RFWIocAbilityProvider.g().registerIoc(view, this, mw.e.class);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        onDestroy();
        RFWIocAbilityProvider.g().unregisterSingleIoc(getPartRootView(), mw.e.class);
    }

    @Override // nw.a
    public void onDestroy() {
        this.f76262e = null;
    }
}
