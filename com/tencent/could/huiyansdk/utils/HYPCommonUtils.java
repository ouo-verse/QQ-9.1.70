package com.tencent.could.huiyansdk.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.Toast;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.epicgames.ue4.GameActivity;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.could.component.common.ai.net.TxNetWorkHelper;
import com.tencent.could.component.common.ai.utils.TwoTuple;
import com.tencent.could.huiyansdk.api.CreateFaceIdToken;
import com.tencent.could.huiyansdk.api.HuiYanAuthImp;
import com.tencent.could.huiyansdk.api.HuiYanAuthResultListener;
import com.tencent.could.huiyansdk.base.HuiYanBaseApi;
import com.tencent.could.huiyansdk.entity.CompareResult;
import com.tencent.could.huiyansdk.entity.CustomerTokenEntity;
import com.tencent.could.huiyansdk.exception.AuthException;
import com.tencent.could.huiyansdk.manager.d;
import com.tencent.could.huiyansdk.manager.k;
import com.tencent.could.huiyansdk.operate.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* loaded from: classes5.dex */
public class HYPCommonUtils {
    static IPatchRedirector $redirector_ = null;
    public static final int ANDROID_R = 30;
    public static final boolean IS_DB_VERSION = false;

    public HYPCommonUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static AnimationDrawable createFrameAnimation(Resources resources) {
        if (resources == null) {
            return null;
        }
        AnimationDrawable animationDrawable = new AnimationDrawable();
        animationDrawable.addFrame(VectorDrawableCompat.create(resources, R.drawable.lzh, null), 120);
        animationDrawable.addFrame(VectorDrawableCompat.create(resources, R.drawable.lzi, null), 120);
        animationDrawable.addFrame(VectorDrawableCompat.create(resources, R.drawable.lzj, null), 120);
        animationDrawable.addFrame(VectorDrawableCompat.create(resources, R.drawable.lzk, null), 120);
        animationDrawable.addFrame(VectorDrawableCompat.create(resources, R.drawable.lzl, null), 120);
        animationDrawable.addFrame(VectorDrawableCompat.create(resources, R.drawable.lzm, null), 120);
        animationDrawable.addFrame(VectorDrawableCompat.create(resources, R.drawable.lzn, null), 120);
        animationDrawable.addFrame(VectorDrawableCompat.create(resources, R.drawable.lzo, null), 120);
        animationDrawable.addFrame(VectorDrawableCompat.create(resources, R.drawable.lzp, null), 120);
        animationDrawable.addFrame(VectorDrawableCompat.create(resources, R.drawable.lzq, null), 120);
        animationDrawable.addFrame(VectorDrawableCompat.create(resources, R.drawable.lzr, null), 120);
        animationDrawable.addFrame(VectorDrawableCompat.create(resources, R.drawable.lzs, null), 120);
        animationDrawable.addFrame(VectorDrawableCompat.create(resources, R.drawable.lzt, null), 120);
        animationDrawable.addFrame(VectorDrawableCompat.create(resources, R.drawable.lzu, null), 120);
        animationDrawable.addFrame(VectorDrawableCompat.create(resources, R.drawable.lzv, null), 120);
        animationDrawable.addFrame(VectorDrawableCompat.create(resources, R.drawable.lzw, null), 120);
        animationDrawable.addFrame(VectorDrawableCompat.create(resources, R.drawable.lzx, null), 120);
        animationDrawable.addFrame(VectorDrawableCompat.create(resources, R.drawable.lzy, null), 120);
        animationDrawable.addFrame(VectorDrawableCompat.create(resources, R.drawable.lzz, null), 120);
        animationDrawable.addFrame(VectorDrawableCompat.create(resources, R.drawable.f162633m00, null), 120);
        animationDrawable.addFrame(VectorDrawableCompat.create(resources, R.drawable.f162634m01, null), 120);
        animationDrawable.addFrame(VectorDrawableCompat.create(resources, R.drawable.f162635m02, null), 120);
        animationDrawable.addFrame(VectorDrawableCompat.create(resources, R.drawable.f162636m03, null), 120);
        animationDrawable.addFrame(VectorDrawableCompat.create(resources, R.drawable.f162637m04, null), 120);
        animationDrawable.addFrame(VectorDrawableCompat.create(resources, R.drawable.f162638m05, null), 120);
        animationDrawable.addFrame(VectorDrawableCompat.create(resources, R.drawable.m06, null), 120);
        return animationDrawable;
    }

    public static void doResultCallBackResult(CompareResult compareResult) {
        String faceIdToken = getFaceIdToken();
        HuiYanAuthResultListener authResultListener = HuiYanAuthImp.getInstance().getAuthResultListener();
        if (authResultListener == null) {
            k.a.f100197a.a(2, "HYPCommonUtils", "resultListener is null token\uff1a " + faceIdToken);
            return;
        }
        if (compareResult.getErrorCode() == 0) {
            authResultListener.onSuccess(faceIdToken);
            com.tencent.could.huiyansdk.operate.c cVar = c.b.f100258a;
            cVar.a(0, "Success");
            com.tencent.could.huiyansdk.manager.d dVar = d.b.f100161a;
            dVar.a(dVar.a(), false, (File) null);
            cVar.a(cVar.a(), false, null);
        } else {
            HuiYanAuthImp.getInstance().getDoOnFail(compareResult.getErrorCode(), compareResult.getErrorMsg());
        }
        HuiYanAuthImp.getInstance().cleanCommonDataListener();
    }

