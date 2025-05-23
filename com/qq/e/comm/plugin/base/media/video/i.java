package com.qq.e.comm.plugin.base.media.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.qq.e.comm.managers.GDTADManager;

/* compiled from: P */
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f39286a = true;

    /* renamed from: b, reason: collision with root package name */
    private static Context f39287b = GDTADManager.getInstance().getAppContext();

    private static int a(String str) {
        return f39287b.getResources().getIdentifier(str, "drawable", f39287b.getPackageName());
    }

    public static Bitmap b(Context context) {
        return a(context, a("gdt_ic_express_back"));
    }

    public static Bitmap c(Context context) {
        return a(context, a("gdt_ic_express_volume_on"));
    }

    public static Bitmap d(Context context) {
        return a(context, a("gdt_ic_express_volume_off"));
    }

    public static Bitmap e(Context context) {
        return a(context, a("gdt_ic_express_enter_fullscreen"));
    }

    public static Bitmap f(Context context) {
        return a(context, a("gdt_ic_express_play"));
    }

    public static Bitmap g(Context context) {
        return a(context, a("gdt_ic_express_pause"));
    }

    private static Bitmap a(Context context, int i3) {
        return BitmapFactory.decodeResource(context.getResources(), i3);
    }

    public static Bitmap a(Context context) {
        return a(context, a("gdt_ic_express_close"));
    }

    public static void a(boolean z16) {
        f39286a = z16;
    }
}
