package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c45.a;
import c45.e;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.log.KLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;
import u35.b;

/* loaded from: classes31.dex */
public final class CommonProxyService$request$1 extends Lambda implements Function3<b, Integer, String, Unit> {
    public final /* synthetic */ Function4<Rsp, byte[], Integer, String, Unit> $callback;
    public final /* synthetic */ IBizRequestByProxy<Req, Rsp> $request;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CommonProxyService$request$1(Function4<? super Rsp, ? super byte[], ? super Integer, ? super String, Unit> function4, IBizRequestByProxy<Req, Rsp> iBizRequestByProxy) {
        super(3);
        this.$callback = function4;
        this.$request = iBizRequestByProxy;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Unit invoke(b bVar, Integer num, String str) {
        b bVar2 = bVar;
        int intValue = num.intValue();
        String str2 = str;
        e eVar = null;
        a aVar = bVar2 != null ? bVar2.f438203f : null;
        if (aVar != null && intValue == 0) {
            int i3 = bVar2.f438201d;
            if (i3 != 0) {
                this.$callback.invoke(null, null, Integer.valueOf(i3), bVar2.f438202e);
            } else {
                try {
                    eVar = this.$request.decodeResponse(aVar.f30291a);
                } catch (Throwable th5) {
                    AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("decode error: ", th5, KLog.INSTANCE, "CommonProxyService");
                }
                this.$callback.invoke(eVar, aVar.f30291a, Integer.valueOf(intValue), str2);
            }
        } else {
            this.$callback.invoke(null, null, Integer.valueOf(intValue), str2);
        }
        return Unit.INSTANCE;
    }
}
