package com.tencent.state.square.chatland.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.Size;
import android.view.View;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.state.service.ImageService;
import java.lang.ref.WeakReference;
import java.util.Timer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ$\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u000eH\u0002J0\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/state/square/chatland/view/ImageTipsManager;", "", ParseCommon.CONTAINER, "Ljava/lang/ref/WeakReference;", "Lcom/tencent/state/square/chatland/view/IViewContainer;", "(Ljava/lang/ref/WeakReference;)V", SemanticAttributes.FaasTriggerValues.TIMER, "Ljava/util/Timer;", "destroy", "", "loadImage", "url", "", "done", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "show", "context", "Landroid/content/Context;", "location", "Landroid/graphics/Point;", "size", "Landroid/util/Size;", "duration", "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ImageTipsManager {
    private static final long DEFAULT_DURATION = 500;
    private static final long DEFAULT_FADEOUT_DURATION = 300;
    private static final String TAG = "ImageTipsManager";
    private final WeakReference<IViewContainer> container;
    private Timer timer;

    public ImageTipsManager(WeakReference<IViewContainer> container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.container = container;
        this.timer = new Timer();
    }

    private final void loadImage(String url, final Function1<? super Bitmap, Unit> done) {
        ImageLoader loader = ImageService.INSTANCE.getLoader();
        if (loader != null) {
            loader.loadImage(url, new SimpleImageLoadingListener() { // from class: com.tencent.state.square.chatland.view.ImageTipsManager$loadImage$1
                @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                    if (loadedImage != null) {
                        Function1.this.invoke(loadedImage);
                    }
                }
            });
        }
    }

    public final void destroy() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
        }
        this.timer = null;
    }

    public final void show(Context context, String url, Point location, Size size, long duration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(size, "size");
        loadImage(url, new ImageTipsManager$show$1(this, context, size, location, duration));
    }

    public static /* synthetic */ void show$default(ImageTipsManager imageTipsManager, Context context, String str, Point point, Size size, long j3, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            j3 = 500;
        }
        imageTipsManager.show(context, str, point, size, j3);
    }
}
