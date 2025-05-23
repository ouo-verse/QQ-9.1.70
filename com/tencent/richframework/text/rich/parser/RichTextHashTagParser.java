package com.tencent.richframework.text.rich.parser;

import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ImageSpan;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.AutoShadowPluginRuntime;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.text.rich.bean.RichTextPreloadConfig;
import com.tencent.richframework.text.rich.bean.RichTextPreloadParserInfo;
import com.tencent.richframework.text.rich.event.RichTextPreloadEvent;
import com.tencent.richframework.text.rich.span.BoldClickableSpan;
import com.tencent.richframework.text.rich.span.RoundBackgroundColorSpan;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import nb0.c;

/* loaded from: classes25.dex */
public class RichTextHashTagParser implements IParseRuleStrategyParser<SpannableStringBuilder> {
    private BoldClickableSpan.OnClickBoldTextListener mLocalListener;
    public static final Pattern HASH_TAG_PATTERN = Pattern.compile("#?\\{tagName=.*?\\}");
    public static final Pattern HASH_TAG_PATTERN_V2 = Pattern.compile("#?\\{type=(\\d),tagName=(.*?)\\}");
    private static final int DEFAULT_ICON_LEFT_PADDING = ViewUtils.dip2px(4.0f);
    private static final int DEFAULT_ICON_RIGHT_PADDING = ViewUtils.dip2px(-2.0f);
    private static final int ICON_HASHTAG_HOT = R.drawable.ns6;
    private static final int ICON_HASHTAG_NEW = R.drawable.ns7;
    private static final int ICON_HASHTAG_RECOMMEND = R.drawable.ns8;
    private static final int ICON_HASHTAG_DEFAULT = R.drawable.f162386o04;

    private void addBoldClickSpan(SpannableStringBuilder spannableStringBuilder, int i3, int i16, BoldClickableSpan.OnClickBoldTextListener onClickBoldTextListener, int i17, boolean z16, boolean z17, RichTextPreloadEvent richTextPreloadEvent) {
        if (!TextUtils.isEmpty(spannableStringBuilder) && i16 >= i3 && spannableStringBuilder.length() >= i16) {
            if (!z16 && QCircleSkinHelper.getInstance().isExistsColorRes(i17)) {
                i17 = QCircleSkinHelper.getInstance().getColor(i17);
            }
            spannableStringBuilder.setSpan(new BoldClickableSpan(onClickBoldTextListener, i17, z17, richTextPreloadEvent), i3, i16, 33);
        }
    }

    private void checkNewLocalListener() {
        if (this.mLocalListener == null) {
            this.mLocalListener = new BoldClickableSpan.OnClickBoldTextListener() { // from class: com.tencent.richframework.text.rich.parser.RichTextHashTagParser.1
                @Override // com.tencent.richframework.text.rich.span.BoldClickableSpan.OnClickBoldTextListener
                public void onClick(Object obj) {
                    if (!(obj instanceof RichTextPreloadEvent)) {
                        return;
                    }
                    SimpleEventBus.getInstance().dispatchEvent((RichTextPreloadEvent) obj);
                }
            };
        }
    }

    private static boolean checkRange(Spannable spannable, int i3, int i16) {
        int length;
        if (spannable == null || i3 > (length = spannable.length()) || i16 > length || i3 < 0 || i16 < 0 || i3 > i16) {
            return false;
        }
        return true;
    }

    private static ImageSpan getImageSpan(Drawable drawable) {
        if (drawable == null) {
            QLog.d("RichTextTagParser", 1, "drawable == null");
            return null;
        }
        c cVar = new c(drawable);
        cVar.a(DEFAULT_ICON_LEFT_PADDING, DEFAULT_ICON_RIGHT_PADDING);
        return cVar;
    }

    private int getImgUrl(int i3) {
        if (i3 != 5) {
            if (i3 != 6) {
                if (i3 != 7) {
                    return ICON_HASHTAG_DEFAULT;
                }
                return ICON_HASHTAG_HOT;
            }
            return ICON_HASHTAG_RECOMMEND;
        }
        return ICON_HASHTAG_NEW;
    }

