package com.tencent.hippykotlin.demo.pages.nearby.common_share;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* loaded from: classes31.dex */
public final /* synthetic */ class NearbyCommonSharePage$initShareVM$shareVM$1 extends FunctionReferenceImpl implements Function2<Boolean, String, Unit> {
    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(Boolean bool, String str) {
        NearbyCommonSharePage.access$handleError((NearbyCommonSharePage) this.receiver, bool.booleanValue(), str);
        return Unit.INSTANCE;
    }

    public NearbyCommonSharePage$initShareVM$shareVM$1(Object obj) {
        super(2, obj, NearbyCommonSharePage.class, "handleError", "handleError(ZLjava/lang/String;)V", 0);
    }
}
