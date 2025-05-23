package com.tencent.mobileqq.search.searchdetail.content.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqnt.aio.utils.ViewUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 F2\u00020\u0001:\u0001(B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\bA\u0010BB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010D\u001a\u0004\u0018\u00010C\u00a2\u0006\u0004\bA\u0010EJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0002J\u001a\u0010\u0015\u001a\u00020\u0014*\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0002J.\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018J\u0018\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0018H\u0014J0\u0010#\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u0018H\u0014J\u001a\u0010(\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&J\u0006\u0010)\u001a\u00020\u0004J\u000e\u0010*\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006J\u000e\u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\nJ\u000e\u0010-\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006R\u0016\u00100\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010/R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u00101R\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020\u0006028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u00103R\u0016\u00106\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u00105R\u0016\u00109\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00108R\u0016\u0010>\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u00108\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/view/QSearchShowHighlightTextView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "", "f", "", "content", "Landroid/text/TextPaint;", "paint", "", "contentShowWidth", "e", "str", "", "highlightStrs", "Landroid/text/SpannableString;", "d", "", "words", "", "g", "highlightList", "c", "", NodeProps.MAX_WIDTH, "setTextViewMaxWidth", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "changed", "l", "t", "r", "b", "onLayout", "Landroid/view/View;", "tailView", "Landroid/widget/LinearLayout$LayoutParams;", "layoutParams", "a", tl.h.F, IECSearchBar.METHOD_SET_TEXT, "size", "setTextSize", "setHighlightText", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "textView", "Landroid/view/View;", "", "Ljava/util/List;", "highlightWords", UserInfo.SEX_FEMALE, "textSize", "i", "I", "textColor", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "highlightTextColor", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/CharSequence;", "realContent", "D", "lastMeasuredWidth", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "E", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class QSearchShowHighlightTextView extends LinearLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private CharSequence realContent;

    /* renamed from: D, reason: from kotlin metadata */
    private int lastMeasuredWidth;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView textView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View tailView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<String> highlightWords;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float textSize;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int textColor;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int highlightTextColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QSearchShowHighlightTextView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.highlightWords = new ArrayList();
        this.textSize = ViewUtils.f352270a.a(14.0f);
        this.textColor = getContext().getColor(R.color.qui_common_text_primary);
        this.highlightTextColor = getContext().getColor(R.color.qui_common_brand_standard);
        this.realContent = "";
        this.lastMeasuredWidth = -1;
        f(context);
    }

    public static /* synthetic */ void b(QSearchShowHighlightTextView qSearchShowHighlightTextView, View view, LinearLayout.LayoutParams layoutParams, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            layoutParams = null;
        }
        qSearchShowHighlightTextView.a(view, layoutParams);
    }

    private final CharSequence c(String content, List<String> highlightList, TextPaint paint, float contentShowWidth) {
        int i3;
        int i16;
        int i17;
        int i18;
        int indexOf;
        float measureText = paint.measureText("\u2026");
        int size = highlightList.size();
        int i19 = 0;
        int i26 = 0;
        int i27 = 0;
        for (int i28 = 0; i28 < size; i28++) {
            String str = highlightList.get(i28);
            indexOf = StringsKt__StringsKt.indexOf((CharSequence) content, str, i26, true);
            if (indexOf != -1) {
                if (i28 == 0) {
                    i19 = indexOf;
                }
                i27 = Math.min(content.length(), indexOf + str.length());
                String substring = content.substring(i19, i27);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                if (paint.measureText(substring) + (2 * measureText) < contentShowWidth) {
                    i26 = i27;
                }
            }
        }
        int max = Math.max(i19, i26);
        while (true) {
            if (i19 <= 0 && max >= content.length()) {
                break;
            }
            if (max < i27) {
                max++;
                if (i19 <= 0) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                if (max >= content.length()) {
                    i3--;
                }
                String substring2 = content.substring(i19, max);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                if (paint.measureText(substring2) + (i3 * measureText) >= contentShowWidth) {
                    break;
                }
            } else {
                if (i19 > 0) {
                    i19--;
                    if (i19 <= 0) {
                        i17 = 1;
                    } else {
                        i17 = 2;
                    }
                    if (max >= content.length()) {
                        i17--;
                    }
                    String substring3 = content.substring(i19, max);
                    Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    if (paint.measureText(substring3) + (i17 * measureText) >= contentShowWidth) {
                        i19++;
                        break;
                    }
                }
                if (max < content.length()) {
                    max++;
                    if (i19 <= 0) {
                        i16 = 1;
                    } else {
                        i16 = 2;
                    }
                    if (max >= content.length()) {
                        i16--;
                    }
                    String substring4 = content.substring(i19, max);
                    Intrinsics.checkNotNullExpressionValue(substring4, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    if (paint.measureText(substring4) + (i16 * measureText) >= contentShowWidth) {
                        break;
                    }
                } else {
                    continue;
                }
            }
        }
        max--;
        SpannableString d16 = d(content, highlightList);
        int i29 = i19 == 0 ? i19 : i19 - 1;
        if (max == content.length()) {
            i18 = max;
        } else {
            i18 = max + 1;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(d16.subSequence(i29, i18));
        if (i19 > 0) {
            spannableStringBuilder = spannableStringBuilder.replace(0, 1, (CharSequence) "\u2026");
            Intrinsics.checkNotNullExpressionValue(spannableStringBuilder, "result.replace(0, 1, \"\u2026\")");
        }
        if (max < content.length()) {
            SpannableStringBuilder replace = spannableStringBuilder.replace(spannableStringBuilder.length() - 1, spannableStringBuilder.length(), (CharSequence) "\u2026");
            Intrinsics.checkNotNullExpressionValue(replace, "result.replace(result.le\u2026 - 1, result.length, \"\u2026\")");
            return replace;
        }
        return spannableStringBuilder;
    }

    private final SpannableString d(String str, List<String> highlightStrs) {
        int indexOf;
        SpannableString spannableString = new SpannableString(str);
        int i3 = 0;
        for (String str2 : highlightStrs) {
            indexOf = StringsKt__StringsKt.indexOf((CharSequence) str, str2, i3, true);
            if (indexOf != -1) {
                i3 = Math.min(str.length(), str2.length() + indexOf);
                spannableString.setSpan(new ForegroundColorSpan(this.highlightTextColor), indexOf, i3, 18);
            }
        }
        return spannableString;
    }

    private final String e(String content, TextPaint paint, float contentShowWidth) {
        int i3 = 1;
        while (true) {
            if (i3 >= content.length()) {
                break;
            }
            String substring = content.substring(0, i3);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            if (paint.measureText(substring + "\u2026") < contentShowWidth) {
                i3++;
            } else {
                i3--;
                break;
            }
        }
        if (i3 < content.length()) {
            String substring2 = content.substring(0, i3);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            return substring2 + "\u2026";
        }
        return content;
    }

    private final void f(Context context) {
        this.textView = new TextView(context);
        setOrientation(0);
        TextView textView = this.textView;
        View view = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
            textView = null;
        }
        textView.setSingleLine();
        TextView textView2 = this.textView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
            textView2 = null;
        }
        textView2.setMaxLines(1);
        TextView textView3 = this.textView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
            textView3 = null;
        }
        textView3.setText(this.realContent);
        TextView textView4 = this.textView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
            textView4 = null;
        }
        textView4.setTextColor(this.textColor);
        TextView textView5 = this.textView;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
            textView5 = null;
        }
        textView5.setTextSize(0, this.textSize);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        View view2 = this.textView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
        } else {
            view = view2;
        }
        addView(view, layoutParams);
    }

    private final boolean g(CharSequence charSequence, List<String> list) {
        boolean contains;
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            contains = StringsKt__StringsKt.contains(charSequence, (CharSequence) it.next(), true);
            if (contains) {
                return true;
            }
        }
        return false;
    }

    public final void a(@NotNull View tailView, @Nullable LinearLayout.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(tailView, "tailView");
        View view = this.tailView;
        if (view != null) {
            removeView(view);
        }
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.gravity = 17;
        layoutParams.leftMargin = ViewUtils.f352270a.a(4.0f);
        this.tailView = tailView;
        addView(tailView, layoutParams);
    }

    public final void h() {
        View view = this.tailView;
        if (view != null) {
            removeView(view);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l3, int t16, int r16, int b16) {
        super.onLayout(changed, l3, t16, r16, b16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0044, code lost:
    
        if (android.text.TextUtils.equals(r3.getText(), r8.realContent) == false) goto L18;
     */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i3;
        int coerceAtLeast;
        CharSequence e16;
        super.measureChildren(widthMeasureSpec, heightMeasureSpec);
        View view = this.tailView;
        if (view != null) {
            i3 = view.getMeasuredWidth() + ViewUtils.f352270a.a(4.0f);
        } else {
            i3 = 0;
        }
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        TextView textView = this.textView;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
            textView = null;
        }
        if (textView.getMeasuredWidth() + i3 < size) {
            if (this.lastMeasuredWidth != size) {
                TextView textView3 = this.textView;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("textView");
                    textView3 = null;
                }
            }
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(0, size - i3);
        TextView textView4 = this.textView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
            textView4 = null;
        }
        TextPaint paint = textView4.getPaint();
        CharSequence charSequence = this.realContent;
        if (this.highlightWords.isEmpty()) {
            String obj = charSequence.toString();
            Intrinsics.checkNotNullExpressionValue(paint, "paint");
            e16 = e(obj, paint, coerceAtLeast);
        } else if (g(charSequence, this.highlightWords)) {
            String obj2 = charSequence.toString();
            List<String> list = this.highlightWords;
            Intrinsics.checkNotNullExpressionValue(paint, "paint");
            e16 = c(obj2, list, paint, coerceAtLeast);
        } else {
            String obj3 = charSequence.toString();
            Intrinsics.checkNotNullExpressionValue(paint, "paint");
            e16 = e(obj3, paint, coerceAtLeast);
        }
        TextView textView5 = this.textView;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
        } else {
            textView2 = textView5;
        }
        textView2.setText(e16);
        this.lastMeasuredWidth = size;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public final void setHighlightText(@NotNull String str) {
        boolean z16;
        boolean contains$default;
        List split$default;
        Intrinsics.checkNotNullParameter(str, "str");
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        TextView textView = null;
        if (z16 && (!this.highlightWords.isEmpty())) {
            this.highlightWords.clear();
            TextView textView2 = this.textView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textView");
            } else {
                textView = textView2;
            }
            textView.setText(this.realContent);
            return;
        }
        ArrayList arrayList = new ArrayList();
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) " ", false, 2, (Object) null);
        if (contains$default) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{" "}, false, 0, 6, (Object) null);
            arrayList.addAll(split$default);
        } else {
            arrayList.add(str);
        }
        this.highlightWords.clear();
        this.highlightWords.addAll(arrayList);
        if (g(this.realContent, this.highlightWords)) {
            TextView textView3 = this.textView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textView");
            } else {
                textView = textView3;
            }
            textView.setText(d(this.realContent.toString(), this.highlightWords));
        }
    }

    public final void setText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        this.realContent = str;
        TextView textView = null;
        if (this.highlightWords.isEmpty()) {
            TextView textView2 = this.textView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textView");
            } else {
                textView = textView2;
            }
            textView.setText(str);
            return;
        }
        if (g(this.realContent, this.highlightWords)) {
            TextView textView3 = this.textView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textView");
            } else {
                textView = textView3;
            }
            textView.setText(d(this.realContent.toString(), this.highlightWords));
            return;
        }
        TextView textView4 = this.textView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
        } else {
            textView = textView4;
        }
        textView.setText(str);
    }

    public final void setTextSize(float size) {
        TextView textView = this.textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
            textView = null;
        }
        textView.setTextSize(1, size);
    }

    public final void setTextViewMaxWidth(int maxWidth) {
        TextView textView = this.textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
            textView = null;
        }
        textView.setMaxWidth(maxWidth);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QSearchShowHighlightTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.highlightWords = new ArrayList();
        ViewUtils viewUtils = ViewUtils.f352270a;
        this.textSize = viewUtils.a(14.0f);
        this.textColor = getContext().getColor(R.color.qui_common_text_primary);
        this.highlightTextColor = getContext().getColor(R.color.qui_common_brand_standard);
        this.realContent = "";
        this.lastMeasuredWidth = -1;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, gp2.a.B6);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "getContext().obtainStyle\u2026le.ShowHighlightTextView)");
        String string = obtainStyledAttributes.getString(gp2.a.C6);
        this.realContent = string != null ? string : "";
        this.textSize = obtainStyledAttributes.getDimension(gp2.a.E6, viewUtils.a(14.0f));
        this.textColor = obtainStyledAttributes.getColor(gp2.a.D6, context.getColor(R.color.qui_common_text_primary));
        obtainStyledAttributes.recycle();
        f(context);
    }
}
