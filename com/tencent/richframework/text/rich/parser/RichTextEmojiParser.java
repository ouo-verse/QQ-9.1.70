package com.tencent.richframework.text.rich.parser;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostEmotionUtil;
import com.tencent.biz.richframework.AutoShadowPluginRuntime;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.text.rich.bean.RichTextPreloadConfig;
import com.tencent.richframework.text.rich.bean.RichTextPreloadParserInfo;
import com.tencent.richframework.text.rich.event.RichTextPreloadEvent;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import nb0.c;

/* loaded from: classes25.dex */
public class RichTextEmojiParser implements IParseRuleStrategyParser<SpannableStringBuilder> {
    public static final Pattern IMAGE_TAG_GROUP_PATTERN = Pattern.compile("\\{img:(.*?),w:(\\d+),h:(\\d+)\\}");

    /* loaded from: classes25.dex */
    public interface OnDrawableListener {
        void onLoadSuccess(Drawable drawable);
    }

    public static void asyncParseSmiley(RichTextPreloadConfig.TextImageSpanConfig textImageSpanConfig, Spannable spannable, OnDrawableListener onDrawableListener) {
        if (spannable == null) {
            return;
        }
        Matcher matcher = Patterns.PATTERN_EMO.matcher(spannable);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (end <= spannable.length() && start <= end && start >= 0) {
                try {
                    String charSequence = spannable.subSequence(start, end).toString();
                    try {
                        Drawable emoDrawableFromEMCode = HostEmotionUtil.getEmoDrawableFromEMCode(charSequence);
                        if (emoDrawableFromEMCode != null) {
                            emojiDrawableLoadingMonitor(onDrawableListener, emoDrawableFromEMCode);
                            setSpan(textImageSpanConfig, spannable, start, end, emoDrawableFromEMCode);
                        } else {
                            int indexOf = charSequence.indexOf(HostEmotionUtil.EMO_PREFIX()) + HostEmotionUtil.EMO_PREFIX().length();
                            int indexOf2 = charSequence.indexOf(HostEmotionUtil.EMO_TAIL());
                            if (indexOf != -1 && indexOf2 != -1) {
                                loadEmojiDrawable(textImageSpanConfig, spannable, onDrawableListener, start, end, charSequence, indexOf, indexOf2);
                            }
                            return;
                        }
                    } catch (Exception e16) {
                        QLog.e("RichTextEmojiParser", 1, "asyncParseSmiley  e = " + e16.getMessage());
                        e16.printStackTrace();
                    }
                } catch (Exception e17) {
                    QLog.e("RichTextEmojiParser", 1, " e = " + e17.getMessage());
                }
            } else {
                QLog.e("RichTextEmojiParser", 1, "ArrayIndexOutOfBounds  end > spannable.length() || start > end || start < 0");
            }
        }
    }

    private static boolean checkRange(Spannable spannable, int i3, int i16) {
        int length;
        if (spannable == null || i3 > (length = spannable.length()) || i16 > length || i3 < 0 || i16 < 0 || i3 > i16) {
            return false;
        }
        return true;
    }

    private static void emojiDrawableLoadingMonitor(final OnDrawableListener onDrawableListener, Drawable drawable) {
        if (!(drawable instanceof URLDrawable)) {
            return;
        }
        ((URLDrawable) drawable).setURLDrawableListener(new URLDrawable.URLDrawableListener() { // from class: com.tencent.richframework.text.rich.parser.RichTextEmojiParser.2
            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
                QLog.e("RichTextEmojiParser", 1, "emojiDrawableLoadingMonitor onLoadFialed");
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadSuccessed(URLDrawable uRLDrawable) {
                OnDrawableListener onDrawableListener2 = OnDrawableListener.this;
                if (onDrawableListener2 != null) {
                    onDrawableListener2.onLoadSuccess(uRLDrawable);
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

    private static c getEmojiImageSpan(RichTextPreloadConfig.TextImageSpanConfig textImageSpanConfig, Drawable drawable) {
        int dip2px = ViewUtils.dip2px(textImageSpanConfig.getIconSize());
        Rect rect = new Rect(0, 0, dip2px, dip2px);
        if (drawable != null) {
            drawable.setBounds(rect);
            return new c(drawable, textImageSpanConfig.getVerticalAlignment());
        }
        return null;
    }

    protected static void loadEmojiDrawable(RichTextPreloadConfig.TextImageSpanConfig textImageSpanConfig, Spannable spannable, OnDrawableListener onDrawableListener, int i3, int i16, String str, int i17, int i18) {
        String str2;
        String substring = str.substring(i17, i18);
        try {
            str2 = HostEmotionUtil.getEmoUrlFromConfig(substring);
        } catch (Exception unused) {
            str2 = HostEmotionUtil.SIGN_ICON_URL_PREFIX() + substring + HostEmotionUtil.SIGN_ICON_URL_END();
        }
        Drawable drawable = AutoShadowPluginRuntime.getInstance().getApplication().getResources().getDrawable(R.drawable.f162386o04);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        URLDrawable drawable2 = URLDrawable.getDrawable(str2, obtain);
        emojiDrawableLoadingMonitor(onDrawableListener, drawable2);
        setSpan(textImageSpanConfig, spannable, i3, i16, drawable2);
    }

    public static boolean match(CharSequence charSequence) {
        int indexOf = charSequence.toString().indexOf(QzoneEmotionUtils.EMO_PREFIX);
        if (indexOf >= 0 && indexOf < charSequence.length() - 1) {
            return Patterns.PATTERN_EMO.matcher(charSequence).find();
        }
        return false;
    }

    private void parseUrlImageSpan(RichTextPreloadConfig.TextImageSpanConfig textImageSpanConfig, SpannableStringBuilder spannableStringBuilder, OnDrawableListener onDrawableListener) {
        if (TextUtils.isEmpty(spannableStringBuilder)) {
            return;
        }
        Matcher matcher = IMAGE_TAG_GROUP_PATTERN.matcher(spannableStringBuilder);
        while (matcher.find()) {
            try {
                String group = matcher.group(1);
                if (group.startsWith("https://qzonestyle.gtimg.cn/")) {
                    String group2 = matcher.group(2);
                    String group3 = matcher.group(3);
                    int start = matcher.start();
                    int end = matcher.end();
                    Drawable drawable = AutoShadowPluginRuntime.getInstance().getApplication().getResources().getDrawable(R.drawable.f162386o04);
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    obtain.mLoadingDrawable = drawable;
                    obtain.mFailedDrawable = drawable;
                    URLDrawable drawable2 = URLDrawable.getDrawable(group, obtain);
                    emojiDrawableLoadingMonitor(onDrawableListener, drawable2);
                    setSpan(textImageSpanConfig, spannableStringBuilder, start, end, drawable2);
                    try {
                        int parseInt = Integer.parseInt(group3);
                        int parseInt2 = Integer.parseInt(group2);
                        if (parseInt > 0 && parseInt2 > 0) {
                            obtain.mRequestWidth = parseInt2;
                            obtain.mRequestHeight = parseInt;
                        }
                    } catch (Exception e16) {
                        QLog.e("RichTextEmojiParser", 1, e16, new Object[0]);
                    }
                }
            } catch (Exception e17) {
                e17.printStackTrace();
                return;
            }
        }
    }

    private static void setSpan(RichTextPreloadConfig.TextImageSpanConfig textImageSpanConfig, Spannable spannable, int i3, int i16, Drawable drawable) {
        if (drawable != null) {
            try {
                c emojiImageSpan = getEmojiImageSpan(textImageSpanConfig, drawable);
                if (emojiImageSpan != null && checkRange(spannable, i3, i16)) {
                    spannable.setSpan(emojiImageSpan, i3, i16, 33);
                }
            } catch (Exception e16) {
                QLog.d("RichTextEmojiParser", 4, e16.getMessage());
            }
        }
    }

    private SpannableStringBuilder textParser(SpannableStringBuilder spannableStringBuilder, RichTextPreloadConfig.TextImageSpanConfig textImageSpanConfig, OnDrawableListener onDrawableListener) {
        asyncParseSmiley(textImageSpanConfig, spannableStringBuilder, onDrawableListener);
        textImageSpanConfig.setIconSize(textImageSpanConfig.getIconSize());
        parseUrlImageSpan(textImageSpanConfig, spannableStringBuilder, onDrawableListener);
        return spannableStringBuilder;
    }

    @Override // com.tencent.richframework.text.rich.parser.IParseRuleStrategyParser
    public SpannableStringBuilder ruleParse(SpannableStringBuilder spannableStringBuilder, final RichTextPreloadParserInfo richTextPreloadParserInfo) {
        if (spannableStringBuilder == null || richTextPreloadParserInfo == null || richTextPreloadParserInfo.getConfig() == null || richTextPreloadParserInfo.getConfig().getImageSpanConfig() == null) {
            return null;
        }
        textParser(spannableStringBuilder, richTextPreloadParserInfo.getConfig().getImageSpanConfig(), new OnDrawableListener() { // from class: com.tencent.richframework.text.rich.parser.RichTextEmojiParser.1
            @Override // com.tencent.richframework.text.rich.parser.RichTextEmojiParser.OnDrawableListener
            public void onLoadSuccess(Drawable drawable) {
                RFWPreloadParseRichTextHelper.g().removeSpannableCache(richTextPreloadParserInfo.getCacheKey());
                SimpleEventBus.getInstance().dispatchEvent(new RichTextPreloadEvent(1, richTextPreloadParserInfo.getPreloadBusinessTag(), richTextPreloadParserInfo.getCacheKey()));
            }
        });
        return spannableStringBuilder;
    }
}
