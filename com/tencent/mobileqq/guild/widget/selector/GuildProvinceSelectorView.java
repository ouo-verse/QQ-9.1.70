package com.tencent.mobileqq.guild.widget.selector;

import android.app.Activity;
import com.tencent.mobileqq.guild.widget.selector.GuildEditPickerView;
import com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi;
import com.tencent.mobileqq.profilecard.widget.selector.ProvinceSelectorView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.selectorview.model.BaseAddress;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import mqq.app.MobileQQ;

/* loaded from: classes14.dex */
public class GuildProvinceSelectorView extends com.tencent.mobileqq.guild.widget.selector.a {

    /* renamed from: e, reason: collision with root package name */
    private String f236591e;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<ArrayList<BaseAddress>> f236592f;

    /* renamed from: g, reason: collision with root package name */
    private BaseAddress[] f236593g;

    /* renamed from: h, reason: collision with root package name */
    private int[] f236594h;

    /* renamed from: i, reason: collision with root package name */
    private String[] f236595i;

    /* renamed from: j, reason: collision with root package name */
    private int f236596j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f236597k;

    /* renamed from: l, reason: collision with root package name */
    private final GuildEditPickerView.e f236598l;

    /* renamed from: m, reason: collision with root package name */
    private final GuildEditPickerView.f f236599m;

    /* loaded from: classes14.dex */
    public static final class NoSelectAddress extends BaseAddress {
        public NoSelectAddress(String str, String str2, int i3) {
            super(str, str2, i3);
        }

        public NoSelectAddress(int i3) {
            this("", "0", i3);
        }
    }

    /* loaded from: classes14.dex */
    class a implements GuildEditPickerView.e {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.widget.selector.GuildEditPickerView.e
        public int getColumnCount() {
            return GuildProvinceSelectorView.this.f236596j;
        }

        @Override // com.tencent.mobileqq.guild.widget.selector.GuildEditPickerView.e
        public int getRowCount(int i3) {
            if (i3 < 0 || i3 >= GuildProvinceSelectorView.this.f236592f.size() || GuildProvinceSelectorView.this.f236592f.get(i3) == null) {
                return 0;
            }
            return ((ArrayList) GuildProvinceSelectorView.this.f236592f.get(i3)).size();
        }

