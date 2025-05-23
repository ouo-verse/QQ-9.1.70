package oicq.wlogin_sdk.tools;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.Proxy;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.os.SystemProperties;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.ams.adcore.mma.util.SharedPreferencedUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.data.troop.TroopMemberSpecialTitleInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
import javax.crypto.Cipher;
import oicq.wlogin_sdk.listener.PrivacyListener;
import oicq.wlogin_sdk.listener.SwitchListener;
import oicq.wlogin_sdk.pb.device_report;
import oicq.wlogin_sdk.persistence.d;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.request.u;
import oicq.wlogin_sdk.tools.InternationMsg;
import okhttp3.HttpUrl;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes28.dex */
public class util {
    public static final int ASYNC_GET_SALT_UIN_LIST = 24;
    public static final int ASYNC_GET_ST_BY_GATEWAY = 21;
    public static final int ASYNC_GET_ST_BY_PHONE = 22;
    public static final int ASYNC_GET_ST_BY_PHONE_PASSWORD = 23;
    public static final int ASYNC_GET_ST_BY_THIRD_PLATFORM = 25;
    public static final int ASYN_CHECK_IMAGE = 2;
    public static final int ASYN_CHECK_SMS = 4;
    public static final int ASYN_EXCEPTION = 11;
    public static final int ASYN_GET_A1_WITH_A1 = 6;
    public static final int ASYN_GET_ST_WITHOUT_PWD = 5;
    public static final int ASYN_GET_ST_WITH_PWD = 0;
    public static final int ASYN_QUICKLOG_BY_GATEWAY = 19;
    public static final int ASYN_QUICKLOG_BY_THIRD_PLATFORM = 20;
    public static final int ASYN_QUICKLOG_BY_WECHAT = 18;
    public static final int ASYN_QUICKLOG_WITH_PTSIG = 16;
    public static final int ASYN_QUICKLOG_WITH_QQSIG = 15;
    public static final int ASYN_QUICKLOG_WITH_QRSIG = 17;
    public static final int ASYN_REFLUSH_IMAGE = 1;
    public static final int ASYN_REFLUSH_SMS = 3;
    public static final int ASYN_REPORT = 7;
    public static final int ASYN_REPORT_ERROR = 8;
    public static final int ASYN_SMSLOGIN_CHECK = 12;
    public static final int ASYN_SMSLOGIN_REFRESH = 14;
    public static final int ASYN_SMSLOGIN_VERIFY = 13;
    public static final int ASYN_TRANSPORT = 9;
    public static final int ASYN_TRANSPORT_MSF = 10;
    public static final long BUILD_TIME = 1745224715;
    public static final int BUSINESS_TYPE_LOGIN_GATEWAY = 2;
    public static final int BUSINESS_TYPE_LOGIN_SMS = 3;
    public static final int BUSINESS_TYPE_NULL = 0;
    public static final String CMD_DEVICE_LOCK = "wtlogin.device_lock";
    public static final String CMD_LOG_REPORT = "wtlogin.log_report";
    public static final String CMD_QR_LOGIN = "wtlogin.qrlogin";
    public static final String CMD_REGISTER = "wtlogin.register";
    public static final int D = 2;
    private static SimpleDateFormat DAYFORMAT = null;
    public static final int E_A1_DECRYPT = -1014;
    public static final int E_A1_FORMAT = -1016;
    public static final int E_A1_SEQ_ERROR = 20;
    public static final int E_ADVANCE_NOTICE = 257;
    public static final int E_APK_CHK_ERR = -1021;
    public static final int E_BUFFER_OVERFLOW = -1023;
    public static final int E_DECRYPT = -1002;
    public static final int E_ENCODING = -1013;
    public static final int E_ENCRYPTION_METHOD = -1024;
    public static final int E_GATEWAY_LOGIN_FAILED = -2005;
    public static final int E_GATEWAY_LOGIN_NUM_FAILED = -2004;
    public static final int E_INPUT = -1017;
    public static final int E_LOGIN_THROUGH_QQ = -2001;
    public static final int E_LOGIN_THROUGH_WEB = -2000;
    public static final int E_NAME_INVALID = -1008;
    public static final int E_NEWST_DECRYPT = -1025;
    public static final int E_NO_KEY = -1004;
    public static final int E_NO_NETWORK = -1026;
    public static final int E_NO_REG_CMD = -1010;
    public static final int E_NO_RET = -1000;
    public static final int E_NO_TGTKEY = -1006;
    public static final int E_NO_UIN = -1003;
    public static final int E_OTHER_EXCEPTION = -2006;
    public static final int E_PENDING = -1001;
    public static final int E_PK_LEN = -1009;
    public static final int E_PUSH_REG = -1011;
    public static final int E_RESOLVE_ADDR = -1007;
    public static final int E_SAVE_TICKET_ERROR = -1022;
    public static final int E_SHARE_SERVICE_EXCEPTION = -1020;
    public static final int E_SHARE_SERVICE_PARAM = -1019;
    public static final int E_SHARE_SERVICE_UNCHECK = -1018;
    public static final int E_SYSTEM = -1012;
    public static final int E_TLV_DECRYPT = -1015;
    public static final int E_TLV_VERIFY = -1005;
    public static final int E_WXLOGIN_NO_REGISTER = 230;
    public static final int E_WXLOGIN_NUM_FAILED = -2003;
    public static final int E_WXLOGIN_TOKEN_FAILED = -2002;
    public static final String FILE_DIR = "wtlogin";
    public static int GUID_DELAY_HOUR = 0;
    private static int HONEYCOMB = 0;
    public static final String HTTPS_PREFIX = "https://";
    public static final String HTTPS_WLOGIN_PATH = "/cgi-bin/wlogin_proxy_login";
    public static final int I = 1;
    public static final int KEY_TLV543_IN_TLV199 = 1676611;
    public static LogCallBack LCB = null;
    public static boolean LOGCAT_OUT = false;
    public static final String LOG_DIR = "tencent/wtlogin";
    public static int LOG_LEVEL = 0;
    public static String LOG_TAG_EVENT_REPORT = null;
    public static String LOG_TAG_GATEWAY_LOGIN_NEW_DOV = null;
    public static String LOG_TAG_POW = null;
    public static String LOG_TAG_PRIVACY = null;
    public static String LOG_TAG_QIMEI = null;
    public static int MAX_APPID = 0;
    public static final int MAX_CONTENT_SIZE = 40960;
    public static final int MAX_FILE_SIZE = 524288;
    public static final int MAX_INIT_KEY_TIME = 3;
    public static int MAX_NAME_LEN = 0;
    public static final int MAX_REQUEST_COUNT_OF_PSKEY = 20;

