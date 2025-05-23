package com.tencent.mobileqq.zplan.aio.panel.page;

import android.content.Context;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.zplan.aio.panel.item.NormalItem;
import com.tencent.mobileqq.zplan.aio.panel.page.view.PageView;
import com.tencent.mobileqq.zplan.aio.panel.panel.Panel;
import com.tencent.mobileqq.zplan.utils.SknNetworkUtilKt;
import com.tencent.mobileqq.zplan.utils.g;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.state.report.SquareReportConst;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import ku4.n;
import ku4.o;
import mqq.util.WeakReference;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0088\u0001\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010*\u001a\u00020)\u0012\u001e\u0010\u0012\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00020\r\u0012<\u0010\u001e\u001a8\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u0013\u0012\u0006\u0010!\u001a\u00020\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\b+\u0010,J%\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR/\u0010\u0012\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00020\r8\u0002X\u0082\u0004\u00f8\u0001\u0000\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011RJ\u0010\u001e\u001a8\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010!\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R \u0010(\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/page/ScenePageBuilder;", "Lcom/tencent/mobileqq/zplan/aio/panel/page/c;", "", "data", "", "source", "Lcom/tencent/mobileqq/zplan/aio/panel/page/Page;", "b", "(Ljava/lang/Object;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Context;", "d", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "e", "Lkotlin/jvm/functions/Function1;", "getSelectingSceneId", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/ParameterName;", "name", "scope", "Lle3/b;", DownloadInfo.spKey_Config, "Lkotlinx/coroutines/Deferred;", "", "f", "Lkotlin/jvm/functions/Function2;", "onSelect", "g", "Ljava/lang/String;", "friendUin", "Ljava/lang/Class;", "Lku4/e;", tl.h.F, "Ljava/lang/Class;", "a", "()Ljava/lang/Class;", "dataClass", "Lcom/tencent/mobileqq/zplan/aio/panel/page/view/PageView$a;", "pageTheme", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Landroid/content/Context;Lcom/tencent/mobileqq/zplan/aio/panel/page/view/PageView$a;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ScenePageBuilder extends c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Function1<Continuation<? super Integer>, Object> getSelectingSceneId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Function2<CoroutineScope, le3.b, Deferred<Boolean>> onSelect;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final String friendUin;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Class<ku4.e> dataClass;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ScenePageBuilder(CoroutineScope scope, Context context, PageView.Theme pageTheme, Function1<? super Continuation<? super Integer>, ? extends Object> getSelectingSceneId, Function2<? super CoroutineScope, ? super le3.b, ? extends Deferred<Boolean>> onSelect, String friendUin) {
        super(scope, pageTheme);
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageTheme, "pageTheme");
        Intrinsics.checkNotNullParameter(getSelectingSceneId, "getSelectingSceneId");
        Intrinsics.checkNotNullParameter(onSelect, "onSelect");
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        this.context = context;
        this.getSelectingSceneId = getSelectingSceneId;
        this.onSelect = onSelect;
        this.friendUin = friendUin;
        this.dataClass = ku4.e.class;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.panel.a
    public Class<ku4.e> a() {
        return this.dataClass;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0196 A[LOOP:2: B:45:0x0190->B:47:0x0196, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    @Override // com.tencent.mobileqq.zplan.aio.panel.panel.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object b(Object obj, String str, Continuation<? super Page> continuation) {
        ScenePageBuilder$onCreatePage$1 scenePageBuilder$onCreatePage$1;
        Object coroutine_suspended;
        int i3;
        ScenePageBuilder scenePageBuilder;
        byte[] readBytes;
        Object invoke;
        Object obj2;
        o oVar;
        final ScenePageBuilder scenePageBuilder2;
        n[] nVarArr;
        int collectionSizeOrDefault;
        Object obj3 = obj;
        if (continuation instanceof ScenePageBuilder$onCreatePage$1) {
            scenePageBuilder$onCreatePage$1 = (ScenePageBuilder$onCreatePage$1) continuation;
            int i16 = scenePageBuilder$onCreatePage$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                scenePageBuilder$onCreatePage$1.label = i16 - Integer.MIN_VALUE;
                Object obj4 = scenePageBuilder$onCreatePage$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = scenePageBuilder$onCreatePage$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            oVar = (o) scenePageBuilder$onCreatePage$1.L$2;
                            obj2 = scenePageBuilder$onCreatePage$1.L$1;
                            scenePageBuilder2 = (ScenePageBuilder) scenePageBuilder$onCreatePage$1.L$0;
                            ResultKt.throwOnFailure(obj4);
                            Integer num = (Integer) obj4;
                            Panel.Companion companion = Panel.INSTANCE;
                            n[] nVarArr2 = oVar.f413134a;
                            Intrinsics.checkNotNullExpressionValue(nVarArr2, "staticConfigs.cfgs");
                            ku4.e eVar = (ku4.e) obj2;
                            o oVar2 = eVar.f413100b;
                            nVarArr = oVar2 == null ? oVar2.f413134a : null;
                            if (nVarArr == null) {
                                nVarArr = new n[0];
                            }
                            int i17 = eVar.f413101c;
                            int[] iArr = eVar.f413102d;
                            Intrinsics.checkNotNullExpressionValue(iArr, "data.sortIds");
                            List<n> o16 = companion.o(nVarArr2, nVarArr, i17, iArr, new Function1<n, Integer>() { // from class: com.tencent.mobileqq.zplan.aio.panel.page.ScenePageBuilder$onCreatePage$2
                                @Override // kotlin.jvm.functions.Function1
                                public final Integer invoke(n nVar) {
                                    return Integer.valueOf(nVar.f413120a);
                                }
                            });
                            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(o16, 10);
                            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                            for (n it : o16) {
                                CoroutineScope scope = scenePageBuilder2.getScope();
                                String str2 = it.f413121b;
                                Intrinsics.checkNotNullExpressionValue(str2, "it.name");
                                Intrinsics.checkNotNullExpressionValue(it, "it");
                                Context context = scenePageBuilder2.context;
                                String str3 = it.f413122c;
                                Intrinsics.checkNotNullExpressionValue(str3, "it.mainIconUrl");
                                String str4 = it.f413123d;
                                Intrinsics.checkNotNullExpressionValue(str4, "it.cornerIconUrl");
                                NormalItem normalItem = new NormalItem(scope, str2, it, context, str3, str4, false, it.f413133n, it.f413132m, it.f413120a);
                                normalItem.s(num != null && normalItem.getResourceConfig().f413120a == num.intValue());
                                arrayList.add(normalItem);
                            }
                            ScenePage scenePage = new ScenePage(arrayList, scenePageBuilder2.friendUin, scenePageBuilder2.getSelectingSceneId);
                            final WeakReference weakReference = new WeakReference(scenePage);
                            List<com.tencent.mobileqq.zplan.aio.panel.item.b> c16 = scenePage.c();
                            ArrayList<NormalItem> arrayList2 = new ArrayList();
                            for (com.tencent.mobileqq.zplan.aio.panel.item.b bVar : c16) {
                                NormalItem normalItem2 = bVar instanceof NormalItem ? (NormalItem) bVar : null;
                                if (normalItem2 != null) {
                                    arrayList2.add(normalItem2);
                                }
                            }
                            for (NormalItem normalItem3 : arrayList2) {
                                final String str5 = normalItem3.getResourceConfig().f413121b;
                                final int i18 = normalItem3.getResourceConfig().f413120a;
                                normalItem3.z(new Function2<CoroutineScope, le3.b, Deferred<? extends Boolean>>() { // from class: com.tencent.mobileqq.zplan.aio.panel.page.ScenePageBuilder$onCreatePage$4$2
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Deferred<Boolean> invoke(CoroutineScope scope2, le3.b config) {
                                        Map mapOf;
                                        Function2 function2;
                                        Intrinsics.checkNotNullParameter(scope2, "scope");
                                        Intrinsics.checkNotNullParameter(config, "config");
                                        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY), TuplesKt.to("zplan_action_type", "click"), TuplesKt.to("zplan_is_dress_up_user", f.a()), TuplesKt.to("zplan_emote_scene_type", ScenePageBuilder.this.getPageTheme().getReportSceneType()), TuplesKt.to("zplan_emote_name", str5), TuplesKt.to("zplan_emote_id", Integer.valueOf(i18)));
                                        VideoReport.reportEvent("ev_zplan_scene_click", mapOf);
                                        function2 = ScenePageBuilder.this.onSelect;
                                        return (Deferred) function2.invoke(scope2, config);
                                    }
                                });
                                normalItem3.y(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aio.panel.page.ScenePageBuilder$onCreatePage$4$3

                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
                                    @DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.panel.page.ScenePageBuilder$onCreatePage$4$3$1", f = "ScenePage.kt", i = {}, l = {181}, m = "invokeSuspend", n = {}, s = {})
                                    /* renamed from: com.tencent.mobileqq.zplan.aio.panel.page.ScenePageBuilder$onCreatePage$4$3$1, reason: invalid class name */
                                    /* loaded from: classes35.dex */
                                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        final /* synthetic */ WeakReference<ScenePage> $pageRef;
                                        int label;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        AnonymousClass1(WeakReference<ScenePage> weakReference, Continuation<? super AnonymousClass1> continuation) {
                                            super(2, continuation);
                                            this.$pageRef = weakReference;
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            return new AnonymousClass1(this.$pageRef, continuation);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Object invokeSuspend(Object obj) {
                                            Object coroutine_suspended;
                                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            int i3 = this.label;
                                            if (i3 == 0) {
                                                ResultKt.throwOnFailure(obj);
                                                ScenePage scenePage = this.$pageRef.get();
                                                if (scenePage != null) {
                                                    this.label = 1;
                                                    if (scenePage.A(this) == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                }
                                            } else if (i3 == 1) {
                                                ResultKt.throwOnFailure(obj);
                                            } else {
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                            return Unit.INSTANCE;
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                        }
                                    }

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
                                        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY), TuplesKt.to("zplan_action_type", "imp"), TuplesKt.to("zplan_is_dress_up_user", f.a()), TuplesKt.to("zplan_emote_scene_type", ScenePageBuilder.this.getPageTheme().getReportSceneType()), TuplesKt.to("zplan_emote_name", str5), TuplesKt.to("zplan_emote_id", Integer.valueOf(i18)));
                                        VideoReport.reportEvent("ev_zplan_scene_click", mapOf);
                                        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
                                        if (f16 != null) {
                                            CorountineFunKt.e(f16, "zplan_ScenePage_updateSelect", null, null, null, new AnonymousClass1(weakReference, null), 14, null);
                                        }
                                    }
                                });
                            }
                            return scenePage;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    obj3 = scenePageBuilder$onCreatePage$1.L$1;
                    scenePageBuilder = (ScenePageBuilder) scenePageBuilder$onCreatePage$1.L$0;
                    ResultKt.throwOnFailure(obj4);
                } else {
                    ResultKt.throwOnFailure(obj4);
                    Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type com.tencent.trpcprotocol.zplan.aio_avatar.nano.AllSceneConfig");
                    com.tencent.mobileqq.zplan.utils.o h16 = SknNetworkUtilKt.h(SknNetworkUtilKt.a(com.tencent.mobileqq.zplan.utils.e.f335814a), 0L, 0, 3, null);
                    Panel.Companion companion2 = Panel.INSTANCE;
                    Context context2 = this.context;
                    String str6 = ((ku4.e) obj3).f413099a;
                    Intrinsics.checkNotNullExpressionValue(str6, "data.staticCfgUrl");
                    com.tencent.mobileqq.zplan.utils.f d16 = companion2.d(context2, str6);
                    scenePageBuilder$onCreatePage$1.L$0 = this;
                    scenePageBuilder$onCreatePage$1.L$1 = obj3;
                    scenePageBuilder$onCreatePage$1.label = 1;
                    obj4 = h16.a(d16, scenePageBuilder$onCreatePage$1);
                    if (obj4 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    scenePageBuilder = this;
                }
                Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.utils.DownloadRsp.Success");
                readBytes = FilesKt__FileReadWriteKt.readBytes(((g.c) obj4).getFile());
                o oVar3 = (o) SknNetworkUtilKt.c(readBytes, new o());
                Function1<Continuation<? super Integer>, Object> function1 = scenePageBuilder.getSelectingSceneId;
                scenePageBuilder$onCreatePage$1.L$0 = scenePageBuilder;
                scenePageBuilder$onCreatePage$1.L$1 = obj3;
                scenePageBuilder$onCreatePage$1.L$2 = oVar3;
                scenePageBuilder$onCreatePage$1.label = 2;
                invoke = function1.invoke(scenePageBuilder$onCreatePage$1);
                if (invoke != coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj2 = obj3;
                oVar = oVar3;
                obj4 = invoke;
                scenePageBuilder2 = scenePageBuilder;
                Integer num2 = (Integer) obj4;
                Panel.Companion companion3 = Panel.INSTANCE;
                n[] nVarArr22 = oVar.f413134a;
                Intrinsics.checkNotNullExpressionValue(nVarArr22, "staticConfigs.cfgs");
                ku4.e eVar2 = (ku4.e) obj2;
                o oVar22 = eVar2.f413100b;
                if (oVar22 == null) {
                }
                if (nVarArr == null) {
                }
                int i172 = eVar2.f413101c;
                int[] iArr2 = eVar2.f413102d;
                Intrinsics.checkNotNullExpressionValue(iArr2, "data.sortIds");
                List<n> o162 = companion3.o(nVarArr22, nVarArr, i172, iArr2, new Function1<n, Integer>() { // from class: com.tencent.mobileqq.zplan.aio.panel.page.ScenePageBuilder$onCreatePage$2
                    @Override // kotlin.jvm.functions.Function1
                    public final Integer invoke(n nVar) {
                        return Integer.valueOf(nVar.f413120a);
                    }
                });
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(o162, 10);
                ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
                while (r1.hasNext()) {
                }
                ScenePage scenePage2 = new ScenePage(arrayList3, scenePageBuilder2.friendUin, scenePageBuilder2.getSelectingSceneId);
                final WeakReference<ScenePage> weakReference2 = new WeakReference(scenePage2);
                List<com.tencent.mobileqq.zplan.aio.panel.item.b> c162 = scenePage2.c();
                ArrayList<NormalItem> arrayList22 = new ArrayList();
                while (r2.hasNext()) {
                }
                while (r2.hasNext()) {
                }
                return scenePage2;
            }
        }
        scenePageBuilder$onCreatePage$1 = new ScenePageBuilder$onCreatePage$1(this, continuation);
        Object obj42 = scenePageBuilder$onCreatePage$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = scenePageBuilder$onCreatePage$1.label;
        if (i3 == 0) {
        }
        Intrinsics.checkNotNull(obj42, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.utils.DownloadRsp.Success");
        readBytes = FilesKt__FileReadWriteKt.readBytes(((g.c) obj42).getFile());
        o oVar32 = (o) SknNetworkUtilKt.c(readBytes, new o());
        Function1<Continuation<? super Integer>, Object> function12 = scenePageBuilder.getSelectingSceneId;
        scenePageBuilder$onCreatePage$1.L$0 = scenePageBuilder;
        scenePageBuilder$onCreatePage$1.L$1 = obj3;
        scenePageBuilder$onCreatePage$1.L$2 = oVar32;
        scenePageBuilder$onCreatePage$1.label = 2;
        invoke = function12.invoke(scenePageBuilder$onCreatePage$1);
        if (invoke != coroutine_suspended) {
        }
    }
}
