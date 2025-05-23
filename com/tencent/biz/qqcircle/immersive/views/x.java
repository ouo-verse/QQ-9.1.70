package com.tencent.biz.qqcircle.immersive.views;

import android.content.Context;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.api.IVasTempApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.libpag.PAGFile;

/* compiled from: P */
/* loaded from: classes4.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    private static volatile IVasTempApi f91336a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f91337b;

    public static boolean c() {
        if (f91337b) {
            return true;
        }
        d();
        f91337b = f91336a.initPagSo();
        return f91337b;
    }

    private static void d() {
        if (f91336a == null) {
            synchronized (x.class) {
                if (f91336a == null) {
                    f91336a = IVasTempApi.INSTANCE.get();
                }
            }
        }
    }

    public static PAGFile e(Context context, Object obj) {
        return f(context, obj);
    }

    private static PAGFile f(Context context, Object obj) {
        try {
            if (obj instanceof Integer) {
                return k(context, ((Integer) obj).intValue());
            }
            if (obj instanceof String) {
                return PagViewMonitor.Load((String) obj);
            }
            QLog.e("QFSPagFileUtils", 1, "get pag file type error, path =  " + obj);
            return null;
        } catch (Throwable th5) {
            QLog.e("QFSPagFileUtils", 1, "get pag file error: " + th5);
            return null;
        }
    }

    public static void g(final WeakReference<Function0<Unit>> weakReference) {
        if (h()) {
            Function0<Unit> function0 = weakReference.get();
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        QLog.d("QFSPagFileUtils", 1, "api.initPagFile async");
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.v
            @Override // java.lang.Runnable
            public final void run() {
                x.l(weakReference);
            }
        });
    }

    public static boolean h() {
        return f91337b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit j(WeakReference weakReference) {
        Function0 function0 = (Function0) weakReference.get();
        if (function0 != null) {
            function0.invoke();
            return null;
        }
        QLog.d("QFSPagFileUtils", 2, "initPagFile function0 is null");
        return null;
    }

    private static PAGFile k(Context context, int i3) {
        if (context != null && i3 != 0) {
            InputStream openRawResource = context.getResources().openRawResource(i3);
            try {
                int available = openRawResource.available();
                if (available <= 0) {
                    QLog.e("QFSPagFileUtils", 1, "readPagFromRaw error, size is 0");
                    return null;
                }
                byte[] bArr = new byte[available];
                openRawResource.read(bArr, 0, available);
                return PAGFile.Load(bArr);
            } catch (Throwable th5) {
                try {
                    QLog.e("QFSPagFileUtils", 1, "readPagFromRaw error", th5);
                    return null;
                } finally {
                    FileUtils.close(openRawResource);
                }
            }
        }
        QLog.w("QFSPagFileUtils", 1, "cant readPagFromRaw: context=" + context + ", id=" + i3);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(final WeakReference<Function0<Unit>> weakReference) {
        QLog.d("QFSPagFileUtils", 1, "api.initPagFile");
        d();
        f91336a.requestPagDownload(new Function0() { // from class: com.tencent.biz.qqcircle.immersive.views.w
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit j3;
                j3 = x.j(weakReference);
                return j3;
            }
        });
    }
}
