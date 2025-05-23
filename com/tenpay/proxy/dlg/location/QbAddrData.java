package com.tenpay.proxy.dlg.location;

import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.StringUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QbAddrData {
    public static final char DATA_SPLITER = '|';
    public static final String DEFAULT_CODE = "0";
    public static final String TAG = "QbAddressData";
    public HashMap<String, QbBaseAddr> countryMap = new HashMap<>(30);
    public static final String END_TAG = HardCodeUtil.qqStr(R.string.prv);
    public static final String DEFAULT_NAME = HardCodeUtil.qqStr(R.string.prw);

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class NoLimitAddress extends QbBaseAddr {
        public NoLimitAddress(String str, String str2, int i3) {
            super(str, str2, i3);
        }

        public NoLimitAddress(int i3) {
            this(QbAddrData.DEFAULT_NAME, "0", i3);
        }
    }

    private boolean assertDuplicate(String str, Map<String, QbBaseAddr> map) {
        Iterator it = new ArrayList(map.values()).iterator();
        while (it.hasNext()) {
            if (str.equals(((QbBaseAddr) it.next()).name)) {
                return false;
            }
        }
        return true;
    }

    private int getAddressTypeByIndex(int i3) {
        switch (i3) {
            case 2:
            case 3:
                return 1;
            case 4:
            case 5:
                return 2;
            case 6:
            case 7:
                return 3;
            default:
                return 0;
        }
    }

    private int getNextIndex(int i3, int i16, String[] strArr) {
        while (i3 < i16) {
            int i17 = i3 + 1;
            if (!TextUtils.isEmpty(strArr[i3])) {
                i3 = i17 + 1;
                if (!TextUtils.isEmpty(strArr[i17])) {
                    return i3 - 2;
                }
            } else {
                i3 = i17;
            }
            if (i3 >= i16 - 1) {
                return -1;
            }
        }
        return -1;
    }

    public void destory() {
        HashMap<String, QbBaseAddr> hashMap = this.countryMap;
        if (hashMap != null) {
            hashMap.clear();
            this.countryMap = null;
        }
    }

    public boolean insertData(String str) {
        if (str.startsWith(END_TAG)) {
            return false;
        }
        String[] split = StringUtil.split(str, DATA_SPLITER);
        if (str.startsWith("#") || split.length < 2 || !"1".equals(split[0])) {
            return true;
        }
        int length = split.length;
        String str2 = split[0];
        String str3 = split[1];
        QbBaseAddr qbBaseAddr = this.countryMap.get(str2);
        if (qbBaseAddr == null) {
            qbBaseAddr = new QbBaseAddr(str3, str2, getAddressTypeByIndex(1));
            this.countryMap.put(str2, qbBaseAddr);
        }
        int nextIndex = getNextIndex(2, length, split);
        if (nextIndex == -1) {
            return true;
        }
        int i3 = nextIndex + 1;
        String str4 = split[nextIndex];
        int i16 = i3 + 1;
        String str5 = split[i3];
        QbBaseAddr qbBaseAddr2 = qbBaseAddr.dataMap.get(str4);
        if (qbBaseAddr2 == null) {
            QbBaseAddr qbBaseAddr3 = new QbBaseAddr(str5, str4, getAddressTypeByIndex(i16 - 1));
            qbBaseAddr.dataMap.put(str4, qbBaseAddr3);
            qbBaseAddr.hasProvince = true;
            qbBaseAddr2 = qbBaseAddr3;
        }
        int nextIndex2 = getNextIndex(i16, length, split);
        if (nextIndex2 == -1) {
            return true;
        }
        int i17 = nextIndex2 + 1;
        String str6 = split[nextIndex2];
        int i18 = i17 + 1;
        String str7 = split[i17];
        QbBaseAddr qbBaseAddr4 = qbBaseAddr2.dataMap.get(str6);
        if (qbBaseAddr4 == null) {
            QbBaseAddr qbBaseAddr5 = new QbBaseAddr(str7, str6, getAddressTypeByIndex(i18 - 1));
            qbBaseAddr2.dataMap.put(str6, qbBaseAddr5);
            qbBaseAddr.hasCity = true;
            qbBaseAddr4 = qbBaseAddr5;
        }
        int nextIndex3 = getNextIndex(i18, length, split);
        if (nextIndex3 == -1) {
            return true;
        }
        int i19 = nextIndex3 + 1;
        String str8 = split[nextIndex3];
        int i26 = i19 + 1;
        String str9 = split[i19];
        if (qbBaseAddr4.dataMap.get(str8) == null) {
            qbBaseAddr4.dataMap.put(str8, new QbBaseAddr(str9, str8, getAddressTypeByIndex(i26 - 1)));
            qbBaseAddr.hasDistrict = true;
        }
        return true;
    }
}
