package com.tencent.mobileqq.guild.aisearch.views;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.URLSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.android.androidbypass.codeblock.span.CodeBlockSpan;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bv;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.guild.util.s;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import se1.b;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 K2\u00020\u0001:\u0001LB'\b\u0007\u0012\u0006\u00100\u001a\u00020/\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010F\u0012\b\b\u0002\u0010H\u001a\u00020\u000b\u00a2\u0006\u0004\bI\u0010JJ\u001c\u0010\b\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001c\u0010\n\u001a\u00020\u0007*\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0007H\u0002J\b\u0010\u0016\u001a\u00020\u0007H\u0014J\u0006\u0010\u0017\u001a\u00020\u000eJ\b\u0010\u0018\u001a\u00020\u0007H\u0014J\u0018\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000bH\u0014J\u001c\u0010\u001f\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u000bH\u0016J\u0018\u0010$\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u000bH\u0014J0\u0010+\u001a\u00020\u00072\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000bH\u0014J\u0012\u0010.\u001a\u00020\u00072\b\u0010-\u001a\u0004\u0018\u00010,H\u0014J\u001e\u00103\u001a\u00020\u000b2\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000bR\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u00109\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00108R\u0018\u0010;\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010:R\u0016\u0010>\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u001d\u0010E\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u0002040C8F\u00a2\u0006\u0006\u001a\u0004\b5\u0010D\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/views/AIReplyView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/text/style/URLSpan;", "Landroid/text/SpannableStringBuilder;", "copyText", "Landroid/text/Spannable;", "originSpan", "", "f", "Lcom/tencent/android/androidbypass/codeblock/span/CodeBlockSpan;", "e", "", "selectionStart", "selectionEnd", "", "g", "Landroid/view/View;", "view", "k", "Landroidx/recyclerview/widget/RecyclerView;", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, NodeProps.ON_ATTACHED_TO_WINDOW, "j", NodeProps.ON_DETACHED_FROM_WINDOW, "selStart", "selEnd", "onSelectionChanged", "text", "Landroid/widget/TextView$BufferType;", "type", IECSearchBar.METHOD_SET_TEXT, "color", "setHighlightColor", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "", "changed", "left", "top", "right", "bottom", "onLayout", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "Landroid/content/Context;", "context", "colorResId", c.f123400v, "i", "", h.F, "Ljava/lang/String;", "scene", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Ljava/lang/CharSequence;", "originSpanBuilder", BdhLogUtil.LogTag.Tag_Conn, "Z", "reachLastLine", "Lse1/b;", "D", "Lse1/b;", "reporter", "", "()Ljava/util/Map;", "attr", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "E", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class AIReplyView extends AppCompatTextView {
    private static final int F = (int) cw.c(120.0f);
    private static final int G = (int) cw.c(40.0f);

    /* renamed from: C, reason: from kotlin metadata */
    private boolean reachLastLine;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final b reporter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String scene;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView recyclerView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CharSequence originSpanBuilder;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AIReplyView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void e(CodeBlockSpan codeBlockSpan, SpannableStringBuilder spannableStringBuilder, Spannable spannable) {
        spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(codeBlockSpan), spannableStringBuilder.getSpanEnd(codeBlockSpan), codeBlockSpan.m().c());
    }

    private final void f(URLSpan uRLSpan, SpannableStringBuilder spannableStringBuilder, Spannable spannable) {
        if (spannable.getSpanEnd(uRLSpan) - spannable.getSpanStart(uRLSpan) == spannableStringBuilder.getSpanEnd(uRLSpan) - spannableStringBuilder.getSpanStart(uRLSpan)) {
            spannableStringBuilder.insert(spannableStringBuilder.getSpanEnd(uRLSpan), (CharSequence) ("(" + uRLSpan.getURL() + " )"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CharSequence g(Spannable originSpan, int selectionStart, int selectionEnd) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(originSpan);
        spannableStringBuilder.delete(0, selectionStart);
        Object[] spans = originSpan.getSpans(selectionStart, selectionEnd, Object.class);
        if (spans != null) {
            spannableStringBuilder.delete(selectionEnd - selectionStart, spannableStringBuilder.length());
            for (Object sp5 : spans) {
                if (sp5 instanceof URLSpan) {
                    Intrinsics.checkNotNullExpressionValue(sp5, "sp");
                    f((URLSpan) sp5, spannableStringBuilder, originSpan);
                } else if (sp5 instanceof CodeBlockSpan) {
                    Intrinsics.checkNotNullExpressionValue(sp5, "sp");
                    e((CodeBlockSpan) sp5, spannableStringBuilder, originSpan);
                }
            }
        }
        return spannableStringBuilder;
    }

    private final int k(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i3;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        int i16 = 0;
        if (marginLayoutParams != null) {
            i3 = marginLayoutParams.leftMargin;
        } else {
            i3 = 0;
        }
        if (marginLayoutParams != null) {
            i16 = marginLayoutParams.rightMargin;
        }
        int paddingLeft = view.getPaddingLeft() + view.getPaddingRight();
        int i17 = i3 + i16;
        View view2 = (View) view.getParent();
        while (view2 != null && (view2 instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view2;
            paddingLeft += viewGroup.getPaddingLeft() + viewGroup.getPaddingRight();
            if (viewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.LayoutParams layoutParams2 = viewGroup.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                i17 += marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin;
            }
            Object parent = viewGroup.getParent();
            if (parent instanceof View) {
                view2 = (View) parent;
            } else {
                view2 = null;
            }
        }
        return bv.b(getContext()) - (i17 + paddingLeft);
    }

    private final RecyclerView l() {
        ViewParent parent = getParent();
        while (parent != null && !(parent instanceof RecyclerView)) {
            parent = parent.getParent();
        }
        if (parent instanceof RecyclerView) {
            return (RecyclerView) parent;
        }
        return null;
    }

    private final void m() {
        List<Drawable> listOf;
        Drawable drawable;
        BlendMode blendMode;
        int color = getContext().getColor(R.color.qui_common_brand_standard);
        if (Build.VERSION.SDK_INT >= 29) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Drawable[]{getTextCursorDrawable(), getTextSelectHandle(), getTextSelectHandleLeft(), getTextSelectHandleRight()});
            for (Drawable drawable2 : listOf) {
                if (drawable2 != null) {
                    drawable = drawable2.mutate();
                } else {
                    drawable = null;
                }
                if (drawable != null) {
                    blendMode = BlendMode.SRC_IN;
                    drawable.setColorFilter(new BlendModeColorFilter(color, blendMode));
                }
            }
        }
    }

    @NotNull
    public final Map<String, String> h() {
        Spanned spanned;
        CodeBlockSpan[] codeBlockSpanArr;
        Pair[] pairArr = new Pair[6];
        int i3 = 0;
        pairArr[0] = TuplesKt.to("text_length", String.valueOf(getText().length()));
        pairArr[1] = TuplesKt.to("width", String.valueOf(getWidth()));
        pairArr[2] = TuplesKt.to("height", String.valueOf(getHeight()));
        pairArr[3] = TuplesKt.to("hash", String.valueOf(hashCode()));
        CharSequence text = getText();
        if (text instanceof Spanned) {
            spanned = (Spanned) text;
        } else {
            spanned = null;
        }
        if (spanned != null && (codeBlockSpanArr = (CodeBlockSpan[]) spanned.getSpans(0, text.length(), CodeBlockSpan.class)) != null) {
            i3 = codeBlockSpanArr.length;
        }
        pairArr[4] = TuplesKt.to("has_code", String.valueOf(i3));
        pairArr[5] = TuplesKt.to("scene", this.scene);
        return com.tencent.android.androidbypass.b.g(pairArr);
    }

    public final int i(@NotNull Context context, int colorResId, int alpha) {
        Intrinsics.checkNotNullParameter(context, "context");
        int color = ContextCompat.getColor(context, colorResId);
        return Color.argb(alpha, Color.red(color), Color.green(color), Color.blue(color));
    }

    @NotNull
    public final CharSequence j() {
        Spannable spannable;
        CharSequence g16;
        CharSequence charSequence = this.originSpanBuilder;
        if (charSequence instanceof Spannable) {
            spannable = (Spannable) charSequence;
        } else {
            spannable = null;
        }
        if (spannable == null || (g16 = g(spannable, 0, spannable.length())) == null) {
            return "";
        }
        return g16;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.recyclerView = l();
        setMaxWidth(k(this));
        setEnabled(false);
        setEnabled(true);
        m();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.recyclerView = null;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(@Nullable Canvas canvas) {
        com.tencent.android.androidbypass.b.d().c();
        super.onDraw(canvas);
        com.tencent.android.androidbypass.b.d().b(h());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        com.tencent.android.androidbypass.b.e().c();
        super.onLayout(changed, left, top, right, bottom);
        com.tencent.android.androidbypass.b.e().b(h());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        com.tencent.android.androidbypass.b.f().c();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        com.tencent.android.androidbypass.b.f().b(h());
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int selStart, int selEnd) {
        Pair pair;
        super.onSelectionChanged(selStart, selEnd);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("AIReplyView", "onSelectionChanged: " + selStart + ", " + selEnd + " , " + getText().length());
        }
        if (selStart == -1 && selEnd == -1) {
            this.reachLastLine = false;
            return;
        }
        if (this.reachLastLine) {
            return;
        }
        if (selStart > selEnd) {
            pair = TuplesKt.to(Integer.valueOf(selStart), Integer.valueOf(selEnd));
        } else {
            pair = TuplesKt.to(Integer.valueOf(selEnd), Integer.valueOf(selStart));
        }
        int intValue = ((Number) pair.component1()).intValue();
        int intValue2 = ((Number) pair.component2()).intValue();
        if (intValue > intValue2) {
            try {
                int lineForOffset = getLayout().getLineForOffset(intValue);
                if (lineForOffset >= getLayout().getLineCount() - 1) {
                    Log.d("AIReplyView", "is last line");
                    this.reachLastLine = true;
                    return;
                }
                int lineBottom = getLayout().getLineBottom(lineForOffset);
                int lineBottom2 = getLayout().getLineBottom(getLayout().getLineCount() - 1);
                int[] iArr = new int[2];
                getLocationOnScreen(iArr);
                int i3 = iArr[1];
                int i16 = i3 + lineBottom;
                RecyclerView recyclerView = this.recyclerView;
                if (recyclerView != null) {
                    int[] iArr2 = new int[2];
                    recyclerView.getLocationOnScreen(iArr2);
                    int i17 = iArr2[1];
                    int i18 = i3 - i17;
                    int i19 = i18 + lineBottom;
                    int i26 = i18 + lineBottom2;
                    if (QLog.isDevelopLevel()) {
                        Log.d("AIReplyView", "tv on screen : " + i3 + ", rv on screen:" + i17 + " , line in tv:" + lineBottom);
                    }
                    if (QLog.isDevelopLevel()) {
                        Log.d("AIReplyView", "posOffsetToRv: " + i19 + ", tvHeight:" + recyclerView.getHeight());
                    }
                    if (Math.abs(recyclerView.getHeight() - i19) < F) {
                        Log.d("AIReplyView", "set selection: " + intValue2 + ", " + intValue);
                        CharSequence text = getText();
                        Intrinsics.checkNotNull(text, "null cannot be cast to non-null type android.text.Spannable");
                        Selection.setSelection((Spannable) text, intValue2, intValue + 1);
                    }
                    if (i26 == recyclerView.getHeight()) {
                        recyclerView.smoothScrollBy(0, G);
                    }
                }
                this.reporter.b();
                if (QLog.isDevelopLevel()) {
                    Log.d("AIReplyView", "  current " + lineForOffset + " lineBottom\uff1a" + lineBottom + ", tH:" + i16);
                }
            } catch (Exception e16) {
                s.f("AIReplyView", "on selection change exc", e16);
            }
        }
    }

    @Override // android.widget.TextView
    public void setHighlightColor(int color) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        super.setHighlightColor(i(context, R.color.qui_common_brand_light, 51));
    }

    @Override // android.widget.TextView
    public void setText(@Nullable CharSequence text, @Nullable TextView.BufferType type) {
        this.originSpanBuilder = text;
        super.setText(text, TextView.BufferType.SPANNABLE);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AIReplyView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AIReplyView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AIReplyView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        String str = "unknown";
        this.scene = "unknown";
        this.reporter = new b(this);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, up1.a.f439672t6, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.theme.obtainStyl\u2026e.MarkdownTextView, 0, 0)");
        try {
            String string = obtainStyledAttributes.getString(up1.a.f439685u6);
            if (string != null) {
                str = string;
            }
            this.scene = str;
            obtainStyledAttributes.recycle();
            setMaxWidth(ViewUtils.getScreenWidth());
            setCustomSelectionActionModeCallback(new a(context));
        } catch (Throwable th5) {
            obtainStyledAttributes.recycle();
            throw th5;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/guild/aisearch/views/AIReplyView$a", "Landroid/view/ActionMode$Callback2;", "Landroid/view/ActionMode;", "mode", "Landroid/view/Menu;", "menu", "", "onCreateActionMode", "onPrepareActionMode", "Landroid/view/MenuItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "onActionItemClicked", "", "onDestroyActionMode", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a extends ActionMode.Callback2 {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f214241b;

        a(Context context) {
            this.f214241b = context;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(@NotNull ActionMode mode, @NotNull MenuItem item) {
            Spannable spannable;
            Integer valueOf;
            int selectionStart;
            Intrinsics.checkNotNullParameter(mode, "mode");
            Intrinsics.checkNotNullParameter(item, "item");
            CharSequence charSequence = AIReplyView.this.originSpanBuilder;
            CharSequence charSequence2 = null;
            if (charSequence instanceof Spannable) {
                spannable = (Spannable) charSequence;
            } else {
                spannable = null;
            }
            if (item.getItemId() == R.id.s9b) {
                Logger logger = Logger.f235387a;
                AIReplyView aIReplyView = AIReplyView.this;
                if (QLog.isDevelopLevel()) {
                    Log.d("AIReplyView", "onActionItemClicked: " + aIReplyView.getSelectionStart());
                }
                AIReplyView aIReplyView2 = AIReplyView.this;
                if (QLog.isDevelopLevel()) {
                    Log.d("AIReplyView", "end: " + aIReplyView2.getSelectionEnd());
                }
                if (QLog.isDevelopLevel()) {
                    Log.d("AIReplyView", "span: " + ((Object) spannable));
                }
                if (AIReplyView.this.getSelectionEnd() > AIReplyView.this.getSelectionStart()) {
                    valueOf = Integer.valueOf(AIReplyView.this.getSelectionStart());
                    selectionStart = AIReplyView.this.getSelectionEnd();
                } else {
                    valueOf = Integer.valueOf(AIReplyView.this.getSelectionEnd());
                    selectionStart = AIReplyView.this.getSelectionStart();
                }
                Pair pair = TuplesKt.to(valueOf, Integer.valueOf(selectionStart));
                int intValue = ((Number) pair.component1()).intValue();
                int intValue2 = ((Number) pair.component2()).intValue();
                if (spannable != null) {
                    try {
                        charSequence2 = AIReplyView.this.g(spannable, intValue, intValue2);
                    } catch (Exception e16) {
                        s.f("AIReplyView", "deal with span exception", e16);
                    }
                }
                Object systemService = this.f214241b.getSystemService("clipboard");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                ClipboardMonitor.setPrimaryClip((ClipboardManager) systemService, ClipData.newPlainText("label", charSequence2));
                te1.a.INSTANCE.b(this.f214241b, "\u590d\u5236\u6210\u529f");
                AIReplyView.this.reporter.d();
                mode.finish();
                return true;
            }
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(@Nullable ActionMode mode, @Nullable Menu menu) {
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(@Nullable ActionMode mode, @Nullable Menu menu) {
            MenuInflater menuInflater;
            if (menu != null) {
                menu.clear();
            }
            if (mode != null && (menuInflater = mode.getMenuInflater()) != null) {
                menuInflater.inflate(R.menu.f169216d, menu);
            }
            if (mode != null) {
                mode.getCustomView();
                return true;
            }
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(@Nullable ActionMode mode) {
        }
    }
}
