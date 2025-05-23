package com.tencent.mobileqq.profilecard.base.component;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;
import com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes16.dex */
public abstract class AbsProfileComponent<VIEW> extends AbsComponent<VIEW, ProfileCardInfo> {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "AbsProfileComponent";
    protected IProfileConfig mConfigHelper;
    protected IProfileActivityDelegate mDelegate;

    public AbsProfileComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
        }
    }

    private void applyDIYTemplateItemTheme(View view, TextView textView, View view2, ImageView imageView, View view3, View view4, View view5) {
        if (view != null) {
            view.setBackgroundResource(R.drawable.f160556k2);
        }
        ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter).updateItemThemeForDIYTemplate(textView, view2, imageView, view3, view4, view5);
    }

    private void applyTemplateItemTheme(View view, TextView textView, View view2, View view3, ImageView imageView, View view4, View view5, View view6, ProfileCardTemplate profileCardTemplate) {
        updateViewAttr(textView, "color", profileCardTemplate, "commonItemContentColor");
        updateViewAttr(view3, "color", profileCardTemplate, "commonItemContentColor");
        updateViewAttr(imageView, "color", profileCardTemplate, "commonItemContentColor");
        updateViewAttr(view2, "color", profileCardTemplate, "commonItemContentColor");
        if (view4 != null) {
            view4.setBackgroundResource(0);
            view4.setVisibility(8);
        }
        if (view5 != null) {
            view5.setBackgroundResource(0);
        }
        if (view6 != null) {
            view6.setBackgroundResource(0);
        }
    }

    private void updateDefaultItemTheme(View view, TextView textView, View view2, ImageView imageView, View view3, View view4, View view5) {
        int i3;
        Resources resources = this.mActivity.getResources();
        if (view != null) {
            IProfileActivityDelegate iProfileActivityDelegate = this.mDelegate;
            if (iProfileActivityDelegate != null) {
                i3 = iProfileActivityDelegate.getComponentBgResource();
            } else {
                i3 = R.drawable.f160556k2;
            }
            view.setBackgroundResource(i3);
        }
        if (textView != null) {
            textView.setTextColor(resources.getColorStateList(R.color.qui_common_text_primary));
        }
        if (view2 instanceof TextView) {
            ((TextView) view2).setTextColor(resources.getColorStateList(R.color.qui_common_text_secondary));
        } else if (view2 instanceof SingleLineTextView) {
            ((SingleLineTextView) view2).setTextColor(resources.getColorStateList(R.color.qui_common_text_secondary));
        }
        if (imageView != null) {
            imageView.setImageResource(R.drawable.qui_chevron_right_icon_secondary_01);
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.width = resources.getDimensionPixelSize(R.dimen.c9y);
            layoutParams.height = resources.getDimensionPixelSize(R.dimen.c9y);
            imageView.setLayoutParams(layoutParams);
        }
        if (view3 != null) {
            view3.setBackgroundResource(0);
            view3.setVisibility(8);
        }
        if (view4 != null) {
            view4.setBackgroundResource(0);
        }
        if (view5 != null) {
            view5.setBackgroundResource(0);
        }
    }

    private void updateViewAttr(View view, String str, ProfileCardTemplate profileCardTemplate, String str2) {
        if (view == null) {
            return;
        }
        try {
            ProfileTemplateApi.getTemplateManager(this.mComponentCenter).updateViewAttrForTemplate(view, str, profileCardTemplate, str2);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, " getTemplateManager.updateViewAttr error!", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isVasCard(ProfileCardInfo profileCardInfo) {
        Card card;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) profileCardInfo)).booleanValue();
        }
        if (profileCardInfo.currentTemplate == null && ((card = profileCardInfo.card) == null || !ProfileTemplateApi.isDiyTemplateStyleID(card.lCurrentStyleId))) {
            return false;
        }
        return true;
    }

    public void setProfileActivityDelegate(IProfileActivityDelegate iProfileActivityDelegate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iProfileActivityDelegate);
            return;
        }
        this.mDelegate = iProfileActivityDelegate;
        if (iProfileActivityDelegate != null) {
            this.mConfigHelper = iProfileActivityDelegate.getProfileConfig();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public void updateItemTheme(TextView textView, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            updateItemTheme(null, textView, view, null);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) textView, (Object) view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public void updateItemTheme(View view, TextView textView, View view2, ImageView imageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, view, textView, view2, imageView);
            return;
        }
        View view3 = null;
        if (textView != null) {
            try {
                view3 = ((ViewGroup) textView.getParent()).findViewById(R.id.icon);
                if (view3 == null) {
                    view3 = ((ViewGroup) textView.getParent().getParent()).findViewById(R.id.icon);
                }
            } catch (Exception unused) {
            }
        }
        updateItemTheme(view, textView, view3, view2, imageView, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateItemTheme(View view, TextView textView, View view2, View view3, ImageView imageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            updateItemTheme(view, textView, view2, view3, imageView, null, null, null);
        } else {
            iPatchRedirector.redirect((short) 5, this, view, textView, view2, view3, imageView);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateItemTheme(ProfileContentTitleView profileContentTitleView, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, profileContentTitleView, Boolean.valueOf(z16));
            return;
        }
        FrameLayout frameLayout = z16 ? profileContentTitleView.mContentContainer : null;
        ViewGroup viewGroup = profileContentTitleView.mTitleContainer;
        TextView textView = profileContentTitleView.mTitleText;
        ImageView imageView = profileContentTitleView.mTitleIcon;
        updateItemTheme(viewGroup, textView, imageView, null, profileContentTitleView.mTitleArrow, imageView, profileContentTitleView.mTitleTextBg, frameLayout);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void updateItemTheme(View view, TextView textView, View view2, View view3, ImageView imageView, View view4, View view5, View view6) {
        ConcurrentHashMap<String, Object> concurrentHashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, view, textView, view2, view3, imageView, view4, view5, view6);
            return;
        }
        try {
            ProfileCardTemplate profileCardTemplate = ((ProfileCardInfo) this.mData).currentTemplate;
            if (profileCardTemplate != null && (concurrentHashMap = profileCardTemplate.templateAttr) != null && !concurrentHashMap.isEmpty()) {
                applyTemplateItemTheme(view, textView, view2, view3, imageView, view4, view5, view6, profileCardTemplate);
            } else if (ProfileTemplateApi.isDiyTemplateStyleID(((ProfileCardInfo) this.mData).curUseStyleId)) {
                applyDIYTemplateItemTheme(view, textView, view3, imageView, view4, view5, view6);
            } else {
                updateDefaultItemTheme(view, textView, view3, imageView, view4, view5, view6);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "updateItemTheme fail.", e16);
        }
    }
}
