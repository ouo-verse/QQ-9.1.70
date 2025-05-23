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
import android.widget.FasterTextView;
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
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 d2\u00020\u00012\u00020\u0002:\u0001\"B\u0013\b\u0016\u0012\b\u0010\\\u001a\u0004\u0018\u00010[\u00a2\u0006\u0004\b]\u0010^B\u001d\b\u0016\u0012\b\u0010\\\u001a\u0004\u0018\u00010[\u0012\b\u0010`\u001a\u0004\u0018\u00010_\u00a2\u0006\u0004\b]\u0010aB%\b\u0016\u0012\b\u0010\\\u001a\u0004\u0018\u00010[\u0012\b\u0010`\u001a\u0004\u0018\u00010_\u0012\u0006\u0010b\u001a\u00020\u0003\u00a2\u0006\u0004\b]\u0010cJ\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\u0004\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u001e\u0010\u0005\u001a\u00020\u000b2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011J\u001e\u0010\u0013\u001a\u00020\u000b2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0014J\u000e\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0003H\u0016J\u0018\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003H\u0016J\b\u0010\u001f\u001a\u00020\u000bH\u0016J\u0010\u0010\"\u001a\n !*\u0004\u0018\u00010 0 H\u0016J\u0010\u0010%\u001a\u00020\b2\u0006\u0010$\u001a\u00020#H\u0016R\u0018\u0010(\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001b\u0010-\u001a\u00020)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010*\u001a\u0004\b+\u0010,R\u001b\u00102\u001a\u00020.8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u0010*\u001a\u0004\b0\u00101R\"\u00108\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001b\u0010=\u001a\u0002098DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u0010*\u001a\u0004\b;\u0010<R.\u0010F\u001a\u0004\u0018\u00010>2\b\u0010?\u001a\u0004\u0018\u00010>8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER6\u0010M\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0018\u0010P\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010R\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010OR$\u0010Z\u001a\u0004\u0018\u00010S8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010Y\u00a8\u0006e"}, d2 = {"Lcom/tencent/qqnt/aio/widget/SelectableFasterTextView;", "Landroid/widget/FasterTextView;", "Lnv3/a;", "", HippyTKDListViewAdapter.X, "y", "p", "index", "", "Lnv3/b;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "o", "", "j", "Ljava/util/ArrayList;", "Landroid/graphics/Rect;", "Lkotlin/collections/ArrayList;", "rects", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "b", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "contentLength", "color", "c", "startIndex", "endIndex", tl.h.F, "e", "", "kotlin.jvm.PlatformType", "a", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "d", "Lnv3/b;", "mSelectableParent", "Landroid/graphics/Paint;", "Lkotlin/Lazy;", "u", "()Landroid/graphics/Paint;", "mHighLightPaint", "Landroid/graphics/Path;", "f", "v", "()Landroid/graphics/Path;", "mHighLightPath", "Z", "w", "()Z", "setMIsHighLight", "(Z)V", "mIsHighLight", "Lcom/tencent/qqnt/aio/widget/DoubleClickDetector;", "i", "r", "()Lcom/tencent/qqnt/aio/widget/DoubleClickDetector;", "doubleClickDetector", "Lcom/tencent/qqnt/aio/widget/i;", "value", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/aio/widget/i;", "getOnDoubleClickListener", "()Lcom/tencent/qqnt/aio/widget/i;", "setOnDoubleClickListener", "(Lcom/tencent/qqnt/aio/widget/i;)V", "onDoubleClickListener", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "t", "()Ljava/util/ArrayList;", "setFontRect", "(Ljava/util/ArrayList;)V", "fontRect", "D", "[I", "xIndex", "E", "yIndex", "Ly03/c;", UserInfo.SEX_FEMALE, "Ly03/c;", ReportConstant.COSTREPORT_PREFIX, "()Ly03/c;", "setFontDrawable", "(Ly03/c;)V", "fontDrawable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "G", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public class SelectableFasterTextView extends FasterTextView implements nv3.a {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/widget/SelectableFasterTextView$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.widget.SelectableFasterTextView$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48060);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 26)) {
            redirector.redirect((short) 26);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SelectableFasterTextView(@Nullable Context context) {
        super(context);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        lazy = LazyKt__LazyJVMKt.lazy(SelectableFasterTextView$mHighLightPaint$2.INSTANCE);
        this.mHighLightPaint = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(SelectableFasterTextView$mHighLightPath$2.INSTANCE);
        this.mHighLightPath = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<DoubleClickDetector>() { // from class: com.tencent.qqnt.aio.widget.SelectableFasterTextView$doubleClickDetector$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SelectableFasterTextView.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final DoubleClickDetector invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new DoubleClickDetector(SelectableFasterTextView.this) : (DoubleClickDetector) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.doubleClickDetector = lazy3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x009c, code lost:
    
        if (r11 > (r5 - ((r5 - r4) / 2))) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int p(int x16, int y16) {
        nv3.b bVar = this.mSelectableParent;
        int i3 = -1;
        if (bVar == null) {
            return -1;
        }
        Intrinsics.checkNotNull(bVar);
        int k3 = bVar.k();
        if (k3 == -1) {
            if (QLog.isColorLevel()) {
                QLog.d("AnimationTextView", 2, "detectIndexByOffsetSpring backport to detectIndexByOffset");
            }
            return -1;
        }
        nv3.b bVar2 = this.mSelectableParent;
        Intrinsics.checkNotNull(bVar2);
        int[] n3 = bVar2.n();
        int i16 = n3[0];
        int i17 = n3[1];
        Layout layout = getLayout();
        if (layout != null) {
            if (k3 != 1) {
                i16 = i17;
            }
            int lineForVertical = layout.getLineForVertical(y16);
            if (x(i16)) {
                int primaryHorizontal = (int) layout.getPrimaryHorizontal(i16 - 1);
                int lineRight = (int) layout.getLineRight(lineForVertical);
                if (x16 > lineRight - ((lineRight - primaryHorizontal) / 2)) {
                    i16--;
                }
            }
            int lineForOffset = layout.getLineForOffset(i16);
            int lineTop = layout.getLineTop(lineForOffset);
            int lineBottom = layout.getLineBottom(lineForOffset);
            int i18 = (lineBottom - lineTop) / 2;
            if ((lineForVertical == lineForOffset + 1 && y16 - lineBottom < i18) || (lineForVertical == lineForOffset - 1 && lineTop - y16 < i18)) {
                lineForVertical = lineForOffset;
            }
            int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, x16);
            if (offsetForHorizontal < getText().length() - 1) {
                i3 = offsetForHorizontal + 1;
                if (x(i3)) {
                    int primaryHorizontal2 = (int) layout.getPrimaryHorizontal(offsetForHorizontal);
                    int lineRight2 = (int) layout.getLineRight(lineForVertical);
                }
            }
            i3 = offsetForHorizontal;
            QLog.i("AnimationTextView", 1, "line is " + lineForVertical + ", index is " + i3);
        }
        return i3;
    }

    private final Paint u() {
        return (Paint) this.mHighLightPaint.getValue();
    }

    private final Path v() {
        return (Path) this.mHighLightPath.getValue();
    }

    private final boolean x(int index) {
        Layout layout = getLayout();
        if (layout != null) {
            if (index > 0 && layout.getLineForOffset(index) == layout.getLineForOffset(index - 1) + 1) {
                return true;
            }
            return false;
        }
        throw new RuntimeException("Has no layout.");
    }

    @Override // nv3.a
    public CharSequence a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (CharSequence) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return getText();
    }

    @Override // nv3.a
    public int b(int x16, int y16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, this, Integer.valueOf(x16), Integer.valueOf(y16))).intValue();
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, color);
        } else {
            u().setColor(color);
        }
    }

    @Override // nv3.a
    public int contentLength() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return getText().length();
    }

    @Override // nv3.a
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        } else {
            this.mIsHighLight = false;
            invalidate();
        }
    }

    @Override // nv3.a
    public void h(int startIndex, int endIndex) {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Integer.valueOf(startIndex), Integer.valueOf(endIndex));
            return;
        }
        this.mIsHighLight = true;
        v().reset();
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
                v().addRect(new RectF(rect2.left, rect2.top, rect2.right, rect2.bottom), Path.Direction.CW);
                startIndex++;
            }
        } else {
            Layout layout = getLayout();
            if (layout != null) {
                layout.getSelectionPath(startIndex, endIndex, v());
            }
        }
        if (QLog.isDevelopLevel()) {
            Layout layout2 = getLayout();
            Integer num2 = null;
            if (layout2 != null) {
                num = Integer.valueOf(layout2.getLineBottom(0));
            } else {
                num = null;
            }
            Layout layout3 = getLayout();
            if (layout3 != null) {
                num2 = Integer.valueOf(layout3.getLineTop(0));
            }
            QLog.d("SelectableTextView", 4, "LineBottom " + num + " LineTop " + num2);
        }
        invalidate();
    }

    @Override // nv3.a
    @NotNull
    public int[] j(int index) {
        int[] iArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (int[]) iPatchRedirector.redirect((short) 14, (Object) this, index);
        }
        int[] iArr2 = new int[2];
        int i3 = 0;
        if (getLayout() == null) {
            iArr2[0] = -1;
            iArr2[1] = -1;
        } else {
            getLocationInWindow(iArr2);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) parent);
        } else {
            Intrinsics.checkNotNullParameter(parent, "parent");
            this.mSelectableParent = parent;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FasterTextView, android.widget.WrappedTextView, android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.mIsHighLight) {
            q(canvas);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.FasterTextView, android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, (Object) event)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(event, "event");
        if (r().j(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    public final void q(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.translate(getPaddingLeft(), getPaddingTop());
        canvas.drawPath(v(), u());
        canvas.translate(-getPaddingLeft(), -getPaddingTop());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final DoubleClickDetector r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (DoubleClickDetector) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return (DoubleClickDetector) this.doubleClickDetector.getValue();
    }

    @Nullable
    public final y03.c s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (y03.c) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.fontDrawable;
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
            r().k(iVar);
            this.onDoubleClickListener = iVar;
        }
    }

    @Nullable
    public final ArrayList<Rect> t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ArrayList) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.fontRect;
    }

    public final boolean w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.mIsHighLight;
    }

    public final void y(@NotNull ArrayList<Rect> rects) {
        int[] intArray;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) rects);
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

    public final void z(@NotNull ArrayList<Rect> rects) {
        int[] intArray;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) rects);
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

    public SelectableFasterTextView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        lazy = LazyKt__LazyJVMKt.lazy(SelectableFasterTextView$mHighLightPaint$2.INSTANCE);
        this.mHighLightPaint = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(SelectableFasterTextView$mHighLightPath$2.INSTANCE);
        this.mHighLightPath = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<DoubleClickDetector>() { // from class: com.tencent.qqnt.aio.widget.SelectableFasterTextView$doubleClickDetector$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SelectableFasterTextView.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final DoubleClickDetector invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new DoubleClickDetector(SelectableFasterTextView.this) : (DoubleClickDetector) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.doubleClickDetector = lazy3;
    }

    public SelectableFasterTextView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        lazy = LazyKt__LazyJVMKt.lazy(SelectableFasterTextView$mHighLightPaint$2.INSTANCE);
        this.mHighLightPaint = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(SelectableFasterTextView$mHighLightPath$2.INSTANCE);
        this.mHighLightPath = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<DoubleClickDetector>() { // from class: com.tencent.qqnt.aio.widget.SelectableFasterTextView$doubleClickDetector$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SelectableFasterTextView.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final DoubleClickDetector invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new DoubleClickDetector(SelectableFasterTextView.this) : (DoubleClickDetector) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.doubleClickDetector = lazy3;
    }
}
