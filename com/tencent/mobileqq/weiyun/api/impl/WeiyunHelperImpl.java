package com.tencent.mobileqq.weiyun.api.impl;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.text.TextUtils;
import android.util.SparseArray;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.weiyun.TransmissionHelper;
import com.tencent.mobileqq.weiyun.api.IWeiyunApi;
import com.tencent.mobileqq.weiyun.api.IWeiyunHelper;
import com.tencent.mobileqq.weiyun.utils.d;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.weiyun.utils.NetworkUtils;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;
import y43.e;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class WeiyunHelperImpl implements IWeiyunHelper {
    static IPatchRedirector $redirector_ = null;
    private static final String CLS_WEIYUN_RUNTIME = "com.weiyun.plugin.app.WeiyunRuntime";
    private static final String OPEN_QQ_VIP_STRATEIE_URL = "https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=524289&aid=%s";
    private static final Map<Integer, String> THUMB_TYPE_SIZE;
    private static final SparseArray<String> VIDEO_THUMB_TYPE_SIZE;
    private static String sDefaultRecvPath;
    private static String sDefaultThumbPath;
    private static String sDefaultUploadPDirKey;
    private static String sDefaultUploadPpDirKey;
    private static volatile boolean sDowngrade;
    private static boolean sStart;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19494);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
            return;
        }
        sStart = false;
        sDefaultUploadPpDirKey = "";
        sDefaultUploadPDirKey = "";
        HashMap hashMap = new HashMap();
        THUMB_TYPE_SIZE = hashMap;
        hashMap.put(0, "16*16");
        hashMap.put(1, "32*32");
        hashMap.put(2, "64*64");
        hashMap.put(3, "128*128");
        hashMap.put(4, "320*320");
        hashMap.put(5, "384*384");
        hashMap.put(6, "640*640");
        hashMap.put(7, "750*750");
        hashMap.put(8, "1024*1024");
        SparseArray<String> sparseArray = new SparseArray<>(9);
        VIDEO_THUMB_TYPE_SIZE = sparseArray;
        sparseArray.put(0, "/16");
        sparseArray.put(1, "/32");
        sparseArray.put(2, "/64");
        sparseArray.put(3, "/128");
        sparseArray.put(4, "/320");
        sparseArray.put(5, "/384");
        sparseArray.put(6, "/640");
        sparseArray.put(7, "/750");
        sparseArray.put(8, "/1024");
    }

    public WeiyunHelperImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void initPath(Application application) {
        File cacheDir;
        sDefaultRecvPath = AppConstants.SDCARD_FILE_SAVE_PATH;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            cacheDir = new File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH));
        } else {
            cacheDir = application.getCacheDir();
        }
        sDefaultThumbPath = new File(cacheDir, AppConstants.PATH_URLDRAWABLE_DISKCACHE).getAbsolutePath();
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunHelper
    public boolean checkSOExists(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) context)).booleanValue();
        }
        return d.b(context);
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunHelper
    public void cleanPwdRecord(Context context, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, Long.valueOf(j3));
        } else {
            ((IWeiyunApi) QRoute.api(IWeiyunApi.class)).cleanPwdRecord(context, j3);
        }
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunHelper
    public void clearDefaultUploadDirKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            sDefaultUploadPpDirKey = "";
            sDefaultUploadPDirKey = "";
        }
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunHelper
    public PluginRuntime createRuntime(Context context) {
        Class<?> cls;
        Object newInstance;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (PluginRuntime) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
        }
        try {
            try {
                try {
                    cls = Class.forName(CLS_WEIYUN_RUNTIME);
                } catch (IllegalAccessException e16) {
                    e16.printStackTrace();
                } catch (IllegalArgumentException e17) {
                    e17.printStackTrace();
                } catch (InstantiationException e18) {
                    e18.printStackTrace();
                } catch (NoSuchMethodException e19) {
                    e19.printStackTrace();
                } catch (InvocationTargetException e26) {
                    e26.printStackTrace();
                } catch (Exception e27) {
                    e27.printStackTrace();
                }
            } catch (ClassNotFoundException e28) {
                e28.printStackTrace();
            }
        } catch (ClassNotFoundException unused) {
            ClassLoader orCreateClassLoader = PluginStatic.getOrCreateClassLoader(context, IWeiyunHelper.WEIYUN_PLUGIN_ID);
            Class<?> loadClass = orCreateClassLoader.loadClass(CLS_WEIYUN_RUNTIME);
            BasicClassTypeUtil.setClassLoader(true, orCreateClassLoader);
            cls = loadClass;
        }
        if (cls != null && (newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0])) != null && (newInstance instanceof PluginRuntime)) {
            return (PluginRuntime) newInstance;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunHelper
    public void downgradePath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else if (!sDowngrade) {
            sDefaultRecvPath = MobileQQ.sMobileQQ.getFilesDir().getAbsolutePath();
            sDefaultThumbPath = MobileQQ.sMobileQQ.getCacheDir().getAbsolutePath();
            sDowngrade = true;
        }
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunHelper
    public void downloadSo(Context context, e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) context, (Object) eVar);
        } else {
            d.d(context, eVar);
        }
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunHelper
    public Pair<Pair<String, String>, Long> genThumbInfo(String str, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Pair) iPatchRedirector.redirect((short) 13, this, str, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        if (TextUtils.isEmpty(str)) {
            return new Pair<>(new Pair(str, str), 0L);
        }
        String str2 = THUMB_TYPE_SIZE.get(Integer.valueOf(i3));
        StringBuilder sb5 = new StringBuilder(str);
        if (z16) {
            String str3 = VIDEO_THUMB_TYPE_SIZE.get(i3);
            if (!TextUtils.isEmpty(str3)) {
                sb5.append(str3);
            }
            String sb6 = sb5.toString();
            return new Pair<>(new Pair(sb6, sb6), Long.valueOf(sb6.hashCode() * 31));
        }
        int networkType = NetworkUtils.getNetworkType(MobileQQ.sMobileQQ);
        sb5.append("&nettype=");
        sb5.append(networkType);
        if (!TextUtils.isEmpty(str2)) {
            sb5.append("&size=");
            sb5.append(str2);
        }
        String sb7 = sb5.toString();
        return new Pair<>(new Pair(sb7, sb7.replaceFirst("cn=\\d", "").replaceFirst("nettype=\\d", "")), Long.valueOf(r6.hashCode() * 31));
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunHelper
    public String getDefaultDownloadPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return sDefaultRecvPath;
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunHelper
    public String getDefaultThumbPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return sDefaultThumbPath;
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunHelper
    public String[] getDefaultUploadDirKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String[]) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return new String[]{sDefaultUploadPpDirKey, sDefaultUploadPDirKey};
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunHelper
    public String getOpenQQVipH5(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this, (Object) str, (Object) str2);
        }
        String format = String.format(OPEN_QQ_VIP_STRATEIE_URL, str2);
        QLog.d(IWeiyunHelper.TAG, 2, "qq vip payurl : " + format);
        return format;
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunHelper
    public String getOpenWeiyunBuySpaceH5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        QLog.d(IWeiyunHelper.TAG, 2, "weiyun shapce payurl : https://jump.weiyun.com/?from=3047");
        return "https://jump.weiyun.com/?from=3047";
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunHelper
    public String getOpenWeiyunVipH5(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str, (Object) str2);
        }
        String format = String.format("https://jump.weiyun.com/?from=30001&aid=%s", str2);
        QLog.d(IWeiyunHelper.TAG, 2, "weiyun vip payurl : " + format);
        return format;
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunHelper
    public File getUploadSoFile(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (File) iPatchRedirector.redirect((short) 21, (Object) this, (Object) context);
        }
        return d.h(context);
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunHelper
    public void notifyEnterFileAssit(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
        } else {
            context.sendBroadcast(new Intent(IWeiyunHelper.BROADCAST_ENTER_FILE_ASSIT), "com.tencent.msg.permission.pushnotify");
        }
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunHelper
    public void notifyExitFileAssit(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
        } else {
            context.sendBroadcast(new Intent(IWeiyunHelper.BROADCAST_EXIT_FILE_ASSIT), "com.tencent.msg.permission.pushnotify");
        }
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunHelper
    public void saveDefaultUploadDirKey(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            sDefaultUploadPpDirKey = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            sDefaultUploadPDirKey = str2;
        }
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunHelper
    public void shutdownWySystem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (sStart) {
            synchronized (WeiyunHelperImpl.class) {
                if (sStart) {
                    TransmissionHelper.f(false, MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin());
                    sStart = false;
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunHelper
    public void startWySystem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (!sStart) {
            synchronized (WeiyunHelperImpl.class) {
                if (!sStart) {
                    TransmissionHelper.e(MobileQQ.sMobileQQ, false);
                    ((IWeiyunApi) QRoute.api(IWeiyunApi.class)).initPwdRecord(MobileQQ.sMobileQQ);
                    initPath(MobileQQ.sMobileQQ);
                    sStart = true;
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunHelper
    public void upgradePath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else if (sDowngrade) {
            initPath(MobileQQ.sMobileQQ);
            sDowngrade = false;
        }
    }
}
