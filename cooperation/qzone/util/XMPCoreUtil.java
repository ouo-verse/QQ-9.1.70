package cooperation.qzone.util;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qzonehub.api.IQzoneModuleManageApi;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.networkedmodule.QzoneModuleConst;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes28.dex */
public class XMPCoreUtil {
    private static final String KEY = "xmp_core_file_md5";
    public static final String PROPERTY_NAME_CROP_WIDTH = "GPano:CroppedAreaImageWidthPixels";
    public static final String PROPERTY_NAME_FULL_WIDTH = "GPano:FullPanoWidthPixels";
    public static final String PROPERTY_NAME_IS_PANORAMA = "GPano:UsePanoramaViewer";
    public static final String SCHEMA_PANORAMA = "http://ns.google.com/photos/1.0/panorama/";
    private static final String TAG = "XMPCoreUtil";
    private boolean isModuleLoadSuccess = false;
    private ConcurrentHashMap<String, Boolean> panoramaHashMap = new ConcurrentHashMap<>();
    private static String mXMPCoreJarUrl = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneModuleConst.QZONE_MODULE_XMP_CORE_DEFAULT_URL_SECONDARY_KEY, QzoneModuleConst.QZONE_MODULE_XMP_CORE_DEFAULT_URL);
    private static String mXMPCoreJarMD5 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneModuleConst.QZONE_MODULE_XMP_CORE_DEFAULT_MD5_SECONDARY_KEY, QzoneModuleConst.QZONE_MODULE_XMP_CORE_DEFAULT_MD5);
    private static XMPCoreUtil instance = null;

    /* loaded from: classes28.dex */
    public interface XMPCoreJarLoadListener {
        void loadState(boolean z16);
    }

    public static XMPCoreUtil getInstance() {
        if (instance == null) {
            synchronized (XMPCoreUtil.class) {
                if (instance == null) {
                    instance = new XMPCoreUtil();
                }
            }
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNeedUpdate() {
        if (TextUtils.isEmpty(LocalMultiProcConfig.getString(KEY, null))) {
            return true;
        }
        return !r0.equalsIgnoreCase(mXMPCoreJarMD5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isXMPCoreJarExit() {
        String moduleFilePath = ((IQzoneModuleManageApi) QRoute.api(IQzoneModuleManageApi.class)).getModuleFilePath(QzoneModuleConst.QZONE_MODULE_XMP_CORE_JAR);
        QZLog.i(TAG, 4, "isXMPCoreJarExit path = ", moduleFilePath);
        if (TextUtils.isEmpty(moduleFilePath)) {
            return false;
        }
        return new File(moduleFilePath).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadXMPCoreModule() {
        QZLog.i(TAG, "loadXMPCoreModule");
        if (isXMPCoreJarExit()) {
            QZLog.i(TAG, 4, "xmpCoreModulePath =", ((IQzoneModuleManageApi) QRoute.api(IQzoneModuleManageApi.class)).getModuleFilePath(QzoneModuleConst.QZONE_MODULE_XMP_CORE_JAR));
            boolean loadModule = ((IQzoneModuleManageApi) QRoute.api(IQzoneModuleManageApi.class)).loadModule(QzoneModuleConst.QZONE_MODULE_XMP_CORE_JAR, getClass().getClassLoader(), false, false);
            this.isModuleLoadSuccess = loadModule;
            if (loadModule) {
                QZLog.i(TAG, "loadXMPCoreModule success");
            } else {
                QZLog.i(TAG, "loadXMPCoreModule fail");
            }
        }
    }

    private HashMap<String, Object> readXMPData(String str, String str2, String[] strArr) {
        Object callSpecifiedMethod;
        Object callSpecifiedMethod2;
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length != 0 && this.isModuleLoadSuccess) {
            Object callSpecifiedStaticMethod = JarReflectUtil.callSpecifiedStaticMethod("com.adobe.xmp.XmpUtil", "extractXMPMeta", false, getParamsClass(String.class), str);
            HashMap<String, Object> hashMap = new HashMap<>();
            if (callSpecifiedStaticMethod != null) {
                for (String str3 : strArr) {
                    if (!TextUtils.isEmpty(str3) && (callSpecifiedMethod = JarReflectUtil.callSpecifiedMethod(callSpecifiedStaticMethod, "getProperty", false, getParamsClass(String.class, String.class), str2, str3)) != null && (callSpecifiedMethod2 = JarReflectUtil.callSpecifiedMethod(callSpecifiedMethod, HippyTextInputController.COMMAND_getValue, false, new Class[0], new Object[0])) != null) {
                        hashMap.put(str3, callSpecifiedMethod2);
                    }
                }
            }
            return hashMap;
        }
        return null;
    }

    public void downloadXMPModule() {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: cooperation.qzone.util.XMPCoreUtil.2
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                if (!XMPCoreUtil.this.isNeedUpdate() && XMPCoreUtil.this.isXMPCoreJarExit()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    ((IQzoneModuleManageApi) QRoute.api(IQzoneModuleManageApi.class)).downloadModule(QzoneModuleConst.QZONE_MODULE_XMP_CORE_JAR, new ModuleDownloadListener() { // from class: cooperation.qzone.util.XMPCoreUtil.2.1
                        @Override // cooperation.qzone.networkedmodule.ModuleDownloadListener
                        public void onDownloadCanceled(String str) {
                            QZLog.i(XMPCoreUtil.TAG, 4, "onDownloadCanceled ", str);
                        }

                        @Override // cooperation.qzone.networkedmodule.ModuleDownloadListener
                        public void onDownloadFailed(String str) {
                            QZLog.i(XMPCoreUtil.TAG, 4, "onDownloadFailed ", str);
                        }

                        @Override // cooperation.qzone.networkedmodule.ModuleDownloadListener
                        public void onDownloadProgress(String str, float f16) {
                            QZLog.i(XMPCoreUtil.TAG, 4, "moduleId = ", str, " progress = ", Float.valueOf(f16));
                        }

                        @Override // cooperation.qzone.networkedmodule.ModuleDownloadListener
                        public void onDownloadSucceed(String str) {
                            if (!str.equals(QzoneModuleConst.QZONE_MODULE_XMP_CORE_JAR)) {
                                return;
                            }
                            QZLog.i(XMPCoreUtil.TAG, 4, "url = ", XMPCoreUtil.mXMPCoreJarUrl, " onDownloadSucceed = ", XMPCoreUtil.mXMPCoreJarMD5);
                            LocalMultiProcConfig.putString(XMPCoreUtil.KEY, XMPCoreUtil.mXMPCoreJarMD5);
                        }
                    });
                }
            }
        });
    }

    public Class[] getParamsClass(Class... clsArr) {
        Class[] clsArr2 = new Class[clsArr.length];
        for (int i3 = 0; i3 < clsArr.length; i3++) {
            clsArr2[i3] = clsArr[i3];
        }
        return clsArr2;
    }

    public boolean isModuleLoadSuccess() {
        return this.isModuleLoadSuccess;
    }

    public boolean isPanorama(String str) {
        Object obj;
        if (this.panoramaHashMap.get(str) != null) {
            return this.panoramaHashMap.get(str).booleanValue();
        }
        HashMap<String, Object> readXMPData = readXMPData(str, SCHEMA_PANORAMA, new String[]{PROPERTY_NAME_IS_PANORAMA});
        if (readXMPData == null || (obj = readXMPData.get(PROPERTY_NAME_IS_PANORAMA)) == null || !(obj instanceof String)) {
            return false;
        }
        boolean equalsIgnoreCase = ((String) obj).equalsIgnoreCase("true");
        QZLog.i(TAG, 4, "isPanorama: ", Boolean.valueOf(equalsIgnoreCase));
        this.panoramaHashMap.put(str, Boolean.valueOf(equalsIgnoreCase));
        return equalsIgnoreCase;
    }

    public void loadXMPCoreJarModule(final XMPCoreJarLoadListener xMPCoreJarLoadListener) {
        boolean z16;
        if (xMPCoreJarLoadListener == null) {
            QZLog.i(TAG, "loadXMPCoreJarModule xmpCoreJarLoadListenerNull");
            return;
        }
        if (this.isModuleLoadSuccess) {
            QZLog.i(TAG, "loadXMPCoreJarModule ModuleLoadSuccess");
            xMPCoreJarLoadListener.loadState(this.isModuleLoadSuccess);
            return;
        }
        if (!isNeedUpdate() && isXMPCoreJarExit()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            loadXMPCoreModule();
            xMPCoreJarLoadListener.loadState(this.isModuleLoadSuccess);
        } else {
            ((IQzoneModuleManageApi) QRoute.api(IQzoneModuleManageApi.class)).downloadModule(QzoneModuleConst.QZONE_MODULE_XMP_CORE_JAR, new ModuleDownloadListener() { // from class: cooperation.qzone.util.XMPCoreUtil.1
                @Override // cooperation.qzone.networkedmodule.ModuleDownloadListener
                public void onDownloadCanceled(String str) {
                    QZLog.i(XMPCoreUtil.TAG, 4, "onDownloadCanceled ", str);
                }

                @Override // cooperation.qzone.networkedmodule.ModuleDownloadListener
                public void onDownloadFailed(String str) {
                    QZLog.i(XMPCoreUtil.TAG, 4, "onDownloadFailed ", str);
                    XMPCoreUtil.this.isModuleLoadSuccess = false;
                    xMPCoreJarLoadListener.loadState(false);
                }

                @Override // cooperation.qzone.networkedmodule.ModuleDownloadListener
                public void onDownloadProgress(String str, float f16) {
                    QZLog.i(XMPCoreUtil.TAG, 4, "moduleId = ", str, " progress = ", Float.valueOf(f16));
                }

                @Override // cooperation.qzone.networkedmodule.ModuleDownloadListener
                public void onDownloadSucceed(String str) {
                    if (!str.equals(QzoneModuleConst.QZONE_MODULE_XMP_CORE_JAR)) {
                        return;
                    }
                    QZLog.i(XMPCoreUtil.TAG, 4, "url = ", XMPCoreUtil.mXMPCoreJarUrl, " onDownloadSucceed = ", XMPCoreUtil.mXMPCoreJarMD5);
                    LocalMultiProcConfig.putString(XMPCoreUtil.KEY, XMPCoreUtil.mXMPCoreJarMD5);
                    XMPCoreUtil.this.loadXMPCoreModule();
                    xMPCoreJarLoadListener.loadState(XMPCoreUtil.this.isModuleLoadSuccess);
                }
            });
        }
    }
}