        @Override // com.tencent.mobileqq.guild.widget.selector.GuildEditPickerView.e
        public String getText(int i3, int i16) {
            try {
                if (GuildProvinceSelectorView.this.f236592f.get(i3) != null) {
                    if (((BaseAddress) ((ArrayList) GuildProvinceSelectorView.this.f236592f.get(i3)).get(i16)).code.equals("0")) {
                        return ProvinceSelectorView.NAME_NO_SELECT_PROFILE;
                    }
                    return ((BaseAddress) ((ArrayList) GuildProvinceSelectorView.this.f236592f.get(i3)).get(i16)).name;
                }
            } catch (IndexOutOfBoundsException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("ProvinceSelectorView", 2, "", e16);
                }
            }
            return "";
        }
    }

    /* loaded from: classes14.dex */
    class b implements GuildEditPickerView.f {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.widget.selector.GuildEditPickerView.f
        public void onItemSelected(int i3, int i16) {
            GuildProvinceSelectorView guildProvinceSelectorView = GuildProvinceSelectorView.this;
            GuildEditPickerView guildEditPickerView = guildProvinceSelectorView.f236605c;
            if (guildEditPickerView == null) {
                return;
            }
            ArrayList arrayList = null;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        if (Collections.emptyList().equals(GuildProvinceSelectorView.this.f236592f.get(2))) {
                            if (QLog.isColorLevel()) {
                                QLog.d("ProvinceSelectorView", 2, "columnListArray at 2 is empty");
                            }
                        } else {
                            arrayList = (ArrayList) GuildProvinceSelectorView.this.f236592f.get(2);
                        }
                        if (arrayList != null && i16 < arrayList.size() && i16 >= 0) {
                            GuildProvinceSelectorView.this.f236593g[2] = (BaseAddress) arrayList.get(i16);
                            GuildProvinceSelectorView.this.f236594h[2] = i16;
                            return;
                        }
                        return;
                    }
                    return;
                }
                guildProvinceSelectorView.f236594h[1] = i16;
                GuildProvinceSelectorView.this.f236605c.setPickListener(null);
                try {
                    GuildProvinceSelectorView.this.f236593g[1] = (BaseAddress) ((ArrayList) GuildProvinceSelectorView.this.f236592f.get(1)).get(i16);
                } catch (Exception unused) {
                    GuildProvinceSelectorView.this.f236593g[1] = new BaseAddress("", "0", 2);
                }
                ArrayList<BaseAddress> dataList = GuildProvinceSelectorView.this.f236593g[1].getDataList();
                if (dataList.size() > 0 && !"1".equals(GuildProvinceSelectorView.this.f236591e)) {
                    GuildProvinceSelectorView.this.f236592f.set(2, dataList);
                    GuildProvinceSelectorView.this.f236593g[2] = dataList.get(0);
                    GuildProvinceSelectorView.this.f236594h[2] = 0;
                } else if (GuildProvinceSelectorView.this.f236596j > 2) {
                    GuildProvinceSelectorView.this.f236593g[2] = new NoSelectAddress(3);
                    GuildProvinceSelectorView.this.f236592f.set(2, null);
                    GuildProvinceSelectorView.this.f236594h[2] = 0;
                }
                if (GuildProvinceSelectorView.this.f236596j > 2) {
                    GuildProvinceSelectorView.this.f236605c.l(2);
                    GuildProvinceSelectorView guildProvinceSelectorView2 = GuildProvinceSelectorView.this;
                    guildProvinceSelectorView2.f236605c.setSelection(2, guildProvinceSelectorView2.f236594h[2]);
                }
                GuildProvinceSelectorView.this.f236605c.setPickListener(this);
                return;
            }
            guildEditPickerView.setPickListener(null);
            GuildProvinceSelectorView.this.f236594h[0] = i16;
            GuildProvinceSelectorView.this.f236593g[0] = (BaseAddress) ((ArrayList) GuildProvinceSelectorView.this.f236592f.get(0)).get(i16);
            ArrayList<BaseAddress> dataList2 = GuildProvinceSelectorView.this.f236593g[0].getDataList();
            if (dataList2.size() > 0) {
                GuildProvinceSelectorView.this.f236592f.set(1, dataList2);
                GuildProvinceSelectorView.this.f236593g[1] = dataList2.get(0);
                GuildProvinceSelectorView.this.f236594h[1] = 0;
                ArrayList<BaseAddress> dataList3 = GuildProvinceSelectorView.this.f236593g[1].getDataList();
                if (dataList3.size() > 0) {
                    GuildProvinceSelectorView.this.f236592f.set(2, dataList3);
                    GuildProvinceSelectorView.this.f236593g[2] = dataList3.get(0);
                    GuildProvinceSelectorView.this.f236594h[2] = 0;
                } else if (GuildProvinceSelectorView.this.f236596j == 3) {
                    GuildProvinceSelectorView.this.f236593g[2] = new NoSelectAddress(3);
                    GuildProvinceSelectorView.this.f236592f.set(2, null);
                    GuildProvinceSelectorView.this.f236594h[2] = 0;
                }
            } else if (GuildProvinceSelectorView.this.f236596j > 1) {
                GuildProvinceSelectorView.this.f236593g[1] = new NoSelectAddress(2);
                GuildProvinceSelectorView.this.f236592f.set(1, null);
                GuildProvinceSelectorView.this.f236594h[1] = 0;
                if (GuildProvinceSelectorView.this.f236596j == 3) {
                    GuildProvinceSelectorView.this.f236593g[2] = new NoSelectAddress(3);
                    GuildProvinceSelectorView.this.f236592f.set(2, null);
                    GuildProvinceSelectorView.this.f236594h[2] = 0;
                }
            }
            if (GuildProvinceSelectorView.this.f236596j > 1) {
                GuildProvinceSelectorView.this.f236605c.l(1);
                GuildProvinceSelectorView guildProvinceSelectorView3 = GuildProvinceSelectorView.this;
                guildProvinceSelectorView3.f236605c.setSelection(1, guildProvinceSelectorView3.f236594h[1]);
                if (GuildProvinceSelectorView.this.f236596j == 3) {
                    GuildProvinceSelectorView.this.f236605c.l(2);
                    GuildProvinceSelectorView guildProvinceSelectorView4 = GuildProvinceSelectorView.this;
                    guildProvinceSelectorView4.f236605c.setSelection(2, guildProvinceSelectorView4.f236594h[2]);
                }
            }
            GuildProvinceSelectorView.this.f236605c.setPickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class c implements IProfileEditBusinessApi.OnAreaInfoLoadedListener {
        c() {
        }

        @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi.OnAreaInfoLoadedListener
        public void onAreaInfoLoaded(Object obj) {
            if (!(obj instanceof BaseAddress)) {
                QLog.e("ProvinceSelectorView", 1, "getAreaInfo fail: info is not a subtype of BaseAddress");
                return;
            }
            BaseAddress baseAddress = (BaseAddress) obj;
            if ("1".equals(baseAddress.code)) {
                baseAddress.hasDistrict = false;
            }
            GuildProvinceSelectorView.this.p(baseAddress);
        }
    }

    public GuildProvinceSelectorView(Activity activity, boolean z16) {
        super(activity, z16);
        this.f236595i = new String[]{"0", "0", "0"};
        this.f236596j = 1;
        this.f236597k = false;
        this.f236598l = new a();
        b bVar = new b();
        this.f236599m = bVar;
        o();
        this.f236597k = z16;
        this.f236605c.setPickListener(bVar);
    }

    private void k() {
        ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).loadProvinceInfo(MobileQQ.sMobileQQ.waitAppRuntime(null), this.f236591e, new c());
    }

    private int m(ArrayList<? extends BaseAddress> arrayList, String str) {
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

    private void o() {
        ArrayList<ArrayList<BaseAddress>> arrayList = new ArrayList<>(3);
        this.f236592f = arrayList;
        arrayList.add(new ArrayList<>());
        this.f236592f.add(new ArrayList<>());
        this.f236592f.add(new ArrayList<>());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(BaseAddress baseAddress) {
        if (baseAddress == null) {
            return;
        }
        int columnNember = baseAddress.getColumnNember();
        this.f236596j = columnNember;
        this.f236593g = new BaseAddress[columnNember];
        this.f236594h = new int[columnNember];
        if (columnNember == 0) {
            return;
        }
        int i3 = 0;
        for (String str : this.f236595i) {
            if (!"0".equals(str)) {
                this.f236592f.set(i3, baseAddress.getDataList());
                BaseAddress[] baseAddressArr = this.f236593g;
                baseAddress = baseAddress.dataMap.get(str);
                baseAddressArr[i3] = baseAddress;
                this.f236594h[i3] = m(this.f236592f.get(i3), str);
                i3++;
                if (baseAddress == null) {
                    return;
                }
            }
        }
        if (i3 == 0) {
            this.f236592f.set(i3, baseAddress.getDataList());
            this.f236593g[i3] = baseAddress.dataMap.get(0);
            return;
        }
        try {
            if (i3 < this.f236596j) {
                this.f236592f.set(i3, baseAddress.getDataList());
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ProvinceSelectorView", 2, "", e16);
            }
        }
    }

    public String[] l() {
        BaseAddress[] baseAddressArr = this.f236593g;
        if (baseAddressArr != null && baseAddressArr.length <= 3) {
            String[] strArr = new String[4];
            int i3 = 0;
            strArr[0] = this.f236591e;
            strArr[1] = "0";
            strArr[2] = "0";
            strArr[3] = "0";
            while (true) {
                BaseAddress[] baseAddressArr2 = this.f236593g;
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

    public void n(String str, String[] strArr) {
        this.f236591e = str;
        if (strArr == null) {
            strArr = this.f236595i;
        }
        this.f236595i = strArr;
        k();
        this.f236605c.k(this.f236598l, this.f236597k);
        if (this.f236594h != null) {
            for (int i3 = 0; i3 < this.f236596j; i3++) {
                this.f236605c.setSelection(i3, this.f236594h[i3]);
            }
        }
        this.f236605c.l(0);
    }
}
