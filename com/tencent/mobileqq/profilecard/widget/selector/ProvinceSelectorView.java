package com.tencent.mobileqq.profilecard.widget.selector;

import android.content.Context;
import com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi;
import com.tencent.mobileqq.profilecard.widget.ProfileEditPickerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.selectorview.model.BaseAddress;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class ProvinceSelectorView extends BaseSelectorView {
    static IPatchRedirector $redirector_ = null;
    public static final String CODE_NO_SELECT = "0";
    public static final String DEFAULT_COUNTRY_CODE = "1";
    public static final int INDEX_CIT = 1;
    public static final int INDEX_DIS = 2;
    public static final int INDEX_PRO = 0;
    public static final String NAME_NO_SELECT = "";
    public static final String NAME_NO_SELECT_PROFILE = "----";
    private static final String TAG = "ProvinceSelectorView";
    private final ProfileEditPickerView.PickerViewAdapter mAdapter;
    private BaseAddress[] mColumnArray;
    private int mColumnCount;
    private ArrayList<ArrayList<BaseAddress>> mColumnListArray;
    private String mCountryCode;
    private int[] mIndexArray;
    private String[] mLastAddressCodes;
    private final ProfileEditPickerView.ProfileEditPickListener mListener;

    /* loaded from: classes16.dex */
    public static final class NoSelectAddress extends BaseAddress {
        static IPatchRedirector $redirector_;

        public NoSelectAddress(String str, String str2, int i3) {
            super(str, str2, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, this, str, str2, Integer.valueOf(i3));
        }

        public NoSelectAddress(int i3) {
            this("", "0", i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
    }

    public ProvinceSelectorView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mLastAddressCodes = new String[]{"0", "0", "0"};
        this.mColumnCount = 1;
        this.mAdapter = new ProfileEditPickerView.PickerViewAdapter() { // from class: com.tencent.mobileqq.profilecard.widget.selector.ProvinceSelectorView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProvinceSelectorView.this);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.widget.ProfileEditPickerView.PickerViewAdapter
            public int getColumnCount() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 4)) {
                    return ProvinceSelectorView.this.mColumnCount;
                }
                return ((Integer) iPatchRedirector2.redirect((short) 4, (Object) this)).intValue();
            }

            @Override // com.tencent.mobileqq.profilecard.widget.ProfileEditPickerView.PickerViewAdapter
            public int getRowCount(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    return ((Integer) iPatchRedirector2.redirect((short) 3, (Object) this, i3)).intValue();
                }
                if (i3 < 0 || i3 >= ProvinceSelectorView.this.mColumnListArray.size() || ProvinceSelectorView.this.mColumnListArray.get(i3) == null) {
                    return 0;
                }
                return ((ArrayList) ProvinceSelectorView.this.mColumnListArray.get(i3)).size();
            }

            @Override // com.tencent.mobileqq.profilecard.widget.ProfileEditPickerView.PickerViewAdapter
            public String getText(int i3, int i16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                }
                try {
                    if (ProvinceSelectorView.this.mColumnListArray.get(i3) != null) {
                        if (((BaseAddress) ((ArrayList) ProvinceSelectorView.this.mColumnListArray.get(i3)).get(i16)).code.equals("0")) {
                            return ProvinceSelectorView.NAME_NO_SELECT_PROFILE;
                        }
                        return ((BaseAddress) ((ArrayList) ProvinceSelectorView.this.mColumnListArray.get(i3)).get(i16)).name;
                    }
                } catch (IndexOutOfBoundsException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e(ProvinceSelectorView.TAG, 2, "", e16);
                    }
                }
                return "";
            }
        };
        ProfileEditPickerView.ProfileEditPickListener profileEditPickListener = new ProfileEditPickerView.ProfileEditPickListener() { // from class: com.tencent.mobileqq.profilecard.widget.selector.ProvinceSelectorView.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProvinceSelectorView.this);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.widget.ProfileEditPickerView.ProfileEditPickListener
            public void onItemSelected(int i3, int i16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                    return;
                }
                ProvinceSelectorView provinceSelectorView = ProvinceSelectorView.this;
                ProfileEditPickerView profileEditPickerView = provinceSelectorView.pickerView;
                if (profileEditPickerView == null) {
                    return;
                }
                ArrayList arrayList = null;
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            if (Collections.emptyList().equals(ProvinceSelectorView.this.mColumnListArray.get(2))) {
                                if (QLog.isColorLevel()) {
                                    QLog.d(ProvinceSelectorView.TAG, 2, "columnListArray at 2 is empty");
                                }
                            } else {
                                arrayList = (ArrayList) ProvinceSelectorView.this.mColumnListArray.get(2);
                            }
                            if (arrayList != null && i16 < arrayList.size() && i16 >= 0) {
                                ProvinceSelectorView.this.mColumnArray[2] = (BaseAddress) arrayList.get(i16);
                                ProvinceSelectorView.this.mIndexArray[2] = i16;
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    provinceSelectorView.mIndexArray[1] = i16;
                    ProvinceSelectorView.this.pickerView.setPickListener(null);
                    try {
                        ProvinceSelectorView.this.mColumnArray[1] = (BaseAddress) ((ArrayList) ProvinceSelectorView.this.mColumnListArray.get(1)).get(i16);
                    } catch (Exception unused) {
                        ProvinceSelectorView.this.mColumnArray[1] = new BaseAddress("", "0", 2);
                    }
                    ArrayList<BaseAddress> dataList = ProvinceSelectorView.this.mColumnArray[1].getDataList();
                    if (dataList.size() > 0) {
                        ProvinceSelectorView.this.mColumnListArray.set(2, dataList);
                        ProvinceSelectorView.this.mColumnArray[2] = dataList.get(0);
                        ProvinceSelectorView.this.mIndexArray[2] = 0;
                    } else if (ProvinceSelectorView.this.mColumnCount > 2) {
                        ProvinceSelectorView.this.mColumnArray[2] = new NoSelectAddress(3);
                        ProvinceSelectorView.this.mColumnListArray.set(2, null);
                        ProvinceSelectorView.this.mIndexArray[2] = 0;
                    }
                    if (ProvinceSelectorView.this.mColumnCount > 2) {
                        ProvinceSelectorView.this.pickerView.notifyDataSetChange(2);
                        ProvinceSelectorView provinceSelectorView2 = ProvinceSelectorView.this;
                        provinceSelectorView2.pickerView.setSelection(2, provinceSelectorView2.mIndexArray[2]);
                    }
                    ProvinceSelectorView.this.pickerView.setPickListener(this);
                    return;
                }
                profileEditPickerView.setPickListener(null);
                if (ProvinceSelectorView.this.mIndexArray.length == 0) {
                    ProvinceSelectorView.this.pickerView.setPickListener(this);
                    return;
                }
                ProvinceSelectorView.this.mIndexArray[0] = i16;
                ProvinceSelectorView.this.mColumnArray[0] = (BaseAddress) ((ArrayList) ProvinceSelectorView.this.mColumnListArray.get(0)).get(i16);
                ArrayList<BaseAddress> dataList2 = ProvinceSelectorView.this.mColumnArray[0].getDataList();
                if (dataList2.size() > 0) {
                    ProvinceSelectorView.this.mColumnListArray.set(1, dataList2);
                    ProvinceSelectorView.this.mColumnArray[1] = dataList2.get(0);
                    ProvinceSelectorView.this.mIndexArray[1] = 0;
                    ArrayList<BaseAddress> dataList3 = ProvinceSelectorView.this.mColumnArray[1].getDataList();
                    if (dataList3.size() > 0) {
                        ProvinceSelectorView.this.mColumnListArray.set(2, dataList3);
                        ProvinceSelectorView.this.mColumnArray[2] = dataList3.get(0);
                        ProvinceSelectorView.this.mIndexArray[2] = 0;
                    } else if (ProvinceSelectorView.this.mColumnCount == 3) {
                        ProvinceSelectorView.this.mColumnArray[2] = new NoSelectAddress(3);
                        ProvinceSelectorView.this.mColumnListArray.set(2, null);
                        ProvinceSelectorView.this.mIndexArray[2] = 0;
                    }
                } else if (ProvinceSelectorView.this.mColumnCount > 1) {
                    ProvinceSelectorView.this.mColumnArray[1] = new NoSelectAddress(2);
                    ProvinceSelectorView.this.mColumnListArray.set(1, null);
                    ProvinceSelectorView.this.mIndexArray[1] = 0;
                    if (ProvinceSelectorView.this.mColumnCount == 3) {
                        ProvinceSelectorView.this.mColumnArray[2] = new NoSelectAddress(3);
                        ProvinceSelectorView.this.mColumnListArray.set(2, null);
                        ProvinceSelectorView.this.mIndexArray[2] = 0;
                    }
                }
                if (ProvinceSelectorView.this.mColumnCount > 1) {
                    ProvinceSelectorView.this.pickerView.notifyDataSetChange(1);
                    ProvinceSelectorView provinceSelectorView3 = ProvinceSelectorView.this;
                    provinceSelectorView3.pickerView.setSelection(1, provinceSelectorView3.mIndexArray[1]);
                    if (ProvinceSelectorView.this.mColumnCount == 3) {
                        ProvinceSelectorView.this.pickerView.notifyDataSetChange(2);
                        ProvinceSelectorView provinceSelectorView4 = ProvinceSelectorView.this;
                        provinceSelectorView4.pickerView.setSelection(2, provinceSelectorView4.mIndexArray[2]);
                    }
                }
                ProvinceSelectorView.this.pickerView.setPickListener(this);
            }
        };
        this.mListener = profileEditPickListener;
        initColumnListArray();
        this.pickerView.setPickListener(profileEditPickListener);
    }

    private void getAreaInfo() {
        ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).loadProvinceInfo(MobileQQ.sMobileQQ.waitAppRuntime(null), this.mCountryCode, new IProfileEditBusinessApi.OnAreaInfoLoadedListener() { // from class: com.tencent.mobileqq.profilecard.widget.selector.ProvinceSelectorView.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProvinceSelectorView.this);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi.OnAreaInfoLoadedListener
            public void onAreaInfoLoaded(Object obj) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, obj);
                } else if (obj instanceof BaseAddress) {
                    ProvinceSelectorView.this.initData((BaseAddress) obj);
                } else {
                    QLog.e(ProvinceSelectorView.TAG, 1, "getAreaInfo fail: areaInfo is not a subtype of BaseAddress");
                }
            }
        });
    }

    private int getDateIndex(ArrayList<? extends BaseAddress> arrayList, String str) {
        if (arrayList == null) {
            QLog.e(TAG, 1, "getDateIndex: list is null");
            return 0;
        }
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (arrayList.get(i3).code.equals(str)) {
                return i3;
            }
        }
        return 0;
    }

    private void initColumnListArray() {
        ArrayList<ArrayList<BaseAddress>> arrayList = new ArrayList<>(3);
        this.mColumnListArray = arrayList;
        arrayList.add(new ArrayList<>());
        this.mColumnListArray.add(new ArrayList<>());
        this.mColumnListArray.add(new ArrayList<>());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData(BaseAddress baseAddress) {
        if (baseAddress == null) {
            return;
        }
        int columnNember = baseAddress.getColumnNember();
        this.mColumnCount = columnNember;
        this.mColumnArray = new BaseAddress[columnNember];
        this.mIndexArray = new int[columnNember];
        if (columnNember == 0) {
            return;
        }
        int i3 = 0;
        for (String str : this.mLastAddressCodes) {
            if (!"0".equals(str)) {
                this.mColumnListArray.set(i3, baseAddress.getDataList());
                BaseAddress[] baseAddressArr = this.mColumnArray;
                baseAddress = baseAddress.dataMap.get(str);
                baseAddressArr[i3] = baseAddress;
                this.mIndexArray[i3] = getDateIndex(this.mColumnListArray.get(i3), str);
                i3++;
                if (baseAddress == null) {
                    return;
                }
            }
        }
        if (i3 == 0) {
            this.mColumnListArray.set(i3, baseAddress.getDataList());
            this.mColumnArray[i3] = baseAddress.dataMap.get(0);
            return;
        }
        try {
            if (i3 < this.mColumnCount) {
                this.mColumnListArray.set(i3, baseAddress.getDataList());
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "", e16);
            }
        }
    }

    public String[] getCodes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        BaseAddress[] baseAddressArr = this.mColumnArray;
        if (baseAddressArr != null && baseAddressArr.length <= 3) {
            String[] strArr = new String[4];
            int i3 = 0;
            strArr[0] = this.mCountryCode;
            strArr[1] = "0";
            strArr[2] = "0";
            strArr[3] = "0";
            while (true) {
                BaseAddress[] baseAddressArr2 = this.mColumnArray;
                if (i3 < baseAddressArr2.length) {
                    BaseAddress baseAddress = baseAddressArr2[i3];
                    if (baseAddress != null) {
                        strArr[i3 + 1] = baseAddress.code;
                    }
                    i3++;
                } else {
                    return strArr;
                }
            }
        } else {
            return null;
        }
    }

    public void init(String str, String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) strArr);
            return;
        }
        this.mCountryCode = str;
        if (strArr == null) {
            strArr = this.mLastAddressCodes;
        }
        this.mLastAddressCodes = strArr;
        getAreaInfo();
        if (this.mAdapter.getColumnCount() <= 0) {
            QLog.e(TAG, 1, "init fail, columnCount<=0");
            return;
        }
        this.pickerView.initialize(this.mAdapter);
        this.pickerView.setHide(this.actionSheet.isHide());
        for (int i3 = 0; i3 < this.mColumnCount; i3++) {
            this.pickerView.setSelection(i3, this.mIndexArray[i3]);
        }
        this.pickerView.notifyDataSetChange(0);
    }
}
