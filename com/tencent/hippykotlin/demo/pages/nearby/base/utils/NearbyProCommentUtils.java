package com.tencent.hippykotlin.demo.pages.nearby.base.utils;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* loaded from: classes31.dex */
public final class NearbyProCommentUtils {
    public static final NearbyProCommentUtils INSTANCE = new NearbyProCommentUtils();

    public final boolean needCheckIdentity() {
        e eVar;
        String stringFromQQCommonConfig = QQNearbyModule.Companion.getInstance().getStringFromQQCommonConfig("102637", "{}");
        KLog.INSTANCE.i("NearbyProCommentUtils", "getQQMCConfig: 102637: " + stringFromQQCommonConfig);
        try {
            eVar = new e(stringFromQQCommonConfig);
        } catch (Throwable unused) {
            eVar = new e();
        }
        boolean g16 = eVar.g("check_identity", false);
        CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0.m("needCheckIdentity: ", g16, KLog.INSTANCE, "NearbyProCommentUtils");
        return g16;
    }
}
