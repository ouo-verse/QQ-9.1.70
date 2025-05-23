package dov.com.qq.im.ae.download.old;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.VideoEnvironment64BitUtils;

/* compiled from: P */
/* loaded from: classes28.dex */
public class e {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface a {
        void onConfigResult(int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f394495a;

        /* renamed from: b, reason: collision with root package name */
        public int f394496b;

        /* renamed from: c, reason: collision with root package name */
        public int f394497c;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b a(String str) {
        if (VideoEnvironment64BitUtils.checkIs64bit() && !str.endsWith("64bit")) {
            str = str + "64bit";
        }
        b bVar = new b();
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_resource_status_sp", 4);
        bVar.f394495a = sharedPreferences.getInt(str + "_version_k", 0);
        bVar.f394496b = sharedPreferences.getInt(str + "_status_k", -1);
        bVar.f394497c = sharedPreferences.getInt(str + "_last_error_k", -1);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(String str, int i3, int i16, int i17) {
        if (VideoEnvironment64BitUtils.checkIs64bit() && !str.endsWith("64bit")) {
            str = str + "64bit";
        }
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_resource_status_sp", 4).edit();
        edit.putInt(str + "_version_k", i3);
        edit.putInt(str + "_status_k", i16);
        edit.putInt(str + "_last_error_k", i17);
        return edit.commit();
    }
}
