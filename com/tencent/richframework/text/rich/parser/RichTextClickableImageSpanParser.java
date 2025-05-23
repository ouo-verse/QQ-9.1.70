package com.tencent.richframework.text.rich.parser;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.AutoShadowPluginRuntime;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.text.rich.bean.RichTextPreloadParserInfo;
import com.tencent.richframework.text.rich.event.RichTextPreloadEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import nb0.d;

/* loaded from: classes25.dex */
public class RichTextClickableImageSpanParser implements IParseRuleStrategyParser<SpannableStringBuilder> {
    public static final Pattern CLICKABLE_IMAGE_SPAN_TAG_GROUP_PATTERN = Pattern.compile("\\{img:(.*?),w:(\\d+),h:(\\d+),type:(\\d+),id:(.*?)\\}");
    private static final int DEFAULT_ICON_LEFT_PADDING = ViewUtils.dip2px(4.0f);
    private static final int DEFAULT_ICON_RIGHT_PADDING = ViewUtils.dip2px(4.0f);

    /* loaded from: classes25.dex */
    public interface OnStatusListener {
        void onClick(int i3, String str);

        void onLoadImageSuccess(Drawable drawable);
    }

    public static String change2TipsText(String str, int i3, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            StringBuilder sb5 = new StringBuilder(str);
            Matcher matcher = CLICKABLE_IMAGE_SPAN_TAG_GROUP_PATTERN.matcher(sb5);
            int i16 = 0;
            while (matcher.find()) {
                try {
                    if (Integer.parseInt(matcher.group(4)) == i3) {
                        sb5.replace(matcher.start() - i16, matcher.end() - i16, str2);
                        i16 += matcher.group().length() - str2.length();
                    }
                } catch (Exception e16) {
                    QLog.d("RichTextClickableImageSpanParser", 1, "parseClickableImageSpan error=" + e16);
                }
            }
            return sb5.toString();
        }
        return str;
    }

    private static boolean checkRange(Spannable spannable, int i3, int i16) {
        int length;
        if (spannable == null || i3 > (length = spannable.length()) || i16 > length || i3 < 0 || i16 < 0 || i3 > i16) {
            return false;
        }
        return true;
    }

    private static void drawableLoadingMonitor(final OnStatusListener onStatusListener, Drawable drawable) {
        if (!(drawable instanceof URLDrawable)) {
            QLog.e("RichTextClickableImageSpanParser", 1, "drawableLoadingMonitor drawable != URLDrawable");
        } else {
            ((URLDrawable) drawable).setURLDrawableListener(new URLDrawable.URLDrawableListener() { // from class: com.tencent.richframework.text.rich.parser.RichTextClickableImageSpanParser.3
                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
                    QLog.e("RichTextClickableImageSpanParser", 1, "drawableLoadingMonitor onLoadFialed");
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadSuccessed(URLDrawable uRLDrawable) {
                    OnStatusListener onStatusListener2 = OnStatusListener.this;
                    if (onStatusListener2 != null) {
                        onStatusListener2.onLoadImageSuccess(uRLDrawable);
                    }
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadCanceled(URLDrawable uRLDrawable) {
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
                }
            });
        }
    }

    public static String generateContent(String str, int i3, int i16, int i17, String str2) {
        return "{img:" + str + ",w:" + i3 + ",h:" + i16 + ",type:" + i17 + ",id:" + str2 + "}";
    }

    private static ImageSpan getImageSpan(Drawable drawable, int i3, int i16) {
        if (drawable == null) {
            QLog.d("RichTextClickableImageSpanParser", 1, "drawable == null");
            return null;
        }
        drawable.setBounds(new Rect(0, 0, i3, i16));
        d dVar = new d(drawable);
        dVar.a(DEFAULT_ICON_LEFT_PADDING, DEFAULT_ICON_RIGHT_PADDING);
        return dVar;
    }

    public static boolean match(CharSequence charSequence) {
        int indexOf = charSequence.toString().indexOf("{img:");
        if (indexOf >= 0 && indexOf < charSequence.length() - 1) {
            return CLICKABLE_IMAGE_SPAN_TAG_GROUP_PATTERN.matcher(charSequence).find();
        }
        return false;
    }

    public static void parseClickableImageSpan(Spannable spannable, final OnStatusListener onStatusListener) {
        if (TextUtils.isEmpty(spannable)) {
            return;
        }
        Matcher matcher = CLICKABLE_IMAGE_SPAN_TAG_GROUP_PATTERN.matcher(spannable);
        while (matcher.find()) {
            try {
                int start = matcher.start();
                int end = matcher.end();
                if (checkRange(spannable, start, end)) {
                    String group = matcher.group(1);
                    int parseInt = Integer.parseInt(matcher.group(2));
                    int parseInt2 = Integer.parseInt(matcher.group(3));
                    final int parseInt3 = Integer.parseInt(matcher.group(4));
                    final String group2 = matcher.group(5);
                    int dip2px = ViewUtils.dip2px(parseInt);
                    int dip2px2 = ViewUtils.dip2px(parseInt2);
                    Drawable drawable = AutoShadowPluginRuntime.getInstance().getApplication().getResources().getDrawable(R.drawable.f162386o04);
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    obtain.mLoadingDrawable = drawable;
                    obtain.mFailedDrawable = drawable;
                    URLDrawable drawable2 = URLDrawable.getDrawable(group, obtain);
                    drawableLoadingMonitor(onStatusListener, drawable2);
                    spannable.setSpan(getImageSpan(drawable2, dip2px, dip2px2), start, end, 33);
                    spannable.setSpan(new ClickableSpan() { // from class: com.tencent.richframework.text.rich.parser.RichTextClickableImageSpanParser.2
                        @Override // android.text.style.ClickableSpan
                        public void onClick(@NonNull View view) {
                            OnStatusListener onStatusListener2 = OnStatusListener.this;
                            if (onStatusListener2 != null) {
                                onStatusListener2.onClick(parseInt3, group2);
                            }
                        }
                    }, start, end, 33);
                }
            } catch (Exception e16) {
                QLog.d("RichTextClickableImageSpanParser", 1, "parseClickableImageSpan error=" + e16);
                return;
            }
        }
    }

    private SpannableStringBuilder textParser(SpannableStringBuilder spannableStringBuilder, OnStatusListener onStatusListener) {
        parseClickableImageSpan(spannableStringBuilder, onStatusListener);
        return spannableStringBuilder;
    }

    @Override // com.tencent.richframework.text.rich.parser.IParseRuleStrategyParser
    public SpannableStringBuilder ruleParse(SpannableStringBuilder spannableStringBuilder, final RichTextPreloadParserInfo richTextPreloadParserInfo) {
        if (spannableStringBuilder == null) {
            return null;
        }
        textParser(spannableStringBuilder, new OnStatusListener() { // from class: com.tencent.richframework.text.rich.parser.RichTextClickableImageSpanParser.1
            @Override // com.tencent.richframework.text.rich.parser.RichTextClickableImageSpanParser.OnStatusListener
            public void onClick(int i3, String str) {
                RFWPreloadParseRichTextHelper.g().removeSpannableCache(richTextPreloadParserInfo.getCacheKey());
                RichTextPreloadEvent richTextPreloadEvent = new RichTextPreloadEvent(4, richTextPreloadParserInfo.getPreloadBusinessTag(), richTextPreloadParserInfo.getCacheKey());
                richTextPreloadEvent.type = i3;
                richTextPreloadEvent.busiId = str;
                SimpleEventBus.getInstance().dispatchEvent(richTextPreloadEvent);
            }

            @Override // com.tencent.richframework.text.rich.parser.RichTextClickableImageSpanParser.OnStatusListener
            public void onLoadImageSuccess(Drawable drawable) {
                RFWPreloadParseRichTextHelper.g().removeSpannableCache(richTextPreloadParserInfo.getCacheKey());
                SimpleEventBus.getInstance().dispatchEvent(new RichTextPreloadEvent(5, richTextPreloadParserInfo.getPreloadBusinessTag(), richTextPreloadParserInfo.getCacheKey()));
            }
        });
        return spannableStringBuilder;
    }
}
