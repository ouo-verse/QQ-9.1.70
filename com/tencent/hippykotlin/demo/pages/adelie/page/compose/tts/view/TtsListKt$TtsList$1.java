package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsInfo;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingViewModel;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
/* loaded from: classes31.dex */
public /* synthetic */ class TtsListKt$TtsList$1 extends FunctionReferenceImpl implements Function1<AdelieTtsInfo, Unit> {
    public final /* synthetic */ Ref.LongRef $lastClickTime;
    public final /* synthetic */ AdelieTtsSettingViewModel $viewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TtsListKt$TtsList$1(Ref.LongRef longRef, AdelieTtsSettingViewModel adelieTtsSettingViewModel) {
        super(1, Intrinsics.Kotlin.class, NodeProps.ON_CLICK, "TtsList$onClick(Lkotlin/jvm/internal/Ref$LongRef;Lcom/tencent/hippykotlin/demo/pages/adelie/page/compose/tts/AdelieTtsSettingViewModel;Lcom/tencent/hippykotlin/demo/pages/adelie/page/compose/tts/AdelieTtsInfo;)V", 0);
        this.$lastClickTime = longRef;
        this.$viewModel = adelieTtsSettingViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(AdelieTtsInfo adelieTtsInfo) {
        TtsListKt.access$TtsList$onClick(this.$lastClickTime, this.$viewModel, adelieTtsInfo);
        return Unit.INSTANCE;
    }
}
