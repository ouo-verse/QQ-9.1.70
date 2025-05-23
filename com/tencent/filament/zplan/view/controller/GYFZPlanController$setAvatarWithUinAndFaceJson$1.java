package com.tencent.filament.zplan.view.controller;

import com.tencent.filament.zplan.listener.LoadAvatarCallback;
import com.tencent.filament.zplan.view.controller.GYFZPlanController;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class GYFZPlanController$setAvatarWithUinAndFaceJson$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $faceJson;
    final /* synthetic */ int $requestId;
    final /* synthetic */ int $resultCode;
    final /* synthetic */ String $uin;
    final /* synthetic */ GYFZPlanController this$0;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\t"}, d2 = {"com/tencent/filament/zplan/view/controller/GYFZPlanController$setAvatarWithUinAndFaceJson$1$1", "Lcom/tencent/filament/zplan/listener/LoadAvatarCallback;", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "getTaskId", "()I", "onResourcePrepare", "", "result", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.filament.zplan.view.controller.GYFZPlanController$setAvatarWithUinAndFaceJson$1$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 implements LoadAvatarCallback {
        AnonymousClass1() {
        }

        @Override // com.tencent.filament.zplan.listener.LoadAvatarCallback
        public int getTaskId() {
            return GYFZPlanController$setAvatarWithUinAndFaceJson$1.this.$requestId;
        }

        @Override // com.tencent.filament.zplan.listener.LoadAvatarCallback
        public void onResourcePrepare(final int result) {
            int i3;
            FLog.INSTANCE.d("GYFZPlanController", "onResourcePrepare: " + result + '}');
            i3 = GYFZPlanController$setAvatarWithUinAndFaceJson$1.this.this$0.faceJsonCurrentRequestId;
            GYFZPlanController$setAvatarWithUinAndFaceJson$1 gYFZPlanController$setAvatarWithUinAndFaceJson$1 = GYFZPlanController$setAvatarWithUinAndFaceJson$1.this;
            if (i3 != gYFZPlanController$setAvatarWithUinAndFaceJson$1.$requestId && gYFZPlanController$setAvatarWithUinAndFaceJson$1.this$0.getIsReentrant()) {
                GYFZPlanController$setAvatarWithUinAndFaceJson$1.this.this$0.L().post(new Runnable() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$setAvatarWithUinAndFaceJson$1$1$onResourcePrepare$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        GYFZPlanController.c loadAvatarListener = GYFZPlanController$setAvatarWithUinAndFaceJson$1.this.this$0.getLoadAvatarListener();
                        if (loadAvatarListener != null) {
                            loadAvatarListener.a(-200, GYFZPlanController$setAvatarWithUinAndFaceJson$1.this.$requestId);
                        }
                    }
                });
            } else {
                GYFZPlanController$setAvatarWithUinAndFaceJson$1.this.this$0.a0("setAvatarWithAvatarInfo", new Function0<Unit>() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$setAvatarWithUinAndFaceJson$1$1$onResourcePrepare$2
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
                        int v06;
                        final Ref.IntRef intRef = new Ref.IntRef();
                        int i16 = result;
                        intRef.element = i16;
                        if (i16 != 0) {
                            v06 = GYFZPlanController$setAvatarWithUinAndFaceJson$1.this.this$0.v0(i16);
                            intRef.element = v06;
                        } else {
                            GYFZPlanNativeAPI nativeAPI = GYFZPlanController$setAvatarWithUinAndFaceJson$1.this.this$0.getNativeAPI();
                            if (nativeAPI != null) {
                                nativeAPI.applyAvatarInfo(GYFZPlanController$setAvatarWithUinAndFaceJson$1.this.$requestId);
                            }
                            GYFZPlanNativeAPI nativeAPI2 = GYFZPlanController$setAvatarWithUinAndFaceJson$1.this.this$0.getNativeAPI();
                            if (nativeAPI2 != null) {
                                nativeAPI2.renderWarmup(false);
                            }
                        }
                        GYFZPlanController$setAvatarWithUinAndFaceJson$1.this.this$0.L().post(new Runnable() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$setAvatarWithUinAndFaceJson$1$1$onResourcePrepare$2.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                GYFZPlanController$setAvatarWithUinAndFaceJson$1 gYFZPlanController$setAvatarWithUinAndFaceJson$12 = GYFZPlanController$setAvatarWithUinAndFaceJson$1.this;
                                int i17 = gYFZPlanController$setAvatarWithUinAndFaceJson$12.$resultCode;
                                if (i17 == 169) {
                                    i17 = intRef.element;
                                }
                                GYFZPlanController.c loadAvatarListener = gYFZPlanController$setAvatarWithUinAndFaceJson$12.this$0.getLoadAvatarListener();
                                if (loadAvatarListener != null) {
                                    loadAvatarListener.a(i17, GYFZPlanController$setAvatarWithUinAndFaceJson$1.this.$requestId);
                                }
                            }
                        });
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GYFZPlanController$setAvatarWithUinAndFaceJson$1(GYFZPlanController gYFZPlanController, String str, String str2, int i3, int i16) {
        super(0);
        this.this$0 = gYFZPlanController;
        this.$uin = str;
        this.$faceJson = str2;
        this.$requestId = i3;
        this.$resultCode = i16;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        GYFZPlanNativeAPI nativeAPI = this.this$0.getNativeAPI();
        if (nativeAPI != null) {
            nativeAPI.setAvatarWithUinAndFaceJson(this.$uin, this.$faceJson, this.$requestId, new AnonymousClass1());
        }
    }
}
