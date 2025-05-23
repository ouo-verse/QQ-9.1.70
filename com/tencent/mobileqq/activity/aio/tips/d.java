package com.tencent.mobileqq.activity.aio.tips;

import android.os.SystemClock;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d {

    /* renamed from: c, reason: collision with root package name */
    public static final String f180103c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f180104d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f180105e;

    /* renamed from: f, reason: collision with root package name */
    private static d f180106f;

    /* renamed from: a, reason: collision with root package name */
    public String f180107a;

    /* renamed from: b, reason: collision with root package name */
    public String f180108b;

    static {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(BaseApplication.getContext().getFilesDir());
        String str = File.separator;
        sb5.append(str);
        sb5.append("lightalkfiles");
        String sb6 = sb5.toString();
        f180103c = sb6;
        f180104d = sb6 + str + "aio_lightalk_tips_config";
        f180105e = sb6 + str + "aio_lightalk_tips_icon";
        f180106f = null;
    }

    d() {
    }

    public static d a() {
        boolean z16;
        long uptimeMillis = SystemClock.uptimeMillis();
        b();
        long uptimeMillis2 = SystemClock.uptimeMillis();
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("read config cost ");
            sb5.append(uptimeMillis2 - uptimeMillis);
            sb5.append(" , result is ");
            if (f180106f == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d("LightalkBlueTipsBar", 2, sb5.toString());
        }
        return f180106f;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: SimplifyVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r3v2 ??, still in use, count: 1, list:
          (r3v2 ?? I:??[OBJECT, ARRAY]) from 0x008b: MOVE (r2v6 java.io.FileInputStream) = (r3v2 ?? I:??[OBJECT, ARRAY]) (LINE:140)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:80)
        	at jadx.core.dex.visitors.SimplifyVisitor.simplifyIf(SimplifyVisitor.java:280)
        	at jadx.core.dex.visitors.SimplifyVisitor.simplifyInsn(SimplifyVisitor.java:138)
        	at jadx.core.dex.visitors.SimplifyVisitor.simplifyBlock(SimplifyVisitor.java:86)
        	at jadx.core.dex.visitors.SimplifyVisitor.visit(SimplifyVisitor.java:71)
        */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void b() {
        /*
            java.lang.String r0 = ""
            com.tencent.mobileqq.activity.aio.tips.d r1 = com.tencent.mobileqq.activity.aio.tips.d.f180106f
            if (r1 == 0) goto L8
            return
        L8:
            java.io.File r1 = new java.io.File
            java.lang.String r2 = com.tencent.mobileqq.activity.aio.tips.d.f180104d
            r1.<init>(r2)
            java.io.File r2 = new java.io.File
            java.lang.String r3 = com.tencent.mobileqq.activity.aio.tips.d.f180105e
            r2.<init>(r3)
            boolean r3 = r1.exists()
            java.lang.String r4 = "LightalkBlueTipsBar"
            r5 = 2
            if (r3 == 0) goto L9d
            long r6 = r1.length()
            r8 = 0
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 <= 0) goto L9d
            boolean r2 = r2.exists()
            if (r2 == 0) goto L9d
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            int r1 = r3.available()     // Catch: java.lang.Exception -> L71 java.lang.Throwable -> L8a
            byte[] r1 = new byte[r1]     // Catch: java.lang.Exception -> L71 java.lang.Throwable -> L8a
            r3.read(r1)     // Catch: java.lang.Exception -> L71 java.lang.Throwable -> L8a
            java.lang.String r6 = new java.lang.String     // Catch: java.lang.Exception -> L71 java.lang.Throwable -> L8a
            java.lang.String r7 = "UTF-8"
            r6.<init>(r1, r7)     // Catch: java.lang.Exception -> L71 java.lang.Throwable -> L8a
            java.lang.String r1 = "__"
            java.lang.String[] r1 = r6.split(r1)     // Catch: java.lang.Exception -> L71 java.lang.Throwable -> L8a
            int r6 = r1.length     // Catch: java.lang.Exception -> L71 java.lang.Throwable -> L8a
            if (r6 != r5) goto L62
            com.tencent.mobileqq.activity.aio.tips.d r6 = new com.tencent.mobileqq.activity.aio.tips.d     // Catch: java.lang.Exception -> L71 java.lang.Throwable -> L8a
            r6.<init>()     // Catch: java.lang.Exception -> L71 java.lang.Throwable -> L8a
            com.tencent.mobileqq.activity.aio.tips.d.f180106f = r6     // Catch: java.lang.Exception -> L71 java.lang.Throwable -> L8a
            r7 = 0
            r7 = r1[r7]     // Catch: java.lang.Exception -> L71 java.lang.Throwable -> L8a
            r6.f180107a = r7     // Catch: java.lang.Exception -> L71 java.lang.Throwable -> L8a
            r7 = 1
            r1 = r1[r7]     // Catch: java.lang.Exception -> L71 java.lang.Throwable -> L8a
            r6.f180108b = r1     // Catch: java.lang.Exception -> L71 java.lang.Throwable -> L8a
        L62:
            r3.close()     // Catch: java.io.IOException -> L66
            goto La9
        L66:
            r1 = move-exception
            boolean r2 = com.tencent.qphone.base.util.QLog.isColorLevel()
            if (r2 == 0) goto La9
        L6d:
            com.tencent.qphone.base.util.QLog.d(r4, r5, r0, r1)
            goto La9
        L71:
            r1 = move-exception
            goto L77
        L73:
            r1 = move-exception
            goto L8c
        L75:
            r1 = move-exception
            r3 = r2
        L77:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L8a
            com.tencent.mobileqq.activity.aio.tips.d.f180106f = r2     // Catch: java.lang.Throwable -> L8a
            if (r3 == 0) goto La9
            r3.close()     // Catch: java.io.IOException -> L82
            goto La9
        L82:
            r1 = move-exception
            boolean r2 = com.tencent.qphone.base.util.QLog.isColorLevel()
            if (r2 == 0) goto La9
            goto L6d
        L8a:
            r1 = move-exception
            r2 = r3
        L8c:
            if (r2 == 0) goto L9c
            r2.close()     // Catch: java.io.IOException -> L92
            goto L9c
        L92:
            r2 = move-exception
            boolean r3 = com.tencent.qphone.base.util.QLog.isColorLevel()
            if (r3 == 0) goto L9c
            com.tencent.qphone.base.util.QLog.d(r4, r5, r0, r2)
        L9c:
            throw r1
        L9d:
            boolean r0 = com.tencent.qphone.base.util.QLog.isColorLevel()
            if (r0 == 0) goto La9
            java.lang.String r0 = "readTipsConfig:file not exist"
            com.tencent.qphone.base.util.QLog.d(r4, r5, r0)
        La9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mobileqq.activity.aio.tips.d.b():void");
    }
}
