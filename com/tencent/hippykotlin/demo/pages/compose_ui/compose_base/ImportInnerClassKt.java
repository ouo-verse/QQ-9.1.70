package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQComposeMarkdownKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIAlertDialogItem;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIAlertDialogKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIBottomToastKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIButtonKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineCommonViewKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineSwitchViewKt;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.ntcompose.ui.platform.a;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ImportInnerClassKt {
    public static final void importInnerClass(Composer composer, final int i3) {
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1990242121);
        if (i3 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1990242121, i3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.importInnerClass (importInnerClass.kt:17)");
            }
            if (((a) startRestartGroup.consume(CompositionLocalsKt.d())).j() && ((a) startRestartGroup.consume(CompositionLocalsKt.d())).k()) {
                i.Companion companion = i.INSTANCE;
                QUIListSingleLineCommonViewKt.QUIListSingleLineCommonView(companion, null, null, "LeftTitle", 0.0f, null, null, "\u8f85\u52a9\u4fe1\u606f", ComposableSingletons$ImportInnerClassKt.f28lambda1, null, null, 0.0f, startRestartGroup, 113249336, 0, 3700);
                QUIListSingleLineSwitchViewKt.QUIListSingleLineSwitchView(null, null, null, TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, null, false, new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.ImportInnerClassKt$importInnerClass$1
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        bool.booleanValue();
                        return Unit.INSTANCE;
                    }
                }, startRestartGroup, 1772544, 23);
                QUIButtonKt.QUIButton(companion, null, null, "test", null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.ImportInnerClassKt$importInnerClass$2
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                        return Unit.INSTANCE;
                    }
                }, null, null, startRestartGroup, 199688, 214);
                startRestartGroup.startReplaceableGroup(-492369756);
                Object rememberedValue = startRestartGroup.rememberedValue();
                Composer.Companion companion2 = Composer.INSTANCE;
                if (rememberedValue == companion2.getEmpty()) {
                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                final MutableState mutableState = (MutableState) rememberedValue;
                boolean booleanValue = ((Boolean) mutableState.getValue()).booleanValue();
                QUIAlertDialogItem[] qUIAlertDialogItemArr = new QUIAlertDialogItem[2];
                startRestartGroup.startReplaceableGroup(1157296644);
                boolean changed = startRestartGroup.changed(mutableState);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changed || rememberedValue2 == companion2.getEmpty()) {
                    rememberedValue2 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.ImportInnerClassKt$importInnerClass$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            mutableState.setValue(Boolean.FALSE);
                            return Unit.INSTANCE;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceableGroup();
                qUIAlertDialogItemArr[0] = QUIAlertDialogKt.QUIAlertDialogNormalTextItem("\u53d6\u6d88", (Function0) rememberedValue2);
                startRestartGroup.startReplaceableGroup(1157296644);
                boolean changed2 = startRestartGroup.changed(mutableState);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changed2 || rememberedValue3 == companion2.getEmpty()) {
                    rememberedValue3 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.ImportInnerClassKt$importInnerClass$4$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            mutableState.setValue(Boolean.FALSE);
                            return Unit.INSTANCE;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceableGroup();
                qUIAlertDialogItemArr[1] = QUIAlertDialogKt.QUIAlertDialogWarningTextItem("\u786e\u5b9a\uff08\u7ea2\u8272\u6309\u94ae\uff09", (Function0) rememberedValue3);
                QUIAlertDialogKt.QUIAlertDialog(booleanValue, "\u4e0b\u7ebf\u901a\u77e5", "\u4f60\u7684\u5e10\u53f7\u4e8e17:00\u5728\u4e00\u53f0Android\u624b\u673a\u767b\u5f55\u3002\u5982\u975e\u672c\u4eba\u64cd\u4f5c\uff0c\u5bc6\u7801\u53ef\u80fd\u5df2\u7ecf\u6cc4\u9732\uff0c\u5efa\u8bae\u524d\u5f80 http://110.qq.com/\u4fee\u6539\u5bc6\u7801\u6216\u8005\u7d27\u6025\u51bb\u7ed3\u5e10\u53f7\u3002", null, qUIAlertDialogItemArr, null, null, startRestartGroup, 33200, 104);
                composer2 = startRestartGroup;
                QUIDatePickerKt.QUIDatePicker(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), null, 0L, 0, true, null, null, null, null, null, new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.ImportInnerClassKt$importInnerClass$5
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        bool.booleanValue();
                        return Unit.INSTANCE;
                    }
                }, null, null, null, composer2, 24584, 6, 15342);
                QUIBottomToastKt.QUIBottomToast(true, QToastMode.Info, "\u53ef\u4ee5\u4e0a\u4f20\u6587\u4ef6\u5230\u4e91\u76d8", "\u4e0a\u4f20\u6587\u4ef6", 0.0f, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.ImportInnerClassKt$importInnerClass$6
                    @Override // kotlin.jvm.functions.Function0
                    public final /* bridge */ /* synthetic */ Unit invoke() {
                        return Unit.INSTANCE;
                    }
                }, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.ImportInnerClassKt$importInnerClass$7
                    @Override // kotlin.jvm.functions.Function0
                    public final /* bridge */ /* synthetic */ Unit invoke() {
                        return Unit.INSTANCE;
                    }
                }, composer2, 1797558, 0);
                QQComposeMarkdownKt.QQComposeMarkdown(null, null, "", 0, 0.0f, composer2, MsgConstant.KRMFILETHUMBSIZE384, 27);
            } else {
                composer2 = startRestartGroup;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.ImportInnerClassKt$importInnerClass$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer3, Integer num) {
                num.intValue();
                ImportInnerClassKt.importInnerClass(composer3, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
