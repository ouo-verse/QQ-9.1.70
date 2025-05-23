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
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.qq_intimate_space.font.IntimateSpaceFontLoader$deleteFonts$1", f = "IntimateSpaceFontLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes37.dex */
public final class IntimateSpaceFontLoader$deleteFonts$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ List<IntimateSpaceFonts> $fonts;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public IntimateSpaceFontLoader$deleteFonts$1(List<? extends IntimateSpaceFonts> list, Continuation<? super IntimateSpaceFontLoader$deleteFonts$1> continuation) {
        super(2, continuation);
        this.$fonts = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IntimateSpaceFontLoader$deleteFonts$1(this.$fonts, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((IntimateSpaceFontLoader$deleteFonts$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        for (final IntimateSpaceFonts intimateSpaceFonts : this.$fonts) {
            try {
                c cVar = c.f117352a;
                QQKuiklyFontModule qQKuiklyFontModule = (QQKuiklyFontModule) cVar.g().acquireModule("QQKuiklyFontModule");
                String str = intimateSpaceFonts.url;
                final Function1<e, Unit> function1 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.font.IntimateSpaceFontLoader$deleteFonts$1.1
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
                        m3.append(", delete font success: ");
                        m3.append(z16);
                        kLog.i("IntimateSpaceFontLoader", m3.toString());
                        return Unit.INSTANCE;
                    }
                };
                qQKuiklyFontModule.getClass();
                if (cVar.g().getPageData().getIsIOS()) {
                    e eVar = new e();
                    eVar.v("fontSrc", str);
                    qQKuiklyFontModule.toNative(false, "deleteFont", eVar.toString(), new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyFontModule$deleteFont$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(e eVar2) {
                            e eVar3 = eVar2;
                            Function1<e, Unit> function12 = function1;
                            if (function12 != null) {
                                function12.invoke(eVar3);
                            }
                            return Unit.INSTANCE;
                        }
                    }, false);
                }
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
