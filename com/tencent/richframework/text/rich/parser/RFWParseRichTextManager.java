package com.tencent.richframework.text.rich.parser;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.text.rich.bean.RichTextPreloadConfig;
import com.tencent.richframework.text.rich.bean.RichTextPreloadParserInfo;
import com.tencent.richframework.text.rich.span.RFWQQText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes25.dex */
public class RFWParseRichTextManager {
    private static final List<IParseRuleStrategyParser<SpannableStringBuilder>> mBaseRuleStrategyParsers;
    private static final ConcurrentHashMap<String, IParseRuleStrategyParser> mDynamicRuleStrategyParsers;

    static {
        ArrayList arrayList = new ArrayList();
        mBaseRuleStrategyParsers = arrayList;
        mDynamicRuleStrategyParsers = new ConcurrentHashMap<>();
        arrayList.add(new RichTextEmojiParser());
        arrayList.add(new RichTextAtParser());
        arrayList.add(new RichTextHashTagParser());
        arrayList.add(new RichTextClickableImageSpanParser());
        arrayList.add(new RichTextSearchKeywordParser());
    }

    private static IParseRuleStrategyParser getDynamicRuleStrategyParser(Class<? extends IParseRuleStrategyParser> cls) {
        if (cls == null) {
            return null;
        }
        ConcurrentHashMap<String, IParseRuleStrategyParser> concurrentHashMap = mDynamicRuleStrategyParsers;
        if (concurrentHashMap.containsKey(cls.getName())) {
            return concurrentHashMap.get(cls.getName());
        }
        try {
            IParseRuleStrategyParser newInstance = cls.newInstance();
            concurrentHashMap.put(cls.getName(), newInstance);
            return newInstance;
        } catch (Exception e16) {
            QLog.e("RFWParseRichTextManager", 1, "[registerDynamicRuleStrategyParser] newInstance , e = " + e16.getMessage());
            return null;
        }
    }

    protected static QQText getQQText(SpannableStringBuilder spannableStringBuilder, RichTextPreloadConfig richTextPreloadConfig) {
        int i3;
        if (richTextPreloadConfig != null && richTextPreloadConfig.getImageSpanConfig() != null) {
            i3 = richTextPreloadConfig.getImageSpanConfig().getIconSize();
        } else {
            i3 = 32;
        }
        if (spannableStringBuilder == null) {
            spannableStringBuilder = new SpannableStringBuilder("");
        }
        return new RFWQQText(spannableStringBuilder, 3, i3);
    }

    public static RichTextHashTagParser getTagRuleParser() {
        for (IParseRuleStrategyParser<SpannableStringBuilder> iParseRuleStrategyParser : mBaseRuleStrategyParsers) {
            if (iParseRuleStrategyParser instanceof RichTextHashTagParser) {
                return (RichTextHashTagParser) iParseRuleStrategyParser;
            }
        }
        return null;
    }

    public static Spannable parseBaseRule(RichTextPreloadParserInfo richTextPreloadParserInfo) {
        if (richTextPreloadParserInfo == null) {
            return null;
        }
        if (richTextPreloadParserInfo.getConfig() == null) {
            richTextPreloadParserInfo.setConfig(new RichTextPreloadConfig());
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(richTextPreloadParserInfo.getPreloadContent());
        Iterator<IParseRuleStrategyParser<SpannableStringBuilder>> it = mBaseRuleStrategyParsers.iterator();
        while (it.hasNext()) {
            it.next().ruleParse(spannableStringBuilder, richTextPreloadParserInfo);
        }
        return getQQText(spannableStringBuilder, richTextPreloadParserInfo.getConfig());
    }

    public static Spannable parseDynamicAndBaseRule(Object obj, RichTextPreloadParserInfo richTextPreloadParserInfo) {
        if (obj != null && richTextPreloadParserInfo != null) {
            realParseDynamicRule(obj, richTextPreloadParserInfo);
            return parseBaseRule(richTextPreloadParserInfo);
        }
        return null;
    }

    public static Spannable parseDynamicRule(Object obj, RichTextPreloadParserInfo richTextPreloadParserInfo) {
        if (obj != null && richTextPreloadParserInfo != null) {
            return getQQText(realParseDynamicRule(obj, richTextPreloadParserInfo), richTextPreloadParserInfo.getConfig());
        }
        return null;
    }

    private static SpannableStringBuilder realParseDynamicRule(Object obj, RichTextPreloadParserInfo richTextPreloadParserInfo) {
        SpannableStringBuilder spannableStringBuilder = null;
        if (richTextPreloadParserInfo == null) {
            return null;
        }
        if (richTextPreloadParserInfo.getConfig() == null) {
            richTextPreloadParserInfo.setConfig(new RichTextPreloadConfig());
        }
        if (richTextPreloadParserInfo.getDynamicParserClass() == null) {
            QLog.w("RFWParseRichTextManager", 1, "realParseDynamicRule  parserInfo.getDynamicParserClass() == null");
            return null;
        }
        IParseRuleStrategyParser dynamicRuleStrategyParser = getDynamicRuleStrategyParser(richTextPreloadParserInfo.getDynamicParserClass());
        if (dynamicRuleStrategyParser != null && obj != null) {
            spannableStringBuilder = dynamicRuleStrategyParser.ruleParse(obj, richTextPreloadParserInfo);
        }
        richTextPreloadParserInfo.setPreloadContent(spannableStringBuilder);
        return spannableStringBuilder;
    }
}
