package com.qzone.proxy.feedcomponent.manager;

import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.util.JsonORM;
import com.tencent.oskplayer.support.log.Logger;
import cooperation.qzone.cache.QZoneFilePath;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class g {
    public static j a() {
        JSONObject jSONObject;
        File file = new File(QZoneFilePath.VIDEO_CONFIG);
        if (file.exists() && file.isFile()) {
            String b16 = b(file);
            if (!TextUtils.isEmpty(b16)) {
                try {
                    jSONObject = new JSONObject(b16);
                } catch (JSONException unused) {
                    Logger.g().w("QZoneVideoExternalEnvConfig", "invalid json config " + file.getAbsolutePath());
                    jSONObject = null;
                }
                if (jSONObject != null) {
                    try {
                        return (j) JsonORM.d(jSONObject, j.class);
                    } catch (Exception e16) {
                        Logger.g().w("QZoneVideoExternalEnvConfig", "parse failed " + file.getAbsolutePath(), e16);
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x007f: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:27:0x007f */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0082 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String b(File file) {
        BufferedReader bufferedReader;
        IOException e16;
        FileNotFoundException e17;
        BufferedReader bufferedReader2;
        StringBuilder sb5 = new StringBuilder();
        BufferedReader bufferedReader3 = null;
        try {
        } catch (Exception e18) {
            e18.printStackTrace();
        }
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb5.append(readLine);
                    } catch (FileNotFoundException e19) {
                        e17 = e19;
                        Logger.g().w("QZoneVideoExternalEnvConfig", "read file no such file " + file.getAbsolutePath(), e17);
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return sb5.toString();
                    } catch (IOException e26) {
                        e16 = e26;
                        Logger.g().w("QZoneVideoExternalEnvConfig", "read file io exception " + file.getAbsolutePath(), e16);
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return sb5.toString();
                    }
                }
                bufferedReader.close();
            } catch (FileNotFoundException e27) {
                bufferedReader = null;
                e17 = e27;
            } catch (IOException e28) {
                bufferedReader = null;
                e16 = e28;
            } catch (Throwable th5) {
                th = th5;
                if (bufferedReader3 != null) {
                }
                throw th;
            }
            return sb5.toString();
        } catch (Throwable th6) {
            th = th6;
            bufferedReader3 = bufferedReader2;
            if (bufferedReader3 != null) {
                try {
                    bufferedReader3.close();
                } catch (Exception e29) {
                    e29.printStackTrace();
                }
            }
            throw th;
        }
    }
}
