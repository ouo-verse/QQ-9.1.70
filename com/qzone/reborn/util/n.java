package com.qzone.reborn.util;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.text.rich.bean.RichTextPreloadConfig;
import com.tencent.richframework.text.rich.bean.RichTextPreloadParserInfo;
import com.tencent.richframework.text.rich.event.RichTextPreloadEvent;
import com.tencent.richframework.text.rich.parser.IParseRuleStrategyParser;
import com.tencent.richframework.text.rich.span.BoldClickableSpan;
import com.tencent.richframework.text.rich.span.RoundBackgroundColorSpan;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes37.dex */
public class n implements IParseRuleStrategyParser<SpannableStringBuilder> {

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f59552c = Pattern.compile("#?\\{tagName:.*?\\}");

    /* renamed from: a, reason: collision with root package name */
    private BoldClickableSpan.OnClickBoldTextListener f59553a;

    /* renamed from: b, reason: collision with root package name */
    private RichTextPreloadParserInfo f59554b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements BoldClickableSpan.OnClickBoldTextListener {
        a() {
        }

        @Override // com.tencent.richframework.text.rich.span.BoldClickableSpan.OnClickBoldTextListener
        public void onClick(Object obj) {
            if (obj instanceof RichTextPreloadEvent) {
                RichTextPreloadEvent richTextPreloadEvent = (RichTextPreloadEvent) obj;
                if (n.this.f59554b != null) {
                    richTextPreloadEvent.cacheKey = n.this.f59554b.getCacheKey();
                }
                SimpleEventBus.getInstance().dispatchEvent(richTextPreloadEvent);
            }
        }
    }

    private void b(SpannableStringBuilder spannableStringBuilder, int i3, int i16, BoldClickableSpan.OnClickBoldTextListener onClickBoldTextListener, int i17, boolean z16, RichTextPreloadEvent richTextPreloadEvent) {
        if (TextUtils.isEmpty(spannableStringBuilder) || i16 < i3 || spannableStringBuilder.length() < i16) {
            return;
        }
        spannableStringBuilder.setSpan(new BoldClickableSpan(onClickBoldTextListener, BaseApplication.getContext().getResources().getColor(i17), z16, richTextPreloadEvent), i3, i16, 33);
    }

    private void c() {
        if (this.f59553a == null) {
            this.f59553a = new a();
        }
    }

    public ArrayList<String> e(SpannableStringBuilder spannableStringBuilder, RichTextPreloadConfig.TextHashTagConfig textHashTagConfig, RichTextPreloadParserInfo richTextPreloadParserInfo) {
        String str;
        int i3;
        ArrayList<String> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(spannableStringBuilder)) {
            return arrayList;
        }
        Matcher matcher = f59552c.matcher(spannableStringBuilder);
        int i16 = 0;
        while (matcher.find()) {
            try {
                int start = matcher.start() - i16;
                int end = matcher.end() - i16;
                String group = matcher.group();
                String substring = group.substring(group.indexOf("tagName:") + 8, group.indexOf("}"));
                if (textHashTagConfig.isNeedSpecialHashTagAreaBackground()) {
                    str = " #" + substring + " ";
                } else {
                    str = " # " + substring + " ";
                }
                spannableStringBuilder.replace(start, end, (CharSequence) str);
                int length = i16 + (group.length() - str.length());
                int length2 = start + str.length();
                int i17 = length2 == spannableStringBuilder.length() ? 1 : 0;
                if (richTextPreloadParserInfo == null || !textHashTagConfig.isClickable()) {
                    i3 = length2;
                } else {
                    c();
                    RichTextPreloadEvent richTextPreloadEvent = new RichTextPreloadEvent(3, richTextPreloadParserInfo.getPreloadBusinessTag(), richTextPreloadParserInfo.getCacheKey());
                    richTextPreloadEvent.tagName = substring;
                    i3 = length2;
                    b(spannableStringBuilder, start, length2 - i17, this.f59553a, textHashTagConfig.getSpecialAreaColorId(), textHashTagConfig.isNeedSpecialAreaBold(), richTextPreloadEvent);
                }
                arrayList.add(substring);
                if (textHashTagConfig.isNeedSpecialHashTagAreaBackground()) {
                    int i18 = start + 1;
                    int i19 = i3 - 1;
                    spannableStringBuilder.setSpan(textHashTagConfig.getSpanTextSizeSpan(), i18, i19, 17);
                    spannableStringBuilder.setSpan(new RoundBackgroundColorSpan(textHashTagConfig.getSpecialAreaHasBackgroundColorId(), textHashTagConfig.getSpecialAreaHashTagBackgroundColorId()), i18, i19, 17);
                    spannableStringBuilder.setSpan(new AbsoluteSizeSpan(cx.a(4.0f)), start, i18, 17);
                    spannableStringBuilder.setSpan(new AbsoluteSizeSpan(cx.a(4.0f)), i19, i3, 17);
                } else {
                    spannableStringBuilder.setSpan(new AbsoluteSizeSpan(cx.a(4.0f)), start, start + 1, 17);
                    spannableStringBuilder.setSpan(new AbsoluteSizeSpan(cx.a(4.0f)), start + 2, start + 3, 17);
                    spannableStringBuilder.setSpan(new AbsoluteSizeSpan(cx.a(4.0f)), i3 - 1, i3, 17);
                }
                i16 = length;
            } catch (Exception e16) {
                QLog.e("RichTextTagParser", 1, e16, new Object[0]);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.richframework.text.rich.parser.IParseRuleStrategyParser
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public SpannableStringBuilder ruleParse(SpannableStringBuilder spannableStringBuilder, RichTextPreloadParserInfo richTextPreloadParserInfo) {
        if (spannableStringBuilder == null || richTextPreloadParserInfo == null || richTextPreloadParserInfo.getConfig() == null || richTextPreloadParserInfo.getConfig().getTagConfig() == null) {
            return null;
        }
        this.f59554b = richTextPreloadParserInfo;
        e(spannableStringBuilder, richTextPreloadParserInfo.getConfig().getTagConfig(), richTextPreloadParserInfo);
        return spannableStringBuilder;
    }
}
