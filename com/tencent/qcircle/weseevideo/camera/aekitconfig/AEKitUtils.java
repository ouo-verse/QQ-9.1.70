package com.tencent.qcircle.weseevideo.camera.aekitconfig;

import android.content.Context;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.api.standard.AEModuleConfig;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.qcircle.oscar.app.GlobalContext;
import com.tencent.ttpic.openapi.manager.FeatureManager;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AEKitUtils {
    private static final String TAG = "AEKitUtils";
    private boolean mIsLoadAekitSo = false;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static final class SINGLETON {
        public static AEKitUtils instance;

        SINGLETON() {
        }

        public static AEKitUtils getInstance() {
            if (instance == null) {
                instance = new AEKitUtils();
            }
            return instance;
        }
    }

    public static AEKitUtils g() {
        return SINGLETON.getInstance();
    }

    public void initAEKit(Context context) {
        AEModule.initialize(context, AEModuleConfig.newBuilder().build());
        loadAekitSoAndSetting();
    }

    public void loadAekitSoAndSetting() {
        if (this.mIsLoadAekitSo) {
            return;
        }
        GlUtil.setEnableLog(false);
        if (AEModule.getContext() == null) {
            AEModule.setContext(GlobalContext.getContext());
        }
        FeatureManager.loadBasicFeatures();
        FeatureManager.Features.IMAGE_ALGO.init();
        FeatureManager.Features.LIGHT_SDK.init();
        this.mIsLoadAekitSo = true;
    }
}
