package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes32.dex */
public final class SearchNetApi$covertPbByteArrayToString$1 extends Lambda implements Function1<Byte, CharSequence> {
    public static final SearchNetApi$covertPbByteArrayToString$1 INSTANCE = new SearchNetApi$covertPbByteArrayToString$1();

    @Override // kotlin.jvm.functions.Function1
    public final CharSequence invoke(Byte b16) {
        return String.valueOf((char) b16.byteValue());
    }

    public SearchNetApi$covertPbByteArrayToString$1() {
        super(1);
    }
}
