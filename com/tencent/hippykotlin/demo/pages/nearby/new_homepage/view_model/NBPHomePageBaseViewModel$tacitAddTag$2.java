package com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model;

import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class NBPHomePageBaseViewModel$tacitAddTag$2 extends Lambda implements Function2<Integer, String, Unit> {
    public static final NBPHomePageBaseViewModel$tacitAddTag$2 INSTANCE = new NBPHomePageBaseViewModel$tacitAddTag$2();

    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(Integer num, String str) {
        num.intValue();
        Utils.INSTANCE.currentBridgeModule().qToast("\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", QToastMode.Warning);
        return Unit.INSTANCE;
    }

    public NBPHomePageBaseViewModel$tacitAddTag$2() {
        super(2);
    }
}
