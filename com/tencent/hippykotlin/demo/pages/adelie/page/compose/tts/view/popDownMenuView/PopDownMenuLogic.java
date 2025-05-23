package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.compose.util.ListStateHolder;
import com.tencent.hippykotlin.demo.pages.adelie.common.compose.util.StateHolder;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.ReportKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieMyTtsVoiceState;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieOIDBServer$requestEditUserTts$1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsDataManager;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsInfo;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsReport;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.TtsPlayState;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.module.AdelieKuiklyTTSPageModule;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import f25.j;
import h25.f;
import h25.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
import yo3.Offset;

/* loaded from: classes31.dex */
public final class PopDownMenuLogic {
    public final PopDownStateManager popDownStateManager;

    public PopDownMenuLogic(PopDownStateManager popDownStateManager) {
        this.popDownStateManager = popDownStateManager;
    }

    public static final void access$reportRenameOrDeleteEvent(PopDownMenuLogic popDownMenuLogic, String str) {
        popDownMenuLogic.getClass();
        e eVar = new e();
        eVar.v("dt_pgid", "pg_bas_ugc_tone_selection");
        e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_ugc_tone_selection");
        m3.v("current_timbre", AdelieTtsReport.currentTimbreId);
        eVar.v("cur_pg", m3);
        eVar.v("dt_eid", str);
        eVar.v("timbre_id", popDownMenuLogic.popDownStateManager.chosenTtsId);
        ReportKt.reportCustomDTEvent("dt_clck", eVar);
    }

