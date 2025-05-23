package com.tencent.aelight.camera.aioeditor.capture.util;

import hr.d;
import java.io.File;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static File f67190a = new File(QIMFileUtils.a(), "information_paster");

    /* renamed from: b, reason: collision with root package name */
    private static String f67191b = f67190a.getPath() + File.separator;

    public static File a() {
        return f67190a;
    }

    public static String b() {
        return f67191b;
    }

    public static String c(d.c cVar) {
        return f67191b + cVar.f406031j + "_" + cVar.f406030i + File.separator + cVar.f406031j;
    }

    public static String d(d.c cVar) {
        return new File(f67190a, cVar.f406031j + "_" + cVar.f406030i + ".zip").getPath();
    }
}
