package com.tencent.mobileqq.intervideo.huayang.impl;

import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.intervideo.huayang.HuayangLoadbackgroudActivity;
import com.tencent.mobileqq.intervideo.huayang.IHuayangLoadbackgroudActivityUtil;
import cooperation.qzone.util.ProcessUtils;

/* compiled from: P */
/* loaded from: classes33.dex */
public class HuayangLoadbackgroudActivityUtilImpl implements IHuayangLoadbackgroudActivityUtil {
    @Override // com.tencent.mobileqq.intervideo.huayang.IHuayangLoadbackgroudActivityUtil
    public void init() {
        if (TextUtils.equals(ProcessUtils.getCurProcessName(BaseApplicationImpl.sApplication), BaseApplicationImpl.sApplication.getPackageName() + ":troophomework")) {
            BaseApplicationImpl.sApplication.registerReceiver(HuayangLoadbackgroudActivity.b(), new IntentFilter("action_iv_plugin_update"));
        }
    }
}
