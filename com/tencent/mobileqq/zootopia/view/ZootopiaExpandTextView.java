package com.tencent.mobileqq.zootopia.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 M2\u00020\u0001:\u0001NB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010J\u001a\u00020\u0013\u00a2\u0006\u0004\bK\u0010LJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0014\u0010\u000b\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0014\u0010\u0010\u001a\u00020\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0014J\u0010\u0010\u0017\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\rR\u0016\u0010\u001b\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001dR\u0016\u0010!\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010 R\u0016\u0010$\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001dR\u0016\u0010'\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010#R\u0016\u0010)\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010\u001dR\u0016\u0010+\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010#R\u0016\u0010,\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010#R\u0016\u0010.\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010#R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u00104R\u0016\u00107\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010\u001aR\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u00106R\u0016\u0010@\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010 R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010\u001aR\u0018\u0010H\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010\u001d\u00a8\u0006O"}, d2 = {"Lcom/tencent/mobileqq/zootopia/view/ZootopiaExpandTextView;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "", "d", "f", "", "textString", "j", "l", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "text", tl.h.F, "e", "c", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", IECSearchBar.METHOD_SET_TEXT, "hasWaveBg", "g", "Z", com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, "isAnimating", "Ljava/lang/String;", "mainText", "", UserInfo.SEX_FEMALE, "mainTextSize", "i", "I", "mainTextColor", "closeEndText", BdhLogUtil.LogTag.Tag_Conn, "closeEndTextColor", "D", "openEndText", "E", "openEndTextColor", "limitLine", "G", "endTextMeasureWidth", "Landroid/text/TextPaint;", "H", "Landroid/text/TextPaint;", "textPaint", "Landroid/text/StaticLayout;", "Landroid/text/StaticLayout;", "staticLayout", "J", "isNeedMeasure", "Landroid/view/ViewGroup$LayoutParams;", "K", "Landroid/view/ViewGroup$LayoutParams;", "currentLayoutParam", "", "L", "animDuration", "M", NodeProps.LINE_SPACING_MULTIPLIER, "Lfi3/y;", "N", "Lfi3/y;", "binding", "P", "needCloseText", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "closeText", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BdhLogUtil.LogTag.Tag_Req, "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaExpandTextView extends RelativeLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private int closeEndTextColor;

    /* renamed from: D, reason: from kotlin metadata */
    private String openEndText;

    /* renamed from: E, reason: from kotlin metadata */
    private int openEndTextColor;

    /* renamed from: F, reason: from kotlin metadata */
    private int limitLine;

    /* renamed from: G, reason: from kotlin metadata */
    private int endTextMeasureWidth;

    /* renamed from: H, reason: from kotlin metadata */
    private final TextPaint textPaint;

    /* renamed from: I, reason: from kotlin metadata */
    private StaticLayout staticLayout;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isNeedMeasure;

    /* renamed from: K, reason: from kotlin metadata */
    private ViewGroup.LayoutParams currentLayoutParam;

    /* renamed from: L, reason: from kotlin metadata */
    private long animDuration;

    /* renamed from: M, reason: from kotlin metadata */
    private float lineSpacingMultiplier;

    /* renamed from: N, reason: from kotlin metadata */
    private fi3.y binding;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean needCloseText;

    /* renamed from: Q, reason: from kotlin metadata */
    private String closeText;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isOpen;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isAnimating;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String mainText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float mainTextSize;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mainTextColor;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String closeEndText;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaExpandTextView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ZootopiaExpandTextView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isAnimating) {
            return;
        }
        if (this$0.isOpen) {
            this$0.c();
        } else {
            this$0.e();
        }
    }

    private final void f() {
        TextView textView = this.binding.f399435b;
        textView.setTextSize(0, this.mainTextSize);
        if (!this.isOpen) {
            textView.setText(this.closeEndText);
            textView.setTextColor(this.closeEndTextColor);
            textView.setVisibility(0);
        } else {
            textView.setVisibility(this.needCloseText ? 0 : 8);
            textView.setText(this.openEndText);
            textView.setTextColor(this.openEndTextColor);
        }
        this.binding.f399436c.setVisibility(textView.getVisibility());
    }

    private final void j(String textString) {
        TextView textView = this.binding.f399438e;
        textView.setText(textString);
        textView.setLineSpacing(0.0f, this.lineSpacingMultiplier);
        textView.setTextSize(0, this.mainTextSize);
        textView.setTextColor(this.mainTextColor);
    }

    private final void l() {
        StaticLayout staticLayout = this.staticLayout;
        if (staticLayout != null) {
            if (staticLayout.getLineCount() <= this.limitLine) {
                this.binding.f399437d.setVisibility(8);
                k(this, null, 1, null);
                return;
            }
            this.binding.f399437d.setVisibility(0);
            f();
            if (this.isOpen) {
                k(this, null, 1, null);
            } else {
                j(this.closeText);
            }
        }
    }

    private final boolean m() {
        CharSequence subSequence;
        if (getMeasuredWidth() == 0) {
            return false;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            this.currentLayoutParam = layoutParams;
        }
        this.endTextMeasureWidth = this.needCloseText ? this.binding.f399435b.getMeasuredWidth() + com.tencent.sqshow.zootopia.utils.i.a(15.0f) : 0;
        String str = null;
        i(this, null, 1, null);
        StaticLayout staticLayout = this.staticLayout;
        if (staticLayout != null) {
            int lineCount = staticLayout.getLineCount();
            int i3 = this.limitLine;
            if (lineCount <= i3) {
                this.closeText = this.mainText;
            } else if (i3 >= 1) {
                int max = Math.max((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 0);
                if (this.needCloseText && staticLayout.getLineCount() >= 1 && staticLayout.getLineWidth(staticLayout.getLineCount() - 1) + this.endTextMeasureWidth > max) {
                    String str2 = this.mainText + "\n";
                    this.mainText = str2;
                    h(str2);
                }
                String str3 = this.mainText;
                if (str3 != null && (subSequence = str3.subSequence(0, staticLayout.getLineEnd(this.limitLine - 1))) != null) {
                    str = subSequence.toString();
                }
                this.closeText = str;
            }
        }
        l();
        return true;
    }

    public final void g(boolean hasWaveBg) {
        this.binding.f399435b.setBackgroundColor(hasWaveBg ? 0 : -1);
        this.binding.f399436c.setBackgroundResource(hasWaveBg ? R.drawable.hzq : R.drawable.hzr);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (!this.isNeedMeasure || getMeasuredWidth() == 0) {
            return;
        }
        this.isNeedMeasure = !m();
    }

    public final void setText(String text) {
        this.mainText = text;
        this.isNeedMeasure = !m();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaExpandTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void c() {
        this.isOpen = false;
        j(this.closeText);
        this.isAnimating = false;
        f();
    }

    private final void e() {
        this.isOpen = true;
        k(this, null, 1, null);
        this.isAnimating = false;
        f();
    }

    public /* synthetic */ ZootopiaExpandTextView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    private final void d(Context context, AttributeSet attr) {
        if (attr != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attr, ei3.a.f396318l);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026tyleable.ZplanExpandText)");
            this.mainText = obtainStyledAttributes.getString(7);
            this.mainTextSize = obtainStyledAttributes.getDimension(9, this.mainTextSize);
            this.mainTextColor = obtainStyledAttributes.getResourceId(6, this.mainTextColor);
            String string = obtainStyledAttributes.getString(1);
            if (string == null) {
                string = this.closeEndText;
            }
            this.closeEndText = string;
            this.closeEndTextColor = obtainStyledAttributes.getResourceId(6, this.closeEndTextColor);
            String string2 = obtainStyledAttributes.getString(5);
            if (string2 == null) {
                string2 = this.openEndText;
            }
            this.openEndText = string2;
            this.openEndTextColor = obtainStyledAttributes.getResourceId(6, this.openEndTextColor);
            this.limitLine = obtainStyledAttributes.getInt(3, this.limitLine);
            this.animDuration = obtainStyledAttributes.getInt(0, (int) this.animDuration);
            this.lineSpacingMultiplier = obtainStyledAttributes.getFloat(4, this.lineSpacingMultiplier);
            obtainStyledAttributes.recycle();
        }
    }

    private final void h(String text) {
        if (text != null) {
            this.staticLayout = StaticLayout.Builder.obtain(text, 0, text.length(), this.textPaint, getMeasuredWidth()).setIncludePad(true).setLineSpacing(0.0f, this.lineSpacingMultiplier).build();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaExpandTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mainTextSize = TypedValue.applyDimension(2, 13.0f, getResources().getDisplayMetrics());
        this.mainTextColor = -16777216;
        this.closeEndText = "\u6536\u8d77";
        this.closeEndTextColor = Color.parseColor("#ff57bdf7");
        this.openEndText = "\u5c55\u5f00";
        this.openEndTextColor = Color.parseColor("#ff57bdf7");
        this.limitLine = 2;
        TextPaint textPaint = new TextPaint();
        this.textPaint = textPaint;
        this.isNeedMeasure = true;
        this.animDuration = 400L;
        this.lineSpacingMultiplier = 1.0f;
        fi3.y f16 = fi3.y.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        d(context, attributeSet);
        textPaint.setTextSize(this.mainTextSize);
        textPaint.setAntiAlias(true);
        textPaint.setColor(this.mainTextColor);
        this.binding.f399437d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.view.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZootopiaExpandTextView.b(ZootopiaExpandTextView.this, view);
            }
        });
        this.currentLayoutParam = new RelativeLayout.LayoutParams(-1, -2);
    }

    static /* synthetic */ void i(ZootopiaExpandTextView zootopiaExpandTextView, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = zootopiaExpandTextView.mainText;
        }
        zootopiaExpandTextView.h(str);
    }

    static /* synthetic */ void k(ZootopiaExpandTextView zootopiaExpandTextView, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = zootopiaExpandTextView.mainText;
        }
        zootopiaExpandTextView.j(str);
    }
}
