package com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.result;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendPbRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.data.NBPMoodGroupConfig;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.repo.GetMatchRequest;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.repo.NBPShootRepo;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.NBPMoodGroupReportViewModel;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.views.InputView;
import java.util.ArrayList;
import java.util.List;
import k35.a;
import k35.n;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import o25.e;
import w25.d;
import w25.g;

/* loaded from: classes31.dex */
public final class NBPShootResultViewModel {
    public final List<String> blueNumberIcons;
    public int boomCount;
    public d cardData;
    public NBPMoodGroupConfig.BackgroundImage cartoonImg;
    public MutableState<Boolean> collectCardAnimation;
    public String configString;
    public final MutableState editedText$delegate;
    public String emojiId;
    public final MutableState enterAnimPlayed$delegate;
    public MutableState<Boolean> fadeOutAnimation;
    public a gameData;
    public List<String> guidePicture;
    public String guideText;
    public boolean hasAddHeight;
    public final MutableState hasEntranceAnimationFinished$delegate;
    public aa<InputView> inputRef;
    public aa<ViewContainer<?, ?>> inputViewRef;
    public final MutableState isPublishing$delegate;
    public boolean isResultViewPopable;
    public List<g> matchResult;
    public int matchViewCount;
    public int mid;
    public final MutableState needToBlur$delegate;
    public String openPageNotifyCallbackRef;
    public boolean readyToShowThemeMapGuide;
    public final MutableState recommendMatchMsgList$delegate;
    public final Lazy repo$delegate;
    public final NBPMoodGroupReportViewModel reportVM;
    public final MutableState resultConfig$delegate;
    public MutableState<NBPShootResultPageState> resultViewState;
    public boolean shareImageLoadedCheck;
    public int shareView;
    public List<n> shootRspList;
    public MutableState<Boolean> showDefaultResult;
    public final MutableState showThemeMapGuide$delegate;
    public MutableState<Float> smallScreenOffsetY;
    public List<String> specialNumberIconArray;
    public final MutableState textIndex$delegate;
    public String themeId;
    public NBPMoodGroupConfig.BackgroundImage topRightBackgroundImg;
    public final List<String> yellowNumberIcons;

