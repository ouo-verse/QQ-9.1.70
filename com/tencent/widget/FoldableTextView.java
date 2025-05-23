package com.tencent.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0001HB'\b\u0007\u0012\u0006\u0010B\u001a\u00020A\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010C\u0012\b\b\u0002\u0010E\u001a\u00020\u0006\u00a2\u0006\u0004\bF\u0010GJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J \u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0002J\u0006\u0010\u0014\u001a\u00020\u0002J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0014J\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u0006J\u000e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aR\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001eR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001eR\u0016\u0010\"\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010!R\u0016\u0010$\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010#R\u0018\u0010&\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010%R\u0016\u0010(\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010#R\u0016\u0010*\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010!R\u0016\u0010,\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010!R\u0016\u0010.\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010#R\u0016\u00100\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010#R\u0016\u00102\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010#R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R$\u0010\t\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010=\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b;\u00108\"\u0004\b<\u0010:R$\u0010@\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b>\u00108\"\u0004\b?\u0010:\u00a8\u0006I"}, d2 = {"Lcom/tencent/widget/FoldableTextView;", "Landroid/widget/RelativeLayout;", "", "e", "", "k", "", "width", "", "text", "Landroid/text/Layout;", tl.h.F, "source", "Landroid/text/TextPaint;", "p", "", "i", "avail", "d", "j", "b", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "f", "c", "Landroid/content/res/ColorStateList;", "colorStateList", "setTextColor", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "mContentTV", "mFoldTV", "Ljava/lang/CharSequence;", "mText", "I", "mTextSize", "Landroid/content/res/ColorStateList;", "mTextColor", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mFoldLineCount", BdhLogUtil.LogTag.Tag_Conn, "mFoldStateText", "D", "mExpandStateText", "E", "mFoldHintTextColor", UserInfo.SEX_FEMALE, "mFoldStatus", "G", "mLastMeasuredWidth", "Landroid/view/View$OnClickListener;", "H", "Landroid/view/View$OnClickListener;", "mFoldClickListener", "getText", "()Ljava/lang/CharSequence;", IECSearchBar.METHOD_SET_TEXT, "(Ljava/lang/CharSequence;)V", "getFoldStateText", "setFoldStateText", "foldStateText", "getExpandStateText", "setExpandStateText", "expandStateText", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "qqview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class FoldableTextView extends RelativeLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private CharSequence mFoldStateText;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private CharSequence mExpandStateText;

    /* renamed from: E, reason: from kotlin metadata */
    private int mFoldHintTextColor;

    /* renamed from: F, reason: from kotlin metadata */
    private int mFoldStatus;

    /* renamed from: G, reason: from kotlin metadata */
    private int mLastMeasuredWidth;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final View.OnClickListener mFoldClickListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView mContentTV;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView mFoldTV;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CharSequence mText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mTextSize;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ColorStateList mTextColor;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mFoldLineCount;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/widget/FoldableTextView$a;", "", "", "DEFAULT_FOLD_LINE_COUNT", "I", "", "ELLIPSIS", "Ljava/lang/String;", "STATUS_EXPAND", "STATUS_FOLD", "TAG", "<init>", "()V", "qqview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.widget.FoldableTextView$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37346);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FoldableTextView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            return;
        }
        iPatchRedirector.redirect((short) 15, (Object) this, (Object) context);
    }

    private final int d(CharSequence text, TextPaint p16, float avail) {
        if (TextUtils.isEmpty(text) || avail <= 0.0f) {
            return 0;
        }
        float measureText = avail - p16.measureText("\u2026");
        int length = text.length();
        while (i(text, p16) > measureText) {
            length = text.length() - 1;
            if (text instanceof Spanned) {
                Spanned spanned = (Spanned) text;
                int length2 = spanned.getSpans(0, text.length(), Object.class).length;
                for (int i3 = 0; i3 < length2; i3++) {
                    int spanStart = spanned.getSpanStart(Integer.valueOf(i3));
                    int spanEnd = spanned.getSpanEnd(Integer.valueOf(i3));
                    if (spanStart != -1 && spanEnd != -1 && (length >= spanStart || length <= spanEnd)) {
                        length = spanStart;
                    }
                }
            }
            if (length <= 0) {
                return 0;
            }
            text = text.subSequence(0, length);
        }
        return length;
    }

    private final void e() {
        TextView textView = new TextView(getContext());
        this.mContentTV = textView;
        textView.setId(R.id.mcn);
        TextView textView2 = this.mContentTV;
        View view = null;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentTV");
            textView2 = null;
        }
        textView2.setTextColor(this.mTextColor);
        TextView textView3 = this.mContentTV;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentTV");
            textView3 = null;
        }
        textView3.setTextSize(0, this.mTextSize);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        View view2 = this.mContentTV;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentTV");
            view2 = null;
        }
        addView(view2, layoutParams);
        TextView textView4 = new TextView(getContext());
        this.mFoldTV = textView4;
        textView4.setTextSize(0, this.mTextSize);
        TextView textView5 = this.mFoldTV;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFoldTV");
            textView5 = null;
        }
        textView5.setOnClickListener(this.mFoldClickListener);
        TextView textView6 = this.mFoldTV;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFoldTV");
            textView6 = null;
        }
        textView6.setText(this.mFoldStateText);
        TextView textView7 = this.mFoldTV;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFoldTV");
            textView7 = null;
        }
        textView7.setTextColor(this.mFoldHintTextColor);
        TextView textView8 = this.mFoldTV;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFoldTV");
            textView8 = null;
        }
        textView8.setVisibility(8);
        int c16 = x.c(getContext(), 32.0f);
        int c17 = x.c(getContext(), 21.0f);
        TextView textView9 = this.mFoldTV;
        if (textView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFoldTV");
            textView9 = null;
        }
        textView9.setPadding(c16, c17, 0, 0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(12, -1);
        layoutParams2.addRule(11, -1);
        View view3 = this.mFoldTV;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFoldTV");
        } else {
            view = view3;
        }
        addView(view, layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(FoldableTextView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final Layout h(int width, CharSequence text) {
        Layout staticLayout;
        TextView textView = null;
        if (k()) {
            TextView textView2 = this.mContentTV;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentTV");
            } else {
                textView = textView2;
            }
            staticLayout = new DynamicLayout(text, textView.getPaint(), width, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        } else {
            TextView textView3 = this.mContentTV;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentTV");
            } else {
                textView = textView3;
            }
            staticLayout = new StaticLayout(text, textView.getPaint(), width, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        }
        return staticLayout;
    }

    private final float i(CharSequence source, TextPaint p16) {
        return p16.measureText(source.toString());
    }

    private final void j() {
        int paddingRight;
        CharSequence charSequence;
        boolean z16;
        CharSequence subSequence;
        TextView textView = this.mContentTV;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentTV");
            textView = null;
        }
        if (textView.getLayout() != null) {
            TextView textView3 = this.mContentTV;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentTV");
                textView3 = null;
            }
            paddingRight = textView3.getLayout().getWidth();
        } else {
            TextView textView4 = this.mContentTV;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentTV");
                textView4 = null;
            }
            int measuredWidth = textView4.getMeasuredWidth();
            TextView textView5 = this.mContentTV;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentTV");
                textView5 = null;
            }
            int paddingLeft = measuredWidth - textView5.getPaddingLeft();
            TextView textView6 = this.mContentTV;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentTV");
                textView6 = null;
            }
            paddingRight = paddingLeft - textView6.getPaddingRight();
        }
        if (paddingRight <= 0) {
            QLog.d("FoldableTextView", 1, "updateFoldStatus, layoutWidth <= 0");
            return;
        }
        Layout h16 = h(paddingRight, this.mText);
        int lineCount = h16.getLineCount();
        if (lineCount <= this.mFoldLineCount) {
            TextView textView7 = this.mContentTV;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentTV");
                textView7 = null;
            }
            textView7.setText(this.mText);
            TextView textView8 = this.mFoldTV;
            if (textView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFoldTV");
            } else {
                textView2 = textView8;
            }
            textView2.setVisibility(8);
            return;
        }
        if (this.mFoldStatus == 0) {
            TextView textView9 = this.mFoldTV;
            if (textView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFoldTV");
                textView9 = null;
            }
            textView9.setText(this.mFoldStateText);
            int lineStart = h16.getLineStart(this.mFoldLineCount - 1);
            int lineEnd = h16.getLineEnd(this.mFoldLineCount - 1);
            CharSequence charSequence2 = this.mText;
            if (charSequence2 instanceof QQText) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append(this.mText, lineStart, lineEnd);
                charSequence = spannableStringBuilder;
            } else {
                charSequence = charSequence2.subSequence(lineStart, lineEnd);
            }
            if (QLog.isDebugVersion()) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("lineCount: %s, lastLineText: %s", Arrays.copyOf(new Object[]{Integer.valueOf(h16.getLineCount()), charSequence}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                QLog.d("FoldableTextView", 4, format);
            }
            if (charSequence.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && charSequence.toString().charAt(charSequence.length() - 1) == '\n') {
                if (charSequence.length() == 1) {
                    subSequence = "";
                } else {
                    subSequence = charSequence.subSequence(0, charSequence.length() - 1);
                }
                charSequence = subSequence;
            }
            float width = h16.getWidth();
            TextView textView10 = this.mFoldTV;
            if (textView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFoldTV");
                textView10 = null;
            }
            TextPaint paint = textView10.getPaint();
            CharSequence charSequence3 = this.mFoldStateText;
            float measureText = width - paint.measureText(charSequence3, 0, charSequence3.length());
            TextView textView11 = this.mContentTV;
            if (textView11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentTV");
                textView11 = null;
            }
            TextPaint paint2 = textView11.getPaint();
            Intrinsics.checkNotNullExpressionValue(paint2, "mContentTV.paint");
            int d16 = d(charSequence, paint2, measureText) + lineStart;
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            spannableStringBuilder2.append(this.mText, 0, d16);
            spannableStringBuilder2.append((CharSequence) "\u2026");
            TextView textView12 = this.mContentTV;
            if (textView12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentTV");
                textView12 = null;
            }
            textView12.setText(spannableStringBuilder2);
            TextView textView13 = this.mFoldTV;
            if (textView13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFoldTV");
            } else {
                textView2 = textView13;
            }
            textView2.setVisibility(0);
            return;
        }
        float secondaryHorizontal = h16.getSecondaryHorizontal(h16.getLineEnd(lineCount - 1));
        TextView textView14 = this.mFoldTV;
        if (textView14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFoldTV");
            textView14 = null;
        }
        TextPaint paint3 = textView14.getPaint();
        CharSequence charSequence4 = this.mExpandStateText;
        if (paddingRight - secondaryHorizontal < paint3.measureText(charSequence4, 0, charSequence4.length())) {
            TextView textView15 = this.mContentTV;
            if (textView15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentTV");
                textView15 = null;
            }
            textView15.setText(TextUtils.concat(this.mText, "\n"));
        } else {
            TextView textView16 = this.mContentTV;
            if (textView16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentTV");
                textView16 = null;
            }
            textView16.setText(this.mText);
        }
        TextView textView17 = this.mFoldTV;
        if (textView17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFoldTV");
            textView17 = null;
        }
        textView17.setVisibility(0);
        TextView textView18 = this.mFoldTV;
        if (textView18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFoldTV");
        } else {
            textView2 = textView18;
        }
        textView2.setText(this.mExpandStateText);
    }

    private final boolean k() {
        boolean z16 = this.mText instanceof Spannable;
        TextView textView = this.mContentTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentTV");
            textView = null;
        }
        boolean isTextSelectable = textView.isTextSelectable();
        if (!z16 && !isTextSelectable) {
            return false;
        }
        return true;
    }

    public final void b() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (this.mFoldStatus == 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        this.mFoldStatus = i3;
        j();
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.mFoldStatus;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        TextView textView = this.mFoldTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFoldTV");
            textView = null;
        }
        if (textView.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(widthMeasureSpec), Integer.valueOf(heightMeasureSpec));
            return;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (this.mLastMeasuredWidth != getMeasuredWidth()) {
            if (this.mText.length() <= 0) {
                z16 = false;
            }
            if (z16) {
                j();
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            }
        }
        this.mLastMeasuredWidth = getMeasuredWidth();
    }

    public final void setExpandStateText(@NotNull CharSequence text) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) text);
            return;
        }
        Intrinsics.checkNotNullParameter(text, "text");
        this.mExpandStateText = text;
        if (this.mFoldStatus == 1) {
            TextView textView = this.mFoldTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFoldTV");
                textView = null;
            }
            textView.setText(this.mExpandStateText);
        }
    }

    public final void setFoldStateText(@NotNull CharSequence text) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) text);
            return;
        }
        Intrinsics.checkNotNullParameter(text, "text");
        this.mFoldStateText = text;
        if (this.mFoldStatus == 0) {
            TextView textView = this.mFoldTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFoldTV");
                textView = null;
            }
            textView.setText(this.mFoldStateText);
        }
    }

    public final void setText(@NotNull CharSequence text) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) text);
            return;
        }
        Intrinsics.checkNotNullParameter(text, "text");
        this.mText = text;
        if (this.mLastMeasuredWidth > 0) {
            j();
        }
    }

    public final void setTextColor(@NotNull ColorStateList colorStateList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) colorStateList);
            return;
        }
        Intrinsics.checkNotNullParameter(colorStateList, "colorStateList");
        this.mTextColor = colorStateList;
        TextView textView = this.mContentTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentTV");
            textView = null;
        }
        textView.setTextColor(this.mTextColor);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FoldableTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            return;
        }
        iPatchRedirector.redirect((short) 14, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ FoldableTextView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FoldableTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mText = "";
        this.mFoldStateText = "";
        this.mExpandStateText = "";
        this.mFoldClickListener = new View.OnClickListener() { // from class: com.tencent.widget.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FoldableTextView.g(FoldableTextView.this, view);
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, u51.a.K);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026yleable.FoldableTextView)");
        String string = obtainStyledAttributes.getString(u51.a.N);
        this.mText = string == null ? "" : string;
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(u51.a.M);
        this.mTextColor = colorStateList == null ? context.getColorStateList(R.color.qui_common_text_secondary) : colorStateList;
        this.mTextSize = obtainStyledAttributes.getDimensionPixelSize(u51.a.L, x.c(getContext(), 14.0f));
        this.mFoldLineCount = obtainStyledAttributes.getInt(u51.a.Q, 2);
        String string2 = obtainStyledAttributes.getString(u51.a.R);
        this.mFoldStateText = string2 == null ? "" : string2;
        String string3 = obtainStyledAttributes.getString(u51.a.O);
        this.mExpandStateText = string3 != null ? string3 : "";
        this.mFoldHintTextColor = obtainStyledAttributes.getColor(u51.a.P, context.getResources().getColor(R.color.f157768yz));
        obtainStyledAttributes.recycle();
        if (TextUtils.isEmpty(this.mFoldStateText)) {
            String qqStr = HardCodeUtil.qqStr(R.string.zp9);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.creation_setting_expand)");
            this.mFoldStateText = qqStr;
        }
        if (TextUtils.isEmpty(this.mExpandStateText)) {
            String qqStr2 = HardCodeUtil.qqStr(R.string.zp_);
            Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.creation_setting_fold)");
            this.mExpandStateText = qqStr2;
        }
        e();
    }
}
