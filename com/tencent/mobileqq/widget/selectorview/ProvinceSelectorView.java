package com.tencent.mobileqq.widget.selectorview;

import android.content.Context;
import com.tencent.mobileqq.widget.selectorview.QPickerView;
import com.tencent.mobileqq.widget.selectorview.model.BaseAddress;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes20.dex */
public class ProvinceSelectorView extends h {

    /* renamed from: g, reason: collision with root package name */
    private String f317347g;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<ArrayList<BaseAddress>> f317348h;

    /* renamed from: i, reason: collision with root package name */
    private BaseAddress[] f317349i;

    /* renamed from: j, reason: collision with root package name */
    private int[] f317350j;

    /* renamed from: k, reason: collision with root package name */
    private String[] f317351k;

    /* renamed from: l, reason: collision with root package name */
    private int f317352l;

    /* renamed from: m, reason: collision with root package name */
    private final QPickerView.e f317353m;

    /* renamed from: n, reason: collision with root package name */
    private final QPickerView.f f317354n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f317355o;

    /* loaded from: classes20.dex */
    public static final class NoSelectAddress extends BaseAddress {
        public NoSelectAddress(String str, String str2, int i3) {
            super(str, str2, i3);
        }

        public NoSelectAddress(int i3) {
            this("", "0", i3);
        }
    }

    /* loaded from: classes20.dex */
    class a implements QPickerView.e {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        public int getColumnCount() {
            return ProvinceSelectorView.this.f317352l;
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        public int getRowCount(int i3) {
            if (i3 < 0 || i3 >= ProvinceSelectorView.this.f317348h.size() || ProvinceSelectorView.this.f317348h.get(i3) == null) {
                return 0;
            }
            return ((ArrayList) ProvinceSelectorView.this.f317348h.get(i3)).size();
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        public String getText(int i3, int i16) {
            try {
                if (ProvinceSelectorView.this.f317348h.get(i3) != null) {
                    if (((BaseAddress) ((ArrayList) ProvinceSelectorView.this.f317348h.get(i3)).get(i16)).code.equals("0")) {
                        return com.tencent.mobileqq.profilecard.widget.selector.ProvinceSelectorView.NAME_NO_SELECT_PROFILE;
                    }
                    return ((BaseAddress) ((ArrayList) ProvinceSelectorView.this.f317348h.get(i3)).get(i16)).name;
                }
            } catch (IndexOutOfBoundsException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("ProvinceSelectorView", 2, "", e16);
                }
            }
            return "";
        }
    }

    /* loaded from: classes20.dex */
    class b implements QPickerView.f {
        b() {
        }

        private void a(int i3) {
            ProvinceSelectorView.this.f317413c.setPickListener(null);
            ProvinceSelectorView.this.f317350j[0] = i3;
            ProvinceSelectorView.this.f317349i[0] = (BaseAddress) ((ArrayList) ProvinceSelectorView.this.f317348h.get(0)).get(i3);
            ArrayList<BaseAddress> dataList = ProvinceSelectorView.this.f317349i[0].getDataList();
            if (dataList.size() > 0) {
                ProvinceSelectorView.this.f317348h.set(1, dataList);
                ProvinceSelectorView.this.f317349i[1] = dataList.get(0);
                ProvinceSelectorView.this.f317350j[1] = 0;
                ArrayList<BaseAddress> dataList2 = ProvinceSelectorView.this.f317349i[1].getDataList();
                if (dataList2.size() > 0) {
                    ProvinceSelectorView.this.f317348h.set(2, dataList2);
                    ProvinceSelectorView.this.f317349i[2] = dataList2.get(0);
                    ProvinceSelectorView.this.f317350j[2] = 0;
                } else if (ProvinceSelectorView.this.f317352l == 3) {
                    ProvinceSelectorView.this.f317349i[2] = new NoSelectAddress(3);
                    ProvinceSelectorView.this.f317348h.set(2, null);
                    ProvinceSelectorView.this.f317350j[2] = 0;
                }
            } else if (ProvinceSelectorView.this.f317352l > 1) {
                ProvinceSelectorView.this.f317349i[1] = new NoSelectAddress(2);
                ProvinceSelectorView.this.f317348h.set(1, null);
                ProvinceSelectorView.this.f317350j[1] = 0;
                if (ProvinceSelectorView.this.f317352l == 3) {
                    ProvinceSelectorView.this.f317349i[2] = new NoSelectAddress(3);
                    ProvinceSelectorView.this.f317348h.set(2, null);
                    ProvinceSelectorView.this.f317350j[2] = 0;
                }
            }
            if (ProvinceSelectorView.this.f317352l > 1) {
                ProvinceSelectorView.this.f317413c.m(1);
                ProvinceSelectorView provinceSelectorView = ProvinceSelectorView.this;
                provinceSelectorView.f317413c.setSelection(1, provinceSelectorView.f317350j[1]);
                if (ProvinceSelectorView.this.f317352l == 3) {
                    ProvinceSelectorView.this.f317413c.m(2);
                    ProvinceSelectorView provinceSelectorView2 = ProvinceSelectorView.this;
                    provinceSelectorView2.f317413c.setSelection(2, provinceSelectorView2.f317350j[2]);
                }
            }
            ProvinceSelectorView.this.f317413c.setPickListener(this);
        }

