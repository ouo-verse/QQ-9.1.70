package com.tencent.av.utils;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes3.dex */
public class k {
    public static String a() {
        File filesDir = BaseApplicationImpl.sApplication.getFilesDir();
        if (filesDir == null) {
            if (QLog.isColorLevel()) {
                QLog.i("DingdongSoundUtil", 2, "[sound_early] getFilesDir is null");
                return "";
            }
            return "";
        }
        return filesDir.getParent() + "/dingdong/sound_early/";
    }
}
