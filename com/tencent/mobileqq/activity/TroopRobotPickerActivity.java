package com.tencent.mobileqq.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.ark.ark;
import com.tencent.common.config.AppSetting;
import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.conditionsearch.CountrySelectActivity;
import com.tencent.mobileqq.conditionsearch.data.AddressData;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.profilecard.widget.CountrySelect.CountrySelectView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.selectorview.model.BaseAddress;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.widget.ActionSheet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes9.dex */
public class TroopRobotPickerActivity extends BaseActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: j0, reason: collision with root package name */
    public static String f177398j0;

    /* renamed from: k0, reason: collision with root package name */
    static final String[] f177399k0;

    /* renamed from: a0, reason: collision with root package name */
    ConditionSearchManager f177400a0;

    /* renamed from: b0, reason: collision with root package name */
    TextView f177401b0;

    /* renamed from: c0, reason: collision with root package name */
    ActionSheet f177402c0;

    /* renamed from: d0, reason: collision with root package name */
    IphonePickerView f177403d0;

    /* renamed from: e0, reason: collision with root package name */
    RobotPickerData f177404e0;

    /* renamed from: f0, reason: collision with root package name */
    JSONObject f177405f0;

    /* renamed from: g0, reason: collision with root package name */
    JSONObject f177406g0;

    /* renamed from: h0, reason: collision with root package name */
    String f177407h0;

    /* renamed from: i0, reason: collision with root package name */
    ProgressDialog f177408i0;

    /* loaded from: classes9.dex */
    public static class RobotPickerData implements Serializable {
        static IPatchRedirector $redirector_ = null;
        public static final int REQ_ROBOT_PICKER = 111;
        static final int TYPE_AGE_PICKER = 2;
        static final int TYPE_LOCATION_PICKER = 3;
        static final int TYPE_SEX_PICKER = 1;
        public int mAgeSelectIndex1;
        public int mAgeSelectIndex2;
        public int mCurAgeIndex1;
        public int mCurAgeIndex2;
        public BaseAddress[] mLocationArray;
        public String[] mLocationCodeArray;
        public int mLocationColumCount;
        public BaseAddress mLocationCountry;
        public String mLocationCountyCode;
        public int[] mLocationIndexArray;
        public Object[] mLocationListArray;
        public int mSexIndex;
        public int pickerType;

        public RobotPickerData() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.pickerType = -1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopRobotPickerActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                Intent intent = new Intent(TroopRobotPickerActivity.this, (Class<?>) CountrySelectActivity.class);
                intent.putExtra("key_country_code", TroopRobotPickerActivity.this.f177404e0.mLocationCountyCode);
                intent.putExtra("key_no_limit_allow", true);
                TroopRobotPickerActivity.this.startActivityForResult(intent, 111);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes9.dex */
    class b implements ConditionSearchManager.c {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopRobotPickerActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ConditionSearchManager.c
        public void onGetConfig(int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                TroopRobotPickerActivity.this.J2();
                TroopRobotPickerActivity.this.f177408i0.dismiss();
            } else {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class c implements IphonePickerView.IphonePickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public RobotPickerData f177411a;

        /* renamed from: b, reason: collision with root package name */
        IphonePickerView f177412b;

        /* renamed from: c, reason: collision with root package name */
        ActionSheet f177413c;

        c(RobotPickerData robotPickerData, IphonePickerView iphonePickerView, ActionSheet actionSheet) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopRobotPickerActivity.this, robotPickerData, iphonePickerView, actionSheet);
                return;
            }
            this.f177411a = robotPickerData;
            this.f177412b = iphonePickerView;
            this.f177413c = actionSheet;
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener
        public void onConfirmBtClicked() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            RobotPickerData robotPickerData = this.f177411a;
            if (robotPickerData.pickerType == 2) {
                int i3 = robotPickerData.mCurAgeIndex1;
                int i16 = robotPickerData.mCurAgeIndex2;
                if (i3 > i16 && i16 != 0) {
                    TroopRobotPickerActivity troopRobotPickerActivity = TroopRobotPickerActivity.this;
                    QQToast.makeText(troopRobotPickerActivity, troopRobotPickerActivity.getResources().getString(R.string.a7z), 0).show();
                    return;
                }
            }
            ActionSheet actionSheet = this.f177413c;
            if (actionSheet != null && actionSheet.isShowing()) {
                this.f177413c.dismiss();
            }
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener
        public void onItemSelected(int i3, int i16) {
            Object obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (this.f177411a == null) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TroopRobotPickerActivity.f177398j0, 2, "onItemSelected|pickerType : " + this.f177411a.pickerType + ", column : " + i3 + ", row : " + i16);
            }
            RobotPickerData robotPickerData = this.f177411a;
            int i17 = robotPickerData.pickerType;
            if (i17 == 2) {
                if (i16 < 0 || i16 >= ConditionSearchManager.f194486n0.length) {
                    i16 = 0;
                }
                if (i3 != 0) {
                    if (i3 == 1) {
                        robotPickerData.mCurAgeIndex2 = i16;
                    }
                } else {
                    robotPickerData.mCurAgeIndex1 = i16;
                }
                int i18 = robotPickerData.mCurAgeIndex1;
                int i19 = robotPickerData.mCurAgeIndex2;
                if (i18 <= i19 || i19 == 0) {
                    robotPickerData.mAgeSelectIndex1 = i18;
                    robotPickerData.mAgeSelectIndex2 = i19;
                    return;
                }
                return;
            }
            if (i17 == 1) {
                if (i16 < 0 || i16 >= ConditionSearchManager.f194487o0.length) {
                    i16 = 0;
                }
                robotPickerData.mSexIndex = i16;
                return;
            }
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2 && (obj = robotPickerData.mLocationListArray[2]) != null && ((List) obj).size() > 0) {
                        if (i16 < 0 || i16 >= ((List) this.f177411a.mLocationListArray[2]).size()) {
                            i16 = 0;
                        }
                        RobotPickerData robotPickerData2 = this.f177411a;
                        robotPickerData2.mLocationIndexArray[2] = i16;
                        robotPickerData2.mLocationArray[2] = (BaseAddress) ((List) robotPickerData2.mLocationListArray[2]).get(i16);
                        RobotPickerData robotPickerData3 = this.f177411a;
                        robotPickerData3.mLocationCodeArray[2] = robotPickerData3.mLocationArray[2].code;
                        return;
                    }
                    return;
                }
                Object obj2 = robotPickerData.mLocationListArray[1];
                if (obj2 != null && ((List) obj2).size() > 0) {
                    if (i16 < 0 || i16 >= ((List) this.f177411a.mLocationListArray[1]).size()) {
                        i16 = 0;
                    }
                    RobotPickerData robotPickerData4 = this.f177411a;
                    robotPickerData4.mLocationIndexArray[1] = i16;
                    robotPickerData4.mLocationArray[1] = (BaseAddress) ((List) robotPickerData4.mLocationListArray[1]).get(i16);
                    RobotPickerData robotPickerData5 = this.f177411a;
                    String[] strArr = robotPickerData5.mLocationCodeArray;
                    BaseAddress[] baseAddressArr = robotPickerData5.mLocationArray;
                    strArr[1] = baseAddressArr[1].code;
                    ArrayList<BaseAddress> dataList = baseAddressArr[1].getDataList();
                    RobotPickerData robotPickerData6 = this.f177411a;
                    if (robotPickerData6.mLocationColumCount > 2) {
                        robotPickerData6.mLocationListArray[2] = dataList;
                        robotPickerData6.mLocationIndexArray[2] = 0;
                        robotPickerData6.mLocationArray[2] = new AddressData.NO_LIMIT_ADDRESS(2);
                        this.f177411a.mLocationCodeArray[2] = "0";
                        try {
                            this.f177412b.notifyDataSetChange(2);
                            this.f177412b.setSelection(2, 0);
                            return;
                        } catch (Exception e16) {
                            if (QLog.isColorLevel()) {
                                QLog.d(TroopRobotPickerActivity.f177398j0, 2, e16, new Object[0]);
                            }
                            ActionSheet actionSheet = this.f177413c;
                            if (actionSheet != null && actionSheet.isShowing()) {
                                this.f177413c.dismiss();
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            Object obj3 = robotPickerData.mLocationListArray[0];
            if (obj3 != null && ((List) obj3).size() > 0) {
                if (i16 < 0 || i16 >= ((List) this.f177411a.mLocationListArray[0]).size()) {
                    i16 = 0;
                }
                RobotPickerData robotPickerData7 = this.f177411a;
                robotPickerData7.mLocationIndexArray[0] = i16;
                robotPickerData7.mLocationArray[0] = (BaseAddress) ((List) robotPickerData7.mLocationListArray[0]).get(i16);
                RobotPickerData robotPickerData8 = this.f177411a;
                String[] strArr2 = robotPickerData8.mLocationCodeArray;
                BaseAddress[] baseAddressArr2 = robotPickerData8.mLocationArray;
                strArr2[0] = baseAddressArr2[0].code;
                ArrayList<BaseAddress> dataList2 = baseAddressArr2[0].getDataList();
                RobotPickerData robotPickerData9 = this.f177411a;
                if (robotPickerData9.mLocationColumCount > 1) {
                    robotPickerData9.mLocationListArray[1] = dataList2;
                    robotPickerData9.mLocationIndexArray[1] = 0;
                    robotPickerData9.mLocationArray[1] = new AddressData.NO_LIMIT_ADDRESS(2);
                    this.f177411a.mLocationCodeArray[1] = "0";
                    try {
                        this.f177412b.notifyDataSetChange(1);
                        this.f177412b.setSelection(1, 0);
                    } catch (Exception e17) {
                        if (QLog.isColorLevel()) {
                            QLog.d(TroopRobotPickerActivity.f177398j0, 2, e17, new Object[0]);
                        }
                        ActionSheet actionSheet2 = this.f177413c;
                        if (actionSheet2 != null && actionSheet2.isShowing()) {
                            this.f177413c.dismiss();
                        }
                    }
                    RobotPickerData robotPickerData10 = this.f177411a;
                    if (robotPickerData10.mLocationColumCount > 2) {
                        robotPickerData10.mLocationListArray[2] = null;
                        robotPickerData10.mLocationIndexArray[2] = 0;
                        robotPickerData10.mLocationArray[2] = new AddressData.NO_LIMIT_ADDRESS(2);
                        this.f177411a.mLocationCodeArray[2] = "0";
                        try {
                            this.f177412b.notifyDataSetChange(2);
                            this.f177412b.setSelection(2, 0);
                        } catch (Exception e18) {
                            if (QLog.isColorLevel()) {
                                QLog.d(TroopRobotPickerActivity.f177398j0, 2, e18, new Object[0]);
                            }
                            ActionSheet actionSheet3 = this.f177413c;
                            if (actionSheet3 != null && actionSheet3.isShowing()) {
                                this.f177413c.dismiss();
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class d implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        RobotPickerData f177415d;

        d(RobotPickerData robotPickerData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopRobotPickerActivity.this, (Object) robotPickerData);
            } else {
                this.f177415d = robotPickerData;
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            RobotPickerData robotPickerData;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TroopRobotPickerActivity.f177398j0, 2, "onDismiss|pickerType : " + this.f177415d.pickerType);
            }
            int i3 = this.f177415d.pickerType;
            if (i3 == 2) {
                Intent intent = new Intent();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("ageStart", this.f177415d.mAgeSelectIndex1);
                    jSONObject.put("ageEnd", this.f177415d.mAgeSelectIndex2);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                intent.putExtra("result", jSONObject.toString());
                intent.putExtra("callback", TroopRobotPickerActivity.this.f177407h0);
                TroopRobotPickerActivity.this.setResult(-1, intent);
                TroopRobotPickerActivity.this.finish();
                if (QLog.isColorLevel()) {
                    QLog.d(TroopRobotPickerActivity.f177398j0, 2, "onDismiss|mCurAgeIndex1 : " + this.f177415d.mCurAgeIndex1 + ", mCurAgeIndex2 : " + this.f177415d.mCurAgeIndex2 + ", mAgeSelectIndex1 : " + this.f177415d.mAgeSelectIndex1 + ", mAgeSelectIndex2 : " + this.f177415d.mAgeSelectIndex2);
                    return;
                }
                return;
            }
            if (i3 == 1) {
                Intent intent2 = new Intent();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("sex", this.f177415d.mSexIndex);
                } catch (JSONException e17) {
                    e17.printStackTrace();
                }
                intent2.putExtra("callback", TroopRobotPickerActivity.this.f177407h0);
                intent2.putExtra("result", jSONObject2.toString());
                TroopRobotPickerActivity.this.setResult(-1, intent2);
                TroopRobotPickerActivity.this.finish();
                return;
            }
            Intent intent3 = new Intent();
            JSONObject jSONObject3 = new JSONObject();
            int i16 = 0;
            while (true) {
                try {
                    robotPickerData = this.f177415d;
                    String[] strArr = robotPickerData.mLocationCodeArray;
                    if (i16 >= strArr.length) {
                        break;
                    }
                    String[] strArr2 = TroopRobotPickerActivity.f177399k0;
                    jSONObject3.put(strArr2[i16], strArr[i16]);
                    jSONObject3.put(strArr2[i16] + "Str", this.f177415d.mLocationArray[i16].name);
                    i16++;
                } catch (JSONException e18) {
                    e18.printStackTrace();
                }
            }
            jSONObject3.put("country", robotPickerData.mLocationCountyCode);
            jSONObject3.put("countryStr", this.f177415d.mLocationCountry.name);
            intent3.putExtra("result", jSONObject3.toString());
            intent3.putExtra("callback", TroopRobotPickerActivity.this.f177407h0);
            TroopRobotPickerActivity.this.setResult(-1, intent3);
            TroopRobotPickerActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class e implements IphonePickerView.PickerViewAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public RobotPickerData f177417a;

        e(RobotPickerData robotPickerData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopRobotPickerActivity.this, (Object) robotPickerData);
            } else {
                this.f177417a = robotPickerData;
            }
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter
        public int getColumnCount() {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            RobotPickerData robotPickerData = this.f177417a;
            int i16 = robotPickerData.pickerType;
            if (i16 == 2) {
                i3 = 2;
            } else {
                i3 = 1;
                if (i16 != 1 && i16 == 3) {
                    i3 = robotPickerData.mLocationColumCount;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(TroopRobotPickerActivity.f177398j0, 2, "getColumnCount|pickerType : " + this.f177417a.pickerType + ", count : " + i3);
            }
            return i3;
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter
        public int getRowCount(int i3) {
            int i16;
            Object obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, i3)).intValue();
            }
            RobotPickerData robotPickerData = this.f177417a;
            int i17 = robotPickerData.pickerType;
            if (i17 == 2) {
                i16 = ConditionSearchManager.f194486n0.length;
            } else if (i17 == 1) {
                i16 = ConditionSearchManager.f194485m0.length;
            } else if (i17 == 3 && i3 < robotPickerData.mLocationColumCount && i3 >= 0 && (obj = robotPickerData.mLocationListArray[i3]) != null) {
                i16 = ((List) obj).size();
            } else {
                i16 = 0;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TroopRobotPickerActivity.f177398j0, 2, "getRowCount|pickerType : " + this.f177417a.pickerType + ", column : " + i3 + ", count : " + i16);
            }
            return i16;
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter
        public String getText(int i3, int i16) {
            String str;
            Object obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
            }
            RobotPickerData robotPickerData = this.f177417a;
            int i17 = robotPickerData.pickerType;
            if (i17 == 2) {
                if (i16 < 0 || i16 >= ConditionSearchManager.f194486n0.length) {
                    i16 = 0;
                }
                str = ConditionSearchManager.f194486n0[i16];
            } else if (i17 == 1) {
                if (i16 < 0 || i16 >= ConditionSearchManager.f194487o0.length) {
                    i16 = 0;
                }
                str = ConditionSearchManager.f194485m0[i16];
            } else if (i17 == 3 && (obj = robotPickerData.mLocationListArray[i3]) != null) {
                if (i16 < 0 || i16 >= ((List) obj).size()) {
                    i16 = 0;
                }
                if (((BaseAddress) ((List) this.f177417a.mLocationListArray[i3]).get(i16)).code.equals("0")) {
                    str = HardCodeUtil.qqStr(R.string.f172856uq3);
                } else {
                    str = ((BaseAddress) ((List) this.f177417a.mLocationListArray[i3]).get(i16)).name;
                }
            } else {
                str = "";
            }
            if (QLog.isColorLevel()) {
                QLog.d(TroopRobotPickerActivity.f177398j0, 2, "getText|pickerType : " + this.f177417a.pickerType + ", column : " + i3 + ", row : " + i16 + ", result : " + str);
            }
            return str;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67555);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f177398j0 = "TroopRobotPickerActivity";
            f177399k0 = new String[]{"provn", "city", GdtGetUserInfoHandler.KEY_AREA, ""};
        }
    }

    public TroopRobotPickerActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private int G2(ArrayList<? extends BaseAddress> arrayList, String str) {
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (arrayList.get(i3).code.equals(str)) {
                return i3;
            }
        }
        return 0;
    }

    private void H2() {
        I2("");
    }

    private void I2(String str) {
        String str2;
        String str3;
        try {
            str2 = this.f177406g0.optString("countryCode");
        } catch (Exception e16) {
            e16.printStackTrace();
            str2 = "";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "1";
        }
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        BaseAddress w3 = this.f177400a0.w(str);
        RobotPickerData robotPickerData = this.f177404e0;
        robotPickerData.mLocationCountry = w3;
        if (w3 != null) {
            robotPickerData.mLocationColumCount = w3.getColumnNember();
            RobotPickerData robotPickerData2 = this.f177404e0;
            int i3 = robotPickerData2.mLocationColumCount;
            robotPickerData2.mLocationListArray = new Object[i3];
            robotPickerData2.mLocationArray = new BaseAddress[i3];
            robotPickerData2.mLocationIndexArray = new int[i3];
            if (i3 == 0) {
                return;
            }
            BaseAddress baseAddress = robotPickerData2.mLocationCountry;
            int length = robotPickerData2.mLocationCodeArray.length;
            int i16 = 0;
            for (int i17 = 0; i17 < length; i17++) {
                if (!"0".equals(this.f177404e0.mLocationCodeArray[i17])) {
                    this.f177404e0.mLocationListArray[i16] = baseAddress.getDataList();
                    RobotPickerData robotPickerData3 = this.f177404e0;
                    BaseAddress[] baseAddressArr = robotPickerData3.mLocationArray;
                    baseAddress = baseAddress.dataMap.get(robotPickerData3.mLocationCodeArray[i17]);
                    baseAddressArr[i16] = baseAddress;
                    RobotPickerData robotPickerData4 = this.f177404e0;
                    robotPickerData4.mLocationIndexArray[i16] = G2((ArrayList) robotPickerData4.mLocationListArray[i16], robotPickerData4.mLocationCodeArray[i17]);
                    i16++;
                    if (baseAddress == null) {
                        return;
                    }
                }
            }
            RobotPickerData robotPickerData5 = this.f177404e0;
            if (i16 < robotPickerData5.mLocationColumCount) {
                robotPickerData5.mLocationListArray[i16] = baseAddress.getDataList();
                this.f177404e0.mLocationArray[i16] = baseAddress.dataMap.get(0);
                this.f177404e0.mLocationIndexArray[i16] = 0;
            }
        }
        if (QLog.isColorLevel()) {
            String str4 = f177398j0;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("initLocationData|mLocationColumCount : ");
            sb5.append(this.f177404e0.mLocationColumCount);
            sb5.append(", mLocationCountry.name : ");
            BaseAddress baseAddress2 = this.f177404e0.mLocationCountry;
            if (baseAddress2 == null) {
                str3 = "null";
            } else {
                str3 = baseAddress2.name;
            }
            sb5.append(str3);
            QLog.d(str4, 2, sb5.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J2() {
        String str;
        int i3 = this.f177404e0.pickerType;
        if (i3 == 3) {
            H2();
        }
        ActionSheet createMenuSheet = ActionSheet.createMenuSheet(this);
        this.f177402c0 = createMenuSheet;
        DispatchActionMoveScrollView dispatchActionMoveScrollView = (DispatchActionMoveScrollView) createMenuSheet.findViewById(R.id.f163936cz);
        dispatchActionMoveScrollView.getChildAt(0).setOnClickListener(null);
        dispatchActionMoveScrollView.dispatchActionMove = true;
        dispatchActionMoveScrollView.setBackgroundResource(17170445);
        IphonePickerView iphonePickerView = (IphonePickerView) LayoutInflater.from(this).inflate(R.layout.avo, (ViewGroup) null);
        this.f177403d0 = iphonePickerView;
        iphonePickerView.initialize(new e(this.f177404e0));
        this.f177403d0.setBackgroundColor(-1118221);
        if (i3 == 2) {
            this.f177403d0.setSelection(0, this.f177404e0.mAgeSelectIndex1);
            this.f177403d0.setSelection(1, this.f177404e0.mAgeSelectIndex2);
        } else if (i3 == 1) {
            this.f177403d0.setSelection(0, this.f177404e0.mSexIndex);
        } else {
            int i16 = 0;
            while (true) {
                RobotPickerData robotPickerData = this.f177404e0;
                if (i16 >= robotPickerData.mLocationColumCount) {
                    break;
                }
                this.f177403d0.setSelection(i16, robotPickerData.mLocationIndexArray[i16]);
                i16++;
            }
            TextView textView = (TextView) this.f177403d0.findViewById(R.id.f166840im0);
            this.f177401b0 = textView;
            textView.setVisibility(0);
            BaseAddress baseAddress = this.f177404e0.mLocationCountry;
            if (baseAddress != null) {
                str = baseAddress.name;
            } else {
                str = CountrySelectView.NAME_CHINA;
            }
            this.f177401b0.setText(str);
            this.f177401b0.setOnClickListener(new a());
            if (AppSetting.f99565y) {
                this.f177401b0.setContentDescription(HardCodeUtil.qqStr(R.string.upy) + str + HardCodeUtil.qqStr(R.string.f172854uq0));
            }
        }
        IphonePickerView iphonePickerView2 = this.f177403d0;
        iphonePickerView2.setPickListener(new c(this.f177404e0, iphonePickerView2, this.f177402c0));
        this.f177402c0.getWindow().setFlags(16777216, 16777216);
        this.f177402c0.setActionContentView(this.f177403d0, null);
        this.f177402c0.setOnDismissListener(new d(this.f177404e0));
        try {
            this.f177402c0.show();
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d(f177398j0, 2, th5.getMessage());
            }
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
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
        if (i16 == -1 && i3 == 111) {
            String stringExtra = intent.getStringExtra("key_country_code");
            if (QLog.isColorLevel()) {
                QLog.d(f177398j0, 2, "doOnActivityResult | codes = " + stringExtra);
            }
            if (!TextUtils.isEmpty(stringExtra) && !stringExtra.equals(this.f177404e0.mLocationCountyCode)) {
                RobotPickerData robotPickerData = this.f177404e0;
                robotPickerData.mLocationCountyCode = stringExtra;
                robotPickerData.mLocationCountry = this.f177400a0.w(stringExtra);
                BaseAddress baseAddress = this.f177404e0.mLocationCountry;
                if (baseAddress != null) {
                    int columnNember = baseAddress.getColumnNember();
                    if (columnNember > 0 && columnNember <= 3) {
                        I2(this.f177404e0.mLocationCountyCode);
                        ActionSheet actionSheet = this.f177402c0;
                        if (actionSheet != null && actionSheet.isShowing()) {
                            if (this.f177403d0 == null) {
                                this.f177403d0 = (IphonePickerView) getLayoutInflater().inflate(R.layout.avo, (ViewGroup) null);
                            }
                            this.f177403d0.initialize(new e(this.f177404e0));
                            for (int i17 = 0; i17 < this.f177404e0.mLocationColumCount; i17++) {
                                this.f177403d0.notifyDataSetChange(i17);
                                this.f177403d0.setSelection(i17, 0);
                            }
                        }
                        TextView textView = this.f177401b0;
                        if (textView != null) {
                            textView.setText(this.f177404e0.mLocationCountry.name);
                            if (AppSetting.f99565y) {
                                this.f177401b0.setContentDescription(HardCodeUtil.qqStr(R.string.uq8) + this.f177404e0.mLocationCountry.name + HardCodeUtil.qqStr(R.string.uqa));
                            }
                        }
                    } else {
                        I2(this.f177404e0.mLocationCountyCode);
                        ActionSheet actionSheet2 = this.f177402c0;
                        if (actionSheet2 != null && actionSheet2.isShowing()) {
                            this.f177402c0.dismiss();
                        }
                    }
                }
            }
        }
        super.doOnActivityResult(i3, i16, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        RobotPickerData robotPickerData;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        ReportProgressDialog reportProgressDialog = new ReportProgressDialog(this);
        this.f177408i0 = reportProgressDialog;
        reportProgressDialog.setMessage(HardCodeUtil.qqStr(R.string.uq5));
        this.f177404e0 = new RobotPickerData();
        try {
            JSONObject jSONObject = new JSONObject(getIntent().getStringExtra(ark.ARKMETADATA_JSON));
            this.f177405f0 = jSONObject;
            this.f177406g0 = jSONObject.getJSONObject("selected");
            this.f177407h0 = this.f177405f0.optString("callback");
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        JSONObject jSONObject2 = this.f177405f0;
        if (jSONObject2 != null && this.f177407h0 != null) {
            try {
                this.f177404e0.pickerType = jSONObject2.optInt("type");
                robotPickerData = this.f177404e0;
                i3 = robotPickerData.pickerType;
            } catch (Exception e17) {
                e17.printStackTrace();
            }
            if (i3 == 0) {
                finish();
                QQToast.makeText(this, HardCodeUtil.qqStr(R.string.f172857uq4), 1).show();
                return false;
            }
            if (i3 == 1) {
                robotPickerData.mSexIndex = this.f177406g0.optInt("sex");
            } else if (i3 == 2) {
                robotPickerData.mAgeSelectIndex1 = this.f177406g0.optInt("ageStart");
                this.f177404e0.mAgeSelectIndex2 = this.f177406g0.optInt("ageEnd");
                RobotPickerData robotPickerData2 = this.f177404e0;
                robotPickerData2.mCurAgeIndex1 = robotPickerData2.mAgeSelectIndex1;
                robotPickerData2.mCurAgeIndex2 = robotPickerData2.mAgeSelectIndex2;
            } else {
                robotPickerData.mLocationCodeArray = new String[3];
                for (int i16 = 0; i16 < 3; i16++) {
                    this.f177404e0.mLocationCodeArray[i16] = this.f177406g0.optString(f177399k0[i16]);
                }
                this.f177404e0.mLocationCountyCode = this.f177406g0.optString("country");
            }
            this.f177400a0 = (ConditionSearchManager) this.app.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER);
            int i17 = this.f177404e0.pickerType;
            if (i17 == 3) {
                this.f177408i0.show();
                this.f177400a0.g(new b());
                ConditionSearchManager conditionSearchManager = this.f177400a0;
                conditionSearchManager.h0(conditionSearchManager.j(), true);
            } else if (i17 != -1) {
                J2();
            }
            return false;
        }
        finish();
        if (QLog.isColorLevel()) {
            QLog.e("" + f177398j0, 2, "webData is null!");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.doOnDestroy();
        ConditionSearchManager conditionSearchManager = this.f177400a0;
        if (conditionSearchManager != null) {
            conditionSearchManager.o(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.doOnStart();
        ConditionSearchManager conditionSearchManager = this.f177400a0;
        if (conditionSearchManager != null) {
            conditionSearchManager.h(this);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
