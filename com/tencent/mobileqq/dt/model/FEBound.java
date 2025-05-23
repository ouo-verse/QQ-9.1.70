package com.tencent.mobileqq.dt.model;

import com.tencent.mobileqq.fe.FEKit;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jf.dexlib2.analysis.RegisterType;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class FEBound {
    static IPatchRedirector $redirector_ = null;
    private static final int LEVEL1 = 32;
    private static final int LEVEL2 = 16;
    private static final String TAG = "FEBound";
    private static final int Type_Decode = 2;
    private static final int Type_Encode = 1;
    private static byte[][] mConfigDeCode;
    private static byte[][] mConfigEnCode;
    private static AtomicBoolean mInit;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12916);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        mInit = new AtomicBoolean(false);
        mConfigEnCode = new byte[][]{new byte[]{RegisterType.DOUBLE_LO, 1, 13, 10, 2, 7, 6, 5, 0, 12, 4, 8, 11, 9, RegisterType.DOUBLE_HI, 3}, new byte[]{10, 0, 12, 6, 9, 4, 8, RegisterType.DOUBLE_HI, 3, 7, 13, 5, RegisterType.DOUBLE_LO, 11, 1, 2}, new byte[]{6, 2, 0, 13, 4, 10, RegisterType.DOUBLE_LO, 11, RegisterType.DOUBLE_HI, 1, 12, 3, 9, 5, 8, 7}, new byte[]{2, 10, 4, 8, RegisterType.DOUBLE_HI, RegisterType.DOUBLE_LO, 0, 3, 13, 12, 11, 6, 7, 5, 1, 9}, new byte[]{RegisterType.DOUBLE_LO, 3, 11, 12, 0, 6, 9, 13, 8, 4, 7, 1, 2, RegisterType.DOUBLE_HI, 10, 5}, new byte[]{10, 11, 5, 4, 8, 12, 13, 0, RegisterType.DOUBLE_HI, 7, 1, 9, 2, 6, 3, RegisterType.DOUBLE_LO}, new byte[]{7, 1, 9, RegisterType.DOUBLE_LO, 3, 5, 11, 13, 6, 2, 12, 10, 0, RegisterType.DOUBLE_HI, 4, 8}, new byte[]{3, 10, 0, 5, 6, 7, 11, 2, 4, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, 1, 12, 8, 13, 9}, new byte[]{RegisterType.DOUBLE_HI, 2, RegisterType.DOUBLE_LO, 13, 1, 0, 4, 7, 5, 3, 9, 10, 8, 6, 11, 12}, new byte[]{11, 10, 8, 4, 6, 0, 12, 5, 7, 9, 13, 2, 1, 3, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI}, new byte[]{7, 3, 1, 12, RegisterType.DOUBLE_LO, 8, 10, 5, 6, 13, 11, RegisterType.DOUBLE_HI, 4, 9, 2, 0}, new byte[]{3, 11, 13, 0, 6, 5, 7, 8, 9, 1, RegisterType.DOUBLE_HI, RegisterType.DOUBLE_LO, 12, 10, 2, 4}, new byte[]{RegisterType.DOUBLE_HI, 3, 7, 11, RegisterType.DOUBLE_LO, 5, 12, 2, 13, 4, 10, 0, 1, 8, 9, 6}, new byte[]{11, 12, 2, 3, 5, RegisterType.DOUBLE_LO, 1, RegisterType.DOUBLE_HI, 7, 10, 4, 8, 9, 6, 13, 0}, new byte[]{7, 4, 12, 10, 13, 11, 8, 2, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, 0, 6, 3, 1, 5, 9}, new byte[]{3, 12, 7, 4, 2, 8, 13, 9, 6, 11, 10, RegisterType.DOUBLE_LO, 0, RegisterType.DOUBLE_HI, 1, 5}, new byte[]{0, 3, 10, 11, 1, 12, 9, 4, 7, 6, RegisterType.DOUBLE_HI, 5, 13, 2, RegisterType.DOUBLE_LO, 8}, new byte[]{12, 11, 5, 3, 13, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, 6, 4, 8, 9, 10, 2, 7, 1, 0}, new byte[]{8, 3, RegisterType.DOUBLE_HI, 10, 11, 4, 9, 13, 1, 7, 6, RegisterType.DOUBLE_LO, 5, 0, 12, 2}, new byte[]{4, 12, 10, 6, 13, 9, 5, 7, 2, 8, 11, 0, 3, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, 1}, new byte[]{0, 4, 1, 10, 11, 5, 6, RegisterType.DOUBLE_HI, 13, 9, 3, 2, 8, RegisterType.DOUBLE_LO, 12, 7}, new byte[]{12, 0, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, 9, 1, 3, 13, 2, 4, 7, 6, 10, 8, 11, 5}, new byte[]{8, 5, 9, 2, 10, RegisterType.DOUBLE_LO, 11, 13, 7, 0, 1, 12, 6, 3, RegisterType.DOUBLE_HI, 4}, new byte[]{4, 13, 3, 9, 5, 1, 11, 2, 6, 8, 10, 0, RegisterType.DOUBLE_HI, RegisterType.DOUBLE_LO, 7, 12}, new byte[]{0, 5, RegisterType.DOUBLE_LO, 8, 10, 3, 2, 7, 13, 1, 11, 12, 9, RegisterType.DOUBLE_HI, 6, 4}, new byte[]{13, 12, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, 7, 1, 9, 2, 11, 5, 8, 10, 3, 0, 4, 6}, new byte[]{9, 4, 12, 0, 8, RegisterType.DOUBLE_LO, 1, 3, 11, 6, 5, 13, 10, 2, RegisterType.DOUBLE_HI, 7}, new byte[]{5, 12, 6, RegisterType.DOUBLE_HI, 10, 13, RegisterType.DOUBLE_LO, 3, 9, 8, 2, 11, 0, 1, 7, 4}, new byte[]{1, 5, 7, 2, 6, 11, 4, 13, 3, 10, 0, 9, RegisterType.DOUBLE_HI, RegisterType.DOUBLE_LO, 12, 8}, new byte[]{13, 0, 11, RegisterType.DOUBLE_HI, 8, 4, 9, 3, 1, 5, RegisterType.DOUBLE_LO, 10, 7, 2, 6, 12}, new byte[]{9, 5, 6, 7, 3, RegisterType.DOUBLE_HI, RegisterType.DOUBLE_LO, 4, 2, 8, 13, 0, 1, 11, 10, 12}, new byte[]{5, RegisterType.DOUBLE_LO, 1, 2, 13, 0, 7, 12, 9, 11, 8, 4, 3, 10, 6, RegisterType.DOUBLE_HI}};
        mConfigDeCode = new byte[][]{new byte[]{11, RegisterType.DOUBLE_HI, 6, 12, 5, 4, 1, 8, 13, 7, 3, RegisterType.DOUBLE_LO, 0, 9, 2, 10}, new byte[]{RegisterType.DOUBLE_LO, 4, 10, 7, RegisterType.DOUBLE_HI, 13, 8, 5, 0, 2, 12, 6, 3, 11, 1, 9}, new byte[]{9, 10, RegisterType.DOUBLE_HI, 2, 0, 4, 1, 8, 13, 3, 7, 11, 5, 12, 6, RegisterType.DOUBLE_LO}, new byte[]{6, 0, 12, 3, 7, 5, RegisterType.DOUBLE_HI, 2, 13, 10, 11, 4, 8, 1, RegisterType.DOUBLE_LO, 9}, new byte[]{4, 8, 13, 6, 5, 1, 3, 12, 11, 2, 7, RegisterType.DOUBLE_HI, RegisterType.DOUBLE_LO, 0, 10, 9}, new byte[]{3, 7, RegisterType.DOUBLE_HI, 11, 5, 9, 13, 12, 6, 0, RegisterType.DOUBLE_LO, 10, 2, 1, 4, 8}, new byte[]{7, 2, 8, 6, 11, 0, 1, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, 3, 9, 4, 13, 5, 12, 10}, new byte[]{10, 0, 12, 5, 9, 13, 3, RegisterType.DOUBLE_LO, 2, 4, RegisterType.DOUBLE_HI, 6, 7, 8, 1, 11}, new byte[]{4, 2, 5, RegisterType.DOUBLE_LO, 1, 13, 7, 11, 10, 12, 6, 3, 9, 8, 0, RegisterType.DOUBLE_HI}, new byte[]{7, 6, 11, RegisterType.DOUBLE_HI, 12, 5, RegisterType.DOUBLE_LO, 3, 9, 10, 0, 8, 13, 1, 4, 2}, new byte[]{7, 6, RegisterType.DOUBLE_HI, 4, 8, 1, 0, 11, 9, 2, 3, 5, 13, RegisterType.DOUBLE_LO, 10, 12}, new byte[]{6, 10, 0, 4, 2, 9, 11, 3, 7, 13, 12, RegisterType.DOUBLE_HI, 8, 1, RegisterType.DOUBLE_LO, 5}, new byte[]{2, 6, 9, 10, 4, 7, 1, 5, 8, 3, 13, 12, RegisterType.DOUBLE_HI, 11, 0, RegisterType.DOUBLE_LO}, new byte[]{5, 12, 9, 11, 13, 7, 3, RegisterType.DOUBLE_LO, 2, 6, 0, 10, 4, 8, 1, RegisterType.DOUBLE_HI}, new byte[]{1, RegisterType.DOUBLE_LO, 8, 2, 6, 11, 0, 12, 3, 7, 9, RegisterType.DOUBLE_HI, 10, 13, 5, 4}, new byte[]{7, RegisterType.DOUBLE_LO, 0, 8, 10, 13, 3, 6, RegisterType.DOUBLE_HI, 5, 4, 11, 12, 2, 9, 1}, new byte[]{11, 3, 5, 9, 10, 13, 8, 1, 2, 12, 7, RegisterType.DOUBLE_HI, 6, RegisterType.DOUBLE_LO, 0, 4}, new byte[]{11, 3, 2, 9, 7, 5, 6, 4, 12, RegisterType.DOUBLE_LO, 0, 8, 13, RegisterType.DOUBLE_HI, 10, 1}, new byte[]{RegisterType.DOUBLE_HI, 12, 9, 13, 10, 1, 2, 0, 3, 11, 8, 6, RegisterType.DOUBLE_LO, 4, 5, 7}, new byte[]{7, 9, 6, 0, 3, RegisterType.DOUBLE_LO, 11, 10, 13, 8, 4, 12, 5, RegisterType.DOUBLE_HI, 1, 2}, new byte[]{13, 10, 12, 5, RegisterType.DOUBLE_HI, RegisterType.DOUBLE_LO, 1, 6, 3, 9, 7, 2, 8, 4, 11, 0}, new byte[]{10, 3, 5, 8, 4, 2, 9, RegisterType.DOUBLE_HI, 7, 11, 13, 0, RegisterType.DOUBLE_LO, 6, 12, 1}, new byte[]{1, 3, RegisterType.DOUBLE_LO, 11, RegisterType.DOUBLE_HI, 7, 9, 0, 8, 12, 13, 5, 4, 10, 6, 2}, new byte[]{5, 10, RegisterType.DOUBLE_LO, 0, 4, 9, 12, 8, 13, 6, 2, 7, RegisterType.DOUBLE_HI, 11, 3, 1}, new byte[]{6, RegisterType.DOUBLE_HI, 8, 7, 2, 12, 3, 11, 1, 10, 9, 5, 4, 13, RegisterType.DOUBLE_LO, 0}, new byte[]{9, 8, 12, 3, RegisterType.DOUBLE_HI, RegisterType.DOUBLE_LO, 7, 4, 10, 6, 5, 0, 2, 13, 1, 11}, new byte[]{RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, 7, 8, 11, 3, 9, 0, 1, 2, 5, 6, 4, 13, 12, 10}, new byte[]{9, 10, 4, 5, 0, RegisterType.DOUBLE_LO, 13, 6, 7, 12, 11, 8, RegisterType.DOUBLE_HI, 2, 1, 3}, new byte[]{0, 2, 12, 6, 10, RegisterType.DOUBLE_HI, 3, 1, 9, 8, 4, 5, RegisterType.DOUBLE_LO, 11, 7, 13}, new byte[]{6, 7, 2, RegisterType.DOUBLE_LO, 12, 9, 4, RegisterType.DOUBLE_HI, 8, 11, 10, 5, 0, 13, 3, 1}, new byte[]{10, 5, 12, 13, 6, 3, RegisterType.DOUBLE_HI, 1, 0, 4, 9, 11, 2, RegisterType.DOUBLE_LO, 8, 7}, new byte[]{6, 4, 5, 12, 0, 7, 1, RegisterType.DOUBLE_HI, 13, 11, 10, RegisterType.DOUBLE_LO, 2, 8, 9, 3}};
    }

    public FEBound() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void initAssertConfig() {
        try {
            InputStream open = FEKit.getInstance().getContext().getAssets().open("qsec/dtconfig.json");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            JSONObject jSONObject = new JSONObject(new String(bArr, "utf8"));
            parseConfig(jSONObject, "en", mConfigEnCode);
            parseConfig(jSONObject, "de", mConfigDeCode);
            open.close();
        } catch (Throwable th5) {
            com.tencent.mobileqq.fe.c.a(TAG, 1, "read asset json failed" + th5);
        }
    }

    private static void parseConfig(JSONObject jSONObject, String str, byte[][] bArr) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray.length() != 32) {
            com.tencent.mobileqq.fe.c.a(TAG, 1, "config file error!");
            return;
        }
        for (int i3 = 0; i3 < 32; i3++) {
            JSONArray optJSONArray2 = optJSONArray.optJSONArray(i3);
            if (optJSONArray2 != null && optJSONArray2.length() == 16) {
                for (int i16 = 0; i16 < 16; i16++) {
                    bArr[i3][i16] = (byte) optJSONArray2.optInt(i16);
                }
            } else {
                com.tencent.mobileqq.fe.c.a(TAG, 1, "config file error!");
                return;
            }
        }
    }

    public static byte[] transform(int i3, byte[] bArr) {
        try {
            byte[] bArr2 = new byte[bArr.length];
            byte[][] bArr3 = mConfigEnCode;
            if (bArr3.length == 32 && i3 == 1) {
                transformInner(bArr, bArr2, bArr3);
            } else {
                byte[][] bArr4 = mConfigDeCode;
                if (bArr4.length == 32 && i3 == 2) {
                    transformInner(bArr, bArr2, bArr4);
                } else {
                    com.tencent.mobileqq.fe.c.a(TAG, 1, "transform error!");
                }
            }
            return bArr2;
        } catch (Throwable th5) {
            com.tencent.mobileqq.fe.c.a(TAG, 1, "encode error!" + th5);
            return null;
        }
    }

    private static void transformInner(byte[] bArr, byte[] bArr2, byte[][] bArr3) {
        for (int i3 = 0; i3 < bArr.length; i3++) {
            byte b16 = bArr[i3];
            int i16 = i3 * 2;
            bArr2[i3] = (byte) ((bArr3[i16 % 32][(byte) ((b16 >> 4) & 15)] << 4) | bArr3[(i16 + 1) % 32][(byte) (b16 & RegisterType.DOUBLE_HI)]);
        }
    }
}
