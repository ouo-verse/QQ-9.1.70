package com.qzone.component.sound;

import android.media.AudioManager;
import android.util.SparseIntArray;
import com.qzone.util.ToastUtil;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static AudioManager f46723a = (AudioManager) BaseApplication.getContext().getSystemService("audio");

    /* renamed from: b, reason: collision with root package name */
    private static int f46724b = -2;

    /* renamed from: c, reason: collision with root package name */
    private static SparseIntArray f46725c = new SparseIntArray();

    public static void a() {
        if (SystemMethodProxy.getStreamVolume(f46723a, 3) == 0) {
            ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastOpenVoice", "\u8bf7\u6253\u5f00\u97f3\u91cf\u6536\u542c"));
        }
    }
}