    private RichTextPreloadConfig.TextHashTagConfig setSpanBackgroundColor(int i3, RichTextPreloadConfig.TextHashTagConfig textHashTagConfig) {
        if (textHashTagConfig == null) {
            return null;
        }
        if (i3 != 5) {
            if (i3 != 6) {
                if (i3 == 7) {
                    textHashTagConfig.setSpecialAreaHasBackgroundColorId(R.color.qvideo_skin_color_tag_hot_bg).setSpecialAreaHashTagBackgroundColorId(R.color.qvideo_skin_color_tag_hot);
                }
            } else {
                textHashTagConfig.setSpecialAreaHasBackgroundColorId(R.color.qvideo_skin_color_tag_recom_bg).setSpecialAreaHashTagBackgroundColorId(R.color.qvideo_skin_color_tag_recom);
            }
        } else {
            textHashTagConfig.setSpecialAreaHasBackgroundColorId(R.color.qvideo_skin_color_tag_new_bg).setSpecialAreaHashTagBackgroundColorId(R.color.qvideo_skin_color_tag_new);
        }
        return textHashTagConfig;
    }

    public ArrayList<String> specialTextParser(SpannableStringBuilder spannableStringBuilder, RichTextPreloadConfig.TextHashTagConfig textHashTagConfig, RichTextPreloadParserInfo richTextPreloadParserInfo) {
        String str;
        int i3;
        ArrayList<String> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(spannableStringBuilder)) {
            return arrayList;
        }
        Matcher matcher = HASH_TAG_PATTERN_V2.matcher(spannableStringBuilder);
        int i16 = 0;
        RichTextPreloadConfig.TextHashTagConfig textHashTagConfig2 = textHashTagConfig;
        int i17 = 0;
        while (matcher.find()) {
            try {
                int start = matcher.start() - i17;
                int end = matcher.end() - i17;
                if (checkRange(spannableStringBuilder, start, end)) {
                    String group = matcher.group(1);
                    String group2 = matcher.group(2);
                    String substring = group2.substring(i16, group2.length());
                    if (textHashTagConfig2.isNeedSpecialHashTagAreaBackground()) {
                        str = "  # " + substring + "  ";
                    } else {
                        str = " # " + substring + " ";
                    }
                    spannableStringBuilder.replace(start, end, (CharSequence) str);
                    int length = i17 + ((group.length() + group2.length()) - str.length()) + 17;
                    int length2 = str.length() + start;
                    if (length2 == spannableStringBuilder.length()) {
                        i3 = 1;
                    } else {
                        i3 = i16;
                    }
                    arrayList.add(substring);
                    int parseInt = Integer.parseInt(group);
                    int dip2px = ViewUtils.dip2px(13.0f);
                    int dip2px2 = ViewUtils.dip2px(13.0f);
                    if (textHashTagConfig2.isNeedSpecialHashTagAreaBackground()) {
                        Drawable drawable = AutoShadowPluginRuntime.getInstance().getApplication().getResources().getDrawable(getImgUrl(parseInt));
                        drawable.setBounds(i16, i16, dip2px, dip2px2);
                        Object imageSpan = getImageSpan(drawable);
                        textHashTagConfig2 = setSpanBackgroundColor(parseInt, textHashTagConfig2);
                        RoundBackgroundColorSpan roundBackgroundColorSpan = new RoundBackgroundColorSpan(textHashTagConfig2.getSpecialAreaHasBackgroundColorId(), textHashTagConfig2.getSpecialAreaHashTagBackgroundColorId());
                        roundBackgroundColorSpan.setDrawable(drawable);
                        int i18 = start + 1;
                        int i19 = length2 - 1;
                        spannableStringBuilder.setSpan(roundBackgroundColorSpan, i18, i19, 17);
                        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(ImmersiveUtils.dpToPx(13.0f)), i18, i19, 17);
                        spannableStringBuilder.setSpan(imageSpan, start, i18, 33);
                        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(cx.a(4.0f)), start, i18, 17);
                        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(cx.a(4.0f)), i19, length2, 17);
                    } else {
                        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(cx.a(4.0f)), start, start + 1, 17);
                        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(cx.a(4.0f)), start + 2, start + 3, 17);
                        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(cx.a(4.0f)), length2 - 1, length2, 17);
                    }
                    RichTextPreloadConfig.TextHashTagConfig textHashTagConfig3 = textHashTagConfig2;
                    if (richTextPreloadParserInfo != null) {
                        checkNewLocalListener();
                        RichTextPreloadEvent richTextPreloadEvent = new RichTextPreloadEvent(3, richTextPreloadParserInfo.getPreloadBusinessTag(), richTextPreloadParserInfo.getCacheKey());
                        richTextPreloadEvent.tagName = substring;
                        addBoldClickSpan(spannableStringBuilder, start, length2 - i3, this.mLocalListener, textHashTagConfig3.getSpecialAreaColorId(), textHashTagConfig3.isUseColorInt(), textHashTagConfig3.isNeedSpecialAreaBold(), richTextPreloadEvent);
                    }
                    textHashTagConfig2 = textHashTagConfig3;
                    i17 = length;
                    i16 = 0;
                }
            } catch (Exception e16) {
                QLog.e("RichTextTagParser", 1, e16, new Object[0]);
            }
        }
        return arrayList;
    }

    public ArrayList<String> textParser(SpannableStringBuilder spannableStringBuilder, RichTextPreloadConfig.TextHashTagConfig textHashTagConfig, RichTextPreloadParserInfo richTextPreloadParserInfo) {
        int i3;
        int i16;
        ArrayList<String> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(spannableStringBuilder)) {
            return arrayList;
        }
        Matcher matcher = HASH_TAG_PATTERN.matcher(spannableStringBuilder);
        int i17 = 0;
        while (matcher.find()) {
            try {
                int start = matcher.start() - i17;
                int end = matcher.end() - i17;
                String group = matcher.group();
                String substring = group.substring(group.indexOf("tagName=") + 8, group.indexOf("}"));
                String str = " # " + substring + " ";
                spannableStringBuilder.replace(start, end, (CharSequence) str);
                int length = i17 + (group.length() - str.length());
                int length2 = start + str.length();
                if (length2 == spannableStringBuilder.length()) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if (richTextPreloadParserInfo != null) {
                    checkNewLocalListener();
                    RichTextPreloadEvent richTextPreloadEvent = new RichTextPreloadEvent(3, richTextPreloadParserInfo.getPreloadBusinessTag(), richTextPreloadParserInfo.getCacheKey());
                    richTextPreloadEvent.tagName = substring;
                    i16 = length2;
                    addBoldClickSpan(spannableStringBuilder, start, length2 - i3, this.mLocalListener, textHashTagConfig.getSpecialAreaColorId(), textHashTagConfig.isUseColorInt(), textHashTagConfig.isNeedSpecialAreaBold(), richTextPreloadEvent);
                } else {
                    i16 = length2;
                }
                arrayList.add(substring);
                if (textHashTagConfig.isNeedSpecialHashTagAreaBackground()) {
                    int i18 = start + 1;
                    int i19 = i16 - 1;
                    spannableStringBuilder.setSpan(new RoundBackgroundColorSpan(textHashTagConfig.getSpecialAreaHasBackgroundColorId(), textHashTagConfig.getSpecialAreaHashTagBackgroundColorId()), i18, i19, 17);
                    spannableStringBuilder.setSpan(new AbsoluteSizeSpan(cx.a(4.0f)), start, i18, 17);
                    spannableStringBuilder.setSpan(new AbsoluteSizeSpan(cx.a(4.0f)), i19, i16, 17);
                } else {
                    spannableStringBuilder.setSpan(new AbsoluteSizeSpan(cx.a(4.0f)), start, start + 1, 17);
                    spannableStringBuilder.setSpan(new AbsoluteSizeSpan(cx.a(4.0f)), start + 2, start + 3, 17);
                    spannableStringBuilder.setSpan(new AbsoluteSizeSpan(cx.a(4.0f)), i16 - 1, i16, 17);
                }
                i17 = length;
            } catch (Exception e16) {
                QLog.e("RichTextTagParser", 1, e16, new Object[0]);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.richframework.text.rich.parser.IParseRuleStrategyParser
    public SpannableStringBuilder ruleParse(SpannableStringBuilder spannableStringBuilder, RichTextPreloadParserInfo richTextPreloadParserInfo) {
        if (spannableStringBuilder == null || richTextPreloadParserInfo == null || richTextPreloadParserInfo.getConfig() == null || richTextPreloadParserInfo.getConfig().getTagConfig() == null) {
            return null;
        }
        specialTextParser(spannableStringBuilder, richTextPreloadParserInfo.getConfig().getTagConfig(), richTextPreloadParserInfo);
        textParser(spannableStringBuilder, richTextPreloadParserInfo.getConfig().getTagConfig(), richTextPreloadParserInfo);
        return spannableStringBuilder;
    }
}
