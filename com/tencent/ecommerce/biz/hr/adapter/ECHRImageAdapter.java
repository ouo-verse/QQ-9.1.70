package com.tencent.ecommerce.biz.hr.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.widget.ImageView;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.imageloader.api.IECImageLoader;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.biz.hr.api.IKuiklyImageFetcher;
import com.tencent.ecommerce.biz.res.api.IECResourceApi;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import d01.HRImageLoadOption;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJc\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022Q\u0010\u000f\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0004j\u0002`\u000eH\u0002Jm\u0010\u0013\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0003\u001a\u00020\u00022Q\u0010\u000f\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0004j\u0002`\u000eH\u0002Jc\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022Q\u0010\u000f\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0004j\u0002`\u000eH\u0002Jc\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022Q\u0010\u000f\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0004j\u0002`\u000eH\u0002J\f\u0010\u0017\u001a\u00020\u0016*\u00020\u0002H\u0002Ji\u0010\u0018\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0003\u001a\u00020\u00022M\u0010\u000f\u001aI\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0004H\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/adapter/ECHRImageAdapter;", "Ld01/h;", "Ld01/a;", "imageLoadOption", "Lkotlin/Function3;", "Landroid/graphics/drawable/Drawable;", "Lkotlin/ParameterName;", "name", "drawable", "", "errorCode", "", "errorMsg", "", "Lcom/tencent/kuikly/core/render/android/expand/component/image/FetchImageCallback;", "callback", "c", "Landroid/content/Context;", "context", "e", "b", "d", "Lcom/tencent/ecommerce/base/imageloader/api/IECImageLoader$b;", "f", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECHRImageAdapter implements d01.h {

    /* renamed from: a, reason: collision with root package name */
    public static final ECHRImageAdapter f102519a = new ECHRImageAdapter();

    ECHRImageAdapter() {
    }

    private final void b(HRImageLoadOption imageLoadOption, Function3<? super Drawable, ? super Integer, ? super String, Unit> callback) {
        List split$default;
        String src = imageLoadOption.getSrc();
        split$default = StringsKt__StringsKt.split$default((CharSequence) src, new String[]{QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER}, false, 0, 6, (Object) null);
        if (!split$default.isEmpty()) {
            src = (String) split$default.get(0);
        }
        ECSkin.INSTANCE.getDrawableWithFetchCallback(src, f(imageLoadOption), new a(imageLoadOption, callback));
    }

    private final void c(HRImageLoadOption imageLoadOption, Function3<? super Drawable, ? super Integer, ? super String, Unit> callback) {
        IECImageLoader.ImageLoaderOption f16 = f(imageLoadOption);
        IECResourceApi resourceApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getResourceApi();
        if (resourceApi != null) {
            resourceApi.fetchDrawable(wg0.a.a(), imageLoadOption.getSrc(), f16, new a(imageLoadOption, callback));
        }
    }

    private final void d(final HRImageLoadOption imageLoadOption, final Function3<? super Drawable, ? super Integer, ? super String, Unit> callback) {
        ECThreadUtilKt.a(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.hr.adapter.ECHRImageAdapter$loadFromBase64$1
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
                List split$default;
                BitmapFactory.Options options = new BitmapFactory.Options();
                split$default = StringsKt__StringsKt.split$default((CharSequence) HRImageLoadOption.this.getSrc(), new String[]{","}, false, 0, 6, (Object) null);
                byte[] decode = Base64.decode((String) split$default.get(1), 0);
                options.inJustDecodeBounds = false;
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                try {
                    callback.invoke(new BitmapDrawable(BitmapFactory.decodeByteArray(decode, 0, decode.length, options)), 0, "");
                } catch (OutOfMemoryError e16) {
                    cg0.a.b("ECHRImageAdapter", "in else oom happen: " + e16);
                    callback.invoke(null, -20002, "load base 64 error, oom");
                }
            }
        });
    }

    private final void e(Context context, HRImageLoadOption imageLoadOption, Function3<? super Drawable, ? super Integer, ? super String, Unit> callback) {
        String src;
        IECImageLoader.ImageLoaderOption f16 = f(imageLoadOption);
        if (imageLoadOption.h()) {
            src = StringsKt__StringsJVMKt.replace$default(imageLoadOption.getSrc(), "file://", "", false, 4, (Object) null);
        } else {
            src = imageLoadOption.getSrc();
        }
        IKuiklyImageFetcher kuiklyImageFetcher = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getKuiklyImageFetcher();
        if (kuiklyImageFetcher != null) {
            if (context == null) {
                context = wg0.a.a();
            }
            kuiklyImageFetcher.fetchDrawable(context, src, f16, new a(imageLoadOption, callback));
        }
    }

    private final IECImageLoader.ImageLoaderOption f(HRImageLoadOption hRImageLoadOption) {
        ImageView.ScaleType scaleType;
        int requestWidth = hRImageLoadOption.getRequestWidth();
        int requestHeight = hRImageLoadOption.getRequestHeight();
        boolean needResize = hRImageLoadOption.getNeedResize();
        int i3 = d.f102525a[hRImageLoadOption.getScaleType().ordinal()];
        if (i3 == 1) {
            scaleType = ImageView.ScaleType.CENTER_INSIDE;
        } else if (i3 != 2) {
            scaleType = ImageView.ScaleType.CENTER_CROP;
        } else {
            scaleType = ImageView.ScaleType.MATRIX;
        }
        return new IECImageLoader.ImageLoaderOption(requestWidth, requestHeight, 0, scaleType, null, null, needResize, true, hRImageLoadOption.a(), 52, null);
    }

    @Override // d01.h
    public void a(Context context, HRImageLoadOption imageLoadOption, Function3<? super Drawable, ? super Integer, ? super String, Unit> callback) {
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean startsWith$default3;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(imageLoadOption.getSrc(), "qui_image://", false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(imageLoadOption.getSrc(), "data:image/", false, 2, null);
            if (!startsWith$default2) {
                startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(imageLoadOption.getSrc(), "qecommerce", false, 2, null);
                if (startsWith$default3) {
                    b(imageLoadOption, callback);
                    return;
                } else {
                    e(context, imageLoadOption, callback);
                    return;
                }
            }
            d(imageLoadOption, callback);
            return;
        }
        c(imageLoadOption, callback);
    }
}
