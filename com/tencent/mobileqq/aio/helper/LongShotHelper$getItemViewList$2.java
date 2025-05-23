package com.tencent.mobileqq.aio.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.collection.LruCache;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.aio.event.LongShotMsgIntent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/aio/helper/LongShotHelper$getItemViewList$2", "Landroidx/recyclerview/widget/RecyclerView$OnChildAttachStateChangeListener;", "onChildViewAttachedToWindow", "", "itemView", "Landroid/view/View;", "onChildViewDetachedFromWindow", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
public final class LongShotHelper$getItemViewList$2 implements RecyclerView.OnChildAttachStateChangeListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ LongShotHelper f188881d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Ref.IntRef f188882e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ LruCache<String, Bitmap> f188883f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ Ref.IntRef f188884h;

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ int f188885i;

    /* renamed from: m, reason: collision with root package name */
    final /* synthetic */ RecyclerView f188886m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LongShotHelper$getItemViewList$2(LongShotHelper longShotHelper, Ref.IntRef intRef, LruCache<String, Bitmap> lruCache, Ref.IntRef intRef2, int i3, RecyclerView recyclerView) {
        this.f188881d = longShotHelper;
        this.f188882e = intRef;
        this.f188883f = lruCache;
        this.f188884h = intRef2;
        this.f188885i = i3;
        this.f188886m = recyclerView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, longShotHelper, intRef, lruCache, intRef2, Integer.valueOf(i3), recyclerView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LruCache bitmapCache, Ref.IntRef i3, View itemView, LongShotHelper this$0, Ref.IntRef msgHeight, int i16, RecyclerView recyclerView) {
        Context context;
        boolean z16;
        boolean z17;
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap bitmap4;
        com.tencent.mobileqq.aio.longshot.b L;
        com.tencent.mobileqq.aio.longshot.b L2;
        Bitmap bitmap5;
        com.tencent.aio.main.businesshelper.b bVar;
        Intrinsics.checkNotNullParameter(bitmapCache, "$bitmapCache");
        Intrinsics.checkNotNullParameter(i3, "$i");
        Intrinsics.checkNotNullParameter(itemView, "$itemView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgHeight, "$msgHeight");
        Intrinsics.checkNotNullParameter(recyclerView, "$recyclerView");
        try {
            bitmapCache.put(String.valueOf(i3.element), com.tencent.mobileqq.aio.utils.am.f194110a.e(itemView, true));
        } catch (Throwable th5) {
            QLog.e("LongShotHelper", 1, "try create bitmap 1 false: " + th5);
            System.gc();
            Runtime runtime = Runtime.getRuntime();
            if ((runtime.maxMemory() / 1048576) - ((runtime.totalMemory() - runtime.freeMemory()) / 1048576) < 1) {
                this$0.H(bitmapCache);
                return;
            }
            try {
                bitmapCache.put(String.valueOf(i3.element), com.tencent.mobileqq.aio.utils.am.f194110a.e(itemView, true));
            } catch (Throwable th6) {
                QLog.e("LongShotHelper", 1, "try create bitmap 2 false: " + th6);
                this$0.H(bitmapCache);
                return;
            }
        }
        msgHeight.element += itemView.getMeasuredHeight();
        int i17 = i3.element + 1;
        i3.element = i17;
        if (i17 >= i16) {
            try {
                context = this$0.mContext;
                if (context != null) {
                    if (!com.tencent.mobileqq.aio.utils.am.f194110a.a(context, msgHeight.element)) {
                        this$0.H(bitmapCache);
                    } else {
                        z16 = this$0.mIsMosaic;
                        Bitmap bitmap6 = z16 ? this$0.mMosaicTitleBitmap : this$0.mTitleBitmap;
                        z17 = this$0.mIsMosaic;
                        bitmap = this$0.mBottomBlurBitmap;
                        bitmap2 = this$0.mInputBarBitmap;
                        bitmap3 = this$0.mShortcutBarBitmap;
                        bitmap4 = this$0.mWatermarkBitmap;
                        com.tencent.mobileqq.aio.longshot.c cVar = new com.tencent.mobileqq.aio.longshot.c(z17, bitmapCache, bitmap6, bitmap, bitmap2, bitmap3, bitmap4);
                        L = this$0.L();
                        if (L != null) {
                            L.i(cVar);
                        }
                        L2 = this$0.L();
                        if (L2 != null) {
                            bitmap5 = L2.a(recyclerView.getMeasuredWidth(), msgHeight.element);
                        } else {
                            bitmap5 = null;
                        }
                        if (bitmap5 != null) {
                            bVar = this$0.mHelperParam;
                            if (bVar == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
                                bVar = null;
                            }
                            LifecycleOwner d16 = bVar.a().d();
                            Intrinsics.checkNotNullExpressionValue(d16, "mHelperParam.aioContext.lifecycleOwner");
                            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(d16), null, null, new LongShotHelper$getItemViewList$2$onChildViewAttachedToWindow$1$1$1(this$0, bitmap5, null), 3, null);
                        } else {
                            this$0.H(bitmapCache);
                        }
                    }
                }
                ViewParent parent = recyclerView.getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent).removeView(recyclerView);
                return;
            } catch (Exception e16) {
                this$0.H(bitmapCache);
                QLog.e("LongShotHelper", 1, "draw bitmap error: " + e16);
                return;
            }
        }
        recyclerView.scrollToPosition(i17);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewAttachedToWindow(@NotNull final View itemView) {
        com.tencent.aio.main.businesshelper.b bVar;
        boolean z16;
        Handler handler;
        long N;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) itemView);
            return;
        }
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        bVar = this.f188881d.mHelperParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            bVar = null;
        }
        com.tencent.mvi.base.route.j e16 = bVar.a().e();
        z16 = this.f188881d.mIsMosaic;
        e16.h(new LongShotMsgIntent.ShotMosaic(z16));
        handler = this.f188881d.mUiHandler;
        final LruCache<String, Bitmap> lruCache = this.f188883f;
        final Ref.IntRef intRef = this.f188882e;
        final LongShotHelper longShotHelper = this.f188881d;
        final Ref.IntRef intRef2 = this.f188884h;
        final int i3 = this.f188885i;
        final RecyclerView recyclerView = this.f188886m;
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.aio.helper.ah
            @Override // java.lang.Runnable
            public final void run() {
                LongShotHelper$getItemViewList$2.b(LruCache.this, intRef, itemView, longShotHelper, intRef2, i3, recyclerView);
            }
        };
        N = this.f188881d.N(this.f188882e.element);
        handler.postDelayed(runnable, N);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewDetachedFromWindow(@NotNull View itemView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) itemView);
        } else {
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }
    }
}
