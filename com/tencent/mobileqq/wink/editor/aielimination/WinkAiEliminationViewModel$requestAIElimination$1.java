package com.tencent.mobileqq.wink.editor.aielimination;

import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.wink.utils.al;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.ShadowAIGCGenerate$GenerateReply;
import y53.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.aielimination.WinkAiEliminationViewModel$requestAIElimination$1", f = "WinkAiEliminationViewModel.kt", i = {1}, l = {394, 396}, m = "invokeSuspend", n = {"imageUrl"}, s = {"L$0"})
/* loaded from: classes21.dex */
public final class WinkAiEliminationViewModel$requestAIElimination$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function4<String, Long, com.tencent.mobileqq.wink.editor.aielimination.model.b, String, Unit> $callback;
    final /* synthetic */ com.tencent.mobileqq.wink.editor.aielimination.model.b $item;
    final /* synthetic */ String $maskPath;
    final /* synthetic */ String $requestId;
    Object L$0;
    int label;
    final /* synthetic */ WinkAiEliminationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WinkAiEliminationViewModel$requestAIElimination$1(WinkAiEliminationViewModel winkAiEliminationViewModel, com.tencent.mobileqq.wink.editor.aielimination.model.b bVar, String str, String str2, Function4<? super String, ? super Long, ? super com.tencent.mobileqq.wink.editor.aielimination.model.b, ? super String, Unit> function4, Continuation<? super WinkAiEliminationViewModel$requestAIElimination$1> continuation) {
        super(2, continuation);
        this.this$0 = winkAiEliminationViewModel;
        this.$item = bVar;
        this.$maskPath = str;
        this.$requestId = str2;
        this.$callback = function4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkAiEliminationViewModel$requestAIElimination$1(this.this$0, this.$item, this.$maskPath, this.$requestId, this.$callback, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0085  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        boolean z16;
        String dstMediaUrl;
        String dstMediaUrl2;
        Object b16;
        boolean z17;
        String str;
        String str2;
        String str3;
        Object b17;
        String n26;
        String str4;
        String str5;
        String n27;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    String str6 = (String) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    str = str6;
                    b17 = obj;
                    str3 = (String) b17;
                    String str7 = str3;
                    String str8 = str;
                    this.this$0.j3(str8);
                    ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestoneEnd(IPrefRecorder.MILESTONE_AI_ELIMINATE_UPLOAD_IMG);
                    n26 = this.this$0.n2();
                    String str9 = this.$requestId;
                    str4 = this.this$0.mOriginImageUrl;
                    w53.b.f("WinkAiEliminationViewModel", "requestAIElimination " + n26 + " requestId: " + str9 + ", imageUrl : " + str8 + ", maskUrl: " + str7 + ", mOriginImageUrl: " + str4);
                    ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestone(IPrefRecorder.MILESTONE_AI_ELIMINATE_BACKEND_REQUEST);
                    AIEliminateDataSource aIEliminateDataSource = AIEliminateDataSource.f318757a;
                    str5 = this.this$0.mOriginImageUrl;
                    a aVar = new a(this.this$0, this.$requestId, this.$callback, this.$item, this.$maskPath, str8);
                    String b26 = this.this$0.b2();
                    n27 = this.this$0.n2();
                    aIEliminateDataSource.e(str8, str7, str5, aVar, b26, n27);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            b16 = obj;
        } else {
            ResultKt.throwOnFailure(obj);
            ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestone(IPrefRecorder.MILESTONE_AI_ELIMINATE_UPLOAD_IMG);
            WinkAiEliminationViewModel winkAiEliminationViewModel = this.this$0;
            String dstMediaUrl3 = this.$item.getDstMediaUrl();
            boolean z18 = false;
            if (dstMediaUrl3 != null) {
                if (dstMediaUrl3.length() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    z16 = true;
                    winkAiEliminationViewModel.isHotStart = z16;
                    dstMediaUrl = this.$item.getDstMediaUrl();
                    if (dstMediaUrl != null || dstMediaUrl.length() == 0) {
                        z18 = true;
                    }
                    if (!z18) {
                        al alVar = al.f326675a;
                        String dstMediaPath = this.$item.getDstMediaPath();
                        this.label = 1;
                        b16 = al.b(alVar, dstMediaPath, false, this, 2, null);
                        if (b16 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        dstMediaUrl2 = this.$item.getDstMediaUrl();
                        Intrinsics.checkNotNull(dstMediaUrl2);
                        str = dstMediaUrl2;
                        this.$item.e(str);
                        str2 = this.$maskPath;
                        if (str2 == null) {
                            al alVar2 = al.f326675a;
                            this.L$0 = str;
                            this.label = 2;
                            b17 = al.b(alVar2, str2, false, this, 2, null);
                            if (b17 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            str3 = (String) b17;
                            String str72 = str3;
                            String str82 = str;
                            this.this$0.j3(str82);
                            ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestoneEnd(IPrefRecorder.MILESTONE_AI_ELIMINATE_UPLOAD_IMG);
                            n26 = this.this$0.n2();
                            String str92 = this.$requestId;
                            str4 = this.this$0.mOriginImageUrl;
                            w53.b.f("WinkAiEliminationViewModel", "requestAIElimination " + n26 + " requestId: " + str92 + ", imageUrl : " + str82 + ", maskUrl: " + str72 + ", mOriginImageUrl: " + str4);
                            ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestone(IPrefRecorder.MILESTONE_AI_ELIMINATE_BACKEND_REQUEST);
                            AIEliminateDataSource aIEliminateDataSource2 = AIEliminateDataSource.f318757a;
                            str5 = this.this$0.mOriginImageUrl;
                            a aVar2 = new a(this.this$0, this.$requestId, this.$callback, this.$item, this.$maskPath, str82);
                            String b262 = this.this$0.b2();
                            n27 = this.this$0.n2();
                            aIEliminateDataSource2.e(str82, str72, str5, aVar2, b262, n27);
                            return Unit.INSTANCE;
                        }
                        str3 = null;
                        String str722 = str3;
                        String str822 = str;
                        this.this$0.j3(str822);
                        ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestoneEnd(IPrefRecorder.MILESTONE_AI_ELIMINATE_UPLOAD_IMG);
                        n26 = this.this$0.n2();
                        String str922 = this.$requestId;
                        str4 = this.this$0.mOriginImageUrl;
                        w53.b.f("WinkAiEliminationViewModel", "requestAIElimination " + n26 + " requestId: " + str922 + ", imageUrl : " + str822 + ", maskUrl: " + str722 + ", mOriginImageUrl: " + str4);
                        ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestone(IPrefRecorder.MILESTONE_AI_ELIMINATE_BACKEND_REQUEST);
                        AIEliminateDataSource aIEliminateDataSource22 = AIEliminateDataSource.f318757a;
                        str5 = this.this$0.mOriginImageUrl;
                        a aVar22 = new a(this.this$0, this.$requestId, this.$callback, this.$item, this.$maskPath, str822);
                        String b2622 = this.this$0.b2();
                        n27 = this.this$0.n2();
                        aIEliminateDataSource22.e(str822, str722, str5, aVar22, b2622, n27);
                        return Unit.INSTANCE;
                    }
                }
            }
            z16 = false;
            winkAiEliminationViewModel.isHotStart = z16;
            dstMediaUrl = this.$item.getDstMediaUrl();
            if (dstMediaUrl != null) {
            }
            z18 = true;
            if (!z18) {
            }
        }
        dstMediaUrl2 = (String) b16;
        str = dstMediaUrl2;
        this.$item.e(str);
        str2 = this.$maskPath;
        if (str2 == null) {
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkAiEliminationViewModel$requestAIElimination$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J6\u0010\r\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/wink/editor/aielimination/WinkAiEliminationViewModel$requestAIElimination$1$a", "Lcom/tencent/biz/richframework/network/observer/VSDispatchObserver$OnVSRspCallBack;", "Lqshadow/ShadowAIGCGenerate$GenerateReply;", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", Const.BUNDLE_KEY_REQUEST, "", "isSuccess", "", "retCode", "", "errMsg", "pbResponse", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements VSDispatchObserver.OnVSRspCallBack<ShadowAIGCGenerate$GenerateReply> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WinkAiEliminationViewModel f318792a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f318793b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function4<String, Long, com.tencent.mobileqq.wink.editor.aielimination.model.b, String, Unit> f318794c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.wink.editor.aielimination.model.b f318795d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f318796e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f318797f;

        /* JADX WARN: Multi-variable type inference failed */
        a(WinkAiEliminationViewModel winkAiEliminationViewModel, String str, Function4<? super String, ? super Long, ? super com.tencent.mobileqq.wink.editor.aielimination.model.b, ? super String, Unit> function4, com.tencent.mobileqq.wink.editor.aielimination.model.b bVar, String str2, String str3) {
            this.f318792a = winkAiEliminationViewModel;
            this.f318793b = str;
            this.f318794c = function4;
            this.f318795d = bVar;
            this.f318796e = str2;
            this.f318797f = str3;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(@Nullable BaseRequest request, boolean isSuccess, long retCode, @Nullable String errMsg, @Nullable ShadowAIGCGenerate$GenerateReply pbResponse) {
            String n26;
            n26 = this.f318792a.n2();
            w53.b.f("WinkAiEliminationViewModel", "requestAIElimination " + n26 + " isSuccess : " + isSuccess + ", retCode: " + retCode + ", errMsg:" + errMsg + ", requestId: " + this.f318793b + ", currentRequestId: " + this.f318792a.getCurrentRequestId());
            ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestoneEnd(IPrefRecorder.MILESTONE_AI_ELIMINATE_BACKEND_REQUEST);
            Long valueOf = Long.valueOf(TroopMemberInfo.VALUE_MEMBER_CLOSE_SHARE_LBS);
            if (isSuccess && retCode == 0 && pbResponse != null) {
                AIEliminateDataSource aIEliminateDataSource = AIEliminateDataSource.f318757a;
                String str = pbResponse.extra.get();
                Intrinsics.checkNotNullExpressionValue(str, "pbResponse.extra.get()");
                Map<String, String> d16 = aIEliminateDataSource.d(str);
                String str2 = d16.get("image_url");
                if (str2 == null) {
                    this.f318794c.invoke(this.f318793b, valueOf, null, "get result image url fail");
                    return;
                }
                ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestone(IPrefRecorder.MILESTONE_AI_ELIMINATE_DOWNLOAD_IMG);
                String v26 = this.f318792a.v2();
                y53.a.c().a(str2, v26, new C9015a(this.f318794c, this.f318793b, str2, d16, this.f318795d, this.f318796e, v26, this.f318797f));
                return;
            }
            if (isSuccess) {
                this.f318794c.invoke(this.f318793b, Long.valueOf(retCode), null, errMsg);
            } else {
                this.f318794c.invoke(this.f318793b, valueOf, null, errMsg);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/editor/aielimination/WinkAiEliminationViewModel$requestAIElimination$1$a$a", "Ly53/a$a;", "Lcom/tencent/mobileqq/transfile/NetResp;", "resp", "", "a", "", "progress", "onProgressUpdate", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.wink.editor.aielimination.WinkAiEliminationViewModel$requestAIElimination$1$a$a, reason: collision with other inner class name */
        /* loaded from: classes21.dex */
        public static final class C9015a implements a.InterfaceC11592a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Function4<String, Long, com.tencent.mobileqq.wink.editor.aielimination.model.b, String, Unit> f318798a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f318799b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f318800c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Map<String, String> f318801d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.wink.editor.aielimination.model.b f318802e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f318803f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ String f318804g;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f318805h;

            /* JADX WARN: Multi-variable type inference failed */
            C9015a(Function4<? super String, ? super Long, ? super com.tencent.mobileqq.wink.editor.aielimination.model.b, ? super String, Unit> function4, String str, String str2, Map<String, String> map, com.tencent.mobileqq.wink.editor.aielimination.model.b bVar, String str3, String str4, String str5) {
                this.f318798a = function4;
                this.f318799b = str;
                this.f318800c = str2;
                this.f318801d = map;
                this.f318802e = bVar;
                this.f318803f = str3;
                this.f318804g = str4;
                this.f318805h = str5;
            }

            @Override // y53.a.InterfaceC11592a
            public void a(@Nullable NetResp resp) {
                boolean startsWith$default;
                if (resp == null) {
                    w53.b.c("WinkAiEliminationViewModel", "download onResp: error resp is null");
                    this.f318798a.invoke(this.f318799b, -1003L, null, "download fail");
                    return;
                }
                w53.b.a("WinkAiEliminationViewModel", "download onResp: " + resp.mResult + ", " + this.f318800c + ", response: " + this.f318801d);
                ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestoneEnd(IPrefRecorder.MILESTONE_AI_ELIMINATE_DOWNLOAD_IMG);
                if (resp.mResult == 0) {
                    Function4<String, Long, com.tencent.mobileqq.wink.editor.aielimination.model.b, String, Unit> function4 = this.f318798a;
                    String str = this.f318799b;
                    com.tencent.mobileqq.wink.editor.aielimination.model.b bVar = new com.tencent.mobileqq.wink.editor.aielimination.model.b(this.f318802e.getDstMediaPath(), this.f318803f, this.f318804g);
                    String str2 = this.f318805h;
                    Map<String, String> map = this.f318801d;
                    String str3 = this.f318800c;
                    bVar.f(str2);
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(entry.getKey(), "SHARE_PREFIX_", false, 2, null);
                        if (startsWith$default) {
                            linkedHashMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                    bVar.g(linkedHashMap);
                    bVar.e(str3);
                    Unit unit = Unit.INSTANCE;
                    function4.invoke(str, 0L, bVar, null);
                    return;
                }
                this.f318798a.invoke(this.f318799b, -1003L, null, "download fail");
            }

            @Override // y53.a.InterfaceC11592a
            public void onProgressUpdate(int progress) {
            }
        }
    }
}
