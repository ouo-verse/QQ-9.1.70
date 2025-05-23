package cooperation.qwallet.pluginshare.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.pluginshare.ITenCookie;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes28.dex */
public class TenCookieImpl implements ITenCookie {
    private static final String COOKIE_TAG = "qpay";
    private static final String KEY_HOSTS = "KEY_HOSTS";
    private static final String QB_TENPAY_HB_RANDOM = "q$WaQ3#k";
    private static final String QB_TENPAY_PAY = "qb_tenpay_cookies_";
    private static final String TAG = "TenCookie";
    private Map<String, List<String>> insCookies = new ConcurrentHashMap();
    private String qpayPattern = String.format("%s(\\w+)?=[%%\\w\\$\\(\\)\\[\\]\\*\\+\\.\\^\\|@#&-]*;", COOKIE_TAG);
    private String qpayKPattern = String.format("%s(\\w+)?=", COOKIE_TAG);
    private String domainPattern = "(?i)domain=[\\w\\.]+;";
    private String expirePattern = "(?i)expires=[\\w\\s:,]+;";
    private String uin = "";
    private int mIndex = 1;
    private Map<String, String> tempArgs = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray List2JArray(List<String> list) throws JSONException {
        return new JSONArray((Collection) list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getShareName() {
        return QB_TENPAY_PAY + this.uin;
    }

    public static String getUserKeyWithUin(String str) {
        return MD5.toMD5(MD5.toMD5(str) + QB_TENPAY_HB_RANDOM).substring(8, 24);
    }

    private List<String> jArray2List(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            arrayList.add(jSONArray.getString(i3));
        }
        return arrayList;
    }

    /*  JADX ERROR: NullPointerException in pass: BlockProcessor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getPredecessors()" because "to" is null
        	at jadx.core.dex.visitors.blocks.BlockSplitter.connect(BlockSplitter.java:157)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.connectSplittersAndHandlers(BlockExceptionHandler.java:480)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.wrapBlocksWithTryCatch(BlockExceptionHandler.java:381)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.connectExcHandlers(BlockExceptionHandler.java:90)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.process(BlockExceptionHandler.java:61)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.independentBlockTreeMod(BlockProcessor.java:325)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:51)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private java.lang.String prosOneHost(java.lang.String r12, java.util.List<java.lang.String> r13) {
        /*
            r11 = this;
            r0 = 0
            if (r13 == 0) goto Lca
            int r1 = r13.size()
            if (r1 > 0) goto Lb
            goto Lca
        Lb:
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            java.lang.String r2 = ""
            r1.<init>(r2)
            int r2 = r13.size()
            int r2 = r2 + (-1)
        L19:
            r3 = 2
            java.lang.String r4 = "TenCookie"
            if (r2 < 0) goto L9d
            java.lang.Object r5 = r13.get(r2)
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r6 = r11.expirePattern
            java.lang.String r7 = "expires="
            r8 = 0
            java.lang.String r6 = r11.regGet(r5, r6, r7, r8)
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 == 0) goto L36
            goto L99
        L36:
            java.util.Date r7 = new java.util.Date
            r7.<init>(r6)
            long r6 = r7.getTime()
            long r9 = com.tencent.mobileqq.msf.core.NetConnInfoCenter.getServerTimeMillis()
            int r9 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r9 <= 0) goto L7c
            boolean r8 = com.tencent.qphone.base.util.QLog.isColorLevel()
            if (r8 == 0) goto L78
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "cookie time out curTime = "
            r8.append(r9)
            long r9 = com.tencent.mobileqq.msf.core.NetConnInfoCenter.getServerTimeMillis()
            r8.append(r9)
            java.lang.String r9 = " expire = "
            r8.append(r9)
            r8.append(r6)
            java.lang.String r6 = " cookie = "
            r8.append(r6)
            r8.append(r5)
            java.lang.String r5 = r8.toString()
            com.tencent.qphone.base.util.QLog.i(r4, r3, r5)
        L78:
            r13.remove(r2)     // Catch: java.lang.IndexOutOfBoundsException -> L99
            goto L99
        L7c:
            java.lang.String r3 = r11.qpayPattern
            java.lang.String r3 = r11.regGet(r5, r3, r0, r8)
            if (r3 == 0) goto L99
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            java.lang.String r3 = ";"
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            r1.append(r3)
        L99:
            int r2 = r2 + (-1)
            goto L19
        L9d:
            boolean r13 = com.tencent.qphone.base.util.QLog.isColorLevel()
            if (r13 == 0) goto Lc5
            boolean r13 = android.text.TextUtils.isEmpty(r1)
            if (r13 != 0) goto Lc5
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r12)
            java.lang.String r12 = " -> "
            r13.append(r12)
            java.lang.String r12 = r1.toString()
            r13.append(r12)
            java.lang.String r12 = r13.toString()
            com.tencent.qphone.base.util.QLog.i(r4, r3, r12)
        Lc5:
            java.lang.String r12 = r1.toString()
            return r12
        Lca:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cooperation.qwallet.pluginshare.impl.TenCookieImpl.prosOneHost(java.lang.String, java.util.List):java.lang.String");
    }

    private String regGet(String str, String str2, String str3, boolean z16) {
        int i3;
        Matcher matcher = Pattern.compile(str2).matcher(str);
        if (matcher.find()) {
            int i16 = !z16 ? 1 : 0;
            int start = matcher.start();
            if (str3 != null) {
                i3 = str3.length();
            } else {
                i3 = 0;
            }
            return str.substring(start + i3, matcher.end() - i16);
        }
        return null;
    }

    private void repListIfExist(List<String> list, String str, String str2) throws Exception {
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).contains(str2)) {
                QLog.i(TAG, 2, "replace cookie " + str2);
                list.remove(size);
            }
        }
        list.add(str);
    }

    private void timeToShare(final Context context) {
        ThreadManagerV2.post(new Runnable() { // from class: cooperation.qwallet.pluginshare.impl.TenCookieImpl.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TenCookieImpl.class) {
                    SharedPreferences.Editor edit = context.getSharedPreferences(TenCookieImpl.this.getShareName(), 4).edit();
                    try {
                        try {
                            ArrayList arrayList = new ArrayList();
                            for (String str : TenCookieImpl.this.insCookies.keySet()) {
                                List list = (List) TenCookieImpl.this.insCookies.get(str);
                                edit.putString(str, TenCookieImpl.this.List2JArray(list).toString());
                                if (QLog.isColorLevel()) {
                                    QLog.i(TenCookieImpl.TAG, 2, str + " <<== " + TenCookieImpl.this.List2JArray(list).toString());
                                }
                                arrayList.add(str);
                            }
                            edit.putString(TenCookieImpl.KEY_HOSTS, new JSONArray((Collection) arrayList).toString());
                        } catch (Exception e16) {
                            QLog.e(TenCookieImpl.TAG, 1, "error msg in qqpay-impl module: ", e16);
                        }
                    } finally {
                        edit.apply();
                    }
                }
            }
        }, 2, null, true);
    }

    @Override // cooperation.qwallet.pluginshare.ITenCookie
    public boolean clearTempArgs(String str) {
        if (str == null) {
            this.tempArgs.clear();
            return true;
        }
        if (this.tempArgs.containsKey(str)) {
            this.tempArgs.remove(str);
            return true;
        }
        return false;
    }

    @Override // cooperation.qwallet.pluginshare.ITenCookie
    public String getEncryptValue(String str, String str2, SharedPreferences sharedPreferences) {
        byte[] bytes;
        byte[] bytes2;
        String userKeyWithUin = getUserKeyWithUin(str);
        String string = sharedPreferences.getString(str2 + "_" + userKeyWithUin, "");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getEncryptUserValue,encryptValue:" + string + ",userKey:" + userKeyWithUin);
        }
        Cryptor cryptor = new Cryptor();
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(userKeyWithUin)) {
            try {
                bytes = userKeyWithUin.getBytes("ISO8859_1");
            } catch (UnsupportedEncodingException unused) {
                bytes = userKeyWithUin.getBytes();
            }
            try {
                bytes2 = string.getBytes("ISO8859_1");
            } catch (UnsupportedEncodingException unused2) {
                bytes2 = string.getBytes();
            }
            byte[] decrypt = cryptor.decrypt(bytes2, bytes);
            if (decrypt != null) {
                try {
                    return new String(decrypt, "ISO8859_1");
                } catch (UnsupportedEncodingException unused3) {
                    return new String(decrypt);
                }
            }
        }
        return null;
    }

    @Override // cooperation.qwallet.pluginshare.ITenCookie
    public String getMsgNo(String str) {
        String format = new SimpleDateFormat(DateUtil.DATE_FORMAT_14).format(new Date());
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append(format);
        int i3 = this.mIndex;
        this.mIndex = i3 + 1;
        String valueOf = String.valueOf(i3);
        int length = (28 - sb5.length()) - valueOf.length();
        for (int i16 = 0; i16 < length; i16++) {
            sb5.append("0");
        }
        sb5.append(valueOf);
        return sb5.toString();
    }

    @Override // cooperation.qwallet.pluginshare.ITenCookie
    public String getTempArgs(String str) {
        if (this.tempArgs.containsKey(str)) {
            return this.tempArgs.get(str);
        }
        return null;
    }

    @Override // cooperation.qwallet.pluginshare.ITenCookie
    public String putEncryptValue(String str, String str2, SharedPreferences sharedPreferences, String str3) {
        byte[] bytes;
        byte[] bytes2;
        String str4;
        String userKeyWithUin = getUserKeyWithUin(str);
        String str5 = null;
        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(userKeyWithUin)) {
            try {
                bytes = userKeyWithUin.getBytes("ISO8859_1");
            } catch (UnsupportedEncodingException unused) {
                bytes = userKeyWithUin.getBytes();
            }
            try {
                bytes2 = str3.getBytes("ISO8859_1");
            } catch (UnsupportedEncodingException unused2) {
                bytes2 = str3.getBytes();
            }
            byte[] encrypt = new Cryptor().encrypt(bytes2, bytes);
            if (encrypt != null) {
                try {
                    str4 = new String(encrypt, "ISO8859_1");
                } catch (UnsupportedEncodingException unused3) {
                    str4 = new String(encrypt);
                }
                if (!TextUtils.isEmpty(str4)) {
                    sharedPreferences.edit().putString(str2 + "_" + userKeyWithUin, str4).apply();
                }
                str5 = str4;
            }
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "putEncryptUserValue,encryptValue:" + str5);
            }
        }
        return str5;
    }

    @Override // cooperation.qwallet.pluginshare.ITenCookie
    public String readTagCookie(Context context, String str, String str2) {
        QLog.i(TAG, 2, "readTagCookie this = " + this);
        if (TextUtils.isEmpty(str2) || context == null) {
            return null;
        }
        setUin(str);
        if (this.insCookies.size() <= 0) {
            synchronized (TenCookieImpl.class) {
                SharedPreferences sharedPreferences = context.getSharedPreferences(getShareName(), 4);
                String string = sharedPreferences.getString(KEY_HOSTS, null);
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "initialize cookie from share " + string);
                }
                if (!TextUtils.isEmpty(string)) {
                    try {
                        JSONArray jSONArray = new JSONArray(string);
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            String str3 = (String) jSONArray.get(i3);
                            String string2 = sharedPreferences.getString(str3, null);
                            if (!TextUtils.isEmpty(string2)) {
                                if (QLog.isColorLevel()) {
                                    QLog.i(TAG, 2, "initialize sdomain = " + str3 + ProgressTracer.SEPARATOR + string2);
                                }
                                this.insCookies.put(str3, jArray2List(new JSONArray(string2)));
                            }
                        }
                    } catch (Exception e16) {
                        QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e16);
                    }
                }
            }
        }
        QLog.i(TAG, 2, "readTagCookie insCookie size = " + this.insCookies.size());
        if (this.insCookies.size() <= 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer("");
        for (String str4 : this.insCookies.keySet()) {
            if (str2.equals(str4) || str2.contains(str4)) {
                QLog.i(TAG, 2, "domain matched, append : " + str4);
                String prosOneHost = prosOneHost(str2, this.insCookies.get(str4));
                if (!TextUtils.isEmpty(prosOneHost)) {
                    stringBuffer.append(prosOneHost);
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, str2 + " => " + stringBuffer.toString());
        }
        return stringBuffer.toString();
    }

    @Override // cooperation.qwallet.pluginshare.ITenCookie
    public String setTempArgs(String str, String str2) {
        String str3;
        if (this.tempArgs.containsKey(str)) {
            str3 = this.tempArgs.get(str);
        } else {
            str3 = null;
        }
        this.tempArgs.put(str, str2);
        return str3;
    }

    @Override // cooperation.qwallet.pluginshare.ITenCookie
    public boolean setUin(String str) {
        synchronized (TenCookieImpl.class) {
            if (!TextUtils.isEmpty(str) && !this.uin.equals(str)) {
                this.uin = str;
                this.insCookies.clear();
                QLog.i(TAG, 2, "change user...");
                return true;
            }
            return false;
        }
    }

    @Override // cooperation.qwallet.pluginshare.ITenCookie
    public void writeTagCookie(Context context, String str, List<String> list) {
        List<String> arrayList;
        if (context != null && list.size() > 0) {
            setUin(str);
            for (int size = list.size() - 1; size >= 0; size--) {
                String str2 = list.get(size);
                QLog.i(TAG, 2, "writeTagCookie cookie = " + str2 + " uin = " + this.uin);
                String regGet = regGet(str2, this.qpayKPattern, null, true);
                if (regGet != null) {
                    String regGet2 = regGet(str2, this.domainPattern, "domain=", false);
                    if (TextUtils.isEmpty(regGet2)) {
                        QLog.i(TAG, 2, regGet2 + "writeTagCookie domain error, abort...");
                        return;
                    }
                    QLog.i(TAG, 2, regGet2 + " <= " + str2);
                    if (this.insCookies.containsKey(regGet2)) {
                        arrayList = this.insCookies.get(regGet2);
                    } else {
                        arrayList = new ArrayList<>();
                    }
                    try {
                        repListIfExist(arrayList, str2, regGet);
                    } catch (Exception e16) {
                        QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e16);
                    }
                    this.insCookies.put(regGet2, arrayList);
                }
            }
            timeToShare(context);
        }
    }
}
