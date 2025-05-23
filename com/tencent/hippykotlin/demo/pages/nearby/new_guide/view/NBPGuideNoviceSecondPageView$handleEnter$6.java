package com.tencent.hippykotlin.demo.pages.nearby.new_guide.view;

import com.tencent.kuikly.core.log.KLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class NBPGuideNoviceSecondPageView$handleEnter$6 extends Lambda implements Function2<Integer, String, Unit> {
    public static final NBPGuideNoviceSecondPageView$handleEnter$6 INSTANCE = new NBPGuideNoviceSecondPageView$handleEnter$6();

    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(Integer num, String str) {
        int intValue = num.intValue();
        KLog.INSTANCE.e("NBPGuideNoviceSecondPage", "[handleEnter]updateTagsInfo error:[" + intValue + ']' + str);
        return Unit.INSTANCE;
    }

    public NBPGuideNoviceSecondPageView$handleEnter$6() {
        super(2);
    }
}
