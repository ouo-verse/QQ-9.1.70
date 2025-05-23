package com.tencent.av.utils;

import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes3.dex */
public class q {
    public static String a() {
        File filesDir = BaseApplication.getContext().getFilesDir();
        if (filesDir == null) {
            if (QLog.isColorLevel()) {
                QLog.i("GAudioSoundUtil", 2, "[sound_early] getFilesDir is null");
                return "";
            }
            return "";
        }
        return filesDir.getParent() + "/qav/sound_early/";
    }

    public static boolean b(String str) {
        return new File(a(), str).exists();
    }

    public static void c(Context context) {
        if (QLog.isColorLevel()) {
            QLog.i("GAudioSoundUtil", 2, "[sound_early] trigger early download");
        }
        String a16 = a();
        File file = new File(a16, "qav_gaudio_muted.mp3");
        File file2 = new File(a16, "qav_gaudio_cancel_muted.mp3");
        File file3 = new File(a16, "qav_peer_phone_calling.mp3");
        if (!file.exists() || !file2.exists() || !file3.exists()) {
            Intent intent = new Intent("tencent.video.v2q.downloadGAudioSound");
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent);
        }
    }
}
