package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import kotlin.text.Regex;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class Cir_main_page_extensionKt {
    public static final String filterCirEmoji(String str) {
        return new Regex("\\[em\\].*?\\[/em\\]").replace(str, "");
    }
}
