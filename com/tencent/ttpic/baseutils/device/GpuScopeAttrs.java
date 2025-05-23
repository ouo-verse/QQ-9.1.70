package com.tencent.ttpic.baseutils.device;

import android.content.Context;
import com.google.gson.Gson;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class GpuScopeAttrs {
    private static final String[] GPU_NAMES = {"Mali-T860", "Mali-T720"};
    private static final GpuScopeAttrs INSTANCE = new GpuScopeAttrs();
    private static final String TAG = "GpuScopeAttrs";
    private GpuBean.DeviceModel thisDeviceModel;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class GpuBean {
        public List<DeviceModel> deviceModels;
        public List<GpuModel> gpuModels;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        public static class DeviceModel {
            public String device;
            public boolean hairColor;
        }

        /* compiled from: P */
        /* loaded from: classes27.dex */
        public static class GpuModel {
            public boolean filamentSupport;
            public List<String> filamentWhiteList;
            public String gpu;
        }
    }

    public static GpuScopeAttrs getInstance() {
        return INSTANCE;
    }

    public GpuBean.DeviceModel getDeviceModel() {
        return this.thisDeviceModel;
    }

    public void init(Context context, String str, String str2) {
        GpuBean gpuBean;
        List<GpuBean.DeviceModel> list;
        String str3 = FileUtils.genSeperateFileDir(str2) + "device_config.json";
        if (!FileUtils.isFileExist(str3)) {
            str3 = "assets://device_config.json";
        }
        try {
            gpuBean = (GpuBean) new Gson().fromJson(FileUtils.load(context, str3), GpuBean.class);
        } catch (Throwable th5) {
            LogUtils.e(TAG, th5.toString());
            gpuBean = null;
        }
        if (gpuBean != null && (list = gpuBean.deviceModels) != null) {
            for (GpuBean.DeviceModel deviceModel : list) {
                if (str.contains(deviceModel.device)) {
                    this.thisDeviceModel = deviceModel;
                    return;
                }
            }
        }
    }
}
