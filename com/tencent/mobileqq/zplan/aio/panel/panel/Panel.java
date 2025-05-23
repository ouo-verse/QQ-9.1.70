package com.tencent.mobileqq.zplan.aio.panel.panel;

import android.content.Context;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zplan.aio.panel.item.d;
import com.tencent.mobileqq.zplan.aio.panel.page.ActionPage;
import com.tencent.mobileqq.zplan.aio.panel.page.Page;
import com.tencent.mobileqq.zplan.aio.panel.page.ScenePage;
import com.tencent.mobileqq.zplan.aio.panel.page.view.PageView;
import com.tencent.mobileqq.zplan.aio.panel.panel.a;
import com.tencent.mobileqq.zplan.utils.SknNetworkUtilKt;
import com.tencent.mobileqq.zplan.utils.ZPlanRequestReq;
import com.tencent.mobileqq.zplan.utils.at;
import com.tencent.mobileqq.zplan.utils.av;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.mobileqq.zplan.utils.f;
import com.tencent.mobileqq.zplan.utils.n;
import com.tencent.mobileqq.zplan.utils.o;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.state.report.SquareReportConst;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
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
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import ku4.k;
import ku4.l;
import lx4.b;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u001d\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fB%\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0012\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0010\"\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u0012R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/panel/Panel;", "", "Lcom/tencent/mobileqq/zplan/aio/panel/panel/DataSource;", "a", "Lcom/tencent/mobileqq/zplan/aio/panel/panel/DataSource;", "()Lcom/tencent/mobileqq/zplan/aio/panel/panel/DataSource;", "dataSource", "", "Lcom/tencent/mobileqq/zplan/aio/panel/page/Page;", "b", "Ljava/util/List;", "()Ljava/util/List;", "pages", "unsortedPages", "<init>", "(Lcom/tencent/mobileqq/zplan/aio/panel/panel/DataSource;Ljava/util/List;)V", "", "args", "(Lcom/tencent/mobileqq/zplan/aio/panel/panel/DataSource;[Lcom/tencent/mobileqq/zplan/aio/panel/page/Page;)V", "c", "Companion", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class Panel {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final DataSource dataSource;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final List<Page> pages;

    @Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b1\u00102J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J=\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\tH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ+\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010JP\u0010\u001a\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\f0\u00112\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00152\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0017H\u0002J$\u0010\u001b\u001a\u00020\u0019*\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00152\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0017H\u0002J\u0016\u0010 \u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0015J^\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010!2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\"2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\"2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010'\u001a\u00020&2\u0017\u0010*\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020(\u00a2\u0006\u0002\b)\u00a2\u0006\u0004\b+\u0010,J\"\u0010.\u001a\b\u0012\u0004\u0012\u00020\f0-2\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006JD\u0010/\u001a\b\u0012\u0004\u0012\u00020\f0-2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001c2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0014\u001a\u00020\t2\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0017J\u0016\u00100\u001a\u0004\u0018\u00010\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/panel/Panel$Companion;", "", "", "entryType", "Lku4/k;", "f", "", "Lcom/tencent/mobileqq/zplan/aio/panel/panel/a;", "builders", "", "readCache", "writeCache", "Lcom/tencent/mobileqq/zplan/aio/panel/panel/Panel;", "l", "(ILjava/util/List;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", DomainData.DOMAIN_NAME, "(ILjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "forceRefresh", "", "reportSceneType", "Lkotlin/Function0;", "getReportSubtabOpenSource", "", "e", "k", "Landroid/content/Context;", "context", "url", "Lcom/tencent/mobileqq/zplan/utils/f;", "d", "T", "", "staticItems", "dynamicItems", "joinRule", "", "sortIds", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "getId", "o", "([Ljava/lang/Object;[Ljava/lang/Object;I[ILkotlin/jvm/functions/Function1;)Ljava/util/List;", "Lkotlinx/coroutines/flow/StateFlow;", "j", "g", "i", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class Companion {

        @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u0004J\u001b\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0096B\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/aio/panel/panel/Panel$Companion$a", "Lcom/tencent/mobileqq/zplan/utils/o;", "Lcom/tencent/mobileqq/zplan/utils/au;", "Lcom/tencent/mobileqq/zplan/utils/av;", "Lcom/tencent/mobileqq/zplan/utils/IZPlanRequest;", "req", "Lcom/tencent/mobileqq/zplan/utils/av$b;", "b", "(Lcom/tencent/mobileqq/zplan/utils/au;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes35.dex */
        public static final class a implements o<ZPlanRequestReq, av> {
            a() {
            }

            @Override // com.tencent.mobileqq.zplan.utils.o
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Object a(ZPlanRequestReq zPlanRequestReq, Continuation<? super av.b> continuation) {
                return new av.b(null);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void e(MutableStateFlow<Panel> mutableStateFlow, CoroutineScope coroutineScope, int i3, List<? extends com.tencent.mobileqq.zplan.aio.panel.panel.a> list, boolean z16, String str, Function0<String> function0) {
            CorountineFunKt.e(coroutineScope, "zplan_AioAvatarPanel_\u597d\u53cb\u65f6\u5149_\u62c9\u53d6\u9762\u677f", null, null, null, new Panel$Companion$configSource$1(i3, list, mutableStateFlow, z16, str, function0, null), 14, null);
        }

        private final k f(int entryType) {
            k kVar = new k();
            kVar.f413112a = entryType;
            kVar.f413113b = AppSetting.f99551k + "." + AppSetting.f99542b;
            return kVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void k(Panel panel, final String str, final Function0<String> function0) {
            for (final Page page : panel.b()) {
                page.q(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aio.panel.panel.Panel$Companion$initReport$1
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
                        String str2;
                        Map mapOf;
                        Pair[] pairArr = new Pair[4];
                        pairArr[0] = TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
                        pairArr[1] = TuplesKt.to("zplan_subtab_name", Page.this.h());
                        pairArr[2] = TuplesKt.to("zplan_subtab_page_source", str);
                        Function0<String> function02 = function0;
                        if (function02 == null || (str2 = function02.invoke()) == null) {
                            str2 = "";
                        }
                        pairArr[3] = TuplesKt.to("zplan_subtab_open_source", str2);
                        mapOf = MapsKt__MapsKt.mapOf(pairArr);
                        VideoReport.reportEvent("ev_zplan_emote_subtab_click", mapOf);
                    }
                });
                page.r(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aio.panel.panel.Panel$Companion$initReport$2
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
                        String str2;
                        Map mapOf;
                        Pair[] pairArr = new Pair[5];
                        pairArr[0] = TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
                        pairArr[1] = TuplesKt.to("zplan_is_selected_when_imp", b.INSTANCE.a(Page.this.getIsTabSelected()));
                        pairArr[2] = TuplesKt.to("zplan_subtab_name", Page.this.h());
                        pairArr[3] = TuplesKt.to("zplan_subtab_page_source", str);
                        Function0<String> function02 = function0;
                        if (function02 == null || (str2 = function02.invoke()) == null) {
                            str2 = "";
                        }
                        pairArr[4] = TuplesKt.to("zplan_subtab_open_source", str2);
                        mapOf = MapsKt__MapsKt.mapOf(pairArr);
                        VideoReport.reportEvent("ev_zplan_emote_subtab_imp", mapOf);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:13:0x015c  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0107  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0161  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00d8  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00db  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0055  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0152 -> B:11:0x0155). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0158 -> B:12:0x015a). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object l(int i3, List<? extends com.tencent.mobileqq.zplan.aio.panel.panel.a> list, boolean z16, boolean z17, Continuation<? super Panel> continuation) {
            Panel$Companion$requestPanel$1 panel$Companion$requestPanel$1;
            Object coroutine_suspended;
            int i16;
            List<? extends com.tencent.mobileqq.zplan.aio.panel.panel.a> list2;
            List listOf;
            DataSource dataSource;
            List<? extends com.tencent.mobileqq.zplan.aio.panel.panel.a> list3;
            Iterator it;
            Collection collection;
            Object obj;
            if (continuation instanceof Panel$Companion$requestPanel$1) {
                panel$Companion$requestPanel$1 = (Panel$Companion$requestPanel$1) continuation;
                int i17 = panel$Companion$requestPanel$1.label;
                if ((i17 & Integer.MIN_VALUE) != 0) {
                    panel$Companion$requestPanel$1.label = i17 - Integer.MIN_VALUE;
                    Object obj2 = panel$Companion$requestPanel$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i16 = panel$Companion$requestPanel$1.label;
                    if (i16 != 0) {
                        ResultKt.throwOnFailure(obj2);
                        AppInterface c16 = bb.f335811a.c();
                        String currentUin = c16 != null ? c16.getCurrentUin() : null;
                        if (currentUin == null) {
                            currentUin = "";
                        }
                        n nVar = new n("AioAvatarPanel_" + currentUin);
                        o<ZPlanRequestReq, av> h16 = SknNetworkUtilKt.h(at.f335791a, 0L, 0, 3, null);
                        if (z16) {
                            h16 = SknNetworkUtilKt.f(h16, nVar, 0L, 2, null);
                        }
                        if (z17) {
                            h16 = SknNetworkUtilKt.j(h16, nVar);
                        }
                        ZPlanRequestReq zPlanRequestReq = new ZPlanRequestReq("trpc.zplan.aio_avatar.Mobile.SsoGetAllConfig", SknNetworkUtilKt.i(f(i3)));
                        list2 = list;
                        panel$Companion$requestPanel$1.L$0 = list2;
                        panel$Companion$requestPanel$1.label = 1;
                        obj2 = h16.a(zPlanRequestReq, panel$Companion$requestPanel$1);
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i16 == 1) {
                        list2 = (List) panel$Companion$requestPanel$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    } else {
                        if (i16 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        it = (Iterator) panel$Companion$requestPanel$1.L$3;
                        collection = (Collection) panel$Companion$requestPanel$1.L$2;
                        dataSource = (DataSource) panel$Companion$requestPanel$1.L$1;
                        List<? extends com.tencent.mobileqq.zplan.aio.panel.panel.a> list4 = (List) panel$Companion$requestPanel$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        Page page = (Page) obj2;
                        if (page != null) {
                            collection.add(page);
                        }
                        list3 = list4;
                        if (it.hasNext()) {
                            ExtendableMessageNano data = (ExtendableMessageNano) it.next();
                            Iterator<T> it5 = list3.iterator();
                            while (true) {
                                if (!it5.hasNext()) {
                                    obj = null;
                                    break;
                                }
                                obj = it5.next();
                                if (Intrinsics.areEqual(data.getClass(), ((com.tencent.mobileqq.zplan.aio.panel.panel.a) obj).a())) {
                                    break;
                                }
                            }
                            com.tencent.mobileqq.zplan.aio.panel.panel.a aVar = (com.tencent.mobileqq.zplan.aio.panel.panel.a) obj;
                            if (aVar != null) {
                                Intrinsics.checkNotNullExpressionValue(data, "data");
                                panel$Companion$requestPanel$1.L$0 = list3;
                                panel$Companion$requestPanel$1.L$1 = dataSource;
                                panel$Companion$requestPanel$1.L$2 = collection;
                                panel$Companion$requestPanel$1.L$3 = it;
                                panel$Companion$requestPanel$1.label = 2;
                                Object a16 = a.C9148a.a(aVar, data, null, panel$Companion$requestPanel$1, 2, null);
                                if (a16 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                list4 = list3;
                                obj2 = a16;
                                Page page2 = (Page) obj2;
                                if (page2 != null) {
                                }
                                list3 = list4;
                                if (it.hasNext()) {
                                    return new Panel(dataSource, (List<? extends Page>) collection);
                                }
                            } else {
                                list4 = list3;
                                page2 = null;
                                if (page2 != null) {
                                }
                                list3 = list4;
                                if (it.hasNext()) {
                                }
                            }
                        }
                    }
                    av avVar = (av) obj2;
                    Object data2 = avVar.getData();
                    Intrinsics.checkNotNull(data2, "null cannot be cast to non-null type kotlin.ByteArray");
                    l lVar = (l) SknNetworkUtilKt.c((byte[]) data2, new l());
                    DataSource dataSource2 = !(avVar instanceof av.a) ? DataSource.Cache : DataSource.Backend;
                    listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ExtendableMessageNano[]{lVar.f413116c, lVar.f413115b, lVar.f413114a});
                    ArrayList arrayList = new ArrayList();
                    dataSource = dataSource2;
                    list3 = list2;
                    it = listOf.iterator();
                    collection = arrayList;
                    if (it.hasNext()) {
                    }
                }
            }
            panel$Companion$requestPanel$1 = new Panel$Companion$requestPanel$1(this, continuation);
            Object obj22 = panel$Companion$requestPanel$1.result;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i16 = panel$Companion$requestPanel$1.label;
            if (i16 != 0) {
            }
            av avVar2 = (av) obj22;
            Object data22 = avVar2.getData();
            Intrinsics.checkNotNull(data22, "null cannot be cast to non-null type kotlin.ByteArray");
            l lVar2 = (l) SknNetworkUtilKt.c((byte[]) data22, new l());
            if (!(avVar2 instanceof av.a)) {
            }
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ExtendableMessageNano[]{lVar2.f413116c, lVar2.f413115b, lVar2.f413114a});
            ArrayList arrayList2 = new ArrayList();
            dataSource = dataSource2;
            list3 = list2;
            it = listOf.iterator();
            collection = arrayList2;
            if (it.hasNext()) {
            }
        }

        public final f d(Context context, String url) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(url, "url");
            File cacheDir = context.getCacheDir();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%08X", Arrays.copyOf(new Object[]{Integer.valueOf(url.hashCode())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return new f(url, cacheDir + "/zplan/aio_avatar/" + format, null, false, null, 28, null);
        }

        public final Panel i(List<? extends com.tencent.mobileqq.zplan.aio.panel.panel.a> builders) {
            Object runBlocking$default;
            Intrinsics.checkNotNullParameter(builders, "builders");
            runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new Panel$Companion$generateAioSourceFromCache$1(builders, null), 1, null);
            return (Panel) runBlocking$default;
        }

        public final StateFlow<Panel> j(CoroutineScope scope, List<? extends com.tencent.mobileqq.zplan.aio.panel.panel.a> builders) {
            Intrinsics.checkNotNullParameter(scope, "scope");
            Intrinsics.checkNotNullParameter(builders, "builders");
            DataSource dataSource = DataSource.PlaceHolder;
            Page[] pageArr = new Page[2];
            ArrayList arrayList = new ArrayList(8);
            for (int i3 = 0; i3 < 8; i3++) {
                arrayList.add(d.f331180d);
            }
            pageArr[0] = new ActionPage(arrayList);
            ArrayList arrayList2 = new ArrayList(8);
            for (int i16 = 0; i16 < 8; i16++) {
                arrayList2.add(d.f331180d);
            }
            pageArr[1] = new ScenePage(arrayList2, null, null, 6, null);
            MutableStateFlow<Panel> MutableStateFlow = StateFlowKt.MutableStateFlow(new Panel(dataSource, pageArr));
            Panel.INSTANCE.e(MutableStateFlow, scope, 2, builders, true, PageView.Theme.INSTANCE.c().getReportSceneType(), new Function0<String>() { // from class: com.tencent.mobileqq.zplan.aio.panel.panel.Panel$Companion$generateSpaceSource$3$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "3";
                }
            });
            return MutableStateFlow;
        }

        public final <T> List<T> o(T[] staticItems, T[] dynamicItems, int joinRule, int[] sortIds, Function1<? super T, Integer> getId) {
            List listOf;
            ArrayList arrayList;
            Iterable asIterable;
            List listOf2;
            Iterable asIterable2;
            List listOf3;
            List<T> filterNotNull;
            T t16;
            Iterable asIterable3;
            List<T> emptyList;
            Intrinsics.checkNotNullParameter(staticItems, "staticItems");
            Intrinsics.checkNotNullParameter(dynamicItems, "dynamicItems");
            Intrinsics.checkNotNullParameter(sortIds, "sortIds");
            Intrinsics.checkNotNullParameter(getId, "getId");
            if (joinRule == 1) {
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Object[][]{staticItems, dynamicItems});
                arrayList = new ArrayList();
                Iterator<T> it = listOf.iterator();
                while (it.hasNext()) {
                    asIterable = ArraysKt___ArraysKt.asIterable((Object[]) it.next());
                    CollectionsKt__MutableCollectionsKt.addAll(arrayList, asIterable);
                }
            } else {
                if (joinRule != 2) {
                    if (joinRule != 3) {
                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                        return emptyList;
                    }
                    listOf3 = CollectionsKt__CollectionsKt.listOf((Object[]) new Object[][]{dynamicItems, staticItems});
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<T> it5 = listOf3.iterator();
                    while (it5.hasNext()) {
                        asIterable3 = ArraysKt___ArraysKt.asIterable((Object[]) it5.next());
                        CollectionsKt__MutableCollectionsKt.addAll(arrayList2, asIterable3);
                    }
                    ArrayList arrayList3 = new ArrayList(sortIds.length);
                    int length = sortIds.length;
                    for (int i3 = 0; i3 < length; i3++) {
                        int i16 = sortIds[i3];
                        Iterator<T> it6 = arrayList2.iterator();
                        while (true) {
                            if (!it6.hasNext()) {
                                t16 = (T) null;
                                break;
                            }
                            t16 = it6.next();
                            if (getId.invoke(t16).intValue() == i16) {
                                break;
                            }
                        }
                        arrayList3.add(t16);
                    }
                    filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(arrayList3);
                    return filterNotNull;
                }
                listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Object[][]{dynamicItems, staticItems});
                arrayList = new ArrayList();
                Iterator<T> it7 = listOf2.iterator();
                while (it7.hasNext()) {
                    asIterable2 = ArraysKt___ArraysKt.asIterable((Object[]) it7.next());
                    CollectionsKt__MutableCollectionsKt.addAll(arrayList, asIterable2);
                }
            }
            return arrayList;
        }

        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0153  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x00fe  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0158  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00b3  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00bd  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0055  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0149 -> B:11:0x014c). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x014f -> B:12:0x0151). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object n(int i3, List<? extends com.tencent.mobileqq.zplan.aio.panel.panel.a> list, Continuation<? super Panel> continuation) {
            Panel$Companion$requestPanelCache$1 panel$Companion$requestPanelCache$1;
            Object coroutine_suspended;
            int i16;
            List<? extends com.tencent.mobileqq.zplan.aio.panel.panel.a> list2;
            av avVar;
            DataSource dataSource;
            List listOf;
            Collection arrayList;
            Iterator it;
            List<? extends com.tencent.mobileqq.zplan.aio.panel.panel.a> list3;
            Object obj;
            if (continuation instanceof Panel$Companion$requestPanelCache$1) {
                panel$Companion$requestPanelCache$1 = (Panel$Companion$requestPanelCache$1) continuation;
                int i17 = panel$Companion$requestPanelCache$1.label;
                if ((i17 & Integer.MIN_VALUE) != 0) {
                    panel$Companion$requestPanelCache$1.label = i17 - Integer.MIN_VALUE;
                    Object obj2 = panel$Companion$requestPanelCache$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i16 = panel$Companion$requestPanelCache$1.label;
                    if (i16 != 0) {
                        ResultKt.throwOnFailure(obj2);
                        AppInterface c16 = bb.f335811a.c();
                        String currentUin = c16 != null ? c16.getCurrentUin() : null;
                        if (currentUin == null) {
                            currentUin = "";
                        }
                        o f16 = SknNetworkUtilKt.f(new a(), new n("AioAvatarPanel_" + currentUin), 0L, 2, null);
                        ZPlanRequestReq zPlanRequestReq = new ZPlanRequestReq("trpc.zplan.aio_avatar.Mobile.SsoGetAllConfig", SknNetworkUtilKt.i(f(i3)));
                        panel$Companion$requestPanelCache$1.L$0 = list;
                        panel$Companion$requestPanelCache$1.label = 1;
                        obj2 = f16.a(zPlanRequestReq, panel$Companion$requestPanelCache$1);
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        list2 = list;
                    } else if (i16 == 1) {
                        list2 = (List) panel$Companion$requestPanelCache$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    } else if (i16 == 2) {
                        it = (Iterator) panel$Companion$requestPanelCache$1.L$3;
                        arrayList = (Collection) panel$Companion$requestPanelCache$1.L$2;
                        dataSource = (DataSource) panel$Companion$requestPanelCache$1.L$1;
                        List<? extends com.tencent.mobileqq.zplan.aio.panel.panel.a> list4 = (List) panel$Companion$requestPanelCache$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        Page page = (Page) obj2;
                        if (page != null) {
                            arrayList.add(page);
                        }
                        list3 = list4;
                        if (!it.hasNext()) {
                            ExtendableMessageNano data = (ExtendableMessageNano) it.next();
                            Iterator<T> it5 = list3.iterator();
                            while (true) {
                                if (!it5.hasNext()) {
                                    obj = null;
                                    break;
                                }
                                obj = it5.next();
                                if (Intrinsics.areEqual(data.getClass(), ((com.tencent.mobileqq.zplan.aio.panel.panel.a) obj).a())) {
                                    break;
                                }
                            }
                            com.tencent.mobileqq.zplan.aio.panel.panel.a aVar = (com.tencent.mobileqq.zplan.aio.panel.panel.a) obj;
                            if (aVar == null) {
                                list4 = list3;
                                page = null;
                                if (page != null) {
                                }
                                list3 = list4;
                                if (!it.hasNext()) {
                                }
                            } else {
                                Intrinsics.checkNotNullExpressionValue(data, "data");
                                panel$Companion$requestPanelCache$1.L$0 = list3;
                                panel$Companion$requestPanelCache$1.L$1 = dataSource;
                                panel$Companion$requestPanelCache$1.L$2 = arrayList;
                                panel$Companion$requestPanelCache$1.L$3 = it;
                                panel$Companion$requestPanelCache$1.label = 2;
                                Object a16 = a.C9148a.a(aVar, data, null, panel$Companion$requestPanelCache$1, 2, null);
                                if (a16 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                list4 = list3;
                                obj2 = a16;
                                Page page2 = (Page) obj2;
                                if (page2 != null) {
                                }
                                list3 = list4;
                                if (!it.hasNext()) {
                                    return new Panel(dataSource, (List<? extends Page>) arrayList);
                                }
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    avVar = (av) obj2;
                    if (!(avVar instanceof av.b)) {
                        QLog.w("AioAvatarPanel", 1, "requestPanelCache failed");
                        return null;
                    }
                    Object data2 = avVar.getData();
                    Intrinsics.checkNotNull(data2, "null cannot be cast to non-null type kotlin.ByteArray");
                    l lVar = (l) SknNetworkUtilKt.c((byte[]) data2, new l());
                    dataSource = DataSource.Cache;
                    listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ExtendableMessageNano[]{lVar.f413116c, lVar.f413115b, lVar.f413114a});
                    arrayList = new ArrayList();
                    List<? extends com.tencent.mobileqq.zplan.aio.panel.panel.a> list5 = list2;
                    it = listOf.iterator();
                    list3 = list5;
                    if (!it.hasNext()) {
                    }
                }
            }
            panel$Companion$requestPanelCache$1 = new Panel$Companion$requestPanelCache$1(this, continuation);
            Object obj22 = panel$Companion$requestPanelCache$1.result;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i16 = panel$Companion$requestPanelCache$1.label;
            if (i16 != 0) {
            }
            avVar = (av) obj22;
            if (!(avVar instanceof av.b)) {
            }
        }

        public final StateFlow<Panel> g(CoroutineScope scope, Context context, List<? extends com.tencent.mobileqq.zplan.aio.panel.panel.a> builders, boolean forceRefresh, Function0<String> getReportSubtabOpenSource) {
            List emptyList;
            List listOf;
            List plus;
            Intrinsics.checkNotNullParameter(scope, "scope");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(builders, "builders");
            DataSource dataSource = DataSource.PlaceHolder;
            Page[] pageArr = new Page[3];
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            com.tencent.mobileqq.zplan.aio.panel.page.a aVar = new com.tencent.mobileqq.zplan.aio.panel.page.a(emptyList, null, 2, 0 == true ? 1 : 0);
            pageArr[0] = aVar;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(ActionPage.INSTANCE.a(context, new Function1<CoroutineScope, Deferred<? extends Boolean>>() { // from class: com.tencent.mobileqq.zplan.aio.panel.panel.Panel$Companion$generateAioSource$1
                @Override // kotlin.jvm.functions.Function1
                public final Deferred<Boolean> invoke(CoroutineScope it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return CompletableDeferredKt.CompletableDeferred(Boolean.TRUE);
                }
            }));
            List list = listOf;
            ArrayList arrayList = new ArrayList(9);
            for (int i3 = 0; i3 < 9; i3++) {
                arrayList.add(d.f331180d);
            }
            plus = CollectionsKt___CollectionsKt.plus((Collection) list, (Iterable) arrayList);
            pageArr[1] = new ActionPage(plus);
            ArrayList arrayList2 = new ArrayList(10);
            for (int i16 = 0; i16 < 10; i16++) {
                arrayList2.add(d.f331180d);
            }
            pageArr[2] = new ScenePage(arrayList2, null, null, 6, null);
            MutableStateFlow<Panel> MutableStateFlow = StateFlowKt.MutableStateFlow(new Panel(dataSource, pageArr));
            Panel.INSTANCE.e(MutableStateFlow, scope, 1, builders, forceRefresh, PageView.Theme.INSTANCE.a().getReportSceneType(), getReportSubtabOpenSource);
            return MutableStateFlow;
        }

        public static /* synthetic */ StateFlow h(Companion companion, CoroutineScope coroutineScope, Context context, List list, boolean z16, Function0 function0, int i3, Object obj) {
            if ((i3 & 16) != 0) {
                function0 = null;
            }
            return companion.g(coroutineScope, context, list, z16, function0);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((Page) t16).getSortKey()), Integer.valueOf(((Page) t17).getSortKey()));
            return compareValues;
        }
    }

    public Panel(DataSource dataSource, List<? extends Page> unsortedPages) {
        List<Page> sortedWith;
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        Intrinsics.checkNotNullParameter(unsortedPages, "unsortedPages");
        this.dataSource = dataSource;
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(unsortedPages, new a());
        this.pages = sortedWith;
    }

    /* renamed from: a, reason: from getter */
    public final DataSource getDataSource() {
        return this.dataSource;
    }

    public final List<Page> b() {
        return this.pages;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Panel(DataSource dataSource, Page... args) {
        this(dataSource, (List<? extends Page>) r3);
        List asList;
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        Intrinsics.checkNotNullParameter(args, "args");
        asList = ArraysKt___ArraysJvmKt.asList(args);
    }
}
