package com.tenpay.ndk;

import android.content.Context;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Md5EncUtil {
    private byte[] enc_buf;
    private byte[] raw_buf;

    public Md5EncUtil(Context context) {
        CftSoLoader.loadSo(context);
    }

    private native boolean encryptDd5(int i3, byte[] bArr);

    public boolean encryptMd5(int i3, String str) {
        synchronized (CftSoLoader.lock) {
            if (str.length() <= 0) {
                return false;
            }
            try {
                byte[] bytes = str.getBytes("UTF-8");
                this.raw_buf = bytes;
                return encryptDd5(i3, bytes);
            } catch (Exception unused) {
                return false;
            }
        }
    }

    public String getMd5Sign() {
        synchronized (CftSoLoader.lock) {
            byte[] bArr = this.enc_buf;
            if (bArr == null) {
                return null;
            }
            try {
                return new String(bArr, "UTF-8").toUpperCase();
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public String sortConstructVars(HashMap<String, String> hashMap) {
        String str;
        synchronized (CftSoLoader.lock) {
            str = "";
            LinkedList<Map.Entry> linkedList = new LinkedList(hashMap.entrySet());
            Collections.sort(linkedList, new Comparator() { // from class: com.tenpay.ndk.Md5EncUtil.1
                @Override // java.util.Comparator
                public int compare(Object obj, Object obj2) {
                    return ((Map.Entry) obj).getKey().toString().compareTo(((Map.Entry) obj2).getKey().toString());
                }
            });
            boolean z16 = true;
            for (Map.Entry entry : linkedList) {
                if (entry.getKey().toString().length() > 0 && entry.getValue().toString().length() > 0) {
                    if (z16) {
                        str = (entry.getKey().toString() + ContainerUtils.KEY_VALUE_DELIMITER) + entry.getValue().toString();
                        z16 = false;
                    } else {
                        str = (((str + ContainerUtils.FIELD_DELIMITER) + entry.getKey().toString()) + ContainerUtils.KEY_VALUE_DELIMITER) + entry.getValue().toString();
                    }
                }
            }
        }
        return str;
    }
}
