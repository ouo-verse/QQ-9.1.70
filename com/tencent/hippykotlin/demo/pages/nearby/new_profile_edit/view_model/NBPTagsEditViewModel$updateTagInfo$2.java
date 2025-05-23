package com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view_model;

import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.kuikly.core.timer.TimerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class NBPTagsEditViewModel$updateTagInfo$2 extends Lambda implements Function2<Integer, String, Unit> {
    public static final NBPTagsEditViewModel$updateTagInfo$2 INSTANCE = new NBPTagsEditViewModel$updateTagInfo$2();

    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(Integer num, String str) {
        num.intValue();
        TimerKt.d(100, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view_model.NBPTagsEditViewModel$updateTagInfo$2.1
            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                Utils.INSTANCE.currentBridgeModule().qToast("\u6807\u7b7e\u4fee\u6539\u5931\u8d25", QToastMode.Info);
                return Unit.INSTANCE;
            }
        });
        return Unit.INSTANCE;
    }

    public NBPTagsEditViewModel$updateTagInfo$2() {
        super(2);
    }
}
