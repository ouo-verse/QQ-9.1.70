package com.gcore.abase.hotfix;

import android.content.Context;
import android.util.Log;
import com.gcore.abase.utils.FileUtils;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SecurityCheck {
    private static final String GCLOUD_CRT_PATH = "gcloud.crt";
    private static final String PATCH_INFO_FILE = "patch_info.json";
    private static final String SO_INFO_FILE = "so_info.json";
    private static final String TAG = "ABase.SecurityCheck";
    private static String mCertificateMd5;
    private final Context mContext;
    private final HashMap<String, String> metaContentMap = new HashMap<>();

    public SecurityCheck(Context context) {
        this.mContext = context;
        if (mCertificateMd5 == null) {
            init(context);
        }
    }

    private boolean check(File file, Certificate[] certificateArr) {
        if (certificateArr.length > 0) {
            for (int length = certificateArr.length - 1; length >= 0; length--) {
                try {
                } catch (Exception e16) {
                    Log.e(TAG, file.getAbsolutePath(), e16);
                }
                if (mCertificateMd5.equals(FileUtils.getMD5(certificateArr[length].getEncoded()))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private void init(Context context) {
        InputStream inputStream = null;
        try {
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509", "BC");
                inputStream = context.getAssets().open(GCLOUD_CRT_PATH);
                String md5 = FileUtils.getMD5(((X509Certificate) certificateFactory.generateCertificate(inputStream)).getEncoded());
                mCertificateMd5 = md5;
                if (md5 == null) {
                    Log.e(TAG, "mCertificateMd5 is null!");
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                Log.e(TAG, "get gcloud.crt failed! check if gcloud.crt exist!");
            }
        } finally {
            FileUtils.closeQuietly(inputStream);
        }
    }

    public PatchInfo getPatchInfo() {
        String str = this.metaContentMap.get(PATCH_INFO_FILE);
        if (str == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            PatchInfo patchInfo = new PatchInfo();
            patchInfo.sdkName = jSONObject.getString(HianalyticsBaseData.SDK_NAME);
            patchInfo.sdkVersion = jSONObject.getString("sdk_version");
            patchInfo.patchVersion = jSONObject.getInt("patch_version");
            return patchInfo;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public List<SoInfo> getSoInfos() {
        String str = this.metaContentMap.get(SO_INFO_FILE);
        ArrayList arrayList = new ArrayList();
        if (str == null) {
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                SoInfo soInfo = new SoInfo();
                soInfo.name = jSONObject.getString("name");
                soInfo.arch = jSONObject.getString("arch");
                soInfo.md5 = jSONObject.getString("md5");
                arrayList.add(soInfo);
            }
            return arrayList;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return arrayList;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean verifyPatchMetaSignature(File file) {
        JarFile jarFile;
        Exception e16;
        if (mCertificateMd5 == null) {
            Log.e(TAG, "mCertificateMd5 is null! check if gcloud.crt exist!");
            return false;
        }
        JarFile jarFile2 = null;
        try {
            try {
                jarFile = new JarFile(file);
            } catch (Exception e17) {
                jarFile = null;
                e16 = e17;
            } catch (Throwable th5) {
                th = th5;
                if (jarFile2 != null) {
                }
                throw th;
            }
        } catch (IOException e18) {
            Log.e(TAG, file.getAbsolutePath(), e18);
        }
        try {
            try {
                Enumeration<JarEntry> entries = jarFile.entries();
                while (entries.hasMoreElements()) {
                    JarEntry nextElement = entries.nextElement();
                    if (nextElement != null) {
                        String name = nextElement.getName();
                        if (!name.startsWith("META-INF/") && name.endsWith("_info.json")) {
                            this.metaContentMap.put(name, FileUtils.loadDigestes(jarFile, nextElement));
                            Certificate[] certificates = nextElement.getCertificates();
                            if (certificates == null || !check(file, certificates)) {
                                try {
                                    jarFile.close();
                                } catch (IOException e19) {
                                    Log.e(TAG, file.getAbsolutePath(), e19);
                                }
                                return false;
                            }
                        }
                    }
                }
                jarFile.close();
            } catch (Throwable th6) {
                th = th6;
                jarFile2 = jarFile;
                if (jarFile2 != null) {
                    try {
                        jarFile2.close();
                    } catch (IOException e26) {
                        Log.e(TAG, file.getAbsolutePath(), e26);
                    }
                }
                throw th;
            }
        } catch (Exception e27) {
            e16 = e27;
            e16.printStackTrace();
            Log.e(TAG, String.format("SecurityCheck file %s, size %d verifyPatchMetaSignature fail", file.getAbsolutePath(), Long.valueOf(file.length())));
            if (jarFile != null) {
                jarFile.close();
            }
            return true;
        }
        return true;
    }
}
