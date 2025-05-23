package com.tencent.mobileqq.vas.wallpaper;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.WallpaperColors;
import android.app.WallpaperManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.service.wallpaper.WallpaperService;
import android.view.SurfaceHolder;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.util.ILiveEntranceUtilApi;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class VipWallpaperService extends WallpaperService {

    /* renamed from: d, reason: collision with root package name */
    private b f311398d = new b();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private class a extends WallpaperService.Engine {

        /* renamed from: a, reason: collision with root package name */
        private final WallpaperHelper f311399a;

        a() {
            super(VipWallpaperService.this);
            this.f311399a = new WallpaperHelper();
        }

        @Override // android.service.wallpaper.WallpaperService.Engine
        public WallpaperColors onComputeColors() {
            return this.f311399a.g();
        }

        @Override // android.service.wallpaper.WallpaperService.Engine
        public void onOffsetsChanged(float f16, float f17, float f18, float f19, int i3, int i16) {
            super.onOffsetsChanged(f16, f17, f18, f19, i3, i16);
        }

        @Override // android.service.wallpaper.WallpaperService.Engine
        public void onSurfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
            super.onSurfaceChanged(surfaceHolder, i3, i16, i17);
            this.f311399a.i(surfaceHolder, i3, i16, i17);
        }

        @Override // android.service.wallpaper.WallpaperService.Engine
        public void onSurfaceCreated(SurfaceHolder surfaceHolder) {
            super.onSurfaceCreated(surfaceHolder);
            this.f311399a.j(VipWallpaperService.this, surfaceHolder);
        }

        @Override // android.service.wallpaper.WallpaperService.Engine
        public void onSurfaceDestroyed(SurfaceHolder surfaceHolder) {
            super.onSurfaceDestroyed(surfaceHolder);
            this.f311399a.k();
        }

        @Override // android.service.wallpaper.WallpaperService.Engine
        public void onSurfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
            super.onSurfaceRedrawNeeded(surfaceHolder);
        }

        @Override // android.service.wallpaper.WallpaperService.Engine
        public void onVisibilityChanged(boolean z16) {
            super.onVisibilityChanged(z16);
            this.f311399a.l(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class b {
        b() {
        }

        static boolean a(Context context) {
            return ((ILiveEntranceUtilApi) QRoute.api(ILiveEntranceUtilApi.class)).isServiceExisted(context, VipWallpaperService.class.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SharedPreferences a(Context context) {
        return context.getApplicationContext().getSharedPreferences("qqvip_wallpaper", 4);
    }

    public static Drawable b() {
        try {
            QLog.i("VipWallpaper", 1, "use system wallpaper");
            return ((WallpaperManager) BaseApplicationImpl.getApplication().getSystemService("wallpaper")).getDrawable();
        } catch (Exception unused) {
            return null;
        }
    }

    public static c c(Context context, boolean z16) {
        if (z16 && !b.a(context)) {
            return new c();
        }
        return d(a(context));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c d(SharedPreferences sharedPreferences) {
        return new c(sharedPreferences.getString("wallpaper_item_id", ""), sharedPreferences.getString("wallpaper_path_img", ""), sharedPreferences.getString("wallpaper_path_video", ""));
    }

    private static void e(Activity activity, AtomicBoolean atomicBoolean) {
        if (!b.a(activity)) {
            Intent intent = new Intent("android.service.wallpaper.CHANGE_LIVE_WALLPAPER");
            intent.putExtra("android.service.wallpaper.extra.LIVE_WALLPAPER_COMPONENT", new ComponentName(activity, (Class<?>) VipWallpaperService.class));
            intent.putExtra("big_brother_source_key", "biz_src_jc_vip");
            activity.startActivity(intent);
            if (atomicBoolean != null) {
                atomicBoolean.set(true);
                return;
            }
            return;
        }
        if (atomicBoolean != null) {
            atomicBoolean.set(false);
        }
    }

    @SuppressLint({"ApplySharedPref"})
    public static void f(Activity activity, c cVar, AtomicBoolean atomicBoolean) {
        QLog.i("VipWallpaper", 1, "set wallpaper = " + cVar.toString());
        a(activity).edit().putString("wallpaper_item_id", cVar.f311401a).putString("wallpaper_path_img", cVar.f311402b).putString("wallpaper_path_video", cVar.f311403c).commit();
        String str = cVar.f311401a;
        if (str != null && !str.equals("0")) {
            e(activity, atomicBoolean);
        }
    }

    @Override // android.service.wallpaper.WallpaperService, android.app.Service
    public void onCreate() {
        super.onCreate();
        VasCommonReporter.getHistoryFeature("wallpaper").report();
        QLog.i("VipWallpaper", 1, "onCreate");
    }

    @Override // android.service.wallpaper.WallpaperService
    public WallpaperService.Engine onCreateEngine() {
        return new a();
    }

    @Override // android.service.wallpaper.WallpaperService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        QLog.i("VipWallpaper", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final String f311401a;

        /* renamed from: b, reason: collision with root package name */
        public final String f311402b;

        /* renamed from: c, reason: collision with root package name */
        @Deprecated
        public final String f311403c;

        public c(String str, String str2, String str3) {
            this.f311401a = str;
            this.f311402b = str2;
            this.f311403c = str3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                return this.f311402b.equals(((c) obj).f311402b);
            }
            return false;
        }

        public String toString() {
            return "WallpaperConfig{itemId='" + this.f311401a + "', imgPath='" + this.f311402b + "', videoPath='" + this.f311403c + "'}";
        }

        public c() {
            this.f311401a = "0";
            this.f311402b = "";
            this.f311403c = "";
        }
    }
}
