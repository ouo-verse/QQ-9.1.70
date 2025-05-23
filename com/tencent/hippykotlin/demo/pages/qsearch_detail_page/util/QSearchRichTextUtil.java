package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util;

import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchRichTextUtil {
    public static final QSearchRichTextUtil INSTANCE = new QSearchRichTextUtil();

    public final void addRichTextSpan(List list, String str, int i3, String str2, Function0 function0) {
        int indexOf$default;
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, str2, i3, false, 4, (Object) null);
        if (indexOf$default != -1) {
            QUISkinColor qUISkinColor = QUISkinColor.INSTANCE;
            list.add(new RichTextSpanUnit(indexOf$default, str2.length() + indexOf$default, QUIToken.color$default("text_link"), null, function0));
            addRichTextSpan(list, str, str2.length() + indexOf$default, str2, function0);
        }
    }
}
