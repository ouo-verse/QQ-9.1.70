package com.tencent.mobileqq.qqecommerce.biz.kuikly.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.hippy.qq.utils.screenshot.ScreenShotHelper;
import com.tencent.kuikly.core.render.android.css.decoration.KRViewDecoration;
import com.tencent.kuikly.core.render.android.expand.component.list.KRRecyclerContentView;
import com.tencent.kuikly.core.render.android.expand.component.list.KRRecyclerView;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 *2\u00020\u0001:\u0002%*B\u0007\u00a2\u0006\u0004\b(\u0010)J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J0\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J&\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J(\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J \u0010\u0019\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0014H\u0002J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010\u0013\u001a\u00020\u0002H\u0002J\u0010\u0010!\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0002H\u0002J\u0012\u0010\"\u001a\u00020\u001f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0002J$\u0010#\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/utils/c;", "", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/utils/c$b;", "callBack", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/kuikly/core/render/android/expand/component/list/KRRecyclerView;", "recyclerView", "", "hideViews", "c", "Ljava/util/LinkedList;", "Landroid/graphics/Bitmap;", "bitmapList", "Landroid/graphics/Canvas;", PM.CANVAS, "f", "view", "", "height", "d", "e", "Landroidx/recyclerview/widget/RecyclerView;", "g", tl.h.F, MimeHelper.IMAGE_SUBTYPE_BITMAP, DomainData.DOMAIN_NAME, "recyclerContentViewHeight", "j", "", "k", "i", "l", "o", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "mScrollListener", "<init>", "()V", "b", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    private static final String f263215c = AppConstants.SDCARD_FILE_SAVE_PATH + "Kuikly/screenShot/";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private RecyclerView.OnScrollListener mScrollListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/utils/c$b;", "", "", QzoneIPCModule.RESULT_CODE, "", "filePath", "", "callback", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface b {
        void callback(int resultCode, String filePath);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/kuikly/utils/c$c", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqecommerce.biz.kuikly.utils.c$c, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    public static final class C8309c extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ KRRecyclerView f263217d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ c f263218e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ List<View> f263219f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ View f263220h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ b f263221i;

        /* JADX WARN: Multi-variable type inference failed */
        C8309c(KRRecyclerView kRRecyclerView, c cVar, List<? extends View> list, View view, b bVar) {
            this.f263217d = kRRecyclerView;
            this.f263218e = cVar;
            this.f263219f = list;
            this.f263220h = view;
            this.f263221i = bVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0) {
                if (this.f263217d.canScrollVertically(-1)) {
                    this.f263218e.c(this.f263217d, this.f263219f, this.f263220h, this.f263221i);
                } else {
                    this.f263217d.smoothScrollToPosition(0);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(KRRecyclerView recyclerView, List<? extends View> hideViews, View rootView, b callBack) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        int i3 = 0;
        if (!(adapter != null && adapter.getNUM_BACKGOURND_ICON() == 1) && callBack != null) {
            callBack.callback(-1, "");
        }
        KRRecyclerContentView kRRecyclerContentView = (KRRecyclerContentView) recyclerView.getChildAt(0);
        if (kRRecyclerContentView == null && callBack != null) {
            callBack.callback(-1, "");
        }
        LinkedList<Bitmap> linkedList = new LinkedList<>();
        if (kRRecyclerContentView != null) {
            int childCount = kRRecyclerContentView.getChildCount();
            int i16 = 0;
            for (int i17 = 0; i17 < childCount; i17++) {
                View childAt = kRRecyclerContentView.getChildAt(i17);
                if (l(childAt) && !hideViews.contains(childAt)) {
                    childAt.setDrawingCacheEnabled(true);
                    childAt.buildDrawingCache();
                    if (childAt.getDrawingCache() != null) {
                        try {
                            linkedList.add(Bitmap.createBitmap(childAt.getDrawingCache()));
                            i16 += childAt.getHeight();
                        } catch (Exception e16) {
                            QLog.e("Kuikly.ScreenShotUtil", 1, "[captureRecyclerView] createBitmap failed ,oom : ", e16);
                        }
                        childAt.setDrawingCacheEnabled(false);
                    }
                }
            }
            i3 = i16;
        }
        RecyclerView.OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            recyclerView.removeOnScrollListener(onScrollListener);
        }
        int j3 = j(rootView, i3);
        Bitmap screenShotBitmap = Bitmap.createBitmap(rootView.getWidth(), j3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(screenShotBitmap);
        d(recyclerView, rootView, canvas, j3);
        e(recyclerView, canvas);
        g(recyclerView, canvas, j3);
        f(recyclerView, linkedList, canvas);
        Intrinsics.checkNotNullExpressionValue(screenShotBitmap, "screenShotBitmap");
        n(screenShotBitmap, callBack);
        screenShotBitmap.recycle();
    }

    private final void d(View view, View rootView, Canvas canvas, int height) {
        Stack stack = new Stack();
        Stack stack2 = new Stack();
        while (view.getParent() != null) {
            Object parent = view.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
            view = (View) parent;
            if (k(view)) {
                stack.add(Integer.valueOf(i(view)));
                stack2.add(new Rect(view.getLeft(), view.getTop(), view.getRight(), height));
            }
            if (Intrinsics.areEqual(view, rootView)) {
                break;
            }
        }
        while (!stack.isEmpty() && !stack2.isEmpty()) {
            Paint paint = new Paint();
            Object pop = stack.pop();
            Intrinsics.checkNotNullExpressionValue(pop, "stack.pop()");
            paint.setColor(((Number) pop).intValue());
            canvas.drawRect((Rect) stack2.pop(), paint);
        }
    }

    private final void e(KRRecyclerView recyclerView, Canvas canvas) {
        if (recyclerView.getParent() instanceof ViewGroup) {
            ViewParent parent = recyclerView.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) parent;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (childAt instanceof KRRecyclerView) {
                    return;
                }
                childAt.setDrawingCacheEnabled(true);
                childAt.buildDrawingCache();
                if (childAt.getDrawingCache() != null) {
                    try {
                        Bitmap createBitmap = Bitmap.createBitmap(childAt.getDrawingCache());
                        canvas.drawBitmap(createBitmap, (Rect) null, new Rect(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom()), (Paint) null);
                        createBitmap.recycle();
                    } catch (OutOfMemoryError e16) {
                        QLog.e("Kuikly.ScreenShotUtil", 1, "drawOtherView drawBitmap failed, oom : ", e16);
                    }
                    childAt.setDrawingCacheEnabled(false);
                }
            }
        }
    }

    private final void f(KRRecyclerView recyclerView, LinkedList<Bitmap> bitmapList, Canvas canvas) {
        int top = recyclerView.getTop();
        while (!bitmapList.isEmpty()) {
            Bitmap pollFirst = bitmapList.pollFirst();
            if (pollFirst != null) {
                Rect rect = new Rect(recyclerView.getLeft(), top, recyclerView.getRight(), pollFirst.getHeight() + top);
                if (!pollFirst.isRecycled()) {
                    try {
                        canvas.drawBitmap(pollFirst, (Rect) null, rect, (Paint) null);
                        top += pollFirst.getHeight();
                    } catch (Exception e16) {
                        QLog.e(ScreenShotHelper.TAG, 1, "drawRecyclerContentView canvas.drawBitmap error, " + e16);
                    }
                    pollFirst.recycle();
                }
            }
        }
    }

    private final void g(RecyclerView recyclerView, Canvas canvas, int height) {
        if (k(recyclerView)) {
            Rect rect = new Rect(recyclerView.getLeft(), recyclerView.getTop(), recyclerView.getRight(), height);
            Paint paint = new Paint();
            paint.setColor(i(recyclerView));
            canvas.drawRect(rect, paint);
        }
    }

    private final KRRecyclerView h(View rootView) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(rootView);
        while (!linkedList.isEmpty()) {
            View view = (View) linkedList.poll();
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    if (viewGroup.getChildAt(i3) instanceof RecyclerView) {
                        View childAt = viewGroup.getChildAt(i3);
                        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type com.tencent.kuikly.core.render.android.expand.component.list.KRRecyclerView");
                        return (KRRecyclerView) childAt;
                    }
                    linkedList.add(viewGroup.getChildAt(i3));
                }
            }
        }
        return null;
    }

    private final int i(View view) {
        if (!(view.getContext() instanceof com.tencent.kuikly.core.render.android.j)) {
            return 0;
        }
        Context context = view.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.tencent.kuikly.core.render.android.KuiklyRenderViewContext");
        KRViewDecoration kRViewDecoration = (KRViewDecoration) ((com.tencent.kuikly.core.render.android.j) context).P0(view, "viewDecorator");
        if (kRViewDecoration != null) {
            return kRViewDecoration.getBackgroundColor();
        }
        return 0;
    }

    private final int j(View rootView, int recyclerContentViewHeight) {
        KRRecyclerView h16 = h(rootView);
        int i3 = 0;
        if ((h16 != null ? h16.getParent() : null) instanceof ViewGroup) {
            ViewParent parent = h16.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) parent;
            int childCount = viewGroup.getChildCount();
            int i16 = 0;
            while (i3 < childCount && !Intrinsics.areEqual(viewGroup.getChildAt(i3), h16)) {
                i16 = viewGroup.getChildAt(i3).getBottom();
                i3++;
            }
            i3 = i16;
        }
        return i3 + recyclerContentViewHeight;
    }

    private final boolean k(View view) {
        if (!(view.getContext() instanceof com.tencent.kuikly.core.render.android.j)) {
            return false;
        }
        Context context = view.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.tencent.kuikly.core.render.android.KuiklyRenderViewContext");
        KRViewDecoration kRViewDecoration = (KRViewDecoration) ((com.tencent.kuikly.core.render.android.j) context).P0(view, "viewDecorator");
        return (kRViewDecoration == null || kRViewDecoration.getBackgroundColor() == 0) ? false : true;
    }

    private final void n(Bitmap bitmap, b callBack) {
        String str = f263215c;
        String str2 = str + "screenshot_" + System.currentTimeMillis() + ".png";
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(str2);
            if (!file2.exists()) {
                file2.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            if (callBack != null) {
                callBack.callback(0, str2);
            }
        } catch (Exception e16) {
            if (callBack != null) {
                callBack.callback(-1, "");
            }
            QLog.e("Kuikly.ScreenShotUtil", 1, "saveScreenShot to file error, " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(c this$0, View rootView, b callBack, List hideViews) {
        Unit unit;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(rootView, "$rootView");
        Intrinsics.checkNotNullParameter(callBack, "$callBack");
        Intrinsics.checkNotNullParameter(hideViews, "$hideViews");
        KRRecyclerView h16 = this$0.h(rootView);
        if (h16 != null) {
            C8309c c8309c = new C8309c(h16, this$0, hideViews, rootView, callBack);
            this$0.mScrollListener = c8309c;
            Intrinsics.checkNotNull(c8309c, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.OnScrollListener");
            h16.addOnScrollListener(c8309c);
            h16.smoothScrollToPosition(0);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this$0.m(rootView, callBack);
        }
    }

    public final void o(final View rootView, final List<? extends View> hideViews, final b callBack) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(hideViews, "hideViews");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.utils.b
            @Override // java.lang.Runnable
            public final void run() {
                c.p(c.this, rootView, callBack, hideViews);
            }
        }, 100L);
    }

    private final void m(View rootView, b callBack) {
        rootView.setDrawingCacheEnabled(true);
        rootView.buildDrawingCache();
        if (rootView.getDrawingCache() == null) {
            if (callBack != null) {
                callBack.callback(-1, "");
                return;
            }
            return;
        }
        try {
            Bitmap bitmap = Bitmap.createBitmap(rootView.getDrawingCache());
            Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
            n(bitmap, callBack);
            bitmap.recycle();
        } catch (OutOfMemoryError e16) {
            QLog.e("Kuikly.ScreenShotUtil", 1, "normalScreenShot createBitmap failed ,oom : ", e16);
            if (callBack != null) {
                callBack.callback(-1, "");
            }
        }
    }

    private final boolean l(View view) {
        return (view == null || view.getWidth() == 0 || view.getHeight() == 0) ? false : true;
    }
}
