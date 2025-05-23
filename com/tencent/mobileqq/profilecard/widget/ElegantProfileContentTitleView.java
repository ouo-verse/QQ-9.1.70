package com.tencent.mobileqq.profilecard.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public class ElegantProfileContentTitleView extends ProfileContentTitleView {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ElegantProfileContentTitleView";

    public ElegantProfileContentTitleView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView
    public int getLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return R.layout.h0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView
    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(getLayoutId(), (ViewGroup) this, true);
        this.mRoot = (ViewGroup) inflate.findViewById(R.id.root_layout);
        this.mTitleContainer = (ViewGroup) inflate.findViewById(R.id.title_container);
        this.mTitleIcon = (ImageView) inflate.findViewById(R.id.joy);
        this.mTitleText = (TextView) inflate.findViewById(R.id.f166992jq2);
        this.mTitleTextBg = (ViewGroup) inflate.findViewById(R.id.f98905oc);
        this.mTitleArrow = (ImageView) inflate.findViewById(R.id.f98225mi);
        this.mTitleExtContainer = (RelativeLayout) inflate.findViewById(R.id.f98445n4);
        this.mContentContainer = (FrameLayout) inflate.findViewById(R.id.b9t);
    }

    public ElegantProfileContentTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }
}
