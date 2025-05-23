package com.qzone.album.base;

import NS_QMALL_COVER.AlbumThemeSkin;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.Observable;
import com.qzone.personalize.business.QzoneZipDownloadService;
import com.qzone.proxy.feedcomponent.util.j;
import com.qzone.reborn.util.k;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.open.base.MD5Utils;
import cooperation.qzone.cache.CacheManager;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

/* loaded from: classes39.dex */
public class AlbumPersonalizeManager extends Observable {

    /* renamed from: i, reason: collision with root package name */
    private static volatile AlbumPersonalizeManager f41926i;

    /* renamed from: m, reason: collision with root package name */
    private static final Object f41927m = new Object();

    /* renamed from: d, reason: collision with root package name */
    private String f41928d = "AlbumPersonalizeManager";

    /* renamed from: e, reason: collision with root package name */
    private AlbumThemeSkin f41929e = null;

    /* renamed from: f, reason: collision with root package name */
    private AlbumThemeSkin f41930f = null;

    /* renamed from: h, reason: collision with root package name */
    private Handler f41931h = new a();

    /* renamed from: com.qzone.album.base.AlbumPersonalizeManager$3, reason: invalid class name */
    /* loaded from: classes39.dex */
    class AnonymousClass3 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f41937d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f41938e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f41939f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f41940h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Context f41941i;
        final /* synthetic */ AlbumPersonalizeManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            Bitmap G;
            String K = this.this$0.K(this.f41937d);
            try {
                if (TextUtils.isEmpty(K) || (G = this.this$0.G(K, null)) == null || this.f41938e.getHandler() == null) {
                    return;
                }
                final Bitmap createBitmap = Bitmap.createBitmap(G, 0, (G.getHeight() * this.f41939f) / this.f41940h, G.getWidth(), (G.getHeight() * this.f41938e.getHeight()) / this.f41938e.getWidth(), (Matrix) null, false);
                this.f41938e.getHandler().post(new Runnable() { // from class: com.qzone.album.base.AlbumPersonalizeManager.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        View view = AnonymousClass3.this.f41938e;
                        if (view instanceof ImageView) {
                            ((ImageView) view).setImageDrawable(new BitmapDrawable(AnonymousClass3.this.f41941i.getResources(), createBitmap));
                        } else {
                            view.setBackgroundDrawable(new BitmapDrawable(AnonymousClass3.this.f41941i.getResources(), createBitmap));
                        }
                    }
                });
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    /* loaded from: classes39.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                AlbumPersonalizeManager albumPersonalizeManager = AlbumPersonalizeManager.this;
                albumPersonalizeManager.f41929e = albumPersonalizeManager.f41930f;
                EventCenter.getInstance().post("QzoneAlbum", 19, (Object[]) null);
            }
        }
    }

    AlbumPersonalizeManager() {
        N();
    }

    public static boolean F(Activity activity, boolean z16) {
        Window window = activity.getWindow();
        if (window == null) {
            return false;
        }
        Class<?> cls = window.getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i3 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Class<?> cls3 = Integer.TYPE;
            Method method = cls.getMethod("setExtraFlags", cls3, cls3);
            if (z16) {
                method.invoke(window, Integer.valueOf(i3), Integer.valueOf(i3));
            } else {
                method.invoke(window, 0, Integer.valueOf(i3));
            }
            try {
                if (z16) {
                    activity.getWindow().getDecorView().setSystemUiVisibility(9216);
                } else {
                    activity.getWindow().getDecorView().setSystemUiVisibility(0);
                }
            } catch (Exception unused) {
            }
            return true;
        } catch (Exception unused2) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String K(String str) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(CacheManager.getCacheDir("AlbumTheme"));
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append(MD5Utils.toMD5(J().strPicZipUrl));
        sb5.append(str2);
        sb5.append(str);
        return sb5.toString();
    }

    public static AlbumPersonalizeManager L() {
        if (f41926i == null) {
            synchronized (f41927m) {
                if (f41926i == null) {
                    try {
                        f41926i = new AlbumPersonalizeManager();
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return f41926i;
    }

    private Drawable M(Context context, int i3, boolean z16) {
        return ie0.a.f().o(context, i3, z16 ? R.color.qui_button_bg_primary_default : R.color.qui_common_icon_primary, k.f59549a.f() ? 1002 : 1001);
    }

    public void H(String str) {
        QzoneZipDownloadService.k().i(str, CacheManager.getCacheDir("AlbumTheme"), this.f41931h);
    }

    public int I() {
        return P() ? -1 : -16777216;
    }

    public AlbumThemeSkin J() {
        return this.f41929e;
    }

    public void N() {
        AlbumThemeSkin albumThemeSkin = new AlbumThemeSkin();
        albumThemeSkin.iItemId = -1;
        albumThemeSkin.strPicZipUrl = "";
        albumThemeSkin.lTabBarSelectedFontColor = Long.parseLong("4279876351");
        albumThemeSkin.lTabBarUnselectedFontColor = Long.parseLong("4281612620");
        this.f41929e = albumThemeSkin;
    }

    public void O() {
        if (Q()) {
            EventCenter.getInstance().post("QzoneAlbum", 19, (Object[]) null);
        } else {
            T(this.f41929e);
        }
    }

    public boolean P() {
        AlbumThemeSkin albumThemeSkin = this.f41929e;
        return albumThemeSkin != null && albumThemeSkin.iColor == 1;
    }

    public boolean Q() {
        AlbumThemeSkin albumThemeSkin = this.f41929e;
        return albumThemeSkin == null || (albumThemeSkin != null && albumThemeSkin.iItemId == -1);
    }

    public boolean R() {
        if (!Q()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(CacheManager.getCacheDir("AlbumTheme"));
            String str = File.separator;
            sb5.append(str);
            sb5.append(MD5Utils.toMD5(this.f41929e.strPicZipUrl));
            sb5.append(str);
            File file = new File(sb5.toString());
            if (file.exists() && file.isDirectory()) {
                return true;
            }
        }
        return false;
    }

    public void T(AlbumThemeSkin albumThemeSkin) {
        if (!TextUtils.isEmpty(albumThemeSkin.strPicZipUrl)) {
            this.f41930f = albumThemeSkin;
            L().H(albumThemeSkin.strPicZipUrl);
        } else {
            N();
        }
    }

    public boolean X() {
        return Q() && com.tencent.mobileqq.simpleui.b.c() && !SimpleUIUtil.useDarkResource();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.FileInputStream, java.io.InputStream] */
    public Bitmap G(String str, BitmapFactory.Options options) {
        ?? r16;
        Bitmap bitmap;
        Bitmap bitmap2 = null;
        bitmap2 = null;
        ?? r06 = 0;
        try {
            if (new File(str).exists()) {
                r16 = new FileInputStream(str);
                if (options != null) {
                    try {
                        if (options.inJustDecodeBounds) {
                            bitmap = BitmapFactory.decodeStream(new BufferedInputStream(r16, 2048), null, options);
                            bitmap2 = r16;
                            r06 = bitmap2;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        try {
                            th.printStackTrace();
                            if (r16 == null) {
                                return bitmap2;
                            }
                            try {
                                r16.close();
                                return bitmap2;
                            } catch (IOException unused) {
                                return bitmap2;
                            }
                        } catch (Throwable th6) {
                            if (r16 != null) {
                                try {
                                    r16.close();
                                } catch (IOException unused2) {
                                }
                            }
                            throw th6;
                        }
                    }
                }
                bitmap = BitmapFactory.decodeStream(new BufferedInputStream(r16, 8192), null, options);
                bitmap2 = r16;
                r06 = bitmap2;
            } else {
                bitmap = null;
            }
            if (r06 != 0) {
                try {
                    r06.close();
                } catch (IOException unused3) {
                }
            }
            return bitmap;
        } catch (Throwable th7) {
            th = th7;
            r16 = null;
        }
    }

    public void S(TextView textView) {
        if (textView != null) {
            if (P()) {
                textView.setTextColor(-1291845633);
            } else {
                textView.setTextColor(-7894119);
            }
        }
    }

    public void U(TextView textView, Resources resources) {
        if (textView != null) {
            if (!P() && !X()) {
                textView.setTextColor(resources.getColor(R.color.qzone_skin_album_sub_text_color));
            } else {
                textView.setTextColor(-1291845633);
            }
        }
    }

    public void W(final Context context, final String str, final View view) {
        if (view == null || J() == null) {
            return;
        }
        j.a(this.f41928d, 1, "update theme resource:" + str);
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.qzone.album.base.AlbumPersonalizeManager.2
            @Override // java.lang.Runnable
            public void run() {
                final Bitmap G;
                String K = AlbumPersonalizeManager.this.K(str);
                if (TextUtils.isEmpty(K) || (G = AlbumPersonalizeManager.this.G(K, null)) == null || view.getHandler() == null) {
                    return;
                }
                view.getHandler().post(new Runnable() { // from class: com.qzone.album.base.AlbumPersonalizeManager.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            View view2 = view;
                            if (view2 instanceof ImageView) {
                                ((ImageView) view2).setImageDrawable(new BitmapDrawable(context.getResources(), G));
                            } else {
                                view2.setBackgroundDrawable(new BitmapDrawable(context.getResources(), G));
                            }
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                    }
                });
            }
        }, null, true);
    }

    public void V(Context context, int i3, View view, View view2, View view3, View view4, View view5, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4) {
        RadioButton radioButton5;
        String str;
        String str2;
        View view6;
        RadioButton radioButton6;
        String str3;
        String str4;
        if (this.f41929e != null && !Q() && view2.getHandler() != null) {
            if (i3 == 0) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("tabbar");
                String str5 = File.separator;
                sb5.append(str5);
                sb5.append("albumSelected@2x.png");
                W(context, sb5.toString(), view2);
                W(context, "tabbar" + str5 + "photo@2x.png", view3);
                W(context, "tabbar" + str5 + "video@2x.png", view4);
                if (view5 != null) {
                    W(context, "tabbar" + str5 + "localphoto@2x.png", view5);
                }
                radioButton.setTextColor((int) this.f41929e.lTabBarSelectedFontColor);
                radioButton2.setTextColor((int) this.f41929e.lTabBarUnselectedFontColor);
                radioButton3.setTextColor((int) this.f41929e.lTabBarUnselectedFontColor);
                radioButton5 = radioButton4;
                if (radioButton5 != null) {
                    radioButton5.setTextColor((int) this.f41929e.lTabBarUnselectedFontColor);
                }
            } else {
                radioButton5 = radioButton4;
            }
            if (i3 != 1) {
                str = "video@2x.png";
                str2 = "photo@2x.png";
            } else {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("tabbar");
                str2 = "photo@2x.png";
                String str6 = File.separator;
                sb6.append(str6);
                sb6.append("album@2x.png");
                W(context, sb6.toString(), view2);
                W(context, "tabbar" + str6 + "photoSelected@2x.png", view3);
                W(context, "tabbar" + str6 + "video@2x.png", view4);
                if (view5 != null) {
                    W(context, "tabbar" + str6 + "localphoto@2x.png", view5);
                }
                str = "video@2x.png";
                radioButton.setTextColor((int) this.f41929e.lTabBarUnselectedFontColor);
                radioButton2.setTextColor((int) this.f41929e.lTabBarSelectedFontColor);
                radioButton3.setTextColor((int) this.f41929e.lTabBarUnselectedFontColor);
                if (radioButton5 != null) {
                    radioButton5.setTextColor((int) this.f41929e.lTabBarUnselectedFontColor);
                }
            }
            if (i3 == 2) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append("tabbar");
                String str7 = File.separator;
                sb7.append(str7);
                sb7.append("album@2x.png");
                view6 = view2;
                W(context, sb7.toString(), view6);
                StringBuilder sb8 = new StringBuilder();
                sb8.append("tabbar");
                sb8.append(str7);
                str3 = str;
                str4 = str2;
                sb8.append(str4);
                W(context, sb8.toString(), view3);
                W(context, "tabbar" + str7 + "videoSelected@2x.png", view4);
                if (view5 != null) {
                    W(context, "tabbar" + str7 + "localphoto@2x.png", view5);
                }
                radioButton.setTextColor((int) this.f41929e.lTabBarUnselectedFontColor);
                radioButton2.setTextColor((int) this.f41929e.lTabBarUnselectedFontColor);
                radioButton6 = radioButton3;
                radioButton6.setTextColor((int) this.f41929e.lTabBarSelectedFontColor);
                if (radioButton5 != null) {
                    radioButton5.setTextColor((int) this.f41929e.lTabBarUnselectedFontColor);
                }
            } else {
                view6 = view2;
                radioButton6 = radioButton3;
                str3 = str;
                str4 = str2;
            }
            if (i3 == 3) {
                StringBuilder sb9 = new StringBuilder();
                sb9.append("tabbar");
                String str8 = File.separator;
                sb9.append(str8);
                sb9.append("album@2x.png");
                W(context, sb9.toString(), view6);
                W(context, "tabbar" + str8 + str4, view3);
                W(context, "tabbar" + str8 + str3, view4);
                if (view5 != null) {
                    W(context, "tabbar" + str8 + "localphotoSelected@2x.png", view5);
                }
                radioButton.setTextColor((int) this.f41929e.lTabBarUnselectedFontColor);
                radioButton2.setTextColor((int) this.f41929e.lTabBarUnselectedFontColor);
                radioButton6.setTextColor((int) this.f41929e.lTabBarUnselectedFontColor);
                if (radioButton5 != null) {
                    radioButton5.setTextColor((int) this.f41929e.lTabBarSelectedFontColor);
                }
            }
            W(context, "tabbarBg@2x.png", view);
            return;
        }
        ie0.a f16 = ie0.a.f();
        k kVar = k.f59549a;
        int g16 = f16.g(context, R.color.qui_button_bg_primary_default, kVar.f() ? 1002 : 1001);
        int g17 = ie0.a.f().g(context, R.color.qui_common_text_primary, kVar.f() ? 1002 : 1001);
        boolean z16 = i3 == 0;
        boolean z17 = i3 == 1;
        boolean z18 = i3 == 2;
        boolean z19 = i3 == 3;
        ((ImageView) view2).setImageDrawable(M(context, R.drawable.qui_feed_picture_collection, z16));
        ((ImageView) view3).setImageDrawable(M(context, R.drawable.qui_image, z17));
        ((ImageView) view4).setImageDrawable(M(context, R.drawable.qui_play_circle, z18));
        if (view5 != null) {
            ((ImageView) view5).setImageDrawable(M(context, R.drawable.qui_fans, z19));
        }
        radioButton.setTextColor(z16 ? g16 : g17);
        radioButton2.setTextColor(z17 ? g16 : g17);
        radioButton3.setTextColor(z18 ? g16 : g17);
        if (radioButton4 != null) {
            radioButton4.setTextColor(z19 ? g16 : g17);
        }
        view.setBackgroundColor(-1);
        if (L().Q()) {
            s5.a.h(view);
        }
    }
}
