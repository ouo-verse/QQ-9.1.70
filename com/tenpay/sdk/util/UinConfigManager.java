package com.tenpay.sdk.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tenpay.QwLog;
import com.tenpay.proxy.DataProxy;
import com.tenpay.sdk.Cgi;
import com.tenpay.util.MD5;
import com.tenpay.util.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UinConfigManager {
    public static final String CONFIGFILE_PREF = "uinconfig_";
    public static final String CONFIGLASTTIME_KEY = "update_last";
    public static final String CONFIG_NAME_HB_ADS = "qpay_notice";
    public static final String CONFIG_NAME_PRODUCT = "qpay_product";
    public static final long DEFAULT_CLEARINTERVAL = 604800000;
    public static final long DEFAULT_INTERTIME = 60000;
    public static final long DEFAULT_INTERVAL = 1800000;
    public static final String KEY_ADS = "notice";
    public static final String KEY_ADS_HB_CLICK_DISAPPEAR = "click_disappear";
    public static final String KEY_ADS_HB_DAILY_NUM = "daily_num";
    public static final String KEY_ADS_HB_END_TIME = "end_time";
    public static final String KEY_ADS_HB_ID = "id";
    public static final String KEY_ADS_HB_LEVEL = "level";
    public static final String KEY_ADS_HB_PRIORITY = "priority";
    public static final String KEY_ADS_HB_START_TIME = "start_time";
    public static final String KEY_ADS_HB_TITLE = "title";
    public static final String KEY_ADS_HB_URL = "url";
    public static final String KEY_CLEARTIME = "clear_time";
    public static final String KEY_CLICKDISAP = "clickDisap";
    public static final String KEY_CONFIG_ARRAY = "config_array";
    public static final String KEY_CONFIG_IMAGE = "image";
    public static final String KEY_CONFIG_INFOS = "config_infos";
    public static final String KEY_CONFIG_NAME = "config_name";
    public static final String KEY_DISPLAYCOUNT = "displaycount";
    public static final String KEY_HB = "hb";
    public static final String KEY_LV1_MD5 = "md5";
    public static final String KEY_QRCODE = "paycode";
    public static final String KEY_UPDATE_INTERVAL = "update_interval";
    public static final String KEY_VERSION = "version";
    public static final int LEN_REVERSEAREA = 256;
    public static final String MD5_SALT = "qpay_config_2016_!@#";
    public static final String PREFER_NAME = "tenpay_uinconfig";
    public static final String RSAPKEY = "30819F300D06092A864886F70D010101050003818D0030818902818100DA6F21F276C1B455FFC378C9B6F14FAFC2B79EC6D1379A3C0A9B91716D40018F3245FECF8E223A6B705B75FAEF1A1263F2D5211D57E0798597E2B6416D09E6CB751E46CF79098B53151CA2C6527528708AA0130B7714FA928559102C8FC629A5BA8276A56921C97CA740730611B2C75F53866A4F373B82442674C1DF36F638E50203010001";
    private static final String TAG = "UinConfigManager";
    private static long mUpdateTime;
    private Context mAppContext;
    private HashMap<String, JSONObject> mConfigs;
    private String mFilePath;
    private HashMap<String, Properties> mMapProps;
    private RSAPublicKey mPubKey;
    private String mUin;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class Ins {
        public static UinConfigManager mInstance = new UinConfigManager();

        Ins() {
        }
    }

    UinConfigManager() {
    }

    private void cacheConfig(String str, JSONObject jSONObject) {
        if (this.mConfigs == null) {
            this.mConfigs = new HashMap<>();
        }
        if (this.mConfigs.size() < 10) {
            this.mConfigs.put(str, jSONObject);
        }
    }

    private JSONObject check_cacheConfig(Context context, String str, String str2, String str3, boolean z16) throws Exception {
        byte[] bArr = new byte[256];
        byte[] readEncrptConfigFile = ConfigUtil.readEncrptConfigFile(str2, 256, bArr);
        if (readEncrptConfigFile != null) {
            if (readEncrptConfigFile.length == 0) {
                return new JSONObject("");
            }
            if (bArr[0] != 0) {
                return null;
            }
            int i3 = bArr[2] & 255;
            if (bArr[i3 + 3] == 0 && bArr[1] == 0) {
                if (this.mPubKey == null) {
                    this.mPubKey = RSAUtils.getPubKeyFromStr(RSAPKEY);
                }
                if (this.mPubKey == null) {
                    return null;
                }
                byte[] bArr2 = new byte[i3];
                System.arraycopy(bArr, 3, bArr2, 0, i3);
                byte[] decryptWithRSA = RSAUtils.decryptWithRSA(bArr2, this.mPubKey);
                if (decryptWithRSA == null) {
                    return null;
                }
                String trim = new String(decryptWithRSA).trim();
                String str4 = new String(readEncrptConfigFile, Charset.forName("UTF8"));
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                messageDigest.update(readEncrptConfigFile);
                if ((RSAUtils.bcd2Str(messageDigest.digest()) + MD5_SALT).toLowerCase().equals(trim)) {
                    QwLog.i("check_cacheConfig jsonString =" + str4);
                    JSONObject jSONObject = new JSONObject(str4);
                    if (z16) {
                        cacheConfig(str3, jSONObject);
                    }
                    return jSONObject;
                }
            }
        }
        return null;
    }

    private void clearConfigDatas(Context context, String str) throws Exception {
        Properties mapProp;
        boolean z16;
        if (!str.equals(this.mUin) || (mapProp = getMapProp(CONFIG_NAME_HB_ADS)) == null) {
            return;
        }
        String property = mapProp.getProperty(KEY_CLEARTIME);
        if (property == null) {
            mapProp.setProperty(KEY_CLEARTIME, String.valueOf(System.currentTimeMillis() + 604800000));
            savePropFile(CONFIG_NAME_HB_ADS, mapProp);
            return;
        }
        if (Long.parseLong(property) > System.currentTimeMillis()) {
            return;
        }
        List<JSONObject> configs = getConfigs(context, str, null, null, false);
        ArrayList arrayList = new ArrayList();
        Iterator<JSONObject> it = configs.iterator();
        while (it.hasNext()) {
            getConfigIDS(it.next(), KEY_ADS, arrayList);
        }
        if (arrayList.size() == 0) {
            return;
        }
        Enumeration keys = mapProp.keys();
        while (keys.hasMoreElements()) {
            String str2 = (String) keys.nextElement();
            if (str2.startsWith(KEY_CLICKDISAP) || str2.startsWith(KEY_DISPLAYCOUNT)) {
                Iterator it5 = arrayList.iterator();
                while (true) {
                    if (it5.hasNext()) {
                        if (str2.endsWith((String) it5.next())) {
                            z16 = true;
                            break;
                        }
                    } else {
                        z16 = false;
                        break;
                    }
                }
                if (!z16) {
                    mapProp.remove(str2);
                }
            }
        }
        mapProp.setProperty(KEY_CLEARTIME, String.valueOf(System.currentTimeMillis() + 604800000));
        savePropFile(CONFIG_NAME_HB_ADS, mapProp);
    }

    private List<String> getConfigFileAllNames() throws Exception {
        ArrayList arrayList = new ArrayList();
        String[] list = new File(this.mFilePath).list();
        if (list != null) {
            for (String str : list) {
                if (str.startsWith(CONFIG_NAME_HB_ADS)) {
                    arrayList.add(str);
                }
            }
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    private String getConfigFileMd5(String str) {
        return MD5.getFileMD5(new File(this.mFilePath + str));
    }

    private static boolean getConfigIDS(JSONObject jSONObject, String str, List<String> list) throws Exception {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return false;
        }
        Iterator keys = optJSONObject.keys();
        if (keys != null) {
            while (keys.hasNext()) {
                JSONArray jSONArray = optJSONObject.getJSONArray((String) keys.next());
                if (jSONArray != null) {
                    int length = jSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        String string = ((JSONObject) jSONArray.get(i3)).getString("id");
                        if (string != null) {
                            list.add(string);
                        }
                    }
                }
            }
            return true;
        }
        return true;
    }

    public static synchronized List<JSONObject> getConfigJson(Context context, String str, String str2, String str3, String str4) throws Exception {
        List<JSONObject> configs;
        synchronized (UinConfigManager.class) {
            UinConfigManager uinConfigManager = getInstance();
            uinConfigManager.init(context, str);
            configs = uinConfigManager.getConfigs(context, str, str3, str4, true);
        }
        return configs;
    }

    private String getConfigPath(String str) {
        return this.mFilePath + getConfigFileName(str);
    }

    private String getConfigPropFilePath(String str) {
        return this.mFilePath + "qpay_prop_" + str;
    }

    private List<JSONObject> getConfigs(Context context, String str, String str2, String str3, boolean z16) throws Exception {
        ArrayList arrayList = new ArrayList();
        for (String str4 : getConfigFileAllNames()) {
            JSONObject specConfig = getSpecConfig(context, str, str4, false, str2, str3);
            if (specConfig != null) {
                if (z16) {
                    cacheConfig(str4, specConfig);
                }
                arrayList.add(specConfig);
            }
        }
        return arrayList;
    }

    public static synchronized int getDispCount(Context context, String str, String str2, String str3) {
        int displayCount;
        synchronized (UinConfigManager.class) {
            UinConfigManager uinConfigManager = getInstance();
            uinConfigManager.init(context, str2);
            try {
                displayCount = uinConfigManager.getDisplayCount(str, str3);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "", e16);
                return 0;
            }
        }
        return displayCount;
    }

    private int getDisplayCount(String str, String str2) throws Exception {
        return getTodayDisplayCount(str, str2, new SimpleDateFormat(DateUtil.DATE_FORMAT_8).format(new Date()));
    }

    private boolean getIdIsClickDisappeared(String str, String str2) {
        String mapPropValue = getMapPropValue(str, KEY_CLICKDISAP + str2);
        if (mapPropValue != null && mapPropValue.equals("1")) {
            return true;
        }
        return false;
    }

    private static UinConfigManager getInstance() {
        return Ins.mInstance;
    }

    public static synchronized boolean getIsClickDisappeared(Context context, String str, String str2, String str3) {
        boolean idIsClickDisappeared;
        synchronized (UinConfigManager.class) {
            UinConfigManager uinConfigManager = getInstance();
            uinConfigManager.init(context, str2);
            try {
                idIsClickDisappeared = uinConfigManager.getIdIsClickDisappeared(str, str3);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "", e16);
                return false;
            }
        }
        return idIsClickDisappeared;
    }

    private Properties getMapProp(String str) {
        Properties properties;
        HashMap<String, Properties> hashMap = this.mMapProps;
        InputStream inputStream = null;
        FileInputStream fileInputStream = null;
        if (hashMap != null) {
            properties = hashMap.get(str);
        } else {
            properties = null;
        }
        try {
            if (properties == null) {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(getConfigPropFilePath(str));
                    try {
                        try {
                            Properties properties2 = new Properties();
                            try {
                                properties2.load(fileInputStream2);
                                putMapProp(str, properties2);
                                Utils.closeObject(fileInputStream2);
                                properties = properties2;
                                inputStream = properties2;
                            } catch (Exception e16) {
                                e = e16;
                                properties = properties2;
                                fileInputStream = fileInputStream2;
                                QLog.e(TAG, 1, "", e);
                                Utils.closeObject(fileInputStream);
                                inputStream = fileInputStream;
                                return properties;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            inputStream = fileInputStream2;
                            Utils.closeObject(inputStream);
                            throw th;
                        }
                    } catch (Exception e17) {
                        e = e17;
                    }
                } catch (Exception e18) {
                    e = e18;
                }
            }
            return properties;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private String getMapPropValue(String str, String str2) {
        Properties mapProp = getMapProp(str);
        if (mapProp != null) {
            return mapProp.getProperty(str2);
        }
        return null;
    }

    private JSONObject getSpecConfig(Context context, String str, String str2, boolean z16, String str3, String str4) throws Exception {
        JSONObject jSONObject;
        if (!this.mUin.equals(str)) {
            return null;
        }
        HashMap<String, JSONObject> hashMap = this.mConfigs;
        if (hashMap != null && !z16) {
            jSONObject = hashMap.get(str2);
        } else {
            jSONObject = null;
        }
        if (jSONObject == null) {
            jSONObject = check_cacheConfig(context, str, getConfigPath(str2), str2, false);
        }
        if (jSONObject == null) {
            return null;
        }
        if (str3 != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject(str3);
            if (optJSONObject == null) {
                return null;
            }
            if (str4 != null && !optJSONObject.has(str4)) {
                return null;
            }
        }
        return jSONObject;
    }

    private int getTodayDisplayCount(String str, String str2, String str3) throws Exception {
        String mapPropValue = getMapPropValue(str, KEY_DISPLAYCOUNT + str2);
        if (mapPropValue == null || !mapPropValue.substring(0, 8).equals(str3)) {
            return 0;
        }
        return Integer.parseInt(mapPropValue.substring(8));
    }

    public static synchronized void incDispCount(Context context, String str, String str2, String str3) {
        synchronized (UinConfigManager.class) {
            UinConfigManager uinConfigManager = getInstance();
            uinConfigManager.init(context, str2);
            try {
                uinConfigManager.increaseDisplayCount(str, str3);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "", e16);
            }
        }
    }

    private void increaseDisplayCount(String str, String str2) throws Exception {
        String format = new SimpleDateFormat(DateUtil.DATE_FORMAT_8).format(new Date());
        int todayDisplayCount = getTodayDisplayCount(str, str2, format) + 1;
        putMapPropValue(str, KEY_DISPLAYCOUNT + str2, format + todayDisplayCount);
    }

    private void init(Context context, String str) {
        String str2 = this.mUin;
        if (str2 != null) {
            if (!str2.equals(str)) {
                HashMap<String, JSONObject> hashMap = this.mConfigs;
                if (hashMap != null) {
                    hashMap.clear();
                }
                setUin(context, str);
                return;
            }
            return;
        }
        setUin(context, str);
    }

    private boolean isNeedUpdateIntime(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFER_NAME + this.mUin, 0);
        long j3 = sharedPreferences.getLong("update_interval", 0L);
        long j16 = sharedPreferences.getLong(this.mUin + CONFIGLASTTIME_KEY, 0L);
        if (j3 == 0) {
            j3 = 1800000;
        }
        if (System.currentTimeMillis() < j3 + j16) {
            return false;
        }
        return true;
    }

    public static boolean isTrustDomain(String str) {
        if (str == null) {
            return false;
        }
        try {
            String host = new URL(str.toLowerCase()).getHost();
            if (!host.endsWith("qq.com")) {
                if (!host.endsWith(Cgi.TENPAY_DOMAIN)) {
                    return false;
                }
            }
            return true;
        } catch (MalformedURLException unused) {
            return false;
        }
    }

    private void putMapProp(String str, Properties properties) {
        if (this.mMapProps == null) {
            this.mMapProps = new HashMap<>();
        }
        this.mMapProps.put(str, properties);
    }

    private void putMapPropValue(String str, String str2, String str3) {
        Properties mapProp = getMapProp(str);
        if (mapProp == null) {
            mapProp = new Properties();
            putMapProp(str, mapProp);
        } else {
            String property = mapProp.getProperty(str2);
            if (property != null && property.equals(str3)) {
                return;
            }
        }
        mapProp.setProperty(str2, str3);
        savePropFile(str, mapProp);
    }

    private boolean saveConfigInterval(long j3) {
        SharedPreferences.Editor edit = this.mAppContext.getSharedPreferences(PREFER_NAME + this.mUin, 0).edit();
        if (j3 > 0) {
            edit.putLong("update_interval", j3);
        }
        edit.commit();
        return true;
    }

    private void saveConfigLastTime(String str, long j3) {
        SharedPreferences.Editor edit = this.mAppContext.getSharedPreferences(PREFER_NAME + str, 0).edit();
        edit.putLong(str + CONFIGLASTTIME_KEY, j3);
        edit.commit();
    }

    private void savePropFile(String str, Properties properties) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(getConfigPropFilePath(str));
                try {
                    properties.store(fileOutputStream2, (String) null);
                    Utils.closeObject(fileOutputStream2);
                } catch (Exception e16) {
                    e = e16;
                    fileOutputStream = fileOutputStream2;
                    QLog.e(TAG, 1, "", e);
                    Utils.closeObject(fileOutputStream);
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = fileOutputStream2;
                    Utils.closeObject(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    private void setIdIsClickDisappeared(String str, String str2) {
        putMapPropValue(str, KEY_CLICKDISAP + str2, "1");
    }

    public static synchronized void setIsClickDisappeared(Context context, String str, String str2, String str3) {
        synchronized (UinConfigManager.class) {
            UinConfigManager uinConfigManager = getInstance();
            uinConfigManager.init(context, str2);
            try {
                uinConfigManager.setIdIsClickDisappeared(str, str3);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "", e16);
            }
        }
    }

    private void setUin(Context context, String str) {
        this.mAppContext = context.getApplicationContext();
        this.mUin = str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(DataProxy.getTenpayInternalPath());
        sb5.append(str);
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append("qpayconfig");
        sb5.append(str2);
        this.mFilePath = sb5.toString();
        File file = new File(this.mFilePath);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    private String getConfigFileName(String str) {
        return str;
    }
}
