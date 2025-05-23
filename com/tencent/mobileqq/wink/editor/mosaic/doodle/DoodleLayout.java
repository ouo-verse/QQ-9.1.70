package com.tencent.mobileqq.wink.editor.mosaic.doodle;

import android.content.Context;
import android.graphics.Rect;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.editor.mosaic.doodle.DoodleLayout;
import com.tencent.mobileqq.wink.editor.mosaic.ui.DoodleView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import v63.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 t2\u00020\u00012\u00020\u0002:\u0003u\u000b\u001dB\u0013\b\u0016\u0012\b\u0010l\u001a\u0004\u0018\u00010k\u00a2\u0006\u0004\bm\u0010nB\u001d\b\u0016\u0012\b\u0010l\u001a\u0004\u0018\u00010k\u0012\b\u0010p\u001a\u0004\u0018\u00010o\u00a2\u0006\u0004\bm\u0010qB%\b\u0016\u0012\b\u0010l\u001a\u0004\u0018\u00010k\u0012\b\u0010p\u001a\u0004\u0018\u00010o\u0012\u0006\u0010r\u001a\u00020\u0003\u00a2\u0006\u0004\bm\u0010sJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0003H\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\u0006\u0010\u0014\u001a\u00020\u0005J\u0012\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0006\u0010\u0018\u001a\u00020\u0005J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\u001e\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001bJ\u0016\u0010 \u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003J\u000e\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0003J\u0010\u0010%\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020#H\u0016J\u0012\u0010&\u001a\u00020\u001b2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016R\"\u0010,\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010/\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010'\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+R\"\u00102\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010'\u001a\u0004\b0\u0010)\"\u0004\b1\u0010+R*\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u000104038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R(\u0010>\u001a\b\u0012\u0004\u0012\u00020;038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u00105\u001a\u0004\b<\u00107\"\u0004\b=\u00109R\u0016\u0010?\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010'R$\u0010G\u001a\u0004\u0018\u00010@8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0014\u0010K\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010O\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u001c\u0010T\u001a\n Q*\u0004\u0018\u00010P0P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010SR\"\u0010X\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010'\u001a\u0004\bV\u0010)\"\u0004\bW\u0010+R\u0017\u0010^\u001a\u00020Y8\u0006\u00a2\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]R\u001a\u0010b\u001a\b\u0012\u0004\u0012\u00020`0_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010aR\"\u0010j\u001a\u00020c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010i\u00a8\u0006v"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/mosaic/doodle/DoodleLayout;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "", "e", "", "d", "Lu63/b;", "f", "", "factor", "b", "j", "o", "normalPenWidth", "g", "buttonState", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, h.F, "i", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "l", NodeProps.ON_DETACHED_FROM_WINDOW, "w", "", "keepDoodle", "c", NodeProps.MAX_WIDTH, NodeProps.MAX_HEIGHT, "setDoodleBitmapMaxSize", "size", "setMosaicSize", "Landroid/view/MotionEvent;", "event", "dispatchTouchEvent", "onTouchEvent", "I", "getMSelectedLineType", "()I", "setMSelectedLineType", "(I)V", "mSelectedLineType", "getMSelectedLineSubType", "setMSelectedLineSubType", "mSelectedLineSubType", "getCurrentIndex", "setCurrentIndex", "currentIndex", "Landroid/util/SparseArray;", "Lt63/a;", "Landroid/util/SparseArray;", "getMDoodleConfigMap", "()Landroid/util/SparseArray;", "setMDoodleConfigMap", "(Landroid/util/SparseArray;)V", "mDoodleConfigMap", "Lcom/tencent/mobileqq/wink/editor/mosaic/doodle/DoodleLayout$b;", "getMLayerCollectionMap", "setMLayerCollectionMap", "mLayerCollectionMap", "mMosaicSize", "Lcom/tencent/mobileqq/wink/editor/mosaic/ui/DoodleView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/editor/mosaic/ui/DoodleView;", "getMDoodleView", "()Lcom/tencent/mobileqq/wink/editor/mosaic/ui/DoodleView;", "setMDoodleView", "(Lcom/tencent/mobileqq/wink/editor/mosaic/ui/DoodleView;)V", "mDoodleView", "Ljava/util/concurrent/atomic/AtomicBoolean;", "D", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mNeedCreateBitmapCache", "Ljava/util/concurrent/locks/Lock;", "E", "Ljava/util/concurrent/locks/Lock;", "mBitmapCacheLock", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", UserInfo.SEX_FEMALE, "Ljava/util/concurrent/locks/Condition;", "mBitmapAvailableCondition", "G", "getMButtonState", "setMButtonState", "mButtonState", "Lcom/tencent/mobileqq/wink/editor/mosaic/b;", "H", "Lcom/tencent/mobileqq/wink/editor/mosaic/b;", "getPicRawImage", "()Lcom/tencent/mobileqq/wink/editor/mosaic/b;", "picRawImage", "Ljava/util/Comparator;", "Lv63/a;", "Ljava/util/Comparator;", "mBaseLayerComparator", "Landroid/graphics/Rect;", "J", "Landroid/graphics/Rect;", "getMDisplayRect", "()Landroid/graphics/Rect;", "setMDisplayRect", "(Landroid/graphics/Rect;)V", "mDisplayRect", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "L", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class DoodleLayout extends RelativeLayout implements View.OnClickListener {
    private static int M = ViewUtils.dip2px(3.0f);
    private static int N = ViewUtils.dip2px(32.0f);
    private static int P;
    private static float Q;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private DoodleView mDoodleView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final AtomicBoolean mNeedCreateBitmapCache;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lock mBitmapCacheLock;

    /* renamed from: F, reason: from kotlin metadata */
    private final Condition mBitmapAvailableCondition;

    /* renamed from: G, reason: from kotlin metadata */
    private int mButtonState;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.wink.editor.mosaic.b picRawImage;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Comparator<a> mBaseLayerComparator;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private Rect mDisplayRect;

    @NotNull
    public Map<Integer, View> K = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mSelectedLineType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mSelectedLineSubType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int currentIndex;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private SparseArray<t63.a> mDoodleConfigMap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private SparseArray<b> mLayerCollectionMap;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mMosaicSize;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/mosaic/doodle/DoodleLayout$b;", "", "Lu63/b;", "a", "Lu63/b;", "()Lu63/b;", "mLineLayer", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final u63.b mLineLayer;

        @NotNull
        /* renamed from: a, reason: from getter */
        public final u63.b getMLineLayer() {
            return this.mLineLayer;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/mosaic/doodle/DoodleLayout$c;", "", "", "state", "", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final c f320639a = new c();

        c() {
        }

        public final boolean a(int state) {
            if (state == 0 || state == 1 || state == 2 || state == 3 || state == 4 || state == 5 || state == 6 || state == 9 || state == 10 || state == 11) {
                return true;
            }
            return false;
        }
    }

    static {
        int dip2px = ViewUtils.dip2px(5.0f) - 7;
        P = dip2px;
        Q = (dip2px * 1.0f) / (N - M);
    }

    public DoodleLayout(@Nullable Context context) {
        super(context);
        this.mSelectedLineType = -1;
        this.mSelectedLineSubType = -1;
        this.mDoodleConfigMap = new SparseArray<>();
        this.mLayerCollectionMap = new SparseArray<>();
        this.mMosaicSize = -1;
        this.mNeedCreateBitmapCache = new AtomicBoolean(true);
        ReentrantLock reentrantLock = new ReentrantLock();
        this.mBitmapCacheLock = reentrantLock;
        this.mBitmapAvailableCondition = reentrantLock.newCondition();
        this.picRawImage = new com.tencent.mobileqq.wink.editor.mosaic.b();
        this.mBaseLayerComparator = new Comparator() { // from class: s63.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int k3;
                k3 = DoodleLayout.k((v63.a) obj, (v63.a) obj2);
                return k3;
            }
        };
        this.mDisplayRect = new Rect();
        i();
    }

    private final float b(float factor) {
        return M + ((N - r0) * factor);
    }

    private final void d() {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
        } else {
            throw new IllegalStateException("Only the original thread that created a view hierarchy can touch its views.".toString());
        }
    }

    private final int e() {
        return R.layout.hcm;
    }

    private final u63.b f() {
        b bVar = this.mLayerCollectionMap.get(this.currentIndex);
        if (bVar == null) {
            hd0.c.v("DoodleLayout_Mosaic", "can not find LayerCollection by index %d", Integer.valueOf(this.currentIndex));
            return null;
        }
        return bVar.getMLineLayer();
    }

    private final float g(float normalPenWidth) {
        return normalPenWidth * 3.2f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x006f, code lost:
    
        if (r0 < 0.01f) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void h() {
        com.tencent.mobileqq.wink.editor.mosaic.b bVar = this.picRawImage;
        if (bVar != null) {
            float c16 = bVar.c();
            float mBaseScale = bVar.getMBaseScale();
            float mMaxScale = bVar.getMMaxScale();
            float f16 = mMaxScale - mBaseScale;
            w53.b.a("DoodleLayout_Mosaic", "handleDoodleViewScale... currentScale:" + c16 + ",baseScale:" + mBaseScale + ",maxScale:" + mMaxScale + ",scaleLength:" + f16);
            float f17 = 0.0f;
            if (f16 <= 0.0f) {
                w53.b.a("DoodleLayout_Mosaic", "handleDoodleViewScale... scalelength:" + f16);
                return;
            }
            float f18 = mMaxScale - c16;
            float f19 = -0.01f;
            if (f18 >= -0.01f) {
                f19 = 0.01f;
            }
            f18 = f19;
            if (f18 > 0.0f) {
                f17 = Q * (f18 / f16);
            } else if (f18 < 0.0f) {
                f17 = Q / ((-f18) / f16);
            }
            o(f17);
            return;
        }
        w53.b.a("DoodleLayout_Mosaic", "handleDoodleViewScale error, editPicRawImage is null!");
    }

    private final void j() {
        View findViewById = super.findViewById(R.id.f165009bo4);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.mosaic.ui.DoodleView");
        this.mDoodleView = (DoodleView) findViewById;
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int k(a aVar, a aVar2) {
        return aVar2.d() - aVar.d();
    }

    private final void n(int buttonState) {
        ms.a.a("DoodleLayout_Mosaic", "setState---buttonState=" + buttonState);
        if (!c.f320639a.a(buttonState)) {
            hd0.c.g("DoodleLayout_Mosaic", "illegal state.");
        } else {
            this.mButtonState = buttonState;
        }
    }

    private final void o(float factor) {
        w63.b bVar;
        u63.b f16 = f();
        if (f16 == null) {
            return;
        }
        float b16 = b(factor);
        w63.a s16 = f16.s(104);
        if (s16 instanceof w63.b) {
            bVar = (w63.b) s16;
        } else {
            bVar = null;
        }
        if (bVar != null) {
            bVar.b(g(b16));
        }
    }

    public final void c(int w3, int h16, boolean keepDoodle) {
        w63.b bVar;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("changeDoodleViewSize, width: %d, height: %d ", Arrays.copyOf(new Object[]{Integer.valueOf(w3), Integer.valueOf(h16)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        hd0.c.a("DoodleLayout_Mosaic", format);
        setDoodleBitmapMaxSize(w3, h16);
        DoodleView doodleView = this.mDoodleView;
        Intrinsics.checkNotNull(doodleView);
        int width = doodleView.getWidth();
        DoodleView doodleView2 = this.mDoodleView;
        Intrinsics.checkNotNull(doodleView2);
        int height = doodleView2.getHeight();
        DoodleView doodleView3 = this.mDoodleView;
        Intrinsics.checkNotNull(doodleView3);
        ViewGroup.LayoutParams layoutParams = doodleView3.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        layoutParams.width = w3;
        layoutParams.height = h16;
        DoodleView doodleView4 = this.mDoodleView;
        Intrinsics.checkNotNull(doodleView4);
        doodleView4.setLayoutParams(layoutParams);
        if (!keepDoodle) {
            DoodleView doodleView5 = this.mDoodleView;
            Intrinsics.checkNotNull(doodleView5);
            doodleView5.b();
            m();
        }
        DoodleView doodleView6 = this.mDoodleView;
        Intrinsics.checkNotNull(doodleView6);
        doodleView6.j();
        DoodleView doodleView7 = this.mDoodleView;
        Intrinsics.checkNotNull(doodleView7);
        doodleView7.onSizeChanged(w3, h16, width, height);
        u63.b f16 = f();
        Intrinsics.checkNotNull(f16);
        w63.a s16 = f16.s(104);
        if (s16 instanceof w63.b) {
            bVar = (w63.b) s16;
        } else {
            bVar = null;
        }
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action == 1 || action == 3 || action == 6) {
            h();
        }
        return super.dispatchTouchEvent(event);
    }

    public final void i() {
        LayoutInflater.from(super.getContext()).inflate(e(), this);
        j();
    }

    public final void l() {
        d();
        m();
        n(0);
        DoodleView doodleView = this.mDoodleView;
        Intrinsics.checkNotNull(doodleView);
        doodleView.k();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        DoodleView doodleView = this.mDoodleView;
        Intrinsics.checkNotNull(doodleView);
        doodleView.i();
        com.tencent.mobileqq.wink.editor.mosaic.b bVar = this.picRawImage;
        if (bVar != null) {
            bVar.f();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent event) {
        DoodleView doodleView = this.mDoodleView;
        Intrinsics.checkNotNull(doodleView);
        doodleView.d().b(event);
        return true;
    }

    public final void setCurrentIndex(int i3) {
        this.currentIndex = i3;
    }

    public final void setDoodleBitmapMaxSize(int maxWidth, int maxHeight) {
        if (maxWidth > 0 && maxHeight > 0) {
            hd0.c.a("DoodleLayout_Mosaic", "setDoodleBitmapMaxSize, maxWidth" + maxWidth + ",maxHeight:" + maxHeight);
            int size = this.mDoodleConfigMap.size();
            for (int i3 = 0; i3 < size; i3++) {
                t63.a aVar = this.mDoodleConfigMap.get(i3);
                if (aVar != null) {
                    aVar.f435494a = maxWidth;
                    aVar.f435495b = maxHeight;
                }
            }
            return;
        }
        hd0.c.g("DoodleLayout_Mosaic", "width or height is illegal, width=" + maxWidth + ",height=" + maxHeight);
    }

    public final void setMButtonState(int i3) {
        this.mButtonState = i3;
    }

    public final void setMDisplayRect(@NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "<set-?>");
        this.mDisplayRect = rect;
    }

    public final void setMDoodleConfigMap(@NotNull SparseArray<t63.a> sparseArray) {
        Intrinsics.checkNotNullParameter(sparseArray, "<set-?>");
        this.mDoodleConfigMap = sparseArray;
    }

    public final void setMDoodleView(@Nullable DoodleView doodleView) {
        this.mDoodleView = doodleView;
    }

    public final void setMLayerCollectionMap(@NotNull SparseArray<b> sparseArray) {
        Intrinsics.checkNotNullParameter(sparseArray, "<set-?>");
        this.mLayerCollectionMap = sparseArray;
    }

    public final void setMSelectedLineSubType(int i3) {
        this.mSelectedLineSubType = i3;
    }

    public final void setMSelectedLineType(int i3) {
        this.mSelectedLineType = i3;
    }

    public final void setMosaicSize(int size) {
        w63.b bVar;
        if (size < 1) {
            hd0.c.g("DoodleLayout_Mosaic", "MosaicSize little than 1.");
            size = 1;
        }
        this.mMosaicSize = size;
        int size2 = this.mLayerCollectionMap.size();
        for (int i3 = 0; i3 < size2; i3++) {
            w63.a s16 = this.mLayerCollectionMap.valueAt(i3).getMLineLayer().s(104);
            if (s16 instanceof w63.b) {
                bVar = (w63.b) s16;
            } else {
                bVar = null;
            }
            if (bVar != null) {
                bVar.c(size);
            }
        }
    }

    public DoodleLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSelectedLineType = -1;
        this.mSelectedLineSubType = -1;
        this.mDoodleConfigMap = new SparseArray<>();
        this.mLayerCollectionMap = new SparseArray<>();
        this.mMosaicSize = -1;
        this.mNeedCreateBitmapCache = new AtomicBoolean(true);
        ReentrantLock reentrantLock = new ReentrantLock();
        this.mBitmapCacheLock = reentrantLock;
        this.mBitmapAvailableCondition = reentrantLock.newCondition();
        this.picRawImage = new com.tencent.mobileqq.wink.editor.mosaic.b();
        this.mBaseLayerComparator = new Comparator() { // from class: s63.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int k3;
                k3 = DoodleLayout.k((v63.a) obj, (v63.a) obj2);
                return k3;
            }
        };
        this.mDisplayRect = new Rect();
        i();
    }

    private final void m() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
    }

    public DoodleLayout(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mSelectedLineType = -1;
        this.mSelectedLineSubType = -1;
        this.mDoodleConfigMap = new SparseArray<>();
        this.mLayerCollectionMap = new SparseArray<>();
        this.mMosaicSize = -1;
        this.mNeedCreateBitmapCache = new AtomicBoolean(true);
        ReentrantLock reentrantLock = new ReentrantLock();
        this.mBitmapCacheLock = reentrantLock;
        this.mBitmapAvailableCondition = reentrantLock.newCondition();
        this.picRawImage = new com.tencent.mobileqq.wink.editor.mosaic.b();
        this.mBaseLayerComparator = new Comparator() { // from class: s63.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int k3;
                k3 = DoodleLayout.k((v63.a) obj, (v63.a) obj2);
                return k3;
            }
        };
        this.mDisplayRect = new Rect();
        i();
    }
}