    public final void deleteDialog(Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(2110460777);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2110460777, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuLogic.deleteDialog (PopDownMenuLogic.kt:108)");
        }
        Boolean value = this.popDownStateManager.isDeleteDialog._state.getValue();
        final AdelieTtsInfo ttsInfoById = AdelieTtsDataManager.INSTANCE.getTtsInfoById(this.popDownStateManager.chosenTtsId);
        if (Intrinsics.areEqual(value, Boolean.TRUE) && ttsInfoById != null) {
            DeleteDialogKt.DeleteDialog(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuLogic$deleteDialog$onDeleteClick$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(ClickParams clickParams) {
                    PopDownStateManager popDownStateManager = PopDownMenuLogic.this.popDownStateManager;
                    StateHolder<Boolean> stateHolder = popDownStateManager.isDeleteDialog;
                    Boolean bool = Boolean.FALSE;
                    stateHolder._state.setValue(bool);
                    popDownStateManager.shadowState._state.setValue(bool);
                    PopDownMenuLogic popDownMenuLogic = PopDownMenuLogic.this;
                    final AdelieTtsInfo adelieTtsInfo = ttsInfoById;
                    popDownMenuLogic.getClass();
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("deleteTtsInfo id: ");
                    m3.append(adelieTtsInfo.ttsId);
                    m3.append(" name: ");
                    m3.append(adelieTtsInfo.getTtsName());
                    kLog.i("AdelieTtsPopDownMenuLogic", m3.toString());
                    if (adelieTtsInfo.getPlayState() == TtsPlayState.PLAYING) {
                        AdelieKuiklyTTSPageModule adelieKuiklyTTSPageModule = (AdelieKuiklyTTSPageModule) c.f117352a.g().acquireModule("AdelieKuiklyTTSPageModule");
                        e eVar = new e();
                        eVar.v("ttsId", adelieTtsInfo.ttsId);
                        eVar.v("ttsName", adelieTtsInfo.getTtsName());
                        eVar.v("ttsExample", adelieTtsInfo.ttsExample);
                        AdelieKuiklyTTSPageModule.stopTtsVoice$default(adelieKuiklyTTSPageModule, eVar);
                    }
                    j jVar = adelieTtsInfo.ttsInfo;
                    BuildersKt.e(com.tencent.kuikly.core.coroutines.e.f117232d, null, null, new AdelieOIDBServer$requestEditUserTts$1(new Function3<Integer, String, q, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuLogic$deleteTtsInfo$1
                        {
                            super(3);
                        }

                        /* JADX WARN: Type inference failed for: r14v5, types: [java.util.List<com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsInfo>, java.util.ArrayList] */
                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(Integer num, String str, q qVar) {
                            int intValue = num.intValue();
                            String str2 = str;
                            q qVar2 = qVar;
                            if (intValue == 0 && qVar2 != null) {
                                f fVar = qVar2.f404225d;
                                KLog kLog2 = KLog.INSTANCE;
                                StringBuilder m16 = PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("deleteTtsInfo id: "), AdelieTtsInfo.this.ttsId, " errCode: ", intValue, " errMsg: ");
                                m16.append(str2);
                                m16.append(" asyncTask: ");
                                m16.append(fVar);
                                kLog2.i("AdelieTtsPopDownMenuLogic", m16.toString());
                                if (AdelieTtsInfo.this.getPlayState() != TtsPlayState.NONE) {
                                    AdelieTtsDataManager.noneVoiceTtsInfo.playState$delegate.setValue(TtsPlayState.COMPLETED);
                                    AdelieTtsInfo adelieTtsInfo2 = AdelieTtsDataManager.noneVoiceTtsInfo;
                                    k kVar = (k) c.f117352a.g().acquireModule("KRNotifyModule");
                                    e eVar2 = new e();
                                    eVar2.v("ttsId", adelieTtsInfo2.ttsId);
                                    eVar2.v("ttsName", adelieTtsInfo2.getTtsName());
                                    eVar2.t("ttsType", BoxType$EnumUnboxingSharedUtility.ordinal(adelieTtsInfo2.type));
                                    Unit unit = Unit.INSTANCE;
                                    k.d(kVar, "adelie_tts_select_result", eVar2, false, 4, null);
                                }
                                AdelieTtsDataManager adelieTtsDataManager = AdelieTtsDataManager.INSTANCE;
                                AdelieTtsInfo adelieTtsInfo3 = AdelieTtsInfo.this;
                                ?? r142 = AdelieTtsDataManager.ttsInfoList;
                                r142.remove(adelieTtsInfo3);
                                ListStateHolder<AdelieTtsInfo> listStateHolder = AdelieTtsDataManager.myTtsInfoList;
                                ArrayList arrayList = new ArrayList();
                                Iterator it = r142.iterator();
                                while (it.hasNext()) {
                                    Object next = it.next();
                                    if (((AdelieTtsInfo) next).type == 3) {
                                        arrayList.add(next);
                                    }
                                }
                                listStateHolder.updateValueList(arrayList);
                            } else {
                                ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).qToast(str2.length() == 0 ? "\u64cd\u4f5c\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\u3002" : str2, QToastMode.Info);
                                KLog kLog3 = KLog.INSTANCE;
                                StringBuilder m17 = PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("deleteTtsInfo id: "), AdelieTtsInfo.this.ttsId, " errCode: ", intValue, " errMsg: ");
                                m17.append(str2);
                                m17.append(" asyncTask: null");
                                kLog3.i("AdelieTtsPopDownMenuLogic", m17.toString());
                            }
                            return Unit.INSTANCE;
                        }
                    }, 3, jVar, null), 3, null);
                    return Unit.INSTANCE;
                }
            }, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuLogic$deleteDialog$onCancelClick$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(ClickParams clickParams) {
                    PopDownStateManager popDownStateManager = PopDownMenuLogic.this.popDownStateManager;
                    StateHolder<Boolean> stateHolder = popDownStateManager.isDeleteDialog;
                    Boolean bool = Boolean.FALSE;
                    stateHolder._state.setValue(bool);
                    popDownStateManager.shadowState._state.setValue(bool);
                    return Unit.INSTANCE;
                }
            }, ttsInfoById.userNum != 0, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                return;
            }
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuLogic$deleteDialog$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    PopDownMenuLogic.this.deleteDialog(composer2, i3 | 1);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 == null) {
            return;
        }
        endRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuLogic$deleteDialog$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                PopDownMenuLogic.this.deleteDialog(composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public final void popDownMenu(Composer composer, final int i3) {
        List listOf;
        Composer startRestartGroup = composer.startRestartGroup(1124335244);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1124335244, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuLogic.popDownMenu (PopDownMenuLogic.kt:31)");
        }
        Boolean value = this.popDownStateManager.isPopDownMenu._state.getValue();
        AdelieTtsInfo ttsInfoById = AdelieTtsDataManager.INSTANCE.getTtsInfoById(this.popDownStateManager.chosenTtsId);
        AdelieMyTtsVoiceState state = ttsInfoById != null ? ttsInfoById.getState() : null;
        if (Intrinsics.areEqual(value, Boolean.FALSE)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                return;
            }
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuLogic$popDownMenu$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    PopDownMenuLogic.this.popDownMenu(composer2, i3 | 1);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        Offset offset = this.popDownStateManager.chosenTtsOffset;
        PopDownMenuItemData[] popDownMenuItemDataArr = new PopDownMenuItemData[2];
        final boolean z16 = state == AdelieMyTtsVoiceState.ERROR || state == AdelieMyTtsVoiceState.CANNOT;
        QUIToken qUIToken = QUIToken.INSTANCE;
        PopDownMenuItemData popDownMenuItemData = new PopDownMenuItemData("\u91cd\u547d\u540d", qUIToken.image("edit", null), new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuLogic$getRenameItem$renameItem$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                if (!z16) {
                    PopDownStateManager popDownStateManager = this.popDownStateManager;
                    StateHolder<Boolean> stateHolder = popDownStateManager.isRenameDialog;
                    Boolean bool = Boolean.TRUE;
                    stateHolder._state.setValue(bool);
                    popDownStateManager.shadowState._state.setValue(bool);
                    popDownStateManager.popDownMenuDisappear();
                    PopDownMenuLogic.access$reportRenameOrDeleteEvent(this, "em_bas_rename");
                }
                return Unit.INSTANCE;
            }
        });
        if (z16) {
            popDownMenuItemData.enableClick = false;
        }
        popDownMenuItemDataArr[0] = popDownMenuItemData;
        popDownMenuItemDataArr[1] = new PopDownMenuItemData("\u5220\u9664", qUIToken.image("qui_delete", null), new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuLogic$getDeleteItem$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                PopDownStateManager popDownStateManager = PopDownMenuLogic.this.popDownStateManager;
                StateHolder<Boolean> stateHolder = popDownStateManager.isDeleteDialog;
                Boolean bool = Boolean.TRUE;
                stateHolder._state.setValue(bool);
                popDownStateManager.shadowState._state.setValue(bool);
                popDownStateManager.popDownMenuDisappear();
                PopDownMenuLogic.access$reportRenameOrDeleteEvent(PopDownMenuLogic.this, "em_bas_delete");
                return Unit.INSTANCE;
            }
        });
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) popDownMenuItemDataArr);
        PopDownMenuKt.PopDownMenu(offset, listOf, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuLogic$removeClick$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                PopDownMenuLogic.this.popDownStateManager.popDownMenuDisappear();
                return Unit.INSTANCE;
            }
        }, startRestartGroup, Offset.f450729d | 64);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 == null) {
            return;
        }
        endRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuLogic$popDownMenu$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                PopDownMenuLogic.this.popDownMenu(composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public final void renameDialog(Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(447483644);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(447483644, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuLogic.renameDialog (PopDownMenuLogic.kt:83)");
        }
        Boolean value = this.popDownStateManager.isRenameDialog._state.getValue();
        AdelieTtsInfo ttsInfoById = AdelieTtsDataManager.INSTANCE.getTtsInfoById(this.popDownStateManager.chosenTtsId);
        final j jVar = ttsInfoById != null ? ttsInfoById.ttsInfo : null;
        String str = jVar != null ? jVar.f397756e : null;
        if (Intrinsics.areEqual(value, Boolean.TRUE) && jVar != null) {
            if (!(str == null || str.length() == 0)) {
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = "";
                RenameDialogKt.RenameDialog(str, new Function1<String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuLogic$renameDialog$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX WARN: Type inference failed for: r2v3, types: [T, java.lang.String] */
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(String str2) {
                        CharSequence trim;
                        Ref.ObjectRef<String> objectRef2 = objectRef;
                        trim = StringsKt__StringsKt.trim((CharSequence) str2);
                        objectRef2.element = trim.toString();
                        return Unit.INSTANCE;
                    }
                }, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuLogic$renameDialog$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ClickParams clickParams) {
                        PopDownStateManager popDownStateManager = PopDownMenuLogic.this.popDownStateManager;
                        StateHolder<Boolean> stateHolder = popDownStateManager.isRenameDialog;
                        Boolean bool = Boolean.FALSE;
                        stateHolder._state.setValue(bool);
                        popDownStateManager.shadowState._state.setValue(bool);
                        final PopDownMenuLogic popDownMenuLogic = PopDownMenuLogic.this;
                        final j jVar2 = jVar;
                        final String str2 = objectRef.element;
                        popDownMenuLogic.getClass();
                        KLog kLog = KLog.INSTANCE;
                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("renameTtsInfo id: ");
                        m3.append(jVar2.f397755d);
                        m3.append(" oldName: ");
                        m3.append(jVar2.f397756e);
                        m3.append(" newName: ");
                        m3.append(str2);
                        kLog.i("AdelieTtsPopDownMenuLogic", m3.toString());
                        j jVar3 = new j(jVar2.f397755d, str2, jVar2.f397757f, jVar2.f397758h);
                        BuildersKt.e(com.tencent.kuikly.core.coroutines.e.f117232d, null, null, new AdelieOIDBServer$requestEditUserTts$1(new Function3<Integer, String, q, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuLogic$renameTtsInfo$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(Integer num, String str3, q qVar) {
                                int intValue = num.intValue();
                                String str4 = str3;
                                q qVar2 = qVar;
                                if (intValue == 0 && qVar2 != null) {
                                    f fVar = qVar2.f404225d;
                                    KLog kLog2 = KLog.INSTANCE;
                                    StringBuilder m16 = PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("renameTtsInfo id: "), j.this.f397755d, " errCode: ", intValue, " errMsg: ");
                                    m16.append(str4);
                                    m16.append(" asyncTask: ");
                                    m16.append(fVar);
                                    kLog2.i("AdelieTtsPopDownMenuLogic", m16.toString());
                                    AdelieTtsInfo ttsInfoById2 = AdelieTtsDataManager.INSTANCE.getTtsInfoById(popDownMenuLogic.popDownStateManager.chosenTtsId);
                                    if (ttsInfoById2 != null) {
                                        j jVar4 = ttsInfoById2.ttsInfo;
                                        ttsInfoById2.ttsInfo = new j(jVar4 != null ? jVar4.f397755d : null, str2, jVar4 != null ? jVar4.f397757f : null, jVar4 != null ? jVar4.f397758h : null);
                                        ttsInfoById2.ttsName$delegate.setValue(str2);
                                        k kVar = (k) c.f117352a.g().acquireModule("KRNotifyModule");
                                        e eVar = new e();
                                        eVar.v("ttsId", ttsInfoById2.ttsId);
                                        eVar.v("ttsName", ttsInfoById2.getTtsName());
                                        eVar.t("ttsType", BoxType$EnumUnboxingSharedUtility.ordinal(ttsInfoById2.type));
                                        Unit unit = Unit.INSTANCE;
                                        k.d(kVar, "adelie_tts_select_result", eVar, false, 4, null);
                                    }
                                } else {
                                    ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).qToast(str4.length() == 0 ? "\u64cd\u4f5c\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\u3002" : str4, QToastMode.Info);
                                    KLog kLog3 = KLog.INSTANCE;
                                    StringBuilder m17 = PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("renameTtsInfo id: "), j.this.f397755d, " errCode: ", intValue, " errMsg: ");
                                    m17.append(str4);
                                    m17.append(" asyncTask: null");
                                    kLog3.i("AdelieTtsPopDownMenuLogic", m17.toString());
                                }
                                return Unit.INSTANCE;
                            }
                        }, 2, jVar3, null), 3, null);
                        return Unit.INSTANCE;
                    }
                }, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuLogic$renameDialog$4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ClickParams clickParams) {
                        PopDownStateManager popDownStateManager = PopDownMenuLogic.this.popDownStateManager;
                        StateHolder<Boolean> stateHolder = popDownStateManager.isRenameDialog;
                        Boolean bool = Boolean.FALSE;
                        stateHolder._state.setValue(bool);
                        popDownStateManager.shadowState._state.setValue(bool);
                        return Unit.INSTANCE;
                    }
                }, startRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                    return;
                }
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuLogic$renameDialog$5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Composer composer2, Integer num) {
                        num.intValue();
                        PopDownMenuLogic.this.renameDialog(composer2, i3 | 1);
                        return Unit.INSTANCE;
                    }
                });
                return;
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 == null) {
            return;
        }
        endRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuLogic$renameDialog$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                PopDownMenuLogic.this.renameDialog(composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
