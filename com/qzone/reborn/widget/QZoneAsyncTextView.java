package com.qzone.reborn.widget;

import android.content.Context;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.qzone.proxy.feedcomponent.model.CellLikeInfo;
import com.qzone.reborn.util.n;
import com.tencent.biz.qqcircle.utils.bg;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView;
import com.tencent.richframework.text.rich.bean.RichTextPreloadConfig;
import com.tencent.richframework.text.rich.bean.RichTextPreloadParserInfo;
import com.tencent.richframework.text.rich.parser.RFWParseRichTextManager;
import com.tencent.richframework.text.rich.parser.RFWPreloadParseRichTextHelper;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneAsyncTextView extends RFWAsyncRichTextView {
    private Spannable C;
    private int D;
    private int E;

    /* renamed from: h, reason: collision with root package name */
    private int f59602h;

    /* renamed from: i, reason: collision with root package name */
    private int f59603i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f59604m;

    public QZoneAsyncTextView(Context context) {
        this(context, null);
    }

    private SpannableStringBuilder a(Object obj, RichTextPreloadParserInfo richTextPreloadParserInfo) {
        if (!(obj instanceof CellLikeInfo)) {
            return new SpannableStringBuilder("");
        }
        return h(obj, richTextPreloadParserInfo);
    }

    private RichTextPreloadConfig e() {
        return new RichTextPreloadConfig();
    }

    private RichTextPreloadParserInfo f(CharSequence charSequence) {
        RichTextPreloadParserInfo richTextPreloadParserInfo = new RichTextPreloadParserInfo("", new SpannableStringBuilder(charSequence));
        richTextPreloadParserInfo.setDynamicParserClass(n.class);
        richTextPreloadParserInfo.setConfig(g());
        return richTextPreloadParserInfo;
    }

    private RichTextPreloadConfig g() {
        RichTextPreloadConfig.TextImageSpanConfig verticalAlignment = new RichTextPreloadConfig.TextImageSpanConfig().setIconSize(ViewUtils.pxToDp(getLineHeight())).setVerticalAlignment(this.mEmoIconAlignment);
        return new RichTextPreloadConfig().setImageSpanConfig(verticalAlignment).setAtConfig(new RichTextPreloadConfig.TextAtConfig().setSpecialAreaColorId(this.f59603i).setNeedSpecialAreaBold(false)).setTagConfig(new RichTextPreloadConfig.TextHashTagConfig().setSpecialAreaColorId(this.f59602h).setNeedSpecialAreaBold(false).setIsClickable(this.f59604m).setNeedSpecialHashTagAreaBackground(false));
    }

    private CharSequence i(int i3) {
        if (!TextUtils.isEmpty(this.C) && i3 <= this.C.length()) {
            CharSequence subSequence = this.C.subSequence(0, i3);
            return subSequence.toString().endsWith("\n") ? subSequence.subSequence(0, subSequence.length() - 1) : subSequence;
        }
        return this.C;
    }

    private int j(int i3, int i16, int i17) {
        String charSequence;
        if (TextUtils.isEmpty(this.C)) {
            charSequence = "";
        } else {
            charSequence = this.C.subSequence(0, i17).toString();
        }
        return k(i3, i16, i17, i17, bg.c(charSequence).getIndexList(), r6.size() - 1);
    }

    private RichTextPreloadParserInfo l() {
        RichTextPreloadParserInfo richTextPreloadParserInfo = new RichTextPreloadParserInfo("", new SpannableStringBuilder());
        richTextPreloadParserInfo.setDynamicParserClass(go.a.class);
        richTextPreloadParserInfo.setConfig(e());
        return richTextPreloadParserInfo;
    }

    private String m() {
        return "... ";
    }

    private Spannable n() {
        int width;
        long currentTimeMillis = System.currentTimeMillis();
        if (TextUtils.isEmpty(this.C)) {
            QLog.e("QZoneShaiShaiAsyncTextView", 1, "getRealContent mSourceContent is empty");
            return this.C;
        }
        if (this.E <= 0) {
            if (getLayoutParams() != null && getLayoutParams().width > 0) {
                width = getLayoutParams().width;
            } else {
                width = getWidth();
            }
            this.E = width;
        }
        int i3 = this.E;
        if (i3 <= 0) {
            return this.C;
        }
        int paddingLeft = (i3 - getPaddingLeft()) - getPaddingRight();
        DynamicLayout dynamicLayout = new DynamicLayout(this.C, getPaint(), paddingLeft, Layout.Alignment.ALIGN_NORMAL, getLineSpacingMultiplier(), getLineSpacingExtra(), true);
        if (dynamicLayout.getLineCount() <= this.D) {
            return this.C;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int i16 = this.D - 1;
        CharSequence i17 = i(j(paddingLeft, dynamicLayout.getLineStart(i16), dynamicLayout.getLineEnd(i16)));
        String m3 = m();
        spannableStringBuilder.append(i17);
        spannableStringBuilder.append((CharSequence) m3);
        QLog.d("QZoneShaiShaiAsyncTextView", 1, "getRealContent , cosTime = " + (System.currentTimeMillis() - currentTimeMillis));
        return spannableStringBuilder;
    }

    @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView
    /* renamed from: getParseType */
    protected int getGuildParseType() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView
    public Spannable parserText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return null;
        }
        Spannable parserText = super.parserText(charSequence);
        if (this.D <= 0) {
            return parserText;
        }
        this.C = new SpannableStringBuilder(parserText);
        return n();
    }

    public void setAtTextColor(int i3) {
        this.f59603i = i3;
    }

    public void setExactWidth(int i3) {
        this.E = i3;
    }

    public void setIsClickable(boolean z16) {
        this.f59604m = z16;
    }

    public void setTagTextColor(int i3) {
        this.f59602h = i3;
    }

    public QZoneAsyncTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QZoneAsyncTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f59602h = R.color.qui_common_brand_standard;
        this.f59603i = R.color.qui_common_brand_standard;
        this.f59604m = true;
        this.D = -1;
        this.D = getContext().obtainStyledAttributes(attributeSet, e4.a.f395576b, i3, 0).getInt(0, -1);
    }

    private SpannableStringBuilder b(Object obj, RichTextPreloadParserInfo richTextPreloadParserInfo) {
        if (obj != null && (!(obj instanceof CharSequence) || !TextUtils.isEmpty((CharSequence) obj))) {
            return h(obj, richTextPreloadParserInfo);
        }
        return new SpannableStringBuilder("");
    }

    private SpannableStringBuilder h(Object obj, RichTextPreloadParserInfo richTextPreloadParserInfo) {
        CharSequence charSequence;
        if (richTextPreloadParserInfo != null) {
            setPreloadParserInfo(richTextPreloadParserInfo);
            charSequence = RFWPreloadParseRichTextHelper.g().getSpannableCachePool(richTextPreloadParserInfo.getCacheKey());
        } else {
            charSequence = null;
        }
        if (charSequence == null) {
            charSequence = d(obj, richTextPreloadParserInfo);
        }
        if (charSequence instanceof SpannableStringBuilder) {
            return (SpannableStringBuilder) charSequence;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        return new SpannableStringBuilder(charSequence);
    }

    @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView
    public void setDynamicText(Object obj, RichTextPreloadParserInfo richTextPreloadParserInfo) {
        if (richTextPreloadParserInfo != null) {
            super.setDynamicText(obj, richTextPreloadParserInfo);
            return;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            setText(b(new SpannableStringBuilder(charSequence), f(charSequence)));
        } else if (obj instanceof CellLikeInfo) {
            setText(a(obj, l()));
        }
    }

    private Spannable d(Object obj, RichTextPreloadParserInfo richTextPreloadParserInfo) {
        if (richTextPreloadParserInfo == null || obj == null) {
            return null;
        }
        try {
            return RFWParseRichTextManager.parseDynamicRule(obj, richTextPreloadParserInfo);
        } catch (Throwable th5) {
            QLog.e("QZoneShaiShaiAsyncTextView", 2, "[preloadParserDynamicRuleText] error: ", th5);
            return null;
        }
    }

    private int k(int i3, int i16, int i17, int i18, List<int[]> list, int i19) {
        if (i18 > i17) {
            return i17;
        }
        if (i18 <= i16) {
            return i16;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(i(i18));
        spannableStringBuilder.append((CharSequence) m());
        if (new DynamicLayout(spannableStringBuilder, getPaint(), i3, Layout.Alignment.ALIGN_NORMAL, getLineSpacingMultiplier(), getLineSpacingExtra(), true).getLineCount() <= this.D) {
            return i18;
        }
        int[] iArr = (i19 <= 0 || list == null || list.size() <= i19) ? null : list.get(i19);
        if (iArr != null && iArr.length == 2 && iArr[1] == i18) {
            return k(i3, i16, i17, iArr[0], list, i19 - 1);
        }
        return i18 < 1 ? i18 : k(i3, i16, i17, i18 - 1, list, i19);
    }
}
