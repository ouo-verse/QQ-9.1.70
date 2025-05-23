package com.tencent.mobileqq.profilecard.widget.CountrySelect;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi;
import com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit;
import com.tencent.mobileqq.profilecard.widget.CountrySelect.CountrySelectView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class CountrySelectActionSheet extends ActionSheetProfileEdit implements ActionSheetProfileEdit.OnActionSheetListener {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "CountrySelectActionSheet";
    private CountrySelectView mCountrySelectView;
    private IProfileEditBusinessApi.OnGetUserLocationListener mOnGetUserLocationListener;

    public CountrySelectActionSheet(Context context) {
        this(context, "0");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private int getSystemStatusBarHeight() {
        int identifier;
        Context context = this.mContext;
        if (context == null || context.getResources() == null || (identifier = this.mContext.getResources().getIdentifier("status_bar_height", "dimen", "android")) == 0) {
            return 0;
        }
        return this.mContext.getResources().getDimensionPixelSize(identifier);
    }

    private void initCountrySelectView(String str) {
        CountrySelectView countrySelectView = new CountrySelectView(this.mContext);
        this.mCountrySelectView = countrySelectView;
        countrySelectView.initListView(str, false);
        this.mCountrySelectView.setCountrySelectListener(new CountrySelectView.OnCountrySelectListener() { // from class: com.tencent.mobileqq.profilecard.widget.CountrySelect.CountrySelectActionSheet.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) CountrySelectActionSheet.this);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.widget.CountrySelect.CountrySelectView.OnCountrySelectListener
            public void getSelectResult(String str2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    CountrySelectActionSheet.this.updateCountryData(str2);
                    CountrySelectActionSheet.this.dismiss();
                    CountrySelectActionSheet.this.mCountrySelectView = null;
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str2);
            }
        });
    }

    private void initUI() {
        findViewById(R.id.ujh).setVisibility(8);
        ((TextView) this.mRootView.findViewById(R.id.title)).setText("\u9009\u62e9\u56fd\u5bb6");
        ((TextView) this.mRootView.findViewById(R.id.b7m)).setVisibility(8);
        this.mRootView.findViewById(R.id.ujg).setVisibility(8);
        this.mRootView.findViewById(R.id.f27710gz).setVisibility(8);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = ViewUtils.dip2px(60.0f) + getSystemStatusBarHeight();
        ViewGroup viewGroup = this.mContainerView;
        if (viewGroup != null) {
            viewGroup.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCountryData(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.d(TAG, 4, "\u66f4\u65b0\u56fd\u5bb6\u4fe1\u606f\u5931\u8d25");
            return;
        }
        QLog.d(TAG, 4, "\u9009\u62e9\u4e86\u56fd\u5bb6\uff1a" + str);
        this.mOnGetUserLocationListener.onGetUserLocation(true, new String[]{str, "0", "0", "0"}, true);
    }

    @Override // com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit.OnActionSheetListener
    public void onConfirm() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit.OnActionSheetListener
    public void onDismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        IProfileEditBusinessApi.OnGetUserLocationListener onGetUserLocationListener = this.mOnGetUserLocationListener;
        if (onGetUserLocationListener != null) {
            onGetUserLocationListener.onGetUserLocation(false, null, true);
        }
    }

    public void setOnGetUserLocationListener(IProfileEditBusinessApi.OnGetUserLocationListener onGetUserLocationListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) onGetUserLocationListener);
        } else {
            this.mOnGetUserLocationListener = onGetUserLocationListener;
        }
    }

    public CountrySelectActionSheet(Context context, String str) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) str);
            return;
        }
        initCountrySelectView(str);
        initUI();
        setContentWrapperView(this.mCountrySelectView.getRootView());
        setOnActionSheetListener(this);
    }
}
