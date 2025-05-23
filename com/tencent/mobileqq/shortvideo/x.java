package com.tencent.mobileqq.shortvideo;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;

/* compiled from: P */
/* loaded from: classes18.dex */
public class x extends com.tencent.mobileqq.utils.q {

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        void onConfigResult(int i3, int i16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f288325a;

        /* renamed from: b, reason: collision with root package name */
        public int f288326b;

        /* renamed from: c, reason: collision with root package name */
        public int f288327c;

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
        bVar.f288325a = sharedPreferences.getInt(str + "_version_k", 0);
        bVar.f288326b = sharedPreferences.getInt(str + "_status_k", -1);
        bVar.f288327c = sharedPreferences.getInt(str + "_last_error_k", -1);
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
