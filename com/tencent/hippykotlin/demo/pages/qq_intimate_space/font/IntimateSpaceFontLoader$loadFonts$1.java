package com.tencent.hippykotlin.demo.pages.qq_intimate_space.font;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyFontModule;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import cooperation.qzone.QzoneIPCModule;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.qq_intimate_space.font.IntimateSpaceFontLoader$loadFonts$1", f = "IntimateSpaceFontLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes37.dex */
public final class IntimateSpaceFontLoader$loadFonts$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ List<IntimateSpaceFonts> $fonts;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public IntimateSpaceFontLoader$loadFonts$1(List<? extends IntimateSpaceFonts> list, Continuation<? super IntimateSpaceFontLoader$loadFonts$1> continuation) {
        super(2, continuation);
        this.$fonts = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IntimateSpaceFontLoader$loadFonts$1(this.$fonts, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((IntimateSpaceFontLoader$loadFonts$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        for (final IntimateSpaceFonts intimateSpaceFonts : this.$fonts) {
            try {
                ((QQKuiklyFontModule) c.f117352a.g().acquireModule("QQKuiklyFontModule")).registerFont(intimateSpaceFonts.url, true, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.font.IntimateSpaceFontLoader$loadFonts$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(e eVar) {
                        e eVar2 = eVar;
                        boolean z16 = (eVar2 != null ? eVar2.j(QzoneIPCModule.RESULT_CODE) : -1) >= 0;
                        KLog kLog = KLog.INSTANCE;
                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("font: ");
                        m3.append(IntimateSpaceFonts.this.family);
                        m3.append(", isFontLoaded: ");
                        m3.append(z16);
                        kLog.i("IntimateSpaceFontLoader", m3.toString());
                        return Unit.INSTANCE;
                    }
                });
            } catch (Exception e16) {
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("font: ");
                m3.append(intimateSpaceFonts.family);
                m3.append(", load exception: ");
                m3.append(e16);
                kLog.e("IntimateSpaceFontLoader", m3.toString());
            }
        }
        return Unit.INSTANCE;
    }
}
