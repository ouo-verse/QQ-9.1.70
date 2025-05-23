package com.tencent.mobileqq.profilecard.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi;
import com.tencent.mobileqq.profilecard.data.AddressInfo;
import com.tencent.mobileqq.profilecard.fragment.ProfileEditFragment;
import com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit;
import com.tencent.mobileqq.profilecard.widget.CountrySelect.CountrySelectActionSheet;
import com.tencent.mobileqq.profilecard.widget.selector.ProvinceSelectorView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.u;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes16.dex */
public class ProfileLocationActionSheet {
    static IPatchRedirector $redirector_ = null;
    private static final String ADDRESS_SEPARATOR = "-";
    private static final long ERROR_DELAY_TIME = 20000;
    private static final long MIN_WAITING_MILLIES = 1200;
    private static final String[] PERMISSIONS;
    private static final String TAG = "ProfileLocationActionSheet";
    private View countryLayout;
    private CoverDialog coverDialog;
    public ActionSheetProfileEdit mActionSheet;
    public QBaseActivity mActivity;
    public BaseQQAppInterface mApp;
    public Card mCard;
    private AddressInfo[] mColumnArray;
    public Context mContext;
    private AddressInfo mCountry;
    private String mCountryStr;
    private TextView mCountryTv;
    private String mCountyCodeStr;
    private Object mCsmConfigListenr;
    private QQProgressDialog mDlgProgress;
    private Dialog mEntDialog;
    private String[] mInitAddressCodes;
    private String mInitCountyCodeStr;
    private String mInitLocationStr;
    private String[] mLastAddressCodes;
    private BusinessObserver mLbsObserver;
    private ImageView mLoadingIv;
    private long mLocationReqTime;
    private String mLocationStr;
    IProfileEditBusinessApi.OnCheckCSMListener mOnCheckCSMListener;
    public ProfileEditFragment.OnLocationUpdateListener mOnLocationUpdateListener;
    private ActionSheetProfileEdit.OnPrivacyListener mOnPrivacyListener;
    private int mPrivacy;
    private View mProvinceLayout;
    private String mProvinceStr;
    private TextView mProvinceTitle;
    private TextView mProvinceTv;
    IProfileEditBusinessApi.OnGetUserLocationListener onGetUserLocationListener;
    IProfileEditBusinessApi.OnLocationUpdateListener onLocationUpdateListener;
    private ProvinceSelectorView provinceSelectorView;
    private boolean saveInfoImmediately;
    private View useCurrLocLayout;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39722);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            PERMISSIONS = new String[]{"android.permission.ACCESS_COARSE_LOCATION"};
        }
    }

    public ProfileLocationActionSheet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mCountyCodeStr = "1";
        this.mInitCountyCodeStr = "1";
        this.mPrivacy = -1;
        this.saveInfoImmediately = true;
        this.mOnCheckCSMListener = new IProfileEditBusinessApi.OnCheckCSMListener() { // from class: com.tencent.mobileqq.profilecard.widget.ProfileLocationActionSheet.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileLocationActionSheet.this);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi.OnCheckCSMListener
            public void onCheckDone(boolean z16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    ProfileLocationActionSheet.this.dismissWaitingDialog();
                    if (z16) {
                        ProfileLocationActionSheet profileLocationActionSheet = ProfileLocationActionSheet.this;
                        profileLocationActionSheet.initLocationInfo(profileLocationActionSheet.mCard.strLocationCodes);
                        ProfileLocationActionSheet.this.mApp.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.profilecard.widget.ProfileLocationActionSheet.1.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                    ProfileLocationActionSheet.this.initLocationActionSheetLayout();
                                } else {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                }
                            }
                        });
                        return;
                    }
                    QQToast.makeText(ProfileLocationActionSheet.this.mContext, R.string.zna, 0).show(((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).getTitleBarHeight(ProfileLocationActionSheet.this.mContext));
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this, z16);
            }

            @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi.OnCheckCSMListener
            public void onUpdateResult(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, i3);
                    return;
                }
                if (i3 != -2) {
                    if (i3 == -1) {
                        QQToast.makeText(ProfileLocationActionSheet.this.mContext, R.string.f171139ci4, 0).show(((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).getTitleBarHeight(ProfileLocationActionSheet.this.mContext));
                    }
                } else {
                    ProfileLocationActionSheet profileLocationActionSheet = ProfileLocationActionSheet.this;
                    Context context = profileLocationActionSheet.mContext;
                    profileLocationActionSheet.showWaitingDialog(context, context.getString(R.string.znd));
                    ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.profilecard.widget.ProfileLocationActionSheet.1.2
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                ProfileLocationActionSheet.this.dismissWaitingDialog();
                                QQToast.makeText(ProfileLocationActionSheet.this.mContext, R.string.zna, 0).show(((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).getTitleBarHeight(ProfileLocationActionSheet.this.mContext));
                            } else {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            }
                        }
                    }, ProfileLocationActionSheet.ERROR_DELAY_TIME);
                }
            }
        };
        this.onGetUserLocationListener = new IProfileEditBusinessApi.OnGetUserLocationListener() { // from class: com.tencent.mobileqq.profilecard.widget.ProfileLocationActionSheet.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileLocationActionSheet.this);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi.OnGetUserLocationListener
            public void onGetUserLocation(boolean z16, String[] strArr, boolean z17) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), strArr, Boolean.valueOf(z17));
                    return;
                }
                ActionSheetProfileEdit actionSheetProfileEdit = ProfileLocationActionSheet.this.mActionSheet;
                if (actionSheetProfileEdit != null && z17 && !actionSheetProfileEdit.isShowing()) {
                    ProfileLocationActionSheet.this.mActionSheet.show();
                }
                if (Math.abs(System.currentTimeMillis() - ProfileLocationActionSheet.this.mLocationReqTime) > 1200) {
                    ProfileLocationActionSheet.this.doOnGetUserLocation(z16, strArr);
                } else {
                    ThreadManager.getSubThreadHandler().postDelayed(new Runnable(z16, strArr) { // from class: com.tencent.mobileqq.profilecard.widget.ProfileLocationActionSheet.2.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ String[] val$codes;
                        final /* synthetic */ boolean val$isSuccess;

                        {
                            this.val$isSuccess = z16;
                            this.val$codes = strArr;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, this, AnonymousClass2.this, Boolean.valueOf(z16), strArr);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                ProfileLocationActionSheet.this.doOnGetUserLocation(this.val$isSuccess, this.val$codes);
                            } else {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            }
                        }
                    }, 1200L);
                }
            }
        };
        this.onLocationUpdateListener = new IProfileEditBusinessApi.OnLocationUpdateListener() { // from class: com.tencent.mobileqq.profilecard.widget.ProfileLocationActionSheet.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileLocationActionSheet.this);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi.OnLocationUpdateListener
            public void OnLocationUpdate(boolean z16, String str, String str2, String str3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), str, str2, str3);
                } else {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable(z16, str, str2, str3) { // from class: com.tencent.mobileqq.profilecard.widget.ProfileLocationActionSheet.3.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ String val$countryName;
                        final /* synthetic */ boolean val$isSuc;
                        final /* synthetic */ String val$locationStr;
                        final /* synthetic */ String val$provinceName;

                        {
                            this.val$isSuc = z16;
                            this.val$countryName = str;
                            this.val$provinceName = str2;
                            this.val$locationStr = str3;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, this, AnonymousClass3.this, Boolean.valueOf(z16), str, str2, str3);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            int i3;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            if (ProfileLocationActionSheet.this.mLoadingIv != null) {
                                ProfileLocationActionSheet.this.mLoadingIv.setVisibility(8);
                            }
                            if (this.val$isSuc) {
                                if (ProfileLocationActionSheet.this.mCountryTv != null) {
                                    ProfileLocationActionSheet.this.mCountryTv.setText(this.val$countryName);
                                    ProfileLocationActionSheet.this.mCountryTv.setContentDescription(HardCodeUtil.qqStr(R.string.ntt) + this.val$countryName);
                                }
                                boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(ProfileLocationActionSheet.this.mApp, false, null);
                                if (ProfileLocationActionSheet.this.mProvinceTv != null && ProfileLocationActionSheet.this.mProvinceTitle != null) {
                                    String str4 = "";
                                    if (TextUtils.isEmpty(this.val$provinceName)) {
                                        ProfileLocationActionSheet.this.mProvinceLayout.setClickable(false);
                                        ProfileLocationActionSheet.this.mProvinceTv.setText("");
                                        ProfileLocationActionSheet.this.mProvinceTitle.setTextColor(Color.parseColor("#999999"));
                                    } else {
                                        ProfileLocationActionSheet.this.mProvinceLayout.setClickable(true);
                                        TextView textView = ProfileLocationActionSheet.this.mProvinceTv;
                                        if (!this.val$provinceName.equals(IProfileCardConst.NAME_NO_LIMIT)) {
                                            str4 = this.val$provinceName;
                                        }
                                        textView.setText(str4);
                                        TextView textView2 = ProfileLocationActionSheet.this.mProvinceTitle;
                                        if (isNowThemeIsNight) {
                                            i3 = -1;
                                        } else {
                                            i3 = -16777216;
                                        }
                                        textView2.setTextColor(i3);
                                        ProfileLocationActionSheet.this.mProvinceTv.setContentDescription(HardCodeUtil.qqStr(R.string.ntv) + this.val$provinceName);
                                    }
                                }
                                ProfileLocationActionSheet.this.mLocationStr = this.val$locationStr;
                                return;
                            }
                            QQToast.makeText(ProfileLocationActionSheet.this.mContext, HardCodeUtil.qqStr(R.string.zn7), 0).show(((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).getTitleBarHeight(ProfileLocationActionSheet.this.mContext));
                        }
                    });
                }
            }
        };
    }

    private void dialogDismiss(Dialog dialog) {
        try {
            dialog.dismiss();
        } catch (Exception unused) {
        } catch (Throwable th5) {
            sy3.a.a(dialog);
            throw th5;
        }
        sy3.a.a(dialog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissCoverDialog() {
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.profilecard.widget.ProfileLocationActionSheet.10
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileLocationActionSheet.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (ProfileLocationActionSheet.this.coverDialog != null) {
                    ProfileLocationActionSheet.this.coverDialog.dismiss();
                }
                ProfileLocationActionSheet.this.onDestroy();
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissWaitingDialog() {
        QQProgressDialog qQProgressDialog = this.mDlgProgress;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.mDlgProgress.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doOnGetUserLocation(boolean z16, String[] strArr) {
        AddressInfo addressInfo;
        if (z16 && strArr != null && strArr.length == 4) {
            int i3 = 0;
            if (!TextUtils.isEmpty(strArr[0])) {
                addressInfo = ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).getCountryByCode(this.mApp, strArr[0]);
            } else {
                addressInfo = null;
            }
            if (addressInfo != null) {
                this.mCountyCodeStr = strArr[0];
                resetLastCodes();
                int length = strArr.length;
                for (int i16 = 1; i16 < length; i16++) {
                    if (!TextUtils.isEmpty(strArr[i16])) {
                        this.mLastAddressCodes[i3] = strArr[i16];
                        i3++;
                    }
                }
                initLocationData();
                if (this.mCountry == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "invalid country!! | cournty is : null");
                        return;
                    }
                    return;
                } else {
                    this.mLocationStr = generateLocationString();
                    IProfileEditBusinessApi.OnLocationUpdateListener onLocationUpdateListener = this.onLocationUpdateListener;
                    AddressInfo addressInfo2 = this.mCountry;
                    onLocationUpdateListener.OnLocationUpdate(true, addressInfo2.name, createLocationString(addressInfo2.count), this.mLocationStr);
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "invalid country code!! | cournty code is :" + strArr[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String[] genarateLocationCodes() {
        String[] strArr = new String[4];
        strArr[0] = this.mCountyCodeStr;
        strArr[1] = "0";
        strArr[2] = "0";
        strArr[3] = "0";
        AddressInfo[] addressInfoArr = this.mColumnArray;
        if (addressInfoArr != null) {
            int length = addressInfoArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                AddressInfo addressInfo = this.mColumnArray[i3];
                if (addressInfo == null) {
                    break;
                }
                strArr[addressInfo.addressType] = addressInfo.code;
            }
        }
        return strArr;
    }

    private void getCurrentLocation() {
        checkAndEnableLbs(new Runnable() { // from class: com.tencent.mobileqq.profilecard.widget.ProfileLocationActionSheet.8
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileLocationActionSheet.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    QQPermissionFactory.getQQPermission(ProfileLocationActionSheet.this.mActivity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_BUSINESS_CARD, QQPermissionConstants.Business.SCENE.PROFILE_CARD_EDIT_GET_CURRENT_LOCATION)).requestPermissions(ProfileLocationActionSheet.PERMISSIONS, 2, new QQPermission.BasePermissionsListener() { // from class: com.tencent.mobileqq.profilecard.widget.ProfileLocationActionSheet.8.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass8.this);
                            }
                        }

                        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
                        public void onAllGranted() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                super.onAllGranted();
                                ProfileLocationActionSheet.this.reqCurrentLocation();
                            }
                        }

                        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
                        public void onDenied(List<String> list, List<Integer> list2) {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                                iPatchRedirector2.redirect((short) 3, (Object) this, (Object) list, (Object) list2);
                                return;
                            }
                            super.onDenied(list, list2);
                            if (ProfileLocationActionSheet.this.mLoadingIv != null) {
                                ProfileLocationActionSheet.this.mLoadingIv.setVisibility(8);
                            }
                            ProfileLocationActionSheet.this.doOnGetUserLocation(false, null);
                        }
                    });
                }
            }
        });
    }

    private void initAddressCode() {
        this.mInitAddressCodes = new String[]{"0", "0", "0"};
    }

    private void initLastLocation(String str) {
        String[] strArr;
        if (!TextUtils.isEmpty(str)) {
            strArr = str.split("-");
        } else {
            strArr = null;
        }
        initAddressCode();
        resetLastCodes();
        if (strArr != null) {
            if (((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).isFirstPickLocation(this.mApp) && strArr[0].equals("0")) {
                return;
            }
            String str2 = strArr[0];
            this.mCountyCodeStr = str2;
            this.mInitCountyCodeStr = str2;
            int length = strArr.length;
            for (int i3 = 1; i3 < length; i3++) {
                int i16 = i3 - 1;
                this.mLastAddressCodes[i16] = strArr[i3];
                this.mInitAddressCodes[i16] = strArr[i3];
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initLocationActionSheetLayout() {
        ActionSheetProfileEdit createLocationMenuDialog = ActionSheetProfileEdit.createLocationMenuDialog(this.mContext);
        this.mActionSheet = createLocationMenuDialog;
        ((TextView) createLocationMenuDialog.findViewById(R.id.title)).setText(HardCodeUtil.qqStr(R.string.f175422yi));
        this.useCurrLocLayout = this.mActionSheet.findViewById(R.id.f82364go);
        this.countryLayout = this.mActionSheet.findViewById(R.id.f82294gh);
        this.mProvinceLayout = this.mActionSheet.findViewById(R.id.f82334gl);
        this.mProvinceTitle = (TextView) this.mActionSheet.findViewById(R.id.f82344gm);
        this.mCountryTv = (TextView) this.mActionSheet.findViewById(R.id.f82314gj);
        this.mProvinceTv = (TextView) this.mActionSheet.findViewById(R.id.f82354gn);
        this.mLoadingIv = (ImageView) this.mActionSheet.findViewById(R.id.f82324gk);
        if (!TextUtils.isEmpty(this.mCountryStr)) {
            this.mCountryTv.setText(this.mCountryStr);
            this.mCountryTv.setContentDescription(HardCodeUtil.qqStr(R.string.ntt) + this.mCountryStr);
        }
        this.useCurrLocLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.widget.ProfileLocationActionSheet.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileLocationActionSheet.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else if (!u.a().b()) {
                    ProfileLocationActionSheet.this.onLocationClickUseCurrent();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        this.countryLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.widget.ProfileLocationActionSheet.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileLocationActionSheet.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else if (!u.a().b()) {
                    ProfileLocationActionSheet profileLocationActionSheet = ProfileLocationActionSheet.this;
                    CountrySelectActionSheet countrySelectActionSheet = new CountrySelectActionSheet(profileLocationActionSheet.mContext, profileLocationActionSheet.mCountyCodeStr);
                    countrySelectActionSheet.setOnGetUserLocationListener(ProfileLocationActionSheet.this.onGetUserLocationListener);
                    countrySelectActionSheet.show();
                    ProfileLocationActionSheet.this.mActionSheet.dismiss();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        this.mProvinceLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.widget.ProfileLocationActionSheet.6
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileLocationActionSheet.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String[] strArr;
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else if (!u.a().b()) {
                    ProfileLocationActionSheet profileLocationActionSheet = ProfileLocationActionSheet.this;
                    if (profileLocationActionSheet.mLastAddressCodes != null) {
                        strArr = ProfileLocationActionSheet.this.mLastAddressCodes;
                    } else {
                        strArr = new String[]{"0", "0", "0"};
                    }
                    profileLocationActionSheet.mLastAddressCodes = strArr;
                    if (ProfileLocationActionSheet.this.provinceSelectorView == null) {
                        ProfileLocationActionSheet profileLocationActionSheet2 = ProfileLocationActionSheet.this;
                        profileLocationActionSheet2.provinceSelectorView = new ProvinceSelectorView(profileLocationActionSheet2.mActivity);
                        ProfileLocationActionSheet.this.provinceSelectorView.setTitle("\u9009\u62e9\u7701\u4efd");
                        ProfileLocationActionSheet.this.provinceSelectorView.setPrivacyVisibility(8);
                    }
                    ProfileLocationActionSheet.this.provinceSelectorView.init(ProfileLocationActionSheet.this.mCountyCodeStr, ProfileLocationActionSheet.this.mLastAddressCodes);
                    if (ProfileLocationActionSheet.this.provinceSelectorView.getOnActionSheetListener() == null) {
                        ProfileLocationActionSheet.this.provinceSelectorView.setOnActionSheetListener(new ActionSheetProfileEdit.OnActionSheetListener() { // from class: com.tencent.mobileqq.profilecard.widget.ProfileLocationActionSheet.6.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass6.this);
                                }
                            }

                            @Override // com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit.OnActionSheetListener
                            public void onConfirm() {
                                boolean z16;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                                    iPatchRedirector2.redirect((short) 3, (Object) this);
                                    return;
                                }
                                String[] codes = ProfileLocationActionSheet.this.provinceSelectorView.getCodes();
                                IProfileEditBusinessApi.OnGetUserLocationListener onGetUserLocationListener = ProfileLocationActionSheet.this.onGetUserLocationListener;
                                if (codes != null) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                onGetUserLocationListener.onGetUserLocation(z16, codes, true);
                            }

                            @Override // com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit.OnActionSheetListener
                            public void onDismiss() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                } else {
                                    ProfileLocationActionSheet.this.onGetUserLocationListener.onGetUserLocation(false, null, true);
                                }
                            }
                        });
                    }
                    ProfileLocationActionSheet.this.provinceSelectorView.show();
                    ProfileLocationActionSheet.this.mActionSheet.dismiss();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        this.mActionSheet.setOnActionSheetListener(new ActionSheetProfileEdit.OnActionSheetListener() { // from class: com.tencent.mobileqq.profilecard.widget.ProfileLocationActionSheet.7
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileLocationActionSheet.this);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit.OnActionSheetListener
            public void onConfirm() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this);
                    return;
                }
                if (!ProfileLocationActionSheet.this.mActionSheet.isHide()) {
                    String[] genarateLocationCodes = ProfileLocationActionSheet.this.genarateLocationCodes();
                    ProfileLocationActionSheet profileLocationActionSheet = ProfileLocationActionSheet.this;
                    profileLocationActionSheet.mOnLocationUpdateListener.onLocationStrUpdate(profileLocationActionSheet.mLocationStr, genarateLocationCodes);
                    if (ProfileLocationActionSheet.this.saveInfoImmediately) {
                        IProfileEditBusinessApi iProfileEditBusinessApi = (IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class);
                        ProfileLocationActionSheet profileLocationActionSheet2 = ProfileLocationActionSheet.this;
                        iProfileEditBusinessApi.saveLocationInfo(profileLocationActionSheet2.mApp, profileLocationActionSheet2.mContext, genarateLocationCodes, profileLocationActionSheet2.mLocationStr, ProfileLocationActionSheet.this.mLastAddressCodes);
                    }
                    QLog.i(ProfileLocationActionSheet.TAG, 1, String.format("onConfirm locationCode: %s, mLocationStr: %s, mLastAddressCodes: %s", Arrays.toString(genarateLocationCodes), ProfileLocationActionSheet.this.mLocationStr, Arrays.toString(ProfileLocationActionSheet.this.mLastAddressCodes)));
                }
                IProfileEditBusinessApi iProfileEditBusinessApi2 = (IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class);
                ProfileLocationActionSheet profileLocationActionSheet3 = ProfileLocationActionSheet.this;
                iProfileEditBusinessApi2.destroyLocationSearchManager(profileLocationActionSheet3.mApp, profileLocationActionSheet3.mContext, profileLocationActionSheet3.mCsmConfigListenr);
                ProfileLocationActionSheet.this.dismissCoverDialog();
            }

            @Override // com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit.OnActionSheetListener
            public void onDismiss() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    ProfileLocationActionSheet.this.dismissCoverDialog();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        });
        String str = "";
        if (TextUtils.isEmpty(this.mProvinceStr)) {
            this.mProvinceTitle.setTextColor(Color.parseColor("#999999"));
            this.mProvinceTv.setText("");
            this.mProvinceLayout.setClickable(false);
        } else {
            this.mProvinceLayout.setClickable(true);
            TextView textView = this.mProvinceTv;
            if (!this.mProvinceStr.equals(IProfileCardConst.NAME_NO_LIMIT)) {
                str = this.mProvinceStr;
            }
            textView.setText(str);
            this.mProvinceTv.setContentDescription(HardCodeUtil.qqStr(R.string.ntv) + this.mProvinceStr);
        }
        this.mActionSheet.setPrivacy(this.mPrivacy);
        onPrivacyChange(this.mPrivacy);
        ActionSheetProfileEdit.OnPrivacyListener onPrivacyListener = this.mOnPrivacyListener;
        if (onPrivacyListener != null) {
            this.mActionSheet.setOnPrivacyListener(onPrivacyListener);
        }
        this.mActionSheet.setOnPrivacyChangeListener(new ActionSheetProfileEdit.OnPrivacyChangeListener() { // from class: com.tencent.mobileqq.profilecard.widget.a
            @Override // com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit.OnPrivacyChangeListener
            public final void onChange(int i3) {
                ProfileLocationActionSheet.this.onPrivacyChange(i3);
            }
        });
        try {
            QBaseActivity qBaseActivity = this.mActivity;
            if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
                showCoverDialog();
                this.mActionSheet.show();
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "action sheet show error", e16);
        }
    }

    private void initLocationData() {
        AddressInfo countryByCode = ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).getCountryByCode(this.mApp, this.mCountyCodeStr);
        this.mCountry = countryByCode;
        if (countryByCode == null) {
            return;
        }
        int i3 = countryByCode.count;
        this.mColumnArray = new AddressInfo[i3];
        if (i3 == 0) {
            return;
        }
        int length = this.mLastAddressCodes.length;
        int i16 = 0;
        for (int i17 = 0; i17 < length; i17++) {
            if (!"0".equals(this.mLastAddressCodes[i17])) {
                AddressInfo[] addressInfoArr = this.mColumnArray;
                countryByCode = countryByCode.dataMap.get(this.mLastAddressCodes[i17]);
                addressInfoArr[i16] = countryByCode;
                i16++;
                if (countryByCode == null) {
                    return;
                }
            }
        }
        if (i16 == 0) {
            this.mColumnArray[i16] = countryByCode.dataMap.get(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLbsEnabled() {
        return ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).isObtainLocAllowed(this.mApp.getAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showEnableLbsDialog$0(DialogInterface dialogInterface, int i3) {
        ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setObtainLocAllowed(this.mApp.getAccount(), true);
        dialogDismiss(this.mEntDialog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showEnableLbsDialog$1(DialogInterface dialogInterface, int i3) {
        Dialog dialog = this.mEntDialog;
        if (dialog != null && dialog.isShowing()) {
            dialogDismiss(this.mEntDialog);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLBSForbidden() {
        this.mLoadingIv.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLocationClickUseCurrent() {
        ImageView imageView = this.mLoadingIv;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        ReportController.o(this.mApp, "CliOper", "", "", "0X8004246", "0X8004246", 0, 0, "", "", "", "");
        getCurrentLocation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reqCurrentLocation() {
        if (!NetworkUtil.isNetSupport(this.mContext)) {
            QQToast.makeText(this.mContext, R.string.f171139ci4, 0).show(this.mActivity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        } else {
            this.mLocationReqTime = System.currentTimeMillis();
            ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).requestUserLocation(this.mApp);
        }
    }

    private void resetLastCodes() {
        this.mLastAddressCodes = new String[]{"0", "0", "0"};
        this.mColumnArray = null;
    }

    private void showCoverDialog() {
        if (this.coverDialog == null) {
            this.coverDialog = new CoverDialog(this.mContext);
        }
        this.coverDialog.show();
    }

    private void showEnableLbsDialog(Runnable runnable) {
        DialogInterface.OnDismissListener onDismissListener = new DialogInterface.OnDismissListener(runnable) { // from class: com.tencent.mobileqq.profilecard.widget.ProfileLocationActionSheet.9
            static IPatchRedirector $redirector_;
            final /* synthetic */ Runnable val$okRunner;

            {
                this.val$okRunner = runnable;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileLocationActionSheet.this, (Object) runnable);
                }
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                } else if (!ProfileLocationActionSheet.this.isLbsEnabled()) {
                    ProfileLocationActionSheet.this.onLBSForbidden();
                } else {
                    this.val$okRunner.run();
                }
            }
        };
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.mContext, 230, HardCodeUtil.qqStr(R.string.f175712za), HardCodeUtil.qqStr(R.string.f175702z_), HardCodeUtil.qqStr(R.string.f175692z9), HardCodeUtil.qqStr(R.string.f175682z8), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.widget.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ProfileLocationActionSheet.this.lambda$showEnableLbsDialog$0(dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.widget.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ProfileLocationActionSheet.this.lambda$showEnableLbsDialog$1(dialogInterface, i3);
            }
        });
        this.mEntDialog = createCustomDialog;
        createCustomDialog.setOnDismissListener(onDismissListener);
        try {
            QBaseActivity qBaseActivity = this.mActivity;
            if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
                this.mEntDialog.show();
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "action sheet show error", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showWaitingDialog(Context context, String str) {
        if (this.mDlgProgress == null) {
            this.mDlgProgress = new QQProgressDialog(context, 44);
        }
        this.mDlgProgress.setMessage(str);
        try {
            QBaseActivity qBaseActivity = this.mActivity;
            if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
                this.mDlgProgress.show();
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "showWaitingDialog error", e16);
        }
    }

    protected void checkAndEnableLbs(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) runnable);
        } else if (isLbsEnabled()) {
            runnable.run();
        } else {
            showEnableLbsDialog(runnable);
        }
    }

    public String createLocationString(int i3) {
        AddressInfo addressInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
        if (i3 == 0) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        for (int i16 = 0; i16 < i3; i16++) {
            AddressInfo[] addressInfoArr = this.mColumnArray;
            if (addressInfoArr != null && (addressInfo = addressInfoArr[i16]) != null && !"0".equals(addressInfo.code)) {
                sb5.append(this.mColumnArray[i16].name);
                sb5.append("-");
            }
        }
        String sb6 = sb5.toString();
        if (TextUtils.isEmpty(sb6)) {
            return IProfileCardConst.NAME_NO_LIMIT;
        }
        return sb6.substring(0, sb6.length() - 1);
    }

    public void disableSaveInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.saveInfoImmediately = false;
        }
    }

    public String generateLocationString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        String[] strArr = new String[4];
        strArr[0] = this.mCountyCodeStr;
        strArr[1] = "0";
        strArr[2] = "0";
        strArr[3] = "0";
        AddressInfo[] addressInfoArr = this.mColumnArray;
        if (addressInfoArr != null) {
            int length = addressInfoArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                AddressInfo addressInfo = this.mColumnArray[i3];
                if (addressInfo == null) {
                    break;
                }
                strArr[addressInfo.addressType] = addressInfo.code;
            }
        }
        return ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).generateLocationString(this.mApp, strArr);
    }

    public ActionSheetProfileEdit.OnPrivacyListener getOnPrivacyListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ActionSheetProfileEdit.OnPrivacyListener) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        ActionSheetProfileEdit actionSheetProfileEdit = this.mActionSheet;
        if (actionSheetProfileEdit != null) {
            return actionSheetProfileEdit.getOnPrivacyListener();
        }
        return null;
    }

    public void init(@NonNull Context context, BaseQQAppInterface baseQQAppInterface, Card card, ProfileEditFragment.OnLocationUpdateListener onLocationUpdateListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, baseQQAppInterface, card, onLocationUpdateListener);
            return;
        }
        this.mApp = baseQQAppInterface;
        this.mCard = card;
        this.mContext = context;
        this.mActivity = (QBaseActivity) context;
        this.mOnLocationUpdateListener = onLocationUpdateListener;
        this.saveInfoImmediately = true;
        if (this.onGetUserLocationListener != null) {
            BusinessObserver createLBSObserver = ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).createLBSObserver(this.onGetUserLocationListener);
            this.mLbsObserver = createLBSObserver;
            this.mApp.addObserver(createLBSObserver);
        }
    }

    public void initLocationInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        initLastLocation(str);
        initLocationData();
        String generateLocationString = generateLocationString();
        this.mLocationStr = generateLocationString;
        this.mInitLocationStr = generateLocationString;
        AddressInfo addressInfo = this.mCountry;
        if (addressInfo != null) {
            this.mCountryStr = addressInfo.name;
            this.mProvinceStr = createLocationString(addressInfo.count);
        }
    }

    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.mApp.removeObserver(this.mLbsObserver);
            ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).destroyLocationSearchManager(this.mApp, this.mContext, this.mCsmConfigListenr);
        }
    }

    public void onPrivacyChange(int i3) {
        boolean z16;
        int color;
        int color2;
        String str;
        int color3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
            return;
        }
        if (i3 == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.mLocationStr = this.mInitLocationStr;
            this.mCountyCodeStr = this.mInitCountyCodeStr;
            String[] strArr = this.mInitAddressCodes;
            System.arraycopy(strArr, 0, this.mLastAddressCodes, 0, strArr.length);
            initLocationData();
        }
        this.useCurrLocLayout.setFocusable(!z16);
        this.useCurrLocLayout.setClickable(!z16);
        TextView textView = (TextView) this.useCurrLocLayout.findViewById(R.id.f82374gp);
        if (z16) {
            color = this.useCurrLocLayout.getResources().getColor(R.color.qui_common_text_secondary);
        } else {
            color = this.useCurrLocLayout.getResources().getColor(R.color.qui_common_text_primary);
        }
        textView.setTextColor(color);
        this.countryLayout.setFocusable(!z16);
        this.countryLayout.setClickable(!z16);
        TextView textView2 = (TextView) this.countryLayout.findViewById(R.id.f82304gi);
        if (z16) {
            color2 = this.countryLayout.getResources().getColor(R.color.qui_common_text_secondary);
        } else {
            color2 = this.countryLayout.getResources().getColor(R.color.qui_common_text_primary);
        }
        textView2.setTextColor(color2);
        TextView textView3 = this.mCountryTv;
        String str2 = "";
        if (z16) {
            str = "";
        } else {
            str = this.mCountry.name;
        }
        textView3.setText(str);
        this.mProvinceLayout.setFocusable(!z16);
        this.mProvinceLayout.setClickable(!z16);
        TextView textView4 = (TextView) this.mProvinceLayout.findViewById(R.id.f82344gm);
        if (z16) {
            color3 = this.mProvinceLayout.getResources().getColor(R.color.qui_common_text_secondary);
        } else {
            color3 = this.mProvinceLayout.getResources().getColor(R.color.qui_common_text_primary);
        }
        textView4.setTextColor(color3);
        TextView textView5 = this.mProvinceTv;
        if (!z16) {
            str2 = createLocationString(this.mCountry.count);
        }
        textView5.setText(str2);
    }

    public void setOnPrivacyListener(ActionSheetProfileEdit.OnPrivacyListener onPrivacyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) onPrivacyListener);
        } else {
            this.mOnPrivacyListener = onPrivacyListener;
        }
    }

    public void setPrivacy(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.mPrivacy = i3;
        }
    }

    public void show() {
        Object initSearchManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.mApp != null && this.mCard != null && this.mContext != null && this.mOnLocationUpdateListener != null && (initSearchManager = ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).initSearchManager(this.mApp, this.mContext, this.mOnCheckCSMListener)) != null) {
            this.mCsmConfigListenr = initSearchManager;
        }
    }
}
