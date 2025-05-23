package com.tencent.mobileqq.zootopia.ueloading.prepare.preparer;

import com.tencent.guild.aio.util.PostUtilKt;
import com.tencent.mobileqq.activity.qcircle.utils.g;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zootopia.download.v;
import com.tencent.mobileqq.zootopia.ueloading.ZPlanUELoaderControllerV2;
import com.tencent.sqshow.zootopia.utils.ah;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vd3.PrepareResult;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J0\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J \u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R$\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0016j\b\u0012\u0004\u0012\u00020\u0002`\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ueloading/prepare/preparer/ParallelPreparer;", "Lvd3/a;", "Lvd3/b;", "preparer", "", "l", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "enterParams", "Lorg/json/JSONObject;", "enterJson", "Lvd3/f;", "result", "Lvd3/c;", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "e", "a", "Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderControllerV2;", "d", "Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderControllerV2;", "ueLoaderController", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "mPreparerList", "Ljava/util/concurrent/atomic/AtomicInteger;", "f", "Ljava/util/concurrent/atomic/AtomicInteger;", "mPrepareCountFlag", "Ljava/util/concurrent/atomic/AtomicBoolean;", "g", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mPrepareFailFlag", "<init>", "(Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderControllerV2;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ParallelPreparer extends vd3.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ZPlanUELoaderControllerV2 ueLoaderController;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<vd3.b> mPreparerList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final AtomicInteger mPrepareCountFlag;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean mPrepareFailFlag;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ParallelPreparer(ZPlanUELoaderControllerV2 ueLoaderController) {
        super(ueLoaderController);
        Intrinsics.checkNotNullParameter(ueLoaderController, "ueLoaderController");
        this.ueLoaderController = ueLoaderController;
        this.mPreparerList = new ArrayList<>();
        this.mPrepareCountFlag = new AtomicInteger(0);
        this.mPrepareFailFlag = new AtomicBoolean(false);
        l(new e(ueLoaderController));
        l(new AvatarCharacterPreparer(ueLoaderController));
        l(new vd3.d().b(new CheckPreparer(ueLoaderController)).b(new HotPatchPreparer(ueLoaderController)).b(new CommonBarPreparer(ueLoaderController)));
    }

    private final void l(vd3.b preparer) {
        this.mPreparerList.add(preparer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(ZootopiaEnterParams enterParams, JSONObject enterJson, vd3.b preparer, PrepareResult result, vd3.c callback) {
        if (!result.e()) {
            h("onSubPrepareComplete failed");
            if (this.mPrepareFailFlag.get()) {
                return;
            }
            callback.a(result);
            this.mPrepareFailFlag.set(true);
            return;
        }
        if (preparer instanceof AvatarCharacterPreparer) {
            h("onSubPrepareComplete complete AvatarCharacterPreparer");
            enterJson.put("MaleDefaultAvatarInfo", result.getEnterJson().opt("MaleDefaultAvatarInfo"));
            enterJson.put("FemaleDefaultAvatarInfo", result.getEnterJson().opt("MaleDefaultAvatarInfo"));
        } else if (preparer instanceof vd3.d) {
            h("onSubPrepareComplete complete PrepareBuilder");
            ZootopiaEnterParams enterParams2 = result.getEnterParams();
            enterParams.setVersion(enterParams2.getVersion());
            enterParams.setOpenId(enterParams2.getOpenId());
            enterParams.setAccessToken(enterParams2.getAccessToken());
            enterParams.setPakPath(enterParams2.getPakPath());
            enterParams.setIcon(enterParams2.getIcon());
            enterParams.setDownloaded(enterParams2.getIsDownloaded());
            enterParams.setLoadingId(enterParams2.getLoadingId());
            enterParams.setProjectName(enterParams2.getProjectName());
            enterParams.setScreenType(enterParams2.getScreenType());
            enterParams.setShowGameHealthyLoading(enterParams2.getShowGameHealthyLoading());
            enterParams.setUeParams(enterParams2.getUeParams());
            enterParams.setNeedMinorsHeartBeat(enterParams2.getNeedMinorsHeartBeat());
            enterParams.setLoadingParams(enterParams2.getLoadingParams());
            enterParams.setProgress(enterParams2.getProgress());
            enterParams.setSource(enterParams2.getSource());
            enterParams.setStartTime(enterParams2.getStartTime());
            enterParams.setCommonModCheckResult(enterParams2.getCommonModCheckResult());
            JSONObject jsonObject = enterParams2.toJsonObject();
            Iterator keys = jsonObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                enterJson.put(str, jsonObject.get(str));
            }
            enterJson.put(ZootopiaEnterParams.KEY_HOT_PATCH_FOLDER, result.getEnterJson().opt(ZootopiaEnterParams.KEY_HOT_PATCH_FOLDER));
            enterJson.put(ZootopiaEnterParams.KEY_HOT_PATCH_VERSION, result.getEnterJson().opt(ZootopiaEnterParams.KEY_HOT_PATCH_VERSION));
            enterJson.put("ComModuleCfgStr", result.getEnterJson().opt("ComModuleCfgStr"));
        }
        if (this.mPrepareCountFlag.incrementAndGet() == this.mPreparerList.size()) {
            h("onSubPrepareComplete success");
            enterJson.put("ComModPakPathPrefix", v.f328299a.c());
            enterJson.put("isSeparateLoading", !this.ueLoaderController.getUseV2Loading());
            ZootopiaSource source = this.ueLoaderController.getSource();
            enterJson.put("Source", source != null ? ah.b(source) : null);
            enterJson.put("LoadingId", this.ueLoaderController.getProgressRecord().getLoadingId());
            f(enterParams, enterJson, callback);
        }
    }

    @Override // vd3.a, vd3.b
    public void a(final ZootopiaEnterParams enterParams, final JSONObject enterJson, final vd3.c callback) {
        Intrinsics.checkNotNullParameter(enterParams, "enterParams");
        Intrinsics.checkNotNullParameter(enterJson, "enterJson");
        Intrinsics.checkNotNullParameter(callback, "callback");
        super.a(enterParams, enterJson, callback);
        g.e(new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.ueloading.prepare.preparer.ParallelPreparer$prepare$1
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
                ArrayList<vd3.b> arrayList;
                arrayList = ParallelPreparer.this.mPreparerList;
                final ZootopiaEnterParams zootopiaEnterParams = enterParams;
                final JSONObject jSONObject = enterJson;
                final ParallelPreparer parallelPreparer = ParallelPreparer.this;
                final vd3.c cVar = callback;
                for (final vd3.b bVar : arrayList) {
                    bVar.a(zootopiaEnterParams, jSONObject, new vd3.c() { // from class: com.tencent.mobileqq.zootopia.ueloading.prepare.preparer.ParallelPreparer$prepare$1$1$1
                        @Override // vd3.c
                        public void a(PrepareResult result) {
                            Intrinsics.checkNotNullParameter(result, "result");
                            ParallelPreparer parallelPreparer2 = ParallelPreparer.this;
                            ZootopiaEnterParams zootopiaEnterParams2 = zootopiaEnterParams;
                            JSONObject jSONObject2 = jSONObject;
                            vd3.b bVar2 = bVar;
                            final vd3.c cVar2 = cVar;
                            parallelPreparer2.m(zootopiaEnterParams2, jSONObject2, bVar2, result, new vd3.c() { // from class: com.tencent.mobileqq.zootopia.ueloading.prepare.preparer.ParallelPreparer$prepare$1$1$1$onPrepareComplete$1
                                @Override // vd3.c
                                public void a(final PrepareResult result2) {
                                    Intrinsics.checkNotNullParameter(result2, "result");
                                    final vd3.c cVar3 = vd3.c.this;
                                    PostUtilKt.b(new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.ueloading.prepare.preparer.ParallelPreparer$prepare$1$1$1$onPrepareComplete$1$onPrepareComplete$1
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
                                            vd3.c.this.a(result2);
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            }
        });
    }

    @Override // vd3.a
    public String e() {
        return "ParallelPreparerV2";
    }
}
