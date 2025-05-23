package com.tencent.hippykotlin.demo.pages.nearby.new_guide;

import com.tencent.kuikly.core.log.KLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class NBPGuideTagPickPage$onHandleComplete$4 extends Lambda implements Function2<Integer, String, Unit> {
    public static final NBPGuideTagPickPage$onHandleComplete$4 INSTANCE = new NBPGuideTagPickPage$onHandleComplete$4();

    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(Integer num, String str) {
        int intValue = num.intValue();
        KLog.INSTANCE.i("NBPGuideTagPickPage", "updateTagsInfo error:[" + intValue + ']' + str);
        return Unit.INSTANCE;
    }

    public NBPGuideTagPickPage$onHandleComplete$4() {
        super(2);
    }
}
