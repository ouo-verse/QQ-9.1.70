package com.tencent.richframework.text.rich.parser;

import android.text.SpannableStringBuilder;
import com.tencent.richframework.text.rich.bean.RichTextPreloadParserInfo;

/* loaded from: classes25.dex */
public interface IParseRuleStrategyParser<T> {
    SpannableStringBuilder ruleParse(T t16, RichTextPreloadParserInfo richTextPreloadParserInfo);
}
