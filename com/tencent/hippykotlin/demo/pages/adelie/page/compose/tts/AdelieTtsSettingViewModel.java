package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts;

import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.tencent.hippykotlin.demo.pages.adelie.common.compose.util.ListStateHolder;
import com.tencent.hippykotlin.demo.pages.adelie.common.compose.util.StateHolder;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownStateManager;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.coroutines.e;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.timer.TimerKt;
import f25.j;
import h25.i;
import h25.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdelieTtsSettingViewModel {
    public boolean isFetchDataEnd;
    public boolean isResume;
    public int maxUserTtsCount;
    public final StateHolder<PageState> pageState = new StateHolder<>(PageState.LOADING);
    public final Lazy popDownStateManager$delegate;
    public StateHolder<Boolean> showCreatFloatView;
    public StateHolder<Boolean> showLoading;
    public final AdelieTtsSettingViewModel$stateManagerCallback$1 stateManagerCallback;
    public final Lazy ttsInfoStateManager$delegate;
    public boolean userIsSelected;

    /* JADX WARN: Type inference failed for: r0v8, types: [com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingViewModel$stateManagerCallback$1] */
    public AdelieTtsSettingViewModel() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AdelieTtsInfoStateManager>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingViewModel$ttsInfoStateManager$2
            @Override // kotlin.jvm.functions.Function0
            public final AdelieTtsInfoStateManager invoke() {
                return new AdelieTtsInfoStateManager();
            }
        });
        this.ttsInfoStateManager$delegate = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<PopDownStateManager>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingViewModel$popDownStateManager$2
            @Override // kotlin.jvm.functions.Function0
            public final PopDownStateManager invoke() {
                return new PopDownStateManager();
            }
        });
        this.popDownStateManager$delegate = lazy2;
        Boolean bool = Boolean.FALSE;
        this.showCreatFloatView = new StateHolder<>(bool);
        this.showLoading = new StateHolder<>(bool);
        this.isResume = true;
        this.stateManagerCallback = new IAdelieTtsInfoStateManagerCallback() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingViewModel$stateManagerCallback$1
            @Override // com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.IAdelieTtsInfoStateManagerCallback
            public final void checkFail(String str, AdelieMyTtsVoiceState adelieMyTtsVoiceState, String str2) {
                AdelieTtsInfo ttsInfoByTaskId = AdelieTtsDataManager.INSTANCE.getTtsInfoByTaskId(str);
                if (ttsInfoByTaskId != null) {
                    ttsInfoByTaskId.state$delegate.setValue(adelieMyTtsVoiceState);
                }
                ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).qToast(str2, QToastMode.Info);
            }

            @Override // com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.IAdelieTtsInfoStateManagerCallback
            public final void checkSuccess(String str, String str2, String str3, PollingEntrance pollingEntrance) {
                AdelieTtsDataManager adelieTtsDataManager = AdelieTtsDataManager.INSTANCE;
                AdelieTtsInfo ttsInfoByTaskId = adelieTtsDataManager.getTtsInfoByTaskId(str);
                if (ttsInfoByTaskId != null) {
                    ttsInfoByTaskId.ttsId = str2;
                }
                if (ttsInfoByTaskId != null) {
                    ttsInfoByTaskId.ttsExample = str3;
                }
                if (ttsInfoByTaskId != null) {
                    ttsInfoByTaskId.state$delegate.setValue(AdelieMyTtsVoiceState.SUCCESS);
                }
                if (pollingEntrance == PollingEntrance.PRE_PAGE) {
                    return;
                }
                ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).qToast("\u58f0\u97f3\u5df2\u521b\u5efa\u6210\u529f", QToastMode.Success);
                AdelieTtsSettingViewModel adelieTtsSettingViewModel = AdelieTtsSettingViewModel.this;
                if (adelieTtsSettingViewModel.userIsSelected || !adelieTtsSettingViewModel.isResume || ttsInfoByTaskId == null) {
                    return;
                }
                AdelieTtsInfo selectTtsInfo = adelieTtsDataManager.getSelectTtsInfo();
                if (selectTtsInfo != null) {
                    selectTtsInfo.playState$delegate.setValue(TtsPlayState.NONE);
                }
                AdelieTtsPlayerManager.INSTANCE.startPlay(ttsInfoByTaskId);
            }
        };
    }

    /* JADX WARN: Type inference failed for: r12v1, types: [java.util.List<com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsInfo>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r13v2, types: [java.util.List<com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsInfo>, java.util.ArrayList] */
    public static final void access$handleMyTtsList(AdelieTtsSettingViewModel adelieTtsSettingViewModel, s sVar) {
        int collectionSizeOrDefault;
        String str;
        AdelieMyTtsVoiceState adelieMyTtsVoiceState;
        String str2;
        String str3;
        adelieTtsSettingViewModel.getClass();
        AdelieTtsDataManager.ttsInfoList.removeAll(AdelieTtsDataManager.myTtsInfoList._stateList);
        List<i> list = sVar.f404237m;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        int i3 = 0;
        for (Object obj : list) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            i iVar = (i) obj;
            j jVar = iVar.f404208d;
            String str4 = "";
            if (jVar == null || (str = jVar.f397755d) == null) {
                str = "";
            }
            AdelieTtsInfo adelieTtsInfo = new AdelieTtsInfo(str, (jVar == null || (str3 = jVar.f397758h) == null) ? "" : str3, 3, iVar.f404210f, iVar.f404211h);
            j jVar2 = iVar.f404208d;
            if (jVar2 != null && (str2 = jVar2.f397756e) != null) {
                str4 = str2;
            }
            adelieTtsInfo.ttsName$delegate.setValue(str4);
            AdelieMyTtsVoiceState[] values = AdelieMyTtsVoiceState.values();
            int length = values.length;
            int i17 = 0;
            while (true) {
                if (i17 >= length) {
                    adelieMyTtsVoiceState = null;
                    break;
                }
                adelieMyTtsVoiceState = values[i17];
                if (adelieMyTtsVoiceState.value == iVar.f404209e) {
                    break;
                } else {
                    i17++;
                }
            }
            if (adelieMyTtsVoiceState == null) {
                if (iVar.f404209e == 0) {
                    adelieMyTtsVoiceState = AdelieMyTtsVoiceState.SUCCESS;
                } else {
                    adelieMyTtsVoiceState = AdelieMyTtsVoiceState.ERROR;
                }
            }
            adelieTtsInfo.state$delegate.setValue(adelieMyTtsVoiceState);
            adelieTtsInfo.ttsInfo = iVar.f404208d;
            AdelieTtsDataManager.INSTANCE.addTtsInfo(adelieTtsInfo, i16);
            KLog kLog = KLog.INSTANCE;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("handleMyTtsList AdelieTtsInfo value: ");
            sb5.append(adelieTtsInfo);
            sb5.append(" and ttsState = ");
            ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(sb5, iVar.f404209e, kLog, "AdelieTtsSettingViewModel");
            arrayList.add(Unit.INSTANCE);
            i3 = i16;
        }
        ListStateHolder<AdelieTtsInfo> listStateHolder = AdelieTtsDataManager.myTtsInfoList;
        ?? r132 = AdelieTtsDataManager.ttsInfoList;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = r132.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (((AdelieTtsInfo) next).type == 3) {
                arrayList2.add(next);
            }
        }
        listStateHolder.updateValueList(arrayList2);
    }

    public static final void access$handleTtsLoadingState(AdelieTtsSettingViewModel adelieTtsSettingViewModel, PollingEntrance pollingEntrance, String str) {
        int collectionSizeOrDefault;
        adelieTtsSettingViewModel.getClass();
        SnapshotStateList<AdelieTtsInfo> snapshotStateList = AdelieTtsDataManager.myTtsInfoList._stateList;
        ArrayList arrayList = new ArrayList();
        Iterator<AdelieTtsInfo> it = snapshotStateList.iterator();
        while (it.hasNext()) {
            AdelieTtsInfo next = it.next();
            if (next.getState() == AdelieMyTtsVoiceState.LOADING) {
                arrayList.add(next);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            AdelieTtsInfo adelieTtsInfo = (AdelieTtsInfo) it5.next();
            if (str == null) {
                adelieTtsSettingViewModel.getTtsInfoStateManager().monitorTtsState(adelieTtsInfo.taskId, pollingEntrance);
            } else if (Intrinsics.areEqual(str, adelieTtsInfo.taskId)) {
                adelieTtsSettingViewModel.getTtsInfoStateManager().monitorTtsState(adelieTtsInfo.taskId, pollingEntrance);
            }
            arrayList2.add(Unit.INSTANCE);
        }
    }

    public final void fetchTtsInfoFromServer() {
        StateHolder<PageState> stateHolder = this.pageState;
        stateHolder._state.setValue(PageState.LOADING);
        TimerKt.c(300, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingViewModel$fetchTtsInfoFromServer$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                AdelieTtsSettingViewModel adelieTtsSettingViewModel = AdelieTtsSettingViewModel.this;
                if (!adelieTtsSettingViewModel.isFetchDataEnd) {
                    StateHolder<Boolean> stateHolder2 = adelieTtsSettingViewModel.showLoading;
                    stateHolder2._state.setValue(Boolean.TRUE);
                }
                return Unit.INSTANCE;
            }
        });
        BuildersKt.e(e.f117232d, null, null, new AdelieOIDBServer$requestTtsList$1(new Function3<Integer, String, s, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingViewModel$fetchTtsInfoFromServer$2
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(Integer num, String str, s sVar) {
                List<j> list;
                int collectionSizeOrDefault;
                int intValue = num.intValue();
                s sVar2 = sVar;
                AdelieTtsSettingViewModel adelieTtsSettingViewModel = AdelieTtsSettingViewModel.this;
                adelieTtsSettingViewModel.isFetchDataEnd = true;
                adelieTtsSettingViewModel.showLoading._state.setValue(Boolean.FALSE);
                if (intValue == 0 && sVar2 != null) {
                    AdelieTtsSettingViewModel.this.maxUserTtsCount = sVar2.C;
                    f25.i iVar = sVar2.f404232d;
                    if (iVar != null && (list = iVar.f397754e) != null) {
                        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                        for (j jVar : list) {
                            String str2 = jVar.f397755d;
                            String str3 = "";
                            String str4 = str2 == null ? "" : str2;
                            String str5 = jVar.f397758h;
                            if (str5 == null) {
                                str5 = "";
                            }
                            AdelieTtsInfo adelieTtsInfo = new AdelieTtsInfo(str4, str5, Intrinsics.areEqual(str2, "none_voice") ? 1 : 2, 24);
                            adelieTtsInfo.state$delegate.setValue(AdelieMyTtsVoiceState.SUCCESS);
                            String str6 = jVar.f397756e;
                            if (str6 != null) {
                                str3 = str6;
                            }
                            adelieTtsInfo.ttsName$delegate.setValue(str3);
                            AdelieTtsDataManager.INSTANCE.addTtsInfo(adelieTtsInfo, -1);
                            arrayList.add(Unit.INSTANCE);
                        }
                    }
                    AdelieTtsSettingViewModel.access$handleMyTtsList(AdelieTtsSettingViewModel.this, sVar2);
                    AdelieTtsSettingViewModel.this.pageState._state.setValue(PageState.SUCCESS);
                    AdelieTtsSettingViewModel.access$handleTtsLoadingState(AdelieTtsSettingViewModel.this, PollingEntrance.PRE_PAGE, null);
                } else {
                    AdelieTtsSettingViewModel.this.pageState._state.setValue(PageState.ERROR);
                }
                return Unit.INSTANCE;
            }
        }, null), 3, null);
    }

    public final PopDownStateManager getPopDownStateManager() {
        return (PopDownStateManager) this.popDownStateManager$delegate.getValue();
    }

    public final AdelieTtsInfoStateManager getTtsInfoStateManager() {
        return (AdelieTtsInfoStateManager) this.ttsInfoStateManager$delegate.getValue();
    }
}
