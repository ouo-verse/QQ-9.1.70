package com.tencent.hippykotlin.demo.pages.vas_base.native_api;

import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.QQComposeViewExtCreator$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.lib.QQUtils;
import com.tencent.kuikly.core.manager.c;

/* compiled from: P */
/* loaded from: classes33.dex */
public interface INativeApi {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();

        public static void checkQQVersion$default() {
            String str;
            c cVar = c.f117352a;
            if (!PageDataExtKt.isTim(cVar.g().getPageData())) {
                str = "9.0.85";
            } else {
                str = "";
            }
            if (cVar.g().getPageData().u() && QQUtils.INSTANCE.compare(str) < 0) {
                throw new RuntimeException(QQComposeViewExtCreator$$ExternalSyntheticOutline0.m("debug\u5305\u5f02\u5e38\uff1a\u4e0d\u652f\u6301", "9.0.85", "\u4ee5\u4e0b\u7248\u672c\u8c03\u7528"));
            }
        }
    }
}
