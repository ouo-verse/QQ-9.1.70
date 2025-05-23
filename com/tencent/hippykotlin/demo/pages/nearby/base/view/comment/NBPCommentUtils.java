package com.tencent.hippykotlin.demo.pages.nearby.base.view.comment;

import c45.a;
import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QUISkinImage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.CommonProxyRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.CommonProxyService;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.CommonProxyService$handle$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.CommonProxyService$request$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.GetRecommendCommentRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QuickCommentItem;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Ref;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import oicq.wlogin_sdk.tools.util;
import p35.ad;
import p35.z;

/* loaded from: classes31.dex */
public final class NBPCommentUtils {
    public static final NBPCommentUtils INSTANCE = new NBPCommentUtils();
    public static final Lazy config$delegate;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<e>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPCommentUtils$config$2
            @Override // kotlin.jvm.functions.Function0
            public final e invoke() {
                String stringFromQQCommonConfig = QQNearbyModule.Companion.getInstance().getStringFromQQCommonConfig("105637", "{}");
                KLog.INSTANCE.i("NearbyProUtils", QUISkinImage$$ExternalSyntheticOutline0.m("getQQMCConfig: ", "105637", MsgSummary.STR_COLON, stringFromQQCommonConfig));
                try {
                    return new e(stringFromQQCommonConfig);
                } catch (Throwable unused) {
                    return null;
                }
            }
        });
        config$delegate = lazy;
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.util.List, T] */
    public final void loadQuickCommentsData(int i3, final String str, final Function2<? super List<QuickCommentItem>, ? super List<QuickCommentItem>, Unit> function2) {
        ?? emptyList;
        ?? emptyList2;
        final Function2<List<? extends QuickCommentItem>, List<? extends QuickCommentItem>, Unit> function22 = new Function2<List<? extends QuickCommentItem>, List<? extends QuickCommentItem>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPCommentUtils$loadQuickCommentsData$finishCallback$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(List<? extends QuickCommentItem> list, List<? extends QuickCommentItem> list2) {
                int collectionSizeOrDefault;
                List<? extends QuickCommentItem> list3 = list;
                List<? extends QuickCommentItem> list4 = list2;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                for (QuickCommentItem quickCommentItem : list4) {
                    arrayList.add(new QuickCommentItem(quickCommentItem.f114209id, new Regex("\\[(.*?)\\]").replace(quickCommentItem.text, new Function1<MatchResult, CharSequence>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPCommentUtils$loadQuickCommentsData$finishCallback$1$resAIQuickComments$1$1
                        @Override // kotlin.jvm.functions.Function1
                        public final CharSequence invoke(MatchResult matchResult) {
                            StringBuilder m3 = BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0.m('/');
                            m3.append(matchResult.getGroupValues().get(1));
                            return m3.toString();
                        }
                    }), quickCommentItem.trace));
                }
                if (!arrayList.isEmpty()) {
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Object next = it.next();
                        if (((QuickCommentItem) next).text.length() < 10) {
                            arrayList2.add(next);
                        }
                    }
                    list3 = CollectionsKt___CollectionsKt.plus((Collection) arrayList2, (Iterable) list3);
                }
                function2.invoke(list3, arrayList);
                return Unit.INSTANCE;
            }
        };
        e eVar = (e) config$delegate.getValue();
        if (eVar != null && eVar.j("enabledAIQuickComment") == 1) {
            final Ref.IntRef intRef = new Ref.IntRef();
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            objectRef.element = emptyList;
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            objectRef2.element = emptyList2;
            final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPCommentUtils$loadQuickCommentsData$resCallback$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    Ref.IntRef intRef2 = Ref.IntRef.this;
                    int i16 = intRef2.element + 1;
                    intRef2.element = i16;
                    if (i16 == 2) {
                        function22.invoke(objectRef.element, objectRef2.element);
                    }
                    return Unit.INSTANCE;
                }
            };
            final Function1<List<? extends QuickCommentItem>, Unit> function1 = new Function1<List<? extends QuickCommentItem>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPCommentUtils$loadQuickCommentsData$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r2v1, types: [java.util.List, T] */
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(List<? extends QuickCommentItem> list) {
                    objectRef.element = list;
                    function0.invoke();
                    return Unit.INSTANCE;
                }
            };
            KLog kLog = KLog.INSTANCE;
            kLog.i("StrangerFeedCommentRepo", "fetchFeedQuickComments: feedId=" + str);
            GetRecommendCommentRequest getRecommendCommentRequest = new GetRecommendCommentRequest(i3, str, 0);
            CommonProxyService commonProxyService = CommonProxyService.INSTANCE;
            commonProxyService.request(getRecommendCommentRequest, new Function4<z, byte[], Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.repo.StrangerFeedCommentRepo$fetchFeedQuickComments$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public final Unit invoke(z zVar, byte[] bArr, Integer num, String str2) {
                    List<QuickCommentItem> emptyList3;
                    int collectionSizeOrDefault;
                    z zVar2 = zVar;
                    int intValue = num.intValue();
                    String str3 = str2;
                    KLog kLog2 = KLog.INSTANCE;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchFeedQuickComments: rspIsNull=");
                    m3.append(zVar2 == null);
                    m3.append(" feedId=");
                    AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0.m(m3, str, ", code=", intValue, ", msg="), str3, kLog2, "StrangerFeedCommentRepo");
                    List<ad> list = zVar2 != null ? zVar2.f425231d : null;
                    if (intValue == 0 && list != null) {
                        Function1<List<QuickCommentItem>, Unit> function12 = function1;
                        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                        for (ad adVar : list) {
                            arrayList.add(new QuickCommentItem(adVar.f425126e, adVar.f425125d, adVar.f425128h));
                        }
                        function12.invoke(arrayList);
                    } else {
                        Function1<List<QuickCommentItem>, Unit> function13 = function1;
                        emptyList3 = CollectionsKt__CollectionsKt.emptyList();
                        function13.invoke(emptyList3);
                    }
                    return Unit.INSTANCE;
                }
            });
            final Function1<List<? extends QuickCommentItem>, Unit> function12 = new Function1<List<? extends QuickCommentItem>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPCommentUtils$loadQuickCommentsData$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r2v1, types: [java.util.List, T] */
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(List<? extends QuickCommentItem> list) {
                    objectRef2.element = list;
                    function0.invoke();
                    return Unit.INSTANCE;
                }
            };
            kLog.i("StrangerFeedCommentRepo", "fetchFeedQuickComments: feedId=" + str);
            commonProxyService.request(new GetRecommendCommentRequest(i3, str, 1), new Function4<z, byte[], Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.repo.StrangerFeedCommentRepo$fetchFeedQuickComments$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public final Unit invoke(z zVar, byte[] bArr, Integer num, String str2) {
                    List<QuickCommentItem> emptyList3;
                    int collectionSizeOrDefault;
                    z zVar2 = zVar;
                    int intValue = num.intValue();
                    String str3 = str2;
                    KLog kLog2 = KLog.INSTANCE;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchFeedQuickComments: rspIsNull=");
                    m3.append(zVar2 == null);
                    m3.append(" feedId=");
                    AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0.m(m3, str, ", code=", intValue, ", msg="), str3, kLog2, "StrangerFeedCommentRepo");
                    List<ad> list = zVar2 != null ? zVar2.f425231d : null;
                    if (intValue == 0 && list != null) {
                        Function1<List<QuickCommentItem>, Unit> function122 = function12;
                        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                        for (ad adVar : list) {
                            arrayList.add(new QuickCommentItem(adVar.f425126e, adVar.f425125d, adVar.f425128h));
                        }
                        function122.invoke(arrayList);
                    } else {
                        Function1<List<QuickCommentItem>, Unit> function13 = function12;
                        emptyList3 = CollectionsKt__CollectionsKt.emptyList();
                        function13.invoke(emptyList3);
                    }
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        final Function1<List<? extends QuickCommentItem>, Unit> function13 = new Function1<List<? extends QuickCommentItem>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPCommentUtils$loadQuickCommentsData$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(List<? extends QuickCommentItem> list) {
                List emptyList3;
                Function2<List<QuickCommentItem>, List<QuickCommentItem>, Unit> function23 = function22;
                emptyList3 = CollectionsKt__CollectionsKt.emptyList();
                function23.invoke(list, emptyList3);
                return Unit.INSTANCE;
            }
        };
        KLog kLog2 = KLog.INSTANCE;
        kLog2.i("StrangerFeedCommentRepo", "fetchFeedQuickComments: feedId=" + str);
        GetRecommendCommentRequest getRecommendCommentRequest2 = new GetRecommendCommentRequest(i3, str, 0);
        Function4<z, byte[], Integer, String, Unit> function4 = new Function4<z, byte[], Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.repo.StrangerFeedCommentRepo$fetchFeedQuickComments$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public final Unit invoke(z zVar, byte[] bArr, Integer num, String str2) {
                List<QuickCommentItem> emptyList3;
                int collectionSizeOrDefault;
                z zVar2 = zVar;
                int intValue = num.intValue();
                String str3 = str2;
                KLog kLog22 = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchFeedQuickComments: rspIsNull=");
                m3.append(zVar2 == null);
                m3.append(" feedId=");
                AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0.m(m3, str, ", code=", intValue, ", msg="), str3, kLog22, "StrangerFeedCommentRepo");
                List<ad> list = zVar2 != null ? zVar2.f425231d : null;
                if (intValue == 0 && list != null) {
                    Function1<List<QuickCommentItem>, Unit> function122 = function13;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    for (ad adVar : list) {
                        arrayList.add(new QuickCommentItem(adVar.f425126e, adVar.f425125d, adVar.f425128h));
                    }
                    function122.invoke(arrayList);
                } else {
                    Function1<List<QuickCommentItem>, Unit> function132 = function13;
                    emptyList3 = CollectionsKt__CollectionsKt.emptyList();
                    function132.invoke(emptyList3);
                }
                return Unit.INSTANCE;
            }
        };
        a aVar = new a(i.d(getRecommendCommentRequest2.getRequest()));
        int appId = getRecommendCommentRequest2.getAppId();
        CommonProxyService$request$1 commonProxyService$request$1 = new CommonProxyService$request$1(function4, getRecommendCommentRequest2);
        StringBuilder m3 = AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0.m("req: appId=", appId, " service=", "QQStranger.FeedSvr", " method=");
        m3.append("GetRecommendComment");
        kLog2.i("CommonProxyService", m3.toString());
        APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, appId + util.base64_pad_url + "QQStranger.FeedSvr.GetRecommendComment");
        CommonProxyRequest commonProxyRequest = new CommonProxyRequest(appId, "QQStranger.FeedSvr", "GetRecommendComment", aVar);
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.sendPbRequest$default(commonProxyRequest, null, new CommonProxyService$handle$1(aPICallTechReporter, commonProxyService$request$1), 6);
    }
}
