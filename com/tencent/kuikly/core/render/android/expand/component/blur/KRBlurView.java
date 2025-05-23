package com.tencent.kuikly.core.render.android.expand.component.blur;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.UiThread;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import i01.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 z2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001{B\u000f\u0012\u0006\u0010w\u001a\u00020v\u00a2\u0006\u0004\bx\u0010yJ\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0002J \u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J \u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0018\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017H\u0002J.\u0010!\u001a\u00020\u00102\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0\u001f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u001a\u0010#\u001a\u0004\u0018\u00010\u00172\u0006\u0010\"\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010$H\u0002J\u0018\u0010'\u001a\u00020\u00102\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010$H\u0002J \u0010(\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00170\u001fH\u0002J\n\u0010*\u001a\u0004\u0018\u00010\u0017H\u0002J\n\u0010+\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010,\u001a\u00020\u0010H\u0014J\b\u0010-\u001a\u00020\u0010H\u0014J\u0018\u00100\u001a\u00020\b2\u0006\u0010/\u001a\u00020.2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016JI\u00109\u001a\u0004\u0018\u00010\u00062\u0006\u00101\u001a\u00020.2\b\u00102\u001a\u0004\u0018\u00010.2+\u00108\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b4\u0012\b\b5\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u0010\u0018\u000103j\u0004\u0018\u0001`7H\u0016J\u0010\u0010:\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J(\u0010>\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\r2\u0006\u0010;\u001a\u00020\r2\u0006\u0010<\u001a\u00020\r2\u0006\u0010=\u001a\u00020\rH\u0014J\b\u0010?\u001a\u00020\u0010H\u0016J\u001a\u0010D\u001a\u00020\u00102\u0006\u0010A\u001a\u00020@2\b\u0010C\u001a\u0004\u0018\u00010BH\u0016J\u0010\u0010E\u001a\u00020\u00102\u0006\u0010A\u001a\u00020@H\u0016J\u0010\u0010F\u001a\u00020\u00102\u0006\u0010A\u001a\u00020@H\u0016J\u0010\u0010G\u001a\u00020\u00102\u0006\u0010A\u001a\u00020@H\u0016J\u0010\u0010H\u001a\u00020\u00102\u0006\u0010A\u001a\u00020@H\u0016J\u0018\u0010J\u001a\u00020\u00102\u0006\u0010A\u001a\u00020@2\u0006\u0010I\u001a\u00020BH\u0016J\u0010\u0010K\u001a\u00020\u00102\u0006\u0010A\u001a\u00020@H\u0016R\u0018\u0010N\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010U\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010X\u001a\u00020V8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010WR\u0014\u0010Z\u001a\u00020V8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010WR\u0016\u0010\\\u001a\u00020[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0012R\u0014\u0010_\u001a\u00020]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010^R\u0016\u0010`\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010TR\u001c\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00170a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010bR\u001c\u0010d\u001a\b\u0012\u0004\u0012\u00020\r0a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010bR\u0016\u0010e\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010TR\u001b\u0010k\u001a\u00020f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bg\u0010h\u001a\u0004\bi\u0010jR\u0016\u0010m\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010TR\u0016\u0010o\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010TR\u0016\u0010q\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010TR\u0014\u0010u\u001a\u00020r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bs\u0010t\u00a8\u0006|"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/blur/KRBlurView;", "Landroid/widget/FrameLayout;", "Li01/c;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/app/Application;", "w", "", "propValue", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "l", "j", "", "width", "height", "", "G", UserInfo.SEX_FEMALE, "Landroid/graphics/Canvas;", PM.CANVAS, "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "E", "view", "Landroid/view/TextureView;", "t", "", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "r", "tag", "u", "", BdhLogUtil.LogTag.Tag_Conn, "setGoneViews", "B", "D", HippyTKDListViewAdapter.X, "v", "y", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "", "propKey", "b", "method", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "draw", tl.h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onActivityCreated", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "outState", "onActivitySaveInstanceState", "onActivityDestroyed", "d", "Landroid/graphics/Bitmap;", "internalBitmap", "Lcom/tencent/kuikly/core/render/android/expand/component/blur/a;", "e", "Lcom/tencent/kuikly/core/render/android/expand/component/blur/a;", "internalCanvas", "f", "Z", "initialized", "", "[I", "rootLocation", "i", "blurViewLocation", "", "blurRadius", "Lcom/tencent/kuikly/core/render/android/expand/component/blur/b;", "Lcom/tencent/kuikly/core/render/android/expand/component/blur/b;", "blur", "filterInvalidDraw", "", "Ljava/util/List;", "blurRootViewList", "targetBlurViewTags", "blurOtherLayer", "Landroid/graphics/Paint;", "H", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Landroid/graphics/Paint;", "otherLayerPaint", "I", "pauseBlur", "J", "blurOnce", "K", "hadBlurBefore", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "L", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "preDrawListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "M", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRBlurView extends FrameLayout implements i01.c, Application.ActivityLifecycleCallbacks {

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private final com.tencent.kuikly.core.render.android.expand.component.blur.b blur;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean filterInvalidDraw;

    /* renamed from: E, reason: from kotlin metadata */
    private List<View> blurRootViewList;

    /* renamed from: F, reason: from kotlin metadata */
    private List<Integer> targetBlurViewTags;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean blurOtherLayer;

    /* renamed from: H, reason: from kotlin metadata */
    private final Lazy otherLayerPaint;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean pauseBlur;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean blurOnce;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean hadBlurBefore;

    /* renamed from: L, reason: from kotlin metadata */
    private final ViewTreeObserver.OnPreDrawListener preDrawListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Bitmap internalBitmap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private a internalCanvas;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean initialized;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int[] rootLocation;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int[] blurViewLocation;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float blurRadius;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/blur/KRBlurView$a;", "", "", "PROP_BLUR_ONCE", "Ljava/lang/String;", "PROP_BLUR_OTHER_LAYER", "PROP_BLUR_RADIUS", "PROP_TARGET_BLUR_VIEW_NATIVE_REFS", "VIEW_NAME", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.expand.component.blur.KRBlurView$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "onPreDraw"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    static final class b implements ViewTreeObserver.OnPreDrawListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            if (KRBlurView.this.pauseBlur) {
                return false;
            }
            if (!KRBlurView.this.filterInvalidDraw) {
                KRBlurView.this.F();
                return true;
            }
            KRBlurView.this.filterInvalidDraw = false;
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KRBlurView(@NotNull Context context) {
        super(context);
        com.tencent.kuikly.core.render.android.expand.component.blur.b lVar;
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.rootLocation = new int[2];
        this.blurViewLocation = new int[2];
        this.blurRadius = 5.0f;
        if (Build.VERSION.SDK_INT >= 31) {
            lVar = new k(context);
        } else {
            lVar = new l(context);
        }
        this.blur = lVar;
        this.blurRootViewList = new ArrayList();
        this.targetBlurViewTags = new ArrayList();
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<Paint>() { // from class: com.tencent.kuikly.core.render.android.expand.component.blur.KRBlurView$otherLayerPaint$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Paint invoke() {
                Paint paint = new Paint();
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
                return paint;
            }
        });
        this.otherLayerPaint = lazy;
        this.preDrawListener = new b();
        setWillNotDraw(false);
        Application w3 = w();
        if (w3 != null) {
            w3.registerActivityLifecycleCallbacks(this);
        }
    }

    private final void B(Set<? extends View> setGoneViews) {
        if (setGoneViews != null) {
            Iterator<T> it = setGoneViews.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setVisibility(0);
            }
        }
    }

    private final Set<View> C() {
        ViewParent parent = getParent();
        LinkedHashSet linkedHashSet = null;
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup != null) {
            int indexOfChild = viewGroup.indexOfChild(this);
            if (indexOfChild == -1) {
                return null;
            }
            linkedHashSet = new LinkedHashSet();
            int childCount = viewGroup.getChildCount();
            for (int i3 = indexOfChild + 1; i3 < childCount; i3++) {
                View child = viewGroup.getChildAt(i3);
                if (!(child instanceof KRBlurView)) {
                    Intrinsics.checkNotNullExpressionValue(child, "child");
                    if (child.getVisibility() == 0) {
                        child.setVisibility(8);
                        linkedHashSet.add(child);
                        this.filterInvalidDraw = true;
                    }
                }
            }
            for (int i16 = 0; i16 < indexOfChild; i16++) {
                View childAt = viewGroup.getChildAt(i16);
                if (childAt != null && childAt.getZ() > getZ() && !(childAt instanceof KRBlurView) && childAt.getVisibility() == 0) {
                    childAt.setVisibility(8);
                    linkedHashSet.add(childAt);
                    this.filterInvalidDraw = true;
                }
            }
        }
        return linkedHashSet;
    }

    private final void D(View rootView, Bitmap bitmap, Canvas canvas) {
        rootView.getLocationOnScreen(this.rootLocation);
        getLocationOnScreen(this.blurViewLocation);
        int[] iArr = this.blurViewLocation;
        int i3 = iArr[0];
        int[] iArr2 = this.rootLocation;
        int i16 = i3 - iArr2[0];
        int i17 = iArr[1] - iArr2[1];
        float width = getWidth() / bitmap.getWidth();
        float height = getHeight() / bitmap.getHeight();
        canvas.translate((-i16) / width, (-i17) / height);
        float f16 = 1;
        canvas.scale(f16 / width, f16 / height);
    }

    private final void E(View rootView, Canvas canvas) {
        TextureView t16;
        Bitmap bitmap;
        if (this.blurOtherLayer && (t16 = t(rootView)) != null && (bitmap = t16.getBitmap()) != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, z());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F() {
        Bitmap bitmap;
        a aVar;
        if (!this.initialized) {
            return;
        }
        if ((!this.blurOnce || !this.hadBlurBefore) && (bitmap = this.internalBitmap) != null && (aVar = this.internalCanvas) != null) {
            bitmap.eraseColor(0);
            Iterator<T> it = x().iterator();
            while (it.hasNext()) {
                p(aVar, bitmap, (View) it.next());
            }
            this.internalBitmap = this.blur.blur(bitmap, this.blurRadius);
            this.hadBlurBefore = true;
        }
    }

    private final void G(int width, int height) {
        m mVar = new m(20.0f);
        if (mVar.b(width, height)) {
            return;
        }
        Pair<Integer, Integer> d16 = mVar.d(width, height);
        Bitmap bitmap = Bitmap.createBitmap(d16.getFirst().intValue(), d16.getSecond().intValue(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
        this.internalCanvas = new a(bitmap);
        this.internalBitmap = bitmap;
        this.initialized = true;
        this.hadBlurBefore = false;
    }

    private final boolean j(Object propValue) {
        boolean z16;
        if (propValue != null) {
            if (((Integer) propValue).intValue() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.blurOnce = z16;
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    private final boolean l(Object propValue) {
        boolean z16;
        if (propValue != null) {
            if (((Integer) propValue).intValue() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.blurOtherLayer = z16;
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    private final boolean m(Object propValue) {
        this.blurRadius = com.tencent.kuikly.core.render.android.css.ktx.b.H(propValue) * 2.0f;
        return true;
    }

    private final boolean o(Object propValue) {
        boolean z16;
        List split$default;
        Integer intOrNull;
        int i3;
        if (propValue != null) {
            String str = (String) propValue;
            if (str.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return true;
            }
            this.targetBlurViewTags.clear();
            split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"|"}, false, 0, 6, (Object) null);
            Iterator it = split$default.iterator();
            while (it.hasNext()) {
                intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull((String) it.next());
                if (intOrNull != null) {
                    i3 = intOrNull.intValue();
                } else {
                    i3 = -1;
                }
                if (i3 != -1) {
                    this.targetBlurViewTags.add(Integer.valueOf(i3));
                }
            }
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    private final void p(Canvas canvas, Bitmap bitmap, View rootView) {
        if (!this.targetBlurViewTags.isEmpty()) {
            r(this.targetBlurViewTags, canvas, bitmap, rootView);
        } else {
            q(canvas, bitmap, rootView);
        }
    }

    private final void q(Canvas canvas, Bitmap bitmap, View rootView) {
        canvas.save();
        D(rootView, bitmap, canvas);
        Set<View> C = C();
        rootView.draw(canvas);
        E(rootView, canvas);
        B(C);
        canvas.restore();
    }

    private final void r(List<Integer> tags, Canvas canvas, Bitmap bitmap, View rootView) {
        Iterator<T> it = tags.iterator();
        while (it.hasNext()) {
            View u16 = u(((Number) it.next()).intValue(), rootView);
            if (u16 != null) {
                canvas.save();
                D(u16, bitmap, canvas);
                u16.draw(canvas);
                canvas.restore();
            }
        }
    }

    private final TextureView t(View view) {
        if (view instanceof TextureView) {
            return (TextureView) view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                TextureView t16 = t(viewGroup.getChildAt(i3));
                if (t16 != null) {
                    return t16;
                }
            }
            return null;
        }
        return null;
    }

    private final View u(int tag, View rootView) {
        View view;
        com.tencent.kuikly.core.render.android.a aVar = get_kuiklyRenderContext();
        if (aVar != null) {
            view = aVar.b(tag);
        } else {
            view = null;
        }
        if (view == null) {
            return rootView.findViewWithTag(Integer.valueOf(tag));
        }
        return view;
    }

    private final View v() {
        Window window;
        Activity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            return window.getDecorView();
        }
        return null;
    }

    private final Application w() {
        Context context;
        Context context2 = getContext();
        Context context3 = null;
        if (context2 != null) {
            context = context2.getApplicationContext();
        } else {
            context = null;
        }
        if (context instanceof Application) {
            context3 = context;
        }
        return (Application) context3;
    }

    private final List<View> x() {
        this.blurRootViewList.clear();
        View v3 = v();
        if (v3 != null) {
            this.blurRootViewList.add(v3);
        }
        View y16 = y();
        if (y16 != null && (!Intrinsics.areEqual(y16, v3))) {
            this.blurRootViewList.add(y16);
        }
        return this.blurRootViewList;
    }

    private final View y() {
        return getRootView();
    }

    private final Paint z() {
        return (Paint) this.otherLayerPaint.getValue();
    }

    @Nullable
    public ViewGroup A() {
        return c.a.h(this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0010. Please report as an issue. */
    @Override // i01.c
    public boolean b(@NotNull String propKey, @NotNull Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        switch (propKey.hashCode()) {
            case -1428201511:
                if (propKey.equals("blurRadius")) {
                    return m(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case -825815244:
                if (propKey.equals("targetBlurViewNativeRefs")) {
                    return o(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case -479774840:
                if (propKey.equals("blurOnce")) {
                    return j(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 1394034664:
                if (propKey.equals("blurOtherLayer")) {
                    return l(propValue);
                }
                return c.a.p(this, propKey, propValue);
            default:
                return c.a.p(this, propKey, propValue);
        }
    }

    @Override // i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable Object obj, @Nullable Function1<Object, Unit> function1) {
        Intrinsics.checkNotNullParameter(method, "method");
        return c.a.a(this, method, obj, function1);
    }

    @Override // android.view.View
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (!this.initialized) {
            super.draw(canvas);
            return;
        }
        if (!(canvas instanceof a)) {
            Bitmap bitmap = this.internalBitmap;
            if (bitmap != null) {
                canvas.save();
                canvas.scale(getWidth() / bitmap.getWidth(), getHeight() / bitmap.getHeight());
                this.blur.a(canvas, bitmap);
                canvas.restore();
            }
            super.draw(canvas);
        }
    }

    @Override // i01.c
    public void e(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        c.a.l(this, parent);
    }

    @Override // i01.c
    @NotNull
    public View f() {
        return c.a.r(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    public Activity getActivity() {
        return c.a.e(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    /* renamed from: getKuiklyRenderContext */
    public com.tencent.kuikly.core.render.android.a get_kuiklyRenderContext() {
        return c.a.f(this);
    }

    @Override // i01.c
    @UiThread
    public void h() {
        c.a.n(this);
    }

    @Override // i01.c
    /* renamed from: k */
    public boolean getReusable() {
        return c.a.g(this);
    }

    @Override // i01.c
    public void n(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        c.a.i(this, parent);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (Intrinsics.areEqual(activity, getActivity()) && this.blur.b()) {
            this.hadBlurBefore = false;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        ViewTreeObserver viewTreeObserver;
        super.onAttachedToWindow();
        ViewGroup A = A();
        if (A != null && (viewTreeObserver = A.getViewTreeObserver()) != null) {
            viewTreeObserver.removeOnPreDrawListener(this.preDrawListener);
            viewTreeObserver.addOnPreDrawListener(this.preDrawListener);
        }
    }

    @Override // i01.a
    @UiThread
    public void onCreate() {
        c.a.j(this);
    }

    @Override // i01.c, i01.a
    public void onDestroy() {
        c.a.k(this);
        this.blur.destroy();
        Application w3 = w();
        if (w3 != null) {
            w3.unregisterActivityLifecycleCallbacks(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ViewTreeObserver viewTreeObserver;
        super.onDetachedFromWindow();
        ViewGroup A = A();
        if (A != null && (viewTreeObserver = A.getViewTreeObserver()) != null) {
            viewTreeObserver.removeOnPreDrawListener(this.preDrawListener);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        G(w3, h16);
    }

    @Override // i01.c
    @UiThread
    public boolean s(@NotNull String propKey) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        return c.a.m(this, propKey);
    }

    @Override // i01.c, i01.a
    public void setKuiklyRenderContext(@Nullable com.tencent.kuikly.core.render.android.a aVar) {
        c.a.o(this, aVar);
    }

    @Override // i01.c
    @UiThread
    public void setShadow(@NotNull i01.b shadow) {
        Intrinsics.checkNotNullParameter(shadow, "shadow");
        c.a.q(this, shadow);
    }

    @Override // i01.c, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        int hashCode = method.hashCode();
        if (hashCode != -557609420) {
            if (hashCode == 828891005 && method.equals("pauseBlur")) {
                this.pauseBlur = true;
                return Unit.INSTANCE;
            }
        } else if (method.equals("resumeBlur")) {
            this.pauseBlur = false;
            return Unit.INSTANCE;
        }
        return c.a.b(this, method, params, callback);
    }
}
