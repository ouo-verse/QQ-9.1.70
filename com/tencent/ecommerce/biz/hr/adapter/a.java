package com.tencent.ecommerce.biz.hr.adapter;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import d01.HRImageLoadOption;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002M\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0001j\u0002`\u000bBb\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012Q\u0010\u0014\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0001j\u0002`\u000b\u00a2\u0006\u0004\b\u0015\u0010\u0016J#\u0010\r\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0096\u0002R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R_\u0010\u0014\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0001j\u0002`\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/adapter/a;", "Lkotlin/Function3;", "Landroid/graphics/drawable/Drawable;", "Lkotlin/ParameterName;", "name", "drawable", "", "errorCode", "", "errorMsg", "", "Lcom/tencent/kuikly/core/render/android/expand/component/image/FetchImageCallback;", "it", "b", "Ld01/a;", "d", "Ld01/a;", "imageLoadOption", "e", "Lkotlin/jvm/functions/Function3;", "callback", "<init>", "(Ld01/a;Lkotlin/jvm/functions/Function3;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
final class a implements Function3<Drawable, Integer, String, Unit> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final HRImageLoadOption imageLoadOption;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Function3<Drawable, Integer, String, Unit> callback;

    /* JADX WARN: Multi-variable type inference failed */
    public a(HRImageLoadOption hRImageLoadOption, Function3<? super Drawable, ? super Integer, ? super String, Unit> function3) {
        this.imageLoadOption = hRImageLoadOption;
        this.callback = function3;
    }

    public void b(Drawable it, int errorCode, String errorMsg) {
        BitmapDrawable b16;
        if (!this.imageLoadOption.getNeedResize() && (it instanceof URLDrawable)) {
            URLDrawable uRLDrawable = (URLDrawable) it;
            if (uRLDrawable.getStatus() == 1) {
                Function3<Drawable, Integer, String, Unit> function3 = this.callback;
                b16 = e.b(uRLDrawable);
                if (b16 != null) {
                    it = b16;
                }
                function3.invoke(it, 0, "");
                return;
            }
            uRLDrawable.setURLDrawableListener(new C1055a());
            uRLDrawable.startDownload();
            return;
        }
        this.callback.invoke(it, Integer.valueOf(errorCode), errorMsg);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable, Integer num, String str) {
        b(drawable, num.intValue(), str);
        return Unit.INSTANCE;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/ecommerce/biz/hr/adapter/a$a", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "", "onLoadSuccessed", "", "t", "onLoadFialed", "onLoadCanceled", "", "p1", "onLoadProgressed", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.hr.adapter.a$a, reason: collision with other inner class name */
    /* loaded from: classes31.dex */
    public static final class C1055a implements URLDrawable.URLDrawableListener {
        C1055a() {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable urlDrawable, Throwable t16) {
            cg0.a.a("ECHRImageAdapter", "hrRequestImage", "download image fail: " + t16);
            a.this.callback.invoke(null, -20001, String.valueOf(t16 != null ? t16.getMessage() : null));
        }

        /* JADX WARN: Code restructure failed: missing block: B:3:0x0008, code lost:
        
            r1 = com.tencent.ecommerce.biz.hr.adapter.e.b(r4);
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v2, types: [android.graphics.drawable.BitmapDrawable] */
        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onLoadSuccessed(URLDrawable urlDrawable) {
            ?? b16;
            Function3 function3 = a.this.callback;
            if (urlDrawable != null && b16 != 0) {
                urlDrawable = b16;
            }
            function3.invoke(urlDrawable, 0, "");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable urlDrawable) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable urlDrawable, int p16) {
        }
    }
}
