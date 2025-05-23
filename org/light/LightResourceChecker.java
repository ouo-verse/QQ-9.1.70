package org.light;

import android.text.TextUtils;
import com.tencent.aelight.camera.constants.AECameraConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.concurrent.ConcurrentHashMap;
import org.light.utils.LightLogUtil;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LightResourceChecker {
    private static final String TAG = "LightResourceChecker";
    private static final ConcurrentHashMap<String, Boolean> resultMap = new ConcurrentHashMap<>();

    private static CheckResult checkBundle(String str, String str2, long j3) {
        String str3 = str + str2;
        File file = new File(str3);
        if (!file.exists()) {
            LightLogUtil.e(TAG, "checkBundleResources fails, file not exists: " + str3);
            return new CheckResult(false, 1, str2, 0L, 0L);
        }
        long length = file.length();
        if (length != j3) {
            LightLogUtil.e(TAG, MessageFormat.format("checkBundleResources fails, {0} size not match, actualLength: {1}, recordingLength: {2}", str3, Long.valueOf(length), Long.valueOf(j3)));
            return new CheckResult(false, 2, str2, length, j3);
        }
        return new CheckResult(true, 0, str2, 0L, 0L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a6, code lost:
    
        org.light.LightResourceChecker.resultMap.put(r9, java.lang.Boolean.TRUE);
        r0.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean checkLightResources(String str) {
        if (Boolean.TRUE.equals(resultMap.get(str))) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            LightLogUtil.e(TAG, "checkBundleResources skip: bundleDir is empty: " + str);
            return true;
        }
        File file = new File(str + AECameraConstants.META);
        if (!file.exists()) {
            LightLogUtil.e(TAG, "checkBundleResources skip: meta.txt not exists");
            return true;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                String trim = readLine.trim();
                if (trim.length() > 0) {
                    LightFileMeta lightFileMeta = new LightFileMeta();
                    if (parseMateLine(trim, lightFileMeta) && lightFileMeta.getFilePath().length() > 0 && lightFileMeta.getFileLength() > 0 && !checkBundle(str, lightFileMeta.getFilePath(), lightFileMeta.getFileLength()).checkPass) {
                        return false;
                    }
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            LightLogUtil.e(TAG, e16.toString());
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00cb, code lost:
    
        org.light.LightResourceChecker.resultMap.put(r10, java.lang.Boolean.TRUE);
        r0.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static CheckResult checkLightResourcesError(String str) {
        if (Boolean.TRUE.equals(resultMap.get(str))) {
            return new CheckResult(true, 0, str, 0L, 0L);
        }
        if (TextUtils.isEmpty(str)) {
            LightLogUtil.e(TAG, "checkBundleResources skip: bundleDir is empty: " + str);
            return new CheckResult(true, 0, str, 0L, 0L);
        }
        File file = new File(str + AECameraConstants.META);
        if (!file.exists()) {
            LightLogUtil.e(TAG, "checkBundleResources skip: meta.txt not exists");
            return new CheckResult(true, 0, str, 0L, 0L);
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                String trim = readLine.trim();
                if (trim.length() > 0) {
                    LightFileMeta lightFileMeta = new LightFileMeta();
                    if (parseMateLine(trim, lightFileMeta) && lightFileMeta.getFilePath().length() > 0 && lightFileMeta.getFileLength() > 0) {
                        CheckResult checkBundle = checkBundle(str, lightFileMeta.getFilePath(), lightFileMeta.getFileLength());
                        if (!checkBundle.checkPass) {
                            return checkBundle;
                        }
                    }
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            LightLogUtil.e(TAG, e16.toString());
        }
        return new CheckResult(true, 0, str, 0L, 0L);
    }

    private static boolean parseMateLine(String str, LightFileMeta lightFileMeta) {
        if (str.length() <= 0) {
            return false;
        }
        String[] split = str.split(":");
        if (split.length != 3) {
            return false;
        }
        int indexOf = split[0].indexOf("/");
        if (indexOf < 0) {
            indexOf = 0;
        }
        lightFileMeta.setFilePath(split[0].substring(indexOf));
        lightFileMeta.setFileMD5(split[1]);
        lightFileMeta.setFileLength(Long.parseLong(split[2]));
        return true;
    }
}
