package com.tenpay.payment.paymentout;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tenpay.payment.QWalletPaymentExtKt;
import com.tenpay.sdk.view.MyTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0002#$B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0018\u001a\u00020\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\nH\u0002J\u000e\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\nJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u0019J\u0006\u0010!\u001a\u00020\u0019J\u0006\u0010\"\u001a\u00020\u0019R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/tenpay/payment/paymentout/PaymentOutFullScreenController;", "", "fragment", "Lcom/tenpay/payment/paymentout/PaymentOutFragment;", "callback", "Lcom/tenpay/payment/paymentout/PaymentOutFullScreenController$IFullScreenChangeCallback;", "(Lcom/tenpay/payment/paymentout/PaymentOutFragment;Lcom/tenpay/payment/paymentout/PaymentOutFullScreenController$IFullScreenChangeCallback;)V", "barCodeImgView", "Landroid/widget/ImageView;", "barCodeLayout", "Landroid/view/View;", "barCodeNum1", "Lcom/tenpay/sdk/view/MyTextView;", "barCodeNum2", "barCodeNum3", "barCodeNum4", "barCodeNum5", "barCodeNumContainer", "currentFullScreenState", "", "fullScreenBarCodeImgView", "fullScreenCodeContainer", "fullScreenQrCodeImgView", "qrCodeImgView", "exitFullScreen", "", "getMagicDrawingCache", "Landroid/graphics/Bitmap;", "view", "initView", "isFullScreenState", "", "showBarCodeFullScreen", "showQrCodeFullScreen", "updateFullScreen", "Companion", "IFullScreenChangeCallback", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PaymentOutFullScreenController {
    private static final int STATE_BAR_CODE_FULL_SCREEN = 2;
    private static final int STATE_NOT_FULL_SCREEN = 0;
    private static final int STATE_QR_CODE_FULL_SCREEN = 1;
    private ImageView barCodeImgView;
    private View barCodeLayout;
    private MyTextView barCodeNum1;
    private MyTextView barCodeNum2;
    private MyTextView barCodeNum3;
    private MyTextView barCodeNum4;
    private MyTextView barCodeNum5;
    private View barCodeNumContainer;

    @NotNull
    private final IFullScreenChangeCallback callback;
    private int currentFullScreenState;

    @NotNull
    private final PaymentOutFragment fragment;
    private ImageView fullScreenBarCodeImgView;
    private View fullScreenCodeContainer;
    private ImageView fullScreenQrCodeImgView;
    private ImageView qrCodeImgView;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tenpay/payment/paymentout/PaymentOutFullScreenController$IFullScreenChangeCallback;", "", "onFullScreenCodeChange", "", OpenHippyInfo.EXTRA_KEY_IS_FULL_SCREEN, "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public interface IFullScreenChangeCallback {
        void onFullScreenCodeChange(boolean isFullScreen);
    }

    public PaymentOutFullScreenController(@NotNull PaymentOutFragment fragment, @NotNull IFullScreenChangeCallback callback) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.fragment = fragment;
        this.callback = callback;
    }

    private final Bitmap getMagicDrawingCache(View view) {
        if (view.getWidth() + view.getHeight() == 0) {
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        }
        int width = view.getWidth();
        int height = view.getHeight();
        if (width != 0 && height != 0) {
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
            createBitmap.eraseColor(-1);
            view.draw(new Canvas(createBitmap));
            return createBitmap;
        }
        QLog.w(QWalletPaymentExtKt.getPaymentTag(this), 1, "getMagicDrawingCache fail: viewWidth=" + width + " viewHeight=" + height);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1$lambda$0(PaymentOutFullScreenController this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.exitFullScreen();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showBarCodeFullScreen$lambda$4(PaymentOutFullScreenController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.barCodeLayout;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barCodeLayout");
            view = null;
        }
        Bitmap magicDrawingCache = this$0.getMagicDrawingCache(view);
        if (magicDrawingCache != null) {
            Matrix matrix = new Matrix();
            matrix.setRotate(90.0f);
            Bitmap createBitmap = Bitmap.createBitmap(magicDrawingCache, 0, 0, magicDrawingCache.getWidth(), magicDrawingCache.getHeight(), matrix, true);
            ImageView imageView = this$0.fullScreenBarCodeImgView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fullScreenBarCodeImgView");
                imageView = null;
            }
            imageView.setBackground(new BitmapDrawable(this$0.fragment.getResources(), createBitmap));
        }
        View view3 = this$0.barCodeNumContainer;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barCodeNumContainer");
        } else {
            view2 = view3;
        }
        view2.setVisibility(4);
        this$0.callback.onFullScreenCodeChange(true);
        com.tencent.mobileqq.qwallet.c.f("paycode.showpaycode.barcode", null, null, null, null, 30, null);
    }

    public final void exitFullScreen() {
        this.currentFullScreenState = 0;
        View view = this.fullScreenCodeContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fullScreenCodeContainer");
            view = null;
        }
        view.setVisibility(8);
        this.callback.onFullScreenCodeChange(false);
    }

    public final void initView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.f232505x);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.p\u2026t_out_bar_code_container)");
        this.barCodeLayout = findViewById;
        View findViewById2 = view.findViewById(R.id.f232605y);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.payment_out_bar_code_img)");
        this.barCodeImgView = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(R.id.f2332064);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.p\u2026_out_bar_code_num_layout)");
        this.barCodeNumContainer = findViewById3;
        View findViewById4 = view.findViewById(R.id.f232705z);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.payment_out_bar_code_num_1)");
        this.barCodeNum1 = (MyTextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.f2328060);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.payment_out_bar_code_num_2)");
        this.barCodeNum2 = (MyTextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.f2329061);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.payment_out_bar_code_num_3)");
        this.barCodeNum3 = (MyTextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.f2330062);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.payment_out_bar_code_num_4)");
        this.barCodeNum4 = (MyTextView) findViewById7;
        View findViewById8 = view.findViewById(R.id.f2331063);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.payment_out_bar_code_num_5)");
        this.barCodeNum5 = (MyTextView) findViewById8;
        View findViewById9 = view.findViewById(R.id.jkv);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById(R.id.tiao_img1)");
        this.fullScreenBarCodeImgView = (ImageView) findViewById9;
        View findViewById10 = view.findViewById(R.id.f2337069);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "view.findViewById(R.id.payment_out_qr_code_img)");
        this.qrCodeImgView = (ImageView) findViewById10;
        View findViewById11 = view.findViewById(R.id.h0k);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "view.findViewById(R.id.qr_img1)");
        this.fullScreenQrCodeImgView = (ImageView) findViewById11;
        View findViewById12 = view.findViewById(R.id.h18);
        findViewById12.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.payment.paymentout.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PaymentOutFullScreenController.initView$lambda$1$lambda$0(PaymentOutFullScreenController.this, view2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById12, "view.findViewById<View?>\u2026)\n            }\n        }");
        this.fullScreenCodeContainer = findViewById12;
    }

    public final boolean isFullScreenState() {
        if (this.currentFullScreenState != 0) {
            return true;
        }
        return false;
    }

    public final void showBarCodeFullScreen() {
        this.currentFullScreenState = 2;
        View view = this.fullScreenCodeContainer;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fullScreenCodeContainer");
            view = null;
        }
        if (view.getVisibility() != 0) {
            View view3 = this.fullScreenCodeContainer;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fullScreenCodeContainer");
                view3 = null;
            }
            view3.setVisibility(0);
            ImageView imageView = this.fullScreenQrCodeImgView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fullScreenQrCodeImgView");
                imageView = null;
            }
            imageView.setVisibility(8);
            ImageView imageView2 = this.fullScreenBarCodeImgView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fullScreenBarCodeImgView");
                imageView2 = null;
            }
            imageView2.setVisibility(0);
        }
        View view4 = this.barCodeNumContainer;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barCodeNumContainer");
            view4 = null;
        }
        view4.setVisibility(0);
        View view5 = this.barCodeNumContainer;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barCodeNumContainer");
        } else {
            view2 = view5;
        }
        view2.post(new Runnable() { // from class: com.tenpay.payment.paymentout.d
            @Override // java.lang.Runnable
            public final void run() {
                PaymentOutFullScreenController.showBarCodeFullScreen$lambda$4(PaymentOutFullScreenController.this);
            }
        });
    }

    public final void showQrCodeFullScreen() {
        BitmapDrawable bitmapDrawable;
        Bitmap bitmap;
        this.currentFullScreenState = 1;
        View view = this.fullScreenCodeContainer;
        ImageView imageView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fullScreenCodeContainer");
            view = null;
        }
        if (view.getVisibility() != 0) {
            View view2 = this.fullScreenCodeContainer;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fullScreenCodeContainer");
                view2 = null;
            }
            view2.setVisibility(0);
            ImageView imageView2 = this.fullScreenQrCodeImgView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fullScreenQrCodeImgView");
                imageView2 = null;
            }
            imageView2.setVisibility(0);
            ImageView imageView3 = this.fullScreenBarCodeImgView;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fullScreenBarCodeImgView");
                imageView3 = null;
            }
            imageView3.setVisibility(8);
        }
        ImageView imageView4 = this.qrCodeImgView;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qrCodeImgView");
            imageView4 = null;
        }
        Drawable background = imageView4.getBackground();
        if (background instanceof BitmapDrawable) {
            bitmapDrawable = (BitmapDrawable) background;
        } else {
            bitmapDrawable = null;
        }
        if (bitmapDrawable != null) {
            bitmap = bitmapDrawable.getBitmap();
        } else {
            bitmap = null;
        }
        if (bitmap == null) {
            return;
        }
        BitmapDrawable bitmapDrawable2 = new BitmapDrawable(bitmap.copy(bitmap.getConfig(), true));
        ImageView imageView5 = this.fullScreenQrCodeImgView;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fullScreenQrCodeImgView");
        } else {
            imageView = imageView5;
        }
        imageView.setBackground(bitmapDrawable2);
        this.callback.onFullScreenCodeChange(true);
        com.tencent.mobileqq.qwallet.c.f("paycode.showpaycode.Qrcode", null, null, null, null, 30, null);
    }

    public final void updateFullScreen() {
        int i3 = this.currentFullScreenState;
        if (i3 != 1) {
            if (i3 == 2) {
                showBarCodeFullScreen();
                return;
            }
            return;
        }
        showQrCodeFullScreen();
    }
}
