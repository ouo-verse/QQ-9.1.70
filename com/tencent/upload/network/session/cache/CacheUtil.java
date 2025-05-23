package com.tencent.upload.network.session.cache;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.task.UploadTask;

/* compiled from: P */
/* loaded from: classes27.dex */
public class CacheUtil {
    static IPatchRedirector $redirector_;

    public CacheUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void cacheSessionId(UploadTask uploadTask, String str) {
        long currentUin = UploadGlobalConfig.getConfig().getCurrentUin();
        Context context = UploadGlobalConfig.getContext();
        String filePath = uploadTask.getFilePath();
        if (context != null && currentUin != 0 && !TextUtils.isEmpty(filePath) && !TextUtils.isEmpty(str)) {
            new SessionDbHelper(context).insert(currentUin, generateKey(filePath, uploadTask.flowId), str);
        }
    }

    public static void clearAllCache() {
        long currentUin = UploadGlobalConfig.getConfig().getCurrentUin();
        Context context = UploadGlobalConfig.getContext();
        if (context != null && currentUin != 0) {
            new SessionDbHelper(context).clearUserData(currentUin);
        }
    }

    public static void deleteSessionId(UploadTask uploadTask, String str) {
        long currentUin = UploadGlobalConfig.getConfig().getCurrentUin();
        Context context = UploadGlobalConfig.getContext();
        String filePath = uploadTask.getFilePath();
        if (context != null && currentUin != 0 && !TextUtils.isEmpty(filePath) && !TextUtils.isEmpty(str)) {
            new SessionDbHelper(context).delete(currentUin, generateKey(filePath, uploadTask.flowId), str);
        }
    }

    public static String generateKey(String str, int i3) {
        return str + Math.abs(i3);
    }

    public static void setCachedSessionId(UploadTask uploadTask) {
        String filePath = uploadTask.getFilePath();
        long currentUin = UploadGlobalConfig.getConfig().getCurrentUin();
        Context context = UploadGlobalConfig.getContext();
        if (context != null && currentUin != 0 && !TextUtils.isEmpty(filePath)) {
            String query = new SessionDbHelper(context).query(currentUin, generateKey(filePath, uploadTask.flowId));
            if (!TextUtils.isEmpty(query)) {
                uploadTask.setSessionId(query);
            }
        }
    }
}
