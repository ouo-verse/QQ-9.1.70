package com.tenpay.lcation;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tenpay.idverify.utils.IdVerifyUtils;
import com.tenpay.proxy.QUIProxy;
import com.tenpay.proxy.dlg.location.LocSelDlg;
import com.tenpay.proxy.dlg.location.QbAddrData;
import com.tenpay.proxy.dlg.location.QbAddrHelper;
import com.tenpay.proxy.dlg.location.QbBaseAddr;
import com.tenpay.sdk.util.TenUtils;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes27.dex */
public class LocationInputFragment extends QWalletBaseFragment implements View.OnClickListener {
    public static final String KEY_ADDRESS_CITY = "address_city";
    public static final String KEY_ADDRESS_DISTRICT = "address_district";
    public static final String KEY_ADDRESS_PROVINCE = "address_province";
    public static final String KEY_DETAIL_ADDRESS = "address_detail";
    public static final String LBS_BIZ_QWALLET_ID_VERIFY = "lbs_biz_qwallet_id_verify";
    private static final int LOADING_TIMEOUT_MILLISECOND = 5000;
    private static final String TAG = "LocationInputFragment";
    private static final AtomicReference<QbAddrData> mAtomicReference = new AtomicReference<>(null);
    private ImageView mLoadingView;
    private LocSelDlg mLocSelDlg;
    private Runnable mTimeOutRunnable;
    private TextView mVerifyAddress;
    private TextView mVerifyAddressDetail;
    private Dialog mWaitingDialog;
    private final Runnable mDialogRunnable = new Runnable() { // from class: com.tenpay.lcation.f
        @Override // java.lang.Runnable
        public final void run() {
            LocationInputFragment.this.dismissDialog();
        }
    };
    private Animatable mAnimatedDrawale = null;
    private boolean mIsClickable = true;

    @NonNull
    private String mProvince = "";

    @NonNull
    private String mCity = "";

