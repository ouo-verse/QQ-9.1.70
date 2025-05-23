package cooperation.qzone.networkedmodule;

import NS_MOBILE_CLIENT_UPDATE.SQ_CLIENT_UPDATE_RSP;
import NS_MOBILE_CLIENT_UPDATE.UPDATE_INFO;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QUA;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class QzoneModuleConfigManager {
    public static final String QZONE_MODULE_CONFIG_CUR = "NetworkedModuleConfig_cur";
    private static final String TAG = "QzoneModuleConfigManager";
    private static volatile QzoneModuleConfigManager sConfigManager;
    private Map<String, QzoneModuleRecord> mCurModules = jsonStr2moduleRecord(LocalMultiProcConfig.getString(LocalMultiProcConfig.PREFS_NAME_QZ_SETTING, QZONE_MODULE_CONFIG_CUR, ""));
    private Map<String, QzoneModuleRecord> mUpdateModules = new ConcurrentHashMap();

    QzoneModuleConfigManager() {
    }

    public static QzoneModuleConfigManager getInstance() {
        if (sConfigManager == null) {
            synchronized (TAG) {
                if (sConfigManager == null) {
                    sConfigManager = new QzoneModuleConfigManager();
                }
            }
        }
        return sConfigManager;
    }

    static Map<String, QzoneModuleRecord> jsonStr2moduleRecord(String str) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray optJSONArray = new JSONObject(str).optJSONArray(QzoneModuleConst.QZONE_MODULE_CONFIG_NETWORKED_MODULE);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        JSONObject jSONObject = optJSONArray.getJSONObject(i3);
                        String optString = jSONObject.optString("module_id");
                        String optString2 = jSONObject.optString(QzoneModuleConst.QZONE_MODULE_CONFIG_MODULE_MD5);
                        String optString3 = jSONObject.optString(QzoneModuleConst.QZONE_MODULE_CONFIG_MODULE_URL);
                        String optString4 = jSONObject.optString(QzoneModuleConst.QZONE_MODULE_CONFIG_MODULE_VERSION);
                        String optString5 = jSONObject.optString(QzoneModuleConst.QZONE_MODULE_CONFIG_MODULE_MAIN_VERSION);
                        String optString6 = jSONObject.optString(QzoneModuleConst.QZONE_MODULE_CONFIG_MODULE_KEY_CLASS_NAME);
                        String optString7 = jSONObject.optString(QzoneModuleConst.QZONE_MODULE_CONFIG_MODULE_CLASS_IDS);
                        int optInt = jSONObject.optInt(QzoneModuleConst.QZONE_MODULE_CONFIG_MODULE_KEY_CLASS_IDS_COUNT);
                        long optLong = jSONObject.optLong(QzoneModuleConst.QZONE_MODULE_CONFIG_MODULE_FILE_LENGTH);
                        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString2)) {
                            QzoneModuleRecordBuilder qzoneModuleRecordBuilder = new QzoneModuleRecordBuilder();
                            qzoneModuleRecordBuilder.setModuleId(optString).setVersion(optString4).setMainVersion(optString5).setUrl(optString3).setMD5(optString2).setKeyClassName(optString6).setClassIds(optString7).setClassIdsCount(optInt).setModuleFileLength(optLong);
                            QzoneModuleRecord build = qzoneModuleRecordBuilder.build();
                            concurrentHashMap.put(build.mModuleId, build);
                        }
                    }
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
                QLog.e(TAG, 1, th5, new Object[0]);
            }
        }
        return concurrentHashMap;
    }

    private QzoneModuleRecord parseModuleInfo(UPDATE_INFO update_info) {
        String str;
        String str2;
        String str3;
        String str4 = update_info.f24971id;
        String str5 = update_info.md5;
        if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 1, "id:" + str4);
        }
        String str6 = update_info.ver;
        String str7 = update_info.mainVersion;
        Map<Integer, String> map = update_info.plugin_info;
        int i3 = 0;
        if (map != null) {
            str = map.get(2);
            str3 = update_info.plugin_info.get(0);
            str2 = update_info.plugin_info.get(1);
            if (!TextUtils.isEmpty(str2)) {
                String[] split = str2.split("#");
                if (split.length >= 2) {
                    try {
                        i3 = Integer.parseInt(split[0]);
                        str2 = split[1];
                    } catch (NumberFormatException e16) {
                        QLog.e(TAG, 1, "catch an exception: ", e16);
                    }
                }
            }
        } else {
            str = "";
            str2 = "";
            str3 = str2;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "id:" + str4 + " ,md5:" + str5 + ",url:" + str3 + " ,keyClassName:" + str + ",version:" + str6 + ",mainVersion:" + str7 + ",classIds:" + str2 + ",classIDsCount:" + i3);
        }
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str5)) {
            return null;
        }
        QzoneModuleRecordBuilder qzoneModuleRecordBuilder = new QzoneModuleRecordBuilder();
        qzoneModuleRecordBuilder.setModuleId(str4).setVersion(str6).setMainVersion(str7).setUrl(str3).setMD5(str5).setKeyClassName(str).setClassIds(str2).setClassIdsCount(i3).setModuleFileLength(0L);
        return qzoneModuleRecordBuilder.build();
    }

    public synchronized QzoneModuleRecord getModuleRecord(String str) {
        QzoneModuleRecord qzoneModuleRecord;
        qzoneModuleRecord = this.mCurModules.get(str);
        QzoneModuleRecord qzoneModuleRecord2 = this.mUpdateModules.get(str);
        if (qzoneModuleRecord2 == null) {
            qzoneModuleRecord2 = QzoneModuleRecordFactory.getInstance().createRecord(str);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("try to create record locally,success ? : ");
            sb5.append(String.valueOf(qzoneModuleRecord2 != null));
            QLog.i(TAG, 2, sb5.toString());
            if (qzoneModuleRecord2 != null) {
                this.mUpdateModules.put(str, qzoneModuleRecord2);
            }
        }
        if (qzoneModuleRecord != null) {
            qzoneModuleRecord.mNewVersion = qzoneModuleRecord2;
        } else if (qzoneModuleRecord2 != null) {
            qzoneModuleRecord2.mNewVersion = qzoneModuleRecord2;
            String str2 = qzoneModuleRecord2.mMD5;
            if (TextUtils.equals(str2, str2)) {
                qzoneModuleRecord2.mModuleFileLength = qzoneModuleRecord2.mModuleFileLength;
            }
            qzoneModuleRecord = qzoneModuleRecord2;
        }
        if (qzoneModuleRecord != null) {
            QzoneModuleRecord qzoneModuleRecord3 = qzoneModuleRecord.mNewVersion;
            if (qzoneModuleRecord3 != null && !TextUtils.isEmpty(qzoneModuleRecord3.mQua) && !QUA.getQUA3().equalsIgnoreCase(qzoneModuleRecord.mNewVersion.mQua)) {
                QLog.i(TAG, 1, "mNewVersion.mQua=" + qzoneModuleRecord.mNewVersion.mQua + " is not equal QUA=" + QUA.getQUA3());
                qzoneModuleRecord.mNewVersion = null;
            }
            if (!TextUtils.isEmpty(qzoneModuleRecord.mQua) && !QUA.getQUA3().equalsIgnoreCase(qzoneModuleRecord.mQua)) {
                QLog.i(TAG, 1, "curRecord.mQua=" + qzoneModuleRecord.mQua + " is not equal QUA=" + QUA.getQUA3());
                QzoneModuleRecord qzoneModuleRecord4 = qzoneModuleRecord.mNewVersion;
                if (qzoneModuleRecord4 != null && qzoneModuleRecord.mMD5.equalsIgnoreCase(qzoneModuleRecord4.mMD5)) {
                    qzoneModuleRecord = qzoneModuleRecord.mNewVersion;
                    updateConfigAfterDownloaded(qzoneModuleRecord);
                    QLog.i(TAG, 1, "curRecord and updateRecord has the same md5,so needn't to download again,just call updateConfigAfterDownloaded to update cur configs");
                } else {
                    qzoneModuleRecord = qzoneModuleRecord.mNewVersion;
                }
            }
        }
        return qzoneModuleRecord;
    }

    public ArrayList<UPDATE_INFO> getUpdateInfo() {
        ArrayList<UPDATE_INFO> arrayList = new ArrayList<>();
        for (String str : QzoneModuleConst.QZONE_MODULES_QBOSS) {
            UPDATE_INFO update_info = new UPDATE_INFO();
            update_info.f24971id = str;
            QzoneModuleRecord qzoneModuleRecord = this.mCurModules.get(str);
            if (qzoneModuleRecord != null) {
                update_info.ver = qzoneModuleRecord.mVersion;
            } else {
                update_info.ver = "0";
            }
            arrayList.add(update_info);
            QLog.i(TAG, 1, "getUpdateInfo:" + str);
        }
        return arrayList;
    }

    public synchronized void handleModuleRsp(SQ_CLIENT_UPDATE_RSP sq_client_update_rsp) {
        ArrayList<UPDATE_INFO> arrayList;
        QLog.i(TAG, 1, "handleModuleRsp:");
        if (sq_client_update_rsp != null && (arrayList = sq_client_update_rsp.vModule) != null && arrayList.size() > 0) {
            QLog.i(TAG, 1, "handleModuleRsp:" + sq_client_update_rsp.vModule.size());
            Iterator<UPDATE_INFO> it = sq_client_update_rsp.vModule.iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                UPDATE_INFO next = it.next();
                QzoneModuleRecord parseModuleInfo = parseModuleInfo(next);
                if (parseModuleInfo != null) {
                    this.mUpdateModules.put(parseModuleInfo.mModuleId, parseModuleInfo);
                }
                int i3 = next.actype;
                if (i3 == 4) {
                    QLog.w(TAG, 1, "clear module config:" + next.f24971id);
                    QzoneModuleRecord qzoneModuleRecord = this.mCurModules.get(next.f24971id);
                    if (qzoneModuleRecord != null) {
                        File file = new File(QzoneModuleConst.getModuleSavePath(BaseApplicationImpl.getApplication(), qzoneModuleRecord));
                        if (file.exists()) {
                            file.delete();
                        }
                        this.mCurModules.remove(next.f24971id);
                        z16 = true;
                    }
                    if (this.mUpdateModules.containsKey(next.f24971id)) {
                        this.mUpdateModules.remove(next.f24971id);
                    }
                    QzoneModuleConst.clearLastCrashCount(next.f24971id);
                } else if (i3 != 0) {
                    QLog.w(TAG, 1, "force update module config:" + next.f24971id);
                    QzoneModuleRecord qzoneModuleRecord2 = this.mCurModules.get(next.f24971id);
                    if (qzoneModuleRecord2 != null) {
                        this.mCurModules.remove(next.f24971id);
                        if (!qzoneModuleRecord2.mMD5.equalsIgnoreCase(next.md5)) {
                            File file2 = new File(QzoneModuleConst.getModuleSavePath(BaseApplicationImpl.getApplication(), qzoneModuleRecord2));
                            if (file2.exists()) {
                                file2.delete();
                            }
                            QLog.w(TAG, 1, "force update module md5 is not same,so just delete local file and config:" + next.f24971id);
                        } else if (parseModuleInfo != null) {
                            this.mCurModules.put(next.f24971id, parseModuleInfo);
                            QLog.w(TAG, 1, "force update module md5 is same,so just update config:" + next.f24971id);
                            QzoneModuleConst.clearLastCrashCount(next.f24971id);
                        }
                        z16 = true;
                    }
                }
            }
            if (z16) {
                LocalMultiProcConfig.putString(LocalMultiProcConfig.PREFS_NAME_QZ_SETTING, QZONE_MODULE_CONFIG_CUR, moduleRecord2JsonStr(this.mCurModules));
            }
        }
    }

    public synchronized void putModuleRecord(QzoneModuleRecord qzoneModuleRecord) {
        this.mUpdateModules.put(qzoneModuleRecord.mModuleId, qzoneModuleRecord);
    }

    public synchronized void updateConfigAfterDownloaded(QzoneModuleRecord qzoneModuleRecord) {
        if (qzoneModuleRecord != null) {
            this.mUpdateModules.remove(qzoneModuleRecord.mModuleId);
            QzoneModuleRecord qzoneModuleRecord2 = this.mCurModules.get(qzoneModuleRecord.mModuleId);
            if (qzoneModuleRecord2 != null && !qzoneModuleRecord2.mMD5.equalsIgnoreCase(qzoneModuleRecord.mMD5)) {
                File file = new File(QzoneModuleConst.getModuleSavePath(BaseApplicationImpl.getApplication(), qzoneModuleRecord2));
                if (file.exists()) {
                    file.delete();
                }
            }
            File file2 = new File(QzoneModuleConst.getModuleSavePath(BaseApplicationImpl.getApplication(), qzoneModuleRecord));
            if (file2.exists()) {
                qzoneModuleRecord.mModuleFileLength = file2.length();
            }
            this.mCurModules.put(qzoneModuleRecord.mModuleId, qzoneModuleRecord);
            LocalMultiProcConfig.putString(LocalMultiProcConfig.PREFS_NAME_QZ_SETTING, QZONE_MODULE_CONFIG_CUR, moduleRecord2JsonStr(this.mCurModules));
            QzoneModuleConst.clearLastCrashCount(qzoneModuleRecord.mModuleId);
        }
    }

    static String moduleRecord2JsonStr(Map<String, QzoneModuleRecord> map) {
        if (map != null && map.size() > 0) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (String str : map.keySet()) {
                JSONObject jSONObject2 = new JSONObject();
                QzoneModuleRecord qzoneModuleRecord = map.get(str);
                try {
                    jSONObject2.put("module_id", qzoneModuleRecord.mModuleId);
                    jSONObject2.put(QzoneModuleConst.QZONE_MODULE_CONFIG_MODULE_MD5, qzoneModuleRecord.mMD5);
                    jSONObject2.put(QzoneModuleConst.QZONE_MODULE_CONFIG_MODULE_URL, qzoneModuleRecord.mUrl);
                    jSONObject2.put(QzoneModuleConst.QZONE_MODULE_CONFIG_MODULE_VERSION, qzoneModuleRecord.mVersion);
                    jSONObject2.put(QzoneModuleConst.QZONE_MODULE_CONFIG_MODULE_MAIN_VERSION, qzoneModuleRecord.mMainVersion);
                    jSONObject2.put(QzoneModuleConst.QZONE_MODULE_CONFIG_MODULE_KEY_CLASS_NAME, qzoneModuleRecord.mKeyClassName);
                    jSONObject2.put(QzoneModuleConst.QZONE_MODULE_CONFIG_MODULE_CLASS_IDS, qzoneModuleRecord.mClassIds);
                    jSONObject2.put(QzoneModuleConst.QZONE_MODULE_CONFIG_MODULE_KEY_CLASS_IDS_COUNT, qzoneModuleRecord.mClassIdsCount);
                    jSONObject2.put(QzoneModuleConst.QZONE_MODULE_CONFIG_MODULE_FILE_LENGTH, qzoneModuleRecord.mModuleFileLength);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                jSONArray.mo162put(jSONObject2);
            }
            try {
                jSONObject.put(QzoneModuleConst.QZONE_MODULE_CONFIG_NETWORKED_MODULE, jSONArray);
                return jSONObject.toString();
            } catch (JSONException e17) {
                e17.printStackTrace();
            }
        }
        return "";
    }
}
