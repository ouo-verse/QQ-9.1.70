package com.tencent.qqnt.aio.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.r;
import com.tencent.qqnt.aio.widget.i;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 k2\u00020\u00012\u00020\u0002:\u0001%B\u0013\b\u0016\u0012\b\u0010c\u001a\u0004\u0018\u00010b\u00a2\u0006\u0004\bd\u0010eB\u001d\b\u0016\u0012\b\u0010c\u001a\u0004\u0018\u00010b\u0012\b\u0010g\u001a\u0004\u0018\u00010f\u00a2\u0006\u0004\bd\u0010hB%\b\u0016\u0012\b\u0010c\u001a\u0004\u0018\u00010b\u0012\b\u0010g\u001a\u0004\u0018\u00010f\u0012\u0006\u0010i\u001a\u00020\u0007\u00a2\u0006\u0004\bd\u0010jJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\t\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rJ\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u001e\u0010\u0015\u001a\u00020\u00052\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013J\u001e\u0010\u0016\u001a\u00020\u00052\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0014J\u000e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018J\b\u0010\u001c\u001a\u00020\u0007H\u0016J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0007H\u0016J\u0018\u0010!\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0016J\b\u0010\"\u001a\u00020\u0005H\u0016J\u0010\u0010%\u001a\n $*\u0004\u0018\u00010#0#H\u0016J\u0010\u0010(\u001a\u00020\f2\u0006\u0010'\u001a\u00020&H\u0016J\u0006\u0010)\u001a\u00020\u0005R\u0018\u0010,\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001b\u00101\u001a\u00020-8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010.\u001a\u0004\b/\u00100R\u001b\u00106\u001a\u0002028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u0010.\u001a\u0004\b4\u00105R\"\u0010;\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u00107\u001a\u0004\b\b\u00108\"\u0004\b9\u0010:R\u001b\u0010@\u001a\u00020<8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u0010.\u001a\u0004\b>\u0010?R.\u0010I\u001a\u0004\u0018\u00010A2\b\u0010B\u001a\u0004\u0018\u00010A8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR6\u0010P\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u0018\u0010S\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010U\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010RR$\u0010]\u001a\u0004\u0018\u00010V8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\"\u0010a\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b^\u00107\u001a\u0004\b_\u00108\"\u0004\b`\u0010:\u00a8\u0006l"}, d2 = {"Lcom/tencent/qqnt/aio/widget/SelectableTextView;", "Landroid/widget/TextView;", "Lnv3/a;", "", "outLocation", "", "r", "", HippyTKDListViewAdapter.X, "y", "p", "index", "", "Lnv3/b;", HippyNestedScrollComponent.PRIORITY_PARENT, "o", "j", "Ljava/util/ArrayList;", "Landroid/graphics/Rect;", "Lkotlin/collections/ArrayList;", "rects", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "b", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "contentLength", "color", "c", "startIndex", "endIndex", tl.h.F, "e", "", "kotlin.jvm.PlatformType", "a", "Landroid/view/MotionEvent;", "event", "onTouchEvent", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "d", "Lnv3/b;", "mSelectableParent", "Landroid/graphics/Paint;", "Lkotlin/Lazy;", "v", "()Landroid/graphics/Paint;", "mHighLightPaint", "Landroid/graphics/Path;", "f", "w", "()Landroid/graphics/Path;", "mHighLightPath", "Z", "()Z", "setMIsHighLight", "(Z)V", "mIsHighLight", "Lcom/tencent/qqnt/aio/widget/DoubleClickDetector;", "i", ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/qqnt/aio/widget/DoubleClickDetector;", "doubleClickDetector", "Lcom/tencent/qqnt/aio/widget/i;", "value", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/aio/widget/i;", "getOnDoubleClickListener", "()Lcom/tencent/qqnt/aio/widget/i;", "setOnDoubleClickListener", "(Lcom/tencent/qqnt/aio/widget/i;)V", "onDoubleClickListener", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "u", "()Ljava/util/ArrayList;", "setFontRect", "(Ljava/util/ArrayList;)V", "fontRect", "D", "[I", "xIndex", "E", "yIndex", "Ly03/c;", UserInfo.SEX_FEMALE, "Ly03/c;", "t", "()Ly03/c;", "setFontDrawable", "(Ly03/c;)V", "fontDrawable", "G", "getUseCustomLocationWithoutAnimScale", "setUseCustomLocationWithoutAnimScale", "useCustomLocationWithoutAnimScale", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "H", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public class SelectableTextView extends TextView implements nv3.a {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private ArrayList<Rect> fontRect;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private int[] xIndex;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private int[] yIndex;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private y03.c fontDrawable;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean useCustomLocationWithoutAnimScale;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private nv3.b mSelectableParent;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mHighLightPaint;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mHighLightPath;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mIsHighLight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy doubleClickDetector;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private i onDoubleClickListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/widget/SelectableTextView$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.widget.SelectableTextView$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48072);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 29)) {
            redirector.redirect((short) 29);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SelectableTextView(@Nullable Context context) {
        super(context);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        lazy = LazyKt__LazyJVMKt.lazy(SelectableTextView$mHighLightPaint$2.INSTANCE);
        this.mHighLightPaint = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(SelectableTextView$mHighLightPath$2.INSTANCE);
        this.mHighLightPath = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<DoubleClickDetector>() { // from class: com.tencent.qqnt.aio.widget.SelectableTextView$doubleClickDetector$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SelectableTextView.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final DoubleClickDetector invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new DoubleClickDetector(SelectableTextView.this) : (DoubleClickDetector) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.doubleClickDetector = lazy3;
    }

    private final int p(int x16, int y16) {
        nv3.b bVar = this.mSelectableParent;
        if (bVar == null) {
            return -1;
        }
        Intrinsics.checkNotNull(bVar);
        int k3 = bVar.k();
        if (k3 == -1) {
            if (QLog.isDevelopLevel()) {
                QLog.d("SelectableTextView", 4, "detectIndexByOffsetSpring backport to detectIndexByOffset");
            }
            return -1;
        }
        nv3.b bVar2 = this.mSelectableParent;
        Intrinsics.checkNotNull(bVar2);
        int[] n3 = bVar2.n();
        int i3 = n3[0];
        int i16 = n3[1];
        Layout layout = getLayout();
        if (layout == null) {
            return -1;
        }
        if (k3 != 1) {
            i3 = i16;
        }
        int lineForVertical = layout.getLineForVertical(y16);
        if (y(i3)) {
            int primaryHorizontal = (int) layout.getPrimaryHorizontal(i3 - 1);
            int lineRight = (int) layout.getLineRight(lineForVertical);
            if (x16 > lineRight - ((lineRight - primaryHorizontal) / 2)) {
                i3--;
            }
        }
        int lineForOffset = layout.getLineForOffset(i3);
        int lineTop = layout.getLineTop(lineForOffset);
        int lineBottom = layout.getLineBottom(lineForOffset);
        int i17 = (lineBottom - lineTop) / 2;
        if ((lineForVertical == lineForOffset + 1 && y16 - lineBottom < i17) || (lineForVertical == lineForOffset - 1 && lineTop - y16 < i17)) {
            lineForVertical = lineForOffset;
        }
        int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, x16);
        if (offsetForHorizontal < getText().length() - 1) {
            int i18 = offsetForHorizontal + 1;
            if (y(i18)) {
                int primaryHorizontal2 = (int) layout.getPrimaryHorizontal(offsetForHorizontal);
                int lineRight2 = (int) layout.getLineRight(lineForVertical);
                if (x16 > lineRight2 - ((lineRight2 - primaryHorizontal2) / 2)) {
                    return i18;
                }
            }
        }
        return offsetForHorizontal;
    }

    private final void r(int[] outLocation) {
        getLocationInWindow(outLocation);
        if (this.useCustomLocationWithoutAnimScale) {
            float f16 = 2;
            outLocation[0] = outLocation[0] + ((int) (((getMeasuredWidth() * getScaleX()) - getMeasuredWidth()) / f16));
            outLocation[1] = outLocation[1] + ((int) (((getMeasuredHeight() * getScaleY()) - getMeasuredHeight()) / f16));
        }
    }

    private final Paint v() {
        return (Paint) this.mHighLightPaint.getValue();
    }

    private final Path w() {
        return (Path) this.mHighLightPath.getValue();
    }

    private final boolean y(int index) {
        Layout layout = getLayout();
        if (layout != null) {
            if (index > 0 && layout.getLineForOffset(index) == layout.getLineForOffset(index - 1) + 1) {
                return true;
            }
            return false;
        }
        throw new RuntimeException("Has no layout.");
    }

    public final void A(@NotNull ArrayList<Rect> rects) {
        int[] intArray;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) rects);
            return;
        }
        Intrinsics.checkNotNullParameter(rects, "rects");
        ArrayList arrayList = new ArrayList();
        int size = rects.size() - 1;
        int i3 = 0;
        while (i3 < size) {
            Rect rect = rects.get(i3);
            Intrinsics.checkNotNullExpressionValue(rect, "rects[i]");
            Rect rect2 = rect;
            int i16 = rect2.left;
            if (i16 != 0 || i3 == 0) {
                arrayList.add(Integer.valueOf(i16));
            }
            i3++;
            if (rects.get(i3).left == 0) {
                arrayList.add(Integer.valueOf(rect2.right));
            }
        }
        arrayList.add(Integer.valueOf(rects.get(rects.size() - 1).left));
        arrayList.add(Integer.valueOf(rects.get(rects.size() - 1).right));
        intArray = CollectionsKt___CollectionsKt.toIntArray(arrayList);
        this.xIndex = intArray;
    }

    public final void B(@NotNull ArrayList<Rect> rects) {
        int[] intArray;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) rects);
            return;
        }
        Intrinsics.checkNotNullParameter(rects, "rects");
        ArrayList arrayList = new ArrayList();
        int size = rects.size();
        for (int i3 = 0; i3 < size; i3++) {
            Rect rect = rects.get(i3);
            Intrinsics.checkNotNullExpressionValue(rect, "rects[i]");
            Rect rect2 = rect;
            if (i3 == 0) {
                arrayList.add(Integer.valueOf(rect2.top));
            }
            if (rect2.left == 0) {
                arrayList.add(Integer.valueOf(rect2.bottom));
            }
        }
        intArray = CollectionsKt___CollectionsKt.toIntArray(arrayList);
        this.yIndex = intArray;
    }

    @Override // nv3.a
    public CharSequence a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (CharSequence) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return getText();
    }

    @Override // nv3.a
    public int b(int x16, int y16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, this, Integer.valueOf(x16), Integer.valueOf(y16))).intValue();
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        y03.c cVar = this.fontDrawable;
        if (cVar != null) {
            Intrinsics.checkNotNull(cVar);
            Integer b16 = cVar.b(x16 - iArr[0], y16 - iArr[1]);
            if (b16 != null) {
                return b16.intValue();
            }
        }
        return p((x16 - iArr[0]) - getPaddingLeft(), (y16 - iArr[1]) - getPaddingTop());
    }

    @Override // nv3.a
    public void c(int color) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, color);
        } else {
            v().setColor(color);
        }
    }

    @Override // nv3.a
    public int contentLength() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        return getText().length();
    }

    @Override // nv3.a
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
        } else {
            this.mIsHighLight = false;
            invalidate();
        }
    }

    @Override // nv3.a
    public void h(int startIndex, int endIndex) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Integer.valueOf(startIndex), Integer.valueOf(endIndex));
            return;
        }
        this.mIsHighLight = true;
        w().reset();
        if (this.fontDrawable != null && this.fontRect != null && this.xIndex != null && this.yIndex != null) {
            while (startIndex < endIndex) {
                ArrayList<Rect> arrayList = this.fontRect;
                Intrinsics.checkNotNull(arrayList);
                if (startIndex >= arrayList.size()) {
                    break;
                }
                ArrayList<Rect> arrayList2 = this.fontRect;
                Intrinsics.checkNotNull(arrayList2);
                Rect rect = arrayList2.get(startIndex);
                Intrinsics.checkNotNullExpressionValue(rect, "fontRect!![i]");
                Rect rect2 = rect;
                w().addRect(new RectF(rect2.left, rect2.top, rect2.right, rect2.bottom), Path.Direction.CW);
                startIndex++;
            }
        } else {
            r rVar = r.f352313a;
            CharSequence text = getText();
            Intrinsics.checkNotNullExpressionValue(text, "text");
            if (rVar.a(text)) {
                Layout layout = getLayout();
                if (layout != null) {
                    layout.getSelectionPath(startIndex, endIndex, w());
                }
            } else {
                QLog.d("SelectableTextView", 1, "current text cannot show: " + ((Object) getText()));
            }
        }
        invalidate();
    }

    @Override // nv3.a
    @NotNull
    public int[] j(int index) {
        int[] iArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (int[]) iPatchRedirector.redirect((short) 16, (Object) this, index);
        }
        int[] iArr2 = new int[2];
        int i3 = 0;
        if (getLayout() == null) {
            iArr2[0] = -1;
            iArr2[1] = -1;
        } else {
            r(iArr2);
            if (this.fontDrawable != null && this.fontRect != null && (iArr = this.xIndex) != null && this.yIndex != null) {
                Intrinsics.checkNotNull(iArr);
                if (index < iArr.length) {
                    int i16 = index - 1;
                    ArrayList<Rect> arrayList = this.fontRect;
                    Intrinsics.checkNotNull(arrayList);
                    if (i16 < arrayList.size() && index >= 0) {
                        int i17 = iArr2[0];
                        int[] iArr3 = this.xIndex;
                        Intrinsics.checkNotNull(iArr3);
                        iArr2[0] = i17 + iArr3[index] + getPaddingLeft();
                        int i18 = iArr2[1];
                        ArrayList<Rect> arrayList2 = this.fontRect;
                        Intrinsics.checkNotNull(arrayList2);
                        if (index != 0) {
                            i3 = i16;
                        }
                        iArr2[1] = i18 + arrayList2.get(i3).bottom + getPaddingTop();
                    }
                }
            }
            iArr2[0] = iArr2[0] + ((int) getLayout().getPrimaryHorizontal(index)) + getPaddingLeft();
            iArr2[1] = iArr2[1] + getLayout().getLineBottom(getLayout().getLineForOffset(index)) + getPaddingTop();
        }
        return iArr2;
    }

    public final void o(@NotNull nv3.b parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) parent);
        } else {
            Intrinsics.checkNotNullParameter(parent, "parent");
            this.mSelectableParent = parent;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.mIsHighLight) {
            q(canvas);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this, (Object) event)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(event, "event");
        if (s().j(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    public final void q(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.translate(getPaddingLeft(), getPaddingTop());
        canvas.drawPath(w(), v());
        canvas.translate(-getPaddingLeft(), -getPaddingTop());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final DoubleClickDetector s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (DoubleClickDetector) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return (DoubleClickDetector) this.doubleClickDetector.getValue();
    }

    public final void setFontDrawable(@Nullable y03.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) cVar);
        } else {
            this.fontDrawable = cVar;
        }
    }

    public final void setFontRect(@Nullable ArrayList<Rect> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) arrayList);
        } else {
            this.fontRect = arrayList;
        }
    }

    public final void setMIsHighLight(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.mIsHighLight = z16;
        }
    }

    public final void setOnDoubleClickListener(@Nullable i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) iVar);
        } else {
            s().k(iVar);
            this.onDoubleClickListener = iVar;
        }
    }

    public final void setUseCustomLocationWithoutAnimScale(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else {
            this.useCustomLocationWithoutAnimScale = z16;
        }
    }

    @Nullable
    public final y03.c t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (y03.c) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.fontDrawable;
    }

    @Nullable
    public final ArrayList<Rect> u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ArrayList) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.fontRect;
    }

    public final boolean x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.mIsHighLight;
    }

    public final void z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        i b16 = s().b();
        if (b16 != null) {
            i.a.a(b16, false, 1, null);
        }
    }

    public SelectableTextView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        lazy = LazyKt__LazyJVMKt.lazy(SelectableTextView$mHighLightPaint$2.INSTANCE);
        this.mHighLightPaint = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(SelectableTextView$mHighLightPath$2.INSTANCE);
        this.mHighLightPath = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<DoubleClickDetector>() { // from class: com.tencent.qqnt.aio.widget.SelectableTextView$doubleClickDetector$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SelectableTextView.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final DoubleClickDetector invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new DoubleClickDetector(SelectableTextView.this) : (DoubleClickDetector) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.doubleClickDetector = lazy3;
    }

    public SelectableTextView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        lazy = LazyKt__LazyJVMKt.lazy(SelectableTextView$mHighLightPaint$2.INSTANCE);
        this.mHighLightPaint = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(SelectableTextView$mHighLightPath$2.INSTANCE);
        this.mHighLightPath = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<DoubleClickDetector>() { // from class: com.tencent.qqnt.aio.widget.SelectableTextView$doubleClickDetector$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SelectableTextView.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final DoubleClickDetector invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new DoubleClickDetector(SelectableTextView.this) : (DoubleClickDetector) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.doubleClickDetector = lazy3;
    }
}
