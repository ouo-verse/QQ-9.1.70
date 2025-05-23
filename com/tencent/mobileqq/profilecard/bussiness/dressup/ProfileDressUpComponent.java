package com.tencent.mobileqq.profilecard.bussiness.dressup;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;

/* loaded from: classes16.dex */
public class ProfileDressUpComponent extends BaseProfileDressUpComponent {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ProfileDressUpComponent";

    public ProfileDressUpComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.dressup.BaseProfileDressUpComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    public String getComponentName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return TAG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.profilecard.bussiness.dressup.BaseProfileDressUpComponent
    public int getPhotoSize() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        Resources resources = this.mActivity.getResources();
        int dpToPx = ViewUtils.dpToPx(16.0f);
        int dpToPx2 = ViewUtils.dpToPx(15.0f);
        View containerView = getContainerView();
        if (containerView != null) {
            i3 = containerView.getMeasuredWidth();
        } else {
            i3 = 0;
        }
        if (i3 <= 0) {
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            i3 = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        return (int) ((((i3 - dpToPx) - dpToPx2) - ((resources.getDimensionPixelSize(R.dimen.aie) * 3) * 1.0f)) / 4.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.bussiness.dressup.BaseProfileDressUpComponent
    public void initStyle(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
            return;
        }
        super.initStyle(view);
        VIEW view2 = this.mViewContainer;
        if (view2 == 0) {
            return;
        }
        ((View) view2).setBackground(this.mActivity.getResources().getDrawable(R.drawable.ktt));
        ViewGroup viewGroup = (ViewGroup) ((View) this.mViewContainer).findViewById(R.id.xmj);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = ViewUtils.dpToPx(16.0f);
        layoutParams.rightMargin = ViewUtils.dpToPx(15.0f);
        viewGroup.setLayoutParams(layoutParams);
        int photoSize = getPhotoSize();
        for (ImageView imageView : getImageViews()) {
            ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
            layoutParams2.width = photoSize;
            layoutParams2.height = photoSize;
            imageView.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent
    public void updateItemTheme(View view, TextView textView, View view2, View view3, ImageView imageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, view, textView, view2, view3, imageView);
        }
    }
}
