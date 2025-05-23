package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsInfo;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingViewModel;
import com.tencent.kuikly.core.log.KLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import yo3.Offset;

/* compiled from: P */
/* loaded from: classes31.dex */
public /* synthetic */ class TtsListKt$TtsList$4 extends FunctionReferenceImpl implements Function2<AdelieTtsInfo, Offset, Unit> {
    public final /* synthetic */ AdelieTtsSettingViewModel $viewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TtsListKt$TtsList$4(AdelieTtsSettingViewModel adelieTtsSettingViewModel) {
        super(2, Intrinsics.Kotlin.class, "onMore", "TtsList$onMore(Lcom/tencent/hippykotlin/demo/pages/adelie/page/compose/tts/AdelieTtsSettingViewModel;Lcom/tencent/hippykotlin/demo/pages/adelie/page/compose/tts/AdelieTtsInfo;Lcom/tencent/ntcompose/ui/geometry/Offset;)V", 0);
        this.$viewModel = adelieTtsSettingViewModel;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(AdelieTtsInfo adelieTtsInfo, Offset offset) {
        Offset offset2 = offset;
        AdelieTtsSettingViewModel adelieTtsSettingViewModel = this.$viewModel;
        KLog.INSTANCE.i("LazyListScope.TtsList", "chosenOffset=" + offset2);
        adelieTtsSettingViewModel.getPopDownStateManager().chosenTtsOffset = offset2;
        adelieTtsSettingViewModel.getPopDownStateManager().chosenTtsId = adelieTtsInfo.ttsId;
        adelieTtsSettingViewModel.getPopDownStateManager().isPopDownMenu._state.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }
}
