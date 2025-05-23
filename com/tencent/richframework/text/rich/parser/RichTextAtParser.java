package com.tencent.richframework.text.rich.parser;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.text.rich.bean.RFWFriend;
import com.tencent.richframework.text.rich.bean.RichTextPreloadConfig;
import com.tencent.richframework.text.rich.bean.RichTextPreloadParserInfo;
import com.tencent.richframework.text.rich.event.RichTextPreloadEvent;
import com.tencent.richframework.text.rich.span.BoldClickableSpan;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes25.dex */
public class RichTextAtParser implements IParseRuleStrategyParser<SpannableStringBuilder> {
    public static final Pattern AT_PATTERN = Pattern.compile("@?\\{uin:\\d+,nick(name)?:.*?\\}");
    private BoldClickableSpan.OnClickBoldTextListener mLocalListener;

    private void addBoldClickSpan(SpannableStringBuilder spannableStringBuilder, int i3, int i16, BoldClickableSpan.OnClickBoldTextListener onClickBoldTextListener, int i17, boolean z16, boolean z17, RichTextPreloadEvent richTextPreloadEvent) {
        if (!TextUtils.isEmpty(spannableStringBuilder) && i16 >= i3 && spannableStringBuilder.length() >= i16) {
            if (!z16) {
                i17 = QCircleSkinHelper.getInstance().getColor(i17);
            }
            spannableStringBuilder.setSpan(new BoldClickableSpan(onClickBoldTextListener, i17, z17, richTextPreloadEvent), i3, i16, 33);
        }
    }

    public static String changeAT2PlainText(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder(str);
        Matcher matcher = AT_PATTERN.matcher(sb5);
        int i3 = 0;
        while (matcher.find()) {
            try {
                int start = matcher.start() - i3;
                int end = matcher.end() - i3;
                String group = matcher.group();
                String str2 = "@" + group.substring(group.indexOf(",nick:") + 6, group.length() - 1).replace("%25", "%").replace("%2C", ",").replace("%7D", "}").replace("%7B", "{").replace("%3A", ":").replace("%3E", ">");
                sb5.replace(start, end, str2);
                i3 += group.length() - str2.length();
            } catch (Exception e16) {
                QLog.e("RichTextAtParser", 1, e16, new Object[0]);
            }
        }
        return sb5.toString();
    }

    private void checkNewLocalListener() {
        if (this.mLocalListener == null) {
            this.mLocalListener = new BoldClickableSpan.OnClickBoldTextListener() { // from class: com.tencent.richframework.text.rich.parser.RichTextAtParser.1
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

    private long getUin(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e16) {
            QLog.e("RichTextAtParser", 1, "uin trans exception, msg = " + e16);
            return 0L;
        }
    }

    private SpannableStringBuilder handleNicknameRichText(String str, RichTextPreloadConfig.TextImageSpanConfig textImageSpanConfig) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (!TextUtils.isEmpty(str) && str.contains("/")) {
            RichTextEmojiParser.asyncParseSmiley(textImageSpanConfig, spannableStringBuilder, null);
        }
        return spannableStringBuilder;
    }

    private void textParser(SpannableStringBuilder spannableStringBuilder, RichTextPreloadConfig.TextAtConfig textAtConfig, RichTextPreloadParserInfo richTextPreloadParserInfo) {
        if (TextUtils.isEmpty(spannableStringBuilder)) {
            return;
        }
        Matcher matcher = textAtConfig.getPattern().matcher(spannableStringBuilder);
        int i3 = 0;
        while (matcher.find()) {
            try {
                int start = matcher.start() - i3;
                int end = matcher.end() - i3;
                String group = matcher.group();
                int indexOf = group.indexOf("uin:") + 4;
                int indexOf2 = group.indexOf(",nick:");
                String substring = group.substring(indexOf, indexOf2);
                String replace = group.substring(indexOf2 + 6, group.length() - 1).replace("%25", "%").replace("%2C", ",").replace("%7D", "}").replace("%7B", "{").replace("%3A", ":").replace("%3E", ">");
                RFWFriend rFWFriend = new RFWFriend();
                rFWFriend.mUin = getUin(substring);
                rFWFriend.mName = replace;
                SpannableStringBuilder handleNicknameRichText = handleNicknameRichText("@" + rFWFriend.mName, richTextPreloadParserInfo.getConfig().getImageSpanConfig());
                spannableStringBuilder.replace(start, end, (CharSequence) handleNicknameRichText);
                int length = i3 + (group.length() - handleNicknameRichText.length());
                int length2 = start + handleNicknameRichText.length();
                if (length2 == spannableStringBuilder.length()) {
                    spannableStringBuilder.append(" ");
                }
                checkNewLocalListener();
                RichTextPreloadEvent richTextPreloadEvent = new RichTextPreloadEvent(2, richTextPreloadParserInfo.getPreloadBusinessTag(), richTextPreloadParserInfo.getCacheKey());
                richTextPreloadEvent.uin = substring;
                addBoldClickSpan(spannableStringBuilder, start, length2, this.mLocalListener, textAtConfig.getSpecialAreaColorId(), textAtConfig.isUseColorInt(), textAtConfig.isNeedSpecialAreaBold(), richTextPreloadEvent);
                i3 = length;
            } catch (Exception e16) {
                QLog.e("RichTextAtParser", 1, e16, new Object[0]);
                return;
            }
        }
    }

    @Override // com.tencent.richframework.text.rich.parser.IParseRuleStrategyParser
    public SpannableStringBuilder ruleParse(SpannableStringBuilder spannableStringBuilder, RichTextPreloadParserInfo richTextPreloadParserInfo) {
        if (spannableStringBuilder == null || richTextPreloadParserInfo == null || richTextPreloadParserInfo.getConfig() == null || richTextPreloadParserInfo.getConfig().getAtConfig() == null) {
            return null;
        }
        textParser(spannableStringBuilder, richTextPreloadParserInfo.getConfig().getAtConfig(), richTextPreloadParserInfo);
        return spannableStringBuilder;
    }
}
