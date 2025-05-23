package com.tencent.mobileqq.profilecard.bussiness.personalitysign;

import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.profile.b;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes16.dex */
public class ElegantProfileContentSignComponent extends ProfileContentSignComponent {
    static IPatchRedirector $redirector_ = null;
    private static final int MARGIN_START_OF_EDIT_TIP_IMAGE = 8;

    public ElegantProfileContentSignComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.personalitysign.ProfileContentSignComponent
    protected int getEmptyStringId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return R.string.f203294zt;
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.personalitysign.ProfileContentSignComponent
    protected String getPrefixText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.bussiness.personalitysign.ProfileContentSignComponent
    public void initView(View view, boolean z16, SpannableString spannableString) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, view, Boolean.valueOf(z16), spannableString);
            return;
        }
        super.initView(view, z16, spannableString);
        View findViewById = view.findViewById(R.id.m2g);
        TextView textView = (TextView) view.findViewById(R.id.info);
        ImageView imageView = (ImageView) view.findViewById(R.id.uqw);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.f164472yw);
        QBaseActivity qBaseActivity = this.mActivity;
        if (qBaseActivity != null && qBaseActivity.getResources() != null) {
            String string = this.mActivity.getResources().getString(getEmptyStringId());
            textView.setMaxWidth((findViewById.getWidth() - imageView.getWidth()) - Utils.n(8.0f, this.mActivity.getResources()));
            if (z16 && spannableString.length() == 0 && string.contentEquals(textView.getText())) {
                textView.setTextColor(this.mActivity.getResources().getColorStateList(R.color.qui_common_text_secondary));
            }
            ((View) this.mViewContainer).setBackground(this.mActivity.getResources().getDrawable(R.drawable.ktt));
            findViewById.setBackground(null);
        }
        int i16 = 8;
        view.findViewById(R.id.lqz).setVisibility(8);
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        if (!z16) {
            i16 = 0;
        }
        imageView2.setVisibility(i16);
        findViewById.setClickable(false);
        view.setOnClickListener(this);
        view.setTag(new b(3, null));
        if (ProfilePAUtils.isPaTypeStrangerInContact(((ProfileCardInfo) this.mData).allInOne) && ((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).isContactProfileElegantVersion()) {
            imageView2.setVisibility(4);
            view.setOnClickListener(null);
        } else {
            imageView2.setVisibility(0);
            view.setOnClickListener(this);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.personalitysign.ProfileContentSignComponent
    public View initViewContainer() {
        View viewById;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        LayoutInflater layoutInflater = this.mActivity.getLayoutInflater();
        IComponentCenter iComponentCenter = this.mComponentCenter;
        if (iComponentCenter != null && (viewById = iComponentCenter.getViewLoader().getViewById(R.layout.f168841h10)) != null) {
            return viewById;
        }
        return layoutInflater.inflate(R.layout.f168841h10, (ViewGroup) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.bussiness.personalitysign.ProfileContentSignComponent, android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
        } else {
            super.onClick(view);
            ProfileCardDtReportUtil.dtReportClick((View) this.mViewContainer);
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
