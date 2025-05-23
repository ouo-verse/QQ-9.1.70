package org.light.device;

import android.content.Context;
import android.os.Build;
import com.google.gson.Gson;
import java.util.Iterator;
import java.util.List;
import org.light.utils.FileUtils;
import org.light.utils.LightLogUtil;

/* compiled from: P */
/* loaded from: classes29.dex */
public class GpuScopeAttrs {
    private static final String[] GPU_NAMES = {"Mali-T860", "Mali-T720"};
    private static final GpuScopeAttrs INSTANCE = new GpuScopeAttrs();
    private static final String TAG = "GpuScopeAttrs";
    private GpuBean.AndroidVersionModel thisAndroidVersionModel;
    private GpuBean.DeviceModel thisDeviceModel;
    private GpuBean.GpuModel thisGpuModel;
    private GpuBean.SysVersionModel thisSysVersionModel;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class GpuBean {
        public List<AndroidVersionModel> androidVersionModels;
        public List<DeviceModel> deviceModels;
        public List<GpuModel> gpuModels;
        public List<SysVersionModel> sysVersionModels;

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static class AndroidVersionModel extends BaseModel {
            public String androidVersion;
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static class BaseModel {
            public List<String> GLExtensionBlackList;
            public List<String> filamentWhiteList;
            public List<String> renderBlackList;
            public boolean kapuSupport = true;
            public boolean filamentSupport = true;
            public boolean boneSupport = true;
            public boolean openclSupport = true;
            public boolean aiSupport = true;
            public boolean shareGLContextError = false;
            public boolean ace3dFlushSupport = true;
            public boolean hairSegPreLoadSupport = true;
            public boolean fenceSupport = true;
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static class DeviceModel extends BaseModel {
            public String device;
            public boolean enableImuSmooth = false;
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static class GpuModel extends BaseModel {
            public String gpu;
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static class SysVersionModel extends BaseModel {
            public String version;
        }
    }

    public static GpuScopeAttrs getInstance() {
        return INSTANCE;
    }

    public GpuBean.AndroidVersionModel getAndroidVersionModel() {
        return this.thisAndroidVersionModel;
    }

    public GpuBean.DeviceModel getDeviceModel() {
        return this.thisDeviceModel;
    }

    public GpuBean.GpuModel getGPuModel() {
        return this.thisGpuModel;
    }

    public GpuBean.SysVersionModel getSysVersionModel() {
        return this.thisSysVersionModel;
    }

    public void init(Context context, String str, String str2, String str3, String str4) {
        GpuBean gpuBean;
        String str5;
        String str6;
        String str7 = FileUtils.genSeperateFileDir(str4) + "device_config.json";
        if (!FileUtils.isFileExist(str7)) {
            str7 = "assets://device_config.json";
        }
        try {
            gpuBean = (GpuBean) new Gson().fromJson(FileUtils.load(context, str7), GpuBean.class);
        } catch (Throwable th5) {
            LightLogUtil.e(TAG, th5.toString());
            gpuBean = null;
        }
        if (gpuBean != null) {
            this.thisGpuModel = null;
            List<GpuBean.GpuModel> list = gpuBean.gpuModels;
            if (list != null) {
                Iterator<GpuBean.GpuModel> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GpuBean.GpuModel next = it.next();
                    if (str2 != null && next.gpu != null) {
                        if (str2.contains(next.gpu + ";")) {
                            this.thisGpuModel = next;
                            break;
                        }
                    }
                }
            }
            this.thisDeviceModel = null;
            List<GpuBean.DeviceModel> list2 = gpuBean.deviceModels;
            if (list2 != null) {
                Iterator<GpuBean.DeviceModel> it5 = list2.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    }
                    GpuBean.DeviceModel next2 = it5.next();
                    if (str.toLowerCase().contains(next2.device.toLowerCase())) {
                        LightLogUtil.i(TAG, str + "->>deviceModels:" + next2.device + ",shareGLContextError:" + next2.shareGLContextError);
                        this.thisDeviceModel = next2;
                        break;
                    }
                }
            }
            this.thisSysVersionModel = null;
            List<GpuBean.SysVersionModel> list3 = gpuBean.sysVersionModels;
            if (list3 != null) {
                Iterator<GpuBean.SysVersionModel> it6 = list3.iterator();
                while (true) {
                    if (!it6.hasNext()) {
                        break;
                    }
                    GpuBean.SysVersionModel next3 = it6.next();
                    if (str2 != null && (str6 = next3.version) != null && str3.contains(str6)) {
                        this.thisSysVersionModel = next3;
                        break;
                    }
                }
            }
            this.thisAndroidVersionModel = null;
            List<GpuBean.AndroidVersionModel> list4 = gpuBean.androidVersionModels;
            if (list4 != null) {
                for (GpuBean.AndroidVersionModel androidVersionModel : list4) {
                    if (str2 != null && (str5 = androidVersionModel.androidVersion) != null && Build.VERSION.RELEASE.equals(str5)) {
                        this.thisAndroidVersionModel = androidVersionModel;
                        return;
                    }
                }
            }
        }
    }
}
