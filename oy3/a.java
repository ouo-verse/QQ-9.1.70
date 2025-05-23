package oy3;

import android.annotation.TargetApi;
import android.os.Process;
import com.tencent.mm.hardcoder.HardCoderManager;

/* compiled from: P */
@TargetApi(16)
/* loaded from: classes25.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static a f424520a;

    public static a a() {
        if (f424520a == null) {
            synchronized (a.class) {
                if (f424520a == null) {
                    f424520a = new a();
                }
            }
        }
        return f424520a;
    }

    public void b(String str) {
        if (str.equals("qzone_homepage")) {
            HardCoderManager.getInstance().start(0, 1, 0, 1, new int[]{0}, 1500, 701, 32L, Process.myTid(), "qzoneList", false);
        } else if (str.equals("list_photo")) {
            HardCoderManager.getInstance().start(0, 1, 0, 1, new int[]{0}, 1500, 702, 32L, Process.myTid(), "photoList", false);
        }
    }

    public void c(String str, boolean z16) {
    }
}
