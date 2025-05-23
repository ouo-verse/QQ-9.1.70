package com.tencent.hippykotlin.demo.pages.foundation.module;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.lib.QQUtils;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.exception.PagerNotFoundExceptionKt;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QQCommonNApiModule extends Module {
    public static final Companion Companion = new Companion();
    public String curModuleName = "";

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static final class Companion {
    }

    public final String getStringFromQQCommonConfig(String str, String str2) {
        this.curModuleName = "QQNearbyModule";
        e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("key", str);
        Unit unit = Unit.INSTANCE;
        String syncToNativeMethod = syncToNativeMethod("getStringFromQQCommonConfig", m3, (Function1<? super e, Unit>) null);
        if (!(syncToNativeMethod.length() == 0)) {
            str2 = syncToNativeMethod;
        }
        this.curModuleName = "";
        return str2;
    }

    public final boolean isDarkTheme() {
        boolean isNightMode;
        this.curModuleName = "VasKuiklyModule";
        if (QQUtils.INSTANCE.compare("9.0.35") >= 0) {
            isNightMode = Intrinsics.areEqual(toNative(false, "isDarkTheme", null, null, true).getReturnValue(), Boolean.TRUE);
        } else {
            isNightMode = QUIToken.INSTANCE.isNightMode();
        }
        Boolean valueOf = Boolean.valueOf(isNightMode);
        this.curModuleName = "";
        if (valueOf != null) {
            return valueOf.booleanValue();
        }
        return false;
    }

    @Override // com.tencent.kuikly.core.module.Module
    public final String moduleName() {
        if ((this.curModuleName.length() == 0) && !PageDataExtKt.isPublic(c.f117352a.g().getPageData())) {
            PagerNotFoundExceptionKt.a("module is empty when QQCommonNApiModule Module call native api, \u8bf7\u901a\u8fc7callAnyModuleApi\u8c03\u7528");
        }
        return this.curModuleName;
    }
}
