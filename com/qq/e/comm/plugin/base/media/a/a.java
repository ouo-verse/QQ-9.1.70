package com.qq.e.comm.plugin.base.media.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Movie;
import android.os.Handler;
import android.os.Looper;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.util.GDTLogger;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, WeakReference<Bitmap>> f39164a = new LinkedHashMap();

    /* compiled from: P */
    /* renamed from: com.qq.e.comm.plugin.base.media.a.a$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    static class AnonymousClass1 implements d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f39165a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f39166b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ImageView f39167c;

        AnonymousClass1(long j3, ViewGroup viewGroup, ImageView imageView) {
            this.f39165a = j3;
            this.f39166b = viewGroup;
            this.f39167c = imageView;
        }

        @Override // com.qq.e.comm.plugin.base.media.a.d
        public void a(String str, View view, int i3) {
        }

        @Override // com.qq.e.comm.plugin.base.media.a.d
        public void a(String str, boolean z16) {
        }

        @Override // com.qq.e.comm.plugin.base.media.a.d
        public void a(final String str, View view, final Bitmap bitmap, Movie movie) {
            GDTLogger.d("BG Blur download image cost : " + (System.currentTimeMillis() - this.f39165a));
            GdtSDKThreadManager.getInstance().runOnThread(3, new Runnable() { // from class: com.qq.e.comm.plugin.base.media.a.a.1.1
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap2 = bitmap;
                    if (bitmap2 == null) {
                        return;
                    }
                    Bitmap copy = bitmap2.copy(Bitmap.Config.ARGB_8888, true);
                    Matrix matrix = new Matrix();
                    matrix.preScale(0.25f, 0.25f);
                    final Bitmap b16 = a.b(Bitmap.createBitmap(copy, 0, 0, copy.getWidth(), copy.getHeight(), matrix, false), AnonymousClass1.this.f39166b.getContext());
                    a.f39164a.put(str, new WeakReference(b16));
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.comm.plugin.base.media.a.a.1.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            a.b(anonymousClass1.f39167c, b16, anonymousClass1.f39166b, anonymousClass1.f39165a);
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(ImageView imageView, Bitmap bitmap, ViewGroup viewGroup, long j3) {
        if (bitmap == null || bitmap.isRecycled() || viewGroup == null) {
            return;
        }
        imageView.setImageBitmap(bitmap);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        viewGroup.addView(imageView, 0);
        long currentTimeMillis = System.currentTimeMillis() - j3;
        GDTLogger.d("BG Blur cost : " + currentTimeMillis);
        StatTracer.trackEvent(100282, ((int) currentTimeMillis) / 50, (com.qq.e.comm.plugin.stat.b) null);
    }

    public static void a(ViewGroup viewGroup, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (b()) {
            GDTLogger.d("BG Blur disable");
            return;
        }
        if (viewGroup != null && !TextUtils.isEmpty(str)) {
            View findViewWithTag = viewGroup.findViewWithTag("blurImage");
            View findViewWithTag2 = viewGroup.findViewWithTag("blurBG");
            if (findViewWithTag != null && findViewWithTag2 != null) {
                findViewWithTag.setVisibility(0);
                findViewWithTag2.setVisibility(0);
                GDTLogger.d("already do blur, just show.");
                return;
            }
            ImageView imageView = new ImageView(viewGroup.getContext());
            imageView.setTag("blurImage");
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            imageView.setLayoutParams(layoutParams);
            ImageView imageView2 = new ImageView(viewGroup.getContext());
            imageView2.setTag("blurBG");
            imageView2.setLayoutParams(layoutParams);
            imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView2.setBackgroundColor(Color.parseColor("#88444444"));
            viewGroup.addView(imageView2, 0);
            WeakReference<Bitmap> weakReference = f39164a.get(str);
            if (weakReference != null && weakReference.get() != null) {
                GDTLogger.d("BG Blur hit cache");
                b(imageView, weakReference.get(), viewGroup, currentTimeMillis);
                return;
            } else {
                c.a().a(str, imageView, new AnonymousClass1(currentTimeMillis, viewGroup, imageView));
                return;
            }
        }
        GDTLogger.d("viewGroup or bgResUrl null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bitmap b(Bitmap bitmap, Context context) {
        RenderScript create;
        try {
            create = RenderScript.create(context);
        } catch (Exception e16) {
            GDTLogger.e("blur exception happened : " + e16.getMessage());
            e16.printStackTrace();
        }
        if (create == null) {
            return bitmap;
        }
        create.setMessageHandler(new RenderScript.RSMessageHandler());
        Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap);
        ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, createFromBitmap.getElement());
        create2.setInput(createFromBitmap);
        create2.setRadius(5.0f);
        create2.forEach(createFromBitmap);
        createFromBitmap.copyTo(bitmap);
        create.destroy();
        return bitmap;
    }

    private static boolean b() {
        return GDTADManager.getInstance().getSM().getInteger("videoBGBlur", 1) == 0;
    }
}
