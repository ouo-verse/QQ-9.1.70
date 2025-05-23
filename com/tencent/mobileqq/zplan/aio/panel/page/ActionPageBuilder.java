package com.tencent.mobileqq.zplan.aio.panel.page;

import android.content.Context;
import com.tencent.mobileqq.emoticonview.BaseEmotionAdapter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.zplan.aio.panel.item.NormalItem;
import com.tencent.mobileqq.zplan.aio.panel.page.view.PageView;
import com.tencent.mobileqq.zplan.aio.panel.panel.Panel;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.api.IZPlanShowGuideApi;
import com.tencent.mobileqq.zplan.utils.SknNetworkUtilKt;
import com.tencent.mobileqq.zplan.utils.g;
import com.tencent.mobileqq.zplan.utils.o;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.state.report.SquareReportConst;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import ku4.n;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0088\u0001\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010)\u001a\u00020(\u0012<\u0010\u001c\u001a8\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0011\u0012)\b\u0002\u0010 \u001a#\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u001d\u00a2\u0006\u0004\b*\u0010+J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0012\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002*\u00020\u0005H\u0002J%\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fRJ\u0010\u001c\u001a8\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR5\u0010 \u001a#\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR \u0010'\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/page/ActionPageBuilder;", "Lcom/tencent/mobileqq/zplan/aio/panel/page/c;", "", "", "j", "", "i", "", "data", "source", "Lcom/tencent/mobileqq/zplan/aio/panel/page/Page;", "b", "(Ljava/lang/Object;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Context;", "d", "Landroid/content/Context;", "context", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/ParameterName;", "name", "scope", "Lle3/b;", DownloadInfo.spKey_Config, "Lkotlinx/coroutines/Deferred;", "", "e", "Lkotlin/jvm/functions/Function2;", "onSelect", "Lkotlin/Function1;", "f", "Lkotlin/jvm/functions/Function1;", "performClickAsync", "Ljava/lang/Class;", "Lku4/c;", "g", "Ljava/lang/Class;", "a", "()Ljava/lang/Class;", "dataClass", "Lcom/tencent/mobileqq/zplan/aio/panel/page/view/PageView$a;", "pageTheme", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Landroid/content/Context;Lcom/tencent/mobileqq/zplan/aio/panel/page/view/PageView$a;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ActionPageBuilder extends c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Function2<CoroutineScope, le3.b, Deferred<Boolean>> onSelect;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Function1<CoroutineScope, Deferred<Boolean>> performClickAsync;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Class<ku4.c> dataClass;

    public /* synthetic */ ActionPageBuilder(CoroutineScope coroutineScope, Context context, PageView.Theme theme, Function2 function2, Function1 function1, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineScope, context, theme, function2, (i3 & 16) != 0 ? new Function1<CoroutineScope, CompletableDeferred<Boolean>>() { // from class: com.tencent.mobileqq.zplan.aio.panel.page.ActionPageBuilder.1
            @Override // kotlin.jvm.functions.Function1
            public final CompletableDeferred<Boolean> invoke(CoroutineScope it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return CompletableDeferredKt.CompletableDeferred(Boolean.TRUE);
            }
        } : function1);
    }

    private final List<Integer> i(String str) {
        List split$default;
        int collectionSizeOrDefault;
        split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"_"}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : split$default) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(Integer.parseInt((String) it.next())));
        }
        return arrayList2;
    }

    private final List<Integer> j() {
        QLog.i(BaseEmotionAdapter.TAG, 1, "getHasIdListFromMMKV");
        return i(((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getString(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin() + "_key_has_id_list_mmkv", ""));
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.panel.a
    public Class<ku4.c> a() {
        return this.dataClass;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ActionPageBuilder(CoroutineScope scope, Context context, PageView.Theme pageTheme, Function2<? super CoroutineScope, ? super le3.b, ? extends Deferred<Boolean>> onSelect, Function1<? super CoroutineScope, ? extends Deferred<Boolean>> performClickAsync) {
        super(scope, pageTheme);
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageTheme, "pageTheme");
        Intrinsics.checkNotNullParameter(onSelect, "onSelect");
        Intrinsics.checkNotNullParameter(performClickAsync, "performClickAsync");
        this.context = context;
        this.onSelect = onSelect;
        this.performClickAsync = performClickAsync;
        this.dataClass = ku4.c.class;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x014b A[LOOP:1: B:34:0x0145->B:36:0x014b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    @Override // com.tencent.mobileqq.zplan.aio.panel.panel.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object b(Object obj, String str, Continuation<? super Page> continuation) {
        ActionPageBuilder$onCreatePage$1 actionPageBuilder$onCreatePage$1;
        Object coroutine_suspended;
        int i3;
        String str2;
        final ActionPageBuilder actionPageBuilder;
        byte[] readBytes;
        List listOfNotNull;
        int[] plus;
        int collectionSizeOrDefault;
        Iterator it;
        List plus2;
        boolean contains;
        Object obj2 = obj;
        if (continuation instanceof ActionPageBuilder$onCreatePage$1) {
            actionPageBuilder$onCreatePage$1 = (ActionPageBuilder$onCreatePage$1) continuation;
            int i16 = actionPageBuilder$onCreatePage$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                actionPageBuilder$onCreatePage$1.label = i16 - Integer.MIN_VALUE;
                Object obj3 = actionPageBuilder$onCreatePage$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = actionPageBuilder$onCreatePage$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj3);
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.tencent.trpcprotocol.zplan.aio_avatar.nano.AllActionConfig");
                    o h16 = SknNetworkUtilKt.h(SknNetworkUtilKt.a(com.tencent.mobileqq.zplan.utils.e.f335814a), 0L, 0, 3, null);
                    Panel.Companion companion = Panel.INSTANCE;
                    Context context = this.context;
                    String str3 = ((ku4.c) obj2).f413088a;
                    Intrinsics.checkNotNullExpressionValue(str3, "data.staticCfgUrl");
                    com.tencent.mobileqq.zplan.utils.f d16 = companion.d(context, str3);
                    actionPageBuilder$onCreatePage$1.L$0 = this;
                    actionPageBuilder$onCreatePage$1.L$1 = obj2;
                    str2 = str;
                    actionPageBuilder$onCreatePage$1.L$2 = str2;
                    actionPageBuilder$onCreatePage$1.label = 1;
                    obj3 = h16.a(d16, actionPageBuilder$onCreatePage$1);
                    if (obj3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    actionPageBuilder = this;
                } else if (i3 == 1) {
                    String str4 = (String) actionPageBuilder$onCreatePage$1.L$2;
                    Object obj4 = actionPageBuilder$onCreatePage$1.L$1;
                    actionPageBuilder = (ActionPageBuilder) actionPageBuilder$onCreatePage$1.L$0;
                    ResultKt.throwOnFailure(obj3);
                    str2 = str4;
                    obj2 = obj4;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.utils.DownloadRsp.Success");
                readBytes = FilesKt__FileReadWriteKt.readBytes(((g.c) obj3).getFile());
                ku4.a aVar = (ku4.a) SknNetworkUtilKt.c(readBytes, new ku4.a());
                if (Intrinsics.areEqual(str2, "MINI_HOME_CONNECT")) {
                    n[] nVarArr = aVar.f413068a;
                    Intrinsics.checkNotNullExpressionValue(nVarArr, "staticConfigs.cfgs");
                    ArrayList arrayList = new ArrayList();
                    for (n nVar : nVarArr) {
                        if (nVar.f413126g == 2) {
                            arrayList.add(nVar);
                        }
                    }
                    Object[] array = arrayList.toArray(new n[0]);
                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    aVar.f413068a = (n[]) array;
                }
                listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull(!Intrinsics.areEqual(actionPageBuilder.getPageTheme(), PageView.Theme.INSTANCE.a()) ? ActionPage.INSTANCE.a(actionPageBuilder.context, actionPageBuilder.performClickAsync) : null);
                ku4.c cVar = (ku4.c) obj2;
                int[] iArr = cVar.f413092e;
                Intrinsics.checkNotNullExpressionValue(iArr, "data.havingResourceIds");
                plus = ArraysKt___ArraysJvmKt.plus(iArr, (Collection<Integer>) actionPageBuilder.j());
                List list = listOfNotNull;
                Panel.Companion companion2 = Panel.INSTANCE;
                n[] nVarArr2 = aVar.f413068a;
                Intrinsics.checkNotNullExpressionValue(nVarArr2, "staticConfigs.cfgs");
                ku4.a aVar2 = cVar.f413089b;
                n[] nVarArr3 = aVar2 != null ? aVar2.f413068a : null;
                n[] nVarArr4 = nVarArr3 != null ? new n[0] : nVarArr3;
                int i17 = cVar.f413090c;
                int[] iArr2 = cVar.f413091d;
                Intrinsics.checkNotNullExpressionValue(iArr2, "data.sortIds");
                List o16 = companion2.o(nVarArr2, nVarArr4, i17, iArr2, new Function1<n, Integer>() { // from class: com.tencent.mobileqq.zplan.aio.panel.page.ActionPageBuilder$onCreatePage$3
                    @Override // kotlin.jvm.functions.Function1
                    public final Integer invoke(n nVar2) {
                        return Integer.valueOf(nVar2.f413120a);
                    }
                });
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(o16, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                for (it = o16.iterator(); it.hasNext(); it = it) {
                    n it5 = (n) it.next();
                    final String str5 = it5.f413121b;
                    final int i18 = it5.f413120a;
                    CoroutineScope scope = actionPageBuilder.getScope();
                    String str6 = it5.f413121b;
                    Intrinsics.checkNotNullExpressionValue(str6, "it.name");
                    Intrinsics.checkNotNullExpressionValue(it5, "it");
                    Context context2 = actionPageBuilder.context;
                    String str7 = it5.f413122c;
                    Intrinsics.checkNotNullExpressionValue(str7, "it.mainIconUrl");
                    String str8 = it5.f413123d;
                    Intrinsics.checkNotNullExpressionValue(str8, "it.cornerIconUrl");
                    contains = ArraysKt___ArraysKt.contains(plus, it5.f413120a);
                    NormalItem normalItem = new NormalItem(scope, str6, it5, context2, str7, str8, contains, it5.f413133n, it5.f413132m, it5.f413120a);
                    normalItem.z(new Function2<CoroutineScope, le3.b, Deferred<? extends Boolean>>() { // from class: com.tencent.mobileqq.zplan.aio.panel.page.ActionPageBuilder$onCreatePage$4$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Deferred<Boolean> invoke(CoroutineScope scope2, le3.b config) {
                            Map mapOf;
                            Function2 function2;
                            Map mapOf2;
                            Intrinsics.checkNotNullParameter(scope2, "scope");
                            Intrinsics.checkNotNullParameter(config, "config");
                            String onGetCurrentPeekUin = ((IZPlanShowGuideApi) QRoute.api(IZPlanShowGuideApi.class)).onGetCurrentPeekUin();
                            if (onGetCurrentPeekUin == null) {
                                onGetCurrentPeekUin = "";
                            }
                            long parseLong = onGetCurrentPeekUin.length() > 0 ? Long.parseLong(onGetCurrentPeekUin) : 0L;
                            if (Intrinsics.areEqual(ActionPageBuilder.this.getPageTheme().getReportSceneType(), PageView.Theme.INSTANCE.b().getReportSceneType())) {
                                mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY), TuplesKt.to("zplan_action_type", "click"), TuplesKt.to(SquareReportConst.Key.KEY_ACTION_ID, Integer.valueOf(i18)));
                                VideoReport.reportEvent("ev_zplan_action_item", mapOf2);
                            } else {
                                Pair[] pairArr = new Pair[8];
                                pairArr[0] = TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
                                pairArr[1] = TuplesKt.to("zplan_action_type", "click");
                                pairArr[2] = TuplesKt.to("zplan_is_dress_up_user", f.a());
                                pairArr[3] = TuplesKt.to("zplan_emote_scene_type", ActionPageBuilder.this.getPageTheme().getReportSceneType());
                                pairArr[4] = TuplesKt.to("zplan_emote_name", str5);
                                pairArr[5] = TuplesKt.to("zplan_emote_id", Integer.valueOf(i18));
                                pairArr[6] = TuplesKt.to("zplan_to_uin", Long.valueOf(parseLong));
                                pairArr[7] = TuplesKt.to("zplan_click_type", (!config.a() || config.e()) ? PreDownloadConstants.DEPARTMENT_SED : "Preview");
                                mapOf = MapsKt__MapsKt.mapOf(pairArr);
                                VideoReport.reportEvent("ev_zplan_action_click", mapOf);
                            }
                            function2 = ActionPageBuilder.this.onSelect;
                            return (Deferred) function2.invoke(scope2, config);
                        }
                    });
                    normalItem.y(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aio.panel.page.ActionPageBuilder$onCreatePage$4$1$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            Map mapOf;
                            Map mapOf2;
                            if (Intrinsics.areEqual(ActionPageBuilder.this.getPageTheme().getReportSceneType(), PageView.Theme.INSTANCE.b().getReportSceneType())) {
                                mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY), TuplesKt.to("zplan_action_type", "imp"), TuplesKt.to(SquareReportConst.Key.KEY_ACTION_ID, Integer.valueOf(i18)));
                                VideoReport.reportEvent("ev_zplan_action_item", mapOf2);
                            } else {
                                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY), TuplesKt.to("zplan_action_type", "imp"), TuplesKt.to("zplan_is_dress_up_user", f.a()), TuplesKt.to("zplan_emote_scene_type", ActionPageBuilder.this.getPageTheme().getReportSceneType()), TuplesKt.to("zplan_emote_name", str5), TuplesKt.to("zplan_emote_id", Integer.valueOf(i18)));
                                VideoReport.reportEvent("ev_zplan_action_click", mapOf);
                            }
                        }
                    });
                    arrayList2.add(normalItem);
                }
                plus2 = CollectionsKt___CollectionsKt.plus((Collection) list, (Iterable) arrayList2);
                return new ActionPage(plus2);
            }
        }
        actionPageBuilder$onCreatePage$1 = new ActionPageBuilder$onCreatePage$1(this, continuation);
        Object obj32 = actionPageBuilder$onCreatePage$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = actionPageBuilder$onCreatePage$1.label;
        if (i3 != 0) {
        }
        Intrinsics.checkNotNull(obj32, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.utils.DownloadRsp.Success");
        readBytes = FilesKt__FileReadWriteKt.readBytes(((g.c) obj32).getFile());
        ku4.a aVar3 = (ku4.a) SknNetworkUtilKt.c(readBytes, new ku4.a());
        if (Intrinsics.areEqual(str2, "MINI_HOME_CONNECT")) {
        }
        listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull(!Intrinsics.areEqual(actionPageBuilder.getPageTheme(), PageView.Theme.INSTANCE.a()) ? ActionPage.INSTANCE.a(actionPageBuilder.context, actionPageBuilder.performClickAsync) : null);
        ku4.c cVar2 = (ku4.c) obj2;
        int[] iArr3 = cVar2.f413092e;
        Intrinsics.checkNotNullExpressionValue(iArr3, "data.havingResourceIds");
        plus = ArraysKt___ArraysJvmKt.plus(iArr3, (Collection<Integer>) actionPageBuilder.j());
        List list2 = listOfNotNull;
        Panel.Companion companion22 = Panel.INSTANCE;
        n[] nVarArr22 = aVar3.f413068a;
        Intrinsics.checkNotNullExpressionValue(nVarArr22, "staticConfigs.cfgs");
        ku4.a aVar22 = cVar2.f413089b;
        if (aVar22 != null) {
        }
        if (nVarArr3 != null) {
        }
        int i172 = cVar2.f413090c;
        int[] iArr22 = cVar2.f413091d;
        Intrinsics.checkNotNullExpressionValue(iArr22, "data.sortIds");
        List o162 = companion22.o(nVarArr22, nVarArr4, i172, iArr22, new Function1<n, Integer>() { // from class: com.tencent.mobileqq.zplan.aio.panel.page.ActionPageBuilder$onCreatePage$3
            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(n nVar2) {
                return Integer.valueOf(nVar2.f413120a);
            }
        });
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(o162, 10);
        ArrayList arrayList22 = new ArrayList(collectionSizeOrDefault);
        while (it.hasNext()) {
        }
        plus2 = CollectionsKt___CollectionsKt.plus((Collection) list2, (Iterable) arrayList22);
        return new ActionPage(plus2);
    }
}