    public static String getFaceIdToken() {
        CreateFaceIdToken createFaceIdToken = HuiYanAuthImp.getInstance().getCreateFaceIdToken();
        if (createFaceIdToken != null) {
            return createFaceIdToken.getCustomerFaceIdToken();
        }
        CustomerTokenEntity customerTokenEntity = HuiYanAuthImp.getInstance().getCommonDataCache().getCustomerTokenEntity();
        if (customerTokenEntity != null && customerTokenEntity.isSuccess()) {
            return customerTokenEntity.getFaceIdToken();
        }
        return "";
    }

    public static String getNetWorkTypeState(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo.State state;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || !m.a(context, new String[]{DeviceInfoUtil.PERMISSION_READ_PHONE}) || !m.a(context, new String[]{"android.permission.ACCESS_NETWORK_STATE"})) {
            return "";
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo != null && (state = networkInfo.getState()) != null && (state == NetworkInfo.State.CONNECTING || state == NetworkInfo.State.CONNECTED)) {
            return "WI-FI";
        }
        try {
            int networkType = NetworkMonitor.getNetworkType((TelephonyManager) context.getSystemService("phone"));
            if (networkType != 20) {
                switch (networkType) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return "2G";
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return "3G";
                    case 13:
                        return "4G";
                    default:
                        return com.tencent.mobileqq.msf.core.x.q.f250392x;
                }
            }
            return "5G";
        } catch (Exception unused) {
            return "";
        }
    }

    public static TwoTuple<String, String> getRequestConnectIp(boolean z16) {
        if (!z16) {
            z16 = true;
        }
        if (z16) {
            return new TwoTuple<>("https://sdk.faceid.qq.com", "https://sdk-enhance.faceid.qq.com");
        }
        TxNetWorkHelper txNetWorkHelper = TxNetWorkHelper.getInstance();
        HuiYanBaseApi huiYanBaseApi = HuiYanBaseApi.b.f100031a;
        String hostNameCurrentIp = txNetWorkHelper.getHostNameCurrentIp(huiYanBaseApi.a(), "sdk.faceid.qq.com");
        if (!TextUtils.isEmpty(hostNameCurrentIp)) {
            return new TwoTuple<>("https://" + hostNameCurrentIp, "https://sdk.faceid.qq.com");
        }
        String hostNameCurrentIp2 = TxNetWorkHelper.getInstance().getHostNameCurrentIp(huiYanBaseApi.a(), "sdk-enhance.faceid.qq.com");
        if (!TextUtils.isEmpty(hostNameCurrentIp2)) {
            return new TwoTuple<>("https://" + hostNameCurrentIp2, "https://sdk-enhance.faceid.qq.com");
        }
        return new TwoTuple<>("https://121.14.78.51", "https://sdk.faceid.qq.com");
    }

    public static String getTokenUrl(String str) {
        CustomerTokenEntity customerTokenEntity = HuiYanAuthImp.getInstance().getCommonDataCache().getCustomerTokenEntity();
        if (customerTokenEntity != null && customerTokenEntity.isSuccess()) {
            return str + "?FaceIdToken=" + customerTokenEntity.getFaceIdToken();
        }
        return str;
    }

    public static String readFileAndCreateRequestBase64(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists()) {
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) file.length());
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = bufferedInputStream.read(bArr, 0, 1024);
                                if (-1 != read) {
                                    byteArrayOutputStream.write(bArr, 0, read);
                                } else {
                                    String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                                    byteArrayOutputStream.close();
                                    bufferedInputStream.close();
                                    return encodeToString;
                                }
                            }
                        } finally {
                        }
                    } finally {
                    }
                } catch (IOException e16) {
                    AuthException authException = new AuthException(e16.getMessage());
                    authException.f100039a = PlayerResources.RawId.RAW_360_VERTEX_SHADER;
                    throw authException;
                }
            } else {
                AuthException authException2 = new AuthException("file is not exists!");
                authException2.f100039a = PlayerResources.RawId.BASE;
                throw authException2;
            }
        } else {
            AuthException authException3 = new AuthException("filePath is empty!");
            authException3.f100039a = PlayerResources.RawId.BASE;
            throw authException3;
        }
    }

    public static void showToastTip(String str) {
        Context a16 = HuiYanBaseApi.b.f100031a.a();
        if (a16 != null) {
            Toast.makeText(a16, str, 1).show();
        }
        k.a.f100197a.a(1, GameActivity.DOWNLOAD_RETURN_NAME, "show toast tip tips: " + str);
    }
}
