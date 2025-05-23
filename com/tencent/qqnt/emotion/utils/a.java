package com.tencent.qqnt.emotion.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceSupportSize;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes24.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static byte[] a(byte[] bArr) {
        SecurityUtile.xorInLimit(bArr, 0, bArr.length, 0L, 200);
        return bArr;
    }

    public static char[] b(int i3, int i16) {
        return new char[]{(char) (i3 >> 8), (char) (i3 & 255), (char) i16, '\u00ff'};
    }

    public static byte[] c(String str) {
        byte[] d16 = d(str);
        if (d16 != null) {
            return a(d16);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
    
        if (r0 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0030, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x002e, code lost:
    
        if (r0 == null) goto L30;
     */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] d(String str) {
        FileInputStream fileInputStream;
        ?? exists = new File(str).exists();
        FileInputStream fileInputStream2 = null;
        try {
            if (exists != 0) {
                try {
                    fileInputStream = new FileInputStream(new File(str));
                } catch (FileNotFoundException e16) {
                    e = e16;
                    fileInputStream = null;
                } catch (IOException e17) {
                    e = e17;
                    fileInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException unused) {
                        }
                    }
                    throw th;
                }
                try {
                    byte[] bArr = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr);
                    try {
                        fileInputStream.close();
                    } catch (IOException unused2) {
                    }
                    return bArr;
                } catch (FileNotFoundException e18) {
                    e = e18;
                    e.printStackTrace();
                } catch (IOException e19) {
                    e = e19;
                    e.printStackTrace();
                }
            }
            return null;
        } catch (Throwable th6) {
            th = th6;
            fileInputStream2 = exists;
        }
    }

    public static ArrayList<MarketFaceSupportSize> e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ArrayList<MarketFaceSupportSize> arrayList = new ArrayList<>();
            JSONArray jSONArray = new JSONArray(str);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                arrayList.add(new MarketFaceSupportSize(optJSONObject.optInt("Width"), optJSONObject.optInt("Height")));
            }
            return arrayList;
        } catch (JSONException e16) {
            QLog.e("BaseEmosmUtils", 1, "parseMarketFaceSupportSize error! ", e16);
            return null;
        }
    }
}
