package com.tencent.hippykotlin.demo.pages.qq_intimate_space.share;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes37.dex */
public final class ImageSharePanelViewKt {
    public static final void ImageSharePanelView(final ImageSharePanelViewModel imageSharePanelViewModel, final PanelConfig panelConfig, ShareElementVR shareElementVR, ShareElementVR shareElementVR2, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, Function1<? super ShareItem, Unit> function1, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i3, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(1813294607);
        final ShareElementVR shareElementVR3 = (i16 & 4) != 0 ? null : shareElementVR;
        ShareElementVR shareElementVR4 = (i16 & 8) != 0 ? null : shareElementVR2;
        Function0<Unit> function04 = (i16 & 16) != 0 ? null : function0;
        Function0<Unit> function05 = (i16 & 32) != 0 ? null : function02;
        Function0<Unit> function06 = (i16 & 64) != 0 ? null : function03;
        final Function1<? super ShareItem, Unit> function12 = (i16 & 128) != 0 ? null : function1;
        Function2<? super Composer, ? super Integer, Unit> function22 = (i16 & 256) != 0 ? null : function2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1813294607, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.ImageSharePanelView (ImageSharePanelView.kt:18)");
        }
        SharePanelViewKt.SharePanelView(imageSharePanelViewModel.sharePanelViewModel.getValue(), panelConfig, shareElementVR3, shareElementVR4, function04, function05, function06, new Function1<ShareItem, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.ImageSharePanelViewKt$ImageSharePanelView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ShareItem shareItem) {
                ShareItem shareItem2 = shareItem;
                Function1<ShareItem, Unit> function13 = function12;
                if (function13 != null) {
                    function13.invoke(shareItem2);
                } else {
                    ImageSharePanelViewModel imageSharePanelViewModel2 = imageSharePanelViewModel;
                    imageSharePanelViewModel2.getClass();
                    Function0<Unit> function07 = shareItem2.onClick;
                    if (function07 != null) {
                        function07.invoke();
                    } else {
                        imageSharePanelViewModel2.doShareAction(shareItem2);
                    }
                }
                return Unit.INSTANCE;
            }
        }, function22, startRestartGroup, (57344 & i3) | 4680 | (458752 & i3) | (3670016 & i3) | (234881024 & i3), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final ShareElementVR shareElementVR5 = shareElementVR4;
        final Function0<Unit> function07 = function04;
        final Function0<Unit> function08 = function05;
        final Function0<Unit> function09 = function06;
        final Function1<? super ShareItem, Unit> function13 = function12;
        final Function2<? super Composer, ? super Integer, Unit> function23 = function22;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.ImageSharePanelViewKt$ImageSharePanelView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                ImageSharePanelViewKt.ImageSharePanelView(ImageSharePanelViewModel.this, panelConfig, shareElementVR3, shareElementVR5, function07, function08, function09, function13, function23, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }
}