    public NBPShootResultViewModel(NBPMoodGroupReportViewModel nBPMoodGroupReportViewModel) {
        Lazy lazy;
        MutableState<NBPShootResultPageState> mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState<Boolean> mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        MutableState mutableStateOf$default5;
        MutableState mutableStateOf$default6;
        List<g> emptyList;
        MutableState mutableStateOf$default7;
        MutableState mutableStateOf$default8;
        List emptyList2;
        MutableState mutableStateOf$default9;
        List<String> emptyList3;
        MutableState mutableStateOf$default10;
        MutableState mutableStateOf$default11;
        MutableState<Float> mutableStateOf$default12;
        MutableState<Boolean> mutableStateOf$default13;
        MutableState<Boolean> mutableStateOf$default14;
        List<String> listOf;
        List<String> listOf2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<NBPShootRepo>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.result.NBPShootResultViewModel$repo$2
            @Override // kotlin.jvm.functions.Function0
            public final NBPShootRepo invoke() {
                return new NBPShootRepo();
            }
        });
        this.repo$delegate = lazy;
        this.reportVM = nBPMoodGroupReportViewModel;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(NBPShootResultPageState.NULL, null, 2, null);
        this.resultViewState = mutableStateOf$default;
        Boolean bool = Boolean.FALSE;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.needToBlur$delegate = mutableStateOf$default2;
        this.mid = 1;
        this.themeId = "";
        this.emojiId = "";
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.showDefaultResult = mutableStateOf$default3;
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.isPublishing$delegate = mutableStateOf$default4;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.enterAnimPlayed$delegate = mutableStateOf$default5;
        mutableStateOf$default6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.hasEntranceAnimationFinished$delegate = mutableStateOf$default6;
        this.gameData = new a(this.boomCount);
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.matchResult = emptyList;
        this.configString = "";
        mutableStateOf$default7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.resultConfig$delegate = mutableStateOf$default7;
        this.shootRspList = new ArrayList();
        this.isResultViewPopable = true;
        mutableStateOf$default8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        this.textIndex$delegate = mutableStateOf$default8;
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        mutableStateOf$default9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(emptyList2, null, 2, null);
        this.recommendMatchMsgList$delegate = mutableStateOf$default9;
        this.guideText = "";
        emptyList3 = CollectionsKt__CollectionsKt.emptyList();
        this.guidePicture = emptyList3;
        this.topRightBackgroundImg = new NBPMoodGroupConfig.BackgroundImage(0, 0, "", 0);
        this.cartoonImg = new NBPMoodGroupConfig.BackgroundImage(0, 0, "", 0);
        mutableStateOf$default10 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
        this.editedText$delegate = mutableStateOf$default10;
        mutableStateOf$default11 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.showThemeMapGuide$delegate = mutableStateOf$default11;
        this.cardData = new d(null, null, null, null, null, null, 63, null);
        mutableStateOf$default12 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
        this.smallScreenOffsetY = mutableStateOf$default12;
        mutableStateOf$default13 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.fadeOutAnimation = mutableStateOf$default13;
        mutableStateOf$default14 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.collectCardAnimation = mutableStateOf$default14;
        this.specialNumberIconArray = new ArrayList();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_d8tp5hlMm1G.png", "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_xlDA9s2SB5Q.png", "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_NGXKkJAF_E4.png", "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_FcQjSPDaqgH.png", "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_iniI4I-D-cH.png", "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_MV4fqpklfjv.png", "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_oI5jt_R0JEr.png", "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_V5X13Q32Ibv.png", "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_DgqP7xkjPYt.png", "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_NnODHksduzO.png"});
        this.blueNumberIcons = listOf;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_okpX8Pw6g2J.png", "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_oMmTHfQHGvX.png", "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_F7R5NOlb7j1.png", "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_Brr-vWjXL5y.png", "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_2bDerBrhwvB.png", "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_CLuZ8usYiZh.png", "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_sJpAPp0AFGa.png", "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_8Plkcc9Nj_v.png", "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_9ewd6s4L1ii.png", "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_C0G7qsECmNE.png"});
        this.yellowNumberIcons = listOf2;
    }

    public static final String access$safeStringForRequest(NBPShootResultViewModel nBPShootResultViewModel, String str, String str2) {
        nBPShootResultViewModel.getClass();
        if (str != null) {
            if (!(str.length() == 0)) {
                return str;
            }
        }
        return str2.length() == 0 ? "Unknown" : str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String getEditedText() {
        return (String) this.editedText$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getEnterAnimPlayed() {
        return ((Boolean) this.enterAnimPlayed$delegate.getValue()).booleanValue();
    }

    public final List<String> getRecommendMatchMsgList() {
        return (List) this.recommendMatchMsgList$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final NBPMoodGroupConfig getResultConfig$qecommerce_biz_release() {
        return (NBPMoodGroupConfig) this.resultConfig$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int getTextIndex() {
        return ((Number) this.textIndex$delegate.getValue()).intValue();
    }

    public final void loadPageData() {
        UserDataManager userDataManager = UserDataManager.INSTANCE;
        e eVar = new e((float) userDataManager.getUserSelfInfo().latLng.latitude, (float) userDataManager.getUserSelfInfo().latLng.longitude, 4);
        NBPShootRepo nBPShootRepo = (NBPShootRepo) this.repo$delegate.getValue();
        int i3 = this.mid;
        a aVar = this.gameData;
        final Function3<n, Integer, String, Unit> function3 = new Function3<n, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.result.NBPShootResultViewModel$loadPageData$1
            {
                super(3);
            }

            /* JADX WARN: Type inference failed for: r0v7, types: [java.util.List<java.lang.String>, java.util.ArrayList] */
            /* JADX WARN: Type inference failed for: r3v2, types: [java.util.List<java.lang.String>, java.util.ArrayList] */
            /* JADX WARN: Type inference failed for: r3v3, types: [java.util.List<java.lang.String>, java.util.ArrayList] */
            /* JADX WARN: Type inference failed for: r7v11, types: [java.util.List<k35.n>, java.util.ArrayList] */
            /* JADX WARN: Type inference failed for: r7v13, types: [java.util.List<k35.n>, java.util.ArrayList] */
            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(n nVar, Integer num, String str) {
                List<g> list;
                n nVar2 = nVar;
                num.intValue();
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchMatchInfo success, hitCount: ");
                m3.append(nVar2 != null ? Long.valueOf(nVar2.f411569d) : null);
                m3.append(", matchUser size: ");
                m3.append((nVar2 == null || (list = nVar2.f411571f) == null) ? null : Integer.valueOf(list.size()));
                m3.append(", type: ");
                NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0.m(m3, nVar2 != null ? Integer.valueOf(nVar2.f411570e) : null, kLog, "NBPShootResultPage");
                if (nVar2 != null) {
                    NBPShootResultViewModel.this.showDefaultResult.setValue(Boolean.TRUE);
                    NBPShootResultViewModel nBPShootResultViewModel = NBPShootResultViewModel.this;
                    nBPShootResultViewModel.matchResult = nVar2.f411571f;
                    int i16 = (int) nVar2.f411569d;
                    if (nBPShootResultViewModel.blueNumberIcons.size() >= 10 && nBPShootResultViewModel.yellowNumberIcons.size() >= 10) {
                        nBPShootResultViewModel.specialNumberIconArray.clear();
                        String valueOf = String.valueOf(i16);
                        for (int i17 = 0; i17 < valueOf.length(); i17++) {
                            int parseInt = Integer.parseInt(String.valueOf(valueOf.charAt(i17)));
                            if (parseInt < 10) {
                                if (Intrinsics.areEqual(nBPShootResultViewModel.emojiId, "1")) {
                                    nBPShootResultViewModel.specialNumberIconArray.add(nBPShootResultViewModel.yellowNumberIcons.get(parseInt));
                                } else {
                                    nBPShootResultViewModel.specialNumberIconArray.add(nBPShootResultViewModel.blueNumberIcons.get(parseInt));
                                }
                            }
                        }
                    }
                    if (nVar2.f411570e == 1) {
                        d dVar = nVar2.f411572h;
                        if (dVar != null) {
                            NBPShootResultViewModel nBPShootResultViewModel2 = NBPShootResultViewModel.this;
                            nBPShootResultViewModel2.cardData = dVar;
                            nBPShootResultViewModel2.shootRspList.add(nVar2);
                        }
                    } else if (!nVar2.f411571f.isEmpty()) {
                        NBPShootResultViewModel.this.shootRspList.add(nVar2);
                    }
                } else {
                    kLog.e("NBPShootResultPage", "fetchMatchInfo error");
                }
                return Unit.INSTANCE;
            }
        };
        nBPShootRepo.getClass();
        KLog.INSTANCE.i("NBPShootResultPage", "getMatchFriendInfo. mid:" + i3);
        GetMatchRequest getMatchRequest = new GetMatchRequest(i3, eVar, aVar);
        Function1<PbResponse<n>, Unit> function1 = new Function1<PbResponse<n>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.repo.NBPShootRepo$fetchMatchInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(PbResponse<n> pbResponse) {
                PbResponse<n> pbResponse2 = pbResponse;
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("getMatchFriendInfo response, ");
                m3.append(pbResponse2.f114187msg);
                m3.append(", ");
                ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(m3, pbResponse2.code, kLog, "NBPShootResultPage");
                function3.invoke(pbResponse2.rsp, Integer.valueOf(pbResponse2.code), pbResponse2.f114187msg);
                return Unit.INSTANCE;
            }
        };
        APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.lplan.mood_svr.MoodSvr.SsoMatch");
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.sendPbRequest$default(getMatchRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, function1), 6);
    }

    public final void setNeedToBlur(boolean z16) {
        this.needToBlur$delegate.setValue(Boolean.valueOf(z16));
    }

    public final void setShowThemeMapGuide(boolean z16) {
        this.showThemeMapGuide$delegate.setValue(Boolean.valueOf(z16));
    }
}
