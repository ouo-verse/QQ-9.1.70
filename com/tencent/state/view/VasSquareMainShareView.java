package com.tencent.state.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.state.square.IShareUtils;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.data.SquareMainPosterShareInfo;
import com.tencent.state.square.databinding.VasSquareMainSharePosterBinding;
import com.tencent.state.utils.RegexUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\fJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\"\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00112\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\f0\u0015J\u001a\u0010\u0017\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/state/view/VasSquareMainShareView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareMainSharePosterBinding;", "bindPosterView", "", "shareInfo", "Lcom/tencent/state/square/data/SquareMainPosterShareInfo;", "clearPosterTempFile", "convertToBitMap", "Landroid/graphics/Bitmap;", "getPosterTempFile", MimeHelper.IMAGE_SUBTYPE_BITMAP, "callback", "Lkotlin/Function1;", "Ljava/io/File;", "loadImageDrawable", "url", "", "view", "Landroid/widget/ImageView;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasSquareMainShareView extends FrameLayout {
    private static final String TAG = "VasSquareMainShareView";
    private final VasSquareMainSharePosterBinding binding;

    public VasSquareMainShareView(Context context) {
        this(context, null, 0, 6, null);
    }

    private final void loadImageDrawable(String url, ImageView view) {
        if (RegexUtils.isValidUrl$default(RegexUtils.INSTANCE, url, false, 2, null)) {
            URLDrawable.URLDrawableOptions urlDrawableOptions$default = SquareUtil.getUrlDrawableOptions$default(SquareUtil.INSTANCE, null, null, 3, null);
            final WeakReference weakReference = new WeakReference(view);
            URLDrawable drawable = URLDrawable.getDrawable(url, urlDrawableOptions$default);
            drawable.setURLDrawableListener(new URLDrawable.URLDrawableListener() { // from class: com.tencent.state.view.VasSquareMainShareView$loadImageDrawable$$inlined$apply$lambda$1
                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadFialed(URLDrawable p06, Throwable p16) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasSquareMainShareView", "onLoadFailed $", null, 4, null);
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadSuccessed(URLDrawable drawable2) {
                    ImageView imageView = (ImageView) weakReference.get();
                    if (imageView != null) {
                        imageView.setImageDrawable(drawable2);
                    }
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadCanceled(URLDrawable p06) {
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadProgressed(URLDrawable p06, int p16) {
                }
            });
            Intrinsics.checkNotNullExpressionValue(drawable, "drawable");
            if (drawable.getStatus() != 1) {
                drawable.startDownload();
            }
            view.setImageDrawable(drawable);
        }
    }

    public final void bindPosterView(SquareMainPosterShareInfo shareInfo) {
        Intrinsics.checkNotNullParameter(shareInfo, "shareInfo");
        TextView textView = this.binding.nick;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.nick");
        textView.setText(shareInfo.getNickName());
        String background = shareInfo.getBackground();
        SquareImageView squareImageView = this.binding.background;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.background");
        loadImageDrawable(background, squareImageView);
        Bitmap qrCode$default = IShareUtils.DefaultImpls.getQrCode$default(SquareBaseKt.getSquareShareUtil(), shareInfo.getQrCodeUrl(), ViewExtensionsKt.dip(getContext(), 59.2f), 0, 4, null);
        if (qrCode$default != null) {
            this.binding.qrCode.setImageBitmap(qrCode$default);
        }
    }

    public final void clearPosterTempFile() {
        SquareBaseKt.getSquareThread().postOnFileThread(new Function0<Unit>() { // from class: com.tencent.state.view.VasSquareMainShareView$clearPosterTempFile$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SquareBaseKt.getSquareLog().i("VasSquareMainShareView", "clear poster dir");
                File file = new File(SquareBase.INSTANCE.getConfig().getRootCacheDir(), QAdVrReport.ElementID.AD_POSTER);
                if (file.exists()) {
                    file.delete();
                }
            }
        });
    }

    public final Bitmap convertToBitMap() {
        View root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        int width = root.getWidth();
        View root2 = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
        Bitmap createBitmap = Bitmap.createBitmap(width, root2.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(-1);
        this.binding.getRoot().draw(canvas);
        return createBitmap;
    }

    public final void getPosterTempFile(final Bitmap bitmap, final Function1<? super File, Unit> callback) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(callback, "callback");
        File file = new File(SquareBase.INSTANCE.getConfig().getRootCacheDir(), QAdVrReport.ElementID.AD_POSTER);
        if (!file.exists()) {
            file.mkdir();
        }
        final File file2 = new File(file, System.currentTimeMillis() + ".jpg");
        SquareBaseKt.getSquareThread().postOnFileThread(new Function0<Unit>() { // from class: com.tencent.state.view.VasSquareMainShareView$getPosterTempFile$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    try {
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
                        fileOutputStream.flush();
                    } finally {
                        try {
                        } finally {
                        }
                    }
                } catch (Throwable th5) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasSquareMainShareView", String.valueOf(th5), null, 4, null);
                }
                SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.view.VasSquareMainShareView$getPosterTempFile$1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        VasSquareMainShareView$getPosterTempFile$1 vasSquareMainShareView$getPosterTempFile$1 = VasSquareMainShareView$getPosterTempFile$1.this;
                        callback.invoke(file2);
                    }
                });
            }
        });
    }

    public VasSquareMainShareView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ VasSquareMainShareView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasSquareMainShareView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        VasSquareMainSharePosterBinding inflate = VasSquareMainSharePosterBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareMainSharePoster\u2026ater.from(context), this)");
        this.binding = inflate;
    }
}