    @NonNull
    private String mDistrict = "";
    private final String locDataPath = ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).getConfigPath();

    private void cardIdClick(final String str) {
        if (mAtomicReference.get() != null) {
            showLocDialog(str);
        } else {
            TenUtils.checkUpdate(new ResultReceiver(ThreadManagerV2.getUIHandlerV2()) { // from class: com.tenpay.lcation.LocationInputFragment.1
                @Override // android.os.ResultReceiver
                protected void onReceiveResult(int i3, Bundle bundle) {
                    QLog.i(LocationInputFragment.TAG, 1, "resultCode : " + i3);
                    super.onReceiveResult(i3, bundle);
                    IQWalletTemp iQWalletTemp = (IQWalletTemp) QRoute.api(IQWalletTemp.class);
                    if (iQWalletTemp.isResultOk(i3)) {
                        LocationInputFragment.this.showLocDialog(str);
                        return;
                    }
                    if (bundle == null) {
                        QLog.e(LocationInputFragment.TAG, 1, "resultData == null");
                        QQToast.makeText(LocationInputFragment.this.getContext(), LocationInputFragment.this.getString(R.string.a8c), 0).show();
                        return;
                    }
                    int i16 = bundle.getInt("updateResult");
                    QLog.i(LocationInputFragment.TAG, 1, "resultCode : " + i3);
                    if (iQWalletTemp.isUpdateNetUnavailable(i16)) {
                        QQToast.makeText(LocationInputFragment.this.getContext(), R.string.f171139ci4, 0).show();
                        return;
                    }
                    if (iQWalletTemp.isUpdateOk(i16)) {
                        int i17 = bundle.getInt("isUpdateSuccess");
                        QLog.d(LocationInputFragment.TAG, 4, "isUpdateSuccess : " + i17);
                        LocationInputFragment.this.dismissDialog();
                        try {
                            File file = new File(LocationInputFragment.this.locDataPath);
                            if (i17 != 1 && (!file.exists() || file.length() <= 0)) {
                                QQToast.makeText(LocationInputFragment.this.getContext(), R.string.a8c, 0).show();
                                return;
                            }
                            QLog.d(LocationInputFragment.TAG, 4, "how local data...");
                            androidx.lifecycle.c.a(LocationInputFragment.mAtomicReference, null, QbAddrHelper.doPraseFile(file));
                            LocationInputFragment.this.showLocDialog(str);
                            return;
                        } catch (Exception e16) {
                            QLog.e(LocationInputFragment.TAG, 1, "", e16);
                            QQToast.makeText(LocationInputFragment.this.getContext(), LocationInputFragment.this.getString(R.string.a8c), 0).show();
                            return;
                        }
                    }
                    if (LocationInputFragment.this.mWaitingDialog == null || !LocationInputFragment.this.mWaitingDialog.isShowing()) {
                        QLog.e(LocationInputFragment.TAG, 1, "QUIProxy.showWaitingDialog...");
                        LocationInputFragment locationInputFragment = LocationInputFragment.this;
                        locationInputFragment.mWaitingDialog = QUIProxy.showWaitingDialog(locationInputFragment.getContext(), LocationInputFragment.this.getString(R.string.a8f), R.dimen.title_bar_height);
                    }
                    LocationInputFragment.this.mVerifyAddress.postDelayed(LocationInputFragment.this.mDialogRunnable, 60000L);
                }
            });
        }
    }

    private void checkAndResult() {
        showLoading();
        IdVerifyUtils.INSTANCE.checkAddress(this, this.mProvince, this.mCity, this.mDistrict, this.mVerifyAddressDetail.getText().toString(), new Function1() { // from class: com.tenpay.lcation.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit lambda$checkAndResult$3;
                lambda$checkAndResult$3 = LocationInputFragment.this.lambda$checkAndResult$3((Boolean) obj);
                return lambda$checkAndResult$3;
            }
        });
    }

    private String dealLocationStr(String str) {
        if (str != null && !"Unknown".equals(str)) {
            return str;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissDialog() {
        Dialog dialog = this.mWaitingDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mWaitingDialog.dismiss();
            this.mWaitingDialog = null;
        }
    }

    private String getAddress(SosoLocation sosoLocation) {
        if (sosoLocation == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        String dealLocationStr = dealLocationStr(sosoLocation.province);
        if (!TextUtils.isEmpty(dealLocationStr)) {
            this.mProvince = dealLocationStr;
            sb5.append(dealLocationStr);
        }
        String dealLocationStr2 = dealLocationStr(sosoLocation.city);
        if (!TextUtils.isEmpty(dealLocationStr2)) {
            this.mCity = dealLocationStr2;
            if (sb5.length() > 0) {
                sb5.append(" ");
            }
            sb5.append(dealLocationStr2);
        }
        String dealLocationStr3 = dealLocationStr(sosoLocation.district);
        if (!TextUtils.isEmpty(dealLocationStr3)) {
            this.mDistrict = dealLocationStr3;
            if (sb5.length() > 0) {
                sb5.append(" ");
            }
            sb5.append(dealLocationStr3);
        }
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getNameByCode(SosoLocation sosoLocation) {
        QbAddrData qbAddrData = mAtomicReference.get();
        if (qbAddrData != null && !TextUtils.isEmpty(sosoLocation.cityCode)) {
            QbBaseAddr qbBaseAddr = qbAddrData.countryMap.get("1");
            if (qbBaseAddr == null) {
                return getAddress(sosoLocation);
            }
            String str = sosoLocation.cityCode;
            String str2 = "";
            QbBaseAddr qbBaseAddr2 = qbBaseAddr.dataMap.get(str.substring(0, Math.min(2, str.length())).replaceFirst("0*", ""));
            if (qbBaseAddr2 == null) {
                return getAddress(sosoLocation);
            }
            String str3 = qbBaseAddr2.name;
            if (str3 == null) {
                str3 = "";
            }
            this.mProvince = str3;
            if (sosoLocation.cityCode.length() < 3) {
                return this.mProvince;
            }
            String str4 = sosoLocation.cityCode;
            QbBaseAddr qbBaseAddr3 = qbBaseAddr2.dataMap.get(str4.substring(2, Math.min(4, str4.length())).replaceFirst("0*", ""));
            if (qbBaseAddr3 == null) {
                return this.mProvince;
            }
            String str5 = qbBaseAddr3.name;
            if (str5 == null) {
                str5 = "";
            }
            this.mCity = str5;
            if (sosoLocation.cityCode.length() < 5) {
                return this.mProvince + " " + this.mCity;
            }
            String str6 = sosoLocation.cityCode;
            QbBaseAddr qbBaseAddr4 = qbBaseAddr3.dataMap.get(str6.substring(4, Math.min(6, str6.length())).replaceFirst("0*", ""));
            if (qbBaseAddr4 == null) {
                return this.mProvince + " " + this.mCity;
            }
            String str7 = qbBaseAddr4.name;
            if (str7 != null) {
                str2 = str7;
            }
            this.mDistrict = str2;
            return this.mProvince + " " + this.mCity + " " + this.mDistrict;
        }
        return getAddress(sosoLocation);
    }

    private void initIntent() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(KEY_ADDRESS_PROVINCE);
        String stringExtra2 = intent.getStringExtra(KEY_ADDRESS_CITY);
        String stringExtra3 = intent.getStringExtra(KEY_ADDRESS_DISTRICT);
        String stringExtra4 = intent.getStringExtra(KEY_DETAIL_ADDRESS);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.mProvince = stringExtra;
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        this.mCity = stringExtra2;
        if (stringExtra3 == null) {
            stringExtra3 = "";
        }
        this.mDistrict = stringExtra3;
        this.mVerifyAddress.setText((this.mProvince + " " + this.mCity + " " + this.mDistrict).trim());
        TextView textView = this.mVerifyAddressDetail;
        if (stringExtra4 == null) {
            stringExtra4 = "";
        }
        textView.setText(stringExtra4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$checkAndResult$3(Boolean bool) {
        dismissLoading();
        if (!bool.booleanValue()) {
            return Unit.INSTANCE;
        }
        Intent intent = new Intent();
        intent.putExtra(KEY_ADDRESS_PROVINCE, this.mProvince);
        intent.putExtra(KEY_ADDRESS_CITY, this.mCity);
        intent.putExtra(KEY_ADDRESS_DISTRICT, this.mDistrict);
        intent.putExtra(KEY_DETAIL_ADDRESS, this.mVerifyAddressDetail.getText().toString());
        setResult(-1, intent);
        finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0() {
        androidx.lifecycle.c.a(mAtomicReference, null, QbAddrHelper.doPraseFile(new File(this.locDataPath)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setFinishReqStatus$2() {
        if (this.mLoadingView.getVisibility() == 0) {
            this.mLoadingView.setVisibility(8);
        }
        Animatable animatable = this.mAnimatedDrawale;
        if (animatable != null && animatable.isRunning()) {
            this.mAnimatedDrawale.stop();
        }
        this.mIsClickable = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showLocDialog$1(String str) {
        String str2;
        String str3;
        if (this.mVerifyAddress != null && !TextUtils.isEmpty(str)) {
            String[] split = str.split(" ");
            String str4 = "";
            if (split.length < 1) {
                str2 = "";
            } else {
                str2 = split[0];
            }
            this.mProvince = str2;
            if (split.length < 2) {
                str3 = "";
            } else {
                str3 = split[1];
            }
            this.mCity = str3;
            if (split.length >= 3) {
                str4 = split[2];
            }
            this.mDistrict = str4;
            this.mVerifyAddress.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reqCurrentLocation() {
        if (!NetworkUtil.isNetSupport(getContext())) {
            QQToast.makeText(getContext(), R.string.f171139ci4, 0).show(getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            setFinishReqStatus();
            return;
        }
        setStartReqStatus();
        Runnable runnable = this.mTimeOutRunnable;
        if (runnable != null) {
            ThreadManagerV2.removeJob(runnable, 16);
        }
        this.mTimeOutRunnable = ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tenpay.lcation.e
            @Override // java.lang.Runnable
            public final void run() {
                LocationInputFragment.this.setFinishReqStatus();
            }
        }, 16, null, true, 5000L);
        ILbsManagerServiceApi iLbsManagerServiceApi = (ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class);
        String str = LBS_BIZ_QWALLET_ID_VERIFY;
        SosoLbsInfo cachedLbsInfo = iLbsManagerServiceApi.getCachedLbsInfo(LBS_BIZ_QWALLET_ID_VERIFY);
        if (cachedLbsInfo != null && cachedLbsInfo.mLocation != null) {
            setFinishReqStatus();
            this.mVerifyAddress.setText(getNameByCode(cachedLbsInfo.mLocation));
        } else {
            ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(new LbsManagerServiceOnLocationChangeListener(str, true) { // from class: com.tenpay.lcation.LocationInputFragment.2
                @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
                public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
                    QLog.d(LocationInputFragment.TAG, 2, "onLocationFinish errCode:" + i3 + ",info:" + sosoLbsInfo);
                    LocationInputFragment.this.setFinishReqStatus();
                    if (i3 == 0 && sosoLbsInfo != null && sosoLbsInfo.mLocation != null) {
                        LocationInputFragment.this.mVerifyAddress.setText(LocationInputFragment.this.getNameByCode(sosoLbsInfo.mLocation));
                    } else {
                        QLog.e(LocationInputFragment.TAG, 1, "LbsManagerService.startLocation: failed");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFinishReqStatus() {
        this.mLoadingView.post(new Runnable() { // from class: com.tenpay.lcation.d
            @Override // java.lang.Runnable
            public final void run() {
                LocationInputFragment.this.lambda$setFinishReqStatus$2();
            }
        });
    }

    private void setStartReqStatus() {
        if (this.mLoadingView.getVisibility() == 8) {
            this.mLoadingView.setVisibility(0);
        }
        Animatable animatable = this.mAnimatedDrawale;
        if (animatable != null && !animatable.isRunning()) {
            this.mAnimatedDrawale.start();
        }
        this.mIsClickable = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLocDialog(String str) {
        if (this.mLocSelDlg == null) {
            this.mLocSelDlg = new LocSelDlg(getContext(), str, R.id.f163936cz, R.layout.avo, mAtomicReference.get());
        }
        this.mLocSelDlg.setLocationSelected(new LocSelDlg.OnLocationLocationSelectedListener() { // from class: com.tenpay.lcation.a
            @Override // com.tenpay.proxy.dlg.location.LocSelDlg.OnLocationLocationSelectedListener
            public final void onConfirmBtClicked(String str2) {
                LocationInputFragment.this.lambda$showLocDialog$1(str2);
            }
        });
        this.mLocSelDlg.popupPickerView();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    protected boolean isStatusBarImmersive() {
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.a47) {
            finish();
        } else if (id5 == R.id.caw) {
            if (!TextUtils.isEmpty(this.mVerifyAddress.getText()) && !TextUtils.isEmpty(this.mVerifyAddressDetail.getText())) {
                checkAndResult();
            } else {
                QQToast.makeText(getContext(), "\u90e8\u5206\u4fe1\u606f\u672a\u586b\u5199", 0).show();
            }
        } else if (id5 == R.id.da_) {
            cardIdClick(this.mVerifyAddress.getText().toString().trim());
        } else if (id5 == R.id.f164528t00 && this.mIsClickable) {
            QQPermission qQPermission = QQPermissionFactory.getQQPermission(this, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QWALLET, QQPermissionConstants.Business.SCENE.QWALLET_ID_VERIFY_LOCATION));
            if (qQPermission.hasPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) {
                qQPermission.requestPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, 2, new QQPermission.BasePermissionsListener() { // from class: com.tenpay.lcation.LocationInputFragment.3
                    @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
                    public void onAllGranted() {
                        super.onAllGranted();
                        LocationInputFragment.this.reqCurrentLocation();
                        QLog.i(LocationInputFragment.TAG, 2, "grant location Permission");
                    }

                    @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
                    public void onDenied(List<String> list, List<Integer> list2) {
                        super.onDenied(list, list2);
                        LocationInputFragment.this.setFinishReqStatus();
                        QLog.i(LocationInputFragment.TAG, 2, "denied location Permission");
                    }
                });
            } else {
                QLog.i(TAG, 2, "has location Permission");
                reqCurrentLocation();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tenpay.lcation.c
            @Override // java.lang.Runnable
            public final void run() {
                LocationInputFragment.this.lambda$onCreate$0();
            }
        }, 64, null, false);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.hjj, viewGroup, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        dismissDialog();
        this.mVerifyAddress.removeCallbacks(this.mDialogRunnable);
        Runnable runnable = this.mTimeOutRunnable;
        if (runnable != null) {
            ThreadManagerV2.removeJob(runnable, 16);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.findViewById(R.id.caw).setOnClickListener(this);
        view.findViewById(R.id.a47).setOnClickListener(this);
        TextView textView = (TextView) view.findViewById(R.id.da_);
        this.mVerifyAddress = textView;
        textView.setOnClickListener(this);
        this.mVerifyAddressDetail = (TextView) view.findViewById(R.id.db7);
        view.findViewById(R.id.f164528t00).setOnClickListener(this);
        this.mLoadingView = (ImageView) view.findViewById(R.id.f164529t01);
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.kc6, null);
        this.mLoadingView.setImageDrawable(drawable);
        if (drawable instanceof Animatable) {
            this.mAnimatedDrawale = (Animatable) drawable;
        }
        initIntent();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
