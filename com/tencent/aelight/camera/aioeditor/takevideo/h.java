package com.tencent.aelight.camera.aioeditor.takevideo;

import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes32.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public static String f68705a;

    public static boolean a() {
        f68705a = com.tencent.mobileqq.app.ab.f195231a + "QQEditPic" + File.separator;
        File file = new File(f68705a);
        boolean mkdirs = file.mkdirs();
        boolean isDirectory = file.isDirectory();
        if (QLog.isColorLevel()) {
            QLog.e("initDirs", 2, "thumbFilesDirPath=" + mkdirs + " isdir=" + isDirectory);
        }
        return mkdirs || isDirectory;
    }
}
