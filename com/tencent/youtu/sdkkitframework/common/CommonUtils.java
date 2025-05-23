package com.tencent.youtu.sdkkitframework.common;

import com.tencent.component.media.image.ProgressTracer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.tvkplayer.dex.sdkupdate.TVKUpdateInfo;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.jf.dexlib2.analysis.RegisterType;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class CommonUtils {
    static IPatchRedirector $redirector_ = null;
    private static final String ALGORITHM = "TC3-HMAC-SHA256";
    private static final String CT_JSON = "application/json;";
    private static final String HOST = "ocr.tencentcloudapi.com";
    public static final int MAX_TIMEOUT_MS = 30000;
    public static final int MIN_TIMEOUT_MS = 0;
    private static final String SERVICE = "ocr";
    private static final String TAG = "CommonUtils";
    private static final String UTF8 = "UTF-8";
    private static ConcurrentHashMap<String, BenchMarkTime> benchMarkMaps;
    private static final char[] hexCode;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class BenchMarkTime {
        static IPatchRedirector $redirector_;
        public long avg;
        public long begin;
        public long cur;
        public long max;
        public long min;
        public long tick;
        public long total;

        public BenchMarkTime() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.total = 0L;
            this.tick = 0L;
            this.cur = 0L;
            this.avg = 0L;
            this.min = Long.MAX_VALUE;
            this.max = Long.MIN_VALUE;
        }

        private void update(long j3) {
            this.tick++;
            this.min = Math.min(j3, this.min);
            this.max = Math.max(j3, this.max);
            long j16 = this.total + j3;
            this.total = j16;
            this.avg = j16 / this.tick;
        }

        public void begin() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.begin = System.currentTimeMillis();
            }
        }

        public void end() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.begin;
            this.cur = currentTimeMillis;
            update(currentTimeMillis);
        }

        public String getTime() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return "avg: " + this.avg + "ms min: " + this.min + "ms max: " + this.max + "ms cur: " + this.cur + "ms";
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13703);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            benchMarkMaps = new ConcurrentHashMap<>();
            hexCode = "0123456789ABCDEF".toCharArray();
        }
    }

    public CommonUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String Base64Encode(byte[] bArr) {
        return Base64.getEncoder().encodeToString(bArr);
    }

    public static byte[] HmacSha1(byte[] bArr, String str) {
        Mac mac = Mac.getInstance(KeyPropertiesCompact.KEY_ALGORITHM_HMAC_SHA1);
        mac.init(new SecretKeySpec(str.getBytes(), KeyPropertiesCompact.KEY_ALGORITHM_HMAC_SHA1));
        return mac.doFinal(bArr);
    }

    public static void benchMarkBegin(String str) {
        if (!benchMarkMaps.containsKey(str)) {
            benchMarkMaps.put(str, new BenchMarkTime());
        }
        benchMarkMaps.get(str).begin();
    }

    public static long benchMarkEnd(String str) {
        if (!benchMarkMaps.containsKey(str)) {
            return 0L;
        }
        BenchMarkTime benchMarkTime = benchMarkMaps.get(str);
        benchMarkTime.end();
        YtLogger.d("CommonUtils", "benchMarkEnd -- " + str + ProgressTracer.SEPARATOR + benchMarkTime.cur + "ms");
        return benchMarkTime.cur;
    }

    public static String byteToHex(byte b16) {
        return new String(new char[]{Character.forDigit((b16 >> 4) & 15, 16), Character.forDigit(b16 & RegisterType.DOUBLE_HI, 16)});
    }

    public static String bytesToHexFun(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder(bArr.length * 2);
        for (byte b16 : bArr) {
            sb5.append(String.format("%02x", Integer.valueOf(b16 & 255)));
        }
        return sb5.toString();
    }

    public static String encodeHexString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b16 : bArr) {
            stringBuffer.append(byteToHex(b16));
        }
        return stringBuffer.toString();
    }

    public static HashMap<String, String> getAuthorization(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String format = simpleDateFormat.format(new Date(Long.parseLong(valueOf + TVKUpdateInfo.APP_ID)));
        String str8 = "POST\n/\n\ncontent-type:application/json\nhost:ocr.tencentcloudapi.com\n\ncontent-type;host\n" + sha256Hex(str);
        String str9 = format + "/" + SERVICE + "/tc3_request";
        String str10 = "TC3-HMAC-SHA256 Credential=" + str2 + "/" + str9 + ", SignedHeaders=content-type;host, Signature=" + bytesToHexFun(hmac256(hmac256(hmac256(hmac256(("TC3" + str3).getBytes("UTF-8"), format), SERVICE), "tc3_request"), "TC3-HMAC-SHA256\n" + valueOf + "\n" + str9 + "\n" + sha256Hex(str8)));
        HashMap<String, String> hashMap = new HashMap<>();
        if (str4 != null && !str4.isEmpty()) {
            hashMap.put("X-TC-Token", str4);
        }
        hashMap.put("Authorization", str10);
        hashMap.put("Content-Type", CT_JSON);
        hashMap.put("Host", HOST);
        hashMap.put("X-TC-Action", str5);
        hashMap.put("X-TC-Timestamp", valueOf);
        hashMap.put("X-TC-Version", str6);
        hashMap.put("X-TC-Region", str7);
        return hashMap;
    }

    public static String getBenchMarkTime(String str) {
        if (!benchMarkMaps.containsKey(str)) {
            return "";
        }
        return "[" + str + "]" + benchMarkMaps.get(str).getTime();
    }

    private static byte[] getSignature(String str, String str2) {
        Mac mac = Mac.getInstance(KeyPropertiesCompact.KEY_ALGORITHM_HMAC_SHA1);
        mac.init(new SecretKeySpec(str2.getBytes(), mac.getAlgorithm()));
        return mac.doFinal(str.getBytes());
    }

    public static String getYouTuAppSign(long j3, String str, String str2, String str3) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String format = String.format("a=%d&b=%s&k=%s&t=%d&e=%d&r=%d", Long.valueOf(j3), str3, str, Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis + 2592000), Integer.valueOf(Math.abs(new Random().nextInt())));
        byte[] HmacSha1 = HmacSha1(format, str2);
        byte[] bArr = new byte[HmacSha1.length + format.getBytes().length];
        System.arraycopy(HmacSha1, 0, bArr, 0, HmacSha1.length);
        System.arraycopy(format.getBytes(), 0, bArr, HmacSha1.length, format.getBytes().length);
        return Base64Encode(bArr);
    }

    public static String getYouTuAppSignTC3(String str, String str2, String str3, String str4) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String format = simpleDateFormat.format(new Date(Long.valueOf(str4 + TVKUpdateInfo.APP_ID).longValue()));
        String str5 = "POST\n/\n\ncontent-type:application/json\nhost:ocr.tencentcloudapi.com\n\ncontent-type;host\n" + sha256Hex(str3);
        String str6 = format + "/" + SERVICE + "/tc3_request";
        return "TC3-HMAC-SHA256 Credential=" + str + "/" + str6 + ", SignedHeaders=content-type;host, Signature=" + bytesToHexFun(hmac256(hmac256(hmac256(hmac256(("TC3" + str2).getBytes("UTF-8"), format), SERVICE), "tc3_request"), "TC3-HMAC-SHA256\n" + str4 + "\n" + str6 + "\n" + sha256Hex(str5))).toLowerCase();
    }

    public static String getYoutuOpenAppSign(String str, String str2, String str3, String str4) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String str5 = "a=" + str + "&k=" + str2 + "&e=" + (2592000 + currentTimeMillis) + "&t=" + currentTimeMillis + "&r=" + Math.abs(new Random().nextInt()) + "&u=" + str4 + "&f=";
        byte[] signature = getSignature(str5, str3);
        byte[] bArr = new byte[signature.length + str5.getBytes().length];
        System.arraycopy(signature, 0, bArr, 0, signature.length);
        System.arraycopy(str5.getBytes(), 0, bArr, signature.length, str5.getBytes().length);
        return new String(android.util.Base64.encode(bArr, 2));
    }

    public static byte[] hmac256(byte[] bArr, String str) {
        Mac mac = Mac.getInstance(KeyPropertiesCompact.KEY_ALGORITHM_HMAC_SHA256);
        mac.init(new SecretKeySpec(bArr, mac.getAlgorithm()));
        return mac.doFinal(str.getBytes("UTF-8"));
    }

    public static String makeMessageJson(int i3, String str, String str2) {
        try {
            new JSONObject(str2);
            return str2;
        } catch (Exception unused) {
            return "{ \"errorcode\":" + i3 + ",\"errormsg\": \"" + str + "\",\"extrainfo\":\"" + str2 + "\"}";
        }
    }

    public static String printHexBinary(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder(bArr.length * 2);
        for (byte b16 : bArr) {
            char[] cArr = hexCode;
            sb5.append(cArr[(b16 >> 4) & 15]);
            sb5.append(cArr[b16 & RegisterType.DOUBLE_HI]);
        }
        return sb5.toString();
    }

    public static void reportException(String str, Exception exc) {
        YtSDKStats.getInstance().reportInfo(str + " cause exception: " + exc.getLocalizedMessage());
        YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>(exc) { // from class: com.tencent.youtu.sdkkitframework.common.CommonUtils.1
            static IPatchRedirector $redirector_;
            public final /* synthetic */ Exception val$e;

            {
                this.val$e = exc;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) exc);
                    return;
                }
                put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.PROCESS_FIN);
                put(StateEvent.Name.UI_TIPS, StringCode.RST_FAILED);
                put(StateEvent.Name.PROCESS_RESULT, "failed");
                put("error_code", 3145728);
                put("message", CommonUtils.makeMessageJson(3145728, StringCode.RST_FAILED, exc.getLocalizedMessage()));
            }
        });
    }

    public static String sha256Hex(String str) {
        return printHexBinary(MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA256).digest(str.getBytes("UTF-8"))).toLowerCase();
    }

    public static byte[] HmacSha1(String str, String str2) {
        return HmacSha1(str.getBytes(), str2);
    }
}
