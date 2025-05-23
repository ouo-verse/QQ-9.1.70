package com.tencent.could.huiyansdk.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.could.component.common.ai.utils.TwoTuple;
import com.tencent.could.huiyansdk.api.HuiYanSdkImp;
import com.tencent.could.huiyansdk.base.HuiYanBaseApi;
import com.tencent.could.huiyansdk.common.a;
import com.tencent.could.huiyansdk.entity.LiveDataCheckResult;
import com.tencent.could.huiyansdk.enums.HuiYanAction;
import com.tencent.could.huiyansdk.fragments.BaseFragment;
import com.tencent.could.huiyansdk.manager.b;
import com.tencent.could.huiyansdk.manager.k;
import com.tencent.could.huiyansdk.utils.a;
import com.tencent.could.huiyansdk.utils.q;
import com.tencent.mobileqq.flashchat.FlashChatItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qqlive.tvkplayer.tools.httpdns.TVKHttpDnsCryptoUtils;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CommonUtils {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f100295a;

        public a(String str) {
            this.f100295a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            File file = new File(this.f100295a);
            if (file.exists() && !file.delete()) {
                k.a.f100197a.a(2, com.tencent.av.video.effect.utils.CommonUtils.TAG, "delete file error\uff0c path:" + this.f100295a);
            }
        }
    }

    public CommonUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean a(boolean z16, String[] strArr) {
        k.a.f100197a.a(1, com.tencent.av.video.effect.utils.CommonUtils.TAG, "contain action or not: " + z16);
        if (!z16) {
            return true;
        }
        for (String str : strArr) {
            String[] split = str.split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (split.length == 2 && "action_data".equals(split[0])) {
                for (String str2 : split[1].split(",")) {
                    if (!"5".equals(str2.trim())) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static String base64DecodeToString(String str) {
        return new String(Base64.decode(str, 2));
    }

    public static String base64EncodeToString(String str) {
        return new String(Base64.encode(str.getBytes(), 2));
    }

    public static TwoTuple calculateTuringErrorCode(long j3) {
        return new TwoTuple(Integer.valueOf((int) (j3 / (-100000))), Integer.valueOf((int) (j3 % (FlashChatItem.ID_RANDOM * r0))));
    }

    public static int[] changeActions(HuiYanAction[] huiYanActionArr) {
        if (huiYanActionArr == null || huiYanActionArr.length == 0) {
            return null;
        }
        int[] iArr = new int[huiYanActionArr.length];
        for (int i3 = 0; i3 < huiYanActionArr.length; i3++) {
            int ordinal = huiYanActionArr[i3].ordinal();
            int i16 = 2;
            if (ordinal != 1) {
                if (ordinal != 2) {
                    i16 = 4;
                    if (ordinal != 3) {
                        if (ordinal != 4) {
                            i16 = 1;
                        } else {
                            i16 = 5;
                        }
                    }
                } else {
                    i16 = 3;
                }
            }
            iArr[i3] = i16;
        }
        return iArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static LiveDataCheckResult checkHaveColorData(String str) {
        JSONObject jSONObject;
        LiveDataCheckResult liveDataCheckResult = new LiveDataCheckResult();
        try {
            jSONObject = new JSONObject(str);
        } catch (NullPointerException | JSONException e16) {
            k.a.f100197a.a(2, com.tencent.av.video.effect.utils.CommonUtils.TAG, "check have color data json exception: " + e16.getLocalizedMessage());
            e16.printStackTrace();
        }
        if (!jSONObject.has("select_data")) {
            return liveDataCheckResult;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("select_data");
        if (!jSONObject2.has(DownloadInfo.spKey_Config)) {
            return liveDataCheckResult;
        }
        String[] split = jSONObject2.getString(DownloadInfo.spKey_Config).split(ContainerUtils.FIELD_DELIMITER);
        boolean z16 = false;
        for (String str2 : split) {
            String[] split2 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (split2.length == 2 && "actref_ux_mode".equals(split2[0])) {
                if (!"0".equals(split2[1]) && !"1".equals(split2[1])) {
                    liveDataCheckResult.setHaveColorData(false);
                    if (!"1".equals(split2[1])) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                }
                liveDataCheckResult.setHaveColorData(true);
                if (!"1".equals(split2[1])) {
                }
            }
        }
        liveDataCheckResult.setNoAction(a(z16, split));
        return liveDataCheckResult;
    }

    public static byte[] clipNV21(byte[] bArr, int i3, int i16, int i17, int i18, int i19, int i26) {
        if (i17 % 2 == 1) {
            i17--;
        }
        if (i18 % 2 == 1) {
            i18--;
        }
        int i27 = i18 + i26;
        int i28 = ((i19 * i26) * 3) / 2;
        byte[] a16 = a.C1020a.f100297a.a();
        if (a16 == null) {
            a16 = new byte[i28];
        }
        for (int i29 = i18; i29 < i27; i29++) {
            System.arraycopy(bArr, (i29 * i3) + i17, a16, (i29 - i18) * i19, i19);
        }
        int i36 = (i18 / 2) + i16;
        int i37 = i16 + (i27 / 2);
        for (int i38 = i36; i38 < i37; i38++) {
            System.arraycopy(bArr, (i38 * i3) + i17, a16, ((i38 - i36) + i26) * i19, i19);
        }
        return a16;
    }

    public static void closeCurrentFragment() {
        try {
            final BaseFragment a16 = b.a.f100131a.a();
            if (a16 != null) {
                k.a.f100197a.a(1, com.tencent.av.video.effect.utils.CommonUtils.TAG, "closeCurrentFragment exit fragment!");
                a16.a(new Runnable() { // from class: com.tencent.could.huiyansdk.utils.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseFragment.this.b();
                    }
                });
            }
        } catch (Exception e16) {
            k.a.f100197a.a(2, com.tencent.av.video.effect.utils.CommonUtils.TAG, "close current fragment error! e" + e16.getLocalizedMessage());
        }
    }

    public static boolean copyFile(String str, String str2) {
        if (!new File(str).exists()) {
            return false;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(str2);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read != -1) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                            fileInputStream.close();
                            return true;
                        }
                    }
                } finally {
                }
            } finally {
            }
        } catch (Exception unused) {
            k.a.f100197a.a(2, com.tencent.av.video.effect.utils.CommonUtils.TAG, "copy video error.");
            return false;
        }
    }

    public static void deleteFileByPath(String str) {
        q.a.f100321a.a(new a(str));
    }

    public static int dpToPx(View view, float f16) {
        return Math.round(view.getResources().getDisplayMetrics().density * f16);
    }

    public static byte[] encryptAESDecode(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, KeyPropertiesCompact.KEY_ALGORITHM_AES);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
        Cipher cipher = Cipher.getInstance(TVKHttpDnsCryptoUtils.ENCRYPTION_TYPE_AES);
        cipher.init(2, secretKeySpec, ivParameterSpec);
        return cipher.doFinal(bArr3);
    }

    public static byte[] encryptAESEncode(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, KeyPropertiesCompact.KEY_ALGORITHM_AES);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
        Cipher cipher = Cipher.getInstance(TVKHttpDnsCryptoUtils.ENCRYPTION_TYPE_AES);
        cipher.init(1, secretKeySpec, ivParameterSpec);
        return cipher.doFinal(bArr3);
    }

    public static Context getContext() {
        Context resContext = HuiYanSdkImp.getInstance().getResContext();
        if (resContext == null) {
            return HuiYanBaseApi.b.f100031a.a();
        }
        return resContext;
    }

    public static byte[] hexStringToBytes(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i3 = 0; i3 < length; i3 += 2) {
            bArr[i3 / 2] = (byte) ((Character.digit(str.charAt(i3), 16) << 4) + Character.digit(str.charAt(i3 + 1), 16));
        }
        return bArr;
    }

    public static String md5(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str2 = a.C1019a.f100038a.f100035d;
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        String substring = str2.substring(1, Integer.parseInt(str2.substring(0, 1)) + 1);
        byte[] bytes = str.getBytes();
        byte[] bytes2 = substring.getBytes();
        if (bytes == null) {
            bytes = bytes2;
        } else if (bytes2 != null) {
            byte[] bArr = new byte[bytes.length + bytes2.length];
            System.arraycopy(bytes, 0, bArr, 0, bytes.length);
            System.arraycopy(bytes2, 0, bArr, bytes.length, bytes2.length);
            bytes = bArr;
        }
        return realMd5(bytes);
    }

    public static String realMd5(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(bArr);
            return a(messageDigest.digest());
        } catch (NoSuchAlgorithmException e16) {
            k.a.f100197a.a(2, com.tencent.av.video.effect.utils.CommonUtils.TAG, "md5 error: " + e16.getLocalizedMessage());
            return "";
        }
    }

    public static String realSha256(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA256);
            messageDigest.update(bArr);
            return a(messageDigest.digest());
        } catch (NoSuchAlgorithmException e16) {
            k.a.f100197a.a(2, com.tencent.av.video.effect.utils.CommonUtils.TAG, "md5 error: " + e16.getLocalizedMessage());
            return "";
        }
    }

    public static void sendErrorAndExitAuth(int i3, String str) {
        final BaseFragment a16 = b.a.f100131a.a();
        if (a16 != null) {
            k.a.f100197a.a(1, com.tencent.av.video.effect.utils.CommonUtils.TAG, "send error and exit fragment!");
            a16.a(new Runnable() { // from class: com.tencent.could.huiyansdk.utils.t
                @Override // java.lang.Runnable
                public final void run() {
                    BaseFragment.this.b();
                }
            });
        }
        HuiYanSdkImp.getInstance().doOnFail(i3, str);
    }

    public static String sha256(String str) {
        return realSha256(str.getBytes());
    }

    public static String a(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder();
        if (bArr == null || bArr.length <= 0) {
            return "";
        }
        for (byte b16 : bArr) {
            String hexString = Integer.toHexString(b16 & 255);
            if (hexString.length() < 2) {
                sb5.append(0);
            }
            sb5.append(hexString);
        }
        return sb5.toString().toLowerCase();
    }
}
