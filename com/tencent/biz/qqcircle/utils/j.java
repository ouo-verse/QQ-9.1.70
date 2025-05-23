package com.tencent.biz.qqcircle.utils;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.utils.j;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;

/* compiled from: P */
/* loaded from: classes5.dex */
public class j {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a extends QCirclePicStateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f92772d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ImageView f92773e;

        a(b bVar, ImageView imageView) {
            this.f92772d = bVar;
            this.f92773e = imageView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(ImageView imageView, BitmapDrawable bitmapDrawable) {
            if (imageView != null) {
                imageView.setImageDrawable(bitmapDrawable);
            }
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            if (QLog.isColorLevel()) {
                QLog.d("ImageUtil", 1, "[loadImageView] loadImage state: ", loadState);
            }
            b bVar = this.f92772d;
            if (bVar != null) {
                bVar.a(loadState);
            }
            if (loadState != LoadState.STATE_SUCCESS) {
                QLog.e("ImageUtil", 1, "[loadImageView] loadImage failed.");
                return;
            }
            final BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f92773e.getResources(), option.getResultBitMap());
            Handler uIHandler = RFWThreadManager.getUIHandler();
            final ImageView imageView = this.f92773e;
            uIHandler.post(new Runnable() { // from class: com.tencent.biz.qqcircle.utils.i
                @Override // java.lang.Runnable
                public final void run() {
                    j.a.b(imageView, bitmapDrawable);
                }
            });
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface b {
        void a(LoadState loadState);
    }

    public static void a(ImageView imageView, String str, float f16, float f17) {
        d(imageView, str, f16, f17, null, null);
    }

    public static void b(ImageView imageView, String str, float f16, float f17, Drawable drawable) {
        d(imageView, str, f16, f17, null, drawable);
    }

    public static void c(ImageView imageView, String str, float f16, float f17, b bVar) {
        d(imageView, str, f16, f17, bVar, null);
    }

    public static void d(ImageView imageView, String str, float f16, float f17, b bVar, Drawable drawable) {
        Option obtain = Option.obtain();
        obtain.setUrl(str).setTargetView(imageView).setPredecode(true).setRequestWidth(ViewUtils.dip2px(f16)).setRequestHeight(ViewUtils.dip2px(f17));
        QCircleFeedPicLoader.g().loadImage(obtain, new a(bVar, imageView));
    }
}
