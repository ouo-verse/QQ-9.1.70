package com.tencent.mobileqq.conditionsearch;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.av.service.LBSInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.LbsBaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.bh;
import com.tencent.mobileqq.conditionsearch.data.AddressData;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.widget.selector.ProvinceSelectorView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.u;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.selectorview.LocationSelectorView;
import com.tencent.mobileqq.widget.selectorview.QActionSheet;
import com.tencent.mobileqq.widget.selectorview.h;
import com.tencent.mobileqq.widget.selectorview.model.BaseAddress;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import cooperation.qzone.gift.QZoneCheckSendGiftServlet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class LocationSelectActivity extends LbsBaseActivity implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    DialogInterface.OnDismissListener A0;

    /* renamed from: a0, reason: collision with root package name */
    private h.b f201953a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f201954b0;

    /* renamed from: c0, reason: collision with root package name */
    ConditionSearchManager f201955c0;

    /* renamed from: d0, reason: collision with root package name */
    private FormSimpleItem f201956d0;

    /* renamed from: e0, reason: collision with root package name */
    private FormSimpleItem f201957e0;

    /* renamed from: f0, reason: collision with root package name */
    private FormSimpleItem f201958f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f201959g0;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f201960h0;

    /* renamed from: i0, reason: collision with root package name */
    private BaseAddress f201961i0;

    /* renamed from: j0, reason: collision with root package name */
    private String f201962j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f201963k0;

    /* renamed from: l0, reason: collision with root package name */
    List<BaseAddress> f201964l0;

    /* renamed from: m0, reason: collision with root package name */
    Object[] f201965m0;

    /* renamed from: n0, reason: collision with root package name */
    BaseAddress[] f201966n0;

    /* renamed from: o0, reason: collision with root package name */
    int[] f201967o0;

    /* renamed from: p0, reason: collision with root package name */
    String[] f201968p0;

    /* renamed from: q0, reason: collision with root package name */
    int f201969q0;

    /* renamed from: r0, reason: collision with root package name */
    String f201970r0;

    /* renamed from: s0, reason: collision with root package name */
    IphonePickerView.PickerViewAdapter f201971s0;

    /* renamed from: t0, reason: collision with root package name */
    ActionSheet f201972t0;

    /* renamed from: u0, reason: collision with root package name */
    IphonePickerView f201973u0;

    /* renamed from: v0, reason: collision with root package name */
    IphonePickerView.IphonePickListener f201974v0;

    /* renamed from: w0, reason: collision with root package name */
    long f201975w0;

    /* renamed from: x0, reason: collision with root package name */
    final int f201976x0;

    /* renamed from: y0, reason: collision with root package name */
    Handler f201977y0;

    /* renamed from: z0, reason: collision with root package name */
    private bh f201978z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocationSelectActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                LocationSelectActivity.this.onBackEvent();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class b implements IphonePickerView.PickerViewAdapter {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocationSelectActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter
        public int getColumnCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return LocationSelectActivity.this.f201969q0;
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter
        public int getRowCount(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, i3)).intValue();
            }
            Object obj = LocationSelectActivity.this.f201965m0[i3];
            if (obj != null) {
                return ((List) obj).size();
            }
            return 0;
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter
        public String getText(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
            }
            try {
                Object obj = LocationSelectActivity.this.f201965m0[i3];
                if (obj != null) {
                    if (((BaseAddress) ((List) obj).get(i16)).code.equals("0")) {
                        return ProvinceSelectorView.NAME_NO_SELECT_PROFILE;
                    }
                    return ((BaseAddress) ((List) LocationSelectActivity.this.f201965m0[i3]).get(i16)).name;
                }
            } catch (IndexOutOfBoundsException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("LocationSelectActivity", 2, "", e16);
                }
            }
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c implements LocationSelectorView.f {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocationSelectActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.selectorview.LocationSelectorView.f
        public void onGetUserLocation(boolean z16, String[] strArr, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), strArr, Boolean.valueOf(z17));
                return;
            }
            if (!z16 || strArr == null) {
                LocationSelectActivity.this.b3();
                return;
            }
            if (strArr.length >= 1) {
                LocationSelectActivity.this.doOnActivityResult(1000, -1, new Intent().putExtra("key_country_code", strArr[0]));
            }
            LocationSelectActivity.this.b3();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class d implements QActionSheet.f {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.widget.selectorview.ProvinceSelectorView f201983d;

        d(com.tencent.mobileqq.widget.selectorview.ProvinceSelectorView provinceSelectorView) {
            this.f201983d = provinceSelectorView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocationSelectActivity.this, (Object) provinceSelectorView);
            }
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onConfirm() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            String[] t16 = this.f201983d.t();
            if (t16 != null && t16.length > 0) {
                t16[0] = LocationSelectActivity.this.f201961i0.code;
            }
            LocationSelectActivity.this.f201954b0 = true;
            LocationSelectActivity.this.c3(true, t16);
            LocationSelectActivity.this.b3();
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                LocationSelectActivity.this.b3();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void t() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class e implements IphonePickerView.IphonePickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocationSelectActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener
        public void onConfirmBtClicked() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                LocationSelectActivity.this.f201958f0.setRightTextColor(2);
                LocationSelectActivity.this.f201972t0.dismiss();
            }
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener
        public void onItemSelected(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            LocationSelectActivity locationSelectActivity = LocationSelectActivity.this;
            IphonePickerView iphonePickerView = locationSelectActivity.f201973u0;
            if (iphonePickerView == null) {
                return;
            }
            ArrayList arrayList = null;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        if (Collections.emptyList().equals(LocationSelectActivity.this.f201965m0[2])) {
                            if (QLog.isColorLevel()) {
                                QLog.d("LocationSelectActivity", 2, "columnListArray at 2 is empty");
                            }
                        } else {
                            arrayList = (ArrayList) LocationSelectActivity.this.f201965m0[2];
                        }
                        if (arrayList != null && i16 < arrayList.size() && i16 >= 0) {
                            LocationSelectActivity.this.f201966n0[2] = (BaseAddress) arrayList.get(i16);
                            LocationSelectActivity.this.f201967o0[2] = i16;
                        }
                    }
                } else {
                    locationSelectActivity.f201967o0[1] = i16;
                    iphonePickerView.setPickListener(null);
                    try {
                        LocationSelectActivity locationSelectActivity2 = LocationSelectActivity.this;
                        locationSelectActivity2.f201966n0[1] = (BaseAddress) ((ArrayList) locationSelectActivity2.f201965m0[1]).get(i16);
                    } catch (Exception unused) {
                        LocationSelectActivity.this.f201966n0[1] = new BaseAddress(IProfileCardConst.NAME_NO_LIMIT, "0", 2);
                    }
                    ArrayList<BaseAddress> dataList = LocationSelectActivity.this.f201966n0[1].getDataList();
                    if (dataList.size() > 0) {
                        LocationSelectActivity locationSelectActivity3 = LocationSelectActivity.this;
                        locationSelectActivity3.f201965m0[2] = dataList;
                        locationSelectActivity3.f201966n0[2] = dataList.get(0);
                        LocationSelectActivity.this.f201967o0[2] = 0;
                    } else {
                        LocationSelectActivity locationSelectActivity4 = LocationSelectActivity.this;
                        if (locationSelectActivity4.f201969q0 > 2) {
                            locationSelectActivity4.f201966n0[2] = new AddressData.NO_LIMIT_ADDRESS(3);
                            LocationSelectActivity locationSelectActivity5 = LocationSelectActivity.this;
                            locationSelectActivity5.f201965m0[2] = null;
                            locationSelectActivity5.f201967o0[2] = 0;
                        }
                    }
                    LocationSelectActivity locationSelectActivity6 = LocationSelectActivity.this;
                    if (locationSelectActivity6.f201969q0 > 2) {
                        locationSelectActivity6.f201973u0.notifyDataSetChange(2);
                        LocationSelectActivity locationSelectActivity7 = LocationSelectActivity.this;
                        locationSelectActivity7.f201973u0.setSelection(2, locationSelectActivity7.f201967o0[2]);
                    }
                    LocationSelectActivity.this.f201973u0.setPickListener(this);
                }
            } else {
                iphonePickerView.setPickListener(null);
                LocationSelectActivity locationSelectActivity8 = LocationSelectActivity.this;
                locationSelectActivity8.f201967o0[0] = i16;
                locationSelectActivity8.f201966n0[0] = (BaseAddress) ((ArrayList) locationSelectActivity8.f201965m0[0]).get(i16);
                ArrayList<BaseAddress> dataList2 = LocationSelectActivity.this.f201966n0[0].getDataList();
                if (dataList2.size() > 0) {
                    LocationSelectActivity locationSelectActivity9 = LocationSelectActivity.this;
                    locationSelectActivity9.f201965m0[1] = dataList2;
                    locationSelectActivity9.f201966n0[1] = dataList2.get(0);
                    LocationSelectActivity locationSelectActivity10 = LocationSelectActivity.this;
                    locationSelectActivity10.f201967o0[1] = 0;
                    ArrayList<BaseAddress> dataList3 = locationSelectActivity10.f201966n0[1].getDataList();
                    if (dataList3.size() > 0) {
                        LocationSelectActivity locationSelectActivity11 = LocationSelectActivity.this;
                        locationSelectActivity11.f201965m0[2] = dataList3;
                        locationSelectActivity11.f201966n0[2] = dataList3.get(0);
                        LocationSelectActivity.this.f201967o0[2] = 0;
                    } else {
                        LocationSelectActivity locationSelectActivity12 = LocationSelectActivity.this;
                        if (locationSelectActivity12.f201969q0 == 3) {
                            locationSelectActivity12.f201966n0[2] = new AddressData.NO_LIMIT_ADDRESS(3);
                            LocationSelectActivity locationSelectActivity13 = LocationSelectActivity.this;
                            locationSelectActivity13.f201965m0[2] = null;
                            locationSelectActivity13.f201967o0[2] = 0;
                        }
                    }
                } else {
                    LocationSelectActivity locationSelectActivity14 = LocationSelectActivity.this;
                    if (locationSelectActivity14.f201969q0 > 1) {
                        locationSelectActivity14.f201966n0[1] = new AddressData.NO_LIMIT_ADDRESS(2);
                        LocationSelectActivity locationSelectActivity15 = LocationSelectActivity.this;
                        locationSelectActivity15.f201965m0[1] = null;
                        locationSelectActivity15.f201967o0[1] = 0;
                        if (locationSelectActivity15.f201969q0 == 3) {
                            locationSelectActivity15.f201966n0[2] = new AddressData.NO_LIMIT_ADDRESS(3);
                            LocationSelectActivity locationSelectActivity16 = LocationSelectActivity.this;
                            locationSelectActivity16.f201965m0[2] = null;
                            locationSelectActivity16.f201967o0[2] = 0;
                        }
                    }
                }
                LocationSelectActivity locationSelectActivity17 = LocationSelectActivity.this;
                if (locationSelectActivity17.f201969q0 > 1) {
                    locationSelectActivity17.f201973u0.notifyDataSetChange(1);
                    LocationSelectActivity locationSelectActivity18 = LocationSelectActivity.this;
                    locationSelectActivity18.f201973u0.setSelection(1, locationSelectActivity18.f201967o0[1]);
                    LocationSelectActivity locationSelectActivity19 = LocationSelectActivity.this;
                    if (locationSelectActivity19.f201969q0 == 3) {
                        locationSelectActivity19.f201973u0.notifyDataSetChange(2);
                        LocationSelectActivity locationSelectActivity20 = LocationSelectActivity.this;
                        locationSelectActivity20.f201973u0.setSelection(2, locationSelectActivity20.f201967o0[2]);
                    }
                }
                LocationSelectActivity.this.f201973u0.setPickListener(this);
            }
            LocationSelectActivity locationSelectActivity21 = LocationSelectActivity.this;
            locationSelectActivity21.p3(locationSelectActivity21.f201958f0, LocationSelectActivity.this.Y2());
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class f extends Handler {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocationSelectActivity.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            } else if (message.what == 1000) {
                LocationSelectActivity.this.c3(((Boolean) ((Object[]) message.obj)[0]).booleanValue(), (String[]) ((Object[]) message.obj)[1]);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class g extends bh {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocationSelectActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.bh
        public void onGetUserLocation(boolean z16, LBSInfo lBSInfo) {
            String[] strArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), lBSInfo);
                return;
            }
            if (lBSInfo != null) {
                strArr = lBSInfo.a();
            } else {
                strArr = null;
            }
            if (Math.abs(System.currentTimeMillis() - LocationSelectActivity.this.f201975w0) > 1200) {
                LocationSelectActivity.this.c3(z16, strArr);
                return;
            }
            Message obtainMessage = LocationSelectActivity.this.f201977y0.obtainMessage(1000);
            obtainMessage.obj = new Object[]{Boolean.valueOf(z16), strArr};
            LocationSelectActivity.this.f201977y0.sendMessageDelayed(obtainMessage, 1200L);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class h implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocationSelectActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                return;
            }
            LocationSelectActivity.this.f201958f0.setRightTextColor(2);
            if (AppSetting.f99565y) {
                LocationSelectActivity.this.f201957e0.setContentDescription(HardCodeUtil.qqStr(R.string.ntp) + LocationSelectActivity.this.f201961i0.name);
                LocationSelectActivity.this.f201958f0.setContentDescription(HardCodeUtil.qqStr(R.string.ntn) + ((Object) LocationSelectActivity.this.f201958f0.d().getText()));
            }
            String[] e36 = LocationSelectActivity.this.e3();
            if (LocationSelectActivity.this.f201959g0 == 0) {
                ReportController.o(LocationSelectActivity.this.app, "CliOper", "", "", "0X8004248", "0X8004248", 0, 0, e36[0], e36[1], e36[2], "");
            } else {
                ReportController.o(LocationSelectActivity.this.app, "CliOper", "", "", "0X800424A", "0X800424A", 0, 0, e36[0], e36[1], e36[2], "");
            }
        }
    }

    public LocationSelectActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f201969q0 = 0;
        this.f201970r0 = "1";
        this.f201971s0 = new b();
        this.f201974v0 = new e();
        this.f201975w0 = 0L;
        this.f201976x0 = 1000;
        this.f201977y0 = new f();
        this.f201978z0 = new g();
        this.A0 = new h();
    }

    private void W2() {
        RelativeLayout relativeLayout;
        if (isInMultiWindow() && (relativeLayout = this.titleRoot) != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) relativeLayout.getLayoutParams();
            marginLayoutParams.setMargins(0, 0, 0, 0);
            this.titleRoot.setLayoutParams(marginLayoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Y2() {
        BaseAddress baseAddress;
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < this.f201969q0; i3++) {
            BaseAddress[] baseAddressArr = this.f201966n0;
            if (baseAddressArr != null && (baseAddress = baseAddressArr[i3]) != null && !"0".equals(baseAddress.code)) {
                sb5.append(this.f201966n0[i3].name);
                sb5.append("-");
            }
        }
        String sb6 = sb5.toString();
        if (TextUtils.isEmpty(sb6)) {
            return IProfileCardConst.NAME_NO_LIMIT;
        }
        return sb6.substring(0, sb6.length() - 1);
    }

    private String Z2() {
        String Y2 = Y2();
        if (!IProfileCardConst.NAME_NO_LIMIT.equals(Y2)) {
            return Y2;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b3() {
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.conditionsearch.LocationSelectActivity.10
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocationSelectActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else if (LocationSelectActivity.this.f201953a0 != null) {
                    LocationSelectActivity.this.f201953a0.dismiss();
                }
            }
        }, 200L);
    }

    private int d3(ArrayList<? extends BaseAddress> arrayList, String str) {
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (arrayList.get(i3).code.equals(str)) {
                return i3;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String[] e3() {
        String[] strArr = {"0", "0", "0"};
        BaseAddress[] baseAddressArr = this.f201966n0;
        if (baseAddressArr != null) {
            for (BaseAddress baseAddress : baseAddressArr) {
                if (baseAddress == null) {
                    break;
                }
                strArr[baseAddress.addressType - 1] = String.valueOf(ConditionSearchManager.p(baseAddress.code));
            }
        }
        return strArr;
    }

    private void f3() {
        String[] stringArrayExtra = getIntent().getStringArrayExtra(IProfileCardConst.PARAM_LOCATION_CODE);
        if (stringArrayExtra != null) {
            j3();
            if (this.f201959g0 == 0 && this.f201955c0.F() && stringArrayExtra[0].equals("0")) {
                return;
            }
            this.f201970r0 = stringArrayExtra[0];
            int length = stringArrayExtra.length;
            for (int i3 = 1; i3 < length; i3++) {
                this.f201968p0[i3 - 1] = stringArrayExtra[i3];
            }
        }
    }

    private void g3() {
        if (!u.a().b() && this.f201964l0 != null) {
            com.tencent.mobileqq.widget.selectorview.c cVar = new com.tencent.mobileqq.widget.selectorview.c(this, this.f201970r0, QQTheme.isNowThemeIsNight(), this.f201964l0, false);
            cVar.p0(new c());
            r3();
            cVar.show();
        }
    }

    private void h3() {
        if (u.a().b()) {
            return;
        }
        String[] strArr = this.f201968p0;
        if (strArr == null) {
            strArr = new String[]{"0", "0", "0"};
        }
        this.f201968p0 = strArr;
        com.tencent.mobileqq.widget.selectorview.ProvinceSelectorView provinceSelectorView = new com.tencent.mobileqq.widget.selectorview.ProvinceSelectorView(this, QQTheme.isNowThemeIsNight());
        provinceSelectorView.k(HardCodeUtil.qqStr(R.string.f2040451u));
        BaseAddress baseAddress = this.f201961i0;
        provinceSelectorView.v(baseAddress.code, this.f201968p0, baseAddress);
        if (provinceSelectorView.e() == null) {
            provinceSelectorView.i(new d(provinceSelectorView));
        }
        try {
            this.f201954b0 = false;
            r3();
            provinceSelectorView.m();
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("LocationSelectActivity", 2, th5.getMessage());
            }
            this.f201954b0 = true;
            b3();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void i3() {
        if (!NetworkUtil.isNetSupport(this)) {
            QQToast.makeText(this, R.string.f171139ci4, 0).show(getTitleBarHeight());
            return;
        }
        this.f201975w0 = System.currentTimeMillis();
        addObserver(this.f201978z0);
        ((LBSHandler) this.app.getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER)).J2();
        this.f201956d0.setLeftTextColor(2);
        Drawable drawable = getResources().getDrawable(R.drawable.common_loading6);
        this.f201956d0.setRightIcon(drawable);
        ((Animatable) drawable).start();
        this.f201956d0.setEnabled(false);
    }

    private void initData() {
        this.f201961i0 = this.f201955c0.w(this.f201970r0);
        this.f201964l0 = this.f201955c0.x();
        BaseAddress baseAddress = this.f201961i0;
        if (baseAddress != null && baseAddress != null) {
            int columnNember = baseAddress.getColumnNember();
            this.f201969q0 = columnNember;
            FormSimpleItem formSimpleItem = this.f201958f0;
            if (formSimpleItem != null) {
                if (columnNember == 0) {
                    n3(formSimpleItem, false);
                    return;
                }
                n3(formSimpleItem, true);
            }
            int i3 = this.f201969q0;
            this.f201965m0 = new Object[i3];
            this.f201966n0 = new BaseAddress[i3];
            this.f201967o0 = new int[i3];
            if (i3 == 0) {
                return;
            }
            BaseAddress baseAddress2 = this.f201961i0;
            int length = this.f201968p0.length;
            int i16 = 0;
            for (int i17 = 0; i17 < length; i17++) {
                if (!"0".equals(this.f201968p0[i17])) {
                    this.f201965m0[i16] = baseAddress2.getDataList();
                    BaseAddress[] baseAddressArr = this.f201966n0;
                    baseAddress2 = baseAddress2.dataMap.get(this.f201968p0[i17]);
                    baseAddressArr[i16] = baseAddress2;
                    this.f201967o0[i16] = d3((ArrayList) this.f201965m0[i16], this.f201968p0[i17]);
                    i16++;
                    if (baseAddress2 == null) {
                        return;
                    }
                }
            }
            if (i16 == 0) {
                this.f201965m0[i16] = baseAddress2.getDataList();
                this.f201966n0[i16] = baseAddress2.dataMap.get(0);
                return;
            }
            try {
                if (i16 < this.f201969q0) {
                    this.f201965m0[i16] = baseAddress2.getDataList();
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("LocationSelectActivity", 2, "", e16);
                }
            }
        }
    }

    private void initView() {
        String str;
        boolean booleanExtra = getIntent().getBooleanExtra("param_is_popup", true);
        this.f201960h0 = booleanExtra;
        if (booleanExtra) {
            setRightHighlightButton(R.string.b9f, new a());
            enableRightHighlight(true);
            this.leftView.setVisibility(8);
        } else {
            setLeftViewName(R.string.f170549u3);
        }
        Drawable drawable = getResources().getDrawable(R.drawable.qui_common_fill_light_primary_bg);
        FormSimpleItem formSimpleItem = (FormSimpleItem) findViewById(R.id.b78);
        this.f201956d0 = formSimpleItem;
        formSimpleItem.setBackgroundDrawable(drawable);
        FormSimpleItem formSimpleItem2 = (FormSimpleItem) findViewById(R.id.b77);
        this.f201957e0 = formSimpleItem2;
        formSimpleItem2.setBackgroundDrawable(drawable);
        FormSimpleItem formSimpleItem3 = (FormSimpleItem) findViewById(R.id.b79);
        this.f201958f0 = formSimpleItem3;
        formSimpleItem3.setBackgroundDrawable(drawable);
        int i3 = this.f201959g0;
        if (i3 != 0 && i3 != 2) {
            setTitle(R.string.a87);
            this.f201956d0.setVisibility(8);
            findViewById(R.id.f165049uq1).setVisibility(8);
        } else {
            setTitle(R.string.a89);
            this.f201956d0.setLeftIcon(null);
            this.f201956d0.setLeftText(getResources().getString(R.string.a8e));
            this.f201956d0.setLeftTextColor(1);
            this.f201956d0.h(false);
            this.f201956d0.setOnClickListener(this);
            if (AppSetting.f99565y) {
                this.f201956d0.setContentDescription(HardCodeUtil.qqStr(R.string.ntu));
            }
        }
        String stringExtra = getIntent().getStringExtra(ISelectMemberActivityConstants.PARAM_TITLE);
        if (!TextUtils.isEmpty(stringExtra)) {
            setTitle(stringExtra);
        }
        this.f201957e0.setLeftIcon(null);
        this.f201957e0.setLeftText(getResources().getString(R.string.a86));
        BaseAddress baseAddress = this.f201961i0;
        if (baseAddress != null) {
            if (baseAddress != null) {
                str = baseAddress.name;
            } else {
                str = HardCodeUtil.qqStr(R.string.ntw);
            }
        } else {
            str = null;
        }
        p3(this.f201957e0, str);
        this.f201957e0.setOnClickListener(this);
        if (AppSetting.f99565y) {
            this.f201957e0.setContentDescription(HardCodeUtil.qqStr(R.string.nts) + str);
        }
        this.f201958f0.setLeftIcon(null);
        this.f201958f0.setLeftText(getResources().getString(R.string.a8_));
        this.f201958f0.setOnClickListener(this);
        if (this.f201969q0 == 0) {
            n3(this.f201958f0, false);
            return;
        }
        n3(this.f201958f0, true);
        String stringExtra2 = getIntent().getStringExtra("param_location_param");
        this.f201962j0 = stringExtra2;
        String[] f06 = this.f201955c0.f0(stringExtra2);
        BaseAddress baseAddress2 = this.f201961i0;
        if (baseAddress2 != null && f06[0].equals(baseAddress2.name)) {
            this.f201962j0 = f06[1];
        }
        p3(this.f201958f0, this.f201962j0);
        if (AppSetting.f99565y) {
            this.f201958f0.setContentDescription(HardCodeUtil.qqStr(R.string.ntq) + ((Object) this.f201958f0.d().getText()));
        }
    }

    private void j3() {
        this.f201968p0 = new String[]{"0", "0", "0"};
        this.f201966n0 = null;
    }

    private void l3(String[] strArr) {
        String[] N;
        Intent intent = new Intent("action_get_lbs_location");
        intent.putExtra("code", strArr);
        ConditionSearchManager conditionSearchManager = this.f201955c0;
        if (conditionSearchManager != null && (N = conditionSearchManager.N(strArr)) != null) {
            intent.putExtra("location", N);
        }
        if (getIntent() != null && getIntent().hasExtra("select_location_broadcast_callback")) {
            intent.putExtra("select_location_broadcast_callback", getIntent().getIntExtra("select_location_broadcast_callback", 0));
        }
        sendBroadcast(intent);
    }

    private void n3(FormSimpleItem formSimpleItem, boolean z16) {
        if (formSimpleItem != null) {
            this.f201958f0.setEnabled(z16);
        }
        if (!z16 && AppSetting.f99565y) {
            this.f201958f0.setContentDescription(HardCodeUtil.qqStr(R.string.nty));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p3(FormSimpleItem formSimpleItem, String str) {
        if (!TextUtils.isEmpty(str) && str.equals(IProfileCardConst.NAME_NO_LIMIT)) {
            str = "";
        }
        formSimpleItem.setRightText(str);
    }

    private void r3() {
        if (this.f201953a0 == null) {
            this.f201953a0 = new h.b(this);
        }
        this.f201953a0.show();
    }

    void c3(boolean z16, String[] strArr) {
        String Y2;
        this.f201956d0.setLeftTextColor(1);
        BaseAddress baseAddress = null;
        this.f201956d0.setRightIcon(null);
        this.f201956d0.setEnabled(true);
        int i3 = 0;
        if (z16 && strArr != null && strArr.length == 4) {
            if (this.f201954b0) {
                if (!TextUtils.isEmpty(strArr[0])) {
                    baseAddress = this.f201955c0.w(strArr[0]);
                }
                if (baseAddress != null) {
                    this.f201970r0 = strArr[0];
                    j3();
                    int length = strArr.length;
                    for (int i16 = 1; i16 < length; i16++) {
                        if (!TextUtils.isEmpty(strArr[i16])) {
                            this.f201968p0[i3] = strArr[i16];
                            i3++;
                        }
                    }
                    initData();
                    p3(this.f201957e0, this.f201961i0.name);
                    this.f201957e0.setContentDescription(HardCodeUtil.qqStr(R.string.ntt) + this.f201961i0.name);
                    if (this.f201969q0 == 0) {
                        Y2 = "";
                    } else {
                        Y2 = Y2();
                    }
                    p3(this.f201958f0, Y2);
                    this.f201958f0.setContentDescription(HardCodeUtil.qqStr(R.string.ntv) + Y2);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("LocationSelectActivity", 2, "invalid country code!! | cournty code is :" + strArr[0]);
                    return;
                }
                return;
            }
            return;
        }
        QQToast.makeText(this, R.string.f170776a83, 0).show(getTitleBarHeight());
    }

    @Override // com.tencent.mobileqq.activity.LbsBaseActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i3 == 1000 && i16 == -1) {
            String stringExtra = intent.getStringExtra("key_country_code");
            if (!TextUtils.isEmpty(stringExtra) && !stringExtra.equals(this.f201970r0)) {
                if (this.f201955c0.w(stringExtra) == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("LocationSelectActivity", 2, "doOnActivityResult | should not be here, can not get country by code ! result code = " + stringExtra);
                        return;
                    }
                    return;
                }
                this.f201970r0 = stringExtra;
                j3();
                initData();
                p3(this.f201957e0, this.f201961i0.name);
                if (AppSetting.f99565y) {
                    this.f201957e0.setContentDescription(HardCodeUtil.qqStr(R.string.ntx) + this.f201961i0.name);
                    this.f201958f0.setContentDescription(HardCodeUtil.qqStr(R.string.ntr) + ((Object) this.f201958f0.d().getText()));
                }
                if (this.f201959g0 == 0) {
                    ReportController.o(this.app, "CliOper", "", "", "0X8004247", "0X8004247", 0, 0, ConditionSearchManager.p(this.f201970r0) + "", "", "", "");
                    return;
                }
                ReportController.o(this.app, "CliOper", "", "", "0X8004249", "0X8004249", 0, 0, ConditionSearchManager.p(this.f201970r0) + "", "", "", "");
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.LbsBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    protected boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        this.f201959g0 = getIntent().getIntExtra(QZoneCheckSendGiftServlet.PARAM_REQ_TYPE, 0);
        Intent intent = getIntent();
        if (intent != null) {
            this.f201959g0 = intent.getIntExtra(QZoneCheckSendGiftServlet.PARAM_REQ_TYPE, 0);
            this.f201963k0 = intent.getIntExtra("source_from", 0);
        }
        setContentView(R.layout.aw7);
        this.f201955c0 = (ConditionSearchManager) this.app.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER);
        f3();
        initData();
        initView();
        W2();
        return true;
    }

    @Override // com.tencent.mobileqq.activity.LbsBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    protected void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            removeObserver(this.f201978z0);
            super.doOnDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            super.doOnResume();
        }
    }

    @Override // com.tencent.mobileqq.activity.LbsBaseActivity
    protected int getContentTipsForEnableLbs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return R.string.f170772a80;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        Intent intent = new Intent();
        String[] strArr = new String[4];
        strArr[0] = this.f201970r0;
        strArr[1] = "0";
        strArr[2] = "0";
        strArr[3] = "0";
        BaseAddress[] baseAddressArr = this.f201966n0;
        if (baseAddressArr != null) {
            int length = baseAddressArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                BaseAddress baseAddress = this.f201966n0[i3];
                if (baseAddress == null) {
                    break;
                }
                strArr[baseAddress.addressType] = baseAddress.code;
            }
        }
        intent.putExtra(IProfileCardConst.PARAM_LOCATION_CODE, strArr);
        String Z2 = Z2();
        if (this.f201961i0 != null) {
            if (TextUtils.isEmpty(Z2)) {
                str2 = this.f201961i0.name;
            } else {
                str2 = this.f201961i0.name + "-" + Y2();
            }
            intent.putExtra("param_location_param", str2);
        } else {
            int i16 = this.f201959g0;
            if (i16 != 2 && i16 != 3) {
                str = IProfileCardConst.NAME_NO_LIMIT;
            } else {
                str = "";
            }
            intent.putExtra("param_location_param", str);
        }
        l3(strArr);
        setResult(-1, intent);
        finish();
        if (this.f201960h0) {
            overridePendingTransition(0, R.anim.f154423k);
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.b78) {
                ReportController.o(this.app, "CliOper", "", "", "0X8004246", "0X8004246", 0, 0, "", "", "", "");
                this.f201954b0 = true;
                checkAndEnableLbs(new Runnable() { // from class: com.tencent.mobileqq.conditionsearch.LocationSelectActivity.2
                    static IPatchRedirector $redirector_;

                    /* compiled from: P */
                    /* renamed from: com.tencent.mobileqq.conditionsearch.LocationSelectActivity$2$a */
                    /* loaded from: classes5.dex */
                    class a extends QQPermission.BasePermissionsListener {
                        static IPatchRedirector $redirector_;

                        a() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                            }
                        }

                        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
                        public void onAllGranted() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                            } else {
                                super.onAllGranted();
                                LocationSelectActivity.this.i3();
                            }
                        }
                    }

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LocationSelectActivity.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            QQPermissionFactory.getQQPermission(LocationSelectActivity.this, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_BUSINESS_CARD, QQPermissionConstants.Business.SCENE.BUSINESS_CARD_GET_LOCATION)).requestPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, 2, new a());
                        }
                    }
                });
            } else if (id5 == R.id.b77) {
                g3();
            } else if (id5 == R.id.b79) {
                h3();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.activity.LbsBaseActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.activity.LbsBaseActivity
    protected void onLBSForbidden() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }
}
