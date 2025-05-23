package com.tencent.hippykotlin.demo.pages.nearby.new_homepage.repository;

import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import f35.d;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class NBPNewHomeRepository$requestOpenID$1 extends Lambda implements Function1<PbResponse<d>, Unit> {
    public final /* synthetic */ Function2<Integer, String, Unit> $errorBlock;
    public final /* synthetic */ Function1<d, Unit> $successBlock;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NBPNewHomeRepository$requestOpenID$1(Function1<? super d, Unit> function1, Function2<? super Integer, ? super String, Unit> function2) {
        super(1);
        this.$successBlock = function1;
        this.$errorBlock = function2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(PbResponse<d> pbResponse) {
        PbResponse<d> pbResponse2 = pbResponse;
        if (pbResponse2.success) {
            this.$successBlock.invoke(pbResponse2.rsp);
        } else {
            this.$errorBlock.invoke(Integer.valueOf(pbResponse2.code), pbResponse2.f114187msg);
        }
        return Unit.INSTANCE;
    }
}
