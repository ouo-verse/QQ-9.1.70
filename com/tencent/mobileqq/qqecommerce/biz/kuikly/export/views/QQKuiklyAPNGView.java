package com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import d01.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0001EB\u000f\u0012\u0006\u0010A\u001a\u00020@\u00a2\u0006\u0004\bB\u0010CJ\u0016\u0010\u0006\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J$\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000bH\u0002J\u001c\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J0\u0010!\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000bH\u0014R\u0018\u0010$\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010#R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00150%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010&R\u0016\u0010*\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)RH\u00102\u001a4\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R \u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010&R\u0016\u00107\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u0004\u0018\u00010<8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b=\u0010>\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/views/QQKuiklyAPNGView;", "Landroid/widget/ImageView;", "Ld01/b;", "Lkotlin/Function0;", "", "block", "j", "l", "p", "", "filePath", "", "targetWidth", "targetHeight", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "setFilePath", "count", "setRepeatCount", "b", "stopAnimation", "Ld01/c;", "listener", "e", "c", "Landroid/view/View;", "d", "", "changed", "left", "top", "right", "bottom", "onLayout", "Lcom/tencent/image/URLDrawable;", "Lcom/tencent/image/URLDrawable;", "apngDrawable", "", "Ljava/util/List;", "listeners", "f", "I", "repeatCount", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "width", "height", tl.h.F, "Lkotlin/jvm/functions/Function2;", "loadDrawableLazyTask", "i", "readyCallbacks", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "firstLoaded", "Lcom/tencent/image/ApngDrawable$OnPlayRepeatListener;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/image/ApngDrawable$OnPlayRepeatListener;", "apnListener", "Lcom/tencent/image/ApngImage;", "k", "()Lcom/tencent/image/ApngImage;", "apnImage", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "D", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQKuiklyAPNGView extends ImageView implements d01.b {

    /* renamed from: C, reason: from kotlin metadata */
    private ApngDrawable.OnPlayRepeatListener apnListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private URLDrawable apngDrawable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private List<d01.c> listeners;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int repeatCount;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Function2<? super Integer, ? super Integer, Unit> loadDrawableLazyTask;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final List<Function0<Unit>> readyCallbacks;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean firstLoaded;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\nH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/kuikly/export/views/QQKuiklyAPNGView$b", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "p0", "", "onLoadSuccessed", "", "p1", "onLoadFialed", "onLoadCanceled", "", "onLoadProgressed", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WeakReference<QQKuiklyAPNGView> f263118d;

        b(WeakReference<QQKuiklyAPNGView> weakReference) {
            this.f263118d = weakReference;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable p06, Throwable p16) {
            QLog.e("QQKuiklyAPNGView", 1, "loadApng failed: " + p16);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable p06) {
            QQKuiklyAPNGView qQKuiklyAPNGView = this.f263118d.get();
            if (qQKuiklyAPNGView != null) {
                qQKuiklyAPNGView.l();
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable p06) {
            QLog.i("QQKuiklyAPNGView", 1, "loadApng canceled");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable p06, int p16) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQKuiklyAPNGView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.listeners = new ArrayList();
        this.repeatCount = 1;
        this.readyCallbacks = new ArrayList();
    }

    private final void j(Function0<Unit> block) {
        synchronized (this.readyCallbacks) {
            if (this.firstLoaded) {
                block.invoke();
            } else {
                this.readyCallbacks.add(block);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApngImage k() {
        URLDrawable uRLDrawable = this.apngDrawable;
        Drawable currDrawable = uRLDrawable != null ? uRLDrawable.getCurrDrawable() : null;
        ApngDrawable apngDrawable = currDrawable instanceof ApngDrawable ? (ApngDrawable) currDrawable : null;
        if (apngDrawable != null) {
            return apngDrawable.getImage();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        final WeakReference weakReference = new WeakReference(this);
        this.apnListener = new ApngDrawable.OnPlayRepeatListener() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.d
            @Override // com.tencent.image.ApngDrawable.OnPlayRepeatListener
            public final void onPlayRepeat(int i3) {
                QQKuiklyAPNGView.m(WeakReference.this, i3);
            }
        };
        ApngImage k3 = k();
        if (k3 != null) {
            k3.setOnPlayRepeatListener(this.apnListener);
        }
        setImageDrawable(this.apngDrawable);
        ApngImage k16 = k();
        if (k16 != null) {
            k16.setSupportGlobalPasued(false);
        }
        ApngImage k17 = k();
        if (k17 != null) {
            k17.pause();
        }
        synchronized (this.readyCallbacks) {
            if (!this.firstLoaded) {
                Iterator<T> it = this.readyCallbacks.iterator();
                while (it.hasNext()) {
                    ((Function0) it.next()).invoke();
                }
                this.readyCallbacks.clear();
                this.firstLoaded = true;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void m(WeakReference selfRef, int i3) {
        Intrinsics.checkNotNullParameter(selfRef, "$selfRef");
        QQKuiklyAPNGView qQKuiklyAPNGView = (QQKuiklyAPNGView) selfRef.get();
        if (qQKuiklyAPNGView == null || i3 != qQKuiklyAPNGView.repeatCount) {
            return;
        }
        qQKuiklyAPNGView.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(final String filePath, int targetWidth, int targetHeight) {
        WeakReference weakReference = new WeakReference(this);
        if (targetWidth > 0 && targetHeight > 0) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mUseApngImage = true;
            obtain.mRequestWidth = targetWidth;
            obtain.mRequestHeight = targetHeight;
            obtain.mUseMemoryCache = false;
            obtain.mLoadingDrawable = new ColorDrawable(0);
            Bundle bundle = new Bundle();
            bundle.putInt("key_loop", this.repeatCount);
            bundle.putBoolean("key_double_bitmap", true);
            bundle.putString("key_name", filePath);
            obtain.mExtraInfo = bundle;
            URLDrawable fileDrawable = URLDrawable.getFileDrawable(filePath, obtain);
            fileDrawable.setURLDrawableListener(new b(weakReference));
            this.apngDrawable = fileDrawable;
            fileDrawable.startDownload();
            return;
        }
        this.loadDrawableLazyTask = new Function2<Integer, Integer, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.QQKuiklyAPNGView$loadDrawable$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
                invoke(num.intValue(), num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, int i16) {
                QQKuiklyAPNGView.this.n(filePath, i3, i16);
            }
        };
    }

    private final void p() {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((d01.c) it.next()).onAnimationEnd(this);
        }
    }

    private final void q(int targetWidth, int targetHeight) {
        Function2<? super Integer, ? super Integer, Unit> function2 = this.loadDrawableLazyTask;
        if (function2 != null && targetWidth > 0 && targetHeight > 0) {
            if (function2 != null) {
                function2.invoke(Integer.valueOf(targetWidth), Integer.valueOf(targetHeight));
            }
            this.loadDrawableLazyTask = null;
        }
    }

    @Override // d01.b
    public boolean a(String str, Object obj) {
        return b.a.a(this, str, obj);
    }

    @Override // d01.b
    public void b() {
        final WeakReference weakReference = new WeakReference(this);
        j(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.QQKuiklyAPNGView$playAnimation$1
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

            /* JADX WARN: Code restructure failed: missing block: B:3:0x000a, code lost:
            
                r0 = r0.k();
             */
            /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
            
                r0 = r0.k();
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2() {
                ApngImage k3;
                ApngImage k16;
                QQKuiklyAPNGView qQKuiklyAPNGView = weakReference.get();
                if (qQKuiklyAPNGView != null && k16 != null) {
                    k16.replay();
                }
                QQKuiklyAPNGView qQKuiklyAPNGView2 = weakReference.get();
                if (qQKuiklyAPNGView2 == null || k3 == null) {
                    return;
                }
                k3.resume();
            }
        });
    }

    @Override // d01.b
    public void c(d01.c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
    }

    @Override // d01.b
    public void e(d01.c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        r(this, 0, 0, 3, null);
    }

    @Override // d01.b
    public void setFilePath(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        o(this, filePath, 0, 0, 6, null);
    }

    @Override // d01.b
    public void setRepeatCount(final int count) {
        this.repeatCount = count;
        final WeakReference weakReference = new WeakReference(this);
        j(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.QQKuiklyAPNGView$setRepeatCount$1
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
                QQKuiklyAPNGView qQKuiklyAPNGView = weakReference.get();
                ApngImage k3 = qQKuiklyAPNGView != null ? qQKuiklyAPNGView.k() : null;
                if (k3 == null) {
                    return;
                }
                k3.apngLoop = count;
            }
        });
    }

    @Override // d01.b
    public void stopAnimation() {
        final WeakReference weakReference = new WeakReference(this);
        j(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.QQKuiklyAPNGView$stopAnimation$1
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

            /* JADX WARN: Code restructure failed: missing block: B:3:0x000a, code lost:
            
                r0 = r0.k();
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2() {
                ApngImage k3;
                QQKuiklyAPNGView qQKuiklyAPNGView = weakReference.get();
                if (qQKuiklyAPNGView == null || k3 == null) {
                    return;
                }
                k3.pause();
            }
        });
    }

    static /* synthetic */ void o(QQKuiklyAPNGView qQKuiklyAPNGView, String str, int i3, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i3 = qQKuiklyAPNGView.getWidth();
        }
        if ((i17 & 4) != 0) {
            i16 = qQKuiklyAPNGView.getHeight();
        }
        qQKuiklyAPNGView.n(str, i3, i16);
    }

    static /* synthetic */ void r(QQKuiklyAPNGView qQKuiklyAPNGView, int i3, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = qQKuiklyAPNGView.getWidth();
        }
        if ((i17 & 2) != 0) {
            i16 = qQKuiklyAPNGView.getHeight();
        }
        qQKuiklyAPNGView.q(i3, i16);
    }

    @Override // d01.b
    public View d() {
        return this;
    }
}