    @SuppressLint({"NewApi"})
    private static int MODE_MULTI_PROCESS = 0;
    private static int NTSwitch = 0;
    private static final String NT_LOGIN_SWITCH_KEY = "switch_nt_login";
    public static final int QQ_APP_ID = 16;
    public static final String RANDOM_ANDROID_ID = "random_AndroidId";
    public static final int REG_CHECK_ERROR_FACE = 59;
    public static final int REG_OVER_LIMIT = 61;
    public static final String SDK_VERSION = "6.0.0.2574";
    public static final int SSO_VERSION = 22;
    public static final long SVN_VER = 2574;
    public static final int S_BABYLH_EXPIRED = 116;
    public static final int S_GET_IMAGE = 2;
    public static final int S_GET_SMS = 160;
    public static final int S_GET_SMS_TOKEN = 239;
    public static final int S_LH_EXPIRED = 41;
    public static final int S_PHONE_DEV = 224;
    public static final int S_PWD_WRONG = 1;
    public static final int S_ROLL_BACK = 180;
    public static final int S_SEC_GUID = 204;
    public static final int S_SUCCESS = 0;
    public static final String TAG = "wlogin_sdk";
    public static final int TLV542 = 1346;
    public static final int W = 0;
    public static final String WT_LOGIN_URL_HOST = "txz.qq.com";
    public static final char[] base64_encode_chars;
    public static final char base64_pad_url = '_';
    public static final short[] base64_reverse_table_url;
    private static boolean libwtecdh_loaded;
    public static boolean loadEncryptSo;
    public static String logContent;
    public static PrivacyListener privacyListener;
    public static HashMap<Long, String> roleCmdMap;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.matches("wtlogin_[0-9]+\\.log");
        }
    }

    static {
        HashMap<Long, String> hashMap = new HashMap<>();
        roleCmdMap = hashMap;
        hashMap.put(85L, CMD_LOG_REPORT);
        roleCmdMap.put(95L, "wtlogin.register");
        roleCmdMap.put(505L, CMD_DEVICE_LOCK);
        roleCmdMap.put(114L, CMD_QR_LOGIN);
        MAX_APPID = 65535;
        MAX_NAME_LEN = 128;
        LOG_LEVEL = 1;
        LCB = null;
        privacyListener = null;
        LOGCAT_OUT = false;
        LOG_TAG_GATEWAY_LOGIN_NEW_DOV = "gateway_login_new_dov";
        LOG_TAG_POW = "pow";
        LOG_TAG_EVENT_REPORT = "event_report";
        LOG_TAG_PRIVACY = "privacy";
        LOG_TAG_QIMEI = TVKLiveRequestBuilder.RequestParamKey.QIMEI36;
        GUID_DELAY_HOUR = 360;
        logContent = "";
        DAYFORMAT = null;
        libwtecdh_loaded = false;
        loadEncryptSo = true;
        MODE_MULTI_PROCESS = 4;
        NTSwitch = 0;
        HONEYCOMB = 11;
        base64_encode_chars = new char[]{EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        base64_reverse_table_url = new short[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 63, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    }

    public static boolean ExistSDCard() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return true;
        }
        return false;
    }

    public static void LOGD(String str) {
        try {
            if (LOG_LEVEL >= 2) {
                LogCallBack logCallBack = LCB;
                if (logCallBack != null) {
                    logCallBack.OnLog(str);
                } else if (LOGCAT_OUT) {
                    Log.d(TAG, str);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void LOGI(String str) {
        try {
            if (LOG_LEVEL >= 1) {
                LogCallBack logCallBack = LCB;
                if (logCallBack != null) {
                    logCallBack.OnLog(str);
                } else if (LOGCAT_OUT) {
                    Log.i(TAG, str);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void LOGW(String str, String str2) {
        try {
            if (LOG_LEVEL >= 0) {
                LogCallBack logCallBack = LCB;
                if (logCallBack != null) {
                    logCallBack.OnLog(str, str2);
                } else if (LOGCAT_OUT) {
                    Log.w(TAG, str + ":" + str2);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static byte[] RSADecrypt(byte[] bArr, Key key) {
        String str;
        if (bArr != null && key != null) {
            try {
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(2, key);
                int length = bArr.length;
                byte[] bArr2 = new byte[length];
                if (length % 128 != 0) {
                    LOGI("len not match block size", "");
                    return null;
                }
                int i3 = 0;
                for (int i16 = 0; i16 < length / 128; i16++) {
                    byte[] bArr3 = new byte[128];
                    System.arraycopy(bArr, i16 * 128, bArr3, 0, 128);
                    byte[] doFinal = cipher.doFinal(bArr3);
                    System.arraycopy(doFinal, 0, bArr2, i3, doFinal.length);
                    i3 += doFinal.length;
                }
                byte[] bArr4 = new byte[i3];
                System.arraycopy(bArr2, 0, bArr4, 0, i3);
                return bArr4;
            } catch (Exception e16) {
                str = "descypt exception:" + e16.toString();
            }
        } else {
            str = "data or key is null";
        }
        LOGI(str, "");
        return null;
    }

    public static byte[] RSAEncrypt(byte[] bArr, Key key) {
        if (bArr != null && key != null) {
            try {
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(1, key);
                int length = bArr.length;
                int round = (int) Math.round((length / 117) + 0.5d);
                byte[] bArr2 = new byte[round * 128];
                int i3 = 117;
                for (int i16 = 0; i16 < round; i16++) {
                    if (length < 117) {
                        i3 = length;
                    }
                    byte[] bArr3 = new byte[i3];
                    System.arraycopy(bArr, i16 * 117, bArr3, 0, i3);
                    System.arraycopy(cipher.doFinal(bArr3), 0, bArr2, 128 * i16, 128);
                    length -= i3;
                }
                return bArr2;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static Key RSAPrivKeyFromJNI(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = {48, -126, 2, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, 2, 1, 0, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 4, -126, 2, 95};
        int length = bArr.length - 607;
        bArr2[3] = (byte) (bArr2[3] + length);
        bArr2[25] = (byte) (bArr2[25] + length);
        byte[] bArr3 = new byte[bArr.length + 26];
        System.arraycopy(bArr2, 0, bArr3, 0, 26);
        System.arraycopy(bArr, 0, bArr3, 26, bArr.length);
        try {
            return KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(bArr3));
        } catch (Exception e16) {
            printException(e16, "");
            return null;
        }
    }

    public static byte[] RSAPrivKeyFromJava(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            byte[] encoded = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(bArr)).getEncoded();
            int length = encoded.length - 26;
            byte[] bArr2 = new byte[length];
            System.arraycopy(encoded, 26, bArr2, 0, length);
            return bArr2;
        } catch (Exception e16) {
            printException(e16, "");
            return null;
        }
    }

    public static Key RSAPubKeyFromJNI(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length + 22];
        System.arraycopy(new byte[]{48, -127, -97, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -127, -115, 0}, 0, bArr2, 0, 22);
        System.arraycopy(bArr, 0, bArr2, 22, bArr.length);
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr2));
        } catch (Exception e16) {
            printException(e16, "");
            return null;
        }
    }

    public static byte[] RSAPubKeyFromJava(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            byte[] encoded = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr)).getEncoded();
            int length = encoded.length - 22;
            byte[] bArr2 = new byte[length];
            System.arraycopy(encoded, 22, bArr2, 0, length);
            return bArr2;
        } catch (Exception e16) {
            printException(e16, "");
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0075, code lost:
    
        if (r4 != 3) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] base64_decode_url(byte[] bArr, int i3) {
        int i16;
        byte[] bArr2 = new byte[24];
        short s16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        while (true) {
            int i26 = i3 - 1;
            if (i3 <= 0) {
                break;
            }
            int i27 = i17 + 1;
            s16 = bArr[i17];
            if (s16 == 0 || s16 == 95) {
                break;
            }
            if (s16 == 32) {
                s16 = 42;
            }
            s16 = base64_reverse_table_url[s16];
            if (s16 >= 0) {
                int i28 = i18 % 4;
                if (i28 != 0) {
                    if (i28 != 1) {
                        if (i28 != 2) {
                            if (i28 == 3) {
                                i16 = i19 + 1;
                                bArr2[i19] = (byte) (bArr2[i19] | s16);
                            }
                        } else {
                            i16 = i19 + 1;
                            bArr2[i19] = (byte) (bArr2[i19] | (s16 >> 2));
                            bArr2[i16] = (byte) ((s16 & 3) << 6);
                        }
                    } else {
                        i16 = i19 + 1;
                        bArr2[i19] = (byte) (bArr2[i19] | (s16 >> 4));
                        bArr2[i16] = (byte) ((s16 & 15) << 4);
                    }
                    i19 = i16;
                } else {
                    bArr2[i19] = (byte) (s16 << 2);
                }
                i18++;
            }
            i17 = i27;
            i3 = i26;
        }
        if (s16 == 95) {
            int i29 = i18 % 4;
            if (i29 != 0 && i29 != 1) {
                if (i29 == 2) {
                    i19++;
                }
                bArr2[i19] = 0;
            } else {
                return null;
            }
        }
        return bArr2;
    }

    public static String base64_encode(byte[] bArr) {
        char c16;
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i3 = 0;
        while (i3 < length) {
            int i16 = i3 + 1;
            int i17 = bArr[i3] & 255;
            if (i16 == length) {
                char[] cArr = base64_encode_chars;
                stringBuffer.append(cArr[i17 >>> 2]);
                c16 = cArr[(i17 & 3) << 4];
            } else {
                int i18 = i16 + 1;
                int i19 = bArr[i16] & 255;
                if (i18 == length) {
                    char[] cArr2 = base64_encode_chars;
                    stringBuffer.append(cArr2[i17 >>> 2]);
                    stringBuffer.append(cArr2[((i17 & 3) << 4) | ((i19 & 240) >>> 4)]);
                    c16 = cArr2[(i19 & 15) << 2];
                } else {
                    int i26 = i18 + 1;
                    int i27 = bArr[i18] & 255;
                    char[] cArr3 = base64_encode_chars;
                    stringBuffer.append(cArr3[i17 >>> 2]);
                    stringBuffer.append(cArr3[((i17 & 3) << 4) | ((i19 & 240) >>> 4)]);
                    stringBuffer.append(cArr3[((i19 & 15) << 2) | ((i27 & 192) >>> 6)]);
                    stringBuffer.append(cArr3[i27 & 63]);
                    i3 = i26;
                }
            }
            stringBuffer.append(c16);
            break;
        }
        return stringBuffer.toString();
    }

    public static long buf_len(byte[] bArr) {
        if (bArr == null) {
            return 0L;
        }
        return bArr.length;
    }

    public static int buf_to_int16(byte[] bArr, int i3) {
        return ((bArr[i3] << 8) & 65280) + ((bArr[i3 + 1] << 0) & 255);
    }

    public static int buf_to_int32(byte[] bArr, int i3) {
        return ((bArr[i3] << 24) & (-16777216)) + ((bArr[i3 + 1] << RegisterType.UNINIT_REF) & ITVKAsset.VOD_ASSET_MASK_BIT) + ((bArr[i3 + 2] << 8) & 65280) + ((bArr[i3 + 3] << 0) & 255);
    }

    public static long buf_to_int64(byte[] bArr, int i3) {
        return ((bArr[i3] << 56) & (-72057594037927936L)) + 0 + ((bArr[i3 + 1] << 48) & 71776119061217280L) + ((bArr[i3 + 2] << 40) & 280375465082880L) + ((bArr[i3 + 3] << 32) & 1095216660480L) + ((bArr[i3 + 4] << 24) & 4278190080L) + ((bArr[i3 + 5] << 16) & 16711680) + ((bArr[i3 + 6] << 8) & 65280) + ((bArr[i3 + 7] << 0) & 255);
    }

    public static int buf_to_int8(byte[] bArr, int i3) {
        return bArr[i3] & 255;
    }

    public static String buf_to_string(byte[] bArr) {
        String str = "";
        if (bArr == null) {
            return "";
        }
        for (int i3 = 0; i3 < bArr.length; i3++) {
            str = (str + Integer.toHexString((bArr[i3] >> 4) & 15)) + Integer.toHexString(bArr[i3] & RegisterType.DOUBLE_HI);
        }
        return str;
    }

    public static Boolean check_uin_account(String str) {
        LOGI("check_uin_account account = " + str, "");
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong >= 10000 && parseLong <= 4294967295L) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (NumberFormatException unused) {
            return Boolean.FALSE;
        }
    }

    public static void chg_retry_type(Context context) {
        int i3;
        if (get_net_retry_type(context) == 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        set_net_retry_type(context, i3);
    }

    public static byte[] compress(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
                deflaterOutputStream.write(bArr);
                deflaterOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            } catch (IOException unused) {
                return new byte[0];
            }
        }
        return bArr;
    }

    public static long constructSalt() {
        return (get_rand_32() << 32) + get_rand_32();
    }

    public static void decompress(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            LOGI("data len:" + bArr.length);
            int i3 = 0;
            int i16 = 0;
            while (bArr.length > i3 + 3) {
                int buf_to_int32 = buf_to_int32(bArr, i3);
                if (bArr.length > i3 + buf_to_int32 + 3) {
                    byte[] bArr2 = new byte[buf_to_int32];
                    int i17 = i3 + 4;
                    System.arraycopy(bArr, i17, bArr2, 0, buf_to_int32);
                    i3 = i17 + buf_to_int32;
                    i16++;
                    LOGI("len:" + buf_to_int32);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        InflaterInputStream inflaterInputStream = new InflaterInputStream(new ByteArrayInputStream(bArr2));
                        byte[] bArr3 = new byte[1024];
                        while (true) {
                            int read = inflaterInputStream.read(bArr3);
                            if (read == -1) {
                                break;
                            } else {
                                byteArrayOutputStream.write(bArr3, 0, read);
                            }
                        }
                        LOGI(i16 + byteArrayOutputStream.toString());
                    } catch (IOException unused) {
                    }
                } else {
                    return;
                }
            }
        }
    }

    public static void deleteExpireFile(String str, int i3) {
        File[] listFiles;
        if (str != null && str.length() != 0) {
            LOGI("file path:" + str);
            try {
                File file = new File(str);
                if (file.isDirectory() && (listFiles = file.listFiles(new a())) != null) {
                    int length = listFiles.length;
                    for (int i16 = 0; i16 < length; i16++) {
                        if (!listFiles[i16].isDirectory() && (System.currentTimeMillis() - listFiles[i16].lastModified()) / 1000 > i3) {
                            listFiles[i16].delete();
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void deleteExpireLog(Context context) {
        String str;
        if (context == null) {
            return;
        }
        try {
            String str2 = u.f422941r0;
            if (str2 != null && str2.length() != 0) {
                str = u.f422941r0;
            } else if (ExistSDCard()) {
                str = context.getExternalCacheDir().getAbsolutePath() + "/" + LOG_DIR + "/" + context.getPackageName();
            } else {
                deleteExpireFile(context.getFilesDir().getPath() + "/" + LOG_DIR, TroopMemberSpecialTitleInfo.SPECIAL_TITLE_EXPIRE_SOON_TIME);
                return;
            }
            deleteExpireFile(str, 691200);
        } catch (Exception unused) {
        }
    }

    public static int format_ret_code(int i3) {
        if (i3 != -1015 && i3 != -1014 && i3 != -1006 && i3 != -1002) {
            if (i3 != -1000) {
                if (i3 != 0) {
                    if (i3 == 2) {
                        return 2;
                    }
                    return 17;
                }
                return 0;
            }
            return 1;
        }
        return 5;
    }

    public static byte[] generateGuid(Context context) {
        String str;
        byte[] bArr = u.f422930g0;
        if (bArr != null && bArr.length != 0) {
            LOGI("generate guid from customer guid");
            return u.f422930g0;
        }
        LOGI("generate guid temporarily");
        if (TextUtils.isEmpty(oicq.wlogin_sdk.utils.a.f423003a)) {
            oicq.wlogin_sdk.utils.a.b(context);
        }
        String str2 = oicq.wlogin_sdk.utils.a.f423003a;
        PrivacyListener privacyListener2 = privacyListener;
        if (privacyListener2 != null) {
            str = privacyListener2.getMac(context);
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            str = GlobalUtil.DEFAULT_MAC_ADDRESS;
        }
        LOGI("android_id " + str2, "");
        LOGI("mac " + str, "");
        return MD5.toMD5Byte((str2 + str).getBytes());
    }

    public static KeyPair generateRSAKeyPair() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(1024);
            return keyPairGenerator.generateKeyPair();
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] getAppName(Context context) {
        String charSequence;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
            if (applicationInfo != null && (charSequence = context.getPackageManager().getApplicationLabel(applicationInfo).toString()) != null) {
                return charSequence.getBytes();
            }
        } catch (Throwable unused) {
        }
        return new byte[0];
    }

    public static String getBaseband() {
        try {
            return (String) SystemProperties.class.getMethod("get", String.class, String.class).invoke(SystemProperties.class.newInstance(), "gsm.version.baseband", "no message");
        } catch (Exception unused) {
            return "";
        }
    }

    public static int getByteLength(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public static String getChannelId(Context context, String str) {
        String str2;
        String str3;
        long j3;
        String str4;
        if (str == null || str.length() == 0) {
            str = context.getPackageName();
        }
        try {
            String str5 = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 0).applicationInfo.sourceDir;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("pkg ");
            sb5.append(str);
            sb5.append(" path ");
            if (str5 == null) {
                str3 = "null";
            } else {
                str3 = str5;
            }
            sb5.append(str3);
            LOGI(sb5.toString(), "");
            if (str5 != null && str5.length() != 0) {
                byte[] bArr = {80, 75, 5, 6};
                FileInputStream fileInputStream = new FileInputStream(str5);
                long available = fileInputStream.available();
                int skip = (int) (available - fileInputStream.skip(available - 256));
                byte[] bArr2 = new byte[skip];
                fileInputStream.read(bArr2);
                fileInputStream.close();
                int i3 = 0;
                while (true) {
                    if (i3 < skip - 4) {
                        if (bArr2[i3] == bArr[0] && bArr2[i3 + 1] == bArr[1] && bArr2[i3 + 2] == bArr[2] && bArr2[i3 + 3] == bArr[3]) {
                            j3 = i3;
                            break;
                        }
                        i3++;
                    } else {
                        j3 = -1;
                        break;
                    }
                }
                if (j3 == -1) {
                    return "";
                }
                int i16 = ((int) j3) + 20;
                int i17 = bArr2[i16] + (bArr2[i16 + 1] << 8);
                if (i17 == 0) {
                    return "";
                }
                byte[] bArr3 = new byte[i17];
                System.arraycopy(bArr2, (int) (j3 + 20), bArr3, 0, i17);
                Matcher matcher = Pattern.compile("channelId=(\\S+)").matcher(new String(bArr3));
                if (!matcher.find()) {
                    str4 = "";
                } else {
                    str4 = matcher.group(1);
                }
                try {
                    LOGI("found comment " + new String(bArr3) + " channelId:" + str4, "");
                    return str4;
                } catch (Exception e16) {
                    str2 = str4;
                    e = e16;
                    printException(e, "");
                    return str2;
                }
            }
            return "";
        } catch (Exception e17) {
            e = e17;
            str2 = "";
        }
    }

    public static String getCurrentDay() {
        try {
            if (DAYFORMAT == null) {
                DAYFORMAT = new SimpleDateFormat(DateUtil.DATE_FORMAT_8);
            }
            return DAYFORMAT.format(new Date());
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getCurrentPid() {
        return "[" + Process.myPid() + "]";
    }

    public static String getDate() {
        try {
            return "[" + System.currentTimeMillis() + "]";
        } catch (Exception unused) {
            return "";
        }
    }

    public static long getFileModifyTime(String str) {
        File file;
        if (str == null) {
            return 0L;
        }
        if (str.length() != 0) {
            try {
                file = new File(str);
                if (file.exists() && file.isFile()) {
                }
                return 0L;
            } catch (Exception unused) {
                return 0L;
            }
        }
        return file.lastModified();
    }

    public static int getFileSize(String str) {
        try {
            File file = new File(str);
            if (!file.exists() || !file.isFile()) {
                return 0;
            }
            return (int) file.length();
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0070, code lost:
    
        if (r0 == null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0072, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0076, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0077, code lost:
    
        printException(r0, "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0060, code lost:
    
        if (r0 != null) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] getGuidFromFile(Context context) {
        byte[] bArr;
        FileInputStream fileInputStream;
        byte[] bArr2 = u.f422930g0;
        if (bArr2 != null && bArr2.length != 0) {
            LOGI("get guid from customer guid", "");
            return u.f422930g0;
        }
        LOGI("get guid from file", "");
        FileInputStream fileInputStream2 = null;
        if (context == null) {
            return null;
        }
        bArr = new byte[0];
        try {
            try {
                File file = new File(context.getFilesDir().getAbsolutePath() + "/wlogin_device.dat");
                if (file.exists()) {
                    fileInputStream = new FileInputStream(file);
                    try {
                        int available = fileInputStream.available();
                        if (available < 1024) {
                            bArr = new byte[available];
                            fileInputStream.read(bArr);
                        }
                        fileInputStream2 = fileInputStream;
                    } catch (Exception e16) {
                        e = e16;
                        fileInputStream2 = fileInputStream;
                        u.X |= 65536;
                        printException(e, "");
                    } catch (Throwable th5) {
                        th = th5;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e17) {
                                printException(e17, "");
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e18) {
                e = e18;
            }
        } catch (Throwable th6) {
            th = th6;
            fileInputStream = null;
        }
        if (bArr.length <= 0 && (bArr = get_saved_android_id(context)) != null && bArr.length > 0) {
            saveGuidToFile(context, bArr);
        }
        return bArr;
    }

    public static byte[] getIccid(Context context) {
        String simSerialNumber;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null && (simSerialNumber = DeviceInfoMonitor.getSimSerialNumber(telephonyManager)) != null) {
                return simSerialNumber.getBytes();
            }
        } catch (Throwable unused) {
        }
        return new byte[0];
    }

    public static int getInitKeyTime(Context context) {
        int i3;
        if (context != null) {
            try {
                i3 = ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO")).f422789b.getInt("InitKeyTime", 0);
            } catch (Throwable th5) {
                printThrowable(th5, "getReqTimeFromSp");
                return 0;
            }
        } else {
            i3 = 0;
        }
        LOGI("getInitKeyTime " + i3, "");
        return i3;
    }

    public static String getInnerVersion() {
        String str = Build.DISPLAY;
        if (!str.contains(Build.VERSION.INCREMENTAL)) {
            return Build.VERSION.INCREMENTAL;
        }
        return str;
    }

    public static String getLanguage(Context context) {
        String country = context.getResources().getConfiguration().locale.getCountry();
        if (country.equals(LocaleManager.MOBILE_COUNTRY_CODE_CN_STR)) {
            return LocaleManager.MOBILE_COUNTRY_CODE_CN_STR;
        }
        if (country.equals("TW")) {
            return "TW";
        }
        return "EN";
    }

    public static String getLogDir(Context context) {
        String str = u.f422941r0;
        if (str != null && str.length() != 0) {
            return u.f422941r0;
        }
        try {
            if (ExistSDCard()) {
                return context.getExternalCacheDir().getAbsolutePath() + "/" + LOG_DIR + "/" + context.getPackageName();
            }
            return context.getFilesDir().getPath() + "/" + LOG_DIR;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getLogFileName(Context context, String str) {
        if (context != null && str != null && str.length() != 0) {
            return getLogDir(context) + "/wtlogin_" + str + ".log";
        }
        return null;
    }

    public static long getLogModifyTime(Context context, String str) {
        if (context != null && str != null && str.length() != 0) {
            return getFileModifyTime(getLogFileName(context, str));
        }
        return 0L;
    }

    public static String getMaskBytes(byte[] bArr, int i3, int i16) {
        if (bArr == null) {
            return "null";
        }
        String str = new String(bArr);
        if (i3 + i16 > str.length()) {
            return "***";
        }
        return str.substring(0, i3) + "***" + str.substring(str.length() - i16);
    }

    public static String getMaskString(String str, int i3, int i16) {
        if (i3 + i16 > str.length()) {
            return "***";
        }
        return str.substring(0, i3) + "***" + str.substring(str.length() - i16);
    }

    public static int getNTSwitch(Context context) {
        int i3;
        int i16 = NTSwitch;
        if (i16 == 0 && context != null) {
            Map<String, String> map = oicq.wlogin_sdk.persistence.a.f422781a;
            if (QMMKV.from(context, "common_mmkv_configurations").decodeBool("switch_nt_login", false)) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            NTSwitch = i3;
            return i3;
        }
        return i16;
    }

    public static byte[] getPkgSigFromApkName(Context context, String str) {
        Signature signature;
        try {
            Signature[] signatureArr = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 64).signatures;
            if (signatureArr != null && signatureArr.length > 0 && (signature = signatureArr[0]) != null) {
                return MD5.toMD5Byte(signature.toByteArray());
            }
            return new byte[0];
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public static String getProcVersion() {
        FileReader fileReader;
        String readLine;
        FileReader fileReader2 = null;
        try {
            try {
                try {
                    fileReader = new FileReader("/proc/version");
                    try {
                        readLine = new BufferedReader(fileReader).readLine();
                    } catch (Exception e16) {
                        e = e16;
                        fileReader2 = fileReader;
                        LOGD("getProcVersion failed" + e.toString(), "");
                        if (fileReader2 != null) {
                            fileReader2.close();
                        }
                        return "";
                    } catch (Throwable th5) {
                        th = th5;
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException e17) {
                                e17.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    fileReader = fileReader2;
                }
            } catch (Exception e18) {
                e = e18;
            }
        } catch (IOException e19) {
            e19.printStackTrace();
        }
        if (readLine != null) {
            try {
                fileReader.close();
            } catch (IOException e26) {
                e26.printStackTrace();
            }
            return readLine;
        }
        fileReader.close();
        return "";
    }

    public static byte[] getRequestInitTime() {
        byte[] bArr = new byte[4];
        int64_to_buf32(bArr, 0, (System.currentTimeMillis() / 1000) + u.f422926c0);
        return bArr;
    }

    public static String getSvnVersion() {
        return "[2574]";
    }

    public static String getThreadId() {
        return "[" + Thread.currentThread().getId() + "]";
    }

    public static String getThrowableInfo(Throwable th5) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter((Writer) stringWriter, true);
        th5.printStackTrace(printWriter);
        printWriter.flush();
        stringWriter.flush();
        return stringWriter.toString();
    }

    public static String getUser(String str) {
        if (str != null) {
            return "[" + str + "]";
        }
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }

    public static byte[] get_IMSI(Context context) {
        PrivacyListener privacyListener2 = privacyListener;
        if (privacyListener2 != null) {
            String imsi = privacyListener2.getImsi(context);
            if (!TextUtils.isEmpty(imsi)) {
                return imsi.getBytes();
            }
        }
        return new byte[0];
    }

    public static byte[] get_android_dev_info(Context context) {
        byte[] bArr = new byte[0];
        try {
            if (TextUtils.isEmpty(oicq.wlogin_sdk.utils.a.f423003a)) {
                oicq.wlogin_sdk.utils.a.b(context);
            }
            String str = oicq.wlogin_sdk.utils.a.f423003a;
            String str2 = Build.BOOTLOADER;
            String procVersion = getProcVersion();
            String str3 = Build.VERSION.CODENAME;
            String str4 = Build.VERSION.INCREMENTAL;
            String str5 = Build.FINGERPRINT;
            String baseband = getBaseband();
            String innerVersion = getInnerVersion();
            device_report.DeviceReport deviceReport = new device_report.DeviceReport();
            deviceReport.bytes_bootloader.set(ByteStringMicro.copyFromUtf8(str2));
            deviceReport.bytes_version.set(ByteStringMicro.copyFromUtf8(procVersion));
            deviceReport.bytes_codename.set(ByteStringMicro.copyFromUtf8(str3));
            deviceReport.bytes_incremental.set(ByteStringMicro.copyFromUtf8(str4));
            deviceReport.bytes_fingerprint.set(ByteStringMicro.copyFromUtf8(str5));
            deviceReport.bytes_android_id.set(ByteStringMicro.copyFromUtf8(str));
            deviceReport.bytes_baseband.set(ByteStringMicro.copyFromUtf8(baseband));
            deviceReport.bytes_inner_ver.set(ByteStringMicro.copyFromUtf8(innerVersion));
            bArr = deviceReport.toByteArray();
            StringBuilder sb5 = new StringBuilder(300);
            sb5.append(str2);
            sb5.append("\n");
            sb5.append(procVersion);
            sb5.append("\n");
            sb5.append(str3);
            sb5.append("\n");
            sb5.append(str4);
            sb5.append("\n");
            sb5.append(str5);
            sb5.append("\n");
            sb5.append(str);
            sb5.append("\n");
            sb5.append(baseband);
            sb5.append("\n");
            sb5.append(innerVersion);
            sb5.append("\n");
            LOGI(sb5.toString(), "");
        } catch (Throwable unused) {
        }
        if (bArr == null || bArr.length <= 0) {
            return new byte[0];
        }
        return bArr;
    }

    public static byte[] get_apk_id(Context context) {
        try {
            return context.getPackageName().getBytes();
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public static byte[] get_apk_v(Context context, String str) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 0).versionName.getBytes();
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public static String get_apn_string(Context context) {
        return "wifi";
    }

    public static byte[] get_bssid_addr(Context context) {
        PrivacyListener privacyListener2 = privacyListener;
        if (privacyListener2 != null) {
            String bssid = privacyListener2.getBssid(context);
            if (!TextUtils.isEmpty(bssid)) {
                return bssid.toLowerCase().getBytes();
            }
        }
        return new byte[0];
    }

    public static byte get_char(byte b16) {
        int i3;
        if (b16 >= 48 && b16 <= 57) {
            i3 = b16 - 48;
        } else {
            byte b17 = 97;
            if (b16 < 97 || b16 > 102) {
                b17 = 65;
                if (b16 < 65 || b16 > 70) {
                    return (byte) 0;
                }
            }
            i3 = (b16 - b17) + 10;
        }
        return (byte) i3;
    }

    public static String get_cost_time(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_COST")).f422789b.getString("costTime", "");
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String get_cost_trace(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_COST")).f422789b.getString("costTrace", "");
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0099, code lost:
    
        if (r9 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00ae, code lost:
    
        return string_to_buf(oicq.wlogin_sdk.tools.RSACrypt.DEFAULT_PUB_KEY);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a4, code lost:
    
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a2, code lost:
    
        if (r9 == null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] get_cp_pubkey(Context context, long j3, long j16) {
        if (context == null) {
            return new byte[0];
        }
        Cursor cursor = null;
        try {
            try {
                cursor = ContactsMonitor.query(context.getContentResolver(), Uri.parse("content://oicq.wlogin_sdk.WloginProvider/rsa_pubkey"), new String[]{"id", "appid", "subappid", "pubkey", "pubkey_md5"}, "appid=? and subappid=?", new String[]{"" + j3, "" + j16}, null);
                if (cursor != null && cursor.moveToNext()) {
                    String string = cursor.getString(cursor.getColumnIndex("pubkey"));
                    if (MD5.toMD5(string).equals(cursor.getString(cursor.getColumnIndex("pubkey_md5")))) {
                        byte[] string_to_buf = string_to_buf(string);
                        cursor.close();
                        return string_to_buf;
                    }
                }
            } catch (Exception e16) {
                printException(e16, "");
            }
        } catch (Throwable th5) {
            if (cursor != null) {
                cursor.close();
            }
            throw th5;
        }
    }

    public static String get_error_msg(int i3) {
        InternationMsg.MSG_TYPE msg_type;
        if (i3 != -1000) {
            msg_type = InternationMsg.MSG_TYPE.MSG_3;
        } else {
            msg_type = InternationMsg.MSG_TYPE.MSG_4;
        }
        return InternationMsg.a(msg_type);
    }

    public static byte[] get_ksid(Context context) {
        SwitchListener switchListener;
        byte[] bArr = new byte[0];
        try {
            switchListener = WtloginHelper.switchListener;
        } catch (Throwable th5) {
            printThrowable(th5, "");
        }
        if (switchListener != null && switchListener.isSwitchOn("103084", false)) {
            LOGI("use null ksid", "");
            return bArr;
        }
        bArr = string_to_buf(((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO")).f422789b.getString("ksid", new String("")));
        LOGI("use normal ksid : " + new String(bArr), "");
        return bArr;
    }

    private static byte[] get_ksid_new(Context context) {
        byte[] bArr = new byte[0];
        try {
            SharedPreferences a16 = oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO");
            return string_to_buf(((oicq.wlogin_sdk.persistence.c) a16).f422789b.getString("ksid", new String("")));
        } catch (Throwable th5) {
            printThrowable(th5, "");
            return bArr;
        }
    }

    public static int get_last_flag(Context context) {
        try {
            return ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO")).f422789b.getInt("last_flag", 0);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static byte[] get_last_guid(Context context) {
        byte[] bArr = new byte[0];
        try {
            SharedPreferences a16 = oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO");
            bArr = string_to_buf(((oicq.wlogin_sdk.persistence.c) a16).f422789b.getString("last_guid", new String("")));
        } catch (Throwable unused) {
        }
        if (bArr == null || bArr.length <= 0) {
            return new byte[0];
        }
        return bArr;
    }

    public static byte[] get_last_mac(Context context) {
        byte[] bArr = new byte[0];
        try {
            SharedPreferences a16 = oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO");
            bArr = string_to_buf(((oicq.wlogin_sdk.persistence.c) a16).f422789b.getString("last_mac", new String("")));
        } catch (Throwable unused) {
        }
        if (bArr == null || bArr.length <= 0) {
            return new byte[0];
        }
        return bArr;
    }

    public static byte[] get_mac_addr(Context context) {
        PrivacyListener privacyListener2 = privacyListener;
        if (privacyListener2 != null) {
            String mac = privacyListener2.getMac(context);
            if (!TextUtils.isEmpty(mac)) {
                return mac.getBytes();
            }
        }
        return GlobalUtil.DEFAULT_MAC_ADDRESS.getBytes();
    }

    public static String get_mpasswd() {
        int i3;
        try {
            String str = "";
            for (byte b16 : SecureRandom.getSeed(16)) {
                boolean nextBoolean = new Random().nextBoolean();
                int abs = Math.abs(b16 % 26);
                if (nextBoolean) {
                    i3 = 97;
                } else {
                    i3 = 65;
                }
                str = str + String.valueOf((char) (abs + i3));
            }
            return str;
        } catch (Throwable unused) {
            return "1234567890123456";
        }
    }

    public static int get_net_retry_type(Context context) {
        try {
            return ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO")).f422789b.getInt("netretry_type", 0);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static int get_network_type(Context context) {
        int i3;
        try {
            i3 = NetworkMonitor.getType(((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo());
        } catch (Throwable unused) {
            i3 = 0;
        }
        if (i3 == 0) {
            return 1;
        }
        if (i3 != 1) {
            return 0;
        }
        return 2;
    }

    public static byte[] get_os_type() {
        return "android".getBytes();
    }

    public static byte[] get_os_version() {
        return Build.VERSION.RELEASE.getBytes();
    }

    public static boolean get_pow_test(Context context) {
        boolean z16 = true;
        if (context != null) {
            try {
                z16 = ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_COST")).f422789b.getBoolean("powTestNew", true);
            } catch (Throwable th5) {
                LOGI(LOG_TAG_POW + "get_pow_test " + Log.getStackTraceString(th5), "");
            }
        }
        LOGI(LOG_TAG_POW + "get_pow_test " + z16, "");
        return z16;
    }

    public static byte[] get_prand_16byte() {
        try {
            byte[] bArr = new byte[16];
            int32_to_buf(bArr, 0, (int) (Math.random() * 2.147483647E9d));
            int32_to_buf(bArr, 4, (int) (Math.random() * 2.147483647E9d));
            int32_to_buf(bArr, 8, (int) (Math.random() * 2.147483647E9d));
            int32_to_buf(bArr, 12, (int) (Math.random() * 2.147483647E9d));
            return MD5.toMD5Byte(bArr);
        } catch (Throwable unused) {
            return new byte[16];
        }
    }

    @SuppressLint({"NewApi"})
    @TargetApi(4)
    public static String get_proxy_ip() {
        if (Build.VERSION.SDK_INT < HONEYCOMB) {
            return Proxy.getDefaultHost();
        }
        return System.getProperty("http.proxyHost");
    }

    @SuppressLint({"NewApi", "NewApi"})
    @TargetApi(4)
    public static int get_proxy_port() {
        if (Build.VERSION.SDK_INT < HONEYCOMB) {
            return Proxy.getDefaultPort();
        }
        try {
            return Integer.parseInt(System.getProperty("http.proxyPort"));
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            return -1;
        }
    }

    public static byte[] get_rand_16byte(SecureRandom secureRandom) {
        try {
            byte[] bArr = new byte[16];
            secureRandom.nextBytes(bArr);
            return bArr;
        } catch (Throwable unused) {
            return get_prand_16byte();
        }
    }

    public static int get_rand_32() {
        return (int) (Math.random() * 2.147483647E9d);
    }

    public static String get_release_time() {
        return "2025/04/21 16:38:35";
    }

    public static byte[] get_rsa_privkey(Context context) {
        byte[] bArr = new byte[0];
        try {
            bArr = string_to_buf(((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO")).f422789b.getString("rsa_privkey", ""));
        } catch (Throwable unused) {
        }
        if (bArr == null || bArr.length <= 0) {
            return new byte[0];
        }
        return bArr;
    }

    public static byte[] get_rsa_pubkey(Context context) {
        byte[] bArr = new byte[0];
        try {
            bArr = string_to_buf(((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO")).f422789b.getString("rsa_pubkey", ""));
        } catch (Throwable unused) {
        }
        if (bArr == null || bArr.length <= 0) {
            return new byte[0];
        }
        return bArr;
    }

    public static byte[] get_saved_android_id(Context context) {
        byte[] bArr = new byte[0];
        try {
            SharedPreferences a16 = oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO");
            return string_to_buf(((oicq.wlogin_sdk.persistence.c) a16).f422789b.getString(SharedPreferencedUtil.SP_KEY_ANDROID_ID, new String("")));
        } catch (Throwable th5) {
            printThrowable(th5, "");
            return bArr;
        }
    }

    public static int get_saved_network_type(Context context) {
        try {
            return ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO")).f422789b.getInt("network_type", 0);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static long get_server_cur_time() {
        SecureRandom secureRandom = u.f422943t;
        return (System.currentTimeMillis() / 1000) + u.f422926c0;
    }

    public static byte[] get_server_host1(Context context) {
        try {
            return ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO")).f422789b.getString("host1", "").getBytes();
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public static byte[] get_server_host2(Context context) {
        try {
            return ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO")).f422789b.getString("host2", "").getBytes();
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public static byte[] get_server_ipv6_host1(Context context) {
        try {
            return ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO")).f422789b.getString("ipv6_host1", "").getBytes();
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public static byte[] get_server_ipv6_host2(Context context) {
        try {
            return ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO")).f422789b.getString("ipv6_host2", "").getBytes();
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public static byte[] get_ssid_addr(Context context) {
        PrivacyListener privacyListener2 = privacyListener;
        if (privacyListener2 != null) {
            String ssid = privacyListener2.getSsid(context);
            if (!TextUtils.isEmpty(ssid)) {
                return ssid.getBytes();
            }
        }
        return new byte[0];
    }

    public static byte[] get_wap_server_host1(Context context) {
        try {
            return ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO")).f422789b.getString("wap-host1", "").getBytes();
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public static byte[] get_wap_server_host2(Context context) {
        try {
            return ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO")).f422789b.getString("wap-host2", "").getBytes();
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public static byte[] get_wap_server_ipv6_host1(Context context) {
        try {
            return ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO")).f422789b.getString("wap-ipv6_host1", "").getBytes();
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public static byte[] get_wap_server_ipv6_host2(Context context) {
        try {
            return ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO")).f422789b.getString("wap-ipv6_host2", "").getBytes();
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public static void int16_to_buf(byte[] bArr, int i3, int i16) {
        bArr[i3 + 1] = (byte) (i16 >> 0);
        bArr[i3 + 0] = (byte) (i16 >> 8);
    }

    public static void int32_to_buf(byte[] bArr, int i3, int i16) {
        bArr[i3 + 3] = (byte) (i16 >> 0);
        bArr[i3 + 2] = (byte) (i16 >> 8);
        bArr[i3 + 1] = (byte) (i16 >> 16);
        bArr[i3 + 0] = (byte) (i16 >> 24);
    }

    public static void int64_to_buf(byte[] bArr, int i3, long j3) {
        bArr[i3 + 7] = (byte) (j3 >> 0);
        bArr[i3 + 6] = (byte) (j3 >> 8);
        bArr[i3 + 5] = (byte) (j3 >> 16);
        bArr[i3 + 4] = (byte) (j3 >> 24);
        bArr[i3 + 3] = (byte) (j3 >> 32);
        bArr[i3 + 2] = (byte) (j3 >> 40);
        bArr[i3 + 1] = (byte) (j3 >> 48);
        bArr[i3 + 0] = (byte) (j3 >> 56);
    }

    public static void int64_to_buf32(byte[] bArr, int i3, long j3) {
        bArr[i3 + 3] = (byte) (j3 >> 0);
        bArr[i3 + 2] = (byte) (j3 >> 8);
        bArr[i3 + 1] = (byte) (j3 >> 16);
        bArr[i3 + 0] = (byte) (j3 >> 24);
    }

    public static void int8_to_buf(byte[] bArr, int i3, int i16) {
        bArr[i3 + 0] = (byte) (i16 >> 0);
    }

    public static boolean isFileExist(String str) {
        try {
            return new File(str).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isMQQExist(Context context) {
        if (context == null) {
            return false;
        }
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), "com.tencent.mobileqq", 0);
            if (packageInfo == null) {
                return false;
            }
            String str = packageInfo.versionName;
            if (str.compareTo("4.6.0") >= 0) {
                return true;
            }
            try {
                if (Integer.parseInt(str.substring(0, str.indexOf("."))) < 10) {
                    return false;
                }
                return true;
            } catch (Exception e16) {
                printException(e16, "");
                return false;
            }
        } catch (Exception unused) {
        }
    }

    public static boolean isPackageExist(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            LOGI(InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 0).versionName, "");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isTimeOutRet(int i3) {
        if (i3 != 10 && i3 != 161 && i3 != 162 && i3 != 164 && i3 != 165 && i3 != 166 && i3 != 154 && (i3 < 128 || i3 > 143)) {
            return false;
        }
        return true;
    }

    @Deprecated
    public static boolean isWtLoginUrlV1(String str) {
        int indexOf;
        int i3;
        int i16;
        if (str == null || (indexOf = str.indexOf("?k=")) == -1 || (i16 = (i3 = indexOf + 3) + 32) > str.length()) {
            return false;
        }
        String substring = str.substring(i3, i16);
        if (base64_decode_url(substring.getBytes(), substring.length()) == null) {
            return false;
        }
        return true;
    }

    public static boolean isWtLoginUrlV2(String str) {
        String str2;
        if (str == null) {
            return false;
        }
        try {
            str2 = Uri.parse(str).getHost();
        } catch (Exception e16) {
            printException(e16);
            str2 = null;
        }
        if (!WT_LOGIN_URL_HOST.equals(str2)) {
            return false;
        }
        return isWtLoginUrlV1(str);
    }

    public static boolean is_wap_proxy_retry(Context context) {
        return false;
    }

    public static boolean is_wap_retry(Context context) {
        if (get_net_retry_type(context) == 0) {
            return false;
        }
        return true;
    }

    public static boolean loadLibrary(String str, Context context) {
        return false;
    }

    public static boolean needChangeGuid(Context context) {
        oicq.wlogin_sdk.persistence.c cVar = (oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO");
        long j3 = cVar.f422789b.getLong("change_guid_time", 0L);
        long e16 = u.e();
        LOGI("needChangeGuid delay:" + j3 + " now:" + e16, "");
        if (j3 == 0) {
            ((d) cVar.edit()).putLong("change_guid_time", e16 + (new Random().nextInt(GUID_DELAY_HOUR) * 60 * 60 * 1000)).commit();
            return false;
        }
        if (j3 < e16) {
            return false;
        }
        ((d) cVar.edit()).putLong("change_guid_time", 0L).commit();
        return true;
    }

    public static boolean need_pow_test(byte[] bArr) {
        String str;
        if (bArr != null && bArr.length > 0) {
            str = "need_pow_test false because not null";
        } else {
            String f16 = u.f();
            if (!TextUtils.isEmpty(f16) && f16.endsWith(":MSF")) {
                return get_pow_test(u.f422949w);
            }
            str = "need_pow_test false because not msf";
        }
        LOGI(str);
        return false;
    }

    public static Bundle packBundle(byte[][] bArr) {
        Bundle bundle = new Bundle();
        if (bArr != null && bArr.length > 0) {
            bundle.putInt(com.tencent.luggage.wxa.c8.c.E, bArr.length);
            for (int i3 = 0; i3 < bArr.length; i3++) {
                bundle.putByteArray(String.valueOf(i3), bArr[i3]);
            }
        }
        if (bundle.isEmpty()) {
            return null;
        }
        return bundle;
    }

    public static String printByte(byte[] bArr) {
        if (bArr == null) {
            return "null";
        }
        return String.valueOf(bArr.length);
    }

    public static void printException(Exception exc) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter((Writer) stringWriter, true);
        exc.printStackTrace(printWriter);
        printWriter.flush();
        stringWriter.flush();
        LOGW("exception:", stringWriter.toString());
    }

    public static void printThrowable(Throwable th5, String str) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter((Writer) stringWriter, true);
        th5.printStackTrace(printWriter);
        printWriter.flush();
        stringWriter.flush();
        LOGW("throwable", stringWriter.toString(), str);
    }

    public static byte[] readFile(String str) {
        if (str != null && str.length() != 0) {
            try {
                File file = new File(str);
                if (file.exists() && file.isFile()) {
                    FileInputStream fileInputStream = new FileInputStream(str);
                    int available = fileInputStream.available();
                    if (available > 528384) {
                        fileInputStream.close();
                        return null;
                    }
                    byte[] bArr = new byte[available];
                    fileInputStream.read(bArr);
                    fileInputStream.close();
                    return bArr;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static byte[] readLog(Context context, String str) {
        if (context != null && str != null && str.length() != 0) {
            return readFile(getLogFileName(context, str));
        }
        return null;
    }

    public static void saveGuidToFile(Context context, byte[] bArr) {
        if (context != null && bArr != null && bArr.length > 0) {
            LOGI("saveGuidToFile guid=" + buf_to_string(bArr), "");
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    File file = new File(context.getFilesDir().getAbsolutePath() + "/wlogin_device.dat");
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    if (file.exists() && file.canWrite()) {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file, false);
                        try {
                            fileOutputStream2.write(bArr);
                            fileOutputStream = fileOutputStream2;
                        } catch (Exception e16) {
                            e = e16;
                            fileOutputStream = fileOutputStream2;
                            printException(e, "");
                            if (fileOutputStream == null) {
                                return;
                            }
                            fileOutputStream.close();
                        } catch (Throwable th5) {
                            th = th5;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e17) {
                                    printException(e17, "");
                                }
                            }
                            throw th;
                        }
                    }
                    save_android_id(context, bArr);
                    if (fileOutputStream == null) {
                        return;
                    }
                } catch (Exception e18) {
                    e = e18;
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e19) {
                    printException(e19, "");
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
    }

    public static void saveInitKeyTime(Context context, int i3) {
        if (context != null) {
            try {
                d dVar = (d) ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO")).edit();
                dVar.putInt("InitKeyTime", i3);
                dVar.f422793b.commit();
                LOGI("saveInitKeyTime time:" + i3, "");
            } catch (Throwable th5) {
                printThrowable(th5, "saveReqTimeToSp");
            }
        }
    }

    public static void save_android_id(Context context, byte[] bArr) {
        if (context != null && bArr != null && bArr.length > 0) {
            d dVar = (d) ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO")).edit();
            dVar.putString(SharedPreferencedUtil.SP_KEY_ANDROID_ID, buf_to_string(bArr));
            dVar.f422793b.commit();
        }
    }

    public static void save_cost_time(Context context, String str) {
        if (context != null) {
            d dVar = (d) ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_COST")).edit();
            dVar.putString("costTime", str);
            dVar.f422793b.commit();
        }
    }

    public static void save_cost_trace(Context context, String str) {
        if (context != null) {
            d dVar = (d) ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_COST")).edit();
            dVar.putString("costTrace", str);
            dVar.f422793b.commit();
        }
    }

    public static void save_cur_flag(Context context, int i3) {
        if (context != null) {
            d dVar = (d) ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO")).edit();
            dVar.putInt("last_flag", i3);
            dVar.f422793b.commit();
        }
    }

    public static void save_cur_guid(Context context, byte[] bArr) {
        if (context != null && bArr != null && bArr.length > 0) {
            d dVar = (d) ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO")).edit();
            dVar.putString("last_guid", buf_to_string(bArr));
            dVar.f422793b.commit();
        }
    }

    public static void save_cur_mac(Context context, byte[] bArr) {
        if (context != null && bArr != null && bArr.length > 0) {
            d dVar = (d) ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO")).edit();
            dVar.putString("last_mac", buf_to_string(bArr));
            dVar.f422793b.commit();
        }
    }

    public static void save_network_type(Context context, int i3) {
        if (context != null) {
            d dVar = (d) ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO")).edit();
            dVar.putInt("network_type", i3);
            dVar.f422793b.commit();
        }
    }

    public static void save_pow_test(Context context, boolean z16) {
        if (context != null) {
            d dVar = (d) ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_COST")).edit();
            dVar.putBoolean("powTestNew", z16);
            dVar.f422793b.commit();
            LOGI("save_pow_test " + z16, "");
        }
    }

    public static void save_rsa_privkey(Context context, byte[] bArr) {
        if (context != null && bArr != null && bArr.length > 0) {
            d dVar = (d) ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO")).edit();
            dVar.putString("rsa_privkey", buf_to_string(bArr));
            dVar.f422793b.commit();
        }
    }

    public static void save_rsa_pubkey(Context context, byte[] bArr) {
        if (context != null && bArr != null && bArr.length > 0) {
            d dVar = (d) ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO")).edit();
            dVar.putString("rsa_pubkey", buf_to_string(bArr));
            dVar.f422793b.commit();
        }
    }

    public static boolean set_cp_pubkey(Context context, long j3, long j16) {
        if (context == null) {
            return false;
        }
        ContentResolver contentResolver = context.getContentResolver();
        Uri parse = Uri.parse("content://oicq.wlogin_sdk.WloginProvider/rsa_pubkey");
        LOGI(parse.toString());
        Cursor cursor = null;
        try {
            try {
                Cursor query = ContactsMonitor.query(contentResolver, parse, new String[]{"id", "appid", "subappid", "pubkey", "pubkey_md5"}, "appid=? and subappid=?", new String[]{"" + j3, "" + j16}, null);
                if (query == null) {
                    if (query != null) {
                        query.close();
                    }
                    return false;
                }
                String buf_to_string = buf_to_string(get_rsa_pubkey(context));
                if (buf_to_string.length() == 0) {
                    query.close();
                    return false;
                }
                String md5 = MD5.toMD5(buf_to_string);
                if (query.getCount() > 0) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("pubkey", buf_to_string);
                    contentValues.put("pubkey_md5", md5);
                    query.moveToNext();
                } else {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("appid", Long.valueOf(j3));
                    contentValues2.put("subappid", Long.valueOf(j16));
                    contentValues2.put("pubkey", buf_to_string);
                    contentValues2.put("pubkey_md5", md5);
                    LOGD("inserted uri: " + contentResolver.insert(parse, contentValues2) + ", with appid=" + j3 + ", subappid=" + j16);
                }
                query.close();
                return true;
            } catch (Exception e16) {
                printException(e16, "");
                if (0 != 0) {
                    cursor.close();
                }
                return false;
            }
        } catch (Throwable th5) {
            if (0 != 0) {
                cursor.close();
            }
            throw th5;
        }
    }

    public static void set_ksid(Context context, byte[] bArr) {
        if (context != null && bArr != null && bArr.length > 0) {
            byte[] bArr2 = get_ksid_new(context);
            if (bArr2 == null || bArr2.length <= 0) {
                d dVar = (d) ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO")).edit();
                dVar.putString("ksid", buf_to_string(bArr));
                dVar.f422793b.commit();
            }
        }
    }

    public static void set_net_retry_type(Context context, int i3) {
        if (context != null) {
            d dVar = (d) ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO")).edit();
            dVar.putInt("netretry_type", i3);
            dVar.f422793b.commit();
        }
    }

    public static void set_server_host1(Context context, byte[] bArr) {
        if (context != null && bArr != null && bArr.length > 0) {
            d dVar = (d) ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO")).edit();
            dVar.putString("host1", new String(bArr));
            dVar.f422793b.commit();
        }
    }

    public static void set_server_host2(Context context, byte[] bArr) {
        if (context != null && bArr != null && bArr.length > 0) {
            d dVar = (d) ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO")).edit();
            dVar.putString("host2", new String(bArr));
            dVar.f422793b.commit();
        }
    }

    public static void set_server_ipv6_host1(Context context, byte[] bArr) {
        if (context != null && bArr != null && bArr.length > 0) {
            d dVar = (d) ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO")).edit();
            dVar.putString("ipv6_host1", new String(bArr));
            dVar.f422793b.commit();
        }
    }

    public static void set_server_ipv6_host2(Context context, byte[] bArr) {
        if (context != null && bArr != null && bArr.length > 0) {
            d dVar = (d) ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO")).edit();
            dVar.putString("ipv6_host2", new String(bArr));
            dVar.f422793b.commit();
        }
    }

    public static void set_wap_server_host1(Context context, byte[] bArr) {
        if (context != null && bArr != null && bArr.length > 0) {
            d dVar = (d) ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO")).edit();
            dVar.putString("wap-host1", new String(bArr));
            dVar.f422793b.commit();
        }
    }

    public static void set_wap_server_host2(Context context, byte[] bArr) {
        if (context != null && bArr != null && bArr.length > 0) {
            d dVar = (d) ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO")).edit();
            dVar.putString("wap-host2", new String(bArr));
            dVar.f422793b.commit();
        }
    }

    public static void set_wap_server_ipv6_host1(Context context, byte[] bArr) {
        if (context != null && bArr != null && bArr.length > 0) {
            d dVar = (d) ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO")).edit();
            dVar.putString("wap-ipv6_host1", new String(bArr));
            dVar.f422793b.commit();
        }
    }

    public static void set_wap_server_ipv6_host2(Context context, byte[] bArr) {
        if (context != null && bArr != null && bArr.length > 0) {
            d dVar = (d) ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context, "WLOGIN_DEVICE_INFO")).edit();
            dVar.putString("wap-ipv6_host2", new String(bArr));
            dVar.f422793b.commit();
        }
    }

    public static boolean shouldKick(int i3) {
        if (i3 != -1000 && i3 != 257 && i3 != -1026) {
            return true;
        }
        return false;
    }

    public static byte[] string_to_buf(String str) {
        if (str == null) {
            return new byte[0];
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i3 = 0; i3 < str.length() / 2; i3++) {
            int i16 = i3 * 2;
            bArr[i3] = (byte) ((get_char((byte) str.charAt(i16)) << 4) + get_char((byte) str.charAt(i16 + 1)));
        }
        return bArr;
    }

    public static byte[][] unpackBundle(Bundle bundle) {
        if (bundle != null) {
            int i3 = bundle.getInt(com.tencent.luggage.wxa.c8.c.E);
            byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i3, 0);
            for (int i16 = 0; i16 < i3; i16++) {
                bArr[i16] = bundle.getByteArray(String.valueOf(i16));
            }
            return bArr;
        }
        return null;
    }

    public static synchronized void writeFile(String str, byte[] bArr) {
        File file;
        File parentFile;
        synchronized (util.class) {
            if (str != null) {
                if (str.length() != 0) {
                    try {
                        file = new File(str);
                    } catch (Exception unused) {
                    }
                    if (!file.exists() && ((parentFile = file.getParentFile()) == null || (!parentFile.mkdirs() && !parentFile.isDirectory()))) {
                        return;
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file, true);
                    fileOutputStream.write(bArr);
                    fileOutputStream.close();
                }
            }
        }
    }

    public static void LOGD(String str, String str2) {
        try {
            if (LOG_LEVEL >= 2) {
                LogCallBack logCallBack = LCB;
                if (logCallBack != null) {
                    logCallBack.OnLog(str, str2);
                } else if (LOGCAT_OUT) {
                    Log.d(TAG, str + ":" + str2);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void LOGI(String str, String str2) {
        try {
            if (LOG_LEVEL >= 1) {
                LogCallBack logCallBack = LCB;
                if (logCallBack != null) {
                    logCallBack.OnLog(str);
                } else if (LOGCAT_OUT) {
                    Log.i(TAG, str);
                }
                b.a(u.f422949w, str2, str);
            }
        } catch (Exception unused) {
        }
    }

    public static void LOGW(String str, String str2, String str3) {
        try {
            if (LOG_LEVEL >= 0) {
                LogCallBack logCallBack = LCB;
                if (logCallBack != null) {
                    logCallBack.OnLog(str, str2);
                } else if (LOGCAT_OUT) {
                    Log.w(TAG, str + ":" + str2);
                }
                b.a(u.f422949w, str3, str + ":" + str2);
            }
        } catch (Exception unused) {
        }
    }

    public static String buf_to_string(byte[] bArr, int i3) {
        String str = "";
        if (bArr == null) {
            return "";
        }
        if (i3 > bArr.length) {
            i3 = bArr.length;
        }
        for (int i16 = 0; i16 < i3; i16++) {
            str = (str + Integer.toHexString((bArr[i16] >> 4) & 15)) + Integer.toHexString(bArr[i16] & RegisterType.DOUBLE_HI);
        }
        return str;
    }

    public static byte[] get_rand_16byte(byte[] bArr) {
        try {
            byte[] seed = SecureRandom.getSeed(16);
            byte[] bArr2 = new byte[seed.length + bArr.length];
            System.arraycopy(seed, 0, bArr2, 0, seed.length);
            System.arraycopy(bArr, 0, bArr2, seed.length, bArr.length);
            return MD5.toMD5Byte(bArr2);
        } catch (Throwable unused) {
            return get_prand_16byte();
        }
    }

    public static void printException(Exception exc, String str) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter((Writer) stringWriter, true);
        exc.printStackTrace(printWriter);
        printWriter.flush();
        stringWriter.flush();
        LOGW("exception", stringWriter.toString(), str);
    }
}
