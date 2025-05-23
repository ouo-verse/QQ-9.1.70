package com.tenpay.proxy.dlg.location;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class LocSelDlg {
    public static final int INDEX_CIT = 1;
    public static final int INDEX_DIS = 2;
    public static final int INDEX_PRO = 0;
    private static final String TAG = "LocSelDlg";
    private int actionId;
    private QbAddrData addressData;

    /* renamed from: as, reason: collision with root package name */
    ActionSheet f386685as;
    QbBaseAddr[] columnArray;
    Object[] columnListArray;
    private QbBaseAddr country;
    int[] indexArray;
    private String locationString;
    private Context mContext;
    private OnLocationLocationSelectedListener mLocationSelected;
    private int pickerLayout;

    /* renamed from: pv, reason: collision with root package name */
    IphonePickerView f386686pv;
    int columnCount = 0;
    String[] lastAddressCodes = {"0", "0", "0"};
    IphonePickerView.PickerViewAdapter mAdapter = new IphonePickerView.PickerViewAdapter() { // from class: com.tenpay.proxy.dlg.location.LocSelDlg.1
        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter
        public int getColumnCount() {
            return LocSelDlg.this.columnCount;
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter
        public int getRowCount(int i3) {
            Object obj = LocSelDlg.this.columnListArray[i3];
            if (obj != null) {
                return ((List) obj).size();
            }
            return 0;
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter
        public String getText(int i3, int i16) {
            try {
                Object obj = LocSelDlg.this.columnListArray[i3];
                if (obj != null) {
                    return ((QbBaseAddr) ((List) obj).get(i16)).name;
                }
            } catch (IndexOutOfBoundsException e16) {
                QLog.e(LocSelDlg.TAG, 1, "", e16);
            }
            return "";
        }
    };
    IphonePickerView.IphonePickListener mListener = new IphonePickerView.IphonePickListener() { // from class: com.tenpay.proxy.dlg.location.LocSelDlg.2
        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener
        public void onConfirmBtClicked() {
            LocSelDlg.this.f386685as.dismiss();
            if (LocSelDlg.this.mLocationSelected != null) {
                LocSelDlg.this.mLocationSelected.onConfirmBtClicked(LocSelDlg.this.createLocationString());
            }
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener
        public void onItemSelected(int i3, int i16) {
            LocSelDlg locSelDlg = LocSelDlg.this;
            IphonePickerView iphonePickerView = locSelDlg.f386686pv;
            if (iphonePickerView == null) {
                return;
            }
            ArrayList arrayList = null;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        if (!Collections.emptyList().equals(LocSelDlg.this.columnListArray[2])) {
                            arrayList = (ArrayList) LocSelDlg.this.columnListArray[2];
                        }
                        if (arrayList != null && i16 < arrayList.size() && i16 >= 0) {
                            LocSelDlg.this.columnArray[2] = (QbBaseAddr) arrayList.get(i16);
                            LocSelDlg.this.indexArray[2] = i16;
                        }
                    }
                } else {
                    locSelDlg.indexArray[1] = i16;
                    iphonePickerView.setPickListener(null);
                    try {
                        LocSelDlg locSelDlg2 = LocSelDlg.this;
                        locSelDlg2.columnArray[1] = (QbBaseAddr) ((ArrayList) locSelDlg2.columnListArray[1]).get(i16);
                    } catch (Exception unused) {
                        LocSelDlg.this.columnArray[1] = new QbBaseAddr(HardCodeUtil.qqStr(R.string.f172149nu1), "0", 2);
                    }
                    ArrayList<QbBaseAddr> dataList = LocSelDlg.this.columnArray[1].getDataList();
                    if (dataList.size() > 0) {
                        LocSelDlg locSelDlg3 = LocSelDlg.this;
                        locSelDlg3.columnListArray[2] = dataList;
                        locSelDlg3.columnArray[2] = dataList.get(0);
                        LocSelDlg.this.indexArray[2] = 0;
                    } else {
                        LocSelDlg locSelDlg4 = LocSelDlg.this;
                        if (locSelDlg4.columnCount > 2) {
                            locSelDlg4.columnArray[2] = new QbAddrData.NoLimitAddress(3);
                            LocSelDlg locSelDlg5 = LocSelDlg.this;
                            locSelDlg5.columnListArray[2] = null;
                            locSelDlg5.indexArray[2] = 0;
                        }
                    }
                    LocSelDlg locSelDlg6 = LocSelDlg.this;
                    if (locSelDlg6.columnCount > 2) {
                        locSelDlg6.f386686pv.notifyDataSetChange(2);
                        LocSelDlg locSelDlg7 = LocSelDlg.this;
                        locSelDlg7.f386686pv.setSelection(2, locSelDlg7.indexArray[2]);
                    }
                    LocSelDlg.this.f386686pv.setPickListener(this);
                }
            } else {
                iphonePickerView.setPickListener(null);
                LocSelDlg locSelDlg8 = LocSelDlg.this;
                locSelDlg8.indexArray[0] = i16;
                locSelDlg8.columnArray[0] = (QbBaseAddr) ((ArrayList) locSelDlg8.columnListArray[0]).get(i16);
                ArrayList<QbBaseAddr> dataList2 = LocSelDlg.this.columnArray[0].getDataList();
                if (dataList2.size() > 0) {
                    LocSelDlg locSelDlg9 = LocSelDlg.this;
                    locSelDlg9.columnListArray[1] = dataList2;
                    locSelDlg9.columnArray[1] = dataList2.get(0);
                    LocSelDlg locSelDlg10 = LocSelDlg.this;
                    locSelDlg10.indexArray[1] = 0;
                    ArrayList<QbBaseAddr> dataList3 = locSelDlg10.columnArray[1].getDataList();
                    if (dataList3.size() > 0) {
                        LocSelDlg locSelDlg11 = LocSelDlg.this;
                        locSelDlg11.columnListArray[2] = dataList3;
                        locSelDlg11.columnArray[2] = dataList3.get(0);
                        LocSelDlg.this.indexArray[2] = 0;
                    } else {
                        LocSelDlg locSelDlg12 = LocSelDlg.this;
                        if (locSelDlg12.columnCount == 3) {
                            locSelDlg12.columnArray[2] = new QbAddrData.NoLimitAddress(3);
                            LocSelDlg locSelDlg13 = LocSelDlg.this;
                            locSelDlg13.columnListArray[2] = null;
                            locSelDlg13.indexArray[2] = 0;
                        }
                    }
                } else {
                    LocSelDlg locSelDlg14 = LocSelDlg.this;
                    if (locSelDlg14.columnCount > 1) {
                        locSelDlg14.columnArray[1] = new QbAddrData.NoLimitAddress(2);
                        LocSelDlg locSelDlg15 = LocSelDlg.this;
                        locSelDlg15.columnListArray[1] = null;
                        locSelDlg15.indexArray[1] = 0;
                        if (locSelDlg15.columnCount == 3) {
                            locSelDlg15.columnArray[2] = new QbAddrData.NoLimitAddress(3);
                            LocSelDlg locSelDlg16 = LocSelDlg.this;
                            locSelDlg16.columnListArray[2] = null;
                            locSelDlg16.indexArray[2] = 0;
                        }
                    }
                }
                LocSelDlg locSelDlg17 = LocSelDlg.this;
                if (locSelDlg17.columnCount > 1) {
                    locSelDlg17.f386686pv.notifyDataSetChange(1);
                    LocSelDlg locSelDlg18 = LocSelDlg.this;
                    locSelDlg18.f386686pv.setSelection(1, locSelDlg18.indexArray[1]);
                    LocSelDlg locSelDlg19 = LocSelDlg.this;
                    if (locSelDlg19.columnCount == 3) {
                        locSelDlg19.f386686pv.notifyDataSetChange(2);
                        LocSelDlg locSelDlg20 = LocSelDlg.this;
                        locSelDlg20.f386686pv.setSelection(2, locSelDlg20.indexArray[2]);
                    }
                }
                LocSelDlg.this.f386686pv.setPickListener(this);
            }
            if (LocSelDlg.this.mLocationSelected != null) {
                LocSelDlg.this.mLocationSelected.onConfirmBtClicked(LocSelDlg.this.createLocationString());
            }
        }
    };

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnLocationLocationSelectedListener {
        void onConfirmBtClicked(String str);
    }

    public LocSelDlg(Context context, String str, int i3, int i16, QbAddrData qbAddrData) {
        this.addressData = null;
        this.locationString = HardCodeUtil.qqStr(R.string.f172150nu2);
        this.mContext = context;
        this.actionId = i3;
        this.pickerLayout = i16;
        this.addressData = qbAddrData;
        if (!TextUtils.isEmpty(str)) {
            this.locationString = str;
        }
        initData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String createLocationString() {
        QbBaseAddr qbBaseAddr;
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < this.columnCount; i3++) {
            QbBaseAddr[] qbBaseAddrArr = this.columnArray;
            if (qbBaseAddrArr != null && (qbBaseAddr = qbBaseAddrArr[i3]) != null && !"0".equals(qbBaseAddr.code)) {
                sb5.append(this.columnArray[i3].name);
                sb5.append(" ");
            }
        }
        String sb6 = sb5.toString();
        if (TextUtils.isEmpty(sb6)) {
            return "";
        }
        return sb6.substring(0, sb6.length() - 1);
    }

    private String getCodeByName(LinkedHashMap<String, QbBaseAddr> linkedHashMap, String str) {
        if (linkedHashMap != null && linkedHashMap.size() > 0) {
            for (Map.Entry<String, QbBaseAddr> entry : linkedHashMap.entrySet()) {
                if (!(entry.getValue() instanceof QbBaseAddr)) {
                    break;
                }
                if (entry.getValue().name.contains(str) || str.contains(entry.getValue().name)) {
                    return entry.getKey().toString();
                }
            }
        }
        return "0";
    }

    private int getDateIndexByCode(ArrayList<? extends QbBaseAddr> arrayList, String str) {
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (arrayList.get(i3).code.equals(str)) {
                return i3;
            }
        }
        return 0;
    }

    private void getLastAddressCodes() {
        String[] strArr = {"", "", ""};
        if (!TextUtils.isEmpty(this.locationString)) {
            String[] split = this.locationString.split(" ");
            for (int i3 = 0; i3 < split.length; i3++) {
                strArr[i3] = split[i3];
            }
            QbBaseAddr qbBaseAddr = this.country;
            if (qbBaseAddr != null) {
                String codeByName = getCodeByName(qbBaseAddr.dataMap, strArr[0]);
                String[] strArr2 = this.lastAddressCodes;
                if (codeByName.equals("0")) {
                    codeByName = getCodeByName(this.country.dataMap, HardCodeUtil.qqStr(R.string.f172148nu0));
                }
                strArr2[0] = codeByName;
                QbBaseAddr qbBaseAddr2 = this.country.dataMap.get(this.lastAddressCodes[0]);
                if (qbBaseAddr2 != null) {
                    String codeByName2 = getCodeByName(qbBaseAddr2.dataMap, strArr[1]);
                    String[] strArr3 = this.lastAddressCodes;
                    if (codeByName2.equals("0")) {
                        codeByName2 = getCodeByName(qbBaseAddr2.dataMap, HardCodeUtil.qqStr(R.string.ntz));
                    }
                    strArr3[1] = codeByName2;
                    QbBaseAddr qbBaseAddr3 = qbBaseAddr2.dataMap.get(this.lastAddressCodes[1]);
                    if (qbBaseAddr3 != null) {
                        this.lastAddressCodes[2] = getCodeByName(qbBaseAddr3.dataMap, strArr[2]);
                    }
                }
            }
        }
    }

    private void initData() {
        if (this.addressData == null) {
            this.addressData = QbAddrHelper.doPraseFile(new File(((IQWalletTemp) QRoute.api(IQWalletTemp.class)).getConfigPath()));
        }
        QbAddrData qbAddrData = this.addressData;
        if (qbAddrData != null) {
            this.country = qbAddrData.countryMap.get("1");
        }
        if (this.country == null) {
            return;
        }
        getLastAddressCodes();
        int columnNember = this.country.getColumnNember();
        this.columnCount = columnNember;
        this.columnListArray = new Object[columnNember];
        this.columnArray = new QbBaseAddr[columnNember];
        this.indexArray = new int[columnNember];
        if (columnNember == 0) {
            return;
        }
        QbBaseAddr qbBaseAddr = this.country;
        int length = this.lastAddressCodes.length;
        int i3 = 0;
        for (int i16 = 0; i16 < length; i16++) {
            if (!"0".equals(this.lastAddressCodes[i16])) {
                this.columnListArray[i3] = qbBaseAddr.getDataList();
                QbBaseAddr[] qbBaseAddrArr = this.columnArray;
                qbBaseAddr = qbBaseAddr.dataMap.get(this.lastAddressCodes[i16]);
                qbBaseAddrArr[i3] = qbBaseAddr;
                this.indexArray[i3] = getDateIndexByCode((ArrayList) this.columnListArray[i3], this.lastAddressCodes[i16]);
                i3++;
                if (qbBaseAddr == null) {
                    return;
                }
            }
        }
        if (i3 == 0) {
            this.columnListArray[0] = qbBaseAddr.getDataList();
            this.columnArray[0] = qbBaseAddr.dataMap.get(0);
            return;
        }
        try {
            if (i3 < this.columnCount) {
                this.columnListArray[i3] = qbBaseAddr.getDataList();
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
        }
    }

    @SuppressLint({"NewApi"})
    public void popupPickerView() {
        ActionSheet createMenuSheet = ActionSheet.createMenuSheet(this.mContext);
        this.f386685as = createMenuSheet;
        DispatchActionMoveScrollView dispatchActionMoveScrollView = (DispatchActionMoveScrollView) createMenuSheet.findViewById(this.actionId);
        dispatchActionMoveScrollView.dispatchActionMove = true;
        dispatchActionMoveScrollView.setBackgroundResource(17170445);
        this.f386685as.setCloseAutoRead(false);
        IphonePickerView iphonePickerView = (IphonePickerView) LayoutInflater.from(this.mContext).inflate(this.pickerLayout, (ViewGroup) null);
        this.f386686pv = iphonePickerView;
        iphonePickerView.initialize(this.mAdapter);
        for (int i3 = 0; i3 < this.columnCount; i3++) {
            this.f386686pv.setSelection(i3, this.indexArray[i3]);
        }
        this.f386686pv.setPickListener(this.mListener);
        this.f386685as.getWindow().setFlags(16777216, 16777216);
        this.f386685as.setActionContentView(this.f386686pv, null);
        try {
            this.f386685as.show();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "", th5);
        }
    }

    public void setLocationSelected(OnLocationLocationSelectedListener onLocationLocationSelectedListener) {
        this.mLocationSelected = onLocationLocationSelectedListener;
    }
}
