package com.tencent.mobileqq.profilecard.bussiness.accountinfo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.base.utils.VasSvipPrivilegeAnimateHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.profilecard.util.LevelUtil;
import com.tencent.mobileqq.vas.qqvaluecard.view.QQValuePagView;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.zplan.nameplate.api.IZPlanNameplate;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes16.dex */
public class ElegantProfileQQLevelView extends BaseProfileQQLevelView {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "BaseProfileQQLevelView";

    public ElegantProfileQQLevelView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    public void initViews() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.mInflater.inflate(R.layout.h0d, this);
        this.mPrettyOwner = (ImageView) findViewById(R.id.m37);
        this.mVipInfo = (TextView) findViewById(R.id.dlu);
        this.mVipIcon = (ImageView) findViewById(R.id.kyu);
        this.mVipExtIcon = (ImageView) findViewById(R.id.f11988782);
        this.mCardNamePlateIcon = (ImageView) findViewById(R.id.to9);
        this.mKingInfo = (URLImageView) findViewById(R.id.dli);
        this.mLevelInfo = (AnimationTextView) findViewById(R.id.dkg);
        this.mDarenIcon = (ImageView) findViewById(R.id.bn6);
        this.mZPlanNameplateManager = ((IZPlanNameplate) QRoute.api(IZPlanNameplate.class)).generateManager((RelativeLayout) findViewById(R.id.f126687pf));
        this.mPagLayout = (QQValuePagView) findViewById(R.id.f219702g);
        setVisibility(8);
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.accountinfo.view.BaseProfileQQLevelView
    public void updateQQLevelContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("BaseProfileQQLevelView", 2, String.format("updateQQLevelContent level=%s levelType=%s iconLength=%s", Integer.valueOf(this.mQQLevel), Integer.valueOf(this.mQQLevelType), Integer.valueOf(this.mIconLength)));
        }
        this.mLevelInfo.setText(LevelUtil.parseQQLevel(getContext(), this.mIconLength, this.mQQLevelType, this.mQQLevel, true, (int) getContext().getResources().getDimension(R.dimen.f159041uo)), TextView.BufferType.SPANNABLE);
        VasSvipPrivilegeAnimateHelper.addSvipPrivilegeAnimateView(this.mLevelInfo);
    }

    public ElegantProfileQQLevelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public ElegantProfileQQLevelView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
