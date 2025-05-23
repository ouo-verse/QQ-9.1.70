package com.tencent.richframework.text.rich;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.text.R$styleable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.richframework.text.rich.bean.RichTextPreloadConfig;
import com.tencent.richframework.text.rich.bean.RichTextPreloadParserInfo;
import com.tencent.richframework.text.rich.event.RichTextPreloadEvent;
import com.tencent.richframework.text.rich.parser.Patterns;
import com.tencent.richframework.text.rich.parser.RFWParseRichTextManager;
import com.tencent.richframework.text.rich.parser.RFWPreloadParseRichTextHelper;
import com.tencent.richframework.text.rich.parser.RichTextHashTagParser;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RFWAsyncRichTextView extends RFWSafeTextView implements SimpleEventReceiver {
    private CharSequence currentText;
    private OnClickAtTextListener mAtTextClickListener;
    private OnClickableImageSpanListener mClickableImageSpanListener;
    protected double mDotTextWidth;
    protected int mEmoIconAlignment;
    private CopyOnWriteArrayList<String> mHashTagList;
    private OnClickHashTagTextListener mHashTagTextClickListener;
    private double mIconSizeToTextSize;
    protected boolean mIsEllipsizeEnd;
    private boolean mIsSpanClick;
    private boolean mNeedLayout;
    private boolean mNeedSpecialAreaBold;
    private boolean mNeedSpecialHashTagAreaBackground;
    private OnClickNicknameListener mOnClickNicknameListener;
    protected OnTriggerEllipseListener mOnTriggerEllipseListener;
    protected RichTextPreloadParserInfo mPreloadParserInfo;
    private boolean mShowEllipseEndImageSpan;
    public int mSpecialAreaColorId;
    protected double mSysDotTextWidth;
    public boolean mUseColorInt;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface OnClickAtTextListener {
        void onClick(String str);
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface OnClickHashTagTextListener {
        void onClick(String str);
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface OnClickNicknameListener {
        void onClick(String str);
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface OnClickSearchKeywordListener {
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface OnClickableImageSpanListener {
        void onClick(int i3, String str);
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface OnTriggerEllipseListener {
        void triggerEllipse();
    }

    public RFWAsyncRichTextView(Context context) {
        super(context, null);
        this.mUseColorInt = false;
        this.mSpecialAreaColorId = R.color.coc;
        this.mIconSizeToTextSize = 1.0d;
        this.mNeedLayout = false;
        this.mNeedSpecialHashTagAreaBackground = false;
        initView(context, null);
    }

    private void doOnClickAt(String str) {
        setIsSpanClick(true);
        OnClickAtTextListener onClickAtTextListener = this.mAtTextClickListener;
        if (onClickAtTextListener != null) {
            onClickAtTextListener.onClick(str);
        }
    }

    private void doOnClickHashTag(String str) {
        setIsSpanClick(true);
        OnClickHashTagTextListener onClickHashTagTextListener = this.mHashTagTextClickListener;
        if (onClickHashTagTextListener != null) {
            onClickHashTagTextListener.onClick(str);
        }
    }

    private void doOnClickImageSpan(int i3, String str) {
        setIsSpanClick(true);
        OnClickableImageSpanListener onClickableImageSpanListener = this.mClickableImageSpanListener;
        if (onClickableImageSpanListener != null) {
            onClickableImageSpanListener.onClick(i3, str);
        }
    }

    private void doOnClickNickName(String str) {
        setIsSpanClick(true);
        OnClickNicknameListener onClickNicknameListener = this.mOnClickNicknameListener;
        if (onClickNicknameListener != null) {
            onClickNicknameListener.onClick(str);
        }
    }

    private void doOnClickSearchKeyword(String str) {
        setIsSpanClick(true);
    }

    private SpannableStringBuilder fixContent(CharSequence charSequence, Spannable spannable) {
        if (this.mPreloadParserInfo == null) {
            return new SpannableStringBuilder(spannable);
        }
        int indexOf = charSequence.toString().indexOf(this.mPreloadParserInfo.getPreloadContent().toString());
        SpannableStringBuilder addFrontText = addFrontText(indexOf, spannable, charSequence);
        if (indexOf >= 0 && charSequence.length() > this.mPreloadParserInfo.getPreloadContent().length() + indexOf) {
            addFrontText.append(charSequence.subSequence(indexOf + this.mPreloadParserInfo.getPreloadContent().length(), charSequence.length()));
        }
        return addFrontText;
    }

    private RichTextPreloadConfig getDefaultRichTextConfig() {
        RichTextPreloadConfig.TextImageSpanConfig verticalAlignment = new RichTextPreloadConfig.TextImageSpanConfig().setIconSize((int) (ViewUtils.pxToDp(getLineHeight()) * this.mIconSizeToTextSize)).setVerticalAlignment(this.mEmoIconAlignment);
        return new RichTextPreloadConfig().setImageSpanConfig(verticalAlignment).setAtConfig(new RichTextPreloadConfig.TextAtConfig().setSpecialAreaColorId(this.mSpecialAreaColorId, this.mUseColorInt).setNeedSpecialAreaBold(this.mNeedSpecialAreaBold)).setTagConfig(new RichTextPreloadConfig.TextHashTagConfig().setSpecialAreaColorId(this.mSpecialAreaColorId, this.mUseColorInt).setNeedSpecialAreaBold(this.mNeedSpecialAreaBold).setNeedSpecialHashTagAreaBackground(this.mNeedSpecialHashTagAreaBackground));
    }

    private Spannable getPreloadCacheSpannable(CharSequence charSequence) {
        Spannable spannableCachePool;
        RichTextPreloadParserInfo richTextPreloadParserInfo = this.mPreloadParserInfo;
        if (richTextPreloadParserInfo == null || TextUtils.isEmpty(richTextPreloadParserInfo.getCacheKey()) || (spannableCachePool = RFWPreloadParseRichTextHelper.g().getSpannableCachePool(this.mPreloadParserInfo.getCacheKey())) == null || charSequence == null) {
            return null;
        }
        return fixContent(charSequence, spannableCachePool);
    }

    private void initView(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.EmoText);
        try {
            double d16 = obtainStyledAttributes.getFloat(R$styleable.EmoText_emo_icon_scale, 1.0f);
            this.mIconSizeToTextSize = d16;
            if (d16 <= 0.1d || d16 >= 10.0d) {
                this.mIconSizeToTextSize = 1.0d;
            }
            this.mEmoIconAlignment = obtainStyledAttributes.getInt(R$styleable.EmoText_emo_icon_alignment, 0);
            obtainStyledAttributes.recycle();
            SimpleEventBus.getInstance().registerReceiver(this);
            setSpannableFactory(QQText.SPANNABLE_FACTORY);
        } catch (Throwable th5) {
            obtainStyledAttributes.recycle();
            throw th5;
        }
    }

    private void setRichText(CharSequence charSequence) {
        this.currentText = charSequence;
        setMovementMethod(getDefaultMovementMethod());
        super.setText(parserText(charSequence), (TextView.BufferType) null);
        this.mHashTagList = null;
    }

    protected CharSequence addDotTextAndLastImageSpan(CharSequence charSequence, ImageSpan[] imageSpanArr) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        spannableStringBuilder.append((CharSequence) MiniBoxNoticeInfo.APPNAME_SUFFIX);
        if (imageSpanArr.length > 0) {
            spannableStringBuilder.append((CharSequence) " ");
            spannableStringBuilder.setSpan(imageSpanArr[0], spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
        }
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SpannableStringBuilder addFrontText(int i3, Spanned spanned, CharSequence charSequence) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (i3 > 0 && charSequence != null && charSequence.toString().length() >= i3) {
            spannableStringBuilder.append((CharSequence) new SpannableStringBuilder(new SpannableStringBuilder(charSequence).subSequence(0, i3)));
        }
        spannableStringBuilder.append((CharSequence) spanned);
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public SpannableStringBuilder charSequence2SpannableStringBuilder(CharSequence charSequence) {
        if (charSequence == null) {
            return new SpannableStringBuilder();
        }
        if (charSequence instanceof SpannableStringBuilder) {
            return (SpannableStringBuilder) charSequence;
        }
        return new SpannableStringBuilder(charSequence.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CharSequence cutLastLineEndDot(CharSequence charSequence) {
        if (charSequence == null) {
            return "";
        }
        if (charSequence.toString().endsWith("\u2026")) {
            if (charSequence.length() <= 0) {
                charSequence = "";
            } else {
                charSequence = charSequence.subSequence(0, charSequence.length() - 1);
            }
        }
        ensureInitDotTextWidth();
        ensureInitSysDotTextWidth();
        return charSequence;
    }

    protected CharSequence cutTextForNeedCutWidth(CharSequence charSequence, int i3, int i16, int i17) {
        float textSize = getTextSize();
        int i18 = 0;
        while (i17 < i3) {
            if (charSequence.toString().endsWith(QzoneEmotionUtils.EMO_TAIL)) {
                Matcher matcher = Patterns.PATTERN_EMO.matcher(charSequence);
                while (true) {
                    if (!matcher.find()) {
                        break;
                    }
                    int start = matcher.start();
                    int end = matcher.end();
                    if (start < i16 && end == i16) {
                        i17 = (int) (i17 + textSize);
                        i16 = start;
                        break;
                    }
                }
            } else if (i16 > 0) {
                i17 += (int) Math.floor(getPaint().measureText(charSequence.subSequence(i16 - 1, i16).toString()));
                i16--;
            }
            if (i16 >= 0) {
                charSequence = charSequence.subSequence(0, i16);
            }
            i18++;
            if (i18 > 1000) {
                break;
            }
        }
        return charSequence;
    }

    public void ensureInitDotTextWidth() {
        if (this.mDotTextWidth == 0.0d) {
            this.mDotTextWidth = Math.ceil(getPaint().measureText(MiniBoxNoticeInfo.APPNAME_SUFFIX));
        }
    }

    public void ensureInitSysDotTextWidth() {
        if (this.mSysDotTextWidth == 0.0d) {
            this.mSysDotTextWidth = Math.ceil(getPaint().measureText("\u2026"));
        }
    }

    protected CharSequence fixMultiLineEndImageSpan(CharSequence charSequence) {
        String charSequence2 = charSequence.toString();
        if (!TextUtils.isEmpty(charSequence2) && charSequence2.contains("\n")) {
            return charSequence2.substring(0, charSequence2.indexOf("\n"));
        }
        return charSequence;
    }

    @Override // android.widget.TextView
    protected MovementMethod getDefaultMovementMethod() {
        return LinkMovementMethod.getInstance();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(RichTextPreloadEvent.class);
        return arrayList;
    }

    public CopyOnWriteArrayList<String> getHashTagList() {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = this.mHashTagList;
        if (copyOnWriteArrayList != null) {
            return copyOnWriteArrayList;
        }
        RichTextHashTagParser tagRuleParser = RFWParseRichTextManager.getTagRuleParser();
        if (tagRuleParser == null) {
            return new CopyOnWriteArrayList<>();
        }
        ArrayList<String> textParser = tagRuleParser.textParser(new SpannableStringBuilder(this.currentText), new RichTextPreloadConfig.TextHashTagConfig(), null);
        if (textParser == null || textParser.isEmpty()) {
            textParser = tagRuleParser.specialTextParser(new SpannableStringBuilder(this.currentText), new RichTextPreloadConfig.TextHashTagConfig(), null);
        }
        if (textParser != null && !textParser.isEmpty()) {
            this.mHashTagList = new CopyOnWriteArrayList<>(textParser);
        } else {
            this.mHashTagList = new CopyOnWriteArrayList<>();
        }
        return this.mHashTagList;
    }

    protected double getLastLineWidth(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0d;
        }
        return Math.ceil(getPaint().measureText(charSequence.toString()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getNeedCutWidth(ImageSpan[] imageSpanArr) {
        int i3;
        if (imageSpanArr.length > 0 && imageSpanArr[0].getDrawable() != null) {
            i3 = imageSpanArr[0].getDrawable().getIntrinsicWidth();
        } else {
            i3 = 0;
        }
        return 0 + i3;
    }

    protected int getParseType() {
        return 0;
    }

    protected List<Class> getRestoreSpanClassList() {
        return new ArrayList() { // from class: com.tencent.richframework.text.rich.RFWAsyncRichTextView.1
            {
                add(ClickableSpan.class);
            }
        };
    }

    public boolean isNeedSpecialHashTagAreaBackground() {
        return this.mNeedSpecialHashTagAreaBackground;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isSpanClick() {
        return this.mIsSpanClick;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CharSequence text = getText();
        if (text instanceof SpannableStringBuilder) {
            ((SpannableStringBuilder) text).clearSpans();
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    @RequiresApi(api = 16)
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        if (this.mNeedLayout) {
            showEllipseView();
            this.mNeedLayout = false;
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof RichTextPreloadEvent) {
            RichTextPreloadEvent richTextPreloadEvent = (RichTextPreloadEvent) simpleBaseEvent;
            RichTextPreloadParserInfo richTextPreloadParserInfo = this.mPreloadParserInfo;
            if (richTextPreloadParserInfo != null && TextUtils.equals(richTextPreloadParserInfo.getCacheKey(), richTextPreloadEvent.cacheKey)) {
                switch (richTextPreloadEvent.eventType) {
                    case 1:
                        postInvalidate();
                        return;
                    case 2:
                        doOnClickAt(richTextPreloadEvent.uin);
                        return;
                    case 3:
                        doOnClickHashTag(richTextPreloadEvent.tagName);
                        return;
                    case 4:
                        doOnClickImageSpan(richTextPreloadEvent.type, richTextPreloadEvent.busiId);
                        return;
                    case 5:
                        postInvalidate();
                        return;
                    case 6:
                        doOnClickNickName(richTextPreloadEvent.uin);
                        return;
                    case 7:
                        doOnClickSearchKeyword(richTextPreloadEvent.searchKeyword);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        setFocusable(false);
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Spannable parserText(CharSequence charSequence) {
        SpannableStringBuilder charSequence2SpannableStringBuilder = charSequence2SpannableStringBuilder(charSequence);
        if (getParseType() == 1) {
            return charSequence2SpannableStringBuilder;
        }
        RichTextPreloadParserInfo richTextPreloadParserInfo = this.mPreloadParserInfo;
        if (richTextPreloadParserInfo != null && TextUtils.isEmpty(richTextPreloadParserInfo.getPreloadBusinessTag())) {
            this.mPreloadParserInfo.setPreloadContent(charSequence2SpannableStringBuilder);
            this.mPreloadParserInfo.setCacheKey(null);
        }
        RichTextPreloadParserInfo richTextPreloadParserInfo2 = this.mPreloadParserInfo;
        if (richTextPreloadParserInfo2 != null && richTextPreloadParserInfo2.getConfig() == null) {
            this.mPreloadParserInfo.setConfig(getDefaultRichTextConfig());
        }
        Spannable preloadCacheSpannable = getPreloadCacheSpannable(charSequence);
        if (preloadCacheSpannable != null) {
            return preloadCacheSpannable;
        }
        if (TextUtils.isEmpty(charSequence)) {
            return charSequence2SpannableStringBuilder;
        }
        if (this.mPreloadParserInfo == null) {
            RichTextPreloadParserInfo richTextPreloadParserInfo3 = new RichTextPreloadParserInfo("", new SpannableStringBuilder(charSequence2SpannableStringBuilder));
            this.mPreloadParserInfo = richTextPreloadParserInfo3;
            richTextPreloadParserInfo3.setConfig(getDefaultRichTextConfig());
        }
        Spannable synchroParserBaseRuleText = RFWPreloadParseRichTextHelper.g().synchroParserBaseRuleText(this.mPreloadParserInfo);
        if (synchroParserBaseRuleText != null) {
            return fixContent(charSequence, synchroParserBaseRuleText);
        }
        return charSequence2SpannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void restoreTruncatedSpan(int i3, SpannableStringBuilder spannableStringBuilder) {
        if (TextUtils.isEmpty(getText()) || getMaxLines() < 2) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(getText());
        for (ClickableSpan clickableSpan : (ClickableSpan[]) spannableStringBuilder2.getSpans(getLayout().getLineStart(getMaxLines() - 2), getText().length(), ClickableSpan.class)) {
            int spanStart = spannableStringBuilder2.getSpanStart(clickableSpan);
            int spanEnd = spannableStringBuilder2.getSpanEnd(clickableSpan);
            if (i3 > spanStart && i3 < spanEnd) {
                if (spanEnd > spannableStringBuilder.length()) {
                    spanEnd = spannableStringBuilder.length();
                }
                spannableStringBuilder.setSpan(clickableSpan, spanStart, spanEnd, 33);
                return;
            }
        }
    }

    protected void restoreTruncatedSpanNew(int i3, SpannableStringBuilder spannableStringBuilder) {
        if (TextUtils.isEmpty(getText())) {
            return;
        }
        int i16 = 2;
        if (getMaxLines() < 2) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(getText());
        List<Class> restoreSpanClassList = getRestoreSpanClassList();
        int lineEnd = getLayout().getLineEnd(getMaxLines() - 1);
        long currentTimeMillis = System.currentTimeMillis();
        Iterator<Class> it = restoreSpanClassList.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            Object[] spans = spannableStringBuilder2.getSpans(getLayout().getLineStart(getMaxLines() - i16), lineEnd, it.next());
            if (spans.length > 0) {
                for (Object obj : spans) {
                    int spanStart = spannableStringBuilder2.getSpanStart(obj);
                    int spanEnd = spannableStringBuilder2.getSpanEnd(obj);
                    if (i3 < spanEnd) {
                        if (spanEnd > spannableStringBuilder.length()) {
                            spanEnd = spannableStringBuilder.length();
                        }
                        if (spanEnd > spanStart) {
                            spannableStringBuilder.setSpan(obj, spanStart, spanEnd, 33);
                        }
                    }
                }
                z16 = true;
            }
            i16 = 2;
        }
        if (z16) {
            QLog.i("RFWAsyncRichTextView", 4, "restoreTruncatedSpan cost:" + (System.currentTimeMillis() - currentTimeMillis) + "(ms)");
        }
    }

    public void seOnClickableImageSpanListener(OnClickableImageSpanListener onClickableImageSpanListener) {
        this.mClickableImageSpanListener = onClickableImageSpanListener;
    }

    public void setDynamicText(Object obj, RichTextPreloadParserInfo richTextPreloadParserInfo) {
        if (obj instanceof Spannable) {
            setText((Spannable) obj);
        } else {
            setText(transformDynamicText(obj, richTextPreloadParserInfo));
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (truncateAt == TextUtils.TruncateAt.END && getMaxLines() > 1) {
            this.mIsEllipsizeEnd = true;
        } else {
            this.mIsEllipsizeEnd = false;
            super.setEllipsize(truncateAt);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setIsSpanClick(boolean z16) {
        this.mIsSpanClick = z16;
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i3) {
        super.setMaxLines(i3);
        if (this.mIsEllipsizeEnd && i3 == 1) {
            setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    public void setNeedSpecialAreaBold(boolean z16) {
        this.mNeedSpecialAreaBold = z16;
    }

    public void setNeedSpecialHashTagAreaBackground(boolean z16) {
        this.mNeedSpecialHashTagAreaBackground = z16;
    }

    public void setOnClickAtTextListener(OnClickAtTextListener onClickAtTextListener) {
        this.mAtTextClickListener = onClickAtTextListener;
    }

    public void setOnClickHashTagTextListener(OnClickHashTagTextListener onClickHashTagTextListener) {
        this.mHashTagTextClickListener = onClickHashTagTextListener;
    }

    public void setOnClickNicknameListener(OnClickNicknameListener onClickNicknameListener) {
        this.mOnClickNicknameListener = onClickNicknameListener;
    }

    public void setOnTriggerEllipseListener(OnTriggerEllipseListener onTriggerEllipseListener) {
        this.mOnTriggerEllipseListener = onTriggerEllipseListener;
    }

    public void setPreloadParserInfo(RichTextPreloadParserInfo richTextPreloadParserInfo) {
        this.mPreloadParserInfo = richTextPreloadParserInfo;
    }

    public void setPreloadText(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.mPreloadParserInfo = new RichTextPreloadParserInfo(str, new SpannedString(str2));
        } else {
            this.mPreloadParserInfo = null;
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z16) {
        super.setSingleLine(z16);
        if (this.mIsEllipsizeEnd) {
            setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    public void setSpecialClickAreaColor(int i3) {
        this.mSpecialAreaColorId = i3;
    }

    @Override // com.tencent.richframework.text.rich.RFWSafeTextView, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.mNeedLayout = true;
        setRichText(charSequence);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTextDirectly(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTextWhenShowEllipseView(SpannableStringBuilder spannableStringBuilder) {
        int i3;
        RichTextPreloadParserInfo richTextPreloadParserInfo = this.mPreloadParserInfo;
        if (richTextPreloadParserInfo != null && richTextPreloadParserInfo.getConfig() != null && this.mPreloadParserInfo.getConfig().getImageSpanConfig() != null) {
            i3 = this.mPreloadParserInfo.getConfig().getImageSpanConfig().getIconSize();
        } else {
            i3 = 32;
        }
        super.setText(new QQText(spannableStringBuilder, 3, i3), (TextView.BufferType) null);
    }

    public void showEllipseEndImageSpan(boolean z16) {
        this.mShowEllipseEndImageSpan = z16;
    }

    @RequiresApi(api = 16)
    protected void showEllipseView() {
        CharSequence ellipsize;
        if (this.mIsEllipsizeEnd && getLayout() != null && getLineCount() > getMaxLines() && getMaxLines() > 0) {
            int maxLines = getMaxLines() - 1;
            int lineStart = getLayout().getLineStart(maxLines);
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int lineWidth = (((int) getLayout().getLineWidth(maxLines)) - getPaddingLeft()) - getPaddingRight();
            ensureInitDotTextWidth();
            if (width >= lineWidth + this.mDotTextWidth) {
                ellipsize = ((Object) fixMultiLineEndImageSpan(new SpannableStringBuilder(getText()).subSequence(lineStart, getLayout().getLineEnd(maxLines)))) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
            } else {
                ellipsize = TextUtils.ellipsize(new SpannableStringBuilder(getText()).subSequence(lineStart, getText().length()), getPaint(), width, TextUtils.TruncateAt.END);
            }
            SpannableStringBuilder addFrontText = addFrontText(lineStart, charSequence2SpannableStringBuilder(truncatedShowEndImageSpan(ellipsize)), getText());
            if (useNewRestoreMode()) {
                restoreTruncatedSpanNew(lineStart, addFrontText);
            } else {
                restoreTruncatedSpan(lineStart, addFrontText);
            }
            setTextWhenShowEllipseView(addFrontText);
            OnTriggerEllipseListener onTriggerEllipseListener = this.mOnTriggerEllipseListener;
            if (onTriggerEllipseListener != null) {
                onTriggerEllipseListener.triggerEllipse();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v8, types: [android.text.Spannable] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.tencent.richframework.text.rich.bean.RichTextPreloadParserInfo] */
    public SpannableStringBuilder transformDynamicText(Object obj, RichTextPreloadParserInfo richTextPreloadParserInfo) {
        ?? r16;
        String str = "";
        if (obj != null && (!(obj instanceof CharSequence) || !TextUtils.isEmpty((CharSequence) obj))) {
            if (richTextPreloadParserInfo != 0) {
                setPreloadParserInfo(richTextPreloadParserInfo);
                r16 = RFWPreloadParseRichTextHelper.g().getSpannableCachePool(richTextPreloadParserInfo.getCacheKey());
            } else {
                r16 = 0;
            }
            if (r16 == 0) {
                r16 = RFWPreloadParseRichTextHelper.g().synchroParserDynamicRuleText(obj, richTextPreloadParserInfo);
            }
            boolean z16 = r16 instanceof SpannableStringBuilder;
            SpannableStringBuilder spannableStringBuilder = r16;
            if (!z16) {
                if (r16 != 0) {
                    str = r16;
                }
                spannableStringBuilder = new SpannableStringBuilder(str);
            }
            if (richTextPreloadParserInfo != 0) {
                richTextPreloadParserInfo.setPreloadContent(spannableStringBuilder);
                RFWPreloadParseRichTextHelper.g().putSpannableCache(richTextPreloadParserInfo.getCacheKey(), spannableStringBuilder);
            }
            return spannableStringBuilder;
        }
        return new SpannableStringBuilder("");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CharSequence truncatedShowEndImageSpan(CharSequence charSequence) {
        if (this.mShowEllipseEndImageSpan) {
            CharSequence fixMultiLineEndImageSpan = fixMultiLineEndImageSpan(charSequence);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getText());
            ImageSpan[] imageSpanArr = (ImageSpan[]) spannableStringBuilder.getSpans(spannableStringBuilder.length() - 1, spannableStringBuilder.length(), ImageSpan.class);
            int needCutWidth = getNeedCutWidth(imageSpanArr);
            if (needCutWidth > 0) {
                CharSequence cutLastLineEndDot = cutLastLineEndDot(fixMultiLineEndImageSpan);
                int a16 = needCutWidth + ((int) (this.mDotTextWidth - this.mSysDotTextWidth)) + cx.a(5.0f);
                int length = cutLastLineEndDot.length();
                double lastLineWidth = getLastLineWidth(cutLastLineEndDot);
                int width = (int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) - lastLineWidth);
                QLog.i("RFWAsyncRichTextView", 1, "nowFreeWidth = " + width + " , needCutWidth = " + a16 + " , nowStringLength = " + lastLineWidth + " , lastLine = " + ((Object) cutLastLineEndDot));
                return addDotTextAndLastImageSpan(cutTextForNeedCutWidth(cutLastLineEndDot, a16, length, width), imageSpanArr);
            }
            return fixMultiLineEndImageSpan;
        }
        return charSequence;
    }

    protected boolean useNewRestoreMode() {
        return false;
    }

    public void setSpecialClickAreaColor(int i3, boolean z16) {
        setSpecialClickAreaColor(i3);
        this.mUseColorInt = z16;
    }

    public void setText(CharSequence charSequence, boolean z16) {
        this.mNeedSpecialHashTagAreaBackground = z16;
        setText(charSequence, (TextView.BufferType) null);
    }

    public RFWAsyncRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mUseColorInt = false;
        this.mSpecialAreaColorId = R.color.coc;
        this.mIconSizeToTextSize = 1.0d;
        this.mNeedLayout = false;
        this.mNeedSpecialHashTagAreaBackground = false;
        try {
            initView(context, attributeSet);
        } catch (Throwable unused) {
            Log.d("RFWAsyncRichTextView", "RFWAsyncRichTextView: ");
        }
    }

    public RFWAsyncRichTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mUseColorInt = false;
        this.mSpecialAreaColorId = R.color.coc;
        this.mIconSizeToTextSize = 1.0d;
        this.mNeedLayout = false;
        this.mNeedSpecialHashTagAreaBackground = false;
        initView(context, attributeSet);
    }

    public void setOnClickSearchKeywordListener(OnClickSearchKeywordListener onClickSearchKeywordListener) {
    }
}