        private void b(int i3) {
            ProvinceSelectorView.this.f317350j[1] = i3;
            ProvinceSelectorView.this.f317413c.setPickListener(null);
            try {
                ProvinceSelectorView.this.f317349i[1] = (BaseAddress) ((ArrayList) ProvinceSelectorView.this.f317348h.get(1)).get(i3);
            } catch (Exception unused) {
                ProvinceSelectorView.this.f317349i[1] = new BaseAddress("", "0", 2);
            }
            ArrayList<BaseAddress> dataList = ProvinceSelectorView.this.f317349i[1].getDataList();
            if (dataList.size() > 0) {
                ProvinceSelectorView.this.f317348h.set(2, dataList);
                ProvinceSelectorView.this.f317349i[2] = dataList.get(0);
                ProvinceSelectorView.this.f317350j[2] = 0;
            } else if (ProvinceSelectorView.this.f317352l > 2) {
                ProvinceSelectorView.this.f317349i[2] = new NoSelectAddress(3);
                ProvinceSelectorView.this.f317348h.set(2, null);
                ProvinceSelectorView.this.f317350j[2] = 0;
            }
            if (ProvinceSelectorView.this.f317352l > 2) {
                ProvinceSelectorView.this.f317413c.m(2);
                ProvinceSelectorView provinceSelectorView = ProvinceSelectorView.this;
                provinceSelectorView.f317413c.setSelection(2, provinceSelectorView.f317350j[2]);
            }
            ProvinceSelectorView.this.f317413c.setPickListener(this);
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.f
        public void onItemSelected(int i3, int i16) {
            ProvinceSelectorView provinceSelectorView = ProvinceSelectorView.this;
            if (provinceSelectorView.f317413c == null) {
                return;
            }
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        provinceSelectorView.y(i16, null);
                        return;
                    }
                    return;
                }
                b(i16);
                return;
            }
            a(i16);
        }
    }

    public ProvinceSelectorView(Context context, boolean z16) {
        super(context, z16);
        this.f317351k = new String[]{"0", "0", "0"};
        this.f317352l = 1;
        this.f317353m = new a();
        b bVar = new b();
        this.f317354n = bVar;
        this.f317355o = false;
        w();
        this.f317355o = z16;
        this.f317413c.setPickListener(bVar);
    }

    private int u(ArrayList<? extends BaseAddress> arrayList, String str) {
        if (arrayList == null) {
            QLog.e("ProvinceSelectorView", 1, "getDateIndex: list is null");
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

    private void w() {
        ArrayList<ArrayList<BaseAddress>> arrayList = new ArrayList<>(3);
        this.f317348h = arrayList;
        arrayList.add(new ArrayList<>());
        this.f317348h.add(new ArrayList<>());
        this.f317348h.add(new ArrayList<>());
    }

    private void x(BaseAddress baseAddress) {
        if (baseAddress == null) {
            return;
        }
        int columnNember = baseAddress.getColumnNember();
        this.f317352l = columnNember;
        this.f317349i = new BaseAddress[columnNember];
        this.f317350j = new int[columnNember];
        if (columnNember == 0) {
            return;
        }
        int i3 = 0;
        for (String str : this.f317351k) {
            if (!"0".equals(str)) {
                this.f317348h.set(i3, baseAddress.getDataList());
                BaseAddress[] baseAddressArr = this.f317349i;
                baseAddress = baseAddress.dataMap.get(str);
                baseAddressArr[i3] = baseAddress;
                this.f317350j[i3] = u(this.f317348h.get(i3), str);
                i3++;
                if (baseAddress == null) {
                    return;
                }
            }
        }
        if (i3 == 0) {
            this.f317348h.set(i3, baseAddress.getDataList());
            this.f317349i[i3] = baseAddress.dataMap.get(0);
            return;
        }
        try {
            if (i3 < this.f317352l) {
                this.f317348h.set(i3, baseAddress.getDataList());
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ProvinceSelectorView", 2, "", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(int i3, ArrayList<BaseAddress> arrayList) {
        if (Collections.emptyList().equals(this.f317348h.get(2))) {
            if (QLog.isColorLevel()) {
                QLog.d("ProvinceSelectorView", 2, "columnListArray at 2 is empty");
            }
        } else {
            arrayList = this.f317348h.get(2);
        }
        if (arrayList != null && i3 < arrayList.size() && i3 >= 0) {
            this.f317349i[2] = arrayList.get(i3);
            this.f317350j[2] = i3;
        }
    }

    public String[] t() {
        BaseAddress[] baseAddressArr = this.f317349i;
        if (baseAddressArr != null && baseAddressArr.length <= 3) {
            String[] strArr = new String[4];
            int i3 = 0;
            strArr[0] = this.f317347g;
            strArr[1] = "0";
            strArr[2] = "0";
            strArr[3] = "0";
            while (true) {
                BaseAddress[] baseAddressArr2 = this.f317349i;
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

    public void v(String str, String[] strArr, BaseAddress baseAddress) {
        this.f317347g = str;
        if (strArr == null) {
            strArr = this.f317351k;
        }
        this.f317351k = strArr;
        if (baseAddress != null) {
            x(baseAddress);
        }
        if (this.f317416f) {
            this.f317413c.j(this.f317353m);
        } else {
            this.f317413c.k(this.f317353m, this.f317355o);
        }
        for (int i3 = 0; i3 < this.f317352l; i3++) {
            this.f317413c.setSelection(i3, this.f317350j[i3]);
        }
        this.f317413c.m(0);
    }
}
