package ch;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \t2\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b \u0010!J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J*\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006J\u0016\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0005J\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eR\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001b\u00a8\u0006\""}, d2 = {"Lch/l;", "", "", "lv10Path", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "numbers", "", "f", "i", "k", "e", "j", "Landroid/graphics/Canvas;", PM.CANVAS, "canvasHeight", "b", "g", "offsetY", "c", "d", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroid/graphics/drawable/Drawable;", "a", "Ljava/util/concurrent/CopyOnWriteArrayList;", "numbersDrawable", "Landroid/graphics/drawable/Drawable;", "numberPrefixDrawable", "numberBgDrawable", "starDrawable", "bottomBgDrawable", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private CopyOnWriteArrayList<Drawable> numbersDrawable = new CopyOnWriteArrayList<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Drawable numberPrefixDrawable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Drawable numberBgDrawable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Drawable starDrawable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Drawable bottomBgDrawable;

    private final void b(Canvas canvas, int canvasHeight) {
        int i3;
        int width = canvas.getWidth();
        Drawable drawable = this.bottomBgDrawable;
        int i16 = 0;
        if (drawable != null) {
            drawable.setBounds(0, canvasHeight - ((int) ((width / Math.min(drawable.getIntrinsicWidth(), width)) * drawable.getIntrinsicHeight())), width, canvasHeight);
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.numberBgDrawable;
        if (drawable2 != null) {
            int intrinsicWidth = drawable2.getIntrinsicWidth();
            int i17 = (width - 26) - intrinsicWidth;
            i3 = canvasHeight - drawable2.getIntrinsicHeight();
            drawable2.setBounds(i17, i3, intrinsicWidth + i17, canvasHeight);
            drawable2.draw(canvas);
            i16 = i17;
        } else {
            i3 = 0;
        }
        Drawable drawable3 = this.starDrawable;
        if (drawable3 != null) {
            drawable3.setBounds(i16 - drawable3.getIntrinsicWidth(), i3, i16, drawable3.getIntrinsicHeight() + i3);
            drawable3.draw(canvas);
        }
        int i18 = i3 + 4;
        Drawable drawable4 = this.numberPrefixDrawable;
        if (drawable4 != null) {
            int intrinsicWidth2 = drawable4.getIntrinsicWidth();
            int i19 = i16 + 16;
            drawable4.setBounds(i19, i18, i19 + intrinsicWidth2, drawable4.getIntrinsicHeight() + i18);
            drawable4.draw(canvas);
            i16 = i19 + (intrinsicWidth2 - 2);
        }
        CopyOnWriteArrayList<Drawable> copyOnWriteArrayList = this.numbersDrawable;
        if (copyOnWriteArrayList != null) {
            for (Drawable drawable5 : copyOnWriteArrayList) {
                int intrinsicWidth3 = drawable5.getIntrinsicWidth();
                drawable5.setBounds(i16, i18, i16 + intrinsicWidth3, drawable5.getIntrinsicHeight() + i18);
                drawable5.draw(canvas);
                i16 += intrinsicWidth3 - 2;
            }
        }
    }

    private final void e(String lv10Path) {
        if (this.bottomBgDrawable != null) {
            return;
        }
        File file = new File(lv10Path, "bottom_bg.png");
        if (file.exists()) {
            ApngOptions apngOptions = new ApngOptions();
            apngOptions.setAutoScale(false);
            IVasApngFactory iVasApngFactory = (IVasApngFactory) QRoute.api(IVasApngFactory.class);
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "apngFile.absolutePath");
            this.bottomBgDrawable = iVasApngFactory.getDynamicDrawable("", apngOptions, absolutePath);
        }
    }

    private final void f(String lv10Path, ArrayList<Integer> numbers) {
        this.numbersDrawable.clear();
        Iterator<T> it = numbers.iterator();
        while (it.hasNext()) {
            File file = new File(lv10Path, ((Number) it.next()).intValue() + ".png");
            if (file.exists()) {
                ApngOptions apngOptions = new ApngOptions();
                apngOptions.setAutoScale(false);
                CopyOnWriteArrayList<Drawable> copyOnWriteArrayList = this.numbersDrawable;
                IVasApngFactory iVasApngFactory = (IVasApngFactory) QRoute.api(IVasApngFactory.class);
                String absolutePath = file.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "numberPath.absolutePath");
                copyOnWriteArrayList.add(iVasApngFactory.getDynamicDrawable("", apngOptions, absolutePath));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(l this$0, String lv10Path, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(lv10Path, "$lv10Path");
        this$0.j(lv10Path);
        this$0.i(lv10Path);
        this$0.k(lv10Path);
        this$0.e(lv10Path);
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this$0.f(lv10Path, arrayList);
    }

    private final void i(String lv10Path) {
        if (this.numberBgDrawable != null) {
            return;
        }
        File file = new File(lv10Path, "num_bg.png");
        if (file.exists()) {
            ApngOptions apngOptions = new ApngOptions();
            apngOptions.setAutoScale(false);
            IVasApngFactory iVasApngFactory = (IVasApngFactory) QRoute.api(IVasApngFactory.class);
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "apngFile.absolutePath");
            this.numberBgDrawable = iVasApngFactory.getDynamicDrawable("", apngOptions, absolutePath);
        }
    }

    private final void j(String lv10Path) {
        if (this.numberPrefixDrawable != null) {
            return;
        }
        File file = new File(lv10Path, "prefix.png");
        if (file.exists()) {
            ApngOptions apngOptions = new ApngOptions();
            apngOptions.setAutoScale(false);
            IVasApngFactory iVasApngFactory = (IVasApngFactory) QRoute.api(IVasApngFactory.class);
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "apngFile.absolutePath");
            this.numberPrefixDrawable = iVasApngFactory.getDynamicDrawable("", apngOptions, absolutePath);
        }
    }

    private final void k(String lv10Path) {
        File file = new File(lv10Path, "stars.png");
        if (file.exists()) {
            ApngOptions apngOptions = new ApngOptions();
            apngOptions.setAutoScale(false);
            IVasApngFactory iVasApngFactory = (IVasApngFactory) QRoute.api(IVasApngFactory.class);
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "apngFile.absolutePath");
            this.starDrawable = iVasApngFactory.getDynamicDrawable("", apngOptions, absolutePath);
        }
    }

    public final void c(Canvas canvas, int offsetY) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        b(canvas, offsetY);
    }

    public final void d(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        b(canvas, canvas.getHeight());
    }

    public final void g(final String lv10Path, final ArrayList<Integer> numbers) {
        Intrinsics.checkNotNullParameter(lv10Path, "lv10Path");
        if (lv10Path.length() == 0) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: ch.k
            @Override // java.lang.Runnable
            public final void run() {
                l.h(l.this, lv10Path, numbers);
            }
        }, 16, null, false);
    }
}
