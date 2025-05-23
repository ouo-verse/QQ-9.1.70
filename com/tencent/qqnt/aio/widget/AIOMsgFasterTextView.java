package com.tencent.qqnt.aio.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.vas.font.IFontManager;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y03.AIOTextViewInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00013B'\b\u0007\u0012\u0006\u0010,\u001a\u00020+\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-\u0012\b\b\u0002\u0010/\u001a\u00020\u0017\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u001c\u0010\u000b\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0015J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0014J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0015J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0015J\u0010\u0010\u001c\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u001bJ\u0012\u0010\u001f\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010 \u001a\u0004\u0018\u00010\u001bR$\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\"0!j\b\u0012\u0004\u0012\u00020\"`#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u00064"}, d2 = {"Lcom/tencent/qqnt/aio/widget/AIOMsgFasterTextView;", "Lcom/tencent/qqnt/aio/widget/SelectableFasterTextView;", "Landroid/view/View$OnClickListener;", "", "E", "Ly03/a;", BdhLogUtil.LogTag.Tag_Conn, "", "text", "Landroid/widget/TextView$BufferType;", "type", IECSearchBar.METHOD_SET_TEXT, "Landroid/graphics/drawable/Drawable;", "who", "", "verifyDrawable", "drawable", "invalidateDrawable", NodeProps.ON_DETACHED_FROM_WINDOW, "requestLayout", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "Ly03/c;", "setTextDrawable", "Landroid/view/View;", "p0", NodeProps.ON_CLICK, "D", "Ljava/util/ArrayList;", "Lov3/a;", "Lkotlin/collections/ArrayList;", "H", "Ljava/util/ArrayList;", "mTextViewProcessorList", "", "I", "[I", "measureIntArray", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "J", "a", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOMsgFasterTextView extends SelectableFasterTextView implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/AIO/text/aio_text_inject_config.yml")
    @NotNull
    private static final ArrayList<Class<ov3.a>> K;

    @NotNull
    private static final HashMap<String, Typeface> L;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<ov3.a> mTextViewProcessorList;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private int[] measureIntArray;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR4\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\tj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/aio/widget/AIOMsgFasterTextView$a;", "", "", "ttfPath", "Landroid/graphics/Typeface;", "a", "b", "TAG", "Ljava/lang/String;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "typefaceMap", "Ljava/util/HashMap;", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.widget.AIOMsgFasterTextView$a, reason: from kotlin metadata */
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

        private final Typeface a(String ttfPath) {
            Typeface typeface;
            if (!TextUtils.isEmpty(ttfPath) && new File(ttfPath).exists()) {
                typeface = Typeface.createFromFile(ttfPath);
            } else {
                typeface = null;
            }
            AIOMsgFasterTextView.L.put(ttfPath, typeface);
            return typeface;
        }

        @Nullable
        public final synchronized Typeface b(@Nullable String ttfPath) {
            boolean z16;
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
            if (AIOMsgFasterTextView.L.containsKey(ttfPath)) {
                return (Typeface) AIOMsgFasterTextView.L.get(ttfPath);
            }
            return a(ttfPath);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47978);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
            return;
        }
        INSTANCE = new Companion(null);
        ArrayList<Class<ov3.a>> arrayList = new ArrayList<>();
        K = arrayList;
        arrayList.add(com.tencent.qqnt.emotion.text.processor.a.class);
        arrayList.add(com.tencent.qqnt.emotion.text.processor.a.class);
        L = new HashMap<>();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AIOMsgFasterTextView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            return;
        }
        iPatchRedirector.redirect((short) 14, (Object) this, (Object) context);
    }

    private final AIOTextViewInfo C() {
        return new AIOTextViewInfo(getMaxWidth(), getMaxEms(), getMaxLines(), getMinWidth(), getMinHeight(), getMaxWidth(), new Rect(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom()));
    }

    private final void E() {
        QLog.e("AIOMsgFasterTextView", 1, "initTextViewProcessor");
        Iterator<Class<ov3.a>> it = K.iterator();
        while (it.hasNext()) {
            Class<ov3.a> next = it.next();
            try {
                this.mTextViewProcessorList.add(next.newInstance());
            } catch (IllegalAccessException e16) {
                QLog.e("AIOMsgFasterTextView", 1, "initTextViewProcessor error! ", e16);
            } catch (InstantiationException e17) {
                QLog.e("AIOMsgFasterTextView", 1, "initTextViewProcessor error! ", e17);
            }
            QLog.e("AIOMsgFasterTextView", 1, "initTextViewProcessor " + next.getCanonicalName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(AIOMsgFasterTextView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.requestLayout();
    }

    @Nullable
    public final y03.c D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (y03.c) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return s();
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) p06);
        } else {
            y03.c s16 = s();
            if (s16 != null) {
                s16.o();
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.aio.widget.SelectableFasterTextView, android.widget.FasterTextView, android.widget.WrappedTextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (s() == null) {
            super.onDraw(canvas);
            return;
        }
        if (w()) {
            q(canvas);
        }
        y03.c s16 = s();
        Intrinsics.checkNotNull(s16);
        s16.j(new Rect(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom()));
        y03.c s17 = s();
        Intrinsics.checkNotNull(s17);
        IFontManager.DrawableResultInfo e16 = s17.e(canvas);
        if (e16.getDrawFont()) {
            y03.c s18 = s();
            Intrinsics.checkNotNull(s18);
            ArrayList<Rect> a16 = s18.a();
            if (a16 != null) {
                if (t() == null || !Intrinsics.areEqual(t(), a16)) {
                    setFontRect(a16);
                    ArrayList<Rect> t16 = t();
                    Intrinsics.checkNotNull(t16);
                    y(t16);
                    ArrayList<Rect> t17 = t();
                    Intrinsics.checkNotNull(t17);
                    z(t17);
                    return;
                }
                return;
            }
            return;
        }
        super.onDraw(canvas);
        if (e16.getHasTextColor()) {
            setTextColor(e16.getTextColor());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FasterTextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(widthMeasureSpec), Integer.valueOf(heightMeasureSpec));
            return;
        }
        if (s() == null) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        y03.c s16 = s();
        Intrinsics.checkNotNull(s16);
        s16.j(new Rect(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom()));
        int[] iArr = this.measureIntArray;
        if (iArr != null) {
            Intrinsics.checkNotNull(iArr);
            int i16 = iArr[0];
            int[] iArr2 = this.measureIntArray;
            Intrinsics.checkNotNull(iArr2);
            setMeasuredDimension(i16, iArr2[1]);
            return;
        }
        y03.c s17 = s();
        Intrinsics.checkNotNull(s17);
        int[] q16 = s17.q(widthMeasureSpec, heightMeasureSpec);
        if (q16 != null) {
            int i17 = q16[0];
            if (widthMeasureSpec == i17 && heightMeasureSpec == (i3 = q16[1])) {
                super.onMeasure(i17, i3);
                return;
            } else {
                setMeasuredDimension(i17, q16[1]);
                this.measureIntArray = q16;
                return;
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
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

    @Override // android.widget.FasterTextView, android.widget.WrappedTextView
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
    public final void setTextDrawable(@Nullable y03.c drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) drawable);
            return;
        }
        boolean z16 = false;
        if (drawable != 0 && drawable.t()) {
            z16 = true;
        }
        String str = null;
        if (z16) {
            setFontDrawable(drawable);
            this.measureIntArray = null;
            if (drawable instanceof Drawable) {
                ((Drawable) drawable).setCallback(this);
            }
            final AIOTextViewInfo C = C();
            drawable.setLoadedListener(new Function1<y03.c, Unit>() { // from class: com.tencent.qqnt.aio.widget.AIOMsgFasterTextView$setTextDrawable$1
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
            r().l(s());
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.aio.widget.c
                @Override // java.lang.Runnable
                public final void run() {
                    AIOMsgFasterTextView.F(AIOMsgFasterTextView.this);
                }
            });
            return;
        }
        setFontDrawable(null);
        r().l(null);
        this.measureIntArray = null;
        Companion companion = INSTANCE;
        if (drawable != 0) {
            str = drawable.n();
        }
        setTypeface(companion.b(str));
    }

    @Override // android.view.View
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
    public AIOMsgFasterTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            return;
        }
        iPatchRedirector.redirect((short) 13, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ AIOMsgFasterTextView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AIOMsgFasterTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.mTextViewProcessorList = new ArrayList<>();
            E();
        }
    }
}
