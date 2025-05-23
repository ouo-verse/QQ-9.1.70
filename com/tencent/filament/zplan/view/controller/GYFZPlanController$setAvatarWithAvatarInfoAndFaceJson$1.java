package com.tencent.filament.zplan.view.controller;

import android.text.TextUtils;
import com.tencent.filament.zplan.listener.LoadAvatarCallback;
import com.tencent.filament.zplan.view.controller.GYFZPlanController;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes6.dex */
final class GYFZPlanController$setAvatarWithAvatarInfoAndFaceJson$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $avatarInfo;
    final /* synthetic */ String $faceJson;
    final /* synthetic */ int $requestId;
    final /* synthetic */ String $uin;
    final /* synthetic */ GYFZPlanController this$0;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\t"}, d2 = {"com/tencent/filament/zplan/view/controller/GYFZPlanController$setAvatarWithAvatarInfoAndFaceJson$1$1", "Lcom/tencent/filament/zplan/listener/LoadAvatarCallback;", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "getTaskId", "()I", "onResourcePrepare", "", "result", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.filament.zplan.view.controller.GYFZPlanController$setAvatarWithAvatarInfoAndFaceJson$1$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 implements LoadAvatarCallback {
        AnonymousClass1() {
        }

        @Override // com.tencent.filament.zplan.listener.LoadAvatarCallback
        public int getTaskId() {
            return GYFZPlanController$setAvatarWithAvatarInfoAndFaceJson$1.this.$requestId;
        }

        @Override // com.tencent.filament.zplan.listener.LoadAvatarCallback
        public void onResourcePrepare(final int result) {
            GYFZPlanController$setAvatarWithAvatarInfoAndFaceJson$1.this.this$0.a0("onResourcePrepare", new Function0<Unit>() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$setAvatarWithAvatarInfoAndFaceJson$1$1$onResourcePrepare$1
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

                /* JADX WARN: Removed duplicated region for block: B:18:0x008b  */
                /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke2() {
                    int i3;
                    int v06;
                    i3 = GYFZPlanController$setAvatarWithAvatarInfoAndFaceJson$1.this.this$0.fJCurrentRequestIdByAInfo;
                    GYFZPlanController$setAvatarWithAvatarInfoAndFaceJson$1 gYFZPlanController$setAvatarWithAvatarInfoAndFaceJson$1 = GYFZPlanController$setAvatarWithAvatarInfoAndFaceJson$1.this;
                    if (i3 != gYFZPlanController$setAvatarWithAvatarInfoAndFaceJson$1.$requestId && gYFZPlanController$setAvatarWithAvatarInfoAndFaceJson$1.this$0.getIsReentrant()) {
                        GYFZPlanController$setAvatarWithAvatarInfoAndFaceJson$1.this.this$0.L().post(new Runnable() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$setAvatarWithAvatarInfoAndFaceJson$1$1$onResourcePrepare$1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                GYFZPlanController.c loadAvatarListener = GYFZPlanController$setAvatarWithAvatarInfoAndFaceJson$1.this.this$0.getLoadAvatarListener();
                                if (loadAvatarListener != null) {
                                    loadAvatarListener.a(-200, GYFZPlanController$setAvatarWithAvatarInfoAndFaceJson$1.this.$requestId);
                                }
                            }
                        });
                        return;
                    }
                    final Ref.IntRef intRef = new Ref.IntRef();
                    int i16 = result;
                    intRef.element = i16;
                    boolean z16 = false;
                    if (i16 != 0) {
                        v06 = GYFZPlanController$setAvatarWithAvatarInfoAndFaceJson$1.this.this$0.v0(i16);
                        intRef.element = v06;
                        if (!TextUtils.isEmpty(GYFZPlanController$setAvatarWithAvatarInfoAndFaceJson$1.this.$uin)) {
                            GYFZPlanController$setAvatarWithAvatarInfoAndFaceJson$1 gYFZPlanController$setAvatarWithAvatarInfoAndFaceJson$12 = GYFZPlanController$setAvatarWithAvatarInfoAndFaceJson$1.this;
                            gYFZPlanController$setAvatarWithAvatarInfoAndFaceJson$12.this$0.k0(gYFZPlanController$setAvatarWithAvatarInfoAndFaceJson$12.$uin, gYFZPlanController$setAvatarWithAvatarInfoAndFaceJson$12.$faceJson, gYFZPlanController$setAvatarWithAvatarInfoAndFaceJson$12.$requestId, result);
                            if (z16) {
                                return;
                            }
                            GYFZPlanController$setAvatarWithAvatarInfoAndFaceJson$1.this.this$0.L().post(new Runnable() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$setAvatarWithAvatarInfoAndFaceJson$1$1$onResourcePrepare$1.2
                                @Override // java.lang.Runnable
                                public final void run() {
                                    GYFZPlanController.c loadAvatarListener = GYFZPlanController$setAvatarWithAvatarInfoAndFaceJson$1.this.this$0.getLoadAvatarListener();
                                    if (loadAvatarListener != null) {
                                        loadAvatarListener.a(intRef.element, GYFZPlanController$setAvatarWithAvatarInfoAndFaceJson$1.this.$requestId);
                                    }
                                }
                            });
                            return;
                        }
                    } else {
                        GYFZPlanNativeAPI nativeAPI = GYFZPlanController$setAvatarWithAvatarInfoAndFaceJson$1.this.this$0.getNativeAPI();
                        if (nativeAPI != null) {
                            nativeAPI.applyAvatarInfo(GYFZPlanController$setAvatarWithAvatarInfoAndFaceJson$1.this.$requestId);
                        }
                        GYFZPlanNativeAPI nativeAPI2 = GYFZPlanController$setAvatarWithAvatarInfoAndFaceJson$1.this.this$0.getNativeAPI();
                        if (nativeAPI2 != null) {
                            nativeAPI2.renderWarmup(false);
                        }
                    }
                    z16 = true;
                    if (z16) {
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GYFZPlanController$setAvatarWithAvatarInfoAndFaceJson$1(GYFZPlanController gYFZPlanController, String str, String str2, int i3, String str3) {
        super(0);
        this.this$0 = gYFZPlanController;
        this.$avatarInfo = str;
        this.$faceJson = str2;
        this.$requestId = i3;
        this.$uin = str3;
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
            nativeAPI.setAvatarWithAvatarInfoAndFaceJson(this.$avatarInfo, this.$faceJson, this.$requestId, new AnonymousClass1());
        }
    }
}
