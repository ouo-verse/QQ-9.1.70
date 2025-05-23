package com.tencent.richframework.text.rich.parser;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.richframework.text.rich.bean.RichTextPreloadParserInfo;
import com.tencent.richframework.text.rich.event.RichTextPreloadEvent;
import com.tencent.richframework.text.rich.span.BoldClickableSpan;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import nb0.e;

/* loaded from: classes25.dex */
public class RichTextSearchKeywordParser implements IParseRuleStrategyParser<SpannableStringBuilder> {
    private BoldClickableSpan.OnClickBoldTextListener mLocalListener;
    private static final Pattern SEARCH_KEYWORD_GROUP_PATTERN = Pattern.compile("\\{searchKeyword=(.*?)\\}");
    private static final int SEARCH_KEYWORD_FRAME_LENGTH = 16;
    private static final int SEARCH_ICON_SIZE = cx.a(10.0f);
    private static final int SEARCH_ICON_HORIZONTAL_PADDING = cx.a(2.0f);
    private static final int SEARCH_ICON_TOP_PADDING = cx.a(1.0f);

    private void checkNewLocalListener() {
        if (this.mLocalListener == null) {
            this.mLocalListener = new BoldClickableSpan.OnClickBoldTextListener() { // from class: com.tencent.richframework.text.rich.parser.RichTextSearchKeywordParser.1
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

    public static String generateAllSearchKeyword(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Matcher matcher = SEARCH_KEYWORD_GROUP_PATTERN.matcher(str);
        StringBuilder sb5 = new StringBuilder();
        while (matcher.find()) {
            sb5.append(matcher.group(1));
            sb5.append(",");
        }
        if (TextUtils.isEmpty(sb5)) {
            return "";
        }
        return sb5.substring(0, sb5.length() - 1);
    }

    @Override // com.tencent.richframework.text.rich.parser.IParseRuleStrategyParser
    public SpannableStringBuilder ruleParse(SpannableStringBuilder spannableStringBuilder, RichTextPreloadParserInfo richTextPreloadParserInfo) {
        if (spannableStringBuilder == null || richTextPreloadParserInfo == null) {
            return null;
        }
        Matcher matcher = SEARCH_KEYWORD_GROUP_PATTERN.matcher(spannableStringBuilder);
        ArrayList arrayList = new ArrayList();
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            int i3 = end - SEARCH_KEYWORD_FRAME_LENGTH;
            String group = matcher.group(1);
            arrayList.add(group);
            spannableStringBuilder.replace(start, i3, (CharSequence) group);
            Drawable drawable = QCircleSkinHelper.getInstance().getDrawable(R.drawable.qvideo_skin_icon_general_search_hashtag);
            int i16 = SEARCH_ICON_SIZE;
            drawable.setBounds(0, 0, i16, i16);
            e eVar = new e(drawable);
            eVar.a(SEARCH_ICON_HORIZONTAL_PADDING);
            eVar.b(SEARCH_ICON_TOP_PADDING);
            spannableStringBuilder.setSpan(eVar, i3, end, 33);
            checkNewLocalListener();
            RichTextPreloadEvent richTextPreloadEvent = new RichTextPreloadEvent(7, richTextPreloadParserInfo.getPreloadBusinessTag(), richTextPreloadParserInfo.getCacheKey());
            richTextPreloadEvent.searchKeyword = group;
            spannableStringBuilder.setSpan(new BoldClickableSpan(this.mLocalListener, QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_text_hashtag), false, richTextPreloadEvent), start, end, 33);
        }
        return spannableStringBuilder;
    }
}
