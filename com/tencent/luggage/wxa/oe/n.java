package com.tencent.luggage.wxa.oe;

import android.os.ParcelUuid;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public final int f136429a;

    /* renamed from: b, reason: collision with root package name */
    public final List f136430b;

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f136431c;

    /* renamed from: d, reason: collision with root package name */
    public final Map f136432d;

    /* renamed from: e, reason: collision with root package name */
    public final int f136433e;

    /* renamed from: f, reason: collision with root package name */
    public final String f136434f;

    /* renamed from: g, reason: collision with root package name */
    public final byte[] f136435g;

    /* renamed from: h, reason: collision with root package name */
    public final LinkedHashMap f136436h;

    public n(List list, Map map, int i3, int i16, String str, byte[] bArr, LinkedHashMap linkedHashMap) {
        this.f136430b = list;
        this.f136431c = linkedHashMap;
        this.f136432d = map;
        this.f136434f = str;
        this.f136429a = i3;
        this.f136433e = i16;
        this.f136435g = bArr;
        this.f136436h = linkedHashMap;
    }

    public byte[] a(ParcelUuid parcelUuid) {
        if (parcelUuid == null) {
            return null;
        }
        return (byte[]) this.f136432d.get(parcelUuid);
    }

    public String b() {
        return this.f136434f;
    }

    public LinkedHashMap c() {
        return this.f136431c;
    }

    public LinkedHashMap d() {
        return this.f136436h;
    }

    public Map e() {
        return this.f136432d;
    }

    public List f() {
        return this.f136430b;
    }

    public String toString() {
        return "ScanRecord [mAdvertiseFlags=" + this.f136429a + ", mServiceUuids=" + this.f136430b + ", mServiceData=" + a(this.f136432d) + ", mTxPowerLevel=" + this.f136433e + ", mDeviceName=" + this.f136434f + ", mManufacturerSpecificDataFixed=" + a(this.f136436h) + "]";
    }

    public byte[] a() {
        return this.f136435g;
    }

    public byte[] a(int i3) {
        return (byte[]) this.f136436h.get(Integer.valueOf(i3));
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static n a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayMap arrayMap = new ArrayMap();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str = null;
        byte b16 = -2147483648;
        int i3 = -1;
        int i16 = 0;
        while (i16 < bArr.length) {
            try {
                int i17 = i16 + 1;
                int i18 = bArr[i16] & 255;
                if (i18 != 0) {
                    int i19 = i18 - 1;
                    int i26 = i17 + 1;
                    int i27 = bArr[i17] & 255;
                    if (i27 == 22) {
                        arrayMap.put(e.a(a(bArr, i26, 2)), a(bArr, i26 + 2, i19 - 2));
                    } else if (i27 != 255) {
                        switch (i27) {
                            case 1:
                                i3 = bArr[i26] & 255;
                                break;
                            case 2:
                            case 3:
                                a(bArr, i26, i19, 2, arrayList);
                                break;
                            case 4:
                            case 5:
                                a(bArr, i26, i19, 4, arrayList);
                                break;
                            case 6:
                            case 7:
                                a(bArr, i26, i19, 16, arrayList);
                                break;
                            case 8:
                            case 9:
                                str = new String(a(bArr, i26, i19));
                                break;
                            case 10:
                                b16 = bArr[i26];
                                break;
                        }
                    } else {
                        int i28 = ((bArr[i26 + 1] & 255) << 8) + (255 & bArr[i26]);
                        byte[] a16 = a(bArr, i26 + 2, i19 - 2);
                        byte[] bArr2 = (byte[]) linkedHashMap.get(Integer.valueOf(i28));
                        if (bArr2 != null) {
                            byte[] bArr3 = new byte[bArr2.length + a16.length];
                            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
                            System.arraycopy(a16, 0, bArr3, bArr2.length, a16.length);
                            linkedHashMap.put(Integer.valueOf(i28), bArr3);
                        } else {
                            linkedHashMap.put(Integer.valueOf(i28), a16);
                        }
                    }
                    i16 = i19 + i26;
                } else {
                    return new n(!arrayList.isEmpty() ? null : arrayList, arrayMap, i3, b16, str, bArr, linkedHashMap);
                }
            } catch (Exception unused) {
                Log.e("ScanRecordCompat", "unable to parse scan record: " + Arrays.toString(bArr));
                return new n(null, null, -1, Integer.MIN_VALUE, null, bArr, linkedHashMap);
            }
        }
        return new n(!arrayList.isEmpty() ? null : arrayList, arrayMap, i3, b16, str, bArr, linkedHashMap);
    }

    public static int a(byte[] bArr, int i3, int i16, int i17, List list) {
        while (i16 > 0) {
            list.add(e.a(a(bArr, i3, i17)));
            i16 -= i17;
            i3 += i17;
        }
        return i3;
    }

    public static byte[] a(byte[] bArr, int i3, int i16) {
        byte[] bArr2 = new byte[i16];
        System.arraycopy(bArr, i3, bArr2, 0, i16);
        return bArr2;
    }

    public static String a(Map map) {
        if (map == null) {
            return "null";
        }
        if (map.isEmpty()) {
            return "{}";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append('{');
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Object key = ((Map.Entry) it.next()).getKey();
            sb5.append(key);
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(Arrays.toString((byte[]) map.get(key)));
            if (it.hasNext()) {
                sb5.append(", ");
            }
        }
        sb5.append('}');
        return sb5.toString();
    }
}
