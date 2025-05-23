package com.tencent.qqnt.aio.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticon.QQSysFaceSwitcher;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.vas.font.IFontManager;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.utils.k;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.stream.IntStream;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y03.AIOTextViewInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u00018B'\b\u0007\u0012\u0006\u00102\u001a\u000201\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000103\u0012\b\b\u0002\u00105\u001a\u00020\u0018\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u001c\u0010\f\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0015J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0014J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015H\u0015J\u0018\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0015J\u001c\u0010\u001d\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0018\u0010 \u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0018H\u0016J\u0012\u0010#\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\b\u0010$\u001a\u0004\u0018\u00010\u001cR$\u0010*\u001a\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010,R\u0014\u00100\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010/\u00a8\u00069"}, d2 = {"Lcom/tencent/qqnt/aio/widget/AIOMsgTextView;", "Lcom/tencent/qqnt/aio/widget/SelectableTextView;", "Landroid/view/View$OnClickListener;", "", "M", "", "text", "J", "Ly03/a;", "K", "Landroid/widget/TextView$BufferType;", "type", IECSearchBar.METHOD_SET_TEXT, "Landroid/graphics/drawable/Drawable;", "who", "", "verifyDrawable", "drawable", "invalidateDrawable", NodeProps.ON_DETACHED_FROM_WINDOW, "requestLayout", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "Ly03/c;", "setTextDrawable", HippyTKDListViewAdapter.X, "y", "scrollTo", "Landroid/view/View;", "p0", NodeProps.ON_CLICK, "L", "Ljava/util/ArrayList;", "Lov3/a;", "Lkotlin/collections/ArrayList;", "I", "Ljava/util/ArrayList;", "mTextViewProcessorList", "", "[I", "measureIntArray", "Lcom/tencent/qqnt/aio/utils/k;", "Lcom/tencent/qqnt/aio/utils/k;", "concurrentAccessMonitor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOMsgTextView extends SelectableTextView implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/AIO/text/aio_text_inject_config.yml")
    @NotNull
    private static final ArrayList<Class<ov3.a>> M;

    @NotNull
    private static final HashMap<String, WeakReference<Typeface>> N;

    @NotNull
    private static final Lazy<Boolean> P;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<ov3.a> mTextViewProcessorList;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private int[] measureIntArray;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final k concurrentAccessMonitor;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u001b\u0010\r\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR<\u0010\u0013\u001a*\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00110\u0010j\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0011`\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/aio/widget/AIOMsgTextView$a;", "", "", "ttfPath", "Landroid/graphics/Typeface;", "b", "c", "e", "", "aioInterceptScroll$delegate", "Lkotlin/Lazy;", "d", "()Z", "aioInterceptScroll", "TAG", "Ljava/lang/String;", "Ljava/util/HashMap;", "Ljava/lang/ref/WeakReference;", "Lkotlin/collections/HashMap;", "typefaceMap", "Ljava/util/HashMap;", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.widget.AIOMsgTextView$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        private final Typeface b(String ttfPath) {
            Typeface c16 = c(ttfPath);
            if (c16 != null) {
                AIOMsgTextView.N.put(ttfPath, new WeakReference(c16));
                return c16;
            }
            return null;
        }

        private final Typeface c(String ttfPath) {
            if (TextUtils.isEmpty(ttfPath) || !new File(ttfPath).exists()) {
                return null;
            }
            try {
                QLog.d("AIOMsgTextView", 1, "[createTypeface] path=" + ttfPath);
                return Typeface.createFromFile(ttfPath);
            } catch (Exception e16) {
                QLog.w("AIOMsgTextView", 1, "[createTypeface] fail, path=" + ttfPath + ", exc=" + e16);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean d() {
            return ((Boolean) AIOMsgTextView.P.getValue()).booleanValue();
        }

        @Nullable
        public final synchronized Typeface e(@Nullable String ttfPath) {
            boolean z16;
            Typeface typeface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Typeface) iPatchRedirector.redirect((short) 3, (Object) this, (Object) ttfPath);
            }
            if (ttfPath != null && ttfPath.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return null;
            }
            WeakReference weakReference = (WeakReference) AIOMsgTextView.N.get(ttfPath);
            if (weakReference != null && (typeface = (Typeface) weakReference.get()) != null) {
                return typeface;
            }
            return b(ttfPath);
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
        Lazy<Boolean> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48024);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
            return;
        }
        INSTANCE = new Companion(null);
        ArrayList<Class<ov3.a>> arrayList = new ArrayList<>();
        M = arrayList;
        arrayList.add(com.tencent.qqnt.emotion.text.processor.a.class);
        arrayList.add(com.tencent.qqnt.emotion.text.processor.a.class);
        N = new HashMap<>();
        lazy = LazyKt__LazyJVMKt.lazy(AIOMsgTextView$Companion$aioInterceptScroll$2.INSTANCE);
        P = lazy;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AIOMsgTextView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            return;
        }
        iPatchRedirector.redirect((short) 15, (Object) this, (Object) context);
    }

    private final void J(CharSequence text) {
        if (QQSysFaceSwitcher.f204652a.o() && text != null && text != getText()) {
            super.setText(text);
            Iterator<ov3.a> it = this.mTextViewProcessorList.iterator();
            while (it.hasNext()) {
                it.next().c(getText(), this);
            }
        }
    }

    private final AIOTextViewInfo K() {
        return new AIOTextViewInfo(getMaxWidth(), getMaxEms(), getMaxLines(), getMinWidth(), getMinHeight(), getMaxWidth(), new Rect(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom()));
    }

    private final void M() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder();
        Iterator<Class<ov3.a>> it = M.iterator();
        while (it.hasNext()) {
            try {
                this.mTextViewProcessorList.add(it.next().newInstance());
            } catch (IllegalAccessException e16) {
                sb5.append("initTextViewProcessor error! ");
                sb5.append(Log.getStackTraceString(e16));
                sb5.append("\n");
            } catch (InstantiationException e17) {
                sb5.append("initTextViewProcessor error! ");
                sb5.append(Log.getStackTraceString(e17));
                sb5.append("\n");
            }
        }
        if (sb5.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.e("AIOMsgTextView", 1, sb5.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(AIOMsgTextView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.requestLayout();
    }

    public static /* synthetic */ void setTextDrawable$default(AIOMsgTextView aIOMsgTextView, y03.c cVar, CharSequence charSequence, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            charSequence = null;
        }
        aIOMsgTextView.setTextDrawable(cVar, charSequence);
    }

    @Nullable
    public final y03.c L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (y03.c) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return t();
    }

    @Override // android.widget.TextView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NotNull Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) drawable);
            return;
        }
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (drawable instanceof y03.c) {
            invalidate();
            return;
        }
        super.invalidateDrawable(drawable);
        Iterator<ov3.a> it = this.mTextViewProcessorList.iterator();
        while (it.hasNext()) {
            it.next().d(drawable);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View p06) {
        EventCollector.getInstance().onViewClickedBefore(p06);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) p06);
        } else {
            y03.c t16 = t();
            if (t16 != null) {
                t16.o();
            }
        }
        EventCollector.getInstance().onViewClicked(p06);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onDetachedFromWindow();
        Iterator<ov3.a> it = this.mTextViewProcessorList.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    @Override // com.tencent.qqnt.aio.widget.SelectableTextView, android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(@NotNull Canvas canvas) {
        String str;
        IntStream chars;
        int[] array;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (t() == null) {
            try {
                super.onDraw(canvas);
                return;
            } catch (IndexOutOfBoundsException e16) {
                if (Build.VERSION.SDK_INT >= 24) {
                    chars = getText().chars();
                    array = chars.toArray();
                    Intrinsics.checkNotNullExpressionValue(array, "text.chars().toArray()");
                    str = ArraysKt___ArraysKt.joinToString$default(array, (CharSequence) " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) AIOMsgTextView$onDraw$1.INSTANCE, 30, (Object) null);
                } else {
                    str = "";
                }
                CharSequence text = getText();
                throw new RuntimeException("text: " + ((Object) text) + " chars: " + str + " isMainThread: " + Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) + " " + e16);
            }
        }
        if (x()) {
            q(canvas);
        }
        y03.c t16 = t();
        Intrinsics.checkNotNull(t16);
        t16.j(new Rect(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom()));
        y03.c t17 = t();
        Intrinsics.checkNotNull(t17);
        IFontManager.DrawableResultInfo e17 = t17.e(canvas);
        if (e17.getDrawFont()) {
            y03.c t18 = t();
            Intrinsics.checkNotNull(t18);
            ArrayList<Rect> a16 = t18.a();
            if (a16 != null) {
                if (u() == null || !Intrinsics.areEqual(u(), a16)) {
                    setFontRect(a16);
                    ArrayList<Rect> u16 = u();
                    Intrinsics.checkNotNull(u16);
                    A(u16);
                    ArrayList<Rect> u17 = u();
                    Intrinsics.checkNotNull(u17);
                    B(u17);
                    return;
                }
                return;
            }
            return;
        }
        super.onDraw(canvas);
        if (e17.getHasTextColor()) {
            setTextColor(e17.getTextColor());
        }
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(final int widthMeasureSpec, final int heightMeasureSpec) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(widthMeasureSpec), Integer.valueOf(heightMeasureSpec));
        } else {
            this.concurrentAccessMonitor.a(new Function0<Unit>(widthMeasureSpec, heightMeasureSpec) { // from class: com.tencent.qqnt.aio.widget.AIOMsgTextView$onMeasure$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $heightMeasureSpec;
                final /* synthetic */ int $widthMeasureSpec;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$widthMeasureSpec = widthMeasureSpec;
                    this.$heightMeasureSpec = heightMeasureSpec;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, AIOMsgTextView.this, Integer.valueOf(widthMeasureSpec), Integer.valueOf(heightMeasureSpec));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    String str;
                    IntStream chars;
                    int[] array;
                    int[] iArr;
                    int i3;
                    int[] iArr2;
                    int[] iArr3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        if (AIOMsgTextView.this.t() == null) {
                            super/*android.widget.TextView*/.onMeasure(this.$widthMeasureSpec, this.$heightMeasureSpec);
                            return;
                        }
                        y03.c t16 = AIOMsgTextView.this.t();
                        Intrinsics.checkNotNull(t16);
                        t16.j(new Rect(AIOMsgTextView.this.getPaddingLeft(), AIOMsgTextView.this.getPaddingTop(), AIOMsgTextView.this.getPaddingRight(), AIOMsgTextView.this.getPaddingBottom()));
                        iArr = AIOMsgTextView.this.measureIntArray;
                        if (iArr != null) {
                            AIOMsgTextView aIOMsgTextView = AIOMsgTextView.this;
                            iArr2 = aIOMsgTextView.measureIntArray;
                            Intrinsics.checkNotNull(iArr2);
                            int i16 = iArr2[0];
                            iArr3 = AIOMsgTextView.this.measureIntArray;
                            Intrinsics.checkNotNull(iArr3);
                            aIOMsgTextView.setMeasuredDimension(i16, iArr3[1]);
                            return;
                        }
                        y03.c t17 = AIOMsgTextView.this.t();
                        Intrinsics.checkNotNull(t17);
                        int[] q16 = t17.q(this.$widthMeasureSpec, this.$heightMeasureSpec);
                        if (q16 == null) {
                            super/*android.widget.TextView*/.onMeasure(this.$widthMeasureSpec, this.$heightMeasureSpec);
                            return;
                        }
                        int i17 = this.$widthMeasureSpec;
                        int i18 = this.$heightMeasureSpec;
                        AIOMsgTextView aIOMsgTextView2 = AIOMsgTextView.this;
                        int i19 = q16[0];
                        if (i17 != i19 || i18 != (i3 = q16[1])) {
                            aIOMsgTextView2.setMeasuredDimension(i19, q16[1]);
                            aIOMsgTextView2.measureIntArray = q16;
                        } else {
                            super/*android.widget.TextView*/.onMeasure(i19, i3);
                        }
                    } catch (Exception e16) {
                        if (Build.VERSION.SDK_INT >= 24) {
                            chars = AIOMsgTextView.this.getText().chars();
                            array = chars.toArray();
                            Intrinsics.checkNotNullExpressionValue(array, "text.chars().toArray()");
                            str = ArraysKt___ArraysKt.joinToString$default(array, (CharSequence) " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) AnonymousClass2.INSTANCE, 30, (Object) null);
                        } else {
                            str = "";
                        }
                        QLog.i("AIOMsgTextView", 1, "[onMeasure] " + ((Object) AIOMsgTextView.this.getText()) + " chars: " + str + " exc=" + e16);
                        throw new RuntimeException("measure exception: " + ((Object) AIOMsgTextView.this.getText()) + " chars: " + str + " exc=" + e16, e16);
                    }
                }
            });
        }
    }

    @Override // android.view.View
    public void requestLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        ArrayList<ov3.a> arrayList = this.mTextViewProcessorList;
        if (arrayList != null) {
            Iterator<ov3.a> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().a()) {
                    return;
                }
            }
        }
        super.requestLayout();
    }

    @Override // android.view.View
    public void scrollTo(int x16, int y16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(x16), Integer.valueOf(y16));
            return;
        }
        if (QLog.isColorLevel() && y16 > 0) {
            QLog.d("AIOMsgTextView", 1, "scrollTo: " + y16, new Throwable());
        }
        if (INSTANCE.d() && y16 > 0) {
            super.scrollTo(x16, 0);
        } else {
            super.scrollTo(x16, y16);
        }
    }

    @Override // android.widget.TextView
    public void setText(@Nullable CharSequence text, @Nullable TextView.BufferType type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) text, (Object) type);
            return;
        }
        CharSequence text2 = getText();
        super.setText(text, type);
        if (!Intrinsics.areEqual(text2, text)) {
            Iterator<ov3.a> it = this.mTextViewProcessorList.iterator();
            while (it.hasNext()) {
                it.next().c(getText(), this);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setTextDrawable(@Nullable y03.c drawable, @Nullable CharSequence text) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) drawable, (Object) text);
            return;
        }
        boolean z16 = false;
        if (drawable != 0 && drawable.t()) {
            z16 = true;
        }
        String str = null;
        if (z16) {
            setFontDrawable(drawable);
            J(text);
            this.measureIntArray = null;
            if (drawable instanceof Drawable) {
                ((Drawable) drawable).setCallback(this);
            }
            final AIOTextViewInfo K = K();
            drawable.setLoadedListener(new Function1<y03.c, Unit>() { // from class: com.tencent.qqnt.aio.widget.AIOMsgTextView$setTextDrawable$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOTextViewInfo.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(y03.c cVar) {
                    invoke2(cVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull y03.c it) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    } else {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.f(AIOTextViewInfo.this);
                    }
                }
            });
            setOnClickListener(this);
            s().l(t());
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.aio.widget.e
                @Override // java.lang.Runnable
                public final void run() {
                    AIOMsgTextView.N(AIOMsgTextView.this);
                }
            });
            return;
        }
        setFontDrawable(null);
        s().l(null);
        this.measureIntArray = null;
        Companion companion = INSTANCE;
        if (drawable != 0) {
            str = drawable.n();
        }
        setTypeface(companion.e(str));
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"MissingSuperCall"})
    protected boolean verifyDrawable(@NotNull Drawable who) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) who)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(who, "who");
        return true;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AIOMsgTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            return;
        }
        iPatchRedirector.redirect((short) 14, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ AIOMsgTextView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AIOMsgTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mTextViewProcessorList = new ArrayList<>();
        this.concurrentAccessMonitor = new k();
        M();
    }
}
