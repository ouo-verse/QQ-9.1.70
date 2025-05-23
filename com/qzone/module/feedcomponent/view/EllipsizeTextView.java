package com.qzone.module.feedcomponent.view;

import android.content.Context;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class EllipsizeTextView extends TextView {
    public static final String DEFAULT_ELLIPSIZE_TEXT = "\u2026";
    private int mEllipsizeIndex;
    private int mEllipsizeStart;
    private CharSequence mEllipsizeText;
    private boolean mEnableUpdateOriginText;
    private boolean mIsExactlyMode;
    private int mMaxLines;
    private CharSequence mOriginText;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class Range<T extends Comparable<? super T>> {
        private final T mLower;
        private final T mUpper;

        public Range(T t16, T t17) {
            this.mLower = t16;
            this.mUpper = t17;
            if (t16.compareTo(t17) > 0) {
                throw new IllegalArgumentException("lower must be less than or equal to upper");
            }
        }

        public boolean contains(T t16) {
            return (t16.compareTo(this.mLower) >= 0) && (t16.compareTo(this.mUpper) < 0);
        }

        public T getLower() {
            return this.mLower;
        }

        public T getUpper() {
            return this.mUpper;
        }
    }

    public EllipsizeTextView(Context context) {
        this(context, null);
    }

    private void adjustEllipsizeEndText(Layout layout) {
        CharSequence charSequence = this.mOriginText;
        CharSequence subSequence = charSequence.subSequence(this.mEllipsizeIndex, charSequence.length());
        int width = (layout.getWidth() - getPaddingLeft()) - getPaddingRight();
        int max = Math.max(1, computeMaxLineCount(layout)) - 1;
        int lineWidth = (int) layout.getLineWidth(max);
        int lineEnd = layout.getLineEnd(max);
        int desiredWidth = ((int) (Layout.getDesiredWidth(this.mEllipsizeText, getPaint()) + Layout.getDesiredWidth(subSequence, getPaint()))) + 1;
        this.mEnableUpdateOriginText = false;
        int i3 = lineWidth + desiredWidth;
        if (i3 > width) {
            int computeRemovedEllipsizeEndCharacterCount = computeRemovedEllipsizeEndCharacterCount(i3 - width, charSequence.subSequence(0, lineEnd));
            setText(charSequence.subSequence(0, this.mEllipsizeStart));
            int i16 = this.mEllipsizeIndex;
            int i17 = this.mEllipsizeStart;
            int i18 = i16 - i17;
            if (i18 > computeRemovedEllipsizeEndCharacterCount) {
                append(charSequence.subSequence(i17, (i18 + i17) - computeRemovedEllipsizeEndCharacterCount));
            } else {
                append(charSequence.subSequence(i17, i17 + 1));
            }
            append(this.mEllipsizeText);
            append(subSequence);
            setEllipsize(TextUtils.TruncateAt.END);
        } else {
            setText(charSequence.subSequence(0, lineEnd));
            append(this.mEllipsizeText);
            append(subSequence);
        }
        this.mEnableUpdateOriginText = true;
    }

    private List<Range<Integer>> computeCharacterStyleRanges(CharSequence charSequence) {
        SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(charSequence);
        CharacterStyle[] characterStyleArr = (CharacterStyle[]) valueOf.getSpans(0, valueOf.length(), CharacterStyle.class);
        if (characterStyleArr != null && characterStyleArr.length != 0) {
            ArrayList arrayList = new ArrayList();
            for (CharacterStyle characterStyle : characterStyleArr) {
                arrayList.add(new Range(Integer.valueOf(valueOf.getSpanStart(characterStyle)), Integer.valueOf(valueOf.getSpanEnd(characterStyle))));
            }
            return arrayList;
        }
        return Collections.EMPTY_LIST;
    }

    private int computeMaxLineCount(Layout layout) {
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        for (int i3 = 0; i3 < layout.getLineCount(); i3++) {
            if (measuredHeight < layout.getLineBottom(i3)) {
                return i3;
            }
        }
        return layout.getLineCount();
    }

    private int computeRemovedEllipsizeEndCharacterCount(int i3, CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return 0;
        }
        List<Range<Integer>> computeCharacterStyleRanges = computeCharacterStyleRanges(charSequence);
        String charSequence2 = charSequence.toString();
        charSequence.length();
        int codePointCount = charSequence2.codePointCount(0, charSequence.length());
        int i16 = 0;
        while (codePointCount > 0 && i3 > i16) {
            codePointCount--;
            int offsetByCodePoints = charSequence2.offsetByCodePoints(0, codePointCount);
            Range<Integer> computeCharacterStyleRange = computeCharacterStyleRange(computeCharacterStyleRanges, offsetByCodePoints);
            if (computeCharacterStyleRange != null) {
                offsetByCodePoints = computeCharacterStyleRange.getLower().intValue();
                codePointCount = charSequence2.codePointCount(0, offsetByCodePoints);
            }
            i16 = (int) Layout.getDesiredWidth(charSequence.subSequence(offsetByCodePoints, charSequence.length()), getPaint());
        }
        return charSequence.length() - charSequence2.offsetByCodePoints(0, codePointCount);
    }

    private boolean isExceedMaxLine(Layout layout) {
        int lineCount = layout.getLineCount();
        int i3 = this.mMaxLines;
        return lineCount > i3 && i3 > 0;
    }

    private boolean isOutOfBounds(Layout layout) {
        return true;
    }

    public void setEllipsizeText(CharSequence charSequence, int i3, int i16) {
        this.mEllipsizeText = charSequence;
        this.mEllipsizeStart = i3;
        this.mEllipsizeIndex = i16;
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i3) {
        if (this.mMaxLines != i3) {
            super.setMaxLines(i3);
            this.mMaxLines = i3;
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (this.mEnableUpdateOriginText) {
            this.mOriginText = charSequence;
        }
        super.setText(charSequence, bufferType);
        if (this.mIsExactlyMode) {
            requestLayout();
        }
    }

    public EllipsizeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mEllipsizeText = "\u2026";
        this.mMaxLines = 1;
        this.mEnableUpdateOriginText = true;
        this.mEllipsizeIndex = 0;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i16) {
        setSingleLine(false);
        setText(this.mOriginText);
        super.onMeasure(i3, i16);
        try {
            this.mIsExactlyMode = View.MeasureSpec.getMode(i3) == 1073741824;
            Layout layout = getLayout();
            if (layout != null) {
                setSingleLine(true);
                if (isExceedMaxLine(layout) || isOutOfBounds(layout)) {
                    adjustEllipsizeEndText(layout);
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private Range<Integer> computeCharacterStyleRange(List<Range<Integer>> list, int i3) {
        if (list != null && !list.isEmpty()) {
            for (Range<Integer> range : list) {
                if (range.contains(Integer.valueOf(i3))) {
                    return range;
                }
            }
        }
        return null;
    }
}
