package com.tencent.mobileqq.qmcf;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.aelight.camera.qqstory.api.IVideoFilterTools;
import com.tencent.mobileqq.activity.richmedia.FileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.util.SoLoader;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import com.tencent.ttpic.baseutils.device.DeviceInstance;
import com.tencent.ttpic.baseutils.io.IOUtils;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QmcfManager {
    static IPatchRedirector $redirector_ = null;
    public static final int FRAME_TYPE_CL_MALI = 2;
    public static final int FRAME_TYPE_CL_OCL = 3;
    public static final int FRAME_TYPE_GL = 4;
    public static final int FRAME_TYPE_NONE = -1;
    public static final int FRAME_TYPE_NO_SUPPORT = 0;
    public static final int FRAME_TYPE_SNPE = 1;
    public static boolean FrameExtraction = false;
    public static String QMCF_FRAME_TYPE = null;
    public static final int QMCF_MODE_ART = 1;
    public static final int QMCF_MODE_BIGHEAD = 3;
    public static final int QMCF_MODE_NONE = 0;
    public static final int QMCF_MODE_POSE = 2;
    private static final String TAG = "QMCF_MGR";
    private static int artFilterLimitVersion;
    private static QmcfManager g_sInstance;
    public static boolean hasSNPESo;
    public static boolean isDebugMode;
    public static boolean isQQRun;
    private static QmcfReporter mReporter;
    private static QmcfSwitchStrategy mSwitchStrategy;
    public String CommonPrefixPath;
    private int currFrameType;
    private String currModelResFolder;
    private int currQmcfMode;
    public int mCameraMode;
    private Object mReadResLock;
    public float[] mSTMatrix;
    public boolean modeChanged;
    private HashMap modelItemsMap;
    private ArrayList<String> modelSwichList;
    public boolean modelSwitched;
    ExecutorService singleThreadExecutor;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13319);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 36)) {
            redirector.redirect((short) 36);
            return;
        }
        QMCF_FRAME_TYPE = "qmcf_frame_type";
        hasSNPESo = false;
        FrameExtraction = false;
        mSwitchStrategy = new QmcfSwitchStrategy();
        mReporter = new QmcfReporter();
        artFilterLimitVersion = 1;
        isDebugMode = false;
        isQQRun = true;
    }

    public QmcfManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mSTMatrix = new float[16];
        this.mCameraMode = 1;
        this.CommonPrefixPath = null;
        this.modeChanged = false;
        this.modelSwitched = false;
        this.mReadResLock = new Object();
        this.modelItemsMap = new HashMap(16);
        this.modelSwichList = new ArrayList<>();
        this.currQmcfMode = 0;
        this.currFrameType = -1;
        this.singleThreadExecutor = null;
    }

    public static QmcfManager getInstance() {
        if (g_sInstance == null) {
            g_sInstance = new QmcfManager();
        }
        return g_sInstance;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x009d, code lost:
    
        if (r5 == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x009f, code lost:
    
        r0.delete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00af, code lost:
    
        if (r3 != false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String getQmcfModelPath(String str) {
        String readFileContent;
        String str2 = null;
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str + IVideoFilterTools.CONFIG_FILE);
            if (file.exists() && (readFileContent = FileUtils.readFileContent(file)) != null && readFileContent.length() > 0) {
                boolean z16 = false;
                try {
                    try {
                        JSONObject jSONObject = new JSONObject(readFileContent);
                        String string = jSONObject.getString("model_name");
                        String string2 = jSONObject.getString("model_struct");
                        str2 = str + string2;
                        boolean exists = new File(str + string).exists();
                        boolean exists2 = new File(str2).exists();
                        try {
                            if (SLog.isEnable()) {
                                SLog.d(TAG, String.format("getQmcfModelPath paramExit[%s], modelExist[%s], paramName[%s], modelName[%s]", Boolean.valueOf(exists), Boolean.valueOf(exists2), string, string2));
                            }
                        } catch (Exception e16) {
                            e = e16;
                            z16 = exists2;
                            e.printStackTrace();
                        } catch (Throwable th5) {
                            th = th5;
                            z16 = exists2;
                            if (!z16) {
                                file.delete();
                            }
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } catch (Exception e17) {
                    e = e17;
                }
            }
        }
        return str2;
    }

    public boolean checkPathValid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        try {
            this.CommonPrefixPath = SdkContext.getInstance().getResources().getArtFilterResource().getCommonPrefix() + "binarys/";
            File file = new File(this.CommonPrefixPath);
            if (!file.exists()) {
                file.mkdirs();
            }
            return true;
        } catch (Exception e16) {
            if (SLog.isEnable()) {
                SLog.d(TAG, "createDir excep");
            }
            e16.printStackTrace();
            return false;
        }
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (SLog.isEnable()) {
            SLog.d(TAG, "destroy");
        }
        mReporter.clearReporter();
        this.modelSwitched = false;
    }

    public byte[] drink(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (byte[]) iPatchRedirector.redirect((short) 27, (Object) this, (Object) bArr);
        }
        return QMCF.nDrink(bArr, bArr.length, QMCF.getDefaultSign());
    }

    public int getCurrFrameType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        if (this.currFrameType == -1) {
            this.currFrameType = SdkContext.getInstance().getApplication().getSharedPreferences(QmcfSwitchStrategy.SP_TAG, 4).getInt(QMCF_FRAME_TYPE, 4);
            if (SLog.isEnable()) {
                SLog.d(TAG, "getCurrFrameType:" + this.currFrameType);
            }
        }
        return this.currFrameType;
    }

    public int getCurrQmcfMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.currQmcfMode;
    }

    public String getCurrResFolder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.currModelResFolder;
    }

    public QmcfSwitchStrategy getCurrSwitchStrategy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (QmcfSwitchStrategy) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return mSwitchStrategy;
    }

    public int getMatchQmcfMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, i3)).intValue();
        }
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 3) {
            return 2;
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00bb A[Catch: all -> 0x01a0, TryCatch #0 {, blocks: (B:17:0x0031, B:19:0x0050, B:21:0x0056, B:22:0x0072, B:24:0x0074, B:26:0x007e, B:30:0x0081, B:33:0x008d, B:36:0x0094, B:39:0x009b, B:40:0x00b3, B:42:0x00bb, B:45:0x0109, B:47:0x0113, B:48:0x0152, B:50:0x0158, B:52:0x018d, B:54:0x0195, B:55:0x019e, B:57:0x0128, B:59:0x012e, B:62:0x013f, B:65:0x014d, B:69:0x00af), top: B:16:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0158 A[Catch: all -> 0x01a0, TryCatch #0 {, blocks: (B:17:0x0031, B:19:0x0050, B:21:0x0056, B:22:0x0072, B:24:0x0074, B:26:0x007e, B:30:0x0081, B:33:0x008d, B:36:0x0094, B:39:0x009b, B:40:0x00b3, B:42:0x00bb, B:45:0x0109, B:47:0x0113, B:48:0x0152, B:50:0x0158, B:52:0x018d, B:54:0x0195, B:55:0x019e, B:57:0x0128, B:59:0x012e, B:62:0x013f, B:65:0x014d, B:69:0x00af), top: B:16:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0195 A[Catch: all -> 0x01a0, TryCatch #0 {, blocks: (B:17:0x0031, B:19:0x0050, B:21:0x0056, B:22:0x0072, B:24:0x0074, B:26:0x007e, B:30:0x0081, B:33:0x008d, B:36:0x0094, B:39:0x009b, B:40:0x00b3, B:42:0x00bb, B:45:0x0109, B:47:0x0113, B:48:0x0152, B:50:0x0158, B:52:0x018d, B:54:0x0195, B:55:0x019e, B:57:0x0128, B:59:0x012e, B:62:0x013f, B:65:0x014d, B:69:0x00af), top: B:16:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x018c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public QmcfModelItem getQmcfModelItem() {
        String str;
        String str2;
        String str3;
        int i3;
        QmcfModelItem qmcfModelItem;
        QmcfModelItem qmcfModelItem2;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (QmcfModelItem) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        if (TextUtils.isEmpty(this.currModelResFolder)) {
            if (SLog.isEnable()) {
                SLog.d(TAG, "getQmcfModelItem currModelResFolder is null");
            }
            return null;
        }
        synchronized (this.mReadResLock) {
            File file = new File(this.currModelResFolder + IVideoFilterTools.CONFIG_FILE);
            if (!file.exists()) {
                if (SLog.isEnable()) {
                    SLog.d(TAG, "getQmcfModelItem file not exist " + file.getAbsolutePath());
                }
                return null;
            }
            String readFileContent = FileUtils.readFileContent(file);
            if (TextUtils.isEmpty(readFileContent)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(readFileContent);
                str = jSONObject.getString("model_name");
                try {
                    str2 = jSONObject.getString("model_struct");
                    try {
                        str3 = jSONObject.optString("model_dlc");
                        try {
                            i3 = jSONObject.optInt("model_encrypt");
                        } catch (Exception e16) {
                            e = e16;
                            e.printStackTrace();
                            i3 = 0;
                            if (this.modelItemsMap.get(str) == null) {
                            }
                            if (this.modelItemsMap.get(str) != null) {
                            }
                            return qmcfModelItem;
                        }
                    } catch (Exception e17) {
                        e = e17;
                        str3 = null;
                    }
                } catch (Exception e18) {
                    e = e18;
                    str2 = null;
                    str3 = str2;
                    e.printStackTrace();
                    i3 = 0;
                    if (this.modelItemsMap.get(str) == null) {
                    }
                    if (this.modelItemsMap.get(str) != null) {
                    }
                    return qmcfModelItem;
                }
            } catch (Exception e19) {
                e = e19;
                str = null;
                str2 = null;
            }
            if (this.modelItemsMap.get(str) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                String str4 = this.currModelResFolder + str;
                String str5 = this.currModelResFolder + str2;
                String str6 = this.currModelResFolder + str3;
                boolean exists = new File(str4).exists();
                boolean exists2 = new File(str5).exists();
                if (exists && exists2) {
                    String readQmcfModelFile = readQmcfModelFile(str5);
                    if (!TextUtils.isEmpty(readQmcfModelFile)) {
                        QmcfModelItem qmcfModelItem3 = new QmcfModelItem();
                        qmcfModelItem3.modelDeployString = readQmcfModelFile;
                        qmcfModelItem3.modelParamPath = str4;
                        qmcfModelItem3.modelDlcPath = str6;
                        qmcfModelItem3.modelEncrypt = i3;
                        this.modelItemsMap.put(str, qmcfModelItem3);
                        qmcfModelItem2 = qmcfModelItem3;
                        if (SLog.isEnable()) {
                            SLog.d(TAG, String.format("getQmcfModelItem cost[%s], paramExit[%s], modelExist[%s], paramName[%s], modelName[%s], dlcName[%s]", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(exists), Boolean.valueOf(exists2), str, str2, str3));
                        }
                        qmcfModelItem = qmcfModelItem2;
                    } else if (SLog.isEnable()) {
                        Object[] objArr = new Object[1];
                        if (!TextUtils.isEmpty(readQmcfModelFile)) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        objArr[0] = Boolean.valueOf(z16);
                        SLog.d(TAG, String.format("getQmcfModelItem modelValid[%s]", objArr));
                    }
                } else {
                    file.delete();
                }
                qmcfModelItem2 = null;
                if (SLog.isEnable()) {
                }
                qmcfModelItem = qmcfModelItem2;
            } else {
                qmcfModelItem = null;
            }
            if (this.modelItemsMap.get(str) != null) {
                qmcfModelItem = (QmcfModelItem) this.modelItemsMap.get(str);
            }
            return qmcfModelItem;
        }
    }

    public int getRunType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        if (getCurrFrameType() == 4) {
            return 1;
        }
        return 0;
    }

    public boolean hasQmcfEntrance(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) ? hasQmcfEntrance(i3, false) : ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, i3)).booleanValue();
    }

    public boolean isArtFilterVersionOK(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, i3)).booleanValue();
        }
        if (i3 >= artFilterLimitVersion) {
            return true;
        }
        return false;
    }

    public boolean isQmcfNoNeedBeauty() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        int i3 = this.currQmcfMode;
        if (i3 == 1 || i3 == 2) {
            return true;
        }
        return false;
    }

    public boolean isQmcfSupported(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 25)) ? mSwitchStrategy.isModeSupported(i3) : ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, i3)).booleanValue();
    }

    public boolean isQmcfWork() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (this.currQmcfMode != 0) {
            return true;
        }
        return false;
    }

    public boolean needConvertCoor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        if (this.mCameraMode == 1) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String readQmcfModelFile(String str) {
        FileInputStream fileInputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
        }
        long currentTimeMillis = System.currentTimeMillis();
        File file = new File(str);
        String str2 = null;
        str2 = null;
        str2 = null;
        str2 = null;
        FileInputStream fileInputStream2 = null;
        if (file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Exception e16) {
                e = e16;
                fileInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (fileInputStream2 != null) {
                }
                throw th;
            }
            try {
                try {
                    String str3 = new String(drink(IOUtils.toByteArray(fileInputStream)));
                    try {
                        fileInputStream.close();
                    } catch (Exception e17) {
                        e17.printStackTrace();
                    }
                    str2 = str3;
                } catch (Throwable th6) {
                    th = th6;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception e18) {
                            e18.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e19) {
                e = e19;
                e.printStackTrace();
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e26) {
                        e26.printStackTrace();
                    }
                }
                if (SLog.isEnable()) {
                }
                return str2;
            }
            if (SLog.isEnable()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("readModel Cost:");
                sb5.append(System.currentTimeMillis() - currentTimeMillis);
                sb5.append(",hasContent:");
                sb5.append(!TextUtils.isEmpty(str2));
                SLog.d(TAG, sb5.toString());
            }
        }
        return str2;
    }

    public void reportQmcfFrameConsume(int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
        } else {
            mReporter.reportMtaFrameCost(i3, i16, str, this.currQmcfMode, this.currFrameType);
        }
    }

    public void setCameraMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.mCameraMode = i3;
        }
    }

    public void setCurrFrameType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        if (this.currFrameType != i3) {
            SharedPreferences.Editor edit = SdkContext.getInstance().getApplication().getSharedPreferences(QmcfSwitchStrategy.SP_TAG, 4).edit();
            edit.putInt(QMCF_FRAME_TYPE, i3);
            edit.commit();
            if (SLog.isEnable()) {
                SLog.d(TAG, "setCurrFrameType:" + i3);
            }
        }
        this.currFrameType = i3;
    }

    public void setCurrQmcfMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.currQmcfMode = i3;
        }
    }

    public void setCurrResFolder(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        } else {
            this.currModelResFolder = str;
        }
    }

    public void setIsQQRun(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            isQQRun = z16;
        }
    }

    public void setQmcfInitSuccess(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, z16);
        } else {
            mSwitchStrategy.setInitSuccess(z16);
        }
    }

    public void setQmcfMobileNotSupport(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) str);
            return;
        }
        if (mSwitchStrategy.isMobileSupported()) {
            HashMap hashMap = new HashMap();
            hashMap.put(QmcfReporter.SVAF_PARAM_GPUINFO, str);
            QmcfReporter.report(QmcfReporter.SVAF_EVENT_NOSUPPORT_OCL, hashMap, true);
        }
        mSwitchStrategy.setMobileSupport(false);
    }

    public void setQmcfMobileSupport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
        } else {
            mSwitchStrategy.setMobileSupport(true);
        }
    }

    public void setQmcfProcessConsume(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, j3);
        } else {
            mReporter.updateProcessConsume(j3);
        }
    }

    public void setQmcfRunSupported(boolean z16, boolean z17, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3));
        } else {
            mSwitchStrategy.setQmcfRunSupported(z16, z17, i3);
        }
    }

    public void setSTMatrix(float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) fArr);
        } else {
            this.mSTMatrix = fArr;
        }
    }

    public void switchQmcfModel(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3, (Object) str);
            return;
        }
        if (SLog.isEnable()) {
            SLog.d(TAG, "switchQmcfModel begin resFold" + str);
        }
        synchronized (this.modelSwichList) {
            if (i3 == this.currQmcfMode) {
                this.modelSwichList.add(str);
                if (this.currQmcfMode == 1) {
                    this.modelSwitched = true;
                }
            } else {
                this.modeChanged = true;
                this.modelSwichList.clear();
                this.modelSwichList.add(str);
            }
            this.currQmcfMode = i3;
            this.currModelResFolder = str;
        }
        if (this.singleThreadExecutor == null) {
            if (SLog.isEnable()) {
                SLog.d(TAG, "switchQmcfModel create singleThreadExecutor");
            }
            this.singleThreadExecutor = ProxyExecutors.newSingleThreadExecutor();
        }
        this.singleThreadExecutor.execute(new Runnable() { // from class: com.tencent.mobileqq.qmcf.QmcfManager.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QmcfManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    synchronized (QmcfManager.this.modelSwichList) {
                        if (QmcfManager.this.modelSwichList.size() > 0) {
                            String str2 = (String) QmcfManager.this.modelSwichList.get(QmcfManager.this.modelSwichList.size() - 1);
                            QmcfManager.this.modelSwichList.clear();
                            try {
                                QmcfManager qmcfManager = QmcfManager.this;
                                if (qmcfManager.hasQmcfEntrance(qmcfManager.currQmcfMode, true)) {
                                    QmcfManager.this.currModelResFolder = str2;
                                    QmcfManager.this.getQmcfModelItem();
                                } else {
                                    QmcfManager.this.currQmcfMode = 0;
                                }
                            } catch (Exception unused) {
                                SLog.i(QmcfManager.TAG, "switchModel excep!");
                            }
                            return;
                        }
                        if (SLog.isEnable()) {
                            SLog.d(QmcfManager.TAG, "ignore the old switch!");
                        }
                        return;
                    }
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
    }

    public void updateQmcfFrameConsume(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, j3);
        } else {
            mReporter.updateFrameConsume(j3);
        }
    }

    public void updateQmcfMainSwitch(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) jSONObject);
        } else {
            mSwitchStrategy.updateMainSwitch(jSONObject);
        }
    }

    public boolean hasQmcfEntrance(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, this, Integer.valueOf(i3), Boolean.valueOf(z16))).booleanValue();
        }
        if (DeviceInstance.getSDKVersion() < 21) {
            return false;
        }
        boolean isQmcfSupported = isQmcfSupported(i3);
        boolean isLoadArtFilterSuccess = SoLoader.isLoadArtFilterSuccess();
        if (isQmcfSupported && !isLoadArtFilterSuccess) {
            if (z16) {
                isLoadArtFilterSuccess = SoLoader.loadSvArtFilterSO(SdkContext.getInstance().getApplication());
                if (SLog.isEnable()) {
                    SLog.d(TAG, "reloadso :" + isLoadArtFilterSuccess);
                }
            } else {
                isLoadArtFilterSuccess = SoLoader.isQmcfSoUnLoaded();
            }
        }
        return isQmcfSupported && isLoadArtFilterSuccess;
    }

    public boolean isQmcfSupported() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 26)) ? mSwitchStrategy.isModeSupported(1) || mSwitchStrategy.isModeSupported(2) || mSwitchStrategy.isModeSupported(3) : ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
    }
}
